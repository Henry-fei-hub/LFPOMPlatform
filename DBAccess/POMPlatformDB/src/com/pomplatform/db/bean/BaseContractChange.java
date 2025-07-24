package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseContractChange extends GenericBase implements BaseFactory<BaseContractChange>, Comparable<BaseContractChange> 
{


	public static BaseContractChange newInstance(){
		return new BaseContractChange();
	}

	@Override
	public BaseContractChange make(){
		BaseContractChange b = new BaseContractChange();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_CHANGE_ID = "contract_change_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_AMOUNT = "contract_amount" ;
	public final static java.lang.String CS_CONTRACT_CHANGE_AMOUNT = "contract_change_amount" ;
	public final static java.lang.String CS_CONTRACT_FINAL_AMOUNT = "contract_final_amount" ;
	public final static java.lang.String CS_CONTRACT_CHANGE_VIEW = "contract_change_view" ;
	public final static java.lang.String CS_FLAG = "flag" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,合同编码,合同金额,合同变更金额,合同变更后金额,金额变更显示,4已审核),操作人,操作时间,备注";

	public java.lang.Integer getContractChangeId() {
		return this.__contract_change_id;
	}

	public void setContractChangeId( java.lang.Integer value ) {
		this.__contract_change_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.math.BigDecimal getContractAmount() {
		return this.__contract_amount;
	}

	public void setContractAmount( java.math.BigDecimal value ) {
		this.__contract_amount = value;
	}

	public java.math.BigDecimal getContractChangeAmount() {
		return this.__contract_change_amount;
	}

	public void setContractChangeAmount( java.math.BigDecimal value ) {
		this.__contract_change_amount = value;
	}

	public java.math.BigDecimal getContractFinalAmount() {
		return this.__contract_final_amount;
	}

	public void setContractFinalAmount( java.math.BigDecimal value ) {
		this.__contract_final_amount = value;
	}

	public java.lang.String getContractChangeView() {
		return this.__contract_change_view;
	}

	public void setContractChangeView( java.lang.String value ) {
		this.__contract_change_view = value;
	}

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseContractChange __bean){
		__bean.setContractChangeId(getContractChangeId());
		__bean.setContractId(getContractId());
		__bean.setContractAmount(getContractAmount());
		__bean.setContractChangeAmount(getContractChangeAmount());
		__bean.setContractFinalAmount(getContractFinalAmount());
		__bean.setContractChangeView(getContractChangeView());
		__bean.setFlag(getFlag());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractChangeId() == null ? "" : getContractChangeId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getContractAmount() == null ? "" : getContractAmount());
		sb.append(",");
		sb.append(getContractChangeAmount() == null ? "" : getContractChangeAmount());
		sb.append(",");
		sb.append(getContractFinalAmount() == null ? "" : getContractFinalAmount());
		sb.append(",");
		sb.append(getContractChangeView() == null ? "" : getContractChangeView());
		sb.append(",");
		sb.append(getFlag() == null ? "" : getFlag());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractChange o) {
		return __contract_change_id == null ? -1 : __contract_change_id.compareTo(o.getContractChangeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_change_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__contract_change_amount);
		hash = 97 * hash + Objects.hashCode(this.__contract_final_amount);
		hash = 97 * hash + Objects.hashCode(this.__contract_change_view);
		hash = 97 * hash + Objects.hashCode(this.__flag);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractChange o = (BaseContractChange)obj;
		if(!Objects.equals(this.__contract_change_id, o.getContractChangeId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_amount, o.getContractAmount())) return false;
		if(!Objects.equals(this.__contract_change_amount, o.getContractChangeAmount())) return false;
		if(!Objects.equals(this.__contract_final_amount, o.getContractFinalAmount())) return false;
		if(!Objects.equals(this.__contract_change_view, o.getContractChangeView())) return false;
		if(!Objects.equals(this.__flag, o.getFlag())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractChangeId() != null) sb.append(__wrapNumber(count++, "contractChangeId", getContractChangeId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractAmount() != null) sb.append(__wrapDecimal(count++, "contractAmount", getContractAmount()));
		if(getContractChangeAmount() != null) sb.append(__wrapDecimal(count++, "contractChangeAmount", getContractChangeAmount()));
		if(getContractFinalAmount() != null) sb.append(__wrapDecimal(count++, "contractFinalAmount", getContractFinalAmount()));
		if(getContractChangeView() != null) sb.append(__wrapString(count++, "contractChangeView", getContractChangeView()));
		if(getFlag() != null) sb.append(__wrapNumber(count++, "flag", getFlag()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractChangeId")) != null) setContractChangeId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractAmount")) != null) setContractAmount(__getDecimal(val));  
		if((val = values.get("contractChangeAmount")) != null) setContractChangeAmount(__getDecimal(val));  
		if((val = values.get("contractFinalAmount")) != null) setContractFinalAmount(__getDecimal(val));  
		if((val = values.get("contractChangeView")) != null) setContractChangeView(__getString(val));
		if((val = values.get("flag")) != null) setFlag(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __contract_change_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.math.BigDecimal  __contract_amount ;
	protected java.math.BigDecimal  __contract_change_amount ;
	protected java.math.BigDecimal  __contract_final_amount ;
	protected java.lang.String  __contract_change_view ;
	protected java.lang.Integer  __flag ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
}
