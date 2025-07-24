package com.pomplatform.client.budgetmanagement.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.budgetmanagement.datasource.DSAbountPaymentSequenceinfo;
import com.pomplatform.client.budgetmanagement.datasource.DSOnBudgetManagement;
import com.pomplatform.client.budgetmanagement.panel.DSBudgetAttachmentDetail;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.getbudgetuplodanews.datasource.DSGetBudgetUplodaNews;

public class OnBudgetManagementViewer extends AbstractDetailViewer
{

	private static final Logger __LOGGER = Logger.getLogger("");
	private SearchForm __parentSearchForm;
	private final DelicacyListGrid detailgrid = new DelicacyListGrid();
	private final DelicacyListGrid attachgrid = new DelicacyListGrid();
	private DelicacyListGrid upLoadgrid = new DelicacyListGrid();
	private DelicacyListGrid processGrid = new DelicacyListGrid();
	private final DelicacyListGrid paySeqGrid =new DelicacyListGrid(){
		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
			int payStatus=BaseHelpUtils.getIntValue(record.getAttribute("payStatus"));
			if(payStatus==1) {//未付款
				return null;
			}else if(payStatus==2) {//已付款 lightgray
				paySeqGrid.getRecord(rowNum).set_canEdit(false);
				return "color: 009966;";
			}else if(payStatus==3) {//付款申请中
				paySeqGrid.getRecord(rowNum).set_canEdit(false);
				return "color: #D2691E;";
			}
			else {
				return null;
			}

		}  
	};

	public OnBudgetManagementViewer() {
	}

	@Override
	public void initComponents() {
		setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
		super.initComponents();
		detailgrid.setAutoFitFieldWidths(false);
		detailgrid.setShowGridSummary(true);
		int indexs = 0;
		ListGridField[] fieldss = new ListGridField[5];
		fieldss[indexs] = new ListGridField("budgetManagementId");
		fieldss[indexs].setHidden(true);
		indexs++;
		fieldss[indexs] = new ListGridField("bddType","预算类别");
		fieldss[indexs].setAlign(Alignment.CENTER);
		fieldss[indexs].setWidth("25%");
		indexs++;
		fieldss[indexs] = new ListGridField("bddAmount","类别金额(元)");
		fieldss[indexs].setWidth("25%");
		fieldss[indexs].setAlign(Alignment.RIGHT);
		fieldss[indexs].setType(ListGridFieldType.FLOAT);
		fieldss[indexs].setFormat("##,###,###,###,##0.00");
		indexs++;
		fieldss[indexs] = new ListGridField("bddAmountPercent","预算类别占比");
		fieldss[indexs].setWidth("25%");
		fieldss[indexs].setAlign(Alignment.RIGHT);
		indexs++;
		fieldss[indexs] = new ListGridField("budgetContractAmountUse","实际已用金额(元)");
		fieldss[indexs].setWidth("25%");
		fieldss[indexs].setAlign(Alignment.RIGHT);
		fieldss[indexs].setType(ListGridFieldType.FLOAT);
		fieldss[indexs].setFormat("##,###,###,###,##0.00");
		indexs++;
		fieldss[indexs] = new ListGridField("usePercent","实际类别占比");
		fieldss[indexs].setWidth("25%");
		fieldss[indexs].setAlign(Alignment.RIGHT);
		detailgrid.setFields(fieldss);
		
		int a = 0;
		ListGridField[] aFields = new ListGridField[9];
		aFields[a] = new ListGridField("attachmentName","附件名称");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("25%");
		aFields[a].setAlign(Alignment.CENTER);
		a++;
		aFields[a] = new ListGridField("fileUrl","路径");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("25%");
		aFields[a].setLinkText("预算文件下载/预览");
		a++;
		aFields[a] = new ListGridField("budgetContractAmount","预算金额");
		aFields[a].setWidth("25%");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		a++;
		aFields[a] = new ListGridField("budgetContractAmountUse","合同已付金额");
		aFields[a].setWidth("25%");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		a++;
		aFields[a] = new ListGridField("budgetContractAmountRest","合同剩余金额");
		aFields[a].setWidth("25%");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		a++;
		aFields[a] = new ListGridField("payPercent","付款比例");
		aFields[a].setWidth("25%");
		aFields[a].setAlign(Alignment.CENTER);
		a++;
		aFields[a] = new ListGridField("receiveUnitManageId","供应商");
		aFields[a].setWidth("30%");
		aFields[a].setAlign(Alignment.CENTER);
//		aFields[a].setValueMap(KeyValueManager.getValueMap("receive_unit_manages_company"));
		KeyValueManager.loadValueMap("receive_unit_manages_company",aFields[a]);
		aFields[a].setShowGridSummary(false);
		a++;
		aFields[a] = new ListGridField("bddType","预算类别");
		aFields[a].setWidth("25%");
		aFields[a].setAlign(Alignment.CENTER);
		a++;
		aFields[a] = new ListGridField("uploadEmployeeId","上传人员");
		aFields[a].setWidth("25%");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setValueMap(KeyValueManager.getValueMap("employees"));
		aFields[a].setShowGridSummary(false);
		a++;
		aFields[a] = new ListGridField("uploadTime","上传时间");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("25%");
		a++;
		aFields[a] = new ListGridField("uploadRemark","备注");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("25%");
		aFields[a].setType(ListGridFieldType.TEXT);
		attachgrid.setDataSource(DSBudgetAttachmentDetail.getInstance());
		attachgrid.setFields(aFields);
		attachgrid.setAutoFitFieldWidths(true);
		attachgrid.setCanEdit(false);
		attachgrid.setShowGridSummary(true);
		
		int index = 0;
		ListGridField[] fields = new ListGridField[14];
		fields[index] = new ListGridField("attachmentName","附件名称");
		fields[index].setAlign(Alignment.CENTER);
		index++;
		fields[index] = new ListGridField("fileUrl","文件路径");
		fields[index].setAlign(Alignment.CENTER);
		fields[index].setLinkText("预算文件下载/预览");
		index++;
		fields[index] = new ListGridField("payType");
		fields[index].setAlign(Alignment.CENTER);
		fields[index].setShowGridSummary(false);
		fields[index].setValueMap(KeyValueManager.getValueMap("system_dictionary_193"));
		index++;
		fields[index] = new ListGridField("reimbursementAmount","报销金额");
		fields[index].setAlign(Alignment.RIGHT);
		fields[index].setType(ListGridFieldType.FLOAT);
		fields[index].setFormat("##,###,###,###,##0.00");
		fields[index].setWidth("25%");
		fields[index].setCanEdit(true);
		index++;
		fields[index] = new ListGridField("payAmount","<span style='color:red;'>付款金额</span>");
		fields[index].setAlign(Alignment.RIGHT);
		fields[index].setType(ListGridFieldType.FLOAT);
		fields[index].setFormat("##,###,###,###,##0.00");
		fields[index].setWidth("25%");
		fields[index].setCanEdit(true);
		index++;
		fields[index] = new ListGridField("reverseAmount","冲账金额");
		fields[index].setAlign(Alignment.RIGHT);
		fields[index].setType(ListGridFieldType.FLOAT);
		fields[index].setFormat("##,###,###,###,##0.00");
		fields[index].setWidth("25%");
		fields[index].setCanEdit(true);
		index++;
		fields[index] = new ListGridField("returnAmount","还款金额");
		fields[index].setAlign(Alignment.RIGHT);
		fields[index].setType(ListGridFieldType.FLOAT);
		fields[index].setFormat("##,###,###,###,##0.00");
		fields[index].setWidth("25%");
		fields[index].setCanEdit(true);
		index++;
		fields[index] = new ListGridField("applyPayDate");
		fields[index].setAlign(Alignment.CENTER);
		index++;
		index++;
		fields[index] = new ListGridField("payFor","收款方类型");
		fields[index].setAlign(Alignment.CENTER);
		fields[index].setValueMap(KeyValueManager.getValueMap("system_dictionary_196"));
		fields[index].setWidth("15%");
		fields[index].setShowGridSummary(false);
		index++;
		fields[index] = new ListGridField("payName","收款方名称");
		fields[index].setWidth("45%");
		index++;
		fields[index] = new ListGridField("receiveUnitManageId","供应商");
		fields[index].setAlign(Alignment.CENTER);
		fields[index].setShowGridSummary(false);
//		fields[index].setValueMap(KeyValueManager.getValueMap("receive_unit_manages_company"));
		KeyValueManager.loadValueMap("receive_unit_manages_company",fields[index]);
		index++;
		fields[index] = new ListGridField("psRemark");
		fields[index].setAlign(Alignment.CENTER);
		index++;
		fields[index] = new ListGridField("payStatus");
		fields[index].setAlign(Alignment.CENTER);
		fields[index].setShowGridSummary(false);
		fields[index].setValueMap(KeyValueManager.getValueMap("system_dictionary_194"));
		index++;
		fields[index] = new ListGridField("payDate");
		fields[index].setAlign(Alignment.CENTER);
		index++;
		fields[index] = new ListGridField("budgetContractAmount");
		fields[index].setAlign(Alignment.CENTER);
		fields[index].setType(ListGridFieldType.FLOAT);
		fields[index].setFormat("##,###,###,###,##0.00");
		index++;
		fields[index] = new ListGridField("budgetContractAmountUse");
		fields[index].setAlign(Alignment.CENTER);
		fields[index].setType(ListGridFieldType.FLOAT);
		fields[index].setFormat("##,###,###,###,##0.00");
		index++;
		fields[index] = new ListGridField("budgetContractAmountRest");
		fields[index].setAlign(Alignment.CENTER);
		fields[index].setType(ListGridFieldType.FLOAT);
		fields[index].setFormat("##,###,###,###,##0.00");
		index++;
		fields[index] = new ListGridField("payPercent");
		fields[index].setAlign(Alignment.CENTER);
		index++;
		fields[index] = new ListGridField("projectId");
		fields[index].setAlign(Alignment.CENTER);
		fields[index].setShowGridSummary(false);
		KeyValueManager.loadValueMap("projects",fields[index]);
		index++;
		fields[index] = new ListGridField("paymentSequenceId");
		fields[index].setHidden(true);
		fields[index].setShowGridSummary(false);
		index++;
		fields[index] = new ListGridField("budgetAttachmentId");
		fields[index].setHidden(true);
		fields[index].setShowGridSummary(false);
		index++;
		fields[index] = new ListGridField("budgetManagementId");
		fields[index].setHidden(true);
		fields[index].setShowGridSummary(false);
		index++;
		fields[index] = new ListGridField("processType");
		fields[index].setHidden(true);
		fields[index].setShowGridSummary(false);
		index++;
		fields[index] = new ListGridField("processId");
		fields[index].setShowGridSummary(false);
		fields[index].setHidden(true);
		paySeqGrid.setDataSource(DSAbountPaymentSequenceinfo.getInstance());
		paySeqGrid.setFields(fields);
		paySeqGrid.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Record record=paySeqGrid.getSelectedRecord();
				int processType=BaseHelpUtils.getIntValue(record.getAttribute("processType"));
				int processId=BaseHelpUtils.getIntValue(record.getAttribute("processId"));
				if(processType<=0||processId<=0) {
					SC.say("此序列没有发起付款流程，无法查看付款详情");
					return;
				}
				int payType=BaseHelpUtils.getIntValue(record.getAttribute("payType"));
				int paymentSequenceId=BaseHelpUtils.getIntValue(record.getAttribute("paymentSequenceId"));
				int budgetAttachmentId=BaseHelpUtils.getIntValue(record.getAttribute("budgetAttachmentId"));
				int budgetManagementId=BaseHelpUtils.getIntValue(record.getAttribute("budgetManagementId"));
				Map<String,Object> map=new HashMap<>();
				map.put("paymentSequenceId", paymentSequenceId);
				map.put("budgetAttachmentId", budgetAttachmentId);
				map.put("budgetManagementId", budgetManagementId);
				map.put("payType", payType);
				map.put("processType", processType);
				map.put("processId", processId);
				map.put("optType", "payStatusInfo");
				DBDataSource.callOperation("EP_EidtPaymentSequence",map, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							@SuppressWarnings("unchecked")
							Map<String,Object> userDataMap = BaseHelpUtils.getResponseUserData(dsResponse);
							int processInstanceId=BaseHelpUtils.getIntValue(userDataMap.get("processInstanceId"));
							Record records=new Record();
							records.setAttribute("processType", processType);
							records.setAttribute("processId", processId);
							records.setAttribute("processInstanceId", processInstanceId);
							ViewProcessWindow Reimbursement = new ViewProcessWindow();
							Reimbursement.setWidth("80%");
							Reimbursement.setHeight("80%");
							Reimbursement.setLayoutMode(0);
							Reimbursement.setInstanceData(records);
							Reimbursement.initComponents();
							Reimbursement.setTitle(ClientUtil.getProcessTypeName(records));
							Reimbursement.show();
						}
					}
				});
			}
		});
		paySeqGrid.setAlign(Alignment.CENTER);
		paySeqGrid.setCanEdit(false);
		paySeqGrid.setCanRemoveRecords(false);
		paySeqGrid.setShowGridSummary(true);
		
		upLoadgrid.setWidth("100%");
		upLoadgrid.setAlign(Alignment.LEFT);
		int b = 0;
		ListGridField[] aFielda = new ListGridField[5];
		aFielda[b] = new ListGridField("fileId","fileId");
		aFielda[b].setHidden(true);
		b++;
		aFielda[b] = new ListGridField("bdAttachmentName","文件名称");
		aFielda[b].setAlign(Alignment.CENTER);
		aFielda[b].setHidden(false);
		aFielda[b].setWidth("10%");
		b++;
		aFielda[b] = new ListGridField("fileUrl","路径");
		aFielda[b].setAlign(Alignment.CENTER);
		aFielda[b].setCanEdit(false);
		aFielda[b].setLinkText("预算单立项文件下载/预览");
		aFielda[b].setWidth("10%");
		b++;
		aFielda[b] = new ListGridField("createTime","上传时间");
		aFielda[b].setAlign(Alignment.CENTER);
		aFielda[b].setCanEdit(false);
		aFielda[b].setWidth("10%");
		b++;
		aFielda[b] = new ListGridField("bdUploadRemark","上传备注");
		aFielda[b].setAlign(Alignment.CENTER);
		aFielda[b].setCanEdit(false);
		aFielda[b].setWidth("30%");
		//aFields[a].setAutoFitWidth(true);
		upLoadgrid.setDataSource(DSGetBudgetUplodaNews.getInstance());
		upLoadgrid.setFields(aFielda);
		upLoadgrid.setAutoFitFieldWidths(false);
		upLoadgrid.setCanRemoveRecords(false);
		upLoadgrid.setCanEdit(false);
		
		
		
		processGrid.setWidth("100%");
		processGrid.setAlign(Alignment.LEFT);
		int c = 0;
		ListGridField[] aFieldsss = new ListGridField[15]; 
		aFieldsss[c] = new ListGridField("budgetManagementLinkProcessId"); 
		aFieldsss[c].setHidden(true);
		c++;
		aFieldsss[c] = new ListGridField("budgetManagementId"); 
		aFieldsss[c].setHidden(true);
		c++;
		aFieldsss[c] = new ListGridField("businessId"); 
		aFieldsss[c].setHidden(true);
		c++;
		aFieldsss[c] = new ListGridField("processId");
		aFieldsss[c].setHidden(true);
		c++;
		aFieldsss[c] = new ListGridField("processType");
		aFieldsss[c].setHidden(true);
		c++;
		aFieldsss[c] = new ListGridField("processInstanceId");
		aFieldsss[c].setHidden(true);
		c++;
		aFieldsss[c] = new ListGridField("processType","流程类型");
		aFieldsss[c].setAlign(Alignment.CENTER);
		aFieldsss[c].setWidth("25%");
		KeyValueManager.loadValueMap("system_process_types", aFieldsss[c]);
		aFieldsss[c].setShowGridSummary(false);
		c++;
		aFieldsss[c] = new ListGridField("employeeNo","员工编号");
		aFieldsss[c].setAlign(Alignment.CENTER);
		aFieldsss[c].setWidth("25%");
		aFieldsss[c].setShowGridSummary(false);
		c++;
		aFieldsss[c] = new ListGridField("employeeId","申请人");
		aFieldsss[c].setWidth("25%");
		KeyValueManager.loadValueMap("employees", aFieldsss[c]);
		aFieldsss[c].setAlign(Alignment.CENTER);
		aFieldsss[c].setShowGridSummary(false);
		c++;
		aFieldsss[c] = new ListGridField("departmentId","归属部门");
		KeyValueManager.loadValueMap("departments", aFieldsss[c]);
		aFieldsss[c].setAlign(Alignment.CENTER);
		aFieldsss[c].setWidth("25%");
		aFieldsss[c].setShowGridSummary(false);
		c++;
		aFieldsss[c] = new ListGridField("totalPrice","总金额");
		aFieldsss[c].setAlign(Alignment.RIGHT);
		aFieldsss[c].setType(ListGridFieldType.FLOAT);
		aFieldsss[c].setFormat("##,###,###,###,##0.00");
		aFieldsss[c].setShowGridSummary(true);
		aFieldsss[c].setWidth("25%");
		aFieldsss[c].setShowGridSummary(true);
		c++;
		aFieldsss[c] = new ListGridField("createTime","领用日期");
		aFieldsss[c].setAlign(Alignment.CENTER);
		aFieldsss[c].setWidth("25%");
		DateTimeItem  dateItem=new DateTimeItem();
		dateItem.setUseTextField(true);
		aFieldsss[c].setEditorProperties(dateItem);
		aFieldsss[c].setShowGridSummary(false);
		c++;
		aFieldsss[c] = new ListGridField("reason","申请缘由");
		aFieldsss[c].setAlign(Alignment.CENTER);
		aFieldsss[c].setWidth("25%");
		aFieldsss[c].setShowGridSummary(false);
		processGrid.setDataSource(DSGetBudgetUplodaNews.getInstance());
		processGrid.setFields(aFieldsss);
		processGrid.setAutoFitFieldWidths(true);
		processGrid.setCanRemoveRecords(false);
		processGrid.setShowGridSummary(true);
		processGrid.setCanEdit(false);
		processGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Record selected = processGrid.getSelectedRecord();
				__LOGGER.info("1111111++++++++"+selected.toMap());
				ViewProcessWindow Reimbursement = new ViewProcessWindow();
				Reimbursement.setWidth("80%");
				Reimbursement.setHeight("80%");
				Reimbursement.setLayoutMode(0);
				Reimbursement.setInstanceData(selected);
				Reimbursement.initComponents();
				Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
				Reimbursement.show();
			}
		});
		
		
		
		
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "基本情况";
	}

	@Override
	public int getGroupCount() {
		return 0;
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<GroupColumn>();
		return gcs;
	}

	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("budgetManagementId", getBusinessId());
		DBDataSource.callOperation("NQ_OnBudgetManagement", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					for(DetailViewer v : detailViewers){
						v.setData(dsResponse.getData());
						if(dsResponse.getData().length == 0) continue;
						v.selectRecord(0);
						v.redraw();
					}
					setRecord(dsResponse.getData()[0]);
					viewDetailData();
				}
			}
		});
	}

	@Override
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
		setRecord(grid.getSelectedRecord());
		Record selected = grid.getSelectedRecord();
		Map<String,Object> params = new HashMap<>();
		int budgetManagementId=BaseHelpUtils.getIntValue(selected.getAttribute("budgetManagementId"));
		params.put("budgetManagementId", budgetManagementId);
		DBDataSource.callOperation("NQ_BuggetDetailInfo",params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					detailgrid.setData(dsResponse.getData());
				}
			}
		});
		DBDataSource.callOperation("NQ_BudgetAttachmentDetail","find",params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					attachgrid.setData(dsResponse.getData());
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
				}
			}
		});
		
		DBDataSource.callOperation("NQ_AbountPaymentSequenceinfo","find",params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					paySeqGrid.setData(dsResponse.getData());
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
				}
			}
		});
		
		DBDataSource.callOperation("NQ_GetBudgetUplodaNews", params, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					upLoadgrid.setData(dsResponse.getData());
				}
			}
		});
		
		
		DBDataSource.callOperation("ST_BudgetManagementLinkProcess","find", params, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					processGrid.setData(dsResponse.getData());
				}
			}
		});
		
		
	}

	public void viewDetailData(){
	}

	@Override
	public DataSource getMainDataSource() {
		return DSOnBudgetManagement.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 5;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(detailgrid);
		res.add(upLoadgrid);
		res.add(attachgrid);
		res.add(paySeqGrid);
		res.add(processGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("预算详情");
		res.add("预算单附件");
		res.add("预算附件详情");
		res.add("预算相关付款序列");
		res.add("关联的流程");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

