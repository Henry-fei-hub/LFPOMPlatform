package pomplatform.stagemodel.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetContractStageModelByParentId extends GenericBase implements BaseFactory<BaseGetContractStageModelByParentId>, Comparable<BaseGetContractStageModelByParentId> 
{


	public static BaseGetContractStageModelByParentId newInstance(){
		return new BaseGetContractStageModelByParentId();
	}

	@Override
	public BaseGetContractStageModelByParentId make(){
		BaseGetContractStageModelByParentId b = new BaseGetContractStageModelByParentId();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_STAGE_MODEL_ID = "contract_stage_model_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_STAGE_MODEL_ID = "stage_model_id" ;
	public final static java.lang.String CS_STAGE_MODEL_NAME = "stage_model_name" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_LEAF_NODE = "leaf_node" ;
	public final static java.lang.String CS_ORDER_NO = "order_no" ;
	public final static java.lang.String CS_NEED_MANAGER_AUDIT = "need_manager_audit" ;
	public final static java.lang.String CS_NEED_DESIGN_DIRECTOR_AUDIT = "need_design_director_audit" ;
	public final static java.lang.String CS_ACTUAL_PERCENT = "actual_percent" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_MANAGER_COMMENT = "manager_comment" ;
	public final static java.lang.String CS_MANAGER_ID = "manager_id" ;
	public final static java.lang.String CS_MANAGER_AUDIT_DATE = "manager_audit_date" ;
	public final static java.lang.String CS_DESIGN_DIRECTOR_COMMENT = "design_director_comment" ;
	public final static java.lang.String CS_DESIGN_DIRECTOR_ID = "design_director_id" ;
	public final static java.lang.String CS_DESIGN_DIRECTOR_AUDIT_DATE = "design_director_audit_date" ;
	public final static java.lang.String CS_LOCKED = "locked" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;
	public final static java.lang.String CS_CONFIRM_DATE = "confirm_date" ;
	public final static java.lang.String CS_HAS_EVIDENCE = "has_evidence" ;
	public final static java.lang.String CS_PATH = "path" ;
	public final static java.lang.String CS_DEPTH = "depth" ;
	public final static java.lang.String CS_EVIDENCE = "evidence" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,合同,阶段小节点模板,名称,阶段百分比,父级,是否为叶子结点,排序序号,需要项目经理审批,需要设计总监审批,累积百分比,备注,项目经理意见,项目经理,项目经理审批日期,设计总监意见,设计总监,设计总监审批日期,是否锁定,流程状态，默认新建，0新建，1运行中，3结束,确认日期,是否取得证据,路径,深度,证据";

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

	public java.lang.Integer getStageModelId() {
		return this.__stage_model_id;
	}

	public void setStageModelId( java.lang.Integer value ) {
		this.__stage_model_id = value;
	}

	public java.lang.String getStageModelName() {
		return this.__stage_model_name;
	}

	public void setStageModelName( java.lang.String value ) {
		this.__stage_model_name = value;
	}

	public java.math.BigDecimal getPercent() {
		return this.__percent;
	}

	public void setPercent( java.math.BigDecimal value ) {
		this.__percent = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Boolean getLeafNode() {
		return this.__leaf_node;
	}

	public void setLeafNode( java.lang.Boolean value ) {
		this.__leaf_node = value;
	}

	public java.lang.Integer getOrderNo() {
		return this.__order_no;
	}

	public void setOrderNo( java.lang.Integer value ) {
		this.__order_no = value;
	}

	public java.lang.Boolean getNeedManagerAudit() {
		return this.__need_manager_audit;
	}

	public void setNeedManagerAudit( java.lang.Boolean value ) {
		this.__need_manager_audit = value;
	}

	public java.lang.Boolean getNeedDesignDirectorAudit() {
		return this.__need_design_director_audit;
	}

	public void setNeedDesignDirectorAudit( java.lang.Boolean value ) {
		this.__need_design_director_audit = value;
	}

	public java.math.BigDecimal getActualPercent() {
		return this.__actual_percent;
	}

	public void setActualPercent( java.math.BigDecimal value ) {
		this.__actual_percent = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getManagerComment() {
		return this.__manager_comment;
	}

	public void setManagerComment( java.lang.String value ) {
		this.__manager_comment = value;
	}

	public java.lang.Integer getManagerId() {
		return this.__manager_id;
	}

	public void setManagerId( java.lang.Integer value ) {
		this.__manager_id = value;
	}

	public java.util.Date getManagerAuditDate() {
		return this.__manager_audit_date;
	}

	public void setManagerAuditDate( java.util.Date value ) {
		this.__manager_audit_date = value;
	}

	public java.lang.String getDesignDirectorComment() {
		return this.__design_director_comment;
	}

	public void setDesignDirectorComment( java.lang.String value ) {
		this.__design_director_comment = value;
	}

	public java.lang.Integer getDesignDirectorId() {
		return this.__design_director_id;
	}

	public void setDesignDirectorId( java.lang.Integer value ) {
		this.__design_director_id = value;
	}

	public java.util.Date getDesignDirectorAuditDate() {
		return this.__design_director_audit_date;
	}

	public void setDesignDirectorAuditDate( java.util.Date value ) {
		this.__design_director_audit_date = value;
	}

	public java.lang.Boolean getLocked() {
		return this.__locked;
	}

	public void setLocked( java.lang.Boolean value ) {
		this.__locked = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.util.Date getConfirmDate() {
		return this.__confirm_date;
	}

	public void setConfirmDate( java.util.Date value ) {
		this.__confirm_date = value;
	}

	public java.lang.Boolean getHasEvidence() {
		return this.__has_evidence;
	}

	public void setHasEvidence( java.lang.Boolean value ) {
		this.__has_evidence = value;
	}

	public java.lang.Integer[] getPath() {
		return (Integer[]) this.__path;
	}

	public void setPath( java.lang.Object value ) {
		this.__path = value;
	}

	public java.lang.Integer getDepth() {
		return this.__depth;
	}

	public void setDepth( java.lang.Integer value ) {
		this.__depth = value;
	}

	public java.lang.String getEvidence() {
		return __evidence;
	}

	public void setEvidence(java.lang.String value) {
		this.__evidence = value;
	}

	public java.lang.Integer getYear() {
		return __year;
	}

	public void setYear(java.lang.Integer __year) {
		this.__year = __year;
	}

	public void cloneCopy(BaseGetContractStageModelByParentId __bean){
		__bean.setContractStageModelId(getContractStageModelId());
		__bean.setContractId(getContractId());
		__bean.setStageModelId(getStageModelId());
		__bean.setStageModelName(getStageModelName());
		__bean.setPercent(getPercent());
		__bean.setParentId(getParentId());
		__bean.setLeafNode(getLeafNode());
		__bean.setOrderNo(getOrderNo());
		__bean.setNeedManagerAudit(getNeedManagerAudit());
		__bean.setNeedDesignDirectorAudit(getNeedDesignDirectorAudit());
		__bean.setActualPercent(getActualPercent());
		__bean.setRemark(getRemark());
		__bean.setManagerComment(getManagerComment());
		__bean.setManagerId(getManagerId());
		__bean.setManagerAuditDate(getManagerAuditDate());
		__bean.setDesignDirectorComment(getDesignDirectorComment());
		__bean.setDesignDirectorId(getDesignDirectorId());
		__bean.setDesignDirectorAuditDate(getDesignDirectorAuditDate());
		__bean.setLocked(getLocked());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setConfirmDate(getConfirmDate());
		__bean.setHasEvidence(getHasEvidence());
		__bean.setPath(getPath());
		__bean.setDepth(getDepth());
		__bean.setEvidence(getEvidence());
		__bean.setYear(getYear());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractStageModelId() == null ? "" : getContractStageModelId());
		sb.append(",");
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		sb.append(getStageModelId() == null ? "" : getStageModelId());
		sb.append(",");
		sb.append(getStageModelName() == null ? "" : getStageModelName());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		sb.append(",");
		String strParentId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts_1", String.valueOf(getParentId()));
		sb.append(strParentId == null ? "" : strParentId);
		sb.append(",");
		sb.append(getLeafNode() == null ? "" : getLeafNode());
		sb.append(",");
		sb.append(getOrderNo() == null ? "" : getOrderNo());
		sb.append(",");
		sb.append(getNeedManagerAudit() == null ? "" : getNeedManagerAudit());
		sb.append(",");
		sb.append(getNeedDesignDirectorAudit() == null ? "" : getNeedDesignDirectorAudit());
		sb.append(",");
		sb.append(getActualPercent() == null ? "" : getActualPercent());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getManagerComment() == null ? "" : getManagerComment());
		sb.append(",");
		sb.append(getManagerId() == null ? "" : getManagerId());
		sb.append(",");
		sb.append(getManagerAuditDate() == null ? "" : sdf.format(getManagerAuditDate()));
		sb.append(",");
		sb.append(getDesignDirectorComment() == null ? "" : getDesignDirectorComment());
		sb.append(",");
		sb.append(getDesignDirectorId() == null ? "" : getDesignDirectorId());
		sb.append(",");
		sb.append(getDesignDirectorAuditDate() == null ? "" : sdf.format(getDesignDirectorAuditDate()));
		sb.append(",");
		sb.append(getLocked() == null ? "" : getLocked());
		sb.append(",");
		String strProcessStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_120", String.valueOf(getProcessStatus()));
		sb.append(strProcessStatus == null ? "" : strProcessStatus);
		sb.append(",");
		sb.append(getConfirmDate() == null ? "" : sdf.format(getConfirmDate()));
		sb.append(",");
		sb.append(getHasEvidence() == null ? "" : getHasEvidence());
		sb.append(",");
		sb.append(getPath() == null ? "" : getPath());
		sb.append(",");
		sb.append(getDepth() == null ? "" : getDepth());
		sb.append(",");
		sb.append(getEvidence() == null ? "" : getEvidence());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetContractStageModelByParentId o) {
		return __contract_stage_model_id == null ? -1 : __contract_stage_model_id.compareTo(o.getContractStageModelId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_stage_model_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_model_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_model_name);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__leaf_node);
		hash = 97 * hash + Objects.hashCode(this.__order_no);
		hash = 97 * hash + Objects.hashCode(this.__need_manager_audit);
		hash = 97 * hash + Objects.hashCode(this.__need_design_director_audit);
		hash = 97 * hash + Objects.hashCode(this.__actual_percent);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__manager_comment);
		hash = 97 * hash + Objects.hashCode(this.__manager_id);
		hash = 97 * hash + Objects.hashCode(this.__manager_audit_date);
		hash = 97 * hash + Objects.hashCode(this.__design_director_comment);
		hash = 97 * hash + Objects.hashCode(this.__design_director_id);
		hash = 97 * hash + Objects.hashCode(this.__design_director_audit_date);
		hash = 97 * hash + Objects.hashCode(this.__locked);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		hash = 97 * hash + Objects.hashCode(this.__confirm_date);
		hash = 97 * hash + Objects.hashCode(this.__has_evidence);
		hash = 97 * hash + Objects.hashCode(this.__path);
		hash = 97 * hash + Objects.hashCode(this.__depth);
		hash = 97 * hash + Objects.hashCode(this.__evidence);
		hash = 97 * hash + Objects.hashCode(this.__year);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetContractStageModelByParentId o = (BaseGetContractStageModelByParentId)obj;
		if(!Objects.equals(this.__contract_stage_model_id, o.getContractStageModelId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__stage_model_id, o.getStageModelId())) return false;
		if(!Objects.equals(this.__stage_model_name, o.getStageModelName())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__leaf_node, o.getLeafNode())) return false;
		if(!Objects.equals(this.__order_no, o.getOrderNo())) return false;
		if(!Objects.equals(this.__need_manager_audit, o.getNeedManagerAudit())) return false;
		if(!Objects.equals(this.__need_design_director_audit, o.getNeedDesignDirectorAudit())) return false;
		if(!Objects.equals(this.__actual_percent, o.getActualPercent())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__manager_comment, o.getManagerComment())) return false;
		if(!Objects.equals(this.__manager_id, o.getManagerId())) return false;
		if(!Objects.equals(this.__manager_audit_date, o.getManagerAuditDate())) return false;
		if(!Objects.equals(this.__design_director_comment, o.getDesignDirectorComment())) return false;
		if(!Objects.equals(this.__design_director_id, o.getDesignDirectorId())) return false;
		if(!Objects.equals(this.__design_director_audit_date, o.getDesignDirectorAuditDate())) return false;
		if(!Objects.equals(this.__locked, o.getLocked())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__confirm_date, o.getConfirmDate())) return false;
		if(!Objects.equals(this.__has_evidence, o.getHasEvidence())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__path, o.getPath())) return false;
		if(!Objects.equals(this.__depth, o.getDepth())) return false;
		if(!Objects.equals(this.__evidence, o.getEvidence())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractStageModelId() != null) sb.append(__wrapNumber(count++, "contractStageModelId", getContractStageModelId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getStageModelId() != null) sb.append(__wrapNumber(count++, "stageModelId", getStageModelId()));
		if(getStageModelName() != null) sb.append(__wrapString(count++, "stageModelName", getStageModelName()));
		if(getPercent() != null) sb.append(__wrapDecimal(count++, "percent", getPercent()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getLeafNode() != null) sb.append(__wrapBoolean(count++, "leafNode", getLeafNode()));
		if(getOrderNo() != null) sb.append(__wrapNumber(count++, "orderNo", getOrderNo()));
		if(getNeedManagerAudit() != null) sb.append(__wrapBoolean(count++, "needManagerAudit", getNeedManagerAudit()));
		if(getNeedDesignDirectorAudit() != null) sb.append(__wrapBoolean(count++, "needDesignDirectorAudit", getNeedDesignDirectorAudit()));
		if(getActualPercent() != null) sb.append(__wrapDecimal(count++, "actualPercent", getActualPercent()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getManagerComment() != null) sb.append(__wrapString(count++, "managerComment", getManagerComment()));
		if(getManagerId() != null) sb.append(__wrapNumber(count++, "managerId", getManagerId()));
		if(getManagerAuditDate() != null) sb.append(__wrapDate(count++, "managerAuditDate", getManagerAuditDate()));
		if(getDesignDirectorComment() != null) sb.append(__wrapString(count++, "designDirectorComment", getDesignDirectorComment()));
		if(getDesignDirectorId() != null) sb.append(__wrapNumber(count++, "designDirectorId", getDesignDirectorId()));
		if(getDesignDirectorAuditDate() != null) sb.append(__wrapDate(count++, "designDirectorAuditDate", getDesignDirectorAuditDate()));
		if(getLocked() != null) sb.append(__wrapBoolean(count++, "locked", getLocked()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		if(getConfirmDate() != null) sb.append(__wrapDate(count++, "confirmDate", getConfirmDate()));
		if(getHasEvidence() != null) sb.append(__wrapBoolean(count++, "hasEvidence", getHasEvidence()));
		if(getPath() != null) sb.append(__wrapString(count++, "path", getPath().toString()));
		if(getDepth() != null) sb.append(__wrapNumber(count++, "depth", getDepth()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getEvidence() != null) sb.append(__wrapString(count++, "evidence", getEvidence()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractStageModelId")) != null) setContractStageModelId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("stageModelId")) != null) setStageModelId(__getInt(val)); 
		if((val = values.get("stageModelName")) != null) setStageModelName(__getString(val));
		if((val = values.get("percent")) != null) setPercent(__getDecimal(val));  
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("leafNode")) != null) setLeafNode(__getBoolean(val));
		if((val = values.get("orderNo")) != null) setOrderNo(__getInt(val)); 
		if((val = values.get("needManagerAudit")) != null) setNeedManagerAudit(__getBoolean(val));
		if((val = values.get("needDesignDirectorAudit")) != null) setNeedDesignDirectorAudit(__getBoolean(val));
		if((val = values.get("actualPercent")) != null) setActualPercent(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("managerComment")) != null) setManagerComment(__getString(val));
		if((val = values.get("managerId")) != null) setManagerId(__getInt(val)); 
		if((val = values.get("managerAuditDate")) != null) setManagerAuditDate(__getDate(val)); 
		if((val = values.get("designDirectorComment")) != null) setDesignDirectorComment(__getString(val));
		if((val = values.get("designDirectorId")) != null) setDesignDirectorId(__getInt(val)); 
		if((val = values.get("designDirectorAuditDate")) != null) setDesignDirectorAuditDate(__getDate(val)); 
		if((val = values.get("locked")) != null) setLocked(__getBoolean(val));
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("confirmDate")) != null) setConfirmDate(__getDate(val)); 
		if((val = values.get("hasEvidence")) != null) setHasEvidence(__getBoolean(val));
		if((val = values.get("path")) != null) setPath(__getString(val));
		if((val = values.get("depth")) != null) setDepth(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("evidence")) != null) setEvidence(__getString(val));
	}

	protected java.lang.Integer  __contract_stage_model_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __stage_model_id ;
	protected java.lang.String  __stage_model_name ;
	protected java.math.BigDecimal  __percent ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Boolean  __leaf_node ;
	protected java.lang.Integer  __order_no ;
	protected java.lang.Boolean  __need_manager_audit ;
	protected java.lang.Boolean  __need_design_director_audit ;
	protected java.math.BigDecimal  __actual_percent ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __manager_comment ;
	protected java.lang.Integer  __manager_id ;
	protected java.util.Date  __manager_audit_date ;
	protected java.lang.String  __design_director_comment ;
	protected java.lang.Integer  __design_director_id ;
	protected java.util.Date  __design_director_audit_date ;
	protected java.lang.Boolean  __locked ;
	protected java.lang.Integer  __process_status ;
	protected java.util.Date  __confirm_date ;
	protected java.lang.Boolean  __has_evidence ;
	protected java.lang.Integer  __year ;
	protected java.lang.Object  __path ;
	protected java.lang.Integer  __depth ;
	protected java.lang.String  __evidence ;
}
