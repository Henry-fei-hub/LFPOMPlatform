package pomplatform.report.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReportEmployeeDailyHoursTotal extends GenericBase implements BaseFactory<BaseReportEmployeeDailyHoursTotal>, Comparable<BaseReportEmployeeDailyHoursTotal> 
{


	public static BaseReportEmployeeDailyHoursTotal newInstance(){
		return new BaseReportEmployeeDailyHoursTotal();
	}

	@Override
	public BaseReportEmployeeDailyHoursTotal make(){
		BaseReportEmployeeDailyHoursTotal b = new BaseReportEmployeeDailyHoursTotal();
		return b;
	}

	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_EMPLOYEE_NO = "employee_no" ;
	public final static String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static String CS_PLATE_ID = "plate_id" ;
	public final static String CS_WORK_DATE = "work_date" ;
	public final static String CS_WORK_HOUR = "work_hour" ;
	public final static String CS_COEFFICIENT = "coefficient" ;
	public final static String CS_STATISTICAL_WORK_HOUR = "statistical_work_hour" ;
	public final static String CS_PROJECT_NUMBER = "project_number" ;

	public final static String ALL_CAPTIONS = "员工编号,员工姓名,业务部门,日期,填报工时,职级系数,统计工时,项目数";

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( String value ) {
		this.__employee_no = value;
	}

	public String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( String value ) {
		this.__employee_name = value;
	}

	public Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( Integer value ) {
		this.__plate_id = value;
	}

	public java.util.Date getWorkDate() {
		return this.__work_date;
	}

	public void setWorkDate( java.util.Date value ) {
		this.__work_date = value;
	}

	public java.math.BigDecimal getWorkHour() {
		return this.__work_hour;
	}

	public void setWorkHour( java.math.BigDecimal value ) {
		this.__work_hour = value;
	}

	public java.math.BigDecimal getCoefficient() {
		return this.__coefficient;
	}

	public void setCoefficient( java.math.BigDecimal value ) {
		this.__coefficient = value;
	}

	public java.math.BigDecimal getStatisticalWorkHour() {
		return this.__statistical_work_hour;
	}

	public void setStatisticalWorkHour( java.math.BigDecimal value ) {
		this.__statistical_work_hour = value;
	}

	public Long getProjectNumber() {
		return this.__project_number;
	}

	public void setProjectNumber( Long value ) {
		this.__project_number = value;
	}

	public void cloneCopy(BaseReportEmployeeDailyHoursTotal __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setPlateId(getPlateId());
		__bean.setWorkDate(getWorkDate());
		__bean.setWorkHour(getWorkHour());
		__bean.setCoefficient(getCoefficient());
		__bean.setStatisticalWorkHour(getStatisticalWorkHour());
		__bean.setProjectNumber(getProjectNumber());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		//String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		//sb.append(strEmployeeId == null ? "" : strEmployeeId);
		//sb.append(",");

        //String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
        //sb.append(strEmployeeId == null ? "" : strEmployeeId);
        //sb.append(",");

		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strPlateId =  delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getWorkDate() == null ? "" : sdf.format(getWorkDate()));
		sb.append(",");
		sb.append(getWorkHour() == null ? "" : getWorkHour());
		sb.append(",");
		sb.append(getCoefficient() == null ? "" : getCoefficient());
		sb.append(",");
		sb.append(getStatisticalWorkHour() == null ? "" : getStatisticalWorkHour());
		sb.append(",");
		sb.append(getProjectNumber() == null ? "" : getProjectNumber());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportEmployeeDailyHoursTotal o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__work_date);
		hash = 97 * hash + Objects.hashCode(this.__work_hour);
		hash = 97 * hash + Objects.hashCode(this.__coefficient);
		hash = 97 * hash + Objects.hashCode(this.__statistical_work_hour);
		hash = 97 * hash + Objects.hashCode(this.__project_number);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportEmployeeDailyHoursTotal o = (BaseReportEmployeeDailyHoursTotal)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__work_date, o.getWorkDate())) return false;
		if(!Objects.equals(this.__work_hour, o.getWorkHour())) return false;
		if(!Objects.equals(this.__coefficient, o.getCoefficient())) return false;
		if(!Objects.equals(this.__statistical_work_hour, o.getStatisticalWorkHour())) return false;
		if(!Objects.equals(this.__project_number, o.getProjectNumber())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getWorkDate() != null) sb.append(__wrapDate(count++, "workDate", getWorkDate()));
		if(getWorkHour() != null) sb.append(__wrapDecimal(count++, "workHour", getWorkHour()));
		if(getCoefficient() != null) sb.append(__wrapDecimal(count++, "coefficient", getCoefficient()));
		if(getStatisticalWorkHour() != null) sb.append(__wrapDecimal(count++, "statisticalWorkHour", getStatisticalWorkHour()));
		if(getProjectNumber() != null) sb.append(__wrapNumber(count++, "projectNumber", getProjectNumber()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getWorkDate() != null) res.put("workDate", getWorkDate());
		if(getWorkHour() != null) res.put("workHour", getWorkHour());
		if(getCoefficient() != null) res.put("coefficient", getCoefficient());
		if(getStatisticalWorkHour() != null) res.put("statisticalWorkHour", getStatisticalWorkHour());
		if(getProjectNumber() != null) res.put("projectNumber", getProjectNumber());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("workDate")) != null) setWorkDate(__getDate(val)); 
		if((val = values.get("workHour")) != null) setWorkHour(__getDecimal(val));  
		if((val = values.get("coefficient")) != null) setCoefficient(__getDecimal(val));  
		if((val = values.get("statisticalWorkHour")) != null) setStatisticalWorkHour(__getDecimal(val));  
		if((val = values.get("projectNumber")) != null) setProjectNumber(__getLong(val)); 
	}

	protected Integer  __employee_id ;
	protected String  __employee_no ;
	protected String  __employee_name ;
	protected Integer  __plate_id ;
	protected java.util.Date  __work_date ;
	protected java.math.BigDecimal  __work_hour ;
	protected java.math.BigDecimal  __coefficient ;
	protected java.math.BigDecimal  __statistical_work_hour ;
	protected Long  __project_number ;
}
