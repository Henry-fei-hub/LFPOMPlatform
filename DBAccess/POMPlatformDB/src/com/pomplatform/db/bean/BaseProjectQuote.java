package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProjectQuote extends GenericBase implements BaseFactory<BaseProjectQuote>, Comparable<BaseProjectQuote> 
{


	public static BaseProjectQuote newInstance(){
		return new BaseProjectQuote();
	}

	@Override
	public BaseProjectQuote make(){
		BaseProjectQuote b = new BaseProjectQuote();
		return b;
	}

	public final static java.lang.String CS_PROJECT_QUOTE_ID = "project_quote_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_TITLE_NAME = "title_name" ;
	public final static java.lang.String CS_FILE_ID = "file_id" ;
	public final static java.lang.String CS_VERSION_NUMBER = "version_number" ;
	public final static java.lang.String CS_QUOTE_STATUS = "quote_status" ;
	public final static java.lang.String CS_BASIC_AMOUNT = "basic_amount" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static java.lang.String CS_UP_AMOUNT = "up_amount" ;
	public final static java.lang.String CS_UP_PERCENT = "up_percent" ;
	public final static java.lang.String CS_PREFERENTIAL_AMOUNT = "preferential_amount" ;
	public final static java.lang.String CS_PERFERENTIAL_PERCENT = "perferential_percent" ;
	public final static java.lang.String CS_SPECIAL_DISCOUNT_AMOUNT = "special_discount_amount" ;
	public final static java.lang.String CS_SPECIAL_DISCOUNT_PERCENT = "special_discount_percent" ;
	public final static java.lang.String CS_TAX_AMOUNT = "tax_amount" ;
	public final static java.lang.String CS_OTHER_TAX_AMOUNT = "other_tax_amount" ;
	public final static java.lang.String CS_FINAL_PERCENT = "final_percent" ;
	public final static java.lang.String CS_FINAL_AMOUNT = "final_amount" ;
	public final static java.lang.String CS_TAX_FINAL_AMOUNT = "tax_final_amount" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PROJECT_QUOTE_TEMPLATES_PARENT_ID = "project_quote_templates_parent_id" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目id,主题名称,过往合作项目报价图片,版本号,2报价进行中,3已报价),基准总额,小计总额,上浮金额,上浮系数,优惠金额,优惠系数,特殊折扣金额,特殊折扣系数,税金,其它税金（采买）,最终系数,不含税合计,含税合计,操作人,操作时间,备注,模板父级id,业务类别";

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

	public java.lang.Integer getProjectQuoteTemplatesParentId() {
		return this.__project_quote_templates_parent_id;
	}

	public void setProjectQuoteTemplatesParentId( java.lang.Integer value ) {
		this.__project_quote_templates_parent_id = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public void cloneCopy(BaseProjectQuote __bean){
		__bean.setProjectQuoteId(getProjectQuoteId());
		__bean.setProjectId(getProjectId());
		__bean.setTitleName(getTitleName());
		__bean.setFileId(getFileId());
		__bean.setVersionNumber(getVersionNumber());
		__bean.setQuoteStatus(getQuoteStatus());
		__bean.setBasicAmount(getBasicAmount());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setUpAmount(getUpAmount());
		__bean.setUpPercent(getUpPercent());
		__bean.setPreferentialAmount(getPreferentialAmount());
		__bean.setPerferentialPercent(getPerferentialPercent());
		__bean.setSpecialDiscountAmount(getSpecialDiscountAmount());
		__bean.setSpecialDiscountPercent(getSpecialDiscountPercent());
		__bean.setTaxAmount(getTaxAmount());
		__bean.setOtherTaxAmount(getOtherTaxAmount());
		__bean.setFinalPercent(getFinalPercent());
		__bean.setFinalAmount(getFinalAmount());
		__bean.setTaxFinalAmount(getTaxFinalAmount());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
		__bean.setProjectQuoteTemplatesParentId(getProjectQuoteTemplatesParentId());
		__bean.setBusinessType(getBusinessType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectQuoteId() == null ? "" : getProjectQuoteId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getTitleName() == null ? "" : getTitleName());
		sb.append(",");
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getVersionNumber() == null ? "" : getVersionNumber());
		sb.append(",");
		sb.append(getQuoteStatus() == null ? "" : getQuoteStatus());
		sb.append(",");
		sb.append(getBasicAmount() == null ? "" : getBasicAmount());
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		sb.append(",");
		sb.append(getUpAmount() == null ? "" : getUpAmount());
		sb.append(",");
		sb.append(getUpPercent() == null ? "" : getUpPercent());
		sb.append(",");
		sb.append(getPreferentialAmount() == null ? "" : getPreferentialAmount());
		sb.append(",");
		sb.append(getPerferentialPercent() == null ? "" : getPerferentialPercent());
		sb.append(",");
		sb.append(getSpecialDiscountAmount() == null ? "" : getSpecialDiscountAmount());
		sb.append(",");
		sb.append(getSpecialDiscountPercent() == null ? "" : getSpecialDiscountPercent());
		sb.append(",");
		sb.append(getTaxAmount() == null ? "" : getTaxAmount());
		sb.append(",");
		sb.append(getOtherTaxAmount() == null ? "" : getOtherTaxAmount());
		sb.append(",");
		sb.append(getFinalPercent() == null ? "" : getFinalPercent());
		sb.append(",");
		sb.append(getFinalAmount() == null ? "" : getFinalAmount());
		sb.append(",");
		sb.append(getTaxFinalAmount() == null ? "" : getTaxFinalAmount());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getProjectQuoteTemplatesParentId() == null ? "" : getProjectQuoteTemplatesParentId());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectQuote o) {
		return __project_quote_id == null ? -1 : __project_quote_id.compareTo(o.getProjectQuoteId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_quote_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__title_name);
		hash = 97 * hash + Objects.hashCode(this.__file_id);
		hash = 97 * hash + Objects.hashCode(this.__version_number);
		hash = 97 * hash + Objects.hashCode(this.__quote_status);
		hash = 97 * hash + Objects.hashCode(this.__basic_amount);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__up_amount);
		hash = 97 * hash + Objects.hashCode(this.__up_percent);
		hash = 97 * hash + Objects.hashCode(this.__preferential_amount);
		hash = 97 * hash + Objects.hashCode(this.__perferential_percent);
		hash = 97 * hash + Objects.hashCode(this.__special_discount_amount);
		hash = 97 * hash + Objects.hashCode(this.__special_discount_percent);
		hash = 97 * hash + Objects.hashCode(this.__tax_amount);
		hash = 97 * hash + Objects.hashCode(this.__other_tax_amount);
		hash = 97 * hash + Objects.hashCode(this.__final_percent);
		hash = 97 * hash + Objects.hashCode(this.__final_amount);
		hash = 97 * hash + Objects.hashCode(this.__tax_final_amount);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__project_quote_templates_parent_id);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectQuote o = (BaseProjectQuote)obj;
		if(!Objects.equals(this.__project_quote_id, o.getProjectQuoteId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__title_name, o.getTitleName())) return false;
		if(!Objects.equals(this.__file_id, o.getFileId())) return false;
		if(!Objects.equals(this.__version_number, o.getVersionNumber())) return false;
		if(!Objects.equals(this.__quote_status, o.getQuoteStatus())) return false;
		if(!Objects.equals(this.__basic_amount, o.getBasicAmount())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__up_amount, o.getUpAmount())) return false;
		if(!Objects.equals(this.__up_percent, o.getUpPercent())) return false;
		if(!Objects.equals(this.__preferential_amount, o.getPreferentialAmount())) return false;
		if(!Objects.equals(this.__perferential_percent, o.getPerferentialPercent())) return false;
		if(!Objects.equals(this.__special_discount_amount, o.getSpecialDiscountAmount())) return false;
		if(!Objects.equals(this.__special_discount_percent, o.getSpecialDiscountPercent())) return false;
		if(!Objects.equals(this.__tax_amount, o.getTaxAmount())) return false;
		if(!Objects.equals(this.__other_tax_amount, o.getOtherTaxAmount())) return false;
		if(!Objects.equals(this.__final_percent, o.getFinalPercent())) return false;
		if(!Objects.equals(this.__final_amount, o.getFinalAmount())) return false;
		if(!Objects.equals(this.__tax_final_amount, o.getTaxFinalAmount())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__project_quote_templates_parent_id, o.getProjectQuoteTemplatesParentId())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectQuoteId() != null) sb.append(__wrapNumber(count++, "projectQuoteId", getProjectQuoteId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getTitleName() != null) sb.append(__wrapString(count++, "titleName", getTitleName()));
		if(getFileId() != null) sb.append(__wrapNumber(count++, "fileId", getFileId()));
		if(getVersionNumber() != null) sb.append(__wrapNumber(count++, "versionNumber", getVersionNumber()));
		if(getQuoteStatus() != null) sb.append(__wrapNumber(count++, "quoteStatus", getQuoteStatus()));
		if(getBasicAmount() != null) sb.append(__wrapDecimal(count++, "basicAmount", getBasicAmount()));
		if(getTotalAmount() != null) sb.append(__wrapDecimal(count++, "totalAmount", getTotalAmount()));
		if(getUpAmount() != null) sb.append(__wrapDecimal(count++, "upAmount", getUpAmount()));
		if(getUpPercent() != null) sb.append(__wrapDecimal(count++, "upPercent", getUpPercent()));
		if(getPreferentialAmount() != null) sb.append(__wrapDecimal(count++, "preferentialAmount", getPreferentialAmount()));
		if(getPerferentialPercent() != null) sb.append(__wrapDecimal(count++, "perferentialPercent", getPerferentialPercent()));
		if(getSpecialDiscountAmount() != null) sb.append(__wrapDecimal(count++, "specialDiscountAmount", getSpecialDiscountAmount()));
		if(getSpecialDiscountPercent() != null) sb.append(__wrapDecimal(count++, "specialDiscountPercent", getSpecialDiscountPercent()));
		if(getTaxAmount() != null) sb.append(__wrapDecimal(count++, "taxAmount", getTaxAmount()));
		if(getOtherTaxAmount() != null) sb.append(__wrapDecimal(count++, "otherTaxAmount", getOtherTaxAmount()));
		if(getFinalPercent() != null) sb.append(__wrapDecimal(count++, "finalPercent", getFinalPercent()));
		if(getFinalAmount() != null) sb.append(__wrapDecimal(count++, "finalAmount", getFinalAmount()));
		if(getTaxFinalAmount() != null) sb.append(__wrapDecimal(count++, "taxFinalAmount", getTaxFinalAmount()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getProjectQuoteTemplatesParentId() != null) sb.append(__wrapNumber(count++, "projectQuoteTemplatesParentId", getProjectQuoteTemplatesParentId()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
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
		if((val = values.get("projectQuoteTemplatesParentId")) != null) setProjectQuoteTemplatesParentId(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
	}

	protected java.lang.Integer  __project_quote_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __title_name ;
	protected java.lang.Integer  __file_id ;
	protected java.lang.Integer  __version_number ;
	protected java.lang.Integer  __quote_status ;
	protected java.math.BigDecimal  __basic_amount ;
	protected java.math.BigDecimal  __total_amount ;
	protected java.math.BigDecimal  __up_amount ;
	protected java.math.BigDecimal  __up_percent ;
	protected java.math.BigDecimal  __preferential_amount ;
	protected java.math.BigDecimal  __perferential_percent ;
	protected java.math.BigDecimal  __special_discount_amount ;
	protected java.math.BigDecimal  __special_discount_percent ;
	protected java.math.BigDecimal  __tax_amount ;
	protected java.math.BigDecimal  __other_tax_amount ;
	protected java.math.BigDecimal  __final_percent ;
	protected java.math.BigDecimal  __final_amount ;
	protected java.math.BigDecimal  __tax_final_amount ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __project_quote_templates_parent_id ;
	protected java.lang.Integer  __business_type ;
}
