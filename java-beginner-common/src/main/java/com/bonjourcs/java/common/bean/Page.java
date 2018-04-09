package com.bonjourcs.java.common.bean;

import java.util.List;

/**
 * @author Liang Chenghao
 * Description: pagination class
 * Date: 2018/4/9
 */
public class Page<T> {

    /**
     * data list
     */
    private List<T> data;
    /**
     * current page number
     */
    private int page;
    /**
     * element count for each page
     */
    private int size;
    /**
     * total items
     */
    private int totalItems;
    /**
     * total page count
     */
    private int totalPages;

    public Page() {
    }

    /**
     * init paging object
     *
     * @param page       parameter page
     * @param size       parameter size
     * @param totalItems parameter total items
     * @return this
     */
    public Page<T> init(int page, int size, int totalItems) {
        this.page = page;
        this.size = size;
        this.totalItems = totalItems;
        return this;
    }

    /**
     * set paging data
     *
     * @param data data list
     * @return this
     */
    public Page<T> setData(List<T> data) {
        this.data = data;
        return this;
    }

    public List<T> getData() {
        return data;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public int getTotalPages() {
        return totalItems % size == 0 ? totalItems / size : totalItems / size + 1;
    }

    @Override
    public String toString() {
        return "Page{" +
                "data=" + data +
                ", page=" + page +
                ", size=" + size +
                ", totalItems=" + totalItems +
                ", totalPages=" + totalPages +
                '}';
    }

}
