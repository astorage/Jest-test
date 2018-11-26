package com.java.search;

import java.util.Collection;

/**
 * ES语法 should
 * @author cedric
 */
public class ESShould extends ESArrayBase {

	/**
	 * 创建实例
	 * @return 实例
	 */
	public static ESShould builder() {
		ESShould ins = new ESShould();
		ins.build.put(ES_SHOULD, ins.array);
		return ins;
	}

	@Override
	public Collection<Object> value() {
		return array;
	}

}
