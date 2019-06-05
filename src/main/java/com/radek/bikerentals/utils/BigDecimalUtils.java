package com.radek.bikerentals.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalUtils {

    public static BigDecimal random(BigDecimal min, BigDecimal max) {
        BigDecimal random = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
        return random.setScale(6, RoundingMode.HALF_UP);
    }
}
