package com.vigoss.validator.context;

import com.vigoss.validator.error.ValidationError;
import com.vigoss.validator.result.ValidationResult;

/**
 * @author chenzhiqiang
 * @date 2018/6/12
 */
public class DefaultValidationContext implements ValidationContext {

    private ValidationResult result;

    @Override
    public void addErrorMsg(String msg) {
        result.addError(ValidationError.build(msg));
    }

    @Override
    public void setResult(ValidationResult result) {
        this.result = result;
    }
}
