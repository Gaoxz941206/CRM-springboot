package com.myself.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-11-24 10:39
 * @apiNote
 */
@Controller
public class WorkbenchController {

    @RequestMapping("/to/workbench/index")
    public String toWorkBenchIndex(){
        return "workbench/index";
    }

    @RequestMapping("/to/workbench/main/index")
    public String toWorkBenchMainIndex(){
        return "workbench/main/index";
    }

    @RequestMapping("/to/workbench/activity/index")
    public String toWorkBenchActivityIndex(){
        return "workbench/activity/index";
    }

    @RequestMapping("/tto/workbench/clue/index")
    public String toWorkBenchClueIndex(){
        return "workbench/clue/index";
    }

    @RequestMapping("/to/workbench/customer/index")
    public String toWorkBenchCustomerIndex(){
        return "workbench/customer/index";
    }

    @RequestMapping("/to/workbench/contacts/index")
    public String toWorkBenchContactsIndex(){
        return "workbench/contacts/index";
    }

    @RequestMapping("/to/workbench/transaction/index")
    public String toWorkBenchTransactionIndex(){
        return "workbench/transaction/index";
    }
    @RequestMapping("/to/workbench/visit/index")
    public String toWorkBenchVisitIndex(){
        return "workbench/visit/index";
    }
}
