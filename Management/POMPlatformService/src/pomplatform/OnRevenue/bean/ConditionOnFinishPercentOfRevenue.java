package pomplatform.OnRevenue.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnFinishPercentOfRevenue extends GenericCondition{

	public ConditionOnFinishPercentOfRevenue(){
		setParameterCount(1);
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
	}

	private java.lang.String __contract_code = null;
}

