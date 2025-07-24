package pomplatform.k3voucher.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAllVoucherSummary extends GenericBase implements BaseFactory<BaseAllVoucherSummary>, Comparable<BaseAllVoucherSummary> 
{


	public static BaseAllVoucherSummary newInstance(){
		return new BaseAllVoucherSummary();
	}

	@Override
	public BaseAllVoucherSummary make(){
		BaseAllVoucherSummary b = new BaseAllVoucherSummary();
		return b;
	}

	public final static java.lang.String CS_VOUCHER_TYPE = "voucher_type" ;
	public final static java.lang.String CS_REIMBURSEMENT_PACKAGE_CODE = "reimbursement_package_code" ;
	public final static java.lang.String CS_REIMBURSEMENT_PACKAGE_ID = "reimbursement_package_id" ;
	public final static java.lang.String CS_VESTING_DATE = "vesting_date" ;
	public final static java.lang.String CS_SEQUENCE_NUMBER = "sequence_number" ;
	public final static java.lang.String CS_LOCKED = "locked" ;

	public final static java.lang.String ALL_CAPTIONS = "凭证类型,编号,报销汇总单主表编码,归属日期,凭证号,是否锁定";

	public java.lang.Integer getVoucherType() {
		return this.__voucher_type;
	}

	public void setVoucherType( java.lang.Integer value ) {
		this.__voucher_type = value;
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

	public java.util.Date getVestingDate() {
		return this.__vesting_date;
	}

	public void setVestingDate( java.util.Date value ) {
		this.__vesting_date = value;
	}

	public java.lang.Integer getSequenceNumber() {
		return this.__sequence_number;
	}

	public void setSequenceNumber( java.lang.Integer value ) {
		this.__sequence_number = value;
	}

	public java.lang.Boolean getLocked() {
		return this.__locked;
	}

	public void setLocked( java.lang.Boolean value ) {
		this.__locked = value;
	}

	public void cloneCopy(BaseAllVoucherSummary __bean){
		__bean.setVoucherType(getVoucherType());
		__bean.setReimbursementPackageCode(getReimbursementPackageCode());
		__bean.setReimbursementPackageId(getReimbursementPackageId());
		__bean.setVestingDate(getVestingDate());
		__bean.setSequenceNumber(getSequenceNumber());
		__bean.setLocked(getLocked());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strVoucherType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_117", String.valueOf(getVoucherType()));
		sb.append(strVoucherType == null ? "" : strVoucherType);
		sb.append(",");
		sb.append(getReimbursementPackageCode() == null ? "" : getReimbursementPackageCode());
		sb.append(",");
		sb.append(getReimbursementPackageId() == null ? "" : getReimbursementPackageId());
		sb.append(",");
		sb.append(getVestingDate() == null ? "" : sdf.format(getVestingDate()));
		sb.append(",");
		sb.append(getSequenceNumber() == null ? "" : getSequenceNumber());
		sb.append(",");
		sb.append(getLocked() == null ? "" : getLocked());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAllVoucherSummary o) {
		return __voucher_type == null ? -1 : __voucher_type.compareTo(o.getVoucherType());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__voucher_type);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_package_code);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_package_id);
		hash = 97 * hash + Objects.hashCode(this.__vesting_date);
		hash = 97 * hash + Objects.hashCode(this.__sequence_number);
		hash = 97 * hash + Objects.hashCode(this.__locked);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAllVoucherSummary o = (BaseAllVoucherSummary)obj;
		if(!Objects.equals(this.__voucher_type, o.getVoucherType())) return false;
		if(!Objects.equals(this.__reimbursement_package_code, o.getReimbursementPackageCode())) return false;
		if(!Objects.equals(this.__reimbursement_package_id, o.getReimbursementPackageId())) return false;
		if(!Objects.equals(this.__vesting_date, o.getVestingDate())) return false;
		if(!Objects.equals(this.__sequence_number, o.getSequenceNumber())) return false;
		if(!Objects.equals(this.__locked, o.getLocked())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getVoucherType() != null) sb.append(__wrapNumber(count++, "voucherType", getVoucherType()));
		if(getReimbursementPackageCode() != null) sb.append(__wrapString(count++, "reimbursementPackageCode", getReimbursementPackageCode()));
		if(getReimbursementPackageId() != null) sb.append(__wrapNumber(count++, "reimbursementPackageId", getReimbursementPackageId()));
		if(getVestingDate() != null) sb.append(__wrapDate(count++, "vestingDate", getVestingDate()));
		if(getSequenceNumber() != null) sb.append(__wrapNumber(count++, "sequenceNumber", getSequenceNumber()));
		if(getLocked() != null) sb.append(__wrapBoolean(count++, "locked", getLocked()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("voucherType")) != null) setVoucherType(__getInt(val)); 
		if((val = values.get("reimbursementPackageCode")) != null) setReimbursementPackageCode(__getString(val));
		if((val = values.get("reimbursementPackageId")) != null) setReimbursementPackageId(__getInt(val)); 
		if((val = values.get("vestingDate")) != null) setVestingDate(__getDate(val)); 
		if((val = values.get("sequenceNumber")) != null) setSequenceNumber(__getInt(val)); 
		if((val = values.get("locked")) != null) setLocked(__getBoolean(val));
	}

	protected java.lang.Integer  __voucher_type ;
	protected java.lang.String  __reimbursement_package_code ;
	protected java.lang.Integer  __reimbursement_package_id ;
	protected java.util.Date  __vesting_date ;
	protected java.lang.Integer  __sequence_number ;
	protected java.lang.Boolean  __locked ;
}
