package com.java;

import lombok.Data;

import java.util.Collection;

/**
 * ES查询结果
 * @author cedric
 * @param <T>
 */
@Data
public class ESResult<T> {

	private long total;
	private Collection<T> values;

}
