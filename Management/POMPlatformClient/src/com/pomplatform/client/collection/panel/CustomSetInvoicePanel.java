package com.pomplatform.client.collection.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.ja.ht.datasource.DSOutDesignConsideration;
import com.pomplatform.client.sinvoiceitior.datasource.DSSinvoiceitior;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DropCompleteEvent;
import com.smartgwt.client.widgets.events.DropCompleteHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;

public class CustomSetInvoicePanel extends AbstractWizadPage {

	private static Logger __LOGGER = Logger.getLogger("");
	public DelicacyListGrid SourceGrid;
	
	public CustomSetInvoicePanel(final int contractId,final double lsSum,final int capitalId) {
		CustomSetInvoicePanel.contractId = contractId;
		CustomSetInvoicePanel.lsSum = lsSum;
		CustomSetInvoicePanel.capitalId = capitalId;
		SourceGrid = new DelicacyListGrid();
		SourceGrid.setDataSource(DSSinvoiceitior.getInstance());
		SourceGrid.setCanEdit(false);
		
		VLayout bigLayout = new VLayout();
		bigLayout.setWidth100();
		VLayout SearchSourceLayout = new VLayout();
		SearchSourceLayout.setWidth100();
		ListGridField[] fields = new ListGridField[8];
		int idx = 0;
		fields[idx] = new ListGridField("invoiceId");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("sign");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("invoiceType");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("invoiceDate");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("invoiceCode");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("invoiceNumber");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("invoiceAmount");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("outputTax","回款金额");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("taxRate","回款百分比(%)");
		fields[idx].setShowGridSummary(false);
		idx++;
		 
		SourceGrid.setFields(fields);
		SourceGrid.setShowRowNumbers(true);
		SourceGrid.setShowGridSummary(true);
		SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		SearchSourceLayout.setHeight100();
		SearchSourceLayout.setLayoutRightMargin(5);
		SearchSourceLayout.setMembersMargin(10);
		SearchSourceLayout.addMember(SourceGrid);
		
		bigLayout.addMember(SearchSourceLayout);
		VLayout toolStripLayout = new VLayout();
		// 底部工具栏添加
		ToolStrip btnLayout = new ToolStrip();
		btnLayout.setVPolicy(LayoutPolicy.FILL);
		btnLayout.setPadding(5);
		btnLayout.setHeight(40);
		btnLayout.setWidth100();
		btnLayout.addFill();
		IButton saveBtn = new IButton("保存");
		saveBtn.setIcon("[SKIN]/actions/save.png");
		btnLayout.addMember(saveBtn);
		btnLayout.addSpacer(10);
		saveBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] selected = SourceGrid.getSelectedRecords();
				int count=selected.length;
				if(count<=0){
					SC.say("没有选择发票");
					return;
				}
				// 验证发票和流水账的总金额是否正确
				SC.ask("提示", "确认发票回款", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							 __LOGGER.info("save 发票回款");
							//选中发票的ids
							ListGridRecord[] selected = SourceGrid.getSelectedRecords();
							//发票ids
						    StringBuilder ids=new StringBuilder();
						    //发票回款
						    StringBuilder balances=new StringBuilder();
						    //发票回款百分比
						    StringBuilder stagePer=new StringBuilder();
						    //发票金额
						    StringBuilder invoiceMoneys=new StringBuilder();
							for(int i=0;i<selected.length;i++){
								if(BaseHelpUtils.isNullOrEmpty(ids.toString())){
									int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("invoiceId"));
									double tempBalance=BaseHelpUtils.getDoubleValue(selected[i].getAttribute("outputTax"));
									double tempInvoice=BaseHelpUtils.getDoubleValue(selected[i].getAttribute("invoiceAmount"));
									double tempStagePer=BaseHelpUtils.getDoubleValue(selected[i].getAttribute("taxRate"));
									if(tempId>0){
										ids.append(tempId);
										balances.append(tempBalance);
										stagePer.append(tempStagePer);
										invoiceMoneys.append(tempInvoice);
									}
								}else{
									int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("invoiceId"));
									double tempBalance=BaseHelpUtils.getDoubleValue(selected[i].getAttribute("outputTax"));
									double tempInvoice=BaseHelpUtils.getDoubleValue(selected[i].getAttribute("invoiceAmount"));
									double tempStagePer=BaseHelpUtils.getDoubleValue(selected[i].getAttribute("taxRate"));
									if(tempId>0){
										ids.append(",");
										ids.append(tempId);
										balances.append(",");
										balances.append(tempBalance);
										stagePer.append(",");
										stagePer.append(tempStagePer);
										invoiceMoneys.append(",");
										invoiceMoneys.append(tempInvoice);
									}
								}
							}
							Map<String, Object> condition = new HashMap<>();
							condition.put("opt_type", "setInvoiceReceivable");
							condition.put("invoiceIds", ""+ids);//发票的id
							condition.put("balances", ""+balances);//原来这张发票已经回款的金额
							condition.put("stagePer", ""+stagePer);//原来这张发票已经回款的百分比
							condition.put("invoiceMoneys", ""+invoiceMoneys);//这张发票的金额
							condition.put("capitalId", capitalId);
							condition.put("contractId", contractId);
							condition.put("lsSum", lsSum);//流水账的总金额
							condition.put("operator", ClientUtil.getEmployeeId());
							
							 
							DBDataSource.callOperation("EP_CustomItemCollectionHandler", condition, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										fatherWindow.destroy();
										DataEditEvent dee = new DataEditEvent();
										fireEvent(dee);
									}else{
										ClientUtil.displayErrorMessage(dsResponse);
									}
								}
							});
							
							
						}
					}
				});
			}
		});

		IButton cancelBtn = new IButton("取消");
		cancelBtn.setIcon("[SKIN]/actions/close.png");
		btnLayout.addMember(cancelBtn);
		btnLayout.addSpacer(10);
		cancelBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				SC.ask("提示", "放弃操作", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							fatherWindow.destroy();
						}
					}
				});
			}
		});
		toolStripLayout.addMember(btnLayout);
		bigLayout.addMember(toolStripLayout);
		addMember(bigLayout);
	}

	@Override
	public void startEdit() {
		__LOGGER.info("CustomInvoicePanel start load contractId=" + contractId);
		if (BaseHelpUtils.getIntValue(contractId) > 0) {
			Map<String, Object> condition = new HashMap<>();
			condition.put("opt_type", "loadNotInvoiceList");
			condition.put("contractId", contractId);
			DBDataSource.callOperation("EP_CustomItemCollectionHandler", "", condition, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					SourceGrid.setData(dsResponse.getData());
					//设置默认选中的
					double balance=CustomSetInvoicePanel.lsSum;
					ListGridRecord[] recordList=SourceGrid.getRecords();
					if(recordList!=null){
						for(int i=0;i<recordList.length;i++){
							Record record=recordList[i];
							//先检测这张发票还剩的余额
							double stageSumMoney=BaseHelpUtils.getDoubleValue(record.getAttributeAsInt("outputTax"));//发票的回款金额
							double invoiceAmount=BaseHelpUtils.getDoubleValue(record.getAttributeAsInt("invoiceAmount"));
						    balance-=(invoiceAmount-stageSumMoney);
						    __LOGGER.info("balance = "+balance);
						    SourceGrid.selectRecord(i);//勾选中
						    
						    
							if(BaseHelpUtils.getDoubleValue(balance)<=0){
								break;
							}
						}
					}
				}
			});
		}
	}
	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("CustomInvoicePanel");
		return res;
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	private static int contractId;
	private static double lsSum;
	private static int capitalId;
	private Window fatherWindow;

	public Window getFatherWindow() {
		return fatherWindow;
	}

	public void setFatherWindow(Window fatherWindow) {
		this.fatherWindow = fatherWindow;
	}

	@Override
	public boolean checkData() {
		// TODO Auto-generated method stub
		return true;
	}
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}
}
