package pomplatform.meeting.bean;

import delicacy.common.GenericCondition;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConditionMeetingWithConfree extends GenericCondition{

	public ConditionMeetingWithConfree(){
		setParameterCount(1);
	}

	public Integer getMeetingRecordChartId() {
		return this.__meeting_record_chart_id;
	}

	public void setMeetingRecordChartId( Integer value ) {
		this.__meeting_record_chart_id = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMeetingRecordChartId() != null) sb.append(__wrapNumber(1, "meetingRecordChartId", getMeetingRecordChartId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("meetingRecordChartId")) != null) setMeetingRecordChartId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getMeetingRecordChartId() != null) res.add("meetingRecordChartId");
		return res;
	}

	private Integer __meeting_record_chart_id = null;
}

