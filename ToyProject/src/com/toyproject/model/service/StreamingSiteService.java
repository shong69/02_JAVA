package com.toyproject.model.service;

import java.util.List;
import java.util.Map;

import com.toyproject.model.dto.StreamingSite;

//Service
//데이터 가공, 로직 처리 등의 기능을 제공하는 역할
public interface StreamingSiteService {

	/** 구독중인 스트리머 목록 반환
	 * @return streamingList
	 */
	public abstract List<StreamingSite> streamingFullView();

	
	/**구독중인 스트리머 세부 정보 반환
	 * @param streamer
	 * @return 해당하는 스트리머의 상세 정보, 없으면 null 반환
	 */
	public abstract String streamingDetailView(String streamer);


	/** 구독할 스트리머 추가
	 * @param sort
	 * @param streamerName
	 * @param string
	 * @return
	 * @throws Exception 
	 */
	public abstract String addStreamer(String sort, String streamer, String detail) throws Exception;


	/**구독료 변경
	 * @param list
	 * @return
	 * @throws Exception 
	 */
	public abstract boolean updatefollowFee(Map<String, Object> list) throws Exception;


	/**알림 설정 바꾸기
	 * @param streamer
	 * @return
	 * @throws Exception 
	 */
	public abstract boolean checkAlert(String streamer) throws Exception;

}
