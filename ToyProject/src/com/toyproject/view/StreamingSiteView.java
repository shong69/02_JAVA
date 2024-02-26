package com.toyproject.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.toyproject.model.dto.StreamingSite;
import com.toyproject.model.service.StreamingSiteService;
import com.toyproject.model.service.StreamingSiteServiceImpl;

//View : 보여지는 부분(내용 출력, 키보드 입력,..)에서의 역할을 한다
public class StreamingSiteView {

	//필드
	private Scanner sc = new Scanner(System.in);
	private BufferedReader br = null;
	private StreamingSiteService service = null;
	//service 객체 변수 추가하기
	
	//기본생성자에서 예외 처리하기
	public StreamingSiteView() {
		try {
			
			service = new StreamingSiteServiceImpl();
			br = new BufferedReader(new InputStreamReader(System.in));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 관리 화면
	 */
	public void startPage() {
		int input = -1;
		do {
			try {
				input = selectMenu();
				
				switch(input) {
				case 1: streamingFullView(); break;
				case 2: streamingDetailView(); break;
				case 3: addStreamer(); break;
				case 4: updatefollowFee(); break;
				case 5: checkAlert(); break;
				//case 6: unfollowStreamer(); break;
				case 0: System.out.println("구독 관리 프로그램이 종료됩니다.");
				
				default: System.out.println("!!위에 작성된 숫자만 입력 가능합니다!!");
				}
				
				
				
				
			}catch(NumberFormatException e) {
				System.out.println("!!/(슬래쉬) 다음에 숫자만 입력해 주세요!!");
				
			}catch(IOException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}

			
			
		}while(input !=0);
	}
	
	
	public int selectMenu() throws NumberFormatException, IOException, Exception {
		System.out.println("\n********스트리밍 사이트 구독 관리 명령어********");
		
		System.out.println("/1 : 구독 중인 스트리머 목록"); //전체 목록 보기
		System.out.println("/2 : 스트리머 세부 구독 정보"); //스트리머 한 명 보기
		System.out.println("/3 : 구독 할 스트리머 등록"); //스트리머 한명 새로 등록
		System.out.println("/4 : 스트리머 구독료 변경");
		System.out.println("/5 : 알림설정 확인"); //알림설정 f/t 확인하고 바꾸기
		System.out.println("/6 : 구독 취소"); // 스트리머 목록에서 삭제
		System.out.println("/0 : 구독 관리 종료");
		
		System.out.print("명령어를 입력하세요(예시 : /1 ) : ");
		int input = ((int)sc.next().charAt(1))-48;

		System.out.println(input);
		System.out.println();
		
		return input;
	}
	
	/**
	 * 구독 중인 스트리머 전체 목록 불러오기
	 */
	public void streamingFullView() {
		System.out.println("==============구독 중인 스트리머 목록==============");
		
		List<StreamingSite> streamList = service.streamingFullView();
		
		//구독중인 스트리머 수 
		//[게임 스트리머] 우주하마 | 구독료: 5900원 |  알림설정 : ON
		
		int followCount = streamList.size();
		System.out.printf("구독 중인 스트리머 수 <%d>명\n", followCount);
		System.out.println("------");
		for(int i=0, len = streamList.size();i<len;i++) {
			String sort = streamList.get(i).getSort();
			String streamer = streamList.get(i).getStreamer();
			int followFee = streamList.get(i).getFollowFee();
			String alert =streamList.get(i).isAlert()? "ON" : "OFF";
			System.out.printf("[%s] %s | 구독료 : %d | 알림설정 : %s\n", 
					sort, streamer, followFee, alert);
		}
	}
	
	
	
	/**
	 * 스트리머 세부 구독 정보
	 * @throws IOException 
	 */
	public void streamingDetailView() throws IOException {
		System.out.println("==============구독 중인 스트리머 세부 정보==============");
		
		System.out.print("스트리머 이름 입력 : ");
		String streamer = br.readLine();
		
		String detail = service.streamingDetailView(streamer);
		if(detail == null) {
			System.out.println("!!입력한 값에 해당하는 스트리머가 존재하지 않습니다!!");
			return;
		}
		System.out.println(detail);
		
	}
	
	
	
	/**
	 * 구독할 스트리머 등록
	 * @throws Exception 
	 */
	public void addStreamer() throws Exception {
		System.out.println("==============구독 할 스트리머 등록==============");

		System.out.print("스트리머 종류 입력 : ");
		String sort = br.readLine();
		System.out.print("스트리머 이름 입력 : ");
		String streamer = br.readLine();
		System.out.println("세부 내용 작성(입력 종료를 원하면 !end 입력 후 엔터)");
		System.out.println();
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			String detail = br.readLine();
			if(detail.equals("!end")) break;
			
			sb.append(detail);
			sb.append("\n");
			
		}
		System.out.println("- - - - - -");
		
		//추가되면 스트리머 이름 나오고 안되면 null 반환
		String streamerName = service.addStreamer(sort, streamer, sb.toString());
		if(streamerName == null) {
			System.out.println("!!스트리머 추가에 실패했습니다!!");
		}
		System.out.printf("[%s] %s(이)가 나의 구독 리스트에 추가되었습니다.", sort, streamerName);
	}
	
	
	public void updatefollowFee() throws Exception {
		System.out.println("==============스트리머 구독료 변경==============");
		Map<String, Object> list = new HashMap<String, Object>();
		System.out.print("스트리머 이름 입력 : ");
		String streamer = br.readLine();
		
		//----------------------------------------
		
		System.out.println("[구독 요금제]");
		System.out.println("일반회원 : 5900원");
		System.out.println("열혈회원 : 8900원");
		System.out.println("고급회원 : 11900원");
		
		System.out.print("원하는 회원 이름을 입력하세요( 예) 일반 ) : ");
		String membership = br.readLine();
		
		int fee1=0;
		
		switch(membership) { 
		case "일반": fee1=5900; break;
		case "열혈": fee1=8900; break;
		case "고급": fee1=11900; break;
		default: System.out.println("잘못된 입력입니다");
		}
		
		list.put("streamer", streamer);
		list.put("followFee", fee1);
		//스트리머 이름과 구독료를 넣은 map 전달
		boolean result = service.updatefollowFee(list);
		
		if(result) {
			System.out.println("변경되었습니다");
		}else {
			System.out.println("해당하는 스트리머가 존재하지 않습니다");
		}
	}
	
	
	
	
	/**
	 * 알림설정 확인
	 * @throws Exception 
	 */
	public void checkAlert() throws Exception {
		System.out.println("==============알림 설정 변경==============");
		
		System.out.print("스트리머 이름 입력 : ");
		String streamer = br.readLine();
		
		String detail = service.streamingDetailView(streamer);
		if(detail == null) {
			System.out.println("!!입력한 값에 해당하는 스트리머가 존재하지 않습니다!!");
			return;
		}
		System.out.println(detail);
		
		//-------------------------
		
		
		System.out.print("알림설정을 바꾸시겠습니까?(Y/N) : ");
		char ans = sc.next().toUpperCase().charAt(0);
		if(ans=='Y') {
			boolean result = service.checkAlert(streamer);
		}else return;
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
