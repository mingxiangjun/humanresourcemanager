package org.ming.humanresource.common.model;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * 分页器
 *
 * @author acer
 * @create 2017-12-10 11:58
 */
public class Page {
    private static Logger logger = Logger.getLogger(Page.class);
    private int pageSize = 10;
    private int currentPageNo = 1;
    private int totalPage;
    private int totalRows = 0;
    private int startIndex;
    private int endIndex;
    private List infoList;

    /**
     * 初始化分页器：
     *  生成当前pageNo起始Index、
     * @param totalRows 记录总数
     */
    public void init(int totalRows) {
        if (totalRows == 0) {
            logger.error("Page初始化失败，未设置totalRows");
            return;
        }
        this.totalRows = totalRows;
        totalPage = totalRows % pageSize > 0 ? totalRows / pageSize + 1 : totalRows / pageSize;
        init();
    }
    public void init(){
        //分页
        if (currentPageNo > 1) {
            startIndex = (currentPageNo - 1) * pageSize;
            endIndex = startIndex + pageSize;
        }
    }

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

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}
