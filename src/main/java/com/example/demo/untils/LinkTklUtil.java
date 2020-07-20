package com.example.demo.untils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.SinaShortUrl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.httpclient.HttpClient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.untils.SimpleHttpUtils.userAgentMap;

/**
 *
 * @Description: 淘口令链接转换<br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/04 <br>
 */
public class LinkTklUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(LinkTklUtil.class);

    private static String [] appkeys = {"2815391962","31641035","3271760578","3925598208","1681459862"};

    public static final String SHORT_API_URL = "http://api.t.sina.com.cn/short_url/shorten.json";

    /**
     * 生成淘口令
     * @param link 原链接地址
     * @param image 图片链接
     * @param text 描述标题
     * @return
     */
    public static String generateTkl(String link, String image , String text) {

        String url = "http://api.chaozhi.hk/tb/linkTkl";
        HttpClient client = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        //通过postMethod 设置更多的请求数据
        postMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.146 Safari/537.36");
        postMethod.setRequestHeader("Accept","application/json, text/plain, */*");
        postMethod.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        postMethod.setRequestHeader("Referer","http://tool.chaozhi.hk/");
        postMethod.setRequestHeader("Origin","http://tool.chaozhi.hk");
        postMethod.setRequestHeader("Host","api.chaozhi.hk");

        NameValuePair[] data = {
                new NameValuePair("type", "A"),
                new NameValuePair("link", link),
                new NameValuePair("image", image),
                new NameValuePair("text", text)
        };
        postMethod.setRequestBody(data);

        try {
            client.executeMethod(postMethod);
            JSONObject object = JSON.parseObject(postMethod.getResponseBodyAsString());
//            int code = object.getInteger("error_code");
            return ((JSONObject)object.get("data")).getString("tkl");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成短连接
     * @param link 原链接
     * @return
     */
    public static String generateShortUrl(String link){
        String url = SHORT_API_URL + "?source" + appkeys[(int)(Math.random() * 5 )] + "&url_long=" + link;
        try {
            List<SinaShortUrl> listByGson = getListByGson(SimpleHttpUtils.get(url, userAgentMap()));
            String urlShot = listByGson.get(0).getUrl_short();
            return urlShot;
        }catch (Exception e){
            LOGGER.warn("generate shortUrl is error:" + e.getMessage());
        }
        return null;
    }

    /**
     * 接口响应数据封装
     */
    private static List<SinaShortUrl> getListByGson(String jsonString) {
        List<SinaShortUrl> list = new ArrayList<>();
        Gson gson = new Gson();
        list = gson.fromJson(jsonString, new TypeToken<List<SinaShortUrl>>(){}.getType());
        return list;
    }

}
