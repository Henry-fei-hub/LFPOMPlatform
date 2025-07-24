package com.pomplatform.client.manageprojectemployee.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.manageprojectemployee.datasource.DSManageProjectEmployee;
import com.pomplatform.client.manageprojectemployee.form.ManageProjectEmployeeViewer;
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
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ManageProjectEmployeePanel extends AbstractSearchPanel {
	private static final Logger __logger = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			ManageProjectEmployeePanel cm = new ManageProjectEmployeePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ManageProjectEmployee";
		}
	}
	
	public int manageProjectId;

	public int getManageProjectId() {
		return manageProjectId;
	}

	public void setManageProjectId(int manageProjectId) {
		this.manageProjectId = manageProjectId;
	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		
		IButton totalButton = new IButton("汇总");
		controlLayout.addMember(totalButton);
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
                ListGridRecord[] recordList = resultGrid.getRecords();
                int len = recordList.length;
                Record[] records = new Record[len+1];
                if(len>0){
                	double assignIntegral = 0;
                	double assignedIntegral = 0;
                	for(int i=0;i<len;i++){
                		if("汇总".equals(recordList[i].getAttribute("employeeId"))){//如果已经存在汇总，则不可再进行汇总
                			return;
                		}
                		assignIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("assignIntegral"));
                		assignedIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("assignedIntegral"));
                		records[i]=recordList[i];
                	}
                	Record record = new Record();
                	record.setAttribute("employeeId", "汇总");
                	record.setAttribute("assignIntegral", assignIntegral);
                	record.setAttribute("assignedIntegral", assignedIntegral);
                	records[len] = record;
                	resultGrid.setData(records);
                	resultGrid.redraw();
                	resultGrid.setCanEdit(false);
                }
                
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton viewButton = new IButton("查看详细");
		viewButton.hide();
		viewButton.addClickHandler(new ClickHandler() {
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("管理项目成员");
				detail.setWidth100();
				detail.setHeight100();
				ManageProjectEmployeeViewer detailForm = new ManageProjectEmployeeViewer();
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
		if(manageProjectId > 0){
			criteria.put("manageProjectId", manageProjectId);
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		// return new ManageProjectEmployeeSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSManageProjectEmployee.getInstance();
	}

}
