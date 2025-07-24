package pomplatform.contract.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseContractAmountAnalyze extends GenericBase implements BaseFactory<BaseContractAmountAnalyze>, Comparable<BaseContractAmountAnalyze> 
{


	public static BaseContractAmountAnalyze newInstance(){
		return new BaseContractAmountAnalyze();
	}

	@Override
	public BaseContractAmountAnalyze make(){
		BaseContractAmountAnalyze b = new BaseContractAmountAnalyze();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_CONTRACT_YEAR = "contract_year" ;
	public final static java.lang.String CS_JAN_AMOUNT = "jan_amount" ;
	public final static java.lang.String CS_FEB_AMOUNT = "feb_amount" ;
	public final static java.lang.String CS_MAR_AMOUNT = "mar_amount" ;
	public final static java.lang.String CS_APR_AMOUNT = "apr_amount" ;
	public final static java.lang.String CS_MAY_AMOUNT = "may_amount" ;
	public final static java.lang.String CS_JUN_AMOUNT = "jun_amount" ;
	public final static java.lang.String CS_JUL_AMOUNT = "jul_amount" ;
	public final static java.lang.String CS_AUG_AMOUNT = "aug_amount" ;
	public final static java.lang.String CS_SEPT_AMOUNT = "sept_amount" ;
	public final static java.lang.String CS_OCT_AMOUNT = "oct_amount" ;
	public final static java.lang.String CS_NOV_AMOUNT = "nov_amount" ;
	public final static java.lang.String CS_DEC_AMOUNT = "dec_amount" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,年份,一月,二月,三月,四月,五月,六月,七月,八月,九月,十月,十一月,十二月,合计";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Double getContractYear() {
		return this.__contract_year;
	}

	public void setContractYear( java.lang.Double value ) {
		this.__contract_year = value;
	}

	public java.math.BigDecimal getJanAmount() {
		return this.__jan_amount;
	}

	public void setJanAmount( java.math.BigDecimal value ) {
		this.__jan_amount = value;
	}

	public java.math.BigDecimal getFebAmount() {
		return this.__feb_amount;
	}

	public void setFebAmount( java.math.BigDecimal value ) {
		this.__feb_amount = value;
	}

	public java.math.BigDecimal getMarAmount() {
		return this.__mar_amount;
	}

	public void setMarAmount( java.math.BigDecimal value ) {
		this.__mar_amount = value;
	}

	public java.math.BigDecimal getAprAmount() {
		return this.__apr_amount;
	}

	public void setAprAmount( java.math.BigDecimal value ) {
		this.__apr_amount = value;
	}

	public java.math.BigDecimal getMayAmount() {
		return this.__may_amount;
	}

	public void setMayAmount( java.math.BigDecimal value ) {
		this.__may_amount = value;
	}

	public java.math.BigDecimal getJunAmount() {
		return this.__jun_amount;
	}

	public void setJunAmount( java.math.BigDecimal value ) {
		this.__jun_amount = value;
	}

	public java.math.BigDecimal getJulAmount() {
		return this.__jul_amount;
	}

	public void setJulAmount( java.math.BigDecimal value ) {
		this.__jul_amount = value;
	}

	public java.math.BigDecimal getAugAmount() {
		return this.__aug_amount;
	}

	public void setAugAmount( java.math.BigDecimal value ) {
		this.__aug_amount = value;
	}

	public java.math.BigDecimal getSeptAmount() {
		return this.__sept_amount;
	}

	public void setSeptAmount( java.math.BigDecimal value ) {
		this.__sept_amount = value;
	}

	public java.math.BigDecimal getOctAmount() {
		return this.__oct_amount;
	}

	public void setOctAmount( java.math.BigDecimal value ) {
		this.__oct_amount = value;
	}

	public java.math.BigDecimal getNovAmount() {
		return this.__nov_amount;
	}

	public void setNovAmount( java.math.BigDecimal value ) {
		this.__nov_amount = value;
	}

	public java.math.BigDecimal getDecAmount() {
		return this.__dec_amount;
	}

	public void setDecAmount( java.math.BigDecimal value ) {
		this.__dec_amount = value;
	}

	public java.math.BigDecimal getTotalAmount() {
		return this.__total_amount;
	}

	public void setTotalAmount( java.math.BigDecimal value ) {
		this.__total_amount = value;
	}

	public void cloneCopy(BaseContractAmountAnalyze __bean){
		__bean.setPlateId(getPlateId());
		__bean.setContractYear(getContractYear());
		__bean.setJanAmount(getJanAmount());
		__bean.setFebAmount(getFebAmount());
		__bean.setMarAmount(getMarAmount());
		__bean.setAprAmount(getAprAmount());
		__bean.setMayAmount(getMayAmount());
		__bean.setJunAmount(getJunAmount());
		__bean.setJulAmount(getJulAmount());
		__bean.setAugAmount(getAugAmount());
		__bean.setSeptAmount(getSeptAmount());
		__bean.setOctAmount(getOctAmount());
		__bean.setNovAmount(getNovAmount());
		__bean.setDecAmount(getDecAmount());
		__bean.setTotalAmount(getTotalAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getContractYear() == null ? "" : getContractYear());
		sb.append(",");
		sb.append(getJanAmount() == null ? "" : getJanAmount());
		sb.append(",");
		sb.append(getFebAmount() == null ? "" : getFebAmount());
		sb.append(",");
		sb.append(getMarAmount() == null ? "" : getMarAmount());
		sb.append(",");
		sb.append(getAprAmount() == null ? "" : getAprAmount());
		sb.append(",");
		sb.append(getMayAmount() == null ? "" : getMayAmount());
		sb.append(",");
		sb.append(getJunAmount() == null ? "" : getJunAmount());
		sb.append(",");
		sb.append(getJulAmount() == null ? "" : getJulAmount());
		sb.append(",");
		sb.append(getAugAmount() == null ? "" : getAugAmount());
		sb.append(",");
		sb.append(getSeptAmount() == null ? "" : getSeptAmount());
		sb.append(",");
		sb.append(getOctAmount() == null ? "" : getOctAmount());
		sb.append(",");
		sb.append(getNovAmount() == null ? "" : getNovAmount());
		sb.append(",");
		sb.append(getDecAmount() == null ? "" : getDecAmount());
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractAmountAnalyze o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_year);
		hash = 97 * hash + Objects.hashCode(this.__jan_amount);
		hash = 97 * hash + Objects.hashCode(this.__feb_amount);
		hash = 97 * hash + Objects.hashCode(this.__mar_amount);
		hash = 97 * hash + Objects.hashCode(this.__apr_amount);
		hash = 97 * hash + Objects.hashCode(this.__may_amount);
		hash = 97 * hash + Objects.hashCode(this.__jun_amount);
		hash = 97 * hash + Objects.hashCode(this.__jul_amount);
		hash = 97 * hash + Objects.hashCode(this.__aug_amount);
		hash = 97 * hash + Objects.hashCode(this.__sept_amount);
		hash = 97 * hash + Objects.hashCode(this.__oct_amount);
		hash = 97 * hash + Objects.hashCode(this.__nov_amount);
		hash = 97 * hash + Objects.hashCode(this.__dec_amount);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractAmountAnalyze o = (BaseContractAmountAnalyze)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__contract_year, o.getContractYear())) return false;
		if(!Objects.equals(this.__jan_amount, o.getJanAmount())) return false;
		if(!Objects.equals(this.__feb_amount, o.getFebAmount())) return false;
		if(!Objects.equals(this.__mar_amount, o.getMarAmount())) return false;
		if(!Objects.equals(this.__apr_amount, o.getAprAmount())) return false;
		if(!Objects.equals(this.__may_amount, o.getMayAmount())) return false;
		if(!Objects.equals(this.__jun_amount, o.getJunAmount())) return false;
		if(!Objects.equals(this.__jul_amount, o.getJulAmount())) return false;
		if(!Objects.equals(this.__aug_amount, o.getAugAmount())) return false;
		if(!Objects.equals(this.__sept_amount, o.getSeptAmount())) return false;
		if(!Objects.equals(this.__oct_amount, o.getOctAmount())) return false;
		if(!Objects.equals(this.__nov_amount, o.getNovAmount())) return false;
		if(!Objects.equals(this.__dec_amount, o.getDecAmount())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getContractYear() != null) sb.append(__wrapNumber(count++, "contractYear", getContractYear()));
		if(getJanAmount() != null) sb.append(__wrapDecimal(count++, "janAmount", getJanAmount()));
		if(getFebAmount() != null) sb.append(__wrapDecimal(count++, "febAmount", getFebAmount()));
		if(getMarAmount() != null) sb.append(__wrapDecimal(count++, "marAmount", getMarAmount()));
		if(getAprAmount() != null) sb.append(__wrapDecimal(count++, "aprAmount", getAprAmount()));
		if(getMayAmount() != null) sb.append(__wrapDecimal(count++, "mayAmount", getMayAmount()));
		if(getJunAmount() != null) sb.append(__wrapDecimal(count++, "junAmount", getJunAmount()));
		if(getJulAmount() != null) sb.append(__wrapDecimal(count++, "julAmount", getJulAmount()));
		if(getAugAmount() != null) sb.append(__wrapDecimal(count++, "augAmount", getAugAmount()));
		if(getSeptAmount() != null) sb.append(__wrapDecimal(count++, "septAmount", getSeptAmount()));
		if(getOctAmount() != null) sb.append(__wrapDecimal(count++, "octAmount", getOctAmount()));
		if(getNovAmount() != null) sb.append(__wrapDecimal(count++, "novAmount", getNovAmount()));
		if(getDecAmount() != null) sb.append(__wrapDecimal(count++, "decAmount", getDecAmount()));
		if(getTotalAmount() != null) sb.append(__wrapDecimal(count++, "totalAmount", getTotalAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("contractYear")) != null) setContractYear(__getDouble(val)); 
		if((val = values.get("janAmount")) != null) setJanAmount(__getDecimal(val));  
		if((val = values.get("febAmount")) != null) setFebAmount(__getDecimal(val));  
		if((val = values.get("marAmount")) != null) setMarAmount(__getDecimal(val));  
		if((val = values.get("aprAmount")) != null) setAprAmount(__getDecimal(val));  
		if((val = values.get("mayAmount")) != null) setMayAmount(__getDecimal(val));  
		if((val = values.get("junAmount")) != null) setJunAmount(__getDecimal(val));  
		if((val = values.get("julAmount")) != null) setJulAmount(__getDecimal(val));  
		if((val = values.get("augAmount")) != null) setAugAmount(__getDecimal(val));  
		if((val = values.get("septAmount")) != null) setSeptAmount(__getDecimal(val));  
		if((val = values.get("octAmount")) != null) setOctAmount(__getDecimal(val));  
		if((val = values.get("novAmount")) != null) setNovAmount(__getDecimal(val));  
		if((val = values.get("decAmount")) != null) setDecAmount(__getDecimal(val));  
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getDecimal(val));  
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Double  __contract_year ;
	protected java.math.BigDecimal  __jan_amount ;
	protected java.math.BigDecimal  __feb_amount ;
	protected java.math.BigDecimal  __mar_amount ;
	protected java.math.BigDecimal  __apr_amount ;
	protected java.math.BigDecimal  __may_amount ;
	protected java.math.BigDecimal  __jun_amount ;
	protected java.math.BigDecimal  __jul_amount ;
	protected java.math.BigDecimal  __aug_amount ;
	protected java.math.BigDecimal  __sept_amount ;
	protected java.math.BigDecimal  __oct_amount ;
	protected java.math.BigDecimal  __nov_amount ;
	protected java.math.BigDecimal  __dec_amount ;
	protected java.math.BigDecimal  __total_amount ;
}
