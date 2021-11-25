package com.myself.crm.service;

import com.myself.crm.model.Activity;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-11-25 10:26
 * @apiNote
 */
public interface ActivityService {
    int addActivity(Activity activity, String createBy);
}
