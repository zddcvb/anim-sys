package com.yanxi.anim.sys.pojo;

import java.util.ArrayList;
import java.util.List;

public class AnimResCatagortyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnimResCatagortyExample() {
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

        public Criteria andResCatagortyIdIsNull() {
            addCriterion("res_catagorty_id is null");
            return (Criteria) this;
        }

        public Criteria andResCatagortyIdIsNotNull() {
            addCriterion("res_catagorty_id is not null");
            return (Criteria) this;
        }

        public Criteria andResCatagortyIdEqualTo(String value) {
            addCriterion("res_catagorty_id =", value, "resCatagortyId");
            return (Criteria) this;
        }

        public Criteria andResCatagortyIdNotEqualTo(String value) {
            addCriterion("res_catagorty_id <>", value, "resCatagortyId");
            return (Criteria) this;
        }

        public Criteria andResCatagortyIdGreaterThan(String value) {
            addCriterion("res_catagorty_id >", value, "resCatagortyId");
            return (Criteria) this;
        }

        public Criteria andResCatagortyIdGreaterThanOrEqualTo(String value) {
            addCriterion("res_catagorty_id >=", value, "resCatagortyId");
            return (Criteria) this;
        }

        public Criteria andResCatagortyIdLessThan(String value) {
            addCriterion("res_catagorty_id <", value, "resCatagortyId");
            return (Criteria) this;
        }

        public Criteria andResCatagortyIdLessThanOrEqualTo(String value) {
            addCriterion("res_catagorty_id <=", value, "resCatagortyId");
            return (Criteria) this;
        }

        public Criteria andResCatagortyIdLike(String value) {
            addCriterion("res_catagorty_id like", value, "resCatagortyId");
            return (Criteria) this;
        }

        public Criteria andResCatagortyIdNotLike(String value) {
            addCriterion("res_catagorty_id not like", value, "resCatagortyId");
            return (Criteria) this;
        }

        public Criteria andResCatagortyIdIn(List<String> values) {
            addCriterion("res_catagorty_id in", values, "resCatagortyId");
            return (Criteria) this;
        }

        public Criteria andResCatagortyIdNotIn(List<String> values) {
            addCriterion("res_catagorty_id not in", values, "resCatagortyId");
            return (Criteria) this;
        }

        public Criteria andResCatagortyIdBetween(String value1, String value2) {
            addCriterion("res_catagorty_id between", value1, value2, "resCatagortyId");
            return (Criteria) this;
        }

        public Criteria andResCatagortyIdNotBetween(String value1, String value2) {
            addCriterion("res_catagorty_id not between", value1, value2, "resCatagortyId");
            return (Criteria) this;
        }

        public Criteria andResCatagortyNameIsNull() {
            addCriterion("res_catagorty_name is null");
            return (Criteria) this;
        }

        public Criteria andResCatagortyNameIsNotNull() {
            addCriterion("res_catagorty_name is not null");
            return (Criteria) this;
        }

        public Criteria andResCatagortyNameEqualTo(String value) {
            addCriterion("res_catagorty_name =", value, "resCatagortyName");
            return (Criteria) this;
        }

        public Criteria andResCatagortyNameNotEqualTo(String value) {
            addCriterion("res_catagorty_name <>", value, "resCatagortyName");
            return (Criteria) this;
        }

        public Criteria andResCatagortyNameGreaterThan(String value) {
            addCriterion("res_catagorty_name >", value, "resCatagortyName");
            return (Criteria) this;
        }

        public Criteria andResCatagortyNameGreaterThanOrEqualTo(String value) {
            addCriterion("res_catagorty_name >=", value, "resCatagortyName");
            return (Criteria) this;
        }

        public Criteria andResCatagortyNameLessThan(String value) {
            addCriterion("res_catagorty_name <", value, "resCatagortyName");
            return (Criteria) this;
        }

        public Criteria andResCatagortyNameLessThanOrEqualTo(String value) {
            addCriterion("res_catagorty_name <=", value, "resCatagortyName");
            return (Criteria) this;
        }

        public Criteria andResCatagortyNameLike(String value) {
            addCriterion("res_catagorty_name like", value, "resCatagortyName");
            return (Criteria) this;
        }

        public Criteria andResCatagortyNameNotLike(String value) {
            addCriterion("res_catagorty_name not like", value, "resCatagortyName");
            return (Criteria) this;
        }

        public Criteria andResCatagortyNameIn(List<String> values) {
            addCriterion("res_catagorty_name in", values, "resCatagortyName");
            return (Criteria) this;
        }

        public Criteria andResCatagortyNameNotIn(List<String> values) {
            addCriterion("res_catagorty_name not in", values, "resCatagortyName");
            return (Criteria) this;
        }

        public Criteria andResCatagortyNameBetween(String value1, String value2) {
            addCriterion("res_catagorty_name between", value1, value2, "resCatagortyName");
            return (Criteria) this;
        }

        public Criteria andResCatagortyNameNotBetween(String value1, String value2) {
            addCriterion("res_catagorty_name not between", value1, value2, "resCatagortyName");
            return (Criteria) this;
        }

        public Criteria andResCatagortyCreatetimeIsNull() {
            addCriterion("res_catagorty_createTime is null");
            return (Criteria) this;
        }

        public Criteria andResCatagortyCreatetimeIsNotNull() {
            addCriterion("res_catagorty_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andResCatagortyCreatetimeEqualTo(String value) {
            addCriterion("res_catagorty_createTime =", value, "resCatagortyCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyCreatetimeNotEqualTo(String value) {
            addCriterion("res_catagorty_createTime <>", value, "resCatagortyCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyCreatetimeGreaterThan(String value) {
            addCriterion("res_catagorty_createTime >", value, "resCatagortyCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("res_catagorty_createTime >=", value, "resCatagortyCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyCreatetimeLessThan(String value) {
            addCriterion("res_catagorty_createTime <", value, "resCatagortyCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("res_catagorty_createTime <=", value, "resCatagortyCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyCreatetimeLike(String value) {
            addCriterion("res_catagorty_createTime like", value, "resCatagortyCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyCreatetimeNotLike(String value) {
            addCriterion("res_catagorty_createTime not like", value, "resCatagortyCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyCreatetimeIn(List<String> values) {
            addCriterion("res_catagorty_createTime in", values, "resCatagortyCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyCreatetimeNotIn(List<String> values) {
            addCriterion("res_catagorty_createTime not in", values, "resCatagortyCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyCreatetimeBetween(String value1, String value2) {
            addCriterion("res_catagorty_createTime between", value1, value2, "resCatagortyCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyCreatetimeNotBetween(String value1, String value2) {
            addCriterion("res_catagorty_createTime not between", value1, value2, "resCatagortyCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyUpdatetimeIsNull() {
            addCriterion("res_catagorty_updateTime is null");
            return (Criteria) this;
        }

        public Criteria andResCatagortyUpdatetimeIsNotNull() {
            addCriterion("res_catagorty_updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andResCatagortyUpdatetimeEqualTo(String value) {
            addCriterion("res_catagorty_updateTime =", value, "resCatagortyUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyUpdatetimeNotEqualTo(String value) {
            addCriterion("res_catagorty_updateTime <>", value, "resCatagortyUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyUpdatetimeGreaterThan(String value) {
            addCriterion("res_catagorty_updateTime >", value, "resCatagortyUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("res_catagorty_updateTime >=", value, "resCatagortyUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyUpdatetimeLessThan(String value) {
            addCriterion("res_catagorty_updateTime <", value, "resCatagortyUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("res_catagorty_updateTime <=", value, "resCatagortyUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyUpdatetimeLike(String value) {
            addCriterion("res_catagorty_updateTime like", value, "resCatagortyUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyUpdatetimeNotLike(String value) {
            addCriterion("res_catagorty_updateTime not like", value, "resCatagortyUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyUpdatetimeIn(List<String> values) {
            addCriterion("res_catagorty_updateTime in", values, "resCatagortyUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyUpdatetimeNotIn(List<String> values) {
            addCriterion("res_catagorty_updateTime not in", values, "resCatagortyUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyUpdatetimeBetween(String value1, String value2) {
            addCriterion("res_catagorty_updateTime between", value1, value2, "resCatagortyUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResCatagortyUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("res_catagorty_updateTime not between", value1, value2, "resCatagortyUpdatetime");
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

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("parent_id like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("parent_id not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
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