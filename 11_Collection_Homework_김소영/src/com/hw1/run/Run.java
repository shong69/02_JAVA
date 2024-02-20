package com.hw1.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hw1.model.dto.Friend;

public class Run {
	public static void main(String[] args) {
		Friend fr = new Friend();
		
		List<Friend> friendsList = new ArrayList<Friend>();
		
		
		friendsList.add(new Friend("짱구"));
		friendsList.add(new Friend("철수"));
		friendsList.add(new Friend("유리"));
		friendsList.add(new Friend("훈이"));
		friendsList.add(new Friend("맹구"));
		
		
		//리스트 넣는 방법 1) Collections.addAll();
		/*Collections.addAll(friendsList, new Friend("짱구"), new Friend("철수"), new Friend("유리"),
				new Friend("훈이"), new Friend("맹구"));
		*/
		
		//리스트 넣는 방법 2) List.of()  
		//Java 9 이상의 버전에서 사용 가능(안에 들어오는 애들을 모두 리스트화하여 friends에 넣어준다)
		/*List<Friend> friensList = List.of(new Friend("짱구"), new Friend("철수"), new Friend("유리"),
				new Friend("훈이"), new Friend("맹구"));
		*/
		
		//랜덤으로 골목대장 뽑기
		//note! Random random = new Random();
		
		int randomIndex = (int)(Math.random()*friendsList.size());
		
		Friend leader = friendsList.get(randomIndex);
		
		leader.pickLeader();
		
	}
}
