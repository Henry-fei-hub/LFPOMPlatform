package com.pomplatform.client.projectperformance.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.projectperformance.datasource.DSFindProjectInfoByContractId;
import com.pomplatform.client.projectperformance.form.SheetPerformanceSearchForm;
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

public class SheetPerformancePanel extends AbstractSearchPanel
{

	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SheetPerformancePanel cm = new SheetPerformancePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SheetPerformancePanel";
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
		resultGrid.setShowGridSummary(true);
		ListGridField [] fields = new ListGridField[16];
		int index = 0;
		fields[index] = new ListGridField("plateId");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("sheetCode");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("sheetName");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("sheetAmount");
		index ++;
		fields[index] = new ListGridField("totalIntegral");
		fields[index].setHidden(true);
		index ++;
		fields[index] = new ListGridField("projectIntegral");
		fields[index].setHidden(true);
		index ++;
		fields[index] = new ListGridField("reserveIntegral");
		fields[index].setHidden(true);
		index ++;
		fields[index] = new ListGridField("complaintIntegral");
		index ++;
		fields[index] = new ListGridField("sureIntegral");
		fields[index].setHidden(true);
		index ++;
		fields[index] = new ListGridField("projectCost");
		fields[index].setHidden(true);
		index ++;
		fields[index] = new ListGridField("deductIntegral");
		index ++;
		fields[index] = new ListGridField("awardIntegral");
		index ++;
		fields[index] = new ListGridField("finishPercent");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("totalRevenue");
		index ++;
		fields[index] = new ListGridField("leftIntegral");
		index ++;
		fields[index] = new ListGridField("projectManageId");
		fields[index].setShowGridSummary(false);
		resultGrid.setFields(fields);
		
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if(resultGrid.anySelected()){
					Record record = resultGrid.getSelectedRecords()[0];
					PopupWindow window = new PopupWindow();
					window.setTitle("历史考核明细");
					window.setWidth100();
					window.setHeight100();
					ProjectPerformanceDetailPanel panel = new ProjectPerformanceDetailPanel();
					panel.setContractId(record.getAttribute("contractId"));
					panel.setProjectId(record.getAttribute("projectId"));
					panel.setBusinessType(2);
					panel.reDrawResultGrid();
					panel.commonQuery();
					window.addMember(panel);
					window.centerInPage();
					window.show();	
				}else{
					SC.say("请先选择您要查看的订单");
				}	
			}
		});
		
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
		List<Map> keyvalues = new ArrayList<>();
		Map<String, String> kv = new HashMap<>();
		kv.put("key", "ORDER BY plate_id");
		kv.put("value", "and aa.project_id in(select project_id from project_performances where business_type = 2) ORDER BY plate_id");
		keyvalues.add(kv);
		criteria.put("keyValues", keyvalues);
		return true;
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new SheetPerformanceSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSFindProjectInfoByContractId.getInstance();
	}
	
}

