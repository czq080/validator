package com.vigoss.validator.result;

/**
 * @author chenzhiqiang
 * @date 2018/6/12
 */
public interface ResultCollector<T> {
    T toResult(ValidationResult result);
}
