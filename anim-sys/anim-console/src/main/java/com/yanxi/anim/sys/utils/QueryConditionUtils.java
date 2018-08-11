package com.yanxi.anim.sys.utils;

import javax.servlet.http.HttpServletRequest;

import com.yanxi.anim.sys.pojo.QueryCondition;

public class QueryConditionUtils {
	public static QueryCondition queryRes(HttpServletRequest request) {
		QueryCondition condition = new QueryCondition();
		String resNameQuery = request.getParameter("resNameQuery");
		String resCatagortyNameQuery = request.getParameter("resCatagortyNameQuery");
		condition.setResNameQuery(resNameQuery);
		condition.setResCatagortyNameQuery(resCatagortyNameQuery);
		return condition;
	}

	public static QueryCondition queryEmployee(HttpServletRequest request) {
		QueryCondition condition = new QueryCondition();
		String employeeNameQuery = request.getParameter("employeeNameQuery");
		String roleNameQuery = request.getParameter("roleNameQuery");
		String deptNameQuery = request.getParameter("deptNameQuery");
		condition.setEmployeeNameQuery(employeeNameQuery);
		condition.setRoleNameQuery(roleNameQuery);
		condition.setDeptNameQuery(deptNameQuery);
		return condition;
	}
}
