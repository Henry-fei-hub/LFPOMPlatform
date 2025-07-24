package com.pomplatform.client.workinghour.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.workinghour.datasource.DSWorkingHourManage;
import com.pomplatform.client.workinghour.form.NewWorkingHourManageForm;
import com.pomplatform.client.workinghour.form.UpdateWorkingHourManageForm;
import com.pomplatform.client.workinghour.form.WorkingHourManageSearchForm;
import com.pomplatform.client.workinghour.form.WorkingHourManageViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class WorkingHourManagePanel extends AbstractSearchPanel
{


	private String plateIds;
	private String[] plateIdArr;
	
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			WorkingHourManagePanel cm = new WorkingHourManagePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "WorkingHourManage";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid = new DelicacyListGrid(){
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				if (BaseHelpUtils.getBoolean(record.getAttribute("isLock"))) {  //已加锁，标灰色
					return "color:#6E6E6E;";  
				} else {  
					return super.getCellCSSText(record, rowNum, colNum);  
				}  
			}
		};
		resultGrid.setDataSource(getDataSource());
		resultGrid.setShowRowNumbers(true);
	}

	@Override
	public void initComponents() {
		plateIds = PomPlatformClientUtil.getRolePlateId();
		plateIdArr = plateIds.split(",");
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
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		
		IButton operation2Button = new IButton("新建");
		controlLayout.addMember(operation2Button);
		operation2Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				NewProcessWindow window = new NewProcessWindow();
				window.setTitle("我的工时");
				window.setWidth("80%");
				window.setHeight("80%");
				Map<String, String> processIdMap = PomPlatformClientUtil
						.getUserProcessId(PomPlatformClientUtil.PARENT_PROCESS_TYPE_4);
				Integer value = ClientUtil.checkAndGetIntValue(processIdMap.get("Working_hours"));
				window.setProcessId(value);
				window.setLayoutMode(0);
				window.initComponents();
				window.show();
			}
		});
		
		IButton operation3Button = PermissionControl.createPermissionButton("修改",ERPPermissionStatic.MY_WORK_HOUR_UPDATE);
		controlLayout.addMember(operation3Button);
		operation3Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据修改"); return;}
						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
						UpdateWorkingHourManageForm detailForm = new UpdateWorkingHourManageForm();
						detailForm.setTitle("修改");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								DBDataSource.copyRecord(event.getData(), selected1);
								resultGrid.redraw();
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(selected1);
						detailForm.setCurrentPage(getCurrentPage());
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth("60%");
						detailForm.setHeight("70%");
						detailForm.centerInPage();
						detailForm.show();
						setCurrentPage(detailForm.getCurrentPage());
					}
				});
			}
		});
		
		IButton removeButton = new IButton("删除");
//		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				if(BaseHelpUtils.getBoolean(selected.getAttribute("isLock"))) {
					SC.say("该记录已锁定，无法删除");
					return;
				}
				SC.confirm("确定要删除这条数据吗？", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(value) {
							DBDataSource.callOperation("ST_WorkingHour", "delete", selected.toMap(), new DSCallback() {
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

		IButton downloadButton = new IButton("导出");
		controlLayout.addMember(downloadButton);
		downloadButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_WorkingHourManage", condition);
			}
		});
		
		IButton lockButton = PermissionControl.createPermissionButton("加锁", ERPPermissionStatic.MY_WORK_HOUR_LOCK_BUTTON);
		controlLayout.addMember(lockButton);
		lockButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				lockOrUnlockWorkingHour(true);
			}
		});
		
		
		IButton unlockButton = PermissionControl.createPermissionButton("解锁", ERPPermissionStatic.MY_WORK_HOUR_UNLOCK_BUTTON);
		controlLayout.addMember(unlockButton);
		unlockButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				lockOrUnlockWorkingHour(false);
			}
		});
		
		commonQuery();
	}

	public void lockOrUnlockWorkingHour(boolean isLock) {
		if(!resultGrid.anySelected()) {
			if(isLock) {
				SC.say("请选择需要加锁的数据");
			}else {
				SC.say("请选择需要解锁的数据");
			}
			return;
		}
		Record[] records = resultGrid.getSelectedRecords();
		StringBuilder sb = new StringBuilder();
		for(Record r : records) {
			if(sb.length() > 0) {
				sb.append(",");
			}
			sb.append(r.getAttribute("workingHourId"));
		}
		Map<String, Object> params = new HashMap<>();
		params.put("optType", "lockOrUnlockWorkingHour");
		params.put("ids", sb.toString());
		params.put("isLock", isLock);
		DBDataSource.callOperation("EP_WorkingHourProcessor", "find", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					if(isLock) {
						SC.say("加锁成功");
					}else {
						SC.say("解锁成功");
					}
					commonQuery();
				}else {
					ClientUtil.displayErrorMessage(dsResponse);
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
				detail.setTitle("我的工时"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				WorkingHourManageViewer detailForm = new WorkingHourManageViewer();
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
		List<Map> keyvalues = new ArrayList<>();
		SC.debugger();
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.MY_WORK_HOUR_VIEW_ALL_DATA)) {
		} else if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.MY_WORK_HOUR_VIEW_ALL_DATA)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.MY_WORK_HOUR_VIEW_PLATE_DATA)) {
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "ORDER BY create_time desc");
			kv.put("value", "AND plate_id  in (select pr.plate_id from plate_records pr where pr.plate_name in(SELECT d.department_name from departments  d where d.department_id in ((select dd.department_id from employee_roles dd where  dd.role_id =47  and dd.employee_id = "+ClientUtil.getUserId()+" )))) ORDER BY create_time desc");
			keyvalues.add(kv);
		} else {
			criteria.put("employeeId", ClientUtil.getUserId());
		}
		criteria.put("addtionalCondition", "order by employee_id");
		criteria.put("keyValues",keyvalues);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new WorkingHourManageSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSWorkingHourManage.getInstance();
	}


}

