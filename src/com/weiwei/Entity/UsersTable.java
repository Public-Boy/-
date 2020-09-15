package com.weiwei.Entity;

public class UsersTable {
	private int uid;				//用户ID
	private String userName;		//用户真实姓名
	private String userNumber;		//用户名
	private String userPwd;			//用户密码
	private String userYesPwd;		//确认密码
	private String userTypeId;		//用户证件类型
	private String userTypeNumber;	//用户号码
	private String userMobile;		//用户手机号码
	private String userEmail;		//用户电子邮箱
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
