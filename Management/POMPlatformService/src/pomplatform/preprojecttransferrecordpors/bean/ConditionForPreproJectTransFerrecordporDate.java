package pomplatform.preprojecttransferrecordpors.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionForPreproJectTransFerrecordporDate extends GenericCondition{

	public ConditionForPreproJectTransFerrecordporDate(){
		setParameterCount(1);
	}

	public java.lang.Integer getPreProjectTransferRecordId() {
		return this.__pre_project_transfer_record_id;
	}

	public void setPreProjectTransferRecordId( java.lang.Integer value ) {
		this.__pre_project_transfer_record_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPreProjectTransferRecordId() != null) sb.append(__wrapNumber(1, "preProjectTransferRecordId", getPreProjectTransferRecordId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("preProjectTransferRecordId")) != null) setPreProjectTransferRecordId(__getInt(val)); 
	}

	private java.lang.Integer __pre_project_transfer_record_id = null;
}

