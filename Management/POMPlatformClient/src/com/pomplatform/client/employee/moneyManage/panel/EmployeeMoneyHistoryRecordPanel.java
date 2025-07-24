package com.pomplatform.client.employee.moneyManage.panel;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.employee.moneyManage.datasource.DSEmployeeMoneyHistoryRecord;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;

public class EmployeeMoneyHistoryRecordPanel extends HLayout{

	private final DelicacyListGrid grid;
	private int employeeId;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public EmployeeMoneyHistoryRecordPanel(){
		
		setWidth100();
		setHeight100();
		
		grid = new DelicacyListGrid(){
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				if (record.getAttributeAsInt("falg") == 1) {  
                    return "color:#27DC35;";  
                } else if (record.getAttributeAsInt("falg") == 2) {  
                    return "color:#F01813;";  
                } else {  
                    return super.getCellCSSText(record, rowNum, colNum);  
                }  
			}
		};
		grid.setShowGridSummary(true);
		grid.setAutoFitFieldWidths(false);

		ListGridField[] fields = new ListGridField[5];
		int idx = 0;
		fields[idx] = new ListGridField("employeeId", "姓名");
//		fields[idx].setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",fields[idx]);
		idx++;
		fields[idx] = new ListGridField("borrowDate", "日期");
		idx++;
		fields[idx] = new ListGridField("titleName", "主题");
		idx++;
		fields[idx] = new ListGridField("borrowMoney", "金额");
		fields[idx].setFormat("##,###,###,###,#0.00");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("reason", "具体事由");
		grid.setFields(fields);
		grid.setDataSource(DSEmployeeMoneyHistoryRecord.getInstance());
		addMember(grid);
		
	}
	public void load(){
		Map<String, Object> params = new HashMap<>();
		params.put("employeeId", employeeId);
		DBDataSource.callOperation("EP_GetEmployeeMoneyHistoryRecord", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus()>=0){
					Record[] records = dsResponse.getData();
					grid.setData(records);
					grid.redraw();
				}
			}
		});
	}
}
