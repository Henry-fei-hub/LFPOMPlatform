package com.pomplatform.client.budgetmanagement.panel;

import java.util.ArrayList;
import java.util.List;

import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;  
import com.smartgwt.client.data.ResultSet;  
import com.smartgwt.client.data.events.DataChangedEvent;  
import com.smartgwt.client.data.events.DataChangedHandler;  
import com.smartgwt.client.types.ListGridComponent;  
import com.smartgwt.client.types.ListGridEditEvent;  
import com.smartgwt.client.widgets.Canvas;  
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;  
import com.smartgwt.client.widgets.events.ClickHandler;  
import com.smartgwt.client.widgets.grid.ListGrid;  
import com.smartgwt.client.widgets.grid.ListGridField;  
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;  
import com.smartgwt.client.widgets.toolbar.ToolStrip;  
import com.smartgwt.client.widgets.toolbar.ToolStripButton;  

public class TestPanel  extends HLayout implements HasHandlers {
	 private ListGrid countryGrid;  
	    private Label totalsLabel; 


	public void initComponents() {
		 ToolStrip gridEditControls = new ToolStrip();  
	        gridEditControls.setWidth100();  
	        gridEditControls.setHeight(24);  
	          
	        totalsLabel = new Label();  
	        totalsLabel.setPadding(5);  
	          
	        LayoutSpacer spacer = new LayoutSpacer();  
	        spacer.setWidth("*");  
	          
	        ToolStripButton editButton = new ToolStripButton();  
	        editButton.setIcon("[SKIN]/actions/edit.png");  
	        editButton.setPrompt("Edit selected record");  
	        editButton.addClickHandler(new ClickHandler() {  
	              
	            @Override  
	            public void onClick(ClickEvent event) {  
	                ListGridRecord record = countryGrid.getSelectedRecord();  
	                if (record == null) return;  
	                countryGrid.startEditing(countryGrid.getDataAsRecordList().indexOf(record), 0, false);  
	                  
	            }  
	        });  
	          
	        ToolStripButton removeButton = new ToolStripButton();  
	        removeButton.setIcon("[SKIN]/actions/remove.png");  
	        removeButton.setPrompt("Remove selected record");  
	        removeButton.addClickHandler(new ClickHandler() {  
	              
	            @Override  
	            public void onClick(ClickEvent event) {  
	                countryGrid.removeSelectedData();  
	                  
	            }  
	        });  
	          
	        gridEditControls.setMembers(totalsLabel, spacer, editButton, removeButton);  
	          
	        ListGridField countryCode = new ListGridField("countryCode");  
	        ListGridField countryName = new ListGridField("countryName");  
	        ListGridField capital = new ListGridField("capital");  
	        ListGridField continent = new ListGridField("continent");  
	  
	        countryGrid = new ListGrid();  
	        countryGrid.setFields(new ListGridField[] { countryCode, countryName, capital, continent });  
	        countryGrid.setWidth(500);  
	        countryGrid.setHeight(425);  
	        countryGrid.setDataSource(CountryXmlDS.getInstance());  
	        countryGrid.setAutoFetchData(true);  
	        countryGrid.setShowFilterEditor(true);  
	        countryGrid.setCanEdit(true);  
	        countryGrid.setEditEvent(ListGridEditEvent.NONE);  
	          
	        ResultSet dataProperties = new ResultSet();  
	        dataProperties.addDataChangedHandler(new DataChangedHandler() {  
	              
	            @Override  
	            public void onDataChanged(DataChangedEvent event) {  
	                RecordList data = countryGrid.getDataAsRecordList();  
	                  
	                if (data != null && data instanceof ResultSet && ((ResultSet)data).lengthIsKnown() && data.getLength() > 0) {  
	                    totalsLabel.setContents(data.getLength() + " Records");  
	                } else {  
	                    totalsLabel.setContents(" ");  
	                }  
	            }  
	        });  
	        countryGrid.setDataProperties(dataProperties);  
	          
	        countryGrid.setGridComponents(new Object[] {  
	                ListGridComponent.HEADER,   
	                ListGridComponent.FILTER_EDITOR,   
	                ListGridComponent.BODY,   
	                gridEditControls  
	        });  
	          
	        countryGrid.draw();  
		
	        addMember(countryGrid);
	}

	public void loadData() {
		


	}
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}


	private  Window  parentWindow;
	
	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}
	private Record record;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	/*private int   budgetManagementId;
	public void setBudgetManagementId(int budgetManagementId) {
		this.budgetManagementId=budgetManagementId;
	}

	public int  getBudgetManagementId() {
		return this.budgetManagementId;
	}	
	 */
}
