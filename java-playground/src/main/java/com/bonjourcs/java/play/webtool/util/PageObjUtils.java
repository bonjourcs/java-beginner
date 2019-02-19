package com.bonjourcs.java.play.webtool.util;

import com.bonjourcs.java.play.webtool.bean.PageObj;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Liang Chenghao
 * Description: page object util class
 * Date: 2019/2/19
 */
public class PageObjUtils {

    public static <T, O> PageObj encapsulatePageObj(List<O> origin, int totalItems,
                                                    int page, int size, Function<O, T> function) {
        // encapsulate origin object
        List<T> target = new ArrayList<>();
        origin.forEach(o -> {
            T t = function.apply(o);
            target.add(t);
        });

        // set page parameter
        return PageObj.builder()
                .items(target)
                .totalItems(totalItems)
                .page(page)
                .size(size)
                .build();
    }

}
