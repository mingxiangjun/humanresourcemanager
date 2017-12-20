package org.ming.humanresource.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 首页Controller
 * @author MingXiangjun
 * @create 2017-12-17 14:26
 */
@Controller
public class IndexController {
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
    public String toPage(@RequestParam(value = "toPage", defaultValue = "index") String pageName) {
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
}
