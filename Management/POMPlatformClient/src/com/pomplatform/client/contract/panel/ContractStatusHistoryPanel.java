package com.pomplatform.client.contract.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.contract.datasource.DSContractStatusHistory;
import com.pomplatform.client.contract.form.ContractStatusHistorySearchForm;
import com.pomplatform.client.contract.form.ContractStatusHistoryViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class ContractStatusHistoryPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ContractStatusHistoryPanel cm = new ContractStatusHistoryPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ContractStatusHistory";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton downloadButton = new IButton("导出数据");
		controlLayout.addMember(downloadButton);
		downloadButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				DBDataSource.downloadFile("DW_ContractStatusHistory", generateCriteria());
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
				detail.setTitle("历史合同状态"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ContractStatusHistoryViewer detailForm = new ContractStatusHistoryViewer();
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
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ContractStatusHistorySearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSContractStatusHistory.getInstance();
	}


}

