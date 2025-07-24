package pomplatform.equipment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionMequipmentrecordedeor extends GenericCondition{

	public ConditionMequipmentrecordedeor(){
		setParameterCount(1);
	}

	public Integer getEquipmentId() {
		return this.__equipment_id;
	}

	public void setEquipmentId( Integer value ) {
		this.__equipment_id = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEquipmentId() != null) sb.append(__wrapNumber(1, "equipmentId", getEquipmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("equipmentId")) != null) setEquipmentId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getEquipmentId() != null) res.add("equipmentId");
		return res;
	}

	private Integer __equipment_id = null;
}

