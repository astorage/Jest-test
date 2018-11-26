package com.java;

import com.java.search.*;
import io.searchbox.core.Get;

/**
 * Author: Boris
 * Date: 2018/11/23 14:20
 * Description:
 */
public class EsTest {

    public static void main(String[] args) {
        //query();
        //asyncQuery();
        getAsynchronously();
    }

    private static void asyncQuery(){
        ESOperate esOperate = new ESOperate();

        ESSearch search = ESSearch.builder().addQuery( ESQuery.builder().addBool(ESBool.builder()
                .addMust(ESMust.builder().addTerm(ESTerm.builder("tags.B220U100_0_002", "4420517")))));
        //condition.setSize(0);
        search.addPageAndSize(1, 0);
        ESResult esResult = esOperate.asyncQuery(search, ESConnnectionTypeEnum.COMPUTE_USER.getKey());
        System.out.println("标签B220U100_0_002=4420517的人数：" + esResult.getTotal());
    }

    private static void query() {
        ESOperate esOperate = new ESOperate();

        ESSearch condition = ESSearch.builder().addQuery( ESQuery.builder().addBool(ESBool.builder()
                .addMust(ESMust.builder().addTerm(ESTerm.builder("tags.B220U100_0_002", "4420517")))));
        condition.setSize(2);
        ESResult esResult = esOperate.query(condition, ESConnnectionTypeEnum.COMPUTE_USER.getKey());
        System.out.println("标签B220U100_0_002=4420517的人数：" + esResult.getTotal());
    }

    public static void getAsynchronously() {
        ESOperate esOperate = new ESOperate();
        Get get = new Get.Builder("2018115_userid", "10004759").type("tags").build();
        ESResult esResult = esOperate.asyncGet(get, ESConnnectionTypeEnum.COMPUTE_USER.getKey());
        System.out.println("标签B220U100_0_002=4420517的人数：" + esResult.getTotal());
    }
}
