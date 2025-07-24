package pomplatform.report.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReportProjectWorkTime extends GenericBase implements BaseFactory<BaseReportProjectWorkTime>, Comparable<BaseReportProjectWorkTime> 
{


	public static BaseReportProjectWorkTime newInstance(){
		return new BaseReportProjectWorkTime();
	}

	@Override
	public BaseReportProjectWorkTime make(){
		BaseReportProjectWorkTime b = new BaseReportProjectWorkTime();
		return b;
	}

	public final static String CS_PROJECT_ID = "project_id" ;
	public final static String CS_PROJECT_CODE = "project_code" ;
	public final static String CS_PROJECT_NAME = "project_name" ;
	public final static String CS_WORK_HOUR = "work_hour" ;
	public final static String CS_PROJECT_STATISTICAL_WORK_HOUR = "project_statistical_work_hour" ;
	public final static String CS_PARTICIPANT_NUMBER = "participant_number" ;

	public final static String ALL_CAPTIONS = "项目编号,项目名称,填报工时,统计工时,参与人数";

	public Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( Integer value ) {
		this.__project_id = value;
	}

	public String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( String value ) {
		this.__project_code = value;
	}

	public String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( String value ) {
		this.__project_name = value;
	}

	public java.math.BigDecimal getWorkHour() {
		return this.__work_hour;
	}

	public void setWorkHour( java.math.BigDecimal value ) {
		this.__work_hour = value;
	}

	public java.math.BigDecimal getProjectStatisticalWorkHour() {
		return this.__project_statistical_work_hour;
	}

	public void setProjectStatisticalWorkHour( java.math.BigDecimal value ) {
		this.__project_statistical_work_hour = value;
	}

	public Long getParticipantNumber() {
		return this.__participant_number;
	}

	public void setParticipantNumber( Long value ) {
		this.__participant_number = value;
	}

	public void cloneCopy(BaseReportProjectWorkTime __bean){
		__bean.setProjectId(getProjectId());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setWorkHour(getWorkHour());
		__bean.setProjectStatisticalWorkHour(getProjectStatisticalWorkHour());
		__bean.setParticipantNumber(getParticipantNumber());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getWorkHour() == null ? "" : getWorkHour());
		sb.append(",");
		sb.append(getProjectStatisticalWorkHour() == null ? "" : getProjectStatisticalWorkHour());
		sb.append(",");
		sb.append(getParticipantNumber() == null ? "" : getParticipantNumber());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportProjectWorkTime o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__work_hour);
		hash = 97 * hash + Objects.hashCode(this.__project_statistical_work_hour);
		hash = 97 * hash + Objects.hashCode(this.__participant_number);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportProjectWorkTime o = (BaseReportProjectWorkTime)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__work_hour, o.getWorkHour())) return false;
		if(!Objects.equals(this.__project_statistical_work_hour, o.getProjectStatisticalWorkHour())) return false;
		if(!Objects.equals(this.__participant_number, o.getParticipantNumber())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getWorkHour() != null) sb.append(__wrapDecimal(count++, "workHour", getWorkHour()));
		if(getProjectStatisticalWorkHour() != null) sb.append(__wrapDecimal(count++, "projectStatisticalWorkHour", getProjectStatisticalWorkHour()));
		if(getParticipantNumber() != null) sb.append(__wrapNumber(count++, "participantNumber", getParticipantNumber()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getWorkHour() != null) res.put("workHour", getWorkHour());
		if(getProjectStatisticalWorkHour() != null) res.put("projectStatisticalWorkHour", getProjectStatisticalWorkHour());
		if(getParticipantNumber() != null) res.put("participantNumber", getParticipantNumber());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("workHour")) != null) setWorkHour(__getDecimal(val));  
		if((val = values.get("projectStatisticalWorkHour")) != null) setProjectStatisticalWorkHour(__getDecimal(val));  
		if((val = values.get("participantNumber")) != null) setParticipantNumber(__getLong(val)); 
	}

	protected Integer  __project_id ;
	protected String  __project_code ;
	protected String  __project_name ;
	protected java.math.BigDecimal  __work_hour ;
	protected java.math.BigDecimal  __project_statistical_work_hour ;
	protected Long  __participant_number ;
}
