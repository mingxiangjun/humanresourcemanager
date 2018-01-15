package org.ming.humanresource.common.controller;

import net.sf.json.JSONObject;
import org.ming.humanresource.cache.service.CacheService;
import org.ming.humanresource.cache.service.impl.RedisCacheServiceImpl;
import org.ming.humanresource.common.util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 首页Controller
 * @author MingXiangjun
 * @create 2017-12-17 14:26
 */
@Controller
public class IndexController {
    @Autowired
    private CacheService cacheService;

    /**
     * 首页跳转
     */
    @RequestMapping(value = "/index")
    public void index() {
    }

    /**
     * 页面跳转
     * @param pageName
     * @return
     */
    @RequestMapping(value = "/toPage")
    public String toPage(@RequestParam(value = "page", defaultValue = "index") String pageName) {
        if (pageName.indexOf("_") > 0) {
            StringBuffer finalPage = new StringBuffer();
            String[] pageNames = pageName.split("_");
            for (int i = 0; i < pageNames.length; i++) {
                finalPage.append(pageNames[i] + "/");
            }
            pageName = finalPage.substring(0, finalPage.length() - 1).toString();
        }
        return pageName;
    }

    @RequestMapping(value = "sendRedisMsg")
    public void sendRedisMsg(@RequestParam(value = "key")String key,
                               @RequestParam(value = "content")String content,
                               HttpServletResponse response) throws IOException {
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()));
        cacheService.cachePut(key+CommonConstants.CACHENAME,content, CommonConstants.CACHENAME);
//        cacheService.cachePut(key+CommonConstants.CACHENAME_BAK,content, CommonConstants.CACHENAME_BAK);
//        cacheService.cachePut(key+"test",content, "test",30);

        JSONObject resultJson = new JSONObject();
        resultJson.element("code","1").element("msg","操作成功");
        PrintWriter out = response.getWriter();
        out.write(resultJson.toString());
    }
}
