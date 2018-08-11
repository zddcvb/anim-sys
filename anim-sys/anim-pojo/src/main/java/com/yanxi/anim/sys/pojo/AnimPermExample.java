package com.yanxi.anim.sys.pojo;

import java.util.ArrayList;
import java.util.List;

public class AnimPermExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnimPermExample() {
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

        public Criteria andPermIdIsNull() {
            addCriterion("perm_id is null");
            return (Criteria) this;
        }

        public Criteria andPermIdIsNotNull() {
            addCriterion("perm_id is not null");
            return (Criteria) this;
        }

        public Criteria andPermIdEqualTo(String value) {
            addCriterion("perm_id =", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotEqualTo(String value) {
            addCriterion("perm_id <>", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdGreaterThan(String value) {
            addCriterion("perm_id >", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdGreaterThanOrEqualTo(String value) {
            addCriterion("perm_id >=", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdLessThan(String value) {
            addCriterion("perm_id <", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdLessThanOrEqualTo(String value) {
            addCriterion("perm_id <=", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdLike(String value) {
            addCriterion("perm_id like", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotLike(String value) {
            addCriterion("perm_id not like", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdIn(List<String> values) {
            addCriterion("perm_id in", values, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotIn(List<String> values) {
            addCriterion("perm_id not in", values, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdBetween(String value1, String value2) {
            addCriterion("perm_id between", value1, value2, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotBetween(String value1, String value2) {
            addCriterion("perm_id not between", value1, value2, "permId");
            return (Criteria) this;
        }

        public Criteria andPermUrlIsNull() {
            addCriterion("perm_url is null");
            return (Criteria) this;
        }

        public Criteria andPermUrlIsNotNull() {
            addCriterion("perm_url is not null");
            return (Criteria) this;
        }

        public Criteria andPermUrlEqualTo(String value) {
            addCriterion("perm_url =", value, "permUrl");
            return (Criteria) this;
        }

        public Criteria andPermUrlNotEqualTo(String value) {
            addCriterion("perm_url <>", value, "permUrl");
            return (Criteria) this;
        }

        public Criteria andPermUrlGreaterThan(String value) {
            addCriterion("perm_url >", value, "permUrl");
            return (Criteria) this;
        }

        public Criteria andPermUrlGreaterThanOrEqualTo(String value) {
            addCriterion("perm_url >=", value, "permUrl");
            return (Criteria) this;
        }

        public Criteria andPermUrlLessThan(String value) {
            addCriterion("perm_url <", value, "permUrl");
            return (Criteria) this;
        }

        public Criteria andPermUrlLessThanOrEqualTo(String value) {
            addCriterion("perm_url <=", value, "permUrl");
            return (Criteria) this;
        }

        public Criteria andPermUrlLike(String value) {
            addCriterion("perm_url like", value, "permUrl");
            return (Criteria) this;
        }

        public Criteria andPermUrlNotLike(String value) {
            addCriterion("perm_url not like", value, "permUrl");
            return (Criteria) this;
        }

        public Criteria andPermUrlIn(List<String> values) {
            addCriterion("perm_url in", values, "permUrl");
            return (Criteria) this;
        }

        public Criteria andPermUrlNotIn(List<String> values) {
            addCriterion("perm_url not in", values, "permUrl");
            return (Criteria) this;
        }

        public Criteria andPermUrlBetween(String value1, String value2) {
            addCriterion("perm_url between", value1, value2, "permUrl");
            return (Criteria) this;
        }

        public Criteria andPermUrlNotBetween(String value1, String value2) {
            addCriterion("perm_url not between", value1, value2, "permUrl");
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