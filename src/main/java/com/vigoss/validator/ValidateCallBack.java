package com.vigoss.validator;

/**
 * @author chenzhiqiang
 * @date 2018/6/8
 */
public interface ValidateCallBack {
    /**
     * 校验成功回调
     */
    void onSunccess();

    /**
     * 校验不通过
     */
    void onFail();

    /**
     * 校验异常
     */
    void onException(Validator validator, Object target, Exception e) throws Exception;
}
