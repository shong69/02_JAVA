package edu.kh.op.ex;

//같은 패키지 안에 있기 때문에 OpExemple을 iport 할 필요 없다

public class ExempleRun {//코드 실행용 클래스
	
	//메인 메서드 필수 작성
	public static void main(String[] args) {
		//OpExemple 생성 -> OpExemple이라는 클래스(설계도)를 이용해 객체 생성을 하는데,
		//그 객체의 이름이 ex이다.
		OpExemple ex = new OpExemple();
		
		//ex.ex1(); //ex가 가지고 있는 ex1() 메서드를 실행
		
		ex.ex4();
		
	}

}
