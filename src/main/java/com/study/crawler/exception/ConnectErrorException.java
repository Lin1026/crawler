package com.study.crawler.exception;

/**
 * className: ConnectErrorException
 * description: TODO
 *
 * @author lh
 * @version 1.0
 * @date 19-1-12
 */

public class ConnectErrorException extends Exception{
    public ConnectErrorException(String url) {
        super(url + " 连接失败");
    }
}
