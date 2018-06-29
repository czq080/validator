package com.vigoss.validator;

import com.vigoss.validator.context.DefaultValidationContext;
import com.vigoss.validator.context.ValidationContext;
import com.vigoss.validator.element.DefaultValidatorUnit;
import com.vigoss.validator.element.ValidatorChain;
import com.vigoss.validator.error.ValidationError;
import com.vigoss.validator.result.Result;
import com.vigoss.validator.result.ResultCollector;
import com.vigoss.validator.result.ValidationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;

/**
 * @author chenzhiqiang
 * @date 2018/6/8
 */
public class ValidatorProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorProxy.class);

    private ValidationContext validationContext = new DefaultValidationContext();

    private ValidatorChain validatorChain = new ValidatorChain();

    private ValidationResult validationResult = new ValidationResult();

    private boolean isFailFast = true;

    public static ValidatorProxy buid(){
        return new ValidatorProxy();
    }

    public ValidatorProxy withContext(ValidationContext validationContext){
        if(validationContext == null)
            throw new NullPointerException("ValidationContext must not be null");
        this.validationContext = validationContext;
        return this;
    }

    public <T> ValidatorProxy withValidator(T t, Validator<T> v) {
        if (v == null) {
            throw new NullPointerException("Validator must not be null");
        }
        doAddValidator(t, v);
        return this;
    }

    private <T> void doAddValidator(T t, Validator<T> v) {
        validatorChain.addValidatorUnit(new DefaultValidatorUnit(v, t));
    }

    public ValidatorProxy failFast() {
        this.isFailFast = true;
        return this;
    }

    public ValidatorProxy failOver() {
        this.isFailFast = false;
        return this;
    }

    public ValidatorProxy doValidate() {
        return doValidate(
                new ValidateCallBack() {
                    @Override
                    public void onSunccess() {
                    }

                    @Override
                    public void onFail() {
                    }

                    @Override
                    public void onException(Validator validator, Object target, Exception e) throws Exception {
                        LOGGER.error("参数校验过程出现异常:{}", e.getMessage(), e);
                        throw e;
                    }
                });
    }

    public ValidatorProxy doValidate(ValidateCallBack callBack) {

        if (callBack == null) {
            throw new NullPointerException("ValidateCallBack must not be null");
        }
        long validateStart = System.currentTimeMillis();
        try {
            validationContext.setResult(this.validationResult);
            validatorChain.getUnits().forEach(unit -> {
                Object target = unit.getTarget();
                try {
                    if (!unit.validate(this.validationContext)) {
                        validationResult.setIsSuccess(false);
                        if (isFailFast) {
                            return;
                        }
                    }
                } catch (Exception var1) {
                    validationResult.setIsSuccess(false);
                    try {
                        callBack.onException(unit.getValidator(), target, var1);
                    } catch (Exception var2) {
                        throw new RuntimeException(var2);
                    }
                }
            });
            if (validationResult.isSuccess())
                callBack.onSunccess();
            else
                callBack.onFail();
            return this;
        } finally {
            validationResult.setValidateCost((int) ((System.currentTimeMillis() - validateStart)));
        }
    }

    public Result<String> result(){
        return result(result -> {
            Result ret = new Result();
            if (result.isSuccess()) {
                ret.setSuccess(true);
            } else {
                ret.setSuccess(false);
                ret.setValidateCost(result.getValidateCost());
                ret.setErrorList(result.getErrors().stream().map(ValidationError::getErrorMsg).collect(Collectors.toList()));
            }
            return ret;
        });
    }

    public <T> T result(ResultCollector<T> resultCollector){
        return resultCollector.toResult(validationResult);
    }
}
