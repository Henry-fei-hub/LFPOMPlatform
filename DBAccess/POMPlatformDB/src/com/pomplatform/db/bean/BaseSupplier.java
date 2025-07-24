package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSupplier extends GenericBase implements BaseFactory<BaseSupplier>, Comparable<BaseSupplier> 
{


	public static BaseSupplier newInstance(){
		return new BaseSupplier();
	}

	@Override
	public BaseSupplier make(){
		BaseSupplier b = new BaseSupplier();
		return b;
	}

	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_SUPPLIER_NAME = "supplier_name" ;
	public final static java.lang.String CS_SUPPLIER_CONTACT = "supplier_contact" ;
	public final static java.lang.String CS_SUPPLIER_PHONE = "supplier_phone" ;
	public final static java.lang.String CS_SUPPLIER_EMAIL = "supplier_email" ;
	public final static java.lang.String CS_SUPPLIER_TYPE = "supplier_type" ;
	public final static java.lang.String CS_SUPPLIER_MAIN_BUSINESS_TYPE = "supplier_main_business_type" ;
	public final static java.lang.String CS_SUPPLIER_SCOPE_SUPPLY = "supplier_scope_supply" ;
	public final static java.lang.String CS_SOCIAL_CREDIT_CODE = "social_credit_code" ;
	public final static java.lang.String CS_SUPPLIER__PROVINCE = "supplier__province" ;
	public final static java.lang.String CS_SUPPLIER__CITY = "supplier__city" ;
	public final static java.lang.String CS_SUPPLIER_BANK_ADDRESS = "supplier_bank_address" ;
	public final static java.lang.String CS_SUPPLIER_ADDRESS = "supplier_address" ;
	public final static java.lang.String CS_PRODUCTION_CYCLE = "production_cycle" ;
	public final static java.lang.String CS_LOGISTICS_CYCLE = "logistics_cycle" ;
	public final static java.lang.String CS_SUPPLIER_BOSS = "supplier_boss" ;
	public final static java.lang.String CS_CONTRACT_SIGNING_TIME = "contract_signing_time" ;
	public final static java.lang.String CS_CONTRACT_SCOPE_TIME = "contract_scope_time" ;
	public final static java.lang.String CS_CONTRACT_SCOPE_TIME_START = "contract_scope_time_start" ;
	public final static java.lang.String CS_CONTRACT_SCOPE_TIME_END = "contract_scope_time_end" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_SUPPLIER_ORIGIN = "supplier_origin" ;
	public final static java.lang.String CS_SUPPLIER_STATUS = "supplier_status" ;
	public final static java.lang.String CS_IS_USE = "is_use" ;
	public final static java.lang.String CS_RECEIVE_UNIT_MANAGE_ID = "receive_unit_manage_id" ;
	public final static java.lang.String CS_AGREEMENT_TYPE = "agreement_type" ;
	public final static java.lang.String CS_AGREEMENT_SIGN_TIME = "agreement_sign_time" ;
	public final static java.lang.String CS_AGREEMENT_SIGN_ADDRESS = "agreement_sign_address" ;
	public final static java.lang.String CS_FILE_ID = "file_id" ;
	public final static java.lang.String CS_TEAM_SIZE = "team_size" ;
	public final static java.lang.String CS_AREAS_EXPERTISE = "areas_expertise" ;
	public final static java.lang.String CS_ATTACHMENT_NAME = "attachment_name" ;
	public final static java.lang.String CS_ATTACHMENT = "attachment" ;
	public final static java.lang.String CS_CREATE_EMPLOYEE_ID = "create_employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "供应商编码,供应商名称,供应商联系人,供应商电话,供应商邮箱,供应商类型,供应商主营业务类型,供货范围,社会信用代码,供应商所在(省),供应商所在(市),供应商开户行详细地址,供应商税务登记地址,生产周期,物流周期,供应商法定代表人,合同签订日期,合同周期,合同周期开始时间,合同周期结束时间,操作人,操作时间,供应商来源,供应商状态,供应商是否有效(0无效，1有效),收款单位主键编码,协议类别,协议签订时间,协议签订地点,附件编码,团队规模,擅长领域,附件名称,附件路径,创建人,创建时间";

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

	public java.lang.String getSupplierContact() {
		return this.__supplier_contact;
	}

	public void setSupplierContact( java.lang.String value ) {
		this.__supplier_contact = value;
	}

	public java.lang.String getSupplierPhone() {
		return this.__supplier_phone;
	}

	public void setSupplierPhone( java.lang.String value ) {
		this.__supplier_phone = value;
	}

	public java.lang.String getSupplierEmail() {
		return this.__supplier_email;
	}

	public void setSupplierEmail( java.lang.String value ) {
		this.__supplier_email = value;
	}

	public java.lang.Integer getSupplierType() {
		return this.__supplier_type;
	}

	public void setSupplierType( java.lang.Integer value ) {
		this.__supplier_type = value;
	}

	public java.lang.Integer getSupplierMainBusinessType() {
		return this.__supplier_main_business_type;
	}

	public void setSupplierMainBusinessType( java.lang.Integer value ) {
		this.__supplier_main_business_type = value;
	}

	public java.lang.String getSupplierScopeSupply() {
		return this.__supplier_scope_supply;
	}

	public void setSupplierScopeSupply( java.lang.String value ) {
		this.__supplier_scope_supply = value;
	}

	public java.lang.String getSocialCreditCode() {
		return this.__social_credit_code;
	}

	public void setSocialCreditCode( java.lang.String value ) {
		this.__social_credit_code = value;
	}

	public java.lang.Integer getSupplier_province() {
		return this.__supplier__province;
	}

	public void setSupplier_province( java.lang.Integer value ) {
		this.__supplier__province = value;
	}

	public java.lang.Integer getSupplier_city() {
		return this.__supplier__city;
	}

	public void setSupplier_city( java.lang.Integer value ) {
		this.__supplier__city = value;
	}

	public java.lang.String getSupplierBankAddress() {
		return this.__supplier_bank_address;
	}

	public void setSupplierBankAddress( java.lang.String value ) {
		this.__supplier_bank_address = value;
	}

	public java.lang.String getSupplierAddress() {
		return this.__supplier_address;
	}

	public void setSupplierAddress( java.lang.String value ) {
		this.__supplier_address = value;
	}

	public java.lang.Integer getProductionCycle() {
		return this.__production_cycle;
	}

	public void setProductionCycle( java.lang.Integer value ) {
		this.__production_cycle = value;
	}

	public java.lang.Integer getLogisticsCycle() {
		return this.__logistics_cycle;
	}

	public void setLogisticsCycle( java.lang.Integer value ) {
		this.__logistics_cycle = value;
	}

	public java.lang.String getSupplierBoss() {
		return this.__supplier_boss;
	}

	public void setSupplierBoss( java.lang.String value ) {
		this.__supplier_boss = value;
	}

	public java.util.Date getContractSigningTime() {
		return this.__contract_signing_time;
	}

	public void setContractSigningTime( java.util.Date value ) {
		this.__contract_signing_time = value;
	}

	public java.lang.String getContractScopeTime() {
		return this.__contract_scope_time;
	}

	public void setContractScopeTime( java.lang.String value ) {
		this.__contract_scope_time = value;
	}

	public java.util.Date getContractScopeTimeStart() {
		return this.__contract_scope_time_start;
	}

	public void setContractScopeTimeStart( java.util.Date value ) {
		this.__contract_scope_time_start = value;
	}

	public java.util.Date getContractScopeTimeEnd() {
		return this.__contract_scope_time_end;
	}

	public void setContractScopeTimeEnd( java.util.Date value ) {
		this.__contract_scope_time_end = value;
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

	public java.lang.String getSupplierOrigin() {
		return this.__supplier_origin;
	}

	public void setSupplierOrigin( java.lang.String value ) {
		this.__supplier_origin = value;
	}

	public java.lang.Integer getSupplierStatus() {
		return this.__supplier_status;
	}

	public void setSupplierStatus( java.lang.Integer value ) {
		this.__supplier_status = value;
	}

	public java.lang.Integer getIsUse() {
		return this.__is_use;
	}

	public void setIsUse( java.lang.Integer value ) {
		this.__is_use = value;
	}

	public java.lang.Integer getReceiveUnitManageId() {
		return this.__receive_unit_manage_id;
	}

	public void setReceiveUnitManageId( java.lang.Integer value ) {
		this.__receive_unit_manage_id = value;
	}

	public java.lang.Integer getAgreementType() {
		return this.__agreement_type;
	}

	public void setAgreementType( java.lang.Integer value ) {
		this.__agreement_type = value;
	}

	public java.util.Date getAgreementSignTime() {
		return this.__agreement_sign_time;
	}

	public void setAgreementSignTime( java.util.Date value ) {
		this.__agreement_sign_time = value;
	}

	public java.lang.String getAgreementSignAddress() {
		return this.__agreement_sign_address;
	}

	public void setAgreementSignAddress( java.lang.String value ) {
		this.__agreement_sign_address = value;
	}

	public java.lang.Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( java.lang.Integer value ) {
		this.__file_id = value;
	}

	public java.lang.Integer getTeamSize() {
		return this.__team_size;
	}

	public void setTeamSize( java.lang.Integer value ) {
		this.__team_size = value;
	}

	public java.lang.Integer getAreasExpertise() {
		return this.__areas_expertise;
	}

	public void setAreasExpertise( java.lang.Integer value ) {
		this.__areas_expertise = value;
	}

	public java.lang.String getAttachmentName() {
		return this.__attachment_name;
	}

	public void setAttachmentName( java.lang.String value ) {
		this.__attachment_name = value;
	}

	public java.lang.String getAttachment() {
		return this.__attachment;
	}

	public void setAttachment( java.lang.String value ) {
		this.__attachment = value;
	}

	public java.lang.Integer getCreateEmployeeId() {
		return this.__create_employee_id;
	}

	public void setCreateEmployeeId( java.lang.Integer value ) {
		this.__create_employee_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseSupplier __bean){
		__bean.setSupplierId(getSupplierId());
		__bean.setSupplierName(getSupplierName());
		__bean.setSupplierContact(getSupplierContact());
		__bean.setSupplierPhone(getSupplierPhone());
		__bean.setSupplierEmail(getSupplierEmail());
		__bean.setSupplierType(getSupplierType());
		__bean.setSupplierMainBusinessType(getSupplierMainBusinessType());
		__bean.setSupplierScopeSupply(getSupplierScopeSupply());
		__bean.setSocialCreditCode(getSocialCreditCode());
		__bean.setSupplier_province(getSupplier_province());
		__bean.setSupplier_city(getSupplier_city());
		__bean.setSupplierBankAddress(getSupplierBankAddress());
		__bean.setSupplierAddress(getSupplierAddress());
		__bean.setProductionCycle(getProductionCycle());
		__bean.setLogisticsCycle(getLogisticsCycle());
		__bean.setSupplierBoss(getSupplierBoss());
		__bean.setContractSigningTime(getContractSigningTime());
		__bean.setContractScopeTime(getContractScopeTime());
		__bean.setContractScopeTimeStart(getContractScopeTimeStart());
		__bean.setContractScopeTimeEnd(getContractScopeTimeEnd());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setSupplierOrigin(getSupplierOrigin());
		__bean.setSupplierStatus(getSupplierStatus());
		__bean.setIsUse(getIsUse());
		__bean.setReceiveUnitManageId(getReceiveUnitManageId());
		__bean.setAgreementType(getAgreementType());
		__bean.setAgreementSignTime(getAgreementSignTime());
		__bean.setAgreementSignAddress(getAgreementSignAddress());
		__bean.setFileId(getFileId());
		__bean.setTeamSize(getTeamSize());
		__bean.setAreasExpertise(getAreasExpertise());
		__bean.setAttachmentName(getAttachmentName());
		__bean.setAttachment(getAttachment());
		__bean.setCreateEmployeeId(getCreateEmployeeId());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getSupplierName() == null ? "" : getSupplierName());
		sb.append(",");
		sb.append(getSupplierContact() == null ? "" : getSupplierContact());
		sb.append(",");
		sb.append(getSupplierPhone() == null ? "" : getSupplierPhone());
		sb.append(",");
		sb.append(getSupplierEmail() == null ? "" : getSupplierEmail());
		sb.append(",");
		String strSupplierType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_187", String.valueOf(getSupplierType()));
		sb.append(strSupplierType == null ? "" : strSupplierType);
		sb.append(",");
		sb.append(getSupplierMainBusinessType() == null ? "" : getSupplierMainBusinessType());
		sb.append(",");
		sb.append(getSupplierScopeSupply() == null ? "" : getSupplierScopeSupply());
		sb.append(",");
		sb.append(getSocialCreditCode() == null ? "" : getSocialCreditCode());
		sb.append(",");
		sb.append(getSupplier_province() == null ? "" : getSupplier_province());
		sb.append(",");
		sb.append(getSupplier_city() == null ? "" : getSupplier_city());
		sb.append(",");
		sb.append(getSupplierBankAddress() == null ? "" : getSupplierBankAddress());
		sb.append(",");
		sb.append(getSupplierAddress() == null ? "" : getSupplierAddress());
		sb.append(",");
		sb.append(getProductionCycle() == null ? "" : getProductionCycle());
		sb.append(",");
		sb.append(getLogisticsCycle() == null ? "" : getLogisticsCycle());
		sb.append(",");
		sb.append(getSupplierBoss() == null ? "" : getSupplierBoss());
		sb.append(",");
		sb.append(getContractSigningTime() == null ? "" : sdf.format(getContractSigningTime()));
		sb.append(",");
		sb.append(getContractScopeTime() == null ? "" : getContractScopeTime());
		sb.append(",");
		sb.append(getContractScopeTimeStart() == null ? "" : sdf.format(getContractScopeTimeStart()));
		sb.append(",");
		sb.append(getContractScopeTimeEnd() == null ? "" : sdf.format(getContractScopeTimeEnd()));
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getSupplierOrigin() == null ? "" : getSupplierOrigin());
		sb.append(",");
		sb.append(getSupplierStatus() == null ? "" : getSupplierStatus());
		sb.append(",");
		sb.append(getIsUse() == null ? "" : getIsUse());
		sb.append(",");
		sb.append(getReceiveUnitManageId() == null ? "" : getReceiveUnitManageId());
		sb.append(",");
		sb.append(getAgreementType() == null ? "" : getAgreementType());
		sb.append(",");
		sb.append(getAgreementSignTime() == null ? "" : sdf.format(getAgreementSignTime()));
		sb.append(",");
		sb.append(getAgreementSignAddress() == null ? "" : getAgreementSignAddress());
		sb.append(",");
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getTeamSize() == null ? "" : getTeamSize());
		sb.append(",");
		sb.append(getAreasExpertise() == null ? "" : getAreasExpertise());
		sb.append(",");
		sb.append(getAttachmentName() == null ? "" : getAttachmentName());
		sb.append(",");
		sb.append(getAttachment() == null ? "" : getAttachment());
		sb.append(",");
		sb.append(getCreateEmployeeId() == null ? "" : getCreateEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSupplier o) {
		return __supplier_id == null ? -1 : __supplier_id.compareTo(o.getSupplierId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__supplier_name);
		hash = 97 * hash + Objects.hashCode(this.__supplier_contact);
		hash = 97 * hash + Objects.hashCode(this.__supplier_phone);
		hash = 97 * hash + Objects.hashCode(this.__supplier_email);
		hash = 97 * hash + Objects.hashCode(this.__supplier_type);
		hash = 97 * hash + Objects.hashCode(this.__supplier_main_business_type);
		hash = 97 * hash + Objects.hashCode(this.__supplier_scope_supply);
		hash = 97 * hash + Objects.hashCode(this.__social_credit_code);
		hash = 97 * hash + Objects.hashCode(this.__supplier__province);
		hash = 97 * hash + Objects.hashCode(this.__supplier__city);
		hash = 97 * hash + Objects.hashCode(this.__supplier_bank_address);
		hash = 97 * hash + Objects.hashCode(this.__supplier_address);
		hash = 97 * hash + Objects.hashCode(this.__production_cycle);
		hash = 97 * hash + Objects.hashCode(this.__logistics_cycle);
		hash = 97 * hash + Objects.hashCode(this.__supplier_boss);
		hash = 97 * hash + Objects.hashCode(this.__contract_signing_time);
		hash = 97 * hash + Objects.hashCode(this.__contract_scope_time);
		hash = 97 * hash + Objects.hashCode(this.__contract_scope_time_start);
		hash = 97 * hash + Objects.hashCode(this.__contract_scope_time_end);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__supplier_origin);
		hash = 97 * hash + Objects.hashCode(this.__supplier_status);
		hash = 97 * hash + Objects.hashCode(this.__is_use);
		hash = 97 * hash + Objects.hashCode(this.__receive_unit_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__agreement_type);
		hash = 97 * hash + Objects.hashCode(this.__agreement_sign_time);
		hash = 97 * hash + Objects.hashCode(this.__agreement_sign_address);
		hash = 97 * hash + Objects.hashCode(this.__file_id);
		hash = 97 * hash + Objects.hashCode(this.__team_size);
		hash = 97 * hash + Objects.hashCode(this.__areas_expertise);
		hash = 97 * hash + Objects.hashCode(this.__attachment_name);
		hash = 97 * hash + Objects.hashCode(this.__attachment);
		hash = 97 * hash + Objects.hashCode(this.__create_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSupplier o = (BaseSupplier)obj;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__supplier_name, o.getSupplierName())) return false;
		if(!Objects.equals(this.__supplier_contact, o.getSupplierContact())) return false;
		if(!Objects.equals(this.__supplier_phone, o.getSupplierPhone())) return false;
		if(!Objects.equals(this.__supplier_email, o.getSupplierEmail())) return false;
		if(!Objects.equals(this.__supplier_type, o.getSupplierType())) return false;
		if(!Objects.equals(this.__supplier_main_business_type, o.getSupplierMainBusinessType())) return false;
		if(!Objects.equals(this.__supplier_scope_supply, o.getSupplierScopeSupply())) return false;
		if(!Objects.equals(this.__social_credit_code, o.getSocialCreditCode())) return false;
		if(!Objects.equals(this.__supplier__province, o.getSupplier_province())) return false;
		if(!Objects.equals(this.__supplier__city, o.getSupplier_city())) return false;
		if(!Objects.equals(this.__supplier_bank_address, o.getSupplierBankAddress())) return false;
		if(!Objects.equals(this.__supplier_address, o.getSupplierAddress())) return false;
		if(!Objects.equals(this.__production_cycle, o.getProductionCycle())) return false;
		if(!Objects.equals(this.__logistics_cycle, o.getLogisticsCycle())) return false;
		if(!Objects.equals(this.__supplier_boss, o.getSupplierBoss())) return false;
		if(!Objects.equals(this.__contract_signing_time, o.getContractSigningTime())) return false;
		if(!Objects.equals(this.__contract_scope_time, o.getContractScopeTime())) return false;
		if(!Objects.equals(this.__contract_scope_time_start, o.getContractScopeTimeStart())) return false;
		if(!Objects.equals(this.__contract_scope_time_end, o.getContractScopeTimeEnd())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__supplier_origin, o.getSupplierOrigin())) return false;
		if(!Objects.equals(this.__supplier_status, o.getSupplierStatus())) return false;
		if(!Objects.equals(this.__is_use, o.getIsUse())) return false;
		if(!Objects.equals(this.__receive_unit_manage_id, o.getReceiveUnitManageId())) return false;
		if(!Objects.equals(this.__agreement_type, o.getAgreementType())) return false;
		if(!Objects.equals(this.__agreement_sign_time, o.getAgreementSignTime())) return false;
		if(!Objects.equals(this.__agreement_sign_address, o.getAgreementSignAddress())) return false;
		if(!Objects.equals(this.__file_id, o.getFileId())) return false;
		if(!Objects.equals(this.__team_size, o.getTeamSize())) return false;
		if(!Objects.equals(this.__areas_expertise, o.getAreasExpertise())) return false;
		if(!Objects.equals(this.__attachment_name, o.getAttachmentName())) return false;
		if(!Objects.equals(this.__attachment, o.getAttachment())) return false;
		if(!Objects.equals(this.__create_employee_id, o.getCreateEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getSupplierName() != null) sb.append(__wrapString(count++, "supplierName", getSupplierName()));
		if(getSupplierContact() != null) sb.append(__wrapString(count++, "supplierContact", getSupplierContact()));
		if(getSupplierPhone() != null) sb.append(__wrapString(count++, "supplierPhone", getSupplierPhone()));
		if(getSupplierEmail() != null) sb.append(__wrapString(count++, "supplierEmail", getSupplierEmail()));
		if(getSupplierType() != null) sb.append(__wrapNumber(count++, "supplierType", getSupplierType()));
		if(getSupplierMainBusinessType() != null) sb.append(__wrapNumber(count++, "supplierMainBusinessType", getSupplierMainBusinessType()));
		if(getSupplierScopeSupply() != null) sb.append(__wrapString(count++, "supplierScopeSupply", getSupplierScopeSupply()));
		if(getSocialCreditCode() != null) sb.append(__wrapString(count++, "socialCreditCode", getSocialCreditCode()));
		if(getSupplier_province() != null) sb.append(__wrapNumber(count++, "supplier_province", getSupplier_province()));
		if(getSupplier_city() != null) sb.append(__wrapNumber(count++, "supplier_city", getSupplier_city()));
		if(getSupplierBankAddress() != null) sb.append(__wrapString(count++, "supplierBankAddress", getSupplierBankAddress()));
		if(getSupplierAddress() != null) sb.append(__wrapString(count++, "supplierAddress", getSupplierAddress()));
		if(getProductionCycle() != null) sb.append(__wrapNumber(count++, "productionCycle", getProductionCycle()));
		if(getLogisticsCycle() != null) sb.append(__wrapNumber(count++, "logisticsCycle", getLogisticsCycle()));
		if(getSupplierBoss() != null) sb.append(__wrapString(count++, "supplierBoss", getSupplierBoss()));
		if(getContractSigningTime() != null) sb.append(__wrapDate(count++, "contractSigningTime", getContractSigningTime()));
		if(getContractScopeTime() != null) sb.append(__wrapString(count++, "contractScopeTime", getContractScopeTime()));
		if(getContractScopeTimeStart() != null) sb.append(__wrapDate(count++, "contractScopeTimeStart", getContractScopeTimeStart()));
		if(getContractScopeTimeEnd() != null) sb.append(__wrapDate(count++, "contractScopeTimeEnd", getContractScopeTimeEnd()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getSupplierOrigin() != null) sb.append(__wrapString(count++, "supplierOrigin", getSupplierOrigin()));
		if(getSupplierStatus() != null) sb.append(__wrapNumber(count++, "supplierStatus", getSupplierStatus()));
		if(getIsUse() != null) sb.append(__wrapNumber(count++, "isUse", getIsUse()));
		if(getReceiveUnitManageId() != null) sb.append(__wrapNumber(count++, "receiveUnitManageId", getReceiveUnitManageId()));
		if(getAgreementType() != null) sb.append(__wrapNumber(count++, "agreementType", getAgreementType()));
		if(getAgreementSignTime() != null) sb.append(__wrapDate(count++, "agreementSignTime", getAgreementSignTime()));
		if(getAgreementSignAddress() != null) sb.append(__wrapString(count++, "agreementSignAddress", getAgreementSignAddress()));
		if(getFileId() != null) sb.append(__wrapNumber(count++, "fileId", getFileId()));
		if(getTeamSize() != null) sb.append(__wrapNumber(count++, "teamSize", getTeamSize()));
		if(getAreasExpertise() != null) sb.append(__wrapNumber(count++, "areasExpertise", getAreasExpertise()));
		if(getAttachmentName() != null) sb.append(__wrapString(count++, "attachmentName", getAttachmentName()));
		if(getAttachment() != null) sb.append(__wrapString(count++, "attachment", getAttachment()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(count++, "createEmployeeId", getCreateEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSupplierId() != null) res.put("supplierId", getSupplierId());
		if(getSupplierName() != null) res.put("supplierName", getSupplierName());
		if(getSupplierContact() != null) res.put("supplierContact", getSupplierContact());
		if(getSupplierPhone() != null) res.put("supplierPhone", getSupplierPhone());
		if(getSupplierEmail() != null) res.put("supplierEmail", getSupplierEmail());
		if(getSupplierType() != null) res.put("supplierType", getSupplierType());
		if(getSupplierMainBusinessType() != null) res.put("supplierMainBusinessType", getSupplierMainBusinessType());
		if(getSupplierScopeSupply() != null) res.put("supplierScopeSupply", getSupplierScopeSupply());
		if(getSocialCreditCode() != null) res.put("socialCreditCode", getSocialCreditCode());
		if(getSupplier_province() != null) res.put("supplier_province", getSupplier_province());
		if(getSupplier_city() != null) res.put("supplier_city", getSupplier_city());
		if(getSupplierBankAddress() != null) res.put("supplierBankAddress", getSupplierBankAddress());
		if(getSupplierAddress() != null) res.put("supplierAddress", getSupplierAddress());
		if(getProductionCycle() != null) res.put("productionCycle", getProductionCycle());
		if(getLogisticsCycle() != null) res.put("logisticsCycle", getLogisticsCycle());
		if(getSupplierBoss() != null) res.put("supplierBoss", getSupplierBoss());
		if(getContractSigningTime() != null) res.put("contractSigningTime", getContractSigningTime());
		if(getContractScopeTime() != null) res.put("contractScopeTime", getContractScopeTime());
		if(getContractScopeTimeStart() != null) res.put("contractScopeTimeStart", getContractScopeTimeStart());
		if(getContractScopeTimeEnd() != null) res.put("contractScopeTimeEnd", getContractScopeTimeEnd());
		if(getOperateEmployeeId() != null) res.put("operateEmployeeId", getOperateEmployeeId());
		if(getOperateTime() != null) res.put("operateTime", getOperateTime());
		if(getSupplierOrigin() != null) res.put("supplierOrigin", getSupplierOrigin());
		if(getSupplierStatus() != null) res.put("supplierStatus", getSupplierStatus());
		if(getIsUse() != null) res.put("isUse", getIsUse());
		if(getReceiveUnitManageId() != null) res.put("receiveUnitManageId", getReceiveUnitManageId());
		if(getAgreementType() != null) res.put("agreementType", getAgreementType());
		if(getAgreementSignTime() != null) res.put("agreementSignTime", getAgreementSignTime());
		if(getAgreementSignAddress() != null) res.put("agreementSignAddress", getAgreementSignAddress());
		if(getFileId() != null) res.put("fileId", getFileId());
		if(getTeamSize() != null) res.put("teamSize", getTeamSize());
		if(getAreasExpertise() != null) res.put("areasExpertise", getAreasExpertise());
		if(getAttachmentName() != null) res.put("attachmentName", getAttachmentName());
		if(getAttachment() != null) res.put("attachment", getAttachment());
		if(getCreateEmployeeId() != null) res.put("createEmployeeId", getCreateEmployeeId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("supplierName")) != null) setSupplierName(__getString(val));
		if((val = values.get("supplierContact")) != null) setSupplierContact(__getString(val));
		if((val = values.get("supplierPhone")) != null) setSupplierPhone(__getString(val));
		if((val = values.get("supplierEmail")) != null) setSupplierEmail(__getString(val));
		if((val = values.get("supplierType")) != null) setSupplierType(__getInt(val)); 
		if((val = values.get("supplierMainBusinessType")) != null) setSupplierMainBusinessType(__getInt(val)); 
		if((val = values.get("supplierScopeSupply")) != null) setSupplierScopeSupply(__getString(val));
		if((val = values.get("socialCreditCode")) != null) setSocialCreditCode(__getString(val));
		if((val = values.get("supplier_province")) != null) setSupplier_province(__getInt(val)); 
		if((val = values.get("supplier_city")) != null) setSupplier_city(__getInt(val)); 
		if((val = values.get("supplierBankAddress")) != null) setSupplierBankAddress(__getString(val));
		if((val = values.get("supplierAddress")) != null) setSupplierAddress(__getString(val));
		if((val = values.get("productionCycle")) != null) setProductionCycle(__getInt(val)); 
		if((val = values.get("logisticsCycle")) != null) setLogisticsCycle(__getInt(val)); 
		if((val = values.get("supplierBoss")) != null) setSupplierBoss(__getString(val));
		if((val = values.get("contractSigningTime")) != null) setContractSigningTime(__getDate(val)); 
		if((val = values.get("contractScopeTime")) != null) setContractScopeTime(__getString(val));
		if((val = values.get("contractScopeTimeStart")) != null) setContractScopeTimeStart(__getDate(val)); 
		if((val = values.get("contractScopeTimeEnd")) != null) setContractScopeTimeEnd(__getDate(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("supplierOrigin")) != null) setSupplierOrigin(__getString(val));
		if((val = values.get("supplierStatus")) != null) setSupplierStatus(__getInt(val)); 
		if((val = values.get("isUse")) != null) setIsUse(__getInt(val)); 
		if((val = values.get("receiveUnitManageId")) != null) setReceiveUnitManageId(__getInt(val)); 
		if((val = values.get("agreementType")) != null) setAgreementType(__getInt(val)); 
		if((val = values.get("agreementSignTime")) != null) setAgreementSignTime(__getDate(val)); 
		if((val = values.get("agreementSignAddress")) != null) setAgreementSignAddress(__getString(val));
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
		if((val = values.get("teamSize")) != null) setTeamSize(__getInt(val)); 
		if((val = values.get("areasExpertise")) != null) setAreasExpertise(__getInt(val)); 
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
		if((val = values.get("attachment")) != null) setAttachment(__getString(val));
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __supplier_id ;
	protected java.lang.String  __supplier_name ;
	protected java.lang.String  __supplier_contact ;
	protected java.lang.String  __supplier_phone ;
	protected java.lang.String  __supplier_email ;
	protected java.lang.Integer  __supplier_type ;
	protected java.lang.Integer  __supplier_main_business_type ;
	protected java.lang.String  __supplier_scope_supply ;
	protected java.lang.String  __social_credit_code ;
	protected java.lang.Integer  __supplier__province ;
	protected java.lang.Integer  __supplier__city ;
	protected java.lang.String  __supplier_bank_address ;
	protected java.lang.String  __supplier_address ;
	protected java.lang.Integer  __production_cycle ;
	protected java.lang.Integer  __logistics_cycle ;
	protected java.lang.String  __supplier_boss ;
	protected java.util.Date  __contract_signing_time ;
	protected java.lang.String  __contract_scope_time ;
	protected java.util.Date  __contract_scope_time_start ;
	protected java.util.Date  __contract_scope_time_end ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __supplier_origin ;
	protected java.lang.Integer  __supplier_status ;
	protected java.lang.Integer  __is_use ;
	protected java.lang.Integer  __receive_unit_manage_id ;
	protected java.lang.Integer  __agreement_type ;
	protected java.util.Date  __agreement_sign_time ;
	protected java.lang.String  __agreement_sign_address ;
	protected java.lang.Integer  __file_id ;
	protected java.lang.Integer  __team_size ;
	protected java.lang.Integer  __areas_expertise ;
	protected java.lang.String  __attachment_name ;
	protected java.lang.String  __attachment ;
	protected java.lang.Integer  __create_employee_id ;
	protected java.util.Date  __create_time ;
}
