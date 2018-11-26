package com.java.search;


/**
 * ES查询 bool语法
 * @author cedric
 */
public class ESBool extends ESBase {

	public static ESBool builder() {
		ESBool ins = new ESBool();
		ins.build.put(ES_BOOL, ins.value);
		return ins;
	}

	/**
	 * 创建与的条件
	 * @param must 与条件
	 * @return 实例
	 */
	public ESBool addMust(ESArrayBase must) {
		if (must.value() != null) {
			value.put(ES_MUST, must.value());
		}
		return this;
	}

	/**
	 * 添加或的条件
	 * @param should 或条件
	 * @return 实例
	 */
	public ESBool addShould(ESArrayBase should) {
		if (should.value() != null) {
			value.put(ES_SHOULD, should.value());
		}
		return this;
	}

	/**
	 * 创建非条件
	 * @param mustNot 非条件
	 * @return 实例
	 */
	public ESBool addMustNot(ESArrayBase mustNot) {
		if (mustNot.value() != null) {
			value.put(ES_MUST_NOT, mustNot.value());
		}
		return this;
	}

}
