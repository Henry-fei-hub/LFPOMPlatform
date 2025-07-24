package pomplatform.projectappendintegralrecordpor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSprojectappendintegralrecordpor extends GenericBase implements BaseFactory<BaseSprojectappendintegralrecordpor>, Comparable<BaseSprojectappendintegralrecordpor> 
{


	public static BaseSprojectappendintegralrecordpor newInstance(){
		return new BaseSprojectappendintegralrecordpor();
	}

	@Override
	public BaseSprojectappendintegralrecordpor make(){
		BaseSprojectappendintegralrecordpor b = new BaseSprojectappendintegralrecordpor();
		return b;
	}

	public final static java.lang.String CS_PROJECT_APPEND_INTEGRAL_RECORD_ID = "project_append_integral_record_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_APPEND_INTEGRAL = "append_integral" ;
	public final static java.lang.String CS_PERCENTAGE = "percentage" ;
	public final static java.lang.String CS_APPEND_TIME = "append_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目编码,追加积分,核算比例(%),追加时间,备注";

	public java.lang.Integer getProjectAppendIntegralRecordId() {
		return this.__project_append_integral_record_id;
	}

	public void setProjectAppendIntegralRecordId( java.lang.Integer value ) {
		this.__project_append_integral_record_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getAppendIntegral() {
		return this.__append_integral;
	}

	public void setAppendIntegral( java.lang.Integer value ) {
		this.__append_integral = value;
	}

	public java.math.BigDecimal getPercentage() {
		return this.__percentage;
	}

	public void setPercentage( java.math.BigDecimal value ) {
		this.__percentage = value;
	}

	public java.util.Date getAppendTime() {
		return this.__append_time;
	}

	public void setAppendTime( java.util.Date value ) {
		this.__append_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseSprojectappendintegralrecordpor __bean){
		__bean.setProjectAppendIntegralRecordId(getProjectAppendIntegralRecordId());
		__bean.setProjectId(getProjectId());
		__bean.setAppendIntegral(getAppendIntegral());
		__bean.setPercentage(getPercentage());
		__bean.setAppendTime(getAppendTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectAppendIntegralRecordId() == null ? "" : getProjectAppendIntegralRecordId());
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getAppendIntegral() == null ? "" : getAppendIntegral());
		sb.append(",");
		sb.append(getPercentage() == null ? "" : getPercentage());
		sb.append(",");
		sb.append(getAppendTime() == null ? "" : sdf.format(getAppendTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSprojectappendintegralrecordpor o) {
		return __project_append_integral_record_id == null ? -1 : __project_append_integral_record_id.compareTo(o.getProjectAppendIntegralRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_append_integral_record_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__append_integral);
		hash = 97 * hash + Objects.hashCode(this.__percentage);
		hash = 97 * hash + Objects.hashCode(this.__append_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSprojectappendintegralrecordpor o = (BaseSprojectappendintegralrecordpor)obj;
		if(!Objects.equals(this.__project_append_integral_record_id, o.getProjectAppendIntegralRecordId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__append_integral, o.getAppendIntegral())) return false;
		if(!Objects.equals(this.__percentage, o.getPercentage())) return false;
		if(!Objects.equals(this.__append_time, o.getAppendTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectAppendIntegralRecordId() != null) sb.append(__wrapNumber(count++, "projectAppendIntegralRecordId", getProjectAppendIntegralRecordId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getAppendIntegral() != null) sb.append(__wrapNumber(count++, "appendIntegral", getAppendIntegral()));
		if(getPercentage() != null) sb.append(__wrapDecimal(count++, "percentage", getPercentage()));
		if(getAppendTime() != null) sb.append(__wrapDate(count++, "appendTime", getAppendTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectAppendIntegralRecordId")) != null) setProjectAppendIntegralRecordId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("appendIntegral")) != null) setAppendIntegral(__getInt(val)); 
		if((val = values.get("percentage")) != null) setPercentage(__getDecimal(val));  
		if((val = values.get("appendTime")) != null) setAppendTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __project_append_integral_record_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __append_integral ;
	protected java.math.BigDecimal  __percentage ;
	protected java.util.Date  __append_time ;
	protected java.lang.String  __remark ;
}
