package pomplatform.EmployeeAchieveIntegralReturnRecordByProject.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeAchieveIntegralReturnRecordByProject extends GenericBase implements BaseFactory<BaseEmployeeAchieveIntegralReturnRecordByProject>, Comparable<BaseEmployeeAchieveIntegralReturnRecordByProject> 
{


	public static BaseEmployeeAchieveIntegralReturnRecordByProject newInstance(){
		return new BaseEmployeeAchieveIntegralReturnRecordByProject();
	}

	@Override
	public BaseEmployeeAchieveIntegralReturnRecordByProject make(){
		BaseEmployeeAchieveIntegralReturnRecordByProject b = new BaseEmployeeAchieveIntegralReturnRecordByProject();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_ACHIEVE_INTEGRAL = "achieve_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,项目名称,回流积分";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.math.BigDecimal getAchieveIntegral() {
		return this.__achieve_integral;
	}

	public void setAchieveIntegral( java.math.BigDecimal value ) {
		this.__achieve_integral = value;
	}

	public void cloneCopy(BaseEmployeeAchieveIntegralReturnRecordByProject __bean){
		__bean.setPlateId(getPlateId());
		__bean.setProjectId(getProjectId());
		__bean.setAchieveIntegral(getAchieveIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getAchieveIntegral() == null ? "" : getAchieveIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeAchieveIntegralReturnRecordByProject o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__achieve_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeAchieveIntegralReturnRecordByProject o = (BaseEmployeeAchieveIntegralReturnRecordByProject)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__achieve_integral, o.getAchieveIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getAchieveIntegral() != null) sb.append(__wrapDecimal(count++, "achieveIntegral", getAchieveIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("achieveIntegral")) != null) setAchieveIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __project_id ;
	protected java.math.BigDecimal  __achieve_integral ;
}
