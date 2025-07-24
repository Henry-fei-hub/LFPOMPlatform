package pomplatform.preProjects.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetProjectECMCEmployeeInfo extends GenericBase implements BaseFactory<BaseGetProjectECMCEmployeeInfo>, Comparable<BaseGetProjectECMCEmployeeInfo> 
{


	public static BaseGetProjectECMCEmployeeInfo newInstance(){
		return new BaseGetProjectECMCEmployeeInfo();
	}

	@Override
	public BaseGetProjectECMCEmployeeInfo make(){
		BaseGetProjectECMCEmployeeInfo b = new BaseGetProjectECMCEmployeeInfo();
		return b;
	}

	public final static java.lang.String CS_RELATION = "relation" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_ECMC_USER_ID = "ecmc_user_id" ;

	public final static java.lang.String ALL_CAPTIONS = "员工和主项目的关系    1项目营销专员   2项目营销团队负责人   3项目经理   4项目主管领导,员工姓名,ECMC用户ID";

	public java.lang.Integer getRelation() {
		return this.__relation;
	}

	public void setRelation( java.lang.Integer value ) {
		this.__relation = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.String getEcmcUserId() {
		return this.__ecmc_user_id;
	}

	public void setEcmcUserId( java.lang.String value ) {
		this.__ecmc_user_id = value;
	}

	public void cloneCopy(BaseGetProjectECMCEmployeeInfo __bean){
		__bean.setRelation(getRelation());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setEcmcUserId(getEcmcUserId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getRelation() == null ? "" : getRelation());
		sb.append(",");
		String strEmployeeName = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeName()));
		sb.append(strEmployeeName == null ? "" : strEmployeeName);
		sb.append(",");
		sb.append(getEcmcUserId() == null ? "" : getEcmcUserId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetProjectECMCEmployeeInfo o) {
		return __relation == null ? -1 : __relation.compareTo(o.getRelation());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__relation);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__ecmc_user_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetProjectECMCEmployeeInfo o = (BaseGetProjectECMCEmployeeInfo)obj;
		if(!Objects.equals(this.__relation, o.getRelation())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__ecmc_user_id, o.getEcmcUserId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getRelation() != null) sb.append(__wrapNumber(count++, "relation", getRelation()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getEcmcUserId() != null) sb.append(__wrapString(count++, "ecmcUserId", getEcmcUserId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("relation")) != null) setRelation(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("ecmcUserId")) != null) setEcmcUserId(__getString(val));
	}

	protected java.lang.Integer  __relation ;
	protected java.lang.String  __employee_name ;
	protected java.lang.String  __ecmc_user_id ;
}
