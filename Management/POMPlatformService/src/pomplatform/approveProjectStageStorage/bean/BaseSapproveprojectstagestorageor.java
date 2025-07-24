package pomplatform.approveProjectStageStorage.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;
import com.pomplatform.db.bean.BaseProjectStageStorage;
import com.pomplatform.db.bean.BaseProjectStage;

public class BaseSapproveprojectstagestorageor extends GenericBase implements BaseFactory<BaseSapproveprojectstagestorageor>, Comparable<BaseSapproveprojectstagestorageor> 
{


	public static BaseSapproveprojectstagestorageor newInstance(){
		return new BaseSapproveprojectstagestorageor();
	}

	@Override
	public BaseSapproveprojectstagestorageor make(){
		BaseSapproveprojectstagestorageor b = new BaseSapproveprojectstagestorageor();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PROJECT_MANAGE_ID = "project_manage_id" ;
	public final static java.lang.String CS_PLATE_MANAGER_ID = "plate_manager_id" ;
	public final static java.lang.String CS_DEPARTMENT_MANAGER_ID = "department_manager_id" ;

	public final static java.lang.String ALL_CAPTIONS = "项目主键,合同编号,项目编号,项目名称,项目类别,板块,专业负责人,事业部负责人,部门经理";

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

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
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

	public java.lang.Integer getPlateManagerId() {
		return this.__plate_manager_id;
	}

	public void setPlateManagerId( java.lang.Integer value ) {
		this.__plate_manager_id = value;
	}

	public java.lang.Integer getDepartmentManagerId() {
		return this.__department_manager_id;
	}

	public void setDepartmentManagerId( java.lang.Integer value ) {
		this.__department_manager_id = value;
	}

	public java.util.List<BaseProjectStageStorage> getDetailProjectStageStorage() {
		return this.__detailProjectStageStorage;
	}

	public void setDetailProjectStageStorage( java.util.List<BaseProjectStageStorage> value ) {
		this.__detailProjectStageStorage = value;
	}

	public java.util.List<BaseProjectStage> getDetailProjectStage() {
		return this.__detailProjectStage;
	}

	public void setDetailProjectStage( java.util.List<BaseProjectStage> value ) {
		this.__detailProjectStage = value;
	}

	public void cloneCopy(BaseSapproveprojectstagestorageor __bean){
		__bean.setProjectId(getProjectId());
		__bean.setContractCode(getContractCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setProjectType(getProjectType());
		__bean.setPlateId(getPlateId());
		__bean.setProjectManageId(getProjectManageId());
		__bean.setPlateManagerId(getPlateManagerId());
		__bean.setDepartmentManagerId(getDepartmentManagerId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getProjectType() == null ? "" : getProjectType());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getProjectManageId() == null ? "" : getProjectManageId());
		sb.append(",");
		sb.append(getPlateManagerId() == null ? "" : getPlateManagerId());
		sb.append(",");
		sb.append(getDepartmentManagerId() == null ? "" : getDepartmentManagerId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSapproveprojectstagestorageor o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_manager_id);
		hash = 97 * hash + Objects.hashCode(this.__department_manager_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSapproveprojectstagestorageor o = (BaseSapproveprojectstagestorageor)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		if(!Objects.equals(this.__plate_manager_id, o.getPlateManagerId())) return false;
		if(!Objects.equals(this.__department_manager_id, o.getDepartmentManagerId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, "projectManageId", getProjectManageId()));
		if(getPlateManagerId() != null) sb.append(__wrapNumber(count++, "plateManagerId", getPlateManagerId()));
		if(getDepartmentManagerId() != null) sb.append(__wrapNumber(count++, "departmentManagerId", getDepartmentManagerId()));
		if(getDetailProjectStageStorage() != null)  sb.append(__wrapList(count++, "detailProjectStageStorage", getDetailProjectStageStorage()));
		if(getDetailProjectStage() != null)  sb.append(__wrapList(count++, "detailProjectStage", getDetailProjectStage()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("plateManagerId")) != null) setPlateManagerId(__getInt(val)); 
		if((val = values.get("departmentManagerId")) != null) setDepartmentManagerId(__getInt(val)); 
		if((val = values.get("detailProjectStageStorage")) != null) setDetailProjectStageStorage(__getList(val, BaseProjectStageStorage.newInstance()));
		if((val = values.get("detailProjectStage")) != null) setDetailProjectStage(__getList(val, BaseProjectStage.newInstance()));
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __project_type ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __project_manage_id ;
	protected java.lang.Integer  __plate_manager_id ;
	protected java.lang.Integer  __department_manager_id ;
	protected java.util.List<BaseProjectStageStorage> __detailProjectStageStorage = null;
	protected java.util.List<BaseProjectStage> __detailProjectStage = null;
}
