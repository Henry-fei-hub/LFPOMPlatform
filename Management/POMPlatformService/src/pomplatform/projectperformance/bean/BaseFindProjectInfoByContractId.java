package pomplatform.projectperformance.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseFindProjectInfoByContractId extends GenericBase implements BaseFactory<BaseFindProjectInfoByContractId>, Comparable<BaseFindProjectInfoByContractId> 
{


	public static BaseFindProjectInfoByContractId newInstance(){
		return new BaseFindProjectInfoByContractId();
	}

	@Override
	public BaseFindProjectInfoByContractId make(){
		BaseFindProjectInfoByContractId b = new BaseFindProjectInfoByContractId();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_SHEET_CODE = "sheet_code" ;
	public final static java.lang.String CS_SHEET_NAME = "sheet_name" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_SHEET_AMOUNT = "sheet_amount" ;
	public final static java.lang.String CS_TOTAL_INTEGRAL = "total_integral" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_RESERVE_INTEGRAL = "reserve_integral" ;
	public final static java.lang.String CS_COMPLAINT_INTEGRAL = "complaint_integral" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_PROJECT_COST = "project_cost" ;
	public final static java.lang.String CS_DEDUCT_INTEGRAL = "deduct_integral" ;
	public final static java.lang.String CS_AWARD_INTEGRAL = "award_integral" ;
	public final static java.lang.String CS_PROJECT_MANAGE_ID = "project_manage_id" ;
	public final static java.lang.String CS_FINISH_PERCENT = "finish_percent" ;
	public final static java.lang.String CS_TOTAL_REVENUE = "total_revenue" ;
	public final static java.lang.String CS_LEFT_INTEGRAL = "left_integral";

	public final static java.lang.String ALL_CAPTIONS = "合同编码,项目代码,业务部门,订单编号,订单名称,业务类别,项目类别,订单合同金额,订单总积分,项目积分,预留积分,项目绩效,确认积分,项目成本,已扣积分,已奖积分,专业负责人,累计完工比,累计营收,剩余积分";

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getStatus() {
		return __status;
	}

	public void setStatus(java.lang.Integer value) {
		this.__status = value;
	}

	public java.lang.String getSheetCode() {
		return this.__sheet_code;
	}

	public void setSheetCode( java.lang.String value ) {
		this.__sheet_code = value;
	}

	public java.lang.String getSheetName() {
		return this.__sheet_name;
	}

	public void setSheetName( java.lang.String value ) {
		this.__sheet_name = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.math.BigDecimal getSheetAmount() {
		return this.__sheet_amount;
	}

	public void setSheetAmount( java.math.BigDecimal value ) {
		this.__sheet_amount = value;
	}

	public java.math.BigDecimal getTotalIntegral() {
		return this.__total_integral;
	}

	public void setTotalIntegral( java.math.BigDecimal value ) {
		this.__total_integral = value;
	}

	public java.math.BigDecimal getProjectIntegral() {
		return this.__project_integral;
	}

	public void setProjectIntegral( java.math.BigDecimal value ) {
		this.__project_integral = value;
	}

	public java.math.BigDecimal getReserveIntegral() {
		return this.__reserve_integral;
	}

	public void setReserveIntegral( java.math.BigDecimal value ) {
		this.__reserve_integral = value;
	}

	public java.math.BigDecimal getComplaintIntegral() {
		return this.__complaint_integral;
	}

	public void setComplaintIntegral( java.math.BigDecimal value ) {
		this.__complaint_integral = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.math.BigDecimal getProjectCost() {
		return this.__project_cost;
	}

	public void setProjectCost( java.math.BigDecimal value ) {
		this.__project_cost = value;
	}

	public java.math.BigDecimal getDeductIntegral() {
		return this.__deduct_integral;
	}

	public void setDeductIntegral( java.math.BigDecimal value ) {
		this.__deduct_integral = value;
	}

	public java.math.BigDecimal getAwardIntegral() {
		return this.__award_integral;
	}

	public void setAwardIntegral( java.math.BigDecimal value ) {
		this.__award_integral = value;
	}

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	public java.lang.String getFinishPercent() {
		return this.__finish_percent;
	}

	public void setFinishPercent( java.lang.String value ) {
		this.__finish_percent = value;
	}

	public java.math.BigDecimal getTotalRevenue() {
		return this.__total_revenue;
	}

	public void setTotalRevenue( java.math.BigDecimal value ) {
		this.__total_revenue = value;
	}
	
	public java.math.BigDecimal getLeftIntegral() {
		return this.__left_integral;
	}

	public void setLeftIntegral(java.math.BigDecimal value) {
		this.__left_integral = value;
	}

	public void cloneCopy(BaseFindProjectInfoByContractId __bean){
		__bean.setContractId(getContractId());
		__bean.setProjectId(getProjectId());
		__bean.setPlateId(getPlateId());
		__bean.setStatus(getStatus());
		__bean.setSheetCode(getSheetCode());
		__bean.setSheetName(getSheetName());
		__bean.setBusinessType(getBusinessType());
		__bean.setProjectType(getProjectType());
		__bean.setSheetAmount(getSheetAmount());
		__bean.setTotalIntegral(getTotalIntegral());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setReserveIntegral(getReserveIntegral());
		__bean.setComplaintIntegral(getComplaintIntegral());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setProjectCost(getProjectCost());
		__bean.setDeductIntegral(getDeductIntegral());
		__bean.setAwardIntegral(getAwardIntegral());
		__bean.setProjectManageId(getProjectManageId());
		__bean.setFinishPercent(getFinishPercent());
		__bean.setTotalRevenue(getTotalRevenue());
		__bean.setLeftIntegral(getLeftIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getSheetCode() == null ? "" : getSheetCode());
		sb.append(",");
		sb.append(getSheetName() == null ? "" : getSheetName());
		sb.append(",");
		String strBusinessType = delicacy.system.executor.SelectValueCache.getSelectValue("production_value_coefficient_type", String.valueOf(getBusinessType()));
		sb.append(strBusinessType == null ? "" : strBusinessType);
		sb.append(",");
		String strProjectType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getProjectType()));
		sb.append(strProjectType == null ? "" : strProjectType);
		sb.append(",");
		sb.append(getSheetAmount() == null ? "" : getSheetAmount());
		sb.append(",");
		sb.append(getTotalIntegral() == null ? "" : getTotalIntegral());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getReserveIntegral() == null ? "" : getReserveIntegral());
		sb.append(",");
		sb.append(getComplaintIntegral() == null ? "" : getComplaintIntegral());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getProjectCost() == null ? "" : getProjectCost());
		sb.append(",");
		sb.append(getDeductIntegral() == null ? "" : getDeductIntegral());
		sb.append(",");
		sb.append(getAwardIntegral() == null ? "" : getAwardIntegral());
		sb.append(",");
		String strProjectManageId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getProjectManageId()));
		sb.append(strProjectManageId == null ? "" : strProjectManageId);
		sb.append(",");
		sb.append(getFinishPercent() == null ? "" : getFinishPercent());
		sb.append(",");
		sb.append(getTotalRevenue() == null ? "" : getTotalRevenue());
		sb.append(",");
		sb.append(getLeftIntegral() == null ? "" : getLeftIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFindProjectInfoByContractId o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__sheet_code);
		hash = 97 * hash + Objects.hashCode(this.__sheet_name);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__sheet_amount);
		hash = 97 * hash + Objects.hashCode(this.__total_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__reserve_integral);
		hash = 97 * hash + Objects.hashCode(this.__complaint_integral);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_cost);
		hash = 97 * hash + Objects.hashCode(this.__deduct_integral);
		hash = 97 * hash + Objects.hashCode(this.__award_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__finish_percent);
		hash = 97 * hash + Objects.hashCode(this.__total_revenue);
		hash = 97 * hash + Objects.hashCode(this.__left_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFindProjectInfoByContractId o = (BaseFindProjectInfoByContractId)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__status, o.getPlateId())) return false;
		if(!Objects.equals(this.__sheet_code, o.getSheetCode())) return false;
		if(!Objects.equals(this.__sheet_name, o.getSheetName())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__sheet_amount, o.getSheetAmount())) return false;
		if(!Objects.equals(this.__total_integral, o.getTotalIntegral())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__reserve_integral, o.getReserveIntegral())) return false;
		if(!Objects.equals(this.__complaint_integral, o.getComplaintIntegral())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__project_cost, o.getProjectCost())) return false;
		if(!Objects.equals(this.__deduct_integral, o.getDeductIntegral())) return false;
		if(!Objects.equals(this.__award_integral, o.getAwardIntegral())) return false;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		if(!Objects.equals(this.__finish_percent, o.getFinishPercent())) return false;
		if(!Objects.equals(this.__total_revenue, o.getTotalRevenue())) return false;
		if(!Objects.equals(this.__left_integral, o.getLeftIntegral()))return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getSheetCode() != null) sb.append(__wrapString(count++, "sheetCode", getSheetCode()));
		if(getSheetName() != null) sb.append(__wrapString(count++, "sheetName", getSheetName()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getSheetAmount() != null) sb.append(__wrapDecimal(count++, "sheetAmount", getSheetAmount()));
		if(getTotalIntegral() != null) sb.append(__wrapDecimal(count++, "totalIntegral", getTotalIntegral()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getReserveIntegral() != null) sb.append(__wrapDecimal(count++, "reserveIntegral", getReserveIntegral()));
		if(getComplaintIntegral() != null) sb.append(__wrapDecimal(count++, "complaintIntegral", getComplaintIntegral()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getProjectCost() != null) sb.append(__wrapDecimal(count++, "projectCost", getProjectCost()));
		if(getDeductIntegral() != null) sb.append(__wrapDecimal(count++, "deductIntegral", getDeductIntegral()));
		if(getAwardIntegral() != null) sb.append(__wrapDecimal(count++, "awardIntegral", getAwardIntegral()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, "projectManageId", getProjectManageId()));
		if(getFinishPercent() != null) sb.append(__wrapString(count++, "finishPercent", getFinishPercent()));
		if(getTotalRevenue() != null) sb.append(__wrapDecimal(count++, "totalRevenue", getTotalRevenue()));
		if(getLeftIntegral() != null) sb.append(__wrapDecimal(count++, "leftIntegral", getLeftIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("sheetCode")) != null) setSheetCode(__getString(val));
		if((val = values.get("sheetName")) != null) setSheetName(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("sheetAmount")) != null) setSheetAmount(__getDecimal(val));  
		if((val = values.get("totalIntegral")) != null) setTotalIntegral(__getDecimal(val));  
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));  
		if((val = values.get("reserveIntegral")) != null) setReserveIntegral(__getDecimal(val));  
		if((val = values.get("complaintIntegral")) != null) setComplaintIntegral(__getDecimal(val));  
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("projectCost")) != null) setProjectCost(__getDecimal(val));  
		if((val = values.get("deductIntegral")) != null) setDeductIntegral(__getDecimal(val));  
		if((val = values.get("awardIntegral")) != null) setAwardIntegral(__getDecimal(val));  
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("finishPercent")) != null) setFinishPercent(__getString(val));
		if((val = values.get("totalRevenue")) != null) setTotalRevenue(__getDecimal(val));  
		if((val = values.get("leftIntegral")) != null) setLeftIntegral(__getDecimal(val));
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __status ;
	protected java.lang.String  __sheet_code ;
	protected java.lang.String  __sheet_name ;
	protected java.lang.Integer  __business_type ;
	protected java.lang.Integer  __project_type ;
	protected java.math.BigDecimal  __sheet_amount ;
	protected java.math.BigDecimal  __total_integral ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.math.BigDecimal  __reserve_integral ;
	protected java.math.BigDecimal  __complaint_integral ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.math.BigDecimal  __project_cost ;
	protected java.math.BigDecimal  __deduct_integral ;
	protected java.math.BigDecimal  __award_integral ;
	protected java.lang.Integer  __project_manage_id ;
	protected java.lang.String  __finish_percent ;
	protected java.math.BigDecimal  __total_revenue ;
	protected java.math.BigDecimal __left_integral;
}
