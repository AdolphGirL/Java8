package com.reyes.j8tutorial;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import com.reyes.j8tutorial.lambda.FuncInterface01;
import com.reyes.j8tutorial.lambda.FuncInterface02;
import com.reyes.j8tutorial.lambda.FuncInterface03;
import com.reyes.j8tutorial.lambda.FuncInterface04;

public class LambdaTutorial {
	
	
	
	/**
	 * Lambda
	 * - �@�ذΦW��ơA�@�q�i�H�ǻ�����k�F�ޤJ -> �ާ@��
	 * - ����
	 * 		Lambda��F�����ѼƦC��
	 * 		�i�H�ݦ���n��{�@��interface��k�ɡA�ݭn�ǤJ���Ѽ�
	 * - �k��
	 * 		Lambda��F�����һݭn����\��A�YLambda��
	 * 		�i�H�ݦ���n��{�@��interface��k�ɡA�ݭn��{���D��
	 * 
	 * - interfacefunction�ALambda�ݭn�@�Ө�Ʀ����f
	 * 		�@��interface���A�u���@�ө�H��k�����f�A�Y��interfacefunction
	 * 		�ϥ�@FunctionInterface�ŧi�A�@�ΡA�ˬd��interface�O�_�ŦX��Ʀ����f
	 * 
	 * - �y�k�榡
	 * 		- �L�ѼơB�L�k�^��
	 * 			() -> System.out.println("")
	 * 		- ���@�ӰѼơB�L�k�^��
	 * 			(x) -> System.out.println("")
	 * 		- �u���@�ӰѼƮɡA�Ѽƪ��p�A���A�i�H�ٲ�
	 * 		- �p�G���h���P�y�A�hLambda�ݭn�g�j�A��
	 * 		- �p�G�u���@���P�y�Areturn�M�j�A�����i�H�ٲ�
	 * 		- �ѼƦC���ƾ������i�H�ٲ����g�A�]��jvm�sĶ���i�H�q�L�W�U����_�X�ƾڪ������A�٤����������_
	 * 
	 * ���k���@�A����(return��)
	 * �������_������
	 * 
	 */
	
	public static void main(String[] args) {
		LambdaTutorial LambdaTutorial = new LambdaTutorial();
		LambdaTutorial.test1();
		LambdaTutorial.test2();
		LambdaTutorial.test3();
		LambdaTutorial.test4();
		LambdaTutorial.test5();
		
//		�ഫ�j�g
		System.out.println(LambdaTutorial.changeStr("aVbcd", (x) -> x.toUpperCase()));
		
//		���l�Ĥ@�Ӧr
		System.out.println(LambdaTutorial.changeStr("����o", x -> x.substring(0, 1)));
		
//		���լۥ[
		System.out.println(LambdaTutorial.changeNumber(1, 2, (x, y) -> x + y));
		
//		���լۥ[
		System.out.println(LambdaTutorial.changeNumber(1, 2, (x, y) -> x * y));
		
		System.out.println("========== �m�� ============== ");
		LambdaTutorial.test6();
		
		System.out.println(LambdaTutorial.test7("aFa", (x) -> x.toUpperCase()));
		
		System.out.println(LambdaTutorial.test8(1l,  2l, (l1, l2) -> l1 + l2));
		System.out.println(LambdaTutorial.test8(1l,  2l, (l1, l2) -> l1 * l2));
		
	}

	/**
	 * �y�k�榡�A�L�ѼơB�L�k�^��
	 */
	public void test1() {
		
//		�b1.7�������e�A�b�ΦW��Ƥ��ϥΥ~���ܶq�A�ݭn�[�Wfinal�F�bjava8�A�h���Υ[�A�|�۰��q�{�C
//		���n�`�N�A�䤴�M��final�ܶq�A���o�ק諸
		int num = 0;
		
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("hello r1: " + num);
				
			}
			
		};
		r1.run();
		
		Runnable r2 = () -> System.out.println("hello r2: " + num);
		r2.run();
		
	}
	
	/**
	 * �y�k�榡�A���@�ӰѼơB�L�k�^��
	 * 		Consumer�AFunctionalInterface�A�@�ӰѼƵL�k�^��
	 */
	public void test2() {
		Consumer<String> con = (x) -> System.out.println(x);
		con.accept("�u�O���");
		
	}
	
	/**
	 * �y�k�榡�A�u���@�ӰѼƮɡA�Ѽƪ��p�A���A�i�H�ٲ�
	 */
	public void test3() {
		Consumer<String> con = x -> System.out.println(x);
		con.accept("�u�O���");
		
	}
	
	/**
	 * �p�G���h���P�y�A�hLambda�ݭn�g�j�A��
	 */
	public void test4() {
		Comparator<Integer> c = (x, y) -> {
			System.out.println("xxx");
			return Integer.compare(x, y);
		};
		System.out.println(c.compare(1, 2));
	}
	
	/**
	 * �p�G�u���@���P�y�Areturn�M�j�A�����i�H�ٲ�
	 */
	public void test5() {
		Comparator<Integer> c = (x, y) -> Integer.compare(x, y);
		System.out.println(c.compare(1, 2));
	}
	
	
	/**
	 * Lambda���դ@�A�ۦ漶�gfunctioninterface
	 */
	public String changeStr(String str, FuncInterface01 fn1) {
		return fn1.getStringChange(str);
	}
	
	/**
	 * Lambda���դG�A�w�q�x�����f
	 */
	public Integer changeNumber(Integer i1, Integer i2, FuncInterface02<Integer, Integer> fn2) {
		return fn2.opInteger(i1, i2);
	}
	
	private static List<User> users = Arrays.asList(
		new User("A-name", 25), new User("B-name", 25),
		new User("A-name", 30) 
	);
	
	public void test6() {
		Collections.sort(users, (u1, u2) -> {
			if(u1.getAge() == u2.getAge()) {
				return u1.getName().compareTo(u2.getName());
			}else {
				return Integer.compare(u1.getAge(), u2.getAge());
			}
		});
		
		users.forEach(System.out::println);
		
	}
	
	public String test7(String str, FuncInterface03 fun) {
		return fun.getValue(str);
	}
	
	public Long test8(Long l1, Long l2, FuncInterface04<Long, Long> fun) {
		return fun.addValue(l1, l2);
	}
	
}

class User {
	private String name;
	private Integer age;
	
	public User() {
		
	}
	
	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
	
}
