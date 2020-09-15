package com.weiwei.Entity;

public class UsersTable {
	private int uid;				//�û�ID
	private String userName;		//�û���ʵ����
	private String userNumber;		//�û���
	private String userPwd;			//�û�����
	private String userYesPwd;		//ȷ������
	private String userTypeId;		//�û�֤������
	private String userTypeNumber;	//�û�����
	private String userMobile;		//�û��ֻ�����
	private String userEmail;		//�û���������
	private String uimg;
	public int getUid() {
		return uid;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public String getUserYesPwd() {
		return userYesPwd;
	}
	public String getUserTypeId() {
		return userTypeId;
	}
	public String getUserTypeNumber() {
		return userTypeNumber;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public String getUimg() {
		return uimg;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public void setUserYesPwd(String userYesPwd) {
		this.userYesPwd = userYesPwd;
	}
	public void setUserTypeId(String userTypeId) {
		this.userTypeId = userTypeId;
	}
	public void setUserTypeNumber(String userTypeNumber) {
		this.userTypeNumber = userTypeNumber;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public void setUimg(String uimg) {
		this.uimg = uimg;
	}
	public UsersTable(int uid, String userName, String userNumber, String userPwd, String userYesPwd, String userTypeId,
			String userTypeNumber, String userMobile, String userEmail, String uimg) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.userNumber = userNumber;
		this.userPwd = userPwd;
		this.userYesPwd = userYesPwd;
		this.userTypeId = userTypeId;
		this.userTypeNumber = userTypeNumber;
		this.userMobile = userMobile;
		this.userEmail = userEmail;
		this.uimg = uimg;
	}
	public UsersTable(String userName, String userNumber, String userPwd, String userYesPwd, String userTypeId,
			String userTypeNumber, String userMobile, String userEmail, String uimg) {
		super();
		this.userName = userName;
		this.userNumber = userNumber;
		this.userPwd = userPwd;
		this.userYesPwd = userYesPwd;
		this.userTypeId = userTypeId;
		this.userTypeNumber = userTypeNumber;
		this.userMobile = userMobile;
		this.userEmail = userEmail;
		this.uimg = uimg;
	}
	public UsersTable() {
		super();
	}
	@Override
	public String toString() {
		return "UsersTable [uid=" + uid + ", userName=" + userName + ", userNumber=" + userNumber + ", userPwd="
				+ userPwd + ", userYesPwd=" + userYesPwd + ", userTypeId=" + userTypeId + ", userTypeNumber="
				+ userTypeNumber + ", userMobile=" + userMobile + ", userEmail=" + userEmail + ", uimg=" + uimg + "]";
	}
	
	
}
