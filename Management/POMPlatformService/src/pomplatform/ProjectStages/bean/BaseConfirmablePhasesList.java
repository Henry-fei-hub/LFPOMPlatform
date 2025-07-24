package pomplatform.ProjectStages.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseConfirmablePhasesList extends GenericBase implements BaseFactory<BaseConfirmablePhasesList>, Comparable<BaseConfirmablePhasesList> 
{


	public static BaseConfirmablePhasesList newInstance(){
		return new BaseConfirmablePhasesList();
	}

	@Override
	public BaseConfirmablePhasesList make(){
		BaseConfirmablePhasesList b = new BaseConfirmablePhasesList();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_AMOUNT_SUM = "project_amount_sum" ;
	public final static java.lang.String CS_PERCENT_SUM = "percent_sum" ;
	public final static java.lang.String CS_BORROW_MONEY_SUM = "borrow_money_sum" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_NO_BORROW_MONEY_SUM = "no_borrow_money_sum" ;
	public final static java.lang.String CS_NO_PERCENT = "no_percent" ;

	public final static java.lang.String ALL_CAPTIONS = "主订单编码,订单编号,订单名称,信息编号,产值,已确认比例,已收款,已收款比例,未收款,未收款比例";

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.math.BigDecimal getProjectAmountSum() {
		return this.__project_amount_sum;
	}

	public void setProjectAmountSum( java.math.BigDecimal value ) {
		this.__project_amount_sum = value;
	}

	public java.math.BigDecimal getPercentSum() {
		return this.__percent_sum;
	}

	public void setPercentSum( java.math.BigDecimal value ) {
		this.__percent_sum = value;
	}
	

	public java.math.BigDecimal getBorrowMoneySum() {
		return this.__borrow_money_sum;
	}

	public void setBorrowMoneySum( java.math.BigDecimal value ) {
		this.__borrow_money_sum = value;
	}

	public java.math.BigDecimal getPercent() {
		return this.__percent;
	}

	public void setPercent( java.math.BigDecimal value ) {
		this.__percent = value;
	}

	public java.math.BigDecimal getNoBorrowMoneySum() {
		return this.__no_borrow_money_sum;
	}

	public void setNoBorrowMoneySum( java.math.BigDecimal value ) {
		this.__no_borrow_money_sum = value;
	}

	public java.math.BigDecimal getNoPercent() {
		return this.__no_percent;
	}

	public void setNoPercent( java.math.BigDecimal value ) {
		this.__no_percent = value;
	}

	public void cloneCopy(BaseConfirmablePhasesList __bean){
		__bean.setContractId(getContractId());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectAmountSum(getProjectAmountSum());
		__bean.setPercentSum(getPercentSum());
		__bean.setBorrowMoneySum(getBorrowMoneySum());
		__bean.setPercent(getPercent());
		__bean.setNoBorrowMoneySum(getNoBorrowMoneySum());
		__bean.setNoPercent(getNoPercent());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectAmountSum() == null ? "" : getProjectAmountSum());
		sb.append(",");
		sb.append(getPercentSum() == null ? "" : getPercentSum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseConfirmablePhasesList o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_amount_sum);
		hash = 97 * hash + Objects.hashCode(this.__percent_sum);
		hash = 97 * hash + Objects.hashCode(this.__borrow_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__no_borrow_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__no_percent);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseConfirmablePhasesList o = (BaseConfirmablePhasesList)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_amount_sum, o.getProjectAmountSum())) return false;
		if(!Objects.equals(this.__percent_sum, o.getPercentSum())) return false;
		if(!Objects.equals(this.__borrow_money_sum, o.getBorrowMoneySum())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__no_borrow_money_sum, o.getNoBorrowMoneySum())) return false;
		if(!Objects.equals(this.__no_percent, o.getNoPercent())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectAmountSum() != null) sb.append(__wrapDecimal(count++, "projectAmountSum", getProjectAmountSum()));
		if(getPercentSum() != null) sb.append(__wrapDecimal(count++, "percentSum", getPercentSum()));
		if(getBorrowMoneySum() != null) sb.append(__wrapDecimal(count++, "borrowMoneySum", getBorrowMoneySum()));
		if(getPercent() != null) sb.append(__wrapDecimal(count++, "percent", getPercent()));
		if(getNoBorrowMoneySum() != null) sb.append(__wrapDecimal(count++, "noBorrowMoneySum", getNoBorrowMoneySum()));
		if(getNoPercent() != null) sb.append(__wrapDecimal(count++, "noPercent", getNoPercent()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getInfoCode() != null) res.put("infoCode", getInfoCode());
		if(getProjectAmountSum() != null) res.put("projectAmountSum", getProjectAmountSum());
		if(getPercentSum() != null) res.put("percentSum", getPercentSum());
		if(getBorrowMoneySum() != null) res.put("borrowMoneySum", getBorrowMoneySum());
		if(getPercent() != null) res.put("percent", getPercent());
		if(getNoBorrowMoneySum() != null) res.put("noBorrowMoneySum", getNoBorrowMoneySum());
		if(getNoPercent() != null) res.put("noPercent", getNoPercent());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectAmountSum")) != null) setProjectAmountSum(__getDecimal(val));  
		if((val = values.get("percentSum")) != null) setPercentSum(__getDecimal(val));  
		if((val = values.get("borrowMoneySum")) != null) setBorrowMoneySum(__getDecimal(val));  
		if((val = values.get("percent")) != null) setPercent(__getDecimal(val));  
		if((val = values.get("noBorrowMoneySum")) != null) setNoBorrowMoneySum(__getDecimal(val));  
		if((val = values.get("noPercent")) != null) setNoPercent(__getDecimal(val));  
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __info_code ;
	protected java.math.BigDecimal  __project_amount_sum ;
	protected java.math.BigDecimal  __percent_sum ;
	protected java.math.BigDecimal  __borrow_money_sum ;
	protected java.math.BigDecimal  __percent ;
	protected java.math.BigDecimal  __no_borrow_money_sum ;
	protected java.math.BigDecimal  __no_percent ;
}
