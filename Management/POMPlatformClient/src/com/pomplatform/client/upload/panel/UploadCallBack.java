package com.pomplatform.client.upload.panel;

import java.util.Map;

import com.smartgwt.client.data.Record;

public interface UploadCallBack {
	public void execute(Map<String, Record> data);
}
