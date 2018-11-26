package com.java.search;

public class ESAggsValue extends ESBase{

	/**
	 * 构建聚合
	 * @return 实例
	 */
	public static ESAggsValue builder() {
		ESAggsValue aggs = new ESAggsValue();
		aggs.build.put(ES_AGGS, aggs.value);
		return aggs;
	}
	
	public ESAggsValue addTerms(ESAggsTypeTerms terms){
		value.put(ES_TERMS, terms.value());
		return this;
	}
	
	public ESAggsValue addSum(ESAggsTypeSum typeSum){
		value.put(ES_SUM, typeSum.value());
		return this;
	}
	
	public ESAggsValue addAggs(ESAggs agg){
		value.put(ES_AGGS, agg.value());
		return this;
	}
	
	public ESAggsValue addFilter(ESAggsTypeFilter filter){
		value.put(ES_FILTER, filter.value());
		return this;
	}
	
	public ESAggsValue addNested(ESAggsTypeNested nested){
		value.put(ES_NESTED, nested.value());
		return this;
	}
	
	
}
