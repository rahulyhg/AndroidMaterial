package edu.ptu.webview.business;

import java.io.Serializable;

/**
 * Created by WangAnshu on 2016/3/30.
 */
public class RequestBean implements Serializable{
    private int type;//FIXME 处理相同业务,状态模式
    //定制界面
    private String title;//没有title，则不显示标题栏
    private String url;
    private String appendExtraData;
}
