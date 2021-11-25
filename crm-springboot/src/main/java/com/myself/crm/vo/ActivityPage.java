package com.myself.crm.vo;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-11-25 15:59
 * @apiNote
 */
public class ActivityPage {
    private Integer pageNo;
    private Integer pageSize;
    private String queryName;
    private String queryOwner;
    private String queryStartDate;
    private String queryEndDate;

    public ActivityPage() {
    }

    public ActivityPage(Integer pageNo, Integer pageSize, String queryName, String queryOwner, String queryStartDate, String queryEndDate) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.queryName = queryName;
        this.queryOwner = queryOwner;
        this.queryStartDate = queryStartDate;
        this.queryEndDate = queryEndDate;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public String getQueryOwner() {
        return queryOwner;
    }

    public void setQueryOwner(String queryOwner) {
        this.queryOwner = queryOwner;
    }

    public String getQueryStartDate() {
        return queryStartDate;
    }

    public void setQueryStartDate(String queryStartDate) {
        this.queryStartDate = queryStartDate;
    }

    public String getQueryEndDate() {
        return queryEndDate;
    }

    public void setQueryEndDate(String queryEndDate) {
        this.queryEndDate = queryEndDate;
    }
}
