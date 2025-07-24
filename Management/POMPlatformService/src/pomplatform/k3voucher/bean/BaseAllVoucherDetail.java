package pomplatform.k3voucher.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAllVoucherDetail extends GenericBase implements BaseFactory<BaseAllVoucherDetail>, Comparable<BaseAllVoucherDetail> 
{


	public static BaseAllVoucherDetail newInstance(){
		return new BaseAllVoucherDetail();
	}

	@Override
	public BaseAllVoucherDetail make(){
		BaseAllVoucherDetail b = new BaseAllVoucherDetail();
		return b;
	}

	public final static java.lang.String CS_K3_VOUCHER_ID = "k3_voucher_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_SEQUENCE_NUMBER = "sequence_number" ;
	public final static java.lang.String CS_INTERNAL_SEQUENCE_NUMBER = "internal_sequence_number" ;
	public final static java.lang.String CS_CODE_TYPE = "code_type" ;
	public final static java.lang.String CS_CODE_ID = "code_id" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_SECONDARY_CODE_TYPE = "secondary_code_type" ;
	public final static java.lang.String CS_SECONDARY_CODE_ID = "secondary_code_id" ;
	public final static java.lang.String CS_SECONDARY_CODE = "secondary_code" ;
	public final static java.lang.String CS_SECONDARY_NAME = "secondary_name" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_SIMPLIFY_REMARK = "simplify_remark" ;
	public final static java.lang.String CS_DEBIT_SIDE = "debit_side" ;
	public final static java.lang.String CS_CREDIT_SIDE = "credit_side" ;
	public final static java.lang.String CS_REIMBURSEMENT_PACKAGE_CODE = "reimbursement_package_code" ;
	public final static java.lang.String CS_REIMBURSEMENT_PACKAGE_ID = "reimbursement_package_id" ;
	public final static java.lang.String CS_AMOUNT_OF_REIMBURSEMENT = "amount_of_reimbursement" ;
	public final static java.lang.String CS_INPUT_TAX = "input_tax" ;
	public final static java.lang.String CS_INPUT_TAX_REBATE = "input_tax_rebate" ;
	public final static java.lang.String CS_SELF_BANK_ACCOUNT = "self_bank_account" ;
	public final static java.lang.String CS_OTHER_BANK_ACCOUNT = "other_bank_account" ;
	public final static java.lang.String CS_NEED_TO_CHANGE = "need_to_change" ;
	public final static java.lang.String CS_VESTING_DATE = "vesting_date" ;
	public final static java.lang.String CS_LOCKED = "locked" ;
	public final static java.lang.String CS_VOUCHER_TYPE = "voucher_type" ;
	public final static java.lang.String CS_LINK_ID = "link_id" ;
	public final static java.lang.String CS_ADDITIONAL_LINK_ID = "additional_link_id" ;
	public final static java.lang.String CS_VOUCHER_YEAR = "voucher_year" ;
	public final static java.lang.String CS_VOUCHER_MONTH = "voucher_month" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目,归属公司,凭证号,凭证内序号,科目类型,科目编码,科目代码,科目名称,辅助核算类型,辅助核算编码,辅助核算代码,辅助核算名称,备注,凭证摘要,借方,贷方,报销汇总编号,报销汇总单主表编码,报销金额,进项税,进项税转出金额,我方银行账号,对方银行账号,需要调整,归属日期,是否锁定,凭证类型,关联编码,附加的关联编码,凭证年份,凭证月份,流程类型,流程编码,流程实例编码,流程实例业务编码";

	public java.lang.Integer getK3VoucherId() {
		return this.__k3_voucher_id;
	}

	public void setK3VoucherId( java.lang.Integer value ) {
		this.__k3_voucher_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getSequenceNumber() {
		return this.__sequence_number;
	}

	public void setSequenceNumber( java.lang.Integer value ) {
		this.__sequence_number = value;
	}

	public java.lang.Integer getInternalSequenceNumber() {
		return this.__internal_sequence_number;
	}

	public void setInternalSequenceNumber( java.lang.Integer value ) {
		this.__internal_sequence_number = value;
	}

	public java.lang.Integer getCodeType() {
		return this.__code_type;
	}

	public void setCodeType( java.lang.Integer value ) {
		this.__code_type = value;
	}

	public java.lang.Integer getCodeId() {
		return this.__code_id;
	}

	public void setCodeId( java.lang.Integer value ) {
		this.__code_id = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.lang.Integer getSecondaryCodeType() {
		return this.__secondary_code_type;
	}

	public void setSecondaryCodeType( java.lang.Integer value ) {
		this.__secondary_code_type = value;
	}

	public java.lang.Integer getSecondaryCodeId() {
		return this.__secondary_code_id;
	}

	public void setSecondaryCodeId( java.lang.Integer value ) {
		this.__secondary_code_id = value;
	}

	public java.lang.String getSecondaryCode() {
		return this.__secondary_code;
	}

	public void setSecondaryCode( java.lang.String value ) {
		this.__secondary_code = value;
	}

	public java.lang.String getSecondaryName() {
		return this.__secondary_name;
	}

	public void setSecondaryName( java.lang.String value ) {
		this.__secondary_name = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getSimplifyRemark() {
		return this.__simplify_remark;
	}

	public void setSimplifyRemark( java.lang.String value ) {
		this.__simplify_remark = value;
	}

	public java.math.BigDecimal getDebitSide() {
		return this.__debit_side;
	}

	public void setDebitSide( java.math.BigDecimal value ) {
		this.__debit_side = value;
	}

	public java.math.BigDecimal getCreditSide() {
		return this.__credit_side;
	}

	public void setCreditSide( java.math.BigDecimal value ) {
		this.__credit_side = value;
	}

	public java.lang.String getReimbursementPackageCode() {
		return this.__reimbursement_package_code;
	}

	public void setReimbursementPackageCode( java.lang.String value ) {
		this.__reimbursement_package_code = value;
	}

	public java.lang.Integer getReimbursementPackageId() {
		return this.__reimbursement_package_id;
	}

	public void setReimbursementPackageId( java.lang.Integer value ) {
		this.__reimbursement_package_id = value;
	}

	public java.math.BigDecimal getAmountOfReimbursement() {
		return this.__amount_of_reimbursement;
	}

	public void setAmountOfReimbursement( java.math.BigDecimal value ) {
		this.__amount_of_reimbursement = value;
	}

	public java.math.BigDecimal getInputTax() {
		return this.__input_tax;
	}

	public void setInputTax( java.math.BigDecimal value ) {
		this.__input_tax = value;
	}

	public java.math.BigDecimal getInputTaxRebate() {
		return this.__input_tax_rebate;
	}

	public void setInputTaxRebate( java.math.BigDecimal value ) {
		this.__input_tax_rebate = value;
	}

	public java.lang.String getSelfBankAccount() {
		return this.__self_bank_account;
	}

	public void setSelfBankAccount( java.lang.String value ) {
		this.__self_bank_account = value;
	}

	public java.lang.String getOtherBankAccount() {
		return this.__other_bank_account;
	}

	public void setOtherBankAccount( java.lang.String value ) {
		this.__other_bank_account = value;
	}

	public java.lang.Boolean getNeedToChange() {
		return this.__need_to_change;
	}

	public void setNeedToChange( java.lang.Boolean value ) {
		this.__need_to_change = value;
	}

	public java.util.Date getVestingDate() {
		return this.__vesting_date;
	}

	public void setVestingDate( java.util.Date value ) {
		this.__vesting_date = value;
	}

	public java.lang.Boolean getLocked() {
		return this.__locked;
	}

	public void setLocked( java.lang.Boolean value ) {
		this.__locked = value;
	}

	public java.lang.Integer getVoucherType() {
		return this.__voucher_type;
	}

	public void setVoucherType( java.lang.Integer value ) {
		this.__voucher_type = value;
	}

	public java.lang.Integer getLinkId() {
		return this.__link_id;
	}

	public void setLinkId( java.lang.Integer value ) {
		this.__link_id = value;
	}

	public java.lang.Integer getAdditionalLinkId() {
		return this.__additional_link_id;
	}

	public void setAdditionalLinkId( java.lang.Integer value ) {
		this.__additional_link_id = value;
	}

	public java.lang.Integer getVoucherYear() {
		return this.__voucher_year;
	}

	public void setVoucherYear( java.lang.Integer value ) {
		this.__voucher_year = value;
	}

	public java.lang.Integer getVoucherMonth() {
		return this.__voucher_month;
	}

	public void setVoucherMonth( java.lang.Integer value ) {
		this.__voucher_month = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( java.lang.Integer value ) {
		this.__process_id = value;
	}

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public void cloneCopy(BaseAllVoucherDetail __bean){
		__bean.setK3VoucherId(getK3VoucherId());
		__bean.setProjectId(getProjectId());
		__bean.setCompanyId(getCompanyId());
		__bean.setSequenceNumber(getSequenceNumber());
		__bean.setInternalSequenceNumber(getInternalSequenceNumber());
		__bean.setCodeType(getCodeType());
		__bean.setCodeId(getCodeId());
		__bean.setCode(getCode());
		__bean.setName(getName());
		__bean.setSecondaryCodeType(getSecondaryCodeType());
		__bean.setSecondaryCodeId(getSecondaryCodeId());
		__bean.setSecondaryCode(getSecondaryCode());
		__bean.setSecondaryName(getSecondaryName());
		__bean.setRemark(getRemark());
		__bean.setSimplifyRemark(getSimplifyRemark());
		__bean.setDebitSide(getDebitSide());
		__bean.setCreditSide(getCreditSide());
		__bean.setReimbursementPackageCode(getReimbursementPackageCode());
		__bean.setReimbursementPackageId(getReimbursementPackageId());
		__bean.setAmountOfReimbursement(getAmountOfReimbursement());
		__bean.setInputTax(getInputTax());
		__bean.setInputTaxRebate(getInputTaxRebate());
		__bean.setSelfBankAccount(getSelfBankAccount());
		__bean.setOtherBankAccount(getOtherBankAccount());
		__bean.setNeedToChange(getNeedToChange());
		__bean.setVestingDate(getVestingDate());
		__bean.setLocked(getLocked());
		__bean.setVoucherType(getVoucherType());
		__bean.setLinkId(getLinkId());
		__bean.setAdditionalLinkId(getAdditionalLinkId());
		__bean.setVoucherYear(getVoucherYear());
		__bean.setVoucherMonth(getVoucherMonth());
		__bean.setProcessType(getProcessType());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setBusinessId(getBusinessId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getK3VoucherId() == null ? "" : getK3VoucherId());
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getSequenceNumber() == null ? "" : getSequenceNumber());
		sb.append(",");
		sb.append(getInternalSequenceNumber() == null ? "" : getInternalSequenceNumber());
		sb.append(",");
		sb.append(getCodeType() == null ? "" : getCodeType());
		sb.append(",");
		sb.append(getCodeId() == null ? "" : getCodeId());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getSecondaryCodeType() == null ? "" : getSecondaryCodeType());
		sb.append(",");
		sb.append(getSecondaryCodeId() == null ? "" : getSecondaryCodeId());
		sb.append(",");
		sb.append(getSecondaryCode() == null ? "" : getSecondaryCode());
		sb.append(",");
		sb.append(getSecondaryName() == null ? "" : getSecondaryName());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getSimplifyRemark() == null ? "" : getSimplifyRemark());
		sb.append(",");
		sb.append(getDebitSide() == null ? "" : getDebitSide());
		sb.append(",");
		sb.append(getCreditSide() == null ? "" : getCreditSide());
		sb.append(",");
		sb.append(getReimbursementPackageCode() == null ? "" : getReimbursementPackageCode());
		sb.append(",");
		sb.append(getReimbursementPackageId() == null ? "" : getReimbursementPackageId());
		sb.append(",");
		sb.append(getAmountOfReimbursement() == null ? "" : getAmountOfReimbursement());
		sb.append(",");
		sb.append(getInputTax() == null ? "" : getInputTax());
		sb.append(",");
		sb.append(getInputTaxRebate() == null ? "" : getInputTaxRebate());
		sb.append(",");
		sb.append(getSelfBankAccount() == null ? "" : getSelfBankAccount());
		sb.append(",");
		sb.append(getOtherBankAccount() == null ? "" : getOtherBankAccount());
		sb.append(",");
		sb.append(getNeedToChange() == null ? "" : getNeedToChange());
		sb.append(",");
		sb.append(getVestingDate() == null ? "" : sdf.format(getVestingDate()));
		sb.append(",");
		sb.append(getLocked() == null ? "" : getLocked());
		sb.append(",");
		String strVoucherType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_117", String.valueOf(getVoucherType()));
		sb.append(strVoucherType == null ? "" : strVoucherType);
		sb.append(",");
		sb.append(getLinkId() == null ? "" : getLinkId());
		sb.append(",");
		sb.append(getAdditionalLinkId() == null ? "" : getAdditionalLinkId());
		sb.append(",");
		sb.append(getVoucherYear() == null ? "" : getVoucherYear());
		sb.append(",");
		sb.append(getVoucherMonth() == null ? "" : getVoucherMonth());
		sb.append(",");
		String strProcessType = delicacy.system.executor.SelectValueCache.getSelectValue("system_process_types", String.valueOf(getProcessType()));
		sb.append(strProcessType == null ? "" : strProcessType);
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		String strBusinessId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getBusinessId()));
		sb.append(strBusinessId == null ? "" : strBusinessId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAllVoucherDetail o) {
		return __k3_voucher_id == null ? -1 : __k3_voucher_id.compareTo(o.getK3VoucherId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__k3_voucher_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__sequence_number);
		hash = 97 * hash + Objects.hashCode(this.__internal_sequence_number);
		hash = 97 * hash + Objects.hashCode(this.__code_type);
		hash = 97 * hash + Objects.hashCode(this.__code_id);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__secondary_code_type);
		hash = 97 * hash + Objects.hashCode(this.__secondary_code_id);
		hash = 97 * hash + Objects.hashCode(this.__secondary_code);
		hash = 97 * hash + Objects.hashCode(this.__secondary_name);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__simplify_remark);
		hash = 97 * hash + Objects.hashCode(this.__debit_side);
		hash = 97 * hash + Objects.hashCode(this.__credit_side);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_package_code);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_package_id);
		hash = 97 * hash + Objects.hashCode(this.__amount_of_reimbursement);
		hash = 97 * hash + Objects.hashCode(this.__input_tax);
		hash = 97 * hash + Objects.hashCode(this.__input_tax_rebate);
		hash = 97 * hash + Objects.hashCode(this.__self_bank_account);
		hash = 97 * hash + Objects.hashCode(this.__other_bank_account);
		hash = 97 * hash + Objects.hashCode(this.__need_to_change);
		hash = 97 * hash + Objects.hashCode(this.__vesting_date);
		hash = 97 * hash + Objects.hashCode(this.__locked);
		hash = 97 * hash + Objects.hashCode(this.__voucher_type);
		hash = 97 * hash + Objects.hashCode(this.__link_id);
		hash = 97 * hash + Objects.hashCode(this.__additional_link_id);
		hash = 97 * hash + Objects.hashCode(this.__voucher_year);
		hash = 97 * hash + Objects.hashCode(this.__voucher_month);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAllVoucherDetail o = (BaseAllVoucherDetail)obj;
		if(!Objects.equals(this.__k3_voucher_id, o.getK3VoucherId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__sequence_number, o.getSequenceNumber())) return false;
		if(!Objects.equals(this.__internal_sequence_number, o.getInternalSequenceNumber())) return false;
		if(!Objects.equals(this.__code_type, o.getCodeType())) return false;
		if(!Objects.equals(this.__code_id, o.getCodeId())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__secondary_code_type, o.getSecondaryCodeType())) return false;
		if(!Objects.equals(this.__secondary_code_id, o.getSecondaryCodeId())) return false;
		if(!Objects.equals(this.__secondary_code, o.getSecondaryCode())) return false;
		if(!Objects.equals(this.__secondary_name, o.getSecondaryName())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__simplify_remark, o.getSimplifyRemark())) return false;
		if(!Objects.equals(this.__debit_side, o.getDebitSide())) return false;
		if(!Objects.equals(this.__credit_side, o.getCreditSide())) return false;
		if(!Objects.equals(this.__reimbursement_package_code, o.getReimbursementPackageCode())) return false;
		if(!Objects.equals(this.__reimbursement_package_id, o.getReimbursementPackageId())) return false;
		if(!Objects.equals(this.__amount_of_reimbursement, o.getAmountOfReimbursement())) return false;
		if(!Objects.equals(this.__input_tax, o.getInputTax())) return false;
		if(!Objects.equals(this.__input_tax_rebate, o.getInputTaxRebate())) return false;
		if(!Objects.equals(this.__self_bank_account, o.getSelfBankAccount())) return false;
		if(!Objects.equals(this.__other_bank_account, o.getOtherBankAccount())) return false;
		if(!Objects.equals(this.__need_to_change, o.getNeedToChange())) return false;
		if(!Objects.equals(this.__vesting_date, o.getVestingDate())) return false;
		if(!Objects.equals(this.__locked, o.getLocked())) return false;
		if(!Objects.equals(this.__voucher_type, o.getVoucherType())) return false;
		if(!Objects.equals(this.__link_id, o.getLinkId())) return false;
		if(!Objects.equals(this.__additional_link_id, o.getAdditionalLinkId())) return false;
		if(!Objects.equals(this.__voucher_year, o.getVoucherYear())) return false;
		if(!Objects.equals(this.__voucher_month, o.getVoucherMonth())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getK3VoucherId() != null) sb.append(__wrapNumber(count++, "k3VoucherId", getK3VoucherId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getSequenceNumber() != null) sb.append(__wrapNumber(count++, "sequenceNumber", getSequenceNumber()));
		if(getInternalSequenceNumber() != null) sb.append(__wrapNumber(count++, "internalSequenceNumber", getInternalSequenceNumber()));
		if(getCodeType() != null) sb.append(__wrapNumber(count++, "codeType", getCodeType()));
		if(getCodeId() != null) sb.append(__wrapNumber(count++, "codeId", getCodeId()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getSecondaryCodeType() != null) sb.append(__wrapNumber(count++, "secondaryCodeType", getSecondaryCodeType()));
		if(getSecondaryCodeId() != null) sb.append(__wrapNumber(count++, "secondaryCodeId", getSecondaryCodeId()));
		if(getSecondaryCode() != null) sb.append(__wrapString(count++, "secondaryCode", getSecondaryCode()));
		if(getSecondaryName() != null) sb.append(__wrapString(count++, "secondaryName", getSecondaryName()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getSimplifyRemark() != null) sb.append(__wrapString(count++, "simplifyRemark", getSimplifyRemark()));
		if(getDebitSide() != null) sb.append(__wrapDecimal(count++, "debitSide", getDebitSide()));
		if(getCreditSide() != null) sb.append(__wrapDecimal(count++, "creditSide", getCreditSide()));
		if(getReimbursementPackageCode() != null) sb.append(__wrapString(count++, "reimbursementPackageCode", getReimbursementPackageCode()));
		if(getReimbursementPackageId() != null) sb.append(__wrapNumber(count++, "reimbursementPackageId", getReimbursementPackageId()));
		if(getAmountOfReimbursement() != null) sb.append(__wrapDecimal(count++, "amountOfReimbursement", getAmountOfReimbursement()));
		if(getInputTax() != null) sb.append(__wrapDecimal(count++, "inputTax", getInputTax()));
		if(getInputTaxRebate() != null) sb.append(__wrapDecimal(count++, "inputTaxRebate", getInputTaxRebate()));
		if(getSelfBankAccount() != null) sb.append(__wrapString(count++, "selfBankAccount", getSelfBankAccount()));
		if(getOtherBankAccount() != null) sb.append(__wrapString(count++, "otherBankAccount", getOtherBankAccount()));
		if(getNeedToChange() != null) sb.append(__wrapBoolean(count++, "needToChange", getNeedToChange()));
		if(getVestingDate() != null) sb.append(__wrapDate(count++, "vestingDate", getVestingDate()));
		if(getLocked() != null) sb.append(__wrapBoolean(count++, "locked", getLocked()));
		if(getVoucherType() != null) sb.append(__wrapNumber(count++, "voucherType", getVoucherType()));
		if(getLinkId() != null) sb.append(__wrapNumber(count++, "linkId", getLinkId()));
		if(getAdditionalLinkId() != null) sb.append(__wrapNumber(count++, "additionalLinkId", getAdditionalLinkId()));
		if(getVoucherYear() != null) sb.append(__wrapNumber(count++, "voucherYear", getVoucherYear()));
		if(getVoucherMonth() != null) sb.append(__wrapNumber(count++, "voucherMonth", getVoucherMonth()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("k3VoucherId")) != null) setK3VoucherId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("sequenceNumber")) != null) setSequenceNumber(__getInt(val)); 
		if((val = values.get("internalSequenceNumber")) != null) setInternalSequenceNumber(__getInt(val)); 
		if((val = values.get("codeType")) != null) setCodeType(__getInt(val)); 
		if((val = values.get("codeId")) != null) setCodeId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("secondaryCodeType")) != null) setSecondaryCodeType(__getInt(val)); 
		if((val = values.get("secondaryCodeId")) != null) setSecondaryCodeId(__getInt(val)); 
		if((val = values.get("secondaryCode")) != null) setSecondaryCode(__getString(val));
		if((val = values.get("secondaryName")) != null) setSecondaryName(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("simplifyRemark")) != null) setSimplifyRemark(__getString(val));
		if((val = values.get("debitSide")) != null) setDebitSide(__getDecimal(val));  
		if((val = values.get("creditSide")) != null) setCreditSide(__getDecimal(val));  
		if((val = values.get("reimbursementPackageCode")) != null) setReimbursementPackageCode(__getString(val));
		if((val = values.get("reimbursementPackageId")) != null) setReimbursementPackageId(__getInt(val)); 
		if((val = values.get("amountOfReimbursement")) != null) setAmountOfReimbursement(__getDecimal(val));  
		if((val = values.get("inputTax")) != null) setInputTax(__getDecimal(val));  
		if((val = values.get("inputTaxRebate")) != null) setInputTaxRebate(__getDecimal(val));  
		if((val = values.get("selfBankAccount")) != null) setSelfBankAccount(__getString(val));
		if((val = values.get("otherBankAccount")) != null) setOtherBankAccount(__getString(val));
		if((val = values.get("needToChange")) != null) setNeedToChange(__getBoolean(val));
		if((val = values.get("vestingDate")) != null) setVestingDate(__getDate(val)); 
		if((val = values.get("locked")) != null) setLocked(__getBoolean(val));
		if((val = values.get("voucherType")) != null) setVoucherType(__getInt(val)); 
		if((val = values.get("linkId")) != null) setLinkId(__getInt(val)); 
		if((val = values.get("additionalLinkId")) != null) setAdditionalLinkId(__getInt(val)); 
		if((val = values.get("voucherYear")) != null) setVoucherYear(__getInt(val)); 
		if((val = values.get("voucherMonth")) != null) setVoucherMonth(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
	}

	protected java.lang.Integer  __k3_voucher_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __sequence_number ;
	protected java.lang.Integer  __internal_sequence_number ;
	protected java.lang.Integer  __code_type ;
	protected java.lang.Integer  __code_id ;
	protected java.lang.String  __code ;
	protected java.lang.String  __name ;
	protected java.lang.Integer  __secondary_code_type ;
	protected java.lang.Integer  __secondary_code_id ;
	protected java.lang.String  __secondary_code ;
	protected java.lang.String  __secondary_name ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __simplify_remark ;
	protected java.math.BigDecimal  __debit_side ;
	protected java.math.BigDecimal  __credit_side ;
	protected java.lang.String  __reimbursement_package_code ;
	protected java.lang.Integer  __reimbursement_package_id ;
	protected java.math.BigDecimal  __amount_of_reimbursement ;
	protected java.math.BigDecimal  __input_tax ;
	protected java.math.BigDecimal  __input_tax_rebate ;
	protected java.lang.String  __self_bank_account ;
	protected java.lang.String  __other_bank_account ;
	protected java.lang.Boolean  __need_to_change ;
	protected java.util.Date  __vesting_date ;
	protected java.lang.Boolean  __locked ;
	protected java.lang.Integer  __voucher_type ;
	protected java.lang.Integer  __link_id ;
	protected java.lang.Integer  __additional_link_id ;
	protected java.lang.Integer  __voucher_year ;
	protected java.lang.Integer  __voucher_month ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __business_id ;
}
