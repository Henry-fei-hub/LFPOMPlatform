package com.pomplatform.client.capitaldistribution.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.capitaldistribution.datasource.DSCapitalDistributionOfDepartment;
import com.pomplatform.client.capitaldistribution.form.CapitalDistributionOfDepartmentSearchForm;
import com.pomplatform.client.capitaldistribution.form.CapitalDistributionOfDepartmentViewer;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.PomPlatformClientUtil;
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
import com.smartgwt.client.widgets.grid.ListGridField;

public class CapitalDistributionOfDepartmentPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			CapitalDistributionOfDepartmentPanel cm = new CapitalDistributionOfDepartmentPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "CapitalDistributionOfDepartment";
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
		ListGridField[] fields = new ListGridField[11];
		int idx = 0;
		fields[idx] = new ListGridField("contractCode");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("contractId");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("projectId");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("plateId");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("projectManageId");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("totalAmount");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("totalDistributionAmount");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("leftAmount");
		fields[idx++].setShowGridSummary(false);
		fields[idx++] = new ListGridField("distributionAmount");
		fields[idx] = new ListGridField("happenDate");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("remark");
		fields[idx++].setShowGridSummary(false);
		
		resultGrid.setFields(fields);
		resultGrid.setShowGridSummary(true);
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				CapitalDistributionBarChartPanel panel = new CapitalDistributionBarChartPanel();
				panel.initComponents();
				panel.setContractId(resultGrid.getSelectedRecord().getAttribute("contractId"));
				panel.loadData();
				PopupWindow window = new PopupWindow("回款分配");
				window.setWidth100();
				window.setHeight100();
				window.centerInPage();
				window.addMember(panel);
				window.show();
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
		
		IButton changePlateButton = new IButton("更改业务部门");
        controlLayout.addMember(changePlateButton);
        changePlateButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择需要更改业务部门的记录");
							return;
						}
						Record[] records = resultGrid.getSelectedRecords();
						StringBuilder sb = new StringBuilder();
						for(Record record : records){
							int capitalDistributionId = BaseHelpUtils.getIntValue(record.getAttributeAsObject("capitalDistributionId"));
							if(capitalDistributionId > 0){
								if(sb.length() > 0){
									sb.append(",");
								}
								sb.append(capitalDistributionId);
							}
						}
						PopupWindow window = new PopupWindow("更改业务部门");
						window.setWidth(300);
						window.setHeight(220);
						SelectCapitalDistributionPlatePanel panel = new SelectCapitalDistributionPlatePanel();
						panel.setIds(sb.toString());
						panel.setParentWindow(window);
						panel.initComponents();
						panel.addDataEditedHandler(new DataEditedHandler() {
							
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						window.addItem(panel);
						window.centerInPage();
						window.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
        
		IButton downloadButton = new IButton("导出");
		downloadButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				DBDataSource.downloadFile("DW_CapitalDistributionOfDepartment", generateCriteria());
			}
		});
		controlLayout.addMember(downloadButton);
		
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
				detail.setTitle("部门回款分配"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				CapitalDistributionOfDepartmentViewer detailForm = new CapitalDistributionOfDepartmentViewer();
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
		List<Map<String,Object>> keyvalues = new ArrayList<>();
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.CAPITAL_DISTRIBUTION_CHECK_ALL)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.CAPITAL_DISTRIBUTION_CHECK_PLATE)) {
			String plates = PomPlatformClientUtil.getRolePlateId();
			Map<String, Object> kv = new HashMap<>();
			kv.put("key", "and a.plate_id = ?");
			kv.put("value", "and a.plate_id in (" + plates + ") and a.plate_id = ?");
			keyvalues.add(kv);
		}
        if(!BaseHelpUtils.isNullOrEmpty(keyvalues)){
        	criteria.put("keyValues", keyvalues);
        }
		criteria.put("addtionalCondition", "order by capital_distribution_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new CapitalDistributionOfDepartmentSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSCapitalDistributionOfDepartment.getInstance();
	}

}

