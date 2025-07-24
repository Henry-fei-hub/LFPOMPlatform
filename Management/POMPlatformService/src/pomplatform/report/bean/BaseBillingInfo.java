package pomplatform.report.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseBillingInfo extends GenericBase implements BaseFactory<BaseBillingInfo>, Comparable<BaseBillingInfo> 
{


	public static BaseBillingInfo newInstance(){
		return new BaseBillingInfo();
	}

	@Override
	public BaseBillingInfo make(){
		BaseBillingInfo b = new BaseBillingInfo();
		return b;
	}

	public final static String CS_PROJECT_CODE = "project_code" ;
	public final static String CS_PROJECT_NAME = "project_name" ;
	public final static String CS_DRAFTER = "drafter" ;
	public final static String CS_DEPARTMENT_ID = "department_id" ;
	public final static String CS_SUB_TYPE = "sub_type" ;
	public final static String CS_CREATE_TIME = "create_time" ;

	public final static String ALL_CAPTIONS = "项目编号,项目名称,结算申请人,配合部门,结算产值,提交时间";

	public String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( String value ) {
		this.__project_code = value;
	}

	public String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( String value ) {
		this.__project_name = value;
	}

	public Integer getDrafter() {
		return this.__drafter;
	}

	public void setDrafter( Integer value ) {
		this.__drafter = value;
	}

	public Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( Integer value ) {
		this.__department_id = value;
	}

	public String getSubType() {
		return this.__sub_type;
	}

	public void setSubType( String value ) {
		this.__sub_type = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseBillingInfo __bean){
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setDrafter(getDrafter());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setSubType(getSubType());
		__bean.setCreateTime(getCreateTime());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getDrafter() == null ? "" : getDrafter());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getSubType() == null ? "" : getSubType());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseBillingInfo o) {
		return __project_code == null ? -1 : __project_code.compareTo(o.getProjectCode());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__drafter);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__sub_type);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseBillingInfo o = (BaseBillingInfo)obj;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__drafter, o.getDrafter())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__sub_type, o.getSubType())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getDrafter() != null) sb.append(__wrapNumber(count++, "drafter", getDrafter()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getSubType() != null) sb.append(__wrapString(count++, "subType", getSubType()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getDrafter() != null) res.put("drafter", getDrafter());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getSubType() != null) res.put("subType", getSubType());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("drafter")) != null) setDrafter(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("subType")) != null) setSubType(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected String  __project_code ;
	protected String  __project_name ;
	protected Integer  __drafter ;
	protected Integer  __department_id ;
	protected String  __sub_type ;
	protected java.util.Date  __create_time ;
}
