package com.example.cusnavtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyViewPager index_vp_fragment_list_top;
    private ImageView index_bottom_bar_home_image;
    private LinearLayout index_bottom_bar_home;
    private ImageView index_bottom_bar_dynamic_state_image;
    private LinearLayout index_bottom_bar_dynamic_state;
    private ImageView index_bottom_bar_integral_image;
    private LinearLayout index_bottom_bar_integral;
    private ImageView index_bottom_bar_me_image;
    private LinearLayout index_bottom_bar_me;
    private FrameLayout index_fl_bottom_bar;
    private ImageView index_bottom_bar_scan;
    private RelativeLayout index_rl_contain;
    private List<Fragment> mFragments;
    private FragmentIndexAdapter mFragmentIndexAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvent();
    }

    private void initEvent() {
        index_bottom_bar_home.setOnClickListener(new TabOnClickListener(0));
        index_bottom_bar_dynamic_state.setOnClickListener(new TabOnClickListener(1));
        index_bottom_bar_integral.setOnClickListener(new TabOnClickListener(2));
        index_bottom_bar_me.setOnClickListener(new TabOnClickListener(3));
        index_bottom_bar_scan.setOnClickListener(new TabOnClickListener(4));
    }

    private void initIndexFragmentAdapter() {
        mFragmentIndexAdapter = new FragmentIndexAdapter(this.getSupportFragmentManager(), mFragments);
        index_vp_fragment_list_top.setAdapter(mFragmentIndexAdapter);
        index_bottom_bar_home.setSelected(true);
        index_vp_fragment_list_top.setCurrentItem(0);
        index_vp_fragment_list_top.setOffscreenPageLimit(3);
        index_vp_fragment_list_top.addOnPageChangeListener(new TabOnPageChangeListener());
    }

    private void initData() {
        mFragments = new ArrayList<Fragment>();
        mFragments.add(ExampleFragment.newInstance(getResources().getString(R.string.index_bottom_bar_home)));
        mFragments.add(ExampleFragment.newInstance(getResources().getString(R.string.index_bottom_bar_dynamic_state)));
        mFragments.add(ExampleFragment.newInstance(getResources().getString(R.string.index_bottom_bar_integral)));
        mFragments.add(ExampleFragment.newInstance(getResources().getString(R.string.index_bottom_bar_me)));
        mFragments.add(ExampleFragment.newInstance(getResources().getString(R.string.index_bottom_bar_scan)));
        initIndexFragmentAdapter();
    }

    private void initView() {
        index_vp_fragment_list_top = findViewById(R.id.index_vp_fragment_list_top);
        index_bottom_bar_home_image = findViewById(R.id.index_bottom_bar_home_image);
        index_bottom_bar_home = findViewById(R.id.index_bottom_bar_home);
        index_bottom_bar_dynamic_state_image = findViewById(R.id.index_bottom_bar_dynamic_state_image);
        index_bottom_bar_dynamic_state = findViewById(R.id.index_bottom_bar_dynamic_state);
        index_bottom_bar_integral_image = findViewById(R.id.index_bottom_bar_integral_image);
        index_bottom_bar_integral = findViewById(R.id.index_bottom_bar_integral);
        index_bottom_bar_me_image = findViewById(R.id.index_bottom_bar_me_image);
        index_bottom_bar_me = findViewById(R.id.index_bottom_bar_me);
        index_fl_bottom_bar = findViewById(R.id.index_fl_bottom_bar);
        index_bottom_bar_scan = findViewById(R.id.index_bottom_bar_scan);
        index_rl_contain = findViewById(R.id.index_rl_contain);
    }

    /**
     * Bottom_Bar 的點擊事件
     */
    public class TabOnClickListener implements View.OnClickListener {

        private int index = 0;

        public TabOnClickListener(int i) {
            index = i;
        }

        public void onClick(View v) {
            index_vp_fragment_list_top.setCurrentItem(index, false);

//            if (index == 4) {
//                // 跳轉到 Scan 頁面
//                Toast.makeText(MainActivity.this, "點擊了掃描按鈕", Toast.LENGTH_SHORT).show();
//            } else {
//                // 選擇某一項
//                index_vp_fragment_list_top.setCurrentItem(index, false);
//            }
        }

    }

    public class TabOnPageChangeListener implements ViewPager.OnPageChangeListener {

        // 當滑動狀態改變時調用
        public void onPageScrollStateChanged(int state) {
        }

        // 當前頁面被滑動時調用
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        // 當新的頁面被選中時調用
        public void onPageSelected(int position) {
            resetTextView();
            switch (position) {
                case 0:
                    index_bottom_bar_home.setSelected(true);
                    break;
                case 1:
                    index_bottom_bar_dynamic_state.setSelected(true);
                    break;
                case 2:
                    index_bottom_bar_integral.setSelected(true);
                    break;
                case 3:
                    index_bottom_bar_me.setSelected(true);
                    break;
                case 4:
                    index_bottom_bar_scan.setSelected(true);
                    break;
            }
        }
    }

    /**
     * 重置所有 TextView 的字體顏色
     */
    private void resetTextView() {
        index_bottom_bar_home.setSelected(false);
        index_bottom_bar_dynamic_state.setSelected(false);
        index_bottom_bar_integral.setSelected(false);
        index_bottom_bar_me.setSelected(false);
    }
}
