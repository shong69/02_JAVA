package com.toyproject.model.dao;


import java.util.List;

import com.toyproject.model.dto.StreamingSite;

public interface StreamingSiteDAO {

	
	
	List<StreamingSite> streamingFullView();

	StreamingSite streamingDetailView(String streamerstreamer);

	String addStreamer(StreamingSite streamingSite) throws Exception;

	void saveFile() throws Exception;

	boolean updatefollowFee(String streamer, int followFee) throws Exception;

	boolean checkAlert(String streamer) throws Exception;

	StreamingSite unfollowStreamer(String streamer);

}
