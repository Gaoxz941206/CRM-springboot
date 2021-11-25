package com.myself.crm.util;

import java.util.UUID;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-11-25 10:39
 * @apiNote
 */
public class UUid {
    //生成UUid
    public static String Get_UUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
