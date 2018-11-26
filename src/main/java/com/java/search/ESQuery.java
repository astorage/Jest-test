package com.java.search;


/**
 * ES查询
 * @author cedric
 */
public class ESQuery extends ESBase {

	public static ESQuery builder() {
		ESQuery ins = new ESQuery();
		ins.build.put(ES_QUERY, ins.value);
		return ins;
	}

	/**
	 * 创建条件
	 * @return 实例
	 */
	public ESQuery addBool(ESBool bool) {
		value.put(ES_BOOL, bool.value());
		return this;
	}

}
