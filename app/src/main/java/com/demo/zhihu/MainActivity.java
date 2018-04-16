package com.demo.zhihu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.demo.zhihu.activity.BaseActivity;
import com.demo.zhihu.fragment.BaseFragment;
import com.demo.zhihu.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private MyAdapter mAdapter;
    private TabLayout mTableLayout;
    private ViewPager mViewPager;
    private List<BaseFragment> fragments;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mTableLayout= findViewById(R.id.tabLayout);
         mViewPager= findViewById(R.id.viewPager);

        initdata();
    }

    private void initdata() {
        fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance("新书"));
        fragments.add(HomeFragment.newInstance("热门"));
        fragments.add(HomeFragment.newInstance("推荐"));
        fragments.add(HomeFragment.newInstance("分类"));
        mAdapter = new MyAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(mAdapter);
        mTableLayout.setupWithViewPager(mViewPager);
        mTableLayout.setTabMode(TabLayout.MODE_FIXED);
        mViewPager.setOffscreenPageLimit(2);
    }


    public class MyAdapter extends FragmentPagerAdapter {

        private List<BaseFragment> mFragments;
        private String[] mTitle = new String[]{"新书","热门","推荐","分类"};
        public MyAdapter(FragmentManager fm,List<BaseFragment> fragments) {
            super(fm);
            this.mFragments=fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return  mTitle[position];
        }
    }
}
