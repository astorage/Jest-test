package com.java.search;

/**
 * 聚合类型
 * @author cedric
 */
public class ESAggsTypeSum extends ESAggsType {

	/**
	 * 创建Sum聚合类型
	 * @param field l路径
	 * @return 实例
	 */
	public static ESAggsTypeSum builder(String field) {

		ESAggsTypeSum type = new ESAggsTypeSum();
		type.value.put(ES_FIELD, field);
		type.build.put(ES_SUM, type.value);

		return type;
	}

}
