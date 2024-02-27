package edu.kh.lambda.test.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.kh.lambda.test.LambdaTest;

public class TestRun {

	public static void main(String[] args) {
		LambdaTest lt = new LambdaTest();
		lt.ex();
		
		System.out.println("===============================");
		
		//comparator의 compare()메서드를 람다식으로 대체하여 사용하기
		
		//숫자 리스트 생성
		List<Integer> numbers  = new ArrayList<Integer>();
		numbers.add(12);
		numbers.add(99);
		numbers.add(23);
		numbers.add(76);
		
		System.out.println("정렬 전 : "+numbers);
		
		//숫자를 오름차순으로 정렬하는 람다식
		Collections.sort(numbers, (a,b)-> a-b);
		System.out.println("정렬 후 : "+numbers);
		
		
		//Runnable 인터페이스를 람다식으로 구현
		
		
		Runnable runnable = () -> {
			//이 안에 run()에서 수행할 코드 작성
			System.out.println("HEllo Lambda!");
		};
		
		//스레드 생성 및 시작
		Thread thread = new Thread(runnable);
		
		thread.start();
		
		
	}
}
