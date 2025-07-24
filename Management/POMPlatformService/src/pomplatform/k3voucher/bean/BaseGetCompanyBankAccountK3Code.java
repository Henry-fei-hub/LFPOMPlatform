package pomplatform.k3voucher.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetCompanyBankAccountK3Code extends GenericBase implements BaseFactory<BaseGetCompanyBankAccountK3Code>, Comparable<BaseGetCompanyBankAccountK3Code> 
{


	public static BaseGetCompanyBankAccountK3Code newInstance(){
		return new BaseGetCompanyBankAccountK3Code();
	}

	@Override
	public BaseGetCompanyBankAccountK3Code make(){
		BaseGetCompanyBankAccountK3Code b = new BaseGetCompanyBankAccountK3Code();
		return b;
	}

	public final static java.lang.String CS_BANK_ACCOUNT = "bank_account" ;
	public final static java.lang.String CS_OBJECT_ID = "object_id" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_K3_CODE_ID = "k3_code_id" ;
	public final static java.lang.String CS_K3_CODE = "k3_code" ;
	public final static java.lang.String CS_K3_NAME = "k3_name" ;

	public final static java.lang.String ALL_CAPTIONS = "银行账号,公司ID,K3代码类型,主键编码,K3编号,K3名称";

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.Integer getObjectId() {
		return this.__object_id;
	}

	public void setObjectId( java.lang.Integer value ) {
		this.__object_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.Integer getK3CodeId() {
		return this.__k3_code_id;
	}

	public void setK3CodeId( java.lang.Integer value ) {
		this.__k3_code_id = value;
	}

	public java.lang.String getK3Code() {
		return this.__k3_code;
	}

	public void setK3Code( java.lang.String value ) {
		this.__k3_code = value;
	}

	public java.lang.String getK3Name() {
		return this.__k3_name;
	}

	public void setK3Name( java.lang.String value ) {
		this.__k3_name = value;
	}

	public void cloneCopy(BaseGetCompanyBankAccountK3Code __bean){
		__bean.setBankAccount(getBankAccount());
		__bean.setObjectId(getObjectId());
		__bean.setType(getType());
		__bean.setK3CodeId(getK3CodeId());
		__bean.setK3Code(getK3Code());
		__bean.setK3Name(getK3Name());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBankAccount() == null ? "" : getBankAccount());
		sb.append(",");
		sb.append(getObjectId() == null ? "" : getObjectId());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getK3CodeId() == null ? "" : getK3CodeId());
		sb.append(",");
		sb.append(getK3Code() == null ? "" : getK3Code());
		sb.append(",");
		sb.append(getK3Name() == null ? "" : getK3Name());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetCompanyBankAccountK3Code o) {
		return __k3_code_id == null ? -1 : __k3_code_id.compareTo(o.getK3CodeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__bank_account);
		hash = 97 * hash + Objects.hashCode(this.__object_id);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__k3_code_id);
		hash = 97 * hash + Objects.hashCode(this.__k3_code);
		hash = 97 * hash + Objects.hashCode(this.__k3_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetCompanyBankAccountK3Code o = (BaseGetCompanyBankAccountK3Code)obj;
		if(!Objects.equals(this.__bank_account, o.getBankAccount())) return false;
		if(!Objects.equals(this.__object_id, o.getObjectId())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__k3_code_id, o.getK3CodeId())) return false;
		if(!Objects.equals(this.__k3_code, o.getK3Code())) return false;
		if(!Objects.equals(this.__k3_name, o.getK3Name())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBankAccount() != null) sb.append(__wrapString(count++, "bankAccount", getBankAccount()));
		if(getObjectId() != null) sb.append(__wrapNumber(count++, "objectId", getObjectId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getK3CodeId() != null) sb.append(__wrapNumber(count++, "k3CodeId", getK3CodeId()));
		if(getK3Code() != null) sb.append(__wrapString(count++, "k3Code", getK3Code()));
		if(getK3Name() != null) sb.append(__wrapString(count++, "k3Name", getK3Name()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getBankAccount() != null) res.put("bankAccount", getBankAccount());
		if(getObjectId() != null) res.put("objectId", getObjectId());
		if(getType() != null) res.put("type", getType());
		if(getK3CodeId() != null) res.put("k3CodeId", getK3CodeId());
		if(getK3Code() != null) res.put("k3Code", getK3Code());
		if(getK3Name() != null) res.put("k3Name", getK3Name());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("objectId")) != null) setObjectId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("k3CodeId")) != null) setK3CodeId(__getInt(val)); 
		if((val = values.get("k3Code")) != null) setK3Code(__getString(val));
		if((val = values.get("k3Name")) != null) setK3Name(__getString(val));
	}

	protected java.lang.String  __bank_account ;
	protected java.lang.Integer  __object_id ;
	protected java.lang.Integer  __type ;
	protected java.lang.Integer  __k3_code_id ;
	protected java.lang.String  __k3_code ;
	protected java.lang.String  __k3_name ;
}
