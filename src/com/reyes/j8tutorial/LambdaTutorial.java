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
	 * - 一種匿名函數，一段可以傳遞的方法；引入 -> 操作符
	 * - 左側
	 * 		Lambda表達式的參數列表
	 * 		可以看成當要實現一個interface方法時，需要傳入的參數
	 * - 右側
	 * 		Lambda表達式中所需要執行功能，即Lambda體
	 * 		可以看成當要實現一個interface方法時，需要實現的主體
	 * 
	 * - interfacefunction，Lambda需要一個函數式接口
	 * 		一個interface中，只有一個抽象方法的接口，即為interfacefunction
	 * 		使用@FunctionInterface宣告，作用，檢查此interface是否符合函數式接口
	 * 
	 * - 語法格式
	 * 		- 無參數、無法回值
	 * 			() -> System.out.println("")
	 * 		- 有一個參數、無法回值
	 * 			(x) -> System.out.println("")
	 * 		- 只有一個參數時，參數的小括號，可以省略
	 * 		- 如果有多條與句，則Lambda需要寫大括號
	 * 		- 如果只有一條與句，return和大括號都可以省略
	 * 		- 參數列表的數據類型可以省略不寫，因為jvm編譯器可以通過上下文推斷出數據的類型，稱之為類型推斷
	 * 
	 * 左右欲一括號省(return省)
	 * 左側推斷類型省
	 * 
	 */
	
	public static void main(String[] args) {
		LambdaTutorial LambdaTutorial = new LambdaTutorial();
		LambdaTutorial.test1();
		LambdaTutorial.test2();
		LambdaTutorial.test3();
		LambdaTutorial.test4();
		LambdaTutorial.test5();
		
//		轉換大寫
		System.out.println(LambdaTutorial.changeStr("aVbcd", (x) -> x.toUpperCase()));
		
//		取締第一個字
		System.out.println(LambdaTutorial.changeStr("陳文得", x -> x.substring(0, 1)));
		
//		測試相加
		System.out.println(LambdaTutorial.changeNumber(1, 2, (x, y) -> x + y));
		
//		測試相加
		System.out.println(LambdaTutorial.changeNumber(1, 2, (x, y) -> x * y));
		
		System.out.println("========== 練習 ============== ");
		LambdaTutorial.test6();
		
		System.out.println(LambdaTutorial.test7("aFa", (x) -> x.toUpperCase()));
		
		System.out.println(LambdaTutorial.test8(1l,  2l, (l1, l2) -> l1 + l2));
		System.out.println(LambdaTutorial.test8(1l,  2l, (l1, l2) -> l1 * l2));
		
	}

	/**
	 * 語法格式，無參數、無法回值
	 */
	public void test1() {
		
//		在1.7版本之前，在匿名函數中使用外部變量，需要加上final；在java8，則不用加，會自動默認。
//		但要注意，其仍然為final變量，不得修改的
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
	 * 語法格式，有一個參數、無法回值
	 * 		Consumer，FunctionalInterface，一個參數無法回值
	 */
	public void test2() {
		Consumer<String> con = (x) -> System.out.println(x);
		con.accept("真是攝氏");
		
	}
	
	/**
	 * 語法格式，只有一個參數時，參數的小括號，可以省略
	 */
	public void test3() {
		Consumer<String> con = x -> System.out.println(x);
		con.accept("真是攝氏");
		
	}
	
	/**
	 * 如果有多條與句，則Lambda需要寫大括號
	 */
	public void test4() {
		Comparator<Integer> c = (x, y) -> {
			System.out.println("xxx");
			return Integer.compare(x, y);
		};
		System.out.println(c.compare(1, 2));
	}
	
	/**
	 * 如果只有一條與句，return和大括號都可以省略
	 */
	public void test5() {
		Comparator<Integer> c = (x, y) -> Integer.compare(x, y);
		System.out.println(c.compare(1, 2));
	}
	
	
	/**
	 * Lambda測試一，自行撰寫functioninterface
	 */
	public String changeStr(String str, FuncInterface01 fn1) {
		return fn1.getStringChange(str);
	}
	
	/**
	 * Lambda測試二，定義泛型接口
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
