package com.pomplatform.client.leavetype.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.leavetype.datasource.DSLinkOfLeaveTypeAndProvince;
import com.pomplatform.client.leavetype.form.LinkOfLeaveTypeAndProvinceViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class LinkOfLeaveTypeAndProvincePanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			LinkOfLeaveTypeAndProvincePanel cm = new LinkOfLeaveTypeAndProvincePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "LinkOfLeaveTypeAndProvince";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needViewPage = false;
	}

	@Override
	public void initComponents() {
		ListGridField[] fields = new ListGridField[5];
		int idx = 0;
		fields[idx] = new ListGridField("leaveTypeId");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("provinceId");
		ComboBoxItem provinceItem = new ComboBoxItem();
		provinceItem.setValueMap(KeyValueManager.getValueMap("provinces"));
		provinceItem.setChangeOnKeypress(false);
		provinceItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		fields[idx].setEditorProperties(provinceItem);
		idx++;
		fields[idx] = new ListGridField("days");
		idx++;
		fields[idx] = new ListGridField("remark");
		idx++;
		fields[idx] = new ListGridField("isEnable");
		resultGrid.setFields(fields);
		resultGrid.setCanEdit(true);
		
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();
				final int rowNumModified = event.getRowNum();
				DBDataSource.callOperation("ST_LeaveTypeLinkProvince", "saveOrUpdate", params, new DSCallback() {
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
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
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
		
		IButton addButton = new IButton("新建");
		addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] records = resultGrid.getRecords();
				int length = records.length;
				ListGridRecord[] newRecords = new ListGridRecord[length+1];
				for(int i = 0; i < length; i++){
					newRecords[i] = records[i];
				}
				ListGridRecord record = new ListGridRecord();
				record.setAttribute("leaveTypeId", leaveTypeId);
				record.setAttribute("isEnable", true);
				newRecords[length] = record;
				resultGrid.setRecords(newRecords);
				resultGrid.redraw();
				resultGrid.startEditing(length);
			}
		});
		controlLayout.addMember(addButton);
		
		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				if(null != selected.getAttribute("leaveTypeId")){
					DBDataSource.callOperation("ST_LeaveTypeLinkProvince", "delete", selected.toMap(), new DSCallback() {
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
				} else {
					resultGrid.removeData(selected);
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
				detail.setTitle("请假类型和省份关联"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				LinkOfLeaveTypeAndProvinceViewer detailForm = new LinkOfLeaveTypeAndProvinceViewer();
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
		criteria.put("leaveTypeId", leaveTypeId);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
//		return new LinkOfLeaveTypeAndProvinceSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSLinkOfLeaveTypeAndProvince.getInstance();
	}

	private int leaveTypeId;

	public int getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
	
}

