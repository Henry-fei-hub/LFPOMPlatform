package pomplatform.project.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseGetProjectManagerByContractId extends GenericBase implements BaseFactory<BaseGetProjectManagerByContractId>, Comparable<BaseGetProjectManagerByContractId> 
{


	public static BaseGetProjectManagerByContractId newInstance(){
		return new BaseGetProjectManagerByContractId();
	}

	@Override
	public BaseGetProjectManagerByContractId make(){
		BaseGetProjectManagerByContractId b = new BaseGetProjectManagerByContractId();
		return b;
	}

	public final static java.lang.String CS_PROJECT_MANAGE_ID = "project_manage_id" ;

	public final static java.lang.String ALL_CAPTIONS = "专业负责人";

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	public java.lang.Integer getPlateId() {
		return __plate_id;
	}

	public void setPlateId(java.lang.Integer value) {
		this.__plate_id = value;
	}

	public java.lang.String getProjectManagerWeixin() {
		return __project_manager_weixin;
	}

	public void setProjectManagerWeixin(java.lang.String value) {
		this.__project_manager_weixin = value;
	}

	public void cloneCopy(BaseGetProjectManagerByContractId __bean){
		__bean.setProjectManageId(getProjectManageId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProjectManageId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getProjectManageId()));
		sb.append(strProjectManageId == null ? "" : strProjectManageId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetProjectManagerByContractId o) {
		return __project_manage_id == null ? -1 : __project_manage_id.compareTo(o.getProjectManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__project_manager_weixin);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetProjectManagerByContractId o = (BaseGetProjectManagerByContractId)obj;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		if(!Objects.equals(this.__project_manager_weixin, o.getProjectManagerWeixin())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, "projectManageId", getProjectManageId()));
		if(getProjectManagerWeixin() != null) sb.append(__wrapString(count++, "projectManagerWeixin", getProjectManagerWeixin()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("projectManagerWeixin")) != null) setProjectManagerWeixin(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
	}

	protected java.lang.Integer  __project_manage_id ;
	protected java.lang.String  __project_manager_weixin;
	protected java.lang.Integer  __plate_id;
}
