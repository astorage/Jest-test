package com.java;

import com.alibaba.fastjson.JSON;
import com.java.search.ESSearch;
import io.searchbox.client.JestResultHandler;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Get;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Author: Boris
 * Date: 2018/11/23 14:53
 * Description:
 */
public class ESOperate {

    private static final Logger logger = LoggerFactory.getLogger(ESOperate.class);

    private static final long TOOK_TIME = 3000;



    /**
     * CloseableHttpClient查询
     * @param condition 查询条件
     * @param connectionType 不同业务的连接
     * @return 结果
     * @throws Exception
     */
    public ESResult query(final ESSearch condition, String connectionType) {
        ESClient esClient = ESClient.getInstance(connectionType);
        long start = System.currentTimeMillis();
        Search search = new Search.Builder(JSON.toJSONString(condition.value())).addIndex(ESConstants.SALE_INDEX)
                .addType(ESConstants.SALE_TRADE_TYPE).setHeader("Accept-Encoding", "gzip").build();
        try {
            ESResult retValue = new ESResult();
            SearchResult result = esClient.getQueryClient().execute(search);
            logger.info("es 查询结果SearchResult：" + result);
            if (!result.isSucceeded()) {
                logger.error(result.getErrorMessage());
                throw new RuntimeException(result.getErrorMessage());
            }
            if (System.currentTimeMillis() - start > TOOK_TIME) {
                logger.warn("[ES]took:" + result.getValue("took") + "，ES查询耗时：" + (System.currentTimeMillis() - start));
                logger.warn("[ES]execute query,content:" + JSON.toJSON(condition).toString().substring(0, 500));
            }
            retValue.setTotal(result.getTotal());
            return retValue;
        } catch (Exception e) {
            logger.error("query failed:" + e.getMessage(), e);
            logger.error("failed condition:" + JSON.toJSON(condition));
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * CloseableHttpAsyncClient查询
     * @param get 查询条件
     * @param connectionType 不同业务的连接
     * @return 结果
     * @throws Exception
     */
    public ESResult asyncGet(final Get get, String connectionType) {
        final CountDownLatch completionChecker = new CountDownLatch(1);
        ESClient esClient = ESClient.getInstance(connectionType);
        long start = System.currentTimeMillis();
        try {
            ESResult retValue = new ESResult();
            ResultHandler<SearchResult> resultHandler = new ResultHandler();
            esClient.getQueryClient().executeAsync(get, new JestResultHandler<DocumentResult>() {
                @Override
                public void completed(DocumentResult result) {
                    completionChecker.countDown();
                   // resultHandler.setSearchResult(result);
                    logger.info("documentResult:" +  result);
                }

                @Override
                public void failed(Exception ex){
                    completionChecker.countDown();
                    resultHandler.setException(ex);

                }
            });
            boolean finishedAsync = completionChecker.await(2, TimeUnit.SECONDS);
            if (!finishedAsync) {
                logger.error("Execution took to long to complete");
                return retValue;
            }
            SearchResult searchResult = resultHandler.getResult();
            logger.info("es 查询结果SearchResult：" + searchResult);
            if (!searchResult.isSucceeded()) {
                logger.error(searchResult.getErrorMessage());
                throw new RuntimeException(searchResult.getErrorMessage());
            }
            if (System.currentTimeMillis() - start > TOOK_TIME) {
                logger.warn("[ES]took:" + searchResult.getValue("took") + "，ES查询耗时：" + (System.currentTimeMillis() - start));
                logger.warn("[ES]execute query,content:" + JSON.toJSONString(get.getId()).substring(0, 500));
            }
            retValue.setTotal(searchResult.getTotal());
            return retValue;
        } catch (Exception e) {
            logger.error("query failed:" + e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * CloseableHttpAsyncClient查询
     * @param condition 查询条件
     * @param connectionType 不同业务的连接
     * @return 结果
     * @throws Exception
     */
    public ESResult asyncQuery(final ESSearch condition, String connectionType) {
        ESClient esClient = ESClient.getInstance(connectionType);
        long start = System.currentTimeMillis();
        Search search = new Search.Builder(JSON.toJSONString(condition.value())).addIndex(ESConstants.SALE_INDEX)
                .addType(ESConstants.SALE_TRADE_TYPE).setHeader("Accept-Encoding", "gzip").build();
        try {
            ESResult retValue = new ESResult();
            ResultHandler<SearchResult> resultHandler = new ResultHandler();
            esClient.getQueryClient().executeAsync(search, resultHandler);
            SearchResult searchResult = resultHandler.getResult();
            logger.info("es 查询结果SearchResult：" + searchResult);
            if (!searchResult.isSucceeded()) {
                logger.error(searchResult.getErrorMessage());
                throw new RuntimeException(searchResult.getErrorMessage());
            }
            if (System.currentTimeMillis() - start > TOOK_TIME) {
                logger.warn("[ES]took:" + searchResult.getValue("took") + "，ES查询耗时：" + (System.currentTimeMillis() - start));
                logger.warn("[ES]execute query,content:" + JSON.toJSONString(condition.value()).substring(0, 500));
            }
            retValue.setTotal(searchResult.getTotal());
            return retValue;
        } catch (Exception e) {
            logger.error("query failed:" + e.getMessage(), e);
            logger.error("failed condition:" + JSON.toJSONString(condition.value()));
            throw new RuntimeException(e.getMessage());
        }
    }


}
