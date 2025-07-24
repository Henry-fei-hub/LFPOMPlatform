package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseTrackTalentsMinimumArrangement extends GenericBase implements BaseFactory<BaseTrackTalentsMinimumArrangement>, Comparable<BaseTrackTalentsMinimumArrangement> 
{


	public static BaseTrackTalentsMinimumArrangement newInstance(){
		return new BaseTrackTalentsMinimumArrangement();
	}

	@Override
	public BaseTrackTalentsMinimumArrangement make(){
		BaseTrackTalentsMinimumArrangement b = new BaseTrackTalentsMinimumArrangement();
		return b;
	}

	public final static java.lang.String CS_TRACK_TALENTS_MINIMUM_ARRANGEMENT_ID = "track_talents_minimum_arrangement_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_MAX_AMOUNT = "max_amount" ;
	public final static java.lang.String CS_MIN_AMOUNT = "min_amount" ;
	public final static java.lang.String CS_HIGH_DESIGNER = "high_designer" ;
	public final static java.lang.String CS_MIDDLE_DESIGNER = "middle_designer" ;
	public final static java.lang.String CS_INITIAL_DESIGNER = "initial_designer" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务部门,项目级别,最大金额,最小金额,高级设计师,中级设计师,初级设计师,操作人,操作时间,备注";

	public java.lang.Integer getTrackTalentsMinimumArrangementId() {
		return this.__track_talents_minimum_arrangement_id;
	}

	public void setTrackTalentsMinimumArrangementId( java.lang.Integer value ) {
		this.__track_talents_minimum_arrangement_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.math.BigDecimal getMaxAmount() {
		return this.__max_amount;
	}

	public void setMaxAmount( java.math.BigDecimal value ) {
		this.__max_amount = value;
	}

	public java.math.BigDecimal getMinAmount() {
		return this.__min_amount;
	}

	public void setMinAmount( java.math.BigDecimal value ) {
		this.__min_amount = value;
	}

	public java.lang.Integer getHighDesigner() {
		return this.__high_designer;
	}

	public void setHighDesigner( java.lang.Integer value ) {
		this.__high_designer = value;
	}

	public java.lang.Integer getMiddleDesigner() {
		return this.__middle_designer;
	}

	public void setMiddleDesigner( java.lang.Integer value ) {
		this.__middle_designer = value;
	}

	public java.lang.Integer getInitialDesigner() {
		return this.__initial_designer;
	}

	public void setInitialDesigner( java.lang.Integer value ) {
		this.__initial_designer = value;
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

	public void cloneCopy(BaseTrackTalentsMinimumArrangement __bean){
		__bean.setTrackTalentsMinimumArrangementId(getTrackTalentsMinimumArrangementId());
		__bean.setPlateId(getPlateId());
		__bean.setProjectType(getProjectType());
		__bean.setMaxAmount(getMaxAmount());
		__bean.setMinAmount(getMinAmount());
		__bean.setHighDesigner(getHighDesigner());
		__bean.setMiddleDesigner(getMiddleDesigner());
		__bean.setInitialDesigner(getInitialDesigner());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getTrackTalentsMinimumArrangementId() == null ? "" : getTrackTalentsMinimumArrangementId());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strProjectType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_32", String.valueOf(getProjectType()));
		sb.append(strProjectType == null ? "" : strProjectType);
		sb.append(",");
		sb.append(getMaxAmount() == null ? "" : getMaxAmount());
		sb.append(",");
		sb.append(getMinAmount() == null ? "" : getMinAmount());
		sb.append(",");
		sb.append(getHighDesigner() == null ? "" : getHighDesigner());
		sb.append(",");
		sb.append(getMiddleDesigner() == null ? "" : getMiddleDesigner());
		sb.append(",");
		sb.append(getInitialDesigner() == null ? "" : getInitialDesigner());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseTrackTalentsMinimumArrangement o) {
		return __track_talents_minimum_arrangement_id == null ? -1 : __track_talents_minimum_arrangement_id.compareTo(o.getTrackTalentsMinimumArrangementId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__track_talents_minimum_arrangement_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__max_amount);
		hash = 97 * hash + Objects.hashCode(this.__min_amount);
		hash = 97 * hash + Objects.hashCode(this.__high_designer);
		hash = 97 * hash + Objects.hashCode(this.__middle_designer);
		hash = 97 * hash + Objects.hashCode(this.__initial_designer);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseTrackTalentsMinimumArrangement o = (BaseTrackTalentsMinimumArrangement)obj;
		if(!Objects.equals(this.__track_talents_minimum_arrangement_id, o.getTrackTalentsMinimumArrangementId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__max_amount, o.getMaxAmount())) return false;
		if(!Objects.equals(this.__min_amount, o.getMinAmount())) return false;
		if(!Objects.equals(this.__high_designer, o.getHighDesigner())) return false;
		if(!Objects.equals(this.__middle_designer, o.getMiddleDesigner())) return false;
		if(!Objects.equals(this.__initial_designer, o.getInitialDesigner())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getTrackTalentsMinimumArrangementId() != null) sb.append(__wrapNumber(count++, "trackTalentsMinimumArrangementId", getTrackTalentsMinimumArrangementId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getMaxAmount() != null) sb.append(__wrapDecimal(count++, "maxAmount", getMaxAmount()));
		if(getMinAmount() != null) sb.append(__wrapDecimal(count++, "minAmount", getMinAmount()));
		if(getHighDesigner() != null) sb.append(__wrapNumber(count++, "highDesigner", getHighDesigner()));
		if(getMiddleDesigner() != null) sb.append(__wrapNumber(count++, "middleDesigner", getMiddleDesigner()));
		if(getInitialDesigner() != null) sb.append(__wrapNumber(count++, "initialDesigner", getInitialDesigner()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("trackTalentsMinimumArrangementId")) != null) setTrackTalentsMinimumArrangementId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("maxAmount")) != null) setMaxAmount(__getDecimal(val));  
		if((val = values.get("minAmount")) != null) setMinAmount(__getDecimal(val));  
		if((val = values.get("highDesigner")) != null) setHighDesigner(__getInt(val)); 
		if((val = values.get("middleDesigner")) != null) setMiddleDesigner(__getInt(val)); 
		if((val = values.get("initialDesigner")) != null) setInitialDesigner(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __track_talents_minimum_arrangement_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __project_type ;
	protected java.math.BigDecimal  __max_amount ;
	protected java.math.BigDecimal  __min_amount ;
	protected java.lang.Integer  __high_designer ;
	protected java.lang.Integer  __middle_designer ;
	protected java.lang.Integer  __initial_designer ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
}
