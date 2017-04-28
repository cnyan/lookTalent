package com.yan.utils;

/**
 * Created by 闫继龙 on 2017/4/26.
 *
 */
public class PageSizeUtil {

    private int pageIndex;
    private int pageSize;

    public PageSizeUtil() {
    }

    public PageSizeUtil(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageSizeUtil{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                '}';
    }
}
