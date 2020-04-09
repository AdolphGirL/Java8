package com.reyes.j8tutorial;

import java.util.function.Consumer;

public class ConsumerTutorial {
	
	public static void main(String[] args) {
		new ConsumerTutorial().test();
	}
	
	public void test() {
		happy(1000.0, (m)->System.out.println("總共花了多少錢: " + m));
	}
	
	/**
	 * 消費型接口，無返回值
	 * Consumer -> void accept(T t);
	 */
	public void happy(Double money, Consumer<Double> con) {
		con.accept(money);
	}

}
