package pomplatform.projectSettlement.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;
import com.pomplatform.db.bean.BaseProjectSettlementDetail;

public class BaseProjectSettlementProcessApplication extends GenericBase implements BaseFactory<BaseProjectSettlementProcessApplication>, Comparable<BaseProjectSettlementProcessApplication> 
{


	public static BaseProjectSettlementProcessApplication newInstance(){
		return new BaseProjectSettlementProcessApplication();
	}

	@Override
	public BaseProjectSettlementProcessApplication make(){
		BaseProjectSettlementProcessApplication b = new BaseProjectSettlementProcessApplication();
		return b;
	}

	public final static java.lang.String CS_SETTLEMENT_ID = "settlement_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_SETTLEMENT_DATE = "settlement_date" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static java.lang.String CS_TOTAL_COST = "total_cost" ;
	public final static java.lang.String CS_PROJECT_AMOUNT = "project_amount" ;
	public final static java.lang.String CS_LEFT_AMOUNT = "left_amount" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_SETTLEMENT_STATUS = "settlement_status" ;
	public final static java.lang.String CS_FLAG = "flag" ;

	public final static java.lang.String ALL_CAPTIONS = "结算代码,项目代码,结算操作人,结算原因,结算日期,确认积分,项目成本,项目积分,项目结余积分,结算状态,项目阶段,3已驳回,1历史数据结算；2新方式数据结算";

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

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.util.Date getSettlementDate() {
		return this.__settlement_date;
	}

	public void setSettlementDate( java.util.Date value ) {
		this.__settlement_date = value;
	}

	public java.math.BigDecimal getTotalAmount() {
		return this.__total_amount;
	}

	public void setTotalAmount( java.math.BigDecimal value ) {
		this.__total_amount = value;
	}

	public java.math.BigDecimal getTotalCost() {
		return this.__total_cost;
	}

	public void setTotalCost( java.math.BigDecimal value ) {
		this.__total_cost = value;
	}

	public java.math.BigDecimal getProjectAmount() {
		return this.__project_amount;
	}

	public void setProjectAmount( java.math.BigDecimal value ) {
		this.__project_amount = value;
	}

	public java.math.BigDecimal getLeftAmount() {
		return this.__left_amount;
	}

	public void setLeftAmount( java.math.BigDecimal value ) {
		this.__left_amount = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getStageId() {
		return this.__stage_id;
	}

	public void setStageId( java.lang.Integer value ) {
		this.__stage_id = value;
	}

	public java.lang.Integer getSettlementStatus() {
		return this.__settlement_status;
	}

	public void setSettlementStatus( java.lang.Integer value ) {
		this.__settlement_status = value;
	}

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}

	public java.util.List<BaseProjectSettlementDetail> getDetailProjectSettlementDetail() {
		return this.__detailProjectSettlementDetail;
	}

	public void setDetailProjectSettlementDetail( java.util.List<BaseProjectSettlementDetail> value ) {
		this.__detailProjectSettlementDetail = value;
	}

	public void cloneCopy(BaseProjectSettlementProcessApplication __bean){
		__bean.setSettlementId(getSettlementId());
		__bean.setProjectId(getProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setRemark(getRemark());
		__bean.setSettlementDate(getSettlementDate());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setTotalCost(getTotalCost());
		__bean.setProjectAmount(getProjectAmount());
		__bean.setLeftAmount(getLeftAmount());
		__bean.setStatus(getStatus());
		__bean.setStageId(getStageId());
		__bean.setSettlementStatus(getSettlementStatus());
		__bean.setFlag(getFlag());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSettlementId() == null ? "" : getSettlementId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getSettlementDate() == null ? "" : sdf.format(getSettlementDate()));
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		sb.append(",");
		sb.append(getTotalCost() == null ? "" : getTotalCost());
		sb.append(",");
		sb.append(getProjectAmount() == null ? "" : getProjectAmount());
		sb.append(",");
		sb.append(getLeftAmount() == null ? "" : getLeftAmount());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getStageId() == null ? "" : getStageId());
		sb.append(",");
		sb.append(getSettlementStatus() == null ? "" : getSettlementStatus());
		sb.append(",");
		sb.append(getFlag() == null ? "" : getFlag());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectSettlementProcessApplication o) {
		return __settlement_id == null ? -1 : __settlement_id.compareTo(o.getSettlementId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__settlement_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__settlement_date);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__total_cost);
		hash = 97 * hash + Objects.hashCode(this.__project_amount);
		hash = 97 * hash + Objects.hashCode(this.__left_amount);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		hash = 97 * hash + Objects.hashCode(this.__settlement_status);
		hash = 97 * hash + Objects.hashCode(this.__flag);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectSettlementProcessApplication o = (BaseProjectSettlementProcessApplication)obj;
		if(!Objects.equals(this.__settlement_id, o.getSettlementId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__settlement_date, o.getSettlementDate())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__total_cost, o.getTotalCost())) return false;
		if(!Objects.equals(this.__project_amount, o.getProjectAmount())) return false;
		if(!Objects.equals(this.__left_amount, o.getLeftAmount())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__settlement_status, o.getSettlementStatus())) return false;
		if(!Objects.equals(this.__flag, o.getFlag())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSettlementId() != null) sb.append(__wrapNumber(count++, "settlementId", getSettlementId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getSettlementDate() != null) sb.append(__wrapDate(count++, "settlementDate", getSettlementDate()));
		if(getTotalAmount() != null) sb.append(__wrapDecimal(count++, "totalAmount", getTotalAmount()));
		if(getTotalCost() != null) sb.append(__wrapDecimal(count++, "totalCost", getTotalCost()));
		if(getProjectAmount() != null) sb.append(__wrapDecimal(count++, "projectAmount", getProjectAmount()));
		if(getLeftAmount() != null) sb.append(__wrapDecimal(count++, "leftAmount", getLeftAmount()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		if(getSettlementStatus() != null) sb.append(__wrapNumber(count++, "settlementStatus", getSettlementStatus()));
		if(getFlag() != null) sb.append(__wrapNumber(count++, "flag", getFlag()));
		if(getDetailProjectSettlementDetail() != null)  sb.append(__wrapList(count++, "detailProjectSettlementDetail", getDetailProjectSettlementDetail()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSettlementId() != null) res.put("settlementId", getSettlementId());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getSettlementDate() != null) res.put("settlementDate", getSettlementDate());
		if(getTotalAmount() != null) res.put("totalAmount", getTotalAmount());
		if(getTotalCost() != null) res.put("totalCost", getTotalCost());
		if(getProjectAmount() != null) res.put("projectAmount", getProjectAmount());
		if(getLeftAmount() != null) res.put("leftAmount", getLeftAmount());
		if(getStatus() != null) res.put("status", getStatus());
		if(getStageId() != null) res.put("stageId", getStageId());
		if(getSettlementStatus() != null) res.put("settlementStatus", getSettlementStatus());
		if(getFlag() != null) res.put("flag", getFlag());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("settlementId")) != null) setSettlementId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("settlementDate")) != null) setSettlementDate(__getDate(val)); 
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getDecimal(val));  
		if((val = values.get("totalCost")) != null) setTotalCost(__getDecimal(val));  
		if((val = values.get("projectAmount")) != null) setProjectAmount(__getDecimal(val));  
		if((val = values.get("leftAmount")) != null) setLeftAmount(__getDecimal(val));  
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("settlementStatus")) != null) setSettlementStatus(__getInt(val)); 
		if((val = values.get("flag")) != null) setFlag(__getInt(val)); 
		if((val = values.get("detailProjectSettlementDetail")) != null) setDetailProjectSettlementDetail(__getList(val, BaseProjectSettlementDetail.newInstance()));
	}

	protected java.lang.Integer  __settlement_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __settlement_date ;
	protected java.math.BigDecimal  __total_amount ;
	protected java.math.BigDecimal  __total_cost ;
	protected java.math.BigDecimal  __project_amount ;
	protected java.math.BigDecimal  __left_amount ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __stage_id ;
	protected java.lang.Integer  __settlement_status ;
	protected java.lang.Integer  __flag ;
	protected java.util.List<BaseProjectSettlementDetail> __detailProjectSettlementDetail = null;
}
