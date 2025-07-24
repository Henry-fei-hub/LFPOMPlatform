package pomplatform.k3voucher.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseBankTransVoucherInfo extends GenericBase implements BaseFactory<BaseBankTransVoucherInfo>, Comparable<BaseBankTransVoucherInfo> 
{


	public static BaseBankTransVoucherInfo newInstance(){
		return new BaseBankTransVoucherInfo();
	}

	@Override
	public BaseBankTransVoucherInfo make(){
		BaseBankTransVoucherInfo b = new BaseBankTransVoucherInfo();
		return b;
	}

	public final static java.lang.String CS_CARD_MANAGE_ID = "card_manage_id" ;
	public final static java.lang.String CS_TRANS_CODE = "trans_code" ;
	public final static java.lang.String CS_DEBIT = "debit" ;
	public final static java.lang.String CS_CREDIT = "credit" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "银行卡ID,交易类型,借方,贷方,备注摘要";

	public java.lang.Integer getCardManageId() {
		return this.__card_manage_id;
	}

	public void setCardManageId( java.lang.Integer value ) {
		this.__card_manage_id = value;
	}

	public java.lang.String getTransCode() {
		return this.__trans_code;
	}

	public void setTransCode( java.lang.String value ) {
		this.__trans_code = value;
	}

	public java.math.BigDecimal getDebit() {
		return this.__debit;
	}

	public void setDebit( java.math.BigDecimal value ) {
		this.__debit = value;
	}

	public java.math.BigDecimal getCredit() {
		return this.__credit;
	}

	public void setCredit( java.math.BigDecimal value ) {
		this.__credit = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseBankTransVoucherInfo __bean){
		__bean.setCardManageId(getCardManageId());
		__bean.setTransCode(getTransCode());
		__bean.setDebit(getDebit());
		__bean.setCredit(getCredit());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCardManageId() == null ? "" : getCardManageId());
		sb.append(",");
		sb.append(getTransCode() == null ? "" : getTransCode());
		sb.append(",");
		sb.append(getDebit() == null ? "" : getDebit());
		sb.append(",");
		sb.append(getCredit() == null ? "" : getCredit());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseBankTransVoucherInfo o) {
		return __card_manage_id == null ? -1 : __card_manage_id.compareTo(o.getCardManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__card_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__trans_code);
		hash = 97 * hash + Objects.hashCode(this.__debit);
		hash = 97 * hash + Objects.hashCode(this.__credit);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseBankTransVoucherInfo o = (BaseBankTransVoucherInfo)obj;
		if(!Objects.equals(this.__card_manage_id, o.getCardManageId())) return false;
		if(!Objects.equals(this.__trans_code, o.getTransCode())) return false;
		if(!Objects.equals(this.__debit, o.getDebit())) return false;
		if(!Objects.equals(this.__credit, o.getCredit())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCardManageId() != null) sb.append(__wrapNumber(count++, "cardManageId", getCardManageId()));
		if(getTransCode() != null) sb.append(__wrapString(count++, "transCode", getTransCode()));
		if(getDebit() != null) sb.append(__wrapDecimal(count++, "debit", getDebit()));
		if(getCredit() != null) sb.append(__wrapDecimal(count++, "credit", getCredit()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getCardManageId() != null) res.put("cardManageId", getCardManageId());
		if(getTransCode() != null) res.put("transCode", getTransCode());
		if(getDebit() != null) res.put("debit", getDebit());
		if(getCredit() != null) res.put("credit", getCredit());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cardManageId")) != null) setCardManageId(__getInt(val)); 
		if((val = values.get("transCode")) != null) setTransCode(__getString(val));
		if((val = values.get("debit")) != null) setDebit(__getDecimal(val));  
		if((val = values.get("credit")) != null) setCredit(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __card_manage_id ;
	protected java.lang.String  __trans_code ;
	protected java.math.BigDecimal  __debit ;
	protected java.math.BigDecimal  __credit ;
	protected java.lang.String  __remark ;
}
