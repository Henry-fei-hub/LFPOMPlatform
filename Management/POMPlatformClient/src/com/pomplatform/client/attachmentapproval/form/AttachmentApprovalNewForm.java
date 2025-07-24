package com.pomplatform.client.attachmentapproval.form;

import java.util.*;
import java.util.logging.Logger;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.attachmentapproval.datasource.DSAttachmentApproval;
import com.pomplatform.client.budgetmanagement.panel.DSBudgetAttachmentDetail;

public class AttachmentApprovalNewForm extends AbstractWizadPage
{


	private final DelicacyListGrid bdDetailGrid;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	//预算管理ID
	private  Integer budgetManagementId=0;
	//预算附件ID
	private  Integer budgetAttachmentId=0;
	
	public AttachmentApprovalNewForm() {
		bdDetailGrid = new DelicacyListGrid();
		bdDetailGrid.setWidth("90%");
		bdDetailGrid.setAlign(Alignment.CENTER);
		int a = 0;
		ListGridField[] aFields = new ListGridField[9];
		aFields[a] = new ListGridField("budgetAttachmentId","附件id");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("budgetManagementId","预算管理Id");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("attachmentName","附件名称");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("fileUrl","路径");
		aFields[a].setCanEdit(false);
		aFields[a].setLinkText("预算文件下载/预览");
		a++;
		aFields[a] = new ListGridField("budgetContractAmount","预算合同金额");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("budgetContractAmountUse","合同已付金额");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("budgetContractAmountRest","合同剩余金额");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("payPercent","付款比例");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("receiveUnitManageId","供应商");
		aFields[a].setAlign(Alignment.CENTER);
//		aFields[a].setValueMap(KeyValueManager.getValueMap("receive_unit_manages_company"));
		KeyValueManager.loadValueMap("receive_unit_manages_company",aFields[a]);
		aFields[a].setShowGridSummary(false);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("bddType","预算类别");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setValueMap(KeyValueManager.getValueMap("budget_detail_type"));
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("uploadEmployeeId","上传人员");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setValueMap(KeyValueManager.getValueMap("employees"));
		aFields[a].setShowGridSummary(false);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("uploadTime","上传时间");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("uploadRemark","备注");
		aFields[a].setType(ListGridFieldType.TEXT);
		aFields[a].setCanEdit(false);
		bdDetailGrid.setFields(aFields);
		bdDetailGrid.setAutoFitFieldWidths(false);
		bdDetailGrid.setDataSource(DSBudgetAttachmentDetail.getInstance());
		bdDetailGrid.setCanRemoveRecords(false);
		bdDetailGrid.setShowGridSummary(true);
		bdDetailGrid.setHeaderHeight(60);
		bdDetailGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"预算附件审批详情", new String[] {"budgetAttachmentId","budgetManagementId","attachmentName","fileUrl","budgetContractAmount","budgetContractAmountUse","budgetContractAmountRest","payPercent","receiveUnitManageId","bddType","uploadEmployeeId","uploadTime","uploadRemark"}));
		
		
		
		
		
		addMember(bdDetailGrid);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
		
		Map<String,Object> map=new HashMap<>();
		//获取预算管理ID
		 budgetManagementId=BaseHelpUtils.getIntValue(record.getAttribute("budgetManagementId"));
		//获取预算附件ID
		 budgetAttachmentId=BaseHelpUtils.getIntValue(record.getAttribute("budgetAttachmentId"));
		map.put("budgetManagementId",budgetManagementId);
		map.put("budgetAttachmentId",budgetAttachmentId);
		DBDataSource.callOperation("NQ_BudgetAttachmentDetail","find",map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					bdDetailGrid.setData(dsResponse.getData());
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
				}
			}
		});

	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSAttachmentApproval.getInstance());
		manager.addMember(__form);
		
		
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map<String,Object> map=new HashMap<>();
		map.put("budgetManagementId",budgetManagementId);
		map.put("budgetAttachmentId",budgetAttachmentId);
		return map;
	}
	private Record record;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

}
