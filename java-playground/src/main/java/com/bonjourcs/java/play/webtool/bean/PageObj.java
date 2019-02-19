package com.bonjourcs.java.play.webtool.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Liang Chenghao
 * Description: web page object
 * Date: 2019/2/19
 */
@Data
public class PageObj<T> implements Serializable {

    /**
     * default page index
     */
    public static int DEFAULT_PAGE = 1;

    /**
     * default items per page
     */
    public static int DEFAULT_SIZE = 10;

    /**
     * items per page
     */
    private List<T> items;

    /**
     * current page
     */
    private int page;

    /**
     * current size
     */
    private int size;

    /**
     * total items
     */
    private int totalItems;

    /**
     * total pages
     */
    private int totalPages;


    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private PageObj pageObj;

        public Builder() {
            pageObj = new PageObj();
        }

        public Builder page(int page) {
            pageObj.setPage(page);
            return this;
        }

        public Builder size(int size) {
            pageObj.setSize(size);
            return this;
        }

        public Builder totalItems(int totalItems) {
            pageObj.setTotalItems(totalItems);
            return this;
        }

        public <T> Builder items(List<T> list) {
            pageObj.setItems(list);
            return this;
        }

        public PageObj build() {
            return pageObj;
        }

    }


    private PageObj() {
    }

    public int getSize() {
        return this.size <= 0 ? DEFAULT_SIZE : this.size;
    }

    public int getPage() {
        return this.page <= 0 ? DEFAULT_PAGE : this.page;
    }

    public int getTotalItems() {
        return this.totalItems < 0 ? 0 : this.totalItems;
    }

    public int getTotalPages() {
        if (this.totalItems <= 0) {
            return 0;
        } else {
            return getTotalItems() % getSize() == 0 ?
                    this.getTotalItems() / getSize() :
                    this.getTotalItems() / getSize() + 1;
        }
    }

}
