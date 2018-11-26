package com.java;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.strings.StringUtils;
import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: Boris
 * Date: 2018/11/23 14:22
 * Description:
 */
@Data
public class ESClient {
    private static Map<String, ESClient> clientPool = new ConcurrentHashMap<String, ESClient>();

    private JestClient queryClient, pushClient;

    private int PUSH_SIZE;
    private int THREAD_QUERY_POOL, THREAD_PUSH_POOL;

    private ESClient() {
        initSize();

        this.queryClient = client(ESConstants.URL, ESConstants.USER, ESConstants.PWD, THREAD_QUERY_POOL);
        this.pushClient = client(ESConstants.URL, ESConstants.USER, ESConstants.PWD, THREAD_PUSH_POOL);
    }

    private ESClient(String url, String username, String pwd) {
        initSize();

        this.queryClient = client(url, username, pwd, THREAD_QUERY_POOL);
        this.pushClient = client(url, username, pwd, THREAD_PUSH_POOL);
    }

    private void initSize() {
        this.PUSH_SIZE = ESConstants.PUSH_SIZE == null ? 200 : ESConstants.PUSH_SIZE;
        this.THREAD_QUERY_POOL = ESConstants.QUERY_POOL_SIZE == null ? 50 : ESConstants.QUERY_POOL_SIZE;
        this.THREAD_PUSH_POOL = ESConstants.PUSH_POOL_SIZE == null ? 200 : ESConstants.PUSH_POOL_SIZE;
    }


    /**
     * 获取实例
     * @param ins_id 实例id
     * @return 实例
     */
    public static ESClient getInstance(String ins_id) {
        ESClient client = clientPool.get(ins_id);
        if (client == null) {
            synchronized (clientPool) {
                client = clientPool.get(ins_id);
                if (client == null) {
                    client = new ESClient();
                    clientPool.put(ins_id, client);
                }
            }
        }
        return client;
    }

    /**
     * 获取实例
     * @param ins_id 实例id
     * @param url 地址
     * @param user 账号
     * @param pwd 密码
     * @return 实例
     */
    public static ESClient getInstance(String ins_id, String url, String user, String pwd) {
        ESClient client = clientPool.get(ins_id);
        if (client == null) {
            synchronized (clientPool) {
                client = clientPool.get(ins_id);
                if (client == null) {
                    if (StringUtils.isBlank(user) || StringUtils.isBlank(pwd) || StringUtils.isBlank(url)) {
                        client = new ESClient();
                    }else {
                        client = new ESClient(url, user, pwd);
                    }
                    clientPool.put(ins_id, client);
                }
            }
        }
        return client;
    }

    /**
     * 获取客户端实例
     * @param url 地址
     * @param user 账户名
     * @param pwd 密码
     * @param threadPool 线程数
     * @return 客户端
     */
    private JestClient client(String url, String user, String pwd, int threadPool) {
        for (int i = 0;; i++) {
            try {
                JestClientFactory factory = new JestClientFactory();
                factory.setHttpClientConfig(new HttpClientConfig.Builder(url)
                        .defaultCredentials(user, pwd)
                        .multiThreaded(true)
                        .defaultMaxTotalConnectionPerRoute(threadPool)
                        .maxTotalConnection(threadPool)
                        .connTimeout(30000)
                        .readTimeout(60000)
                        .requestCompressionEnabled(true)
                        .build());
                return factory.getObject();
            } catch (Exception e) {
                e.printStackTrace();
                if (i >= 3) {
                    throw new RuntimeException(e.getMessage());
                }
            } catch (Throwable e) {
                System.out.println(e.getMessage());
                if (i >= 3) {
                    throw new RuntimeException(e.getMessage());
                }
            }

        }
    }
}
