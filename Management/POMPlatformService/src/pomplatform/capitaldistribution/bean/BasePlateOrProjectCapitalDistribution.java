package pomplatform.capitaldistribution.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasePlateOrProjectCapitalDistribution extends GenericBase implements BaseFactory<BasePlateOrProjectCapitalDistribution>, Comparable<BasePlateOrProjectCapitalDistribution> 
{


	public static BasePlateOrProjectCapitalDistribution newInstance(){
		return new BasePlateOrProjectCapitalDistribution();
	}

	@Override
	public BasePlateOrProjectCapitalDistribution make(){
		BasePlateOrProjectCapitalDistribution b = new BasePlateOrProjectCapitalDistribution();
		return b;
	}

	public final static java.lang.String CS_CAPITAL_DISTRIBUTION_ID = "capital_distribution_id" ;
	public final static java.lang.String CS_HAPPEN_DATE = "happen_date" ;
	public final static java.lang.String CS_BORROW_MONEY = "borrow_money" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_CAPITAL_ID = "capital_id" ;
	public final static java.lang.String CS_ID = "id" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_DISTRIBUTION_AMOUNT = "distribution_amount" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;

	public final static java.lang.String ALL_CAPTIONS = "回款分配表编码,回款日期,回款金额, 2订单回款分配,回款编码,部门或者订单编码,,回款分配金额,操作人,创建时间,备注,板块";

	public java.lang.Integer getCapitalDistributionId() {
		return this.__capital_distribution_id;
	}

	public void setCapitalDistributionId( java.lang.Integer value ) {
		this.__capital_distribution_id = value;
	}

	public java.util.Date getHappenDate() {
		return this.__happen_date;
	}

	public void setHappenDate( java.util.Date value ) {
		this.__happen_date = value;
	}

	public java.math.BigDecimal getBorrowMoney() {
		return this.__borrow_money;
	}

	public void setBorrowMoney( java.math.BigDecimal value ) {
		this.__borrow_money = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	public java.lang.Integer getId() {
		return this.__id;
	}

	public void setId( java.lang.Integer value ) {
		this.__id = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.math.BigDecimal getDistributionAmount() {
		return this.__distribution_amount;
	}

	public void setDistributionAmount( java.math.BigDecimal value ) {
		this.__distribution_amount = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public void cloneCopy(BasePlateOrProjectCapitalDistribution __bean){
		__bean.setCapitalDistributionId(getCapitalDistributionId());
		__bean.setHappenDate(getHappenDate());
		__bean.setBorrowMoney(getBorrowMoney());
		__bean.setType(getType());
		__bean.setCapitalId(getCapitalId());
		__bean.setId(getId());
		__bean.setCode(getCode());
		__bean.setDistributionAmount(getDistributionAmount());
		__bean.setOperator(getOperator());
		__bean.setCreateTime(getCreateTime());
		__bean.setRemark(getRemark());
		__bean.setPlateId(getPlateId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCapitalDistributionId() == null ? "" : getCapitalDistributionId());
		sb.append(",");
		sb.append(getHappenDate() == null ? "" : sdf.format(getHappenDate()));
		sb.append(",");
		sb.append(getBorrowMoney() == null ? "" : getBorrowMoney());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getCapitalId() == null ? "" : getCapitalId());
		sb.append(",");
		String strId = delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(getId()));
		sb.append(strId == null ? "" : strId);
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getDistributionAmount() == null ? "" : getDistributionAmount());
		sb.append(",");
		String strOperator = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getOperator()));
		sb.append(strOperator == null ? "" : strOperator);
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		return sb.toString();
	}

	@Override
	public int compareTo(BasePlateOrProjectCapitalDistribution o) {
		return __capital_distribution_id == null ? -1 : __capital_distribution_id.compareTo(o.getCapitalDistributionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__capital_distribution_id);
		hash = 97 * hash + Objects.hashCode(this.__happen_date);
		hash = 97 * hash + Objects.hashCode(this.__borrow_money);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__capital_id);
		hash = 97 * hash + Objects.hashCode(this.__id);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__distribution_amount);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePlateOrProjectCapitalDistribution o = (BasePlateOrProjectCapitalDistribution)obj;
		if(!Objects.equals(this.__capital_distribution_id, o.getCapitalDistributionId())) return false;
		if(!Objects.equals(this.__happen_date, o.getHappenDate())) return false;
		if(!Objects.equals(this.__borrow_money, o.getBorrowMoney())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__capital_id, o.getCapitalId())) return false;
		if(!Objects.equals(this.__id, o.getId())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__distribution_amount, o.getDistributionAmount())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCapitalDistributionId() != null) sb.append(__wrapNumber(count++, "capitalDistributionId", getCapitalDistributionId()));
		if(getHappenDate() != null) sb.append(__wrapDate(count++, "happenDate", getHappenDate()));
		if(getBorrowMoney() != null) sb.append(__wrapDecimal(count++, "borrowMoney", getBorrowMoney()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getCapitalId() != null) sb.append(__wrapNumber(count++, "capitalId", getCapitalId()));
		if(getId() != null) sb.append(__wrapNumber(count++, "id", getId()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getDistributionAmount() != null) sb.append(__wrapDecimal(count++, "distributionAmount", getDistributionAmount()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("capitalDistributionId")) != null) setCapitalDistributionId(__getInt(val)); 
		if((val = values.get("happenDate")) != null) setHappenDate(__getDate(val)); 
		if((val = values.get("borrowMoney")) != null) setBorrowMoney(__getDecimal(val));  
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("id")) != null) setId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("distributionAmount")) != null) setDistributionAmount(__getDecimal(val));  
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
	}

	protected java.lang.Integer  __capital_distribution_id ;
	protected java.util.Date  __happen_date ;
	protected java.math.BigDecimal  __borrow_money ;
	protected java.lang.Integer  __type ;
	protected java.lang.Integer  __capital_id ;
	protected java.lang.Integer  __id ;
	protected java.lang.String  __code ;
	protected java.math.BigDecimal  __distribution_amount ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __plate_id ;
}
