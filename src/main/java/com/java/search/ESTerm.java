package com.java.search;

import java.util.Map;

/**
 * "term": {
 * "field": {
 * "value": "value"
 * }
 * }
 * @author cedric
 */
public class ESTerm extends ESBase {

	public static ESTerm builder(String field, Object value) {

		Map<String, Object> v = map();
		v.put(ES_VALUE, value);

		ESTerm term = new ESTerm();

		term.value.put(field, v);
		term.build.put(ES_TERM, term.value());
		return term;
	}

}
