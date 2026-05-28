package com.leetcode.programtest3;

/**
 * @author: Mr.He
 * @create: 2022-09-21 17:14
 * @description: 验证IP地址
 **/
public class Question_ValidIPAddress {

    public static String validIPAddress(String queryIP) {
        if (queryIP.indexOf('.') >= 0) {
            //IPV4
            int last = -1;
            for (int i = 0; i < 4; i++) {
                int cur = (i == 3 ? queryIP.length() : queryIP.indexOf('.',last + 1));
                if (cur < 0){
                    return "Neither";
                }
                if (cur - last - 1 < 1 || cur - last - 1 > 3){
                    return "Neither";
                }
                int addr = 0;
                for (int j = last + 1; j < cur; j++) {
                    if (!Character.isDigit(queryIP.charAt(j))){
                        return "Neither";
                    }
                    addr = addr * 10 + (queryIP.charAt(j) - '0');
                }
                if (addr > 255 || addr < 0){
                    return "Neither";
                }
                if (addr > 0 && queryIP.charAt(last + 1) == '0'){
                    return "Neither";
                }
                if (addr == 0 && cur - last - 1 > 1){
                    return "Neither";
                }
                last = cur;
            }
            return "IPv4";
        } else if (queryIP.indexOf(':') >= 0) {
            int last = -1;
            for (int i = 0; i < 8; i++) {
                int cur = (i == 7 ? queryIP.length() : queryIP.indexOf(':',last + 1));
                if (cur < 0){
                    return "Neither";
                }
                if (cur - last - 1 < 1 || cur - last - 1 > 4){
                    return "Neither";
                }
                for (int j = last + 1; j < cur; j++) {
                    if (!Character.isDigit(queryIP.charAt(j)) && !('a' <= Character.toLowerCase(queryIP.charAt(j)) && Character.toLowerCase(queryIP.charAt(j)) <= 'f')){
                        return "Nethier";
                    }
                }
                last = cur;
            }
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    public static void main(String[] args) {
        System.out.println(validIPAddress("2001:db8:85a3:0::8a2E:0370:7334"));
    }

}
