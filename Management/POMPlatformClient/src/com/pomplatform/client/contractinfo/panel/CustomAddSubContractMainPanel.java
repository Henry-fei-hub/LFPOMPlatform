package com.pomplatform.client.contractinfo.panel;

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
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 *
 * @author CL
 */
public class CustomAddSubContractMainPanel extends VLayout implements HasHandlers {

	private static final Logger __logger = Logger.getLogger("");
	public static CustomAddChildContractStartPanel childContract;
	public static CustomAddConsiderationPanel consideration;
	public static CustomParentContractPanel parentContract;
	public static Label childContractTitle;
	public static Label considerationTitle;
	private Window parentWindow;
	public static DynamicForm __infoForm;
    public static TextAreaItem subContractRemark;//整个子订单的备注
    public static IButton saveRemarkBtn;

	public CustomAddSubContractMainPanel(int contractId, Record record, int flowStatus) {
		// 获取项目编号
		final String projectCode = record.getAttribute("projectCode");
		final int __contractId = contractId;
		considerationTitle = new Label("拆分价列表");
		childContractTitle = new Label("子订单列表");
		childContract = new CustomAddChildContractStartPanel(flowStatus,consideration);
		childContract.setHeight100();
		consideration = new CustomAddConsiderationPanel();
		setHeight100();
		setMembersMargin(5);

		// 报价单grid
		VLayout myBJVLayout=new VLayout(10);
		VLayout considerationPanel = new VLayout(5);
		considerationPanel.setHeight("60%");
		considerationTitle.setHeight(30);
		considerationTitle.setAlign(Alignment.CENTER);
		considerationPanel.addMember(considerationTitle);
		consideration.setContractId(contractId);
		consideration.startEdit();
		considerationPanel.addMember(consideration);
		
		
		VLayout parentContractpanel = new VLayout(5);
		parentContractpanel.setHeight("40%");
		parentContract = new CustomParentContractPanel();
		parentContract.setRecord(record);
		parentContract.startEdit();
		parentContractpanel.addMember(parentContract);
		
		myBJVLayout.addMember(considerationPanel);
		myBJVLayout.addMember(parentContractpanel);

		// 子合同grid
		VLayout myVLayout=new VLayout(10);
		myVLayout.setHeight100();
		VLayout childContractPanel = new VLayout(10);
		childContractPanel.setHeight(800);
		childContractTitle.setHeight(30);
		childContractTitle.setAlign(Alignment.CENTER);
		childContractPanel.addMember(childContractTitle);
		childContract.setContractId(contractId);
		childContract.startEdit();
		childContractPanel.addMember(childContract);
		myVLayout.addMember(childContractPanel);
		//添加备注框
        __infoForm = new DynamicForm();
		__infoForm.setWidth100();
		__infoForm.setHeight(120);
		__infoForm.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
		subContractRemark=new TextAreaItem("subContractRemark","订单备注");
		subContractRemark.setWidth("*");
		
		saveRemarkBtn=new IButton("保存");
		VLayout saveVL=new VLayout(10);
		saveVL.setLayoutTopMargin(40);
		saveVL.setLayoutRightMargin(3);
		saveVL.addMember(saveRemarkBtn);
		saveRemarkBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> params = new HashMap<>();
				params.put("opt_type", "saveContentInfo");
				params.put("employeeId", ClientUtil.getEmployeeId());
				params.put("contractId", __contractId);
				params.put("contentInfo", __infoForm.getItem("subContractRemark").getValue());
				DBDataSource.callOperation("EP_CustomSubContractHandler", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() > 0) {
							SC.say("save success");
						}
					}
				});
				
			}
		});
		
		
		__infoForm.setFields(subContractRemark);
		
		HLayout myHLayout=new HLayout(10);
		myHLayout.addMember(__infoForm);
		myHLayout.addMember(saveVL);
		myVLayout.addMember(myHLayout);
		myHLayout.setBorder("1px solid #ABABAB");
		

		// 创建子合同按钮
		IButton showButto = new IButton("创建订单");
		showButto.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final ListGridRecord[] records = consideration.resultGrid.getSelectedRecords();
				if (records.length > 0) {
					SC.ask("提示", "确认创建？", new BooleanCallback() {
						@Override
						public void execute(Boolean value) {
							if (value) {
								// 获取拆分价Id信息
								String ids = "";
								for (int i = 0; i < records.length; i++) {
									int desiderationId = BaseHelpUtils
											.getIntValue(records[i].getAttribute("designConsiderationId"));
									if (i != 0) {
										ids = ids + ",";
									}
									ids = ids + desiderationId;
								}
								Map<String, Object> params = new HashMap<>();
								params.put("ids", ids);
								params.put("opt_type", "addSubContract");
								params.put("projectCode", projectCode);
								params.put("contractId", __contractId);
								DBDataSource.callOperation("EP_CustomSubContractHandler", "", params, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() > 0) {
											childContract.startEdit();
											consideration.startEdit();
										}
									}
								});
							}
						}
					});
				} else {
					SC.say("请选择拆分价");
				}
			}
		});

		// 撤销按钮
		IButton revertButto = new IButton("撤销订单");
		revertButto.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final ListGridRecord[] records = childContract.SourceGrid.getSelectedRecords();
				if (records.length > 0) {
					SC.ask("提示", "确认撤销？", new BooleanCallback() {
						@Override
						public void execute(Boolean value) {
							if (value) {
								// 获取子合同主键
								int subContractId = records[0].getAttributeAsInt("subContractId");
								Map<String, Object> params = new HashMap<>();
								params.put("subContractId", subContractId);
								params.put("opt_type", "delelteSubContract");
								DBDataSource.callOperation("EP_CustomSubContractHandler", "", params, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() > 0) {
											childContract.startEdit();
											consideration.startEdit();
										}
									}
								});
							}
						}
					});
				} else {
					SC.say("请选择子订单");
				}
			}
		});

		// 提交按钮
		IButton submitButto = new IButton("提交订单");
		submitButto.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String subContractRemark=BaseHelpUtils.getString(__infoForm.getItem("subContractRemark").getValue());
				if(BaseHelpUtils.isNullOrEmpty(subContractRemark)){
					SC.say("订单备注不能空");
					return;
				}
				
				ListGridRecord[] list = consideration.resultGrid.getRecords();
				boolean pass = true;// 检测是否还存在
				for (ListGridRecord listGridRecord : list) {
					double splitPrice = listGridRecord.getAttributeAsDouble("splitPrice");
					if (splitPrice > 0) {
						pass = false;
						break;
					}

				}
				if (pass) {
					SC.ask("提示", "确认提交订单？", new BooleanCallback() {
						@Override
						public void execute(Boolean value) {
							if (value) {
								
								
								Map<String, Object> params = new HashMap<>();
								params.put("opt_type", "saveContentInfo");
								params.put("employeeId", ClientUtil.getEmployeeId());
								params.put("contractId", __contractId);
								params.put("contentInfo", __infoForm.getItem("subContractRemark").getValue());
								DBDataSource.callOperation("EP_CustomSubContractHandler", params, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() > 0) {
											// 获取子合同主键
											Map<String, Object> params = new HashMap<>();
											params.put("contractId", __contractId);
											params.put("opt_type", "goFlowMainContract");
											params.put("flowStatus", 3);
											DBDataSource.callOperation("EP_CustomMainContractHandler", "", params,
											new DSCallback() {
												@Override
												public void execute(DSResponse dsResponse, Object data,
														DSRequest dsRequest) {
													if (dsResponse.getStatus() > 0) {
														getParentWindow().destroy();
														DataEditEvent dee = new DataEditEvent();
														fireEvent(dee);
													} else {
														ClientUtil.displayErrorMessage(dsResponse);
													}
												}
											});
										}
									}
								});
							}
						}
					});
				} else {
					SC.say("还存在有拆分价金额的报价单没进行订单创建,不准许提交！");
				}
			}
		});
		IButton projectManageBtn = new IButton("项目管理");
		projectManageBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// 先将数据保存数据库
				Map<String, Object> params = new HashMap<>();
				params.put("contractId", __contractId);
				params.put("opt_type", "addProjectManageSubContract");
				DBDataSource.callOperation("EP_CustomSubContractHandler", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() > 0) {
//							childContract.startEdit();
							childContract.SourceGrid.setData(dsResponse.getData());
							int index=childContract.SourceGrid.getRecordList().getLength();
//							ListGridRecord selected = childContract.SourceGrid.getRecord(index-1);
							CustomAddChildContractStartPanel.SourceGrid.startEditing(index-1);
						} else {
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});

		// 左边操作按钮面板
		VLayout leftButtonLayout = new VLayout(5);
		leftButtonLayout.setLayoutTopMargin(45);
		leftButtonLayout.setWidth("6%");
		leftButtonLayout.setHeight100();
		leftButtonLayout.addMember(showButto);
		leftButtonLayout.addMember(revertButto);

		// 右边操作按钮面板
		VLayout rightButtonLayout = new VLayout(5);
		rightButtonLayout.setLayoutTopMargin(45);
		rightButtonLayout.setWidth("6%");
		rightButtonLayout.setHeight100();
		rightButtonLayout.addMember(submitButto);
		rightButtonLayout.addMember(projectManageBtn);

		HLayout hPanel = new HLayout(10);
		hPanel.setWidth100();
		hPanel.setHeight100();

		VLayout vPanel = new VLayout(10);
		vPanel.setWidth100();
		vPanel.setHeight100();

		if (Browser.getIsDesktop()) {
			if (flowStatus == 0) {
				myBJVLayout.setWidth("40%");
				myVLayout.setWidth("48%");

				hPanel.addMember(myBJVLayout);
				hPanel.addMember(leftButtonLayout);
				hPanel.addMember(myVLayout);
				hPanel.addMember(rightButtonLayout);
			} else {
				considerationPanel.setWidth("46%");
				childContractPanel.setWidth("54%");
				hPanel.addMember(myBJVLayout);
				hPanel.addMember(myVLayout);
			}
			addMember(hPanel);
		} else {
			if (flowStatus == 0) {

				vPanel.addMember(considerationPanel);
				vPanel.addMember(leftButtonLayout);
				vPanel.addMember(childContractPanel);
				vPanel.addMember(rightButtonLayout);
			} else {
				vPanel.addMember(considerationPanel);
				vPanel.addMember(childContractPanel);
			}
			addMember(vPanel);
		}
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

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}
}
