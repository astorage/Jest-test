package com.java.search;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * ES搜索语法
 * @author cedric
 */
public class ESSearch extends ESBase {

	public static final int LARGE_SIZE = 1000;

	/**
	 * 创建查询
	 * @return 查询
	 */
	public static ESSearch builder() {
		ESSearch search = new ESSearch();

		return search;
	}

	/**
	 * 添加排序
	 * @param sort 排序
	 * @return 实例
	 */
	public ESSearch addSort(ESSort sort) {
		if (sort != null) {
			value.put(ES_SORT, sort.value());
		}
		return this;
	}

	/**
	 * 添加分页
	 * @param page 当前页
	 * @param size 数量
	 * @return 实例
	 */
	public ESSearch addPageAndSize(int page, int size) {
		if (page >= 0 && size > 0) {
			value.put(ES_FROM, page);
			value.put(ES_SIZE, size);
		}
		return this;
	}

	/**
	 * 设置返回的文档数
	 * @param size 数量
	 * @return 实例
	 */
	public void setSize(int size) {
		value.put(ES_SIZE, size);
	}

	/**
	 * 添加字段
	 * @param fields 字段集
	 * @return 实例
	 */
	public ESSearch addSource(String... fields) {
		List list = Arrays.asList(fields);
		if (CollectionUtils.isNotEmpty(list)) {
			value.put(ES_SOURCE, fields);
		}

		return this;
	}

	/**
	 * 获取from
	 * @return from
	 */
	public Integer getFrom() {
		return Integer.valueOf(value.get(ES_FROM).toString());
	}

	/**
	 * 获取每页条数
	 * @return 条数
	 */
	public Integer getSize() {
		return Integer.valueOf(value.get(ES_SIZE).toString());
	}

	/**
	 * 是否是大分页查询(每页大于200条数据)
	 * @return 是/否
	 */
	public boolean largeSize() {
		return getFrom() != null && getSize() != null && getSize() > LARGE_SIZE;
	}

	/**
	 * 添加返回条数
	 * @param size 数量
	 * @return 实例
	 */
	public ESSearch addSize(int size) {
		value.put(ES_SIZE, size);
		return this;
	}

	/**
	 * 添加查询
	 * @param query 查询
	 * @return 实例
	 */
	public ESSearch addQuery(ESQuery query) {
		if (query != null) {
			value.put(ES_QUERY, query.value());
		}

		return this;
	}

	/**
	 * 添加聚合
	 * @param aggs 聚合
	 * @return 实例
	 */
	public ESSearch addAggs(ESAggs aggs) {
		if (aggs != null) {
			value.put(ES_AGGS, aggs.value());
		}

		return this;
	}

	/**
	 * 返回值
	 */
	public Object value() {
		return value;
	}

}
