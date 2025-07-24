package pomplatform.workflow.personnelbusiness.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasePersonnelBusinessSalary extends GenericBase implements BaseFactory<BasePersonnelBusinessSalary>, Comparable<BasePersonnelBusinessSalary> 
{


	public static BasePersonnelBusinessSalary newInstance(){
		return new BasePersonnelBusinessSalary();
	}

	@Override
	public BasePersonnelBusinessSalary make(){
		BasePersonnelBusinessSalary b = new BasePersonnelBusinessSalary();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_MONTH_PAY = "month_pay" ;

	public final static java.lang.String ALL_CAPTIONS = "创建人,截止日期,月薪";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.math.BigDecimal getMonthPay() {
		return this.__month_pay;
	}

	public void setMonthPay( java.math.BigDecimal value ) {
		this.__month_pay = value;
	}

	public java.lang.Integer getType() {
		return __type;
	}

	public void setType(java.lang.Integer __type) {
		this.__type = __type;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return __personnel_business_id;
	}

	public void setPersonnelBusinessId(java.lang.Integer value) {
		this.__personnel_business_id = value;
	}

	public void cloneCopy(BasePersonnelBusinessSalary __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEndDate(getEndDate());
		__bean.setMonthPay(getMonthPay());
		__bean.setType(getType());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getMonthPay() == null ? "" : getMonthPay());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePersonnelBusinessSalary o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__month_pay);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePersonnelBusinessSalary o = (BasePersonnelBusinessSalary)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__month_pay, o.getMonthPay())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getMonthPay() != null) sb.append(__wrapDecimal(count++, "monthPay", getMonthPay()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("monthPay")) != null) setMonthPay(__getDecimal(val));  
		if((val = values.get("type")) != null) setType(__getInt(val));  
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val));  
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __type ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.util.Date  __end_date ;
	protected java.math.BigDecimal  __month_pay ;
}
