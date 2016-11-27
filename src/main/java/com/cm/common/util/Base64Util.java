package com.cm.common.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * @Project CM
 * @ClassName com.common.util
 * @Author 修峻青
 * @Time 2016-8-16-8:58
 * @Declear Base64转换类
 * @Control 筹Mi-V1.0版权控制
 */
public class Base64Util {

    /**
     * Base64转换为jpg图片
     * @param imgStr
     * @param imgPath
     * @param imgName
     * @return
     */
    public static boolean GenerateImage(String imgStr,String imgPath,String imgName){
        //对字节数组字符串进行Base64解码并生成图片
        //对字符串组进行判定，若为空则直接结束
        if (imgStr == null) {
            return false;
        }
        //初始化Base64字符串变量
        BASE64Decoder decoder = new BASE64Decoder();
        try{
            //对Base64进行解码为byte数组
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i){
                if(b[i]<0){
                    //对异常数据进行调整
                    b[i]+=256;
                }
            }
            //构建路径，准备生成jpg图片
            String imgFilePath = imgPath+imgName+".jpg";
            //新生成的图片并存储到指定路径，打开文件字节流
            OutputStream out = new FileOutputStream(imgFilePath);
            //字节流输出
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        //若执行异常则抛出异常，结束
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Base64转化为无后缀的图片
     * @param imgStr
     * @param imgPath
     * @param imgName
     * @return
     */
    public static boolean GenerateImage1(String imgStr,String imgPath,String imgName){
        //对字节数组字符串进行Base64解码并生成图片
        //对字符串组进行判定，若为空则直接结束
        if (imgStr == null) {
            return false;
        }
        //初始化Base64字符串变量
        BASE64Decoder decoder = new BASE64Decoder();
        try{
            //对Base64进行解码为byte数组
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i){
                if(b[i]<0){
                    //对异常数据进行调整
                    b[i]+=256;
                }
            }
            //构建路径，准备生成图片
            String imgFilePath = imgPath+imgName;
            //新生成的图片并存储到指定路径，打开文件字节流
            OutputStream out = new FileOutputStream(imgFilePath);
            //字节流输出
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        //若执行异常则抛出异常，结束
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 图片转化为Base64字符串
     * @param imgFile
     * @return
     */
    public static String GetImageStr(String imgFile){
        //准备文件输入流和字节数组
        InputStream in = null;
        byte[] data = null;
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        //读取图片字节，并存入数组，出现异常抛出
        try{
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        //字节数组进行Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        //返回Base64编码的字节数组字符串
        return encoder.encode(data);
    }

}
