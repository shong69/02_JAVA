package edu.kh.todoList.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImple;

// View : 보여지는 부분(내용 출력, 키보드 입력,..)에서의 역할을 한다
public class TodoListView {

	//필드
	private BufferedReader br = null; //키보드 입력 스트림 참조변수
	private TodoListService service = null; //서비스 참조변수
	
	//기본 생성자
	public TodoListView() {
		
		//객체 생성 시 발생되는 예외를 여기서 모아서 처리할 예정
		try {
			//부모 타입 참조변수 = 자식 객체
			service = new TodoListServiceImple(); //다형성 업캐스팅(인터페이스 참조 못하니까 자식객체 대입)
			
			br = new BufferedReader(new InputStreamReader(System.in));//키보드 입력 가능하도록 객체 생성
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//----------------------------------------아래부터는 메서드------------------------------------------
	
	//displayMenu같은거 만들거임
	
	/**
	 * TodoList 프로그램 시작 화면
	 */
	public void startView() {
		int input = 0;//선택한 메뉴 번호 저장
		do {
			try {
				//선택한 번호가 반환되어 input에 저장됨
				input = selectMenu(); //메서드 호출하도록
				
				switch(input) {
				case 1: todoListFullView(); break;
				//case 2: todoDetailView(); break;
				//case 3: todoAdd(); break;
				//case 4: todoComplete(); break;
				//case 5: todoUpdate(); break;
				//case 6: todoDelete(); break
				case 0: System.out.println("@@프로그램 종료@@"); break;
				
				default : System.out.println("###메뉴에 작성된 번호만 입력해 주세요 ###");
				
				}
				System.out.println("======================================================");

				
			}catch (NumberFormatException e) {
				System.out.println("### 숫자만 입력해 주세요 ###");
				input = -1; //첫 반복에 종료되는 걸 방지
				
			}catch(IOException e) {
				System.out.println("### 입/출력 관련 예외 발생 ###");
				e.printStackTrace();
			}catch(Exception e) { //기타 예외 모두 처리
				e.printStackTrace();
			}
			
		}while(input !=0);
	}
	
	
	
	/**
	 * 메뉴 출력 및 선택 메서드
	 * @return 선택한 메뉴의 번호를 반환함
	 */
	public int selectMenu() throws NumberFormatException, IOException{
		
		
		System.out.println("\n============= Todo List =============\n");
		System.out.println("1. Todo List Full View"); //전체보기
		System.out.println("2. Todo Detail View");
		System.out.println("3. Todo Add");
		System.out.println("4. Todo Complete");
		System.out.println("5. Todo Update");
		System.out.println("6. Todo Delete");
		System.out.println("0. Exit");
		
		System.out.print("select menu number >> ");
		int input = Integer.parseInt(br.readLine()); //br.readLine()으로 반환된 String형을 Integer 타입으로 파싱해줌
		System.out.println();		
		
		return input;		
		
	}
	
	
	
	//------------------------------------
	/**
	 * 할 일 목록 모두 보기
	 */
	public void todoListFullView() {
		
		System.out.println("\n========= [1. Todo List Full View] ==========");
		
		//할 일 목록 + 완료된 개수 카운트 한 값 얻어오기
		//(List)         (int)
		Map<String, Object> map = service.todoListFullView();
		
		//반환받은 map요소 해체하기
		List<Todo> todoList=(List<Todo>)map.get("todoList");
		int completeCount=(int)map.get("completeCount");
		
		
		//출력
		System.out.printf("[ 완료된 Todo 개수 / 전체 Todo 수 : %d / %d ]\n"
				, completeCount, todoList.size());
		System.out.println("--------------------------------------------------------------------");
		System.out.printf("%-3s %10s   %10s     %s\n", "인덱스", "등록일", "완료여부", "할 일 제목");
		System.out.println("--------------------------------------------------------------------");
		
		for(int i=0, len = todoList.size(); i < len; i++) {
		
			String title = todoList.get(i).getTitle();
			
			String completeYN = todoList.get(i).isComplete() ? "O" : "X";
			
			String regDate = service.dateFormat(todoList.get(i).getRegDate()); //TodoListService에서 메서드 새로 작성됨
			
			System.out.printf("[%3d]  %20s    (%s)       %s\n", i, regDate, completeYN, title);
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
