package com.wenge.baseapplication.mvp.model.http.response;

/**
 * Created by Administrator on 2018/4/18.
 */

public class KaiYanHttpRseponse<T> {
    private T results;

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
