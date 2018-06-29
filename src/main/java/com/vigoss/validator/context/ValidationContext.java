package com.vigoss.validator.context;

import com.vigoss.validator.result.ValidationResult;

/**
 * @author chenzhiqiang
 * @date 2018/6/8
 */
public interface ValidationContext {

    void addErrorMsg(String msg);

    void setResult(ValidationResult result);
}
