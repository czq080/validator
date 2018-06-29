package com.vigoss.validator.element;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenzhiqiang
 * @date 2018/6/8
 */
public class ValidatorChain {
    List<AbstractValidatorUnit> units = new ArrayList<AbstractValidatorUnit>();

    public static ValidatorChain build() {
        return new ValidatorChain();
    }

    public ValidatorChain addValidatorUnit(AbstractValidatorUnit unit) {
        units.add(unit);
        return this;
    }

    public boolean isEmpty() {
        return units == null || units.isEmpty();
    }

    public List<AbstractValidatorUnit> getUnits() {
        return units;
    }
}
