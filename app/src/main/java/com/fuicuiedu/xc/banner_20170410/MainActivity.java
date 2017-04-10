package com.fuicuiedu.xc.banner_20170410;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private TextView title;//显示图片标题
    private List<ImageView> imageViews;//图片的集合
    private List<View> dots;//圆点的集合

    //存放图片id
    private int[] imageIds = new int[]{
        R.drawable.gwx,
            R.drawable.lc,
            R.drawable.ljx,
            R.drawable.tz,
            R.drawable.xll,
    };

    //存放图片的标题
    private String[] titles = new String[]{
        "我是郭文鑫",
        "我是黎超",
        "我是陆建鑫",
        "我是汤志",
        "我是小磊磊"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.vp);

        imageViews = new ArrayList<>();
        for (int i = 0; i < imageIds.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);
            imageViews.add(imageView);
        }

        dots = new ArrayList<>();
        dots.add(findViewById(R.id.dot_0));
        dots.add(findViewById(R.id.dot_1));
        dots.add(findViewById(R.id.dot_2));
        dots.add(findViewById(R.id.dot_3));
        dots.add(findViewById(R.id.dot_4));

        title = (TextView) findViewById(R.id.my_title);
        title.setText(titles[0]);

        adapter = new ViewPagerAdapter();
        viewPager.setAdapter(adapter);

// TODO: 2017/4/10 0010 1.完成标题和圆点的改变
// TODO: 2017/4/10 0010 2.实现自动轮播

    }

    private class ViewPagerAdapter extends PagerAdapter{
        //获取当前窗体数量
        @Override
        public int getCount() {
            return imageIds.length;
        }
        //判断是否由对象生成界面
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        //return一个对象，这个对象表明适配器选择哪个对象放在当前的界面中
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViews.get(position));
            return imageViews.get(position);
        }

        //是从ViewGroup移除当前的view
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViews.get(position));
        }
    }
}
