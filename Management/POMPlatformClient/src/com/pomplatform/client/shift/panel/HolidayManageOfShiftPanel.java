package com.pomplatform.client.shift.panel;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.shift.datasource.DSHolidayManageOfShift;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class HolidayManageOfShiftPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			HolidayManageOfShiftPanel cm = new HolidayManageOfShiftPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "HolidayManageOfShift";
		}

	}

	@Override
	public void init(){
		super.init();
		resultGrid.setAutoFitFieldWidths(false);
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		resultGrid.setCanEdit(true);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		ListGridField[] fields = new ListGridField[8];
		int idx = 0;
		fields[idx] = new ListGridField("name");
		idx ++;
		fields[idx] = new ListGridField("year");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("month");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("startTime");
		idx ++;
		fields[idx] = new ListGridField("endTime");
		idx ++;
		fields[idx] = new ListGridField("recordDate");
		idx ++;
		fields[idx] = new ListGridField("isWorkDay");
		idx ++;
		fields[idx] = new ListGridField("isCountOvertime");
		idx ++;
		fields[idx] = new ListGridField("description");
		idx ++;
		resultGrid.setFields(fields);
		resultGrid.setShowFilterEditor(true);
		resultGrid.setFilterOnKeypress(true);
		IButton newButton = new IButton("新建");
		controlLayout.addMember(newButton);
		newButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				resultGrid.startEditingNew();
			}
		});
		
		IButton addMoreButton = new IButton("批量新增");
		controlLayout.addMember(addMoreButton);
		addMoreButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow popupWindow = new PopupWindow("节日设置");
				popupWindow.setWidth("50%");
				popupWindow.setHeight("50%");
				popupWindow.centerInPage();
				HolidayManageAddMorePanel assignIntegral = new HolidayManageAddMorePanel();
				assignIntegral.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				assignIntegral.initComponents();
				popupWindow.addItem(assignIntegral);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						commonQuery();
					}
				});
				assignIntegral.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});

		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();
				Date recordDate = params.get("recordDate")==null?new Date():(Date)params.get("recordDate");
				DateTimeFormat dfYear = DateTimeFormat.getFormat("yyyy");
				String year = dfYear.format(recordDate);
				DateTimeFormat dfMonth = DateTimeFormat.getFormat("MM");
				String month = dfMonth.format(recordDate);
				params.put("year", year);
				params.put("month", month);
				params.put("operateEmployeeId", ClientUtil.getEmployeeId());
				params.put("operateTime", new Date());
				final int rowNumModified = event.getRowNum();
				DBDataSource.callOperation("ST_HolidayManage", "saveOrUpdate", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						}else {
							DBDataSource.copyRecord(dsResponse.getData()[0], resultGrid.getRecord(rowNumModified));
							resultGrid.redraw();
						}
					}
				});
			}
		});

		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				DBDataSource.callOperation("ST_HolidayManage", "delete", selected.toMap(), new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							int indexNum = resultGrid.getRowNum(selected);
							resultGrid.removeData(selected);
							resultGrid.selectSingleRecord(indexNum);
						}
					}
				});
			}
		});

		commonQuery();
	}


	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSHolidayManageOfShift.getInstance();
	}


}

