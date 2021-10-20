package com.example.pojo;

import java.util.List;

public class Page<T> {
    public static final Integer PAGE_SIZE = 4;
    private Integer pageNo;
    //總共有幾頁
    private Integer dataTotalCount;
    private Integer pageSize = PAGE_SIZE;
    //紀錄總共有幾筆資料
    private Integer pageCount;
    // 目前頁面儲存數據
    private List<T> items;

    public Page() {
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", dataTotalCount=" + dataTotalCount +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", items=" + items +
                '}';
    }

    public static Integer getPageSize() {
        return PAGE_SIZE;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getDataTotalCount() {
        return dataTotalCount;
    }

    public void setDataTotalCount(Integer dataTotalCount) {
        this.dataTotalCount = dataTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
