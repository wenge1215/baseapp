package com.wenge.baseapplication.utils;


import com.wenge.baseapplication.mvp.model.http.response.MMTCRseponse;
import com.wenge.baseapplication.mvp.model.http.response.MyHttpResponse;
import com.wenge.baseapplication.mvp.model.http.exception.ApiException;

import org.reactivestreams.Publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by codeest on 2016/8/3.
 */
public class RxUtil {

    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new FlowableTransformer<T, T>() {
            @Override
            public Flowable<T> apply(Flowable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
//                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


    /**
     * 生成Flowable
     *
     * @param <T>
     * @return
     */
    public static <T> Flowable<T> createData(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }

    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<MyHttpResponse<T>, T> handleMyResult() {   //compose判断结果
        return new FlowableTransformer<MyHttpResponse<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<MyHttpResponse<T>> httpResponseFlowable) {
                return httpResponseFlowable.flatMap(new Function<MyHttpResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(MyHttpResponse<T> tMyHttpResponse) {
                        if (tMyHttpResponse.getCode() == 200) {
                            return createData(tMyHttpResponse.getData());
                        } else {
                            return Flowable.error(new ApiException(tMyHttpResponse.getMessage(), tMyHttpResponse.getCode()));
                        }
                    }
                });
            }
        };
    }

    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<MMTCRseponse<T>, T> handleMMTCResult() {   //compose判断结果
        return new FlowableTransformer<MMTCRseponse<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<MMTCRseponse<T>> httpResponseFlowable) {
                return httpResponseFlowable.flatMap(new Function<MMTCRseponse<T>, Publisher<? extends T>>() {
                    @Override
                    public Flowable<T> apply(MMTCRseponse<T> tmmtcRseponse) throws Exception {
                        if (tmmtcRseponse.getStatus() == 1) {
                            return createData(tmmtcRseponse.getInfo());
                        } else {
                            return Flowable.error(new ApiException("服务器返回错误", tmmtcRseponse.getStatus()));
                        }
                    }
                });
            }
        };
    }


    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> handleKaiYanResult() {   //compose判断结果
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream.flatMap(new Function<T, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(T t) throws Exception {
                        if (t == null) {
                            return Flowable.error(new ApiException("服务器返回error"));
                        } else {
                            return createData(t);
                        }

                    }
                });
            }
        };
    }
}
