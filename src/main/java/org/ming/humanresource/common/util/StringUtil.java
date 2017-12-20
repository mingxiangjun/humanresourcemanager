package org.ming.humanresource.common.util;

/**
 * 字符串工具类
 *
 * @author MingXiangjun
 * @create 2017-12-16 14:37
 */
public class StringUtil {
    /**
     * 空字符串判断
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return str==null || !(str.length()>0);
    }

    /**
     * 字符串非空判断
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
