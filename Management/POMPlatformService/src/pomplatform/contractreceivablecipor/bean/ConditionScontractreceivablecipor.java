package pomplatform.contractreceivablecipor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionScontractreceivablecipor extends GenericCondition{

	public ConditionScontractreceivablecipor(){
		setParameterCount(9);
	}

	public java.lang.Integer getContractReceivableId() {
		return this.__contract_receivable_id;
	}

	public void setContractReceivableId( java.lang.Integer value ) {
		this.__contract_receivable_id = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code == null ? null : (this.__info_code.indexOf("%") >= 0 ? this.__info_code : "%"+this.__info_code+"%");
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code == null ? null : (this.__project_code.indexOf("%") >= 0 ? this.__project_code : "%"+this.__project_code+"%");
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getReceivableName() {
		return this.__receivable_name == null ? null : (this.__receivable_name.indexOf("%") >= 0 ? this.__receivable_name : "%"+this.__receivable_name+"%");
	}

	public void setReceivableName( java.lang.String value ) {
		this.__receivable_name = value;
	}

	public java.lang.Boolean getIsConfirmationLetter() {
		return this.__is_confirmation_letter;
	}

	public void setIsConfirmationLetter( java.lang.Boolean value ) {
		this.__is_confirmation_letter = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractReceivableId() != null) sb.append(__wrapNumber(1, "contractReceivableId", getContractReceivableId()));
		if(getInfoCode() != null) sb.append(__wrapString(1, "infoCode", getInfoCode()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getReceivableName() != null) sb.append(__wrapString(1, "receivableName", getReceivableName()));
		if(getIsConfirmationLetter() != null) sb.append(__wrapBoolean(1, "isConfirmationLetter", getIsConfirmationLetter()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getParentId() != null) sb.append(__wrapNumber(1, "parentId", getParentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractReceivableId")) != null) setContractReceivableId(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("receivableName")) != null) setReceivableName(__getString(val));
		if((val = values.get("isConfirmationLetter")) != null) setIsConfirmationLetter(__getBoolean(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
	}

	private java.lang.Integer __contract_receivable_id = null;
	private java.lang.String __info_code = null;
	private java.lang.String __project_code = null;
	private java.lang.Integer __contract_id = null;
	private java.lang.String __contract_code = null;
	private java.lang.String __receivable_name = null;
	private java.lang.Boolean __is_confirmation_letter = null;
	private java.lang.String __remark = null;
	private java.lang.Integer __parent_id = null;
}

