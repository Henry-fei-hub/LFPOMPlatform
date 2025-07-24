package pomplatform.payment.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnSalarySendData extends GenericBase implements BaseFactory<BaseOnSalarySendData>, Comparable<BaseOnSalarySendData> 
{


	public static BaseOnSalarySendData newInstance(){
		return new BaseOnSalarySendData();
	}

	@Override
	public BaseOnSalarySendData make(){
		BaseOnSalarySendData b = new BaseOnSalarySendData();
		return b;
	}

	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_BANK_ACCOUNT = "bank_account" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_FACT_SALARY = "fact_salary" ;
	public final static java.lang.String CS_SALARYISSUE = "salaryissue" ;
	public final static java.lang.String CS_LOANISSUE = "loanissue" ;
	public final static java.lang.String CS_BALANCE = "balance" ;

	public final static java.lang.String ALL_CAPTIONS = "归属公司,员工id,员工编号,员工姓名,银行账号,年份,月份,,,,";

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
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

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
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

	public java.math.BigDecimal getSalaryissue() {
		return this.__salaryissue;
	}

	public void setSalaryissue( java.math.BigDecimal value ) {
		this.__salaryissue = value;
	}

	public java.math.BigDecimal getLoanissue() {
		return this.__loanissue;
	}

	public void setLoanissue( java.math.BigDecimal value ) {
		this.__loanissue = value;
	}

	public java.math.BigDecimal getBalance() {
		return this.__balance;
	}

	public void setBalance( java.math.BigDecimal value ) {
		this.__balance = value;
	}

	public void cloneCopy(BaseOnSalarySendData __bean){
		__bean.setCompanyId(getCompanyId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setBankAccount(getBankAccount());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setFactSalary(getFactSalary());
		__bean.setSalaryissue(getSalaryissue());
		__bean.setLoanissue(getLoanissue());
		__bean.setBalance(getBalance());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		String strEmployeeName = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getEmployeeName()));
		sb.append(strEmployeeName == null ? "" : strEmployeeName);
		sb.append(",");
		sb.append(getBankAccount() == null ? "" : getBankAccount());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getFactSalary() == null ? "" : getFactSalary());
		sb.append(",");
		sb.append(getSalaryissue() == null ? "" : getSalaryissue());
		sb.append(",");
		sb.append(getLoanissue() == null ? "" : getLoanissue());
		sb.append(",");
		sb.append(getBalance() == null ? "" : getBalance());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnSalarySendData o) {
		return __company_id == null ? -1 : __company_id.compareTo(o.getCompanyId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__bank_account);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__fact_salary);
		hash = 97 * hash + Objects.hashCode(this.__salaryissue);
		hash = 97 * hash + Objects.hashCode(this.__loanissue);
		hash = 97 * hash + Objects.hashCode(this.__balance);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnSalarySendData o = (BaseOnSalarySendData)obj;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__bank_account, o.getBankAccount())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__fact_salary, o.getFactSalary())) return false;
		if(!Objects.equals(this.__salaryissue, o.getSalaryissue())) return false;
		if(!Objects.equals(this.__loanissue, o.getLoanissue())) return false;
		if(!Objects.equals(this.__balance, o.getBalance())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getBankAccount() != null) sb.append(__wrapString(count++, "bankAccount", getBankAccount()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getFactSalary() != null) sb.append(__wrapDecimal(count++, "factSalary", getFactSalary()));
		if(getSalaryissue() != null) sb.append(__wrapDecimal(count++, "salaryissue", getSalaryissue()));
		if(getLoanissue() != null) sb.append(__wrapDecimal(count++, "loanissue", getLoanissue()));
		if(getBalance() != null) sb.append(__wrapDecimal(count++, "balance", getBalance()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getBankAccount() != null) res.put("bankAccount", getBankAccount());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getFactSalary() != null) res.put("factSalary", getFactSalary());
		if(getSalaryissue() != null) res.put("salaryissue", getSalaryissue());
		if(getLoanissue() != null) res.put("loanissue", getLoanissue());
		if(getBalance() != null) res.put("balance", getBalance());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("factSalary")) != null) setFactSalary(__getDecimal(val));  
		if((val = values.get("salaryissue")) != null) setSalaryissue(__getDecimal(val));  
		if((val = values.get("loanissue")) != null) setLoanissue(__getDecimal(val));  
		if((val = values.get("balance")) != null) setBalance(__getDecimal(val));  
	}

	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.String  __bank_account ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.math.BigDecimal  __fact_salary ;
	protected java.math.BigDecimal  __salaryissue ;
	protected java.math.BigDecimal  __loanissue ;
	protected java.math.BigDecimal  __balance ;
}
