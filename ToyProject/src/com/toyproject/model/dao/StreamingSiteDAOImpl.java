package com.toyproject.model.dao;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.toyproject.model.dto.StreamingSite;

public class StreamingSiteDAOImpl implements StreamingSiteDAO{

	private final String FILE_PATH = "/io_test/StreaminSite.dat";
	
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	private List<StreamingSite> streamList = null;
	
	
	public StreamingSiteDAOImpl() throws FileNotFoundException, IOException, ClassNotFoundException{
		File file = new File(FILE_PATH);
		if(file.exists()) {
			
			try {
				
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				
				streamList = (ArrayList<StreamingSite>)ois.readObject(); //역직렬화
				
			}finally {
				if(ois!=null) ois.close();
			}

			
		}else {
			
			
			File directory = new File("/io_test");
			if(!directory.exists()) directory.mkdir(); //없으면 폴더 생성
			
			streamList = new ArrayList<StreamingSite>();
			
			streamList.add(new StreamingSite("게임 스트리머", "우주하마", 5900, false, "종합 게임 스트리머입니다"));
			streamList.add(new StreamingSite("게임 스트리머", "우왁굳", 5900, false, "종합 게임 스트리머입니다"));
			streamList.add(new StreamingSite("먹방 스트리머", "입짧은 햇님", 11900, false,"놀라운 토요일에 출연했었습니다"));
			streamList.add(new StreamingSite("버추얼 스트리머", "릴파", 0, false,"최근 발매한 'kidding' 앨범이 있습니다"));
			
			try {
				oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
				oos.writeObject(streamList);
			
			}finally {
				if(oos != null) oos.close();
			}
			
			System.out.println("****streamList 파일 생성함****");
		}
	}


	@Override
	public List<StreamingSite> streamingFullView() {

		return streamList;
	}


	/**
	 *구독 중인 스트리머 세부 설명
	 */
	@Override
	public StreamingSite streamingDetailView(String streamer) {
		for(int i=0;i<streamList.size();i++) {
			if(streamList.get(i).getStreamer().equals(streamer)) {
				return streamList.get(i);
			}
		}
		return null;
	}


	/*파일 저장하는 메소드*/
	@Override
	public void saveFile() throws Exception{
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(streamList);
		}finally {
			oos.close();
		}
	}
	
	
	/**
	 *구독할 스트리머 추가하기
	 * @throws Exception 
	 */
	@Override
	public String addStreamer(StreamingSite streamingSite) throws Exception {
		if(streamList.add(streamingSite)) {
			saveFile();
			
			return streamingSite.getStreamer();
		}
		return null;

	}


	@Override
	public boolean updatefollowFee(String streamer, int followFee) throws Exception {
		boolean flag = false;
		for(int i=0;i<streamList.size();i++) {
			if(streamList.get(i).getStreamer().equals(streamer)) {
				
				streamList.get(i).setFollowFee(followFee);
				saveFile();
				flag = true;
				
			}
		}
		return flag;
		
	}


	/**
	 *알림 설정 바꾸기
	 * @throws Exception 
	 */
	@Override
	public boolean checkAlert(String streamer) throws Exception {
		
		boolean flag = false;
		for(int i=0;i<streamList.size();i++) {
			if(streamList.get(i).getStreamer().equals(streamer)) {
				
				boolean onOff = streamList.get(i).isAlert();
				streamList.get(i).setAlert(!onOff);
				saveFile();
				flag = true;
				
			}
		}
		return flag;
	}


	@Override
	public StreamingSite unfollowStreamer(String streamer) {
		for(int i=0;i<streamList.size();i++) {
			if(streamList.get(i).getStreamer().equals(streamer)) {
				return streamList.get(i);
			}
		}
		return null;

	}

}
