package com.vigoss.validator.util;

import com.vigoss.validator.context.ValidationContext;
import org.apache.commons.lang3.StringUtils;

/**
 * @author chenzhiqiang
 * @date 2018/6/13
 */
public class ValidatorAssertUtil {
    /**
     * 不能为null
     * @param obj
     * @param msg
     */
    public static boolean assertNotNull(Object obj, String msg, ValidationContext validationContext) {
        if (obj == null) {
            validationContext.addErrorMsg(msg);
            return false;
        }
        return true;
    }
    /**
     * 字符串不能为空
     * @param str
     * @param msg
     */
    public static boolean assertNotBlank(String str, String msg, ValidationContext validationContext) {
        if (StringUtils.isBlank(str)) {
            validationContext.addErrorMsg(msg);
            return false;
        }
        return true;
    }
}
