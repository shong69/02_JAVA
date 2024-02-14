package edu.kh.objarray.practice.model.service;

import java.util.Scanner;

import edu.kh.objarray.practice.model.vo.Employee;

public class EmployeeService {

	private Employee[] employees = new Employee[3]; // 사원 정보를 저장할 Employee 배열
	private Scanner sc = new Scanner(System.in); 

	
	public void displayMenu() {
		
		int sel = 0;
		do {
			
			System.out.println("=== 직원 관리 프로그램 ===");
			System.out.println("1. 직원 정보 입력(3명)");
			System.out.println("2. 모든 직원 정보 출력");
			System.out.println("3. 특정 직원 정보 출력(이름 검색)");
			System.out.println("4. 특정 직원 급여/연봉 출력(사번 검색)");
			System.out.println("5. 모든 직원 급여 합/연봉 합 출력");
			System.out.println("6. 모든 직원중 급여가 가장 높은 직원의 이름, 부서, 급여 출력");
			System.out.println("0. 종료");
			System.out.print("메뉴 선택 >> ");
			sel = sc.nextInt();
			sc.nextLine();
			
			switch (sel) {
			case 1: initEmployee(); break;
			case 2: System.out.println(allEmployeesInformation()); break;
			case 3: System.out.println( searchEmployee()); break;
			case 4: System.out.println(salaryCheck()); break;
			case 5: System.out.println("전 직원 급여 합 : "+allSalaryCheck()+ " 전 직원 연봉 합 : "+allSalaryCheck()*12); break;
			case 6: topSalaryEmployee(); break;
			case 0: System.out.println("프로그램 종료."); break;

			default: System.out.println("잘못 입력하셨습니다.");
			}
			
		}while(sel != 0);
		
	}
	
	// 3명의 직원 정보를 입력받아 배열에 각 요소에 초기화  
	public void initEmployee() {
		// 사번, 이름, 부서, 직급, 급여 순서로 입력받기
		if(employees[0]==null) {
			for(int i = 0; i < employees.length;i++) {
				System.out.println("\n=="+(i+1)+"번째 사원 정보 입력==");
				System.out.print("사번 : ");
				int inputNo = sc.nextInt();
				
				System.out.print("이름 : ");
				String inputName = sc.next();
				
				System.out.print("부서 : ");
				String inputDept = sc.next();
				
				System.out.print("직급 : ");
				String inputJob = sc.next();
				
				System.out.print("급여 : ");
				int inputSalary = sc.nextInt();
				
				
				employees[i]=new Employee(inputNo, inputName, inputDept, inputJob, inputSalary);
				
			}
		}else {
			System.out.println("직원 정보는 이미 입력되었습니다.");
		}

	}
	
	
	// 모든 직원 정보를 하나의 문자열로 반환
	public String allEmployeesInformation() {
		if(employees[0]==null) {
			System.out.println("아직 직원 정보가 입력되지 않았습니다.");
		}else {
			return "\n사번 : "+employees[0].getEmpNo()+", 이름 : "+employees[0].getEmpName()+
					" 부서 : "+employees[0].getEmpDept()+", 직급 : "+employees[0].getEmpJob()+", 급여 : "+employees[0].getSalary() 
					+"\n사번 : "+employees[1].getEmpNo()+", 이름 : "+employees[1].getEmpName()+
					" 부서 : "+employees[1].getEmpDept()+", 직급 : "+employees[1].getEmpJob()+", 급여 : "+employees[1].getSalary() 
					+"\n사번 : "+employees[2].getEmpNo()+", 이름 : "+employees[2].getEmpName()+
					" 부서 : "+employees[2].getEmpDept()+", 직급 : "+employees[2].getEmpJob()+", 급여 : "+employees[2].getSalary(); 
 

	
		}

		return null;
	}
	
	// 특정 사원 정보 반환 메소드(이름 검색)
	// 일치하는 이름이 없을 경우 "일치하는 이름의 사원이 없습니다." 반환
	public String searchEmployee() {
		
		
		System.out.println("\n===특정 사원 정보 출력(이름 검색)===");
		
		if(employees[0]==null) {
			System.out.println("아직 직원 정보가 입력되지 않았습니다.");
		}else {
			System.out.print("이름 입력 : ");
			String inputName = sc.next();
			int sameName = -1;
			
			for(int i = 0; i<employees.length; i++) {
				if (employees[i].getEmpName().equals(inputName)) {
					sameName = i;
					break;
				}
		
			}if(sameName >=0) {
				return "사번 : " +employees[sameName].getEmpNo() + " 이름 : "+ employees[sameName].getEmpName()+
						" 부서 : " +employees[sameName].getEmpDept() +" 직급 : " + employees[sameName].getEmpJob()+
						" 급여 :"+ employees[sameName].getSalary();

			}else {
				return "일치하는 이름의 사원이 없습니다";
			}
		}
		return null;
		
	}
	
	
	// 입력받은 사번과 일치하는 직원의 급여, 연봉 정보 반환(연봉 == 급여 * 12)
	// 일치하지 않는 경우 "사번이 일치하는 직원 없습니다." 반환
	public String salaryCheck() {
		System.out.println("\n===급여/연봉 조회===");
		int salNum =  -1;
		if(employees[0]==null) {
			System.out.println("아직 직원 정보가 입력되지 않았습니다.");
			
		}else {
			
			System.out.print("사번 입력 : ");
			int inputNo = sc.nextInt();
			
			for(int i = 0; i<employees.length; i++) {
				if (employees[i].getEmpNo()==inputNo) {
					salNum = i;
					break;
				}
			}if(salNum >=0) {
				return "급여 : "+ employees[salNum].getSalary() +" 연봉 : " + employees[salNum].getSalary()*12;
			}else {
				return "사번이 일치하는 직원이 없습니다";
			}
		}

		return null;
	}
	
	
	// 모든 사원 급여 합 반환
	public int allSalaryCheck() {
		System.out.println("\n===모든 사원의 급여 합/연봉 합===");
		
		if(employees[0]==null) {
			System.out.println("아직 직원 정보가 입력되지 않았습니다.");
		}else {
			int salarySum = 0;
			for(int i = 0; i<employees.length; i++) {
				salarySum += employees[i].getSalary();
			}
			
			return  salarySum;
		}


		return 0;
	}
	
	// 모든 직원중 급여가 가장 높은 직원 출력
	// (동일한 급여인 경우 사번이 낮은 사람이 출력) //코드 수정
	public void topSalaryEmployee() {
		if(employees[0]==null) {
			System.out.println("아직 직원 정보가 입력되지 않았습니다.");
		}else {
			int hiSalNum= -1; //인덱스 번호
			int hiSal = 0; //급여 액수

			
			for(int i = 0; i<=employees.length;i++) {
				if(employees[i].getSalary()>hiSal) {
					
					hiSal = employees[i].getSalary();
					hiSalNum = i;
					
				}else if(employees[i].getSalary()==hiSal) {
					
					if(employees[i].getEmpNo()< employees[hiSalNum].getEmpNo()) {
						
						hiSal = employees[i].getSalary();
						hiSalNum = i;
					}
				}
			}
			System.out.printf("이름 : %s, 부서 : %s, 급여 : %d", 
					employees[hiSalNum].getEmpName(), employees[hiSalNum].getEmpDept(), hiSal);
		}
		
	}
	
}