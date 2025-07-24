package pomplatform.projectSureDateRecord.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseProjectSureDateRecord extends GenericBase implements BaseFactory<BaseProjectSureDateRecord>, Comparable<BaseProjectSureDateRecord> 
{


	public static BaseProjectSureDateRecord newInstance(){
		return new BaseProjectSureDateRecord();
	}

	@Override
	public BaseProjectSureDateRecord make(){
		BaseProjectSureDateRecord b = new BaseProjectSureDateRecord();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PROJECT_MANAGE_ID = "project_manage_id" ;
	public final static java.lang.String CS_SURE_DATE = "sure_date" ;

	public final static java.lang.String ALL_CAPTIONS = "ID,订单编号,项目名称,部门,专业负责人,最新确认日期";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	public java.util.Date getSureDate() {
		return this.__sure_date;
	}

	public void setSureDate( java.util.Date value ) {
		this.__sure_date = value;
	}

	public void cloneCopy(BaseProjectSureDateRecord __bean){
		__bean.setProjectId(getProjectId());
		__bean.setContractCode(getContractCode());
		__bean.setProjectName(getProjectName());
		__bean.setPlateId(getPlateId());
		__bean.setProjectManageId(getProjectManageId());
		__bean.setSureDate(getSureDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		String strContractCode = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractCode()));
		sb.append(strContractCode == null ? "" : strContractCode);
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strProjectManageId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getProjectManageId()));
		sb.append(strProjectManageId == null ? "" : strProjectManageId);
		sb.append(",");
		sb.append(getSureDate() == null ? "" : sdf.format(getSureDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectSureDateRecord o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__sure_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectSureDateRecord o = (BaseProjectSureDateRecord)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		if(!Objects.equals(this.__sure_date, o.getSureDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, "projectManageId", getProjectManageId()));
		if(getSureDate() != null) sb.append(__wrapDate(count++, "sureDate", getSureDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("sureDate")) != null) setSureDate(__getDate(val)); 
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __project_manage_id ;
	protected java.util.Date  __sure_date ;
}
