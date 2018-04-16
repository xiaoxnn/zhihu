package com.demo.zhihu.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.demo.zhihu.R;
import com.demo.zhihu.adapter.BookListAdapter;
import com.demo.zhihu.bean.HomeBean;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by xnn on 2018/4/15.
 */

public class HomeFragment extends  BaseFragment implements SwipeRefreshLayout.OnRefreshListener {


    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private GridLayoutManager mLayoutManager;
    private  BookListAdapter mListAdapter;
    public static HomeFragment newInstance(String title) {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    protected void initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.home_fragment, container, false);
        mRecyclerView=   mRootView.findViewById(R.id.recyclerView);
        mSwipeRefreshLayout= mRootView.findViewById(R.id.swipe_refresh_widget);
    }

    @Override
    protected void initData(boolean isSavedNull) {
           String  title=getArguments().getString("title");
        mSwipeRefreshLayout.setColorSchemeResources(R.color.recycler_color1, R.color.recycler_color2,
                R.color.recycler_color3, R.color.recycler_color4);

        //设置布局管理器
        mLayoutManager = new GridLayoutManager(getActivity(), 1);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //设置adapter
        mListAdapter = new BookListAdapter(getActivity());
        mRecyclerView.setAdapter(mListAdapter);

        //设置Item增加、移除动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mSwipeRefreshLayout.setOnRefreshListener(this);

        getdata();
    }

    @Override
    public void onRefresh() {
          this.getdata();
    }

    public void getdata(){
        OkHttpUtils
                .post()
                .url("http://118.25.37.196:8080/evergreen/book/list?")
                .addParams("page", "1")
                .addParams("size", "20")
                .build()
                .execute(callback);
    }

    StringCallback  callback=new StringCallback() {
        @Override
        public void onError(Call call, Exception e, int id) {
            Log.i("test","e"+e.toString());
        }

        @Override
        public void onResponse(String response, int id) {
               HomeBean homeBean=new Gson().fromJson(response, HomeBean.class);
               mListAdapter.setData(homeBean.getData());
               mListAdapter.notifyDataSetChanged();
               mSwipeRefreshLayout.setRefreshing(false);
        }
    };
}
