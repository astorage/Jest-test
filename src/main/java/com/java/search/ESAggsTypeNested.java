package com.java.search;

/**
 * 聚合类型
 * @author cedric
 */
public class ESAggsTypeNested extends ESAggsType {

	/**
	 * 创建Nested聚合类型
	 * @param path l路径
	 * @return 实例
	 */
	public static ESAggsTypeNested builder(String path) {

		ESAggsTypeNested type = new ESAggsTypeNested();
		type.value.put(ES_PATH, path);
		type.build.put(ES_NESTED, type.value);

		return type;
	}

}
