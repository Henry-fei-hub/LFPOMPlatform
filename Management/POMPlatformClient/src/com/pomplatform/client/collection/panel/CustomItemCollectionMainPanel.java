package com.pomplatform.client.collection.panel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.pomplatform.client.contractreceivables.panel.ContractReceivablePanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 *
 */
public class CustomItemCollectionMainPanel extends VLayout {
	private static Logger __LOGGER = Logger.getLogger("");
	// 流水账
	public static CustomItemCollectionPanel customItemCollectionPanel;
	// 合同付款阶段
	public static CustomContractReceivablePanel customContractReceivablePanel;

	public static Label customItemCollectionTitle;
	public static Label customContractReceivableTitle;

	public CustomItemCollectionMainPanel(int contractId) {
		CustomItemCollectionMainPanel.contractId = contractId;
		// ---标题--------------------
		customItemCollectionTitle = new Label("合同回款流水");
		customItemCollectionTitle.setHeight(30);
		customItemCollectionTitle.setAlign(Alignment.CENTER);

		customContractReceivableTitle = new Label("合同回款阶段");
		customContractReceivableTitle.setHeight(2);
		customContractReceivableTitle.setAlign(Alignment.CENTER);

		// ---加载面板--------------------
		customItemCollectionPanel = new CustomItemCollectionPanel(contractId, true,false);
		customItemCollectionPanel.startEdit();

		customContractReceivablePanel = new CustomContractReceivablePanel(contractId);
		customContractReceivablePanel.startEdit();

		// top
		VLayout topBox = new VLayout(10);
		topBox.setWidth100();
		topBox.setHeight("50%");
		// 添加一个标题
		topBox.addMember(customItemCollectionTitle);

		// top Grid 添加一个绑定发票的按钮
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
		IButton btn = new IButton("绑定合同阶段");
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
						double lsSum = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("borrowMoney"));
						int capitalId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("capitalId"));
						CustomSetContractReceivablePanel panel = new CustomSetContractReceivablePanel(CustomItemCollectionMainPanel.contractId,
								lsSum, capitalId);
						panel.startEdit();
						panel.addDataEditedHandler(new DataEditedHandler() {// 设置父窗口刷新
							@Override
							public void onDataEdited(DataEditEvent event) {
								customItemCollectionPanel.startEdit();
								customContractReceivablePanel.startEdit();
							}
						});
						panel.setFatherWindow(pw);
						pw.addItem(panel);
						pw.setTitle("合同阶段回款");
						pw.setWidth100();
						pw.setHeight100();
						pw.centerInPage();
						pw.show();
					}
				});
			}
		});
		// 添加一个付款流水的Grid
		leftGrid.addMember(customItemCollectionPanel);
		btnVLayout.addMember(btn);
		centerLayout.addMember(leftGrid);
		centerLayout.addMember(btnVLayout);
		topBox.addMember(centerLayout);
		// bottom
		VLayout bottomBox = new VLayout(10);
		bottomBox.setWidth100();
		bottomBox.setHeight("50%");
		// 设置一个水平布局
		HLayout spBox = new HLayout(10);
		spBox.setWidth100();
		spBox.setHeight100();
		bottomBox.addMember(spBox);
		// 设置1个垂直布局
		VLayout leftVBox = new VLayout(10);
		leftVBox.setWidth100();
		leftVBox.setHeight100();
		// 添加一个标题
		leftVBox.addMember(customContractReceivableTitle);
		leftVBox.addMember(customContractReceivablePanel);
		spBox.addMember(leftVBox);

		// 最后加入
		addMember(topBox);
		addMember(bottomBox);

	}

	private static String infoCode;
	private static String projectCode;
	private static int contractId;
}
