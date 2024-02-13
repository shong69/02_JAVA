package edu.kh.oop.method.model.run;

import edu.kh.oop.method.service.MemberService;

public class MemberRun {
	public       static     void    main(String[] args) {
//[접근제한자]	[예약어]   반환형	메서드명([매개변수])
		//=>대괄호 안에 있는 건 생략 가능함
		
		MemberService service = new MemberService();
								//MemberService의 기본 생성자(자동으로 생성된)
							    //컴파일러가 코드를 번역할 때 클래스 내부에 생성자가 하나도 없다면 자동으로 기본생성자 추가해줌
								//*주의사항 : 생성자가 하나라도 있을 때는 기본생성자를 직접입력 해야함
		service.displayMenu();
		
		
		
		
		
		
	}
}
