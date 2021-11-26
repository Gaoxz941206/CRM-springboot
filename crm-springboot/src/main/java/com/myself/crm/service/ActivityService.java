package com.myself.crm.service;

import com.github.pagehelper.PageInfo;
import com.myself.crm.model.Activity;
import com.myself.crm.vo.ActivityPage;

import java.util.Map;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-11-25 10:26
 * @apiNote
 */
public interface ActivityService {
    int addActivity(Activity activity, String createBy);

    PageInfo<Activity> selectAllByPage(ActivityPage activityPage);

    Activity selectByIdToName(String id);

    Map<Object,Object> toEdit(String id);

    int updateActivity(Activity activity,String editBy);
}
