package com.kh.inheritance.run;

import com.kh.inheritance.model.dto.BasicPhone;
import com.kh.inheritance.model.dto.SmartPhone;

public class Run {
	public static void main(String[] args) {
		SmartPhone smp = new SmartPhone("Samsung", "갤럭시24", 2024, 1200000, "Android", 128);
		
		smp.printInfo();
		
		System.out.println("=======================");
		
		BasicPhone bsp = new BasicPhone("Nokia", "3310", 2000, 10000, true);

		bsp.printInfo();
		bsp.checkKeyboard();
	}
}
