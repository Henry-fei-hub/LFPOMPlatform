package pomplatform.workflow.purchase.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSproductinquirytotalpor extends GenericCondition{

	public ConditionSproductinquirytotalpor(){
		setParameterCount(1);
	}

	public java.lang.Integer getProductInquiryTotalId() {
		return this.__product_inquiry_total_id;
	}

	public void setProductInquiryTotalId( java.lang.Integer value ) {
		this.__product_inquiry_total_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProductInquiryTotalId() != null) sb.append(__wrapNumber(1, "productInquiryTotalId", getProductInquiryTotalId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("productInquiryTotalId")) != null) setProductInquiryTotalId(__getInt(val)); 
	}

	private java.lang.Integer __product_inquiry_total_id = null;
}

