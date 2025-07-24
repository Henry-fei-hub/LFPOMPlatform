package pomplatform.employee.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseContractDistributionNew extends GenericBase implements BaseFactory<BaseContractDistributionNew>, Comparable<BaseContractDistributionNew> 
{


	public static BaseContractDistributionNew newInstance(){
		return new BaseContractDistributionNew();
	}

	@Override
	public BaseContractDistributionNew make(){
		BaseContractDistributionNew b = new BaseContractDistributionNew();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_DATE = "contract_date" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_PLATE_NAME = "plate_name" ;
	public final static java.lang.String CS_REAL_RELATIVELY = "real_relatively" ;
	public final static java.lang.String CS_RELATIVELY_PROGRESS = "relatively_progress" ;
	public final static java.lang.String CS_SUM = "sum" ;

	public final static java.lang.String ALL_CAPTIONS = "合同编码,主订单编号,合同签订日期,主订单名称,签约总金额,业态,业务部门名称,,相对进度,";
	public final static java.lang.String EXPORT_CAPTIONS = "合同编号,合同签订日期,合同名称,签约总金额,业务部门,项目总进度(%),提成进度(%),提成金额";

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

	public java.util.Date getContractDate() {
		return this.__contract_date;
	}

	public void setContractDate( java.util.Date value ) {
		this.__contract_date = value;
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

	public java.lang.String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	public java.lang.String getPlateName() {
		return this.__plate_name;
	}

	public void setPlateName( java.lang.String value ) {
		this.__plate_name = value;
	}

	public java.math.BigDecimal getRealRelatively() {
		return this.__real_relatively;
	}

	public void setRealRelatively( java.math.BigDecimal value ) {
		this.__real_relatively = value;
	}

	public java.math.BigDecimal getRelativelyProgress() {
		return this.__relatively_progress;
	}

	public void setRelativelyProgress( java.math.BigDecimal value ) {
		this.__relatively_progress = value;
	}

	public java.math.BigDecimal getSum() {
		return this.__sum;
	}

	public void setSum( java.math.BigDecimal value ) {
		this.__sum = value;
	}

	public void cloneCopy(BaseContractDistributionNew __bean){
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractDate(getContractDate());
		__bean.setContractName(getContractName());
		__bean.setSigningMoneySum(getSigningMoneySum());
		__bean.setBusinessType(getBusinessType());
		__bean.setPlateName(getPlateName());
		__bean.setRealRelatively(getRealRelatively());
		__bean.setRelativelyProgress(getRelativelyProgress());
		__bean.setSum(getSum());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractDate() == null ? "" : sdf.format(getContractDate()));
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		sb.append(",");
		sb.append(getPlateName() == null ? "" : getPlateName());
		sb.append(",");
		sb.append(getRealRelatively() == null ? "" : getRealRelatively());
		sb.append(",");
		sb.append(getRelativelyProgress() == null ? "" : getRelativelyProgress());
		sb.append(",");
		sb.append(getSum() == null ? "" : getSum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractDistributionNew o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_date);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__plate_name);
		hash = 97 * hash + Objects.hashCode(this.__real_relatively);
		hash = 97 * hash + Objects.hashCode(this.__relatively_progress);
		hash = 97 * hash + Objects.hashCode(this.__sum);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractDistributionNew o = (BaseContractDistributionNew)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_date, o.getContractDate())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__plate_name, o.getPlateName())) return false;
		if(!Objects.equals(this.__real_relatively, o.getRealRelatively())) return false;
		if(!Objects.equals(this.__relatively_progress, o.getRelativelyProgress())) return false;
		if(!Objects.equals(this.__sum, o.getSum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractDate() != null) sb.append(__wrapDate(count++, "contractDate", getContractDate()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getSigningMoneySum() != null) sb.append(__wrapDecimal(count++, "signingMoneySum", getSigningMoneySum()));
		if(getBusinessType() != null) sb.append(__wrapString(count++, "businessType", getBusinessType()));
		if(getPlateName() != null) sb.append(__wrapString(count++, "plateName", getPlateName()));
		if(getRealRelatively() != null) sb.append(__wrapDecimal(count++, "realRelatively", getRealRelatively()));
		if(getRelativelyProgress() != null) sb.append(__wrapDecimal(count++, "relativelyProgress", getRelativelyProgress()));
		if(getSum() != null) sb.append(__wrapDecimal(count++, "sum", getSum()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getContractDate() != null) res.put("contractDate", getContractDate());
		if(getContractName() != null) res.put("contractName", getContractName());
		if(getSigningMoneySum() != null) res.put("signingMoneySum", getSigningMoneySum());
		if(getBusinessType() != null) res.put("businessType", getBusinessType());
		if(getPlateName() != null) res.put("plateName", getPlateName());
		if(getRealRelatively() != null) res.put("realRelatively", getRealRelatively());
		if(getRelativelyProgress() != null) res.put("relativelyProgress", getRelativelyProgress());
		if(getSum() != null) res.put("sum", getSum());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractDate")) != null) setContractDate(__getDate(val)); 
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
		if((val = values.get("plateName")) != null) setPlateName(__getString(val));
		if((val = values.get("realRelatively")) != null) setRealRelatively(__getDecimal(val));  
		if((val = values.get("relativelyProgress")) != null) setRelativelyProgress(__getDecimal(val));  
		if((val = values.get("sum")) != null) setSum(__getDecimal(val));  
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.util.Date  __contract_date ;
	protected java.lang.String  __contract_name ;
	protected java.math.BigDecimal  __signing_money_sum ;
	protected java.lang.String  __business_type ;
	protected java.lang.String  __plate_name ;
	protected java.math.BigDecimal  __real_relatively ;
	protected java.math.BigDecimal  __relatively_progress ;
	protected java.math.BigDecimal  __sum ;
}
