package pomplatform.salary.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnDownLoadWorkMoney extends GenericBase implements BaseFactory<BaseOnDownLoadWorkMoney>, Comparable<BaseOnDownLoadWorkMoney> 
{


	public static BaseOnDownLoadWorkMoney newInstance(){
		return new BaseOnDownLoadWorkMoney();
	}

	@Override
	public BaseOnDownLoadWorkMoney make(){
		BaseOnDownLoadWorkMoney b = new BaseOnDownLoadWorkMoney();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_WORK_YEARS = "work_years" ;
	public final static java.lang.String CS_WORK_MONEY = "work_money" ;

	public final static java.lang.String ALL_CAPTIONS = "员工编号,员工姓名,年份,月份,工龄,工龄工资";

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

	public java.lang.String getWorkYears() {
		return this.__work_years;
	}

	public void setWorkYears( java.lang.String value ) {
		this.__work_years = value;
	}

	public java.lang.String getWorkMoney() {
		return this.__work_money;
	}

	public void setWorkMoney( java.lang.String value ) {
		this.__work_money = value;
	}

	public void cloneCopy(BaseOnDownLoadWorkMoney __bean){
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setWorkYears(getWorkYears());
		__bean.setWorkMoney(getWorkMoney());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getWorkYears() == null ? "" : getWorkYears());
		sb.append(",");
		sb.append(getWorkMoney() == null ? "" : getWorkMoney());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnDownLoadWorkMoney o) {
		return __employee_no == null ? -1 : __employee_no.compareTo(o.getEmployeeNo());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__work_years);
		hash = 97 * hash + Objects.hashCode(this.__work_money);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnDownLoadWorkMoney o = (BaseOnDownLoadWorkMoney)obj;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__work_years, o.getWorkYears())) return false;
		if(!Objects.equals(this.__work_money, o.getWorkMoney())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getWorkYears() != null) sb.append(__wrapString(count++, "workYears", getWorkYears()));
		if(getWorkMoney() != null) sb.append(__wrapString(count++, "workMoney", getWorkMoney()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("workYears")) != null) setWorkYears(__getString(val));
		if((val = values.get("workMoney")) != null) setWorkMoney(__getString(val));
	}

	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.String  __work_years ;
	protected java.lang.String  __work_money ;
}
