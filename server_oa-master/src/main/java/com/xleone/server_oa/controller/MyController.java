package com.xleone.server_oa.controller;
import com.xleone.server_oa.bean.*;
import com.xleone.server_oa.mapper.MainMapper;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class MyController {
    @Resource
    MainMapper mainMapper;
    @ResponseBody         //返回jason数据
    @RequestMapping("/news")             //标记请求地址
    public Map<String, List<NewsEntity>> getAllNews() {
        Map<String, List<NewsEntity>> map = new HashMap<>();
        map.put("news", mainMapper.getAllNews());
        return map;
    }
    @ResponseBody
    @RequestMapping("/inform")
    public Inform getAnno()
    {
        Map<String, List<AnnoEntity>> map = new HashMap<>();
        //map.put("announcement", mainMapper.getAnno());
        Map<String, List<NoticeEntity>> map1 = new HashMap<>();
        //map1.put("notice", mainMapper.getNotice());
        Inform inform = new Inform();
        inform.setAnnouncement(mainMapper.getAnno());
        inform.setNotice(mainMapper.getNotice());
        return inform;
    }
    @ResponseBody
    @RequestMapping("/notice")
    public Map<String, List<NoticeEntity>> getNotice()
    {
        Map<String, List<NoticeEntity>> map = new HashMap<>();
        map.put("notice", mainMapper.getNotice());
        return map;
    }
    @ResponseBody
    @RequestMapping("/schedule")
    public Map<String, List<ScheEntity>> getSche(@RequestParam String type,@RequestParam String user_id)
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());
        Map<String, List<ScheEntity>> map = new HashMap<>();
        if(type.equals("new")){
            map.put("schedule", mainMapper.getNewSche(date,user_id));
        }else if(type.equals("tom")){
            map.put("schedule", mainMapper.getTomSche(date,user_id));
        }else if(type.equals("old")){
            map.put("schedule", mainMapper.getOldSche(date,user_id));
        }
        return map;
    }
    @ResponseBody
    @RequestMapping(value ="login",produces="application/json;charset=UTF-8")
    public ResultBean login(HttpServletRequest request, HttpServletResponse response)
    {
        String user_name=request.getParameter("user_id");
        String user_pass=request.getParameter("user_pass");
        response.addHeader( "Access-Control-Allow-Origin", "*" );
        ResultBean resultBean = new ResultBean();
        admin a=new admin();
        a.setUser_name(user_name);
        a.setUser_pass(user_pass);
        admin n = mainMapper.login(a);
        //System.out.println(n);
        if(n!=null){
            resultBean.setResultCode(101);
            resultBean.setUserEntity(a);
        }else {
            resultBean.setResultCode(102);
            resultBean.setUserEntity(null);
        }
        return resultBean;
    }
}
