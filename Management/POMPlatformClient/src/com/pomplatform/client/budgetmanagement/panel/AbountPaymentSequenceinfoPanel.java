package com.pomplatform.client.budgetmanagement.panel;

import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import com.smartgwt.client.widgets.layout.HLayout;

import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.budgetmanagement.datasource.DSAbountPaymentSequenceinfo;
import com.pomplatform.client.budgetmanagement.form.AbountPaymentSequenceinfoSearchForm;
import com.pomplatform.client.budgetmanagement.form.AbountPaymentSequenceinfoViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class AbountPaymentSequenceinfoPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			AbountPaymentSequenceinfoPanel cm = new AbountPaymentSequenceinfoPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AbountPaymentSequenceinfo";
		}

	}

	@Override
	public void init(){
//		super.init();
		__needControl = true;
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid=new DelicacyListGrid(){
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				int payStatus=BaseHelpUtils.getIntValue(record.getAttribute("payStatus"));
				if(payStatus==1) {//未付款
					return null;
				}else if(payStatus==2) {//已付款 
					resultGrid.getRecord(rowNum).set_canEdit(false);
					return "color: 009966;";
				}else if(payStatus==3) {//付款申请中
					resultGrid.getRecord(rowNum).set_canEdit(false);
					return "color: #D2691E;";
				}
				else {
					return null;
				}

			}  
		};
		int index = 0;
		ListGridField[] fields = new ListGridField[14];
		fields[index] = new ListGridField("attachmentName");
		index++;
		fields[index] = new ListGridField("fileUrl");
		fields[index].setLinkText("预算文件下载/预览");
		index++;
		fields[index] = new ListGridField("payType");
		fields[index].setShowGridSummary(false);
		fields[index].setValueMap(KeyValueManager.getValueMap("system_dictionary_193"));
		index++;
		fields[index] = new ListGridField("reimbursementAmount","报销金额");
		fields[index].setAlign(Alignment.RIGHT);
		fields[index].setType(ListGridFieldType.FLOAT);
		fields[index].setFormat("##,###,###,###,##0.00");
		fields[index].setWidth("25%");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("payAmount","<span style='color:red;'>付款金额</span>");
		fields[index].setAlign(Alignment.RIGHT);
		fields[index].setType(ListGridFieldType.FLOAT);
		fields[index].setFormat("##,###,###,###,##0.00");
		fields[index].setWidth("25%");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("reverseAmount","冲账金额");
		fields[index].setAlign(Alignment.RIGHT);
		fields[index].setType(ListGridFieldType.FLOAT);
		fields[index].setFormat("##,###,###,###,##0.00");
		fields[index].setWidth("25%");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("returnAmount","还款金额");
		fields[index].setAlign(Alignment.RIGHT);
		fields[index].setType(ListGridFieldType.FLOAT);
		fields[index].setFormat("##,###,###,###,##0.00");
		fields[index].setWidth("25%");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("applyPayDate");
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
		fields[index] = new ListGridField("receiveUnitManageId");
		KeyValueManager.loadValueMap("receive_unit_manages_company",fields[index]);
		fields[index].setShowGridSummary(false);
		index++;
		fields[index] = new ListGridField("psRemark");
		fields[index].setShowGridSummary(false);
		index++;
		fields[index] = new ListGridField("payStatus");
		fields[index].setShowGridSummary(false);
		fields[index].setValueMap(KeyValueManager.getValueMap("system_dictionary_194"));
		index++;
		fields[index] = new ListGridField("payDate");
		index++;
		fields[index] = new ListGridField("budgetContractAmount");
		fields[index].setType(ListGridFieldType.FLOAT);
		fields[index].setFormat("##,###,###,###,##0.00");
		index++;
		fields[index] = new ListGridField("budgetContractAmountUse");
		fields[index].setType(ListGridFieldType.FLOAT);
		fields[index].setFormat("##,###,###,###,##0.00");
		index++;
		fields[index] = new ListGridField("budgetContractAmountRest");
		fields[index].setType(ListGridFieldType.FLOAT);
		fields[index].setFormat("##,###,###,###,##0.00");
		index++;
		fields[index] = new ListGridField("payPercent");
		fields[index].setShowGridSummary(false);
		index++;
		fields[index] = new ListGridField("projectId");
		KeyValueManager.loadValueMap("projects",fields[index]);
		fields[index].setShowGridSummary(false);
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
		resultGrid.setFields(fields);
		resultGrid.setShowGridSummary(true);
		resultGrid.setDataSource(getDataSource());
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {

			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Record record=resultGrid.getSelectedRecord();
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

	}

	@Override
	public void initComponents() {
		/*IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});*/
		/*IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);*/
		IButton downloadButton = new IButton("导出");
		downloadButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_AbountPaymentSequenceinfo", condition);
			}
		});
		controlLayout.addMember(downloadButton);
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("AbountPaymentSequenceinfo"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				AbountPaymentSequenceinfoViewer detailForm = new AbountPaymentSequenceinfoViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("budgetManagementId", BaseHelpUtils.getIntValue(record.getAttribute("budgetManagementId")));
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSAbountPaymentSequenceinfo.getInstance();
	}

	private Record record;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}


}

