package pomplatform.onprojectquotetemplateworkflow.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnProjectQuoteTemplate extends GenericCondition{

	public ConditionOnProjectQuoteTemplate(){
		setParameterCount(23);
	}

	public java.lang.Integer getProjectQuoteId() {
		return this.__project_quote_id;
	}

	public void setProjectQuoteId( java.lang.Integer value ) {
		this.__project_quote_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.String getTitleName() {
		return this.__title_name;
	}

	public void setTitleName( java.lang.String value ) {
		this.__title_name = value;
	}

	public java.lang.Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( java.lang.Integer value ) {
		this.__file_id = value;
	}

	public java.lang.Integer getVersionNumber() {
		return this.__version_number;
	}

	public void setVersionNumber( java.lang.Integer value ) {
		this.__version_number = value;
	}

	public java.lang.Integer getQuoteStatus() {
		return this.__quote_status;
	}

	public void setQuoteStatus( java.lang.Integer value ) {
		this.__quote_status = value;
	}

	public java.math.BigDecimal getBasicAmount() {
		return this.__basic_amount;
	}

	public void setBasicAmount( java.math.BigDecimal value ) {
		this.__basic_amount = value;
	}

	public java.math.BigDecimal getTotalAmount() {
		return this.__total_amount;
	}

	public void setTotalAmount( java.math.BigDecimal value ) {
		this.__total_amount = value;
	}

	public java.math.BigDecimal getUpAmount() {
		return this.__up_amount;
	}

	public void setUpAmount( java.math.BigDecimal value ) {
		this.__up_amount = value;
	}

	public java.math.BigDecimal getUpPercent() {
		return this.__up_percent;
	}

	public void setUpPercent( java.math.BigDecimal value ) {
		this.__up_percent = value;
	}

	public java.math.BigDecimal getPreferentialAmount() {
		return this.__preferential_amount;
	}

	public void setPreferentialAmount( java.math.BigDecimal value ) {
		this.__preferential_amount = value;
	}

	public java.math.BigDecimal getPerferentialPercent() {
		return this.__perferential_percent;
	}

	public void setPerferentialPercent( java.math.BigDecimal value ) {
		this.__perferential_percent = value;
	}

	public java.math.BigDecimal getSpecialDiscountAmount() {
		return this.__special_discount_amount;
	}

	public void setSpecialDiscountAmount( java.math.BigDecimal value ) {
		this.__special_discount_amount = value;
	}

	public java.math.BigDecimal getSpecialDiscountPercent() {
		return this.__special_discount_percent;
	}

	public void setSpecialDiscountPercent( java.math.BigDecimal value ) {
		this.__special_discount_percent = value;
	}

	public java.math.BigDecimal getTaxAmount() {
		return this.__tax_amount;
	}

	public void setTaxAmount( java.math.BigDecimal value ) {
		this.__tax_amount = value;
	}

	public java.math.BigDecimal getOtherTaxAmount() {
		return this.__other_tax_amount;
	}

	public void setOtherTaxAmount( java.math.BigDecimal value ) {
		this.__other_tax_amount = value;
	}

	public java.math.BigDecimal getFinalPercent() {
		return this.__final_percent;
	}

	public void setFinalPercent( java.math.BigDecimal value ) {
		this.__final_percent = value;
	}

	public java.math.BigDecimal getFinalAmount() {
		return this.__final_amount;
	}

	public void setFinalAmount( java.math.BigDecimal value ) {
		this.__final_amount = value;
	}

	public java.math.BigDecimal getTaxFinalAmount() {
		return this.__tax_final_amount;
	}

	public void setTaxFinalAmount( java.math.BigDecimal value ) {
		this.__tax_final_amount = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectQuoteId() != null) sb.append(__wrapNumber(1, "projectQuoteId", getProjectQuoteId()));
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getTitleName() != null) sb.append(__wrapString(1, "titleName", getTitleName()));
		if(getFileId() != null) sb.append(__wrapNumber(1, "fileId", getFileId()));
		if(getVersionNumber() != null) sb.append(__wrapNumber(1, "versionNumber", getVersionNumber()));
		if(getQuoteStatus() != null) sb.append(__wrapNumber(1, "quoteStatus", getQuoteStatus()));
		if(getBasicAmount() != null) sb.append(__wrapNumber(1, "basicAmount", getBasicAmount()));
		if(getTotalAmount() != null) sb.append(__wrapNumber(1, "totalAmount", getTotalAmount()));
		if(getUpAmount() != null) sb.append(__wrapNumber(1, "upAmount", getUpAmount()));
		if(getUpPercent() != null) sb.append(__wrapNumber(1, "upPercent", getUpPercent()));
		if(getPreferentialAmount() != null) sb.append(__wrapNumber(1, "preferentialAmount", getPreferentialAmount()));
		if(getPerferentialPercent() != null) sb.append(__wrapNumber(1, "perferentialPercent", getPerferentialPercent()));
		if(getSpecialDiscountAmount() != null) sb.append(__wrapNumber(1, "specialDiscountAmount", getSpecialDiscountAmount()));
		if(getSpecialDiscountPercent() != null) sb.append(__wrapNumber(1, "specialDiscountPercent", getSpecialDiscountPercent()));
		if(getTaxAmount() != null) sb.append(__wrapNumber(1, "taxAmount", getTaxAmount()));
		if(getOtherTaxAmount() != null) sb.append(__wrapNumber(1, "otherTaxAmount", getOtherTaxAmount()));
		if(getFinalPercent() != null) sb.append(__wrapNumber(1, "finalPercent", getFinalPercent()));
		if(getFinalAmount() != null) sb.append(__wrapNumber(1, "finalAmount", getFinalAmount()));
		if(getTaxFinalAmount() != null) sb.append(__wrapNumber(1, "taxFinalAmount", getTaxFinalAmount()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(1, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(1, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectQuoteId")) != null) setProjectQuoteId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("titleName")) != null) setTitleName(__getString(val));
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
		if((val = values.get("versionNumber")) != null) setVersionNumber(__getInt(val)); 
		if((val = values.get("quoteStatus")) != null) setQuoteStatus(__getInt(val)); 
		if((val = values.get("basicAmount")) != null) setBasicAmount(__getDecimal(val));  
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getDecimal(val));  
		if((val = values.get("upAmount")) != null) setUpAmount(__getDecimal(val));  
		if((val = values.get("upPercent")) != null) setUpPercent(__getDecimal(val));  
		if((val = values.get("preferentialAmount")) != null) setPreferentialAmount(__getDecimal(val));  
		if((val = values.get("perferentialPercent")) != null) setPerferentialPercent(__getDecimal(val));  
		if((val = values.get("specialDiscountAmount")) != null) setSpecialDiscountAmount(__getDecimal(val));  
		if((val = values.get("specialDiscountPercent")) != null) setSpecialDiscountPercent(__getDecimal(val));  
		if((val = values.get("taxAmount")) != null) setTaxAmount(__getDecimal(val));  
		if((val = values.get("otherTaxAmount")) != null) setOtherTaxAmount(__getDecimal(val));  
		if((val = values.get("finalPercent")) != null) setFinalPercent(__getDecimal(val));  
		if((val = values.get("finalAmount")) != null) setFinalAmount(__getDecimal(val));  
		if((val = values.get("taxFinalAmount")) != null) setTaxFinalAmount(__getDecimal(val));  
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
	}

	private java.lang.Integer __project_quote_id = null;
	private java.lang.Integer __project_id = null;
	private java.lang.String __title_name = null;
	private java.lang.Integer __file_id = null;
	private java.lang.Integer __version_number = null;
	private java.lang.Integer __quote_status = null;
	private java.math.BigDecimal __basic_amount = null;
	private java.math.BigDecimal __total_amount = null;
	private java.math.BigDecimal __up_amount = null;
	private java.math.BigDecimal __up_percent = null;
	private java.math.BigDecimal __preferential_amount = null;
	private java.math.BigDecimal __perferential_percent = null;
	private java.math.BigDecimal __special_discount_amount = null;
	private java.math.BigDecimal __special_discount_percent = null;
	private java.math.BigDecimal __tax_amount = null;
	private java.math.BigDecimal __other_tax_amount = null;
	private java.math.BigDecimal __final_percent = null;
	private java.math.BigDecimal __final_amount = null;
	private java.math.BigDecimal __tax_final_amount = null;
	private java.lang.Integer __operate_employee_id = null;
	private java.util.Date __operate_time = null;
	private java.lang.String __remark = null;
	private java.lang.Integer __company_id = null;
}

