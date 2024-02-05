package edu.kh.control.branch;

import java.util.Scanner;

public class BranchExample {
	Scanner sc = new Scanner(System.in);
	
	public void ex1() {
		//1부터 10까지 1씩 증가하며 출력하는 반복문 작성
		//단 5를 출력하면 반복문 종료
		//1 2 3 4 5 
		
		for(int i = 1; i<=10;i++) {
			System.out.println(i+" ");
			if(i==5) {
				break;
			}
		}
	}
	
	public void ex2() {
		//입력받은 모든 문자열을 누적
		//단, "exit@" 입력 시 문자열 누적을 종료하고 결과 출력
		
		String str = "";
		
		while(true) {
			System.out.print("문자열 입력(exit@ 입력 시 종료) : ");
			String input =  sc.nextLine(); //next()(한 단어만 받아옴)와 달리 nextline()(한 줄 받아옴)은 공백까지 받아온다
			if(input.equals("exit@")) {
				//if(str == "exit@")
				//String 자료형은 비교연산자(==)로 같은 문자열인지 판별할 수 없음
				//비교연산자는 보통 기본 자료형끼리의 연산에서만 사용 가능함
				//->String은 기본자료형이 아닌 참조형임
				
				//해결방법 : 문자열1.equals(문자열2)로 비교 가능하다
				
				break;
			}
			
			str += input + "\n";
		}
		
		
		System.out.println("=========");
		System.out.println(str);
	}
	
	public void ex3() {
		//continue : 다음 반복으로 넘어감
		
		//1~10까지 1씩 증가하며 출력 단, 3의 배수는 제외
		for(int i=1;i<=10;i++) {
			if(i%3 == 0) {
				continue;
			}
			
			System.out.print(i + " ");
		}
	}
	
	public void ex4() {
		//1~100까지 1씩 증가하며 출력하는 반복문
		//단 5의 배수는 건너뛰고 증가하는 값이 40이 되었을 때 반복을 멈춘다
		
		for(int i =1 ;i <=100; i++) {
			if(i == 40) {
				break;
			}
			if(i%5==0) {
				continue;  
				//continue가 break보다 위에 있으면 break문을 만나기 전에 continue가 진행되어 for문이 끝까지 가버린다
			}
			System.out.println(i);

			
		}
	}
	
	public void RSPgame() {
		//가위바위보 게임
		//몇 판 할지 입력 받음
		//입력받은 판 수만큼 게임을 반복
		//컴퓨터 : Math.random() 0~1 미만 난수 생성
		//1~3의 난수를 생성해 1->가위 2->바위 3->보 지정(switch 사용)
		//플레이어도 셋 중 하나를 입력해 게임 판별하기
		//플레이어 승!/졌습니다ㅜㅜ 출력하기
		//매 판마다 "현재 기록 : 몇승 몇무 몇패"라고 출력하기
		
		System.out.println("[가위 바위 보 게임~!!]");
		
		System.out.print("몇 판? : ");
		int games = sc.nextInt();
		int win = 0;
		int same = 0;
		int lose = 0;
		for(int i = 1;i<=games;i++) {
			System.out.printf("%d번째 게임\n",i);
			
			
			int random = (int)(Math.random()*3+1); //int형으로 형변환을 시켜줬기 때문에 floor로 소수점 버림처리 안해도 됨
			String pcValue =null;
			//null : 아무것도 참조하고 있지 않음
		
			switch(random) {
			case 1: pcValue="가위"; break;
			case 2: pcValue="바위";break;
			case 3: pcValue="보";break;
			}
			
			System.out.print("가위/바위/보 중 하나를 입력해주세요 : ");
			String value = sc.next();
			
			System.out.println("컴퓨터는 "+ pcValue+"를 선택했습니다.");

			
			if(value.equals(pcValue)) {
				same += 1;
			}else if(value.equals("가위")){
				
				if(pcValue.equals("바위")){
					lose +=1;
					System.out.println("졌습니다ㅜ");
				}else if(pcValue.equals("보")) {
					win += 1;
					System.out.println("이겼습니다!");
				}
			}else if(value.equals("바위")) {
				
				if(pcValue.equals("보")){
					lose +=1;
					System.out.println("졌습니다ㅜ");

				}else if(pcValue.equals("가위")) {
					win += 1;
					System.out.println("이겼습니다!");

				}
			}else{
				if(pcValue.equals("가위")){
					lose +=1;
					System.out.println("졌습니다ㅜ");

				}else if(pcValue.equals("바위")) {
					win += 1;
					System.out.println("이겼습니다!");

				}
			}
			/* 선생님 코드
			if(value.equals(pcValue)) {
				same += 1;
			}else {
				boolean win1 = value.equals("가위")&&pcValue.equals("보");
				boolean win2 = value.equals("바위")&&pcValue.equals("가위");
				boolean win3 = value.equals("보")&&pcValue.equals("바위");
				if (win1 || win2||win3) {
					System.out.println("플레이어 승");
					win ++;
				}else {
					System.out.println("졌습니다.");
					lose++;
				}
			}
			*/
			
						
			System.out.printf("현재 기록 : %d승 %d무 %d패\n", win, same, lose);
			System.out.println();
		}
	}
	
	
}
