package pomplatform.invoice.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionInvoiceVoucher extends GenericCondition{

	public ConditionInvoiceVoucher(){
		setParameterCount(1);
	}

	public java.lang.Integer getInvoiceId() {
		return this.__invoice_id;
	}

	public void setInvoiceId( java.lang.Integer value ) {
		this.__invoice_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getInvoiceId() != null) sb.append(__wrapNumber(1, "invoiceId", getInvoiceId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("invoiceId")) != null) setInvoiceId(__getInt(val)); 
	}

	private java.lang.Integer __invoice_id = null;
}

