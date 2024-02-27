package com.toyproject.model.dao;

<<<<<<< HEAD
public interface StreamingSiteDAO {

=======
import java.util.List;

import com.toyproject.model.dto.StreamingSite;

public interface StreamingSiteDAO {

	
	
	List<StreamingSite> streamingFullView();

	StreamingSite streamingDetailView(String streamerstreamer);

	String addStreamer(StreamingSite streamingSite) throws Exception;

	/**
	 *구독할 스트리머 추가하기
	 */


	void saveFile() throws Exception;

	boolean updatefollowFee(String streamer, int followFee) throws Exception;

	boolean checkAlert(String streamer) throws Exception;
>>>>>>> b9e037464a0f89f9d4dcf8d2415e883d5a9a27e8
}
