package com.pomplatform.client.budgetmanagementworkflow.form;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

public class BudgetUplodaPanel  extends VLayout implements HasHandlers{
	private Window parentWindow;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
	public void  initComponents(){
		HLayout mainLayout = new HLayout(10);
		mainLayout.setWidth100();
		mainLayout.setHeight100();

		TabSet topTabSet = new TabSet();
		topTabSet.setTabBarPosition(Side.TOP);
		Tab tTab1 = new Tab("上传附件", "pieces/16/star_red.png");
		BudgetUplodaEditPanel panel = new BudgetUplodaEditPanel();
		
		Tab tTab2 = new Tab("附件详情", "pieces/16/star_yellow.png");
		BudgetUplodaInfoPanel infoPanel = new BudgetUplodaInfoPanel();
		
		infoPanel.setPanel(panel);
		infoPanel.addDataEditedHandler(new DataEditedHandler() {
			@Override
			public void onDataEdited(DataEditEvent event) {
				Record delrecord=event.getData();
				if(delrecord!=null) {
					setUpRecord(delrecord);
				}
			}
		});
		infoPanel.initComponents();
		if(getUpRecord()!=null) {
			infoPanel.setRecord(getUpRecord());
			infoPanel.lodaDate();
		}
		tTab2.setPane(infoPanel);

		panel.addDataEditedHandler(new DataEditedHandler(){
			@Override
			public void onDataEdited(DataEditEvent event) {
				Record record=event.getData();
				if(record!=null) {
					DataEditEvent dee = new DataEditEvent();
					dee.setData(record);
					fireEvent(dee);
					infoPanel.setRecord(record);
					infoPanel.lodaDate();
				}
			}
		});
		if(getUpRecord()!=null){
			panel.setDelrecord(getUpRecord());
		}
		panel.initComponents();
		tTab1.setPane(panel);


		topTabSet.addTab(tTab1);
		topTabSet.addTab(tTab2);

		mainLayout.addMember(topTabSet);
		addMember(mainLayout);

	}



	private Record UpRecord;


	public Record getUpRecord() {
		return UpRecord;
	}

	public void setUpRecord(Record upRecord) {
		UpRecord = upRecord;
	}


	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

}
