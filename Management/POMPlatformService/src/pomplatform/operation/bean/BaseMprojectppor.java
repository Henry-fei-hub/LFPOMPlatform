package pomplatform.operation.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMprojectppor extends GenericBase implements BaseFactory<BaseMprojectppor>, Comparable<BaseMprojectppor> 
{


	public static BaseMprojectppor newInstance(){
		return new BaseMprojectppor();
	}

	@Override
	public BaseMprojectppor make(){
		BaseMprojectppor b = new BaseMprojectppor();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static java.lang.String CS_TOTAL_COST = "total_cost" ;
	public final static java.lang.String CS_TOTALCOUNT = "totalcount" ;
	public final static java.lang.String CS_LEFT_AMOUNT = "left_amount" ;

	public final static java.lang.String ALL_CAPTIONS = "项目编码,项目积分,项目总金额,总费用,,项目结余";

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

	public java.math.BigDecimal getTotalAmount() {
		return this.__total_amount;
	}

	public void setTotalAmount( java.math.BigDecimal value ) {
		this.__total_amount = value;
	}

	public java.math.BigDecimal getTotalCost() {
		return this.__total_cost;
	}

	public void setTotalCost( java.math.BigDecimal value ) {
		this.__total_cost = value;
	}

	public java.lang.Long getTotalcount() {
		return this.__totalcount;
	}

	public void setTotalcount( java.lang.Long value ) {
		this.__totalcount = value;
	}

	public java.math.BigDecimal getLeftAmount() {
		return this.__left_amount;
	}

	public void setLeftAmount( java.math.BigDecimal value ) {
		this.__left_amount = value;
	}

	public void cloneCopy(BaseMprojectppor __bean){
		__bean.setProjectId(getProjectId());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setTotalCost(getTotalCost());
		__bean.setTotalcount(getTotalcount());
		__bean.setLeftAmount(getLeftAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		sb.append(",");
		sb.append(getTotalCost() == null ? "" : getTotalCost());
		sb.append(",");
		sb.append(getTotalcount() == null ? "" : getTotalcount());
		sb.append(",");
		sb.append(getLeftAmount() == null ? "" : getLeftAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMprojectppor o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__total_cost);
		hash = 97 * hash + Objects.hashCode(this.__totalcount);
		hash = 97 * hash + Objects.hashCode(this.__left_amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMprojectppor o = (BaseMprojectppor)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__total_cost, o.getTotalCost())) return false;
		if(!Objects.equals(this.__totalcount, o.getTotalcount())) return false;
		if(!Objects.equals(this.__left_amount, o.getLeftAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getTotalAmount() != null) sb.append(__wrapDecimal(count++, "totalAmount", getTotalAmount()));
		if(getTotalCost() != null) sb.append(__wrapDecimal(count++, "totalCost", getTotalCost()));
		if(getTotalcount() != null) sb.append(__wrapNumber(count++, "totalcount", getTotalcount()));
		if(getLeftAmount() != null) sb.append(__wrapDecimal(count++, "leftAmount", getLeftAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));  
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getDecimal(val));  
		if((val = values.get("totalCost")) != null) setTotalCost(__getDecimal(val));  
		if((val = values.get("totalcount")) != null) setTotalcount(__getLong(val)); 
		if((val = values.get("leftAmount")) != null) setLeftAmount(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_id ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.math.BigDecimal  __total_amount ;
	protected java.math.BigDecimal  __total_cost ;
	protected java.lang.Long  __totalcount ;
	protected java.math.BigDecimal  __left_amount ;
}
