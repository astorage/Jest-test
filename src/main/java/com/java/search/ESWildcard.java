package com.java.search;

import java.util.Map;

/**
 * "wildcard": {"tp_buyer": {"value": "ijix*"}}
 * @author cedric
 */
public class ESWildcard extends ESBase {

	public static ESWildcard builder(String field, Object value) {

		Map<String, Object> v = map();
		v.put(ES_VALUE, value);

		ESWildcard term = new ESWildcard();

		term.value.put(field, v);
		term.build.put(ES_WILDCARD, term.value());
		return term;
	}

}
