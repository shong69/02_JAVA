package com.toyproject.model.service;

<<<<<<< HEAD
public class StreamingSiteServiceImpl {
=======
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.toyproject.model.dao.StreamingSiteDAO;
import com.toyproject.model.dao.StreamingSiteDAOImpl;
import com.toyproject.model.dto.StreamingSite;

public class StreamingSiteServiceImpl implements StreamingSiteService{

	private StreamingSiteDAO dao = null;
	
	public StreamingSiteServiceImpl() throws IOException, ClassNotFoundException, Exception{
		
		dao = new StreamingSiteDAOImpl();
		
	}
	
	
	/**
	 *구독 중인 스트리머 목록
	 */
	@Override
	public List<StreamingSite> streamingFullView() {
		List<StreamingSite> streamList = dao.streamingFullView();
		return streamList;
	}


	/**
	 *구독 중인 스트리머 세부 정보 
	 */
	@Override
	public String streamingDetailView(String streamer) {
		//dao에서 입력한 스트리머 이름에 해당하는 객체 얻어오기, 없으면 null 반환
		StreamingSite streamingSite = dao.streamingDetailView(streamer);
		
		if(streamingSite == null) return null;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("-------------\n");
		sb.append(String.format("[%s]\n",streamingSite.getSort()));
		sb.append(String.format("스트리머 이름 : %s\n", streamingSite.getStreamer()));
		sb.append(String.format("구독료 : %d원\n",streamingSite.getFollowFee()));
		sb.append(String.format("알림설정 : %s\n", streamingSite.isAlert()? "ON" : "OFF"));
		sb.append("- - - - - -");
		sb.append(String.format("\n[스트리머 설명] : %s\n", streamingSite.getDetail()));
		
		return sb.toString();
	}


	/**
	 *구독할 스트리머 추가
	 * @throws Exception 
	 */
	@Override
	public String addStreamer(String sort, String streamer, String detail) throws Exception {
		StreamingSite streamingSite = new StreamingSite(sort, streamer, 0, false, detail );
		
		String streamerName = dao.addStreamer(streamingSite);
		return streamerName;
	}


	/**
	 *구독료 변경
	 * @throws Exception 
	 */
	@Override
	public boolean updatefollowFee(Map<String, Object> list) throws Exception {
		String streamer =(String)list.get("streamer");
		int followFee = (int)list.get("followFee");
		
		
		return dao.updatefollowFee(streamer, followFee);
	}


	/**
	 *알림 설정 바꾸기
	 * @throws Exception 
	 */
	@Override
	public boolean checkAlert(String streamer) throws Exception {
		
		return dao.checkAlert(streamer);
	}
>>>>>>> b9e037464a0f89f9d4dcf8d2415e883d5a9a27e8

}
