package com.reyes.j8tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierTutorial {
	
	/**
	 * �H�����ͤ@���w�Ӽ�(�p��100)�}�C
	 */
	public static void main(String[] args) {
		List<Integer> nums = new SupplierTutorial().genList(10, () -> (int)(Math.random()*100));
		nums.forEach(System.out::println);
	}
	
	/**
	 * �ѵ������f
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
