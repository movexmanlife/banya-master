package com.forezp.banya.viewimpl.film;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forezp.banya.R;
import com.forezp.banya.adapter.MyViewpagerAdapter;
import com.forezp.banya.base.BaseFragment;
import com.forezp.banya.utils.ThemeUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by forezp on 16/8/13.
 */
public class FilmFragment extends BaseFragment implements ViewPager.OnPageChangeListener {

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.appbarlayout)
    AppBarLayout appbarlayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.coordinatorlayout)
    CoordinatorLayout coordinatorlayout;
    @BindArray(R.array.tab_film)
    String[] mTitles;
    @BindColor(R.color.text_gray_6)
    int mTabTextColor;

    private List<Fragment> mFragments;
    private FilmLiveFragment filmLiveFragment;
    private FilmTop250Fragment filmTop250Fragment;
    private MyViewpagerAdapter mViewPagerAdapter;

    public static FilmFragment newInstance() {
        Bundle args = new Bundle();
        FilmFragment fragment = new FilmFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public boolean hasMultiFragment() {
        return true;
    }

    @Override
    protected String setFragmentName() {
        return "首页－Fragment";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_film, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {
        mFragments = new ArrayList<>();
        filmLiveFragment = FilmLiveFragment.newInstance();
        filmTop250Fragment = FilmTop250Fragment.newInstance();
        mFragments.add(filmLiveFragment);
        mFragments.add(filmTop250Fragment);


        mViewPagerAdapter = new MyViewpagerAdapter(getChildFragmentManager(), mTitles, mFragments);
        viewpager.setAdapter(mViewPagerAdapter);
        viewpager.setOffscreenPageLimit(3);
        viewpager.addOnPageChangeListener(this);

        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        tablayout.setSelectedTabIndicatorColor(ThemeUtils.getThemeColor());
        tablayout.setTabTextColors(mTabTextColor, ThemeUtils.getThemeColor());
        // 将TabLayout和ViewPager进行关联，让两者联动起来
        tablayout.setupWithViewPager(viewpager);
        // 设置Tablayout的Tab显示ViewPager的适配器中的getPageTitle函数获取到的标题
        tablayout.setTabsFromPagerAdapter(mViewPagerAdapter);


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


}
