package pomplatform.itemCollection.custom.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseonLoadCapitalAmountOfContract extends GenericBase implements BaseFactory<BaseonLoadCapitalAmountOfContract>, Comparable<BaseonLoadCapitalAmountOfContract> 
{


	public static BaseonLoadCapitalAmountOfContract newInstance(){
		return new BaseonLoadCapitalAmountOfContract();
	}

	@Override
	public BaseonLoadCapitalAmountOfContract make(){
		BaseonLoadCapitalAmountOfContract b = new BaseonLoadCapitalAmountOfContract();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_SHEET_AMOUNT = "sheet_amount" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_REVENUE_AMOUNT = "revenue_amount" ;
	public final static java.lang.String CS_CAPITAL_AMOUNT = "capital_amount" ;

	public final static java.lang.String ALL_CAPTIONS = "合同编码,项目编码,板块,订单合同金额,项目积分,确认积分,营收金额,回款金额";

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getSheetAmount() {
		return this.__sheet_amount;
	}

	public void setSheetAmount( java.math.BigDecimal value ) {
		this.__sheet_amount = value;
	}

	public java.math.BigDecimal getProjectIntegral() {
		return this.__project_integral;
	}

	public void setProjectIntegral( java.math.BigDecimal value ) {
		this.__project_integral = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.math.BigDecimal getRevenueAmount() {
		return this.__revenue_amount;
	}

	public void setRevenueAmount( java.math.BigDecimal value ) {
		this.__revenue_amount = value;
	}

	public java.math.BigDecimal getCapitalAmount() {
		return this.__capital_amount;
	}

	public void setCapitalAmount( java.math.BigDecimal value ) {
		this.__capital_amount = value;
	}

	public void cloneCopy(BaseonLoadCapitalAmountOfContract __bean){
		__bean.setContractId(getContractId());
		__bean.setProjectId(getProjectId());
		__bean.setPlateId(getPlateId());
		__bean.setSheetAmount(getSheetAmount());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setRevenueAmount(getRevenueAmount());
		__bean.setCapitalAmount(getCapitalAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getSheetAmount() == null ? "" : getSheetAmount());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getRevenueAmount() == null ? "" : getRevenueAmount());
		sb.append(",");
		sb.append(getCapitalAmount() == null ? "" : getCapitalAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseonLoadCapitalAmountOfContract o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__sheet_amount);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__revenue_amount);
		hash = 97 * hash + Objects.hashCode(this.__capital_amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseonLoadCapitalAmountOfContract o = (BaseonLoadCapitalAmountOfContract)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__sheet_amount, o.getSheetAmount())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__revenue_amount, o.getRevenueAmount())) return false;
		if(!Objects.equals(this.__capital_amount, o.getCapitalAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getSheetAmount() != null) sb.append(__wrapDecimal(count++, "sheetAmount", getSheetAmount()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getRevenueAmount() != null) sb.append(__wrapDecimal(count++, "revenueAmount", getRevenueAmount()));
		if(getCapitalAmount() != null) sb.append(__wrapDecimal(count++, "capitalAmount", getCapitalAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("sheetAmount")) != null) setSheetAmount(__getDecimal(val));  
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));  
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("revenueAmount")) != null) setRevenueAmount(__getDecimal(val));  
		if((val = values.get("capitalAmount")) != null) setCapitalAmount(__getDecimal(val));  
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __sheet_amount ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.math.BigDecimal  __revenue_amount ;
	protected java.math.BigDecimal  __capital_amount ;
}
