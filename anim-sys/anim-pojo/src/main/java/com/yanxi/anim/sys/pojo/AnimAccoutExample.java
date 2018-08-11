package com.yanxi.anim.sys.pojo;

import java.util.ArrayList;
import java.util.List;

public class AnimAccoutExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnimAccoutExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andAccoutTypeIsNull() {
            addCriterion("accout_type is null");
            return (Criteria) this;
        }

        public Criteria andAccoutTypeIsNotNull() {
            addCriterion("accout_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccoutTypeEqualTo(Integer value) {
            addCriterion("accout_type =", value, "accoutType");
            return (Criteria) this;
        }

        public Criteria andAccoutTypeNotEqualTo(Integer value) {
            addCriterion("accout_type <>", value, "accoutType");
            return (Criteria) this;
        }

        public Criteria andAccoutTypeGreaterThan(Integer value) {
            addCriterion("accout_type >", value, "accoutType");
            return (Criteria) this;
        }

        public Criteria andAccoutTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("accout_type >=", value, "accoutType");
            return (Criteria) this;
        }

        public Criteria andAccoutTypeLessThan(Integer value) {
            addCriterion("accout_type <", value, "accoutType");
            return (Criteria) this;
        }

        public Criteria andAccoutTypeLessThanOrEqualTo(Integer value) {
            addCriterion("accout_type <=", value, "accoutType");
            return (Criteria) this;
        }

        public Criteria andAccoutTypeIn(List<Integer> values) {
            addCriterion("accout_type in", values, "accoutType");
            return (Criteria) this;
        }

        public Criteria andAccoutTypeNotIn(List<Integer> values) {
            addCriterion("accout_type not in", values, "accoutType");
            return (Criteria) this;
        }

        public Criteria andAccoutTypeBetween(Integer value1, Integer value2) {
            addCriterion("accout_type between", value1, value2, "accoutType");
            return (Criteria) this;
        }

        public Criteria andAccoutTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("accout_type not between", value1, value2, "accoutType");
            return (Criteria) this;
        }

        public Criteria andProfileUrlIsNull() {
            addCriterion("profile_url is null");
            return (Criteria) this;
        }

        public Criteria andProfileUrlIsNotNull() {
            addCriterion("profile_url is not null");
            return (Criteria) this;
        }

        public Criteria andProfileUrlEqualTo(String value) {
            addCriterion("profile_url =", value, "profileUrl");
            return (Criteria) this;
        }

        public Criteria andProfileUrlNotEqualTo(String value) {
            addCriterion("profile_url <>", value, "profileUrl");
            return (Criteria) this;
        }

        public Criteria andProfileUrlGreaterThan(String value) {
            addCriterion("profile_url >", value, "profileUrl");
            return (Criteria) this;
        }

        public Criteria andProfileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("profile_url >=", value, "profileUrl");
            return (Criteria) this;
        }

        public Criteria andProfileUrlLessThan(String value) {
            addCriterion("profile_url <", value, "profileUrl");
            return (Criteria) this;
        }

        public Criteria andProfileUrlLessThanOrEqualTo(String value) {
            addCriterion("profile_url <=", value, "profileUrl");
            return (Criteria) this;
        }

        public Criteria andProfileUrlLike(String value) {
            addCriterion("profile_url like", value, "profileUrl");
            return (Criteria) this;
        }

        public Criteria andProfileUrlNotLike(String value) {
            addCriterion("profile_url not like", value, "profileUrl");
            return (Criteria) this;
        }

        public Criteria andProfileUrlIn(List<String> values) {
            addCriterion("profile_url in", values, "profileUrl");
            return (Criteria) this;
        }

        public Criteria andProfileUrlNotIn(List<String> values) {
            addCriterion("profile_url not in", values, "profileUrl");
            return (Criteria) this;
        }

        public Criteria andProfileUrlBetween(String value1, String value2) {
            addCriterion("profile_url between", value1, value2, "profileUrl");
            return (Criteria) this;
        }

        public Criteria andProfileUrlNotBetween(String value1, String value2) {
            addCriterion("profile_url not between", value1, value2, "profileUrl");
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

        public Criteria andEmployeeIdIsNull() {
            addCriterion("employee_id is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNotNull() {
            addCriterion("employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdEqualTo(String value) {
            addCriterion("employee_id =", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotEqualTo(String value) {
            addCriterion("employee_id <>", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThan(String value) {
            addCriterion("employee_id >", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("employee_id >=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThan(String value) {
            addCriterion("employee_id <", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThanOrEqualTo(String value) {
            addCriterion("employee_id <=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLike(String value) {
            addCriterion("employee_id like", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotLike(String value) {
            addCriterion("employee_id not like", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIn(List<String> values) {
            addCriterion("employee_id in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotIn(List<String> values) {
            addCriterion("employee_id not in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdBetween(String value1, String value2) {
            addCriterion("employee_id between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotBetween(String value1, String value2) {
            addCriterion("employee_id not between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andAccoutCreatetimeIsNull() {
            addCriterion("accout_createTime is null");
            return (Criteria) this;
        }

        public Criteria andAccoutCreatetimeIsNotNull() {
            addCriterion("accout_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andAccoutCreatetimeEqualTo(String value) {
            addCriterion("accout_createTime =", value, "accoutCreatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutCreatetimeNotEqualTo(String value) {
            addCriterion("accout_createTime <>", value, "accoutCreatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutCreatetimeGreaterThan(String value) {
            addCriterion("accout_createTime >", value, "accoutCreatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("accout_createTime >=", value, "accoutCreatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutCreatetimeLessThan(String value) {
            addCriterion("accout_createTime <", value, "accoutCreatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("accout_createTime <=", value, "accoutCreatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutCreatetimeLike(String value) {
            addCriterion("accout_createTime like", value, "accoutCreatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutCreatetimeNotLike(String value) {
            addCriterion("accout_createTime not like", value, "accoutCreatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutCreatetimeIn(List<String> values) {
            addCriterion("accout_createTime in", values, "accoutCreatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutCreatetimeNotIn(List<String> values) {
            addCriterion("accout_createTime not in", values, "accoutCreatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutCreatetimeBetween(String value1, String value2) {
            addCriterion("accout_createTime between", value1, value2, "accoutCreatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutCreatetimeNotBetween(String value1, String value2) {
            addCriterion("accout_createTime not between", value1, value2, "accoutCreatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutUpdatetimeIsNull() {
            addCriterion("accout_updateTime is null");
            return (Criteria) this;
        }

        public Criteria andAccoutUpdatetimeIsNotNull() {
            addCriterion("accout_updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andAccoutUpdatetimeEqualTo(String value) {
            addCriterion("accout_updateTime =", value, "accoutUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutUpdatetimeNotEqualTo(String value) {
            addCriterion("accout_updateTime <>", value, "accoutUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutUpdatetimeGreaterThan(String value) {
            addCriterion("accout_updateTime >", value, "accoutUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("accout_updateTime >=", value, "accoutUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutUpdatetimeLessThan(String value) {
            addCriterion("accout_updateTime <", value, "accoutUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("accout_updateTime <=", value, "accoutUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutUpdatetimeLike(String value) {
            addCriterion("accout_updateTime like", value, "accoutUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutUpdatetimeNotLike(String value) {
            addCriterion("accout_updateTime not like", value, "accoutUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutUpdatetimeIn(List<String> values) {
            addCriterion("accout_updateTime in", values, "accoutUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutUpdatetimeNotIn(List<String> values) {
            addCriterion("accout_updateTime not in", values, "accoutUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutUpdatetimeBetween(String value1, String value2) {
            addCriterion("accout_updateTime between", value1, value2, "accoutUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAccoutUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("accout_updateTime not between", value1, value2, "accoutUpdatetime");
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