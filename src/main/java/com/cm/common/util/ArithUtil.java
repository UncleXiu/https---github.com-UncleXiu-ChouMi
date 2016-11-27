package com.cm.common.util;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Project CM
 * @ClassName com.common.util
 * @Author 修峻青
 * @Time 2016-8-16-8:45
 * @Declear 精确大数计算类
 * @Control 筹Mi-V1.0版权控制
 */
public class ArithUtil {

    /**
     * 默认除法运算精度常量
     */
    private static final int DEF_DIV_SCALE = 10;

    /**
     * 加法函数
     * @param v1
     * @param v2
     * @return
     */
    public static double add(double v1, double v2) {
        //定义大数计算变量
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        //以大数双精度进行加法运算
        return b1.add(b2).doubleValue();
    }

    /**
     * 减法函数
     * @param v1
     * @param v2
     * @return
     */
    public static double sub(double v1, double v2) {
        //定义大数计算变量
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        //以大数双精度进行加法计算
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 乘法函数
     * @param v1
     * @param v2
     * @return
     */
    public static double mul(double v1, double v2) {
        //定义大数计算变量
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        //以大数双精度进行乘法运算
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 乘方函数
     * @param v1
     * @param v2
     * @return
     */
    public static double mulsque(double v1, int v2){
        //定义运算变量
        BigDecimal res = new BigDecimal( Double.toString( 1 ) );
        BigDecimal b1 = new BigDecimal( Double.toString( v1 ) );
        //乘方运算
        for(int i = 0; i<v2; i++){
            res = res.multiply( b1 );
        }
        //结果数据类型转换
        double result = res.doubleValue();
        return result;
    }

    /**
     * 设定精度的除法函数
     * @param v1
     * @param v2
     * @param scale
     * @return
     */
    public static double div(double v1, double v2, int scale) {
        //检验小数精度是否大于0，若不大于等于0则抛出异常
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        //定义大数计算变量
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        //以大数双精度计算除法
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 保留小数处理
     * @param v
     * @param scale
     * @return
     */
    public static double round(double v, int scale) {
        //检验小数精度是否大于0，若不大于等于0则抛出异常
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        //获取大数双精度数据
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        //大数双精度进行小数位数截取
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
