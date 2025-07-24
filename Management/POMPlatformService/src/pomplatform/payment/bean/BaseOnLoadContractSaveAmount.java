package pomplatform.payment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadContractSaveAmount extends GenericBase implements BaseFactory<BaseOnLoadContractSaveAmount>, Comparable<BaseOnLoadContractSaveAmount> 
{


	public static BaseOnLoadContractSaveAmount newInstance(){
		return new BaseOnLoadContractSaveAmount();
	}

	@Override
	public BaseOnLoadContractSaveAmount make(){
		BaseOnLoadContractSaveAmount b = new BaseOnLoadContractSaveAmount();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_CONTRACT_SAVE = "contract_save" ;

	public final static java.lang.String ALL_CAPTIONS = "板块,年份,合同存量";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.math.BigDecimal getContractSave() {
		return this.__contract_save;
	}

	public void setContractSave( java.math.BigDecimal value ) {
		this.__contract_save = value;
	}

	public void cloneCopy(BaseOnLoadContractSaveAmount __bean){
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setContractSave(getContractSave());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getContractSave() == null ? "" : getContractSave());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadContractSaveAmount o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__contract_save);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadContractSaveAmount o = (BaseOnLoadContractSaveAmount)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__contract_save, o.getContractSave())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getContractSave() != null) sb.append(__wrapDecimal(count++, "contractSave", getContractSave()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("contractSave")) != null) setContractSave(__getDecimal(val));  
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __year ;
	protected java.math.BigDecimal  __contract_save ;
}
