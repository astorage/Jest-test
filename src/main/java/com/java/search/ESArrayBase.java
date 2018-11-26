package com.java.search;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ES bool 基础类
 * @author cedric
 */
public class ESArrayBase extends ESBase {
	protected Collection<Object> array = new ArrayList<Object>();

	/**
	 * 添加term条件
	 * @param term 条件
	 * @return 实例
	 */
	public ESArrayBase addTerm(ESTerm term) {
		array.add(term.build());
		return this;
	}

	/**
	 * 添加terms条件
	 * @param terms 条件
	 * @return 实例
	 */
	public ESArrayBase addTerms(ESTerms terms) {
		array.add(terms.build());
		return this;
	}

	/**
	 * 添加range条件
	 * @param range 条件
	 * @return 实例
	 */
	public ESArrayBase addRange(ESRange range) {
		array.add(range.build());
		return this;
	}

	/**
	 * 增加constantScore条件
	 * @param score 条件
	 * @return 实例
	 */
	public ESArrayBase addConstantScore(ESConstantScore score) {
		array.add(score.build());
		return this;
	}

	/**
	 * 添加wildcard条件
	 * @param wildcard 条件
	 * @return 实例
	 */
	public ESArrayBase addWildcard(ESWildcard wildcard) {
		array.add(wildcard.build());
		return this;
	}

	/**
	 * 添加matchPhrase条件
	 * @param phrase 条件
	 * @return 实例
	 */
	public ESArrayBase addMatchPhrase(ESMatchPhrase phrase) {
		array.add(phrase.build());
		return this;
	}

	/**
	 * 添加bool 条件
	 * @param bool 条件
	 * @return 实例
	 */
	public ESArrayBase addBool(ESBool bool) {
		array.add(bool.build());
		return this;
	}

	/**
	 * 添加nested 条件
	 * @param nested 条件
	 * @return 实例
	 */
	public ESArrayBase addNested(ESNested nested) {
		array.add(nested.build());
		return this;
	}

	/**
	 * 添加exists条件
	 * @param exists 条件
	 * @return 实例
	 */
	public ESArrayBase addExists(ESExists exists) {
		array.add(exists.build());
		return this;
	}
}
