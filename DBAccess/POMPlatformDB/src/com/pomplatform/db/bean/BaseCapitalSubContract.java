package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCapitalSubContract extends GenericBase implements BaseFactory<BaseCapitalSubContract>, Comparable<BaseCapitalSubContract> 
{


	public static BaseCapitalSubContract newInstance(){
		return new BaseCapitalSubContract();
	}

	@Override
	public BaseCapitalSubContract make(){
		BaseCapitalSubContract b = new BaseCapitalSubContract();
		return b;
	}

	public final static java.lang.String CS_CAPITAL_SUB_CONTRACT_ID = "capital_sub_contract_id" ;
	public final static java.lang.String CS_CAPITAL_ID = "capital_id" ;
	public final static java.lang.String CS_SUB_CONTRACT_ID = "sub_contract_id" ;
	public final static java.lang.String CS_MONEY = "money" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_CREAT_TIME = "creat_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,回款编码,子订单编码,金额,操作人,创建时间";

	public java.lang.Integer getCapitalSubContractId() {
		return this.__capital_sub_contract_id;
	}

	public void setCapitalSubContractId( java.lang.Integer value ) {
		this.__capital_sub_contract_id = value;
	}

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	public java.lang.Integer getSubContractId() {
		return this.__sub_contract_id;
	}

	public void setSubContractId( java.lang.Integer value ) {
		this.__sub_contract_id = value;
	}

	public java.math.BigDecimal getMoney() {
		return this.__money;
	}

	public void setMoney( java.math.BigDecimal value ) {
		this.__money = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.util.Date getCreatTime() {
		return this.__creat_time;
	}

	public void setCreatTime( java.util.Date value ) {
		this.__creat_time = value;
	}

	public void cloneCopy(BaseCapitalSubContract __bean){
		__bean.setCapitalSubContractId(getCapitalSubContractId());
		__bean.setCapitalId(getCapitalId());
		__bean.setSubContractId(getSubContractId());
		__bean.setMoney(getMoney());
		__bean.setOperatorId(getOperatorId());
		__bean.setCreatTime(getCreatTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCapitalSubContractId() == null ? "" : getCapitalSubContractId());
		sb.append(",");
		sb.append(getCapitalId() == null ? "" : getCapitalId());
		sb.append(",");
		sb.append(getSubContractId() == null ? "" : getSubContractId());
		sb.append(",");
		sb.append(getMoney() == null ? "" : getMoney());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getCreatTime() == null ? "" : sdf.format(getCreatTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCapitalSubContract o) {
		return __capital_sub_contract_id == null ? -1 : __capital_sub_contract_id.compareTo(o.getCapitalSubContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__capital_sub_contract_id);
		hash = 97 * hash + Objects.hashCode(this.__capital_id);
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_id);
		hash = 97 * hash + Objects.hashCode(this.__money);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__creat_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCapitalSubContract o = (BaseCapitalSubContract)obj;
		if(!Objects.equals(this.__capital_sub_contract_id, o.getCapitalSubContractId())) return false;
		if(!Objects.equals(this.__capital_id, o.getCapitalId())) return false;
		if(!Objects.equals(this.__sub_contract_id, o.getSubContractId())) return false;
		if(!Objects.equals(this.__money, o.getMoney())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__creat_time, o.getCreatTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCapitalSubContractId() != null) sb.append(__wrapNumber(count++, "capitalSubContractId", getCapitalSubContractId()));
		if(getCapitalId() != null) sb.append(__wrapNumber(count++, "capitalId", getCapitalId()));
		if(getSubContractId() != null) sb.append(__wrapNumber(count++, "subContractId", getSubContractId()));
		if(getMoney() != null) sb.append(__wrapDecimal(count++, "money", getMoney()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getCreatTime() != null) sb.append(__wrapDate(count++, "creatTime", getCreatTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("capitalSubContractId")) != null) setCapitalSubContractId(__getInt(val)); 
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("subContractId")) != null) setSubContractId(__getInt(val)); 
		if((val = values.get("money")) != null) setMoney(__getDecimal(val));  
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("creatTime")) != null) setCreatTime(__getDate(val)); 
	}

	protected java.lang.Integer  __capital_sub_contract_id ;
	protected java.lang.Integer  __capital_id ;
	protected java.lang.Integer  __sub_contract_id ;
	protected java.math.BigDecimal  __money ;
	protected java.lang.Integer  __operator_id ;
	protected java.util.Date  __creat_time ;
}
