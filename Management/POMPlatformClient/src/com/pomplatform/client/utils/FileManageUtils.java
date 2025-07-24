package com.pomplatform.client.utils;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

public class FileManageUtils {

	/**
	 * 根据ID，增加引用次数1次
	 * @param id 需要修改fileManage表引用次数的ID，如果有多个ID，用“,”拼接起来
	 */
	public static void addTimes(final String id) {
		if(BaseHelpUtils.isNullOrEmpty(id)) {
			return;
		}
		Map<String, String> params = new HashMap<>();
		params.put("optType", "addTimes");
		params.put("id", id);
		DBDataSource.callOperation("EP_FileManageProcessor", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() < 0) {
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}
	
	/**
	 * 根据ID，减少引用次数1次
	 * @param id 需要修改fileManage表引用次数的ID，如果有多个ID，用“,”拼接起来
	 */
	public static void subtractTimes(final String id) {
		if(BaseHelpUtils.isNullOrEmpty(id)) {
			return;
		}
		Map<String, String> params = new HashMap<>();
		params.put("optType", "subtractTimes");
		params.put("id", id);
		DBDataSource.callOperation("EP_FileManageProcessor", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() < 0) {
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}
}
