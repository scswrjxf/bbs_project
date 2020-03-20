package com.bbs.pojo;

public class ClientInvatationAnswer {  
	private String invitationId;
	private String invitationTitle;
	private String userPhoto;
	private String invitationMessage;
	private String userAlice; 
	public ClientInvatationAnswer() {
		super();
		// TODO Auto-generated constructor stub
	} 
	@Override
	public String toString() {
		return "ClientInvatationAnswer [invitationId=" + invitationId + ", invitationTitle=" + invitationTitle
				+ ", userPhoto=" + userPhoto + ", invitationMessage=" + invitationMessage + ", userAlice=" + userAlice
				+ "]";
	}
	public ClientInvatationAnswer(String invitationId, String invitationTitle, String userPhoto,
			String invitationMessage, String userAlice) {
		super();
		this.invitationId = invitationId;
		this.invitationTitle = invitationTitle;
		this.userPhoto = userPhoto;
		this.invitationMessage = invitationMessage;
		this.userAlice = userAlice;
	}
	public String getInvitationId() {
		return invitationId;
	}
	public void setInvitationId(String invitationId) {
		this.invitationId = invitationId;
	}
	public String getInvitationTitle() {
		return invitationTitle;
	}
	public void setInvitationTitle(String invitationTitle) {
		this.invitationTitle = invitationTitle;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public String getInvitationMessage() {
		return invitationMessage;
	}
	public void setInvitationMessage(String invitationMessage) {
		this.invitationMessage = invitationMessage;
	}
	public String getUserAlice() {
		return userAlice;
	}
	public void setUserAlice(String userAlice) {
		this.userAlice = userAlice;
	}
}
