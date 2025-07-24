package pomplatform.project.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadOutAchieveSure extends GenericBase implements BaseFactory<BaseOnLoadOutAchieveSure>, Comparable<BaseOnLoadOutAchieveSure> 
{


	public static BaseOnLoadOutAchieveSure newInstance(){
		return new BaseOnLoadOutAchieveSure();
	}

	@Override
	public BaseOnLoadOutAchieveSure make(){
		BaseOnLoadOutAchieveSure b = new BaseOnLoadOutAchieveSure();
		return b;
	}

	public final static java.lang.String CS_FINANCIAL_CONTRACT_CODE = "financial_contract_code" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_TOTAL_REVENUE = "total_revenue" ;
	public final static java.lang.String CS_LAST_TOTAL_REVENUE = "last_total_revenue" ;
	public final static java.lang.String CS_CURRENT_REVENUE = "current_revenue" ;

	public final static java.lang.String ALL_CAPTIONS = "财务合同编号,合同编号,合同名称,累计营收,上月累积营收,本月营收";

	public java.lang.String getFinancialContractCode() {
		return this.__financial_contract_code;
	}

	public void setFinancialContractCode( java.lang.String value ) {
		this.__financial_contract_code = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.math.BigDecimal getTotalRevenue() {
		return this.__total_revenue;
	}

	public void setTotalRevenue( java.math.BigDecimal value ) {
		this.__total_revenue = value;
	}

	public java.math.BigDecimal getLastTotalRevenue() {
		return this.__last_total_revenue;
	}

	public void setLastTotalRevenue( java.math.BigDecimal value ) {
		this.__last_total_revenue = value;
	}

	public java.math.BigDecimal getCurrentRevenue() {
		return this.__current_revenue;
	}

	public void setCurrentRevenue( java.math.BigDecimal value ) {
		this.__current_revenue = value;
	}

	public void cloneCopy(BaseOnLoadOutAchieveSure __bean){
		__bean.setFinancialContractCode(getFinancialContractCode());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setTotalRevenue(getTotalRevenue());
		__bean.setLastTotalRevenue(getLastTotalRevenue());
		__bean.setCurrentRevenue(getCurrentRevenue());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFinancialContractCode() == null ? "" : getFinancialContractCode());
		sb.append(",");
		String strContractCode = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractCode()));
		sb.append(strContractCode == null ? "" : strContractCode);
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getTotalRevenue() == null ? "" : getTotalRevenue());
		sb.append(",");
		sb.append(getLastTotalRevenue() == null ? "" : getLastTotalRevenue());
		sb.append(",");
		sb.append(getCurrentRevenue() == null ? "" : getCurrentRevenue());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadOutAchieveSure o) {
		return __financial_contract_code == null ? -1 : __financial_contract_code.compareTo(o.getFinancialContractCode());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__financial_contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__total_revenue);
		hash = 97 * hash + Objects.hashCode(this.__last_total_revenue);
		hash = 97 * hash + Objects.hashCode(this.__current_revenue);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadOutAchieveSure o = (BaseOnLoadOutAchieveSure)obj;
		if(!Objects.equals(this.__financial_contract_code, o.getFinancialContractCode())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__total_revenue, o.getTotalRevenue())) return false;
		if(!Objects.equals(this.__last_total_revenue, o.getLastTotalRevenue())) return false;
		if(!Objects.equals(this.__current_revenue, o.getCurrentRevenue())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFinancialContractCode() != null) sb.append(__wrapString(count++, "financialContractCode", getFinancialContractCode()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getTotalRevenue() != null) sb.append(__wrapDecimal(count++, "totalRevenue", getTotalRevenue()));
		if(getLastTotalRevenue() != null) sb.append(__wrapDecimal(count++, "lastTotalRevenue", getLastTotalRevenue()));
		if(getCurrentRevenue() != null) sb.append(__wrapDecimal(count++, "currentRevenue", getCurrentRevenue()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("financialContractCode")) != null) setFinancialContractCode(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("totalRevenue")) != null) setTotalRevenue(__getDecimal(val));  
		if((val = values.get("lastTotalRevenue")) != null) setLastTotalRevenue(__getDecimal(val));  
		if((val = values.get("currentRevenue")) != null) setCurrentRevenue(__getDecimal(val));  
	}

	protected java.lang.String  __financial_contract_code ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.math.BigDecimal  __total_revenue ;
	protected java.math.BigDecimal  __last_total_revenue ;
	protected java.math.BigDecimal  __current_revenue ;
}
