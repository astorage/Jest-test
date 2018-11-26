package com.java.search;


/**
 * "constant_score": {
 * "filter": {
 * "exists": {
 * "field": "tp_memo"
 * }
 * }
 * }
 * @author cedric
 */
public class ESConstantScore extends ESBase {

	
	@Deprecated
	/**
	 * 已废弃，不可用
	 * @param s
	 * @return
	 */
	public static ESConstantScore existsBuilder(String s){
		return null;
	}
	
	
	/**
	 * 创建对象
	 * @return 实例
	 */
	public static ESConstantScore builder() {
		ESConstantScore s = new ESConstantScore();
		s.build.put(ES_CONSTANT_SCORE, s.value);
		return s;
	}

	/**
	 * 添加Filter
	 * @param filter 过滤器
	 * @return 实例
	 */
	public ESConstantScore addFilter(ESFilter filter) {
		value.put(ES_FILTER, filter.value());
		return this;
	}

	/**
	 * "constant_score": {
	 * "filter": {
	 * "bool": {
	 * "must": {
	 * "exists": {
	 * "field": "[field]"
	 * }
	 * },
	 * "must_not": {
	 * "term": {
	 * "[filed]": ""
	 * }
	 * }
	 * }
	 * }
	 * }<br>
	 * 添加 字段是否存在（不为空同时不为null）
	 * @param field 字段
	 * @return 实例
	 */
	public ESConstantScore addExistsFilter(String field) {
		ESFilter filter = ESFilter.builder().addBool(
			ESBool.builder().addMust(ESMust.builder().addExists(ESExists.builder(field)))
					.addMustNot(ESMustNot.builder().addTerm(ESTerm.builder(field, ""))));
		return addFilter(filter);
	}

}
