package pomplatform.department.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetECMCDepartmentByPlate extends GenericBase implements BaseFactory<BaseGetECMCDepartmentByPlate>, Comparable<BaseGetECMCDepartmentByPlate> 
{


	public static BaseGetECMCDepartmentByPlate newInstance(){
		return new BaseGetECMCDepartmentByPlate();
	}

	@Override
	public BaseGetECMCDepartmentByPlate make(){
		BaseGetECMCDepartmentByPlate b = new BaseGetECMCDepartmentByPlate();
		return b;
	}

	public final static java.lang.String CS_DEPARTMENT_NAME = "department_name" ;
	public final static java.lang.String CS_ECMC_DEPARTMENT_ID = "ecmc_department_id" ;

	public final static java.lang.String ALL_CAPTIONS = "部门名称,ECMC部门编码";

	public java.lang.String getDepartmentName() {
		return this.__department_name;
	}

	public void setDepartmentName( java.lang.String value ) {
		this.__department_name = value;
	}

	public java.lang.Integer getEcmcDepartmentId() {
		return this.__ecmc_department_id;
	}

	public void setEcmcDepartmentId( java.lang.Integer value ) {
		this.__ecmc_department_id = value;
	}

	public void cloneCopy(BaseGetECMCDepartmentByPlate __bean){
		__bean.setDepartmentName(getDepartmentName());
		__bean.setEcmcDepartmentId(getEcmcDepartmentId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getDepartmentName() == null ? "" : getDepartmentName());
		sb.append(",");
		sb.append(getEcmcDepartmentId() == null ? "" : getEcmcDepartmentId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetECMCDepartmentByPlate o) {
		return __department_name == null ? -1 : __department_name.compareTo(o.getDepartmentName());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__department_name);
		hash = 97 * hash + Objects.hashCode(this.__ecmc_department_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetECMCDepartmentByPlate o = (BaseGetECMCDepartmentByPlate)obj;
		if(!Objects.equals(this.__department_name, o.getDepartmentName())) return false;
		if(!Objects.equals(this.__ecmc_department_id, o.getEcmcDepartmentId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDepartmentName() != null) sb.append(__wrapString(count++, "departmentName", getDepartmentName()));
		if(getEcmcDepartmentId() != null) sb.append(__wrapNumber(count++, "ecmcDepartmentId", getEcmcDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("departmentName")) != null) setDepartmentName(__getString(val));
		if((val = values.get("ecmcDepartmentId")) != null) setEcmcDepartmentId(__getInt(val)); 
	}

	protected java.lang.String  __department_name ;
	protected java.lang.Integer  __ecmc_department_id ;
}
