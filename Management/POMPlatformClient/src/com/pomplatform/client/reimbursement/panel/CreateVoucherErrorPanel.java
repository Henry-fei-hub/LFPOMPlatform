package com.pomplatform.client.reimbursement.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericWizadWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.k3code.form.UpdateBankAccountK3CodeForm;
import com.pomplatform.client.k3code.form.UpdateCompanyK3CodeForm;
import com.pomplatform.client.k3code.form.UpdateCustomerK3CodeForm;
import com.pomplatform.client.k3code.form.UpdateEmployeeK3CodeForm;
import com.pomplatform.client.k3code.form.UpdatePlateAreaK3CodeForm;
import com.pomplatform.client.k3code.form.UpdateReceiveUnitK3CodeForm;
import com.pomplatform.client.k3code.form.UpdateSubjectTypeK3CodeForm;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class CreateVoucherErrorPanel extends VLayout{
	
	private Record[] records;
	private DelicacyListGrid grid;
	private static final Logger logger = Logger.getLogger("");
	
	public void initPanel() {
		grid = new DelicacyListGrid();
		grid.setWidth100();
		grid.setAutoFitFieldWidths(false);
		ListGridField[] fields = new ListGridField[3];
		int idx = 0;
		fields[idx++] = new ListGridField("receiveUnit", "收款单位");
		fields[idx++] = new ListGridField("bankAccount", "银行账号");
		fields[idx++] = new ListGridField("receiveUnitAddress", "错误");
		grid.setFields(fields);
		grid.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						Record selected = grid.getSelectedRecord();
						Record record = new Record();
						if(BaseHelpUtils.isNullOrEmpty(selected.getAttribute("receiveUnitManageId"))) {
							return;
						}
						record.setAttribute("type", selected.getAttribute("receiveUnitType"));
						record.setAttribute("k3CodeId", selected.getAttribute("receiveUnitManageId"));
						record.setAttribute("businessId", selected.getAttribute("bankId"));
						GenericWizadWindow detailForm = null;
						if(BaseHelpUtils.getIntValue(record.getAttribute("type")) == ClientStaticUtils.K3_CODE_TYPE_2) {
							detailForm = new UpdateCompanyK3CodeForm();
						}else if(BaseHelpUtils.getIntValue(record.getAttribute("type")) == ClientStaticUtils.K3_CODE_TYPE_1) {
							detailForm = new UpdateEmployeeK3CodeForm();
						}else if(BaseHelpUtils.getIntValue(record.getAttribute("type")) == ClientStaticUtils.K3_CODE_TYPE_5) {
							detailForm = new UpdateBankAccountK3CodeForm();
						}else if(BaseHelpUtils.getIntValue(record.getAttribute("type")) == ClientStaticUtils.K3_CODE_TYPE_4) {
							detailForm = new UpdateSubjectTypeK3CodeForm();
							record.setAttribute("departmentType", selected.getAttribute("bankAccount"));
						}else if(BaseHelpUtils.getIntValue(record.getAttribute("type")) == ClientStaticUtils.K3_CODE_TYPE_8) {
							detailForm = new UpdateReceiveUnitK3CodeForm();
						}else if(BaseHelpUtils.getIntValue(record.getAttribute("type")) == ClientStaticUtils.K3_CODE_TYPE_9) {
							detailForm = new UpdateCustomerK3CodeForm();
						}else if(BaseHelpUtils.getIntValue(record.getAttribute("type")) == ClientStaticUtils.K3_CODE_TYPE_10) {
							detailForm = new UpdatePlateAreaK3CodeForm();
						}
						if(null == detailForm) {
							return;
						}
						detailForm.setTitle("修改");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								grid.removeData(selected);
								grid.redraw();
							}
						});
						detailForm.setRecord(record);
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth("30%");
						detailForm.setHeight("40%");
						detailForm.centerInPage();
						detailForm.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		addMember(grid);
		
		IButton button = new IButton("导出");
		button.setBaseStyle("customButton");
		button.setWidth(130);
		button.setRight(10);;
		button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> params = new HashMap<>();
				params.put("details", records);
				DBDataSource.downloadFile("DW_K3VoucherErrorList", params);
			}
		});
		
		ToolStrip navLayout = new ToolStrip();
		navLayout.setPadding(5);
		navLayout.setHeight(40);
		navLayout.setWidth100();
		navLayout.setMembersMargin(10);
		navLayout.addFill();
		navLayout.setBorder("none");
		navLayout.addMembers(button);
		
		addMember(navLayout);
		setMembersMargin(8);
	}
	
	public Record[] getRecords() {
		return records;
	}
	public void setRecords(Record[] records) {
		this.records = records;
	}
	
	public void setDataToGrid() {
		List<Record> list = new ArrayList<>();
		Set<String> set = new HashSet<>();
		for(Record r : records) {
			String k3CodeId = r.getAttribute("receiveUnitManageId");
			if(BaseHelpUtils.isNullOrEmpty(k3CodeId)) {
				list.add(r);
			}else {
				if(set.contains(k3CodeId)) {
					continue;
				}
				set.add(k3CodeId);
				list.add(r);
			}
		}
		int size = list.size();
		Record[] data = new Record[size];
		for(int i = 0; i < size; i++) {
			data[i] = list.get(i);
		}
		grid.setData(data);
		grid.redraw();
	}
	
}
