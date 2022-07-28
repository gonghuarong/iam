package com.core.utils;

import java.util.Random;

public class IamUtils {
    private IamUtils() {}

    /**
     * 生成指定长度的随机数
     * @param len
     * @return
     */
    public static String getRandom(int len){
        if (len <= 0) len = 1;
        Random random = new Random();
        StringBuilder randStr = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int num = random.nextInt(10);
            randStr.append(num);
        }
        return randStr.toString();
    }
}
