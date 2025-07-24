package com.pomplatform.client.contractsrecords.panel;

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
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.contractsrecords.datasource.DSContractsRecords;
import com.pomplatform.client.contractsrecords.form.ContractsRecordsSearchForm;
import com.pomplatform.client.contractsrecords.form.ContractsRecordsViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class ContractsRecordsPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ContractsRecordsPanel cm = new ContractsRecordsPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ContractsRecords";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(true);
	}

	@Override
	public void initComponents() {
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
				showDetail();
			}
		});
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton recordButton = new IButton("新增合同跟踪记录");
		controlLayout.addMember(recordButton);
		recordButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				
				PopupWindow popupWindow=new PopupWindow();
				ContractsRecordsDetailForm detailForm = new ContractsRecordsDetailForm();
				detailForm.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				detailForm.initCompnts();
				detailForm.setPop(popupWindow);
				popupWindow.setTitle("新增合同跟踪记录");
				popupWindow.setWidth("80%");
				popupWindow.setHeight("80%");
				popupWindow.addItem(detailForm);
				popupWindow.centerInPage();
				popupWindow.show();
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
					}
				});
				
			}
		});
		
		
		IButton EditrecordButton = new IButton("继续跟踪");
		controlLayout.addMember(EditrecordButton);
		EditrecordButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				PopupWindow popupWindow=new PopupWindow();
				EditContractsRecordsDetailForm detailForm = new EditContractsRecordsDetailForm();
				detailForm.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				Record record=resultGrid.getSelectedRecord();
				detailForm.setRecord(record);
				detailForm.initCompnts();
				detailForm.setPop(popupWindow);
				popupWindow.setTitle("继续跟踪");
				popupWindow.setWidth("80%");
				popupWindow.setHeight("80%");
				popupWindow.addItem(detailForm);
				popupWindow.centerInPage();
				popupWindow.show();
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
					}
				});
				
			}
		});
		
		
		IButton DataButton = new IButton("导出跟踪报表");
		DataButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_ExportContractsRecords", condition);

			}
		});
		controlLayout.addMember(DataButton);
		
		
		
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("合同跟踪记录"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ContractsRecordsViewer detailForm = new ContractsRecordsViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
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
		criteria.put("addtionalCondition", "order by contracts_records_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ContractsRecordsSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSContractsRecords.getInstance();
	}


}

