package com.pomplatform.client.minvocieapplydedaocor.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.contracticcisiior.panel.ContractReceivablePanel;
import com.pomplatform.client.contracticcisiior.panel.LeftSignZeroInvoicePanel;
import com.pomplatform.client.contracticcisiior.panel.RightSignOneInvoicePanel;
import com.pomplatform.client.mcontractisubccacccor.panel.McontractisubccacccorPanel;
import com.pomplatform.client.mcontractreceivableiicor.panel.McontractreceivableiicorPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

/**
 * 
 * @ClassName: AddSignZeroContracticcisiiorPanel
 * @Description: 填开发票面板
 * @author CL
 * @date 2016年11月4日
 *
 */
public class UseInvoiceContracticcisiiorPanel extends VLayout {

	public final static String BORDER_STYLE = "1px solid #ABABAB";
	public final static String BACKGROUND_COLOR = "azure";
	public final static String FORM_BORDER_STYLE = "1px solid #808080";

	public final LeftSignZeroInvoicePanel leftSignZeroInvoicePanel;

	public final RightSignOneInvoicePanel rightSignOneInvoicePanel;

	private final McontractisubccacccorPanel mcontractisubccacccorPanel;//右边选择合同面板
	
	private final McontractreceivableiicorPanel mcontractreceivableiicorPanel;//合同阶段与阶段申请金额面板

	public UseInvoiceContracticcisiiorPanel(ListGridRecord applyRecord) {
		final Integer contractId = applyRecord.getAttributeAsInt("contractId");
		final String contractName = applyRecord.getAttributeAsString("contractName");
		final Integer invoiceType = applyRecord.getAttributeAsInt("invoiceType");
		final String customerName = applyRecord.getAttributeAsString("companyName");
		final BigDecimal applySumMoney = BaseHelpUtils.getBigDecimalValue(applyRecord.getAttribute("applySumMoney"));
		Integer invoiceApplyId = applyRecord.getAttributeAsInt("invoiceApplyId");
		setMargin(5);
		setBackgroundColor(BACKGROUND_COLOR);
		HLayout mainLayout = new HLayout();// 最外层面板
		mainLayout.setBorder(BORDER_STYLE);
		// ************* 添加左边 选用未使用的发票
		leftSignZeroInvoicePanel = new LeftSignZeroInvoicePanel();
		leftSignZeroInvoicePanel.setInvoiceType(invoiceType);
		leftSignZeroInvoicePanel.startEdit();

		// 添加右边 合同阶段选择面板 && 左右移动按钮 与选择的发票
		VLayout rightMainLayout = new VLayout();// 右边主面板
		rightMainLayout.setWidth("68%");

//		HLayout rtBottomLayout = new HLayout();// 右边下部分布局
//		rtBottomLayout.setHeight("65%");

		VLayout leftRightBtnLayout = new VLayout();
		leftRightBtnLayout.setAlign(VerticalAlignment.CENTER);
		leftRightBtnLayout.setWidth("7%");
		leftRightBtnLayout.setMembersMargin(10);
		leftRightBtnLayout.setPadding(20);
		leftRightBtnLayout.setLayoutTopMargin(260);
		
		// 右边移动控制
		IButton rightBtn = new IButton(">>");
		leftRightBtnLayout.addMember(rightBtn);
		rightBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				//向右移动时需要检测右方grid是否已经存在相同数据  存在则直接移除左方数据  不添加右方数据
				DelicacyListGrid toGrid = rightSignOneInvoicePanel.SourceGrid;
				DelicacyListGrid fromGrid = leftSignZeroInvoicePanel.SourceGrid;
				if (fromGrid.anySelected()) {
					Date currentDate = new Date();
					ListGridRecord[] records = fromGrid.getSelectedRecords();
					ListGridRecord[] checkRecords = toGrid.getRecords();
					for (ListGridRecord listGridRecord : records) {
						boolean flag = false;//数存在标志
						int invoiceId = listGridRecord.getAttributeAsInt("invoiceId");
						for (ListGridRecord __listGridRecord : checkRecords) {
							int __invoiceId = __listGridRecord.getAttributeAsInt("invoiceId");
							if(invoiceId == __invoiceId){
								flag = true;
								break;
							}
						}
						if(!flag){
							listGridRecord.setAttribute("taxRate", 6);
							listGridRecord.setAttribute("invoiceDate", currentDate);
							if(null != customerName){
								listGridRecord.setAttribute("clientName", customerName);
							}
							toGrid.addData(listGridRecord);
						}
						fromGrid.removeData(listGridRecord);
					}
				} else {
					SC.say("请选中需要使用的发票");
				}
			}
		});
		// 左边移动控制
		IButton leftBtn = new IButton("<<");
		leftRightBtnLayout.addMember(leftBtn);
		leftBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				//向左移动时需要检测左方grid是否已经存在相同数据  存在则直接移除右方数据  不添加右方数据
				DelicacyListGrid fromGrid = rightSignOneInvoicePanel.SourceGrid;
				DelicacyListGrid toGrid = leftSignZeroInvoicePanel.SourceGrid;
				if (fromGrid.anySelected()) {
					ListGridRecord[] records = fromGrid.getSelectedRecords();
					ListGridRecord[] checkRecords = toGrid.getRecords();
					for (ListGridRecord listGridRecord : records) {
						boolean flag = false;//数存在标志
						int invoiceId = listGridRecord.getAttributeAsInt("invoiceId");
						for (ListGridRecord __listGridRecord : checkRecords) {
							int __invoiceId = __listGridRecord.getAttributeAsInt("invoiceId");
							if(invoiceId == __invoiceId){
								flag = true;
								break;
							}
						}
						if(!flag){
							toGrid.addData(listGridRecord);
						}
						fromGrid.removeData(listGridRecord);
					}
				} else {
					SC.say("请选中需要取消使用的发票");
				}
			}
		});
		// 底部工具栏添加
		ToolStrip btnLayout = new ToolStrip();
		btnLayout.setVPolicy(LayoutPolicy.FILL);
		btnLayout.setPadding(5);
		btnLayout.setHeight(40);
		btnLayout.setWidth100();
		btnLayout.addFill();
		IButton saveBtn = new IButton("确认开票");
		saveBtn.setIcon("[SKIN]/actions/save.png");
		btnLayout.addMember(saveBtn);
		btnLayout.addSpacer(10);
		saveBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

//				if (!contractReceivablePanel.checkData()) {
//					SC.say("请选择合同");
//					return;
//				}
				// 验证发票信息是否正确
				if (rightSignOneInvoicePanel.SourceGrid.getRecords().length > 0) {
					if (rightSignOneInvoicePanel.checkData()) {
						List<Map> list = new ArrayList<>();
						// 获取使用的发票信息
						ListGridRecord[] records = rightSignOneInvoicePanel.SourceGrid.getRecords();
						BigDecimal addAllMoney = BigDecimal.ZERO;
						for (ListGridRecord listGridRecord : records) {
							addAllMoney = addAllMoney.add(BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("invoiceAmount")));
							list.add(listGridRecord.toMap());
						}
						if(addAllMoney.compareTo(applySumMoney) > 0){
							SC.say("开票总金额不能大于申请总金额");
							return;
						}
						SC.ask("提示", "确认保存?保存后将会使用选择的发票！！！", new BooleanCallback() {

							@Override
							public void execute(Boolean value) {
								if (value) {
									
									// 获取合同阶段信息
									String ids = null;
//									if (contractReceivablePanel.SourceGrid.anySelected()) {
//										ListGridRecord[] crRecords = contractReceivablePanel.SourceGrid
//												.getSelectedRecords();
//										int crIndex = 0;
//										for (ListGridRecord listGridRecord : crRecords) {
//											if (crIndex == 0) {
//												ids = listGridRecord.getAttributeAsString("contractReceivableId");
//											} else {
//												ids = ids + ","
//														+ listGridRecord.getAttributeAsString("contractReceivableId");
//											}
//											crIndex++;
//										}
//									}

									Map<String, Object> params = new HashMap<>();
									params.put("list", list);
									params.put("ids", ids);
									params.put("invoiceApplyId", invoiceApplyId);
									params.put("contractId", contractId);
									params.put("employeeId", ClientUtil.getEmployeeId());
									params.put("opt_type", "addSingOneInvoices");
									DBDataSource.callOperation("EP_CustomSinvoiceitiorHandler", "addSingOneInvoices",
											params, new DSCallback() {

												@Override
												public void execute(DSResponse dsResponse, Object data,
														DSRequest dsRequest) {
													if (dsResponse.getStatus() >= 0) {
														getFatherWindow().destroy();
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
					} else {
						SC.say("请将需要使用的发票信息补充完整");
					}
				} else {
					SC.say("没有添加需要使用的发票信息");
					return;
				}

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
							getFatherWindow().destroy();
						}
					}
				});
			}
		});

		//面板添加布局  与创建实例
		Label applySumMoneyLabel = new Label("申请总金额 ：" +applySumMoney + "(元)");
		applySumMoneyLabel.setHeight(50);
		rightMainLayout.addMember(applySumMoneyLabel);
		
		rightSignOneInvoicePanel = new RightSignOneInvoicePanel();
		
		mcontractisubccacccorPanel = new McontractisubccacccorPanel();
		mcontractisubccacccorPanel.setUpdate(false);
		mcontractisubccacccorPanel.setHeight("20%");
		com.smartgwt.client.widgets.Canvas canvas = mcontractisubccacccorPanel.getViewPanel();
		canvas.setHeight("100");
		rightMainLayout.addMember(canvas);
		mcontractisubccacccorPanel.setContractId(contractId);
		mcontractisubccacccorPanel.commonQuery();
		
		mcontractreceivableiicorPanel = new McontractreceivableiicorPanel(false);
		mcontractreceivableiicorPanel.setContractId(contractId);
		mcontractreceivableiicorPanel.setInvoiceApplyId(invoiceApplyId);
		mcontractreceivableiicorPanel.startEdit();
		mcontractreceivableiicorPanel.setHeight("20%");
		// 面板布局添加
		rightMainLayout.setPadding(5);
		rightMainLayout.addMember(mcontractreceivableiicorPanel); // ******************
		rightMainLayout.addMember(rightSignOneInvoicePanel);
		mainLayout.addMember(leftSignZeroInvoicePanel); // ********** 待添加左边主面板
		mainLayout.addMember(leftRightBtnLayout);
		mainLayout.addMember(rightMainLayout);
		mainLayout.addMember(btnLayout);

		// rtBottomLayout.addMember(leftRightBtnLayout);
		// rtBottomLayout.addMember(rightSignOneInvoicePanel);
		// //****************待添加 选择发票面板
		// rightMainLayout.addMember(contractReceivablePanel);
		// //****************** 待添加右边合同阶段 面板
		// rightMainLayout.addMember(rtBottomLayout);
		// mainLayout.addMember(leftSignZeroInvoicePanel); //********** 待添加左边主面板
		// mainLayout.addMember(rightMainLayout);
		//// mainLayout.addMember(btnLayout);
		addMember(mainLayout);
		addMember(btnLayout);
	}

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
