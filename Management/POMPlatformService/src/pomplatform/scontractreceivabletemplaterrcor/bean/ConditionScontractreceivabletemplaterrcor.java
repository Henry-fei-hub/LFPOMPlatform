package pomplatform.scontractreceivabletemplaterrcor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionScontractreceivabletemplaterrcor extends GenericCondition{

	public ConditionScontractreceivabletemplaterrcor(){
		setParameterCount(5);
	}

	public java.lang.String getReceivableName() {
		return this.__receivable_name == null ? null : (this.__receivable_name.indexOf("%") >= 0 ? this.__receivable_name : "%"+this.__receivable_name+"%");
	}

	public void setReceivableName( java.lang.String value ) {
		this.__receivable_name = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getContractReceivableTemplateId() {
		return this.__contract_receivable_template_id;
	}

	public void setContractReceivableTemplateId( java.lang.Integer value ) {
		this.__contract_receivable_template_id = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getReceivableName() != null) sb.append(__wrapString(1, "receivableName", getReceivableName()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getContractReceivableTemplateId() != null) sb.append(__wrapNumber(1, "contractReceivableTemplateId", getContractReceivableTemplateId()));
		if(getParentId() != null) sb.append(__wrapNumber(1, "parentId", getParentId()));
		if(getOperator() != null) sb.append(__wrapNumber(1, "operator", getOperator()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("receivableName")) != null) setReceivableName(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("contractReceivableTemplateId")) != null) setContractReceivableTemplateId(__getInt(val)); 
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
	}

	private java.lang.String __receivable_name = null;
	private java.lang.String __remark = null;
	private java.lang.Integer __contract_receivable_template_id = null;
	private java.lang.Integer __parent_id = null;
	private java.lang.Integer __operator = null;
}

