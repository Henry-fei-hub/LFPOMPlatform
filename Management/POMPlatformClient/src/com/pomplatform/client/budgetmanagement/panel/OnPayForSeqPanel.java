package com.pomplatform.client.budgetmanagement.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.aboutreimbursementpayseq.datasource.DSAboutReimbursementPayseq;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;

public class OnPayForSeqPanel extends HLayout implements HasHandlers{
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
	private Window parentWindow;
	private final DelicacyListGrid bdDetailGrid = new DelicacyListGrid();	
	public void init() {
		bdDetailGrid.setAlign(Alignment.CENTER);
		bdDetailGrid.setAutoFitFieldWidths(true);
		int a = 0;
		ListGridField[] aFields = new ListGridField[9];
		aFields[a] = new ListGridField("budgetAttachmentId", "附件id");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("budgetManagementId", "预算管理Id");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("attachmentName", "附件名称");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("fileUrl", "路径");
		DataSourceLinkField link = new DataSourceLinkField();
		aFields[a].setCanEdit(false);
		aFields[a].setLinkText("预算文件下载/预览");
		a++;
		aFields[a] = new ListGridField("payAmount", "<span style='color:red;'>付款金额</span>");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("reimbursementAmount", "<span style='color:red;'>报销金额</span>");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("reverseAmount", "<span style='color:red;'>冲账金额</span>");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("returnAmount", "<span style='color:red;'>还款金额</span>");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("budgetContractAmount", "预算金额");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("budgetContractAmountUse", "合同已付金额");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("budgetContractAmountRest", "合同剩余金额");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("payPercent", "付款比例");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("receiveUnitManageId", "供应商");
		aFields[a].setAlign(Alignment.CENTER);
//		aFields[a].setValueMap(KeyValueManager.getValueMap("receive_unit_manages_company"));
		KeyValueManager.loadValueMap("receive_unit_manages_company",aFields[a]);
		aFields[a].setShowGridSummary(false);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("bddType", "预算类别");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setValueMap(KeyValueManager.getValueMap("system_dictionary_188"));
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("uploadEmployeeId", "上传人员");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setValueMap(KeyValueManager.getValueMap("employees"));
		aFields[a].setShowGridSummary(false);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("uploadTime", "上传时间");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("projectId", "项目名称");
//		aFields[a].setValueMap(KeyValueManager.getValueMap("projects"));
		KeyValueManager.loadValueMap("projects",aFields[a]);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("uploadRemark", "备注");
		aFields[a].setType(ListGridFieldType.TEXT);
		aFields[a].setCanEdit(false);
		bdDetailGrid.setDataSource(DSAboutReimbursementPayseq.getInstance());
		bdDetailGrid.setFields(aFields);
		bdDetailGrid.setShowGridSummary(true);
		bdDetailGrid.setSelectionType(SelectionStyle.SINGLE);
		addMember(bdDetailGrid);
		loadData();

	}

	public void loadData() {
		// 获取预算附件ID
		int budgetAttachmentId = BaseHelpUtils.getIntValue(record.getAttribute("budgetAttachmentId"));
		// 获取付款序列ID
		int paymentSequenceId = BaseHelpUtils.getIntValue(record.getAttribute("paymentSequenceId"));
		//获取预算管理ID
		int budgetManagementId = BaseHelpUtils.getIntValue(record.getAttribute("budgetManagementId"));
		if (budgetManagementId > 0&&budgetAttachmentId>0&&paymentSequenceId>0) {
			Map<String, Object> map = new HashMap<>();
			map.put("budgetManagementId", budgetManagementId);
			map.put("budgetAttachmentId", budgetAttachmentId);
			map.put("paymentSequenceId", paymentSequenceId);
			DBDataSource.callOperation("NQ_AboutReimbursementPayseq", "find", map, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if (dsResponse.getStatus() >= 0) {
						Record[] records = dsResponse.getData();
						if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0) {
							Record record = records[0];
							//获取付款金额
							BigDecimal payAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("payAmount")); 
							//获取冲账金额
							BigDecimal  reverseAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("reverseAmount"));
							//获取报销金额
							BigDecimal  reimbursementAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("reimbursementAmount"));
							//获取还款金额
							BigDecimal  returnAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("returnAmount"));
							ListGridField[] fields =  bdDetailGrid.getFields();
							for(ListGridField e : fields) {
								String name = e.getName();
								if(name.equals("payAmount") && payAmount.compareTo(BigDecimal.ZERO) <= 0) {
									e.setHidden(true);
								}else if(name.equals("reverseAmount") && reverseAmount.compareTo(BigDecimal.ZERO) <= 0) {
									e.setHidden(true);
								}else if(name.equals("reimbursementAmount") && reimbursementAmount.compareTo(BigDecimal.ZERO) <= 0) {
									e.setHidden(true);
								}
								else if(name.equals("returnAmount") && returnAmount.compareTo(BigDecimal.ZERO) <= 0) {
									e.setHidden(true);
								}
							}
							bdDetailGrid.setFields(fields);
							bdDetailGrid.redraw();
							bdDetailGrid.setData(records);
						}
					} else {
						SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
					}
				}
			});
		}
	}



	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	private Record record;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

}
