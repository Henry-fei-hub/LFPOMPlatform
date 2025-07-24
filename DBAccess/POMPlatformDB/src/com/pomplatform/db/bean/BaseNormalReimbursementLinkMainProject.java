package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseNormalReimbursementLinkMainProject extends GenericBase implements BaseFactory<BaseNormalReimbursementLinkMainProject>, Comparable<BaseNormalReimbursementLinkMainProject> 
{


	public static BaseNormalReimbursementLinkMainProject newInstance(){
		return new BaseNormalReimbursementLinkMainProject();
	}

	@Override
	public BaseNormalReimbursementLinkMainProject make(){
		BaseNormalReimbursementLinkMainProject b = new BaseNormalReimbursementLinkMainProject();
		return b;
	}

	public final static java.lang.String CS_NORMAL_REIMBURSEMENT_LINK_MAIN_PROJECT_ID = "normal_reimbursement_link_main_project_id" ;
	public final static java.lang.String CS_PROJECT_NORMAL_REIMBURSEMENT_ID = "project_normal_reimbursement_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_NAME = "main_project_name" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_INPUT_TAX = "input_tax" ;
	public final static java.lang.String CS_FINAL_AMOUNT = "final_amount" ;
	public final static java.lang.String CS_IS_PERSONAL_FEE = "is_personal_fee" ;
	public final static java.lang.String CS_MAIN_ITEM_ID = "main_item_id" ;
	public final static java.lang.String CS_SUB_ITEM_ID = "sub_item_id" ;
	public final static java.lang.String CS_INPUT_TAX_REBATE = "input_tax_rebate" ;
	public final static java.lang.String CS_HAVE_ELECTRONIC_INVOICE = "have_electronic_invoice" ;
	public final static java.lang.String CS_INVOICE_LINK_KEY = "invoice_link_key" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,日常报销编码,项目,前期项目名称,信息编号,费用,备注,业务部门,进项税,成本,是否个人承担费用,一级报销科目,二级报销科目,进项税转出,有无电子发票  1 无 2有,发票关联key 用于发票信息关联";

	public java.lang.Integer getNormalReimbursementLinkMainProjectId() {
		return this.__normal_reimbursement_link_main_project_id;
	}

	public void setNormalReimbursementLinkMainProjectId( java.lang.Integer value ) {
		this.__normal_reimbursement_link_main_project_id = value;
	}

	public java.lang.Integer getProjectNormalReimbursementId() {
		return this.__project_normal_reimbursement_id;
	}

	public void setProjectNormalReimbursementId( java.lang.Integer value ) {
		this.__project_normal_reimbursement_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.String getMainProjectName() {
		return this.__main_project_name;
	}

	public void setMainProjectName( java.lang.String value ) {
		this.__main_project_name = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getInputTax() {
		return this.__input_tax;
	}

	public void setInputTax( java.math.BigDecimal value ) {
		this.__input_tax = value;
	}

	public java.math.BigDecimal getFinalAmount() {
		return this.__final_amount;
	}

	public void setFinalAmount( java.math.BigDecimal value ) {
		this.__final_amount = value;
	}

	public java.lang.Boolean getIsPersonalFee() {
		return this.__is_personal_fee;
	}

	public void setIsPersonalFee( java.lang.Boolean value ) {
		this.__is_personal_fee = value;
	}

	public java.lang.Integer getMainItemId() {
		return this.__main_item_id;
	}

	public void setMainItemId( java.lang.Integer value ) {
		this.__main_item_id = value;
	}

	public java.lang.Integer getSubItemId() {
		return this.__sub_item_id;
	}

	public void setSubItemId( java.lang.Integer value ) {
		this.__sub_item_id = value;
	}

	public java.math.BigDecimal getInputTaxRebate() {
		return this.__input_tax_rebate;
	}

	public void setInputTaxRebate( java.math.BigDecimal value ) {
		this.__input_tax_rebate = value;
	}

	public java.lang.Integer getHaveElectronicInvoice() {
		return this.__have_electronic_invoice;
	}

	public void setHaveElectronicInvoice( java.lang.Integer value ) {
		this.__have_electronic_invoice = value;
	}

	public java.lang.Integer getInvoiceLinkKey() {
		return this.__invoice_link_key;
	}

	public void setInvoiceLinkKey( java.lang.Integer value ) {
		this.__invoice_link_key = value;
	}

	public void cloneCopy(BaseNormalReimbursementLinkMainProject __bean){
		__bean.setNormalReimbursementLinkMainProjectId(getNormalReimbursementLinkMainProjectId());
		__bean.setProjectNormalReimbursementId(getProjectNormalReimbursementId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setMainProjectName(getMainProjectName());
		__bean.setInfoCode(getInfoCode());
		__bean.setAmount(getAmount());
		__bean.setRemark(getRemark());
		__bean.setPlateId(getPlateId());
		__bean.setInputTax(getInputTax());
		__bean.setFinalAmount(getFinalAmount());
		__bean.setIsPersonalFee(getIsPersonalFee());
		__bean.setMainItemId(getMainItemId());
		__bean.setSubItemId(getSubItemId());
		__bean.setInputTaxRebate(getInputTaxRebate());
		__bean.setHaveElectronicInvoice(getHaveElectronicInvoice());
		__bean.setInvoiceLinkKey(getInvoiceLinkKey());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getNormalReimbursementLinkMainProjectId() == null ? "" : getNormalReimbursementLinkMainProjectId());
		sb.append(",");
		sb.append(getProjectNormalReimbursementId() == null ? "" : getProjectNormalReimbursementId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getMainProjectName() == null ? "" : getMainProjectName());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getInputTax() == null ? "" : getInputTax());
		sb.append(",");
		sb.append(getFinalAmount() == null ? "" : getFinalAmount());
		sb.append(",");
		sb.append(getIsPersonalFee() == null ? "" : getIsPersonalFee());
		sb.append(",");
		sb.append(getMainItemId() == null ? "" : getMainItemId());
		sb.append(",");
		sb.append(getSubItemId() == null ? "" : getSubItemId());
		sb.append(",");
		sb.append(getInputTaxRebate() == null ? "" : getInputTaxRebate());
		sb.append(",");
		sb.append(getHaveElectronicInvoice() == null ? "" : getHaveElectronicInvoice());
		sb.append(",");
		sb.append(getInvoiceLinkKey() == null ? "" : getInvoiceLinkKey());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseNormalReimbursementLinkMainProject o) {
		return __normal_reimbursement_link_main_project_id == null ? -1 : __normal_reimbursement_link_main_project_id.compareTo(o.getNormalReimbursementLinkMainProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__normal_reimbursement_link_main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_normal_reimbursement_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_name);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__input_tax);
		hash = 97 * hash + Objects.hashCode(this.__final_amount);
		hash = 97 * hash + Objects.hashCode(this.__is_personal_fee);
		hash = 97 * hash + Objects.hashCode(this.__main_item_id);
		hash = 97 * hash + Objects.hashCode(this.__sub_item_id);
		hash = 97 * hash + Objects.hashCode(this.__input_tax_rebate);
		hash = 97 * hash + Objects.hashCode(this.__have_electronic_invoice);
		hash = 97 * hash + Objects.hashCode(this.__invoice_link_key);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseNormalReimbursementLinkMainProject o = (BaseNormalReimbursementLinkMainProject)obj;
		if(!Objects.equals(this.__normal_reimbursement_link_main_project_id, o.getNormalReimbursementLinkMainProjectId())) return false;
		if(!Objects.equals(this.__project_normal_reimbursement_id, o.getProjectNormalReimbursementId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__main_project_name, o.getMainProjectName())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__input_tax, o.getInputTax())) return false;
		if(!Objects.equals(this.__final_amount, o.getFinalAmount())) return false;
		if(!Objects.equals(this.__is_personal_fee, o.getIsPersonalFee())) return false;
		if(!Objects.equals(this.__main_item_id, o.getMainItemId())) return false;
		if(!Objects.equals(this.__sub_item_id, o.getSubItemId())) return false;
		if(!Objects.equals(this.__input_tax_rebate, o.getInputTaxRebate())) return false;
		if(!Objects.equals(this.__have_electronic_invoice, o.getHaveElectronicInvoice())) return false;
		if(!Objects.equals(this.__invoice_link_key, o.getInvoiceLinkKey())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getNormalReimbursementLinkMainProjectId() != null) sb.append(__wrapNumber(count++, "normalReimbursementLinkMainProjectId", getNormalReimbursementLinkMainProjectId()));
		if(getProjectNormalReimbursementId() != null) sb.append(__wrapNumber(count++, "projectNormalReimbursementId", getProjectNormalReimbursementId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getMainProjectName() != null) sb.append(__wrapString(count++, "mainProjectName", getMainProjectName()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getInputTax() != null) sb.append(__wrapDecimal(count++, "inputTax", getInputTax()));
		if(getFinalAmount() != null) sb.append(__wrapDecimal(count++, "finalAmount", getFinalAmount()));
		if(getIsPersonalFee() != null) sb.append(__wrapBoolean(count++, "isPersonalFee", getIsPersonalFee()));
		if(getMainItemId() != null) sb.append(__wrapNumber(count++, "mainItemId", getMainItemId()));
		if(getSubItemId() != null) sb.append(__wrapNumber(count++, "subItemId", getSubItemId()));
		if(getInputTaxRebate() != null) sb.append(__wrapDecimal(count++, "inputTaxRebate", getInputTaxRebate()));
		if(getHaveElectronicInvoice() != null) sb.append(__wrapNumber(count++, "haveElectronicInvoice", getHaveElectronicInvoice()));
		if(getInvoiceLinkKey() != null) sb.append(__wrapNumber(count++, "invoiceLinkKey", getInvoiceLinkKey()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getNormalReimbursementLinkMainProjectId() != null) res.put("normalReimbursementLinkMainProjectId", getNormalReimbursementLinkMainProjectId());
		if(getProjectNormalReimbursementId() != null) res.put("projectNormalReimbursementId", getProjectNormalReimbursementId());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getMainProjectName() != null) res.put("mainProjectName", getMainProjectName());
		if(getInfoCode() != null) res.put("infoCode", getInfoCode());
		if(getAmount() != null) res.put("amount", getAmount());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getInputTax() != null) res.put("inputTax", getInputTax());
		if(getFinalAmount() != null) res.put("finalAmount", getFinalAmount());
		if(getIsPersonalFee() != null) res.put("isPersonalFee", getIsPersonalFee());
		if(getMainItemId() != null) res.put("mainItemId", getMainItemId());
		if(getSubItemId() != null) res.put("subItemId", getSubItemId());
		if(getInputTaxRebate() != null) res.put("inputTaxRebate", getInputTaxRebate());
		if(getHaveElectronicInvoice() != null) res.put("haveElectronicInvoice", getHaveElectronicInvoice());
		if(getInvoiceLinkKey() != null) res.put("invoiceLinkKey", getInvoiceLinkKey());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("normalReimbursementLinkMainProjectId")) != null) setNormalReimbursementLinkMainProjectId(__getInt(val)); 
		if((val = values.get("projectNormalReimbursementId")) != null) setProjectNormalReimbursementId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("mainProjectName")) != null) setMainProjectName(__getString(val));
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("inputTax")) != null) setInputTax(__getDecimal(val));  
		if((val = values.get("finalAmount")) != null) setFinalAmount(__getDecimal(val));  
		if((val = values.get("isPersonalFee")) != null) setIsPersonalFee(__getBoolean(val));
		if((val = values.get("mainItemId")) != null) setMainItemId(__getInt(val)); 
		if((val = values.get("subItemId")) != null) setSubItemId(__getInt(val)); 
		if((val = values.get("inputTaxRebate")) != null) setInputTaxRebate(__getDecimal(val));  
		if((val = values.get("haveElectronicInvoice")) != null) setHaveElectronicInvoice(__getInt(val)); 
		if((val = values.get("invoiceLinkKey")) != null) setInvoiceLinkKey(__getInt(val)); 
	}

	protected java.lang.Integer  __normal_reimbursement_link_main_project_id ;
	protected java.lang.Integer  __project_normal_reimbursement_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.String  __main_project_name ;
	protected java.lang.String  __info_code ;
	protected java.math.BigDecimal  __amount ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __input_tax ;
	protected java.math.BigDecimal  __final_amount ;
	protected java.lang.Boolean  __is_personal_fee ;
	protected java.lang.Integer  __main_item_id ;
	protected java.lang.Integer  __sub_item_id ;
	protected java.math.BigDecimal  __input_tax_rebate ;
	protected java.lang.Integer  __have_electronic_invoice ;
	protected java.lang.Integer  __invoice_link_key ;
}
