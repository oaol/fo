package com.fo.test.common;

import org.apache.commons.lang3.StringUtils;

/**
 * java 对 UNICODE 字符支持的测试
 * @author bryce
 * @Date Jul 18, 2019
 */
public class JavaUnicodeTest {
    public static void main(String[] args) {
//        String a = "1";
        Character b = '\u0061';
        System.out.println(b);
        String \u0061 = "1";
        \u0053\u0074\u0072\u0069\u006E\u0067\u0020\u0063 = "1";
        System.out.println(c);
        String ss = charUnicode(' ');
        System.out.println(ss);
    }

    public static String charUnicode(Character ch) {
        String hexString = Integer.toHexString(ch);
        String leftPad = StringUtils.leftPad(hexString, 4, "0");
//        String.format("%4s", hexString).replaceAll("\\s", "0")
        return "\\u" + leftPad;
    }
}