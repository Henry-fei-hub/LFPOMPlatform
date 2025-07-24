package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseRankFactorMaintenance extends GenericBase implements BaseFactory<BaseRankFactorMaintenance>, Comparable<BaseRankFactorMaintenance> 
{


	public static BaseRankFactorMaintenance newInstance(){
		return new BaseRankFactorMaintenance();
	}

	@Override
	public BaseRankFactorMaintenance make(){
		BaseRankFactorMaintenance b = new BaseRankFactorMaintenance();
		return b;
	}

	public final static java.lang.String CS_RANK_FACTOR_MAINTENANCE_ID = "rank_factor_maintenance_id" ;
	public final static java.lang.String CS_RANK_ID = "rank_id" ;
	public final static java.lang.String CS_COEFFICIENT = "coefficient" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "员工职级系数维护,职级编码,职级系数,创建时间,备注";

	public java.lang.Integer getRankFactorMaintenanceId() {
		return this.__rank_factor_maintenance_id;
	}

	public void setRankFactorMaintenanceId( java.lang.Integer value ) {
		this.__rank_factor_maintenance_id = value;
	}

	public java.lang.Integer getRankId() {
		return this.__rank_id;
	}

	public void setRankId( java.lang.Integer value ) {
		this.__rank_id = value;
	}

	public java.math.BigDecimal getCoefficient() {
		return this.__coefficient;
	}

	public void setCoefficient( java.math.BigDecimal value ) {
		this.__coefficient = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseRankFactorMaintenance __bean){
		__bean.setRankFactorMaintenanceId(getRankFactorMaintenanceId());
		__bean.setRankId(getRankId());
		__bean.setCoefficient(getCoefficient());
		__bean.setCreateTime(getCreateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getRankFactorMaintenanceId() == null ? "" : getRankFactorMaintenanceId());
		sb.append(",");
		sb.append(getRankId() == null ? "" : getRankId());
		sb.append(",");
		sb.append(getCoefficient() == null ? "" : getCoefficient());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseRankFactorMaintenance o) {
		return __rank_factor_maintenance_id == null ? -1 : __rank_factor_maintenance_id.compareTo(o.getRankFactorMaintenanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__rank_factor_maintenance_id);
		hash = 97 * hash + Objects.hashCode(this.__rank_id);
		hash = 97 * hash + Objects.hashCode(this.__coefficient);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseRankFactorMaintenance o = (BaseRankFactorMaintenance)obj;
		if(!Objects.equals(this.__rank_factor_maintenance_id, o.getRankFactorMaintenanceId())) return false;
		if(!Objects.equals(this.__rank_id, o.getRankId())) return false;
		if(!Objects.equals(this.__coefficient, o.getCoefficient())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getRankFactorMaintenanceId() != null) sb.append(__wrapNumber(count++, "rankFactorMaintenanceId", getRankFactorMaintenanceId()));
		if(getRankId() != null) sb.append(__wrapNumber(count++, "rankId", getRankId()));
		if(getCoefficient() != null) sb.append(__wrapDecimal(count++, "coefficient", getCoefficient()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getRankFactorMaintenanceId() != null) res.put("rankFactorMaintenanceId", getRankFactorMaintenanceId());
		if(getRankId() != null) res.put("rankId", getRankId());
		if(getCoefficient() != null) res.put("coefficient", getCoefficient());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("rankFactorMaintenanceId")) != null) setRankFactorMaintenanceId(__getInt(val)); 
		if((val = values.get("rankId")) != null) setRankId(__getInt(val)); 
		if((val = values.get("coefficient")) != null) setCoefficient(__getDecimal(val));  
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __rank_factor_maintenance_id ;
	protected java.lang.Integer  __rank_id ;
	protected java.math.BigDecimal  __coefficient ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __remark ;
}
