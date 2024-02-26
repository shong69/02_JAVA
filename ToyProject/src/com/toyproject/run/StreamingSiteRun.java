package com.toyproject.run;

import java.io.IOException;

import com.toyproject.view.StreamingSiteView;

public class StreamingSiteRun {

	public static void main(String[] args) {
		System.out.println("========= 프로그램 실행 ==========");
		StreamingSiteView view = new StreamingSiteView();
		view.startPage();
	}
}
