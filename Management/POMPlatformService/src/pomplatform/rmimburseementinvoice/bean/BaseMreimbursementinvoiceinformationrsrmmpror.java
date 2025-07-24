package pomplatform.rmimburseementinvoice.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.system.executor.SelectValueCache;
import delicacy.common.BaseFactory;

public class BaseMreimbursementinvoiceinformationrsrmmpror extends GenericBase implements BaseFactory<BaseMreimbursementinvoiceinformationrsrmmpror>, Comparable<BaseMreimbursementinvoiceinformationrsrmmpror> 
{


	public static BaseMreimbursementinvoiceinformationrsrmmpror newInstance(){
		return new BaseMreimbursementinvoiceinformationrsrmmpror();
	}

	@Override
	public BaseMreimbursementinvoiceinformationrsrmmpror make(){
		BaseMreimbursementinvoiceinformationrsrmmpror b = new BaseMreimbursementinvoiceinformationrsrmmpror();
		return b;
	}

	public final static java.lang.String CS_PACKAGE_CODE = "package_code" ;
	public final static java.lang.String CS_RMI_CODE = "rmi_code" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_AIRCRAFT_QUANTITY = "aircraft_quantity" ;
	public final static java.lang.String CS_AIRCRAFT_TOTAL_AMOUNT = "aircraft_total_amount" ;
	public final static java.lang.String CS_AIRCRAFT_TAX_AMOUNT = "aircraft_tax_amount" ;
	public final static java.lang.String CS_RAIL_QUANTITY = "rail_quantity" ;
	public final static java.lang.String CS_RAIL_TOTAL_AMOUNT = "rail_total_amount" ;
	public final static java.lang.String CS_RAIL_TAX_AMOUNT = "rail_tax_amount" ;
	public final static java.lang.String CS_PT_QUANTITY = "pt_quantity" ;
	public final static java.lang.String CS_PT_TOTAL_AMOUNT = "pt_total_amount" ;
	public final static java.lang.String CS_PT_TAX_AMOUNT = "pt_tax_amount" ;
	public final static java.lang.String CS_NORMAL_QUANTITY = "normal_quantity" ;
	public final static java.lang.String CS_NORMAL_TOTAL_AMOUNT = "normal_total_amount" ;
	public final static java.lang.String CS_NORMAL_TAX_AMOUNT = "normal_tax_amount" ;
	public final static java.lang.String CS_GI_QUANTITY = "gi_quantity" ;
	public final static java.lang.String CS_GI_TOTAL_AMOUNT = "gi_total_amount" ;
	public final static java.lang.String CS_GI_TAX_AMOUNT = "gi_tax_amount" ;

	public final static java.lang.String ALL_CAPTIONS = "汇总单号,报销单号,归属公司,机票数量,机票金额,机票税额,高铁数量,高铁金额,高铁税额,客运水运数量,客运水运金额,客运水运税额,普通电子发票数量,普通电子发票金额,普通电子发票税额,绿联数量,绿联金额,绿联税额";

	public java.lang.String getPackageCode() {
		return this.__package_code;
	}

	public void setPackageCode( java.lang.String value ) {
		this.__package_code = value;
	}

	public java.lang.String getRmiCode() {
		return this.__rmi_code;
	}

	public void setRmiCode( java.lang.String value ) {
		this.__rmi_code = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.Long getAircraftQuantity() {
		return this.__aircraft_quantity;
	}

	public void setAircraftQuantity( java.lang.Long value ) {
		this.__aircraft_quantity = value;
	}

	public java.math.BigDecimal getAircraftTotalAmount() {
		return this.__aircraft_total_amount;
	}

	public void setAircraftTotalAmount( java.math.BigDecimal value ) {
		this.__aircraft_total_amount = value;
	}

	public java.math.BigDecimal getAircraftTaxAmount() {
		return this.__aircraft_tax_amount;
	}

	public void setAircraftTaxAmount( java.math.BigDecimal value ) {
		this.__aircraft_tax_amount = value;
	}

	public java.lang.Long getRailQuantity() {
		return this.__rail_quantity;
	}

	public void setRailQuantity( java.lang.Long value ) {
		this.__rail_quantity = value;
	}

	public java.math.BigDecimal getRailTotalAmount() {
		return this.__rail_total_amount;
	}

	public void setRailTotalAmount( java.math.BigDecimal value ) {
		this.__rail_total_amount = value;
	}

	public java.math.BigDecimal getRailTaxAmount() {
		return this.__rail_tax_amount;
	}

	public void setRailTaxAmount( java.math.BigDecimal value ) {
		this.__rail_tax_amount = value;
	}

	public java.lang.Long getPtQuantity() {
		return this.__pt_quantity;
	}

	public void setPtQuantity( java.lang.Long value ) {
		this.__pt_quantity = value;
	}

	public java.math.BigDecimal getPtTotalAmount() {
		return this.__pt_total_amount;
	}

	public void setPtTotalAmount( java.math.BigDecimal value ) {
		this.__pt_total_amount = value;
	}

	public java.math.BigDecimal getPtTaxAmount() {
		return this.__pt_tax_amount;
	}

	public void setPtTaxAmount( java.math.BigDecimal value ) {
		this.__pt_tax_amount = value;
	}

	public java.lang.Long getNormalQuantity() {
		return this.__normal_quantity;
	}

	public void setNormalQuantity( java.lang.Long value ) {
		this.__normal_quantity = value;
	}

	public java.math.BigDecimal getNormalTotalAmount() {
		return this.__normal_total_amount;
	}

	public void setNormalTotalAmount( java.math.BigDecimal value ) {
		this.__normal_total_amount = value;
	}

	public java.math.BigDecimal getNormalTaxAmount() {
		return this.__normal_tax_amount;
	}

	public void setNormalTaxAmount( java.math.BigDecimal value ) {
		this.__normal_tax_amount = value;
	}

	public java.lang.Long getGiQuantity() {
		return this.__gi_quantity;
	}

	public void setGiQuantity( java.lang.Long value ) {
		this.__gi_quantity = value;
	}

	public java.math.BigDecimal getGiTotalAmount() {
		return this.__gi_total_amount;
	}

	public void setGiTotalAmount( java.math.BigDecimal value ) {
		this.__gi_total_amount = value;
	}

	public java.math.BigDecimal getGiTaxAmount() {
		return this.__gi_tax_amount;
	}

	public void setGiTaxAmount( java.math.BigDecimal value ) {
		this.__gi_tax_amount = value;
	}

	public void cloneCopy(BaseMreimbursementinvoiceinformationrsrmmpror __bean){
		__bean.setPackageCode(getPackageCode());
		__bean.setRmiCode(getRmiCode());
		__bean.setCompanyId(getCompanyId());
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
		__bean.setAircraftQuantity(getAircraftQuantity());
		__bean.setAircraftTotalAmount(getAircraftTotalAmount());
		__bean.setAircraftTaxAmount(getAircraftTaxAmount());
		__bean.setRailQuantity(getRailQuantity());
		__bean.setRailTotalAmount(getRailTotalAmount());
		__bean.setRailTaxAmount(getRailTaxAmount());
		__bean.setPtQuantity(getPtQuantity());
		__bean.setPtTotalAmount(getPtTotalAmount());
		__bean.setPtTaxAmount(getPtTaxAmount());
		__bean.setNormalQuantity(getNormalQuantity());
		__bean.setNormalTotalAmount(getNormalTotalAmount());
		__bean.setNormalTaxAmount(getNormalTaxAmount());
		__bean.setGiQuantity(getGiQuantity());
		__bean.setGiTotalAmount(getGiTotalAmount());
		__bean.setGiTaxAmount(getGiTaxAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPackageCode() == null ? "" : getPackageCode());
		sb.append(",");
		sb.append(getRmiCode() == null ? "" : getRmiCode());
		sb.append(",");
		String companyIdStr = null == getCompanyId() ? "" : getCompanyId().toString();
		String companyIdStrVal = SelectValueCache.getSelectValue("company_records", companyIdStr);
		sb.append(companyIdStrVal);
		sb.append(",");
		sb.append(getAircraftQuantity() == null ? "" : getAircraftQuantity());
		sb.append(",");
		sb.append(getAircraftTotalAmount() == null ? "" : getAircraftTotalAmount());
		sb.append(",");
		sb.append(getAircraftTaxAmount() == null ? "" : getAircraftTaxAmount());
		sb.append(",");
		sb.append(getRailQuantity() == null ? "" : getRailQuantity());
		sb.append(",");
		sb.append(getRailTotalAmount() == null ? "" : getRailTotalAmount());
		sb.append(",");
		sb.append(getRailTaxAmount() == null ? "" : getRailTaxAmount());
		sb.append(",");
		sb.append(getPtQuantity() == null ? "" : getPtQuantity());
		sb.append(",");
		sb.append(getPtTotalAmount() == null ? "" : getPtTotalAmount());
		sb.append(",");
		sb.append(getPtTaxAmount() == null ? "" : getPtTaxAmount());
		sb.append(",");
		sb.append(getNormalQuantity() == null ? "" : getNormalQuantity());
		sb.append(",");
		sb.append(getNormalTotalAmount() == null ? "" : getNormalTotalAmount());
		sb.append(",");
		sb.append(getNormalTaxAmount() == null ? "" : getNormalTaxAmount());
		sb.append(",");
		sb.append(getGiQuantity() == null ? "" : getGiQuantity());
		sb.append(",");
		sb.append(getGiTotalAmount() == null ? "" : getGiTotalAmount());
		sb.append(",");
		sb.append(getGiTaxAmount() == null ? "" : getGiTaxAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMreimbursementinvoiceinformationrsrmmpror o) {
		return __package_code == null ? -1 : __package_code.compareTo(o.getPackageCode());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__package_code);
		hash = 97 * hash + Objects.hashCode(this.__rmi_code);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__aircraft_quantity);
		hash = 97 * hash + Objects.hashCode(this.__aircraft_total_amount);
		hash = 97 * hash + Objects.hashCode(this.__aircraft_tax_amount);
		hash = 97 * hash + Objects.hashCode(this.__rail_quantity);
		hash = 97 * hash + Objects.hashCode(this.__rail_total_amount);
		hash = 97 * hash + Objects.hashCode(this.__rail_tax_amount);
		hash = 97 * hash + Objects.hashCode(this.__pt_quantity);
		hash = 97 * hash + Objects.hashCode(this.__pt_total_amount);
		hash = 97 * hash + Objects.hashCode(this.__pt_tax_amount);
		hash = 97 * hash + Objects.hashCode(this.__normal_quantity);
		hash = 97 * hash + Objects.hashCode(this.__normal_total_amount);
		hash = 97 * hash + Objects.hashCode(this.__normal_tax_amount);
		hash = 97 * hash + Objects.hashCode(this.__gi_quantity);
		hash = 97 * hash + Objects.hashCode(this.__gi_total_amount);
		hash = 97 * hash + Objects.hashCode(this.__gi_tax_amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMreimbursementinvoiceinformationrsrmmpror o = (BaseMreimbursementinvoiceinformationrsrmmpror)obj;
		if(!Objects.equals(this.__package_code, o.getPackageCode())) return false;
		if(!Objects.equals(this.__rmi_code, o.getRmiCode())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__aircraft_quantity, o.getAircraftQuantity())) return false;
		if(!Objects.equals(this.__aircraft_total_amount, o.getAircraftTotalAmount())) return false;
		if(!Objects.equals(this.__aircraft_tax_amount, o.getAircraftTaxAmount())) return false;
		if(!Objects.equals(this.__rail_quantity, o.getRailQuantity())) return false;
		if(!Objects.equals(this.__rail_total_amount, o.getRailTotalAmount())) return false;
		if(!Objects.equals(this.__rail_tax_amount, o.getRailTaxAmount())) return false;
		if(!Objects.equals(this.__pt_quantity, o.getPtQuantity())) return false;
		if(!Objects.equals(this.__pt_total_amount, o.getPtTotalAmount())) return false;
		if(!Objects.equals(this.__pt_tax_amount, o.getPtTaxAmount())) return false;
		if(!Objects.equals(this.__normal_quantity, o.getNormalQuantity())) return false;
		if(!Objects.equals(this.__normal_total_amount, o.getNormalTotalAmount())) return false;
		if(!Objects.equals(this.__normal_tax_amount, o.getNormalTaxAmount())) return false;
		if(!Objects.equals(this.__gi_quantity, o.getGiQuantity())) return false;
		if(!Objects.equals(this.__gi_total_amount, o.getGiTotalAmount())) return false;
		if(!Objects.equals(this.__gi_tax_amount, o.getGiTaxAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPackageCode() != null) sb.append(__wrapString(count++, "packageCode", getPackageCode()));
		if(getRmiCode() != null) sb.append(__wrapString(count++, "rmiCode", getRmiCode()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getAircraftQuantity() != null) sb.append(__wrapNumber(count++, "aircraftQuantity", getAircraftQuantity()));
		if(getAircraftTotalAmount() != null) sb.append(__wrapDecimal(count++, "aircraftTotalAmount", getAircraftTotalAmount()));
		if(getAircraftTaxAmount() != null) sb.append(__wrapDecimal(count++, "aircraftTaxAmount", getAircraftTaxAmount()));
		if(getRailQuantity() != null) sb.append(__wrapNumber(count++, "railQuantity", getRailQuantity()));
		if(getRailTotalAmount() != null) sb.append(__wrapDecimal(count++, "railTotalAmount", getRailTotalAmount()));
		if(getRailTaxAmount() != null) sb.append(__wrapDecimal(count++, "railTaxAmount", getRailTaxAmount()));
		if(getPtQuantity() != null) sb.append(__wrapNumber(count++, "ptQuantity", getPtQuantity()));
		if(getPtTotalAmount() != null) sb.append(__wrapDecimal(count++, "ptTotalAmount", getPtTotalAmount()));
		if(getPtTaxAmount() != null) sb.append(__wrapDecimal(count++, "ptTaxAmount", getPtTaxAmount()));
		if(getNormalQuantity() != null) sb.append(__wrapNumber(count++, "normalQuantity", getNormalQuantity()));
		if(getNormalTotalAmount() != null) sb.append(__wrapDecimal(count++, "normalTotalAmount", getNormalTotalAmount()));
		if(getNormalTaxAmount() != null) sb.append(__wrapDecimal(count++, "normalTaxAmount", getNormalTaxAmount()));
		if(getGiQuantity() != null) sb.append(__wrapNumber(count++, "giQuantity", getGiQuantity()));
		if(getGiTotalAmount() != null) sb.append(__wrapDecimal(count++, "giTotalAmount", getGiTotalAmount()));
		if(getGiTaxAmount() != null) sb.append(__wrapDecimal(count++, "giTaxAmount", getGiTaxAmount()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPackageCode() != null) res.put("packageCode", getPackageCode());
		if(getRmiCode() != null) res.put("rmiCode", getRmiCode());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getAircraftQuantity() != null) res.put("aircraftQuantity", getAircraftQuantity());
		if(getAircraftTotalAmount() != null) res.put("aircraftTotalAmount", getAircraftTotalAmount());
		if(getAircraftTaxAmount() != null) res.put("aircraftTaxAmount", getAircraftTaxAmount());
		if(getRailQuantity() != null) res.put("railQuantity", getRailQuantity());
		if(getRailTotalAmount() != null) res.put("railTotalAmount", getRailTotalAmount());
		if(getRailTaxAmount() != null) res.put("railTaxAmount", getRailTaxAmount());
		if(getPtQuantity() != null) res.put("ptQuantity", getPtQuantity());
		if(getPtTotalAmount() != null) res.put("ptTotalAmount", getPtTotalAmount());
		if(getPtTaxAmount() != null) res.put("ptTaxAmount", getPtTaxAmount());
		if(getNormalQuantity() != null) res.put("normalQuantity", getNormalQuantity());
		if(getNormalTotalAmount() != null) res.put("normalTotalAmount", getNormalTotalAmount());
		if(getNormalTaxAmount() != null) res.put("normalTaxAmount", getNormalTaxAmount());
		if(getGiQuantity() != null) res.put("giQuantity", getGiQuantity());
		if(getGiTotalAmount() != null) res.put("giTotalAmount", getGiTotalAmount());
		if(getGiTaxAmount() != null) res.put("giTaxAmount", getGiTaxAmount());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("packageCode")) != null) setPackageCode(__getString(val));
		if((val = values.get("rmiCode")) != null) setRmiCode(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("aircraftQuantity")) != null) setAircraftQuantity(__getLong(val)); 
		if((val = values.get("aircraftTotalAmount")) != null) setAircraftTotalAmount(__getDecimal(val));  
		if((val = values.get("aircraftTaxAmount")) != null) setAircraftTaxAmount(__getDecimal(val));  
		if((val = values.get("railQuantity")) != null) setRailQuantity(__getLong(val)); 
		if((val = values.get("railTotalAmount")) != null) setRailTotalAmount(__getDecimal(val));  
		if((val = values.get("railTaxAmount")) != null) setRailTaxAmount(__getDecimal(val));  
		if((val = values.get("ptQuantity")) != null) setPtQuantity(__getLong(val)); 
		if((val = values.get("ptTotalAmount")) != null) setPtTotalAmount(__getDecimal(val));  
		if((val = values.get("ptTaxAmount")) != null) setPtTaxAmount(__getDecimal(val));  
		if((val = values.get("normalQuantity")) != null) setNormalQuantity(__getLong(val)); 
		if((val = values.get("normalTotalAmount")) != null) setNormalTotalAmount(__getDecimal(val));  
		if((val = values.get("normalTaxAmount")) != null) setNormalTaxAmount(__getDecimal(val));  
		if((val = values.get("giQuantity")) != null) setGiQuantity(__getLong(val)); 
		if((val = values.get("giTotalAmount")) != null) setGiTotalAmount(__getDecimal(val));  
		if((val = values.get("giTaxAmount")) != null) setGiTaxAmount(__getDecimal(val));  
	}

	protected java.lang.String  __package_code ;
	protected java.lang.String  __rmi_code ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Long  __aircraft_quantity ;
	protected java.math.BigDecimal  __aircraft_total_amount ;
	protected java.math.BigDecimal  __aircraft_tax_amount ;
	protected java.lang.Long  __rail_quantity ;
	protected java.math.BigDecimal  __rail_total_amount ;
	protected java.math.BigDecimal  __rail_tax_amount ;
	protected java.lang.Long  __pt_quantity ;
	protected java.math.BigDecimal  __pt_total_amount ;
	protected java.math.BigDecimal  __pt_tax_amount ;
	protected java.lang.Long  __normal_quantity ;
	protected java.math.BigDecimal  __normal_total_amount ;
	protected java.math.BigDecimal  __normal_tax_amount ;
	protected java.lang.Long  __gi_quantity ;
	protected java.math.BigDecimal  __gi_total_amount ;
	protected java.math.BigDecimal  __gi_tax_amount ;
}
