package com.pomplatform.client.mcontracticcacccor.panel;

import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.collection.panel.CustomCapitalAndInvoicePanel;
import com.pomplatform.client.collection.panel.CustomItemInvoiceMainPanel;
import com.pomplatform.client.mcontracticcacccor.datasource.DSMcontracticcacccor;
import com.pomplatform.client.mcontracticcacccor.form.McontracticcacccorSearchForm;
import com.pomplatform.client.mcontracticcacccor.form.McontracticcacccorViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class McontracticcacccorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			McontracticcacccorPanel cm = new McontracticcacccorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mcontracticcacccor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		//设置行号
		resultGrid.setShowRowNumbers(true);
		ListGridField contractIdField = new ListGridField("contractId", 100);
		contractIdField.setHidden(true);
        ListGridField contractCodeField = new ListGridField("contractCode", 100);
        ListGridField contractNameField = new ListGridField("contractName", 150);
        ListGridField customerNameField = new ListGridField("customerName", 150);
        ListGridField signingMoneySumField = new ListGridField("signingMoneySum","合同总价", 100);
        ListGridField invoiceAmountField = new ListGridField("invoiceAmount", 100);
        ListGridField borrowMoneyField = new ListGridField("borrowMoney", 100);
        ListGridField unReciveMoneyField = new ListGridField("unReciveMoney", 100);
        ListGridField unReciveContractMoneyField = new ListGridField("unReciveContractMoney", 100);
        resultGrid.setShowGridSummary(true);
        resultGrid.setFields(contractIdField,contractCodeField,contractNameField,customerNameField,signingMoneySumField,
        		invoiceAmountField,borrowMoneyField,unReciveMoneyField,unReciveContractMoneyField);
        
		IButton refreshButton = new IButton("刷新");
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
		});
		IButton selectHKAndInvoiceButton = new IButton("查看回款&发票");
		controlLayout.addMember(selectHKAndInvoiceButton);
		selectHKAndInvoiceButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("Refresh, reload");
                    }

                    @Override
                    public void onSuccess() {
                    	if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据");
                            return;
                        }
                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
                        int contractId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("contractId"));
                        String contractName = BaseHelpUtils.getString(selected[0].getAttribute("contractName"));
                        PopupWindow pw = new PopupWindow();
                        CustomCapitalAndInvoicePanel panel=new CustomCapitalAndInvoicePanel(contractId);
                        pw.addItem(panel);
                        panel.setParentCanvas(pw);;
                        pw.setTitle("(" + contractName + ") 合同发票回款");
                        pw.setWidth100();
                        pw.setHeight100();
                        pw.centerInPage();
                        pw.show();
                    }
                });
			}
		});
		
		IButton exportButton = new IButton("导出");
		controlLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				DBDataSource.downloadFile("DW_Mcontracticcacccor", searchForm.getValues());
			}
		});
		
		commonQuery();
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}

			@Override
			public void onSuccess() {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("详情");
				detail.setWidth100();
				detail.setHeight100();
				McontracticcacccorViewer detailForm = new McontracticcacccorViewer();
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
		criteria.put("addtionalCondition", "order by contract_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new McontracticcacccorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMcontracticcacccor.getInstance();
	}
	@Override
	public int getSearchFormHeight() {
		// TODO Auto-generated method stub
		return 90;
	}

}
