package pomplatform.purchase.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMpurchaseplanmsommpmosror extends GenericBase implements BaseFactory<BaseMpurchaseplanmsommpmosror>, Comparable<BaseMpurchaseplanmsommpmosror> 
{


	public static BaseMpurchaseplanmsommpmosror newInstance(){
		return new BaseMpurchaseplanmsommpmosror();
	}

	@Override
	public BaseMpurchaseplanmsommpmosror make(){
		BaseMpurchaseplanmsommpmosror b = new BaseMpurchaseplanmsommpmosror();
		return b;
	}

	public final static java.lang.String CS_PURCHASE_PLAN_ID = "purchase_plan_id" ;
	public final static java.lang.String CS_PERSON_IN_CHARGE = "person_in_charge" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_ORI_PERSONNEL_BUSINESS_ID = "ori_personnel_business_id" ;
	public final static java.lang.String CS_PURCHASE_DATE = "purchase_date" ;
	public final static java.lang.String CS_PURCHASE_AMOUNT = "purchase_amount" ;
	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_SUPPLIER_NAME = "supplier_name" ;
	public final static java.lang.String CS_SUPPLIER_CODE = "supplier_code" ;
	public final static java.lang.String CS_ABBREVIATED_NAME = "abbreviated_name" ;
	public final static java.lang.String CS_MAJOR_CONTACT_PERSON = "major_contact_person" ;
	public final static java.lang.String CS_CONTACT_PHONE = "contact_phone" ;
	public final static java.lang.String CS_TAX_AMOUNT = "tax_amount" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_IS_COMPLETE = "is_complete" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_DEAL_STATUS = "deal_status" ;
	public final static java.lang.String CS_PURCHASE_CONTRACT_ID = "purchase_contract_id" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_TO_PERSONNEL_BUSINESS_ID = "to_personnel_business_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,负责人,大项目主键,项目编号,项目名称,源流程业务主键,采购日期,采购金额,供应商主键,供应商名称,供应商编号,供应商简称,主要联系人,客户联系人电话,含税金额,备注,创建时间,是否完成,操作人(指派人),处理状态(0 新建 1采购申请中 2采购被驳回 3已完成采购),采购合同表主键,合同名称,合同编号,采购实施业务主键";

	public java.lang.Integer getPurchasePlanId() {
		return this.__purchase_plan_id;
	}

	public void setPurchasePlanId( java.lang.Integer value ) {
		this.__purchase_plan_id = value;
	}

	public java.lang.Integer getPersonInCharge() {
		return this.__person_in_charge;
	}

	public void setPersonInCharge( java.lang.Integer value ) {
		this.__person_in_charge = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Integer getOriPersonnelBusinessId() {
		return this.__ori_personnel_business_id;
	}

	public void setOriPersonnelBusinessId( java.lang.Integer value ) {
		this.__ori_personnel_business_id = value;
	}

	public java.util.Date getPurchaseDate() {
		return this.__purchase_date;
	}

	public void setPurchaseDate( java.util.Date value ) {
		this.__purchase_date = value;
	}

	public java.math.BigDecimal getPurchaseAmount() {
		return this.__purchase_amount;
	}

	public void setPurchaseAmount( java.math.BigDecimal value ) {
		this.__purchase_amount = value;
	}

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.lang.String getSupplierName() {
		return this.__supplier_name;
	}

	public void setSupplierName( java.lang.String value ) {
		this.__supplier_name = value;
	}

	public java.lang.String getSupplierCode() {
		return this.__supplier_code;
	}

	public void setSupplierCode( java.lang.String value ) {
		this.__supplier_code = value;
	}

	public java.lang.String getAbbreviatedName() {
		return this.__abbreviated_name;
	}

	public void setAbbreviatedName( java.lang.String value ) {
		this.__abbreviated_name = value;
	}

	public java.lang.String getMajorContactPerson() {
		return this.__major_contact_person;
	}

	public void setMajorContactPerson( java.lang.String value ) {
		this.__major_contact_person = value;
	}

	public java.lang.String getContactPhone() {
		return this.__contact_phone;
	}

	public void setContactPhone( java.lang.String value ) {
		this.__contact_phone = value;
	}

	public java.math.BigDecimal getTaxAmount() {
		return this.__tax_amount;
	}

	public void setTaxAmount( java.math.BigDecimal value ) {
		this.__tax_amount = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Boolean getIsComplete() {
		return this.__is_complete;
	}

	public void setIsComplete( java.lang.Boolean value ) {
		this.__is_complete = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.lang.Integer getDealStatus() {
		return this.__deal_status;
	}

	public void setDealStatus( java.lang.Integer value ) {
		this.__deal_status = value;
	}

	public java.lang.Integer getPurchaseContractId() {
		return this.__purchase_contract_id;
	}

	public void setPurchaseContractId( java.lang.Integer value ) {
		this.__purchase_contract_id = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.Integer getToPersonnelBusinessId() {
		return this.__to_personnel_business_id;
	}

	public void setToPersonnelBusinessId( java.lang.Integer value ) {
		this.__to_personnel_business_id = value;
	}

	public void cloneCopy(BaseMpurchaseplanmsommpmosror __bean){
		__bean.setPurchasePlanId(getPurchasePlanId());
		__bean.setPersonInCharge(getPersonInCharge());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setOriPersonnelBusinessId(getOriPersonnelBusinessId());
		__bean.setPurchaseDate(getPurchaseDate());
		__bean.setPurchaseAmount(getPurchaseAmount());
		__bean.setSupplierId(getSupplierId());
		__bean.setSupplierName(getSupplierName());
		__bean.setSupplierCode(getSupplierCode());
		__bean.setAbbreviatedName(getAbbreviatedName());
		__bean.setMajorContactPerson(getMajorContactPerson());
		__bean.setContactPhone(getContactPhone());
		__bean.setTaxAmount(getTaxAmount());
		__bean.setRemark(getRemark());
		__bean.setCreateTime(getCreateTime());
		__bean.setIsComplete(getIsComplete());
		__bean.setOperatorId(getOperatorId());
		__bean.setDealStatus(getDealStatus());
		__bean.setPurchaseContractId(getPurchaseContractId());
		__bean.setContractName(getContractName());
		__bean.setContractCode(getContractCode());
		__bean.setToPersonnelBusinessId(getToPersonnelBusinessId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPurchasePlanId() == null ? "" : getPurchasePlanId());
		sb.append(",");
		sb.append(getPersonInCharge() == null ? "" : getPersonInCharge());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		String strProjectCode = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getProjectCode()));
		sb.append(strProjectCode == null ? "" : strProjectCode);
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getOriPersonnelBusinessId() == null ? "" : getOriPersonnelBusinessId());
		sb.append(",");
		sb.append(getPurchaseDate() == null ? "" : sdf.format(getPurchaseDate()));
		sb.append(",");
		sb.append(getPurchaseAmount() == null ? "" : getPurchaseAmount());
		sb.append(",");
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getSupplierName() == null ? "" : getSupplierName());
		sb.append(",");
		sb.append(getSupplierCode() == null ? "" : getSupplierCode());
		sb.append(",");
		sb.append(getAbbreviatedName() == null ? "" : getAbbreviatedName());
		sb.append(",");
		sb.append(getMajorContactPerson() == null ? "" : getMajorContactPerson());
		sb.append(",");
		sb.append(getContactPhone() == null ? "" : getContactPhone());
		sb.append(",");
		sb.append(getTaxAmount() == null ? "" : getTaxAmount());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getIsComplete() == null ? "" : getIsComplete());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getDealStatus() == null ? "" : getDealStatus());
		sb.append(",");
		sb.append(getPurchaseContractId() == null ? "" : getPurchaseContractId());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getToPersonnelBusinessId() == null ? "" : getToPersonnelBusinessId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMpurchaseplanmsommpmosror o) {
		return __purchase_plan_id == null ? -1 : __purchase_plan_id.compareTo(o.getPurchasePlanId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__purchase_plan_id);
		hash = 97 * hash + Objects.hashCode(this.__person_in_charge);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__ori_personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__purchase_date);
		hash = 97 * hash + Objects.hashCode(this.__purchase_amount);
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__supplier_name);
		hash = 97 * hash + Objects.hashCode(this.__supplier_code);
		hash = 97 * hash + Objects.hashCode(this.__abbreviated_name);
		hash = 97 * hash + Objects.hashCode(this.__major_contact_person);
		hash = 97 * hash + Objects.hashCode(this.__contact_phone);
		hash = 97 * hash + Objects.hashCode(this.__tax_amount);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__is_complete);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__deal_status);
		hash = 97 * hash + Objects.hashCode(this.__purchase_contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__to_personnel_business_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMpurchaseplanmsommpmosror o = (BaseMpurchaseplanmsommpmosror)obj;
		if(!Objects.equals(this.__purchase_plan_id, o.getPurchasePlanId())) return false;
		if(!Objects.equals(this.__person_in_charge, o.getPersonInCharge())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__ori_personnel_business_id, o.getOriPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__purchase_date, o.getPurchaseDate())) return false;
		if(!Objects.equals(this.__purchase_amount, o.getPurchaseAmount())) return false;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__supplier_name, o.getSupplierName())) return false;
		if(!Objects.equals(this.__supplier_code, o.getSupplierCode())) return false;
		if(!Objects.equals(this.__abbreviated_name, o.getAbbreviatedName())) return false;
		if(!Objects.equals(this.__major_contact_person, o.getMajorContactPerson())) return false;
		if(!Objects.equals(this.__contact_phone, o.getContactPhone())) return false;
		if(!Objects.equals(this.__tax_amount, o.getTaxAmount())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__is_complete, o.getIsComplete())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__deal_status, o.getDealStatus())) return false;
		if(!Objects.equals(this.__purchase_contract_id, o.getPurchaseContractId())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__to_personnel_business_id, o.getToPersonnelBusinessId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPurchasePlanId() != null) sb.append(__wrapNumber(count++, "purchasePlanId", getPurchasePlanId()));
		if(getPersonInCharge() != null) sb.append(__wrapNumber(count++, "personInCharge", getPersonInCharge()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getOriPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "oriPersonnelBusinessId", getOriPersonnelBusinessId()));
		if(getPurchaseDate() != null) sb.append(__wrapDate(count++, "purchaseDate", getPurchaseDate()));
		if(getPurchaseAmount() != null) sb.append(__wrapDecimal(count++, "purchaseAmount", getPurchaseAmount()));
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getSupplierName() != null) sb.append(__wrapString(count++, "supplierName", getSupplierName()));
		if(getSupplierCode() != null) sb.append(__wrapString(count++, "supplierCode", getSupplierCode()));
		if(getAbbreviatedName() != null) sb.append(__wrapString(count++, "abbreviatedName", getAbbreviatedName()));
		if(getMajorContactPerson() != null) sb.append(__wrapString(count++, "majorContactPerson", getMajorContactPerson()));
		if(getContactPhone() != null) sb.append(__wrapString(count++, "contactPhone", getContactPhone()));
		if(getTaxAmount() != null) sb.append(__wrapDecimal(count++, "taxAmount", getTaxAmount()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getIsComplete() != null) sb.append(__wrapBoolean(count++, "isComplete", getIsComplete()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getDealStatus() != null) sb.append(__wrapNumber(count++, "dealStatus", getDealStatus()));
		if(getPurchaseContractId() != null) sb.append(__wrapNumber(count++, "purchaseContractId", getPurchaseContractId()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getToPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "toPersonnelBusinessId", getToPersonnelBusinessId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("purchasePlanId")) != null) setPurchasePlanId(__getInt(val)); 
		if((val = values.get("personInCharge")) != null) setPersonInCharge(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("oriPersonnelBusinessId")) != null) setOriPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("purchaseDate")) != null) setPurchaseDate(__getDate(val)); 
		if((val = values.get("purchaseAmount")) != null) setPurchaseAmount(__getDecimal(val));  
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("supplierName")) != null) setSupplierName(__getString(val));
		if((val = values.get("supplierCode")) != null) setSupplierCode(__getString(val));
		if((val = values.get("abbreviatedName")) != null) setAbbreviatedName(__getString(val));
		if((val = values.get("majorContactPerson")) != null) setMajorContactPerson(__getString(val));
		if((val = values.get("contactPhone")) != null) setContactPhone(__getString(val));
		if((val = values.get("taxAmount")) != null) setTaxAmount(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("isComplete")) != null) setIsComplete(__getBoolean(val));
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("dealStatus")) != null) setDealStatus(__getInt(val)); 
		if((val = values.get("purchaseContractId")) != null) setPurchaseContractId(__getInt(val)); 
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("toPersonnelBusinessId")) != null) setToPersonnelBusinessId(__getInt(val)); 
	}

	protected java.lang.Integer  __purchase_plan_id ;
	protected java.lang.Integer  __person_in_charge ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __ori_personnel_business_id ;
	protected java.util.Date  __purchase_date ;
	protected java.math.BigDecimal  __purchase_amount ;
	protected java.lang.Integer  __supplier_id ;
	protected java.lang.String  __supplier_name ;
	protected java.lang.String  __supplier_code ;
	protected java.lang.String  __abbreviated_name ;
	protected java.lang.String  __major_contact_person ;
	protected java.lang.String  __contact_phone ;
	protected java.math.BigDecimal  __tax_amount ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __create_time ;
	protected java.lang.Boolean  __is_complete ;
	protected java.lang.Integer  __operator_id ;
	protected java.lang.Integer  __deal_status ;
	protected java.lang.Integer  __purchase_contract_id ;
	protected java.lang.String  __contract_name ;
	protected java.lang.String  __contract_code ;
	protected java.lang.Integer  __to_personnel_business_id ;
}
