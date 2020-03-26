package com.reyes.j8tutorial;

import java.util.Comparator;
import java.util.function.Consumer;

import com.reyes.j8tutorial.lambda.FuncInterface01;
import com.reyes.j8tutorial.lambda.FuncInterface02;

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
	
}
