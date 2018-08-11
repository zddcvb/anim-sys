package com.yanxi.anim.sys.pojo;

import java.util.ArrayList;
import java.util.List;

public class AnimResExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnimResExample() {
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

        public Criteria andResIdIsNull() {
            addCriterion("res_id is null");
            return (Criteria) this;
        }

        public Criteria andResIdIsNotNull() {
            addCriterion("res_id is not null");
            return (Criteria) this;
        }

        public Criteria andResIdEqualTo(String value) {
            addCriterion("res_id =", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotEqualTo(String value) {
            addCriterion("res_id <>", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThan(String value) {
            addCriterion("res_id >", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThanOrEqualTo(String value) {
            addCriterion("res_id >=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThan(String value) {
            addCriterion("res_id <", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThanOrEqualTo(String value) {
            addCriterion("res_id <=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLike(String value) {
            addCriterion("res_id like", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotLike(String value) {
            addCriterion("res_id not like", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdIn(List<String> values) {
            addCriterion("res_id in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotIn(List<String> values) {
            addCriterion("res_id not in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdBetween(String value1, String value2) {
            addCriterion("res_id between", value1, value2, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotBetween(String value1, String value2) {
            addCriterion("res_id not between", value1, value2, "resId");
            return (Criteria) this;
        }

        public Criteria andResNameIsNull() {
            addCriterion("res_name is null");
            return (Criteria) this;
        }

        public Criteria andResNameIsNotNull() {
            addCriterion("res_name is not null");
            return (Criteria) this;
        }

        public Criteria andResNameEqualTo(String value) {
            addCriterion("res_name =", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotEqualTo(String value) {
            addCriterion("res_name <>", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameGreaterThan(String value) {
            addCriterion("res_name >", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameGreaterThanOrEqualTo(String value) {
            addCriterion("res_name >=", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameLessThan(String value) {
            addCriterion("res_name <", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameLessThanOrEqualTo(String value) {
            addCriterion("res_name <=", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameLike(String value) {
            addCriterion("res_name like", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotLike(String value) {
            addCriterion("res_name not like", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameIn(List<String> values) {
            addCriterion("res_name in", values, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotIn(List<String> values) {
            addCriterion("res_name not in", values, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameBetween(String value1, String value2) {
            addCriterion("res_name between", value1, value2, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotBetween(String value1, String value2) {
            addCriterion("res_name not between", value1, value2, "resName");
            return (Criteria) this;
        }

        public Criteria andResUrlIsNull() {
            addCriterion("res_url is null");
            return (Criteria) this;
        }

        public Criteria andResUrlIsNotNull() {
            addCriterion("res_url is not null");
            return (Criteria) this;
        }

        public Criteria andResUrlEqualTo(String value) {
            addCriterion("res_url =", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlNotEqualTo(String value) {
            addCriterion("res_url <>", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlGreaterThan(String value) {
            addCriterion("res_url >", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlGreaterThanOrEqualTo(String value) {
            addCriterion("res_url >=", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlLessThan(String value) {
            addCriterion("res_url <", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlLessThanOrEqualTo(String value) {
            addCriterion("res_url <=", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlLike(String value) {
            addCriterion("res_url like", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlNotLike(String value) {
            addCriterion("res_url not like", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlIn(List<String> values) {
            addCriterion("res_url in", values, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlNotIn(List<String> values) {
            addCriterion("res_url not in", values, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlBetween(String value1, String value2) {
            addCriterion("res_url between", value1, value2, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlNotBetween(String value1, String value2) {
            addCriterion("res_url not between", value1, value2, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResSizeIsNull() {
            addCriterion("res_size is null");
            return (Criteria) this;
        }

        public Criteria andResSizeIsNotNull() {
            addCriterion("res_size is not null");
            return (Criteria) this;
        }

        public Criteria andResSizeEqualTo(String value) {
            addCriterion("res_size =", value, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeNotEqualTo(String value) {
            addCriterion("res_size <>", value, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeGreaterThan(String value) {
            addCriterion("res_size >", value, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeGreaterThanOrEqualTo(String value) {
            addCriterion("res_size >=", value, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeLessThan(String value) {
            addCriterion("res_size <", value, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeLessThanOrEqualTo(String value) {
            addCriterion("res_size <=", value, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeLike(String value) {
            addCriterion("res_size like", value, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeNotLike(String value) {
            addCriterion("res_size not like", value, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeIn(List<String> values) {
            addCriterion("res_size in", values, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeNotIn(List<String> values) {
            addCriterion("res_size not in", values, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeBetween(String value1, String value2) {
            addCriterion("res_size between", value1, value2, "resSize");
            return (Criteria) this;
        }

        public Criteria andResSizeNotBetween(String value1, String value2) {
            addCriterion("res_size not between", value1, value2, "resSize");
            return (Criteria) this;
        }

        public Criteria andResCreatetimeIsNull() {
            addCriterion("res_createTime is null");
            return (Criteria) this;
        }

        public Criteria andResCreatetimeIsNotNull() {
            addCriterion("res_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andResCreatetimeEqualTo(String value) {
            addCriterion("res_createTime =", value, "resCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCreatetimeNotEqualTo(String value) {
            addCriterion("res_createTime <>", value, "resCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCreatetimeGreaterThan(String value) {
            addCriterion("res_createTime >", value, "resCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("res_createTime >=", value, "resCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCreatetimeLessThan(String value) {
            addCriterion("res_createTime <", value, "resCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("res_createTime <=", value, "resCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCreatetimeLike(String value) {
            addCriterion("res_createTime like", value, "resCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCreatetimeNotLike(String value) {
            addCriterion("res_createTime not like", value, "resCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCreatetimeIn(List<String> values) {
            addCriterion("res_createTime in", values, "resCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCreatetimeNotIn(List<String> values) {
            addCriterion("res_createTime not in", values, "resCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCreatetimeBetween(String value1, String value2) {
            addCriterion("res_createTime between", value1, value2, "resCreatetime");
            return (Criteria) this;
        }

        public Criteria andResCreatetimeNotBetween(String value1, String value2) {
            addCriterion("res_createTime not between", value1, value2, "resCreatetime");
            return (Criteria) this;
        }

        public Criteria andResUpdatetimeIsNull() {
            addCriterion("res_updateTime is null");
            return (Criteria) this;
        }

        public Criteria andResUpdatetimeIsNotNull() {
            addCriterion("res_updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andResUpdatetimeEqualTo(String value) {
            addCriterion("res_updateTime =", value, "resUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResUpdatetimeNotEqualTo(String value) {
            addCriterion("res_updateTime <>", value, "resUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResUpdatetimeGreaterThan(String value) {
            addCriterion("res_updateTime >", value, "resUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("res_updateTime >=", value, "resUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResUpdatetimeLessThan(String value) {
            addCriterion("res_updateTime <", value, "resUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("res_updateTime <=", value, "resUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResUpdatetimeLike(String value) {
            addCriterion("res_updateTime like", value, "resUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResUpdatetimeNotLike(String value) {
            addCriterion("res_updateTime not like", value, "resUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResUpdatetimeIn(List<String> values) {
            addCriterion("res_updateTime in", values, "resUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResUpdatetimeNotIn(List<String> values) {
            addCriterion("res_updateTime not in", values, "resUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResUpdatetimeBetween(String value1, String value2) {
            addCriterion("res_updateTime between", value1, value2, "resUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("res_updateTime not between", value1, value2, "resUpdatetime");
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

        public Criteria andResReviewUrlIsNull() {
            addCriterion("res_review_url is null");
            return (Criteria) this;
        }

        public Criteria andResReviewUrlIsNotNull() {
            addCriterion("res_review_url is not null");
            return (Criteria) this;
        }

        public Criteria andResReviewUrlEqualTo(String value) {
            addCriterion("res_review_url =", value, "resReviewUrl");
            return (Criteria) this;
        }

        public Criteria andResReviewUrlNotEqualTo(String value) {
            addCriterion("res_review_url <>", value, "resReviewUrl");
            return (Criteria) this;
        }

        public Criteria andResReviewUrlGreaterThan(String value) {
            addCriterion("res_review_url >", value, "resReviewUrl");
            return (Criteria) this;
        }

        public Criteria andResReviewUrlGreaterThanOrEqualTo(String value) {
            addCriterion("res_review_url >=", value, "resReviewUrl");
            return (Criteria) this;
        }

        public Criteria andResReviewUrlLessThan(String value) {
            addCriterion("res_review_url <", value, "resReviewUrl");
            return (Criteria) this;
        }

        public Criteria andResReviewUrlLessThanOrEqualTo(String value) {
            addCriterion("res_review_url <=", value, "resReviewUrl");
            return (Criteria) this;
        }

        public Criteria andResReviewUrlLike(String value) {
            addCriterion("res_review_url like", value, "resReviewUrl");
            return (Criteria) this;
        }

        public Criteria andResReviewUrlNotLike(String value) {
            addCriterion("res_review_url not like", value, "resReviewUrl");
            return (Criteria) this;
        }

        public Criteria andResReviewUrlIn(List<String> values) {
            addCriterion("res_review_url in", values, "resReviewUrl");
            return (Criteria) this;
        }

        public Criteria andResReviewUrlNotIn(List<String> values) {
            addCriterion("res_review_url not in", values, "resReviewUrl");
            return (Criteria) this;
        }

        public Criteria andResReviewUrlBetween(String value1, String value2) {
            addCriterion("res_review_url between", value1, value2, "resReviewUrl");
            return (Criteria) this;
        }

        public Criteria andResReviewUrlNotBetween(String value1, String value2) {
            addCriterion("res_review_url not between", value1, value2, "resReviewUrl");
            return (Criteria) this;
        }

        public Criteria andResViewUrlIsNull() {
            addCriterion("res_view_url is null");
            return (Criteria) this;
        }

        public Criteria andResViewUrlIsNotNull() {
            addCriterion("res_view_url is not null");
            return (Criteria) this;
        }

        public Criteria andResViewUrlEqualTo(String value) {
            addCriterion("res_view_url =", value, "resViewUrl");
            return (Criteria) this;
        }

        public Criteria andResViewUrlNotEqualTo(String value) {
            addCriterion("res_view_url <>", value, "resViewUrl");
            return (Criteria) this;
        }

        public Criteria andResViewUrlGreaterThan(String value) {
            addCriterion("res_view_url >", value, "resViewUrl");
            return (Criteria) this;
        }

        public Criteria andResViewUrlGreaterThanOrEqualTo(String value) {
            addCriterion("res_view_url >=", value, "resViewUrl");
            return (Criteria) this;
        }

        public Criteria andResViewUrlLessThan(String value) {
            addCriterion("res_view_url <", value, "resViewUrl");
            return (Criteria) this;
        }

        public Criteria andResViewUrlLessThanOrEqualTo(String value) {
            addCriterion("res_view_url <=", value, "resViewUrl");
            return (Criteria) this;
        }

        public Criteria andResViewUrlLike(String value) {
            addCriterion("res_view_url like", value, "resViewUrl");
            return (Criteria) this;
        }

        public Criteria andResViewUrlNotLike(String value) {
            addCriterion("res_view_url not like", value, "resViewUrl");
            return (Criteria) this;
        }

        public Criteria andResViewUrlIn(List<String> values) {
            addCriterion("res_view_url in", values, "resViewUrl");
            return (Criteria) this;
        }

        public Criteria andResViewUrlNotIn(List<String> values) {
            addCriterion("res_view_url not in", values, "resViewUrl");
            return (Criteria) this;
        }

        public Criteria andResViewUrlBetween(String value1, String value2) {
            addCriterion("res_view_url between", value1, value2, "resViewUrl");
            return (Criteria) this;
        }

        public Criteria andResViewUrlNotBetween(String value1, String value2) {
            addCriterion("res_view_url not between", value1, value2, "resViewUrl");
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