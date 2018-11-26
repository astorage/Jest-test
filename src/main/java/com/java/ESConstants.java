/*
 * @(#)TOPProperties.java	 2011-9-10
 *
 * Copyright (c) 2011 杭州湖畔网络技术有限公司 
 * 保留所有权利 
 * 本软件为杭州湖畔网络技术有限公司所有及包含机密信息，须遵守其相关许可证条款进行使用。
 * Copyright (c) 2011 HUPUN Network Technology CO.,LTD.
 * All rights reserved.
 * This software is the confidential and proprietary information of HUPUN
 * Network Technology CO.,LTD("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with HUPUN.
 * Website：http://www.hupun.com
 */
package com.java;


import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Properties;

/**
 * ES 属性集
 */
public class ESConstants {
	public final static String URL = ESProperties.getString("url");
	public final static String USER = ESProperties.getString("user");
	public final static String PWD = ESProperties.getString("pwd");
	public final static String SALE_INDEX = ESProperties.getString("es_index");
	public final static String SALE_TRADE_TYPE = ESProperties.getString("es_type");
	public final static Integer PUSH_SIZE = Integer.valueOf(ESProperties.getString("push_size"));
	public final static Integer QUERY_POOL_SIZE = Integer.valueOf(ESProperties.getString("query_pool_size"));
	public final static Integer PUSH_POOL_SIZE = Integer.valueOf(ESProperties.getString("push_pool_size"));
}


/**
 * ES 属性集
 */
class ESProperties {

	protected static Reference<Properties> ref = null;

	/**
	 * 获取文本值
	 * @param key 属性键
	 * @return 文本值
	 */
	public static String getString(String key) {
		return getProperties().get(key).toString();
	}

	/**
	 * 创建属性集实例
	 * @return 属性集
	 */
	protected static Properties getProperties() {
		try {
			Properties prop = ref == null ? null : ref.get();
			if (prop == null) ref = new WeakReference(prop = loadProperties());
			return prop;
		} catch (IOException e) {
			throw new UnsupportedOperationException(e.getLocalizedMessage());
		}
	}

	/**
	 * 加载属性集
	 * @return 属性集
	 * @throws IOException
	 */
	static Properties loadProperties() throws IOException {
		Properties prop = new Properties();
		InputStream inputStream = Class.class.getResourceAsStream("/es.server.properties");
		prop.load(inputStream);
		return prop;
	}
}