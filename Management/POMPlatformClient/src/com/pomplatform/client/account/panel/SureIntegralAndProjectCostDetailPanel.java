package com.pomplatform.client.account.panel;

import java.math.BigDecimal;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.account.datasource.DSSureIntegralAndProjectCostDetail;
import com.pomplatform.client.account.form.SureIntegralAndProjectCostDetailViewer;
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

public class SureIntegralAndProjectCostDetailPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SureIntegralAndProjectCostDetailPanel cm = new SureIntegralAndProjectCostDetailPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SureIntegralAndProjectCostDetail";
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
				showDetail();
			}
		});
		
		IButton totalButton = new IButton("汇总");
		controlLayout.addMember(totalButton);
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] recordList = resultGrid.getRecords();
				int len = recordList.length;
				Record[] records = new Record[len + 1];
				if (len > 0) {
					BigDecimal integral = BigDecimal.ZERO;//设计项目
					BigDecimal integralOne = BigDecimal.ZERO;//设计项目
					BigDecimal integralTwo = BigDecimal.ZERO;//研发项目
					BigDecimal integralThree = BigDecimal.ZERO;//管理项目
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("sheetCode"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						//获取项目标示类型;1:设计项目;2:研发项目;3:管理项目
						int projectFlag = BaseHelpUtils.getIntValue(recordList[i].getAttribute("projectFlag"));
						if(projectFlag == 1){//说明是设计项目
							integralOne = integralOne.add(new BigDecimal(recordList[i].getAttribute("integral")));
						}else if(projectFlag == 2){//说明是研发项目
							integralTwo = integralTwo.add(new BigDecimal(recordList[i].getAttribute("integral")));
						}else if(projectFlag == 3){//说明是管理项目
							integralThree = integralThree.add(new BigDecimal(recordList[i].getAttribute("integral")));
						}
						integral = integral.add(new BigDecimal(recordList[i].getAttribute("integral")));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("sheetCode", "汇总");
					record.setAttribute("sheetName", "设计项目("+integralOne+"),"+"研发项目("+integralTwo+"),"+"管理项目("+integralThree+")");
					record.setAttribute("integral", integral);
					records[len] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
					resultGrid.setCanEdit(false);
				}

			}
		});
		
		IButton exportButton = new IButton("导出报表");
		controlLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_ExportSureIntegralAndProjectCostDetail", condition);
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("确认积分项目成本明细"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				SureIntegralAndProjectCostDetailViewer detailForm = new SureIntegralAndProjectCostDetailViewer();
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
		if(businessTypeId>0)criteria.put("businessTypeId", businessTypeId);
		if(plateId>0)criteria.put("plateId", plateId);
		if(employeeId>0)criteria.put("employeeId", employeeId);
		if(year>0)criteria.put("year", year);
		if(month>0)criteria.put("month", month);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return null;
//		return new SureIntegralAndProjectCostDetailSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSureIntegralAndProjectCostDetail.getInstance();
	}

	public int businessTypeId;
	public int plateId;
	public int employeeId;
	public int year;
	public int month;
	public int getBusinessTypeId() {
		return businessTypeId;
	}

	public void setBusinessTypeId(int businessTypeId) {
		this.businessTypeId = businessTypeId;
	}

	public int getPlateId() {
		return plateId;
	}

	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	

}

