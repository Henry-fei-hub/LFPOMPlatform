package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseBonusPaymentDetail extends GenericBase implements BaseFactory<BaseBonusPaymentDetail>, Comparable<BaseBonusPaymentDetail> 
{


	public static BaseBonusPaymentDetail newInstance(){
		return new BaseBonusPaymentDetail();
	}

	@Override
	public BaseBonusPaymentDetail make(){
		BaseBonusPaymentDetail b = new BaseBonusPaymentDetail();
		return b;
	}

	public final static java.lang.String CS_BONUS_PAYMENT_DETAIL_ID = "bonus_payment_detail_id" ;
	public final static java.lang.String CS_BONUS_PAYMENT_RECORD_ID = "bonus_payment_record_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_ACHIEVE_INTEGRAL = "achieve_integral" ;
	public final static java.lang.String CS_PAY_PERCENT = "pay_percent" ;
	public final static java.lang.String CS_PAY_INTEGRAL = "pay_integral" ;
	public final static java.lang.String CS_LEFT_INTEGRAL = "left_integral" ;
	public final static java.lang.String CS_PAY_DATE = "pay_date" ;
	public final static java.lang.String CS_STATE = "state" ;
	public final static java.lang.String CS_IS_RETURN = "is_return" ;
	public final static java.lang.String CS_IS_LEVEL_TWO = "is_level_two" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_FIRST_INTEGRAL = "first_integral" ;
	public final static java.lang.String CS_SECOND_INTEGRAL = "second_integral" ;
	public final static java.lang.String CS_THIRD_INTEGRAL = "third_integral" ;
	public final static java.lang.String CS_SEND_NUMBER = "send_number" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,奖金发放记录编码,业务部门,员工编码,工号,姓名,价值积分,发放比率,发放积分,剩余积分,发放年月,审核状态  0未审核   1审核通过    2审核不通过,积分是否回收的标识，true回收； false不回收,是否二级部门提交的,归属部门,第一次发放积分,第二次发放积分,第三次发放积分,发放次数";

	public java.lang.Integer getBonusPaymentDetailId() {
		return this.__bonus_payment_detail_id;
	}

	public void setBonusPaymentDetailId( java.lang.Integer value ) {
		this.__bonus_payment_detail_id = value;
	}

	public java.lang.Integer getBonusPaymentRecordId() {
		return this.__bonus_payment_record_id;
	}

	public void setBonusPaymentRecordId( java.lang.Integer value ) {
		this.__bonus_payment_record_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
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

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.math.BigDecimal getAchieveIntegral() {
		return this.__achieve_integral;
	}

	public void setAchieveIntegral( java.math.BigDecimal value ) {
		this.__achieve_integral = value;
	}

	public java.math.BigDecimal getPayPercent() {
		return this.__pay_percent;
	}

	public void setPayPercent( java.math.BigDecimal value ) {
		this.__pay_percent = value;
	}

	public java.math.BigDecimal getPayIntegral() {
		return this.__pay_integral;
	}

	public void setPayIntegral( java.math.BigDecimal value ) {
		this.__pay_integral = value;
	}

	public java.math.BigDecimal getLeftIntegral() {
		return this.__left_integral;
	}

	public void setLeftIntegral( java.math.BigDecimal value ) {
		this.__left_integral = value;
	}

	public java.util.Date getPayDate() {
		return this.__pay_date;
	}

	public void setPayDate( java.util.Date value ) {
		this.__pay_date = value;
	}

	public java.lang.Integer getState() {
		return this.__state;
	}

	public void setState( java.lang.Integer value ) {
		this.__state = value;
	}

	public java.lang.Boolean getIsReturn() {
		return this.__is_return;
	}

	public void setIsReturn( java.lang.Boolean value ) {
		this.__is_return = value;
	}

	public java.lang.Boolean getIsLevelTwo() {
		return this.__is_level_two;
	}

	public void setIsLevelTwo( java.lang.Boolean value ) {
		this.__is_level_two = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.math.BigDecimal getFirstIntegral() {
		return this.__first_integral;
	}

	public void setFirstIntegral( java.math.BigDecimal value ) {
		this.__first_integral = value;
	}

	public java.math.BigDecimal getSecondIntegral() {
		return this.__second_integral;
	}

	public void setSecondIntegral( java.math.BigDecimal value ) {
		this.__second_integral = value;
	}

	public java.math.BigDecimal getThirdIntegral() {
		return this.__third_integral;
	}

	public void setThirdIntegral( java.math.BigDecimal value ) {
		this.__third_integral = value;
	}

	public java.lang.Integer getSendNumber() {
		return this.__send_number;
	}

	public void setSendNumber( java.lang.Integer value ) {
		this.__send_number = value;
	}

	public void cloneCopy(BaseBonusPaymentDetail __bean){
		__bean.setBonusPaymentDetailId(getBonusPaymentDetailId());
		__bean.setBonusPaymentRecordId(getBonusPaymentRecordId());
		__bean.setPlateId(getPlateId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setAchieveIntegral(getAchieveIntegral());
		__bean.setPayPercent(getPayPercent());
		__bean.setPayIntegral(getPayIntegral());
		__bean.setLeftIntegral(getLeftIntegral());
		__bean.setPayDate(getPayDate());
		__bean.setState(getState());
		__bean.setIsReturn(getIsReturn());
		__bean.setIsLevelTwo(getIsLevelTwo());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setFirstIntegral(getFirstIntegral());
		__bean.setSecondIntegral(getSecondIntegral());
		__bean.setThirdIntegral(getThirdIntegral());
		__bean.setSendNumber(getSendNumber());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBonusPaymentDetailId() == null ? "" : getBonusPaymentDetailId());
		sb.append(",");
		sb.append(getBonusPaymentRecordId() == null ? "" : getBonusPaymentRecordId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getAchieveIntegral() == null ? "" : getAchieveIntegral());
		sb.append(",");
		sb.append(getPayPercent() == null ? "" : getPayPercent());
		sb.append(",");
		sb.append(getPayIntegral() == null ? "" : getPayIntegral());
		sb.append(",");
		sb.append(getLeftIntegral() == null ? "" : getLeftIntegral());
		sb.append(",");
		sb.append(getPayDate() == null ? "" : sdf.format(getPayDate()));
		sb.append(",");
		sb.append(getState() == null ? "" : getState());
		sb.append(",");
		sb.append(getIsReturn() == null ? "" : getIsReturn());
		sb.append(",");
		sb.append(getIsLevelTwo() == null ? "" : getIsLevelTwo());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getFirstIntegral() == null ? "" : getFirstIntegral());
		sb.append(",");
		sb.append(getSecondIntegral() == null ? "" : getSecondIntegral());
		sb.append(",");
		sb.append(getThirdIntegral() == null ? "" : getThirdIntegral());
		sb.append(",");
		sb.append(getSendNumber() == null ? "" : getSendNumber());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseBonusPaymentDetail o) {
		return __bonus_payment_detail_id == null ? -1 : __bonus_payment_detail_id.compareTo(o.getBonusPaymentDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__bonus_payment_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__bonus_payment_record_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__achieve_integral);
		hash = 97 * hash + Objects.hashCode(this.__pay_percent);
		hash = 97 * hash + Objects.hashCode(this.__pay_integral);
		hash = 97 * hash + Objects.hashCode(this.__left_integral);
		hash = 97 * hash + Objects.hashCode(this.__pay_date);
		hash = 97 * hash + Objects.hashCode(this.__state);
		hash = 97 * hash + Objects.hashCode(this.__is_return);
		hash = 97 * hash + Objects.hashCode(this.__is_level_two);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__first_integral);
		hash = 97 * hash + Objects.hashCode(this.__second_integral);
		hash = 97 * hash + Objects.hashCode(this.__third_integral);
		hash = 97 * hash + Objects.hashCode(this.__send_number);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseBonusPaymentDetail o = (BaseBonusPaymentDetail)obj;
		if(!Objects.equals(this.__bonus_payment_detail_id, o.getBonusPaymentDetailId())) return false;
		if(!Objects.equals(this.__bonus_payment_record_id, o.getBonusPaymentRecordId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__achieve_integral, o.getAchieveIntegral())) return false;
		if(!Objects.equals(this.__pay_percent, o.getPayPercent())) return false;
		if(!Objects.equals(this.__pay_integral, o.getPayIntegral())) return false;
		if(!Objects.equals(this.__left_integral, o.getLeftIntegral())) return false;
		if(!Objects.equals(this.__pay_date, o.getPayDate())) return false;
		if(!Objects.equals(this.__state, o.getState())) return false;
		if(!Objects.equals(this.__is_return, o.getIsReturn())) return false;
		if(!Objects.equals(this.__is_level_two, o.getIsLevelTwo())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__first_integral, o.getFirstIntegral())) return false;
		if(!Objects.equals(this.__second_integral, o.getSecondIntegral())) return false;
		if(!Objects.equals(this.__third_integral, o.getThirdIntegral())) return false;
		if(!Objects.equals(this.__send_number, o.getSendNumber())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBonusPaymentDetailId() != null) sb.append(__wrapNumber(count++, "bonusPaymentDetailId", getBonusPaymentDetailId()));
		if(getBonusPaymentRecordId() != null) sb.append(__wrapNumber(count++, "bonusPaymentRecordId", getBonusPaymentRecordId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getAchieveIntegral() != null) sb.append(__wrapDecimal(count++, "achieveIntegral", getAchieveIntegral()));
		if(getPayPercent() != null) sb.append(__wrapDecimal(count++, "payPercent", getPayPercent()));
		if(getPayIntegral() != null) sb.append(__wrapDecimal(count++, "payIntegral", getPayIntegral()));
		if(getLeftIntegral() != null) sb.append(__wrapDecimal(count++, "leftIntegral", getLeftIntegral()));
		if(getPayDate() != null) sb.append(__wrapDate(count++, "payDate", getPayDate()));
		if(getState() != null) sb.append(__wrapNumber(count++, "state", getState()));
		if(getIsReturn() != null) sb.append(__wrapBoolean(count++, "isReturn", getIsReturn()));
		if(getIsLevelTwo() != null) sb.append(__wrapBoolean(count++, "isLevelTwo", getIsLevelTwo()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getFirstIntegral() != null) sb.append(__wrapDecimal(count++, "firstIntegral", getFirstIntegral()));
		if(getSecondIntegral() != null) sb.append(__wrapDecimal(count++, "secondIntegral", getSecondIntegral()));
		if(getThirdIntegral() != null) sb.append(__wrapDecimal(count++, "thirdIntegral", getThirdIntegral()));
		if(getSendNumber() != null) sb.append(__wrapNumber(count++, "sendNumber", getSendNumber()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getBonusPaymentDetailId() != null) res.put("bonusPaymentDetailId", getBonusPaymentDetailId());
		if(getBonusPaymentRecordId() != null) res.put("bonusPaymentRecordId", getBonusPaymentRecordId());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getAchieveIntegral() != null) res.put("achieveIntegral", getAchieveIntegral());
		if(getPayPercent() != null) res.put("payPercent", getPayPercent());
		if(getPayIntegral() != null) res.put("payIntegral", getPayIntegral());
		if(getLeftIntegral() != null) res.put("leftIntegral", getLeftIntegral());
		if(getPayDate() != null) res.put("payDate", getPayDate());
		if(getState() != null) res.put("state", getState());
		if(getIsReturn() != null) res.put("isReturn", getIsReturn());
		if(getIsLevelTwo() != null) res.put("isLevelTwo", getIsLevelTwo());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getFirstIntegral() != null) res.put("firstIntegral", getFirstIntegral());
		if(getSecondIntegral() != null) res.put("secondIntegral", getSecondIntegral());
		if(getThirdIntegral() != null) res.put("thirdIntegral", getThirdIntegral());
		if(getSendNumber() != null) res.put("sendNumber", getSendNumber());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("bonusPaymentDetailId")) != null) setBonusPaymentDetailId(__getInt(val)); 
		if((val = values.get("bonusPaymentRecordId")) != null) setBonusPaymentRecordId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("achieveIntegral")) != null) setAchieveIntegral(__getDecimal(val));  
		if((val = values.get("payPercent")) != null) setPayPercent(__getDecimal(val));  
		if((val = values.get("payIntegral")) != null) setPayIntegral(__getDecimal(val));  
		if((val = values.get("leftIntegral")) != null) setLeftIntegral(__getDecimal(val));  
		if((val = values.get("payDate")) != null) setPayDate(__getDate(val)); 
		if((val = values.get("state")) != null) setState(__getInt(val)); 
		if((val = values.get("isReturn")) != null) setIsReturn(__getBoolean(val));
		if((val = values.get("isLevelTwo")) != null) setIsLevelTwo(__getBoolean(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("firstIntegral")) != null) setFirstIntegral(__getDecimal(val));  
		if((val = values.get("secondIntegral")) != null) setSecondIntegral(__getDecimal(val));  
		if((val = values.get("thirdIntegral")) != null) setThirdIntegral(__getDecimal(val));  
		if((val = values.get("sendNumber")) != null) setSendNumber(__getInt(val)); 
	}

	protected java.lang.Integer  __bonus_payment_detail_id ;
	protected java.lang.Integer  __bonus_payment_record_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.math.BigDecimal  __achieve_integral ;
	protected java.math.BigDecimal  __pay_percent ;
	protected java.math.BigDecimal  __pay_integral ;
	protected java.math.BigDecimal  __left_integral ;
	protected java.util.Date  __pay_date ;
	protected java.lang.Integer  __state ;
	protected java.lang.Boolean  __is_return ;
	protected java.lang.Boolean  __is_level_two ;
	protected java.lang.Integer  __department_id ;
	protected java.math.BigDecimal  __first_integral ;
	protected java.math.BigDecimal  __second_integral ;
	protected java.math.BigDecimal  __third_integral ;
	protected java.lang.Integer  __send_number ;
}
