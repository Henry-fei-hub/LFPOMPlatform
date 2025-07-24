package com.pomplatform.client.collection.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.contractreceivables.datasource.DSContractReceivable;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class CustomSetContractReceivablePanel extends AbstractWizadPage implements HasHandlers{
	private static Logger __LOGGER = Logger.getLogger("");
	public TreeGrid SourceGrid;
    public final static String BORDER_STYLE = "1px solid #ABABAB";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
	
	public CustomSetContractReceivablePanel(final int contractId,final double lsSum,final int capitalId) {
		CustomSetContractReceivablePanel.contractId = contractId;
		CustomSetContractReceivablePanel.lsSum = lsSum;
		CustomSetContractReceivablePanel.capitalId = capitalId;
		setBorder(BORDER_STYLE);
		setPadding(5);
		SourceGrid = new TreeGrid();
		int idx = 0;
		TreeGridField [] fields = new TreeGridField[3];
		fields[idx] = new TreeGridField("receivableName");
		idx++ ;
		fields[idx] = new TreeGridField("receivableSumMoney");
		idx++;
		fields[idx] = new TreeGridField("stagePercentage");
		idx++ ;
		fields[idx] = new TreeGridField("stageSumMoney");
		idx++ ;
		SourceGrid.setFields(fields);
		SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		SourceGrid.setDataSource(DSContractReceivable.getInstance());
        SourceGrid.setShowOpenIcons(false);
        SourceGrid.setShowDropIcons(false);
        SourceGrid.setShowSelectedStyle(false);
        SourceGrid.setShowPartialSelection(true);
        //当为true时表示父级选中时子级自动选中，当子级选中时父级自动选中
        SourceGrid.setCascadeSelection(true);
        VLayout bigBox =new VLayout();
        bigBox.setWidth100();
        bigBox.setHeight100();
		VLayout allH =new VLayout();
		allH.setWidth100();
		allH.setHeight100();
		allH.setMargin(5);
		allH.addMember(SourceGrid);
		
		
		
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
					SC.say("没有选择合同阶段");
					return;
				}
				// 验证合同阶段和流水账的总金额是否正确
				SC.ask("提示", "确认合同阶段回款", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							//选中合同阶段的ids
							ListGridRecord[] selected = SourceGrid.getSelectedRecords();
						    StringBuilder ids=new StringBuilder();
						    StringBuilder balances=new StringBuilder();
						    StringBuilder receivableSumMoneys=new StringBuilder();
							for(int i=0;i<selected.length;i++){
								//将父结构过滤
								int parentId=BaseHelpUtils.getIntValue(selected[i].getAttribute("parentId"));
								if(parentId!=0){
									if(BaseHelpUtils.isNullOrEmpty(ids.toString())){
										int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("contractReceivableId"));
										double tempBalance=BaseHelpUtils.getDoubleValue(selected[i].getAttribute("stageSumMoney"));
										double tempReceivableSumMoney=BaseHelpUtils.getDoubleValue(selected[i].getAttribute("receivableSumMoney"));
										if(tempId!=0){
											ids.append(tempId);
											balances.append(tempBalance);
											receivableSumMoneys.append(tempReceivableSumMoney);
										}
									}else{
										int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("contractReceivableId"));
										double tempBalance=BaseHelpUtils.getDoubleValue(selected[i].getAttribute("stageSumMoney"));
										double tempReceivableSumMoney=BaseHelpUtils.getDoubleValue(selected[i].getAttribute("receivableSumMoney"));
										if(tempId!=0){
											ids.append(",");
											ids.append(tempId);
											balances.append(",");
											balances.append(tempBalance);
											receivableSumMoneys.append(",");
											receivableSumMoneys.append(tempReceivableSumMoney);
										}
									}
								}
							}
							Map<String, Object> condition = new HashMap<>();
							condition.put("opt_type", "setContractReceivable");
							condition.put("contractReceivableIds", ""+ids);//发票的id
							condition.put("balances", ""+balances);//原来这合同阶段已经回款的金额
							condition.put("receivableSumMoneys", ""+receivableSumMoneys);//这合同阶段的金额
							condition.put("capitalId", capitalId);
							condition.put("contractId", contractId);
							condition.put("lsSum", lsSum);
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
				SC.ask("提示", "确认取消?取消后所有进行的操作都会被还原！！！", new BooleanCallback() {
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
		bigBox.addMember(allH);
		bigBox.addMember(toolStripLayout);
		addMember(bigBox);
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		return __form.validate();
	}

	@Override
	public void startEdit() {
		if(0 != CustomSetContractReceivablePanel.contractId){
			Map<String, Object> params = new HashMap<>();
			params.put("contractId", CustomSetContractReceivablePanel.contractId);
			params.put("opt_type", "loadNotContractReceivable");
			//
			DBDataSource.callOperation("EP_CustomItemCollectionHandler", params, new DSCallback() {
				
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					int len = dsResponse.getData().length;
                    TreeNode[] nodes = new TreeNode[len];
                    for (int i = 0; i < len; i++) {
                        nodes[i] = new TreeNode();
                        DBDataSource.copyRecord(dsResponse.getData()[i], nodes[i]);
                    }
                    Tree tree = new Tree();
                    tree.setModelType(TreeModelType.PARENT);
                    tree.setRootValue("0");
                    tree.setIdField("contractReceivableId");
                    tree.setParentIdField("parentId");
                    tree.setData(nodes);
                    tree.openAll();
                    SourceGrid.setData(tree);
                  //设置默认选中的
					double balance=CustomSetContractReceivablePanel.lsSum;
					ListGridRecord[] recordList=SourceGrid.getRecords();
					if(recordList!=null){
						for(int i=0;i<recordList.length;i++){
							Record record=recordList[i];
							//先检测这合同阶段还剩的余额
							double stageSumMoney=BaseHelpUtils.getDoubleValue(record.getAttributeAsInt("stageSumMoney"));
							double receivableSumMoney=BaseHelpUtils.getDoubleValue(record.getAttributeAsInt("receivableSumMoney"));
						    balance-=(receivableSumMoney-stageSumMoney);
						    __LOGGER.info("balance = "+balance);
						    SourceGrid.selectRecord(i);//勾选中
						    
							if(BaseHelpUtils.getDoubleValue(balance)<=0){
								break;
							}
						}
					}
				}
			});
		}else{
			SourceGrid.clear();
		}
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