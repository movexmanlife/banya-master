package com.forezp.banya.binding;

import com.forezp.banya.MyApp;
import com.forezp.banya.R;
import com.forezp.banya.bean.LoadMoreData;
import com.forezp.banya.utils.VersionUtil;

/**
 *    private void bindItem() {
 switch (status) {
 case LOAD_MORE:
 progress.setVisibility(View.VISIBLE);
 tv_load_prompt.setText("正在加载...");
 itemView.setVisibility(View.VISIBLE);
 break;
 case LOAD_PULL_TO:
 progress.setVisibility(View.GONE);
 tv_load_prompt.setText("上拉加载更多");
 itemView.setVisibility(View.VISIBLE);
 break;
 case LOAD_NONE:
 System.out.println("LOAD_NONE----");
 progress.setVisibility(View.GONE);
 tv_load_prompt.setText("已无更多加载");
 itemView.setVisibility(View.VISIBLE);
 break;
 case LOAD_END:
 itemView.setVisibility(View.GONE);
 default:
 break;
 }
 }
 */
public class LoadMoreFooterBindUtil {
    public static final boolean isLoadProgress(LoadMoreData loadMoreData) {
        return loadMoreData.getLoadStatus() == LoadMoreData.LOAD_MORE;
    }

    public static final String getLoadMsg(LoadMoreData loadMoreData) {
        switch (loadMoreData.getLoadStatus()) {
            case LoadMoreData.LOAD_MORE:
                return "正在加载...";
            case LoadMoreData.LOAD_PULL_TO:
                return "上拉加载更多";
            case LoadMoreData.LOAD_NONE:
                return "已无更多加载";
            case LoadMoreData.LOAD_END:
                return "";
            default:
                break;
        }
        return "";
    }
}
