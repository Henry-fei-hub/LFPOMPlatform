package com.pomplatform.client.employeemoneymanagespeemmepemmor.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource.DSMprojectcspppcpdcor;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.form.MprojectcspppcpdcorSearchForm;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.form.MprojectcspppcpdcorViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
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

public class MprojectcspppcpdcorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private MprojectcspppcpdcorSearchForm form;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			MprojectcspppcpdcorPanel cm = new MprojectcspppcpdcorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mprojectcspppcpdcor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		ListGridField [] fields = new ListGridField[10]; 
		int index = 0;
		fields[index] = new ListGridField("contractCode");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("projectCode");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("projectName");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("projectManageId");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("totalIntegral");
		index ++;
		fields[index] = new ListGridField("totalAmount");
		index ++;
		fields[index] = new ListGridField("sheetAmount");
		index ++;
		fields[index] = new ListGridField("returnMoney");
		index ++;
		fields[index] = new ListGridField("returnPercent");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("createTime");
		fields[index].setShowGridSummary(false);
		
		resultGrid.setFields(fields);
		resultGrid.setShowGridSummary(true);
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
				if(resultGrid.anySelected()){
					Record record = resultGrid.getSelectedRecord();
					String contractCode = record.getAttribute("contractCode");
					String preffix = contractCode.substring(0, contractCode.indexOf(".", 3));
					form.getField("contractCode").setValue(preffix);
					commonQuery();
				}
//				showDetail();
			}
		});
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		IButton exportBtn = new IButton("导出");
		controlLayout.addMember(exportBtn);
		exportBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map params =  generateCriteria();
				DBDataSource.downloadFile("DW_Mprojectcspppcpdcor", params);
				
			}
		});
		IButton analyProjectBtn = new IButton("订单统计");
		controlLayout.addMember(analyProjectBtn);
		analyProjectBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					int projectId = BaseHelpUtils.getIntValue(resultGrid.getSelectedRecord().getAttribute("projectId"));
					analysisData(projectId, 2, analyProjectBtn);
				} else {
					SC.say("请选择一个订单");
				}
				
			}
		});
		IButton analyContractBtn = new IButton("合同统计");
		controlLayout.addMember(analyContractBtn);
		analyContractBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					int contractId = BaseHelpUtils.getIntValue(resultGrid.getSelectedRecord().getAttribute("contractId"));
					if(contractId > 0){
						analysisData(contractId, 1, analyContractBtn);
					}else{
						SC.say("该订单没有关联合同");
					}
				} else {
					SC.say("请选择一个订单");
				}
				
			}
		});
		IButton allProjectBtn = new IButton("全部统计");
		controlLayout.addMember(allProjectBtn);
		allProjectBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				analysisData(0, 3, allProjectBtn);
			}
		});
//		IButton removeButton = new IButton("删除");
//		controlLayout.addMember(removeButton);
//		removeButton.setIcon("[SKIN]/actions/remove.png");
//		removeButton.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				if (!resultGrid.anySelected()) {
//					SC.say("Please select a data to remove.");
//				}
//				final ListGridRecord selected = resultGrid.getSelectedRecord();
//				DBDataSource.callOperation("ST_Mprojectcspppcpdcor", "delete", selected.toMap(), new DSCallback() {
//					@Override
//					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//						if (dsResponse.getStatus() < 0) {
//							ClientUtil.displayErrorMessage(dsResponse);
//						} else {
//							int indexNum = resultGrid.getRowNum(selected);
//							resultGrid.removeData(selected);
//							resultGrid.selectSingleRecord(indexNum);
//						}
//					}
//				});
//			}
//		});

		commonQuery();
	}
	
	public void analysisData(int id, int type, IButton btn){
		btn.setDisabled(true);
		btn.setTitle("进行中...");
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("type", type);
		params.put("opt_type", "doAnalysis");
		DBDataSource.callOperation("EP_CustomIntegralAnalysisProcess", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() > 0){
					SC.say("更新成功");
				} else {
					ClientUtil.displayErrorMessage(dsResponse);
				}
				btn.setDisabled(false);
				if(type == 3){
					btn.setTitle("全部统计");
				}else if(type == 1){
					btn.setTitle("合同统计");
				}else if(type == 2){
					btn.setTitle("订单统计");
				}
			}
		});
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
				detail.setTitle("详情");
				detail.setWidth100();
				detail.setHeight100();
				MprojectcspppcpdcorViewer detailForm = new MprojectcspppcpdcorViewer();
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
		criteria.put("addtionalCondition", "order by project_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		form = new MprojectcspppcpdcorSearchForm();
		return form;
	}

	@Override
	public DataSource getDataSource() {
		return DSMprojectcspppcpdcor.getInstance();
	}

}
