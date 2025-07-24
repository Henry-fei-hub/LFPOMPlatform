package pomplatform.revenueStatistical.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasecontractSaveAnalyze extends GenericBase implements BaseFactory<BasecontractSaveAnalyze>, Comparable<BasecontractSaveAnalyze> 
{


	public static BasecontractSaveAnalyze newInstance(){
		return new BasecontractSaveAnalyze();
	}

	@Override
	public BasecontractSaveAnalyze make(){
		BasecontractSaveAnalyze b = new BasecontractSaveAnalyze();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_JANUARY_CONTRACT_SAVE = "january_contract_save" ;
	public final static java.lang.String CS_FEBRUARY_CONTRACT_SAVE = "february_contract_save" ;
	public final static java.lang.String CS_MARCH_CONTRACT_SAVE = "march_contract_save" ;
	public final static java.lang.String CS_APRIL_CONTRACT_SAVE = "april_contract_save" ;
	public final static java.lang.String CS_MAY_CONTRACT_SAVE = "may_contract_save" ;
	public final static java.lang.String CS_JUNE_CONTRACT_SAVE = "june_contract_save" ;
	public final static java.lang.String CS_JULY_CONTRACT_SAVE = "july_contract_save" ;
	public final static java.lang.String CS_AUGUST_CONTRACT_SAVE = "august_contract_save" ;
	public final static java.lang.String CS_SEPTEMBER_CONTRACT_SAVE = "september_contract_save" ;
	public final static java.lang.String CS_OCTOBER_CONTRACT_SAVE = "october_contract_save" ;
	public final static java.lang.String CS_NOVEMBER_CONTRACT_SAVE = "november_contract_save" ;
	public final static java.lang.String CS_DECEMBER_CONTRACT_SAVE = "december_contract_save" ;
	public final static java.lang.String CS_TOTAL = "total" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,年份,一月,二月,三月,四月,五月,六月,七月,八月,九月,十月,十一月,十二月,合计";

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

	public java.math.BigDecimal getJanuaryContractSave() {
		return this.__january_contract_save;
	}

	public void setJanuaryContractSave( java.math.BigDecimal value ) {
		this.__january_contract_save = value;
	}

	public java.math.BigDecimal getFebruaryContractSave() {
		return this.__february_contract_save;
	}

	public void setFebruaryContractSave( java.math.BigDecimal value ) {
		this.__february_contract_save = value;
	}

	public java.math.BigDecimal getMarchContractSave() {
		return this.__march_contract_save;
	}

	public void setMarchContractSave( java.math.BigDecimal value ) {
		this.__march_contract_save = value;
	}

	public java.math.BigDecimal getAprilContractSave() {
		return this.__april_contract_save;
	}

	public void setAprilContractSave( java.math.BigDecimal value ) {
		this.__april_contract_save = value;
	}

	public java.math.BigDecimal getMayContractSave() {
		return this.__may_contract_save;
	}

	public void setMayContractSave( java.math.BigDecimal value ) {
		this.__may_contract_save = value;
	}

	public java.math.BigDecimal getJuneContractSave() {
		return this.__june_contract_save;
	}

	public void setJuneContractSave( java.math.BigDecimal value ) {
		this.__june_contract_save = value;
	}

	public java.math.BigDecimal getJulyContractSave() {
		return this.__july_contract_save;
	}

	public void setJulyContractSave( java.math.BigDecimal value ) {
		this.__july_contract_save = value;
	}

	public java.math.BigDecimal getAugustContractSave() {
		return this.__august_contract_save;
	}

	public void setAugustContractSave( java.math.BigDecimal value ) {
		this.__august_contract_save = value;
	}

	public java.math.BigDecimal getSeptemberContractSave() {
		return this.__september_contract_save;
	}

	public void setSeptemberContractSave( java.math.BigDecimal value ) {
		this.__september_contract_save = value;
	}

	public java.math.BigDecimal getOctoberContractSave() {
		return this.__october_contract_save;
	}

	public void setOctoberContractSave( java.math.BigDecimal value ) {
		this.__october_contract_save = value;
	}

	public java.math.BigDecimal getNovemberContractSave() {
		return this.__november_contract_save;
	}

	public void setNovemberContractSave( java.math.BigDecimal value ) {
		this.__november_contract_save = value;
	}

	public java.math.BigDecimal getDecemberContractSave() {
		return this.__december_contract_save;
	}

	public void setDecemberContractSave( java.math.BigDecimal value ) {
		this.__december_contract_save = value;
	}

	public java.math.BigDecimal getTotal() {
		return this.__total;
	}

	public void setTotal( java.math.BigDecimal value ) {
		this.__total = value;
	}

	public void cloneCopy(BasecontractSaveAnalyze __bean){
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setJanuaryContractSave(getJanuaryContractSave());
		__bean.setFebruaryContractSave(getFebruaryContractSave());
		__bean.setMarchContractSave(getMarchContractSave());
		__bean.setAprilContractSave(getAprilContractSave());
		__bean.setMayContractSave(getMayContractSave());
		__bean.setJuneContractSave(getJuneContractSave());
		__bean.setJulyContractSave(getJulyContractSave());
		__bean.setAugustContractSave(getAugustContractSave());
		__bean.setSeptemberContractSave(getSeptemberContractSave());
		__bean.setOctoberContractSave(getOctoberContractSave());
		__bean.setNovemberContractSave(getNovemberContractSave());
		__bean.setDecemberContractSave(getDecemberContractSave());
		__bean.setTotal(getTotal());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getJanuaryContractSave() == null ? "" : getJanuaryContractSave());
		sb.append(",");
		sb.append(getFebruaryContractSave() == null ? "" : getFebruaryContractSave());
		sb.append(",");
		sb.append(getMarchContractSave() == null ? "" : getMarchContractSave());
		sb.append(",");
		sb.append(getAprilContractSave() == null ? "" : getAprilContractSave());
		sb.append(",");
		sb.append(getMayContractSave() == null ? "" : getMayContractSave());
		sb.append(",");
		sb.append(getJuneContractSave() == null ? "" : getJuneContractSave());
		sb.append(",");
		sb.append(getJulyContractSave() == null ? "" : getJulyContractSave());
		sb.append(",");
		sb.append(getAugustContractSave() == null ? "" : getAugustContractSave());
		sb.append(",");
		sb.append(getSeptemberContractSave() == null ? "" : getSeptemberContractSave());
		sb.append(",");
		sb.append(getOctoberContractSave() == null ? "" : getOctoberContractSave());
		sb.append(",");
		sb.append(getNovemberContractSave() == null ? "" : getNovemberContractSave());
		sb.append(",");
		sb.append(getDecemberContractSave() == null ? "" : getDecemberContractSave());
		sb.append(",");
		sb.append(getTotal() == null ? "" : getTotal());
		return sb.toString();
	}

	@Override
	public int compareTo(BasecontractSaveAnalyze o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__january_contract_save);
		hash = 97 * hash + Objects.hashCode(this.__february_contract_save);
		hash = 97 * hash + Objects.hashCode(this.__march_contract_save);
		hash = 97 * hash + Objects.hashCode(this.__april_contract_save);
		hash = 97 * hash + Objects.hashCode(this.__may_contract_save);
		hash = 97 * hash + Objects.hashCode(this.__june_contract_save);
		hash = 97 * hash + Objects.hashCode(this.__july_contract_save);
		hash = 97 * hash + Objects.hashCode(this.__august_contract_save);
		hash = 97 * hash + Objects.hashCode(this.__september_contract_save);
		hash = 97 * hash + Objects.hashCode(this.__october_contract_save);
		hash = 97 * hash + Objects.hashCode(this.__november_contract_save);
		hash = 97 * hash + Objects.hashCode(this.__december_contract_save);
		hash = 97 * hash + Objects.hashCode(this.__total);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasecontractSaveAnalyze o = (BasecontractSaveAnalyze)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__january_contract_save, o.getJanuaryContractSave())) return false;
		if(!Objects.equals(this.__february_contract_save, o.getFebruaryContractSave())) return false;
		if(!Objects.equals(this.__march_contract_save, o.getMarchContractSave())) return false;
		if(!Objects.equals(this.__april_contract_save, o.getAprilContractSave())) return false;
		if(!Objects.equals(this.__may_contract_save, o.getMayContractSave())) return false;
		if(!Objects.equals(this.__june_contract_save, o.getJuneContractSave())) return false;
		if(!Objects.equals(this.__july_contract_save, o.getJulyContractSave())) return false;
		if(!Objects.equals(this.__august_contract_save, o.getAugustContractSave())) return false;
		if(!Objects.equals(this.__september_contract_save, o.getSeptemberContractSave())) return false;
		if(!Objects.equals(this.__october_contract_save, o.getOctoberContractSave())) return false;
		if(!Objects.equals(this.__november_contract_save, o.getNovemberContractSave())) return false;
		if(!Objects.equals(this.__december_contract_save, o.getDecemberContractSave())) return false;
		if(!Objects.equals(this.__total, o.getTotal())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getJanuaryContractSave() != null) sb.append(__wrapDecimal(count++, "januaryContractSave", getJanuaryContractSave()));
		if(getFebruaryContractSave() != null) sb.append(__wrapDecimal(count++, "februaryContractSave", getFebruaryContractSave()));
		if(getMarchContractSave() != null) sb.append(__wrapDecimal(count++, "marchContractSave", getMarchContractSave()));
		if(getAprilContractSave() != null) sb.append(__wrapDecimal(count++, "aprilContractSave", getAprilContractSave()));
		if(getMayContractSave() != null) sb.append(__wrapDecimal(count++, "mayContractSave", getMayContractSave()));
		if(getJuneContractSave() != null) sb.append(__wrapDecimal(count++, "juneContractSave", getJuneContractSave()));
		if(getJulyContractSave() != null) sb.append(__wrapDecimal(count++, "julyContractSave", getJulyContractSave()));
		if(getAugustContractSave() != null) sb.append(__wrapDecimal(count++, "augustContractSave", getAugustContractSave()));
		if(getSeptemberContractSave() != null) sb.append(__wrapDecimal(count++, "septemberContractSave", getSeptemberContractSave()));
		if(getOctoberContractSave() != null) sb.append(__wrapDecimal(count++, "octoberContractSave", getOctoberContractSave()));
		if(getNovemberContractSave() != null) sb.append(__wrapDecimal(count++, "novemberContractSave", getNovemberContractSave()));
		if(getDecemberContractSave() != null) sb.append(__wrapDecimal(count++, "decemberContractSave", getDecemberContractSave()));
		if(getTotal() != null) sb.append(__wrapDecimal(count++, "total", getTotal()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("januaryContractSave")) != null) setJanuaryContractSave(__getDecimal(val));  
		if((val = values.get("februaryContractSave")) != null) setFebruaryContractSave(__getDecimal(val));  
		if((val = values.get("marchContractSave")) != null) setMarchContractSave(__getDecimal(val));  
		if((val = values.get("aprilContractSave")) != null) setAprilContractSave(__getDecimal(val));  
		if((val = values.get("mayContractSave")) != null) setMayContractSave(__getDecimal(val));  
		if((val = values.get("juneContractSave")) != null) setJuneContractSave(__getDecimal(val));  
		if((val = values.get("julyContractSave")) != null) setJulyContractSave(__getDecimal(val));  
		if((val = values.get("augustContractSave")) != null) setAugustContractSave(__getDecimal(val));  
		if((val = values.get("septemberContractSave")) != null) setSeptemberContractSave(__getDecimal(val));  
		if((val = values.get("octoberContractSave")) != null) setOctoberContractSave(__getDecimal(val));  
		if((val = values.get("novemberContractSave")) != null) setNovemberContractSave(__getDecimal(val));  
		if((val = values.get("decemberContractSave")) != null) setDecemberContractSave(__getDecimal(val));  
		if((val = values.get("total")) != null) setTotal(__getDecimal(val));  
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __year ;
	protected java.math.BigDecimal  __january_contract_save ;
	protected java.math.BigDecimal  __february_contract_save ;
	protected java.math.BigDecimal  __march_contract_save ;
	protected java.math.BigDecimal  __april_contract_save ;
	protected java.math.BigDecimal  __may_contract_save ;
	protected java.math.BigDecimal  __june_contract_save ;
	protected java.math.BigDecimal  __july_contract_save ;
	protected java.math.BigDecimal  __august_contract_save ;
	protected java.math.BigDecimal  __september_contract_save ;
	protected java.math.BigDecimal  __october_contract_save ;
	protected java.math.BigDecimal  __november_contract_save ;
	protected java.math.BigDecimal  __december_contract_save ;
	protected java.math.BigDecimal  __total ;
}
