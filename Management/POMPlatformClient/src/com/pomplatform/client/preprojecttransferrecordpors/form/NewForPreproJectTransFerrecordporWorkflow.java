package com.pomplatform.client.preprojecttransferrecordpors.form;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.AbstractProcessPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.HashMap;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.pomplatform.client.preprojecttransferrecordpors.datasource.DSForPreproJectTransFerrecordpor;

public class NewForPreproJectTransFerrecordporWorkflow extends AbstractProcessPanel
{
	private static Logger __logger = Logger.getLogger("");

	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("preProjectTransferRecordId", getBusinessId());
		DBDataSource.callOperation("NQ_ForPreproJectTransFerrecordpor", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					setData(dsResponse.getData()[0]);
					if(__pages == null) __pages = getPages();
					for(AbstractWizadPage wp : __pages) { wp.setRecord(getData()); wp.startEdit(); }
				}
			}
		});
	}

	@Override
	public boolean checkData(Map data){
		return true;
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
		List<AbstractWizadPage> res = new ArrayList<>();
		Record record = getData();
		ForPreproJectTransFerrecordporNewForm panel=new ForPreproJectTransFerrecordporNewForm();
		panel.setRecord(record);
		res.add(panel);
		return res;
	}


}

