package edu.ptu.webview.title;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.ptu.webview.CustomView;
import edu.ptu.webview.R;

/**
 * Created by WangAnshu on 2016/3/24.
 */
public class CustomTitle extends FrameLayout implements CustomView {

    private final ViewGroup contentView;
    private final ViewGroup vgLeftView;
    private final ViewGroup vgRightView;
    private final ViewGroup vgCenterView;
    private final int screenSize;
    private final TextView tvTitleLabel;

    public CustomTitle(Context context, CustomTitleAdapter customTitle) {
        super(context);
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        screenSize = dm.widthPixels;

        contentView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.title_view, null);
        //TODO 添加文件
        vgLeftView = (ViewGroup) contentView.findViewById(R.id.title_vg_left);
        vgCenterView = (ViewGroup) contentView.findViewById(R.id.title_vg_center);
        vgRightView = (ViewGroup) contentView.findViewById(R.id.title_vg_right);
        tvTitleLabel = (TextView) vgCenterView.findViewById(R.id.title_tv_label);
        //改为异步启动
        List<CustomTitleAdapter.TitleItem> leftView = customTitle.getLeftView();
        for (int index = 0; index < leftView.size(); index++) {
            vgLeftView.addView(getRightItem(leftView.get(index), context));
        }
        setTitle(customTitle.titleStr);
        List<CustomTitleAdapter.TitleItem> rightView = customTitle.getLeftView();
        for (int index = 0; index < rightView.size(); index++) {
            vgLeftView.addView(getRightItem(rightView.get(index), context));
        }

        inValideTitleViewWidth();
    }

    public View getRightItem(CustomTitleAdapter.TitleItem item, Context context) {
        if (item.type == CustomTitleAdapter.TitleItem.TYPE_TITLE) {
            TextView textView = new TextView(context);
            textView.setText(item.content);
            return textView;
        } else if (item.type == CustomTitleAdapter.TitleItem.TYPE_IMG) {
            ImageView imgItem = new ImageView(context);
            imgItem.setImageResource(item.imgSrc);
            return imgItem;
        }
        return new View(context);
    }

    private void inValideTitleViewWidth() {
        measureLeftLength();
        measureRightLengh();
        double sideSize = Math.ceil(Math.max(measureLeftLength(), measureRightLengh()));

        ViewGroup.LayoutParams layoutParams = vgLeftView.getLayoutParams();
        layoutParams.width = (int) sideSize;
        vgLeftView.setLayoutParams(layoutParams);

        layoutParams = vgRightView.getLayoutParams();
        layoutParams.width = (int) sideSize;
        vgRightView.setLayoutParams(layoutParams);

        layoutParams = vgCenterView.getLayoutParams();
        layoutParams.width = (int) (screenSize - 2 * sideSize);
        vgCenterView.setLayoutParams(layoutParams);
    }

    private float measureRightLengh() {
        return vgLeftView.getMeasuredWidth();
    }

    private float measureLeftLength() {
        return vgRightView.getMeasuredWidth();
    }

    @Override
    public View getView() {
        return contentView;
    }

    public void setTitle(String title) {
        this.tvTitleLabel.setText(title);
    }
}
