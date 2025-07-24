package pomplatform.poolmanage.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnloadPoolData extends GenericCondition{

	public ConditionOnloadPoolData(){
		setParameterCount(4);
	}

	public java.lang.String getPoolName() {
		return this.__pool_name == null ? null : (this.__pool_name.indexOf("%") >= 0 ? this.__pool_name : "%"+this.__pool_name+"%");
	}

	public void setPoolName( java.lang.String value ) {
		this.__pool_name = value;
	}

	public java.lang.Integer getRegion() {
		return this.__region;
	}

	public void setRegion( java.lang.Integer value ) {
		this.__region = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public java.lang.Integer getPoolType() {
		return this.__pool_type;
	}

	public void setPoolType( java.lang.Integer value ) {
		this.__pool_type = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPoolName() != null) sb.append(__wrapString(1, "poolName", getPoolName()));
		if(getRegion() != null) sb.append(__wrapNumber(1, "region", getRegion()));
		if(getBusinessType() != null) sb.append(__wrapNumber(1, "businessType", getBusinessType()));
		if(getPoolType() != null) sb.append(__wrapNumber(1, "poolType", getPoolType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("poolName")) != null) setPoolName(__getString(val));
		if((val = values.get("region")) != null) setRegion(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("poolType")) != null) setPoolType(__getInt(val)); 
	}

	private java.lang.String __pool_name = null;
	private java.lang.Integer __region = null;
	private java.lang.Integer __business_type = null;
	private java.lang.Integer __pool_type = null;
}

