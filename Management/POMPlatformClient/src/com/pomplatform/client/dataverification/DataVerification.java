package com.pomplatform.client.dataverification;

import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.util.SC;

public class DataVerification {

	public static boolean checkProjectStagePercent(Map data) {
		if (!ClientUtil.isNullOrEmpty(data.get("detailProjectStage"))) {
			List<Map> list = (List)data.get("detailProjectStage");
			double percentSum = 0.0;
			if(null != list && !list.isEmpty()){
				for(Map map : list){
					if(BaseHelpUtils.isNullOrEmpty(map.get("percent"))){
						SC.say("提示","项目的阶段占比不能为空");
						return false;
					}
					percentSum += ClientUtil.checkAndGetDoubleValue(map.get("percent"));
				}
			}
			if(percentSum > 100){
				SC.say("提示","项目的阶段占比总和不能超过100%");
				return false;
			}
			return true;
		}else {
			SC.say("提示","项目阶段不能为空");
			return false;
		}
	}
	
	
	public static boolean checkProjectStagePercent2(Map data) {
	    if(BaseHelpUtils.isNullOrEmpty(data.get("projectTemplateName"))) {
	    	SC.say("模板名称不能为空");
	    	return false;
	    }
	    if(BaseHelpUtils.getIntValue(data.get("projectType"))<=0) {
	    	SC.say("项目类型不能为空");
	    	return false;
	    }
	    if(BaseHelpUtils.getIntValue(data.get("plateId"))<=0) {
	    	SC.say("业务部门不能为空");
	    	return false;
	    }
	    if(BaseHelpUtils.getIntValue(data.get("businessType"))<=0) {
	    	SC.say("业务类型不能为空");
	    	return false;
	    }

		if (!ClientUtil.isNullOrEmpty(data.get("detailProjectStage"))) {
			List<Map> list = (List)data.get("detailProjectStage");
			double percentSum = 0.0;
			if(null != list && !list.isEmpty()){
				for(Map map : list){
					if(BaseHelpUtils.isNullOrEmpty(map.get("percent"))){
						SC.say("提示","项目的阶段占比不能为空");
						return false;
					}
					percentSum += ClientUtil.checkAndGetDoubleValue(map.get("percent"));
				}
			}
			if(percentSum > 100){
				SC.say("提示","项目的阶段占比总和不能超过100%");
				return false;
			}
			return true;
		}else {
			SC.say("提示","项目阶段不能为空");
			return false;
		}
	}
}
