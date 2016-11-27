package com.cm.common.util;

import com.cm.common.interceptor.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @项目名： CM
 * @包名： com.cm.common.util
 * @类名： FileUploadUtil
 * @类描述： 文件上传工具类
 * @时间： 2016-8-17
 * @编写者： 修峻青
 */
@Controller
@RequestMapping(value = "/")
public class FileUploadUtil {

    @RequestMapping(value = "FileUpload.do")
    @ResponseBody
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {
        System.out.println("开始");
        //拼接物理地址: E:/学年设计/FileUpload.do/用户名
        String path = "E:/学年设计"+request.getRequestURI()+"/"+request.getSession().getAttribute( "UserName" );
        //将文档路径存入Session
        request.getSession().setAttribute( "FileURL",path );
        //设计文件名
        String fileName = file.getOriginalFilename();
        //String fileName = new Date().getTime()+".jpg";
        //建立文件传输目标
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回成功码0000
        return Constant.OPER_SUCCESS;
    }

}
