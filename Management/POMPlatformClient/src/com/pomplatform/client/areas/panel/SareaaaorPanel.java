package com.pomplatform.client.areas.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.areas.datasource.DSSareaaaor;
import com.pomplatform.client.areas.datasource.DSSareaaaorChild;
import com.pomplatform.client.areas.form.SareaaaorSearchForm;
import com.pomplatform.client.areas.form.SareaaaorViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.EditorExitEvent;
import com.smartgwt.client.widgets.grid.events.EditorExitHandler;

public class SareaaaorPanel extends AbstractExpansionRelatedPage
{
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SareaaaorPanel cm = new SareaaaorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Sareaaaor";
		}

	}

	@Override
	public void initComponents() {
		resultGrid.setCanEdit(true);
		resultGrid.setShowRowNumbers(true);
		resultGrid.setAutoFitFieldWidths(false);
		ListGridField[] fields = new ListGridField[3];
		int idx = 0;
		fields[idx] = new ListGridField("areaName");
		fields[idx].setWidth(300);
		idx++;
		fields[idx] = new ListGridField("allName");
		fields[idx].setWidth(300);
		idx++;
		fields[idx] = new ListGridField("areaLevel");
		resultGrid.setFields(fields);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton addButton = new IButton("新增区域");
		addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				PopupWindow popupWindow = new PopupWindow();
				popupWindow.setWidth("50%");
				popupWindow.setHeight("50%");
				popupWindow.setTitle("添加区域");
				AddArealPanel addArealPanel = new AddArealPanel();
				addArealPanel.initComponents();
				addArealPanel.setParentWindow(popupWindow);
				popupWindow.addMember(addArealPanel);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		controlLayout.addMember(addButton);

		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
	
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@SuppressWarnings("unchecked")
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map<String,Object> map = resultGrid.getRecord(event.getRowNum()).toMap();
				DBDataSource.callOperation("ST_Area", "saveOrUpdate", map, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
						}
					}
				});
			}
		});
		commonQuery();
	}
	
	@Override
	public void setChildGridOption(ListGrid resultChildGrid) {
		resultChildGrid.setCanRemoveRecords(false);
		resultChildGrid.setAutoFitFieldWidths(false);
		resultChildGrid.setCanEdit(true);
		resultChildGrid.addEditorExitHandler(new EditorExitHandler() {
			@SuppressWarnings("unchecked")
			@Override
			public void onEditorExit(EditorExitEvent event) {
				int colNum = event.getColNum();
				Map<String,Object> map = event.getRecord().toMap();
				if(colNum == 1){
					map.put("allName", event.getNewValue());
				}else if(colNum == 2){
					map.put("areaLevel", event.getNewValue());
				}
				DBDataSource.callOperation("ST_Area", "saveOrUpdate", map, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
						}
					}
				});
			}
		});
	}
	
	@Override
	public boolean doCustomCommonQuery() {
		return true;
	}
	
	@Override
	public void customCommonQuery(ListGridRecord record,ListGrid childGrid) {
		int parentId = BaseHelpUtils.getIntValue(record.getAttribute("areaId"));
		Map<String,Object> map = new HashMap<>();
		map.put("parentId", parentId);
		final LoadingWindow loading = new LoadingWindow();
		DBDataSource.callOperation("EP_GetAreaChildData", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				loading.destroy();
				if (dsResponse.getStatus() >= 0) {
					childGrid.setData(dsResponse.getData());
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
				detail.setTitle("Sareaaaor"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				SareaaaorViewer detailForm = new SareaaaorViewer();
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by area_id");
		criteria.put("parentId", 0);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new SareaaaorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSareaaaor.getInstance();
	}
	
	@Override
	public DataSource getChildDataSource() {
		return DSSareaaaorChild.getInstance();
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}


}

