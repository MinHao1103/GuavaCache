package com.cache.api.utils;

import java.text.DecimalFormat;

public class CommonHttpResult<T> {
    String result;
    T data;

    public CommonHttpResult() {
    }

    public CommonHttpResult(int result, T data) {
        DecimalFormat df = new DecimalFormat("0000");
        this.result = "S" + df.format((long) result);
        this.data = data;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setResult(int result) {
        DecimalFormat df = new DecimalFormat("0000");
        this.result = "S" + df.format((long) result);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
