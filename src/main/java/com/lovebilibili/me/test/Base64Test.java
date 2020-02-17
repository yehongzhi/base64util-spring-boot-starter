package com.lovebilibili.me.test;

import com.lovebilibili.me.util.Base64Util;

/**
 * @author Ye Hongzhi
 * @program Base64Test
 * @description
 * @date 2020-02-17 14:39
 **/
public class Base64Test {

    public static void main(String[] args) {
        String imageStr = Base64Util.getImageFile("C:\\Users\\yehongzhi\\Downloads\\小程序icon\\img\\archive.png");
        System.out.println(imageStr);
        boolean b = Base64Util.generateImage(imageStr, "C:\\Users\\yehongzhi\\Downloads\\小程序icon\\img\\binamahoufile.png");
        System.out.println(b);
    }
}
