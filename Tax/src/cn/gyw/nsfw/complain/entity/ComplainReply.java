package cn.gyw.nsfw.complain.entity;

import java.sql.Timestamp;

/**
 * ComplainReply entity. @author MyEclipse Persistence Tools
 */

public class ComplainReply implements java.io.Serializable {


	private String replayId;
	private Complain complain;
	private String replayer;
	private String replayDept;
	private Timestamp replayTime;
	private String replayContent;


	public ComplainReply() {
	}

	public ComplainReply(Complain complain) {
		this.complain = complain;
	}

	public ComplainReply(Complain complain, String replayer, String replayDept,
			Timestamp replayTime, String replayContent) {
		this.complain = complain;
		this.replayer = replayer;
		this.replayDept = replayDept;
		this.replayTime = replayTime;
		this.replayContent = replayContent;
	}


	public String getReplayId() {
		return this.replayId;
	}

	public void setReplayId(String replayId) {
		this.replayId = replayId;
	}

	public Complain getComplain() {
		return this.complain;
	}

	public void setComplain(Complain complain) {
		this.complain = complain;
	}

	public String getReplayer() {
		return this.replayer;
	}

	public void setReplayer(String replayer) {
		this.replayer = replayer;
	}

	public String getReplayDept() {
		return this.replayDept;
	}

	public void setReplayDept(String replayDept) {
		this.replayDept = replayDept;
	}

	public Timestamp getReplayTime() {
		return this.replayTime;
	}

	public void setReplayTime(Timestamp replayTime) {
		this.replayTime = replayTime;
	}

	public String getReplayContent() {
		return this.replayContent;
	}

	public void setReplayContent(String replayContent) {
		this.replayContent = replayContent;
	}

}