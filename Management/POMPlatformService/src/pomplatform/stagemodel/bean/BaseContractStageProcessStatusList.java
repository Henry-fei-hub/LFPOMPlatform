package pomplatform.stagemodel.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseContractStageProcessStatusList extends GenericBase implements BaseFactory<BaseContractStageProcessStatusList>, Comparable<BaseContractStageProcessStatusList> 
{


	public static BaseContractStageProcessStatusList newInstance(){
		return new BaseContractStageProcessStatusList();
	}

	@Override
	public BaseContractStageProcessStatusList make(){
		BaseContractStageProcessStatusList b = new BaseContractStageProcessStatusList();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_STAGE_MODEL_ID = "contract_stage_model_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_STAGE_MODEL_NAME = "stage_model_name" ;
	public final static java.lang.String CS_MANAGER_ID = "manager_id" ;
	public final static java.lang.String CS_MANAGE_AUDIT_STATUS = "manage_audit_status" ;
	public final static java.lang.String CS_DESIGN_DIRECTOR_ID = "design_director_id" ;
	public final static java.lang.String CS_DESIGN_DIRECTOR_AUDIT_STATUS = "design_director_audit_status" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,合同,合同编号,合同名称,节点名称,项目经理,审批状态,驻场人员/设计总监,审批状态,流程状态";

	public java.lang.Integer getContractStageModelId() {
		return this.__contract_stage_model_id;
	}

	public void setContractStageModelId( java.lang.Integer value ) {
		this.__contract_stage_model_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.String getStageModelName() {
		return this.__stage_model_name;
	}

	public void setStageModelName( java.lang.String value ) {
		this.__stage_model_name = value;
	}

	public java.lang.String getManagerId() {
		return this.__manager_id;
	}

	public void setManagerId( java.lang.String value ) {
		this.__manager_id = value;
	}

	public java.lang.String getManageAuditStatus() {
		return this.__manage_audit_status;
	}

	public void setManageAuditStatus( java.lang.String value ) {
		this.__manage_audit_status = value;
	}

	public java.lang.String getDesignDirectorId() {
		return this.__design_director_id;
	}

	public void setDesignDirectorId( java.lang.String value ) {
		this.__design_director_id = value;
	}

	public java.lang.String getDesignDirectorAuditStatus() {
		return this.__design_director_audit_status;
	}

	public void setDesignDirectorAuditStatus( java.lang.String value ) {
		this.__design_director_audit_status = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public void cloneCopy(BaseContractStageProcessStatusList __bean){
		__bean.setContractStageModelId(getContractStageModelId());
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setStageModelName(getStageModelName());
		__bean.setManagerId(getManagerId());
		__bean.setManageAuditStatus(getManageAuditStatus());
		__bean.setDesignDirectorId(getDesignDirectorId());
		__bean.setDesignDirectorAuditStatus(getDesignDirectorAuditStatus());
		__bean.setProcessStatus(getProcessStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractStageModelId() == null ? "" : getContractStageModelId());
		sb.append(",");
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getStageModelName() == null ? "" : getStageModelName());
		sb.append(",");
		sb.append(getManagerId() == null ? "" : getManagerId());
		sb.append(",");
		sb.append(getManageAuditStatus() == null ? "" : getManageAuditStatus());
		sb.append(",");
		sb.append(getDesignDirectorId() == null ? "" : getDesignDirectorId());
		sb.append(",");
		sb.append(getDesignDirectorAuditStatus() == null ? "" : getDesignDirectorAuditStatus());
		sb.append(",");
		sb.append(getProcessStatus() == null ? "" : getProcessStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractStageProcessStatusList o) {
		return __contract_stage_model_id == null ? -1 : __contract_stage_model_id.compareTo(o.getContractStageModelId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_stage_model_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__stage_model_name);
		hash = 97 * hash + Objects.hashCode(this.__manager_id);
		hash = 97 * hash + Objects.hashCode(this.__manage_audit_status);
		hash = 97 * hash + Objects.hashCode(this.__design_director_id);
		hash = 97 * hash + Objects.hashCode(this.__design_director_audit_status);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractStageProcessStatusList o = (BaseContractStageProcessStatusList)obj;
		if(!Objects.equals(this.__contract_stage_model_id, o.getContractStageModelId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__stage_model_name, o.getStageModelName())) return false;
		if(!Objects.equals(this.__manager_id, o.getManagerId())) return false;
		if(!Objects.equals(this.__manage_audit_status, o.getManageAuditStatus())) return false;
		if(!Objects.equals(this.__design_director_id, o.getDesignDirectorId())) return false;
		if(!Objects.equals(this.__design_director_audit_status, o.getDesignDirectorAuditStatus())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractStageModelId() != null) sb.append(__wrapNumber(count++, "contractStageModelId", getContractStageModelId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getStageModelName() != null) sb.append(__wrapString(count++, "stageModelName", getStageModelName()));
		if(getManagerId() != null) sb.append(__wrapString(count++, "managerId", getManagerId()));
		if(getManageAuditStatus() != null) sb.append(__wrapString(count++, "manageAuditStatus", getManageAuditStatus()));
		if(getDesignDirectorId() != null) sb.append(__wrapString(count++, "designDirectorId", getDesignDirectorId()));
		if(getDesignDirectorAuditStatus() != null) sb.append(__wrapString(count++, "designDirectorAuditStatus", getDesignDirectorAuditStatus()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractStageModelId")) != null) setContractStageModelId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("stageModelName")) != null) setStageModelName(__getString(val));
		if((val = values.get("managerId")) != null) setManagerId(__getString(val));
		if((val = values.get("manageAuditStatus")) != null) setManageAuditStatus(__getString(val));
		if((val = values.get("designDirectorId")) != null) setDesignDirectorId(__getString(val));
		if((val = values.get("designDirectorAuditStatus")) != null) setDesignDirectorAuditStatus(__getString(val));
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
	}

	protected java.lang.Integer  __contract_stage_model_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.String  __stage_model_name ;
	protected java.lang.String  __manager_id ;
	protected java.lang.String  __manage_audit_status ;
	protected java.lang.String  __design_director_id ;
	protected java.lang.String  __design_director_audit_status ;
	protected java.lang.Integer  __process_status ;
}
