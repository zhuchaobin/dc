package com.xai.tt.dc.client.request;

/**
 * Created by linkun on 2017/9/28.
 */
public abstract class PageQuery{

    /**
     * 默认页大小
     */
    public static final Integer DEFAULT_PAGE_SIZE = 15;

    /**
     * 默认页码
     */
    public static final Integer DEFAULT_PAGE_NO = 1;

    /**
     * 页
     */
    protected Integer pageNo = DEFAULT_PAGE_NO;

    /**
     * 页大小
     */
    protected Integer pageSize = DEFAULT_PAGE_SIZE;

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
}
