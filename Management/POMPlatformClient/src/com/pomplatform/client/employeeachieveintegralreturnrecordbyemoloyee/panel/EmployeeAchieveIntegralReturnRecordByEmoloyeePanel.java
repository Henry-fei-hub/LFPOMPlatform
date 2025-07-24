package com.pomplatform.client.employeeachieveintegralreturnrecordbyemoloyee.panel;

import java.util.Map;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.employeeachieveintegralreturnrecordbyemoloyee.datasource.DSEmployeeAchieveIntegralReturnRecordByEmoloyee;
import com.pomplatform.client.employeeachieveintegralreturnrecordbyemoloyee.form.EmployeeAchieveIntegralReturnRecordByEmoloyeeSearchForm;
import com.pomplatform.client.employeeachieveintegralreturnrecordbyemoloyee.form.EmployeeAchieveIntegralReturnRecordByEmoloyeeViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class EmployeeAchieveIntegralReturnRecordByEmoloyeePanel extends AbstractSearchPanel
{


	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			EmployeeAchieveIntegralReturnRecordByEmoloyeePanel cm = new EmployeeAchieveIntegralReturnRecordByEmoloyeePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "EmployeeAchieveIntegralReturnRecordByEmoloyee";
		}

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

		IButton totalButton = new IButton("汇总");
		controlLayout.addMember(totalButton);
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] recordList = resultGrid.getRecords();
				int len = recordList.length;
				Record[] records = new Record[len + 1];
				if (len > 0) {
					double achieveIntegral = 0;
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("plateId"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						achieveIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("achieveIntegral"));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("plateId", "汇总");
					record.setAttribute("achieveIntegral", achieveIntegral);
					records[len] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
					resultGrid.setCanEdit(false);
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("Semployeeachieveintegralreturnrecordprror"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				EmployeeAchieveIntegralReturnRecordByEmoloyeeViewer detailForm = new EmployeeAchieveIntegralReturnRecordByEmoloyeeViewer();
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
		criteria.put("plateId", plateId);
		criteria.put("recordYear", recordYear);
		criteria.put("recordMonth", recordMonth);
		return true;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 80;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new EmployeeAchieveIntegralReturnRecordByEmoloyeeSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSEmployeeAchieveIntegralReturnRecordByEmoloyee.getInstance();
	}
	
	private Integer plateId;
	private Integer recordYear;
	private Integer recordMonth;
	public Integer getPlateId() {
		return plateId;
	}

	public void setPlateId(Integer plateId) {
		this.plateId = plateId;
	}

	public Integer getRecordYear() {
		return recordYear;
	}

	public void setRecordYear(Integer recordYear) {
		this.recordYear = recordYear;
	}

	public Integer getRecordMonth() {
		return recordMonth;
	}

	public void setRecordMonth(Integer recordMonth) {
		this.recordMonth = recordMonth;
	}

}

