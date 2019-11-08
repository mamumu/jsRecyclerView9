package com.mumu.jsrecyclerview9;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.oushangfeng.pinnedsectionitemdecoration.PinnedHeaderItemDecoration;
import com.oushangfeng.pinnedsectionitemdecoration.callback.OnHeaderClickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import per.goweii.actionbarex.common.ActionBarCommon;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.abc_main)
    ActionBarCommon abcMain;
    @BindView(R.id.rv_main)
    RecyclerView rvMain;
    @BindView(R.id.srl_main)
    SmartRefreshLayout srlMain;

    private MainAdapter mainAdapter;
    private List<AnimalEntity.RestbodyBean> data;
    private PinnedHeaderItemDecoration mHeaderItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        initData();
        refreshView();
        smartRefreshView();
    }

    private void initData() {
        data = new ArrayList<>();
        data.add(new AnimalEntity.RestbodyBean(1, "动物1", "1", "小狗", "小猫"));
        for (int i = 1; i <= 12; i++) {
            data.add(new AnimalEntity.RestbodyBean(2, "动物" + i, String.valueOf(i), "小狗" + i, "小猫" + i));
        }
        data.add(new AnimalEntity.RestbodyBean(1, "动物1", "1", "小狗", "小猫"));
        for (int i = 1; i <= 16; i++) {
            data.add(new AnimalEntity.RestbodyBean(2, "动物" + i, String.valueOf(i), "小狗" + i, "小猫" + i));
        }
    }

    private void refreshView() {
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        mainAdapter = new MainAdapter(data);
        rvMain.setAdapter(mainAdapter);

        OnHeaderClickAdapter clickAdapter = new OnHeaderClickAdapter() {

            @Override
            public void onHeaderClick(View view, int id, int position) {
                switch (id) {
                    case R.id.tv_title1:
                        // case OnItemTouchListener.HEADER_ID:
                        Toast.makeText(MainActivity.this, "click, tag: " + mainAdapter.getData().get(position).getTitle1(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tv_title2:
                        Toast.makeText(MainActivity.this, "click " + mainAdapter.getData().get(position).getTitle2() + "'s more button", Toast.LENGTH_SHORT)
                                .show();
                        break;
                }
            }

        };
        mHeaderItemDecoration = new PinnedHeaderItemDecoration.Builder(1).setDividerId(R.drawable.divider).enableDivider(true)
                .setClickIds(R.id.tv_title1, R.id.tv_title2).disableHeaderClick(false).setHeaderClickListener(clickAdapter).create();
        rvMain.addItemDecoration(mHeaderItemDecoration);


    }

    private void smartRefreshView() {
        srlMain.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //下拉刷新,一般添加调用接口获取数据的方法
                srlMain.finishLoadMore();
                data.clear();
                initData();
                mainAdapter.setNewData(data);
                srlMain.finishRefresh();
            }

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                srlMain.finishRefresh();
                //上拉加载，一般添加调用接口获取更多数据的方法
                data.add(new AnimalEntity.RestbodyBean(1, "动物2", "2", "小狗", "小猫"));
                for (int i = 2; i <= 22; i++) {
                    data.add(new AnimalEntity.RestbodyBean(2, "动物" + i, String.valueOf(i), "小狗" + i, "小猫" + i));
                }
                data.add(new AnimalEntity.RestbodyBean(1, "动物2", "2", "小狗", "小猫"));
                for (int i = 2; i <= 25; i++) {
                    data.add(new AnimalEntity.RestbodyBean(2, "动物" + i, String.valueOf(i), "小狗" + i, "小猫" + i));
                }
                data.add(new AnimalEntity.RestbodyBean(1, "动物2", "2", "小狗", "小猫"));
                for (int i = 2; i <= 22; i++) {
                    data.add(new AnimalEntity.RestbodyBean(2, "动物" + i, String.valueOf(i), "小狗" + i, "小猫" + i));
                }
                mainAdapter.setNewData(data);
                srlMain.finishLoadMore();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
