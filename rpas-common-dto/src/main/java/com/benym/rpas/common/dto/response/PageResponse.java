package com.benym.rpas.common.dto.response;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @date 2022/7/7 7:53 下午
 */
public class PageResponse<T> {

    private static final long serialVersionUID = 1L;

    private int totalCount = 0;

    private int pageIndex = 1;

    private int pageSize = 1;

    private Collection<T> list;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageIndex() {
        if (pageIndex < 1) {
            return 1;
        }
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        if (pageIndex < 1) {
            this.pageIndex = 1;
        } else {
            this.pageIndex = pageIndex;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        if (null == list) {
            return Collections.emptyList();
        }
        if (list instanceof List) {
            return (List<T>) list;
        }
        return new ArrayList<>(list);
    }

    public void setList(Collection<T> data) {
        this.list = data;
    }

    public boolean isEmpty() {
        return list == null || list.isEmpty();
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }
}
