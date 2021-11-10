package org.poseibon.common.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 简单分页类
 *
 * @author qingchuan
 * @date 2020/5/13
 */
public class Pagination<T> extends SimplePagination {
    /**
     * 总数量
     */
    protected long totalCount = 0;
    /**
     * 当前页的数据
     */
    private List<T> dataList;
    /**
     * 扩展数据map
     */
    private Map<String, Object> extData = new HashMap<>();

    public Pagination(){}

    public long getTotalCount() {
        return totalCount;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public Map<String, Object> getExtData() {
        return extData;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public void setExtData(Map<String, Object> extData) {
        this.extData = extData;
    }

    /**
     * 扩展数据
     *
     * @param key  值
     * @param data 数据
     */
    public void extend(String key, Object data) {
        this.extData.put(key, data);
    }

    /**
     * 构造器
     *
     * @param pageNo   页码
     * @param pageSize 每页几条数据
     */
    public Pagination(int pageNo, int pageSize) {
        setPageSize(pageSize);
        setPageNo(pageNo);
    }

    /**
     * 构造器
     *
     * @param pageNo     页码
     * @param pageSize   每页几条数据
     * @param totalCount 总共几条数据
     */
    public Pagination(int pageNo, int pageSize, long totalCount) {
        setTotalCount(totalCount);
        setPageSize(pageSize);
        setPageNo(pageNo);
    }

    /**
     * 构造器
     *
     * @param pageNo     页码
     * @param pageSize   每页几条数据
     * @param totalCount 总共几条数据
     */
    public Pagination(int pageNo, int pageSize, long totalCount, List<T> dataList) {
        setTotalCount(totalCount);
        setPageSize(pageSize);
        setPageNo(pageNo);
        this.dataList = dataList;
    }

    /**
     * 总共几页
     *
     * @return 总页数
     */
    public long getTotalPage() {
        long totalPage = totalCount / pageSize;
        if (totalPage == 0 || totalCount % pageSize != 0) {
            totalPage++;
        }
        return totalPage;
    }

    /**
     * 是否第一页
     *
     * @return true为第一页
     */
    public boolean isFirstPage() {
        return pageNo <= 1;
    }

    /**
     * 是否最后一页
     *
     * @return true 为最后一页
     */
    public boolean isLastPage() {
        return pageNo >= getTotalPage();
    }

    /**
     * 是否有下一页
     *
     * @return true 为最后一页
     */
    public boolean hasNext() {
        if (totalCount <= 0) {
            return false;
        }
        return pageNo < getTotalPage();
    }

    /**
     * 是否有下一页
     *
     * @return true 为最后一页
     */
    public void next() {
        pageNo += 1;
    }

    /**
     * 下一页页码
     *
     * @return 下一页页码
     */
    public int getNextPage() {
        if (isLastPage()) {
            return pageNo;
        } else {
            return pageNo + 1;
        }
    }

    /**
     * 上一页页码
     *
     * @return 上一页页码
     */
    public int getPrePage() {
        if (isFirstPage()) {
            return pageNo;
        } else {
            return pageNo - 1;
        }
    }

    /**
     * 设置总数
     *
     * @param totalCount 总数量
     */
    public void setTotalCount(long totalCount) {
        if (totalCount < 0) {
            this.totalCount = 0;
        } else {
            this.totalCount = totalCount;
        }
    }

    /**
     * 获取偏移量
     *
     * @return 偏移量
     */
    public int getOffset() {
        return (pageNo - 1) * this.pageSize;
    }
}
