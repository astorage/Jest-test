package com.java.search;


/**
 * "match_phrase": {"tp_memo": "杭州"}
 * @author cedric
 */
public class ESMatchPhrase extends ESBase {

	public static ESMatchPhrase builder(String field, Object value) {
		ESMatchPhrase term = new ESMatchPhrase();

		term.value.put(field, value);
		term.build.put(ES_MATCH_PHRASE, term.value());
		return term;
	}

}
