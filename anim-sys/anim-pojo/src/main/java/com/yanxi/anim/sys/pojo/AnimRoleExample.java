package com.yanxi.anim.sys.pojo;

import java.util.ArrayList;
import java.util.List;

public class AnimRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnimRoleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(String value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(String value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(String value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(String value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(String value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLike(String value) {
            addCriterion("role_id like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLike(String value) {
            addCriterion("role_id not like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<String> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<String> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(String value1, String value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(String value1, String value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("role_name =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("role_name <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("role_name >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("role_name >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("role_name <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("role_name <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("role_name like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("role_name not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("role_name in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("role_name not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("role_name between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("role_name not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeIsNull() {
            addCriterion("role_createTime is null");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeIsNotNull() {
            addCriterion("role_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeEqualTo(String value) {
            addCriterion("role_createTime =", value, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeNotEqualTo(String value) {
            addCriterion("role_createTime <>", value, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeGreaterThan(String value) {
            addCriterion("role_createTime >", value, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("role_createTime >=", value, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeLessThan(String value) {
            addCriterion("role_createTime <", value, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("role_createTime <=", value, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeLike(String value) {
            addCriterion("role_createTime like", value, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeNotLike(String value) {
            addCriterion("role_createTime not like", value, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeIn(List<String> values) {
            addCriterion("role_createTime in", values, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeNotIn(List<String> values) {
            addCriterion("role_createTime not in", values, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeBetween(String value1, String value2) {
            addCriterion("role_createTime between", value1, value2, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCreatetimeNotBetween(String value1, String value2) {
            addCriterion("role_createTime not between", value1, value2, "roleCreatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeIsNull() {
            addCriterion("role_updateTime is null");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeIsNotNull() {
            addCriterion("role_updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeEqualTo(String value) {
            addCriterion("role_updateTime =", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeNotEqualTo(String value) {
            addCriterion("role_updateTime <>", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeGreaterThan(String value) {
            addCriterion("role_updateTime >", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("role_updateTime >=", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeLessThan(String value) {
            addCriterion("role_updateTime <", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("role_updateTime <=", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeLike(String value) {
            addCriterion("role_updateTime like", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeNotLike(String value) {
            addCriterion("role_updateTime not like", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeIn(List<String> values) {
            addCriterion("role_updateTime in", values, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeNotIn(List<String> values) {
            addCriterion("role_updateTime not in", values, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeBetween(String value1, String value2) {
            addCriterion("role_updateTime between", value1, value2, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("role_updateTime not between", value1, value2, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleDescIsNull() {
            addCriterion("role_desc is null");
            return (Criteria) this;
        }

        public Criteria andRoleDescIsNotNull() {
            addCriterion("role_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRoleDescEqualTo(String value) {
            addCriterion("role_desc =", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotEqualTo(String value) {
            addCriterion("role_desc <>", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescGreaterThan(String value) {
            addCriterion("role_desc >", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescGreaterThanOrEqualTo(String value) {
            addCriterion("role_desc >=", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescLessThan(String value) {
            addCriterion("role_desc <", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescLessThanOrEqualTo(String value) {
            addCriterion("role_desc <=", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescLike(String value) {
            addCriterion("role_desc like", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotLike(String value) {
            addCriterion("role_desc not like", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescIn(List<String> values) {
            addCriterion("role_desc in", values, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotIn(List<String> values) {
            addCriterion("role_desc not in", values, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescBetween(String value1, String value2) {
            addCriterion("role_desc between", value1, value2, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotBetween(String value1, String value2) {
            addCriterion("role_desc not between", value1, value2, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDutyIsNull() {
            addCriterion("role_duty is null");
            return (Criteria) this;
        }

        public Criteria andRoleDutyIsNotNull() {
            addCriterion("role_duty is not null");
            return (Criteria) this;
        }

        public Criteria andRoleDutyEqualTo(String value) {
            addCriterion("role_duty =", value, "roleDuty");
            return (Criteria) this;
        }

        public Criteria andRoleDutyNotEqualTo(String value) {
            addCriterion("role_duty <>", value, "roleDuty");
            return (Criteria) this;
        }

        public Criteria andRoleDutyGreaterThan(String value) {
            addCriterion("role_duty >", value, "roleDuty");
            return (Criteria) this;
        }

        public Criteria andRoleDutyGreaterThanOrEqualTo(String value) {
            addCriterion("role_duty >=", value, "roleDuty");
            return (Criteria) this;
        }

        public Criteria andRoleDutyLessThan(String value) {
            addCriterion("role_duty <", value, "roleDuty");
            return (Criteria) this;
        }

        public Criteria andRoleDutyLessThanOrEqualTo(String value) {
            addCriterion("role_duty <=", value, "roleDuty");
            return (Criteria) this;
        }

        public Criteria andRoleDutyLike(String value) {
            addCriterion("role_duty like", value, "roleDuty");
            return (Criteria) this;
        }

        public Criteria andRoleDutyNotLike(String value) {
            addCriterion("role_duty not like", value, "roleDuty");
            return (Criteria) this;
        }

        public Criteria andRoleDutyIn(List<String> values) {
            addCriterion("role_duty in", values, "roleDuty");
            return (Criteria) this;
        }

        public Criteria andRoleDutyNotIn(List<String> values) {
            addCriterion("role_duty not in", values, "roleDuty");
            return (Criteria) this;
        }

        public Criteria andRoleDutyBetween(String value1, String value2) {
            addCriterion("role_duty between", value1, value2, "roleDuty");
            return (Criteria) this;
        }

        public Criteria andRoleDutyNotBetween(String value1, String value2) {
            addCriterion("role_duty not between", value1, value2, "roleDuty");
            return (Criteria) this;
        }

        public Criteria andIsdeletedIsNull() {
            addCriterion("isDeleted is null");
            return (Criteria) this;
        }

        public Criteria andIsdeletedIsNotNull() {
            addCriterion("isDeleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeletedEqualTo(Boolean value) {
            addCriterion("isDeleted =", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedNotEqualTo(Boolean value) {
            addCriterion("isDeleted <>", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedGreaterThan(Boolean value) {
            addCriterion("isDeleted >", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isDeleted >=", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedLessThan(Boolean value) {
            addCriterion("isDeleted <", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("isDeleted <=", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedIn(List<Boolean> values) {
            addCriterion("isDeleted in", values, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedNotIn(List<Boolean> values) {
            addCriterion("isDeleted not in", values, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("isDeleted between", value1, value2, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isDeleted not between", value1, value2, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(String value) {
            addCriterion("dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(String value) {
            addCriterion("dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(String value) {
            addCriterion("dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(String value) {
            addCriterion("dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(String value) {
            addCriterion("dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(String value) {
            addCriterion("dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLike(String value) {
            addCriterion("dept_id like", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotLike(String value) {
            addCriterion("dept_id not like", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<String> values) {
            addCriterion("dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<String> values) {
            addCriterion("dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(String value1, String value2) {
            addCriterion("dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(String value1, String value2) {
            addCriterion("dept_id not between", value1, value2, "deptId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}