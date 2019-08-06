package com.zeropoint.homemaking.controllers.admin;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.lang.Assert;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/ar")
public class FileUpload {



    @ResponseBody
    @RequestMapping(value = "/uploadFile1")
    public String uploadFile(HttpServletRequest request,HttpSession session, @Param("file") MultipartFile file) throws IOException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

        String res = sdf.format(new Date());


        //原始名称
        String originalFilename = file.getOriginalFilename();



        //新的文件名称
        String newFileName = res + originalFilename.substring(originalFilename.lastIndexOf("."));

        //创建年月文件夹
        Calendar date = Calendar.getInstance();

        File dateDirs = new File(date.get(Calendar.YEAR)

                + File.separator + (date.get(Calendar.MONTH) + 1));
        System.out.println(dateDirs);

        //新文件
        File newFile = new File("/root/uploadFiles/");

//判断目标文件所在的目录是否存在

        if (!newFile.getParentFile().exists()) {

            //如果目标文件所在的目录不存在，则创建父目录
            newFile.getParentFile().mkdirs();

        }

        System.out.println(newFile);


        Map map = new HashMap();

        Map map2 = new HashMap();

        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/"+newFileName;

        session.setAttribute("url",url);

        map.put("code", 0);//0表示成功，1失败

        map.put("msg", "上传成功");//提示消息
        map.put("url",url);

        map.put("data", map2);

        map2.put("src", request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "");//图片url



        map2.put("title", newFileName);//图片名称，这个会显示在输入框里


        String result = new JSONObject(map).toString();
        System.out.println(result);
        file.transferTo(new File(newFile,newFileName));
        return result;

    }
}