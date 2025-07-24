package com.pomplatform.client.preprojects.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.preprojects.datasource.DSPreProjectReport;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.grid.ListGrid;

public class PreProjectReportViewer extends AbstractDetailViewer
{
	private static final Logger __logger = Logger.getLogger("");
	public PreProjectReportViewer() {
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "项目报备流程";
	}

	@Override
	public int getGroupCount() {
		return 0;
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<GroupColumn>();
//		gcs.add()
		return gcs;
	}

	@Override
	public void viewRecord(Record record) {
		int clientId = BaseHelpUtils.getIntValue(record.getAttribute("clientId"));
		Map<String,Object> params =new HashMap<>();
		params.put("customerId", clientId);
		DBDataSource.callOperation("ST_Customer", "find", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record result = dsResponse.getData()[0];
					if(!BaseHelpUtils.isNullOrEmpty(result)){
						record.setAttribute("customerType",result.getAttribute("customerType"));
						record.setAttribute("isWarehous",result.getAttribute("isWarehous"));
						record.setAttribute("isApplyQuote",result.getAttribute("isApplyQuote"));
					}
				}
				viewRecord(record, true);
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSPreProjectReport.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 0;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		return res;
	}


}

