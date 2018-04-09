package com.bonjourcs.java.common.bean;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/9
 */
public class PageTest {

    @Test
    public void testPagingObject() {

        Page<String> page = init();
        System.out.println(JSON.toJSONString(page));

    }

    @Test
    public void testRetData() {

        RetObject<Page<String>> retObject = RetObject.success();
        Page<String> data = init();
        retObject.setRetData(data);
        retObject.setRetMsg("响应成功");

        System.out.println(JSON.toJSONString(retObject));
    }

    /**
     * init paging object
     *
     * @return a paging object with 100 items and paging parameters are 1 and 3
     */
    private Page<String> init() {

        Page<String> page = new Page<>();

        List<String> strings = new ArrayList<>();
        strings.add("AAA");
        strings.add("BBB");
        strings.add("CCC");

        page.init(1, 3, 100)
                .setList(strings);

        return page;
    }
}