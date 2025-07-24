package com.pomplatform.client.activitympcor.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.activitympcor.datasource.DSSactivityMpcor;
import com.pomplatform.client.activitympcor.form.NewActivityMeetForm;
import com.pomplatform.client.activitympcor.form.SactivityMpcorSearchForm;
import com.pomplatform.client.activitympcor.form.SactivityMpcorViewer;
import com.pomplatform.client.activitympcor.form.UpdateActivityMeetPanel;
import com.pomplatform.client.preprojects.panel.UpdatePreProjectInformationForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class SactivityMpcorPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SactivityMpcorPanel cm = new SactivityMpcorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SactivityMpcor";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
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
//		IButton viewButton = new IButton("查看详细");
//		viewButton.addClickHandler(new ClickHandler(){
//			@Override
//			public void onClick(ClickEvent event) {
//				showDetail();
//			}
//		});
//		controlLayout.addMember(viewButton);
		
		IButton addButton = new IButton("新增");
		addButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}

					@Override
					public void onSuccess() {
						NewActivityMeetForm detailForm = new NewActivityMeetForm();
						detailForm.setTitle("新增差旅&会议");
						detailForm.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								RecordList list = resultGrid.getDataAsRecordList();
								RecordList newList = new RecordList();
								newList.addList(list.getRange(0, list.getLength()));
								newList.add(event.getData());
								resultGrid.setData(newList);
								resultGrid.selectSingleRecord(newList.getLength() - 1);
								commonQuery();
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth("40%");
						detailForm.setHeight("88%");
						detailForm.centerInPage();
						detailForm.show();
					}
				});
			}
		});
		controlLayout.addMember(addButton);
		
		IButton updateButton = new IButton("修改");
		updateButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}

					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择一条数据进行操作");
							return;
						}
						Record selected = resultGrid.getSelectedRecord();
						UpdateActivityMeetPanel detailForm = new UpdateActivityMeetPanel();
						detailForm.setTitle("修改差旅&会议信息");
						detailForm.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(selected);
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth("40%");
						detailForm.setHeight("88%");
						detailForm.centerInPage();
						detailForm.show();
					}
				});
			}
		});
		controlLayout.addMember(updateButton);
		
		IButton deleteButton = new IButton("删除");
		deleteButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据进行操作");
				}
				SC.ask("提示","您确认要删除当前会议信息吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value){
							final ListGridRecord selected = resultGrid.getSelectedRecord();
							DBDataSource.callOperation("ST_Activity", "delete", selected.toMap(), new DSCallback() {
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
					}
				});
			}
		});
		controlLayout.addMember(deleteButton);
		
		IButton exportButton = new IButton("导出");
		controlLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_ExportTravelAndMeetingData", condition);
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("差旅&会议"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				SactivityMpcorViewer detailForm = new SactivityMpcorViewer();
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
		criteria.put("addtionalCondition", "order by activitie_id");
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.ACTIVITY_MEET_ALL_DATE)) {
			criteria.put("operateEmployeeId", ClientUtil.getEmployeeId());
		}
		/*List<Map> keyvalues = new ArrayList<>();
		if(BaseHelpUtils.isNullOrEmpty(criteria.get("departmentId"))){
			Map<String, String> kv = new HashMap<>();
        	kv.put("key", "e.department_id in (select child_id from department_ids where department_id = ? )");
        	kv.put("value", "1 = 1");
        	keyvalues.add(kv);
		}
		if(!BaseHelpUtils.isNullOrEmpty(keyvalues) && keyvalues.size() > 0){
        	criteria.put("keyValues", keyvalues);
        }*/
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new SactivityMpcorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSactivityMpcor.getInstance();
	}
	
/* @Override
 * 设置Search页面高度
public int getSearchFormHeight() {
	     
	     
	     
	
	return 180;
}
*/
}

