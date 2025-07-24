package com.pomplatform.client.cwd.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;

public class NewCompanyWorkplaceAndServerManageForm extends GenericWizadWindow
{

	private static final Logger logger = Logger.getLogger("");

	@Override
	public String getActionName(){
		// 需要根据实际业务修改
		return "ST_CompanyWorkplaceWithC";
	}

	@Override
	public boolean checkData(Map data){
		boolean flag =  true;
		List<AbstractWizadPage> pageList = __pages;
		for (AbstractWizadPage abstractWizadPage : pageList) {
			if(!abstractWizadPage.checkData()){
				flag = false;
				break;
			}
		}
		return flag;
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
				Record[] records = dsResponse.getData();
				for(Record record : records) {
					int currentWorkplaceId = ClientUtil.checkAndGetIntValue(record.getAttribute("companyWorkplaceId"));
					Integer companyId = record.getAttributeAsInt("companyId");
					String currentWorkDir = record.getAttribute("workplaceDir");
					Record[] details = record.getAttributeAsRecordArray("detailCompanyWorkplaceServer");
					for(Record detail : details) {
						if(ClientUtil.isNullOrEmpty(detail.getAttribute("url")))
							continue;
						String url = detail.getAttribute("url");
						Map<String, Object> params = new HashMap<>();
						params.put("currentWorkplaceId", currentWorkplaceId);
						params.put("currentCompanyId", companyId);
						params.put("currentWorkDir", currentWorkDir);
						params.put("socketServerAddress", DBDataSource.getBaseURL());
						DBDataSource.callJSONP(url, "EP_SystemConfigProcessor", "find", MapUtils.toJSON(params), null, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								Record[] recordArr = dsResponse.getData();
								for(Record dataRecord : recordArr) {
									logger.info(dataRecord.toMap().toString());
								}
							}
						});
					}
				}
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		res.add(new CompanyWorkplaceAndServerManageNewForm());
		res.add(new CompanyWorkplaceDetailCompanyWorkplaceServer());
		return res;
	}


}

