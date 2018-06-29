package com.vigoss.validator.element;

import com.vigoss.validator.Validator;
import com.vigoss.validator.context.ValidationContext;

/**
 * @author chenzhiqiang
 * @date 2018/6/8
 */
public abstract class AbstractValidatorUnit<T> {

    private final Validator<T> validator;

    private final T target;

    public AbstractValidatorUnit(Validator<T> validator, T target) {
        this.validator = validator;
        this.target = target;
    }

    /**
     * 默认校验单元执行逻辑，查看校验器是否允许校验，是进行参数校验，否则返回校验成功
     *
     * @return
     */
    public boolean validate(ValidationContext validationContext) {
        if (validator.accept(this.target)) {
            return validator.validate(this.target, validationContext);
        }
        return true;
    }

    public Validator<T> getValidator() {
        return validator;
    }

    public T getTarget() {
        return target;
    }
}
