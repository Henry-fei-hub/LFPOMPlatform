package pomplatform.goodsreceive.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionGoodsreceive extends GenericCondition{

	public ConditionGoodsreceive(){
		setParameterCount(5);
	}

	public java.lang.Integer getGoodsReceiveId() {
		return this.__goods_receive_id;
	}

	public void setGoodsReceiveId( java.lang.Integer value ) {
		this.__goods_receive_id = value;
	}

	public java.lang.String getSubject() {
		return this.__subject;
	}

	public void setSubject( java.lang.String value ) {
		this.__subject = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getReceiveDate() {
		return this.__receive_date;
	}

	public void setReceiveDate( java.util.Date value ) {
		this.__receive_date = value;
	}

	public java.lang.Integer getReceiveCount() {
		return this.__receive_count;
	}

	public void setReceiveCount( java.lang.Integer value ) {
		this.__receive_count = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getGoodsReceiveId() != null) sb.append(__wrapNumber(1, "goodsReceiveId", getGoodsReceiveId()));
		if(getSubject() != null) sb.append(__wrapString(1, "subject", getSubject()));
		if(getCreateTime() != null) sb.append(__wrapDate(1, "createTime", getCreateTime()));
		if(getReceiveDate() != null) sb.append(__wrapDate(1, "receiveDate", getReceiveDate()));
		if(getReceiveCount() != null) sb.append(__wrapNumber(1, "receiveCount", getReceiveCount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("goodsReceiveId")) != null) setGoodsReceiveId(__getInt(val)); 
		if((val = values.get("subject")) != null) setSubject(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("receiveDate")) != null) setReceiveDate(__getDate(val)); 
		if((val = values.get("receiveCount")) != null) setReceiveCount(__getInt(val)); 
	}

	private java.lang.Integer __goods_receive_id = null;
	private java.lang.String __subject = null;
	private java.util.Date __create_time = null;
	private java.util.Date __receive_date = null;
	private java.lang.Integer __receive_count = null;
}

