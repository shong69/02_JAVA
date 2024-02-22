package com.hw4.model.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.hw4.model.dto.Toy2.Toy;

public class ToyFactory2 {
	
	private Scanner sc = new Scanner(System.in);
	private Set<Toy> toySet = new HashSet<Toy>(); //중복된 Toy객체가 없도록 저장할 컬렉션 중 Set
	private Map<Integer, String> materialMap = new HashMap<Integer, String>(); //재료가 저장되어 있는 map
	
	public ToyFactory2(){
		
		//기본 등록된 재료
		materialMap.put(1, "면직물");
		materialMap.put(2, "플라스틱");
		materialMap.put(3, "유리");
		materialMap.put(4, "고무");
		
		//다섯개 장난감 생성하기
		toySet.add(new Toy("마미롱레그", 8, 36000, "분홍색", "19950805", addMaterials(1, 4) )); //materialMap에서 재료에 해당하는 키 파라미터로 넘김

		toySet.add(new Toy("허기워기", 5, 12000, "파란색", "19940312", addMaterials(1, 2)));

		toySet.add(new Toy("키시미시", 5, 15000, "분홍색", "19940505", addMaterials(1, 2)));
		
		toySet.add(new Toy("캣냅", 8, 27000, "보라색", "19960128", addMaterials(1, 2)));

		toySet.add(new Toy("파피", 12, 57000, "빨간색", "19931225", addMaterials(1, 2, 4)));
		
	}
	
	//materials에 전달받은 값들을 추가하고 Set으로 반환하는 메서드
	public Set<String> addMaterials(Integer...newMaterials){ //Integer 형태로 n개의 파라미터가 들어올 거다(변수명 newMaterials로)
		
		Set<String> addedMaterials = new HashSet<String>();
		
		for(Integer materialkey : newMaterials) {
			//맵에서 해당 번호(key)에 대응하는 재료를 가져와 추가하기
			String materialValue = materialMap.get(materialkey);
			
			if(materialValue != null) {
				addedMaterials.add(materialValue);
			}
		}
		return addedMaterials;
	}
	
	
public void displayMenu() throws Exception {
		
		int menuNum = -1;
		do {
			System.out.println("\n<<플레이타임 공장>>");
			
			System.out.println("1. 전체 장난감 조회하기");
			System.out.println("2. 새로운 장난감 만들기");
			System.out.println("3. 장난감 삭제하기");
			System.out.println("4. 장난감 제조일 순으로 조회하기");
			System.out.println("5. 연령별 사용 가능한 장난감 리스트 조회하기");
			System.out.println("6. 재료 추가");
			System.out.println("7. 재료 제거");
			System.out.println("0. 프로그램 종료");
			
			
			System.out.print("선택 : ");
			
			try {
				
				menuNum = sc.nextInt();
				
				switch(menuNum) {
				case 1: displayAllToy(); break;
				case 2: createNewToy(); break;
				case 3: deleteToy(); break;
				case 4: displayToysByManufactureDate(); break;
				case 5: displayToysByAge(); break;
				case 6: addMaterial(); break;
				case 7: deleteMaterialByName(); break;
				
				case 0: System.out.println("프로그램을 종료합니다.");
				
				default: System.out.println("잘못된 선택입니다.");
				}
				
				
			}catch(Exception e) {
				System.out.println("알맞은 입력을 해라..(경고)");
				
				sc.nextLine();
				
				menuNum = -1; 
				//첫 반복에서 예외 발생 시 종료되지 않도록 menuNum 값을 임의의 값으로 세팅
			}

		}while(menuNum!=0);
	}
	
	public void displayAllToy() {
		System.out.println("<전체 장난감 목록>");
		
		int index = 1;
		for(Toy toy : toySet) {
			System.out.println(index + "." + toy);
			index++;
		}
		
	}

	public void createNewToy() throws Exception {
		System.out.println("<새로운 장난감 추가>");
		
		System.out.print("장난감 이름 : ");
		String name = sc.next();
		
		//중복되는 장난감 이름 있는지 확인
		for(Toy existingToy : toySet) {
			
			if(existingToy.getName().equals(name)) {
				System.out.println("이미 존재하는 장난감의 이름입니다.");
				return; //이름 중복 시 메서드 종료
			}
		}		

		System.out.print("사용 가능 연령 : ");
		int age = sc.nextInt();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		System.out.print("색상 : ");
		String color = sc.next();
		
		System.out.print("제조일(YYYYMMDD 형식으로 입력) : ");
		String manuDate = sc.next();
		
		//q 입력 할 때까지 재료 받기(Set 안에 넣기)
		Set<String> materials = new HashSet<String>(); //재료 저장할 컬렉션
		while(true) {
			
			System.out.print("재료를 입력하세요(종료하려면 'q'를 입력하세요) : ");
			String input = sc.next();
			
			if(input.equals("q")) {
				break;
			}
			materials.add(input);
			//이미 입력한 재료인지, 재료맵에 있는 재료인지 확인하기 추가
		}
		
		Toy newToy = new Toy(name, age, price, color, manuDate, materials);
		
		toySet.add(newToy);
		System.out.println("새로운 장난감이 추가되었습니다!");

	}
	
	
	public void deleteToy() {
		System.out.print("삭제할 장난감의 이름을 입력하세요 : ");
		String name = sc.next();
		
		boolean flag = false;
		for(Toy toy : toySet) {
			if(toy.getName().equals(name)) {
				toySet.remove(toy);
				flag = true;
				break;
			}
		}
		if(flag) {
			System.out.println("장난감이 삭제되었습니다.");

		}else {
			System.out.println("해당하는 이름의 장난감을 찾을 수 없습니다.");
		}
	}
	
	//<Student> void java.util.Collections.sort(List<Student> list, Comparator<? super Student> c)
	//void java.util.List.sort(Comparator<? super Toy> c)
	//->두가지 다른 sort를 사용할 수 있음
	public void displayToysByManufactureDate() {
		//Set을 List로 변환하여 sort하기
		System.out.println("<제조일 순으로 장난감을 정렬>");
		
		List<Toy> toyListSortedByDate = new ArrayList<Toy>(toySet);
		//comparator는 메소드에서 재정의 필요 없음
		toyListSortedByDate.sort(Comparator.comparing(Toy::getManufactDate));
		//List의 sort 기능을 사용 
		int index = 1;
		for(Toy toy : toyListSortedByDate) {
			System.out.println(index + ". "+ toy);
			index++;
		}
		
		
	}
	
	
	public void displayToysByAge() {
		//Map을 새로 만들어서 k(연령), v(해당 연령의 토이가 들어간 리스트)생성
		System.out.println("<연령별로 사용 가능한 장난감>");

		Map<Integer, List<Toy>> toysByAge = new HashMap<Integer,List<Toy>>();
		//toysByAge Map 생성
		
		for(Toy toy : toySet) {
			int age = toy.getProperAge(); //5
			toysByAge.putIfAbsent(age, new ArrayList<>());
			//putIfAbsent() : Map인터페이스에서 제공되는 메서드로, 
			//해당 키가 존재하지 않는 경우에만 전달받은 값을 추가함 
			//=>맵에 해당 연령의 리스트가 없는 경우에만 새로운 리스트를 생성하여 추가
			
			toysByAge.get(age).add(toy); //value에 해당 연령의 toy들 추가
		}
		
		for(Entry<Integer, List<Toy>> entry : toysByAge.entrySet()) {
			int age = entry.getKey();
			List<Toy> toyList = entry.getValue();
			
			System.out.println("[연령 : "+age+"세]");
			int index = 1;
			for(Toy toy : toyList) {
				System.out.println(index + "."+toy);
				index++;
			}
		}
	}
	
	
	public void addMaterial() throws Exception {
		System.out.println("<재료 추가>");
		System.out.println("***현재 등록된 재료***");
		
		Set<Entry<Integer,String>> entrySet = materialMap.entrySet(); //entrySet 사용하기 위해 Set 사용
		for(Entry<Integer,String> entryset : entrySet) {
			System.out.printf("%d : %s",entryset.getKey(), entryset.getValue());
		}
		
		System.out.println("======================");
		
		System.out.print("재료 고유번호(Key) 입력 : ");
		int num = sc.nextInt();
		System.out.print("재료명 입력 : ");
		String name = sc.next();

		if(materialMap.containsKey(num)) {
			System.out.println("이미 해당 키에 재료가 등록되어 있습니다");
			System.out.print("덮어쓰시겠습니까?(Y/N) : ");
			String ans = sc.next();
			if(ans.equalsIgnoreCase("Y")) { //소문자나 대문자나 모두 확인 가능한 메서드
				materialMap.put(num,name);
				System.out.println("재료가 성공적으로 덮어쓰기 되었습니다.");
			}else {
				return;
			}
		}else {
			materialMap.put(num,name);
			System.out.println("새로운 재료가 성공적으로 등록되었습니다.");
		}
	}
	
	
	public void deleteMaterialByName() throws Exception{
		System.out.println("<재료 삭제>");
		if(materialMap.size()>0) {
			System.out.println("***현재 등록된 재료***");
			
			Set<Entry<Integer,String>> entrySet = materialMap.entrySet(); //entrySet 사용하기 위해 Set 사용
			
			for(Entry<Integer,String> entryset : entrySet) {
				System.out.printf("%d : %s",entryset.getKey(), entryset.getValue());
			}
			System.out.println("======================");

			System.out.print("삭제할 재료명 입력 : ");
			String name = sc.next();
			
			boolean flag = false;
			for(Entry<Integer, String> entry : materialMap.entrySet()) {
				if(entry.getValue().equals(name)) {
					materialMap.remove(entry.getKey());
					System.out.printf("재료 '%s'가 성공적으로 제거되었습니다.", name);
					flag = true;
					break;
				}
			}
			if(!flag) {
				System.out.println("해당 이름의 재료가 존재하지 않습니다.");

			}
		}


	}
	
}
