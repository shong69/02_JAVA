package com.toyproject.model.dto;

import java.io.Serializable;

//방송 종류 / 방송인 / 팔로우 등록 / 알림설정
public class StreamingSite implements Serializable {

	private String sort;
	private String streamer;
	private boolean follow;
	private boolean alert;
	
	public StreamingSite() {}
	public StreamingSite(String sort, String streamer, boolean follow, boolean alert) {
		super();
		this.sort = sort;
		this.streamer = streamer;
		this.follow = follow;
		this.alert = alert;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getStreamer() {
		return streamer;
	}
	public void setStreamer(String streamer) {
		this.streamer = streamer;
	}
	public boolean isFollow() {
		return follow;
	}
	public void setFollow(boolean follow) {
		this.follow = follow;
	}
	public boolean isAlert() {
		return alert;
	}
	public void setAlert(boolean alert) {
		this.alert = alert;
	}
	@Override
	public String toString() {
		return "StreamingSite [sort=" + sort + ", streamer=" + streamer + ", follow=" + follow + ", alert=" + alert
				+ "]";
	}
	
	
	
	
	
}
