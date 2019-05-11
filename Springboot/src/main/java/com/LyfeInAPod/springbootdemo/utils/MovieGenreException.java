package com.LyfeInAPod.springbootdemo.utils;

/**
 * Customized Exception to handle any error situation properly
 * @author ""
 *
 */
public class MovieGenreException extends Exception {

    private static final long serialVersionUID = 5960061893065427227L;

    private String errorMessage;

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public MovieGenreException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
