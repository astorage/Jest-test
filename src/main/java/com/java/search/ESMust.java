package com.java.search;

import java.util.Collection;

/**
 * ES语法 must
 * @author cedric
 */
public class ESMust extends ESArrayBase {

	/**
	 * 创建实例
	 * @return 实例
	 */
	public static ESMust builder() {
		ESMust ins = new ESMust();
		ins.build.put(ES_MUST, ins.array);
		return ins;
	}

	/**
	 * 创建must条件
	 * @return 提交集
	 */
	public Collection<Object> value() {
		return array;
	}

}
