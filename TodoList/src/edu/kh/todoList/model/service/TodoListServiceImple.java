package edu.kh.todoList.model.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.model.dao.TodoListDAO;
import edu.kh.todoList.model.dao.TodoListDAOImpl;
import edu.kh.todoList.model.dto.Todo;

public class TodoListServiceImple implements TodoListService{

	//필드
	private TodoListDAO dao = null;
	
	public TodoListServiceImple() throws FileNotFoundException, IOException, ClassNotFoundException {
		//TodoListServiceImple 객체가 생성될 때 TodoListDAOImple 객체도 생성
		dao = new TodoListDAOImpl();
		//부모타입 참조변수 = 자식객체(다형성 업캐스팅)
	}

	//-------------------------
	/*todoListFullView 정의하기*/
	@Override
	public Map<String, Object> todoListFullView() {
		
		//1. 할 일 목록을 DAO에서 얻어오기
		List<Todo>todoList = dao.todoListFullView(); 
		
		
		//2. 할 일 목록에서 완료(complete 필드값이 true인지 확인)인 요소가 몇 개인지 count
		int completeCount = 0;
		
		
		for(Todo todo:todoList) { //TodoList 순차접근해서 완료된 거(complete=true;) 찾기
			if(todo.isComplete()) { //boolean이라 get없고 iscomplete로 써야함
				completeCount++;
				
			}
		}
		
		//3. todoList, completeCount를 저장할 Map생성
		//->메서드는 반환을 하나밖에 못해서 여러개 반환 시, Map같은 컬렉션에 묶어서 반환한다
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("todoList", todoList);
		map.put("completeCount", completeCount);
		
		//4. map 반환하기
		return map;
	}

	@Override
	public String dateFormat(LocalDateTime regDate) {
		// yyyy-MM-dd HH:mm:ss 형태 날짜 반환
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		//regDate에 저장되어 있는 날짜 데이터를 
		//formatter에 지정된 형식으로 변경
		String formattedDateTime = regDate.format(formatter);
		
		
		return formattedDateTime;
	}
	
	/*할 일 상세조회 서비스*/
	//ArrayList<Todo>인 todo
	//인덱스 입력 시 정보 가져오기
	@Override
	public String todoDetailView(int index) {
		//1. DAO에서 todoList의 index번째 요소(Todo) 얻어오기
		//없으면 null 반환
		Todo todo = dao.todoDetailView(index);

		//2. 반환받은 todo가 null인 경우 null 반환
		if(todo == null) return null;
		
		//3. Todo가 참조하는 객체가 있다면 문자열 가공 후 반환
		StringBuilder sb = new StringBuilder();
		
		sb.append("---------------------------------\n");
		sb.append(String.format("제목 : %s,\n", todo.getTitle()));
		sb.append(String.format("등록일 : %s\n", dateFormat(todo.getRegDate())));
		sb.append(String.format("완료여부 : %s\n", todo.isComplete()? "O":"X" ));
		sb.append("\n[세부내용]\n");
		sb.append("---------------------------------\n");
		
		sb.append(String.format("%s\n", todo.getDetail()));
		
		//4. 가공한 문자열을 view로 반환하기
		return sb.toString();
			
		
	}

	/*할 일 추가 서비스*/
	@Override
	public int todoAdd(String title, String content) throws Exception{
		// Todo 객체 생성하기
		Todo todo = new Todo(title, content, false, LocalDateTime.now());
		//LocalDateTime.now() : 현재 시간 반환
		
		//DAO 메서드 호출 후 결과 반환 받기
		int index = dao.todoAdd(todo);

		return index;
	}

	/*할 일 완료 여부 서비스*/
	@Override
	public boolean todoComplete(int index) throws Exception {

		return dao.todoComplete(index);
	}
	//service 메소드가 별도 처리를 하는게 없음
	//->아무것도 안한다고 해서 서비스를 이용하지 않으면 안된다..!

	
	
	/*할 일 수정 서비스*/
	@Override
	public boolean todoUpdate(int index, String title, String content) throws Exception {
		
		return dao.toUpdate(index, title, content);
	}

	
	/*할 일 삭제 서비스*/
	@Override
	public String todoDelete(int index) throws Exception {
		
		//DAO 메서드 호출 후 결과 반환 받기
		//->삭제된 Todo 또는 null 반환 받기
		Todo todo = dao.todoDelete(index);
		if(todo == null) return null;
		return todo.getTitle(); //제목 반환
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
