package pomplatform.employee.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMemployeeereor extends GenericBase implements BaseFactory<BaseMemployeeereor>, Comparable<BaseMemployeeereor> 
{


	public static BaseMemployeeereor newInstance(){
		return new BaseMemployeeereor();
	}

	@Override
	public BaseMemployeeereor make(){
		BaseMemployeeereor b = new BaseMemployeeereor();
		return b;
	}

	public final static java.lang.String CS_FUNCTION_CODE = "function_code" ;

	public final static java.lang.String ALL_CAPTIONS = "功能编码";

	public java.lang.String getFunctionCode() {
		return this.__function_code;
	}

	public void setFunctionCode( java.lang.String value ) {
		this.__function_code = value;
	}

	public void cloneCopy(BaseMemployeeereor __bean){
		__bean.setFunctionCode(getFunctionCode());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFunctionCode() == null ? "" : getFunctionCode());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMemployeeereor o) {
		return __function_code == null ? -1 : __function_code.compareTo(o.getFunctionCode());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__function_code);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMemployeeereor o = (BaseMemployeeereor)obj;
		if(!Objects.equals(this.__function_code, o.getFunctionCode())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFunctionCode() != null) sb.append(__wrapString(count++, "functionCode", getFunctionCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("functionCode")) != null) setFunctionCode(__getString(val));
	}

	protected java.lang.String  __function_code ;
}
