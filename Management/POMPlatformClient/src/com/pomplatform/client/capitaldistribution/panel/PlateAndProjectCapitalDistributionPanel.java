package com.pomplatform.client.capitaldistribution.panel;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PlateAndProjectCapitalDistributionPanel extends HLayout{
	private VLayout plateLayout;
	private VLayout projectLayout;
	private DelicacyListGrid plateGrid;
	private DelicacyListGrid projectGrid;
	
	public void initComponents(){
		setWidth100();
		setHeight100();
		
		plateLayout = new VLayout();
		plateLayout.setWidth("50%");
		plateLayout.setHeight100();
		
		Label plateLabel = new Label("<font style='font-weight:bold;'>部门回款分配明细</font>");
		plateLabel.setHeight(25);
		plateLabel.setBorder("1px solid #ABABAB; border-bottom:none;");
		plateLabel.setAlign(Alignment.CENTER);
		plateLayout.addMember(plateLabel);
		
		projectLayout = new VLayout();
		projectLayout.setWidth("50%");
		projectLayout.setHeight100();
		
		Label projectLabel = new Label("<font style='font-weight:bold;'>订单回款分配明细</font>");
		projectLabel.setHeight(25);
		projectLabel.setBorder("1px solid #ABABAB; border-bottom:none;");
		projectLabel.setAlign(Alignment.CENTER);
		projectLayout.addMember(projectLabel);
		
		addMembers(plateLayout, projectLayout);
		
		plateGrid = new DelicacyListGrid();
		plateGrid.setAutoFitFieldWidths(false);
		plateGrid.setWidth100();
		plateGrid.setShowRowNumbers(true);
		plateLayout.addMember(plateGrid);

		ListGridField[] plateFields = new ListGridField[5];
		int plateIndex = 0;
		plateFields[plateIndex++] = new ListGridField("happenDate","回款日期");
		plateFields[plateIndex] = new ListGridField("plateId","业务部门");
		plateFields[plateIndex++].setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateFields[plateIndex] = new ListGridField("totalAmount","回款金额");
		plateFields[plateIndex].setDecimalPad(2);
		plateFields[plateIndex].setAlign(Alignment.RIGHT);
		plateFields[plateIndex++].setFormat("##,###,###,###,##0.00");
		plateFields[plateIndex] = new ListGridField("distributionAmount","回款分配金额");
		plateFields[plateIndex].setDecimalPad(2);
		plateFields[plateIndex].setAlign(Alignment.RIGHT);
		plateFields[plateIndex++].setFormat("##,###,###,###,##0.00");
		plateFields[plateIndex++] = new ListGridField("remark","备注");
		plateGrid.setFields(plateFields);
		
		projectGrid = new DelicacyListGrid();
		projectGrid.setAutoFitFieldWidths(false);
		projectGrid.setWidth100();
		projectGrid.setShowRowNumbers(true);
		projectLayout.addMember(projectGrid);
		
		ListGridField[] projectFields = new ListGridField[7];
		int projectIndex = 0;
		projectFields[projectIndex++] = new ListGridField("happenDate","回款日期");
		projectFields[projectIndex] = new ListGridField("plateId","业务部门");
		projectFields[projectIndex++].setValueMap(KeyValueManager.getValueMap("plate_records"));
		projectFields[projectIndex++] = new ListGridField("projectContractCode","订单编号");
		projectFields[projectIndex] = new ListGridField("projectId","订单名称");
//		projectFields[projectIndex++].setValueMap(KeyValueManager.getValueMap("projects"));
		KeyValueManager.loadValueMap("projects", projectFields[projectIndex++]);
		projectFields[projectIndex] = new ListGridField("totalAmount","回款金额");
		projectFields[projectIndex].setDecimalPad(2);
		projectFields[projectIndex].setAlign(Alignment.RIGHT);
		projectFields[projectIndex++].setFormat("##,###,###,###,##0.00");
		projectFields[projectIndex] = new ListGridField("distributionAmount","回款分配金额");
		projectFields[projectIndex].setDecimalPad(2);
		projectFields[projectIndex].setAlign(Alignment.RIGHT);
		projectFields[projectIndex++].setFormat("##,###,###,###,##0.00");
		projectFields[projectIndex++] = new ListGridField("remark","备注");
		projectGrid.setFields(projectFields);
	}

	public void loadData(){
		Map<String, Object> params = new HashMap<>();
		params.put("capitalId", capitalId);//部门回款分配
		DBDataSource.callOperation("NQ_CapitalDistributionOfDepartment", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					plateGrid.setData(dsResponse.getData());
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
		
		//订单回款分配
		DBDataSource.callOperation("NQ_CapitalDistributionOfProject", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					projectGrid.setData(dsResponse.getData());
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}
	
	private Integer capitalId;

	public Integer getCapitalId() {
		return capitalId;
	}

	public void setCapitalId(Integer capitalId) {
		this.capitalId = capitalId;
	}
	
}
