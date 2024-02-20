package edu.kh.collection.pack1.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.pack1.model.vo.Student;





public class StudentService {

	//필드
	private Scanner sc = new Scanner(System.in); 
	
	//학생 정보를 저장할 리스트 생성
	
	//java.util.List 인터페이스 : List에 반드시 필요한 필수 기능을 모아둔 인터페이스
	//*인터페이스 객체 생성 X, 부모 참조변수로써의 역할 O
	
	//java.util.ArrayList : 배열 형태의 List (가장 대표적인 List 자식 클래스)
	
	//ArrayList() 기본생성자 : 기본 크기 10짜리 리스트 생성됨
	//						-->하지만 리스트는 크기가 늘었다 줄었다 하기 때문에 큰 의미는 없음
	
	//ArrayList(용량) : 용량만큼의 리스트 생성
	//					-->너무 큰 값을 작성하면 메모리 소모 많음
	
	//private List<Student> studentList= new ArrayList<Student>(); //검색(조회)에 효율적인 리스트
	//<Student> Student 객체만 받아들이도록 하는 제네릭스
	
	private List<Student> studentList= new LinkedList<Student>(); //추가, 수정, 삭제에 효율적
	
	public StudentService() {//기본 생성자에 학생개체 5개 넣기
		
		studentList.add(new Student("차은우", 26, "서울시 마포구", 'M', 100));
		studentList.add(new Student("고영희", 23, "경기도 안산시", 'F', 90));
		studentList.add(new Student("조마루", 17, "충북 청주시", 'F', 50));
		studentList.add(new Student("한라봉", 24, "제주도 제주시", 'M', 80));
		studentList.add(new Student("강아지", 22, "서울시 강서구", 'F', 90));
		
	}
	public void ex() {
		//List 테스트
		
		//List.add(Object e) : 리스트에 객체를 추가하는 메서드
		// * Object는 모든 객체의 최상위 클래스 ->매개변수 타입이 Object == 모든 객체를 매개변수로 전달할 수 있다
		studentList.add(new Student()); //0번째 인덱스에 Student 객체 삽입
		//studentList.add(sc); //1번
		//studentList.add("문자열"); //2번
		//studentList.add(new Object()); //3번
		
		//컬렉션 특징 : 여러타입의 데이터를 저장할 수 있다.
		
		
		
		
		
		//Object List.get(index i) : 리스트에서 i번째 인덱스에 있는 객체를 반환해준다
		//반환형이 Object == 모든 객체를 반환할 수 있다.
		
		if (studentList.get(0) instanceof Student ) {//studentList의 0번째 인덱스에서 꺼내온 애가 Student 객체와 관련 있냐
			System.out.println(((Student)studentList.get(0)).getName()); 
		}
		//get메서드로 얻어온 객체가 Student형이라면 강제 형변환 후 getName메서드를 사용할 수 있다
		//Student 객체를 초기화 하지 않았기 때문에 null값이 호출됨
		
		//System.out.println(studentList.get(1));
		//System.out.println(studentList.get(2));
		//System.out.println(studentList.get(3));
		
		
		
		
		
		//제네릭스(Generics) 
		//->컬렉션에 저장되는 객체 타입을 한가지로 제한함 : <E>
		
		
		
		
		
	}
	
	
	//메뉴 출력용 메서드
	
	/**
	 *alt + shift + j
	 *메서드 설명용 주석 
	 *@author shong7576@gmail.com
	 *@exception ->메서드에서 발생할 것 같은 예외
	 *@return ->반환형으로 뭐가 가는지
	 */
	public void displayMenu() throws InputMismatchException{
		
		int menuNum = 0; //메뉴 선택용 변수
		
		do {
			System.out.println("\n==================학생 관리 프로그램=====================\n");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 정보 전체 조회");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 제거");
			System.out.println("5. 이름으로 검색(일치)");
			System.out.println("6. 이름으로 검색(포함)");
			System.out.println("7. 나이순으로 정렬"); //Comparable 사용
			System.out.println("8. 이름순으로 정렬"); //comparator 사용
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 번호 선택 : ");
			
			
			try {
				
				menuNum = sc.nextInt();
				System.out.println();
				
				switch(menuNum) {
				case 1: System.out.println(addStudent()); break;
				case 2: selectAll(); break;
				case 3: System.out.println(updateStudent());break;
				case 4: System.out.println(removeStudent()); break;
				case 5: System.out.println(searchName1()); break;
				case 6: System.out.println(searchName2()); break;
				case 7: sortByAge(); break;
				case 8: sortByName(); break;
				case 0: System.out.println("프로그램 종료"); break;
				
				default: System.out.println("메뉴에 작성된 번호만 입력하세요");
				
				}
			}catch(InputMismatchException e) {
				System.out.println("\nerror : 입력 형식이 유효하지 않습니다. 다시 시도해주세요");
				sc.nextLine(); //입력 버퍼에 남아있는 잘못된 코드 제거
				
				//첫 반복에서 잘못 입력한 경우 menuNum이 아직 0인 상태
				menuNum = -1; //while문 탈출 막기 위해서 -1 대입해줌
			}
			
			
		}while(menuNum !=0);
		
		
		
	}
	
	
	/**
	 * 1. 학생 정보 추가 메서드
	 * - 추가 성공 시 "성공" 실패 시 "실패"문자열 반환
	 */

	public String addStudent() {
		System.out.println("==========학생 정보 추가==========");
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine(); //입력 버퍼 개행 문자 제거용
		
		System.out.print("사는 곳 : ");
		String region = sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0); //한자리만 받아와서 작은따옴표로 묶일 수 있도록 함
		
		System.out.print("점수 : ");
		int score = sc.nextInt();
		
		
		//Student 객체 생성 후 List에 추가하기
		if(studentList.add(new Student(name, age, region, gender, score))) {
			//boolean java.util.List.add(Student e)
			//(반환형)				->제네릭<Student> 때문에 List에 추가할 수 있는 객체 타입이 Student로 제한됨
			
			return "성공";
			
		}else {
			return "실패";
		}
		
	
		
	}
	
	
	/**
	 * 2. 학생 전체 조회 메서드
	 * - List가 비어있는 경우 "학생정보가 없습니다" 출력
	 * - 있는 경우 전체 학생 출력
	 */
	public void selectAll() {
		//- List에 저장된 데이터의 개수를 얻어오는 방법 : List.size()
		//- 배열명.length 대신 사용
		
		System.out.println("==========학생 정보 조회==========");
		
		//if(studentList.size() == 0) 
		if(studentList.isEmpty()){ //컬렉션이 비어있다면 True 반환
			//studentList가 비어있는 경우 "학생정보가 없습니다" 출력
			System.out.println("학생 정보가 없습니다");
			return; //반환 없이 메서드 바로 종료 후 돌아갈거임
			
		}else {
			
			/*일반 for문
			for(int i = 0; i<studentList.size();i++) {
				System.out.println(studentList.get(i));
			}*/
			
			//향상된 for문(for each문)
			//- 컬렉션, 배열의 모든 요소를 순차적으로 반복접근할 수 있는 for문
			//(순차적 : 0번인덱스 ~마지막 인덱스 요소까지 1씩 증가)
			
			
			//작성법
			//for(컬렉션 또는 배열에서 꺼낸 한개의 요소를 저장할 변수 : 컬렉션명 또는 배열명) {}
			int index = 0;
			for(Student student : studentList) {
				//student에는 for문 반복할때마다 0,1,2...인덱스 요소들 한번씩 저장됨
				System.out.print((index++)+"번 : ");
				System.out.println(student);
			}
		}
		
		
		
		
		
	}
	
 
	
	/**
	 * 3. 학생 정보 수정 메서드
	 * - 학생 정보 studentList에 있는지 검사, 없다면 "입력된 학생 정보가 없습니다" 문자열 리턴
	 * - 입력된 숫자가 0보다 작은지 검사, 작으면 "음수는 입력할 수 없습니다"문자열 반환
	 * - studentList 범위 내 인덱스 번호인지 검사, 초과했다면 "범위를 넘어선 값을 입력할 수 없습니다" 문자열 반환
	 * - 수정이 완료되었다면, 000의 정보가 변경되었습니다.  문자열 반환
	 */
	public String updateStudent() throws InputMismatchException {
		//Student List.set(int index, Student e)
		//->List의 index번째 요소를 전달받은 e로 변경
		//->반환값 Student == 변경 전 Student 객체가 담겨있다.
		
		System.out.println("==========학생 정보 수정==========");
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		//1)학생 정보 studentList에 있는지 검사, 없다면 "입력된 학생 정보가 없습니다" 문자열 리턴
		if(studentList.isEmpty()) {
			return "입력된 학생 정보가 없습니다";
			
		//2)입력된 숫자가 0보다 작은지 검사, 작으면 "음수는 입력할 수 없습니다"문자열 반환	
		}else if(index<0) {
			return "음수는 입력할 수 없습니다";
			
		//3)studentList 범위 내 인덱스 번호인지 검사, 초과했다면 "범위를 넘어선 값을 입력할 수 없습니다" 문자열 반환
		}else if(index>=studentList.size()) {
			return "범위를 넘어선 값을 입력할 수 없습니다";
			
		//4)만약 문자열을 입력한 경우 -> 에러(InputMismathException)발생 -> throws 작성
		//5)잘 통과했을 때 수정코드 작성
		}else {
			System.out.println(index + "번째에 저장된 학생 정보");
			System.out.println(studentList.get(index));
			

			System.out.print("이름 : ");
			String name = sc.next();
			
			System.out.print("나이 : ");
			int age = sc.nextInt();
			sc.nextLine(); //입력 버퍼 개행 문자 제거용
			
			System.out.print("사는 곳 : ");
			String region = sc.nextLine();
			
			System.out.print("성별(M/F) : ");
			char gender = sc.next().charAt(0); //한자리만 받아와서 작은따옴표로 묶일 수 있도록 함
			
			System.out.print("점수 : ");
			int score = sc.nextInt();
			
			//입력받은 index번째에 새로운 학생 정보를 세팅 == 수정
			//index번째에 있던 기존 학생 정보가 반환되고, 그 객체를 temp에 저장한다.
			Student temp = studentList.set(index, new Student(name, age, region, gender, score));
			
			return temp.getName()+"의 정보가 변경되었습니다.";
			
		}
		
		
	}
	
	
	
	/**
	 * 4. 학생 정보 제거 메서드
	 * @return String
	 */
	public String removeStudent () throws InputMismatchException{
		
		//Student List.remove(int index) 
		//리스트에서 index번째 요소를 제거할 때 사용
		//이 때, 제거된 요소가 반환된다.
		
		//*List는 중간에 비어있는 인덱스가 없게 하기 위해 remove 동작 시 뒤쪽 요소를 한 칸씩 당겨온다
		
		System.out.println("==========학생 정보 제거==========");
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		
		//1)학생 정보 studentList에 있는지 검사, 없다면 "입력된 학생 정보가 없습니다" 문자열 리턴
		if(studentList.isEmpty()) {
			return "입력된 학생 정보가 없습니다";
			
		//2)입력된 숫자가 0보다 작은지 검사, 작으면 "음수는 입력할 수 없습니다"문자열 반환	
		}else if(index<0) {
			return "음수는 입력할 수 없습니다";
			
		//3)studentList 범위 내 인덱스 번호인지 검사, 초과했다면 "범위를 넘어선 값을 입력할 수 없습니다" 문자열 반환
		}else if(index>=studentList.size()) {
			return "범위를 넘어선 값을 입력할 수 없습니다";
			
		//4)만약 문자열을 입력한 경우 -> 에러(InputMismathException)발생 -> throws 작성
		//5)잘 통과했을 때 수정코드 작성
		}else {
			//학생 정보 제거 코드 작성
			
			System.out.println("정말 삭제하시겠습니까?(y/n) : ");
			char ch = sc.next().toUpperCase().charAt(0);
			//String 대문자 -> 대문자의 0번 인덱스 문자 얻어옴
			
			//String.toUpperCase() : 문자열을 대문자로 변경
			//String.toLowerCase() : 문자열을 소문자로 변경
			
			if(ch=='Y') {
				Student temp = studentList.remove(index);
				return temp.getName()+"의 정보가 제거되었습니다.";
				
			}else {
				return "취소";
			}
			
			
		}
		
	}
	
	
	
	/**
	 * 5. 이름으로 검색(일치)
	 * 검색할 이름 입력받기 studentList에서 꺼내온 Student 객체의 name값이 같은지 비교
	 * - 일치하는 경우 Student 객체 출력
	 * - 일치하지 않는 경우 "검색 결과가 없습니다" 출력
	 * 
	 */
	public String searchName1() {
		System.out.println("==========학생 검색(완전 일치)==========");
		System.out.print("이름을 입력하세요(일치) : ");
		String inputName = sc.next();
		
		for(Student std : studentList) {
			if(std.getName().equals(inputName)) {
				return std.toString();
			}
		}
		return "검색 결과가 없습니다";
		
	}
	
	
	
	/**
	 * 6. 이름으로 검색(일부)
	 * 이름에 특정 문자열이 포함되는 학생을 찾아서 조회하는 메서드
	 * 문자열 입력 받아 studentList에서 꺼내온 Student 객체의 name값에 포함되는 문자열인지 검사
	 * - 포함되는 경우 student 객체 출력
	 * - 없다면 "검색결과가 없습니다" 출력 
	 */
	public String searchName2() {
		//boolean String.contains(문자열) : String에 문자열이 포함돼있으면 True, 없으면 false
		System.out.println("==========학생 검색(문자열 포함)==========");
		System.out.print("이름을 입력하세요(일부 검색) : ");
		String inputName = sc.next();
		
		for(Student std : studentList) {
			if(std.getName().contains(inputName)) {
				return std.toString();
			}
		}
		return "검색 결과가 없습니다";
	}
	
	/**
	 * 7. 나이순으로 정렬
	 */
	public void sortByAge() {
		Collections.sort(studentList);
		
		//정렬된 결과 출력
		for(Student std : studentList) {
			System.out.println(std);
		}
	}
	
	public void sortByName() {
		
		
		//이름에 따라 정렬하는 Comparator 객체 생성하기
		Comparator<Student> nameComparator= Comparator.comparing(Student::getName);
		//Comparator<Student> ageComparator= Comparator.comparing(Student::getScore);//여러개 정렬 가능
		//Comparator 인터페이스의 static 메서드인 compraing()을 사용하여 Comparator 객체를 생성
		//->comparing() 주어진 키(key)를 기반으로 객체를 비교
		//Student::getName  :메서드 레퍼런스(Method Reference)
		//->Student클래스의 getName()을 가리키는 것
		//->이 메서드를 비교의 키로 사용하여 각 Student 객체를 비교하고 정렬함
		
		//=> Comparator.comparing(Student::getName)은 
		//이름(name)을 기준으로 학생(Student)객체를 비교하는 Comparator를 생성한 것
		
		
		//이름에 따라 정렬
		Collections.sort(studentList, nameComparator);
		//정렬된 결과 출력
		for(Student std : studentList){
			System.out.println(std);
		}
		
		
		
		
	}
}
