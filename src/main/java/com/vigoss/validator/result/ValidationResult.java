package com.vigoss.validator.result;

import com.vigoss.validator.error.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenzhiqiang
 * @date 2018/6/12
 */
public class ValidationResult {

    private boolean isSuccess = true;

    private List<ValidationError> errors;

    private int validateCost;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public void addError(ValidationError error) {
        if (errors == null) {
            errors = new ArrayList<ValidationError>();
        }
        errors.add(error);
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    public int getValidateCost() {
        return validateCost;
    }

    public void setValidateCost(int validateCost) {
        this.validateCost = validateCost;
    }
}
