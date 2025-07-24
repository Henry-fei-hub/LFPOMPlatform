package pomplatform.workflow.personnelbusiness.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMakeFileNumber extends GenericBase implements BaseFactory<BaseMakeFileNumber>, Comparable<BaseMakeFileNumber> 
{


	public static BaseMakeFileNumber newInstance(){
		return new BaseMakeFileNumber();
	}

	@Override
	public BaseMakeFileNumber make(){
		BaseMakeFileNumber b = new BaseMakeFileNumber();
		return b;
	}

	public final static java.lang.String CS_FILE_NUMBER_MAX = "file_number_max" ;

	public final static java.lang.String ALL_CAPTIONS = "最大档案号";

	public java.lang.String getFileNumberMax() {
		return this.__file_number_max;
	}

	public void setFileNumberMax( java.lang.String value ) {
		this.__file_number_max = value;
	}

	public void cloneCopy(BaseMakeFileNumber __bean){
		__bean.setFileNumberMax(getFileNumberMax());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFileNumberMax() == null ? "" : getFileNumberMax());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMakeFileNumber o) {
		return __file_number_max == null ? -1 : __file_number_max.compareTo(o.getFileNumberMax());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__file_number_max);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMakeFileNumber o = (BaseMakeFileNumber)obj;
		if(!Objects.equals(this.__file_number_max, o.getFileNumberMax())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFileNumberMax() != null) sb.append(__wrapString(count++, "fileNumberMax", getFileNumberMax()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("fileNumberMax")) != null) setFileNumberMax(__getString(val));
	}

	protected java.lang.String  __file_number_max ;
}
