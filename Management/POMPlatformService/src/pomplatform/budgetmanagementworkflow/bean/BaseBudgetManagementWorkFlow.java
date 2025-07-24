package pomplatform.budgetmanagementworkflow.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;
import com.pomplatform.db.bean.BaseBudgetManagementDetail;

public class BaseBudgetManagementWorkFlow extends GenericBase implements BaseFactory<BaseBudgetManagementWorkFlow>, Comparable<BaseBudgetManagementWorkFlow> 
{


	public static BaseBudgetManagementWorkFlow newInstance(){
		return new BaseBudgetManagementWorkFlow();
	}

	@Override
	public BaseBudgetManagementWorkFlow make(){
		BaseBudgetManagementWorkFlow b = new BaseBudgetManagementWorkFlow();
		return b;
	}

	public final static java.lang.String CS_BUDGET_MANAGEMENT_ID = "budget_management_id" ;
	public final static java.lang.String CS_BD_CODE = "bd_code" ;
	public final static java.lang.String CS_BD_TYPE = "bd_type" ;
	public final static java.lang.String CS_BD_TOTAL_AMOUNT = "bd_total_amount" ;
	public final static java.lang.String CS_BD_USE_AMOUNT = "bd_use_amount" ;
	public final static java.lang.String CS_BD_REST_AMOUNT = "bd_rest_amount" ;
	public final static java.lang.String CS_BD_APPLY_EMPLOYEE_ID = "bd_apply_employee_id" ;
	public final static java.lang.String CS_BD_APPLY_TIME = "bd_apply_time" ;
	public final static java.lang.String CS_BD_ESTIMATECLOSE_TIME = "bd_estimateclose_time" ;
	public final static java.lang.String CS_BD_STATUS = "bd_status" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_BD_REMARK = "bd_remark" ;
	public final static java.lang.String CS_INPUT_TAX_INVOICE_ID = "input_tax_invoice_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键id,预算编号,预算类型,预算总金额,预算已用金额,预算剩余金额,申请人id,申请时间,预期关闭时间,预算单状态,项目编号,预算备注,发票编码,申请人归属部门,申请人归属公司";

	public java.lang.Integer getBudgetManagementId() {
		return this.__budget_management_id;
	}

	public void setBudgetManagementId( java.lang.Integer value ) {
		this.__budget_management_id = value;
	}

	public java.lang.String getBdCode() {
		return this.__bd_code;
	}

	public void setBdCode( java.lang.String value ) {
		this.__bd_code = value;
	}

	public java.lang.Integer getBdType() {
		return this.__bd_type;
	}

	public void setBdType( java.lang.Integer value ) {
		this.__bd_type = value;
	}

	public java.math.BigDecimal getBdTotalAmount() {
		return this.__bd_total_amount;
	}

	public void setBdTotalAmount( java.math.BigDecimal value ) {
		this.__bd_total_amount = value;
	}

	public java.math.BigDecimal getBdUseAmount() {
		return this.__bd_use_amount;
	}

	public void setBdUseAmount( java.math.BigDecimal value ) {
		this.__bd_use_amount = value;
	}

	public java.math.BigDecimal getBdRestAmount() {
		return this.__bd_rest_amount;
	}

	public void setBdRestAmount( java.math.BigDecimal value ) {
		this.__bd_rest_amount = value;
	}

	public java.lang.Integer getBdApplyEmployeeId() {
		return this.__bd_apply_employee_id;
	}

	public void setBdApplyEmployeeId( java.lang.Integer value ) {
		this.__bd_apply_employee_id = value;
	}

	public java.util.Date getBdApplyTime() {
		return this.__bd_apply_time;
	}

	public void setBdApplyTime( java.util.Date value ) {
		this.__bd_apply_time = value;
	}

	public java.util.Date getBdEstimatecloseTime() {
		return this.__bd_estimateclose_time;
	}

	public void setBdEstimatecloseTime( java.util.Date value ) {
		this.__bd_estimateclose_time = value;
	}

	public java.lang.Integer getBdStatus() {
		return this.__bd_status;
	}

	public void setBdStatus( java.lang.Integer value ) {
		this.__bd_status = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.String getBdRemark() {
		return this.__bd_remark;
	}

	public void setBdRemark( java.lang.String value ) {
		this.__bd_remark = value;
	}

	public java.lang.Integer getInputTaxInvoiceId() {
		return this.__input_tax_invoice_id;
	}

	public void setInputTaxInvoiceId( java.lang.Integer value ) {
		this.__input_tax_invoice_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.util.List<BaseBudgetManagementDetail> getDetailBudgetManagementDetail() {
		return this.__detailBudgetManagementDetail;
	}

	public void setDetailBudgetManagementDetail( java.util.List<BaseBudgetManagementDetail> value ) {
		this.__detailBudgetManagementDetail = value;
	}

	public void cloneCopy(BaseBudgetManagementWorkFlow __bean){
		__bean.setBudgetManagementId(getBudgetManagementId());
		__bean.setBdCode(getBdCode());
		__bean.setBdType(getBdType());
		__bean.setBdTotalAmount(getBdTotalAmount());
		__bean.setBdUseAmount(getBdUseAmount());
		__bean.setBdRestAmount(getBdRestAmount());
		__bean.setBdApplyEmployeeId(getBdApplyEmployeeId());
		__bean.setBdApplyTime(getBdApplyTime());
		__bean.setBdEstimatecloseTime(getBdEstimatecloseTime());
		__bean.setBdStatus(getBdStatus());
		__bean.setProjectId(getProjectId());
		__bean.setBdRemark(getBdRemark());
		__bean.setInputTaxInvoiceId(getInputTaxInvoiceId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setCompanyId(getCompanyId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBudgetManagementId() == null ? "" : getBudgetManagementId());
		sb.append(",");
		sb.append(getBdCode() == null ? "" : getBdCode());
		sb.append(",");
		sb.append(getBdType() == null ? "" : getBdType());
		sb.append(",");
		sb.append(getBdTotalAmount() == null ? "" : getBdTotalAmount());
		sb.append(",");
		sb.append(getBdUseAmount() == null ? "" : getBdUseAmount());
		sb.append(",");
		sb.append(getBdRestAmount() == null ? "" : getBdRestAmount());
		sb.append(",");
		sb.append(getBdApplyEmployeeId() == null ? "" : getBdApplyEmployeeId());
		sb.append(",");
		sb.append(getBdApplyTime() == null ? "" : sdf.format(getBdApplyTime()));
		sb.append(",");
		sb.append(getBdEstimatecloseTime() == null ? "" : sdf.format(getBdEstimatecloseTime()));
		sb.append(",");
		sb.append(getBdStatus() == null ? "" : getBdStatus());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getBdRemark() == null ? "" : getBdRemark());
		sb.append(",");
		sb.append(getInputTaxInvoiceId() == null ? "" : getInputTaxInvoiceId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseBudgetManagementWorkFlow o) {
		return __budget_management_id == null ? -1 : __budget_management_id.compareTo(o.getBudgetManagementId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__budget_management_id);
		hash = 97 * hash + Objects.hashCode(this.__bd_code);
		hash = 97 * hash + Objects.hashCode(this.__bd_type);
		hash = 97 * hash + Objects.hashCode(this.__bd_total_amount);
		hash = 97 * hash + Objects.hashCode(this.__bd_use_amount);
		hash = 97 * hash + Objects.hashCode(this.__bd_rest_amount);
		hash = 97 * hash + Objects.hashCode(this.__bd_apply_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__bd_apply_time);
		hash = 97 * hash + Objects.hashCode(this.__bd_estimateclose_time);
		hash = 97 * hash + Objects.hashCode(this.__bd_status);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__bd_remark);
		hash = 97 * hash + Objects.hashCode(this.__input_tax_invoice_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseBudgetManagementWorkFlow o = (BaseBudgetManagementWorkFlow)obj;
		if(!Objects.equals(this.__budget_management_id, o.getBudgetManagementId())) return false;
		if(!Objects.equals(this.__bd_code, o.getBdCode())) return false;
		if(!Objects.equals(this.__bd_type, o.getBdType())) return false;
		if(!Objects.equals(this.__bd_total_amount, o.getBdTotalAmount())) return false;
		if(!Objects.equals(this.__bd_use_amount, o.getBdUseAmount())) return false;
		if(!Objects.equals(this.__bd_rest_amount, o.getBdRestAmount())) return false;
		if(!Objects.equals(this.__bd_apply_employee_id, o.getBdApplyEmployeeId())) return false;
		if(!Objects.equals(this.__bd_apply_time, o.getBdApplyTime())) return false;
		if(!Objects.equals(this.__bd_estimateclose_time, o.getBdEstimatecloseTime())) return false;
		if(!Objects.equals(this.__bd_status, o.getBdStatus())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__bd_remark, o.getBdRemark())) return false;
		if(!Objects.equals(this.__input_tax_invoice_id, o.getInputTaxInvoiceId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBudgetManagementId() != null) sb.append(__wrapNumber(count++, "budgetManagementId", getBudgetManagementId()));
		if(getBdCode() != null) sb.append(__wrapString(count++, "bdCode", getBdCode()));
		if(getBdType() != null) sb.append(__wrapNumber(count++, "bdType", getBdType()));
		if(getBdTotalAmount() != null) sb.append(__wrapDecimal(count++, "bdTotalAmount", getBdTotalAmount()));
		if(getBdUseAmount() != null) sb.append(__wrapDecimal(count++, "bdUseAmount", getBdUseAmount()));
		if(getBdRestAmount() != null) sb.append(__wrapDecimal(count++, "bdRestAmount", getBdRestAmount()));
		if(getBdApplyEmployeeId() != null) sb.append(__wrapNumber(count++, "bdApplyEmployeeId", getBdApplyEmployeeId()));
		if(getBdApplyTime() != null) sb.append(__wrapDate(count++, "bdApplyTime", getBdApplyTime()));
		if(getBdEstimatecloseTime() != null) sb.append(__wrapDate(count++, "bdEstimatecloseTime", getBdEstimatecloseTime()));
		if(getBdStatus() != null) sb.append(__wrapNumber(count++, "bdStatus", getBdStatus()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getBdRemark() != null) sb.append(__wrapString(count++, "bdRemark", getBdRemark()));
		if(getInputTaxInvoiceId() != null) sb.append(__wrapNumber(count++, "inputTaxInvoiceId", getInputTaxInvoiceId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getDetailBudgetManagementDetail() != null)  sb.append(__wrapList(count++, "detailBudgetManagementDetail", getDetailBudgetManagementDetail()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("budgetManagementId")) != null) setBudgetManagementId(__getInt(val)); 
		if((val = values.get("bdCode")) != null) setBdCode(__getString(val));
		if((val = values.get("bdType")) != null) setBdType(__getInt(val)); 
		if((val = values.get("bdTotalAmount")) != null) setBdTotalAmount(__getDecimal(val));  
		if((val = values.get("bdUseAmount")) != null) setBdUseAmount(__getDecimal(val));  
		if((val = values.get("bdRestAmount")) != null) setBdRestAmount(__getDecimal(val));  
		if((val = values.get("bdApplyEmployeeId")) != null) setBdApplyEmployeeId(__getInt(val)); 
		if((val = values.get("bdApplyTime")) != null) setBdApplyTime(__getDate(val)); 
		if((val = values.get("bdEstimatecloseTime")) != null) setBdEstimatecloseTime(__getDate(val)); 
		if((val = values.get("bdStatus")) != null) setBdStatus(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("bdRemark")) != null) setBdRemark(__getString(val));
		if((val = values.get("inputTaxInvoiceId")) != null) setInputTaxInvoiceId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("detailBudgetManagementDetail")) != null) setDetailBudgetManagementDetail(__getList(val, BaseBudgetManagementDetail.newInstance()));
	}

	protected java.lang.Integer  __budget_management_id ;
	protected java.lang.String  __bd_code ;
	protected java.lang.Integer  __bd_type ;
	protected java.math.BigDecimal  __bd_total_amount ;
	protected java.math.BigDecimal  __bd_use_amount ;
	protected java.math.BigDecimal  __bd_rest_amount ;
	protected java.lang.Integer  __bd_apply_employee_id ;
	protected java.util.Date  __bd_apply_time ;
	protected java.util.Date  __bd_estimateclose_time ;
	protected java.lang.Integer  __bd_status ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __bd_remark ;
	protected java.lang.Integer  __input_tax_invoice_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __company_id ;
	protected java.util.List<BaseBudgetManagementDetail> __detailBudgetManagementDetail = null;
}
