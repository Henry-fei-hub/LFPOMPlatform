package com.pomplatform.client.workflow.companyCommonNormalReimbursement.form;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.employee.moneyManage.datasource.DSEmployeeMoneyHistoryRecord;
import com.pomplatform.client.workflow.datasource.DSPayMoneyManageOfWorkflow;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;

public class PayMoneyHistoryRecordPanel extends HLayout{

	private final DelicacyListGrid grid;
	private Integer receiveUnitManageId;

	public Integer getReceiveUnitManageId() {
		return receiveUnitManageId;
	}

	public void setReceiveUnitManageId(Integer receiveUnitManageId) {
		this.receiveUnitManageId = receiveUnitManageId;
	}
	public PayMoneyHistoryRecordPanel(){
		
		setWidth100();
		setHeight100();
		
		grid = new DelicacyListGrid(){
			/*@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				if (record.getAttributeAsInt("falg") == 1) {  
                    return "color:#27DC35;";  
                } else if (record.getAttributeAsInt("falg") == 2) {  
                    return "color:#F01813;";  
                } else {  
                    return super.getCellCSSText(record, rowNum, colNum);  
                }  
			}*/
		};
		grid.setShowGridSummary(true);
		grid.setAutoFitFieldWidths(false);

		ListGridField[] fields = new ListGridField[5];
		int idx = 0;
		fields[idx] = new ListGridField("receiveUnit", "收款单位");
		idx++;
		fields[idx] = new ListGridField("bankAccount", "银行账号");
		idx++;
		fields[idx] = new ListGridField("bankName", "开户行");
		idx++;
		fields[idx] = new ListGridField("payAmount", "付款金额");
		fields[idx].setFormat("##,###,###,###,#0.00");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("reason", "付款原因");
		grid.setFields(fields);
		grid.setDataSource(DSPayMoneyManageOfWorkflow.getInstance());
		addMember(grid);
		
	}
	public void load(){
		Map<String, Object> params = new HashMap<>();
		params.put("receiveUnitManageId", getReceiveUnitManageId());
		params.put("opt_type", "getPayMoneyHistoryRecord");
		DBDataSource.callOperation("EP_PayMoneyHistoryRecordProcessor", params, new DSCallback() {
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
