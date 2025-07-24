package com.pomplatform.client.collection.panel;

import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.AutoHorizontalAlignmentConstant;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 *
 */
public class CustomItemInvoiceMainPanel extends VLayout {
	private static Logger __LOGGER = Logger.getLogger("");
	//流水账
    public static CustomItemCollectionPanel customItemCollectionPanel;
    //对应的发票
    public static CustomInvoicePanel customInvoicePanel;
    
    public static Label customItemCollectionTitle;
    public static Label customInvoiceTitle;
    
	public CustomItemInvoiceMainPanel(int contractId) {
		CustomItemInvoiceMainPanel.contractId=contractId;
		//---标题--------------------
		customItemCollectionTitle = new Label("合同回款流水");
		customItemCollectionTitle.setHeight(30);
		customItemCollectionTitle.setAlign(Alignment.CENTER);
		
		customInvoiceTitle = new Label("发票回款");
		customInvoiceTitle.setHeight(1);
		customInvoiceTitle.setAlign(Alignment.CENTER);
		
		//---加载面板--------------------
		customItemCollectionPanel = new CustomItemCollectionPanel(contractId,false,false);
		customItemCollectionPanel.startEdit();
		
		customInvoicePanel = new CustomInvoicePanel(contractId);
		customInvoicePanel.startEdit();
		setHeight100();
		setMembersMargin(5);
		
		
		//top
		VLayout topBox = new VLayout(10);
		topBox.setWidth100();
		topBox.setHeight("50%");
		//添加一个标题
		topBox.addMember(customItemCollectionTitle);
		
		
		
		//top Grid 添加一个绑定发票的按钮
		HLayout centerLayout = new HLayout(10);
		centerLayout.setWidth100();
		centerLayout.setHeight100();
		
		
		HLayout leftGrid = new HLayout(10);
		leftGrid.setWidth("94%");
		leftGrid.setHeight100();
		VLayout btnVLayout = new VLayout(10);
		btnVLayout.setLayoutTopMargin(10);
		btnVLayout.setWidth("6%");
		btnVLayout.setHeight100();
		IButton btn=new IButton("绑定发票");
		btn.addClickHandler(new ClickHandler() {
					
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download");
                    }

                    @Override
                    public void onSuccess() {
                    	if (!customItemCollectionPanel.SourceGrid.anySelected()) {
                            SC.say("请选择一条数据");
                            return;
                        }
                        PopupWindow pw = new PopupWindow();
                        ListGridRecord[] selected = customItemCollectionPanel.SourceGrid.getSelectedRecords();
                        double lsSum = BaseHelpUtils.getDoubleValue(selected[0].getAttribute("borrowMoney")+"");
//                        __LOGGER.info("selected[0].getAttribute(borrowMoney)="+selected[0].getAttribute("borrowMoney"));
//                        __LOGGER.info("lsSum="+lsSum);
                        int capitalId=BaseHelpUtils.getIntValue(selected[0].getAttribute("capitalId")+"");
                        CustomSetInvoicePanel panel=new CustomSetInvoicePanel(CustomItemInvoiceMainPanel.contractId,lsSum,capitalId);
                        panel.startEdit();
                        panel.addDataEditedHandler(new DataEditedHandler() {//设置父窗口刷新
							@Override
							public void onDataEdited(DataEditEvent event) {
								customItemCollectionPanel.startEdit();
								customInvoicePanel.startEdit();
							}
						});
                        panel.setFatherWindow(pw);
                        pw.addItem(panel);
                        pw.setTitle("发票回款【款额="+lsSum+"】");
                        pw.setWidth100();
                        pw.setHeight100();
                        pw.centerInPage();
                        pw.show();
                    }
                });
			}
		});
		//添加一个付款流水的Grid
		leftGrid.addMember(customItemCollectionPanel);
		btnVLayout.addMember(btn);
		centerLayout.addMember(leftGrid);
		centerLayout.addMember(btnVLayout);
		topBox.addMember(centerLayout);
		//bottom
		VLayout bottomBox = new VLayout(10);
		bottomBox.setWidth100();
		bottomBox.setHeight("50%");
		//设置一个水平布局
		HLayout spBox = new HLayout(10);
		spBox.setWidth100();
		spBox.setHeight100();
		bottomBox.addMember(spBox);
		//设置1个垂直布局
		VLayout leftVBox = new VLayout(10);
		leftVBox.setWidth100();
		leftVBox.setHeight100();
		//添加一个标题
		leftVBox.addMember(customInvoiceTitle);
		leftVBox.addMember(customInvoicePanel);
		spBox.addMember(leftVBox);
		 
	    //最后加入
		addMember(topBox);
		addMember(bottomBox);
		 
    }
	private static String infoCode;
	private static String projectCode;
	private static int contractId;
}
