package com.example.week.fragment;

import android.graphics.Color;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.week.R;
import com.example.week.adapter.LanGeAdapter;
import com.example.week.adapter.LanGetowAdapter;
import com.example.week.adapter.MyAdapter;
import com.example.week.adapter.MyTowAdapter;
import com.example.week.base.BaseFragment;
import com.example.week.contract.HomeContract;
import com.example.week.data.ItemBean;
import com.example.week.presenter.HomePresenter;
import com.example.week.utils.URLConstant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.IHomeView {


    @BindView(R.id.home_Recycler)
    RecyclerView homeRecycler;
    private ArrayList<ItemBean.DataDTO.BannerDTO> banner;
    private ArrayList<ItemBean.DataDTO.ChannelDTO> channel;
    private LanGeAdapter lanGeAdapter;
    private LanGetowAdapter lanGetowAdapter;
    private MyTowAdapter myTowAdapter;
    private DelegateAdapter adapter;

    @Override
    protected void initData() {
        presenter.Home(URLConstant.NEWLIST);
    }

    @Override
    protected void initView() {
        banner = new ArrayList<>();
        channel = new ArrayList<>();

        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getContext());
        //设置回收复用线程池大小
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        homeRecycler.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 15);
        //通栏
        MyAdapter myAdapter = initTongLan();
        lanGeAdapter = initLanGe();
        lanGetowAdapter = initChannel();
        myTowAdapter = initGoodslist();
        initBrandlist();

        adapter = new DelegateAdapter(layoutManager, true);
        adapter.addAdapter(myAdapter);
        adapter.addAdapter(lanGeAdapter);
        adapter.addAdapter(lanGetowAdapter);
        homeRecycler.setLayoutManager(layoutManager);
        homeRecycler.setAdapter(adapter);
    }

    private void initBrandlist() {
        
    }

    private MyTowAdapter initGoodslist() {
        /**
         TODO 设置通栏布局
         */
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(0, 50, 0, 0);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        singleLayoutHelper.setMargin(20, 80, 20, 0);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        MyTowAdapter myTowAdapter = new MyTowAdapter(singleLayoutHelper);
        return myTowAdapter;
    }

    private LanGetowAdapter initChannel() {
        /**
         TODO 设置栏格布局
         */
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        // 创建对象

        // 公共属性
        columnLayoutHelper.setItemCount(channel.size());// 设置布局里Item个数
        columnLayoutHelper.setPadding(20, 50, 20, 0);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        columnLayoutHelper.setMargin(0, 0, 0, 0);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        columnLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        columnLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比

        // columnLayoutHelper特有属性
//        columnLayoutHelper.setWeights(new float[]{100});// 设置该行每个Item占该行总宽度的比例
        // 同上面Weigths属性讲解
        LanGetowAdapter getowAdapter = new LanGetowAdapter(columnLayoutHelper, channel);
        return getowAdapter;
    }

    private LanGeAdapter initLanGe() {
        /**
          TODO 设置栏格布局
         */
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        // 创建对象

        // 公共属性
        columnLayoutHelper.setItemCount(1);// 设置布局里Item个数
//        columnLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        columnLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        columnLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        columnLayoutHelper.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比

        // columnLayoutHelper特有属性
//        columnLayoutHelper.setWeights(new float[]{100});// 设置该行每个Item占该行总宽度的比例
        // 同上面Weigths属性讲解
        LanGeAdapter geAdapter = new LanGeAdapter(columnLayoutHelper, banner);
        return geAdapter;
    }

    private MyAdapter initTongLan() {
        /**
          TODO 设置通栏布局
         */
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(3);// 设置布局里Item个数
        //singleLayoutHelper.setPadding(0, 0, 0, 0);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        singleLayoutHelper.setMargin(50, 50, 50, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        MyAdapter myAdapter = new MyAdapter(singleLayoutHelper);
        return myAdapter;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    public HomePresenter getPresenter() {
        return new HomePresenter();
    }

    @Override
    public <T> void HomeRelt(T t) {
        ItemBean bean = (ItemBean) t;
        if (bean!=null){
            List<ItemBean.DataDTO.BannerDTO> banner = bean.getData().getBanner();
            List<ItemBean.DataDTO.ChannelDTO> channel = bean.getData().getChannel();
            this.banner.clear();
            this.banner.addAll(banner);
            lanGeAdapter.notifyDataSetChanged();
            this.channel.clear();
            this.channel.addAll(channel);
            lanGetowAdapter.notifyDataSetChanged();
        }
        adapter.addAdapter(myTowAdapter);
    }

    @Override
    public void tips(String string) {
        Log.e("TAG", "tips: " + string);
    }
}