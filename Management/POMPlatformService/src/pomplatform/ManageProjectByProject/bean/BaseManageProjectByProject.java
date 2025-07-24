package pomplatform.ManageProjectByProject.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseManageProjectByProject extends GenericBase implements BaseFactory<BaseManageProjectByProject>, Comparable<BaseManageProjectByProject> 
{


	public static BaseManageProjectByProject newInstance(){
		return new BaseManageProjectByProject();
	}

	@Override
	public BaseManageProjectByProject make(){
		BaseManageProjectByProject b = new BaseManageProjectByProject();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_MANAGE_PROJECT_ID = "manage_project_id" ;
	public final static java.lang.String CS_MANAGE_PROJECT_NAME = "manage_project_name" ;
	public final static java.lang.String CS_TOTAL_INTEGRAL = "total_integral" ;
	public final static java.lang.String CS_LEFT_INTEGRAL = "left_integral" ;
	public final static java.lang.String CS_PROJECT_DATE = "project_date" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,主键编码,项目名称,项目总积分,剩余积分,日期,备注";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getManageProjectId() {
		return this.__manage_project_id;
	}

	public void setManageProjectId( java.lang.Integer value ) {
		this.__manage_project_id = value;
	}

	public java.lang.String getManageProjectName() {
		return this.__manage_project_name;
	}

	public void setManageProjectName( java.lang.String value ) {
		this.__manage_project_name = value;
	}

	public java.math.BigDecimal getTotalIntegral() {
		return this.__total_integral;
	}

	public void setTotalIntegral( java.math.BigDecimal value ) {
		this.__total_integral = value;
	}

	public java.math.BigDecimal getLeftIntegral() {
		return this.__left_integral;
	}

	public void setLeftIntegral( java.math.BigDecimal value ) {
		this.__left_integral = value;
	}

	public java.util.Date getProjectDate() {
		return this.__project_date;
	}

	public void setProjectDate( java.util.Date value ) {
		this.__project_date = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseManageProjectByProject __bean){
		__bean.setPlateId(getPlateId());
		__bean.setManageProjectId(getManageProjectId());
		__bean.setManageProjectName(getManageProjectName());
		__bean.setTotalIntegral(getTotalIntegral());
		__bean.setLeftIntegral(getLeftIntegral());
		__bean.setProjectDate(getProjectDate());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strManageProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("manage_projects", String.valueOf(getManageProjectId()));
		sb.append(strManageProjectId == null ? "" : strManageProjectId);
		sb.append(",");
		sb.append(getManageProjectName() == null ? "" : getManageProjectName());
		sb.append(",");
		sb.append(getTotalIntegral() == null ? "" : getTotalIntegral());
		sb.append(",");
		sb.append(getLeftIntegral() == null ? "" : getLeftIntegral());
		sb.append(",");
		sb.append(getProjectDate() == null ? "" : sdf.format(getProjectDate()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseManageProjectByProject o) {
		return __manage_project_id == null ? -1 : __manage_project_id.compareTo(o.getManageProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__manage_project_id);
		hash = 97 * hash + Objects.hashCode(this.__manage_project_name);
		hash = 97 * hash + Objects.hashCode(this.__total_integral);
		hash = 97 * hash + Objects.hashCode(this.__left_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_date);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseManageProjectByProject o = (BaseManageProjectByProject)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__manage_project_id, o.getManageProjectId())) return false;
		if(!Objects.equals(this.__manage_project_name, o.getManageProjectName())) return false;
		if(!Objects.equals(this.__total_integral, o.getTotalIntegral())) return false;
		if(!Objects.equals(this.__left_integral, o.getLeftIntegral())) return false;
		if(!Objects.equals(this.__project_date, o.getProjectDate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getManageProjectId() != null) sb.append(__wrapNumber(count++, "manageProjectId", getManageProjectId()));
		if(getManageProjectName() != null) sb.append(__wrapString(count++, "manageProjectName", getManageProjectName()));
		if(getTotalIntegral() != null) sb.append(__wrapDecimal(count++, "totalIntegral", getTotalIntegral()));
		if(getLeftIntegral() != null) sb.append(__wrapDecimal(count++, "leftIntegral", getLeftIntegral()));
		if(getProjectDate() != null) sb.append(__wrapDate(count++, "projectDate", getProjectDate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("manageProjectId")) != null) setManageProjectId(__getInt(val)); 
		if((val = values.get("manageProjectName")) != null) setManageProjectName(__getString(val));
		if((val = values.get("totalIntegral")) != null) setTotalIntegral(__getDecimal(val));  
		if((val = values.get("leftIntegral")) != null) setLeftIntegral(__getDecimal(val));  
		if((val = values.get("projectDate")) != null) setProjectDate(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __manage_project_id ;
	protected java.lang.String  __manage_project_name ;
	protected java.math.BigDecimal  __total_integral ;
	protected java.math.BigDecimal  __left_integral ;
	protected java.util.Date  __project_date ;
	protected java.lang.String  __remark ;
}
