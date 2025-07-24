package pomplatform.workflow.personnelbusiness.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMakeEmployeeNo extends GenericBase implements BaseFactory<BaseMakeEmployeeNo>, Comparable<BaseMakeEmployeeNo> 
{


	public static BaseMakeEmployeeNo newInstance(){
		return new BaseMakeEmployeeNo();
	}

	@Override
	public BaseMakeEmployeeNo make(){
		BaseMakeEmployeeNo b = new BaseMakeEmployeeNo();
		return b;
	}

	public final static java.lang.String CS_COMPANY_CODE = "company_code" ;
	public final static java.lang.String CS_PLATE_CODE = "plate_code" ;
	public final static java.lang.String CS_NUM = "num" ;

	public final static java.lang.String ALL_CAPTIONS = "公司代码,业务部门编码,编号";

	public java.lang.String getCompanyCode() {
		return this.__company_code;
	}

	public void setCompanyCode( java.lang.String value ) {
		this.__company_code = value;
	}

	public java.lang.String getPlateCode() {
		return this.__plate_code;
	}

	public void setPlateCode( java.lang.String value ) {
		this.__plate_code = value;
	}

	public java.lang.String getNum() {
		return this.__num;
	}

	public void setNum( java.lang.String value ) {
		this.__num = value;
	}

	public void cloneCopy(BaseMakeEmployeeNo __bean){
		__bean.setCompanyCode(getCompanyCode());
		__bean.setPlateCode(getPlateCode());
		__bean.setNum(getNum());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCompanyCode() == null ? "" : getCompanyCode());
		sb.append(",");
		sb.append(getPlateCode() == null ? "" : getPlateCode());
		sb.append(",");
		sb.append(getNum() == null ? "" : getNum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMakeEmployeeNo o) {
		return __company_code == null ? -1 : __company_code.compareTo(o.getCompanyCode());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__company_code);
		hash = 97 * hash + Objects.hashCode(this.__plate_code);
		hash = 97 * hash + Objects.hashCode(this.__num);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMakeEmployeeNo o = (BaseMakeEmployeeNo)obj;
		if(!Objects.equals(this.__company_code, o.getCompanyCode())) return false;
		if(!Objects.equals(this.__plate_code, o.getPlateCode())) return false;
		if(!Objects.equals(this.__num, o.getNum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompanyCode() != null) sb.append(__wrapString(count++, "companyCode", getCompanyCode()));
		if(getPlateCode() != null) sb.append(__wrapString(count++, "plateCode", getPlateCode()));
		if(getNum() != null) sb.append(__wrapString(count++, "num", getNum()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("companyCode")) != null) setCompanyCode(__getString(val));
		if((val = values.get("plateCode")) != null) setPlateCode(__getString(val));
		if((val = values.get("num")) != null) setNum(__getString(val));
	}

	protected java.lang.String  __company_code ;
	protected java.lang.String  __plate_code ;
	protected java.lang.String  __num ;
}
