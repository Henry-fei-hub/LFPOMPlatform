package com.pomplatform.client.contractppspcccfscsiiicpor.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.contractppspcccfscsiiicpor.datasource.DSSprojectpcor;
import com.pomplatform.client.contractppspcccfscsiiicpor.form.SprojectpcorSearchForm;
import com.pomplatform.client.contractppspcccfscsiiicpor.form.SprojectpcorViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class SprojectpcorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private Record __record;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			SprojectpcorPanel cm = new SprojectpcorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Sprojectpcor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		resultGrid.setSelectionType(SelectionStyle.SIMPLE);
		IButton doLinkBtn = new IButton("关联");
		controlLayout.addMember(doLinkBtn);
		doLinkBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					SC.confirm("确认关联", new BooleanCallback() {
						
						@Override
						public void execute(Boolean value) {
							if(value){
								int contractId = getRecord().getAttributeAsInt("contractId");
								ListGridRecord [] childRecords = resultGrid.getSelectedRecords();
								String ids = "";
								int index = 0;
								for (ListGridRecord listGridRecord : childRecords) {
									if(index != 0){
										ids += ",";
									}
									ids += listGridRecord.getAttribute("projectId");
									index ++;
								}
								Map<String, Object> params = new HashMap<>();
								params.put("opt_type", "doLinkContract");
								params.put("ids", ids);
								params.put("contractId", contractId);
								DBDataSource.callOperation("EP_CustomSprojectpcorProcess", params, new DSCallback() {
									
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										
										if(dsResponse.getStatus() > 0){
											getFatherWindow().destroy();
											DataEditEvent dee = new DataEditEvent();
											fireEvent(dee);
										} 
									}
								});
							}
						}
					});
				}else{
					SC.say("请选择需要关联的订单");
				}
				
			}
		});

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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("Sprojectpcor");
				detail.setWidth100();
				detail.setHeight100();
				SprojectpcorViewer detailForm = new SprojectpcorViewer();
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
		criteria.put("contractId", 0);
		criteria.put("projectFlag", 1);
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new SprojectpcorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSprojectpcor.getInstance();
	}

	private Window fatherWindow;

	public Window getFatherWindow() {
		return fatherWindow;
	}

	public void setFatherWindow(Window fatherWindow) {
		this.fatherWindow = fatherWindow;
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

	public Record getRecord() {
		return __record;
	}

	public void setRecord(Record record) {
		this.__record = record;
	}

}
