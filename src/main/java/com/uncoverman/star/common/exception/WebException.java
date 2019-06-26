package com.uncoverman.star.common.exception;

/**
 * FEBS系统内部异常
 *
 * @author MrBird
 */
public class WebException extends Exception {

    private static final long serialVersionUID = -994962710559017255L;

    public WebException(String message) {
        super(message);
    }
}
