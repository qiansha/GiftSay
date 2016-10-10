package com.lanou3g.giltsay.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.utils.ListViewReFlashHelper;

/**
 * Created by dllo on 16/9/28.
 */
public class ReFlashListView extends ListView implements AbsListView.OnScrollListener{
//    View header;   // 顶部布局文件
//    int headerHeight;  // 顶部布局文件的高度
//    int firstVisibleItem; // 当前界面第一个可见item的位置
//    int scrollState;   // 当前滚动状态
//    boolean isRemark;  //  标记 当前实在ListView最顶端按下的
//    int startY;   // 向下拉的距离Y
//    int state;   // 当前的状态
//    final int NONE = 0;// 正常状态
//    final int PULL = 1;//下拉状态
//    final int RELESE = 2; // 松开可以刷新状态
//    final int REFLASHING = 3; // 正在刷新状态
//    IReflashListener iReflashListener; // 刷新数据的接口
//
//    public ReFlashListView(Context context) {
//        super(context);
//        initView(context);
//    }
//
//    public ReFlashListView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        initView(context);
//    }
//
//    public ReFlashListView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        initView(context);
//    }
//
//    // 绑定头布局
//    private void initView(Context context) {
//    inflater = LayoutInflater.from(context);
//    footer = inflater.inflate(R.layout.listview_footer, null);
//    loadFull = (TextView) footer.findViewById(R.id.loadFull);
//    noData = (TextView) footer.findViewById(R.id.noData);
//    more = (TextView) footer.findViewById(R.id.more);
//    loading = (ProgressBar) footer.findViewById(R.id.loading);
//        LayoutInflater inflater = LayoutInflater.from(context);
//        header = inflater.inflate(R.layout.reflash_heaher_layout, null);
//        measureView(header);
//        headerHeight = header.getMeasuredHeight();
//        topPadding(-headerHeight);
//        this.addHeaderView(header);
//        this.addFooterView(footer);
//        this.setOnScrollListener(this);
//    }
//
//    // 通知父布局我占了多大地方
//    private void measureView(View view) {
//        ViewGroup.LayoutParams params = view.getLayoutParams();
//        if (params == null) {
//            params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        }
//        int width = ViewGroup.getChildMeasureSpec(0, 0, params.width);
//        int height;
//        int tempHeight = params.height;
//        if (tempHeight > 0) {
//            height = MeasureSpec.makeMeasureSpec(tempHeight, MeasureSpec.EXACTLY);
//        } else {
//            height = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
//        }
//        view.measure(width, height);
//    }
//
//    private void topPadding(int topPadding) {
//        header.setPadding(header.getPaddingLeft(), topPadding, header.getPaddingRight(), header.getPaddingBottom());
//        header.invalidate();
//    }
//
//    @Override
//    public void onScrollStateChanged(AbsListView view, int scrollState) {
//        this.scrollState = scrollState;
//        Log.d("ReFlashListView", "scrollState" + scrollState);
//    }
//
//    @Override
//    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//        this.firstVisibleItem = firstVisibleItem;
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:// 按下鼠标时触发
//                Log.d("kkk", "Down");
//                if (firstVisibleItem == 0) {
//                    isRemark = true;
//                    startY = (int) ev.getY();
//                }
//                break;
//            case MotionEvent.ACTION_MOVE:
////                Log.d("kkk", "Move");
//                onMove(ev);
//                break;
//            case MotionEvent.ACTION_UP:   // 抬起鼠标时触发
////                Log.d("kkk", "???这是什么时候出发的?");
//                if (state == RELESE) {
//                    state = REFLASHING;
//                    // 加载最新数据
//                    reflashViewByState();
//                    iReflashListener.onReflash();
//
//                } else if (state == PULL) {
//                    state = NONE;
//                    isRemark = false;
//                    reflashViewByState();
//                }
//                break;
//        }
//        return super.onTouchEvent(ev);
//    }
//
//    /**
//     * 判断移动过程中的操作
//     */
//    private void onMove(MotionEvent ev) {
//        if (!isRemark) {
//            return;
//        }
//        int tempY = (int) ev.getY();
//        int space = tempY - startY;
//        int topPadding = space - headerHeight;
//        switch (state) {
//            case NONE:
//                if (space > 0) {
//                    state = PULL;
//                    reflashViewByState();
//                }
//                break;
//            case PULL:
//                topPadding(topPadding);
//                if (space > headerHeight + 40 && scrollState == SCROLL_STATE_TOUCH_SCROLL) {
//                    state = RELESE;
//                    reflashViewByState();
//                }
//                break;
//            case RELESE:
//                topPadding(topPadding);
//                if (space < headerHeight + 40) {
//                    state = PULL;
//                    reflashViewByState();
//                } else if (space <= 0) {
//                    state = NONE;
//                    isRemark = false;
//                    reflashViewByState();
//                }
//                break;
//            case REFLASHING:
//                break;
//        }
//    }
//
//    private void reflashViewByState() {
//        TextView tip = (TextView) header.findViewById(R.id.tip);
//        ImageView arrow = (ImageView) header.findViewById(R.id.arrow);
//        ProgressBar progress = (ProgressBar) header.findViewById(R.id.progress);
//        RotateAnimation anim1 = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        RotateAnimation anim2 = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        anim1.setDuration(500);
//        anim2.setDuration(500);
//        anim1.setFillAfter(true);
//        anim2.setFillAfter(true);
//        switch (state) {
//            case NONE:
//                topPadding(-headerHeight);
//                arrow.clearAnimation();
//                break;
//            case PULL:
//                arrow.setVisibility(View.VISIBLE);
//                progress.setVisibility(View.GONE);
//                tip.setText("下拉可以刷新");
//                arrow.clearAnimation();
//                arrow.setAnimation(anim2);
//                break;
//            case RELESE:
//                arrow.setVisibility(View.VISIBLE);
//                progress.setVisibility(View.GONE);
//                tip.setText("松开可以刷新");
//                arrow.clearAnimation();
//                arrow.setAnimation(anim1);
//                break;
//            case REFLASHING:
//                topPadding(50);
//                arrow.setVisibility(View.GONE);
//                progress.setVisibility(View.VISIBLE);
//                tip.setText("正在刷新...");
//                arrow.clearAnimation();
//                break;
//        }
//    }
//
//    // 获取完数据
//    public void reflshComplete() {
//        state = NONE;
//        isRemark = false;
//        reflashViewByState();
////        TextView lastupdateTime = (TextView) header.findViewById(R.id.lastupdate_time);
////        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");
////        Date date = new Date(System.currentTimeMillis());
////        String time = format.format(date);
////        lastupdateTime.setText(time);
//    }
//
//    public void setInterface(IReflashListener iReflashListener) {
//        this.iReflashListener = iReflashListener;
//    }
//
//    /**
//     * 刷新数据接口
//     */
//    public interface IReflashListener {
//        void onReflash();
//    }






// 区分当前操作是刷新还是加载
public static final int REFRESH = 0;
    public static final int LOAD = 1;

    // 区分PULL和RELEASE的距离的大小
    private static final int SPACE = 20;

    // 定义header的四种状态和当前状态
    private static final int NONE = 0;
    private static final int PULL = 1;
    private static final int RELEASE = 2;
    private static final int REFRESHING = 3;
    private int state;

    private LayoutInflater inflater;
    private View header;
    private View footer;
    private TextView tip;
//    private TextView lastUpdate;
    private ImageView arrow;
    private ProgressBar refreshing;

    private TextView noData;
    private TextView loadFull;
    private TextView more;
    private ProgressBar loading;

    private RotateAnimation animation;
    private RotateAnimation reverseAnimation;

    private int startY;

    private int firstVisibleItem;
    private int scrollState;
    private int headerContentInitialHeight;
    private int headerContentHeight;

    // 只有在listview第一个item显示的时候（listview滑到了顶部）才进行下拉刷新， 否则此时的下拉只是滑动listview
    private boolean isRecorded;
    private boolean isLoading;// 判断是否正在加载
    private boolean loadEnable = true;// 开启或者关闭加载更多功能
    private boolean isLoadFull;
    private int pageSize = 10;

    private OnRefreshListener onRefreshListener;
    private OnLoadListener onLoadListener;

    public ReFlashListView(Context context) {
        super(context);
        initView(context);
    }

    public ReFlashListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ReFlashListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    // 下拉刷新监听
    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.onRefreshListener = onRefreshListener;
    }

    // 加载更多监听
    public void setOnLoadListener(OnLoadListener onLoadListener) {
        this.loadEnable = true;
        this.onLoadListener = onLoadListener;
    }

    public boolean isLoadEnable() {
        return loadEnable;
    }

    // 这里的开启或者关闭加载更多，并不支持动态调整
    public void setLoadEnable(boolean loadEnable) {
        this.loadEnable = loadEnable;
        this.removeFooterView(footer);
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    // 初始化组件
    private void initView(Context context) {

        // 设置箭头特效
        animation = new RotateAnimation(0, -180,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animation.setInterpolator(new LinearInterpolator());
        animation.setDuration(100);
        animation.setFillAfter(true);

        reverseAnimation = new RotateAnimation(-180, 0,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        reverseAnimation.setInterpolator(new LinearInterpolator());
        reverseAnimation.setDuration(100);
        reverseAnimation.setFillAfter(true);

        inflater = LayoutInflater.from(context);
        footer = inflater.inflate(R.layout.listview_footer, null);
        loadFull = (TextView) footer.findViewById(R.id.loadFull);
        noData = (TextView) footer.findViewById(R.id.noData);
        more = (TextView) footer.findViewById(R.id.more);
        loading = (ProgressBar) footer.findViewById(R.id.loading);

        header = inflater.inflate(R.layout.pull_to_refresh_header, null);
        arrow = (ImageView) header.findViewById(R.id.arrow);
        tip = (TextView) header.findViewById(R.id.tip);
//        lastUpdate = (TextView) header.findViewById(R.id.lastUpdate);
        refreshing = (ProgressBar) header.findViewById(R.id.refreshing);

        // 为listview添加头部和尾部，并进行初始化
        headerContentInitialHeight = header.getPaddingTop();
        measureView(header);
        headerContentHeight = header.getMeasuredHeight();
        topPadding(-headerContentHeight);
        this.addHeaderView(header);
        this.addFooterView(footer);
        this.setOnScrollListener(this);
    }

    public void onRefresh() {
        if (onRefreshListener != null) {
            onRefreshListener.onRefresh();
        }
    }

    public void onLoad() {
        if (onLoadListener != null) {
            onLoadListener.onLoad();
        }
    }

    public void onRefreshComplete(String updateTime) {
//        lastUpdate.setText(this.getContext().getString(R.string.lastUpdateTime,
//                lastUpdate));
        state = NONE;
        refreshHeaderViewByState();
    }

    // 用于下拉刷新结束后的回调
    public void onRefreshComplete() {
        String currentTime = ListViewReFlashHelper.getCurrentTime();
        onRefreshComplete(currentTime);
    }

    // 用于加载更多结束后的回调
    public void onLoadComplete() {
        isLoading = false;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        this.firstVisibleItem = firstVisibleItem;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        this.scrollState = scrollState;
        ifNeedLoad(view, scrollState);
    }

    // 根据listview滑动的状态判断是否需要加载更多
    private void ifNeedLoad(AbsListView view, int scrollState) {
        if (!loadEnable) {
            return;
        }
        try {
            if (scrollState == OnScrollListener.SCROLL_STATE_IDLE
                    && !isLoading
                    && view.getLastVisiblePosition() == view
                    .getPositionForView(footer) && !isLoadFull) {
                onLoad();
                isLoading = true;
            }
        } catch (Exception e) {
        }
    }

    /**
     * 监听触摸事件，解读手势
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (firstVisibleItem == 0) {
                    isRecorded = true;
                    startY = (int) ev.getY();
                }
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                if (state == PULL) {
                    state = NONE;
                    refreshHeaderViewByState();
                } else if (state == RELEASE) {
                    state = REFRESHING;
                    refreshHeaderViewByState();
                    onRefresh();
                }
                isRecorded = false;
                break;
            case MotionEvent.ACTION_MOVE:
                whenMove(ev);
                break;
        }
        return super.onTouchEvent(ev);
    }

    // 解读手势，刷新header状态
    private void whenMove(MotionEvent ev) {
        if (!isRecorded) {
            return;
        }
        int tmpY = (int) ev.getY();
        int space = tmpY - startY;
        int topPadding = space - headerContentHeight;
        switch (state) {
            case NONE:
                if (space > 0) {
                    state = PULL;
                    refreshHeaderViewByState();
                }
                break;
            case PULL:
                topPadding(topPadding);
                if (scrollState == SCROLL_STATE_TOUCH_SCROLL
                        && space > headerContentHeight + SPACE) {
                    state = RELEASE;
                    refreshHeaderViewByState();
                }
                break;
            case RELEASE:
                topPadding(topPadding);
                if (space > 0 && space < headerContentHeight + SPACE) {
                    state = PULL;
                    refreshHeaderViewByState();
                } else if (space <= 0) {
                    state = NONE;
                    refreshHeaderViewByState();
                }
                break;
        }

    }

    // 调整header的大小。其实调整的只是距离顶部的高度。
    private void topPadding(int topPadding) {
        header.setPadding(header.getPaddingLeft(), topPadding,
                header.getPaddingRight(), header.getPaddingBottom());
        header.invalidate();
    }

    /**
     * 这个方法是根据结果的大小来决定footer显示的。
     * <p>
     * 这里假定每次请求的条数为10。如果请求到了10条。则认为还有数据。如过结果不足10条，则认为数据已经全部加载，这时footer显示已经全部加载
     * </p>
     *
     * @param resultSize
     */
    public void setResultSize(int resultSize) {
        if (resultSize == 0) {
            isLoadFull = true;
            loadFull.setVisibility(View.GONE);
            loading.setVisibility(View.GONE);
            more.setVisibility(View.GONE);
            noData.setVisibility(View.VISIBLE);
        } else if (resultSize > 0 && resultSize < pageSize) {
            isLoadFull = true;
            loadFull.setVisibility(View.VISIBLE);
            loading.setVisibility(View.GONE);
            more.setVisibility(View.GONE);
            noData.setVisibility(View.GONE);
        } else if (resultSize == pageSize) {
            isLoadFull = false;
            loadFull.setVisibility(View.GONE);
            loading.setVisibility(View.VISIBLE);
            more.setVisibility(View.VISIBLE);
            noData.setVisibility(View.GONE);
        }

    }

    // 根据当前状态，调整header
    private void refreshHeaderViewByState() {
        switch (state) {
            case NONE:
                topPadding(-headerContentHeight);
                tip.setText(R.string.pull_to_refresh);
                refreshing.setVisibility(View.GONE);
                arrow.clearAnimation();
                arrow.setImageResource(R.mipmap.pull_to_refresh_arrow);
                break;
            case PULL:
                arrow.setVisibility(View.VISIBLE);
                tip.setVisibility(View.VISIBLE);
//                lastUpdate.setVisibility(View.VISIBLE);
                refreshing.setVisibility(View.GONE);
                tip.setText(R.string.pull_to_refresh);
                arrow.clearAnimation();
                arrow.setAnimation(reverseAnimation);
                break;
            case RELEASE:
                arrow.setVisibility(View.VISIBLE);
                tip.setVisibility(View.VISIBLE);
//                lastUpdate.setVisibility(View.VISIBLE);
                refreshing.setVisibility(View.GONE);
                tip.setText(R.string.pull_to_refresh);
                tip.setText(R.string.release_to_refresh);
                arrow.clearAnimation();
                arrow.setAnimation(animation);
                break;
            case REFRESHING:
                topPadding(headerContentInitialHeight);
                refreshing.setVisibility(View.VISIBLE);
                arrow.clearAnimation();
                arrow.setVisibility(View.GONE);
                tip.setVisibility(View.GONE);
//                lastUpdate.setVisibility(View.GONE);
                break;
        }
    }

    // 用来计算header大小的。比较隐晦。
    private void measureView(View child) {
        ViewGroup.LayoutParams p = child.getLayoutParams();
        if (p == null) {
            p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0 + 0, p.width);
        int lpHeight = p.height;
        int childHeightSpec;
        if (lpHeight > 0) {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight,
                    MeasureSpec.EXACTLY);
        } else {
            childHeightSpec = MeasureSpec.makeMeasureSpec(0,
                    MeasureSpec.UNSPECIFIED);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    /*
     * 定义下拉刷新接口
     */
    public interface OnRefreshListener {
        public void onRefresh();
    }

    /*
     * 定义加载更多接口
     */
    public interface OnLoadListener {
        public void onLoad();
    }


}
