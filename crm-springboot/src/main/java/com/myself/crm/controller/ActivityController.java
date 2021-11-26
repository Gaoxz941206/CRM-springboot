package com.myself.crm.controller;

import com.github.pagehelper.PageInfo;
import com.myself.crm.model.Activity;
import com.myself.crm.model.User;
import com.myself.crm.service.ActivityService;
import com.myself.crm.vo.ActivityPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

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

    //添加市场活动
    @RequestMapping("/add")
    @ResponseBody
    public Boolean addActivity(Activity activity, HttpSession session){
        User user = (User)session.getAttribute("user");
        return activityService.addActivity(activity,user.getId()) == 1;
    }

    //条件分页查询
    @RequestMapping("/pageQuery")
    @ResponseBody
    public PageInfo<Activity> pageQuery(ActivityPage activityPage){
        return activityService.selectAllByPage(activityPage);
    }

    //跳转至详情页
    @RequestMapping("/to/detail/{id}")
    public String toDetail(@PathVariable("id") String id, Model model){
        model.addAttribute("act",activityService.selectByIdToName(id));
        return "workbench/activity/detail";
    }

    //跳转至修改页
    @RequestMapping("/to/update")
    @ResponseBody
    public Map<Object, Object> toUpdate(String id){
        return activityService.toEdit(id);
    }

    //跳转至修改页
    @RequestMapping("/update")
    @ResponseBody
    public int update(Activity activity, HttpSession session){
        String editBy = ((User)session.getAttribute("user")).getId();
        return activityService.updateActivity(activity,editBy);
    }
}
