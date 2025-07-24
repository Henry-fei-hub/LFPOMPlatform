package pomplatform.ProjectStages.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadProjectStageInProcess extends GenericBase implements BaseFactory<BaseOnLoadProjectStageInProcess>, Comparable<BaseOnLoadProjectStageInProcess> 
{


	public static BaseOnLoadProjectStageInProcess newInstance(){
		return new BaseOnLoadProjectStageInProcess();
	}

	@Override
	public BaseOnLoadProjectStageInProcess make(){
		BaseOnLoadProjectStageInProcess b = new BaseOnLoadProjectStageInProcess();
		return b;
	}

	public final static java.lang.String CS_PROJECT_STAGE_PROCESS_RECORD_ID = "project_stage_process_record_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_AMOUNT_SUM = "project_amount_sum" ;
	public final static java.lang.String CS_APPLY_AMOUNT = "apply_amount" ;
	public final static java.lang.String CS_FILE_ID = "file_id" ;
	public final static java.lang.String CS_FILE_URL = "file_url" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "id,contract_id,main_project_id,项目名称,项目编号,订单积分,本次申请的积分,file_id,file_url,备注";

	public java.lang.Integer getProjectStageProcessRecordId() {
		return this.__project_stage_process_record_id;
	}

	public void setProjectStageProcessRecordId( java.lang.Integer value ) {
		this.__project_stage_process_record_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.math.BigDecimal getProjectAmountSum() {
		return this.__project_amount_sum;
	}

	public void setProjectAmountSum( java.math.BigDecimal value ) {
		this.__project_amount_sum = value;
	}

	public java.math.BigDecimal getApplyAmount() {
		return this.__apply_amount;
	}

	public void setApplyAmount( java.math.BigDecimal value ) {
		this.__apply_amount = value;
	}

	public java.lang.Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( java.lang.Integer value ) {
		this.__file_id = value;
	}

	public java.lang.String getFileUrl() {
		return this.__file_url;
	}

	public void setFileUrl( java.lang.String value ) {
		this.__file_url = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseOnLoadProjectStageInProcess __bean){
		__bean.setProjectStageProcessRecordId(getProjectStageProcessRecordId());
		__bean.setContractId(getContractId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setProjectName(getProjectName());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectAmountSum(getProjectAmountSum());
		__bean.setApplyAmount(getApplyAmount());
		__bean.setFileId(getFileId());
		__bean.setFileUrl(getFileUrl());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectStageProcessRecordId() == null ? "" : getProjectStageProcessRecordId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectAmountSum() == null ? "" : getProjectAmountSum());
		sb.append(",");
		sb.append(getApplyAmount() == null ? "" : getApplyAmount());
		sb.append(",");
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getFileUrl() == null ? "" : getFileUrl());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadProjectStageInProcess o) {
		return __project_stage_process_record_id == null ? -1 : __project_stage_process_record_id.compareTo(o.getProjectStageProcessRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_stage_process_record_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_amount_sum);
		hash = 97 * hash + Objects.hashCode(this.__apply_amount);
		hash = 97 * hash + Objects.hashCode(this.__file_id);
		hash = 97 * hash + Objects.hashCode(this.__file_url);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadProjectStageInProcess o = (BaseOnLoadProjectStageInProcess)obj;
		if(!Objects.equals(this.__project_stage_process_record_id, o.getProjectStageProcessRecordId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_amount_sum, o.getProjectAmountSum())) return false;
		if(!Objects.equals(this.__apply_amount, o.getApplyAmount())) return false;
		if(!Objects.equals(this.__file_id, o.getFileId())) return false;
		if(!Objects.equals(this.__file_url, o.getFileUrl())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectStageProcessRecordId() != null) sb.append(__wrapNumber(count++, "projectStageProcessRecordId", getProjectStageProcessRecordId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectAmountSum() != null) sb.append(__wrapDecimal(count++, "projectAmountSum", getProjectAmountSum()));
		if(getApplyAmount() != null) sb.append(__wrapDecimal(count++, "applyAmount", getApplyAmount()));
		if(getFileId() != null) sb.append(__wrapNumber(count++, "fileId", getFileId()));
		if(getFileUrl() != null) sb.append(__wrapString(count++, "fileUrl", getFileUrl()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectStageProcessRecordId() != null) res.put("projectStageProcessRecordId", getProjectStageProcessRecordId());
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getProjectAmountSum() != null) res.put("projectAmountSum", getProjectAmountSum());
		if(getApplyAmount() != null) res.put("applyAmount", getApplyAmount());
		if(getFileId() != null) res.put("fileId", getFileId());
		if(getFileUrl() != null) res.put("fileUrl", getFileUrl());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectStageProcessRecordId")) != null) setProjectStageProcessRecordId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectAmountSum")) != null) setProjectAmountSum(__getDecimal(val));  
		if((val = values.get("applyAmount")) != null) setApplyAmount(__getDecimal(val));  
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
		if((val = values.get("fileUrl")) != null) setFileUrl(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __project_stage_process_record_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __project_code ;
	protected java.math.BigDecimal  __project_amount_sum ;
	protected java.math.BigDecimal  __apply_amount ;
	protected java.lang.Integer  __file_id ;
	protected java.lang.String  __file_url ;
	protected java.lang.String  __remark ;
}
