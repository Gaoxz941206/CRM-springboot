package com.myself.crm.service.impl;

import com.myself.crm.mapper.ActivityMapper;
import com.myself.crm.model.Activity;
import com.myself.crm.service.ActivityService;
import com.myself.crm.util.DateTimeUtil;
import com.myself.crm.util.UUid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-11-25 10:26
 * @apiNote
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired(required = false)
    private ActivityMapper activityMapper;

    @Override
    public int addActivity(Activity activity, String createBy) {
        activity.setId(UUid.Get_UUID());
        activity.setCreateBy(createBy);
        activity.setCreateTime(DateTimeUtil.CURRENT_TIME());
        return activityMapper.insertSelective(activity);
    }
}