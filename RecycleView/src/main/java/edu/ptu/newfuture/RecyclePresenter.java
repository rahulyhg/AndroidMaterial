package edu.ptu.newfuture;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by WangAnshu on 2016/3/2.
 */
public class RecyclePresenter {
    public void loadData() {
        EventBus.getDefault().post(parseJson());
    }

    private ArrayList parseJson() {
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray result = jsonObject.getJSONArray("result");
            ArrayList<RecycleDataEvent> recycleDataEvents = new ArrayList<RecycleDataEvent>(result.length());
            RecycleDataEvent recycleDataEvent;
            for (int pos = 0; pos < result.length(); pos++) {
                JSONObject o = (JSONObject) result.get(pos);
                recycleDataEvent = new RecycleDataEvent();
                recycleDataEvent.setDesc(o.getString("screen_name"));
                recycleDataEvent.setImgUrl(o.getString("profile_image_url"));
                recycleDataEvent.setTitle(o.getString("desc1"));
                recycleDataEvents.add(recycleDataEvent);
            }
            return recycleDataEvents;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new ArrayList<RecycleDataEvent>(0);
    }

    public String data = "{\n" +
            "\tresult: [{\n" +
            "\t\tid: 3300716723,\n" +
            "\t\tscreen_name: \"深圳吃喝玩乐fun\",\n" +
            "\t\tprofile_image_url: \"http://tp4.sinaimg.cn/3300716723/50/5703435662/0\",\n" +
            "\t\tavatar_large: \"http://tp4.sinaimg.cn/3300716723/180/5703435662/0\",\n" +
            "\t\tdesc1: \"微博本地资讯博主（深圳）http://t.cn/RUmMhZ7\",\n" +
            "\t\tdesc2: \"深圳美食\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\tid: 2465987490,\n" +
            "\t\tscreen_name: \"技能蜀黍\",\n" +
            "\t\tprofile_image_url: \"http://tp3.sinaimg.cn/2465987490/50/5736549889/1\",\n" +
            "\t\tavatar_large: \"http://tp3.sinaimg.cn/2465987490/180/5736549889/1\",\n" +
            "\t\tdesc1: \"社会时政博主 \",\n" +
            "\t\tdesc2: \"深圳名人\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\tid: 2828585100,\n" +
            "\t\tscreen_name: \"学生那些小事\",\n" +
            "\t\tprofile_image_url: \"http://tp1.sinaimg.cn/2828585100/50/40063175186/1\",\n" +
            "\t\tavatar_large: \"http://tp1.sinaimg.cn/2828585100/180/40063175186/1\",\n" +
            "\t\tdesc1: \"知名教育培训博主\",\n" +
            "\t\tdesc2: \"深圳最热关注\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\tid: 2934114502,\n" +
            "\t\tscreen_name: \"鲜城深圳\",\n" +
            "\t\tprofile_image_url: \"http://tp3.sinaimg.cn/2934114502/50/5734015069/1\",\n" +
            "\t\tavatar_large: \"http://tp3.sinaimg.cn/2934114502/180/5734015069/1\",\n" +
            "\t\tdesc1: \"鲜城深圳官方微博\",\n" +
            "\t\tdesc2: \"深圳精选\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\tid: 2097044773,\n" +
            "\t\tscreen_name: \"幸福在深圳\",\n" +
            "\t\tprofile_image_url: \"http://tp2.sinaimg.cn/2097044773/50/40010690517/0\",\n" +
            "\t\tavatar_large: \"http://tp2.sinaimg.cn/2097044773/180/40010690517/0\",\n" +
            "\t\tdesc1: \"幸福在深圳官方微博\",\n" +
            "\t\tdesc2: \"深圳美食\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\tid: 1895354102,\n" +
            "\t\tscreen_name: \"八九不离食小姐\",\n" +
            "\t\tprofile_image_url: \"http://tp3.sinaimg.cn/1895354102/50/40022546966/0\",\n" +
            "\t\tavatar_large: \"http://tp3.sinaimg.cn/1895354102/180/40022546966/0\",\n" +
            "\t\tdesc1: \"美食点评团成员 微博签约自媒体\",\n" +
            "\t\tdesc2: \"深圳美食\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\tid: 2013320812,\n" +
            "\t\tscreen_name: \"深圳大小事\",\n" +
            "\t\tprofile_image_url: \"http://tp1.sinaimg.cn/2013320812/50/5599816402/0\",\n" +
            "\t\tavatar_large: \"http://tp1.sinaimg.cn/2013320812/180/5599816402/0\",\n" +
            "\t\tdesc1: \"微博本地资讯博主（深圳）http://t.cn/RUmMhZ7\",\n" +
            "\t\tdesc2: \"深圳精选\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\tid: 1193491727,\n" +
            "\t\tscreen_name: \"王石\",\n" +
            "\t\tprofile_image_url: \"http://tp4.sinaimg.cn/1193491727/50/5667656940/1\",\n" +
            "\t\tavatar_large: \"http://tp4.sinaimg.cn/1193491727/180/5667656940/1\",\n" +
            "\t\tdesc1: \"万科企业股份有限公司董事会主席\",\n" +
            "\t\tdesc2: \"深圳名人\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\tid: 2045192714,\n" +
            "\t\tscreen_name: \"深圳美食爆料\",\n" +
            "\t\tprofile_image_url: \"http://tp3.sinaimg.cn/2045192714/50/5600002099/0\",\n" +
            "\t\tavatar_large: \"http://tp3.sinaimg.cn/2045192714/180/5600002099/0\",\n" +
            "\t\tdesc1: \"微博本地资讯博主（深圳）http://t.cn/RUmMhZ7\",\n" +
            "\t\tdesc2: \"深圳美食\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\tid: 1852545681,\n" +
            "\t\tscreen_name: \"深圳吃货小分队\",\n" +
            "\t\tprofile_image_url: \"http://tp2.sinaimg.cn/1852545681/50/5611067172/0\",\n" +
            "\t\tavatar_large: \"http://tp2.sinaimg.cn/1852545681/180/5611067172/0\",\n" +
            "\t\tdesc1: \"吃饭不积极，思想有问题！\",\n" +
            "\t\tdesc2: \"深圳美食\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\tid: 1886477075,\n" +
            "\t\tscreen_name: \"赤道少女\",\n" +
            "\t\tprofile_image_url: \"http://tp4.sinaimg.cn/1886477075/50/5717356083/1\",\n" +
            "\t\tavatar_large: \"http://tp4.sinaimg.cn/1886477075/180/5717356083/1\",\n" +
            "\t\tdesc1: \"微博知名作家\",\n" +
            "\t\tdesc2: \"深圳名人\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\tid: 1863619513,\n" +
            "\t\tscreen_name: \"深圳生活圈\",\n" +
            "\t\tprofile_image_url: \"http://tp2.sinaimg.cn/1863619513/50/22840764567/0\",\n" +
            "\t\tavatar_large: \"http://tp2.sinaimg.cn/1863619513/180/22840764567/0\",\n" +
            "\t\tdesc1: \"微博本地资讯博主（深圳）http://t.cn/RUmMhZ7\",\n" +
            "\t\tdesc2: \"深圳精选\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\tid: 2435727903,\n" +
            "\t\tscreen_name: \"深圳美食生活\",\n" +
            "\t\tprofile_image_url: \"http://tp4.sinaimg.cn/2435727903/50/22891807367/0\",\n" +
            "\t\tavatar_large: \"http://tp4.sinaimg.cn/2435727903/180/22891807367/0\",\n" +
            "\t\tdesc1: \"微博本地资讯博主（深圳）http://t.cn/RUmMhZ7\",\n" +
            "\t\tdesc2: \"深圳精选\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\tid: 2182038504,\n" +
            "\t\tscreen_name: \"我的前任是极品\",\n" +
            "\t\tprofile_image_url: \"http://tp1.sinaimg.cn/2182038504/50/5727937258/0\",\n" +
            "\t\tavatar_large: \"http://tp1.sinaimg.cn/2182038504/180/5727937258/0\",\n" +
            "\t\tdesc1: \"知名搞笑幽默博主\",\n" +
            "\t\tdesc2: \"深圳最热关注\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\tid: 2435727903,\n" +
            "\t\tscreen_name: \"深圳美食生活\",\n" +
            "\t\tprofile_image_url: \"http://tp4.sinaimg.cn/2435727903/50/22891807367/0\",\n" +
            "\t\tavatar_large: \"http://tp4.sinaimg.cn/2435727903/180/22891807367/0\",\n" +
            "\t\tdesc1: \"微博本地资讯博主（深圳）http://t.cn/RUmMhZ7\",\n" +
            "\t\tdesc2: \"深圳美食\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\tid: 1660815495,\n" +
            "\t\tscreen_name: \"学生那点小事\",\n" +
            "\t\tprofile_image_url: \"http://tp4.sinaimg.cn/1660815495/50/5730024919/0\",\n" +
            "\t\tavatar_large: \"http://tp4.sinaimg.cn/1660815495/180/5730024919/0\",\n" +
            "\t\tdesc1: \"知名幽默博主\",\n" +
            "\t\tdesc2: \"深圳名人\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\tid: 2697416452,\n" +
            "\t\tscreen_name: \"999道私房菜\",\n" +
            "\t\tprofile_image_url: \"http://tp1.sinaimg.cn/2697416452/50/5623039012/0\",\n" +
            "\t\tavatar_large: \"http://tp1.sinaimg.cn/2697416452/180/5623039012/0\",\n" +
            "\t\tdesc1: \"知名美食博主\",\n" +
            "\t\tdesc2: \"深圳名人\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\tid: 1098618600,\n" +
            "\t\tscreen_name: \"银教授\",\n" +
            "\t\tprofile_image_url: \"http://tp1.sinaimg.cn/1098618600/50/5750596444/1\",\n" +
            "\t\tavatar_large: \"http://tp1.sinaimg.cn/1098618600/180/5750596444/1\",\n" +
            "\t\tdesc1: \"微博知名搞笑博主、编剧 代表作：《屌丝男士》、《极品女士》\",\n" +
            "\t\tdesc2: \"深圳名人\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\tid: 2970036311,\n" +
            "\t\tscreen_name: \"贴吧君\",\n" +
            "\t\tprofile_image_url: \"http://tp4.sinaimg.cn/2970036311/50/5726642681/1\",\n" +
            "\t\tavatar_large: \"http://tp4.sinaimg.cn/2970036311/180/5726642681/1\",\n" +
            "\t\tdesc1: \"微博知名搞笑博主\",\n" +
            "\t\tdesc2: \"深圳最热关注\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\tid: 1718488412,\n" +
            "\t\tscreen_name: \"全球经典视频榜\",\n" +
            "\t\tprofile_image_url: \"http://tp1.sinaimg.cn/1718488412/50/40092007941/0\",\n" +
            "\t\tavatar_large: \"http://tp1.sinaimg.cn/1718488412/180/40092007941/0\",\n" +
            "\t\tdesc1: \"每天提供最新、最热门的经典视频：全天24小时即时发布。投稿请私信。\",\n" +
            "\t\tdesc2: \"深圳最热关注\"\n" +
            "\t}]\n" +
            "}";
}
