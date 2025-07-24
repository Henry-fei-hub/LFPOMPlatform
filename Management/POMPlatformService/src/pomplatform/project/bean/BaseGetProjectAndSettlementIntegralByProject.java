package pomplatform.project.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetProjectAndSettlementIntegralByProject extends GenericBase implements BaseFactory<BaseGetProjectAndSettlementIntegralByProject>, Comparable<BaseGetProjectAndSettlementIntegralByProject> 
{


	public static BaseGetProjectAndSettlementIntegralByProject newInstance(){
		return new BaseGetProjectAndSettlementIntegralByProject();
	}

	@Override
	public BaseGetProjectAndSettlementIntegralByProject make(){
		BaseGetProjectAndSettlementIntegralByProject b = new BaseGetProjectAndSettlementIntegralByProject();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_SETTLEMENT_INTEGRAL = "settlement_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "项目编码,项目积分,结算积分";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.math.BigDecimal getProjectIntegral() {
		return this.__project_integral;
	}

	public void setProjectIntegral( java.math.BigDecimal value ) {
		this.__project_integral = value;
	}

	public java.math.BigDecimal getSettlementIntegral() {
		return this.__settlement_integral;
	}

	public void setSettlementIntegral( java.math.BigDecimal value ) {
		this.__settlement_integral = value;
	}

	public void cloneCopy(BaseGetProjectAndSettlementIntegralByProject __bean){
		__bean.setProjectId(getProjectId());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setSettlementIntegral(getSettlementIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getSettlementIntegral() == null ? "" : getSettlementIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetProjectAndSettlementIntegralByProject o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__settlement_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetProjectAndSettlementIntegralByProject o = (BaseGetProjectAndSettlementIntegralByProject)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__settlement_integral, o.getSettlementIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getSettlementIntegral() != null) sb.append(__wrapDecimal(count++, "settlementIntegral", getSettlementIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));  
		if((val = values.get("settlementIntegral")) != null) setSettlementIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_id ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.math.BigDecimal  __settlement_integral ;
}
