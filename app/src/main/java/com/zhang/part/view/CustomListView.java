package com.zhang.part.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ListView;

import com.zhang.part.R;

/**
 * Created by zhang_shuai on 2017/9/27.
 * Del:气泡实现
 */

public class CustomListView extends ListView implements AbsListView.OnScrollListener{

    private final Animation mOutAnimation;
    private final Animation mInAnimation;
    private View mScrollBarPanel;
    private int mWidthMeasureSpec;
    private int mHeightMeasureSpec;
    private int mScrollBarPanelPostion;
    private int mOffset;
    public CustomListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setOnScrollListener(this);
        //初始化自定义属性
        final TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.CustomListView);
        final int layoutId = typedArray.getResourceId(R.styleable.CustomListView_scrollBarPanel, -1);
        final int inAnimation = typedArray.getResourceId(R.styleable.CustomListView_scrollBarPanelInAnimation, R.anim.in_animation);
        final int outAnimation = typedArray.getResourceId(R.styleable.CustomListView_scrollBarPanelOutAnimation, R.anim.out_animation);
        typedArray.recycle();//回收
        setScrollBarPanel(layoutId);

        mOutAnimation = AnimationUtils.loadAnimation(context,outAnimation);
        mInAnimation = AnimationUtils.loadAnimation(context,inAnimation);
        int duration = ViewConfiguration.getScrollBarFadeDuration();
        mOutAnimation.setDuration(duration);
        mOutAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(mScrollBarPanel!=null){
                    mScrollBarPanel.setVisibility(View.GONE);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(mInAnimation);
        set.addAnimation(mOutAnimation);
    }

    private void setScrollBarPanel(int layoutId) {
        //渲染view
        mScrollBarPanel = LayoutInflater.from(getContext()).inflate(layoutId, this, false);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(mScrollBarPanel != null && getAdapter()!=null){
            mWidthMeasureSpec = widthMeasureSpec;
            mHeightMeasureSpec = heightMeasureSpec;
            measureChild(mScrollBarPanel, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int left = getMeasuredWidth()-mScrollBarPanel.getMeasuredWidth()-getVerticalScrollbarWidth();
        mScrollBarPanel.layout(
                left,
                mScrollBarPanelPostion,
                left+mScrollBarPanel.getMeasuredWidth(),
                mScrollBarPanelPostion + mScrollBarPanel.getMeasuredHeight()
        );
    }

    //绘制控件
    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        //系统的直接画
        if(mScrollBarPanel != null && getAdapter()!=null) {
            drawChild(canvas, mScrollBarPanel, getDrawingTime());
        }
    }


    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
        //滑动监听改变mScrollBarPanelPostion的位置
//        computeHorizontalScrollExtent();//滑动自身高度
//        computeHorizontalScrollOffset();
//        computeHorizontalScrollRange();//0到10000的值
        if(mScrollBarPanel!=null) {
            //求滑块的高度
            int height = Math.round(getMeasuredHeight() * computeVerticalScrollExtent() / computeVerticalScrollRange());
            //得到偏移值
            mOffset = height * computeVerticalScrollOffset() / computeVerticalScrollExtent();
            //得到滑块的y坐标
            mOffset += height / 2;

            mScrollBarPanelPostion = mOffset - mScrollBarPanel.getHeight() / 2;

            int left = getMeasuredWidth() - mScrollBarPanel.getMeasuredWidth() - getVerticalScrollbarWidth();
            mScrollBarPanel.layout(
                    left,
                    mScrollBarPanelPostion,
                    left + mScrollBarPanel.getMeasuredWidth(),
                    mScrollBarPanelPostion + mScrollBarPanel.getMeasuredHeight()
            );
        }
    }
}
