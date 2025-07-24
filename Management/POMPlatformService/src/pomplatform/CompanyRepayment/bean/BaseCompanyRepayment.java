package pomplatform.CompanyRepayment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCompanyRepayment extends GenericBase implements BaseFactory<BaseCompanyRepayment>, Comparable<BaseCompanyRepayment> 
{


	public static BaseCompanyRepayment newInstance(){
		return new BaseCompanyRepayment();
	}

	@Override
	public BaseCompanyRepayment make(){
		BaseCompanyRepayment b = new BaseCompanyRepayment();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PLATE_OF_ARREARS = "plate_of_arrears" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,部门欠款";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getPlateOfArrears() {
		return this.__plate_of_arrears;
	}

	public void setPlateOfArrears( java.math.BigDecimal value ) {
		this.__plate_of_arrears = value;
	}

	public void cloneCopy(BaseCompanyRepayment __bean){
		__bean.setPlateId(getPlateId());
		__bean.setPlateOfArrears(getPlateOfArrears());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getPlateOfArrears() == null ? "" : getPlateOfArrears());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCompanyRepayment o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_of_arrears);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCompanyRepayment o = (BaseCompanyRepayment)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__plate_of_arrears, o.getPlateOfArrears())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getPlateOfArrears() != null) sb.append(__wrapDecimal(count++, "plateOfArrears", getPlateOfArrears()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("plateOfArrears")) != null) setPlateOfArrears(__getDecimal(val));  
	}

	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __plate_of_arrears ;
}
