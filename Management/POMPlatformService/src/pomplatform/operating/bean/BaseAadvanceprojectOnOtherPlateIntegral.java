package pomplatform.operating.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAadvanceprojectOnOtherPlateIntegral extends GenericBase implements BaseFactory<BaseAadvanceprojectOnOtherPlateIntegral>, Comparable<BaseAadvanceprojectOnOtherPlateIntegral> 
{


	public static BaseAadvanceprojectOnOtherPlateIntegral newInstance(){
		return new BaseAadvanceprojectOnOtherPlateIntegral();
	}

	@Override
	public BaseAadvanceprojectOnOtherPlateIntegral make(){
		BaseAadvanceprojectOnOtherPlateIntegral b = new BaseAadvanceprojectOnOtherPlateIntegral();
		return b;
	}

	public final static java.lang.String CS_OWN_PLATE_ID = "own_plate_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_ADVANCED_INTEGRAL = "advanced_integral" ;
	public final static java.lang.String CS_ADVANCE_DATE = "advance_date" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;

	public final static java.lang.String ALL_CAPTIONS = ",补贴项目,补贴成员,已补贴积分,补贴日期,年份,月份,所在业务部门";

	public java.lang.Integer getOwnPlateId() {
		return this.__own_plate_id;
	}

	public void setOwnPlateId( java.lang.Integer value ) {
		this.__own_plate_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getAdvancedIntegral() {
		return this.__advanced_integral;
	}

	public void setAdvancedIntegral( java.math.BigDecimal value ) {
		this.__advanced_integral = value;
	}

	public java.util.Date getAdvanceDate() {
		return this.__advance_date;
	}

	public void setAdvanceDate( java.util.Date value ) {
		this.__advance_date = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public void cloneCopy(BaseAadvanceprojectOnOtherPlateIntegral __bean){
		__bean.setOwnPlateId(getOwnPlateId());
		__bean.setProjectId(getProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setAdvancedIntegral(getAdvancedIntegral());
		__bean.setAdvanceDate(getAdvanceDate());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setPlateId(getPlateId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getOwnPlateId() == null ? "" : getOwnPlateId());
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getAdvancedIntegral() == null ? "" : getAdvancedIntegral());
		sb.append(",");
		sb.append(getAdvanceDate() == null ? "" : sdf.format(getAdvanceDate()));
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAadvanceprojectOnOtherPlateIntegral o) {
		return __own_plate_id == null ? -1 : __own_plate_id.compareTo(o.getOwnPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__own_plate_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__advanced_integral);
		hash = 97 * hash + Objects.hashCode(this.__advance_date);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAadvanceprojectOnOtherPlateIntegral o = (BaseAadvanceprojectOnOtherPlateIntegral)obj;
		if(!Objects.equals(this.__own_plate_id, o.getOwnPlateId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__advanced_integral, o.getAdvancedIntegral())) return false;
		if(!Objects.equals(this.__advance_date, o.getAdvanceDate())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getOwnPlateId() != null) sb.append(__wrapNumber(count++, "ownPlateId", getOwnPlateId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getAdvancedIntegral() != null) sb.append(__wrapDecimal(count++, "advancedIntegral", getAdvancedIntegral()));
		if(getAdvanceDate() != null) sb.append(__wrapDate(count++, "advanceDate", getAdvanceDate()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("ownPlateId")) != null) setOwnPlateId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("advancedIntegral")) != null) setAdvancedIntegral(__getDecimal(val));  
		if((val = values.get("advanceDate")) != null) setAdvanceDate(__getDate(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
	}

	protected java.lang.Integer  __own_plate_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __advanced_integral ;
	protected java.util.Date  __advance_date ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.Integer  __plate_id ;
}
