package com.huaibei.response;

/**
 * @author xiaolong
 * @date 2024/5/8
 */
public class ApiResponse {
    public boolean isSuccess() {
        return success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private boolean success;
    private Object data;
    private String message;

    public void setSuccess(boolean b) {
    }
}
