package com.java;

import io.searchbox.client.JestResultHandler;
import lombok.Data;

/**
 * Author: Boris
 * Date: 2018/11/23 19:23
 * Description:
 */
@Data
public class ResultHandler<T> implements JestResultHandler<T> {

    private T searchResult;

    private Exception exception;
    @Override
    public void completed(T result) {
        searchResult = result;
    }

    @Override
    public void failed(Exception ex) {
        exception = ex;
    }

    T getResult() throws Exception{
        if (exception != null) {
            throw exception;
        }
        return searchResult;
    }
}
