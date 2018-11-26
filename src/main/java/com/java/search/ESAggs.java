package com.java.search;

/**
 * ES聚合
 * @author cedric
 */
public class ESAggs extends ESBase {

	/**
	 * 构建聚合
	 * @return 实例
	 */
	public static ESAggs builder() {
		ESAggs aggs = new ESAggs();
		aggs.build.put(ES_AGGS, aggs.value);
		return aggs;
	}

	/**
	 * 添加类型
	 * @param aggsName 聚合名称
	 * @param aggValue 类型
	 * @return 实例
	 */
	public ESAggs addAggValue(String aggsName, ESAggsValue aggValue) {
		value.put(aggsName, aggValue.value());
		return this;
	}

	
}
