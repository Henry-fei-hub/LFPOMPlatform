package pomplatform.employee.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetPlateIdByRole extends GenericBase implements BaseFactory<BaseGetPlateIdByRole>, Comparable<BaseGetPlateIdByRole> 
{


	public static BaseGetPlateIdByRole newInstance(){
		return new BaseGetPlateIdByRole();
	}

	@Override
	public BaseGetPlateIdByRole make(){
		BaseGetPlateIdByRole b = new BaseGetPlateIdByRole();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;

	public final static java.lang.String ALL_CAPTIONS = "板块";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public void cloneCopy(BaseGetPlateIdByRole __bean){
		__bean.setPlateId(getPlateId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetPlateIdByRole o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetPlateIdByRole o = (BaseGetPlateIdByRole)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
	}

	protected java.lang.Integer  __plate_id ;
}
