package com.pomplatform.db.bean;

public class CustomBaseCapitalDistribution extends BaseCapitalDistribution  
{
	

	public static CustomBaseCapitalDistribution newInstance(){
		return new CustomBaseCapitalDistribution();
	}

	@Override
	public CustomBaseCapitalDistribution make(){
		CustomBaseCapitalDistribution b = new CustomBaseCapitalDistribution();
		return b;
	}

	public java.lang.String getCode() {
		return __code;
	}

	public void setCode(java.lang.String value) {
		this.__code = value;
	}

	public java.math.BigDecimal getLeftAmount() {
		return __left_amount;
	}

	public void setLeftAmount(java.math.BigDecimal value) {
		this.__left_amount = value;
	}

	public java.lang.Integer getPlateId() {
		return __plate_id;
	}

	public void setPlateId(java.lang.Integer value) {
		this.__plate_id = value;
	}
	
	public java.math.BigDecimal getSheetAmount() {
		return __sheet_amount;
	}

	public void setSheetAmount(java.math.BigDecimal value) {
		this.__sheet_amount = value;
	}

	public java.math.BigDecimal getDistributedAmount() {
		return __distributed_amount;
	}

	public void setDistributedAmount(java.math.BigDecimal value) {
		this.__distributed_amount = value;
	}

	public java.math.BigDecimal getProjectIntegral() {
		return __project_integral;
	}

	public void setProjectIntegral(java.math.BigDecimal value) {
		this.__project_integral = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return __sure_integral;
	}

	public void setSureIntegral(java.math.BigDecimal value) {
		this.__sure_integral = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCapitalDistributionId() != null) sb.append(__wrapNumber(count++, "capitalDistributionId", getCapitalDistributionId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getCapitalId() != null) sb.append(__wrapNumber(count++, "capitalId", getCapitalId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getTotalAmount() != null) sb.append(__wrapDecimal(count++, "totalAmount", getTotalAmount()));
		if(getDistributionAmount() != null) sb.append(__wrapDecimal(count++, "distributionAmount", getDistributionAmount()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getLocked() != null) sb.append(__wrapBoolean(count++, "locked", getLocked()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getLeftAmount() != null) sb.append(__wrapDecimal(count++, "leftAmount", getLeftAmount()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getSheetAmount() != null) sb.append(__wrapDecimal(count++, "sheetAmount", getSheetAmount()));
		if(getDistributedAmount() != null) sb.append(__wrapDecimal(count++, "distributedAmount", getDistributedAmount()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		
		return sb.toString();
	}

	protected java.lang.String  __code ;
	protected java.math.BigDecimal  __left_amount ;
	protected java.lang.Integer __plate_id;
	protected java.math.BigDecimal __sheet_amount;
	protected java.math.BigDecimal __distributed_amount;
	protected java.math.BigDecimal __project_integral;
	protected java.math.BigDecimal __sure_integral;
}
