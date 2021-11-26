package com.myself.crm.mapper;

import com.myself.crm.model.Activity;
import com.myself.crm.vo.ActivityPage;

import java.util.List;

public interface ActivityMapper {
    int deleteByPrimaryKey(String id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

    List<Activity> selectAllByPage(ActivityPage activityPage);

    Activity selectByIdToName(String id);
}