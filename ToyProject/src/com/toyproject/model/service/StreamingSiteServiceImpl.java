package com.toyproject.model.service;

import java.io.IOException;
import java.text.DecimalFormat;
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
	 *구독료 포멧 함수
	 */
	@Override
	public String formatFee(int followFee) {
		DecimalFormat formatter = new DecimalFormat("###,###");
		String formattedFee = formatter.format(followFee);
		
		return formattedFee;
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
		sb.append(String.format("구독료 : 매달 %s원\n",formatFee(streamingSite.getFollowFee())));
		if(streamingSite.getFollowFee()==0) {
			sb.append("-> \n<구독료를 정하지 않은 상태입니다>\n    구독 서비스에 가입하세요!\n\n");
		}
		sb.append(String.format("알림설정 : %s\n", streamingSite.isAlert()? "ON" : "OFF"));
		sb.append("- - - - - -");
		sb.append(String.format("\n[스트리머 설명]\n : %s\n", streamingSite.getDetail()));
		
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


	/**
	 * 구독 취소하기
	 */
	@Override
	public int unfollowStreamer(String streamer) {
		StreamingSite streamingSite = dao.unfollowStreamer(streamer);
		if(streamingSite==null) return -1;
		
		return streamingSite.getFollowFee();
	}




}
