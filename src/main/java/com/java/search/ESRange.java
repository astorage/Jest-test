package com.java.search;

import java.util.Map;

/**
 * ES 范围语法
 * @author cedric
 */
public class ESRange extends ESBase {

	/**
	 * "range" : {
	 * "age" : {
	 * "gte" : 10
	 * }
	 * }<br/>
	 * 大于等于
	 * @param field 字段
	 * @param l 值
	 * @return 语法
	 */
	public static ESRange greatEqualThan(String field, Object l) {
		Map<String, Object> v = map();

		v.put(ES_GTE, l);
		return build(field, v);
	}

	/**
	 * "range" : {
	 * "age" : {
	 * "gt" : 10
	 * }
	 * }<br/>
	 * 大于
	 * @param field 字段
	 * @param l 值
	 * @return 语法
	 */
	public static ESRange greatThan(String field, Object l) {
		Map<String, Object> v = map();

		v.put(ES_GT, l);
		return build(field, v);
	}

	/**
	 * "range" : {
	 * "age" : {
	 * "lt" : 10
	 * }
	 * }<br/>
	 * 小于
	 * @param field 字段
	 * @param r 值
	 * @return 语法
	 */
	public static ESRange lessThan(String field, Object r) {
		Map<String, Object> v = map();

		v.put(ES_LT, r);
		return build(field, v);
	}

	/**
	 * "range" : {
	 * "age" : {
	 * "lte" : 10
	 * }
	 * }<br/>
	 * 小于等于
	 * @param field 字段
	 * @param r 值
	 * @return 语法
	 */
	public static ESRange lessEqualThan(String field, Object r) {
		Map<String, Object> v = map();

		v.put(ES_LTE, r);
		return build(field, v);
	}

	/**
	 * "range" : {
	 * "age" : {
	 * "gte" : 10,
	 * "lte" : 20
	 * }
	 * } <br>
	 * 范围（包含）
	 * @param field 字段
	 * @param l 左
	 * @param r 右
	 * @return 值
	 */
	public static ESRange rangeEqual(String field, Object l, Object r) {
		Map<String, Object> v = map();

		v.put(ES_LTE, r);
		v.put(ES_GTE, l);
		return build(field, v);
	}

	/**
	 * 创建参数
	 * @param field 字段
	 * @param v 值
	 * @return
	 */
	private static ESRange build(String field, Map<String, Object> v) {
		ESRange range = new ESRange();

		range.value.put(field, v);
		range.build.put(ES_RANGE, range.value);
		return range;
	}

}
