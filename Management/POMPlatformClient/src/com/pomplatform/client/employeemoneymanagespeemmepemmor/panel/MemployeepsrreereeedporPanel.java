package com.pomplatform.client.employeemoneymanagespeemmepemmor.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource.DSMemployeepsrreereeedpor;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.form.MemployeepsrreereeedporSearchForm;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.form.MemployeepsrreereeedporViewer;
import com.pomplatform.client.receiveunit.panel.MemployeeProcessbilllistsmmeorPanel;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class MemployeepsrreereeedporPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			MemployeepsrreereeedporPanel cm = new MemployeepsrreereeedporPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Memployeepsrreereeedpor";
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
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
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
				String employeeId = resultGrid.getSelectedRecord().getAttribute("employeeId");
				pblPanel.getForm().getField("employeeId").setValue(employeeId);
				pblPanel.commonQuery();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by employee_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new MemployeepsrreereeedporSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMemployeepsrreereeedpor.getInstance();
	}

	
	private MemployeeProcessbilllistsmmeorPanel pblPanel;


	public MemployeeProcessbilllistsmmeorPanel getPblPanel() {
		return pblPanel;
	}

	public void setPblPanel(MemployeeProcessbilllistsmmeorPanel pblPanel) {
		this.pblPanel = pblPanel;
	}
	

}

