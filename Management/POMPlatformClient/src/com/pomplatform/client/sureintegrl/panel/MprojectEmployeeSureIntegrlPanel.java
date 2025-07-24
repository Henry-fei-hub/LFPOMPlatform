package com.pomplatform.client.sureintegrl.panel;

import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.sureintegrl.datasource.DSMprojectEmployeeSureIntegrl;
import com.pomplatform.client.sureintegrl.form.MprojectEmployeeSureIntegrlSearchForm;
import com.pomplatform.client.sureintegrl.form.MprojectEmployeeSureIntegrlViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;

public class MprojectEmployeeSureIntegrlPanel extends AbstractSearchPanel
{


	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			MprojectEmployeeSureIntegrlPanel cm = new MprojectEmployeeSureIntegrlPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "MprojectEmployeeSureIntegrl";
		}

	}

	@Override
	public void initComponents() {
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
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
				detail.setTitle("项目成员积分确认"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				MprojectEmployeeSureIntegrlViewer detailForm = new MprojectEmployeeSureIntegrlViewer();
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
	public SearchForm generateSearchForm() {
		return new MprojectEmployeeSureIntegrlSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMprojectEmployeeSureIntegrl.getInstance();
	}


}

