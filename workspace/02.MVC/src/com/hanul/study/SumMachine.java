package com.hanul.study;

public class SumMachine {

	//getSum() : 전달된 매개변수를 이용하여 누적합(sum)을 계산하고 결과를 리턴
	public int getSum(int num1, int num2) {
		int sum = 0;
		for(int i = num1; i <= num2; i++) {
			sum += i;
		}
		return sum;
	}//getSum()
	
}//class
