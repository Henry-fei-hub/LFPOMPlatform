package com.pomplatform.client.onloadnewaccountsinfo.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.onenewaccountstransationsinfo.panel.OneNewAccountsTransationsInfoPanel;
import com.pomplatform.client.onloadnewaccountsinfo.datasource.DSNewAccountsInfo;
import com.pomplatform.client.onloadnewaccountsinfo.form.NewAccountsInfoSearchForm;
import com.pomplatform.client.onloadnewaccountsinfo.form.NewAccountsInfoViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class NewAccountsInfoPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			NewAccountsInfoPanel cm = new NewAccountsInfoPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "NewAccountsInfo";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
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
//		IButton viewButton = new IButton("查看详细");
//		viewButton.addClickHandler(new ClickHandler(){
//			@Override
//			public void onClick(ClickEvent event) {
//				showDetail();
//			}
//		});
//		controlLayout.addMember(viewButton);

		IButton querryOneButton=new IButton("查看流水");
		querryOneButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GenericViewWindow details = new GenericViewWindow();
				Record record = resultGrid.getSelectedRecord();
				details.setTitle("查看流水详细"); 
				details.setWidth100(); 
				details.setHeight100(); 
				OneNewAccountsTransationsInfoPanel detailsForm=new OneNewAccountsTransationsInfoPanel();
				detailsForm.setData(record);
				detailsForm.commonQuery();
				details.setContent(detailsForm);
				details.centerInPage();
				details.show();

			}
		});
		controlLayout.addMember(querryOneButton);







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
				detail.setTitle("账户查看详细"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				NewAccountsInfoViewer detailForm = new NewAccountsInfoViewer();
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
		criteria.put("addtionalCondition", "order by account_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new NewAccountsInfoSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSNewAccountsInfo.getInstance();
	}


}

