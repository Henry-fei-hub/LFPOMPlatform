package pomplatform.revenuecapitalsinfo.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseRevenueCapitalsInfo extends GenericBase implements BaseFactory<BaseRevenueCapitalsInfo>, Comparable<BaseRevenueCapitalsInfo> 
{


	public static BaseRevenueCapitalsInfo newInstance(){
		return new BaseRevenueCapitalsInfo();
	}

	@Override
	public BaseRevenueCapitalsInfo make(){
		BaseRevenueCapitalsInfo b = new BaseRevenueCapitalsInfo();
		return b;
	}

	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_REVENUE_AMOUNT_START = "revenue_amount_start" ;
	public final static java.lang.String CS_CAPITAL_AMOUNT_START = "capital_amount_start" ;
	public final static java.lang.String CS_REVENUE_AMOUNT_END = "revenue_amount_end" ;
	public final static java.lang.String CS_CAPITAL_AMOUNT_END = "capital_amount_end" ;
	public final static java.lang.String CS_REVENUE_ONE_QUARTER = "revenue_one_quarter" ;
	public final static java.lang.String CS_REVENUE_TWO_QUARTER = "revenue_two_quarter" ;
	public final static java.lang.String CS_REVENUE_TREE_QUARTER = "revenue_tree_quarter" ;
	public final static java.lang.String CS_REVENUE_FOUR_QUARTER = "revenue_four_quarter" ;
	public final static java.lang.String CS_CAPITAL_ONE_QUARTER = "capital_one_quarter" ;
	public final static java.lang.String CS_CAPITAL_TWO_QUARTER = "capital_two_quarter" ;
	public final static java.lang.String CS_CAPITAL_TREE_QUARTER = "capital_tree_quarter" ;
	public final static java.lang.String CS_CAPITAL_FOUR_QUARTER = "capital_four_quarter" ;

	public final static java.lang.String ALL_CAPTIONS = "年,合同编号,合同名称,客户名称,期初营收,期初回款,第一季度营收,第二季度营收,第三季度营收,第四季度营收,第一季度回款,第二季度回款,第三季度回款,第四季度回款,期末营收,期末回款,";
	public final static java.lang.String EXPORT_CAPTIONS = "年,合同编号,合同名称,客户名称,期初营收,期初回款,第一季度营收,第一季度回款,第二季度营收,第二季度回款,第三季度营收,第三季度回款,第四季度营收,第四季度回款,期末营收,期末回款";

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
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

	public java.lang.String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.math.BigDecimal getRevenueAmountStart() {
		return this.__revenue_amount_start;
	}

	public void setRevenueAmountStart( java.math.BigDecimal value ) {
		this.__revenue_amount_start = value;
	}

	public java.math.BigDecimal getCapitalAmountStart() {
		return this.__capital_amount_start;
	}

	public void setCapitalAmountStart( java.math.BigDecimal value ) {
		this.__capital_amount_start = value;
	}

	public java.math.BigDecimal getRevenueAmountEnd() {
		return this.__revenue_amount_end;
	}

	public void setRevenueAmountEnd( java.math.BigDecimal value ) {
		this.__revenue_amount_end = value;
	}

	public java.math.BigDecimal getCapitalAmountEnd() {
		return this.__capital_amount_end;
	}

	public void setCapitalAmountEnd( java.math.BigDecimal value ) {
		this.__capital_amount_end = value;
	}

	public java.math.BigDecimal getRevenueOneQuarter() {
		return this.__revenue_one_quarter;
	}

	public void setRevenueOneQuarter( java.math.BigDecimal value ) {
		this.__revenue_one_quarter = value;
	}

	public java.math.BigDecimal getRevenueTwoQuarter() {
		return this.__revenue_two_quarter;
	}

	public void setRevenueTwoQuarter( java.math.BigDecimal value ) {
		this.__revenue_two_quarter = value;
	}

	public java.math.BigDecimal getRevenueTreeQuarter() {
		return this.__revenue_tree_quarter;
	}

	public void setRevenueTreeQuarter( java.math.BigDecimal value ) {
		this.__revenue_tree_quarter = value;
	}

	public java.math.BigDecimal getRevenueFourQuarter() {
		return this.__revenue_four_quarter;
	}

	public void setRevenueFourQuarter( java.math.BigDecimal value ) {
		this.__revenue_four_quarter = value;
	}

	public java.math.BigDecimal getCapitalOneQuarter() {
		return this.__capital_one_quarter;
	}

	public void setCapitalOneQuarter( java.math.BigDecimal value ) {
		this.__capital_one_quarter = value;
	}

	public java.math.BigDecimal getCapitalTwoQuarter() {
		return this.__capital_two_quarter;
	}

	public void setCapitalTwoQuarter( java.math.BigDecimal value ) {
		this.__capital_two_quarter = value;
	}

	public java.math.BigDecimal getCapitalTreeQuarter() {
		return this.__capital_tree_quarter;
	}

	public void setCapitalTreeQuarter( java.math.BigDecimal value ) {
		this.__capital_tree_quarter = value;
	}

	public java.math.BigDecimal getCapitalFourQuarter() {
		return this.__capital_four_quarter;
	}

	public void setCapitalFourQuarter( java.math.BigDecimal value ) {
		this.__capital_four_quarter = value;
	}

	public void cloneCopy(BaseRevenueCapitalsInfo __bean){
		__bean.setYear(getYear());
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setCustomerName(getCustomerName());
		__bean.setRevenueAmountStart(getRevenueAmountStart());
		__bean.setCapitalAmountStart(getCapitalAmountStart());
		__bean.setRevenueAmountEnd(getRevenueAmountEnd());
		__bean.setCapitalAmountEnd(getCapitalAmountEnd());
		__bean.setRevenueOneQuarter(getRevenueOneQuarter());
		__bean.setRevenueTwoQuarter(getRevenueTwoQuarter());
		__bean.setRevenueTreeQuarter(getRevenueTreeQuarter());
		__bean.setRevenueFourQuarter(getRevenueFourQuarter());
		__bean.setCapitalOneQuarter(getCapitalOneQuarter());
		__bean.setCapitalTwoQuarter(getCapitalTwoQuarter());
		__bean.setCapitalTreeQuarter(getCapitalTreeQuarter());
		__bean.setCapitalFourQuarter(getCapitalFourQuarter());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		/*sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");*/
		sb.append(getContractCode() == null ? "" : getContractCode().replaceAll(",", "，"));
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName().replaceAll(",", "，"));
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName().replaceAll(",", "，"));
		sb.append(",");
		sb.append(getRevenueAmountStart() == null ? "" : getRevenueAmountStart());
		sb.append(",");
		sb.append(getCapitalAmountStart() == null ? "" : getCapitalAmountStart());
		sb.append(",");
		sb.append(getRevenueOneQuarter() == null ? "" : getRevenueOneQuarter());
		sb.append(",");
		sb.append(getCapitalOneQuarter() == null ? "" : getCapitalOneQuarter());
		sb.append(",");
		sb.append(getRevenueTwoQuarter() == null ? "" : getRevenueTwoQuarter());
		sb.append(",");
		sb.append(getCapitalTwoQuarter() == null ? "" : getCapitalTwoQuarter());
		sb.append(",");
		sb.append(getRevenueTreeQuarter() == null ? "" : getRevenueTreeQuarter());
		sb.append(",");
		sb.append(getCapitalTreeQuarter() == null ? "" : getCapitalTreeQuarter());
		sb.append(",");
		sb.append(getRevenueFourQuarter() == null ? "" : getRevenueFourQuarter());
		sb.append(",");
		sb.append(getCapitalFourQuarter() == null ? "" : getCapitalFourQuarter());
		sb.append(",");
		sb.append(getRevenueAmountEnd() == null ? "" : getRevenueAmountEnd());
		sb.append(",");
		sb.append(getCapitalAmountEnd() == null ? "" : getCapitalAmountEnd());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseRevenueCapitalsInfo o) {
		return __year == null ? -1 : __year.compareTo(o.getYear());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__revenue_amount_start);
		hash = 97 * hash + Objects.hashCode(this.__capital_amount_start);
		hash = 97 * hash + Objects.hashCode(this.__revenue_amount_end);
		hash = 97 * hash + Objects.hashCode(this.__capital_amount_end);
		hash = 97 * hash + Objects.hashCode(this.__revenue_one_quarter);
		hash = 97 * hash + Objects.hashCode(this.__revenue_two_quarter);
		hash = 97 * hash + Objects.hashCode(this.__revenue_tree_quarter);
		hash = 97 * hash + Objects.hashCode(this.__revenue_four_quarter);
		hash = 97 * hash + Objects.hashCode(this.__capital_one_quarter);
		hash = 97 * hash + Objects.hashCode(this.__capital_two_quarter);
		hash = 97 * hash + Objects.hashCode(this.__capital_tree_quarter);
		hash = 97 * hash + Objects.hashCode(this.__capital_four_quarter);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseRevenueCapitalsInfo o = (BaseRevenueCapitalsInfo)obj;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__revenue_amount_start, o.getRevenueAmountStart())) return false;
		if(!Objects.equals(this.__capital_amount_start, o.getCapitalAmountStart())) return false;
		if(!Objects.equals(this.__revenue_amount_end, o.getRevenueAmountEnd())) return false;
		if(!Objects.equals(this.__capital_amount_end, o.getCapitalAmountEnd())) return false;
		if(!Objects.equals(this.__revenue_one_quarter, o.getRevenueOneQuarter())) return false;
		if(!Objects.equals(this.__revenue_two_quarter, o.getRevenueTwoQuarter())) return false;
		if(!Objects.equals(this.__revenue_tree_quarter, o.getRevenueTreeQuarter())) return false;
		if(!Objects.equals(this.__revenue_four_quarter, o.getRevenueFourQuarter())) return false;
		if(!Objects.equals(this.__capital_one_quarter, o.getCapitalOneQuarter())) return false;
		if(!Objects.equals(this.__capital_two_quarter, o.getCapitalTwoQuarter())) return false;
		if(!Objects.equals(this.__capital_tree_quarter, o.getCapitalTreeQuarter())) return false;
		if(!Objects.equals(this.__capital_four_quarter, o.getCapitalFourQuarter())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getRevenueAmountStart() != null) sb.append(__wrapDecimal(count++, "revenueAmountStart", getRevenueAmountStart()));
		if(getCapitalAmountStart() != null) sb.append(__wrapDecimal(count++, "capitalAmountStart", getCapitalAmountStart()));
		if(getRevenueAmountEnd() != null) sb.append(__wrapDecimal(count++, "revenueAmountEnd", getRevenueAmountEnd()));
		if(getCapitalAmountEnd() != null) sb.append(__wrapDecimal(count++, "capitalAmountEnd", getCapitalAmountEnd()));
		if(getRevenueOneQuarter() != null) sb.append(__wrapDecimal(count++, "revenueOneQuarter", getRevenueOneQuarter()));
		if(getRevenueTwoQuarter() != null) sb.append(__wrapDecimal(count++, "revenueTwoQuarter", getRevenueTwoQuarter()));
		if(getRevenueTreeQuarter() != null) sb.append(__wrapDecimal(count++, "revenueTreeQuarter", getRevenueTreeQuarter()));
		if(getRevenueFourQuarter() != null) sb.append(__wrapDecimal(count++, "revenueFourQuarter", getRevenueFourQuarter()));
		if(getCapitalOneQuarter() != null) sb.append(__wrapDecimal(count++, "capitalOneQuarter", getCapitalOneQuarter()));
		if(getCapitalTwoQuarter() != null) sb.append(__wrapDecimal(count++, "capitalTwoQuarter", getCapitalTwoQuarter()));
		if(getCapitalTreeQuarter() != null) sb.append(__wrapDecimal(count++, "capitalTreeQuarter", getCapitalTreeQuarter()));
		if(getCapitalFourQuarter() != null) sb.append(__wrapDecimal(count++, "capitalFourQuarter", getCapitalFourQuarter()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("revenueAmountStart")) != null) setRevenueAmountStart(__getDecimal(val));  
		if((val = values.get("capitalAmountStart")) != null) setCapitalAmountStart(__getDecimal(val));  
		if((val = values.get("revenueAmountEnd")) != null) setRevenueAmountEnd(__getDecimal(val));  
		if((val = values.get("capitalAmountEnd")) != null) setCapitalAmountEnd(__getDecimal(val));  
		if((val = values.get("revenueOneQuarter")) != null) setRevenueOneQuarter(__getDecimal(val));  
		if((val = values.get("revenueTwoQuarter")) != null) setRevenueTwoQuarter(__getDecimal(val));  
		if((val = values.get("revenueTreeQuarter")) != null) setRevenueTreeQuarter(__getDecimal(val));  
		if((val = values.get("revenueFourQuarter")) != null) setRevenueFourQuarter(__getDecimal(val));  
		if((val = values.get("capitalOneQuarter")) != null) setCapitalOneQuarter(__getDecimal(val));  
		if((val = values.get("capitalTwoQuarter")) != null) setCapitalTwoQuarter(__getDecimal(val));  
		if((val = values.get("capitalTreeQuarter")) != null) setCapitalTreeQuarter(__getDecimal(val));  
		if((val = values.get("capitalFourQuarter")) != null) setCapitalFourQuarter(__getDecimal(val));  
	}

	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.String  __customer_name ;
	protected java.math.BigDecimal  __revenue_amount_start ;
	protected java.math.BigDecimal  __capital_amount_start ;
	protected java.math.BigDecimal  __revenue_amount_end ;
	protected java.math.BigDecimal  __capital_amount_end ;
	protected java.math.BigDecimal  __revenue_one_quarter ;
	protected java.math.BigDecimal  __revenue_two_quarter ;
	protected java.math.BigDecimal  __revenue_tree_quarter ;
	protected java.math.BigDecimal  __revenue_four_quarter ;
	protected java.math.BigDecimal  __capital_one_quarter ;
	protected java.math.BigDecimal  __capital_two_quarter ;
	protected java.math.BigDecimal  __capital_tree_quarter ;
	protected java.math.BigDecimal  __capital_four_quarter ;
}
