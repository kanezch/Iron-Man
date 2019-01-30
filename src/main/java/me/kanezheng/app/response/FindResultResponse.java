package me.kanezheng.app.response;

import me.kanezheng.app.model.MicroService;

import java.util.List;

/**
 * Created by
 *
 * @author kane
 * @date 2018/8/19
 */
public class FindResultResponse {
    int totalCount;
    int totalPageNum;
    int pageSize;
    int pageNum;
    List<MicroService> resultSet;

    public FindResultResponse() {
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {

        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<MicroService> getResultSet() {
        return resultSet;
    }

    public void setResultSet(List<MicroService> resultSet) {
        this.resultSet = resultSet;
    }
}
