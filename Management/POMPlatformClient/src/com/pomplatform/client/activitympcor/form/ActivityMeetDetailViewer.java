package com.pomplatform.client.activitympcor.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Logger;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.activitympcor.datasource.DSSactivityMpcor;
import com.pomplatform.client.preprojectrecord.panel.UpdatePrePrejectRecordPanel;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
public class ActivityMeetDetailViewer extends HLayout implements HasHandlers{
	private static Logger __logger = Logger.getLogger("");
	private final DelicacyListGrid ActivityMeetGrid = new DelicacyListGrid(true);
	private HLayout mainLayout;
	@SuppressWarnings("deprecation")
	public void initComponents() {
		mainLayout = new HLayout(10);
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		ActivityMeetGrid.setDataSource(DSSactivityMpcor.getInstance());
		ActivityMeetGrid.setData(Records);
		ActivityMeetGrid.setCanEdit(false);
		ActivityMeetGrid.setShowRowNumbers(true);
		ActivityMeetGrid.setCanRemoveRecords(false);
		ActivityMeetGrid.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if(!ActivityMeetGrid.anySelected()){
					SC.say("请选择一条数据进行操作");
					return;
				}
				final ListGridRecord selected = ActivityMeetGrid.getSelectedRecord();
				DetailsActivityMeetPanel detailForm = new DetailsActivityMeetPanel();
				detailForm.setTitle("会议详情");
				detailForm.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						DBDataSource.copyRecord(event.getData(), selected);
						ActivityMeetGrid.redraw();
					}
				});
				detailForm.setRecord(selected);
				detailForm.initComponents();
				detailForm.setWidth("40%");
				detailForm.setHeight("80%");
				detailForm.startEdit();
				detailForm.centerInPage();
				detailForm.show();
				detailForm.centerInPage();
				detailForm.show();				
			}
		});
		//mainLayout.addMember(ActivityMeetGrid);
		addMember(ActivityMeetGrid);
	}
	private Record[]  Records;
	public Record[] getRecords() {
		return Records;
	}
	public void setRecords(Record[] records) {
		Records = records;
	}
}

