package com.java.search;

/**
 * "terms": {"orders.sys_sku_id": ["13DAD31FD912340C9337DDCCB987CBFF","49851D980F883A45AE4FC087F78AC8F0"]}
 * @author cedric
 */
public class ESTerms extends ESBase {

	public static <T> ESTerms builder(String field, T... values) {
		ESTerms t = new ESTerms();

		t.value.put(field, values);
		t.build.put(ES_TERMS, t.value());
		return t;
	}

}
