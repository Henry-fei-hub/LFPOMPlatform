package com.pomplatform.client.onprojectquotetemplateworkflow.form;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.pomplatform.client.onprojectquotetemplateworkflow.datasource.DSOnProjectQuoteTemplate;
import com.pomplatform.client.onprojectquotetemplateworkflow.datasource.DSProjectQuoteDetail;

public class NewOnProjectQuoteTemplateForm extends GenericWizadWindow
{


	@Override
	public String getActionName(){
		// 需要根据实际业务修改
		return "ST_ProjectQuoteWithP";
	}

	@Override
	public boolean checkData(Map data){
		return true;
	}

	@Override
	public int getPageCount(){
		return 2;
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
		res.add(new OnProjectQuoteTemplateNewForm());
		res.add(new OnProjectQuoteTemplateDetailProjectQuoteDetail());
		return res;
	}


}

