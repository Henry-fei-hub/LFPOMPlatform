package pomplatform.employee.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnboardEmployeeEachMonth extends GenericBase implements BaseFactory<BaseOnboardEmployeeEachMonth>, Comparable<BaseOnboardEmployeeEachMonth> 
{


	public static BaseOnboardEmployeeEachMonth newInstance(){
		return new BaseOnboardEmployeeEachMonth();
	}

	@Override
	public BaseOnboardEmployeeEachMonth make(){
		BaseOnboardEmployeeEachMonth b = new BaseOnboardEmployeeEachMonth();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_NUM = "num" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门编码,归属部门编码,,,";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Double getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Double value ) {
		this.__year = value;
	}

	public java.lang.Double getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Double value ) {
		this.__month = value;
	}

	public java.lang.Long getNum() {
		return this.__num;
	}

	public void setNum( java.lang.Long value ) {
		this.__num = value;
	}

	public void cloneCopy(BaseOnboardEmployeeEachMonth __bean){
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setNum(getNum());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getNum() == null ? "" : getNum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnboardEmployeeEachMonth o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__num);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnboardEmployeeEachMonth o = (BaseOnboardEmployeeEachMonth)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__num, o.getNum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getNum() != null) sb.append(__wrapNumber(count++, "num", getNum()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getDouble(val)); 
		if((val = values.get("month")) != null) setMonth(__getDouble(val)); 
		if((val = values.get("num")) != null) setNum(__getLong(val)); 
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Double  __year ;
	protected java.lang.Double  __month ;
	protected java.lang.Long  __num ;
}
