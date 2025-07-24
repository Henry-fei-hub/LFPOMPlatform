package pomplatform.project.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnRevenueSureWarn extends GenericBase implements BaseFactory<BaseOnRevenueSureWarn>, Comparable<BaseOnRevenueSureWarn> 
{


	public static BaseOnRevenueSureWarn newInstance(){
		return new BaseOnRevenueSureWarn();
	}

	@Override
	public BaseOnRevenueSureWarn make(){
		BaseOnRevenueSureWarn b = new BaseOnRevenueSureWarn();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PROJECT_NUM = "project_num" ;
	public final static java.lang.String CS_PROJECT_NO_NUM = "project_no_num" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_SURE_DATE = "sure_date" ;
	public final static java.lang.String CS_WEEK_DATE = "week_date" ;
	public final static java.lang.String CS_WARN_FLAG = "warn_flag" ;
	public final static java.lang.String CS_WARN_IMG = "warn_img" ;

	public final static java.lang.String ALL_CAPTIONS = "结算操作人,员工编号,员工姓名,板块,,,,,,,";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getProjectNum() {
		return this.__project_num;
	}

	public void setProjectNum( java.math.BigDecimal value ) {
		this.__project_num = value;
	}

	public java.math.BigDecimal getProjectNoNum() {
		return this.__project_no_num;
	}

	public void setProjectNoNum( java.math.BigDecimal value ) {
		this.__project_no_num = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.util.Date getSureDate() {
		return this.__sure_date;
	}

	public void setSureDate( java.util.Date value ) {
		this.__sure_date = value;
	}

	public java.util.Date getWeekDate() {
		return this.__week_date;
	}

	public void setWeekDate( java.util.Date value ) {
		this.__week_date = value;
	}

	public java.lang.Integer getWarnFlag() {
		return this.__warn_flag;
	}

	public void setWarnFlag( java.lang.Integer value ) {
		this.__warn_flag = value;
	}

	public java.lang.String getWarnImg() {
		return this.__warn_img;
	}

	public void setWarnImg( java.lang.String value ) {
		this.__warn_img = value;
	}

	public void cloneCopy(BaseOnRevenueSureWarn __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setPlateId(getPlateId());
		__bean.setProjectNum(getProjectNum());
		__bean.setProjectNoNum(getProjectNoNum());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setSureDate(getSureDate());
		__bean.setWeekDate(getWeekDate());
		__bean.setWarnFlag(getWarnFlag());
		__bean.setWarnImg(getWarnImg());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getProjectNum() == null ? "" : getProjectNum());
		sb.append(",");
		sb.append(getProjectNoNum() == null ? "" : getProjectNoNum());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getSureDate() == null ? "" : sdf.format(getSureDate()));
		sb.append(",");
		sb.append(getWeekDate() == null ? "" : sdf.format(getWeekDate()));
		sb.append(",");
		sb.append(getWarnFlag() == null ? "" : getWarnFlag());
		sb.append(",");
		sb.append(getWarnImg() == null ? "" : getWarnImg());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnRevenueSureWarn o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__project_num);
		hash = 97 * hash + Objects.hashCode(this.__project_no_num);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__sure_date);
		hash = 97 * hash + Objects.hashCode(this.__week_date);
		hash = 97 * hash + Objects.hashCode(this.__warn_flag);
		hash = 97 * hash + Objects.hashCode(this.__warn_img);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnRevenueSureWarn o = (BaseOnRevenueSureWarn)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__project_num, o.getProjectNum())) return false;
		if(!Objects.equals(this.__project_no_num, o.getProjectNoNum())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__sure_date, o.getSureDate())) return false;
		if(!Objects.equals(this.__week_date, o.getWeekDate())) return false;
		if(!Objects.equals(this.__warn_flag, o.getWarnFlag())) return false;
		if(!Objects.equals(this.__warn_img, o.getWarnImg())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getProjectNum() != null) sb.append(__wrapDecimal(count++, "projectNum", getProjectNum()));
		if(getProjectNoNum() != null) sb.append(__wrapDecimal(count++, "projectNoNum", getProjectNoNum()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getSureDate() != null) sb.append(__wrapDate(count++, "sureDate", getSureDate()));
		if(getWeekDate() != null) sb.append(__wrapDate(count++, "weekDate", getWeekDate()));
		if(getWarnFlag() != null) sb.append(__wrapNumber(count++, "warnFlag", getWarnFlag()));
		if(getWarnImg() != null) sb.append(__wrapString(count++, "warnImg", getWarnImg()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("projectNum")) != null) setProjectNum(__getDecimal(val));  
		if((val = values.get("projectNoNum")) != null) setProjectNoNum(__getDecimal(val));  
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("sureDate")) != null) setSureDate(__getDate(val)); 
		if((val = values.get("weekDate")) != null) setWeekDate(__getDate(val)); 
		if((val = values.get("warnFlag")) != null) setWarnFlag(__getInt(val)); 
		if((val = values.get("warnImg")) != null) setWarnImg(__getString(val));
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __project_num ;
	protected java.math.BigDecimal  __project_no_num ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.util.Date  __sure_date ;
	protected java.util.Date  __week_date ;
	protected java.lang.Integer  __warn_flag ;
	protected java.lang.String  __warn_img ;
}
