package pomplatform.tmpcapitalsListItem.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseTmpcapitalstoinvoicecior extends GenericBase implements BaseFactory<BaseTmpcapitalstoinvoicecior>, Comparable<BaseTmpcapitalstoinvoicecior> 
{


	public static BaseTmpcapitalstoinvoicecior newInstance(){
		return new BaseTmpcapitalstoinvoicecior();
	}

	@Override
	public BaseTmpcapitalstoinvoicecior make(){
		BaseTmpcapitalstoinvoicecior b = new BaseTmpcapitalstoinvoicecior();
		return b;
	}

	public final static java.lang.String CS_HAPPEN_DATE = "happen_date" ;
	public final static java.lang.String CS_STAGE_PERCENTAGE = "stage_percentage" ;
	public final static java.lang.String CS_STAGE_SUM_MONEY = "stage_sum_money" ;

	public final static java.lang.String ALL_CAPTIONS = "发生日期,回款阶段百分比,回款阶段金额";

	public java.util.Date getHappenDate() {
		return this.__happen_date;
	}

	public void setHappenDate( java.util.Date value ) {
		this.__happen_date = value;
	}

	public java.math.BigDecimal getStagePercentage() {
		return this.__stage_percentage;
	}

	public void setStagePercentage( java.math.BigDecimal value ) {
		this.__stage_percentage = value;
	}

	public java.math.BigDecimal getStageSumMoney() {
		return this.__stage_sum_money;
	}

	public void setStageSumMoney( java.math.BigDecimal value ) {
		this.__stage_sum_money = value;
	}

	public void cloneCopy(BaseTmpcapitalstoinvoicecior __bean){
		__bean.setHappenDate(getHappenDate());
		__bean.setStagePercentage(getStagePercentage());
		__bean.setStageSumMoney(getStageSumMoney());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getHappenDate() == null ? "" : sdf.format(getHappenDate()));
		sb.append(",");
		sb.append(getStagePercentage() == null ? "" : getStagePercentage());
		sb.append(",");
		sb.append(getStageSumMoney() == null ? "" : getStageSumMoney());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseTmpcapitalstoinvoicecior o) {
		return __happen_date == null ? -1 : __happen_date.compareTo(o.getHappenDate());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__happen_date);
		hash = 97 * hash + Objects.hashCode(this.__stage_percentage);
		hash = 97 * hash + Objects.hashCode(this.__stage_sum_money);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseTmpcapitalstoinvoicecior o = (BaseTmpcapitalstoinvoicecior)obj;
		if(!Objects.equals(this.__happen_date, o.getHappenDate())) return false;
		if(!Objects.equals(this.__stage_percentage, o.getStagePercentage())) return false;
		if(!Objects.equals(this.__stage_sum_money, o.getStageSumMoney())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getHappenDate() != null) sb.append(__wrapDate(count++, "happenDate", getHappenDate()));
		if(getStagePercentage() != null) sb.append(__wrapDecimal(count++, "stagePercentage", getStagePercentage()));
		if(getStageSumMoney() != null) sb.append(__wrapDecimal(count++, "stageSumMoney", getStageSumMoney()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("happenDate")) != null) setHappenDate(__getDate(val)); 
		if((val = values.get("stagePercentage")) != null) setStagePercentage(__getDecimal(val));  
		if((val = values.get("stageSumMoney")) != null) setStageSumMoney(__getDecimal(val));  
	}

	protected java.util.Date  __happen_date ;
	protected java.math.BigDecimal  __stage_percentage ;
	protected java.math.BigDecimal  __stage_sum_money ;
}
