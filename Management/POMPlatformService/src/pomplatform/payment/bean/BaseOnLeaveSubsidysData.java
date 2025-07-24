package pomplatform.payment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLeaveSubsidysData extends GenericBase implements BaseFactory<BaseOnLeaveSubsidysData>, Comparable<BaseOnLeaveSubsidysData> 
{


	public static BaseOnLeaveSubsidysData newInstance(){
		return new BaseOnLeaveSubsidysData();
	}

	@Override
	public BaseOnLeaveSubsidysData make(){
		BaseOnLeaveSubsidysData b = new BaseOnLeaveSubsidysData();
		return b;
	}

	public final static java.lang.String CS_SALARY_LEAVE_SUBSIDY_ID = "salary_leave_subsidy_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_NO_DEDUCT_TAX = "no_deduct_tax" ;
	public final static java.lang.String CS_DEDUCT_TAX = "deduct_tax" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static java.lang.String CS_IS_SENDED = "is_sended" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工姓名,员工编号,员工姓名,归属公司,业务板块,归属部门,日期,不扣税,扣税,合计,是否发放";

	public java.lang.Integer getSalaryLeaveSubsidyId() {
		return this.__salary_leave_subsidy_id;
	}

	public void setSalaryLeaveSubsidyId( java.lang.Integer value ) {
		this.__salary_leave_subsidy_id = value;
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

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.String getNoDeductTax() {
		return this.__no_deduct_tax;
	}

	public void setNoDeductTax( java.lang.String value ) {
		this.__no_deduct_tax = value;
	}

	public java.lang.String getDeductTax() {
		return this.__deduct_tax;
	}

	public void setDeductTax( java.lang.String value ) {
		this.__deduct_tax = value;
	}

	public java.lang.String getTotalAmount() {
		return this.__total_amount;
	}

	public void setTotalAmount( java.lang.String value ) {
		this.__total_amount = value;
	}

	public java.lang.Boolean getIsSended() {
		return this.__is_sended;
	}

	public void setIsSended( java.lang.Boolean value ) {
		this.__is_sended = value;
	}

	public void cloneCopy(BaseOnLeaveSubsidysData __bean){
		__bean.setSalaryLeaveSubsidyId(getSalaryLeaveSubsidyId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setCompanyId(getCompanyId());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setRecordDate(getRecordDate());
		__bean.setNoDeductTax(getNoDeductTax());
		__bean.setDeductTax(getDeductTax());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setIsSended(getIsSended());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSalaryLeaveSubsidyId() == null ? "" : getSalaryLeaveSubsidyId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getNoDeductTax() == null ? "" : getNoDeductTax());
		sb.append(",");
		sb.append(getDeductTax() == null ? "" : getDeductTax());
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		sb.append(",");
		sb.append(getIsSended() == null ? "" : getIsSended());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLeaveSubsidysData o) {
		return __salary_leave_subsidy_id == null ? -1 : __salary_leave_subsidy_id.compareTo(o.getSalaryLeaveSubsidyId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__salary_leave_subsidy_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__no_deduct_tax);
		hash = 97 * hash + Objects.hashCode(this.__deduct_tax);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__is_sended);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLeaveSubsidysData o = (BaseOnLeaveSubsidysData)obj;
		if(!Objects.equals(this.__salary_leave_subsidy_id, o.getSalaryLeaveSubsidyId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__no_deduct_tax, o.getNoDeductTax())) return false;
		if(!Objects.equals(this.__deduct_tax, o.getDeductTax())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__is_sended, o.getIsSended())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSalaryLeaveSubsidyId() != null) sb.append(__wrapNumber(count++, "salaryLeaveSubsidyId", getSalaryLeaveSubsidyId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getNoDeductTax() != null) sb.append(__wrapString(count++, "noDeductTax", getNoDeductTax()));
		if(getDeductTax() != null) sb.append(__wrapString(count++, "deductTax", getDeductTax()));
		if(getTotalAmount() != null) sb.append(__wrapString(count++, "totalAmount", getTotalAmount()));
		if(getIsSended() != null) sb.append(__wrapBoolean(count++, "isSended", getIsSended()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("salaryLeaveSubsidyId")) != null) setSalaryLeaveSubsidyId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("noDeductTax")) != null) setNoDeductTax(__getString(val));
		if((val = values.get("deductTax")) != null) setDeductTax(__getString(val));
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getString(val));
		if((val = values.get("isSended")) != null) setIsSended(__getBoolean(val));
	}

	protected java.lang.Integer  __salary_leave_subsidy_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.util.Date  __record_date ;
	protected java.lang.String  __no_deduct_tax ;
	protected java.lang.String  __deduct_tax ;
	protected java.lang.String  __total_amount ;
	protected java.lang.Boolean  __is_sended ;
}
