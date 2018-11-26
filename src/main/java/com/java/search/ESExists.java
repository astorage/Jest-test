package com.java.search;

import java.util.Map;

/**
 * ES 是否存在语法（字段是否存在，空串也表示存在）
 * @author cedric
 */
public class ESExists extends ESBase {

	public static ESExists builder(String field) {

		Map<String, Object> v = map();
		v.put(ES_FIELD, field);

		ESExists exists = new ESExists();
		exists.build.put(ES_EXISTS, v);
		return exists;
	}
}
