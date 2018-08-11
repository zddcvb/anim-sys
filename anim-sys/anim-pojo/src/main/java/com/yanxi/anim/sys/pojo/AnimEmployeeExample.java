package com.yanxi.anim.sys.pojo;

import java.util.ArrayList;
import java.util.List;

public class AnimEmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnimEmployeeExample() {
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

        public Criteria andEmployeeSexIsNull() {
            addCriterion("employee_sex is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexIsNotNull() {
            addCriterion("employee_sex is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexEqualTo(String value) {
            addCriterion("employee_sex =", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexNotEqualTo(String value) {
            addCriterion("employee_sex <>", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexGreaterThan(String value) {
            addCriterion("employee_sex >", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexGreaterThanOrEqualTo(String value) {
            addCriterion("employee_sex >=", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexLessThan(String value) {
            addCriterion("employee_sex <", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexLessThanOrEqualTo(String value) {
            addCriterion("employee_sex <=", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexLike(String value) {
            addCriterion("employee_sex like", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexNotLike(String value) {
            addCriterion("employee_sex not like", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexIn(List<String> values) {
            addCriterion("employee_sex in", values, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexNotIn(List<String> values) {
            addCriterion("employee_sex not in", values, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexBetween(String value1, String value2) {
            addCriterion("employee_sex between", value1, value2, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexNotBetween(String value1, String value2) {
            addCriterion("employee_sex not between", value1, value2, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIsNull() {
            addCriterion("employee_name is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIsNotNull() {
            addCriterion("employee_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameEqualTo(String value) {
            addCriterion("employee_name =", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotEqualTo(String value) {
            addCriterion("employee_name <>", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThan(String value) {
            addCriterion("employee_name >", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThanOrEqualTo(String value) {
            addCriterion("employee_name >=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThan(String value) {
            addCriterion("employee_name <", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThanOrEqualTo(String value) {
            addCriterion("employee_name <=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLike(String value) {
            addCriterion("employee_name like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotLike(String value) {
            addCriterion("employee_name not like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIn(List<String> values) {
            addCriterion("employee_name in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotIn(List<String> values) {
            addCriterion("employee_name not in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameBetween(String value1, String value2) {
            addCriterion("employee_name between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotBetween(String value1, String value2) {
            addCriterion("employee_name not between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeIsNull() {
            addCriterion("employee_age is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeIsNotNull() {
            addCriterion("employee_age is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeEqualTo(Integer value) {
            addCriterion("employee_age =", value, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeNotEqualTo(Integer value) {
            addCriterion("employee_age <>", value, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeGreaterThan(Integer value) {
            addCriterion("employee_age >", value, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("employee_age >=", value, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeLessThan(Integer value) {
            addCriterion("employee_age <", value, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeLessThanOrEqualTo(Integer value) {
            addCriterion("employee_age <=", value, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeIn(List<Integer> values) {
            addCriterion("employee_age in", values, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeNotIn(List<Integer> values) {
            addCriterion("employee_age not in", values, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeBetween(Integer value1, Integer value2) {
            addCriterion("employee_age between", value1, value2, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("employee_age not between", value1, value2, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeBornIsNull() {
            addCriterion("employee_born is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeBornIsNotNull() {
            addCriterion("employee_born is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeBornEqualTo(String value) {
            addCriterion("employee_born =", value, "employeeBorn");
            return (Criteria) this;
        }

        public Criteria andEmployeeBornNotEqualTo(String value) {
            addCriterion("employee_born <>", value, "employeeBorn");
            return (Criteria) this;
        }

        public Criteria andEmployeeBornGreaterThan(String value) {
            addCriterion("employee_born >", value, "employeeBorn");
            return (Criteria) this;
        }

        public Criteria andEmployeeBornGreaterThanOrEqualTo(String value) {
            addCriterion("employee_born >=", value, "employeeBorn");
            return (Criteria) this;
        }

        public Criteria andEmployeeBornLessThan(String value) {
            addCriterion("employee_born <", value, "employeeBorn");
            return (Criteria) this;
        }

        public Criteria andEmployeeBornLessThanOrEqualTo(String value) {
            addCriterion("employee_born <=", value, "employeeBorn");
            return (Criteria) this;
        }

        public Criteria andEmployeeBornLike(String value) {
            addCriterion("employee_born like", value, "employeeBorn");
            return (Criteria) this;
        }

        public Criteria andEmployeeBornNotLike(String value) {
            addCriterion("employee_born not like", value, "employeeBorn");
            return (Criteria) this;
        }

        public Criteria andEmployeeBornIn(List<String> values) {
            addCriterion("employee_born in", values, "employeeBorn");
            return (Criteria) this;
        }

        public Criteria andEmployeeBornNotIn(List<String> values) {
            addCriterion("employee_born not in", values, "employeeBorn");
            return (Criteria) this;
        }

        public Criteria andEmployeeBornBetween(String value1, String value2) {
            addCriterion("employee_born between", value1, value2, "employeeBorn");
            return (Criteria) this;
        }

        public Criteria andEmployeeBornNotBetween(String value1, String value2) {
            addCriterion("employee_born not between", value1, value2, "employeeBorn");
            return (Criteria) this;
        }

        public Criteria andEmployeeCardnumIsNull() {
            addCriterion("employee_cardNum is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeCardnumIsNotNull() {
            addCriterion("employee_cardNum is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeCardnumEqualTo(String value) {
            addCriterion("employee_cardNum =", value, "employeeCardnum");
            return (Criteria) this;
        }

        public Criteria andEmployeeCardnumNotEqualTo(String value) {
            addCriterion("employee_cardNum <>", value, "employeeCardnum");
            return (Criteria) this;
        }

        public Criteria andEmployeeCardnumGreaterThan(String value) {
            addCriterion("employee_cardNum >", value, "employeeCardnum");
            return (Criteria) this;
        }

        public Criteria andEmployeeCardnumGreaterThanOrEqualTo(String value) {
            addCriterion("employee_cardNum >=", value, "employeeCardnum");
            return (Criteria) this;
        }

        public Criteria andEmployeeCardnumLessThan(String value) {
            addCriterion("employee_cardNum <", value, "employeeCardnum");
            return (Criteria) this;
        }

        public Criteria andEmployeeCardnumLessThanOrEqualTo(String value) {
            addCriterion("employee_cardNum <=", value, "employeeCardnum");
            return (Criteria) this;
        }

        public Criteria andEmployeeCardnumLike(String value) {
            addCriterion("employee_cardNum like", value, "employeeCardnum");
            return (Criteria) this;
        }

        public Criteria andEmployeeCardnumNotLike(String value) {
            addCriterion("employee_cardNum not like", value, "employeeCardnum");
            return (Criteria) this;
        }

        public Criteria andEmployeeCardnumIn(List<String> values) {
            addCriterion("employee_cardNum in", values, "employeeCardnum");
            return (Criteria) this;
        }

        public Criteria andEmployeeCardnumNotIn(List<String> values) {
            addCriterion("employee_cardNum not in", values, "employeeCardnum");
            return (Criteria) this;
        }

        public Criteria andEmployeeCardnumBetween(String value1, String value2) {
            addCriterion("employee_cardNum between", value1, value2, "employeeCardnum");
            return (Criteria) this;
        }

        public Criteria andEmployeeCardnumNotBetween(String value1, String value2) {
            addCriterion("employee_cardNum not between", value1, value2, "employeeCardnum");
            return (Criteria) this;
        }

        public Criteria andEmployeeSchoolIsNull() {
            addCriterion("employee_school is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeSchoolIsNotNull() {
            addCriterion("employee_school is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeSchoolEqualTo(String value) {
            addCriterion("employee_school =", value, "employeeSchool");
            return (Criteria) this;
        }

        public Criteria andEmployeeSchoolNotEqualTo(String value) {
            addCriterion("employee_school <>", value, "employeeSchool");
            return (Criteria) this;
        }

        public Criteria andEmployeeSchoolGreaterThan(String value) {
            addCriterion("employee_school >", value, "employeeSchool");
            return (Criteria) this;
        }

        public Criteria andEmployeeSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("employee_school >=", value, "employeeSchool");
            return (Criteria) this;
        }

        public Criteria andEmployeeSchoolLessThan(String value) {
            addCriterion("employee_school <", value, "employeeSchool");
            return (Criteria) this;
        }

        public Criteria andEmployeeSchoolLessThanOrEqualTo(String value) {
            addCriterion("employee_school <=", value, "employeeSchool");
            return (Criteria) this;
        }

        public Criteria andEmployeeSchoolLike(String value) {
            addCriterion("employee_school like", value, "employeeSchool");
            return (Criteria) this;
        }

        public Criteria andEmployeeSchoolNotLike(String value) {
            addCriterion("employee_school not like", value, "employeeSchool");
            return (Criteria) this;
        }

        public Criteria andEmployeeSchoolIn(List<String> values) {
            addCriterion("employee_school in", values, "employeeSchool");
            return (Criteria) this;
        }

        public Criteria andEmployeeSchoolNotIn(List<String> values) {
            addCriterion("employee_school not in", values, "employeeSchool");
            return (Criteria) this;
        }

        public Criteria andEmployeeSchoolBetween(String value1, String value2) {
            addCriterion("employee_school between", value1, value2, "employeeSchool");
            return (Criteria) this;
        }

        public Criteria andEmployeeSchoolNotBetween(String value1, String value2) {
            addCriterion("employee_school not between", value1, value2, "employeeSchool");
            return (Criteria) this;
        }

        public Criteria andEmployeeMajorIsNull() {
            addCriterion("employee_major is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeMajorIsNotNull() {
            addCriterion("employee_major is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeMajorEqualTo(String value) {
            addCriterion("employee_major =", value, "employeeMajor");
            return (Criteria) this;
        }

        public Criteria andEmployeeMajorNotEqualTo(String value) {
            addCriterion("employee_major <>", value, "employeeMajor");
            return (Criteria) this;
        }

        public Criteria andEmployeeMajorGreaterThan(String value) {
            addCriterion("employee_major >", value, "employeeMajor");
            return (Criteria) this;
        }

        public Criteria andEmployeeMajorGreaterThanOrEqualTo(String value) {
            addCriterion("employee_major >=", value, "employeeMajor");
            return (Criteria) this;
        }

        public Criteria andEmployeeMajorLessThan(String value) {
            addCriterion("employee_major <", value, "employeeMajor");
            return (Criteria) this;
        }

        public Criteria andEmployeeMajorLessThanOrEqualTo(String value) {
            addCriterion("employee_major <=", value, "employeeMajor");
            return (Criteria) this;
        }

        public Criteria andEmployeeMajorLike(String value) {
            addCriterion("employee_major like", value, "employeeMajor");
            return (Criteria) this;
        }

        public Criteria andEmployeeMajorNotLike(String value) {
            addCriterion("employee_major not like", value, "employeeMajor");
            return (Criteria) this;
        }

        public Criteria andEmployeeMajorIn(List<String> values) {
            addCriterion("employee_major in", values, "employeeMajor");
            return (Criteria) this;
        }

        public Criteria andEmployeeMajorNotIn(List<String> values) {
            addCriterion("employee_major not in", values, "employeeMajor");
            return (Criteria) this;
        }

        public Criteria andEmployeeMajorBetween(String value1, String value2) {
            addCriterion("employee_major between", value1, value2, "employeeMajor");
            return (Criteria) this;
        }

        public Criteria andEmployeeMajorNotBetween(String value1, String value2) {
            addCriterion("employee_major not between", value1, value2, "employeeMajor");
            return (Criteria) this;
        }

        public Criteria andEmployeeEducationIsNull() {
            addCriterion("employee_education is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeEducationIsNotNull() {
            addCriterion("employee_education is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeEducationEqualTo(String value) {
            addCriterion("employee_education =", value, "employeeEducation");
            return (Criteria) this;
        }

        public Criteria andEmployeeEducationNotEqualTo(String value) {
            addCriterion("employee_education <>", value, "employeeEducation");
            return (Criteria) this;
        }

        public Criteria andEmployeeEducationGreaterThan(String value) {
            addCriterion("employee_education >", value, "employeeEducation");
            return (Criteria) this;
        }

        public Criteria andEmployeeEducationGreaterThanOrEqualTo(String value) {
            addCriterion("employee_education >=", value, "employeeEducation");
            return (Criteria) this;
        }

        public Criteria andEmployeeEducationLessThan(String value) {
            addCriterion("employee_education <", value, "employeeEducation");
            return (Criteria) this;
        }

        public Criteria andEmployeeEducationLessThanOrEqualTo(String value) {
            addCriterion("employee_education <=", value, "employeeEducation");
            return (Criteria) this;
        }

        public Criteria andEmployeeEducationLike(String value) {
            addCriterion("employee_education like", value, "employeeEducation");
            return (Criteria) this;
        }

        public Criteria andEmployeeEducationNotLike(String value) {
            addCriterion("employee_education not like", value, "employeeEducation");
            return (Criteria) this;
        }

        public Criteria andEmployeeEducationIn(List<String> values) {
            addCriterion("employee_education in", values, "employeeEducation");
            return (Criteria) this;
        }

        public Criteria andEmployeeEducationNotIn(List<String> values) {
            addCriterion("employee_education not in", values, "employeeEducation");
            return (Criteria) this;
        }

        public Criteria andEmployeeEducationBetween(String value1, String value2) {
            addCriterion("employee_education between", value1, value2, "employeeEducation");
            return (Criteria) this;
        }

        public Criteria andEmployeeEducationNotBetween(String value1, String value2) {
            addCriterion("employee_education not between", value1, value2, "employeeEducation");
            return (Criteria) this;
        }

        public Criteria andEmployeeFamilyAddressIsNull() {
            addCriterion("employee_family_address is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeFamilyAddressIsNotNull() {
            addCriterion("employee_family_address is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeFamilyAddressEqualTo(String value) {
            addCriterion("employee_family_address =", value, "employeeFamilyAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeFamilyAddressNotEqualTo(String value) {
            addCriterion("employee_family_address <>", value, "employeeFamilyAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeFamilyAddressGreaterThan(String value) {
            addCriterion("employee_family_address >", value, "employeeFamilyAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeFamilyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("employee_family_address >=", value, "employeeFamilyAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeFamilyAddressLessThan(String value) {
            addCriterion("employee_family_address <", value, "employeeFamilyAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeFamilyAddressLessThanOrEqualTo(String value) {
            addCriterion("employee_family_address <=", value, "employeeFamilyAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeFamilyAddressLike(String value) {
            addCriterion("employee_family_address like", value, "employeeFamilyAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeFamilyAddressNotLike(String value) {
            addCriterion("employee_family_address not like", value, "employeeFamilyAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeFamilyAddressIn(List<String> values) {
            addCriterion("employee_family_address in", values, "employeeFamilyAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeFamilyAddressNotIn(List<String> values) {
            addCriterion("employee_family_address not in", values, "employeeFamilyAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeFamilyAddressBetween(String value1, String value2) {
            addCriterion("employee_family_address between", value1, value2, "employeeFamilyAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeFamilyAddressNotBetween(String value1, String value2) {
            addCriterion("employee_family_address not between", value1, value2, "employeeFamilyAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeNowAddressIsNull() {
            addCriterion("employee_now_address is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNowAddressIsNotNull() {
            addCriterion("employee_now_address is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNowAddressEqualTo(String value) {
            addCriterion("employee_now_address =", value, "employeeNowAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeNowAddressNotEqualTo(String value) {
            addCriterion("employee_now_address <>", value, "employeeNowAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeNowAddressGreaterThan(String value) {
            addCriterion("employee_now_address >", value, "employeeNowAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeNowAddressGreaterThanOrEqualTo(String value) {
            addCriterion("employee_now_address >=", value, "employeeNowAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeNowAddressLessThan(String value) {
            addCriterion("employee_now_address <", value, "employeeNowAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeNowAddressLessThanOrEqualTo(String value) {
            addCriterion("employee_now_address <=", value, "employeeNowAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeNowAddressLike(String value) {
            addCriterion("employee_now_address like", value, "employeeNowAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeNowAddressNotLike(String value) {
            addCriterion("employee_now_address not like", value, "employeeNowAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeNowAddressIn(List<String> values) {
            addCriterion("employee_now_address in", values, "employeeNowAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeNowAddressNotIn(List<String> values) {
            addCriterion("employee_now_address not in", values, "employeeNowAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeNowAddressBetween(String value1, String value2) {
            addCriterion("employee_now_address between", value1, value2, "employeeNowAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeNowAddressNotBetween(String value1, String value2) {
            addCriterion("employee_now_address not between", value1, value2, "employeeNowAddress");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelephoneIsNull() {
            addCriterion("employee_telephone is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelephoneIsNotNull() {
            addCriterion("employee_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelephoneEqualTo(String value) {
            addCriterion("employee_telephone =", value, "employeeTelephone");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelephoneNotEqualTo(String value) {
            addCriterion("employee_telephone <>", value, "employeeTelephone");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelephoneGreaterThan(String value) {
            addCriterion("employee_telephone >", value, "employeeTelephone");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("employee_telephone >=", value, "employeeTelephone");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelephoneLessThan(String value) {
            addCriterion("employee_telephone <", value, "employeeTelephone");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelephoneLessThanOrEqualTo(String value) {
            addCriterion("employee_telephone <=", value, "employeeTelephone");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelephoneLike(String value) {
            addCriterion("employee_telephone like", value, "employeeTelephone");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelephoneNotLike(String value) {
            addCriterion("employee_telephone not like", value, "employeeTelephone");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelephoneIn(List<String> values) {
            addCriterion("employee_telephone in", values, "employeeTelephone");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelephoneNotIn(List<String> values) {
            addCriterion("employee_telephone not in", values, "employeeTelephone");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelephoneBetween(String value1, String value2) {
            addCriterion("employee_telephone between", value1, value2, "employeeTelephone");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelephoneNotBetween(String value1, String value2) {
            addCriterion("employee_telephone not between", value1, value2, "employeeTelephone");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqIsNull() {
            addCriterion("employee_qq is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqIsNotNull() {
            addCriterion("employee_qq is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqEqualTo(String value) {
            addCriterion("employee_qq =", value, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqNotEqualTo(String value) {
            addCriterion("employee_qq <>", value, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqGreaterThan(String value) {
            addCriterion("employee_qq >", value, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqGreaterThanOrEqualTo(String value) {
            addCriterion("employee_qq >=", value, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqLessThan(String value) {
            addCriterion("employee_qq <", value, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqLessThanOrEqualTo(String value) {
            addCriterion("employee_qq <=", value, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqLike(String value) {
            addCriterion("employee_qq like", value, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqNotLike(String value) {
            addCriterion("employee_qq not like", value, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqIn(List<String> values) {
            addCriterion("employee_qq in", values, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqNotIn(List<String> values) {
            addCriterion("employee_qq not in", values, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqBetween(String value1, String value2) {
            addCriterion("employee_qq between", value1, value2, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqNotBetween(String value1, String value2) {
            addCriterion("employee_qq not between", value1, value2, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeWechantIsNull() {
            addCriterion("employee_wechant is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeWechantIsNotNull() {
            addCriterion("employee_wechant is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeWechantEqualTo(String value) {
            addCriterion("employee_wechant =", value, "employeeWechant");
            return (Criteria) this;
        }

        public Criteria andEmployeeWechantNotEqualTo(String value) {
            addCriterion("employee_wechant <>", value, "employeeWechant");
            return (Criteria) this;
        }

        public Criteria andEmployeeWechantGreaterThan(String value) {
            addCriterion("employee_wechant >", value, "employeeWechant");
            return (Criteria) this;
        }

        public Criteria andEmployeeWechantGreaterThanOrEqualTo(String value) {
            addCriterion("employee_wechant >=", value, "employeeWechant");
            return (Criteria) this;
        }

        public Criteria andEmployeeWechantLessThan(String value) {
            addCriterion("employee_wechant <", value, "employeeWechant");
            return (Criteria) this;
        }

        public Criteria andEmployeeWechantLessThanOrEqualTo(String value) {
            addCriterion("employee_wechant <=", value, "employeeWechant");
            return (Criteria) this;
        }

        public Criteria andEmployeeWechantLike(String value) {
            addCriterion("employee_wechant like", value, "employeeWechant");
            return (Criteria) this;
        }

        public Criteria andEmployeeWechantNotLike(String value) {
            addCriterion("employee_wechant not like", value, "employeeWechant");
            return (Criteria) this;
        }

        public Criteria andEmployeeWechantIn(List<String> values) {
            addCriterion("employee_wechant in", values, "employeeWechant");
            return (Criteria) this;
        }

        public Criteria andEmployeeWechantNotIn(List<String> values) {
            addCriterion("employee_wechant not in", values, "employeeWechant");
            return (Criteria) this;
        }

        public Criteria andEmployeeWechantBetween(String value1, String value2) {
            addCriterion("employee_wechant between", value1, value2, "employeeWechant");
            return (Criteria) this;
        }

        public Criteria andEmployeeWechantNotBetween(String value1, String value2) {
            addCriterion("employee_wechant not between", value1, value2, "employeeWechant");
            return (Criteria) this;
        }

        public Criteria andEmployeeWorkedTimeIsNull() {
            addCriterion("employee_worked_time is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeWorkedTimeIsNotNull() {
            addCriterion("employee_worked_time is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeWorkedTimeEqualTo(String value) {
            addCriterion("employee_worked_time =", value, "employeeWorkedTime");
            return (Criteria) this;
        }

        public Criteria andEmployeeWorkedTimeNotEqualTo(String value) {
            addCriterion("employee_worked_time <>", value, "employeeWorkedTime");
            return (Criteria) this;
        }

        public Criteria andEmployeeWorkedTimeGreaterThan(String value) {
            addCriterion("employee_worked_time >", value, "employeeWorkedTime");
            return (Criteria) this;
        }

        public Criteria andEmployeeWorkedTimeGreaterThanOrEqualTo(String value) {
            addCriterion("employee_worked_time >=", value, "employeeWorkedTime");
            return (Criteria) this;
        }

        public Criteria andEmployeeWorkedTimeLessThan(String value) {
            addCriterion("employee_worked_time <", value, "employeeWorkedTime");
            return (Criteria) this;
        }

        public Criteria andEmployeeWorkedTimeLessThanOrEqualTo(String value) {
            addCriterion("employee_worked_time <=", value, "employeeWorkedTime");
            return (Criteria) this;
        }

        public Criteria andEmployeeWorkedTimeLike(String value) {
            addCriterion("employee_worked_time like", value, "employeeWorkedTime");
            return (Criteria) this;
        }

        public Criteria andEmployeeWorkedTimeNotLike(String value) {
            addCriterion("employee_worked_time not like", value, "employeeWorkedTime");
            return (Criteria) this;
        }

        public Criteria andEmployeeWorkedTimeIn(List<String> values) {
            addCriterion("employee_worked_time in", values, "employeeWorkedTime");
            return (Criteria) this;
        }

        public Criteria andEmployeeWorkedTimeNotIn(List<String> values) {
            addCriterion("employee_worked_time not in", values, "employeeWorkedTime");
            return (Criteria) this;
        }

        public Criteria andEmployeeWorkedTimeBetween(String value1, String value2) {
            addCriterion("employee_worked_time between", value1, value2, "employeeWorkedTime");
            return (Criteria) this;
        }

        public Criteria andEmployeeWorkedTimeNotBetween(String value1, String value2) {
            addCriterion("employee_worked_time not between", value1, value2, "employeeWorkedTime");
            return (Criteria) this;
        }

        public Criteria andIsleavedIsNull() {
            addCriterion("isLeaved is null");
            return (Criteria) this;
        }

        public Criteria andIsleavedIsNotNull() {
            addCriterion("isLeaved is not null");
            return (Criteria) this;
        }

        public Criteria andIsleavedEqualTo(Boolean value) {
            addCriterion("isLeaved =", value, "isleaved");
            return (Criteria) this;
        }

        public Criteria andIsleavedNotEqualTo(Boolean value) {
            addCriterion("isLeaved <>", value, "isleaved");
            return (Criteria) this;
        }

        public Criteria andIsleavedGreaterThan(Boolean value) {
            addCriterion("isLeaved >", value, "isleaved");
            return (Criteria) this;
        }

        public Criteria andIsleavedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isLeaved >=", value, "isleaved");
            return (Criteria) this;
        }

        public Criteria andIsleavedLessThan(Boolean value) {
            addCriterion("isLeaved <", value, "isleaved");
            return (Criteria) this;
        }

        public Criteria andIsleavedLessThanOrEqualTo(Boolean value) {
            addCriterion("isLeaved <=", value, "isleaved");
            return (Criteria) this;
        }

        public Criteria andIsleavedIn(List<Boolean> values) {
            addCriterion("isLeaved in", values, "isleaved");
            return (Criteria) this;
        }

        public Criteria andIsleavedNotIn(List<Boolean> values) {
            addCriterion("isLeaved not in", values, "isleaved");
            return (Criteria) this;
        }

        public Criteria andIsleavedBetween(Boolean value1, Boolean value2) {
            addCriterion("isLeaved between", value1, value2, "isleaved");
            return (Criteria) this;
        }

        public Criteria andIsleavedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isLeaved not between", value1, value2, "isleaved");
            return (Criteria) this;
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

        public Criteria andEmployeeCreatetimeIsNull() {
            addCriterion("employee_createTime is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeCreatetimeIsNotNull() {
            addCriterion("employee_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeCreatetimeEqualTo(String value) {
            addCriterion("employee_createTime =", value, "employeeCreatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeCreatetimeNotEqualTo(String value) {
            addCriterion("employee_createTime <>", value, "employeeCreatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeCreatetimeGreaterThan(String value) {
            addCriterion("employee_createTime >", value, "employeeCreatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("employee_createTime >=", value, "employeeCreatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeCreatetimeLessThan(String value) {
            addCriterion("employee_createTime <", value, "employeeCreatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("employee_createTime <=", value, "employeeCreatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeCreatetimeLike(String value) {
            addCriterion("employee_createTime like", value, "employeeCreatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeCreatetimeNotLike(String value) {
            addCriterion("employee_createTime not like", value, "employeeCreatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeCreatetimeIn(List<String> values) {
            addCriterion("employee_createTime in", values, "employeeCreatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeCreatetimeNotIn(List<String> values) {
            addCriterion("employee_createTime not in", values, "employeeCreatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeCreatetimeBetween(String value1, String value2) {
            addCriterion("employee_createTime between", value1, value2, "employeeCreatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeCreatetimeNotBetween(String value1, String value2) {
            addCriterion("employee_createTime not between", value1, value2, "employeeCreatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeUpdatetimeIsNull() {
            addCriterion("employee_updateTime is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeUpdatetimeIsNotNull() {
            addCriterion("employee_updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeUpdatetimeEqualTo(String value) {
            addCriterion("employee_updateTime =", value, "employeeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeUpdatetimeNotEqualTo(String value) {
            addCriterion("employee_updateTime <>", value, "employeeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeUpdatetimeGreaterThan(String value) {
            addCriterion("employee_updateTime >", value, "employeeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("employee_updateTime >=", value, "employeeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeUpdatetimeLessThan(String value) {
            addCriterion("employee_updateTime <", value, "employeeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("employee_updateTime <=", value, "employeeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeUpdatetimeLike(String value) {
            addCriterion("employee_updateTime like", value, "employeeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeUpdatetimeNotLike(String value) {
            addCriterion("employee_updateTime not like", value, "employeeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeUpdatetimeIn(List<String> values) {
            addCriterion("employee_updateTime in", values, "employeeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeUpdatetimeNotIn(List<String> values) {
            addCriterion("employee_updateTime not in", values, "employeeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeUpdatetimeBetween(String value1, String value2) {
            addCriterion("employee_updateTime between", value1, value2, "employeeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andEmployeeUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("employee_updateTime not between", value1, value2, "employeeUpdatetime");
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