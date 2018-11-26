package com.java.search;

/**
 * 聚合类型
 * @author cedric
 */
public class ESAggsTypeOrder extends ESAggsType {

	public static final String ASC="asc";
	public static final String DESC="desc";

	/**
	 * 创建Filter聚合类型
	 * @return 实例
	 */
	public static ESAggsTypeOrder builder(String field,String value) {

		ESAggsTypeOrder type = new ESAggsTypeOrder();
		type.value.put(field, value);
		type.build.put(ES_ORDER, type.value);
		return type;
	}

}
