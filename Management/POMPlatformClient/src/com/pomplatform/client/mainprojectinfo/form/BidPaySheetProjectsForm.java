package com.pomplatform.client.mainprojectinfo.form;

import java.math.BigDecimal;
import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.ReadOnlyDisplayAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.employeerescord.datasource.DSEmployee;
import com.pomplatform.client.mainprojectinfo.datasource.DSBidPaySheetProject;
import com.pomplatform.client.mainprojectinfo.datasource.DSproject;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;

public class BidPaySheetProjectsForm extends AbstractWizadPage
{
	
//	private final TextItem projectIdItem;
//	private final TextItem projectCodeItem;
//	private final TextItem projectNameItem;
//	private final TextItem plateIdItem;
//	private final DoubleItem bigPayAmountItem;
	
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private DelicacyListGrid projectGrid;
	private HLayout projectLeaderLayout;

	public BidPaySheetProjectsForm() {
		DSproject ds = DSproject.getInstance();
		
		projectGrid = new DelicacyListGrid();
		int d = 0;
		ListGridField[] dFields = new ListGridField[6];
		dFields[d] = new ListGridField("projectId");
		dFields[d].setHidden(true);
		d++;
		dFields[d] = new ListGridField("contractCode","订单编号");
		dFields[d].setWidth("25%");
		d++;
		dFields[d] = new ListGridField("projectName","项目名称");
		dFields[d].setWidth("25%");
		d++;
		dFields[d] = new ListGridField("plateId","业务部门");
		dFields[d].setValueMap(KeyValueManager.getValueMap("plate_records"));
		dFields[d].setWidth("25%");
		d++;
		dFields[d] = new ListGridField("totalAmount","落标补偿金");
		dFields[d].setWidth("25%");
		dFields[d].setCanEdit(true);
		projectGrid.setDataSource(ds);
		projectGrid.setFields(dFields);
		projectGrid.setCanRemoveRecords(false);
		projectGrid.setHeaderHeight(60);
		projectGrid.setAutoFitFieldWidths(false);
		projectGrid.setShowGridSummary(false);
		
		projectLeaderLayout = new HLayout(10);
		projectLeaderLayout.setWidth100();
		projectLeaderLayout.setHeight100();
		projectLeaderLayout.addMember(projectGrid);
		addMember(projectLeaderLayout);
		
		
	}

	@Override
	public void startEdit() {
		if (getRecord() != null) {
			__form.editRecord(getRecord());
			loadData(BaseHelpUtils.getIntValue(record.getAttribute("linkId")));
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSBidPaySheetProject.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		SC.debugger();
		if(BaseHelpUtils.getBigDecimalValue(projectGrid.getAttribute("bigPayAmount")).compareTo(BigDecimal.ZERO) < 0){
			SC.say("提示","落标补偿款不能小于0");
			return false;
		}
		return true;
	}

	private void loadData(int contractId) {
		Map params = new HashMap();
		if(contractId>0) {
			params.put("contractId", contractId);
			params.put("projectType", 66);//投标订单
			DBDataSource.callOperation("ST_Project", "find",params, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						if(dsResponse.getData().length>0) {
							projectGrid.setData(dsResponse.getData());
						}
					}
				}
			});
		}
		
	}
	
	@Override
	public java.util.Map getValuesAsMap() {
		Map projectReocrdsMap =new HashMap<>();
		MapUtils.convertRecordToMap(DSproject.getInstance(),projectGrid.getRecords(),projectReocrdsMap,"projectRecords");
		return projectReocrdsMap;
	}


}
