package pomplatform.report.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCooperateStatisticsTotal extends GenericBase implements BaseFactory<BaseCooperateStatisticsTotal>, Comparable<BaseCooperateStatisticsTotal> 
{


	public static BaseCooperateStatisticsTotal newInstance(){
		return new BaseCooperateStatisticsTotal();
	}

	@Override
	public BaseCooperateStatisticsTotal make(){
		BaseCooperateStatisticsTotal b = new BaseCooperateStatisticsTotal();
		return b;
	}

	public final static String CS_PROJECT_ID = "project_id" ;
	public final static String CS_PROJECT_CODE = "project_code" ;
	public final static String CS_PROJECT_NAME = "project_name" ;
	public final static String CS_DRAFTER = "drafter" ;
	public final static String CS_DEPARTMENT_ID = "department_id" ;
	public final static String CS_TYPE = "type" ;
	public final static String CS_PROJECT_TYPE = "project_type" ;
	public final static String CS_SUB_TYPE = "sub_type" ;
	public final static String CS_SETTLEMENT_INTEGRAL = "settlement_integral" ;
	public final static String CS_CREATE_TIME = "start_date" ;

	public final static String ALL_CAPTIONS = "项目编号,项目名称,申请人,部门,配合部门,专业,产值,已结算配合产值,提交时间";

	public Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( Integer value ) {
		this.__project_id = value;
	}

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

	public Integer getType() {
		return this.__type;
	}

	public void setType( Integer value ) {
		this.__type = value;
	}

	public Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( Integer value ) {
		this.__project_type = value;
	}

	public String getSubType() {
		return this.__sub_type;
	}

	public void setSubType( String value ) {
		this.__sub_type = value;
	}

	public Long getSettlementIntegral() {
		return this.__settlement_integral;
	}

	public void setSettlementIntegral( Long value ) {
		this.__settlement_integral = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public void cloneCopy(BaseCooperateStatisticsTotal __bean){
		__bean.setProjectId(getProjectId());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setDrafter(getDrafter());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setType(getType());
		__bean.setProjectType(getProjectType());
		__bean.setSubType(getSubType());
		__bean.setSettlementIntegral(getSettlementIntegral());
		__bean.setStartDate(getStartDate());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
//		sb.append(getProjectId() == null ? "" : getProjectId());
//		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		String strDrafter = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getDrafter()));
		sb.append(strDrafter == null ? "" : strDrafter);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String strType = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getType()));
		sb.append(strType == null ? "" : strType);
		sb.append(",");
		String strProjectType = delicacy.system.executor.SelectValueCache.getSelectValue("pm_specials", String.valueOf(getProjectType()));
		sb.append(strProjectType == null ? "" : strProjectType);
		sb.append(",");
		sb.append(getSubType() == null ? "" : getSubType());
		sb.append(",");
		sb.append(getSettlementIntegral() == null ? "" : getSettlementIntegral());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCooperateStatisticsTotal o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__drafter);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__sub_type);
		hash = 97 * hash + Objects.hashCode(this.__settlement_integral);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCooperateStatisticsTotal o = (BaseCooperateStatisticsTotal)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__drafter, o.getDrafter())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__sub_type, o.getSubType())) return false;
		if(!Objects.equals(this.__settlement_integral, o.getSettlementIntegral())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getDrafter() != null) sb.append(__wrapNumber(count++, "drafter", getDrafter()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getSubType() != null) sb.append(__wrapString(count++, "subType", getSubType()));
		if(getSettlementIntegral() != null) sb.append(__wrapNumber(count++, "settlementIntegral", getSettlementIntegral()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getDrafter() != null) res.put("drafter", getDrafter());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getType() != null) res.put("type", getType());
		if(getProjectType() != null) res.put("projectType", getProjectType());
		if(getSubType() != null) res.put("subType", getSubType());
		if(getSettlementIntegral() != null) res.put("settlementIntegral", getSettlementIntegral());
		if(getStartDate() != null) res.put("startDate", getStartDate());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("drafter")) != null) setDrafter(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("subType")) != null) setSubType(__getString(val));
		if((val = values.get("settlementIntegral")) != null) setSettlementIntegral(__getLong(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val));
	}

	protected Integer  __project_id ;
	protected String  __project_code ;
	protected String  __project_name ;
	protected Integer  __drafter ;
	protected Integer  __department_id ;
	protected Integer  __type ;
	protected Integer  __project_type ;
	protected String  __sub_type ;
	protected Long  __settlement_integral ;
	protected java.util.Date  __start_date ;
}
