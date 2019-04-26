package com.lvsl.android.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 数字处理工具类
 * 格式化
 *
 * @author lvsl
 * @date 2019-04-26
 */
public class NumberFormatUtils {

    /**
     * 格式化数
     * <p>
     * 6300 -> 6.300
     * 63000 -> 6.3万
     * 63500 -> 6.3万
     *
     * @param formatNum 获取到的数值
     * @param startNum  开始的数值,例如对10000一万,来进行处理,则使用10000
     * @return String.valueOf(num) + "万"
     */
    public static String formatNum(long formatNum, int startNum) {
        if (formatNum < startNum) {
            return String.valueOf(formatNum);
        }
        formatNum = formatNum / 1000;
        float num = ((float) formatNum) / 10;
        return num + "万";
    }

    /**
     * 不带单位的格式化
     * 与上面相同
     *
     * @param formatNum
     * @param startNum
     * @return
     */
    public static String formatNumWithoutUnit(long formatNum, int startNum) {
        if (formatNum < startNum) {
            return String.valueOf(formatNum);
        }
        formatNum = formatNum / 1000;
        float num = ((float) formatNum) / 10;
        return String.valueOf(num);
    }

    /**
     * 保留一位小数
     *
     * @param number
     * @return
     */
    public static String formatNumOne(double number) {
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(number);
    }

    /**
     * 保留一位非0小数
     * setScale(1   可以进行设置,数字表示保留的小数的位数
     *
     * @param number
     * @return
     */
    public static String formatNumOneWithout0(double number) {
        BigDecimal bg = new BigDecimal(number).setScale(1, RoundingMode.UP);

        double num = bg.doubleValue();
        if (Math.round(num) - num == 0) {
            return String.valueOf((long) num);
        }
        return String.valueOf(num);
    }

    /**
     * 时间戳转化为时间
     *
     * @param s
     * @return
     */
    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
}
