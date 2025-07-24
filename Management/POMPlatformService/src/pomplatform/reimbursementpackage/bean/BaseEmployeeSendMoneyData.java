package pomplatform.reimbursementpackage.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeSendMoneyData extends GenericBase implements BaseFactory<BaseEmployeeSendMoneyData>, Comparable<BaseEmployeeSendMoneyData> 
{


	public static BaseEmployeeSendMoneyData newInstance(){
		return new BaseEmployeeSendMoneyData();
	}

	@Override
	public BaseEmployeeSendMoneyData make(){
		BaseEmployeeSendMoneyData b = new BaseEmployeeSendMoneyData();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_FACT_SALARY = "fact_salary" ;
	public final static java.lang.String CS_BANK_ACCOUNT = "bank_account" ;
	public final static java.lang.String CS_BANK_ID = "bank_id" ;
	public final static java.lang.String CS_BANK_ADDRESS = "bank_address" ;
	public final static java.lang.String CS_BANK_NAME = "bank_name" ;

	public final static java.lang.String ALL_CAPTIONS = "员工编码,员工工号,员工姓名,年份,月份,,银行账号,开户行,开户行所在地,开户行(支行)";

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

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.math.BigDecimal getFactSalary() {
		return this.__fact_salary;
	}

	public void setFactSalary( java.math.BigDecimal value ) {
		this.__fact_salary = value;
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.Integer getBankId() {
		return this.__bank_id;
	}

	public void setBankId( java.lang.Integer value ) {
		this.__bank_id = value;
	}

	public java.lang.String getBankAddress() {
		return this.__bank_address;
	}

	public void setBankAddress( java.lang.String value ) {
		this.__bank_address = value;
	}

	public java.lang.String getBankName() {
		return this.__bank_name;
	}

	public void setBankName( java.lang.String value ) {
		this.__bank_name = value;
	}

	public void cloneCopy(BaseEmployeeSendMoneyData __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setFactSalary(getFactSalary());
		__bean.setBankAccount(getBankAccount());
		__bean.setBankId(getBankId());
		__bean.setBankAddress(getBankAddress());
		__bean.setBankName(getBankName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getFactSalary() == null ? "" : getFactSalary());
		sb.append(",");
		sb.append(getBankAccount() == null ? "" : getBankAccount());
		sb.append(",");
		sb.append(getBankId() == null ? "" : getBankId());
		sb.append(",");
		sb.append(getBankAddress() == null ? "" : getBankAddress());
		sb.append(",");
		sb.append(getBankName() == null ? "" : getBankName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeSendMoneyData o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__fact_salary);
		hash = 97 * hash + Objects.hashCode(this.__bank_account);
		hash = 97 * hash + Objects.hashCode(this.__bank_id);
		hash = 97 * hash + Objects.hashCode(this.__bank_address);
		hash = 97 * hash + Objects.hashCode(this.__bank_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeSendMoneyData o = (BaseEmployeeSendMoneyData)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__fact_salary, o.getFactSalary())) return false;
		if(!Objects.equals(this.__bank_account, o.getBankAccount())) return false;
		if(!Objects.equals(this.__bank_id, o.getBankId())) return false;
		if(!Objects.equals(this.__bank_address, o.getBankAddress())) return false;
		if(!Objects.equals(this.__bank_name, o.getBankName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getFactSalary() != null) sb.append(__wrapDecimal(count++, "factSalary", getFactSalary()));
		if(getBankAccount() != null) sb.append(__wrapString(count++, "bankAccount", getBankAccount()));
		if(getBankId() != null) sb.append(__wrapNumber(count++, "bankId", getBankId()));
		if(getBankAddress() != null) sb.append(__wrapString(count++, "bankAddress", getBankAddress()));
		if(getBankName() != null) sb.append(__wrapString(count++, "bankName", getBankName()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getFactSalary() != null) res.put("factSalary", getFactSalary());
		if(getBankAccount() != null) res.put("bankAccount", getBankAccount());
		if(getBankId() != null) res.put("bankId", getBankId());
		if(getBankAddress() != null) res.put("bankAddress", getBankAddress());
		if(getBankName() != null) res.put("bankName", getBankName());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("factSalary")) != null) setFactSalary(__getDecimal(val));  
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("bankId")) != null) setBankId(__getInt(val)); 
		if((val = values.get("bankAddress")) != null) setBankAddress(__getString(val));
		if((val = values.get("bankName")) != null) setBankName(__getString(val));
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.math.BigDecimal  __fact_salary ;
	protected java.lang.String  __bank_account ;
	protected java.lang.Integer  __bank_id ;
	protected java.lang.String  __bank_address ;
	protected java.lang.String  __bank_name ;
}
