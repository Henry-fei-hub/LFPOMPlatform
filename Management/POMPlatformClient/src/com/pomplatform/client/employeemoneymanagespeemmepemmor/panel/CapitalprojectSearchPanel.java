package com.pomplatform.client.employeemoneymanagespeemmepemmor.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource.DSCapitalprojectSearch;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.form.CapitalprojectSearchSearchForm;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.form.CapitalprojectSearchViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class CapitalprojectSearchPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			CapitalprojectSearchPanel cm = new CapitalprojectSearchPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "CapitalprojectSearch";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
	}

	@Override
	public void initComponents() {
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		IButton addButton = new IButton("添加");
		controlLayout.addMember(addButton);
		addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] selectRecords = resultGrid.getSelectedRecords();
				ListGridRecord[] existRecords = subcontractGrid.getRecords();
				for (ListGridRecord __selectRecord : selectRecords) {
					boolean flag = true;
					int projectId = __selectRecord.getAttributeAsInt("projectId");
					for (ListGridRecord __existRecord : existRecords) {
						int __subContractId = __existRecord.getAttributeAsInt("subContractId");
						if (projectId == __subContractId) {
							flag = false;
							break;
						}
					}
					if (flag) {
						__selectRecord.setAttribute("subContractId", projectId);
						subcontractGrid.addData(__selectRecord);
					}
				}
			}
		});
//		commonQuery();
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
				detail.setTitle("CapitalprojectSearch");
				detail.setWidth100();
				detail.setHeight100();
				CapitalprojectSearchViewer detailForm = new CapitalprojectSearchViewer();
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
	public void commonQuery() {
		if(contractId > 0){
			Map<String, Object> params = new HashMap<>();
			params.put("contractId", contractId);
			params.put("opt_type", "getProjectByContractId");
			DBDataSource.callOperation("EP_CustomCapitalDistributionProcess", params, new DSCallback() {
				
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() > 0){
						resultGrid.setData(dsResponse.getData());
					} else {
//						__logger.info("错误！ " + dsResponse.getErrors().get("errorMsg"));
					}
					
				}
			});
		}
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by project_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
//		return new CapitalprojectSearchSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSCapitalprojectSearch.getInstance();
	}

	public DelicacyListGrid subcontractGrid;

	@Override
	public int getSearchFormHeight() {
		return 60;
	}
	
	private Integer contractId;

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}
	
}
