package com.lovebilibili.me.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.sun.org.apache.xml.internal.security.utils.Base64.encode;

/**
 * @author Ye Hongzhi
 * @program Base64Util
 * @description
 * @date 2020-02-17 14:04
 **/
public class Base64Util {

    /**
     * 本地图片转为BASE64编码
     *
     * @param imgFile 本地图片地址
     * @return BASE64 解码后的字符串编码
     * @description: 根据图片地址转换为base64编码字符串
     * @author: Ye Hongzhi
     * @createTime: 2020/02/17
     */
    public static String getImageFile(String imgFile) {
        byte[] data = null;
        try (InputStream inputStream = new FileInputStream(imgFile)) {
            data = new byte[inputStream.available()];
            int length = inputStream.read(data);
            if (length == -1) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        if (data != null) {
            return encoder.encode(data);
        } else {
            return null;
        }
    }

    public static String image2Base64(String imgUrl) throws Exception {
        URL url = new URL(imgUrl);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try(InputStream inputStream = urlConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            urlConnection.connect();
            byte[] buffer = new byte[1024];
            int len;
            //使用一个输入流从buffer里把数据读取出来
            while ((len = inputStream.read(buffer)) != -1) {
                //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
                baos.write(buffer, 0, len);
            }
            // 对字节数组Base64编码
            return encode(baos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return imgUrl;
    }

    /**
     * BASE64编码转为图片
     * 注意："data:image/jpeg;base64," 解码之前得去掉。
     *
     * @param imgStr base64编码字符串
     * @param path   图片路径-具体到文件
     * @return 是否转换成功
     * @description: 将base64编码字符串转换为图片
     * @author: Ye Hongzhi
     * @createTime: 2020/02/17
     */
    public static boolean generateImage(String imgStr, String path) {
        if (imgStr == null) {
            return false;
        }
        try (OutputStream out = new FileOutputStream(path)) {
            BASE64Decoder decoder = new BASE64Decoder();
            // 解密
            byte[] b = decoder.decodeBuffer(imgStr);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            out.write(b);
            out.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
