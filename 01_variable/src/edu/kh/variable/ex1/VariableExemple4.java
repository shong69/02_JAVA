package edu.kh.variable.ex1;

public class VariableExemple4 {
	public static void main(String[] args) {
		/*강제 형변환
		 * -기존 자료형을 원하는 자료형으로 강제 변환시키는 것
		 * 
		 * 1)값의 범위가 큰 자료형을 값의 범위가 작은 자료형으로 변환할 때 사용한다
		 * 2)출력되는 데이터의 표기법을 변환시키고 싶을 때 사용한다
		 * 
		 * *강제 형변환 방법
		 * -자료형을 변환시키고 싶은 값 또는 변수 앞에 (자료형)을 작성
		 * ex)double temp = 3.14;
		 * int num = (int)temp;
		 * */
		
		double temp = 3.14;
		int num = (int)temp;
		System.out.println(temp);//3.14 출력 
		System.out.println(num); //3이 출력된다
		//실수->정수형 변환 시 소수점 버림 처리(데이터 손식)
		
		//int ->byte 강제 형변환
		int iNum =290;
		byte bNum = (byte)iNum;//자동 형변환이 안되기 때문에 int형을 씌워줘야 한다.
		System.out.println(iNum);//290 출력됨
		System.out.println(bNum);//34 출력됨. 데이터 손실 있음
		
		//같은 정수형끼리의 정수형 변환 시에도 값의 범위 차이 때문에 데이터 손실이 발생한다
		
		//char ->int 강제 형변환
		char ch = 'A'; //65임
		int iNum2 = ch;//자동형변환
		System.out.println((int)ch);//강제 형변환 65 나옴
		//int -> char 강제형변환
		//44085는 뭘까
		int iNum3 = 44085;
		System.out.println((char)iNum3);
		
		
		//--------------------------
		//데이터 오버플로우 : 해당 현상은 컴퓨터가 미리 예측할 수 없기 때문에 개발자가 미리 예측해야 한다
		
		int i6 = 2147483647; //int의 최대값
		int result6=i6 + 1; //int의 최대값을 넘었지만 에러가 나지 않고 있다 ->사람이 미리 생각해야함
		System.out.println(result6); //-2147483648  ->가능한 최저의 숫자로(처음으로) 되돌아감
		
	}
}
