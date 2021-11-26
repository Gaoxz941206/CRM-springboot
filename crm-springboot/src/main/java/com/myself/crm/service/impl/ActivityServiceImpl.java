package com.myself.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myself.crm.mapper.ActivityMapper;
import com.myself.crm.mapper.UserMapper;
import com.myself.crm.model.Activity;
import com.myself.crm.model.User;
import com.myself.crm.service.ActivityService;
import com.myself.crm.util.DateTimeUtil;
import com.myself.crm.util.UUid;
import com.myself.crm.vo.ActivityPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-11-25 10:26
 * @apiNote
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired(required = false)
    private ActivityMapper activityMapper;

    @Autowired(required = false)
    private UserMapper userMapper;

    //添加市场活动
    @Override
    public int addActivity(Activity activity, String createBy) {
        activity.setId(UUid.Get_UUID());
        activity.setCreateBy(createBy);
        activity.setCreateTime(DateTimeUtil.CURRENT_TIME());
        return activityMapper.insertSelective(activity);
    }

    //分页条件查询
    @Override
    public PageInfo<Activity> selectAllByPage(ActivityPage activityPage) {
        PageHelper.startPage(activityPage.getPageNo(),activityPage.getPageSize());
        List<Activity> list = activityMapper.selectAllByPage(activityPage);
        return new PageInfo<>(list);
    }

    //根据市场活动id查询(将owner、createBy、editBy转成姓名)
    @Override
    public Activity selectByIdToName(String id) {
        Activity activity = activityMapper.selectByIdToName(id);
        return activityMapper.selectByIdToName(id);
    }

    //跳转至修改市场活动页面之前，根据市场活动id查询、查询user列表
    @Override
    public Map<Object,Object> toEdit(String id) {
        Map<Object,Object> map = new HashMap<>();
        List<User> list = userMapper.selectAll();
        Activity activity = activityMapper.selectByPrimaryKey(id);
        map.put("list",list);
        map.put("act",activity);
        return map;
    }

    @Override
    public int updateActivity(Activity activity,String editBy) {
        activity.setEditBy(editBy);
        activity.setEditTime(DateTimeUtil.CURRENT_TIME());
        return activityMapper.updateByPrimaryKeySelective(activity);
    }
}
