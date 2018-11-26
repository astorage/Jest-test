package com.java.search;

/**
 * ES嵌套
 * @author cedric
 */
public class ESNested extends ESBase {

	public static ESNested builder(String path, ESQuery query) {
		ESNested nested = new ESNested();
		nested.value.put(ES_PATH, path);
		nested.value.put(ES_QUERY, query.value());

		nested.build.put(ES_NESTED, nested.value);
		return nested;
	}
}
