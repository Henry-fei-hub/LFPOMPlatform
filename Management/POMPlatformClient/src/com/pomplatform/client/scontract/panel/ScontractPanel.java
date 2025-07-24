package com.pomplatform.client.scontract.panel;

import java.math.BigDecimal;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.contractreceivables.panel.ContractReceivablePanel;
import com.pomplatform.client.scontract.datasource.DSScontract;
import com.pomplatform.client.scontract.form.ScontractSearchForm;
import com.pomplatform.client.scontract.form.ScontractViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ScontractPanel extends AbstractSearchPanel
{

	private static Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ScontractPanel cm = new ScontractPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Scontract";
		}

	}

	@Override
	public void initComponents() {
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
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		IButton btn1 =PermissionControl.createPermissionButton("收款阶段", ERPPermissionStatic.SK_MANAGEMENT);
		controlLayout.addMember(btn1);
		btn1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一行数据");
				}
				SC.debugger();
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				String infoCode=selected.getAttributeAsString("infoCode");//信息编号
				String projectCode=selected.getAttributeAsString("projectCode");// 项目编号
				Integer contractId=selected.getAttributeAsInt("contractId");//合同id
				String contractCode=selected.getAttributeAsString("contractCode");//合同主编号
				BigDecimal signingMoneySum = BaseHelpUtils.getBigDecimalValue((selected.getAttribute("signingMoneySum")));
				PopupWindow pw = new PopupWindow("填写收款阶段");
				
				ContractReceivablePanel.infoCode=infoCode;
				ContractReceivablePanel.projectCode=projectCode;
				ContractReceivablePanel.contractId=contractId;
				ContractReceivablePanel.contractCode=contractCode;
				ContractReceivablePanel.signingMoneySum=signingMoneySum;
				ContractReceivablePanel panel = new ContractReceivablePanel();
				pw.addItem(panel);
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
				
			}
		});
		IButton exportBtn = new IButton("导出");
		controlLayout.addMember(exportBtn);
		exportBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				DBDataSource.downloadFile("DW_Scontract", generateCriteria());
				
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("Scontract"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ScontractViewer detailForm = new ScontractViewer();
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
		return new ScontractSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSScontract.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 100;
	}
}

