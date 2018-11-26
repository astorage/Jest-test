package com.java.search;

import java.util.Collection;

/**
 * ES语法 ESMustNot
 * @author cedric
 */
public class ESMustNot extends ESArrayBase {

	/**
	 * 创建实例
	 * @return 实例
	 */
	public static ESMustNot builder() {
		ESMustNot ins = new ESMustNot();
		ins.build.put(ES_MUST_NOT, ins.array);
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
