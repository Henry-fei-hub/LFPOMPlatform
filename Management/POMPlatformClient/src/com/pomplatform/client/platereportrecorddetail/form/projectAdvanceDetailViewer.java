package com.pomplatform.client.platereportrecorddetail.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class projectAdvanceDetailViewer extends HLayout
{
	private Record initRecord;
	private SearchForm __parentSearchForm;
	private DelicacyListGrid resultGrid = new DelicacyListGrid();
	private ListGridField plateId;//业务部门
	private ListGridField projectId;//项目ID
	private ListGridField advanceIntegral;//补贴积分
	private ListGridField leftIntegral;//剩余积分
	private ListGridField advanceDate;//补贴时间
	private ListGridField operateEmployeeId;//操作人
	private ListGridField remark;//备注
	private ListGridField flag;//类型
	//主面板
	private VLayout mainLayout;

	public Record getInitRecord() {
		return initRecord;
	}
	public void setInitRecord(Record initRecord) {
		this.initRecord = initRecord;
	}

	public void initComponents(){
		SC.debugger();
		setWidth100();
		setHeight100();
		//主面板
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		addMember(mainLayout);


		plateId = new ListGridField("plateId", "业务部门");
		plateId.setWidth("*");
		KeyValueManager.loadValueMap("system_dictionary_1" , plateId);
		plateId.setHidden(false);

		projectId = new ListGridField("projectId", "项目");
		projectId.setWidth("*");
		KeyValueManager.loadValueMap("projects" , projectId);
		projectId.setHidden(false);

		advanceIntegral = new ListGridField("advanceIntegral", "补贴积分");
		advanceIntegral.setWidth("*");
		advanceIntegral.setHidden(false);

		leftIntegral = new ListGridField("leftIntegral", "剩余积分");
		leftIntegral.setWidth("*");
		leftIntegral.setHidden(false);

		advanceDate = new ListGridField("advanceDate", "补贴时间");
		advanceDate.setWidth("*");
		advanceDate.setHidden(false);

		operateEmployeeId = new ListGridField("operateEmployeeId", "操作人");
		operateEmployeeId.setWidth("*");
		KeyValueManager.loadValueMap("employees" , operateEmployeeId);
		operateEmployeeId.setHidden(false);

		remark = new ListGridField("remark", "备注");
		remark.setWidth("*");
		remark.setHidden(false);

		flag = new ListGridField("flag", "类型");
		flag.setWidth("*");
		LinkedHashMap<String, Object> params = new LinkedHashMap<>();
		params.put("1" , "部门补贴");
		params.put("2" , "公司补贴");
		flag.setHidden(false);
		flag.setValueMap(params);
		resultGrid.setFields(plateId , projectId , advanceIntegral , leftIntegral , advanceDate , operateEmployeeId , remark , flag);
		mainLayout.addMember(resultGrid);
	}

	public void initData(){
		Record initRecord = getInitRecord();
		HashMap<String , Object> params = new HashMap<>();
		int projectId = BaseHelpUtils.getIntValue(initRecord.getAttribute("projectId"));
		params.put("projectId" , projectId);
		DBDataSource.callOperation("ST_ProjectAdvanceRecord", "find" ,params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				SC.debugger();
				if (dsResponse.getStatus() >= 0){
					resultGrid.setData(dsResponse.getData());
				}
			}
		});
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}
}

