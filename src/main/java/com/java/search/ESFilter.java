package com.java.search;

/**
 * ES过滤器
 * @author cedric
 */
public class ESFilter extends ESBase {

	public static ESFilter builder() {
		ESFilter filter = new ESFilter();
		filter.build.put(ES_FILTER, filter.value);
		return filter;
	}

	/**
	 * 添加terms过滤条件
	 * @param terms 过滤条件
	 * @return 实例
	 */
	public ESFilter addTerms(ESTerms terms) {
		value.put(ES_TERMS, terms.value());
		return this;
	}

	/**
	 * 添加bool条件
	 * @param bool bool条件
	 * @return 实例
	 */
	public ESFilter addBool(ESBool bool) {
		value.put(ES_BOOL, bool.value());
		return this;
	}
}
