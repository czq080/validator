package com.vigoss.validator.element;

import com.vigoss.validator.Validator;

/**
 * @author chenzhiqiang
 * @date 2018/6/8
 */
public class DefaultValidatorUnit<T> extends AbstractValidatorUnit {

    public DefaultValidatorUnit(Validator<T> validator, T target) {
        super(validator, target);
    }
}
