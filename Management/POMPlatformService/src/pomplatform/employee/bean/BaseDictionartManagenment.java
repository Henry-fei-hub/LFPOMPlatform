package pomplatform.employee.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseDictionartManagenment extends GenericBase implements BaseFactory<BaseDictionartManagenment>, Comparable<BaseDictionartManagenment> 
{


	public static BaseDictionartManagenment newInstance(){
		return new BaseDictionartManagenment();
	}

	@Override
	public BaseDictionartManagenment make(){
		BaseDictionartManagenment b = new BaseDictionartManagenment();
		return b;
	}

	public final static java.lang.String CS_DIC_TYPE_ID = "dic_type_id" ;
	public final static java.lang.String CS_DIC_TYPE_NAME = "dic_type_name" ;

	public final static java.lang.String ALL_CAPTIONS = "列表数据代码,列表数据名称";

	public java.lang.Integer getDicTypeId() {
		return this.__dic_type_id;
	}

	public void setDicTypeId( java.lang.Integer value ) {
		this.__dic_type_id = value;
	}

	public java.lang.String getDicTypeName() {
		return this.__dic_type_name;
	}

	public void setDicTypeName( java.lang.String value ) {
		this.__dic_type_name = value;
	}

	public void cloneCopy(BaseDictionartManagenment __bean){
		__bean.setDicTypeId(getDicTypeId());
		__bean.setDicTypeName(getDicTypeName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getDicTypeId() == null ? "" : getDicTypeId());
		sb.append(",");
		sb.append(getDicTypeName() == null ? "" : getDicTypeName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseDictionartManagenment o) {
		return __dic_type_id == null ? -1 : __dic_type_id.compareTo(o.getDicTypeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__dic_type_id);
		hash = 97 * hash + Objects.hashCode(this.__dic_type_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseDictionartManagenment o = (BaseDictionartManagenment)obj;
		if(!Objects.equals(this.__dic_type_id, o.getDicTypeId())) return false;
		if(!Objects.equals(this.__dic_type_name, o.getDicTypeName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDicTypeId() != null) sb.append(__wrapNumber(count++, "dicTypeId", getDicTypeId()));
		if(getDicTypeName() != null) sb.append(__wrapString(count++, "dicTypeName", getDicTypeName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("dicTypeId")) != null) setDicTypeId(__getInt(val)); 
		if((val = values.get("dicTypeName")) != null) setDicTypeName(__getString(val));
	}

	protected java.lang.Integer  __dic_type_id ;
	protected java.lang.String  __dic_type_name ;
}
