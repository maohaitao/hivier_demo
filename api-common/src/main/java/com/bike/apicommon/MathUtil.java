package com.bike.apicommon;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * Created by a700 on 16/3/29.
 */
public class MathUtil {

    static DecimalFormat df = new DecimalFormat("#0.000");

    public static Double add(Double d1, Double d2) {        // 进行加法运算
        if (d1 == null) {
            d1 = 0.0d;
        }
        if (d2 == null) {
            d2 = 0.0d;
        }
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return dfDouble(b1.add(b2).doubleValue());
    }

    public static Double sub(Double d1, Double d2) {        // 进行减法运算
        if (d1 == null) {
            d1 = 0.0d;
        }
        if (d2 == null) {
            d2 = 0.0d;
        }
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return dfDouble(b1.subtract(b2).doubleValue());
    }

    public static Double mul(Double d1, Double d2) {        // 进行乘法运算
        if (d1 == null) {
            d1 = 0.0d;
        }
        if (d2 == null) {
            d2 = 0.0d;
        }
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return dfDouble(b1.multiply(b2).doubleValue());
    }

    public static Double div(Double d1, Double d2, int len) {// 进行除法运算
        if (d1 == null) {
            d1 = 0.0d;
        }
        if (d2 == null) {
            d2 = 0.0d;
        }
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return dfDouble(b1.divide(b2, len, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    public static Double round(Double d, int len) {     // 进行四舍五入        操作
        if (d == null) {
            d = 0.0d;
        }

        BigDecimal b1 = new BigDecimal(d);
        BigDecimal b2 = new BigDecimal(1);
        return dfDouble(b1.divide(b2, len, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    public static Double dfDouble(double d) {
        String value = df.format(d);
        try {
            return df.parse(value).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    public static void main(String[] args) {
        System.out.println(dfDouble(0.2));
    }
}
