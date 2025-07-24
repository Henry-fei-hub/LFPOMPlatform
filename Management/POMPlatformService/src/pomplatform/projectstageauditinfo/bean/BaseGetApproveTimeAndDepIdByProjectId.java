package pomplatform.projectstageauditinfo.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetApproveTimeAndDepIdByProjectId extends GenericBase implements BaseFactory<BaseGetApproveTimeAndDepIdByProjectId>, Comparable<BaseGetApproveTimeAndDepIdByProjectId> 
{


	public static BaseGetApproveTimeAndDepIdByProjectId newInstance(){
		return new BaseGetApproveTimeAndDepIdByProjectId();
	}

	@Override
	public BaseGetApproveTimeAndDepIdByProjectId make(){
		BaseGetApproveTimeAndDepIdByProjectId b = new BaseGetApproveTimeAndDepIdByProjectId();
		return b;
	}

	public final static java.lang.String CS_PROJECT_APPROVAL_TIME = "project_approval_time" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_CONTRACT_SIGNING_STATUS = "contract_signing_status" ;

	public final static java.lang.String ALL_CAPTIONS = "立项时间,从属部门,合同签订状态";

	public java.util.Date getProjectApprovalTime() {
		return this.__project_approval_time;
	}

	public void setProjectApprovalTime( java.util.Date value ) {
		this.__project_approval_time = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getContractSigningStatus() {
		return this.__contract_signing_status;
	}

	public void setContractSigningStatus( java.lang.Integer value ) {
		this.__contract_signing_status = value;
	}

	public void cloneCopy(BaseGetApproveTimeAndDepIdByProjectId __bean){
		__bean.setProjectApprovalTime(getProjectApprovalTime());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setContractSigningStatus(getContractSigningStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectApprovalTime() == null ? "" : sdf.format(getProjectApprovalTime()));
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getContractSigningStatus() == null ? "" : getContractSigningStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetApproveTimeAndDepIdByProjectId o) {
		return __project_approval_time == null ? -1 : __project_approval_time.compareTo(o.getProjectApprovalTime());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_approval_time);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_signing_status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetApproveTimeAndDepIdByProjectId o = (BaseGetApproveTimeAndDepIdByProjectId)obj;
		if(!Objects.equals(this.__project_approval_time, o.getProjectApprovalTime())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__contract_signing_status, o.getContractSigningStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectApprovalTime() != null) sb.append(__wrapDate(count++, "projectApprovalTime", getProjectApprovalTime()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getContractSigningStatus() != null) sb.append(__wrapNumber(count++, "contractSigningStatus", getContractSigningStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectApprovalTime")) != null) setProjectApprovalTime(__getDate(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("contractSigningStatus")) != null) setContractSigningStatus(__getInt(val)); 
	}

	protected java.util.Date  __project_approval_time ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __contract_signing_status ;
}
