package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSpecialDeductionDetail extends GenericBase implements BaseFactory<BaseSpecialDeductionDetail>, Comparable<BaseSpecialDeductionDetail> 
{


	public static BaseSpecialDeductionDetail newInstance(){
		return new BaseSpecialDeductionDetail();
	}

	@Override
	public BaseSpecialDeductionDetail make(){
		BaseSpecialDeductionDetail b = new BaseSpecialDeductionDetail();
		return b;
	}

	public final static java.lang.String CS_SPECIAL_DEDUCTION_DETAIL_ID = "special_deduction_detail_id" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_SCHOOLING = "schooling" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_DEDUCTION_PERCENTAGE = "deduction_percentage" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_NUM = "num" ;
	public final static java.lang.String CS_EDUCATION_TYPE = "education_type" ;
	public final static java.lang.String CS_EDUCATION_STAGE = "education_stage" ;
	public final static java.lang.String CS_HOUSE_FIRST = "house_first" ;
	public final static java.lang.String CS_SINGLE_CHILD = "single_child" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_SPECIAL_DEDUCTION_TYPE_ID = "special_deduction_type_id" ;
	public final static java.lang.String CS_CREATE_DATE = "create_date" ;
	public final static java.lang.String CS_CITY = "city" ;

	public final static java.lang.String ALL_CAPTIONS = "id,父id,当前受教育阶段,起始时间,结束时间,本人扣除比例,金额(基数),个数,继续教育类型,教育阶段,是否婚前各自首套贷款且婚后分别扣除50%,是否独生,扣除年度,专项类型,创建时间,租房城市";

	public java.lang.Integer getSpecialDeductionDetailId() {
		return this.__special_deduction_detail_id;
	}

	public void setSpecialDeductionDetailId( java.lang.Integer value ) {
		this.__special_deduction_detail_id = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Integer getSchooling() {
		return this.__schooling;
	}

	public void setSchooling( java.lang.Integer value ) {
		this.__schooling = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.math.BigDecimal getDeductionPercentage() {
		return this.__deduction_percentage;
	}

	public void setDeductionPercentage( java.math.BigDecimal value ) {
		this.__deduction_percentage = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.lang.Integer getNum() {
		return this.__num;
	}

	public void setNum( java.lang.Integer value ) {
		this.__num = value;
	}

	public java.lang.Integer getEducationType() {
		return this.__education_type;
	}

	public void setEducationType( java.lang.Integer value ) {
		this.__education_type = value;
	}

	public java.lang.Integer getEducationStage() {
		return this.__education_stage;
	}

	public void setEducationStage( java.lang.Integer value ) {
		this.__education_stage = value;
	}

	public java.lang.Integer getHouseFirst() {
		return this.__house_first;
	}

	public void setHouseFirst( java.lang.Integer value ) {
		this.__house_first = value;
	}

	public java.lang.Integer getSingleChild() {
		return this.__single_child;
	}

	public void setSingleChild( java.lang.Integer value ) {
		this.__single_child = value;
	}

	public java.lang.String getYear() {
		return this.__year;
	}

	public void setYear( java.lang.String value ) {
		this.__year = value;
	}

	public java.lang.Integer getSpecialDeductionTypeId() {
		return this.__special_deduction_type_id;
	}

	public void setSpecialDeductionTypeId( java.lang.Integer value ) {
		this.__special_deduction_type_id = value;
	}

	public java.util.Date getCreateDate() {
		return this.__create_date;
	}

	public void setCreateDate( java.util.Date value ) {
		this.__create_date = value;
	}

	public java.lang.String getCity() {
		return this.__city;
	}

	public void setCity( java.lang.String value ) {
		this.__city = value;
	}

	public void cloneCopy(BaseSpecialDeductionDetail __bean){
		__bean.setSpecialDeductionDetailId(getSpecialDeductionDetailId());
		__bean.setParentId(getParentId());
		__bean.setSchooling(getSchooling());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setDeductionPercentage(getDeductionPercentage());
		__bean.setAmount(getAmount());
		__bean.setNum(getNum());
		__bean.setEducationType(getEducationType());
		__bean.setEducationStage(getEducationStage());
		__bean.setHouseFirst(getHouseFirst());
		__bean.setSingleChild(getSingleChild());
		__bean.setYear(getYear());
		__bean.setSpecialDeductionTypeId(getSpecialDeductionTypeId());
		__bean.setCreateDate(getCreateDate());
		__bean.setCity(getCity());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSpecialDeductionDetailId() == null ? "" : getSpecialDeductionDetailId());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getSchooling() == null ? "" : getSchooling());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getDeductionPercentage() == null ? "" : getDeductionPercentage());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getNum() == null ? "" : getNum());
		sb.append(",");
		sb.append(getEducationType() == null ? "" : getEducationType());
		sb.append(",");
		sb.append(getEducationStage() == null ? "" : getEducationStage());
		sb.append(",");
		sb.append(getHouseFirst() == null ? "" : getHouseFirst());
		sb.append(",");
		sb.append(getSingleChild() == null ? "" : getSingleChild());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getSpecialDeductionTypeId() == null ? "" : getSpecialDeductionTypeId());
		sb.append(",");
		sb.append(getCreateDate() == null ? "" : sdf.format(getCreateDate()));
		sb.append(",");
		sb.append(getCity() == null ? "" : getCity());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSpecialDeductionDetail o) {
		return __special_deduction_detail_id == null ? -1 : __special_deduction_detail_id.compareTo(o.getSpecialDeductionDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__schooling);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__deduction_percentage);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__num);
		hash = 97 * hash + Objects.hashCode(this.__education_type);
		hash = 97 * hash + Objects.hashCode(this.__education_stage);
		hash = 97 * hash + Objects.hashCode(this.__house_first);
		hash = 97 * hash + Objects.hashCode(this.__single_child);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_type_id);
		hash = 97 * hash + Objects.hashCode(this.__create_date);
		hash = 97 * hash + Objects.hashCode(this.__city);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSpecialDeductionDetail o = (BaseSpecialDeductionDetail)obj;
		if(!Objects.equals(this.__special_deduction_detail_id, o.getSpecialDeductionDetailId())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__schooling, o.getSchooling())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__deduction_percentage, o.getDeductionPercentage())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__num, o.getNum())) return false;
		if(!Objects.equals(this.__education_type, o.getEducationType())) return false;
		if(!Objects.equals(this.__education_stage, o.getEducationStage())) return false;
		if(!Objects.equals(this.__house_first, o.getHouseFirst())) return false;
		if(!Objects.equals(this.__single_child, o.getSingleChild())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__special_deduction_type_id, o.getSpecialDeductionTypeId())) return false;
		if(!Objects.equals(this.__create_date, o.getCreateDate())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSpecialDeductionDetailId() != null) sb.append(__wrapNumber(count++, "specialDeductionDetailId", getSpecialDeductionDetailId()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getSchooling() != null) sb.append(__wrapNumber(count++, "schooling", getSchooling()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getDeductionPercentage() != null) sb.append(__wrapDecimal(count++, "deductionPercentage", getDeductionPercentage()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getNum() != null) sb.append(__wrapNumber(count++, "num", getNum()));
		if(getEducationType() != null) sb.append(__wrapNumber(count++, "educationType", getEducationType()));
		if(getEducationStage() != null) sb.append(__wrapNumber(count++, "educationStage", getEducationStage()));
		if(getHouseFirst() != null) sb.append(__wrapNumber(count++, "houseFirst", getHouseFirst()));
		if(getSingleChild() != null) sb.append(__wrapNumber(count++, "singleChild", getSingleChild()));
		if(getYear() != null) sb.append(__wrapString(count++, "year", getYear()));
		if(getSpecialDeductionTypeId() != null) sb.append(__wrapNumber(count++, "specialDeductionTypeId", getSpecialDeductionTypeId()));
		if(getCreateDate() != null) sb.append(__wrapDate(count++, "createDate", getCreateDate()));
		if(getCity() != null) sb.append(__wrapString(count++, "city", getCity()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSpecialDeductionDetailId() != null) res.put("specialDeductionDetailId", getSpecialDeductionDetailId());
		if(getParentId() != null) res.put("parentId", getParentId());
		if(getSchooling() != null) res.put("schooling", getSchooling());
		if(getStartDate() != null) res.put("startDate", getStartDate());
		if(getEndDate() != null) res.put("endDate", getEndDate());
		if(getDeductionPercentage() != null) res.put("deductionPercentage", getDeductionPercentage());
		if(getAmount() != null) res.put("amount", getAmount());
		if(getNum() != null) res.put("num", getNum());
		if(getEducationType() != null) res.put("educationType", getEducationType());
		if(getEducationStage() != null) res.put("educationStage", getEducationStage());
		if(getHouseFirst() != null) res.put("houseFirst", getHouseFirst());
		if(getSingleChild() != null) res.put("singleChild", getSingleChild());
		if(getYear() != null) res.put("year", getYear());
		if(getSpecialDeductionTypeId() != null) res.put("specialDeductionTypeId", getSpecialDeductionTypeId());
		if(getCreateDate() != null) res.put("createDate", getCreateDate());
		if(getCity() != null) res.put("city", getCity());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("specialDeductionDetailId")) != null) setSpecialDeductionDetailId(__getInt(val)); 
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("schooling")) != null) setSchooling(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("deductionPercentage")) != null) setDeductionPercentage(__getDecimal(val));  
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("num")) != null) setNum(__getInt(val)); 
		if((val = values.get("educationType")) != null) setEducationType(__getInt(val)); 
		if((val = values.get("educationStage")) != null) setEducationStage(__getInt(val)); 
		if((val = values.get("houseFirst")) != null) setHouseFirst(__getInt(val)); 
		if((val = values.get("singleChild")) != null) setSingleChild(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getString(val));
		if((val = values.get("specialDeductionTypeId")) != null) setSpecialDeductionTypeId(__getInt(val)); 
		if((val = values.get("createDate")) != null) setCreateDate(__getDate(val)); 
		if((val = values.get("city")) != null) setCity(__getString(val));
	}

	protected java.lang.Integer  __special_deduction_detail_id ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Integer  __schooling ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.math.BigDecimal  __deduction_percentage ;
	protected java.math.BigDecimal  __amount ;
	protected java.lang.Integer  __num ;
	protected java.lang.Integer  __education_type ;
	protected java.lang.Integer  __education_stage ;
	protected java.lang.Integer  __house_first ;
	protected java.lang.Integer  __single_child ;
	protected java.lang.String  __year ;
	protected java.lang.Integer  __special_deduction_type_id ;
	protected java.util.Date  __create_date ;
	protected java.lang.String  __city ;
}
