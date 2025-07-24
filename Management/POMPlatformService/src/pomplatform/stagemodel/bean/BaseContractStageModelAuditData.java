package pomplatform.stagemodel.bean;

import com.pomplatform.db.bean.BaseContractStageModel;

public class BaseContractStageModelAuditData extends BaseContractStageModel {
	protected java.lang.String businessType;
	protected java.lang.String parentStageName;

	public java.lang.String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(java.lang.String businessType) {
		this.businessType = businessType;
	}

	public java.lang.String getParentStageName() {
		return parentStageName;
	}

	public void setParentStageName(java.lang.String parentStageName) {
		this.parentStageName = parentStageName;
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
		if(getEvidence() != null) sb.append(__wrapString(count++, "evidence", getEvidence()));
		if(getBusinessType() != null) sb.append(__wrapString(count++, "businessType", getBusinessType()));
		if(getParentStageName() != null) sb.append(__wrapString(count++, "parentStageName", getParentStageName()));
		return sb.toString();
	}
}
