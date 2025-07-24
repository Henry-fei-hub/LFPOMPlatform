package com.pomplatform.client.shift.form;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;

public class UpdateManageShiftTimeForm extends GenericWizadWindow
{


	@Override
	public String getActionName(){
		// 需要根据实际业务修改
		return "ST_ShiftTimeManage";
	}

	@Override
	public boolean checkData(Map data){
		if(checkData(data, "shiftTimeName")){
			SC.say("请填写<font style='color:red'>时段名称</font>");
			return false;
		}
		if(checkData(data, "overtimeStartTime")){
			SC.say("请填写<font style='color:red'>开始算加班时间</font>");
			return false;
		}
		if(checkData(data, "signInTime")){
			SC.say("请填写<font style='color:red'>上班时间</font>");
			return false;
		}
		if(checkData(data, "signOffTime")){
			SC.say("请填写<font style='color:red'>下班时间</font>");
			return false;
		}
		if(checkData(data, "lateMinutes")){
			SC.say("请填写<font style='color:red'>计迟到时间</font>");
			return false;
		}
		if(checkData(data, "leaveEarlyTime")){
			SC.say("请填写<font style='color:red'>计早退时间</font>");
			return false;
		}
		if(checkData(data, "signInStartTime")){
			SC.say("请填写<font style='color:red'>签到开始时间</font>");
			return false;
		}
		if(checkData(data, "signInEndTime")){
			SC.say("请填写<font style='color:red'>签到结束时间</font>");
			return false;
		}
		if(checkData(data, "signOffStartTime")){
			SC.say("请填写<font style='color:red'>签退开始时间</font>");
			return false;
		}
		if(checkData(data, "signOffEndTime")){
			SC.say("请填写<font style='color:red'>签退结束时间</font>");
			return false;
		}
		if(checkData(data, "days")){
			SC.say("请填写<font style='color:red'>计多少工作日</font>");
			return false;
		}
		if(checkData(data, "minutes")){
			SC.say("请填写<font style='color:red'>计多少分钟</font>");
			return false;
		}
		return true;
	}

	private boolean checkData(Map data, String key){
		return (!data.containsKey(key) || (data.containsKey(key) && (null == data.get(key)) || data.get(key).toString().trim().length() == 0));
	}
	
	@Override
	public int getPageCount(){
		return 1;
	}

	@Override
	public List<AbstractWizadPage> getPages(){
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
			}
		});
		setSubaction("update");
		List<AbstractWizadPage> res = new ArrayList<>();
		res.add(new ManageShiftTimeUpdateForm());
		return res;
	}


}

