package com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.R;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.bean.BaseListResult;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.presenter.BaseLoadingPresenter;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.status.BaseListStatus;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view.OnRecyclerItemClickListener;
import com.example.admin.mvpdagger2rxjavaretrofit_2017_01_10_14_36.common.view.adapter.BaseHFAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2017/1/18 13:42 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2017/1/18 13:42 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public abstract class BaseListFragment<ITEM, DATA extends BaseListResult<ITEM>
        , P extends BaseLoadingPresenter<DATA>
        , HOLDER extends ViewHolder>
        extends BaseLoadingFragment<DATA, P>
        implements BaseListStatus<ITEM> {

    private RecyclerView mRcv;

    protected RecyclerView getRcv() {
        return mRcv;
    }

    public void setRcv(RecyclerView rcv) {
        mRcv = rcv;
    }

    private boolean mIsLoading, mHasMore = true, mIsLoadMore;

    private List<ITEM> mBaseList;
    private TextView mTvFooter;
    private View mItemFootView;

    public boolean isLoading() {
        return mIsLoading;
    }

    public void setLoading(boolean loading) {
        mIsLoading = loading;
    }

    public boolean isHasMore() {
        return mHasMore;
    }

    public void setHasMore(boolean hasMore) {
        mHasMore = hasMore;
    }

    public boolean isLoadMore() {
        return mIsLoadMore;
    }

    public void setLoadMore(boolean loadMore) {
        mIsLoadMore = loadMore;
    }

    public List<ITEM> getBaseList() {
        return mBaseList;
    }

    public TextView getTvFooter() {
        return mTvFooter;
    }

    public void setTvFooter(TextView tvFooter) {
        mTvFooter = tvFooter;
    }

    public View getItemFootView() {
        return mItemFootView;
    }

    public void setItemFootView(View itemFootView) {
        mItemFootView = itemFootView;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_recycler_list, container, false);
        mRcv = (RecyclerView) view.findViewById(R.id.rcv);
        return super.onCreateView(inflater, (ViewGroup) view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        setRecyclerViewManager(linearLayoutManager);
        mRcv.setHasFixedSize(true);
//        baseListAdapter = new BaseListAdapter();
//        setRecyclerViewAdapter(baseListAdapter);
        BaseHFAdapter baseHFAdapter = new BaseHFAdapter(new BaseListAdapter2());//能够添加头部尾部的适配器
        addFootView(baseHFAdapter);//添加尾部。
        setRecyclerViewAdapter(baseHFAdapter);//设置适配器
        setRcvScrollListener(getRcv());//设置滚动监听。
        addRcvItemTouchListener(baseHFAdapter, getRcv());//设置条目点击
    }

    private void addFootView(BaseHFAdapter baseHFAdapter) {
        mItemFootView = LayoutInflater.from(this.getActivity()).inflate(R.layout.item_loading, null);
        FrameLayout.LayoutParams lytp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        lytp.gravity = Gravity.CENTER;
        mItemFootView.setLayoutParams(lytp);
        mTvFooter = (TextView) mItemFootView.findViewById(R.id.progressTv);
        ImageView ivLoading = (ImageView) mItemFootView.findViewById(R.id.progressIv);
        AnimationDrawable loadingDrawable = (AnimationDrawable) ivLoading.getDrawable();
        loadingDrawable.start();
        setFooterClick();
        baseHFAdapter.addFootView(mItemFootView);
    }

    private void setRcvScrollListener(final RecyclerView rcv) {
        rcv.setOnScrollListener(new OnScrollListener() {
            private int lastVisibleItem;
            private int[] lastPositions;
            private int totalItemCount;
            private int visibleThreshold = 0;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LayoutManager layoutManager = rcv.getLayoutManager();
                if (layoutManager != null) {
                    if (layoutManager instanceof LinearLayoutManager) {
                        lastVisibleItem = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    } else if (layoutManager instanceof GridLayoutManager) {
                        lastVisibleItem = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                    } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                        if (lastPositions == null) {
                            lastPositions = new int[staggeredGridLayoutManager.getSpanCount()];
                        }
                        staggeredGridLayoutManager.findLastVisibleItemPositions(lastPositions);
                        lastVisibleItem = findMax(lastPositions);
                    } else {

                    }
                }

//                totalItemCount = layoutManager.getItemCount();//这个包括头部和尾部

                if (getBaseList() != null) {//这个不包括头部和尾部
                    totalItemCount = getBaseList().size();
                }

                if (!isLoading() && totalItemCount <= (lastVisibleItem + visibleThreshold) && isHasMore()) {
                    if (getBaseList() != null && getBaseList().size() > 0) {
                        setLoading(true);
                        setLoadMore(true);
                        loadMore(getBaseList().get(getBaseList().size() - 1));
                    }
                }
            }
        });
    }

    private void addRcvItemTouchListener(final BaseHFAdapter baseHFAdapter, final RecyclerView rcv) {
        rcv.addOnItemTouchListener(new OnRecyclerItemClickListener(rcv) {
            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }

            @Override
            public void onItemClick(ViewHolder vh) {
                //屏蔽头部和尾部点击
                if (baseHFAdapter.isHeaderViewPos(vh.getPosition())) {

                } else if (baseHFAdapter.isFooterViewPos(vh.getPosition())) {

                } else {
                    onItemClickListener(mBaseList.get(vh.getPosition()));
                }
            }

            @Override
            public void onItemLongClick(ViewHolder vh) {
                //屏蔽头部和尾部点击
                if (baseHFAdapter.isHeaderViewPos(vh.getPosition())) {

                } else if (baseHFAdapter.isFooterViewPos(vh.getPosition())) {

                } else {
                    onItemLongClickListener(mBaseList.get(vh.getPosition()));
                }
            }
        });
    }

    protected void onItemClickListener(ITEM item) {

//        ArrayList<ITEM> oldList = new ArrayList<>(mBaseList);
//        mBaseList.remove(item);
//        notifyData(mRcv.getAdapter(), oldList, mBaseList);
    }

    protected void onItemLongClickListener(ITEM item) {

    }

    protected void setRecyclerViewManager(LayoutManager layoutManager) {
        mRcv.setLayoutManager(layoutManager);
    }

    protected void setRecyclerViewAdapter(RecyclerView.Adapter adapter) {
        mRcv.setAdapter(adapter);
    }

    private int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    //    protected abstract View initItemView();
    protected abstract HOLDER createItemViewHolder(ViewGroup parent);

    protected abstract void bindItemViewHolder(HOLDER holder, ITEM item, int position);

    protected abstract void loadStartData();

    protected abstract void loadMoreData(ITEM item);

    public class BaseListAdapter2 extends RecyclerView.Adapter {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return createItemViewHolder(parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            ITEM item = mBaseList.get(position);
            bindItemViewHolder((HOLDER) holder, item, position);
        }

        @Override
        public int getItemCount() {
            return mBaseList == null ? 0 : mBaseList.size();
        }
    }

    protected void setFooterText(String text) {
        if (mTvFooter != null) {
            mTvFooter.setText(text);
        }
    }

    protected void setFooterText(@StringRes int text) {
        if (mTvFooter != null) {
            mTvFooter.setText(getString(text));
        }
    }

    protected void setFooterClick() {
        mItemFootView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mHasMore) {
                    return;
                }
//                if (getLastItem() == null) {
//                    loadData();
//                } else {
//                    loadMoreData(getLastItem());
//                }
                if (mIsLoadMore && getLastItem() != null) {
                    loadMore(getLastItem());
                } else {
                    loadData();
                }
            }
        });
    }

    protected void setFooterVisiable(int visibility) {
        mItemFootView.findViewById(R.id.item_loading).setVisibility(visibility);
    }

    protected void setFooterEnable(boolean enable) {
        mItemFootView.setEnabled(enable);
    }

    protected void setRefreshAble(boolean isRefresh) {
        if (mSrl != null) {
            mSrl.setEnabled(isRefresh);
        }
    }

    protected ITEM getLastItem() {
        return mBaseList != null && mBaseList.size() > 0 ? mBaseList.get(mBaseList.size() - 1) : null;
    }

    public int getBaseListSize() {
//        return mBaseHFAdapter == null ? 0 : mBaseHFAdapter.getItemCount();
        return mBaseList == null ? 0 : mBaseList.size();
    }

    public void initBaseList() {
        mBaseList = new ArrayList<>();
    }

    public void setBaseList(List<ITEM> baseList) {
        mBaseList = baseList;
    }

    @Override
    public void loadData() {
//        super.loadData();//不能调用父类的

        Log.e(" loadData "," loadData " );
//        mBaseList = new ArrayList<>();
//        mBaseHFAdapter.notifyDataSetChanged();

        setLoadMore(false);

        if (!getSrl().isRefreshing()) {
            getSrl().setRefreshing(true);
        }
        loadStartData();
        hasMore();
        startLoad();
    }

    @Override
    public void startLoad() {
//        super.startLoad();
        setFooterVisiable(View.VISIBLE);
        setFooterEnable(false);
    }

    @Override
    public void noMore() {
        setHasMore(false);
        setFooterText("没有更多。。。");
        setFooterEnable(false);
    }

    @Override
    public void hasMore() {
        setHasMore(true);
        setFooterText("加载中。。。");
        setFooterEnable(false);
    }

    @Override
    public void error(String msg) {
        if (!isLoadMore()) {
            super.error(msg);
            setFooterVisiable(View.GONE);
        }
        setFooterText("加载错误，点击重试。。。");
        setFooterEnable(true);
    }

    @Override
    public void failure(int code, String msg) {
        if (!isLoadMore()) {
            super.failure(code, msg);
            setFooterVisiable(View.GONE);
        }
        setFooterText("加载失败， 点击重试。。。");
        setFooterEnable(true);
    }

    @Override
    public void loadMore(ITEM lastItem) {
        setFooterText("加载更多，加载中。。。");
        setFooterEnable(false);
        if (lastItem == null) {
            loadData();
            Log.e(" loadData 加载更多，"," loadData 加载更多，" );
        } else {
            loadMoreData(lastItem);
        }
    }

    @Override
    public void complete() {
        super.complete();
        setLoading(false);
        getSrl().setRefreshing(false);
//        setFooterText("没有更多");
//        setFooterEnable(false);
    }

    @Override
    public void success(DATA data) {
        super.success(data);

        getSrl().setRefreshing(false);
        if (data == null) {
            noMore();
        } else {
            List<ITEM> list = data.getList();
            if (isLoadMore()) {
                getListMoreData(list);
            } else {
                getListData(list);
            }

            getRcv().getAdapter().notifyDataSetChanged();
        }
//        notifyData(mRcv.getAdapter(), oldList, mBaseList);

    }

    protected void notifyData(RecyclerView.Adapter mAdapter, List<ITEM> mDatas, List<ITEM> newDatas) {

//        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffCallBack(mDatas, newDatas), true);
//
//        diffResult.dispatchUpdatesTo(mAdapter);

        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void getListData(List<ITEM> list) {
        setBaseList(list);
        if (getBaseList() == null || getBaseList().size() == 0) {
            empty();
        }
    }

    @Override
    public void getListMoreData(List<ITEM> list) {

        if (list == null || list.size() == 0) {
            noMore();
        } else {
            getBaseList().addAll(list);
        }
    }

    @Override
    public void reLoad() {
        super.reLoad();
        loadData();
    }

    @Override
    public void empty() {
        super.empty();
        setFooterText("");
        setFooterVisiable(View.GONE);
    }

    @Override
    public void loading() {
//        super.loading();
    }

}
