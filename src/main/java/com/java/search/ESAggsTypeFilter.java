package com.java.search;

/**
 * 聚合类型
 * @author cedric
 */
public class ESAggsTypeFilter extends ESAggsType {

	/**
	 * 创建Filter聚合类型
	 * @return 实例
	 */
	public static ESAggsTypeFilter builder() {

		ESAggsTypeFilter type = new ESAggsTypeFilter();
		type.build.put(ES_FILTER, type.value);
		return type;
	}

	/**
	 * 添加terms 过滤
	 * @param terms 过滤
	 * @return 实例
	 */
	public ESAggsTypeFilter addTerms(ESTerms terms) {
		value.put(ES_TERMS, terms.value());
		return this;
	}
	
	/**
	 * 添加bool 过滤
	 * 
	 * @param bool
	 * @return
	 */
	public ESAggsTypeFilter addBool(ESBool bool){
		value.put(ES_BOOL, bool.value());
		return this;
	}

}
