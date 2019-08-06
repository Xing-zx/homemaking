package com.zeropoint.homemaking.controllers.client;


import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.Certificate;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.services.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/api")
public class CertificateController {
    @Autowired
    PersonnelService personnelService;
    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @RequestMapping("/certificateList")
    public JSONObject certificateList(@RequestBody JSONObject request){
        JSONObject res =new JSONObject();
        try{
            res.put("code",1);
            res.put("msg","certificateList");
            Integer userId =request.getInteger("id");
            ServicePersonnel personnel = personnelService.findByUserId(userId);
            res.put("data",personnelService.getCertificates(personnel.getId()));

        }catch (NullPointerException e)
        {
            res.put("code",0);
            res.put("msg","无证书");
        }
        return res;
    }

    /**
     *
     * @param img picture_url:''
     * @param req user_id,token, typeId:'', title:'',create_time:''
     * @return {code,msg}
     */
    @RequestMapping("/uploadCert")
    public JSONObject uploadCert(@RequestParam("pictureUrl")MultipartFile img, HttpServletRequest req)throws IOException {
        JSONObject res =new JSONObject();
        Integer userId =Integer.parseInt(req.getParameter("user_id"));
        String idStr = req.getParameter("id");
        String token = req.getParameter("token");
        String categoryId =req.getParameter("categoryId");
        String name =req.getParameter("name");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(req.getParameter("expirationTime"));
        Date expireTime = null;
        try {
            expireTime = df.parse(req.getParameter("expirationTime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(expireTime.toString());
        Certificate certificate =new Certificate();
        System.out.println(idStr);
        if (!("".equals(idStr)))
        {
           certificate.setId(Integer.parseInt(idStr));
        }
        certificate.setCategoryId(Integer.parseInt(categoryId));
        certificate.setStatus(0);
        certificate.setName(name);
        certificate.setCreateTime(new Date());
        certificate.setPersonnelId(personnelService.findByUserId(userId).getId());
        certificate.setExpirationTime(expireTime);
        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
        String format = sdf.format(new Date());
        String realPath = uploadFolder + format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        System.out.println(realPath);
        String oldName = img.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        System.out.println(newName);
        img.transferTo(new File(folder,newName));
        String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/" + format + newName;
        certificate.setPictureUrl(url);
        personnelService.addCertificate(certificate);
        System.out.println(url);
        res.put("code",1);
        res.put("msg","upload");
        System.out.println(res.toJSONString());
        return res;
    }

    @RequestMapping("/editCert")
    public JSONObject editCert(@RequestBody JSONObject request){
        JSONObject res =new JSONObject();
        System.out.println(request);
        try{
            Integer id =request.getInteger("id");
            Certificate certificate =personnelService.findCertificatByid(id);
            certificate.setCategoryId(Integer.parseInt(request.getString("categoryId")));
            certificate.setName(request.getString("name"));
            certificate.setPersonnelId(personnelService.findByUserId(request.getInteger("user_id")).getId());
            certificate.setExpirationTime(request.getDate("expirationTime"));
            certificate.setPictureUrl(request.getString("pictureUrl"));
            certificate.setStatus(request.getInteger("status"));
            certificate.setCreateTime(request.getDate("createTime"));
            personnelService.updateCertificate(certificate);
            res.put("code",1);
            res.put("msg","editCert");
        }catch (NullPointerException e){
            res.put("code",0);
            res.put("msg","证书不存在");
        }
        System.out.println(res);
        return res;
    }
}
