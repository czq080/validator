package com.vigoss.validator;

import com.vigoss.validator.context.ValidationContext;

/**
 * @author chenzhiqiang
 * @date 2018/6/8
 */
public interface Validator<T> {
    /**
     * 是否进行参数校验
     * @param t
     * @return
     */
    boolean accept(T t);

    /**
     * 进行校验
     */
    boolean validate(T t, ValidationContext validationContext);
}
