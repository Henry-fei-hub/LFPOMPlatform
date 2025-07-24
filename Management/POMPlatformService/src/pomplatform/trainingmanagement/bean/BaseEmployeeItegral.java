package pomplatform.trainingmanagement.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeItegral extends GenericBase implements BaseFactory<BaseEmployeeItegral>, Comparable<BaseEmployeeItegral> 
{


	public static BaseEmployeeItegral newInstance(){
		return new BaseEmployeeItegral();
	}

	@Override
	public BaseEmployeeItegral make(){
		BaseEmployeeItegral b = new BaseEmployeeItegral();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_ONE = "one" ;
	public final static java.lang.String CS_TWO = "two" ;
	public final static java.lang.String CS_THREE = "three" ;
	public final static java.lang.String CS_FOUR = "four" ;
	public final static java.lang.String CS_FIVE = "five" ;
	public final static java.lang.String CS_SIX = "six" ;
	public final static java.lang.String CS_SEVEN = "seven" ;
	public final static java.lang.String CS_EIGHT = "eight" ;
	public final static java.lang.String CS_NINE = "nine" ;
	public final static java.lang.String CS_TEN = "ten" ;
	public final static java.lang.String CS_ELEVEN = "eleven" ;
	public final static java.lang.String CS_TWELVE = "twelve" ;
	public final static java.lang.String CS_TOTAL = "total" ;

	public final static java.lang.String ALL_CAPTIONS = "签到人编码,部门编码,,,,,,,,,,,,,";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Long getOne() {
		return this.__one;
	}

	public void setOne( java.lang.Long value ) {
		this.__one = value;
	}

	public java.lang.Long getTwo() {
		return this.__two;
	}

	public void setTwo( java.lang.Long value ) {
		this.__two = value;
	}

	public java.lang.Long getThree() {
		return this.__three;
	}

	public void setThree( java.lang.Long value ) {
		this.__three = value;
	}

	public java.lang.Long getFour() {
		return this.__four;
	}

	public void setFour( java.lang.Long value ) {
		this.__four = value;
	}

	public java.lang.Long getFive() {
		return this.__five;
	}

	public void setFive( java.lang.Long value ) {
		this.__five = value;
	}

	public java.lang.Long getSix() {
		return this.__six;
	}

	public void setSix( java.lang.Long value ) {
		this.__six = value;
	}

	public java.lang.Long getSeven() {
		return this.__seven;
	}

	public void setSeven( java.lang.Long value ) {
		this.__seven = value;
	}

	public java.lang.Long getEight() {
		return this.__eight;
	}

	public void setEight( java.lang.Long value ) {
		this.__eight = value;
	}

	public java.lang.Long getNine() {
		return this.__nine;
	}

	public void setNine( java.lang.Long value ) {
		this.__nine = value;
	}

	public java.lang.Long getTen() {
		return this.__ten;
	}

	public void setTen( java.lang.Long value ) {
		this.__ten = value;
	}

	public java.lang.Long getEleven() {
		return this.__eleven;
	}

	public void setEleven( java.lang.Long value ) {
		this.__eleven = value;
	}

	public java.lang.Long getTwelve() {
		return this.__twelve;
	}

	public void setTwelve( java.lang.Long value ) {
		this.__twelve = value;
	}

	public java.lang.Long getTotal() {
		return this.__total;
	}

	public void setTotal( java.lang.Long value ) {
		this.__total = value;
	}

	public void cloneCopy(BaseEmployeeItegral __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setOne(getOne());
		__bean.setTwo(getTwo());
		__bean.setThree(getThree());
		__bean.setFour(getFour());
		__bean.setFive(getFive());
		__bean.setSix(getSix());
		__bean.setSeven(getSeven());
		__bean.setEight(getEight());
		__bean.setNine(getNine());
		__bean.setTen(getTen());
		__bean.setEleven(getEleven());
		__bean.setTwelve(getTwelve());
		__bean.setTotal(getTotal());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getOne() == null ? "" : getOne());
		sb.append(",");
		sb.append(getTwo() == null ? "" : getTwo());
		sb.append(",");
		sb.append(getThree() == null ? "" : getThree());
		sb.append(",");
		sb.append(getFour() == null ? "" : getFour());
		sb.append(",");
		sb.append(getFive() == null ? "" : getFive());
		sb.append(",");
		sb.append(getSix() == null ? "" : getSix());
		sb.append(",");
		sb.append(getSeven() == null ? "" : getSeven());
		sb.append(",");
		sb.append(getEight() == null ? "" : getEight());
		sb.append(",");
		sb.append(getNine() == null ? "" : getNine());
		sb.append(",");
		sb.append(getTen() == null ? "" : getTen());
		sb.append(",");
		sb.append(getEleven() == null ? "" : getEleven());
		sb.append(",");
		sb.append(getTwelve() == null ? "" : getTwelve());
		sb.append(",");
		sb.append(getTotal() == null ? "" : getTotal());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeItegral o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__one);
		hash = 97 * hash + Objects.hashCode(this.__two);
		hash = 97 * hash + Objects.hashCode(this.__three);
		hash = 97 * hash + Objects.hashCode(this.__four);
		hash = 97 * hash + Objects.hashCode(this.__five);
		hash = 97 * hash + Objects.hashCode(this.__six);
		hash = 97 * hash + Objects.hashCode(this.__seven);
		hash = 97 * hash + Objects.hashCode(this.__eight);
		hash = 97 * hash + Objects.hashCode(this.__nine);
		hash = 97 * hash + Objects.hashCode(this.__ten);
		hash = 97 * hash + Objects.hashCode(this.__eleven);
		hash = 97 * hash + Objects.hashCode(this.__twelve);
		hash = 97 * hash + Objects.hashCode(this.__total);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeItegral o = (BaseEmployeeItegral)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__one, o.getOne())) return false;
		if(!Objects.equals(this.__two, o.getTwo())) return false;
		if(!Objects.equals(this.__three, o.getThree())) return false;
		if(!Objects.equals(this.__four, o.getFour())) return false;
		if(!Objects.equals(this.__five, o.getFive())) return false;
		if(!Objects.equals(this.__six, o.getSix())) return false;
		if(!Objects.equals(this.__seven, o.getSeven())) return false;
		if(!Objects.equals(this.__eight, o.getEight())) return false;
		if(!Objects.equals(this.__nine, o.getNine())) return false;
		if(!Objects.equals(this.__ten, o.getTen())) return false;
		if(!Objects.equals(this.__eleven, o.getEleven())) return false;
		if(!Objects.equals(this.__twelve, o.getTwelve())) return false;
		if(!Objects.equals(this.__total, o.getTotal())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getOne() != null) sb.append(__wrapNumber(count++, "one", getOne()));
		if(getTwo() != null) sb.append(__wrapNumber(count++, "two", getTwo()));
		if(getThree() != null) sb.append(__wrapNumber(count++, "three", getThree()));
		if(getFour() != null) sb.append(__wrapNumber(count++, "four", getFour()));
		if(getFive() != null) sb.append(__wrapNumber(count++, "five", getFive()));
		if(getSix() != null) sb.append(__wrapNumber(count++, "six", getSix()));
		if(getSeven() != null) sb.append(__wrapNumber(count++, "seven", getSeven()));
		if(getEight() != null) sb.append(__wrapNumber(count++, "eight", getEight()));
		if(getNine() != null) sb.append(__wrapNumber(count++, "nine", getNine()));
		if(getTen() != null) sb.append(__wrapNumber(count++, "ten", getTen()));
		if(getEleven() != null) sb.append(__wrapNumber(count++, "eleven", getEleven()));
		if(getTwelve() != null) sb.append(__wrapNumber(count++, "twelve", getTwelve()));
		if(getTotal() != null) sb.append(__wrapNumber(count++, "total", getTotal()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("one")) != null) setOne(__getLong(val)); 
		if((val = values.get("two")) != null) setTwo(__getLong(val)); 
		if((val = values.get("three")) != null) setThree(__getLong(val)); 
		if((val = values.get("four")) != null) setFour(__getLong(val)); 
		if((val = values.get("five")) != null) setFive(__getLong(val)); 
		if((val = values.get("six")) != null) setSix(__getLong(val)); 
		if((val = values.get("seven")) != null) setSeven(__getLong(val)); 
		if((val = values.get("eight")) != null) setEight(__getLong(val)); 
		if((val = values.get("nine")) != null) setNine(__getLong(val)); 
		if((val = values.get("ten")) != null) setTen(__getLong(val)); 
		if((val = values.get("eleven")) != null) setEleven(__getLong(val)); 
		if((val = values.get("twelve")) != null) setTwelve(__getLong(val)); 
		if((val = values.get("total")) != null) setTotal(__getLong(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Long  __one ;
	protected java.lang.Long  __two ;
	protected java.lang.Long  __three ;
	protected java.lang.Long  __four ;
	protected java.lang.Long  __five ;
	protected java.lang.Long  __six ;
	protected java.lang.Long  __seven ;
	protected java.lang.Long  __eight ;
	protected java.lang.Long  __nine ;
	protected java.lang.Long  __ten ;
	protected java.lang.Long  __eleven ;
	protected java.lang.Long  __twelve ;
	protected java.lang.Long  __total ;
}
