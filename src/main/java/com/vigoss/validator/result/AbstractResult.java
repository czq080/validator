package com.vigoss.validator.result;

import java.util.List;

/**
 * @author chenzhiqiang
 * @date 2018/6/12
 */
public abstract class AbstractResult<T> {
    private boolean success;

    private int validateCost;

    private List<T> errorList;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<T> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<T> errorList) {
        this.errorList = errorList;
    }

    public int getValidateCost() {
        return validateCost;
    }

    public void setValidateCost(int validateCost) {
        this.validateCost = validateCost;
    }
}
