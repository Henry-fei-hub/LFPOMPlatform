package pomplatform.k3code.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseDepartmentK3Code extends GenericBase implements BaseFactory<BaseDepartmentK3Code>, Comparable<BaseDepartmentK3Code> 
{


	public static BaseDepartmentK3Code newInstance(){
		return new BaseDepartmentK3Code();
	}

	@Override
	public BaseDepartmentK3Code make(){
		BaseDepartmentK3Code b = new BaseDepartmentK3Code();
		return b;
	}

	public final static java.lang.String CS_K3_CODE_ID = "k3_code_id" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_K3_CODE = "k3_code" ;
	public final static java.lang.String CS_K3_NAME = "k3_name" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码, 7收款方类型,部门,K3代码,K3名称";

	public java.lang.Integer getK3CodeId() {
		return this.__k3_code_id;
	}

	public void setK3CodeId( java.lang.Integer value ) {
		this.__k3_code_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
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

	public void cloneCopy(BaseDepartmentK3Code __bean){
		__bean.setK3CodeId(getK3CodeId());
		__bean.setType(getType());
		__bean.setBusinessId(getBusinessId());
		__bean.setK3Code(getK3Code());
		__bean.setK3Name(getK3Name());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getK3CodeId() == null ? "" : getK3CodeId());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		String strBusinessId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getBusinessId()));
		sb.append(strBusinessId == null ? "" : strBusinessId);
		sb.append(",");
		sb.append(getK3Code() == null ? "" : getK3Code());
		sb.append(",");
		sb.append(getK3Name() == null ? "" : getK3Name());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseDepartmentK3Code o) {
		return __k3_code_id == null ? -1 : __k3_code_id.compareTo(o.getK3CodeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__k3_code_id);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__k3_code);
		hash = 97 * hash + Objects.hashCode(this.__k3_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseDepartmentK3Code o = (BaseDepartmentK3Code)obj;
		if(!Objects.equals(this.__k3_code_id, o.getK3CodeId())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__k3_code, o.getK3Code())) return false;
		if(!Objects.equals(this.__k3_name, o.getK3Name())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getK3CodeId() != null) sb.append(__wrapNumber(count++, "k3CodeId", getK3CodeId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getK3Code() != null) sb.append(__wrapString(count++, "k3Code", getK3Code()));
		if(getK3Name() != null) sb.append(__wrapString(count++, "k3Name", getK3Name()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("k3CodeId")) != null) setK3CodeId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("k3Code")) != null) setK3Code(__getString(val));
		if((val = values.get("k3Name")) != null) setK3Name(__getString(val));
	}

	protected java.lang.Integer  __k3_code_id ;
	protected java.lang.Integer  __type ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.String  __k3_code ;
	protected java.lang.String  __k3_name ;
}
