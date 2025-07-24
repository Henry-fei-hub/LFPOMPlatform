package pomplatform.bank.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseBankManager extends GenericBase implements BaseFactory<BaseBankManager>, Comparable<BaseBankManager> 
{


	public static BaseBankManager newInstance(){
		return new BaseBankManager();
	}

	@Override
	public BaseBankManager make(){
		BaseBankManager b = new BaseBankManager();
		return b;
	}

	public final static java.lang.String CS_BANK_ID = "bank_id" ;
	public final static java.lang.String CS_BANK_NAME = "bank_name" ;
	public final static java.lang.String CS_ORDER_NUM = "order_num" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "bank_id,银行名称,排序 越小排越前,创建时间";

	public java.lang.Integer getBankId() {
		return this.__bank_id;
	}

	public void setBankId( java.lang.Integer value ) {
		this.__bank_id = value;
	}

	public java.lang.String getBankName() {
		return this.__bank_name;
	}

	public void setBankName( java.lang.String value ) {
		this.__bank_name = value;
	}

	public java.lang.Integer getOrderNum() {
		return this.__order_num;
	}

	public void setOrderNum( java.lang.Integer value ) {
		this.__order_num = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseBankManager __bean){
		__bean.setBankId(getBankId());
		__bean.setBankName(getBankName());
		__bean.setOrderNum(getOrderNum());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBankId() == null ? "" : getBankId());
		sb.append(",");
		sb.append(getBankName() == null ? "" : getBankName());
		sb.append(",");
		sb.append(getOrderNum() == null ? "" : getOrderNum());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseBankManager o) {
		return __bank_id == null ? -1 : __bank_id.compareTo(o.getBankId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__bank_id);
		hash = 97 * hash + Objects.hashCode(this.__bank_name);
		hash = 97 * hash + Objects.hashCode(this.__order_num);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseBankManager o = (BaseBankManager)obj;
		if(!Objects.equals(this.__bank_id, o.getBankId())) return false;
		if(!Objects.equals(this.__bank_name, o.getBankName())) return false;
		if(!Objects.equals(this.__order_num, o.getOrderNum())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBankId() != null) sb.append(__wrapNumber(count++, "bankId", getBankId()));
		if(getBankName() != null) sb.append(__wrapString(count++, "bankName", getBankName()));
		if(getOrderNum() != null) sb.append(__wrapNumber(count++, "orderNum", getOrderNum()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("bankId")) != null) setBankId(__getInt(val)); 
		if((val = values.get("bankName")) != null) setBankName(__getString(val));
		if((val = values.get("orderNum")) != null) setOrderNum(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __bank_id ;
	protected java.lang.String  __bank_name ;
	protected java.lang.Integer  __order_num ;
	protected java.util.Date  __create_time ;
}
