package com.toyproject.view;

import java.io.BufferedReader;
import java.util.Scanner;

//View : 보여지는 부분(내용 출력, 키보드 입력,..)에서의 역할을 한다
public class StreamingSiteView {

	//필드
	private Scanner sc = new Scanner(System.in);
	private BufferedReader br = null;
	//service 객체 변수 추가하기
	
	//기본생성자에서 예외 처리하기
	public StreamingSiteView() {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
