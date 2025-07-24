package pomplatform.payment.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnOtherDeductionData extends GenericBase implements BaseFactory<BaseOnOtherDeductionData>, Comparable<BaseOnOtherDeductionData> 
{


	public static BaseOnOtherDeductionData newInstance(){
		return new BaseOnOtherDeductionData();
	}

	@Override
	public BaseOnOtherDeductionData make(){
		BaseOnOtherDeductionData b = new BaseOnOtherDeductionData();
		return b;
	}

	public final static java.lang.String CS_OTHER_DEDUCTION_ID = "other_deduction_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_OTHER_DEDUCTION = "other_deduction" ;
	public final static java.lang.String CS_IS_SENDED = "is_sended" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工id,员工编号,员工姓名,归属公司,业务部门,部门,日期,其他扣除,是否发放";

	public java.lang.Integer getOtherDeductionId() {
		return this.__other_deduction_id;
	}

	public void setOtherDeductionId( java.lang.Integer value ) {
		this.__other_deduction_id = value;
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

	public java.lang.String getOtherDeduction() {
		return this.__other_deduction;
	}

	public void setOtherDeduction( java.lang.String value ) {
		this.__other_deduction = value;
	}

	public java.lang.Boolean getIsSended() {
		return this.__is_sended;
	}

	public void setIsSended( java.lang.Boolean value ) {
		this.__is_sended = value;
	}

	public void cloneCopy(BaseOnOtherDeductionData __bean){
		__bean.setOtherDeductionId(getOtherDeductionId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setCompanyId(getCompanyId());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setRecordDate(getRecordDate());
		__bean.setOtherDeduction(getOtherDeduction());
		__bean.setIsSended(getIsSended());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getOtherDeductionId() == null ? "" : getOtherDeductionId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getOtherDeduction() == null ? "" : getOtherDeduction());
		sb.append(",");
		sb.append(getIsSended() == null ? "" : getIsSended());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnOtherDeductionData o) {
		return __other_deduction_id == null ? -1 : __other_deduction_id.compareTo(o.getOtherDeductionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__other_deduction_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__other_deduction);
		hash = 97 * hash + Objects.hashCode(this.__is_sended);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnOtherDeductionData o = (BaseOnOtherDeductionData)obj;
		if(!Objects.equals(this.__other_deduction_id, o.getOtherDeductionId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__other_deduction, o.getOtherDeduction())) return false;
		if(!Objects.equals(this.__is_sended, o.getIsSended())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getOtherDeductionId() != null) sb.append(__wrapNumber(count++, "otherDeductionId", getOtherDeductionId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getOtherDeduction() != null) sb.append(__wrapString(count++, "otherDeduction", getOtherDeduction()));
		if(getIsSended() != null) sb.append(__wrapBoolean(count++, "isSended", getIsSended()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getOtherDeductionId() != null) res.put("otherDeductionId", getOtherDeductionId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getRecordDate() != null) res.put("recordDate", getRecordDate());
		if(getOtherDeduction() != null) res.put("otherDeduction", getOtherDeduction());
		if(getIsSended() != null) res.put("isSended", getIsSended());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("otherDeductionId")) != null) setOtherDeductionId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("otherDeduction")) != null) setOtherDeduction(__getString(val));
		if((val = values.get("isSended")) != null) setIsSended(__getBoolean(val));
	}

	protected java.lang.Integer  __other_deduction_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.util.Date  __record_date ;
	protected java.lang.String  __other_deduction ;
	protected java.lang.Boolean  __is_sended ;
}
