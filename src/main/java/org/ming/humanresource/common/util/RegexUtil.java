package org.ming.humanresource.common.util;

import java.util.regex.Pattern;

/**
 * 正则表达式校验工具
 *
 * @author MingXiangjun
 * @create 2017-12-19 21:47
 */
public class RegexUtil {
    private static final String ACCOUNT_REGEX = "/^[a-zA-Z0-9_-]{4,16}$/";
    /**
     * 校验值是否符合regex正则规则
     * @param val
     * @param regex
     * @return
     */
    public static boolean isMatches(String val,String regex){
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(val).matches();
    }

    /**
     * 是否是正确格式的用户名
     * @param account
     * @return
     */
    public static boolean isAccount(String account){
        return isMatches(account,ACCOUNT_REGEX);
    }
}
