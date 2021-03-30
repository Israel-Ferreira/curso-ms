package io.codekaffee.hruser.exceptions.handlers;

public class StandardError {
    private String errorMsg;
    private Integer statusCode;
    private String resourceName;
    

    public StandardError(){}


    public StandardError(String errorMsg, Integer statusCode, String resourceName){
        this.errorMsg = errorMsg;
        this.statusCode = statusCode;
        this.resourceName = resourceName;
    }


    public String getErrorMsg() {
        return errorMsg;
    }


    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }


    public Integer getStatusCode() {
        return statusCode;
    }


    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }


    public String getResourceName() {
        return resourceName;
    }


    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }


}
