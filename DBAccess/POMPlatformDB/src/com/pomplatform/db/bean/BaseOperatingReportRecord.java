package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseOperatingReportRecord extends GenericBase implements BaseFactory<BaseOperatingReportRecord>, Comparable<BaseOperatingReportRecord> 
{


	public static BaseOperatingReportRecord newInstance(){
		return new BaseOperatingReportRecord();
	}

	@Override
	public BaseOperatingReportRecord make(){
		BaseOperatingReportRecord b = new BaseOperatingReportRecord();
		return b;
	}

	public final static java.lang.String CS_OPERATING_REPORT_RECORD_ID = "operating_report_record_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_COMPANY_SUBSIDY = "company_subsidy" ;
	public final static java.lang.String CS_ACHIEVE_OTHER_PLATE_INTEGRAL = "achieve_other_plate_integral" ;
	public final static java.lang.String CS_SALARY_COST = "salary_cost" ;
	public final static java.lang.String CS_PLATE_COST = "plate_cost" ;
	public final static java.lang.String CS_PROJECT_COST = "project_cost" ;
	public final static java.lang.String CS_PAY_COMMON_PLATE_INTEGRAL = "pay_common_plate_integral" ;
	public final static java.lang.String CS_PAY_OTHER_PLATE_INTEGRAL = "pay_other_plate_integral" ;
	public final static java.lang.String CS_ACHIEVE_INTEGRAL = "achieve_integral" ;
	public final static java.lang.String CS_AWARD_SEND = "award_send" ;
	public final static java.lang.String CS_LEFT_ACHIEVE_INTEGRAL = "left_achieve_integral" ;
	public final static java.lang.String CS_COMPANY_FEE = "company_fee" ;
	public final static java.lang.String CS_DEVELOP_PROJECT = "develop_project";//研发项目
	public final static java.lang.String CS_MANAGE_PROJECT = "manage_project";//管理项目
	public final static java.lang.String CS_COMPANY_ADVANCE = "company_advance";//公司借款
	public final static java.lang.String CS_COMPANY_REFUND = "company_refund";//公司还款
	public final static java.lang.String CS_COLLABORATIVE_ACHIEVE = "collaborative_achieve";//协作收入(品质管理费的收入)
	public final static java.lang.String CS_COLLABORATIVE_PAY = "collaborative_pay";//协作支出(品质管理费的支出)

	public final static java.lang.String ALL_CAPTIONS = "编码,业务部门,确认积分,公司补贴,来自其它部门积分,人工成本,运营成本,项目成本,综合部门分摊,给其它部门积分,价值积分,奖金发放,剩余价值积分,公司费用,研发项目,管理项目,公司借款,公司还款,协作收入,协作支出";
	public final static java.lang.String CUSTOM_CAPTIONS = "业务部门,价值积分,奖金发放,剩余价值积分,确认积分,公司补贴,来自其它部门积分,研发项目,管理项目,公司借款,协作收入,人工成本,运营成本,项目成本,综合部门分摊,给其它部门积分,协作支出,公司费用,公司还款";

	public java.lang.Integer getOperatingReportRecordId() {
		return this.__operating_report_record_id;
	}

	public void setOperatingReportRecordId( java.lang.Integer value ) {
		this.__operating_report_record_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.math.BigDecimal getCompanySubsidy() {
		return this.__company_subsidy;
	}

	public void setCompanySubsidy( java.math.BigDecimal value ) {
		this.__company_subsidy = value;
	}

	public java.math.BigDecimal getAchieveOtherPlateIntegral() {
		return this.__achieve_other_plate_integral;
	}

	public void setAchieveOtherPlateIntegral( java.math.BigDecimal value ) {
		this.__achieve_other_plate_integral = value;
	}

	public java.math.BigDecimal getSalaryCost() {
		return this.__salary_cost;
	}

	public void setSalaryCost( java.math.BigDecimal value ) {
		this.__salary_cost = value;
	}

	public java.math.BigDecimal getPlateCost() {
		return this.__plate_cost;
	}

	public void setPlateCost( java.math.BigDecimal value ) {
		this.__plate_cost = value;
	}

	public java.math.BigDecimal getProjectCost() {
		return this.__project_cost;
	}

	public void setProjectCost( java.math.BigDecimal value ) {
		this.__project_cost = value;
	}

	public java.math.BigDecimal getPayCommonPlateIntegral() {
		return this.__pay_common_plate_integral;
	}

	public void setPayCommonPlateIntegral( java.math.BigDecimal value ) {
		this.__pay_common_plate_integral = value;
	}

	public java.math.BigDecimal getPayOtherPlateIntegral() {
		return this.__pay_other_plate_integral;
	}

	public void setPayOtherPlateIntegral( java.math.BigDecimal value ) {
		this.__pay_other_plate_integral = value;
	}

	public java.math.BigDecimal getAchieveIntegral() {
		return this.__achieve_integral;
	}

	public void setAchieveIntegral( java.math.BigDecimal value ) {
		this.__achieve_integral = value;
	}

	public java.math.BigDecimal getAwardSend() {
		return this.__award_send;
	}

	public void setAwardSend( java.math.BigDecimal value ) {
		this.__award_send = value;
	}

	public java.math.BigDecimal getLeftAchieveIntegral() {
		return this.__left_achieve_integral;
	}

	public void setLeftAchieveIntegral( java.math.BigDecimal value ) {
		this.__left_achieve_integral = value;
	}

	public java.math.BigDecimal getCompanyFee() {
		return __company_fee;
	}

	public void setCompanyFee(java.math.BigDecimal value) {
		this.__company_fee = value;
	}
	
	public java.math.BigDecimal getDevelopProject() {
		return __develop_project;
	}
	
	public void setDevelopProject(java.math.BigDecimal value) {
		this.__develop_project = value;
	}
	
	public java.math.BigDecimal getManageProject() {
		return __manage_project;
	}
	
	public void setManageProject(java.math.BigDecimal value) {
		this.__manage_project = value;
	}
	
	public java.math.BigDecimal getCompanyAdvance() {
		return __company_advance;
	}
	
	public void setCompanyAdvance(java.math.BigDecimal value) {
		this.__company_advance = value;
	}
	
	public java.math.BigDecimal getCompanyRefund() {
		return __company_refund;
	}
	
	public void setCompanyRefund(java.math.BigDecimal value) {
		this.__company_refund = value;
	}
	
	public java.math.BigDecimal getCollaborativeAchieve() {
		return __collaborative_achieve;
	}
	
	public void setCollaborativeAchieve(java.math.BigDecimal value) {
		this.__collaborative_achieve = value;
	}
	
	public java.math.BigDecimal getCollaborativePay() {
		return __collaborative_pay;
	}
	
	public void setCollaborativePay(java.math.BigDecimal value) {
		this.__collaborative_pay = value;
	}
	
	public void cloneCopy(BaseOperatingReportRecord __bean){
		__bean.setOperatingReportRecordId(getOperatingReportRecordId());
		__bean.setPlateId(getPlateId());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setCompanySubsidy(getCompanySubsidy());
		__bean.setAchieveOtherPlateIntegral(getAchieveOtherPlateIntegral());
		__bean.setSalaryCost(getSalaryCost());
		__bean.setPlateCost(getPlateCost());
		__bean.setProjectCost(getProjectCost());
		__bean.setPayCommonPlateIntegral(getPayCommonPlateIntegral());
		__bean.setPayOtherPlateIntegral(getPayOtherPlateIntegral());
		__bean.setAchieveIntegral(getAchieveIntegral());
		__bean.setAwardSend(getAwardSend());
		__bean.setLeftAchieveIntegral(getLeftAchieveIntegral());
		__bean.setCompanyFee(getCompanyFee());
		__bean.setDevelopProject(getDevelopProject());
		__bean.setManageProject(getManageProject());
		__bean.setCompanyAdvance(getCompanyAdvance());
		__bean.setCompanyRefund(getCompanyRefund());
		__bean.setCollaborativeAchieve(getCollaborativeAchieve());
		__bean.setCollaborativePay(getCollaborativePay());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getOperatingReportRecordId() == null ? "" : getOperatingReportRecordId());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getCompanySubsidy() == null ? "" : getCompanySubsidy());
		sb.append(",");
		sb.append(getAchieveOtherPlateIntegral() == null ? "" : getAchieveOtherPlateIntegral());
		sb.append(",");
		sb.append(getDevelopProject() == null ? "" : getDevelopProject());
		sb.append(",");
		sb.append(getManageProject() == null ? "" : getManageProject());
		sb.append(",");
		sb.append(getCompanyAdvance() == null ? "" : getCompanyAdvance());
		sb.append(",");
		sb.append(getCollaborativeAchieve() == null ? "" : getCollaborativeAchieve());
		sb.append(",");
		sb.append(getSalaryCost() == null ? "" : getSalaryCost());
		sb.append(",");
		sb.append(getPlateCost() == null ? "" : getPlateCost());
		sb.append(",");
		sb.append(getProjectCost() == null ? "" : getProjectCost());
		sb.append(",");
		sb.append(getPayCommonPlateIntegral() == null ? "" : getPayCommonPlateIntegral());
		sb.append(",");
		sb.append(getPayOtherPlateIntegral() == null ? "" : getPayOtherPlateIntegral());
		sb.append(",");
		sb.append(getAchieveIntegral() == null ? "" : getAchieveIntegral());
		sb.append(",");
		sb.append(getAwardSend() == null ? "" : getAwardSend());
		sb.append(",");
		sb.append(getLeftAchieveIntegral() == null ? "" : getLeftAchieveIntegral());
		sb.append(",");
		sb.append(getCollaborativePay() == null ? "" : getCollaborativePay());
		sb.append(",");
		sb.append(getCompanyFee() == null ? "" : getCompanyFee());
		sb.append(",");
		sb.append(getCompanyRefund() == null ? "" : getCompanyRefund());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOperatingReportRecord o) {
		return __operating_report_record_id == null ? -1 : __operating_report_record_id.compareTo(o.getOperatingReportRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__operating_report_record_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__company_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__achieve_other_plate_integral);
		hash = 97 * hash + Objects.hashCode(this.__salary_cost);
		hash = 97 * hash + Objects.hashCode(this.__plate_cost);
		hash = 97 * hash + Objects.hashCode(this.__project_cost);
		hash = 97 * hash + Objects.hashCode(this.__pay_common_plate_integral);
		hash = 97 * hash + Objects.hashCode(this.__pay_other_plate_integral);
		hash = 97 * hash + Objects.hashCode(this.__achieve_integral);
		hash = 97 * hash + Objects.hashCode(this.__award_send);
		hash = 97 * hash + Objects.hashCode(this.__left_achieve_integral);
		hash = 97 * hash + Objects.hashCode(this.__company_fee);
		hash = 97 * hash + Objects.hashCode(this.__develop_project);
		hash = 97 * hash + Objects.hashCode(this.__manage_project);
		hash = 97 * hash + Objects.hashCode(this.__company_advance);
		hash = 97 * hash + Objects.hashCode(this.__company_refund);
		hash = 97 * hash + Objects.hashCode(this.__collaborative_achieve);
		hash = 97 * hash + Objects.hashCode(this.__collaborative_pay);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOperatingReportRecord o = (BaseOperatingReportRecord)obj;
		if(!Objects.equals(this.__operating_report_record_id, o.getOperatingReportRecordId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__company_subsidy, o.getCompanySubsidy())) return false;
		if(!Objects.equals(this.__achieve_other_plate_integral, o.getAchieveOtherPlateIntegral())) return false;
		if(!Objects.equals(this.__salary_cost, o.getSalaryCost())) return false;
		if(!Objects.equals(this.__plate_cost, o.getPlateCost())) return false;
		if(!Objects.equals(this.__project_cost, o.getProjectCost())) return false;
		if(!Objects.equals(this.__pay_common_plate_integral, o.getPayCommonPlateIntegral())) return false;
		if(!Objects.equals(this.__pay_other_plate_integral, o.getPayOtherPlateIntegral())) return false;
		if(!Objects.equals(this.__achieve_integral, o.getAchieveIntegral())) return false;
		if(!Objects.equals(this.__award_send, o.getAwardSend())) return false;
		if(!Objects.equals(this.__left_achieve_integral, o.getLeftAchieveIntegral())) return false;
		if(!Objects.equals(this.__company_fee, o.getCompanyFee())) return false;
		if (!Objects.equals(this.__develop_project, o.getDevelopProject()))
			return false;
		if (!Objects.equals(this.__manage_project, o.getManageProject()))
			return false;
		if (!Objects.equals(this.__company_advance, o.getCompanyAdvance()))
			return false;
		if (!Objects.equals(this.__company_refund, o.getCompanyRefund()))
			return false;
		if (!Objects.equals(this.__collaborative_achieve, o.getCollaborativeAchieve()))
			return false;
		if (!Objects.equals(this.__collaborative_pay, o.getCollaborativePay()))
			return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getOperatingReportRecordId() != null) sb.append(__wrapNumber(count++, "operatingReportRecordId", getOperatingReportRecordId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getCompanySubsidy() != null) sb.append(__wrapDecimal(count++, "companySubsidy", getCompanySubsidy()));
		if(getAchieveOtherPlateIntegral() != null) sb.append(__wrapDecimal(count++, "achieveOtherPlateIntegral", getAchieveOtherPlateIntegral()));
		if(getSalaryCost() != null) sb.append(__wrapDecimal(count++, "salaryCost", getSalaryCost()));
		if(getPlateCost() != null) sb.append(__wrapDecimal(count++, "plateCost", getPlateCost()));
		if(getProjectCost() != null) sb.append(__wrapDecimal(count++, "projectCost", getProjectCost()));
		if(getPayCommonPlateIntegral() != null) sb.append(__wrapDecimal(count++, "payCommonPlateIntegral", getPayCommonPlateIntegral()));
		if(getPayOtherPlateIntegral() != null) sb.append(__wrapDecimal(count++, "payOtherPlateIntegral", getPayOtherPlateIntegral()));
		if(getAchieveIntegral() != null) sb.append(__wrapDecimal(count++, "achieveIntegral", getAchieveIntegral()));
		if(getAwardSend() != null) sb.append(__wrapDecimal(count++, "awardSend", getAwardSend()));
		if(getLeftAchieveIntegral() != null) sb.append(__wrapDecimal(count++, "leftAchieveIntegral", getLeftAchieveIntegral()));
		if(getCompanyFee() != null) sb.append(__wrapDecimal(count++, "companyFee", getCompanyFee()));
		if (getDevelopProject() != null)
			sb.append(__wrapDecimal(count++, "developProject", getDevelopProject()));
		if (getManageProject() != null)
			sb.append(__wrapDecimal(count++, "manageProject", getManageProject()));
		if (getCompanyAdvance() != null)
			sb.append(__wrapDecimal(count++, "companyAdvance", getCompanyAdvance()));
		if (getCompanyRefund() != null)
			sb.append(__wrapDecimal(count++, "companyRefund", getCompanyRefund()));
		if (getCollaborativeAchieve() != null)
			sb.append(__wrapDecimal(count++, "collaborativeAchieve", getCollaborativeAchieve()));
		if (getCollaborativePay() != null)
			sb.append(__wrapDecimal(count++, "collaborativePay", getCollaborativePay()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("operatingReportRecordId")) != null) setOperatingReportRecordId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("companySubsidy")) != null) setCompanySubsidy(__getDecimal(val));  
		if((val = values.get("achieveOtherPlateIntegral")) != null) setAchieveOtherPlateIntegral(__getDecimal(val));  
		if((val = values.get("salaryCost")) != null) setSalaryCost(__getDecimal(val));  
		if((val = values.get("plateCost")) != null) setPlateCost(__getDecimal(val));  
		if((val = values.get("projectCost")) != null) setProjectCost(__getDecimal(val));  
		if((val = values.get("payCommonPlateIntegral")) != null) setPayCommonPlateIntegral(__getDecimal(val));  
		if((val = values.get("payOtherPlateIntegral")) != null) setPayOtherPlateIntegral(__getDecimal(val));  
		if((val = values.get("achieveIntegral")) != null) setAchieveIntegral(__getDecimal(val));  
		if((val = values.get("awardSend")) != null) setAwardSend(__getDecimal(val));  
		if((val = values.get("leftAchieveIntegral")) != null) setLeftAchieveIntegral(__getDecimal(val));  
		if((val = values.get("companyFee")) != null) setCompanyFee(__getDecimal(val));  
		if ((val = values.get("developProject")) != null)
			setDevelopProject(__getDecimal(val));
		if ((val = values.get("manageProject")) != null)
			setManageProject(__getDecimal(val));
		if ((val = values.get("companyAdvance")) != null)
			setCompanyAdvance(__getDecimal(val));
		if ((val = values.get("companyRefund")) != null)
			setCompanyRefund(__getDecimal(val));
		if ((val = values.get("collaborativeAchieve")) != null)
			setCollaborativeAchieve(__getDecimal(val));
		if ((val = values.get("collaborativePay")) != null)
			setCollaborativePay(__getDecimal(val));
	}

	protected java.lang.Integer  __operating_report_record_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.math.BigDecimal  __company_subsidy ;
	protected java.math.BigDecimal  __achieve_other_plate_integral ;
	protected java.math.BigDecimal  __salary_cost ;
	protected java.math.BigDecimal  __plate_cost ;
	protected java.math.BigDecimal  __project_cost ;
	protected java.math.BigDecimal  __pay_common_plate_integral ;
	protected java.math.BigDecimal  __pay_other_plate_integral ;
	protected java.math.BigDecimal  __achieve_integral ;
	protected java.math.BigDecimal  __award_send ;
	protected java.math.BigDecimal  __left_achieve_integral ;
	protected java.math.BigDecimal  __company_fee ;
	protected java.math.BigDecimal __develop_project;
	protected java.math.BigDecimal __manage_project;
	protected java.math.BigDecimal __company_advance;
	protected java.math.BigDecimal __company_refund;
	protected java.math.BigDecimal __collaborative_achieve;
	protected java.math.BigDecimal __collaborative_pay;
}
