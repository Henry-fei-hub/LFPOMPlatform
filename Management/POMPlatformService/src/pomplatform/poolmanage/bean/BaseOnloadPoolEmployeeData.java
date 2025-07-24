package pomplatform.poolmanage.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnloadPoolEmployeeData extends GenericBase implements BaseFactory<BaseOnloadPoolEmployeeData>, Comparable<BaseOnloadPoolEmployeeData> 
{


	public static BaseOnloadPoolEmployeeData newInstance(){
		return new BaseOnloadPoolEmployeeData();
	}

	@Override
	public BaseOnloadPoolEmployeeData make(){
		BaseOnloadPoolEmployeeData b = new BaseOnloadPoolEmployeeData();
		return b;
	}

	public final static java.lang.String CS_POOL_MANAGE_ID = "pool_manage_id" ;
	public final static java.lang.String CS_POOL_MANAGE_EMPLOYEE_ID = "pool_manage_employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_GENDER = "gender" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_BUSINESS_IDS = "business_ids" ;
	public final static java.lang.String CS_BUSINESS_NAMES = "business_names" ;
	public final static java.lang.String CS_PROFESSIONAL_IDS = "professional_ids" ;
	public final static java.lang.String CS_PROFESSIONAL_NAMES = "professional_names" ;

	public final static java.lang.String ALL_CAPTIONS = "池子id,主键编码,人员,员工编号,员工姓名,性别,部门,业态编码集,业态名称集,专业编码集,专业名称集";

	public java.lang.Integer getPoolManageId() {
		return this.__pool_manage_id;
	}

	public void setPoolManageId( java.lang.Integer value ) {
		this.__pool_manage_id = value;
	}

	public java.lang.Integer getPoolManageEmployeeId() {
		return this.__pool_manage_employee_id;
	}

	public void setPoolManageEmployeeId( java.lang.Integer value ) {
		this.__pool_manage_employee_id = value;
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

	public java.lang.Integer getGender() {
		return this.__gender;
	}

	public void setGender( java.lang.Integer value ) {
		this.__gender = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.String getBusinessIds() {
		return this.__business_ids;
	}

	public void setBusinessIds( java.lang.String value ) {
		this.__business_ids = value;
	}

	public java.lang.String getBusinessNames() {
		return this.__business_names;
	}

	public void setBusinessNames( java.lang.String value ) {
		this.__business_names = value;
	}

	public java.lang.String getProfessionalIds() {
		return this.__professional_ids;
	}

	public void setProfessionalIds( java.lang.String value ) {
		this.__professional_ids = value;
	}

	public java.lang.String getProfessionalNames() {
		return this.__professional_names;
	}

	public void setProfessionalNames( java.lang.String value ) {
		this.__professional_names = value;
	}

	public void cloneCopy(BaseOnloadPoolEmployeeData __bean){
		__bean.setPoolManageId(getPoolManageId());
		__bean.setPoolManageEmployeeId(getPoolManageEmployeeId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setGender(getGender());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setBusinessIds(getBusinessIds());
		__bean.setBusinessNames(getBusinessNames());
		__bean.setProfessionalIds(getProfessionalIds());
		__bean.setProfessionalNames(getProfessionalNames());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPoolManageId() == null ? "" : getPoolManageId());
		sb.append(",");
		sb.append(getPoolManageEmployeeId() == null ? "" : getPoolManageEmployeeId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		String strEmployeeName = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getEmployeeName()));
		sb.append(strEmployeeName == null ? "" : strEmployeeName);
		sb.append(",");
		sb.append(getGender() == null ? "" : getGender());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getBusinessIds() == null ? "" : getBusinessIds());
		sb.append(",");
		sb.append(getBusinessNames() == null ? "" : getBusinessNames());
		sb.append(",");
		sb.append(getProfessionalIds() == null ? "" : getProfessionalIds());
		sb.append(",");
		sb.append(getProfessionalNames() == null ? "" : getProfessionalNames());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnloadPoolEmployeeData o) {
		return __pool_manage_employee_id == null ? -1 : __pool_manage_employee_id.compareTo(o.getPoolManageEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__pool_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__pool_manage_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__gender);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__business_ids);
		hash = 97 * hash + Objects.hashCode(this.__business_names);
		hash = 97 * hash + Objects.hashCode(this.__professional_ids);
		hash = 97 * hash + Objects.hashCode(this.__professional_names);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnloadPoolEmployeeData o = (BaseOnloadPoolEmployeeData)obj;
		if(!Objects.equals(this.__pool_manage_id, o.getPoolManageId())) return false;
		if(!Objects.equals(this.__pool_manage_employee_id, o.getPoolManageEmployeeId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__gender, o.getGender())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__business_ids, o.getBusinessIds())) return false;
		if(!Objects.equals(this.__business_names, o.getBusinessNames())) return false;
		if(!Objects.equals(this.__professional_ids, o.getProfessionalIds())) return false;
		if(!Objects.equals(this.__professional_names, o.getProfessionalNames())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPoolManageId() != null) sb.append(__wrapNumber(count++, "poolManageId", getPoolManageId()));
		if(getPoolManageEmployeeId() != null) sb.append(__wrapNumber(count++, "poolManageEmployeeId", getPoolManageEmployeeId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getGender() != null) sb.append(__wrapNumber(count++, "gender", getGender()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getBusinessIds() != null) sb.append(__wrapString(count++, "businessIds", getBusinessIds()));
		if(getBusinessNames() != null) sb.append(__wrapString(count++, "businessNames", getBusinessNames()));
		if(getProfessionalIds() != null) sb.append(__wrapString(count++, "professionalIds", getProfessionalIds()));
		if(getProfessionalNames() != null) sb.append(__wrapString(count++, "professionalNames", getProfessionalNames()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPoolManageId() != null) res.put("poolManageId", getPoolManageId());
		if(getPoolManageEmployeeId() != null) res.put("poolManageEmployeeId", getPoolManageEmployeeId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getGender() != null) res.put("gender", getGender());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getBusinessIds() != null) res.put("businessIds", getBusinessIds());
		if(getBusinessNames() != null) res.put("businessNames", getBusinessNames());
		if(getProfessionalIds() != null) res.put("professionalIds", getProfessionalIds());
		if(getProfessionalNames() != null) res.put("professionalNames", getProfessionalNames());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("poolManageId")) != null) setPoolManageId(__getInt(val)); 
		if((val = values.get("poolManageEmployeeId")) != null) setPoolManageEmployeeId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("gender")) != null) setGender(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("businessIds")) != null) setBusinessIds(__getString(val));
		if((val = values.get("businessNames")) != null) setBusinessNames(__getString(val));
		if((val = values.get("professionalIds")) != null) setProfessionalIds(__getString(val));
		if((val = values.get("professionalNames")) != null) setProfessionalNames(__getString(val));
	}

	protected java.lang.Integer  __pool_manage_id ;
	protected java.lang.Integer  __pool_manage_employee_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __gender ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.String  __business_ids ;
	protected java.lang.String  __business_names ;
	protected java.lang.String  __professional_ids ;
	protected java.lang.String  __professional_names ;
}
