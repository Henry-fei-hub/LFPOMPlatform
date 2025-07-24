package pomplatform.preProjects.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMainProjectCompetitionInfo extends GenericBase implements BaseFactory<BaseMainProjectCompetitionInfo>, Comparable<BaseMainProjectCompetitionInfo> 
{


	public static BaseMainProjectCompetitionInfo newInstance(){
		return new BaseMainProjectCompetitionInfo();
	}

	@Override
	public BaseMainProjectCompetitionInfo make(){
		BaseMainProjectCompetitionInfo b = new BaseMainProjectCompetitionInfo();
		return b;
	}

	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_ADDRESS = "address" ;

	public final static java.lang.String ALL_CAPTIONS = "名称,地址";

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.lang.String getAddress() {
		return this.__address;
	}

	public void setAddress( java.lang.String value ) {
		this.__address = value;
	}

	public void cloneCopy(BaseMainProjectCompetitionInfo __bean){
		__bean.setName(getName());
		__bean.setAddress(getAddress());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getAddress() == null ? "" : getAddress());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMainProjectCompetitionInfo o) {
		return __name == null ? -1 : __name.compareTo(o.getName());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__address);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMainProjectCompetitionInfo o = (BaseMainProjectCompetitionInfo)obj;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__address, o.getAddress())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getAddress() != null) sb.append(__wrapString(count++, "address", getAddress()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("address")) != null) setAddress(__getString(val));
	}

	protected java.lang.String  __name ;
	protected java.lang.String  __address ;
}
