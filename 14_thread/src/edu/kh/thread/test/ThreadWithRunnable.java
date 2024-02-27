package edu.kh.thread.test;

//Runnable 인터페이스 상속받아 쓰레드 생성하기
public class ThreadWithRunnable implements Runnable{
	//Runnable Inteface 사용방법
	//클래스 상속의 제약을 피하고 (단일상속의 제약)
	//코드 재사용성을 높일 수 있음 -> 일반적으로 권장되는 방법
	
	//run() 메서드 하나만을 정의하고 있으므로, 다른 클래스를 상속받은 상태에서도 
	//Runnable을 구현하여 쓰레드 실행 가능함
	
	@Override
	public void run() {
		//스레드가 수행할 작업을 정의하면 됨
				for(int i=0; i<5; i++) {
					System.out.println("Runnable : "+ i);
					
					
					try {
						//InterruptedException : 자바에서 다중 쓰레드 프로그래밍 시 발생할 수 있는 예외
						
						//만든 쓰레드를 1초간 대기시키기
						Thread.sleep(1000); //ms 단위
						//sleep : static 메서드이기 때문에 클래스명.메서드명() 으로 작성
						
						
						
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}
		
	}

	
}
