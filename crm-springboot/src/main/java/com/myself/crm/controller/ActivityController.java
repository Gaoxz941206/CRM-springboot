package com.myself.crm.controller;

import com.github.pagehelper.PageInfo;
import com.myself.crm.model.Activity;
import com.myself.crm.model.User;
import com.myself.crm.service.ActivityService;
import com.myself.crm.vo.ActivityPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-11-25 09:32
 * @apiNote
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {

    @Autowired(required = false)
    private ActivityService activityService;

    @RequestMapping("/add")
    @ResponseBody
    public Boolean addActivity(Activity activity, HttpSession session){
        User user = (User)session.getAttribute("user");
        return activityService.addActivity(activity,user.getId()) == 1;
    }

    @RequestMapping("/pageQuery")
    @ResponseBody
    public PageInfo<Activity> pageQuery(ActivityPage activityPage){
        return activityService.selectAllByPage(activityPage);
    }
}
