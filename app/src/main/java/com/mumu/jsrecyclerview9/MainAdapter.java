package com.mumu.jsrecyclerview9;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author : zlf
 * date    : 2019/11/7
 * github  : https://github.com/mamumu
 * blog    : https://www.jianshu.com/u/281e9668a5a6
 * desc    :
 */
public class MainAdapter extends BaseMultiItemQuickAdapter<AnimalEntity.RestbodyBean, BaseViewHolder> {

    public MainAdapter(List<AnimalEntity.RestbodyBean> data) {
        super(data);
        addItemType(1, R.layout.title);
        addItemType(2, R.layout.content);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, AnimalEntity.RestbodyBean item) {
        switch (helper.getItemViewType()) {
            case 1:
                helper.setText(R.id.tv_title1, item.getTitle1());
                helper.setText(R.id.tv_title2, item.getTitle2());
                break;
            case 2:
                helper.setText(R.id.tv_content1, item.getName1());
                helper.setText(R.id.tv_content2, item.getName2());
                break;
        }
    }
}
