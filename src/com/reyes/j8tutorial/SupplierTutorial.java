package com.reyes.j8tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierTutorial {
	
	/**
	 * 隨機產生一指定個數(小於100)陣列
	 */
	public static void main(String[] args) {
		List<Integer> nums = new SupplierTutorial().genList(10, () -> (int)(Math.random()*100));
		nums.forEach(System.out::println);
	}
	
	/**
	 * 供給型接口
	 * Supplier -> T get();
	 */
	public List<Integer> genList(int num, Supplier<Integer> sup){
		List<Integer> numList = new ArrayList<>();
		
		for(int i=0; i<num; i++) {
			numList.add(sup.get());
		}
		
		return numList;
	}
	
}
