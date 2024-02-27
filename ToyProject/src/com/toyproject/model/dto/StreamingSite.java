package com.toyproject.model.dto;

import java.io.Serializable;

//방송 종류 / 방송인 / 팔로우 등록 / 알림설정
public class StreamingSite implements Serializable {

	private String sort;
	private String streamer;
<<<<<<< HEAD
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
=======
	private int followFee;
	private boolean alert;
	private String detail;
	
	public StreamingSite() {}

	public StreamingSite(String sort, String streamer, int followFee, boolean alert, String detail) {
		super();
		this.sort = sort;
		this.streamer = streamer;
		this.followFee = followFee;
		this.alert = alert;
		this.detail = detail;
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

	public int getFollowFee() {
		return followFee;
	}

	public void setFollowFee(int followFee) {
		this.followFee = followFee;
	}

	public boolean isAlert() {
		return alert;
	}

	public void setAlert(boolean alert) {
		this.alert = alert;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "StreamingSite [sort=" + sort + ", streamer=" + streamer + ", followFee=" + followFee + ", alert="
				+ alert + ", detail=" + detail + "]";
	}


>>>>>>> b9e037464a0f89f9d4dcf8d2415e883d5a9a27e8
	
	
	
	
	
}
