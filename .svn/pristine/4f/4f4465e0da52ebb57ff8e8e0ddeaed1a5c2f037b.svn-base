package cn.tedu.note.entity;

import java.io.Serializable;

/**
 * 用户表,对应数据库中cn_user表
 * @author Administrator
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = -1666887147701806566L;
	
	private String userId;
	private String userName;
	private String userPwd;
	private String userToken;
	private String userNick;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public User(String userId, String userName, String userPwd, String userToken, String userNick) {
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userToken = userToken;
		this.userNick = userNick;
	}
	public User() {}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userToken="
				+ userToken + ", userNick=" + userNick + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
}
