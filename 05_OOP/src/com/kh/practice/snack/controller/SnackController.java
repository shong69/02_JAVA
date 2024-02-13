package com.kh.practice.snack.controller;
import com.kh.practice.snack.model.vo.Snack;

import java.util.Scanner;

public class SnackController {
	private Scanner sc = new Scanner(System.in);
	private Snack s = new Snack();

	
	public String saveData(String kind, String name, String flavor, int numOf, int price) {
		
		
	}
	
	public String confirmData() {
		//저장된 데이터를 반환하는 메소드

		System.out.println("저장한 정보를 확인하시겠습니까?(y/n) : ");
		String inputYn = sc.next();
		
		if(inputYn.equals("n")) {
			return null;
		}else if(inputYn.equals("y")) {
			return (s.getKind()+"("+s.getName()+" - "+s.getFlavor()+") "+s.getNumOf()+"개 "+s.getPrice()+"원");
		}else {
			return "잘못된 입력입니다.";
		}
	}
}
