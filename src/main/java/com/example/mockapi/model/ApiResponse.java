package com.example.mockapi.model;

/**
 * Generic wrapper for API responses.
 *
 * @param <T> the type of data returned in the response
 */
public class ApiResponse<T> {

    private int status;
    private String message;
    private T data;

    /**
     * Default constructor.
     */
    public ApiResponse() {
    }

    /**
     * Constructs a new ApiResponse with status, message, and data.
     *
     * @param status  HTTP-like status code
     * @param message response message
     * @param data    the response payload
     */
    public ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /**
     * Gets the status code.
     *
     * @return the status code
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the status code.
     *
     * @param status the status code
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Gets the message.
     *
     * @return the response message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message the response message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the response data.
     *
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the response data.
     *
     * @param data the response data
     */
    public void setData(T data) {
        this.data = data;
    }
}
