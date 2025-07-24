package pomplatform.projectSettlement.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadSettlementEmployees extends GenericBase implements BaseFactory<BaseOnLoadSettlementEmployees>, Comparable<BaseOnLoadSettlementEmployees> 
{


	public static BaseOnLoadSettlementEmployees newInstance(){
		return new BaseOnLoadSettlementEmployees();
	}

	@Override
	public BaseOnLoadSettlementEmployees make(){
		BaseOnLoadSettlementEmployees b = new BaseOnLoadSettlementEmployees();
		return b;
	}

	public final static java.lang.String CS_SETTLEMENT_DETAIL_ID = "settlement_detail_id" ;
	public final static java.lang.String CS_SETTLEMENT_ID = "settlement_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_WORK_CONTENT = "work_content" ;
	public final static java.lang.String CS_SETTLEMENT_DATE = "settlement_date" ;
	public final static java.lang.String CS_PLAN_AMOUNT = "plan_amount" ;
	public final static java.lang.String CS_REAL_AMOUNT = "real_amount" ;
	public final static java.lang.String CS_PROJECT_COST = "project_cost" ;
	public final static java.lang.String CS_FINAL_AMOUNT = "final_amount" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_FINISH_PERCENT = "finish_percent" ;
	public final static java.lang.String CS_IS_RETURN = "is_return" ;
	public final static java.lang.String CS_ADJUSTED_AMOUNT = "adjusted_amount" ;
	public final static java.lang.String CS_SETTLEMENT_STATUS = "settlement_status" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_COST = "cost" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;

	public final static java.lang.String ALL_CAPTIONS = "结算详细代码,结算代码,项目代码,结算操作人,工作内容,结算日期,计划分配,实际分配,历史分摊成本,最终获得,结算状态system_dictionary_97,完成百分比,该记录的积分是否回收的标识，true回收； false不回收,调整后的积分,3已驳回,历史确认积分,本次分摊成本,员工编号,员工姓名";

	public java.lang.Integer getSettlementDetailId() {
		return this.__settlement_detail_id;
	}

	public void setSettlementDetailId( java.lang.Integer value ) {
		this.__settlement_detail_id = value;
	}

	public java.lang.Integer getSettlementId() {
		return this.__settlement_id;
	}

	public void setSettlementId( java.lang.Integer value ) {
		this.__settlement_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getWorkContent() {
		return this.__work_content;
	}

	public void setWorkContent( java.lang.String value ) {
		this.__work_content = value;
	}

	public java.util.Date getSettlementDate() {
		return this.__settlement_date;
	}

	public void setSettlementDate( java.util.Date value ) {
		this.__settlement_date = value;
	}

	public java.math.BigDecimal getPlanAmount() {
		return this.__plan_amount;
	}

	public void setPlanAmount( java.math.BigDecimal value ) {
		this.__plan_amount = value;
	}

	public java.math.BigDecimal getRealAmount() {
		return this.__real_amount;
	}

	public void setRealAmount( java.math.BigDecimal value ) {
		this.__real_amount = value;
	}

	public java.math.BigDecimal getProjectCost() {
		return this.__project_cost;
	}

	public void setProjectCost( java.math.BigDecimal value ) {
		this.__project_cost = value;
	}

	public java.math.BigDecimal getFinalAmount() {
		return this.__final_amount;
	}

	public void setFinalAmount( java.math.BigDecimal value ) {
		this.__final_amount = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.math.BigDecimal getFinishPercent() {
		return this.__finish_percent;
	}

	public void setFinishPercent( java.math.BigDecimal value ) {
		this.__finish_percent = value;
	}

	public java.lang.Boolean getIsReturn() {
		return this.__is_return;
	}

	public void setIsReturn( java.lang.Boolean value ) {
		this.__is_return = value;
	}

	public java.math.BigDecimal getAdjustedAmount() {
		return this.__adjusted_amount;
	}

	public void setAdjustedAmount( java.math.BigDecimal value ) {
		this.__adjusted_amount = value;
	}

	public java.lang.Integer getSettlementStatus() {
		return this.__settlement_status;
	}

	public void setSettlementStatus( java.lang.Integer value ) {
		this.__settlement_status = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.math.BigDecimal getCost() {
		return this.__cost;
	}

	public void setCost( java.math.BigDecimal value ) {
		this.__cost = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public void cloneCopy(BaseOnLoadSettlementEmployees __bean){
		__bean.setSettlementDetailId(getSettlementDetailId());
		__bean.setSettlementId(getSettlementId());
		__bean.setProjectId(getProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setWorkContent(getWorkContent());
		__bean.setSettlementDate(getSettlementDate());
		__bean.setPlanAmount(getPlanAmount());
		__bean.setRealAmount(getRealAmount());
		__bean.setProjectCost(getProjectCost());
		__bean.setFinalAmount(getFinalAmount());
		__bean.setStatus(getStatus());
		__bean.setFinishPercent(getFinishPercent());
		__bean.setIsReturn(getIsReturn());
		__bean.setAdjustedAmount(getAdjustedAmount());
		__bean.setSettlementStatus(getSettlementStatus());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setCost(getCost());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSettlementDetailId() == null ? "" : getSettlementDetailId());
		sb.append(",");
		sb.append(getSettlementId() == null ? "" : getSettlementId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getWorkContent() == null ? "" : getWorkContent());
		sb.append(",");
		sb.append(getSettlementDate() == null ? "" : sdf.format(getSettlementDate()));
		sb.append(",");
		sb.append(getPlanAmount() == null ? "" : getPlanAmount());
		sb.append(",");
		sb.append(getRealAmount() == null ? "" : getRealAmount());
		sb.append(",");
		sb.append(getProjectCost() == null ? "" : getProjectCost());
		sb.append(",");
		sb.append(getFinalAmount() == null ? "" : getFinalAmount());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getFinishPercent() == null ? "" : getFinishPercent());
		sb.append(",");
		sb.append(getIsReturn() == null ? "" : getIsReturn());
		sb.append(",");
		sb.append(getAdjustedAmount() == null ? "" : getAdjustedAmount());
		sb.append(",");
		sb.append(getSettlementStatus() == null ? "" : getSettlementStatus());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getCost() == null ? "" : getCost());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadSettlementEmployees o) {
		return __settlement_detail_id == null ? -1 : __settlement_detail_id.compareTo(o.getSettlementDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__settlement_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__settlement_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__work_content);
		hash = 97 * hash + Objects.hashCode(this.__settlement_date);
		hash = 97 * hash + Objects.hashCode(this.__plan_amount);
		hash = 97 * hash + Objects.hashCode(this.__real_amount);
		hash = 97 * hash + Objects.hashCode(this.__project_cost);
		hash = 97 * hash + Objects.hashCode(this.__final_amount);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__finish_percent);
		hash = 97 * hash + Objects.hashCode(this.__is_return);
		hash = 97 * hash + Objects.hashCode(this.__adjusted_amount);
		hash = 97 * hash + Objects.hashCode(this.__settlement_status);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__cost);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadSettlementEmployees o = (BaseOnLoadSettlementEmployees)obj;
		if(!Objects.equals(this.__settlement_detail_id, o.getSettlementDetailId())) return false;
		if(!Objects.equals(this.__settlement_id, o.getSettlementId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__work_content, o.getWorkContent())) return false;
		if(!Objects.equals(this.__settlement_date, o.getSettlementDate())) return false;
		if(!Objects.equals(this.__plan_amount, o.getPlanAmount())) return false;
		if(!Objects.equals(this.__real_amount, o.getRealAmount())) return false;
		if(!Objects.equals(this.__project_cost, o.getProjectCost())) return false;
		if(!Objects.equals(this.__final_amount, o.getFinalAmount())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__finish_percent, o.getFinishPercent())) return false;
		if(!Objects.equals(this.__is_return, o.getIsReturn())) return false;
		if(!Objects.equals(this.__adjusted_amount, o.getAdjustedAmount())) return false;
		if(!Objects.equals(this.__settlement_status, o.getSettlementStatus())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__cost, o.getCost())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSettlementDetailId() != null) sb.append(__wrapNumber(count++, "settlementDetailId", getSettlementDetailId()));
		if(getSettlementId() != null) sb.append(__wrapNumber(count++, "settlementId", getSettlementId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getWorkContent() != null) sb.append(__wrapString(count++, "workContent", getWorkContent()));
		if(getSettlementDate() != null) sb.append(__wrapDate(count++, "settlementDate", getSettlementDate()));
		if(getPlanAmount() != null) sb.append(__wrapDecimal(count++, "planAmount", getPlanAmount()));
		if(getRealAmount() != null) sb.append(__wrapDecimal(count++, "realAmount", getRealAmount()));
		if(getProjectCost() != null) sb.append(__wrapDecimal(count++, "projectCost", getProjectCost()));
		if(getFinalAmount() != null) sb.append(__wrapDecimal(count++, "finalAmount", getFinalAmount()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getFinishPercent() != null) sb.append(__wrapDecimal(count++, "finishPercent", getFinishPercent()));
		if(getIsReturn() != null) sb.append(__wrapBoolean(count++, "isReturn", getIsReturn()));
		if(getAdjustedAmount() != null) sb.append(__wrapDecimal(count++, "adjustedAmount", getAdjustedAmount()));
		if(getSettlementStatus() != null) sb.append(__wrapNumber(count++, "settlementStatus", getSettlementStatus()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getCost() != null) sb.append(__wrapDecimal(count++, "cost", getCost()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSettlementDetailId() != null) res.put("settlementDetailId", getSettlementDetailId());
		if(getSettlementId() != null) res.put("settlementId", getSettlementId());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getWorkContent() != null) res.put("workContent", getWorkContent());
		if(getSettlementDate() != null) res.put("settlementDate", getSettlementDate());
		if(getPlanAmount() != null) res.put("planAmount", getPlanAmount());
		if(getRealAmount() != null) res.put("realAmount", getRealAmount());
		if(getProjectCost() != null) res.put("projectCost", getProjectCost());
		if(getFinalAmount() != null) res.put("finalAmount", getFinalAmount());
		if(getStatus() != null) res.put("status", getStatus());
		if(getFinishPercent() != null) res.put("finishPercent", getFinishPercent());
		if(getIsReturn() != null) res.put("isReturn", getIsReturn());
		if(getAdjustedAmount() != null) res.put("adjustedAmount", getAdjustedAmount());
		if(getSettlementStatus() != null) res.put("settlementStatus", getSettlementStatus());
		if(getSureIntegral() != null) res.put("sureIntegral", getSureIntegral());
		if(getCost() != null) res.put("cost", getCost());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("settlementDetailId")) != null) setSettlementDetailId(__getInt(val)); 
		if((val = values.get("settlementId")) != null) setSettlementId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("workContent")) != null) setWorkContent(__getString(val));
		if((val = values.get("settlementDate")) != null) setSettlementDate(__getDate(val)); 
		if((val = values.get("planAmount")) != null) setPlanAmount(__getDecimal(val));  
		if((val = values.get("realAmount")) != null) setRealAmount(__getDecimal(val));  
		if((val = values.get("projectCost")) != null) setProjectCost(__getDecimal(val));  
		if((val = values.get("finalAmount")) != null) setFinalAmount(__getDecimal(val));  
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("finishPercent")) != null) setFinishPercent(__getDecimal(val));  
		if((val = values.get("isReturn")) != null) setIsReturn(__getBoolean(val));
		if((val = values.get("adjustedAmount")) != null) setAdjustedAmount(__getDecimal(val));  
		if((val = values.get("settlementStatus")) != null) setSettlementStatus(__getInt(val)); 
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("cost")) != null) setCost(__getDecimal(val));  
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
	}

	protected java.lang.Integer  __settlement_detail_id ;
	protected java.lang.Integer  __settlement_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __work_content ;
	protected java.util.Date  __settlement_date ;
	protected java.math.BigDecimal  __plan_amount ;
	protected java.math.BigDecimal  __real_amount ;
	protected java.math.BigDecimal  __project_cost ;
	protected java.math.BigDecimal  __final_amount ;
	protected java.lang.Integer  __status ;
	protected java.math.BigDecimal  __finish_percent ;
	protected java.lang.Boolean  __is_return ;
	protected java.math.BigDecimal  __adjusted_amount ;
	protected java.lang.Integer  __settlement_status ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.math.BigDecimal  __cost ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
}
