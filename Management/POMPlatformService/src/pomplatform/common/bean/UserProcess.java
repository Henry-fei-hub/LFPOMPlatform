package pomplatform.common.bean;

import java.util.Map;

import delicacy.common.GenericBase;

public class UserProcess extends GenericBase{

	public UserProcess(){
		Project_normal_reimbursement = 0;
		Common_normal_reimbursement = 0;
		Project_travel_reimbursement = 0;
		Common_travel_reimbursement = 0;
		Borrow_money_manage = 0;
		Pay_money_manage = 0;
		Pre_project_normal_reimbursement=0;
		Capital_distribution = 0;
	}
	public java.lang.Integer getProjectNormalReimbursement() {
		return this.Project_normal_reimbursement;
	}

	public void setProjectNormalReimbursement( java.lang.Integer value ) {
		this.Project_normal_reimbursement = value;
	}

	public java.lang.Integer getCommonNormalReimbursement() {
		return this.Common_normal_reimbursement;
	}

	public void setCommonNormalReimbursement( java.lang.Integer value ) {
		this.Common_normal_reimbursement = value;
	}
	
	public java.lang.Integer getProjectTravelReimbursement() {
		return this.Project_travel_reimbursement;
	}

	public void setProjectTravelReimbursement( java.lang.Integer value ) {
		this.Project_travel_reimbursement = value;
	}
	
	public java.lang.Integer getCommonTravelReimbursement() {
		return this.Common_travel_reimbursement;
	}

	public void setCommonTravelReimbursement( java.lang.Integer value ) {
		this.Common_travel_reimbursement = value;
	}
	
	public java.lang.Integer getBorrowMoneyManage() {
		return this.Borrow_money_manage;
	}

	public void setBorrowMoneyManage( java.lang.Integer value ) {
		this.Borrow_money_manage = value;
	}
	
	public java.lang.Integer getPayMoneyManage() {
		return this.Pay_money_manage;
	}

	public void setPayMoneyManage( java.lang.Integer value ) {
		this.Pay_money_manage = value;
	}
	public java.lang.Integer getPreProjectNormalReimbursement() {
		return this.Pre_project_normal_reimbursement;
	}

	public void setPreProjectNormalReimbursement( java.lang.Integer value ) {
		this.Pre_project_normal_reimbursement = value;
	}
	public java.lang.Integer getPreProjectTraelReimbursement() {
		return this.Pre_project_travel_reimbursement;
	}

	public void setPreProjectTraelReimbursement( java.lang.Integer value ) {
		this.Pre_project_travel_reimbursement = value;
	}
	
	public java.lang.Integer getCompanyNormalReimbursement() {
		return this.Company_normal_reimbursement;
	}

	public void setCompanyNormalReimbursement( java.lang.Integer value ) {
		this.Company_normal_reimbursement = value;
	}
	
	public java.lang.Integer getCapitalDistribution() {
		return this.Capital_distribution;
	}

	public void setCapitalDistribution( java.lang.Integer value ) {
		this.Capital_distribution = value;
	}
	
	@Override
	public String toJSONString() {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectNormalReimbursement() != null) sb.append(__wrapNumber(count++, "Project_normal_reimbursement", getProjectNormalReimbursement()));
		if(getCommonNormalReimbursement() != null) sb.append(__wrapNumber(count++, "Common_normal_reimbursement", getCommonNormalReimbursement()));
		if(getProjectTravelReimbursement() != null) sb.append(__wrapNumber(count++, "Project_travel_reimbursement", getProjectTravelReimbursement()));
		if(getCommonTravelReimbursement() != null) sb.append(__wrapNumber(count++, "Common_travel_reimbursement", getCommonTravelReimbursement()));
		if(getBorrowMoneyManage() != null) sb.append(__wrapNumber(count++, "Borrow_money_manage", getBorrowMoneyManage()));
		if(getPayMoneyManage() != null) sb.append(__wrapNumber(count++, "Pay_money_manage", getPayMoneyManage()));
		if(getPreProjectNormalReimbursement() != null) sb.append(__wrapNumber(count++, "Pre_project_normal_reimbursement", getPreProjectNormalReimbursement()));
		if(getPreProjectTraelReimbursement() != null) sb.append(__wrapNumber(count++, "Pre_project_travel_reimbursement", getPreProjectTraelReimbursement()));
		if(getCompanyNormalReimbursement() != null) sb.append(__wrapNumber(count++, "Company_normal_reimbursement", getCompanyNormalReimbursement()));
		if(getCapitalDistribution() != null) sb.append(__wrapNumber(count++, "Capital_distribution", getCapitalDistribution()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values) {
		Object val;
		if((val = values.get("Project_normal_reimbursement")) != null) setProjectNormalReimbursement(__getInt(val)); 
		if((val = values.get("Common_normal_reimbursement")) != null) setCommonNormalReimbursement(__getInt(val)); 
		if((val = values.get("Project_travel_reimbursement")) != null) setProjectTravelReimbursement(__getInt(val)); 
		if((val = values.get("Common_travel_reimbursement")) != null) setCommonTravelReimbursement(__getInt(val)); 
		if((val = values.get("Borrow_money_manage")) != null) setBorrowMoneyManage(__getInt(val)); 
		if((val = values.get("Pay_money_manage")) != null) setPayMoneyManage(__getInt(val)); 
		if((val = values.get("Pre_project_normal_reimbursement")) != null) setPreProjectNormalReimbursement(__getInt(val));
		if((val = values.get("Pre_project_travel_reimbursement")) != null) setPreProjectTraelReimbursement(__getInt(val));
		if((val = values.get("Company_normal_reimbursement")) != null) setCompanyNormalReimbursement(__getInt(val));
	}
	
	protected java.lang.Integer  Project_normal_reimbursement ;
	protected java.lang.Integer  Common_normal_reimbursement ;
	protected java.lang.Integer  Project_travel_reimbursement ;
	protected java.lang.Integer  Common_travel_reimbursement ;
	protected java.lang.Integer  Borrow_money_manage ;
	protected java.lang.Integer  Pay_money_manage ;
	protected java.lang.Integer  Pre_project_normal_reimbursement ;
	protected java.lang.Integer  Pre_project_travel_reimbursement ;
	protected java.lang.Integer  Company_normal_reimbursement ;
	protected java.lang.Integer  Capital_distribution;
}
