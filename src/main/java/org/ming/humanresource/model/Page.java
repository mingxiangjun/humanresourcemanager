package org.ming.humanresource.model;

import java.util.List;

/**
 * 分页器
 * @author acer
 * @create 2017-12-10 11:58
 */
public class Page {
    private int pageSize=10;
    private int currentPageNo=1;
    private int totalPage;
    private int totalRows;
    private List infoList;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List getInfoList() {
        return infoList;
    }

    public void setInfoList(List infoList) {
        this.infoList = infoList;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }
}
