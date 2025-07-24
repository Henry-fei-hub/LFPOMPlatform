package pomplatform.workflow.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionFileManages extends GenericCondition{

	public ConditionFileManages(){
		setParameterCount(1);
	}



	public Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( Integer value ) {
		this.__file_id = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getFileId() != null) sb.append(__wrapNumber(1, "fileId", getFileId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
	}

	private Integer __file_id = null;
}

