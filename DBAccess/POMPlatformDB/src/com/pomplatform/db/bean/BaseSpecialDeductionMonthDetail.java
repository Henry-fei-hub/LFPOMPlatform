package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSpecialDeductionMonthDetail extends GenericBase implements BaseFactory<BaseSpecialDeductionMonthDetail>, Comparable<BaseSpecialDeductionMonthDetail> 
{


	public static BaseSpecialDeductionMonthDetail newInstance(){
		return new BaseSpecialDeductionMonthDetail();
	}

	@Override
	public BaseSpecialDeductionMonthDetail make(){
		BaseSpecialDeductionMonthDetail b = new BaseSpecialDeductionMonthDetail();
		return b;
	}

	public final static java.lang.String CS_SPECIAL_DEDUCTION_MONTH_DETAIL_ID = "special_deduction_month_detail_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_SPECIAL_DEDUCTION_TYPE_IDS = "special_deduction_type_ids" ;
	public final static java.lang.String CS_SPECIAL_DEDUCTION_DETAIL_IDS = "special_deduction_detail_ids" ;
	public final static java.lang.String CS_SPECIAL_DUDUCT_1 = "special_duduct_1" ;
	public final static java.lang.String CS_SPECIAL_DUDUCT_2 = "special_duduct_2" ;
	public final static java.lang.String CS_SPECIAL_DUDUCT_3 = "special_duduct_3" ;
	public final static java.lang.String CS_SPECIAL_DUDUCT_4 = "special_duduct_4" ;
	public final static java.lang.String CS_SPECIAL_DUDUCT_5 = "special_duduct_5" ;
	public final static java.lang.String CS_SPECIAL_DUDUCT_6 = "special_duduct_6" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,职员id,职员编号,归属部门,业务部门,年度,月份,专项扣除总金额,创建时间,专项扣除类型ids,专项扣除详情ids,子女教育,继续教育,住房贷款利息,住房租金,赡养老人,大病医疗";

	public java.lang.Integer getSpecialDeductionMonthDetailId() {
		return this.__special_deduction_month_detail_id;
	}

	public void setSpecialDeductionMonthDetailId( java.lang.Integer value ) {
		this.__special_deduction_month_detail_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.String getYear() {
		return this.__year;
	}

	public void setYear( java.lang.String value ) {
		this.__year = value;
	}

	public java.lang.String getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.String value ) {
		this.__month = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getSpecialDeductionTypeIds() {
		return this.__special_deduction_type_ids;
	}

	public void setSpecialDeductionTypeIds( java.lang.String value ) {
		this.__special_deduction_type_ids = value;
	}

	public java.lang.String getSpecialDeductionDetailIds() {
		return this.__special_deduction_detail_ids;
	}

	public void setSpecialDeductionDetailIds( java.lang.String value ) {
		this.__special_deduction_detail_ids = value;
	}

	public java.math.BigDecimal getSpecialDuduct1() {
		return this.__special_duduct_1;
	}

	public void setSpecialDuduct1( java.math.BigDecimal value ) {
		this.__special_duduct_1 = value;
	}

	public java.math.BigDecimal getSpecialDuduct2() {
		return this.__special_duduct_2;
	}

	public void setSpecialDuduct2( java.math.BigDecimal value ) {
		this.__special_duduct_2 = value;
	}

	public java.math.BigDecimal getSpecialDuduct3() {
		return this.__special_duduct_3;
	}

	public void setSpecialDuduct3( java.math.BigDecimal value ) {
		this.__special_duduct_3 = value;
	}

	public java.math.BigDecimal getSpecialDuduct4() {
		return this.__special_duduct_4;
	}

	public void setSpecialDuduct4( java.math.BigDecimal value ) {
		this.__special_duduct_4 = value;
	}

	public java.math.BigDecimal getSpecialDuduct5() {
		return this.__special_duduct_5;
	}

	public void setSpecialDuduct5( java.math.BigDecimal value ) {
		this.__special_duduct_5 = value;
	}

	public java.math.BigDecimal getSpecialDuduct6() {
		return this.__special_duduct_6;
	}

	public void setSpecialDuduct6( java.math.BigDecimal value ) {
		this.__special_duduct_6 = value;
	}

	public void cloneCopy(BaseSpecialDeductionMonthDetail __bean){
		__bean.setSpecialDeductionMonthDetailId(getSpecialDeductionMonthDetailId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setAmount(getAmount());
		__bean.setCreateTime(getCreateTime());
		__bean.setSpecialDeductionTypeIds(getSpecialDeductionTypeIds());
		__bean.setSpecialDeductionDetailIds(getSpecialDeductionDetailIds());
		__bean.setSpecialDuduct1(getSpecialDuduct1());
		__bean.setSpecialDuduct2(getSpecialDuduct2());
		__bean.setSpecialDuduct3(getSpecialDuduct3());
		__bean.setSpecialDuduct4(getSpecialDuduct4());
		__bean.setSpecialDuduct5(getSpecialDuduct5());
		__bean.setSpecialDuduct6(getSpecialDuduct6());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSpecialDeductionMonthDetailId() == null ? "" : getSpecialDeductionMonthDetailId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getSpecialDeductionTypeIds() == null ? "" : getSpecialDeductionTypeIds());
		sb.append(",");
		sb.append(getSpecialDeductionDetailIds() == null ? "" : getSpecialDeductionDetailIds());
		sb.append(",");
		sb.append(getSpecialDuduct1() == null ? "" : getSpecialDuduct1());
		sb.append(",");
		sb.append(getSpecialDuduct2() == null ? "" : getSpecialDuduct2());
		sb.append(",");
		sb.append(getSpecialDuduct3() == null ? "" : getSpecialDuduct3());
		sb.append(",");
		sb.append(getSpecialDuduct4() == null ? "" : getSpecialDuduct4());
		sb.append(",");
		sb.append(getSpecialDuduct5() == null ? "" : getSpecialDuduct5());
		sb.append(",");
		sb.append(getSpecialDuduct6() == null ? "" : getSpecialDuduct6());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSpecialDeductionMonthDetail o) {
		return __special_deduction_month_detail_id == null ? -1 : __special_deduction_month_detail_id.compareTo(o.getSpecialDeductionMonthDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_month_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_type_ids);
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_detail_ids);
		hash = 97 * hash + Objects.hashCode(this.__special_duduct_1);
		hash = 97 * hash + Objects.hashCode(this.__special_duduct_2);
		hash = 97 * hash + Objects.hashCode(this.__special_duduct_3);
		hash = 97 * hash + Objects.hashCode(this.__special_duduct_4);
		hash = 97 * hash + Objects.hashCode(this.__special_duduct_5);
		hash = 97 * hash + Objects.hashCode(this.__special_duduct_6);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSpecialDeductionMonthDetail o = (BaseSpecialDeductionMonthDetail)obj;
		if(!Objects.equals(this.__special_deduction_month_detail_id, o.getSpecialDeductionMonthDetailId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__special_deduction_type_ids, o.getSpecialDeductionTypeIds())) return false;
		if(!Objects.equals(this.__special_deduction_detail_ids, o.getSpecialDeductionDetailIds())) return false;
		if(!Objects.equals(this.__special_duduct_1, o.getSpecialDuduct1())) return false;
		if(!Objects.equals(this.__special_duduct_2, o.getSpecialDuduct2())) return false;
		if(!Objects.equals(this.__special_duduct_3, o.getSpecialDuduct3())) return false;
		if(!Objects.equals(this.__special_duduct_4, o.getSpecialDuduct4())) return false;
		if(!Objects.equals(this.__special_duduct_5, o.getSpecialDuduct5())) return false;
		if(!Objects.equals(this.__special_duduct_6, o.getSpecialDuduct6())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSpecialDeductionMonthDetailId() != null) sb.append(__wrapNumber(count++, "specialDeductionMonthDetailId", getSpecialDeductionMonthDetailId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapString(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapString(count++, "month", getMonth()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getSpecialDeductionTypeIds() != null) sb.append(__wrapString(count++, "specialDeductionTypeIds", getSpecialDeductionTypeIds()));
		if(getSpecialDeductionDetailIds() != null) sb.append(__wrapString(count++, "specialDeductionDetailIds", getSpecialDeductionDetailIds()));
		if(getSpecialDuduct1() != null) sb.append(__wrapDecimal(count++, "specialDuduct1", getSpecialDuduct1()));
		if(getSpecialDuduct2() != null) sb.append(__wrapDecimal(count++, "specialDuduct2", getSpecialDuduct2()));
		if(getSpecialDuduct3() != null) sb.append(__wrapDecimal(count++, "specialDuduct3", getSpecialDuduct3()));
		if(getSpecialDuduct4() != null) sb.append(__wrapDecimal(count++, "specialDuduct4", getSpecialDuduct4()));
		if(getSpecialDuduct5() != null) sb.append(__wrapDecimal(count++, "specialDuduct5", getSpecialDuduct5()));
		if(getSpecialDuduct6() != null) sb.append(__wrapDecimal(count++, "specialDuduct6", getSpecialDuduct6()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSpecialDeductionMonthDetailId() != null) res.put("specialDeductionMonthDetailId", getSpecialDeductionMonthDetailId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getAmount() != null) res.put("amount", getAmount());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getSpecialDeductionTypeIds() != null) res.put("specialDeductionTypeIds", getSpecialDeductionTypeIds());
		if(getSpecialDeductionDetailIds() != null) res.put("specialDeductionDetailIds", getSpecialDeductionDetailIds());
		if(getSpecialDuduct1() != null) res.put("specialDuduct1", getSpecialDuduct1());
		if(getSpecialDuduct2() != null) res.put("specialDuduct2", getSpecialDuduct2());
		if(getSpecialDuduct3() != null) res.put("specialDuduct3", getSpecialDuduct3());
		if(getSpecialDuduct4() != null) res.put("specialDuduct4", getSpecialDuduct4());
		if(getSpecialDuduct5() != null) res.put("specialDuduct5", getSpecialDuduct5());
		if(getSpecialDuduct6() != null) res.put("specialDuduct6", getSpecialDuduct6());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("specialDeductionMonthDetailId")) != null) setSpecialDeductionMonthDetailId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getString(val));
		if((val = values.get("month")) != null) setMonth(__getString(val));
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("specialDeductionTypeIds")) != null) setSpecialDeductionTypeIds(__getString(val));
		if((val = values.get("specialDeductionDetailIds")) != null) setSpecialDeductionDetailIds(__getString(val));
		if((val = values.get("specialDuduct1")) != null) setSpecialDuduct1(__getDecimal(val));  
		if((val = values.get("specialDuduct2")) != null) setSpecialDuduct2(__getDecimal(val));  
		if((val = values.get("specialDuduct3")) != null) setSpecialDuduct3(__getDecimal(val));  
		if((val = values.get("specialDuduct4")) != null) setSpecialDuduct4(__getDecimal(val));  
		if((val = values.get("specialDuduct5")) != null) setSpecialDuduct5(__getDecimal(val));  
		if((val = values.get("specialDuduct6")) != null) setSpecialDuduct6(__getDecimal(val));  
	}

	protected java.lang.Integer  __special_deduction_month_detail_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.String  __year ;
	protected java.lang.String  __month ;
	protected java.math.BigDecimal  __amount ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __special_deduction_type_ids ;
	protected java.lang.String  __special_deduction_detail_ids ;
	protected java.math.BigDecimal  __special_duduct_1 ;
	protected java.math.BigDecimal  __special_duduct_2 ;
	protected java.math.BigDecimal  __special_duduct_3 ;
	protected java.math.BigDecimal  __special_duduct_4 ;
	protected java.math.BigDecimal  __special_duduct_5 ;
	protected java.math.BigDecimal  __special_duduct_6 ;
}
