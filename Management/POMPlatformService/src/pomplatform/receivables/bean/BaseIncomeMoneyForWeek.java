package pomplatform.receivables.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseIncomeMoneyForWeek extends GenericBase implements BaseFactory<BaseIncomeMoneyForWeek>, Comparable<BaseIncomeMoneyForWeek> 
{


	public static BaseIncomeMoneyForWeek newInstance(){
		return new BaseIncomeMoneyForWeek();
	}

	@Override
	public BaseIncomeMoneyForWeek make(){
		BaseIncomeMoneyForWeek b = new BaseIncomeMoneyForWeek();
		return b;
	}

	public final static java.lang.String CS_MONEY_ATTRIBUTE = "money_attribute" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_OTHER_NAME = "other_name" ;
	public final static java.lang.String CS_BORROW_MONEY = "borrow_money" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_HAPPEN_DATE = "happen_date" ;

	public final static java.lang.String ALL_CAPTIONS = "款项属性,合同id,项目名称,项目总金额,项目收款进度,项目名称,收款金额,备注,发生日期";
	public final static java.lang.String FOR_EXPORT = "项目名称,收款金额,备注";

	public java.lang.Integer getMoneyAttribute() {
		return this.__money_attribute;
	}

	public void setMoneyAttribute( java.lang.Integer value ) {
		this.__money_attribute = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.math.BigDecimal getSigningMoneySum() {
		return this.__signing_money_sum;
	}

	public void setSigningMoneySum( java.math.BigDecimal value ) {
		this.__signing_money_sum = value;
	}

	public java.lang.String getPercent() {
		return this.__percent;
	}

	public void setPercent( java.lang.String value ) {
		this.__percent = value;
	}

	public java.lang.String getOtherName() {
		return this.__other_name;
	}

	public void setOtherName( java.lang.String value ) {
		this.__other_name = value;
	}

	public java.math.BigDecimal getBorrowMoney() {
		return this.__borrow_money;
	}

	public void setBorrowMoney( java.math.BigDecimal value ) {
		this.__borrow_money = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.util.Date getHappenDate() {
		return this.__happen_date;
	}

	public void setHappenDate( java.util.Date value ) {
		this.__happen_date = value;
	}

	public void cloneCopy(BaseIncomeMoneyForWeek __bean){
		__bean.setMoneyAttribute(getMoneyAttribute());
		__bean.setContractId(getContractId());
		__bean.setContractName(getContractName());
		__bean.setSigningMoneySum(getSigningMoneySum());
		__bean.setPercent(getPercent());
		__bean.setOtherName(getOtherName());
		__bean.setBorrowMoney(getBorrowMoney());
		__bean.setRemark(getRemark());
		__bean.setHappenDate(getHappenDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String otherName = getOtherName();
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getBorrowMoney() == null ? "" : getBorrowMoney());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseIncomeMoneyForWeek o) {
		return __money_attribute == null ? -1 : __money_attribute.compareTo(o.getMoneyAttribute());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__money_attribute);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__other_name);
		hash = 97 * hash + Objects.hashCode(this.__borrow_money);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__happen_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseIncomeMoneyForWeek o = (BaseIncomeMoneyForWeek)obj;
		if(!Objects.equals(this.__money_attribute, o.getMoneyAttribute())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__other_name, o.getOtherName())) return false;
		if(!Objects.equals(this.__borrow_money, o.getBorrowMoney())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__happen_date, o.getHappenDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMoneyAttribute() != null) sb.append(__wrapNumber(count++, "moneyAttribute", getMoneyAttribute()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getSigningMoneySum() != null) sb.append(__wrapDecimal(count++, "signingMoneySum", getSigningMoneySum()));
		if(getPercent() != null) sb.append(__wrapString(count++, "percent", getPercent()));
		if(getOtherName() != null) sb.append(__wrapString(count++, "otherName", getOtherName()));
		if(getBorrowMoney() != null) sb.append(__wrapDecimal(count++, "borrowMoney", getBorrowMoney()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getHappenDate() != null) sb.append(__wrapDate(count++, "happenDate", getHappenDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("moneyAttribute")) != null) setMoneyAttribute(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
		if((val = values.get("percent")) != null) setPercent(__getString(val));
		if((val = values.get("otherName")) != null) setOtherName(__getString(val));
		if((val = values.get("borrowMoney")) != null) setBorrowMoney(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("happenDate")) != null) setHappenDate(__getDate(val)); 
	}

	protected java.lang.Integer  __money_attribute ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_name ;
	protected java.math.BigDecimal  __signing_money_sum ;
	protected java.lang.String  __percent ;
	protected java.lang.String  __other_name ;
	protected java.math.BigDecimal  __borrow_money ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __happen_date ;
}
