package pomplatform.k3voucher.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseIncomeVoucher extends GenericBase implements BaseFactory<BaseIncomeVoucher>, Comparable<BaseIncomeVoucher> 
{


	public static BaseIncomeVoucher newInstance(){
		return new BaseIncomeVoucher();
	}

	@Override
	public BaseIncomeVoucher make(){
		BaseIncomeVoucher b = new BaseIncomeVoucher();
		return b;
	}

	public final static java.lang.String CS_K3_VOUCHER_ID = "k3_voucher_id" ;
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
	public final static java.lang.String CS_VESTING_DATE = "vesting_date" ;
	public final static java.lang.String CS_LOCKED = "locked" ;
	public final static java.lang.String CS_VOUCHER_TYPE = "voucher_type" ;
	public final static java.lang.String CS_LINK_ID = "link_id" ;
	public final static java.lang.String CS_INVOICE_NUMBER = "invoice_number" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CONTRACT_AREA = "contract_area" ;
	public final static java.lang.String CS_CUSTOMER_ID = "customer_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,归属公司,凭证号,凭证内序号,科目类型,科目编码,科目代码,科目名称,辅助核算类型,辅助核算编码,辅助核算代码,辅助核算名称,备注,简化备注,借方,贷方,归属日期,是否定稿,凭证类型(system_dictionary_117) 1报销  2发票  3回款,关联编码,发票号码,合同id,合同编号,合同名称,合同区域,客户";
	public final static java.lang.String DOWNLOAD_CAPTIONS = "凭证日期,会计年度,会计期间,凭证字,凭证号,科目代码,科目名称,币别代码,币别名称,原币金额,借方,贷方,制单,审核,核准,出纳,经办,结算方式,结算号,凭证摘要,数量,数量单位,单价,参考信息,业务日期,往来业务编号,附件数,序号,系统模块,业务描述,汇率类型,汇率,分录序号,核算项目,过账,机制凭证,现金流量";
	
	public java.lang.Integer getK3VoucherId() {
		return this.__k3_voucher_id;
	}

	public void setK3VoucherId( java.lang.Integer value ) {
		this.__k3_voucher_id = value;
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

	public java.lang.String getInvoiceNumber() {
		return this.__invoice_number;
	}

	public void setInvoiceNumber( java.lang.String value ) {
		this.__invoice_number = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.Integer getContractArea() {
		return this.__contract_area;
	}

	public void setContractArea( java.lang.Integer value ) {
		this.__contract_area = value;
	}

	public java.lang.Integer getCustomerId() {
		return this.__customer_id;
	}

	public void setCustomerId( java.lang.Integer value ) {
		this.__customer_id = value;
	}

	public void cloneCopy(BaseIncomeVoucher __bean){
		__bean.setK3VoucherId(getK3VoucherId());
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
		__bean.setVestingDate(getVestingDate());
		__bean.setLocked(getLocked());
		__bean.setVoucherType(getVoucherType());
		__bean.setLinkId(getLinkId());
		__bean.setInvoiceNumber(getInvoiceNumber());
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setContractArea(getContractArea());
		__bean.setCustomerId(getCustomerId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getK3VoucherId() == null ? "" : getK3VoucherId());
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
		sb.append(getVestingDate() == null ? "" : sdf.format(getVestingDate()));
		sb.append(",");
		sb.append(getLocked() == null ? "" : getLocked());
		sb.append(",");
		sb.append(getVoucherType() == null ? "" : getVoucherType());
		sb.append(",");
		sb.append(getLinkId() == null ? "" : getLinkId());
		sb.append(",");
		sb.append(getInvoiceNumber() == null ? "" : getInvoiceNumber());
		sb.append(",");
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		String strContractCode = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractCode()));
		sb.append(strContractCode == null ? "" : strContractCode);
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getContractArea() == null ? "" : getContractArea());
		sb.append(",");
		sb.append(getCustomerId() == null ? "" : getCustomerId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseIncomeVoucher o) {
		return __k3_voucher_id == null ? -1 : __k3_voucher_id.compareTo(o.getK3VoucherId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__k3_voucher_id);
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
		hash = 97 * hash + Objects.hashCode(this.__vesting_date);
		hash = 97 * hash + Objects.hashCode(this.__locked);
		hash = 97 * hash + Objects.hashCode(this.__voucher_type);
		hash = 97 * hash + Objects.hashCode(this.__link_id);
		hash = 97 * hash + Objects.hashCode(this.__invoice_number);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__contract_area);
		hash = 97 * hash + Objects.hashCode(this.__customer_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseIncomeVoucher o = (BaseIncomeVoucher)obj;
		if(!Objects.equals(this.__k3_voucher_id, o.getK3VoucherId())) return false;
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
		if(!Objects.equals(this.__vesting_date, o.getVestingDate())) return false;
		if(!Objects.equals(this.__locked, o.getLocked())) return false;
		if(!Objects.equals(this.__voucher_type, o.getVoucherType())) return false;
		if(!Objects.equals(this.__link_id, o.getLinkId())) return false;
		if(!Objects.equals(this.__invoice_number, o.getInvoiceNumber())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__contract_area, o.getContractArea())) return false;
		if(!Objects.equals(this.__customer_id, o.getCustomerId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getK3VoucherId() != null) sb.append(__wrapNumber(count++, "k3VoucherId", getK3VoucherId()));
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
		if(getVestingDate() != null) sb.append(__wrapDate(count++, "vestingDate", getVestingDate()));
		if(getLocked() != null) sb.append(__wrapBoolean(count++, "locked", getLocked()));
		if(getVoucherType() != null) sb.append(__wrapNumber(count++, "voucherType", getVoucherType()));
		if(getLinkId() != null) sb.append(__wrapNumber(count++, "linkId", getLinkId()));
		if(getInvoiceNumber() != null) sb.append(__wrapString(count++, "invoiceNumber", getInvoiceNumber()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getContractArea() != null) sb.append(__wrapNumber(count++, "contractArea", getContractArea()));
		if(getCustomerId() != null) sb.append(__wrapNumber(count++, "customerId", getCustomerId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("k3VoucherId")) != null) setK3VoucherId(__getInt(val)); 
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
		if((val = values.get("vestingDate")) != null) setVestingDate(__getDate(val)); 
		if((val = values.get("locked")) != null) setLocked(__getBoolean(val));
		if((val = values.get("voucherType")) != null) setVoucherType(__getInt(val)); 
		if((val = values.get("linkId")) != null) setLinkId(__getInt(val)); 
		if((val = values.get("invoiceNumber")) != null) setInvoiceNumber(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("contractArea")) != null) setContractArea(__getInt(val)); 
		if((val = values.get("customerId")) != null) setCustomerId(__getInt(val)); 
	}

	protected java.lang.Integer  __k3_voucher_id ;
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
	protected java.util.Date  __vesting_date ;
	protected java.lang.Boolean  __locked ;
	protected java.lang.Integer  __voucher_type ;
	protected java.lang.Integer  __link_id ;
	protected java.lang.String  __invoice_number ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.Integer  __contract_area ;
	protected java.lang.Integer  __customer_id ;
}
