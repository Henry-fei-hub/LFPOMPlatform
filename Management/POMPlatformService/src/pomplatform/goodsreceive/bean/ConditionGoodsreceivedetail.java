package pomplatform.goodsreceive.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionGoodsreceivedetail extends GenericCondition{

	public ConditionGoodsreceivedetail(){
		setParameterCount(5);
	}

	public java.lang.Integer getGoodsReceiveDetailId() {
		return this.__goods_receive_detail_id;
	}

	public void setGoodsReceiveDetailId( java.lang.Integer value ) {
		this.__goods_receive_detail_id = value;
	}

	public java.lang.Integer getGoodsReceiveId() {
		return this.__goods_receive_id;
	}

	public void setGoodsReceiveId( java.lang.Integer value ) {
		this.__goods_receive_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.util.Date getReceiveTime() {
		return this.__receive_time;
	}

	public void setReceiveTime( java.util.Date value ) {
		this.__receive_time = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getGoodsReceiveDetailId() != null) sb.append(__wrapNumber(1, "goodsReceiveDetailId", getGoodsReceiveDetailId()));
		if(getGoodsReceiveId() != null) sb.append(__wrapNumber(1, "goodsReceiveId", getGoodsReceiveId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getReceiveTime() != null) sb.append(__wrapDate(1, "receiveTime", getReceiveTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("goodsReceiveDetailId")) != null) setGoodsReceiveDetailId(__getInt(val)); 
		if((val = values.get("goodsReceiveId")) != null) setGoodsReceiveId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("receiveTime")) != null) setReceiveTime(__getDate(val)); 
	}

	private java.lang.Integer __goods_receive_detail_id = null;
	private java.lang.Integer __goods_receive_id = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __department_id = null;
	private java.util.Date __receive_time = null;
}

