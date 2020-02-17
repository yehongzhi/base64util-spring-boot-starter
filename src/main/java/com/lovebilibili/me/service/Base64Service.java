package com.lovebilibili.me.service;

import com.lovebilibili.me.util.Base64Util;

/**
 * @author Ye Hongzhi
 * @program Base64Service
 * @description
 * @date 2020-02-17 15:13
 **/
public class Base64Service {

    /**
     * 本地图片转为BASE64编码
     */
    public String getImageFile(String imgFile) {
        return Base64Util.getImageFile(imgFile);
    }

    /**
     * BASE64编码转为图片
     * */
    public boolean generateImage(String imgStr, String path) {
        return Base64Util.generateImage(imgStr,path);
    }

    public String image2Base64(String imgUrl) throws Exception{
        return Base64Util.image2Base64(imgUrl);
    }
}
