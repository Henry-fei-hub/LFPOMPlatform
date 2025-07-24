package pomplatform.funciton.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetDepartmentIdByEmployeeIdAndFunctionCode extends GenericBase implements BaseFactory<BaseGetDepartmentIdByEmployeeIdAndFunctionCode>, Comparable<BaseGetDepartmentIdByEmployeeIdAndFunctionCode> 
{


	public static BaseGetDepartmentIdByEmployeeIdAndFunctionCode newInstance(){
		return new BaseGetDepartmentIdByEmployeeIdAndFunctionCode();
	}

	@Override
	public BaseGetDepartmentIdByEmployeeIdAndFunctionCode make(){
		BaseGetDepartmentIdByEmployeeIdAndFunctionCode b = new BaseGetDepartmentIdByEmployeeIdAndFunctionCode();
		return b;
	}

	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;

	public final static java.lang.String ALL_CAPTIONS = "department_id";

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public void cloneCopy(BaseGetDepartmentIdByEmployeeIdAndFunctionCode __bean){
		__bean.setDepartmentId(getDepartmentId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetDepartmentIdByEmployeeIdAndFunctionCode o) {
		return __department_id == null ? -1 : __department_id.compareTo(o.getDepartmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetDepartmentIdByEmployeeIdAndFunctionCode o = (BaseGetDepartmentIdByEmployeeIdAndFunctionCode)obj;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
	}

	protected java.lang.Integer  __department_id ;
}
