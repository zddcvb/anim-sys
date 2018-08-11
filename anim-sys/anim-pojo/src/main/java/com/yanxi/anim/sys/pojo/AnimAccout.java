package com.yanxi.anim.sys.pojo;

import java.io.Serializable;

public class AnimAccout implements Serializable{
	private String id;

	private String username;

	private String password;

	private Integer accoutType;

	private String profileUrl;

	private Boolean isdeleted;

	private String employeeId;

	private String accoutCreatetime;

	private String accoutUpdatetime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Integer getAccoutType() {
		return accoutType;
	}

	public void setAccoutType(Integer accoutType) {
		this.accoutType = accoutType;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl == null ? null : profileUrl.trim();
	}

	public Boolean getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(Boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId == null ? null : employeeId.trim();
	}

	public String getAccoutCreatetime() {
		return accoutCreatetime;
	}

	public void setAccoutCreatetime(String accoutCreatetime) {
		this.accoutCreatetime = accoutCreatetime == null ? null : accoutCreatetime.trim();
	}

	public String getAccoutUpdatetime() {
		return accoutUpdatetime;
	}

	public void setAccoutUpdatetime(String accoutUpdatetime) {
		this.accoutUpdatetime = accoutUpdatetime == null ? null : accoutUpdatetime.trim();
	}

	@Override
	public String toString() {
		return "AnimAccout [id=" + id + ", username=" + username + ", password=" + password + ", accoutType="
				+ accoutType + ", profileUrl=" + profileUrl + ", isdeleted=" + isdeleted + ", employeeId=" + employeeId
				+ ", accoutCreatetime=" + accoutCreatetime + ", accoutUpdatetime=" + accoutUpdatetime + "]";
	}

}