package com.reyes.j8tutorial;

import java.util.function.Consumer;

public class ConsumerTutorial {
	
	public static void main(String[] args) {
		new ConsumerTutorial().test();
	}
	
	public void test() {
		happy(1000.0, (m)->System.out.println("�`�@��F�h�ֿ�: " + m));
	}
	
	/**
	 * ���O�����f�A�L��^��
	 * Consumer -> void accept(T t);
	 */
	public void happy(Double money, Consumer<Double> con) {
		con.accept(money);
	}

}
