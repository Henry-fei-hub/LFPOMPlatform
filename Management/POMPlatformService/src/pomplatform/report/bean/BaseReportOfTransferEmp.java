package pomplatform.report.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReportOfTransferEmp extends GenericBase implements BaseFactory<BaseReportOfTransferEmp>, Comparable<BaseReportOfTransferEmp> 
{


	public static BaseReportOfTransferEmp newInstance(){
		return new BaseReportOfTransferEmp();
	}

	@Override
	public BaseReportOfTransferEmp make(){
		BaseReportOfTransferEmp b = new BaseReportOfTransferEmp();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_GENDER = "gender" ;
	public final static java.lang.String CS_OLD_PLATE_ID = "old_plate_id" ;
	public final static java.lang.String CS_OLD_DEPARTMENT_ID = "old_department_id" ;
	public final static java.lang.String CS_NEW_PLATE_ID = "new_plate_id" ;
	public final static java.lang.String CS_NEW_DEPARTMENT_ID = "new_department_id" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;

	public final static java.lang.String ALL_CAPTIONS = "员工编码,工号,姓名,性别,业务部门,所属部门,业务部门,所属部门,生效时间";

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

	public java.lang.Integer getGender() {
		return this.__gender;
	}

	public void setGender( java.lang.Integer value ) {
		this.__gender = value;
	}

	public java.lang.Integer getOldPlateId() {
		return this.__old_plate_id;
	}

	public void setOldPlateId( java.lang.Integer value ) {
		this.__old_plate_id = value;
	}

	public java.lang.Integer getOldDepartmentId() {
		return this.__old_department_id;
	}

	public void setOldDepartmentId( java.lang.Integer value ) {
		this.__old_department_id = value;
	}

	public java.lang.Integer getNewPlateId() {
		return this.__new_plate_id;
	}

	public void setNewPlateId( java.lang.Integer value ) {
		this.__new_plate_id = value;
	}

	public java.lang.Integer getNewDepartmentId() {
		return this.__new_department_id;
	}

	public void setNewDepartmentId( java.lang.Integer value ) {
		this.__new_department_id = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public void cloneCopy(BaseReportOfTransferEmp __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setGender(getGender());
		__bean.setOldPlateId(getOldPlateId());
		__bean.setOldDepartmentId(getOldDepartmentId());
		__bean.setNewPlateId(getNewPlateId());
		__bean.setNewDepartmentId(getNewDepartmentId());
		__bean.setEndDate(getEndDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getGender() == null ? "" : getGender());
		sb.append(",");
		sb.append(getOldPlateId() == null ? "" : getOldPlateId());
		sb.append(",");
		sb.append(getOldDepartmentId() == null ? "" : getOldDepartmentId());
		sb.append(",");
		sb.append(getNewPlateId() == null ? "" : getNewPlateId());
		sb.append(",");
		sb.append(getNewDepartmentId() == null ? "" : getNewDepartmentId());
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportOfTransferEmp o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__gender);
		hash = 97 * hash + Objects.hashCode(this.__old_plate_id);
		hash = 97 * hash + Objects.hashCode(this.__old_department_id);
		hash = 97 * hash + Objects.hashCode(this.__new_plate_id);
		hash = 97 * hash + Objects.hashCode(this.__new_department_id);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportOfTransferEmp o = (BaseReportOfTransferEmp)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__gender, o.getGender())) return false;
		if(!Objects.equals(this.__old_plate_id, o.getOldPlateId())) return false;
		if(!Objects.equals(this.__old_department_id, o.getOldDepartmentId())) return false;
		if(!Objects.equals(this.__new_plate_id, o.getNewPlateId())) return false;
		if(!Objects.equals(this.__new_department_id, o.getNewDepartmentId())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getGender() != null) sb.append(__wrapNumber(count++, "gender", getGender()));
		if(getOldPlateId() != null) sb.append(__wrapNumber(count++, "oldPlateId", getOldPlateId()));
		if(getOldDepartmentId() != null) sb.append(__wrapNumber(count++, "oldDepartmentId", getOldDepartmentId()));
		if(getNewPlateId() != null) sb.append(__wrapNumber(count++, "newPlateId", getNewPlateId()));
		if(getNewDepartmentId() != null) sb.append(__wrapNumber(count++, "newDepartmentId", getNewDepartmentId()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("gender")) != null) setGender(__getInt(val)); 
		if((val = values.get("oldPlateId")) != null) setOldPlateId(__getInt(val)); 
		if((val = values.get("oldDepartmentId")) != null) setOldDepartmentId(__getInt(val)); 
		if((val = values.get("newPlateId")) != null) setNewPlateId(__getInt(val)); 
		if((val = values.get("newDepartmentId")) != null) setNewDepartmentId(__getInt(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __gender ;
	protected java.lang.Integer  __old_plate_id ;
	protected java.lang.Integer  __old_department_id ;
	protected java.lang.Integer  __new_plate_id ;
	protected java.lang.Integer  __new_department_id ;
	protected java.util.Date  __end_date ;
}
