package com.yanxi.anim.sys.pojo;

public class AnimEmployee {
	private String employeeId;

	private String employeeSex;

	private String employeeName;

	private Integer employeeAge;

	private String employeeBorn;

	private String employeeCardnum;

	private String employeeSchool;

	private String employeeMajor;

	private String employeeEducation;

	private String employeeFamilyAddress;

	private String employeeNowAddress;

	private String employeeTelephone;

	private String employeeQq;

	private String employeeWechant;

	private String employeeWorkedTime;

	private Boolean isleaved;

	private String roleId;

	private String deptId;

	private String employeeCreatetime;

	private String employeeUpdatetime;

	private AnimRole animRole;

	private AnimDept animDept;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId == null ? null : employeeId.trim();
	}

	public String getEmployeeSex() {
		return employeeSex;
	}

	public void setEmployeeSex(String employeeSex) {
		this.employeeSex = employeeSex == null ? null : employeeSex.trim();
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName == null ? null : employeeName.trim();
	}

	public Integer getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(Integer employeeAge) {
		this.employeeAge = employeeAge;
	}

	public String getEmployeeBorn() {
		return employeeBorn;
	}

	public void setEmployeeBorn(String employeeBorn) {
		this.employeeBorn = employeeBorn == null ? null : employeeBorn.trim();
	}

	public String getEmployeeCardnum() {
		return employeeCardnum;
	}

	public void setEmployeeCardnum(String employeeCardnum) {
		this.employeeCardnum = employeeCardnum == null ? null : employeeCardnum.trim();
	}

	public String getEmployeeSchool() {
		return employeeSchool;
	}

	public void setEmployeeSchool(String employeeSchool) {
		this.employeeSchool = employeeSchool == null ? null : employeeSchool.trim();
	}

	public String getEmployeeMajor() {
		return employeeMajor;
	}

	public void setEmployeeMajor(String employeeMajor) {
		this.employeeMajor = employeeMajor == null ? null : employeeMajor.trim();
	}

	public String getEmployeeEducation() {
		return employeeEducation;
	}

	public void setEmployeeEducation(String employeeEducation) {
		this.employeeEducation = employeeEducation == null ? null : employeeEducation.trim();
	}

	public String getEmployeeFamilyAddress() {
		return employeeFamilyAddress;
	}

	public void setEmployeeFamilyAddress(String employeeFamilyAddress) {
		this.employeeFamilyAddress = employeeFamilyAddress == null ? null : employeeFamilyAddress.trim();
	}

	public String getEmployeeNowAddress() {
		return employeeNowAddress;
	}

	public void setEmployeeNowAddress(String employeeNowAddress) {
		this.employeeNowAddress = employeeNowAddress == null ? null : employeeNowAddress.trim();
	}

	public String getEmployeeTelephone() {
		return employeeTelephone;
	}

	public void setEmployeeTelephone(String employeeTelephone) {
		this.employeeTelephone = employeeTelephone == null ? null : employeeTelephone.trim();
	}

	public String getEmployeeQq() {
		return employeeQq;
	}

	public void setEmployeeQq(String employeeQq) {
		this.employeeQq = employeeQq == null ? null : employeeQq.trim();
	}

	public String getEmployeeWechant() {
		return employeeWechant;
	}

	public void setEmployeeWechant(String employeeWechant) {
		this.employeeWechant = employeeWechant == null ? null : employeeWechant.trim();
	}

	public String getEmployeeWorkedTime() {
		return employeeWorkedTime;
	}

	public void setEmployeeWorkedTime(String employeeWorkedTime) {
		this.employeeWorkedTime = employeeWorkedTime == null ? null : employeeWorkedTime.trim();
	}

	public Boolean getIsleaved() {
		return isleaved;
	}

	public void setIsleaved(Boolean isleaved) {
		this.isleaved = isleaved;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId == null ? null : roleId.trim();
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId == null ? null : deptId.trim();
	}

	public String getEmployeeCreatetime() {
		return employeeCreatetime;
	}

	public void setEmployeeCreatetime(String employeeCreatetime) {
		this.employeeCreatetime = employeeCreatetime == null ? null : employeeCreatetime.trim();
	}

	public String getEmployeeUpdatetime() {
		return employeeUpdatetime;
	}

	public void setEmployeeUpdatetime(String employeeUpdatetime) {
		this.employeeUpdatetime = employeeUpdatetime == null ? null : employeeUpdatetime.trim();
	}

	public AnimRole getAnimRole() {
		return animRole;
	}

	public void setAnimRole(AnimRole animRole) {
		this.animRole = animRole;
	}

	public AnimDept getAnimDept() {
		return animDept;
	}

	public void setAnimDept(AnimDept animDept) {
		this.animDept = animDept;
	}

	@Override
	public String toString() {
		return "AnimEmployee [employeeId=" + employeeId + ", employeeSex=" + employeeSex + ", employeeName="
				+ employeeName + ", employeeAge=" + employeeAge + ", employeeBorn=" + employeeBorn
				+ ", employeeCardnum=" + employeeCardnum + ", employeeSchool=" + employeeSchool + ", employeeMajor="
				+ employeeMajor + ", employeeEducation=" + employeeEducation + ", employeeFamilyAddress="
				+ employeeFamilyAddress + ", employeeNowAddress=" + employeeNowAddress + ", employeeTelephone="
				+ employeeTelephone + ", employeeQq=" + employeeQq + ", employeeWechant=" + employeeWechant
				+ ", employeeWorkedTime=" + employeeWorkedTime + ", isleaved=" + isleaved + ", roleId=" + roleId
				+ ", deptId=" + deptId + ", employeeCreatetime=" + employeeCreatetime + ", employeeUpdatetime="
				+ employeeUpdatetime + ", animRole=" + animRole + ", animDept=" + animDept + "]";
	}

}