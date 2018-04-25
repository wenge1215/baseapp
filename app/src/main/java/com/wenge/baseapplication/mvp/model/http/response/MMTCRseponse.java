package com.wenge.baseapplication.mvp.model.http.response;

/**
 * Created by 20180419 on 2018/4/20.
 */

public class MMTCRseponse<T> {

    /**
     * info : [{"mini_link":"https://app.mmtcapp.com/home/index/rjfx","link":"https://app.mmtcapp.com/home/index/rjfx","cover":"/static/upload/image/20180120/20180120144110_43506.jpg","title":"晒日记赢返现"},{"mini_link":"https://app.mmtcapp.com/home/index/mmdr","link":"https://app.mmtcapp.com/home/index/mmdr","cover":"/static/upload/image/20180120/20180120141201_37369.png","title":"粉丝征集令"},{"mini_link":"/pages/other/discount?id=2","link":"discount/albumDetail.html?id=2","cover":"/static/upload/image/20180313/20180313171039_51918.jpg","title":"特惠专题"}]
     * status : 1
     */

    private int status;
    private T info;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

}
