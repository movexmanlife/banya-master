package com.forezp.banya.bean;

import com.forezp.banya.bean.top250.Avatars;

/**
 * 上拉加载更多数据模型
 */
public class LoadMoreData {
    public static final int LOAD_MORE = 0;
    public static final int LOAD_PULL_TO = 1;
    public static final int LOAD_NONE = 2;
    public static final int LOAD_END = 3;
    private int loadStatus = LOAD_END;

    public LoadMoreData(int loadStatus) {
        this.loadStatus = loadStatus;
    }

    public int getLoadStatus() {
        return loadStatus;
    }

    public void setLoadStatus(int loadStatus) {
        this.loadStatus = loadStatus;
    }
}
