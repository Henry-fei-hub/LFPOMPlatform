package pomplatform.employees.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseGetEmployeeByRoleAndPlate extends GenericBase implements BaseFactory<BaseGetEmployeeByRoleAndPlate>, Comparable<BaseGetEmployeeByRoleAndPlate> 
{


	public static BaseGetEmployeeByRoleAndPlate newInstance(){
		return new BaseGetEmployeeByRoleAndPlate();
	}

	@Override
	public BaseGetEmployeeByRoleAndPlate make(){
		BaseGetEmployeeByRoleAndPlate b = new BaseGetEmployeeByRoleAndPlate();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_COMPANY_WEIXIN = "company_weixin" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;

	public final static java.lang.String ALL_CAPTIONS = "员工编码,企业微信账号,业务部门";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getCompanyWeixin() {
		return this.__company_weixin;
	}

	public void setCompanyWeixin( java.lang.String value ) {
		this.__company_weixin = value;
	}

	public java.lang.Integer getPlateId() {
		return __plate_id;
	}

	public void setPlateId(java.lang.Integer value) {
		this.__plate_id = value;
	}

	public void cloneCopy(BaseGetEmployeeByRoleAndPlate __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCompanyWeixin(getCompanyWeixin());
		__bean.setPlateId(getPlateId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getCompanyWeixin() == null ? "" : getCompanyWeixin());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetEmployeeByRoleAndPlate o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__company_weixin);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetEmployeeByRoleAndPlate o = (BaseGetEmployeeByRoleAndPlate)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__company_weixin, o.getCompanyWeixin())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getCompanyWeixin() != null) sb.append(__wrapString(count++, "companyWeixin", getCompanyWeixin()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("companyWeixin")) != null) setCompanyWeixin(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __company_weixin ;
	protected java.lang.Integer  __plate_id ;
}
