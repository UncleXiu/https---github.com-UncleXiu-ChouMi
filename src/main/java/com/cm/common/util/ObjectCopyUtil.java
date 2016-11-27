package com.cm.common.util;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @Project CM
 * @ClassName com.common.util.ObjectCopyUtil
 * @Author 修峻青
 * @Time   2016-8-12-11:07
 * @Declear 对象复制类
 * @Control 筹Mi-V1.0版权控制
 */
public class ObjectCopyUtil {

    /**
     * 对象的完全复制
     * @param from
     * @param to
     */
    public static void copyProperties(Object from, Object to) throws Exception {
        copyPropertiesExclude(from, to, null);
    }

    /**
     * 排除指定属性的对象赋值
     * @param from
     * @param to
     * @param excludsArray（排除属性列表）
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static void copyPropertiesExclude(Object from, Object to, String[] excludsArray) throws Exception {
        List<String> excludesList = null;
        //构造列表对象
        if(excludsArray != null && excludsArray.length > 0) {
            excludesList = Arrays.asList(excludsArray);
        }
        //获取源对象和目标对象内声明的方法
        Method[] fromMethods = from.getClass().getDeclaredMethods();
        Method[] toMethods = to.getClass().getDeclaredMethods();
        Method fromMethod = null;
        Method toMethod = null;
        String fromMethodName = null;
        String toMethodName = null;
        //循环调用函数并赋值
        for (int i = 0; i < fromMethods.length; i++) {
            //捕获源对象内部的get方法
            fromMethod = fromMethods[i];
            fromMethodName = fromMethod.getName();
            //方法中没有get则跳出本次循环，检验下一个方法
            if (!fromMethodName.contains("get")) {
                continue;
            }
            //排除列表检测，若该字符串被排除则跳出本次循环，进行下一个方法
            if(excludesList != null && excludesList.contains(fromMethodName.substring(3))) {
                continue;
            }
            //捕获目标对象内部的set方法
            toMethodName = "set" + fromMethodName.substring(3);
            toMethod = findMethodByName(toMethods, toMethodName);
            //方法中没有set则跳出本次循环，检验下一个方法
            if (toMethod == null) {
                continue;
            }
            //通过反射调用源对象对应属性的值
            Object value = fromMethod.invoke(from, new Object[0]);
            //值为空则跳出本次循环，检索下一属性
            if(value == null) {
                continue;
            }
            if(value instanceof Collection) {
                Collection newValue = (Collection)value;
                if(newValue.size() <= 0) {
                    continue;
                }
            }
            //通过反射设置目标对象对应的属性的值
            toMethod.invoke(to, new Object[] {value});
        }
    }

    /**
     * 复制指定属性的对象赋值
     * @param from
     * @param to
     * @param includsArray（指定属性列表）
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static void copyPropertiesInclude(Object from, Object to, String[] includsArray) throws Exception {

        List<String> includesList = null;
        //需构造对象的属性列表
        if(includsArray != null && includsArray.length > 0) {
            includesList = Arrays.asList(includsArray);
        } else {
            return;
        }
        //获取源对象和目标对象内声明的方法
        Method[] fromMethods = from.getClass().getDeclaredMethods();
        Method[] toMethods = to.getClass().getDeclaredMethods();
        Method fromMethod = null, toMethod = null;
        String fromMethodName = null, toMethodName = null;
        //循环验证方法
        for (int i = 0; i < fromMethods.length; i++) {
            fromMethod = fromMethods[i];
            fromMethodName = fromMethod.getName();
            //若非get方法，则跳过本次循环，验证下一方法
            if (!fromMethodName.contains("get")) {
                continue;
            }
            //复制列表检查
            String str = fromMethodName.substring(3);
            //若不存在该属性则退出本次循环
            if(!includesList.contains(str.substring(0,1) + str.substring(1))) {
                continue;
            }
            toMethodName = "set" + fromMethodName.substring(3);
            //通过名字来寻找并执行相应的方法
            toMethod = findMethodByName(toMethods, toMethodName);
            if (toMethod == null) {
                continue;
            }
            //通过反射调用源对象对应的属性的值
            Object value = fromMethod.invoke(from, new Object[0]);
            if(value == null) {
                continue;
            }
            //集合类判空处理
            if(value instanceof Collection) {
                Collection newValue = (Collection)value;
                if(newValue.size() <= 0)
                    continue;
            }
            //通过反射设置目标对象对应的属性的值
            toMethod.invoke(to, new Object[] {value});
        }

    }



    /**
     * 从方法数组中获取指定名称的方法
     * @param methods
     * @param name
     * @return
     */
    public static Method findMethodByName(Method[] methods, String name) {

        for (int j = 0; j < methods.length; j++) {
            if (methods[j].getName().equals(name))
                return methods[j];
        }
        return null;
    }

}
