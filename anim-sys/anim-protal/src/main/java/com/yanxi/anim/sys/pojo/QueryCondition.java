package com.yanxi.anim.sys.pojo;

public class QueryCondition {
	private String roleNameQuery;
	private String deptNameQuery;
	private String employeeNameQuery;
	private String resNameQuery;
	private String resCatagortyNameQuery;
	private Integer queryType = 0;

	public String getRoleNameQuery() {
		return roleNameQuery;
	}

	public void setRoleNameQuery(String roleNameQuery) {
		this.roleNameQuery = roleNameQuery;
	}

	public String getDeptNameQuery() {
		return deptNameQuery;
	}

	public void setDeptNameQuery(String deptNameQuery) {
		this.deptNameQuery = deptNameQuery;
	}

	public String getEmployeeNameQuery() {
		return employeeNameQuery;
	}

	public void setEmployeeNameQuery(String employeeNameQuery) {
		this.employeeNameQuery = employeeNameQuery;
	}

	public String getResNameQuery() {
		return resNameQuery;
	}

	public void setResNameQuery(String resNameQuery) {
		this.resNameQuery = resNameQuery;
	}

	public String getResCatagortyNameQuery() {
		return resCatagortyNameQuery;
	}

	public void setResCatagortyNameQuery(String resCatagortyNameQuery) {
		this.resCatagortyNameQuery = resCatagortyNameQuery;
	}

	public Integer getQueryType() {
		return queryType;
	}

	public void setQueryType(Integer queryType) {
		this.queryType = queryType;
	}

	@Override
	public String toString() {
		return "QueryCondition [roleNameQuery=" + roleNameQuery + ", deptNameQuery=" + deptNameQuery
				+ ", employeeNameQuery=" + employeeNameQuery + ", resNameQuery=" + resNameQuery
				+ ", resCatagortyNameQuery=" + resCatagortyNameQuery + ", queryType=" + queryType + "]";
	}

}
