package com.pomplatform.client.employee.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.employee.datasource.DSPositiveEmployeeInfo;
import com.pomplatform.client.employee.form.PositiveEmployeeInfoSearchForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;

public class PositiveEmployeeInfoPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			PositiveEmployeeInfoPanel cm = new PositiveEmployeeInfoPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PositiveEmployeeInfo";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		ListGridField[] fields = new ListGridField[5];
		int idx = 0;
		fields[idx++] = new ListGridField("employeeNo");
		fields[idx++] = new ListGridField("employeeName");
		fields[idx++] = new ListGridField("departmentId");
		fields[idx] = new ListGridField("onboardDate");
		fields[idx++].setMinWidth(200);;
		fields[idx] = new ListGridField("positiveDate");
		fields[idx++].setMinWidth(200);
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setFields(fields);
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
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

		IButton workFlowButton = new IButton("转正");
		controlLayout.addMember(workFlowButton);
		workFlowButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择需要转正的员工");
							return;
						}
						Map<String, Object> params = new HashMap<>();
						params.put("optType", "positiveEmployee");
						params.put("drafter", ClientUtil.getUserId());
						MapUtils.convertRecordToMap(resultGrid.getDataSource(), resultGrid.getSelectedRecords(), params,"employeeList");
						DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0) {
									commonQuery();
								}else {
									ClientUtil.displayErrorMessage(dsResponse);
								}
							}
						});
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		commonQuery();
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by employee_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new PositiveEmployeeInfoSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSPositiveEmployeeInfo.getInstance();
	}


}

