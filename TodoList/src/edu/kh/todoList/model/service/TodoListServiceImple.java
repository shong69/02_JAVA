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
}
