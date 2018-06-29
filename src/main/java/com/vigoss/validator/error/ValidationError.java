package com.vigoss.validator.error;

/**
 * @author chenzhiqiang
 * @date 2018/6/12
 */
public class ValidationError {

    private String errorMsg;

    private String field;

    private int errorCode;

    private Object targetValue;

    public static ValidationError build() {
        return new ValidationError();
    }

    public static ValidationError build(String errorMsg) {
        return new ValidationError().setErrorMsg(errorMsg);
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public ValidationError setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public String getField() {
        return field;
    }

    public ValidationError setField(String field) {
        this.field = field;
        return this;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public ValidationError setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public Object getTargetValue() {
        return targetValue;
    }

    public ValidationError setTargetValue(Object targetValue) {
        this.targetValue = targetValue;
        return this;
    }

    @Override
    public String toString() {
        return "ValidationError{" +
                "errorMsg='" + errorMsg + '\'' +
                ", field='" + field + '\'' +
                ", errorCode=" + errorCode +
                ", targetValue=" + targetValue +
                '}';
    }
}
