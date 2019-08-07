package com.zeropoint.homemaking.controllers.client;

import com.alibaba.fastjson.JSONObject;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zeropoint.homemaking.constant.Constant;
import com.zeropoint.homemaking.domain.Certificate;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.domain.Speciality;
import com.zeropoint.homemaking.services.PersonnelService;

import com.zeropoint.homemaking.utils.ConvertUtil;
import com.zeropoint.homemaking.utils.HttpUtils;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/api")
public class PersonnelController {

    @Autowired
    PersonnelService personnelService;

    @Value("${file.uploadFolder}")
    private String uploadFolder;
    /**  阿姨列表
     * @param cond  城市
     * @return 阿姨列表
     */
    @RequestMapping("/personnelList")
    public JSONObject getList(@RequestBody Map<String,Object> cond){
        JSONObject res=new JSONObject();
        res.put("code",1);
        res.put("msg","list");
        cond.put("status",2);
        System.out.println(cond.toString());
        res.put("data",personnelService.getList(cond));
        return res;
    }

    /**
     *  筛选阿姨
     * @param cond 筛选条件
     *             0普通会员 1阿姨审核中 2阿姨审核通过  3审核失败 -1黑名单
     * @return 阿姨列表
     */
    @RequestMapping("/filterPersonnel")
    public JSONObject query(@RequestBody Map<String,Object> cond){
        int pageCount=(int)cond.get("pagination");
        PageHelper.startPage(pageCount,8);
        System.out.println(cond.toString());
        PageInfo<ServicePersonnel> personnelPageInfo = new PageInfo<>(personnelService.getList(cond));
        JSONObject res=new JSONObject();
        cond.put("status",2);
        if(personnelPageInfo.getPages() >=pageCount )
        {
            res.put("code", 1);
            res.put("msg", "filter");

            List<ServicePersonnel> list = personnelPageInfo.getList();
            res.put("data", list);
        }
        else{
            res.put("code",1);
            res.put("msg","there are not more thing");
            res.put("data",null);
        }
        System.out.println(res.toJSONString());
        return res;
    }

    /**
     *  阿姨详情
     * @param request {id,token}
     * @return 返回值
     * realname:'',			//真实姓名
     * 	idcard:'',			//身份证号码
     * 	age:'',				//年龄
     * 	nativeCity: '',			//籍贯
     * 	workCity: '',			//工作地址
     * 	special: [],			//特长
     * 	experience: 0,			//工作经验
     * 	sex:'',				//1男2女
     * 	type:1,				//工作类型  1月嫂 2保姆 3钟点工
     * 	status:0,			//1 普通会员 2阿姨审核中 3阿姨审核通过 -1黑名单（假值）
     * 	selfIntro:'',			//自我介绍
     * 	videoSrc:'',			//自我介绍的短视频
     *
     */
    @RequestMapping("/personnelInfo")
    public JSONObject personnelInfo(@RequestBody JSONObject request){
        JSONObject res = new JSONObject();
        Integer userId=request.getInteger("user_id");
        String token =request.getString("token");
        try
        {
            ServicePersonnel personnel = personnelService.findByUserId(userId);
            List<String> specialities =personnelService.getSpecialityId(personnel.getId());
             if(specialities !=null)
             {
                personnel.setSpecialities(specialities);
             }
            List<String> certificates =personnelService.getCertificateId(personnel.getId());
            if(certificates !=null)
            {
                personnel.setCertificates(certificates);
            }
            res.put("data",personnel);
            res.put("code",1);
            res.put("msg","personnelInfo");
        }catch (NullPointerException e)
        {
            res.put("code",0);
            res.put("msg","阿姨信息——用户不存在");

        }
        System.out.println(res.toJSONString());
        return  res;
    }

    /**
     *  修改阿姨信息
     * @param request  {userId,token}
     * @return 返回值
     *  age:'',				//年龄
     *  nativeCity: '',			//籍贯
     *  workCity: '',			//工作地址
     *  special: [],			//特长
     *  experience: 0,			//工作经验
     *  sex:'',				//1男2女
     *  type:1,
     */

    @RequestMapping("/editPersonnel")
    public JSONObject editPersonnel(@RequestBody JSONObject request){
        JSONObject res =new JSONObject();
        Integer userId=request.getInteger("user_id");
        String token =request.getString("token");
        try
        {
            ServicePersonnel personnel = personnelService.findByUserId(userId);
            personnel.setAge(request.getInteger("age"));
            personnel.setNativePlace(request.getString("nativePlace"));
            personnel.setWorkCity(request.getString("workCity"));
            personnel.setWorkExperience(request.getInteger("workExperience"));
            personnel.setGender(request.getInteger("gender"));
            personnel.setWorkType(request.getInteger("workType"));
            if( personnel.getWorkType()==1)
            {
                personnel.setSchedule(request.getInteger("schedule"));
            }
            personnelService.update(personnel);
            Integer personnelId=personnel.getId();
            ArrayList<Integer>  list=(ArrayList<Integer>) request.get("specialities");
            Integer[] specialities=list.toArray(new Integer[list.size()]);
            personnelService.updateSpeciality(specialities,personnelId);
            res.put("data",personnel);
            res.put("code",1);
            res.put("msg","editPersonnel");
        }catch (NullPointerException e)
        {
            e.printStackTrace();
            res.put("code",0);
            res.put("msg","用户不存在");

        }
        System.out.println(res.toJSONString());
        return  res;
    }
    @RequestMapping("/uploadAvatar")
    public JSONObject uploadAvatar(HttpServletRequest req, @RequestParam("file") MultipartFile file)throws IOException
    {

        Integer userId= Integer.parseInt(req.getParameter("id"));
        String token =req.getParameter("token");
        System.out.println(userId);
        ServicePersonnel personnel= personnelService.findByUserId(userId);
        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
        String format = sdf.format(new Date());
        String realPath = uploadFolder + format;
        System.out.println(realPath);
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder,newName));
        String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/" + format + newName;
        personnel.setPhotoUrl(url);
        personnelService.update(personnel);


        JSONObject res =new JSONObject();
        res.put("code",1);
        res.put("msg","avatarUrl");
        res.put("data",url);
        System.out.println(url);
        System.out.println(res.toJSONString());
        return  res;
    }
    @RequestMapping("/uploadInfo")
    public JSONObject uploadVide(HttpServletRequest req, @RequestParam("videoSrc") MultipartFile file)throws IOException
    {

        Integer userId= Integer.parseInt(req.getParameter("user_id"));
        String token =req.getParameter("token");
        String profile =req.getParameter("selfIntro");
        ServicePersonnel personnel= personnelService.findByUserId(userId);
        personnel.setProfile(profile);
        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
        String format = sdf.format(new Date());
        String realPath = uploadFolder + format;
        System.out.println(realPath);
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder,newName));
        String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/" + format + newName;
        personnel.setVideoUrl(url);
        personnelService.update(personnel);
        System.out.println(url);
        JSONObject res =new JSONObject();
        res.put("code",1);
        res.put("msg","uploadVideo");
        res.put("data",personnel);
        System.out.println(res.toJSONString());
        return  res;
    }

    @RequestMapping("/uploadSelf")
    public JSONObject uploadSelf(@RequestBody JSONObject request){
        Integer userId= Integer.parseInt(request.getString("user_id"));
        String token =request.getString("token");
        String profile =request.getString("selfIntro");
        ServicePersonnel personnel= personnelService.findByUserId(userId);
        personnel.setProfile(profile);
        personnelService.update(personnel);
        JSONObject res =new JSONObject();
        res.put("code",1);
        res.put("msg","uploadVideo");
        res.put("data",personnel);
        return res;
    }
    @RequestMapping("/submitAudit")
    public JSONObject submitAudit(@RequestBody JSONObject request){
        JSONObject res=new JSONObject();
        Integer userId=request.getInteger("id");
       try {
           ServicePersonnel personnel =personnelService.findByUserId(userId);
           personnel.setStatus(1);
           personnelService.update(personnel);
           res.put("code",1);
           res.put("msg","提交审核完成");
           res.put("data",personnel);
       }catch (NullPointerException e)
       {
           res.put("code",0);
           res.put("msg","用户不存在");
       }
        System.out.println(res);
        return res;
    }

    /**
     *
     * @param request id, token, realname, idcard
     * @return
     */
    @RequestMapping("/identify")
    public JSONObject identify(@RequestBody JSONObject request){
        JSONObject res =new JSONObject();
        System.out.println(request.toJSONString());
        Integer id =request.getInteger("id");
        String  realName=request.getString("realname");
        String  cardNo=request.getString("idcard");
        String host = "http://aliyunverifyidcard.haoservice.com";
        String path = "/idcard/VerifyIdcardv2";
        String method = "GET";
        String appcode = Constant.APP_CODE;
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("cardNo", cardNo);
        querys.put("realName", realName);
        ServicePersonnel personnel =personnelService.findByUserId(request.getInteger("id"));
        try {

           HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response.toString());
            //获取response的body
            JSONObject data=JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
            System.out.println(data.toJSONString());
            JSONObject result =(JSONObject)data.get("result");
            JSONObject IdCardInfor = (JSONObject) result.get("IdCardInfor");
            res.put("code",1);
            res.put("msg",data.getString("reason"));
            if("成功".equals(data.getString("reason")))
            {
                personnel.setIdcard(result.getString("idcard"));
                personnel.setRealName(result.getString("realname"));
                personnel.setNativePlace(ConvertUtil.addressStrConvert(IdCardInfor.getString("area")));
                personnelService.update(personnel);
            }
            res.put("data",result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(res.toJSONString());
        return res;
    }

}
