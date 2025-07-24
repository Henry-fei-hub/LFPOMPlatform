package pomplatform.poolmanage.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnloadPoolData extends GenericBase implements BaseFactory<BaseOnloadPoolData>, Comparable<BaseOnloadPoolData> 
{


	public static BaseOnloadPoolData newInstance(){
		return new BaseOnloadPoolData();
	}

	@Override
	public BaseOnloadPoolData make(){
		BaseOnloadPoolData b = new BaseOnloadPoolData();
		return b;
	}

	public final static java.lang.String CS_POOL_MANAGE_ID = "pool_manage_id" ;
	public final static java.lang.String CS_POOL_NAME = "pool_name" ;
	public final static java.lang.String CS_REGION = "region" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_POOL_TYPE = "pool_type" ;
	public final static java.lang.String CS_POOL_EMPLOYEES = "pool_employees" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "池子id,池子名称,地区id,业态,池子类型对应字典表234,成员,备注";

	public java.lang.Integer getPoolManageId() {
		return this.__pool_manage_id;
	}

	public void setPoolManageId( java.lang.Integer value ) {
		this.__pool_manage_id = value;
	}

	public java.lang.String getPoolName() {
		return this.__pool_name;
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

	public java.lang.String getPoolEmployees() {
		return this.__pool_employees;
	}

	public void setPoolEmployees( java.lang.String value ) {
		this.__pool_employees = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseOnloadPoolData __bean){
		__bean.setPoolManageId(getPoolManageId());
		__bean.setPoolName(getPoolName());
		__bean.setRegion(getRegion());
		__bean.setBusinessType(getBusinessType());
		__bean.setPoolType(getPoolType());
		__bean.setPoolEmployees(getPoolEmployees());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPoolManageId() == null ? "" : getPoolManageId());
		sb.append(",");
		sb.append(getPoolName() == null ? "" : getPoolName());
		sb.append(",");
		String strRegion = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_170", String.valueOf(getRegion()));
		sb.append(strRegion == null ? "" : strRegion);
		sb.append(",");
		String strBusinessType = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getBusinessType()));
		sb.append(strBusinessType == null ? "" : strBusinessType);
		sb.append(",");
		sb.append(getPoolType() == null ? "" : getPoolType());
		sb.append(",");
		sb.append(getPoolEmployees() == null ? "" : getPoolEmployees());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnloadPoolData o) {
		return __pool_manage_id == null ? -1 : __pool_manage_id.compareTo(o.getPoolManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__pool_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__pool_name);
		hash = 97 * hash + Objects.hashCode(this.__region);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__pool_type);
		hash = 97 * hash + Objects.hashCode(this.__pool_employees);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnloadPoolData o = (BaseOnloadPoolData)obj;
		if(!Objects.equals(this.__pool_manage_id, o.getPoolManageId())) return false;
		if(!Objects.equals(this.__pool_name, o.getPoolName())) return false;
		if(!Objects.equals(this.__region, o.getRegion())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__pool_type, o.getPoolType())) return false;
		if(!Objects.equals(this.__pool_employees, o.getPoolEmployees())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPoolManageId() != null) sb.append(__wrapNumber(count++, "poolManageId", getPoolManageId()));
		if(getPoolName() != null) sb.append(__wrapString(count++, "poolName", getPoolName()));
		if(getRegion() != null) sb.append(__wrapNumber(count++, "region", getRegion()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getPoolType() != null) sb.append(__wrapNumber(count++, "poolType", getPoolType()));
		if(getPoolEmployees() != null) sb.append(__wrapString(count++, "poolEmployees", getPoolEmployees()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPoolManageId() != null) res.put("poolManageId", getPoolManageId());
		if(getPoolName() != null) res.put("poolName", getPoolName());
		if(getRegion() != null) res.put("region", getRegion());
		if(getBusinessType() != null) res.put("businessType", getBusinessType());
		if(getPoolType() != null) res.put("poolType", getPoolType());
		if(getPoolEmployees() != null) res.put("poolEmployees", getPoolEmployees());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("poolManageId")) != null) setPoolManageId(__getInt(val)); 
		if((val = values.get("poolName")) != null) setPoolName(__getString(val));
		if((val = values.get("region")) != null) setRegion(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("poolType")) != null) setPoolType(__getInt(val)); 
		if((val = values.get("poolEmployees")) != null) setPoolEmployees(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __pool_manage_id ;
	protected java.lang.String  __pool_name ;
	protected java.lang.Integer  __region ;
	protected java.lang.Integer  __business_type ;
	protected java.lang.Integer  __pool_type ;
	protected java.lang.String  __pool_employees ;
	protected java.lang.String  __remark ;
}
