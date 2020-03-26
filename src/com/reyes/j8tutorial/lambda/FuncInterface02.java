package com.reyes.j8tutorial.lambda;


/**
 * 需聲明泛型，且有返回值
 */
@FunctionalInterface
public interface FuncInterface02 <T, R> {

	public R opInteger(T t1, T t2);
	
}
