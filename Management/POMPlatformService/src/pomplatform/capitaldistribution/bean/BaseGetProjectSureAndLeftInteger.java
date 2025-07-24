package pomplatform.capitaldistribution.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetProjectSureAndLeftInteger extends GenericBase implements BaseFactory<BaseGetProjectSureAndLeftInteger>, Comparable<BaseGetProjectSureAndLeftInteger> 
{


	public static BaseGetProjectSureAndLeftInteger newInstance(){
		return new BaseGetProjectSureAndLeftInteger();
	}

	@Override
	public BaseGetProjectSureAndLeftInteger make(){
		BaseGetProjectSureAndLeftInteger b = new BaseGetProjectSureAndLeftInteger();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_LEFT_INTEGRAL = "left_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "项目代码,,";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.math.BigDecimal getLeftIntegral() {
		return this.__left_integral;
	}

	public void setLeftIntegral( java.math.BigDecimal value ) {
		this.__left_integral = value;
	}

	public void cloneCopy(BaseGetProjectSureAndLeftInteger __bean){
		__bean.setProjectId(getProjectId());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setLeftIntegral(getLeftIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getLeftIntegral() == null ? "" : getLeftIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetProjectSureAndLeftInteger o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__left_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetProjectSureAndLeftInteger o = (BaseGetProjectSureAndLeftInteger)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__left_integral, o.getLeftIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getLeftIntegral() != null) sb.append(__wrapDecimal(count++, "leftIntegral", getLeftIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("leftIntegral")) != null) setLeftIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_id ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.math.BigDecimal  __left_integral ;
}
