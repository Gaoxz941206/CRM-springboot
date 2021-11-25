package com.myself.crm.service;

import com.github.pagehelper.PageInfo;
import com.myself.crm.model.Activity;
import com.myself.crm.vo.ActivityPage;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-11-25 10:26
 * @apiNote
 */
public interface ActivityService {
    int addActivity(Activity activity, String createBy);

    PageInfo<Activity> selectAllByPage(ActivityPage activityPage);
}
