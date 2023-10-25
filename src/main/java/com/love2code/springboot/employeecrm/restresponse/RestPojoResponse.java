package com.love2code.springboot.employeecrm.restresponse;

public class RestPojoResponse {
    public String message;
    public boolean success;
    public int status;
    public Object data;

    public RestPojoResponse(){}

    public RestPojoResponse(String message, boolean success, int status, Object data) {
        this.message = message;
        this.success = success;
        this.status = status;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
