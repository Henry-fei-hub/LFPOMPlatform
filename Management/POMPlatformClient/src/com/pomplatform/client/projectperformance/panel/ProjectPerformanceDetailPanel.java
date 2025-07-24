package com.pomplatform.client.projectperformance.panel;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.pomplatform.client.projectperformance.datasource.DSProjectPerformanceDetail;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;

public class ProjectPerformanceDetailPanel extends AbstractSearchPanel
{

	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ProjectPerformanceDetailPanel cm = new ProjectPerformanceDetailPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ProjectPerformanceDetail";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needViewPage = false;
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

	}

//	public void showDetail() {
//		GWT.runAsync(new RunAsyncCallback() {
//			@Override
//			public void onFailure(Throwable reason) {
//				SC.say("failure to download code");
//			}
//			@Override
//			public void onSuccess() {
//				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
//				GenericViewWindow detail = new GenericViewWindow();
//				detail.setTitle("绩效详情表"); 
//				detail.setWidth100(); 
//				detail.setHeight100(); 
//				ProjectPerformanceDetailViewer detailForm = new ProjectPerformanceDetailViewer();
//				detailForm.setParentSearchForm(searchForm);
//				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
//				detailForm.initComponents();
//				detailForm.viewSelectedData(resultGrid);
//				detail.setContent(detailForm);
//				detail.centerInPage();
//				detail.show();
//			}
//		});
//	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", employeeId);
		criteria.put("contractId", contractId);
		criteria.put("projectId", projectId);
		criteria.put("performanceFlag", performanceFlag);
		criteria.put("businessType", businessType);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
//		return new ProjectPerformanceDetailSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSProjectPerformanceDetail.getInstance();
	}
	
	private String employeeId; 
	private String contractId; 
	private String projectId; 
	private Integer performanceFlag; 
	private Integer businessType;
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Integer getPerformanceFlag() {
		return performanceFlag;
	}

	public void setPerformanceFlag(Integer performanceFlag) {
		this.performanceFlag = performanceFlag;
	}

	public Integer getBusinessType() {
		return businessType;
	}

	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}

	@Override
	public void afterDataReceived(Record[] data) {
		super.afterDataReceived(data);
		if(null != projectId){
			//订单绩效
			resultGrid.getField("employeeId").setHidden(true);
		}else{
			//项目绩效
			resultGrid.getField("employeeId").setHidden(false);
			if(performanceFlag.equals(1)){
				//惩罚
				resultGrid.getField("performanceIntegral").setTitle("绩效扣除");
				resultGrid.getField("percent").setTitle("扣除比例(%)");
				resultGrid.getField("reason").setHidden(false);
				resultGrid.getField("remark").setTitle("惩罚说明");
				LinkedHashMap<String, String> linked = new LinkedHashMap<>();
				linked.put("0", "按比例扣除积分");
				linked.put("1", "按绩效扣除积分");
				resultGrid.getField("type").setValueMap(linked);
			}else if(performanceFlag.equals(2)){
				//奖励
				resultGrid.getField("performanceIntegral").setTitle("绩效奖励");
				resultGrid.getField("percent").setTitle("奖励比例(%)");
				resultGrid.getField("reason").setHidden(true);
				resultGrid.getField("remark").setTitle("奖励说明");
				LinkedHashMap<String, String> linked = new LinkedHashMap<>();
				linked.put("0", "按比例奖励积分");
				linked.put("1", "按绩效奖励积分");
				resultGrid.getField("type").setValueMap(linked);
			}
		}
		resultGrid.redraw();
	}
	
	public void reDrawResultGrid(){
		resultGrid.setShowGridSummary(true);
		if(null != performanceFlag && (performanceFlag.equals(1) || performanceFlag.equals(2))){
			ListGridField[] fields = new ListGridField[6];
			int idx = 0;
			fields[idx] = new ListGridField("type");
			fields[idx].setShowGridSummary(false);
			if(performanceFlag.equals(1)){
				//惩罚
				LinkedHashMap<String, String> linked = new LinkedHashMap<>();
				linked.put("0", "按比例扣除积分");
				linked.put("1", "按绩效扣除积分");
				fields[idx].setValueMap(linked);
			}else if(performanceFlag.equals(2)){
				//奖励
				LinkedHashMap<String, String> linked = new LinkedHashMap<>();
				linked.put("0", "按比例奖励积分");
				linked.put("1", "按绩效奖励积分");
				fields[idx].setValueMap(linked);
			}
			idx++;
			fields[idx] = new ListGridField("percent");
			if(performanceFlag.equals(1)){
				//惩罚
				fields[idx].setTitle("扣除比例(%)");
			}else if(performanceFlag.equals(2)){
				//奖励
				fields[idx].setTitle("奖励比例(%)");
			}
			idx++;
			fields[idx] = new ListGridField("performanceIntegral");
			if(performanceFlag.equals(1)){
				//惩罚
				fields[idx].setTitle("绩效扣除");
			}else if(performanceFlag.equals(2)){
				//奖励
				fields[idx].setTitle("绩效奖励");
			}
			idx++;
			fields[idx] = new ListGridField("operateEmployeeId");
			fields[idx].setShowGridSummary(false);
			idx++;
			fields[idx] = new ListGridField("recordDate");
			fields[idx].setShowGridSummary(false);
			idx++;
			fields[idx] = new ListGridField("remark");
			fields[idx].setShowGridSummary(false);
			if(performanceFlag.equals(1)){
				//惩罚
				fields[idx].setTitle("惩罚说明");
			}else if(performanceFlag.equals(2)){
				//奖励
				fields[idx].setTitle("奖励说明");
			}
			resultGrid.setFields(fields);
		}else{
			ListGridField[] fields = new ListGridField[7];
			int idx = 0;
			fields[idx] = new ListGridField("performanceFlag");
			LinkedHashMap<String, String> performanceFlagMap = new LinkedHashMap<>();
			performanceFlagMap.put("2", "绩效奖励");
			performanceFlagMap.put("1", "绩效扣除");
			fields[idx].setValueMap(performanceFlagMap);
			idx++;
			fields[idx] = new ListGridField("type");
			fields[idx].setShowGridSummary(false);
			LinkedHashMap<String, String> linked = new LinkedHashMap<>();
			linked.put("0", "按比例奖励/扣除积分");
			linked.put("1", "按绩效奖励/扣除积分");
			fields[idx].setValueMap(linked);
			idx++;
			fields[idx] = new ListGridField("percent");
			fields[idx].setTitle("奖励/扣除比例(%)");
			idx++;
			fields[idx] = new ListGridField("performanceIntegral");
			fields[idx].setTitle("绩效奖励/扣除");
			idx++;
			fields[idx] = new ListGridField("operateEmployeeId");
			fields[idx].setShowGridSummary(false);
			idx++;
			fields[idx] = new ListGridField("recordDate");
			fields[idx].setShowGridSummary(false);
			idx++;
			fields[idx] = new ListGridField("remark");
			fields[idx].setShowGridSummary(false);
			fields[idx].setTitle("奖励/惩罚说明");
			resultGrid.setFields(fields);
		}
		resultGrid.redraw();
	}
}

