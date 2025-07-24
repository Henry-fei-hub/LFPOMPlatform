package pomplatform.project.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadInAchieveDetail extends GenericBase implements BaseFactory<BaseOnLoadInAchieveDetail>, Comparable<BaseOnLoadInAchieveDetail> 
{


	public static BaseOnLoadInAchieveDetail newInstance(){
		return new BaseOnLoadInAchieveDetail();
	}

	@Override
	public BaseOnLoadInAchieveDetail make(){
		BaseOnLoadInAchieveDetail b = new BaseOnLoadInAchieveDetail();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_FINANCIAL_CONTRACT_CODE = "financial_contract_code" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_SHEET_CODE = "sheet_code" ;
	public final static java.lang.String CS_SHEET_NAME = "sheet_name" ;
	public final static java.lang.String CS_TOTAL_REVENUE = "total_revenue" ;
	public final static java.lang.String CS_CURRENT_REVENUE = "current_revenue" ;
	public final static java.lang.String CS_LAST_TOTAL_REVENUE = "last_total_revenue" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,财务合同编号,合同编号,合同名称,订单编号,订单名称,累计营收,本月营收,上月累积营收";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

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

	public java.lang.String getSheetCode() {
		return this.__sheet_code;
	}

	public void setSheetCode( java.lang.String value ) {
		this.__sheet_code = value;
	}

	public java.lang.String getSheetName() {
		return this.__sheet_name;
	}

	public void setSheetName( java.lang.String value ) {
		this.__sheet_name = value;
	}

	public java.math.BigDecimal getTotalRevenue() {
		return this.__total_revenue;
	}

	public void setTotalRevenue( java.math.BigDecimal value ) {
		this.__total_revenue = value;
	}

	public java.math.BigDecimal getCurrentRevenue() {
		return this.__current_revenue;
	}

	public void setCurrentRevenue( java.math.BigDecimal value ) {
		this.__current_revenue = value;
	}

	public java.math.BigDecimal getLastTotalRevenue() {
		return this.__last_total_revenue;
	}

	public void setLastTotalRevenue( java.math.BigDecimal value ) {
		this.__last_total_revenue = value;
	}

	public void cloneCopy(BaseOnLoadInAchieveDetail __bean){
		__bean.setPlateId(getPlateId());
		__bean.setFinancialContractCode(getFinancialContractCode());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setSheetCode(getSheetCode());
		__bean.setSheetName(getSheetName());
		__bean.setTotalRevenue(getTotalRevenue());
		__bean.setCurrentRevenue(getCurrentRevenue());
		__bean.setLastTotalRevenue(getLastTotalRevenue());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getFinancialContractCode() == null ? "" : getFinancialContractCode());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getSheetCode() == null ? "" : getSheetCode());
		sb.append(",");
		sb.append(getSheetName() == null ? "" : getSheetName());
		sb.append(",");
		sb.append(getTotalRevenue() == null ? "" : getTotalRevenue());
		sb.append(",");
		sb.append(getCurrentRevenue() == null ? "" : getCurrentRevenue());
		sb.append(",");
		sb.append(getLastTotalRevenue() == null ? "" : getLastTotalRevenue());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadInAchieveDetail o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__financial_contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__sheet_code);
		hash = 97 * hash + Objects.hashCode(this.__sheet_name);
		hash = 97 * hash + Objects.hashCode(this.__total_revenue);
		hash = 97 * hash + Objects.hashCode(this.__current_revenue);
		hash = 97 * hash + Objects.hashCode(this.__last_total_revenue);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadInAchieveDetail o = (BaseOnLoadInAchieveDetail)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__financial_contract_code, o.getFinancialContractCode())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__sheet_code, o.getSheetCode())) return false;
		if(!Objects.equals(this.__sheet_name, o.getSheetName())) return false;
		if(!Objects.equals(this.__total_revenue, o.getTotalRevenue())) return false;
		if(!Objects.equals(this.__current_revenue, o.getCurrentRevenue())) return false;
		if(!Objects.equals(this.__last_total_revenue, o.getLastTotalRevenue())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getFinancialContractCode() != null) sb.append(__wrapString(count++, "financialContractCode", getFinancialContractCode()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getSheetCode() != null) sb.append(__wrapString(count++, "sheetCode", getSheetCode()));
		if(getSheetName() != null) sb.append(__wrapString(count++, "sheetName", getSheetName()));
		if(getTotalRevenue() != null) sb.append(__wrapDecimal(count++, "totalRevenue", getTotalRevenue()));
		if(getCurrentRevenue() != null) sb.append(__wrapDecimal(count++, "currentRevenue", getCurrentRevenue()));
		if(getLastTotalRevenue() != null) sb.append(__wrapDecimal(count++, "lastTotalRevenue", getLastTotalRevenue()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("financialContractCode")) != null) setFinancialContractCode(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("sheetCode")) != null) setSheetCode(__getString(val));
		if((val = values.get("sheetName")) != null) setSheetName(__getString(val));
		if((val = values.get("totalRevenue")) != null) setTotalRevenue(__getDecimal(val));  
		if((val = values.get("currentRevenue")) != null) setCurrentRevenue(__getDecimal(val));  
		if((val = values.get("lastTotalRevenue")) != null) setLastTotalRevenue(__getDecimal(val));  
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.String  __financial_contract_code ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.String  __sheet_code ;
	protected java.lang.String  __sheet_name ;
	protected java.math.BigDecimal  __total_revenue ;
	protected java.math.BigDecimal  __current_revenue ;
	protected java.math.BigDecimal  __last_total_revenue ;
}
