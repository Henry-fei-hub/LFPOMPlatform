package pomplatform.k3voucher.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseInsuranceAndHousingFundK3Voucher extends GenericBase implements BaseFactory<BaseInsuranceAndHousingFundK3Voucher>, Comparable<BaseInsuranceAndHousingFundK3Voucher> 
{


	public static BaseInsuranceAndHousingFundK3Voucher newInstance(){
		return new BaseInsuranceAndHousingFundK3Voucher();
	}

	@Override
	public BaseInsuranceAndHousingFundK3Voucher make(){
		BaseInsuranceAndHousingFundK3Voucher b = new BaseInsuranceAndHousingFundK3Voucher();
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
	public final static java.lang.String CS_DEBIT_SIDE = "debit_side" ;
	public final static java.lang.String CS_CREDIT_SIDE = "credit_side" ;
	public final static java.lang.String CS_SIMPLIFY_REMARK = "simplify_remark" ;
	public final static java.lang.String CS_VESTING_DATE = "vesting_date" ;
	public final static java.lang.String CS_LOCKED = "locked" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,归属公司,凭证号,凭证内序号,科目类型,科目编码,科目代码,科目名称,借方,贷方,摘要,归属日期,是否锁定";

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

	public java.lang.String getSimplifyRemark() {
		return this.__simplify_remark;
	}

	public void setSimplifyRemark( java.lang.String value ) {
		this.__simplify_remark = value;
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

	public void cloneCopy(BaseInsuranceAndHousingFundK3Voucher __bean){
		__bean.setK3VoucherId(getK3VoucherId());
		__bean.setCompanyId(getCompanyId());
		__bean.setSequenceNumber(getSequenceNumber());
		__bean.setInternalSequenceNumber(getInternalSequenceNumber());
		__bean.setCodeType(getCodeType());
		__bean.setCodeId(getCodeId());
		__bean.setCode(getCode());
		__bean.setName(getName());
		__bean.setDebitSide(getDebitSide());
		__bean.setCreditSide(getCreditSide());
		__bean.setSimplifyRemark(getSimplifyRemark());
		__bean.setVestingDate(getVestingDate());
		__bean.setLocked(getLocked());
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
		sb.append(getDebitSide() == null ? "" : getDebitSide());
		sb.append(",");
		sb.append(getCreditSide() == null ? "" : getCreditSide());
		sb.append(",");
		sb.append(getSimplifyRemark() == null ? "" : getSimplifyRemark());
		sb.append(",");
		sb.append(getVestingDate() == null ? "" : sdf.format(getVestingDate()));
		sb.append(",");
		sb.append(getLocked() == null ? "" : getLocked());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseInsuranceAndHousingFundK3Voucher o) {
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
		hash = 97 * hash + Objects.hashCode(this.__debit_side);
		hash = 97 * hash + Objects.hashCode(this.__credit_side);
		hash = 97 * hash + Objects.hashCode(this.__simplify_remark);
		hash = 97 * hash + Objects.hashCode(this.__vesting_date);
		hash = 97 * hash + Objects.hashCode(this.__locked);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseInsuranceAndHousingFundK3Voucher o = (BaseInsuranceAndHousingFundK3Voucher)obj;
		if(!Objects.equals(this.__k3_voucher_id, o.getK3VoucherId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__sequence_number, o.getSequenceNumber())) return false;
		if(!Objects.equals(this.__internal_sequence_number, o.getInternalSequenceNumber())) return false;
		if(!Objects.equals(this.__code_type, o.getCodeType())) return false;
		if(!Objects.equals(this.__code_id, o.getCodeId())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__debit_side, o.getDebitSide())) return false;
		if(!Objects.equals(this.__credit_side, o.getCreditSide())) return false;
		if(!Objects.equals(this.__simplify_remark, o.getSimplifyRemark())) return false;
		if(!Objects.equals(this.__vesting_date, o.getVestingDate())) return false;
		if(!Objects.equals(this.__locked, o.getLocked())) return false;
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
		if(getDebitSide() != null) sb.append(__wrapDecimal(count++, "debitSide", getDebitSide()));
		if(getCreditSide() != null) sb.append(__wrapDecimal(count++, "creditSide", getCreditSide()));
		if(getSimplifyRemark() != null) sb.append(__wrapString(count++, "simplifyRemark", getSimplifyRemark()));
		if(getVestingDate() != null) sb.append(__wrapDate(count++, "vestingDate", getVestingDate()));
		if(getLocked() != null) sb.append(__wrapBoolean(count++, "locked", getLocked()));
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
		if((val = values.get("debitSide")) != null) setDebitSide(__getDecimal(val));  
		if((val = values.get("creditSide")) != null) setCreditSide(__getDecimal(val));  
		if((val = values.get("simplifyRemark")) != null) setSimplifyRemark(__getString(val));
		if((val = values.get("vestingDate")) != null) setVestingDate(__getDate(val)); 
		if((val = values.get("locked")) != null) setLocked(__getBoolean(val));
	}

	protected java.lang.Integer  __k3_voucher_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __sequence_number ;
	protected java.lang.Integer  __internal_sequence_number ;
	protected java.lang.Integer  __code_type ;
	protected java.lang.Integer  __code_id ;
	protected java.lang.String  __code ;
	protected java.lang.String  __name ;
	protected java.math.BigDecimal  __debit_side ;
	protected java.math.BigDecimal  __credit_side ;
	protected java.lang.String  __simplify_remark ;
	protected java.util.Date  __vesting_date ;
	protected java.lang.Boolean  __locked ;
}
