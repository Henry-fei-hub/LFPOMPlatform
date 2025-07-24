package pomplatform.abouttrainingmanagement.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAboutTrainingManagement extends GenericBase implements BaseFactory<BaseAboutTrainingManagement>, Comparable<BaseAboutTrainingManagement> 
{


	public static BaseAboutTrainingManagement newInstance(){
		return new BaseAboutTrainingManagement();
	}

	@Override
	public BaseAboutTrainingManagement make(){
		BaseAboutTrainingManagement b = new BaseAboutTrainingManagement();
		return b;
	}

	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_NUMBER = "number" ;

	public final static java.lang.String ALL_CAPTIONS = "年份,月份,部门,培训次数";

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

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getNumber() {
		return this.__number;
	}

	public void setNumber( java.lang.Integer value ) {
		this.__number = value;
	}

	public void cloneCopy(BaseAboutTrainingManagement __bean){
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setNumber(getNumber());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getNumber() == null ? "" : getNumber());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAboutTrainingManagement o) {
		return __year == null ? -1 : __year.compareTo(o.getYear());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__number);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAboutTrainingManagement o = (BaseAboutTrainingManagement)obj;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__number, o.getNumber())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getNumber() != null) sb.append(__wrapNumber(count++, "number", getNumber()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getNumber() != null) res.put("number", getNumber());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("number")) != null) setNumber(__getInt(val)); 
	}

	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __number ;
}
