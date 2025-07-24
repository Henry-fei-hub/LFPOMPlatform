package pomplatform.projectperformance.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseContractProjectPerformance extends GenericBase implements BaseFactory<BaseContractProjectPerformance>, Comparable<BaseContractProjectPerformance> 
{


	public static BaseContractProjectPerformance newInstance(){
		return new BaseContractProjectPerformance();
	}

	@Override
	public BaseContractProjectPerformance make(){
		BaseContractProjectPerformance b = new BaseContractProjectPerformance();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_CONTRACT_AMOUNT = "contract_amount" ;
	public final static java.lang.String CS_PROJECT_LEVEL = "project_level" ;
	public final static java.lang.String CS_SHEET_AMOUNT = "sheet_amount" ;
	public final static java.lang.String CS_TOTAL_INTEGRAL = "total_integral" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_PROJECT_COST = "project_cost" ;
	public final static java.lang.String CS_TOTAL_REVENUE = "total_revenue" ;
	public final static java.lang.String CS_GAIN_MONEY = "gain_money" ;
	public final static java.lang.String CS_LEFT_MONEY = "left_money" ;
	public final static java.lang.String CS_FINISH_PERCENT = "finish_percent" ;
	public final static java.lang.String CS_PROJECT_MANAGE_INTEGRAL = "project_manage_integral" ;
	public final static java.lang.String CS_PROJECT_MANAGE_SURE_INTEGRAL = "project_manage_sure_integral" ;
	public final static java.lang.String CS_DEDUCT_INTEGRAL = "deduct_integral" ;
	public final static java.lang.String CS_AWARD_INTEGRAL = "award_integral" ;
	public final static java.lang.String CS_PROJECT_MANAGE_ID = "project_manage_id" ;
	public final static java.lang.String CS_SHEET_PERFORMANCE_ACHIEVE = "sheet_performance_achieve" ;
	public final static java.lang.String CS_SHEET_PERFORMANCE_PAY = "sheet_performance_pay" ;
	public final static java.lang.String CS_LEFT_INTEGRAL = "left_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "主订单编码,主订单编号,主订单名称,项目编码,,项目等级,订单合同金额,项目总积分,项目积分,,,,,,,,,,专业负责人,,,";

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.math.BigDecimal getContractAmount() {
		return this.__contract_amount;
	}

	public void setContractAmount( java.math.BigDecimal value ) {
		this.__contract_amount = value;
	}

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
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

	public java.math.BigDecimal getProjectCost() {
		return this.__project_cost;
	}

	public void setProjectCost( java.math.BigDecimal value ) {
		this.__project_cost = value;
	}

	public java.math.BigDecimal getTotalRevenue() {
		return this.__total_revenue;
	}

	public void setTotalRevenue( java.math.BigDecimal value ) {
		this.__total_revenue = value;
	}

	public java.math.BigDecimal getGainMoney() {
		return this.__gain_money;
	}

	public void setGainMoney( java.math.BigDecimal value ) {
		this.__gain_money = value;
	}

	public java.math.BigDecimal getLeftMoney() {
		return this.__left_money;
	}

	public void setLeftMoney( java.math.BigDecimal value ) {
		this.__left_money = value;
	}

	public java.lang.String getFinishPercent() {
		return this.__finish_percent;
	}

	public void setFinishPercent( java.lang.String value ) {
		this.__finish_percent = value;
	}

	public java.math.BigDecimal getProjectManageIntegral() {
		return this.__project_manage_integral;
	}

	public void setProjectManageIntegral( java.math.BigDecimal value ) {
		this.__project_manage_integral = value;
	}

	public java.math.BigDecimal getProjectManageSureIntegral() {
		return this.__project_manage_sure_integral;
	}

	public void setProjectManageSureIntegral( java.math.BigDecimal value ) {
		this.__project_manage_sure_integral = value;
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

	public java.math.BigDecimal getSheetPerformanceAchieve() {
		return this.__sheet_performance_achieve;
	}

	public void setSheetPerformanceAchieve( java.math.BigDecimal value ) {
		this.__sheet_performance_achieve = value;
	}

	public java.math.BigDecimal getSheetPerformancePay() {
		return this.__sheet_performance_pay;
	}

	public void setSheetPerformancePay( java.math.BigDecimal value ) {
		this.__sheet_performance_pay = value;
	}

	public java.math.BigDecimal getLeftIntegral() {
		return this.__left_integral;
	}

	public void setLeftIntegral( java.math.BigDecimal value ) {
		this.__left_integral = value;
	}

	public void cloneCopy(BaseContractProjectPerformance __bean){
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setProjectId(getProjectId());
		__bean.setContractAmount(getContractAmount());
		__bean.setProjectLevel(getProjectLevel());
		__bean.setSheetAmount(getSheetAmount());
		__bean.setTotalIntegral(getTotalIntegral());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setProjectCost(getProjectCost());
		__bean.setTotalRevenue(getTotalRevenue());
		__bean.setGainMoney(getGainMoney());
		__bean.setLeftMoney(getLeftMoney());
		__bean.setFinishPercent(getFinishPercent());
		__bean.setProjectManageIntegral(getProjectManageIntegral());
		__bean.setProjectManageSureIntegral(getProjectManageSureIntegral());
		__bean.setDeductIntegral(getDeductIntegral());
		__bean.setAwardIntegral(getAwardIntegral());
		__bean.setProjectManageId(getProjectManageId());
		__bean.setSheetPerformanceAchieve(getSheetPerformanceAchieve());
		__bean.setSheetPerformancePay(getSheetPerformancePay());
		__bean.setLeftIntegral(getLeftIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getContractAmount() == null ? "" : getContractAmount());
		sb.append(",");
		sb.append(getProjectLevel() == null ? "" : getProjectLevel());
		sb.append(",");
		sb.append(getSheetAmount() == null ? "" : getSheetAmount());
		sb.append(",");
		sb.append(getTotalIntegral() == null ? "" : getTotalIntegral());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getProjectCost() == null ? "" : getProjectCost());
		sb.append(",");
		sb.append(getTotalRevenue() == null ? "" : getTotalRevenue());
		sb.append(",");
		sb.append(getGainMoney() == null ? "" : getGainMoney());
		sb.append(",");
		sb.append(getLeftMoney() == null ? "" : getLeftMoney());
		sb.append(",");
		sb.append(getFinishPercent() == null ? "" : getFinishPercent());
		sb.append(",");
		sb.append(getProjectManageIntegral() == null ? "" : getProjectManageIntegral());
		sb.append(",");
		sb.append(getProjectManageSureIntegral() == null ? "" : getProjectManageSureIntegral());
		sb.append(",");
		sb.append(getDeductIntegral() == null ? "" : getDeductIntegral());
		sb.append(",");
		sb.append(getAwardIntegral() == null ? "" : getAwardIntegral());
		sb.append(",");
		sb.append(getProjectManageId() == null ? "" : getProjectManageId());
		sb.append(",");
		sb.append(getSheetPerformanceAchieve() == null ? "" : getSheetPerformanceAchieve());
		sb.append(",");
		sb.append(getSheetPerformancePay() == null ? "" : getSheetPerformancePay());
		sb.append(",");
		sb.append(getLeftIntegral() == null ? "" : getLeftIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractProjectPerformance o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__project_level);
		hash = 97 * hash + Objects.hashCode(this.__sheet_amount);
		hash = 97 * hash + Objects.hashCode(this.__total_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_cost);
		hash = 97 * hash + Objects.hashCode(this.__total_revenue);
		hash = 97 * hash + Objects.hashCode(this.__gain_money);
		hash = 97 * hash + Objects.hashCode(this.__left_money);
		hash = 97 * hash + Objects.hashCode(this.__finish_percent);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__deduct_integral);
		hash = 97 * hash + Objects.hashCode(this.__award_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__sheet_performance_achieve);
		hash = 97 * hash + Objects.hashCode(this.__sheet_performance_pay);
		hash = 97 * hash + Objects.hashCode(this.__left_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractProjectPerformance o = (BaseContractProjectPerformance)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__contract_amount, o.getContractAmount())) return false;
		if(!Objects.equals(this.__project_level, o.getProjectLevel())) return false;
		if(!Objects.equals(this.__sheet_amount, o.getSheetAmount())) return false;
		if(!Objects.equals(this.__total_integral, o.getTotalIntegral())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__project_cost, o.getProjectCost())) return false;
		if(!Objects.equals(this.__total_revenue, o.getTotalRevenue())) return false;
		if(!Objects.equals(this.__gain_money, o.getGainMoney())) return false;
		if(!Objects.equals(this.__left_money, o.getLeftMoney())) return false;
		if(!Objects.equals(this.__finish_percent, o.getFinishPercent())) return false;
		if(!Objects.equals(this.__project_manage_integral, o.getProjectManageIntegral())) return false;
		if(!Objects.equals(this.__project_manage_sure_integral, o.getProjectManageSureIntegral())) return false;
		if(!Objects.equals(this.__deduct_integral, o.getDeductIntegral())) return false;
		if(!Objects.equals(this.__award_integral, o.getAwardIntegral())) return false;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		if(!Objects.equals(this.__sheet_performance_achieve, o.getSheetPerformanceAchieve())) return false;
		if(!Objects.equals(this.__sheet_performance_pay, o.getSheetPerformancePay())) return false;
		if(!Objects.equals(this.__left_integral, o.getLeftIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getContractAmount() != null) sb.append(__wrapDecimal(count++, "contractAmount", getContractAmount()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(count++, "projectLevel", getProjectLevel()));
		if(getSheetAmount() != null) sb.append(__wrapDecimal(count++, "sheetAmount", getSheetAmount()));
		if(getTotalIntegral() != null) sb.append(__wrapDecimal(count++, "totalIntegral", getTotalIntegral()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getProjectCost() != null) sb.append(__wrapDecimal(count++, "projectCost", getProjectCost()));
		if(getTotalRevenue() != null) sb.append(__wrapDecimal(count++, "totalRevenue", getTotalRevenue()));
		if(getGainMoney() != null) sb.append(__wrapDecimal(count++, "gainMoney", getGainMoney()));
		if(getLeftMoney() != null) sb.append(__wrapDecimal(count++, "leftMoney", getLeftMoney()));
		if(getFinishPercent() != null) sb.append(__wrapString(count++, "finishPercent", getFinishPercent()));
		if(getProjectManageIntegral() != null) sb.append(__wrapDecimal(count++, "projectManageIntegral", getProjectManageIntegral()));
		if(getProjectManageSureIntegral() != null) sb.append(__wrapDecimal(count++, "projectManageSureIntegral", getProjectManageSureIntegral()));
		if(getDeductIntegral() != null) sb.append(__wrapDecimal(count++, "deductIntegral", getDeductIntegral()));
		if(getAwardIntegral() != null) sb.append(__wrapDecimal(count++, "awardIntegral", getAwardIntegral()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, "projectManageId", getProjectManageId()));
		if(getSheetPerformanceAchieve() != null) sb.append(__wrapDecimal(count++, "sheetPerformanceAchieve", getSheetPerformanceAchieve()));
		if(getSheetPerformancePay() != null) sb.append(__wrapDecimal(count++, "sheetPerformancePay", getSheetPerformancePay()));
		if(getLeftIntegral() != null) sb.append(__wrapDecimal(count++, "leftIntegral", getLeftIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("contractAmount")) != null) setContractAmount(__getDecimal(val));  
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val)); 
		if((val = values.get("sheetAmount")) != null) setSheetAmount(__getDecimal(val));  
		if((val = values.get("totalIntegral")) != null) setTotalIntegral(__getDecimal(val));  
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));  
		if((val = values.get("projectCost")) != null) setProjectCost(__getDecimal(val));  
		if((val = values.get("totalRevenue")) != null) setTotalRevenue(__getDecimal(val));  
		if((val = values.get("gainMoney")) != null) setGainMoney(__getDecimal(val));  
		if((val = values.get("leftMoney")) != null) setLeftMoney(__getDecimal(val));  
		if((val = values.get("finishPercent")) != null) setFinishPercent(__getString(val));
		if((val = values.get("projectManageIntegral")) != null) setProjectManageIntegral(__getDecimal(val));  
		if((val = values.get("projectManageSureIntegral")) != null) setProjectManageSureIntegral(__getDecimal(val));  
		if((val = values.get("deductIntegral")) != null) setDeductIntegral(__getDecimal(val));  
		if((val = values.get("awardIntegral")) != null) setAwardIntegral(__getDecimal(val));  
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("sheetPerformanceAchieve")) != null) setSheetPerformanceAchieve(__getDecimal(val));  
		if((val = values.get("sheetPerformancePay")) != null) setSheetPerformancePay(__getDecimal(val));  
		if((val = values.get("leftIntegral")) != null) setLeftIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.Integer  __project_id ;
	protected java.math.BigDecimal  __contract_amount ;
	protected java.lang.Integer  __project_level ;
	protected java.math.BigDecimal  __sheet_amount ;
	protected java.math.BigDecimal  __total_integral ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.math.BigDecimal  __project_cost ;
	protected java.math.BigDecimal  __total_revenue ;
	protected java.math.BigDecimal  __gain_money ;
	protected java.math.BigDecimal  __left_money ;
	protected java.lang.String  __finish_percent ;
	protected java.math.BigDecimal  __project_manage_integral ;
	protected java.math.BigDecimal  __project_manage_sure_integral ;
	protected java.math.BigDecimal  __deduct_integral ;
	protected java.math.BigDecimal  __award_integral ;
	protected java.lang.Integer  __project_manage_id ;
	protected java.math.BigDecimal  __sheet_performance_achieve ;
	protected java.math.BigDecimal  __sheet_performance_pay ;
	protected java.math.BigDecimal  __left_integral ;
}
