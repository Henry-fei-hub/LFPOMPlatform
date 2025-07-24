package pomplatform.k3voucher.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseRevenueVoucher extends GenericBase implements BaseFactory<BaseRevenueVoucher>, Comparable<BaseRevenueVoucher> 
{


	public static BaseRevenueVoucher newInstance(){
		return new BaseRevenueVoucher();
	}

	@Override
	public BaseRevenueVoucher make(){
		BaseRevenueVoucher b = new BaseRevenueVoucher();
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
	public final static java.lang.String CS_AMOUNT_OF_REIMBURSEMENT = "amount_of_reimbursement" ;
	public final static java.lang.String CS_INPUT_TAX = "input_tax" ;
	public final static java.lang.String CS_SELF_BANK_ACCOUNT = "self_bank_account" ;
	public final static java.lang.String CS_OTHER_BANK_ACCOUNT = "other_bank_account" ;
	public final static java.lang.String CS_NEED_TO_CHANGE = "need_to_change" ;
	public final static java.lang.String CS_VESTING_DATE = "vesting_date" ;
	public final static java.lang.String CS_LOCKED = "locked" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;
	public final static java.lang.String CS_LOCKED_TIME = "locked_time" ;
	public final static java.lang.String CS_LINK_ID = "link_id" ;
	public final static java.lang.String CS_VOUCHER_TYPE = "voucher_type" ;
	public final static java.lang.String CS_ADDITIONAL_LINK_ID = "additional_link_id" ;
	public final static java.lang.String CS_SHOW_NAME = "show_name" ;
	public final static java.lang.String CS_CUSTOMER_ID = "customer_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目,归属公司,凭证号,凭证内序号,科目类型,科目编码,科目代码,科目名称,辅助核算类型,辅助核算编码,辅助核算代码,辅助核算名称,备注,简化备注,借方,贷方,报销汇总编号,报销金额,进项税,我方银行账号,对方银行账号,需要调整,归属日期,是否锁定,创建时间,修改时间,定稿时间,关联编码,凭证类型 1报销  2发票  3回款 4收入,附加的关联编码,合同/,客户编码";

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

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public java.util.Date getLockedTime() {
		return this.__locked_time;
	}

	public void setLockedTime( java.util.Date value ) {
		this.__locked_time = value;
	}

	public java.lang.Integer getLinkId() {
		return this.__link_id;
	}

	public void setLinkId( java.lang.Integer value ) {
		this.__link_id = value;
	}

	public java.lang.Integer getVoucherType() {
		return this.__voucher_type;
	}

	public void setVoucherType( java.lang.Integer value ) {
		this.__voucher_type = value;
	}

	public java.lang.Integer getAdditionalLinkId() {
		return this.__additional_link_id;
	}

	public void setAdditionalLinkId( java.lang.Integer value ) {
		this.__additional_link_id = value;
	}

	public java.lang.String getShowName() {
		return this.__show_name;
	}

	public void setShowName( java.lang.String value ) {
		this.__show_name = value;
	}

	public java.lang.Integer getCustomerId() {
		return this.__customer_id;
	}

	public void setCustomerId( java.lang.Integer value ) {
		this.__customer_id = value;
	}

	public void cloneCopy(BaseRevenueVoucher __bean){
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
		__bean.setAmountOfReimbursement(getAmountOfReimbursement());
		__bean.setInputTax(getInputTax());
		__bean.setSelfBankAccount(getSelfBankAccount());
		__bean.setOtherBankAccount(getOtherBankAccount());
		__bean.setNeedToChange(getNeedToChange());
		__bean.setVestingDate(getVestingDate());
		__bean.setLocked(getLocked());
		__bean.setCreateTime(getCreateTime());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setLockedTime(getLockedTime());
		__bean.setLinkId(getLinkId());
		__bean.setVoucherType(getVoucherType());
		__bean.setAdditionalLinkId(getAdditionalLinkId());
		__bean.setShowName(getShowName());
		__bean.setCustomerId(getCustomerId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getK3VoucherId() == null ? "" : getK3VoucherId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
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
		sb.append(getAmountOfReimbursement() == null ? "" : getAmountOfReimbursement());
		sb.append(",");
		sb.append(getInputTax() == null ? "" : getInputTax());
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
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");
		sb.append(getLockedTime() == null ? "" : sdf.format(getLockedTime()));
		sb.append(",");
		sb.append(getLinkId() == null ? "" : getLinkId());
		sb.append(",");
		sb.append(getVoucherType() == null ? "" : getVoucherType());
		sb.append(",");
		sb.append(getAdditionalLinkId() == null ? "" : getAdditionalLinkId());
		sb.append(",");
		sb.append(getShowName() == null ? "" : getShowName());
		sb.append(",");
		sb.append(getCustomerId() == null ? "" : getCustomerId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseRevenueVoucher o) {
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
		hash = 97 * hash + Objects.hashCode(this.__amount_of_reimbursement);
		hash = 97 * hash + Objects.hashCode(this.__input_tax);
		hash = 97 * hash + Objects.hashCode(this.__self_bank_account);
		hash = 97 * hash + Objects.hashCode(this.__other_bank_account);
		hash = 97 * hash + Objects.hashCode(this.__need_to_change);
		hash = 97 * hash + Objects.hashCode(this.__vesting_date);
		hash = 97 * hash + Objects.hashCode(this.__locked);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__locked_time);
		hash = 97 * hash + Objects.hashCode(this.__link_id);
		hash = 97 * hash + Objects.hashCode(this.__voucher_type);
		hash = 97 * hash + Objects.hashCode(this.__additional_link_id);
		hash = 97 * hash + Objects.hashCode(this.__show_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseRevenueVoucher o = (BaseRevenueVoucher)obj;
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
		if(!Objects.equals(this.__amount_of_reimbursement, o.getAmountOfReimbursement())) return false;
		if(!Objects.equals(this.__input_tax, o.getInputTax())) return false;
		if(!Objects.equals(this.__self_bank_account, o.getSelfBankAccount())) return false;
		if(!Objects.equals(this.__other_bank_account, o.getOtherBankAccount())) return false;
		if(!Objects.equals(this.__need_to_change, o.getNeedToChange())) return false;
		if(!Objects.equals(this.__vesting_date, o.getVestingDate())) return false;
		if(!Objects.equals(this.__locked, o.getLocked())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__locked_time, o.getLockedTime())) return false;
		if(!Objects.equals(this.__link_id, o.getLinkId())) return false;
		if(!Objects.equals(this.__voucher_type, o.getVoucherType())) return false;
		if(!Objects.equals(this.__additional_link_id, o.getAdditionalLinkId())) return false;
		if(!Objects.equals(this.__show_name, o.getShowName())) return false;
		if(!Objects.equals(this.__customer_id, o.getCustomerId())) return false;
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
		if(getAmountOfReimbursement() != null) sb.append(__wrapDecimal(count++, "amountOfReimbursement", getAmountOfReimbursement()));
		if(getInputTax() != null) sb.append(__wrapDecimal(count++, "inputTax", getInputTax()));
		if(getSelfBankAccount() != null) sb.append(__wrapString(count++, "selfBankAccount", getSelfBankAccount()));
		if(getOtherBankAccount() != null) sb.append(__wrapString(count++, "otherBankAccount", getOtherBankAccount()));
		if(getNeedToChange() != null) sb.append(__wrapBoolean(count++, "needToChange", getNeedToChange()));
		if(getVestingDate() != null) sb.append(__wrapDate(count++, "vestingDate", getVestingDate()));
		if(getLocked() != null) sb.append(__wrapBoolean(count++, "locked", getLocked()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getLockedTime() != null) sb.append(__wrapDate(count++, "lockedTime", getLockedTime()));
		if(getLinkId() != null) sb.append(__wrapNumber(count++, "linkId", getLinkId()));
		if(getVoucherType() != null) sb.append(__wrapNumber(count++, "voucherType", getVoucherType()));
		if(getAdditionalLinkId() != null) sb.append(__wrapNumber(count++, "additionalLinkId", getAdditionalLinkId()));
		if(getShowName() != null) sb.append(__wrapString(count++, "showName", getShowName()));
		if(getCustomerId() != null) sb.append(__wrapNumber(count++, "customerId", getCustomerId()));
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
		if((val = values.get("amountOfReimbursement")) != null) setAmountOfReimbursement(__getDecimal(val));  
		if((val = values.get("inputTax")) != null) setInputTax(__getDecimal(val));  
		if((val = values.get("selfBankAccount")) != null) setSelfBankAccount(__getString(val));
		if((val = values.get("otherBankAccount")) != null) setOtherBankAccount(__getString(val));
		if((val = values.get("needToChange")) != null) setNeedToChange(__getBoolean(val));
		if((val = values.get("vestingDate")) != null) setVestingDate(__getDate(val)); 
		if((val = values.get("locked")) != null) setLocked(__getBoolean(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("lockedTime")) != null) setLockedTime(__getDate(val)); 
		if((val = values.get("linkId")) != null) setLinkId(__getInt(val)); 
		if((val = values.get("voucherType")) != null) setVoucherType(__getInt(val)); 
		if((val = values.get("additionalLinkId")) != null) setAdditionalLinkId(__getInt(val)); 
		if((val = values.get("showName")) != null) setShowName(__getString(val));
		if((val = values.get("customerId")) != null) setCustomerId(__getInt(val)); 
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
	protected java.math.BigDecimal  __amount_of_reimbursement ;
	protected java.math.BigDecimal  __input_tax ;
	protected java.lang.String  __self_bank_account ;
	protected java.lang.String  __other_bank_account ;
	protected java.lang.Boolean  __need_to_change ;
	protected java.util.Date  __vesting_date ;
	protected java.lang.Boolean  __locked ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
	protected java.util.Date  __locked_time ;
	protected java.lang.Integer  __link_id ;
	protected java.lang.Integer  __voucher_type ;
	protected java.lang.Integer  __additional_link_id ;
	protected java.lang.String  __show_name ;
	protected java.lang.Integer  __customer_id ;
}
