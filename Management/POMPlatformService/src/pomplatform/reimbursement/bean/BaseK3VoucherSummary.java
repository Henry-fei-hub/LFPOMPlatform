package pomplatform.reimbursement.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseK3VoucherSummary extends GenericBase implements BaseFactory<BaseK3VoucherSummary>, Comparable<BaseK3VoucherSummary> 
{


	public static BaseK3VoucherSummary newInstance(){
		return new BaseK3VoucherSummary();
	}

	@Override
	public BaseK3VoucherSummary make(){
		BaseK3VoucherSummary b = new BaseK3VoucherSummary();
		return b;
	}

	public final static java.lang.String CS_REIMBURSEMENT_PACKAGE_CODE = "reimbursement_package_code" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_DEBIT_SIDE = "debit_side" ;
	public final static java.lang.String CS_CREDIT_SIDE = "credit_side" ;
	public final static java.lang.String CS_VESTING_DATE = "vesting_date" ;
	public final static java.lang.String CS_LOCKED = "locked" ;

	public final static java.lang.String ALL_CAPTIONS = "报销汇总编号,归属公司,借方,贷方,归属日期,是否定稿";

	public java.lang.String getReimbursementPackageCode() {
		return this.__reimbursement_package_code;
	}

	public void setReimbursementPackageCode( java.lang.String value ) {
		this.__reimbursement_package_code = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
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

	public void cloneCopy(BaseK3VoucherSummary __bean){
		__bean.setReimbursementPackageCode(getReimbursementPackageCode());
		__bean.setCompanyId(getCompanyId());
		__bean.setDebitSide(getDebitSide());
		__bean.setCreditSide(getCreditSide());
		__bean.setVestingDate(getVestingDate());
		__bean.setLocked(getLocked());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getReimbursementPackageCode() == null ? "" : getReimbursementPackageCode());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getDebitSide() == null ? "" : getDebitSide());
		sb.append(",");
		sb.append(getCreditSide() == null ? "" : getCreditSide());
		sb.append(",");
		sb.append(getVestingDate() == null ? "" : sdf.format(getVestingDate()));
		sb.append(",");
		sb.append(getLocked() == null ? "" : getLocked());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseK3VoucherSummary o) {
		return __reimbursement_package_code == null ? -1 : __reimbursement_package_code.compareTo(o.getReimbursementPackageCode());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_package_code);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__debit_side);
		hash = 97 * hash + Objects.hashCode(this.__credit_side);
		hash = 97 * hash + Objects.hashCode(this.__vesting_date);
		hash = 97 * hash + Objects.hashCode(this.__locked);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseK3VoucherSummary o = (BaseK3VoucherSummary)obj;
		if(!Objects.equals(this.__reimbursement_package_code, o.getReimbursementPackageCode())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__debit_side, o.getDebitSide())) return false;
		if(!Objects.equals(this.__credit_side, o.getCreditSide())) return false;
		if(!Objects.equals(this.__vesting_date, o.getVestingDate())) return false;
		if(!Objects.equals(this.__locked, o.getLocked())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getReimbursementPackageCode() != null) sb.append(__wrapString(count++, "reimbursementPackageCode", getReimbursementPackageCode()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getDebitSide() != null) sb.append(__wrapDecimal(count++, "debitSide", getDebitSide()));
		if(getCreditSide() != null) sb.append(__wrapDecimal(count++, "creditSide", getCreditSide()));
		if(getVestingDate() != null) sb.append(__wrapDate(count++, "vestingDate", getVestingDate()));
		if(getLocked() != null) sb.append(__wrapBoolean(count++, "locked", getLocked()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("reimbursementPackageCode")) != null) setReimbursementPackageCode(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("debitSide")) != null) setDebitSide(__getDecimal(val));  
		if((val = values.get("creditSide")) != null) setCreditSide(__getDecimal(val));  
		if((val = values.get("vestingDate")) != null) setVestingDate(__getDate(val)); 
		if((val = values.get("locked")) != null) setLocked(__getBoolean(val));
	}

	protected java.lang.String  __reimbursement_package_code ;
	protected java.lang.Integer  __company_id ;
	protected java.math.BigDecimal  __debit_side ;
	protected java.math.BigDecimal  __credit_side ;
	protected java.util.Date  __vesting_date ;
	protected java.lang.Boolean  __locked ;
}
