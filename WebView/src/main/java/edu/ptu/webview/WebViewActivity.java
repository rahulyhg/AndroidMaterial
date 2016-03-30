package edu.ptu.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import edu.ptu.webview.business.RequestBean;
import edu.ptu.webview.title.CustomTitle;
import edu.ptu.webview.title.CustomTitleAdapter;

/**
 * Created by WangAnshu on 2016/3/24.
 */
public class WebViewActivity extends AppCompatActivity {

    private BaseWebview wvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            RequestBean requestBean = (RequestBean) getIntent().getSerializableExtra("requestBean");
        } catch (Exception e) {
        }
        initView();
    }

    private void initView() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.addView(new CustomTitle(this, new CustomTitleAdapter() {
            @Override
            public List<TitleItem> getLeftView() {
                return new ArrayList<TitleItem>();
            }

            @Override
            public List<TitleItem> getRightView() {
                return new ArrayList<TitleItem>();
            }
        }).getView());
        wvDisplay = new BaseWebview(this);
        linearLayout.addView(wvDisplay);

    }

    //    3. 按返回键时， 不退出程序而是返回上一浏览页面：
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wvDisplay.canGoBack()) {
            wvDisplay.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
