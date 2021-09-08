package com.group.lesson.common;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: hwj
 * @Date: 2021/9/8 15:53
 */
public class RegexUtil {
    private static Pattern mobileRegex = Pattern.compile("^(13[0-9]{9})|(15[0-9]{9})|(17[0-9]{9})|(18[0-9]{9})|(19[0-9]{9})$");
    private static Pattern emailRegex = Pattern.compile("^[a-z0-9](\\w|\\.|-)*@([a-z0-9]+-?[a-z0-9]+\\.){1,3}[a-z]{2,4}$");

    public static boolean isMobile(String mobile){
        Matcher matcher = mobileRegex.matcher(mobile);
        return matcher.matches();
    }
    public static boolean isEmail(String email){
        Matcher matcher = emailRegex.matcher(email);
        return matcher.matches();
    }

}
