package com.kh.practice.snack.controller;
import com.kh.practice.snack.model.vo.Snack;

import java.util.Scanner;

public class SnackController {
	private Scanner sc = new Scanner(System.in);
	private Snack s = new Snack();

	
	public String saveData(String kind, String name, String flavor, int numOf, int price) {
		
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
		return "저장 완료되었습니다.";
	}
	
	public String confirmData() {
		//저장된 데이터를 반환하는 메소드

		return ( s.getKind()+"("+s.getName()+" - "+s.getFlavor()+") "+s.getNumOf()+"개 "+s.getPrice()+"원");
	}
}
