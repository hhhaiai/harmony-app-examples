package com.bigpeach.components;

import com.bigpeach.animation.JStateChangedListener;
import ohos.agp.animation.Animator;
import ohos.agp.animation.AnimatorValue;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.*;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.utils.Point;
import ohos.agp.utils.Rect;
import ohos.app.Context;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public class SlidingDrawerLayout extends StackLayout {

    HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0x00011, "big");

    private Component child;
    private int windowHeight;
    private int offsetHeight;
    private int offsetAuto;
    private int minY;
    private int maxY;
    private float startY;
    private AnimatorValue animator;

    private float x = 0;
    private float y = 0;
    private boolean intercept = false;
    private ShapeElement shapeElement;

    public SlidingDrawerLayout(Context context) {
        this(context, null);
    }

    public SlidingDrawerLayout(Context context, AttrSet attrSet) {
        this(context, attrSet, null);
    }

    public SlidingDrawerLayout(Context context, AttrSet attrSet, String styleName) {
        super(context, attrSet, styleName);
        int height = getResourceManager().getDeviceCapability().height;
        windowHeight = AttrHelper.vp2px(height, getContext());

        shapeElement = new ShapeElement();
        shapeElement.setRgbColor(new RgbColor(0x00, 0x00, 0x00));
        shapeElement.setAlpha(0x00);
        setBackground(shapeElement);

        setDraggedListener(Component.DRAG_VERTICAL, new DraggedListener() {
            @Override
            public void onDragDown(Component component, DragInfo dragInfo) {
                Point point = dragInfo.downPoint;
                int pX = point.getPointXToInt();
                int pY = point.getPointYToInt();
                HiLog.error(label, "onDragDown1 dx=%{public}s dy=%{public}s", point.getPointXToInt(), point.getPointYToInt());

                Rect rect = child.getComponentPosition();
                HiLog.error(label, "onDragDown2 left=%{public}s right=%{public}s top=%{public}s bottom=%{public}s", rect.left, rect.right, rect.top, rect.bottom);

                float[] floats = child.getContentPosition();
                x = floats[0];
                y = floats[1];
                HiLog.error(label, "onDragDown3 x=%{public}s y=%{public}s", floats[0], floats[1]);

                intercept = x < pX && pX < x + (rect.right - rect.left) && y < pY && pY < y + (rect.bottom - rect.top);
                if (intercept && animator != null) animator.stop();
            }

            @Override
            public void onDragStart(Component component, DragInfo dragInfo) {
                Point point = dragInfo.startPoint;
                HiLog.error(label, "onDragStart y=%{public}s yO=%{public}s", point.getPointYToInt(), dragInfo.yOffset);
                y = y + (float) dragInfo.yOffset;
                startY = y;
                child.setContentPosition(x, y);
            }

            @Override
            public void onDragUpdate(Component component, DragInfo dragInfo) {
                Point point = dragInfo.updatePoint;
                //HiLog.error(label, "onDragUpdate y=%{public}s yO=%{public}s yV=%{public}s", point.getPointYToInt(), (int) dragInfo.yOffset, (int) dragInfo.yVelocity);
                y = y + (float) dragInfo.yOffset;
                if (y > maxY) {
                    y = maxY;
                } else if (y < minY) {
                    y = minY;
                }
                child.setContentPosition(x, y);
                float alpha = (float) (0xCC * Math.pow((maxY - y) / offsetHeight, 5));
                //HiLog.error(label, "alpha=%{public}s", alpha);
                shapeElement.setAlpha((int) alpha);
            }

            @Override
            public void onDragEnd(Component component, DragInfo dragInfo) {
                float offsetY = y - startY;
                HiLog.error(label, "onDragEnd offsetY=%{public}s offsetAuto=%{public}s", offsetY, offsetAuto);
                if (offsetY > 0 && offsetY > offsetAuto) {          // 向下滑动
                    if (y < maxY) startAnimator(child, y, maxY);
                } else if (offsetY < 0 && -offsetY > offsetAuto) {  // 向上滑动
                    if (y > minY) startAnimator(child, y, minY);
                } else {
                    startAnimator(child, y, startY);
                }
                intercept = false;
            }

            @Override
            public void onDragCancel(Component component, DragInfo dragInfo) {
                Point point = dragInfo.updatePoint;
                HiLog.error(label, "onDragCancel y=%{public}s", point.getPointYToInt());
                intercept = false;
            }

            @Override
            public boolean onDragPreAccept(Component component, int dragDirection) {
                return intercept;
            }
        });
    }

    public void setChild(Component component, int handHeight, int bodyHeight) {
        this.child = component;
        this.offsetHeight = bodyHeight;
        this.minY = windowHeight - handHeight - bodyHeight;
        this.maxY = windowHeight - handHeight;
        this.offsetAuto = bodyHeight / 3;
    }

    public void showMenu() {
        float y = child.getContentPositionY();
        startAnimator(child, y, minY);
    }

    public void closeMenu() {
        float y = child.getContentPositionY();
        startAnimator(child, y, maxY);
    }

    private void startAnimator(Component component, float startValue, float endValue) {
        if (animator != null) animator.stop();
        float value = endValue - startValue;
        animator = new AnimatorValue();
        animator.setDuration(300);
        animator.setCurveType(Animator.CurveType.ACCELERATE_DECELERATE);
        animator.setStateChangedListener(new JStateChangedListener() {
            @Override
            public void onStop(Animator anim) {
                animator = null;
            }
        });
        animator.setValueUpdateListener((animatorValue, v) -> {
            y = startValue + (value * v);
            child.setContentPosition(0, y);
            float alpha = (float) (0xCC * Math.pow((maxY - y) / offsetHeight, 5));
            //HiLog.error(label, "alpha=%{public}s", alpha);
            shapeElement.setAlpha((int) alpha);
        });
        animator.start();
    }
}
