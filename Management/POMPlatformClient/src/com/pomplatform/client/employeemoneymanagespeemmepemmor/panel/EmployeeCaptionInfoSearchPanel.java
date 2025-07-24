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
import com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource.DSEmployeeCaptionInfoSearch;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.form.EmployeeCaptionInfoSearchSearchForm;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.form.EmployeeCaptionInfoSearchViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class EmployeeCaptionInfoSearchPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	private MemployeemoneymanagespeemmepemmorPanel cpPanel = new MemployeemoneymanagespeemmepemmorPanel();
	
	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			EmployeeCaptionInfoSearchPanel cm = new EmployeeCaptionInfoSearchPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "EmployeeCaptionInfoSearch";
		}

	}

	@Override
	public void init() {
		super.init();
		__needControl = false;
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
//		IButton refreshButton = new IButton("刷新");
//		controlLayout.addMember(refreshButton);
//		refreshButton.setIcon("[SKIN]/actions/refresh.png");
//		refreshButton.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				commonQuery();
//			}
//		});
//
//		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
//			@Override
//			public void onDoubleClick(DoubleClickEvent event) {
//				showDetail();
//			}
//		});
//		IButton operation1Button = new IButton("查看详情");
//		controlLayout.addMember(operation1Button);
//		operation1Button.setIcon("[SKIN]/actions/view.png");
//		operation1Button.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				showDetail();
//			}
//		});
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if(resultGrid.anySelected()){
					Record record = resultGrid.getSelectedRecord();
					int employeeId = record.getAttributeAsInt("employeeId");
					MemployeemoneymanagespeemmepemmorPanel.employeeId = employeeId;
					cpPanel.commonQuery();
				}
				
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
				detail.setTitle("EmployeeCaptionInfoSearch");
				detail.setWidth100();
				detail.setHeight100();
				EmployeeCaptionInfoSearchViewer detailForm = new EmployeeCaptionInfoSearchViewer();
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
		criteria.put("addtionalCondition", "order by employee_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new EmployeeCaptionInfoSearchSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSEmployeeCaptionInfoSearch.getInstance();
	}

	public MemployeemoneymanagespeemmepemmorPanel getCpPanel() {
		return cpPanel;
	}

	public void setCpPanel(MemployeemoneymanagespeemmepemmorPanel cpPanel) {
		this.cpPanel = cpPanel;
	}
	
}
