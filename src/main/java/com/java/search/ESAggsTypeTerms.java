package com.java.search;


/**
 * 聚合类型
 * @author cedric
 */
public class ESAggsTypeTerms extends ESAggsType {

	/**
	 * 创建Terms聚合类型
	 * @param value 字段
	 * @return 实例
	 */
	public static ESAggsTypeTerms builder(String value) {

		ESAggsTypeTerms type = new ESAggsTypeTerms();
		type.value.put(ES_FIELD, value);
		type.build.put(ES_TERMS, type.value);

		return type;
	}
	
	/**
	 * 添加size
	 * @param value
	 * @return
	 */
	public ESAggsTypeTerms addSize(int value){
		this.value.put(ES_SIZE, value);
		return this;
	}
	
	public ESAggsTypeTerms addOrder(ESAggsTypeOrder order){
		this.value.put(ES_ORDER, order.value());
		return this;
	}
	
}
