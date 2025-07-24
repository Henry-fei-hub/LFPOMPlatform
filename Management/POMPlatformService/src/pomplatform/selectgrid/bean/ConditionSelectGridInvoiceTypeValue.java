package pomplatform.selectgrid.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSelectGridInvoiceTypeValue extends GenericCondition{

	public ConditionSelectGridInvoiceTypeValue(){
		setParameterCount(3);
	}

	public java.lang.String getTypeName() {
		return this.__type_name == null ? null : (this.__type_name.indexOf("%") >= 0 ? this.__type_name : "%"+this.__type_name+"%");
	}

	public void setTypeName( java.lang.String value ) {
		this.__type_name = value;
	}

	public java.lang.String getSubtractRemark() {
		return this.__subtract_remark == null ? null : (this.__subtract_remark.indexOf("%") >= 0 ? this.__subtract_remark : "%"+this.__subtract_remark+"%");
	}

	public void setSubtractRemark( java.lang.String value ) {
		this.__subtract_remark = value;
	}

	public java.lang.Integer getInvoiceTypeId() {
		return this.__invoice_type_id;
	}

	public void setInvoiceTypeId( java.lang.Integer value ) {
		this.__invoice_type_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getTypeName() != null) sb.append(__wrapString(1, "typeName", getTypeName()));
		if(getSubtractRemark() != null) sb.append(__wrapString(1, "subtractRemark", getSubtractRemark()));
		if(getInvoiceTypeId() != null) sb.append(__wrapNumber(1, "invoiceTypeId", getInvoiceTypeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("typeName")) != null) setTypeName(__getString(val));
		if((val = values.get("subtractRemark")) != null) setSubtractRemark(__getString(val));
		if((val = values.get("invoiceTypeId")) != null) setInvoiceTypeId(__getInt(val)); 
	}

	private java.lang.String __type_name = null;
	private java.lang.String __subtract_remark = null;
	private java.lang.Integer __invoice_type_id = null;
}

