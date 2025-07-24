package pomplatform.purchase.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSpurchasepaymentor extends GenericBase implements BaseFactory<BaseSpurchasepaymentor>, Comparable<BaseSpurchasepaymentor> 
{


	public static BaseSpurchasepaymentor newInstance(){
		return new BaseSpurchasepaymentor();
	}

	@Override
	public BaseSpurchasepaymentor make(){
		BaseSpurchasepaymentor b = new BaseSpurchasepaymentor();
		return b;
	}

	public final static java.lang.String CS_PURCHASE_PAYMENT_ID = "purchase_payment_id" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_PAYMENT_DATE = "payment_date" ;
	public final static java.lang.String CS_PAYMENT_NAME = "payment_name" ;
	public final static java.lang.String CS_PAYMENT_CONDITION = "payment_condition" ;
	public final static java.lang.String CS_PAYMENT_RATIO = "payment_ratio" ;
	public final static java.lang.String CS_PAYMENT_AMOUNT = "payment_amount" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_PURCHASE_CONTRACT_ID = "purchase_contract_id" ;
	public final static java.lang.String CS_PURCHASE_PAYMENT_STATUS = "purchase_payment_status" ;
	public final static java.lang.String CS_PERSON_IN_CHARGE = "person_in_charge" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_REAL_PAYMENT_DATE = "real_payment_date" ;
	public final static java.lang.String CS_REAL_PAYMENT_AMOUNT = "real_payment_amount" ;
	public final static java.lang.String CS_PROCESS_BUSINESS_ID = "process_business_id" ;
	public final static java.lang.String CS_DEAL_STATUS = "deal_status" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_AMOUNT = "contract_amount" ;
	public final static java.lang.String CS_CONTRACT_DATE = "contract_date" ;
	public final static java.lang.String CS_PURCHASE_PERSON = "purchase_person" ;
	public final static java.lang.String CS_AFTER_SALE_REQUIREMENTS = "after_sale_requirements" ;
	public final static java.lang.String CS_QUALITY_ASSURANCE = "quality_assurance" ;
	public final static java.lang.String CS_TERM_OF_PAYMENT = "term_of_payment" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_SUPPLIER_NAME = "supplier_name" ;
	public final static java.lang.String CS_ABBREVIATED_NAME = "abbreviated_name" ;
	public final static java.lang.String CS_MAJOR_CONTACT_PERSON = "major_contact_person" ;
	public final static java.lang.String CS_CONTACT_PHONE = "contact_phone" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,流程表主键,计划付款日期,款项名称(预付款、第一次付款),付款条件,付款比例,付款金额,备注,创建时间,采购合同表主键,流程状态 0新建 3通过审批完成,负责人,操作人,真实付款时间,真实付款金额,流程业务表主键,处理状态 0新建 1付款申请中 2付款被驳回 3已付款,合同名称,合同编号,合同金额,合同签订日期,订购人,售后要求,质保,付款条件,项目,项目名称,项目编号,供应商编码,供应商名称,供应商简称,主要联系人,客户联系人电话";

	public java.lang.Integer getPurchasePaymentId() {
		return this.__purchase_payment_id;
	}

	public void setPurchasePaymentId( java.lang.Integer value ) {
		this.__purchase_payment_id = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.util.Date getPaymentDate() {
		return this.__payment_date;
	}

	public void setPaymentDate( java.util.Date value ) {
		this.__payment_date = value;
	}

	public java.lang.String getPaymentName() {
		return this.__payment_name;
	}

	public void setPaymentName( java.lang.String value ) {
		this.__payment_name = value;
	}

	public java.lang.String getPaymentCondition() {
		return this.__payment_condition;
	}

	public void setPaymentCondition( java.lang.String value ) {
		this.__payment_condition = value;
	}

	public java.math.BigDecimal getPaymentRatio() {
		return this.__payment_ratio;
	}

	public void setPaymentRatio( java.math.BigDecimal value ) {
		this.__payment_ratio = value;
	}

	public java.math.BigDecimal getPaymentAmount() {
		return this.__payment_amount;
	}

	public void setPaymentAmount( java.math.BigDecimal value ) {
		this.__payment_amount = value;
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

	public java.lang.Integer getPurchaseContractId() {
		return this.__purchase_contract_id;
	}

	public void setPurchaseContractId( java.lang.Integer value ) {
		this.__purchase_contract_id = value;
	}

	public java.lang.Integer getPurchasePaymentStatus() {
		return this.__purchase_payment_status;
	}

	public void setPurchasePaymentStatus( java.lang.Integer value ) {
		this.__purchase_payment_status = value;
	}

	public java.lang.Integer getPersonInCharge() {
		return this.__person_in_charge;
	}

	public void setPersonInCharge( java.lang.Integer value ) {
		this.__person_in_charge = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.util.Date getRealPaymentDate() {
		return this.__real_payment_date;
	}

	public void setRealPaymentDate( java.util.Date value ) {
		this.__real_payment_date = value;
	}

	public java.math.BigDecimal getRealPaymentAmount() {
		return this.__real_payment_amount;
	}

	public void setRealPaymentAmount( java.math.BigDecimal value ) {
		this.__real_payment_amount = value;
	}

	public java.lang.Integer getProcessBusinessId() {
		return this.__process_business_id;
	}

	public void setProcessBusinessId( java.lang.Integer value ) {
		this.__process_business_id = value;
	}

	public java.lang.Integer getDealStatus() {
		return this.__deal_status;
	}

	public void setDealStatus( java.lang.Integer value ) {
		this.__deal_status = value;
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

	public java.math.BigDecimal getContractAmount() {
		return this.__contract_amount;
	}

	public void setContractAmount( java.math.BigDecimal value ) {
		this.__contract_amount = value;
	}

	public java.util.Date getContractDate() {
		return this.__contract_date;
	}

	public void setContractDate( java.util.Date value ) {
		this.__contract_date = value;
	}

	public java.lang.Integer getPurchasePerson() {
		return this.__purchase_person;
	}

	public void setPurchasePerson( java.lang.Integer value ) {
		this.__purchase_person = value;
	}

	public java.lang.String getAfterSaleRequirements() {
		return this.__after_sale_requirements;
	}

	public void setAfterSaleRequirements( java.lang.String value ) {
		this.__after_sale_requirements = value;
	}

	public java.lang.String getQualityAssurance() {
		return this.__quality_assurance;
	}

	public void setQualityAssurance( java.lang.String value ) {
		this.__quality_assurance = value;
	}

	public java.lang.String getTermOfPayment() {
		return this.__term_of_payment;
	}

	public void setTermOfPayment( java.lang.String value ) {
		this.__term_of_payment = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
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

	public void cloneCopy(BaseSpurchasepaymentor __bean){
		__bean.setPurchasePaymentId(getPurchasePaymentId());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setPaymentDate(getPaymentDate());
		__bean.setPaymentName(getPaymentName());
		__bean.setPaymentCondition(getPaymentCondition());
		__bean.setPaymentRatio(getPaymentRatio());
		__bean.setPaymentAmount(getPaymentAmount());
		__bean.setRemark(getRemark());
		__bean.setCreateTime(getCreateTime());
		__bean.setPurchaseContractId(getPurchaseContractId());
		__bean.setPurchasePaymentStatus(getPurchasePaymentStatus());
		__bean.setPersonInCharge(getPersonInCharge());
		__bean.setOperatorId(getOperatorId());
		__bean.setRealPaymentDate(getRealPaymentDate());
		__bean.setRealPaymentAmount(getRealPaymentAmount());
		__bean.setProcessBusinessId(getProcessBusinessId());
		__bean.setDealStatus(getDealStatus());
		__bean.setContractName(getContractName());
		__bean.setContractCode(getContractCode());
		__bean.setContractAmount(getContractAmount());
		__bean.setContractDate(getContractDate());
		__bean.setPurchasePerson(getPurchasePerson());
		__bean.setAfterSaleRequirements(getAfterSaleRequirements());
		__bean.setQualityAssurance(getQualityAssurance());
		__bean.setTermOfPayment(getTermOfPayment());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setProjectName(getProjectName());
		__bean.setProjectCode(getProjectCode());
		__bean.setSupplierId(getSupplierId());
		__bean.setSupplierName(getSupplierName());
		__bean.setAbbreviatedName(getAbbreviatedName());
		__bean.setMajorContactPerson(getMajorContactPerson());
		__bean.setContactPhone(getContactPhone());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPurchasePaymentId() == null ? "" : getPurchasePaymentId());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		sb.append(getPaymentDate() == null ? "" : sdf.format(getPaymentDate()));
		sb.append(",");
		sb.append(getPaymentName() == null ? "" : getPaymentName());
		sb.append(",");
		sb.append(getPaymentCondition() == null ? "" : getPaymentCondition());
		sb.append(",");
		sb.append(getPaymentRatio() == null ? "" : getPaymentRatio());
		sb.append(",");
		sb.append(getPaymentAmount() == null ? "" : getPaymentAmount());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getPurchaseContractId() == null ? "" : getPurchaseContractId());
		sb.append(",");
		sb.append(getPurchasePaymentStatus() == null ? "" : getPurchasePaymentStatus());
		sb.append(",");
		sb.append(getPersonInCharge() == null ? "" : getPersonInCharge());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getRealPaymentDate() == null ? "" : sdf.format(getRealPaymentDate()));
		sb.append(",");
		sb.append(getRealPaymentAmount() == null ? "" : getRealPaymentAmount());
		sb.append(",");
		sb.append(getProcessBusinessId() == null ? "" : getProcessBusinessId());
		sb.append(",");
		sb.append(getDealStatus() == null ? "" : getDealStatus());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractAmount() == null ? "" : getContractAmount());
		sb.append(",");
		sb.append(getContractDate() == null ? "" : sdf.format(getContractDate()));
		sb.append(",");
		sb.append(getPurchasePerson() == null ? "" : getPurchasePerson());
		sb.append(",");
		sb.append(getAfterSaleRequirements() == null ? "" : getAfterSaleRequirements());
		sb.append(",");
		sb.append(getQualityAssurance() == null ? "" : getQualityAssurance());
		sb.append(",");
		sb.append(getTermOfPayment() == null ? "" : getTermOfPayment());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		String strProjectCode = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getProjectCode()));
		sb.append(strProjectCode == null ? "" : strProjectCode);
		sb.append(",");
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getSupplierName() == null ? "" : getSupplierName());
		sb.append(",");
		sb.append(getAbbreviatedName() == null ? "" : getAbbreviatedName());
		sb.append(",");
		sb.append(getMajorContactPerson() == null ? "" : getMajorContactPerson());
		sb.append(",");
		sb.append(getContactPhone() == null ? "" : getContactPhone());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSpurchasepaymentor o) {
		return __purchase_payment_id == null ? -1 : __purchase_payment_id.compareTo(o.getPurchasePaymentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__purchase_payment_id);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__payment_date);
		hash = 97 * hash + Objects.hashCode(this.__payment_name);
		hash = 97 * hash + Objects.hashCode(this.__payment_condition);
		hash = 97 * hash + Objects.hashCode(this.__payment_ratio);
		hash = 97 * hash + Objects.hashCode(this.__payment_amount);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__purchase_contract_id);
		hash = 97 * hash + Objects.hashCode(this.__purchase_payment_status);
		hash = 97 * hash + Objects.hashCode(this.__person_in_charge);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__real_payment_date);
		hash = 97 * hash + Objects.hashCode(this.__real_payment_amount);
		hash = 97 * hash + Objects.hashCode(this.__process_business_id);
		hash = 97 * hash + Objects.hashCode(this.__deal_status);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__contract_date);
		hash = 97 * hash + Objects.hashCode(this.__purchase_person);
		hash = 97 * hash + Objects.hashCode(this.__after_sale_requirements);
		hash = 97 * hash + Objects.hashCode(this.__quality_assurance);
		hash = 97 * hash + Objects.hashCode(this.__term_of_payment);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__supplier_name);
		hash = 97 * hash + Objects.hashCode(this.__abbreviated_name);
		hash = 97 * hash + Objects.hashCode(this.__major_contact_person);
		hash = 97 * hash + Objects.hashCode(this.__contact_phone);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSpurchasepaymentor o = (BaseSpurchasepaymentor)obj;
		if(!Objects.equals(this.__purchase_payment_id, o.getPurchasePaymentId())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__payment_date, o.getPaymentDate())) return false;
		if(!Objects.equals(this.__payment_name, o.getPaymentName())) return false;
		if(!Objects.equals(this.__payment_condition, o.getPaymentCondition())) return false;
		if(!Objects.equals(this.__payment_ratio, o.getPaymentRatio())) return false;
		if(!Objects.equals(this.__payment_amount, o.getPaymentAmount())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__purchase_contract_id, o.getPurchaseContractId())) return false;
		if(!Objects.equals(this.__purchase_payment_status, o.getPurchasePaymentStatus())) return false;
		if(!Objects.equals(this.__person_in_charge, o.getPersonInCharge())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__real_payment_date, o.getRealPaymentDate())) return false;
		if(!Objects.equals(this.__real_payment_amount, o.getRealPaymentAmount())) return false;
		if(!Objects.equals(this.__process_business_id, o.getProcessBusinessId())) return false;
		if(!Objects.equals(this.__deal_status, o.getDealStatus())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_amount, o.getContractAmount())) return false;
		if(!Objects.equals(this.__contract_date, o.getContractDate())) return false;
		if(!Objects.equals(this.__purchase_person, o.getPurchasePerson())) return false;
		if(!Objects.equals(this.__after_sale_requirements, o.getAfterSaleRequirements())) return false;
		if(!Objects.equals(this.__quality_assurance, o.getQualityAssurance())) return false;
		if(!Objects.equals(this.__term_of_payment, o.getTermOfPayment())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__supplier_name, o.getSupplierName())) return false;
		if(!Objects.equals(this.__abbreviated_name, o.getAbbreviatedName())) return false;
		if(!Objects.equals(this.__major_contact_person, o.getMajorContactPerson())) return false;
		if(!Objects.equals(this.__contact_phone, o.getContactPhone())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPurchasePaymentId() != null) sb.append(__wrapNumber(count++, "purchasePaymentId", getPurchasePaymentId()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getPaymentDate() != null) sb.append(__wrapDate(count++, "paymentDate", getPaymentDate()));
		if(getPaymentName() != null) sb.append(__wrapString(count++, "paymentName", getPaymentName()));
		if(getPaymentCondition() != null) sb.append(__wrapString(count++, "paymentCondition", getPaymentCondition()));
		if(getPaymentRatio() != null) sb.append(__wrapDecimal(count++, "paymentRatio", getPaymentRatio()));
		if(getPaymentAmount() != null) sb.append(__wrapDecimal(count++, "paymentAmount", getPaymentAmount()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getPurchaseContractId() != null) sb.append(__wrapNumber(count++, "purchaseContractId", getPurchaseContractId()));
		if(getPurchasePaymentStatus() != null) sb.append(__wrapNumber(count++, "purchasePaymentStatus", getPurchasePaymentStatus()));
		if(getPersonInCharge() != null) sb.append(__wrapNumber(count++, "personInCharge", getPersonInCharge()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getRealPaymentDate() != null) sb.append(__wrapDate(count++, "realPaymentDate", getRealPaymentDate()));
		if(getRealPaymentAmount() != null) sb.append(__wrapDecimal(count++, "realPaymentAmount", getRealPaymentAmount()));
		if(getProcessBusinessId() != null) sb.append(__wrapNumber(count++, "processBusinessId", getProcessBusinessId()));
		if(getDealStatus() != null) sb.append(__wrapNumber(count++, "dealStatus", getDealStatus()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractAmount() != null) sb.append(__wrapDecimal(count++, "contractAmount", getContractAmount()));
		if(getContractDate() != null) sb.append(__wrapDate(count++, "contractDate", getContractDate()));
		if(getPurchasePerson() != null) sb.append(__wrapNumber(count++, "purchasePerson", getPurchasePerson()));
		if(getAfterSaleRequirements() != null) sb.append(__wrapString(count++, "afterSaleRequirements", getAfterSaleRequirements()));
		if(getQualityAssurance() != null) sb.append(__wrapString(count++, "qualityAssurance", getQualityAssurance()));
		if(getTermOfPayment() != null) sb.append(__wrapString(count++, "termOfPayment", getTermOfPayment()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getSupplierName() != null) sb.append(__wrapString(count++, "supplierName", getSupplierName()));
		if(getAbbreviatedName() != null) sb.append(__wrapString(count++, "abbreviatedName", getAbbreviatedName()));
		if(getMajorContactPerson() != null) sb.append(__wrapString(count++, "majorContactPerson", getMajorContactPerson()));
		if(getContactPhone() != null) sb.append(__wrapString(count++, "contactPhone", getContactPhone()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("purchasePaymentId")) != null) setPurchasePaymentId(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("paymentDate")) != null) setPaymentDate(__getDate(val)); 
		if((val = values.get("paymentName")) != null) setPaymentName(__getString(val));
		if((val = values.get("paymentCondition")) != null) setPaymentCondition(__getString(val));
		if((val = values.get("paymentRatio")) != null) setPaymentRatio(__getDecimal(val));  
		if((val = values.get("paymentAmount")) != null) setPaymentAmount(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("purchaseContractId")) != null) setPurchaseContractId(__getInt(val)); 
		if((val = values.get("purchasePaymentStatus")) != null) setPurchasePaymentStatus(__getInt(val)); 
		if((val = values.get("personInCharge")) != null) setPersonInCharge(__getInt(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("realPaymentDate")) != null) setRealPaymentDate(__getDate(val)); 
		if((val = values.get("realPaymentAmount")) != null) setRealPaymentAmount(__getDecimal(val));  
		if((val = values.get("processBusinessId")) != null) setProcessBusinessId(__getInt(val)); 
		if((val = values.get("dealStatus")) != null) setDealStatus(__getInt(val)); 
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractAmount")) != null) setContractAmount(__getDecimal(val));  
		if((val = values.get("contractDate")) != null) setContractDate(__getDate(val)); 
		if((val = values.get("purchasePerson")) != null) setPurchasePerson(__getInt(val)); 
		if((val = values.get("afterSaleRequirements")) != null) setAfterSaleRequirements(__getString(val));
		if((val = values.get("qualityAssurance")) != null) setQualityAssurance(__getString(val));
		if((val = values.get("termOfPayment")) != null) setTermOfPayment(__getString(val));
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("supplierName")) != null) setSupplierName(__getString(val));
		if((val = values.get("abbreviatedName")) != null) setAbbreviatedName(__getString(val));
		if((val = values.get("majorContactPerson")) != null) setMajorContactPerson(__getString(val));
		if((val = values.get("contactPhone")) != null) setContactPhone(__getString(val));
	}

	protected java.lang.Integer  __purchase_payment_id ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.util.Date  __payment_date ;
	protected java.lang.String  __payment_name ;
	protected java.lang.String  __payment_condition ;
	protected java.math.BigDecimal  __payment_ratio ;
	protected java.math.BigDecimal  __payment_amount ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __purchase_contract_id ;
	protected java.lang.Integer  __purchase_payment_status ;
	protected java.lang.Integer  __person_in_charge ;
	protected java.lang.Integer  __operator_id ;
	protected java.util.Date  __real_payment_date ;
	protected java.math.BigDecimal  __real_payment_amount ;
	protected java.lang.Integer  __process_business_id ;
	protected java.lang.Integer  __deal_status ;
	protected java.lang.String  __contract_name ;
	protected java.lang.String  __contract_code ;
	protected java.math.BigDecimal  __contract_amount ;
	protected java.util.Date  __contract_date ;
	protected java.lang.Integer  __purchase_person ;
	protected java.lang.String  __after_sale_requirements ;
	protected java.lang.String  __quality_assurance ;
	protected java.lang.String  __term_of_payment ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __project_code ;
	protected java.lang.Integer  __supplier_id ;
	protected java.lang.String  __supplier_name ;
	protected java.lang.String  __abbreviated_name ;
	protected java.lang.String  __major_contact_person ;
	protected java.lang.String  __contact_phone ;
}
