package com.java.search;

import java.util.HashMap;
import java.util.Map;

public abstract class ESBase {

	protected static final String ES_TERM = "term";
	protected static final String ES_TERMS = "terms";
	protected static final String ES_WILDCARD = "wildcard";
	protected static final String ES_VALUE = "value";
	protected static final String ES_GTE = "gte";
	protected static final String ES_GT = "gt";
	protected static final String ES_LTE = "lte";
	protected static final String ES_LT = "lt";
	protected static final String ES_RANGE = "range";
	protected static final String ES_MUST = "must";
	protected static final String ES_MUST_NOT = "must_not";
	protected static final String ES_BOOL = "bool";
	protected static final String ES_FILTER = "filter";
	protected static final String ES_EXISTS = "exists";
	protected static final String ES_FIELD = "field";
	protected static final String ES_SOURCE = "_source";
	protected static final String ES_CONSTANT_SCORE = "constant_score";
	protected static final String ES_SHOULD = "should";
	protected static final String ES_QUERY = "query";
	protected static final String ES_PATH = "path";
	protected static final String ES_NESTED = "nested";
	protected static final String ES_SORT = "sort";
	protected static final String ES_FROM = "from";
	protected static final String ES_SIZE = "size";
	protected static final String ES_AGGS = "aggs";
	protected static final String ES_SUM = "sum";
	protected static final String ES_ORDER = "order";
	protected static final String ES_MATCH_PHRASE = "match_phrase";

	protected Map<String, Object> value = map();
	protected Map<String, Object> build = map();

	/**
	 * 获取值
	 * @return the value
	 */
	public Map<String, Object> getValue() {
		return value;
	}

	/**
	 * 设置值
	 * @param value
	 */
	public void setValue(Map<String, Object> value) {
		this.value = value;
	}

	/**
	 * 获取键值
	 * @return the build
	 */
	public Map<String, Object> getBuild() {
		return build;
	}

	/**
	 * 设置键值
	 * @param build
	 */
	public void setBuild(Map<String, Object> build) {
		this.build = build;
	}

	/**
	 * map
	 * @return
	 */
	protected static Map<String, Object> map() {
		return new HashMap<String, Object>();
	}

	/**
	 * 获取参数的值
	 * @return value
	 */
	protected Object value() {
		return value;
	}

	/**
	 * 获取参数字段以及对应的值
	 * @return {key:value}
	 */
	protected Object build() {
		return build;
	}

}
