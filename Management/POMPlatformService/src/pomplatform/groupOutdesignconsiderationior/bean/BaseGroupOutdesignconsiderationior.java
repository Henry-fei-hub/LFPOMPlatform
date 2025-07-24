package pomplatform.groupOutdesignconsiderationior.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGroupOutdesignconsiderationior extends GenericBase implements BaseFactory<BaseGroupOutdesignconsiderationior>, Comparable<BaseGroupOutdesignconsiderationior> 
{


	public static BaseGroupOutdesignconsiderationior newInstance(){
		return new BaseGroupOutdesignconsiderationior();
	}

	@Override
	public BaseGroupOutdesignconsiderationior make(){
		BaseGroupOutdesignconsiderationior b = new BaseGroupOutdesignconsiderationior();
		return b;
	}

	public final static java.lang.String CS_FINALIZED_MONEY = "finalized_money" ;
	public final static java.lang.String CS_INTERIOR_MONEY_SUM = "interior_money_sum" ;
	public final static java.lang.String CS_MONEY_SUM = "money_sum" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_NEW_CREATE_QUOTATION_NAME = "new_create_quotation_name" ;
	public final static java.lang.String CS_OUT_QUOTATION_ID = "out_quotation_id" ;
	public final static java.lang.String CS_QUOTATION_STATUS = "quotation_status" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;

	public final static java.lang.String ALL_CAPTIONS = "最终报价,内部设计面积总金额,小计 设计面积总金额,信息编号,新建的报价单名称,报价单表编码,报价单的状态 1成功 2不成功 3报价中...";

	public java.math.BigDecimal getFinalizedMoney() {
		return this.__finalized_money;
	}

	public void setFinalizedMoney( java.math.BigDecimal value ) {
		this.__finalized_money = value;
	}

	public java.math.BigDecimal getInteriorMoneySum() {
		return this.__interior_money_sum;
	}

	public void setInteriorMoneySum( java.math.BigDecimal value ) {
		this.__interior_money_sum = value;
	}

	public java.math.BigDecimal getMoneySum() {
		return this.__money_sum;
	}

	public void setMoneySum( java.math.BigDecimal value ) {
		this.__money_sum = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getNewCreateQuotationName() {
		return this.__new_create_quotation_name;
	}

	public void setNewCreateQuotationName( java.lang.String value ) {
		this.__new_create_quotation_name = value;
	}

	public java.lang.Integer getOutQuotationId() {
		return this.__out_quotation_id;
	}

	public void setOutQuotationId( java.lang.Integer value ) {
		this.__out_quotation_id = value;
	}

	public java.lang.Integer getQuotationStatus() {
		return this.__quotation_status;
	}

	public void setQuotationStatus( java.lang.Integer value ) {
		this.__quotation_status = value;
	}
	
	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public void cloneCopy(BaseGroupOutdesignconsiderationior __bean){
		__bean.setFinalizedMoney(getFinalizedMoney());
		__bean.setInteriorMoneySum(getInteriorMoneySum());
		__bean.setMoneySum(getMoneySum());
		__bean.setInfoCode(getInfoCode());
		__bean.setNewCreateQuotationName(getNewCreateQuotationName());
		__bean.setOutQuotationId(getOutQuotationId());
		__bean.setQuotationStatus(getQuotationStatus());
		__bean.setProjectCode(getProjectCode());
		__bean.setContractId(getContractId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFinalizedMoney() == null ? "" : getFinalizedMoney());
		sb.append(",");
		sb.append(getInteriorMoneySum() == null ? "" : getInteriorMoneySum());
		sb.append(",");
		sb.append(getMoneySum() == null ? "" : getMoneySum());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getNewCreateQuotationName() == null ? "" : getNewCreateQuotationName());
		sb.append(",");
		sb.append(getOutQuotationId() == null ? "" : getOutQuotationId());
		sb.append(",");
		String strQuotationStatus = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getQuotationStatus()));
		sb.append(strQuotationStatus == null ? "" : strQuotationStatus);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGroupOutdesignconsiderationior o) {
		return __finalized_money == null ? -1 : __finalized_money.compareTo(o.getFinalizedMoney());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__finalized_money);
		hash = 97 * hash + Objects.hashCode(this.__interior_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__money_sum);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__new_create_quotation_name);
		hash = 97 * hash + Objects.hashCode(this.__out_quotation_id);
		hash = 97 * hash + Objects.hashCode(this.__quotation_status);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGroupOutdesignconsiderationior o = (BaseGroupOutdesignconsiderationior)obj;
		if(!Objects.equals(this.__finalized_money, o.getFinalizedMoney())) return false;
		if(!Objects.equals(this.__interior_money_sum, o.getInteriorMoneySum())) return false;
		if(!Objects.equals(this.__money_sum, o.getMoneySum())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__new_create_quotation_name, o.getNewCreateQuotationName())) return false;
		if(!Objects.equals(this.__out_quotation_id, o.getOutQuotationId())) return false;
		if(!Objects.equals(this.__quotation_status, o.getQuotationStatus())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFinalizedMoney() != null) sb.append(__wrapDecimal(count++, "finalizedMoney", getFinalizedMoney()));
		if(getInteriorMoneySum() != null) sb.append(__wrapDecimal(count++, "interiorMoneySum", getInteriorMoneySum()));
		if(getMoneySum() != null) sb.append(__wrapDecimal(count++, "moneySum", getMoneySum()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getNewCreateQuotationName() != null) sb.append(__wrapString(count++, "newCreateQuotationName", getNewCreateQuotationName()));
		if(getOutQuotationId() != null) sb.append(__wrapNumber(count++, "outQuotationId", getOutQuotationId()));
		if(getQuotationStatus() != null) sb.append(__wrapNumber(count++, "quotationStatus", getQuotationStatus()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("finalizedMoney")) != null) setFinalizedMoney(__getDecimal(val));  
		if((val = values.get("interiorMoneySum")) != null) setInteriorMoneySum(__getDecimal(val));  
		if((val = values.get("moneySum")) != null) setMoneySum(__getDecimal(val));  
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("newCreateQuotationName")) != null) setNewCreateQuotationName(__getString(val));
		if((val = values.get("outQuotationId")) != null) setOutQuotationId(__getInt(val)); 
		if((val = values.get("quotationStatus")) != null) setQuotationStatus(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		
	}

	protected java.math.BigDecimal  __finalized_money ;
	protected java.math.BigDecimal  __interior_money_sum ;
	protected java.math.BigDecimal  __money_sum ;
	protected java.lang.String  __info_code ;
	protected java.lang.String  __new_create_quotation_name ;
	protected java.lang.Integer  __out_quotation_id ;
	protected java.lang.Integer  __quotation_status ;
	protected java.lang.String  __project_code ;
	protected java.lang.Integer  __contract_id ;
}
