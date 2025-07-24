package pomplatform.scapitaldistributionor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;
import com.pomplatform.db.bean.BaseCapitalDistributionLinkDepartment;
import com.pomplatform.db.bean.BaseCapitalDistributionLinkSubContract;

public class BaseScapitaldistributionor extends GenericBase implements BaseFactory<BaseScapitaldistributionor>, Comparable<BaseScapitaldistributionor> 
{


	public static BaseScapitaldistributionor newInstance(){
		return new BaseScapitaldistributionor();
	}

	@Override
	public BaseScapitaldistributionor make(){
		BaseScapitaldistributionor b = new BaseScapitaldistributionor();
		return b;
	}

	public final static java.lang.String CS_CAPITAL_DISTRIBUTION_ID = "capital_distribution_id" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_APPLY_EMPLOYEE_ID = "apply_employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_TITLE = "title" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CAPITAL_ID = "capital_id" ;
	public final static java.lang.String CS_APPLY_TIME = "apply_time" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_IS_COMPLETED = "is_completed" ;
	public final static java.lang.String CS_MAIN_PROFESSIONAL = "main_professional" ;
	public final static java.lang.String CS_CONTRACT_CHANGE_AMOUNT = "contract_change_amount" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,报销编号,流程编码,起草人,报销人,报销部门,title,归属公司,合同编码,回款编码,申请时间,完成时间,备注,是否完成,主专业,合同变更金额";

	public java.lang.Integer getCapitalDistributionId() {
		return this.__capital_distribution_id;
	}

	public void setCapitalDistributionId( java.lang.Integer value ) {
		this.__capital_distribution_id = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getApplyEmployeeId() {
		return this.__apply_employee_id;
	}

	public void setApplyEmployeeId( java.lang.Integer value ) {
		this.__apply_employee_id = value;
	}

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

	public java.lang.String getTitle() {
		return this.__title;
	}

	public void setTitle( java.lang.String value ) {
		this.__title = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	public java.util.Date getApplyTime() {
		return this.__apply_time;
	}

	public void setApplyTime( java.util.Date value ) {
		this.__apply_time = value;
	}

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Boolean getIsCompleted() {
		return this.__is_completed;
	}

	public void setIsCompleted( java.lang.Boolean value ) {
		this.__is_completed = value;
	}

	public java.lang.Integer getMainProfessional() {
		return this.__main_professional;
	}

	public void setMainProfessional( java.lang.Integer value ) {
		this.__main_professional = value;
	}

	public java.math.BigDecimal getContractChangeAmount() {
		return this.__contract_change_amount;
	}

	public void setContractChangeAmount( java.math.BigDecimal value ) {
		this.__contract_change_amount = value;
	}

	public java.util.List<BaseCapitalDistributionLinkDepartment> getDetailCapitalDistributionLinkDepartment() {
		return this.__detailCapitalDistributionLinkDepartment;
	}

	public void setDetailCapitalDistributionLinkDepartment( java.util.List<BaseCapitalDistributionLinkDepartment> value ) {
		this.__detailCapitalDistributionLinkDepartment = value;
	}

	public java.util.List<BaseCapitalDistributionLinkSubContract> getDetailCapitalDistributionLinkSubContract() {
		return this.__detailCapitalDistributionLinkSubContract;
	}

	public void setDetailCapitalDistributionLinkSubContract( java.util.List<BaseCapitalDistributionLinkSubContract> value ) {
		this.__detailCapitalDistributionLinkSubContract = value;
	}

	public void cloneCopy(BaseScapitaldistributionor __bean){
		__bean.setCapitalDistributionId(getCapitalDistributionId());
		__bean.setCode(getCode());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setApplyEmployeeId(getApplyEmployeeId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setTitle(getTitle());
		__bean.setCompanyId(getCompanyId());
		__bean.setContractId(getContractId());
		__bean.setCapitalId(getCapitalId());
		__bean.setApplyTime(getApplyTime());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setRemark(getRemark());
		__bean.setIsCompleted(getIsCompleted());
		__bean.setMainProfessional(getMainProfessional());
		__bean.setContractChangeAmount(getContractChangeAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCapitalDistributionId() == null ? "" : getCapitalDistributionId());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getApplyEmployeeId() == null ? "" : getApplyEmployeeId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getTitle() == null ? "" : getTitle());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getCapitalId() == null ? "" : getCapitalId());
		sb.append(",");
		sb.append(getApplyTime() == null ? "" : sdf.format(getApplyTime()));
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getIsCompleted() == null ? "" : getIsCompleted());
		sb.append(",");
		sb.append(getMainProfessional() == null ? "" : getMainProfessional());
		sb.append(",");
		sb.append(getContractChangeAmount() == null ? "" : getContractChangeAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseScapitaldistributionor o) {
		return __capital_distribution_id == null ? -1 : __capital_distribution_id.compareTo(o.getCapitalDistributionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__capital_distribution_id);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__apply_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__title);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__capital_id);
		hash = 97 * hash + Objects.hashCode(this.__apply_time);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__is_completed);
		hash = 97 * hash + Objects.hashCode(this.__main_professional);
		hash = 97 * hash + Objects.hashCode(this.__contract_change_amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseScapitaldistributionor o = (BaseScapitaldistributionor)obj;
		if(!Objects.equals(this.__capital_distribution_id, o.getCapitalDistributionId())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__apply_employee_id, o.getApplyEmployeeId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__title, o.getTitle())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__capital_id, o.getCapitalId())) return false;
		if(!Objects.equals(this.__apply_time, o.getApplyTime())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__is_completed, o.getIsCompleted())) return false;
		if(!Objects.equals(this.__main_professional, o.getMainProfessional())) return false;
		if(!Objects.equals(this.__contract_change_amount, o.getContractChangeAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCapitalDistributionId() != null) sb.append(__wrapNumber(count++, "capitalDistributionId", getCapitalDistributionId()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getApplyEmployeeId() != null) sb.append(__wrapNumber(count++, "applyEmployeeId", getApplyEmployeeId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getTitle() != null) sb.append(__wrapString(count++, "title", getTitle()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getCapitalId() != null) sb.append(__wrapNumber(count++, "capitalId", getCapitalId()));
		if(getApplyTime() != null) sb.append(__wrapDate(count++, "applyTime", getApplyTime()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getIsCompleted() != null) sb.append(__wrapBoolean(count++, "isCompleted", getIsCompleted()));
		if(getMainProfessional() != null) sb.append(__wrapNumber(count++, "mainProfessional", getMainProfessional()));
		if(getContractChangeAmount() != null) sb.append(__wrapDecimal(count++, "contractChangeAmount", getContractChangeAmount()));
		if(getDetailCapitalDistributionLinkDepartment() != null)  sb.append(__wrapList(count++, "detailCapitalDistributionLinkDepartment", getDetailCapitalDistributionLinkDepartment()));
		if(getDetailCapitalDistributionLinkSubContract() != null)  sb.append(__wrapList(count++, "detailCapitalDistributionLinkSubContract", getDetailCapitalDistributionLinkSubContract()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("capitalDistributionId")) != null) setCapitalDistributionId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("applyEmployeeId")) != null) setApplyEmployeeId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("title")) != null) setTitle(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("applyTime")) != null) setApplyTime(__getDate(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("isCompleted")) != null) setIsCompleted(__getBoolean(val));
		if((val = values.get("mainProfessional")) != null) setMainProfessional(__getInt(val)); 
		if((val = values.get("contractChangeAmount")) != null) setContractChangeAmount(__getDecimal(val));  
		if((val = values.get("detailCapitalDistributionLinkDepartment")) != null) setDetailCapitalDistributionLinkDepartment(__getList(val, BaseCapitalDistributionLinkDepartment.newInstance()));
		if((val = values.get("detailCapitalDistributionLinkSubContract")) != null) setDetailCapitalDistributionLinkSubContract(__getList(val, BaseCapitalDistributionLinkSubContract.newInstance()));
	}

	protected java.lang.Integer  __capital_distribution_id ;
	protected java.lang.String  __code ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __apply_employee_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.String  __title ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __capital_id ;
	protected java.util.Date  __apply_time ;
	protected java.util.Date  __complete_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Boolean  __is_completed ;
	protected java.lang.Integer  __main_professional ;
	protected java.math.BigDecimal  __contract_change_amount ;
	protected java.util.List<BaseCapitalDistributionLinkDepartment> __detailCapitalDistributionLinkDepartment = null;
	protected java.util.List<BaseCapitalDistributionLinkSubContract> __detailCapitalDistributionLinkSubContract = null;
}
