package pomplatform.employee.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeInfoOfNoSalaryAdjustment extends GenericBase implements BaseFactory<BaseEmployeeInfoOfNoSalaryAdjustment>, Comparable<BaseEmployeeInfoOfNoSalaryAdjustment> 
{


	public static BaseEmployeeInfoOfNoSalaryAdjustment newInstance(){
		return new BaseEmployeeInfoOfNoSalaryAdjustment();
	}

	@Override
	public BaseEmployeeInfoOfNoSalaryAdjustment make(){
		BaseEmployeeInfoOfNoSalaryAdjustment b = new BaseEmployeeInfoOfNoSalaryAdjustment();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_ONBOARD_DATE = "onboard_date" ;
	public final static java.lang.String CS_CHANGE_DATE = "change_date" ;
	public final static java.lang.String CS_ORIGINAL_PAY = "original_pay" ;
	public final static java.lang.String CS_CHANGE_PAY = "change_pay" ;
	public final static java.lang.String CS_MONTH_PAY = "month_pay" ;
	public final static java.lang.String CS_PERCENT = "percent" ;

	public final static java.lang.String ALL_CAPTIONS = "员工编码,姓名,工号,业务部门,所属部门,入职日期,调薪日期,现薪资,调薪金额,调整后薪资总额,调薪比例";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.Integer getCompanyId() {
		return __company_id;
	}

	public void setCompanyId(java.lang.Integer value) {
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

	public java.util.Date getOnboardDate() {
		return this.__onboard_date;
	}

	public void setOnboardDate( java.util.Date value ) {
		this.__onboard_date = value;
	}

	public java.util.Date getChangeDate() {
		return this.__change_date;
	}

	public void setChangeDate( java.util.Date value ) {
		this.__change_date = value;
	}

	public java.lang.String getOriginalPay() {
		return this.__original_pay;
	}

	public void setOriginalPay( java.lang.String value ) {
		this.__original_pay = value;
	}

	public java.lang.String getChangePay() {
		return this.__change_pay;
	}

	public void setChangePay( java.lang.String value ) {
		this.__change_pay = value;
	}

	public java.lang.String getMonthPay() {
		return this.__month_pay;
	}

	public void setMonthPay( java.lang.String value ) {
		this.__month_pay = value;
	}

	public java.math.BigDecimal getPercent() {
		return this.__percent;
	}

	public void setPercent( java.math.BigDecimal value ) {
		this.__percent = value;
	}

	public java.lang.Integer getType() {
		return __type;
	}

	public void setType(java.lang.Integer value) {
		this.__type = value;
	}

	public java.math.BigDecimal getFee() {
		return __fee;
	}

	public void setFee(java.math.BigDecimal value) {
		this.__fee = value;
	}

	public java.lang.String getRemark() {
		return __remark;
	}

	public void setRemark(java.lang.String __remark) {
		this.__remark = __remark;
	}

	public void cloneCopy(BaseEmployeeInfoOfNoSalaryAdjustment __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setCompanyId(getCompanyId());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setOnboardDate(getOnboardDate());
		__bean.setChangeDate(getChangeDate());
		__bean.setOriginalPay(getOriginalPay());
		__bean.setChangePay(getChangePay());
		__bean.setMonthPay(getMonthPay());
		__bean.setPercent(getPercent());
		__bean.setType(getType());
		__bean.setFee(getFee());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strEmployeeName = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeName()));
		sb.append(strEmployeeName == null ? "" : strEmployeeName);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getOnboardDate() == null ? "" : sdf.format(getOnboardDate()));
		sb.append(",");
		sb.append(getChangeDate() == null ? "" : sdf.format(getChangeDate()));
		sb.append(",");
		sb.append(getOriginalPay() == null ? "" : getOriginalPay());
		sb.append(",");
		sb.append(getChangePay() == null ? "" : getChangePay());
		sb.append(",");
		sb.append(getMonthPay() == null ? "" : getMonthPay());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeInfoOfNoSalaryAdjustment o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__onboard_date);
		hash = 97 * hash + Objects.hashCode(this.__change_date);
		hash = 97 * hash + Objects.hashCode(this.__original_pay);
		hash = 97 * hash + Objects.hashCode(this.__change_pay);
		hash = 97 * hash + Objects.hashCode(this.__month_pay);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__fee);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeInfoOfNoSalaryAdjustment o = (BaseEmployeeInfoOfNoSalaryAdjustment)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__onboard_date, o.getOnboardDate())) return false;
		if(!Objects.equals(this.__change_date, o.getChangeDate())) return false;
		if(!Objects.equals(this.__original_pay, o.getOriginalPay())) return false;
		if(!Objects.equals(this.__change_pay, o.getChangePay())) return false;
		if(!Objects.equals(this.__month_pay, o.getMonthPay())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__fee, o.getFee())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getOnboardDate() != null) sb.append(__wrapDate(count++, "onboardDate", getOnboardDate()));
		if(getChangeDate() != null) sb.append(__wrapDate(count++, "changeDate", getChangeDate()));
		if(getOriginalPay() != null) sb.append(__wrapString(count++, "originalPay", getOriginalPay()));
		if(getChangePay() != null) sb.append(__wrapString(count++, "changePay", getChangePay()));
		if(getMonthPay() != null) sb.append(__wrapString(count++, "monthPay", getMonthPay()));
		if(getPercent() != null) sb.append(__wrapDecimal(count++, "percent", getPercent()));
		if(getFee() != null) sb.append(__wrapDecimal(count++, "fee", getFee()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("onboardDate")) != null) setOnboardDate(__getDate(val)); 
		if((val = values.get("changeDate")) != null) setChangeDate(__getDate(val)); 
		if((val = values.get("originalPay")) != null) setOriginalPay(__getString(val));
		if((val = values.get("changePay")) != null) setChangePay(__getString(val));
		if((val = values.get("monthPay")) != null) setMonthPay(__getString(val));
		if((val = values.get("percent")) != null) setPercent(__getDecimal(val));  
		if((val = values.get("fee")) != null) setFee(__getDecimal(val));  
		if((val = values.get("type")) != null) setType(__getInt(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_name ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.util.Date  __onboard_date ;
	protected java.util.Date  __change_date ;
	protected java.lang.String  __original_pay ;
	protected java.lang.String  __change_pay ;
	protected java.lang.String  __month_pay ;
	protected java.math.BigDecimal  __percent ;
	protected java.math.BigDecimal  __fee ;
	protected java.lang.Integer  __type ;
	protected java.lang.String  __remark ;
}
