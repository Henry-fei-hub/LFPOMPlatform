package pomplatform.purchase.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMpurchasecontractppmssmor extends GenericBase implements BaseFactory<BaseMpurchasecontractppmssmor>, Comparable<BaseMpurchasecontractppmssmor> 
{


	public static BaseMpurchasecontractppmssmor newInstance(){
		return new BaseMpurchasecontractppmssmor();
	}

	@Override
	public BaseMpurchasecontractppmssmor make(){
		BaseMpurchasecontractppmssmor b = new BaseMpurchasecontractppmssmor();
		return b;
	}

	public final static java.lang.String CS_PURCHASE_CONTRACT_ID = "purchase_contract_id" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_PURCHASE_PERSON = "purchase_person" ;
	public final static java.lang.String CS_CONTRACT_AMOUNT = "contract_amount" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_QUALITY_ASSURANCE = "quality_assurance" ;
	public final static java.lang.String CS_CONTRACT_DATE = "contract_date" ;
	public final static java.lang.String CS_TERM_OF_PAYMENT = "term_of_payment" ;
	public final static java.lang.String CS_AFTER_SALE_REQUIREMENTS = "after_sale_requirements" ;
	public final static java.lang.String CS_AMOUNT_PAID = "amount_paid" ;
	public final static java.lang.String CS_AMOUNT_UNPAID = "amount_unpaid" ;
	public final static java.lang.String CS_HAVE_INVOICE_AMOUNT = "have_invoice_amount" ;
	public final static java.lang.String CS_LACK_INVOICE_AMOUNT = "lack_invoice_amount" ;
	public final static java.lang.String CS_CONTRACT_ATTACHMENT = "contract_attachment" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_SUPPLIER_NAME = "supplier_name" ;
	public final static java.lang.String CS_ABBREVIATED_NAME = "abbreviated_name" ;
	public final static java.lang.String CS_MAJOR_CONTACT_PERSON = "major_contact_person" ;
	public final static java.lang.String CS_CONTACT_PHONE = "contact_phone" ;
	public final static java.lang.String CS_FILE_URL = "file_url" ;
	public final static java.lang.String CS_FILE_NAME = "file_name" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,合同名称,合同编号,供应商编码,订购人,合同金额,项目,质保,合同签订日期,付款条件,售后要求,已付金额,未付金额,已开票金额,未开票金额,合同附近-扫描件(关联file_manage),流程业务表主键,创建时间,项目名称,项目编号,供应商名称,供应商简称,主要联系人,客户联系人电话,文件路径,文件名";

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

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.lang.Integer getPurchasePerson() {
		return this.__purchase_person;
	}

	public void setPurchasePerson( java.lang.Integer value ) {
		this.__purchase_person = value;
	}

	public java.math.BigDecimal getContractAmount() {
		return this.__contract_amount;
	}

	public void setContractAmount( java.math.BigDecimal value ) {
		this.__contract_amount = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.String getQualityAssurance() {
		return this.__quality_assurance;
	}

	public void setQualityAssurance( java.lang.String value ) {
		this.__quality_assurance = value;
	}

	public java.util.Date getContractDate() {
		return this.__contract_date;
	}

	public void setContractDate( java.util.Date value ) {
		this.__contract_date = value;
	}

	public java.lang.String getTermOfPayment() {
		return this.__term_of_payment;
	}

	public void setTermOfPayment( java.lang.String value ) {
		this.__term_of_payment = value;
	}

	public java.lang.String getAfterSaleRequirements() {
		return this.__after_sale_requirements;
	}

	public void setAfterSaleRequirements( java.lang.String value ) {
		this.__after_sale_requirements = value;
	}

	public java.math.BigDecimal getAmountPaid() {
		return this.__amount_paid;
	}

	public void setAmountPaid( java.math.BigDecimal value ) {
		this.__amount_paid = value;
	}

	public java.math.BigDecimal getAmountUnpaid() {
		return this.__amount_unpaid;
	}

	public void setAmountUnpaid( java.math.BigDecimal value ) {
		this.__amount_unpaid = value;
	}

	public java.math.BigDecimal getHaveInvoiceAmount() {
		return this.__have_invoice_amount;
	}

	public void setHaveInvoiceAmount( java.math.BigDecimal value ) {
		this.__have_invoice_amount = value;
	}

	public java.math.BigDecimal getLackInvoiceAmount() {
		return this.__lack_invoice_amount;
	}

	public void setLackInvoiceAmount( java.math.BigDecimal value ) {
		this.__lack_invoice_amount = value;
	}

	public java.lang.Integer getContractAttachment() {
		return this.__contract_attachment;
	}

	public void setContractAttachment( java.lang.Integer value ) {
		this.__contract_attachment = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
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

	public java.lang.String getFileUrl() {
		return this.__file_url;
	}

	public void setFileUrl( java.lang.String value ) {
		this.__file_url = value;
	}

	public java.lang.String getFileName() {
		return this.__file_name;
	}

	public void setFileName( java.lang.String value ) {
		this.__file_name = value;
	}

	public void cloneCopy(BaseMpurchasecontractppmssmor __bean){
		__bean.setPurchaseContractId(getPurchaseContractId());
		__bean.setContractName(getContractName());
		__bean.setContractCode(getContractCode());
		__bean.setSupplierId(getSupplierId());
		__bean.setPurchasePerson(getPurchasePerson());
		__bean.setContractAmount(getContractAmount());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setQualityAssurance(getQualityAssurance());
		__bean.setContractDate(getContractDate());
		__bean.setTermOfPayment(getTermOfPayment());
		__bean.setAfterSaleRequirements(getAfterSaleRequirements());
		__bean.setAmountPaid(getAmountPaid());
		__bean.setAmountUnpaid(getAmountUnpaid());
		__bean.setHaveInvoiceAmount(getHaveInvoiceAmount());
		__bean.setLackInvoiceAmount(getLackInvoiceAmount());
		__bean.setContractAttachment(getContractAttachment());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setCreateTime(getCreateTime());
		__bean.setProjectName(getProjectName());
		__bean.setProjectCode(getProjectCode());
		__bean.setSupplierName(getSupplierName());
		__bean.setAbbreviatedName(getAbbreviatedName());
		__bean.setMajorContactPerson(getMajorContactPerson());
		__bean.setContactPhone(getContactPhone());
		__bean.setFileUrl(getFileUrl());
		__bean.setFileName(getFileName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPurchaseContractId() == null ? "" : getPurchaseContractId());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getPurchasePerson() == null ? "" : getPurchasePerson());
		sb.append(",");
		sb.append(getContractAmount() == null ? "" : getContractAmount());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getQualityAssurance() == null ? "" : getQualityAssurance());
		sb.append(",");
		sb.append(getContractDate() == null ? "" : sdf.format(getContractDate()));
		sb.append(",");
		sb.append(getTermOfPayment() == null ? "" : getTermOfPayment());
		sb.append(",");
		sb.append(getAfterSaleRequirements() == null ? "" : getAfterSaleRequirements());
		sb.append(",");
		sb.append(getAmountPaid() == null ? "" : getAmountPaid());
		sb.append(",");
		sb.append(getAmountUnpaid() == null ? "" : getAmountUnpaid());
		sb.append(",");
		sb.append(getHaveInvoiceAmount() == null ? "" : getHaveInvoiceAmount());
		sb.append(",");
		sb.append(getLackInvoiceAmount() == null ? "" : getLackInvoiceAmount());
		sb.append(",");
		sb.append(getContractAttachment() == null ? "" : getContractAttachment());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		String strProjectCode = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getProjectCode()));
		sb.append(strProjectCode == null ? "" : strProjectCode);
		sb.append(",");
		sb.append(getSupplierName() == null ? "" : getSupplierName());
		sb.append(",");
		sb.append(getAbbreviatedName() == null ? "" : getAbbreviatedName());
		sb.append(",");
		sb.append(getMajorContactPerson() == null ? "" : getMajorContactPerson());
		sb.append(",");
		sb.append(getContactPhone() == null ? "" : getContactPhone());
		sb.append(",");
		sb.append(getFileUrl() == null ? "" : getFileUrl());
		sb.append(",");
		sb.append(getFileName() == null ? "" : getFileName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMpurchasecontractppmssmor o) {
		return __purchase_contract_id == null ? -1 : __purchase_contract_id.compareTo(o.getPurchaseContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__purchase_contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__purchase_person);
		hash = 97 * hash + Objects.hashCode(this.__contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__quality_assurance);
		hash = 97 * hash + Objects.hashCode(this.__contract_date);
		hash = 97 * hash + Objects.hashCode(this.__term_of_payment);
		hash = 97 * hash + Objects.hashCode(this.__after_sale_requirements);
		hash = 97 * hash + Objects.hashCode(this.__amount_paid);
		hash = 97 * hash + Objects.hashCode(this.__amount_unpaid);
		hash = 97 * hash + Objects.hashCode(this.__have_invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__lack_invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__contract_attachment);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__supplier_name);
		hash = 97 * hash + Objects.hashCode(this.__abbreviated_name);
		hash = 97 * hash + Objects.hashCode(this.__major_contact_person);
		hash = 97 * hash + Objects.hashCode(this.__contact_phone);
		hash = 97 * hash + Objects.hashCode(this.__file_url);
		hash = 97 * hash + Objects.hashCode(this.__file_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMpurchasecontractppmssmor o = (BaseMpurchasecontractppmssmor)obj;
		if(!Objects.equals(this.__purchase_contract_id, o.getPurchaseContractId())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__purchase_person, o.getPurchasePerson())) return false;
		if(!Objects.equals(this.__contract_amount, o.getContractAmount())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__quality_assurance, o.getQualityAssurance())) return false;
		if(!Objects.equals(this.__contract_date, o.getContractDate())) return false;
		if(!Objects.equals(this.__term_of_payment, o.getTermOfPayment())) return false;
		if(!Objects.equals(this.__after_sale_requirements, o.getAfterSaleRequirements())) return false;
		if(!Objects.equals(this.__amount_paid, o.getAmountPaid())) return false;
		if(!Objects.equals(this.__amount_unpaid, o.getAmountUnpaid())) return false;
		if(!Objects.equals(this.__have_invoice_amount, o.getHaveInvoiceAmount())) return false;
		if(!Objects.equals(this.__lack_invoice_amount, o.getLackInvoiceAmount())) return false;
		if(!Objects.equals(this.__contract_attachment, o.getContractAttachment())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__supplier_name, o.getSupplierName())) return false;
		if(!Objects.equals(this.__abbreviated_name, o.getAbbreviatedName())) return false;
		if(!Objects.equals(this.__major_contact_person, o.getMajorContactPerson())) return false;
		if(!Objects.equals(this.__contact_phone, o.getContactPhone())) return false;
		if(!Objects.equals(this.__file_url, o.getFileUrl())) return false;
		if(!Objects.equals(this.__file_name, o.getFileName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPurchaseContractId() != null) sb.append(__wrapNumber(count++, "purchaseContractId", getPurchaseContractId()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getPurchasePerson() != null) sb.append(__wrapNumber(count++, "purchasePerson", getPurchasePerson()));
		if(getContractAmount() != null) sb.append(__wrapDecimal(count++, "contractAmount", getContractAmount()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getQualityAssurance() != null) sb.append(__wrapString(count++, "qualityAssurance", getQualityAssurance()));
		if(getContractDate() != null) sb.append(__wrapDate(count++, "contractDate", getContractDate()));
		if(getTermOfPayment() != null) sb.append(__wrapString(count++, "termOfPayment", getTermOfPayment()));
		if(getAfterSaleRequirements() != null) sb.append(__wrapString(count++, "afterSaleRequirements", getAfterSaleRequirements()));
		if(getAmountPaid() != null) sb.append(__wrapDecimal(count++, "amountPaid", getAmountPaid()));
		if(getAmountUnpaid() != null) sb.append(__wrapDecimal(count++, "amountUnpaid", getAmountUnpaid()));
		if(getHaveInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "haveInvoiceAmount", getHaveInvoiceAmount()));
		if(getLackInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "lackInvoiceAmount", getLackInvoiceAmount()));
		if(getContractAttachment() != null) sb.append(__wrapNumber(count++, "contractAttachment", getContractAttachment()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getSupplierName() != null) sb.append(__wrapString(count++, "supplierName", getSupplierName()));
		if(getAbbreviatedName() != null) sb.append(__wrapString(count++, "abbreviatedName", getAbbreviatedName()));
		if(getMajorContactPerson() != null) sb.append(__wrapString(count++, "majorContactPerson", getMajorContactPerson()));
		if(getContactPhone() != null) sb.append(__wrapString(count++, "contactPhone", getContactPhone()));
		if(getFileUrl() != null) sb.append(__wrapString(count++, "fileUrl", getFileUrl()));
		if(getFileName() != null) sb.append(__wrapString(count++, "fileName", getFileName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("purchaseContractId")) != null) setPurchaseContractId(__getInt(val)); 
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("purchasePerson")) != null) setPurchasePerson(__getInt(val)); 
		if((val = values.get("contractAmount")) != null) setContractAmount(__getDecimal(val));  
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("qualityAssurance")) != null) setQualityAssurance(__getString(val));
		if((val = values.get("contractDate")) != null) setContractDate(__getDate(val)); 
		if((val = values.get("termOfPayment")) != null) setTermOfPayment(__getString(val));
		if((val = values.get("afterSaleRequirements")) != null) setAfterSaleRequirements(__getString(val));
		if((val = values.get("amountPaid")) != null) setAmountPaid(__getDecimal(val));  
		if((val = values.get("amountUnpaid")) != null) setAmountUnpaid(__getDecimal(val));  
		if((val = values.get("haveInvoiceAmount")) != null) setHaveInvoiceAmount(__getDecimal(val));  
		if((val = values.get("lackInvoiceAmount")) != null) setLackInvoiceAmount(__getDecimal(val));  
		if((val = values.get("contractAttachment")) != null) setContractAttachment(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("supplierName")) != null) setSupplierName(__getString(val));
		if((val = values.get("abbreviatedName")) != null) setAbbreviatedName(__getString(val));
		if((val = values.get("majorContactPerson")) != null) setMajorContactPerson(__getString(val));
		if((val = values.get("contactPhone")) != null) setContactPhone(__getString(val));
		if((val = values.get("fileUrl")) != null) setFileUrl(__getString(val));
		if((val = values.get("fileName")) != null) setFileName(__getString(val));
	}

	protected java.lang.Integer  __purchase_contract_id ;
	protected java.lang.String  __contract_name ;
	protected java.lang.String  __contract_code ;
	protected java.lang.Integer  __supplier_id ;
	protected java.lang.Integer  __purchase_person ;
	protected java.math.BigDecimal  __contract_amount ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.String  __quality_assurance ;
	protected java.util.Date  __contract_date ;
	protected java.lang.String  __term_of_payment ;
	protected java.lang.String  __after_sale_requirements ;
	protected java.math.BigDecimal  __amount_paid ;
	protected java.math.BigDecimal  __amount_unpaid ;
	protected java.math.BigDecimal  __have_invoice_amount ;
	protected java.math.BigDecimal  __lack_invoice_amount ;
	protected java.lang.Integer  __contract_attachment ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __supplier_name ;
	protected java.lang.String  __abbreviated_name ;
	protected java.lang.String  __major_contact_person ;
	protected java.lang.String  __contact_phone ;
	protected java.lang.String  __file_url ;
	protected java.lang.String  __file_name ;
}
