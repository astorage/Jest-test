package com.java.search;

import java.util.Map;

/**
 * ES排序条件
 * @author cedric
 */
public class ESSort extends ESBase {
	private static final String ORDER = "order", DESC = "desc", ASC = "asc";

	/**
	 * 设置排序
	 * @param field 字段
	 * @param desc 排序
	 * @return 排序条件
	 */
	public static ESSort builder(String field, boolean desc) {
		ESSort sort = new ESSort();
		Map<String, Object> order = map();
		order.put(ORDER, desc ? DESC : ASC);

		sort.value.put(field, order);
		sort.build.put(ES_SORT, sort.value);
		return sort;
	}

}
