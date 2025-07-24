package pomplatform.payment.bean;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseOnFillSendDeductData extends GenericBase implements BaseFactory<BaseOnFillSendDeductData>, Comparable<BaseOnFillSendDeductData> 
{


	public static BaseOnFillSendDeductData newInstance(){
		return new BaseOnFillSendDeductData();
	}

	@Override
	public BaseOnFillSendDeductData make(){
		BaseOnFillSendDeductData b = new BaseOnFillSendDeductData();
		return b;
	}

	public final static java.lang.String CS_SALARY_FILL_SEND_DEDUCT_ID = "salary_fill_send_deduct_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_FILL_FIVE_INSURANCE_ONE_GOLDS = "fill_five_insurance_one_golds" ;
	public final static java.lang.String CS_MORE_DEDUCT_TAX = "more_deduct_tax" ;
	public final static java.lang.String CS_FILL_TAX = "fill_tax" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static java.lang.String CS_IS_SENDED = "is_sended" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工id,员工编号,员工姓名,归属公司,业务部门,归属部门,日期,填平五险一金,多扣个税,填平个税,合计,是否发放,备注";

	public java.lang.Integer getSalaryFillSendDeductId() {
		return this.__salary_fill_send_deduct_id;
	}

	public void setSalaryFillSendDeductId( java.lang.Integer value ) {
		this.__salary_fill_send_deduct_id = value;
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

	public java.lang.String getFillFiveInsuranceOneGolds() {
		return this.__fill_five_insurance_one_golds;
	}

	public void setFillFiveInsuranceOneGolds( java.lang.String value ) {
		this.__fill_five_insurance_one_golds = value;
	}

	public java.lang.String getMoreDeductTax() {
		return this.__more_deduct_tax;
	}

	public void setMoreDeductTax( java.lang.String value ) {
		this.__more_deduct_tax = value;
	}

	public java.lang.String getFillTax() {
		return this.__fill_tax;
	}

	public void setFillTax( java.lang.String value ) {
		this.__fill_tax = value;
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
	
	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseOnFillSendDeductData __bean){
		__bean.setSalaryFillSendDeductId(getSalaryFillSendDeductId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setCompanyId(getCompanyId());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setRecordDate(getRecordDate());
		__bean.setFillFiveInsuranceOneGolds(getFillFiveInsuranceOneGolds());
		__bean.setMoreDeductTax(getMoreDeductTax());
		__bean.setFillTax(getFillTax());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setIsSended(getIsSended());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSalaryFillSendDeductId() == null ? "" : getSalaryFillSendDeductId());
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
		sb.append(getFillFiveInsuranceOneGolds() == null ? "" : getFillFiveInsuranceOneGolds());
		sb.append(",");
		sb.append(getMoreDeductTax() == null ? "" : getMoreDeductTax());
		sb.append(",");
		sb.append(getFillTax() == null ? "" : getFillTax());
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		sb.append(",");
		sb.append(getIsSended() == null ? "" : getIsSended());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnFillSendDeductData o) {
		return __salary_fill_send_deduct_id == null ? -1 : __salary_fill_send_deduct_id.compareTo(o.getSalaryFillSendDeductId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__salary_fill_send_deduct_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__fill_five_insurance_one_golds);
		hash = 97 * hash + Objects.hashCode(this.__more_deduct_tax);
		hash = 97 * hash + Objects.hashCode(this.__fill_tax);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__is_sended);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnFillSendDeductData o = (BaseOnFillSendDeductData)obj;
		if(!Objects.equals(this.__salary_fill_send_deduct_id, o.getSalaryFillSendDeductId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__fill_five_insurance_one_golds, o.getFillFiveInsuranceOneGolds())) return false;
		if(!Objects.equals(this.__more_deduct_tax, o.getMoreDeductTax())) return false;
		if(!Objects.equals(this.__fill_tax, o.getFillTax())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__is_sended, o.getIsSended())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSalaryFillSendDeductId() != null) sb.append(__wrapNumber(count++, "salaryFillSendDeductId", getSalaryFillSendDeductId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getFillFiveInsuranceOneGolds() != null) sb.append(__wrapString(count++, "fillFiveInsuranceOneGolds", getFillFiveInsuranceOneGolds()));
		if(getMoreDeductTax() != null) sb.append(__wrapString(count++, "moreDeductTax", getMoreDeductTax()));
		if(getFillTax() != null) sb.append(__wrapString(count++, "fillTax", getFillTax()));
		if(getTotalAmount() != null) sb.append(__wrapString(count++, "totalAmount", getTotalAmount()));
		if(getIsSended() != null) sb.append(__wrapBoolean(count++, "isSended", getIsSended()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("salaryFillSendDeductId")) != null) setSalaryFillSendDeductId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("fillFiveInsuranceOneGolds")) != null) setFillFiveInsuranceOneGolds(__getString(val));
		if((val = values.get("moreDeductTax")) != null) setMoreDeductTax(__getString(val));
		if((val = values.get("fillTax")) != null) setFillTax(__getString(val));
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getString(val));
		if((val = values.get("isSended")) != null) setIsSended(__getBoolean(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __salary_fill_send_deduct_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.util.Date  __record_date ;
	protected java.lang.String  __fill_five_insurance_one_golds ;
	protected java.lang.String  __more_deduct_tax ;
	protected java.lang.String  __fill_tax ;
	protected java.lang.String  __total_amount ;
	protected java.lang.Boolean  __is_sended ;
	protected java.lang.String  __remark ;
}
