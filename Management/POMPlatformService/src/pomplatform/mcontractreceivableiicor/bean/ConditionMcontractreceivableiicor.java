package pomplatform.mcontractreceivableiicor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMcontractreceivableiicor extends GenericCondition{

	public ConditionMcontractreceivableiicor(){
		setParameterCount(2);
	}

	public java.lang.Integer getInvoiceApplyId() {
		return this.__invoice_apply_id;
	}

	public void setInvoiceApplyId( java.lang.Integer value ) {
		this.__invoice_apply_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getInvoiceApplyId() != null) sb.append(__wrapNumber(1, "invoiceApplyId", getInvoiceApplyId()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("invoiceApplyId")) != null) setInvoiceApplyId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
	}

	private java.lang.Integer __invoice_apply_id = null;
	private java.lang.Integer __contract_id = null;
}

