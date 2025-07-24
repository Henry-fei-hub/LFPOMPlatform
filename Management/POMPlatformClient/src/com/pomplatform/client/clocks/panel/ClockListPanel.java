package com.pomplatform.client.clocks.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.clocks.datasource.DSClockList;
import com.pomplatform.client.clocks.form.ClockListSearchForm;
import com.pomplatform.client.clocks.form.ClockListViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.menu.IMenuButton;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.ClickHandler;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;

public class ClockListPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private VLayout allLayout;
	private HLayout topLayout;
	private HLayout contentLayout;
	private VLayout contentLeftLayout;
	private HLayout leftButtonLayout;
	private HLayout leftGridLayout;
	
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ClockListPanel cm = new ClockListPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ClockList";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needControl = false;
		resultGrid.setShowRowNumbers(true);
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
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
				detail.setTitle("clockList"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ClockListViewer detailForm = new ClockListViewer();
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
		criteria.put("addtionalCondition", "order by clock_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ClockListSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSClockList.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}
	
	
	@Override
	public Canvas getViewPanel() {
		init();
        searchForm = generateSearchForm();
        allLayout = new VLayout(10);
        allLayout.setWidth100();
        allLayout.setHeight100();
        allLayout.setBackgroundColor("#e2e2e2");

        if (searchForm != null) {
        	ClientUtil.searchFormProcessAccordingToDevice(searchForm);
            if (getSearchFormHeight() > 0) {
                searchForm.setHeight(getSearchFormHeight());
            }
            topLayout = new HLayout(10);
    		topLayout.setWidth100();
    		topLayout.setHeight("5%");
    		topLayout.setLayoutTopMargin(10);
    		topLayout.setLayoutRightMargin(10);
    		topLayout.setLayoutLeftMargin(10);
    		topLayout.addMember(searchForm);
    		
    		VLayout buttonLayout = new VLayout(5);
            searchButton = new IButton("搜索");
            searchButton.setIcon("[SKIN]/actions/search.png");

            IButton resetButton = new IButton("重置");
            resetButton.setIcon("[SKIN]/actions/redo.png");

            buttonLayout.addMember(searchButton);
            buttonLayout.addMember(resetButton);
            topLayout.addMember(buttonLayout);
            
            searchButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    currentPage = 1;
                    commonQuery();
                }
            });

            resetButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    searchForm.editNewRecord();
                }
            });
            allLayout.addMember(topLayout);
        }
        contentLayout = new HLayout(10);
		contentLayout.setWidth100();
		contentLayout.setHeight("95%");
		contentLayout.setLayoutRightMargin(10);
		contentLayout.setLayoutLeftMargin(10);
		allLayout.addMember(contentLayout);
		
		contentLeftLayout = new VLayout(10);
		contentLeftLayout.setWidth100();
		contentLeftLayout.setHeight100();
		contentLayout.addMember(contentLeftLayout);
		
		leftButtonLayout = new HLayout(10);
		leftButtonLayout.setHeight("3%");
		leftButtonLayout.setWidth100();
		
		IButton clockRecevieCmdButton = new IButton("服务器下发命令");
		clockRecevieCmdButton.setWidth("130");
		clockRecevieCmdButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ClockRecevieCmdsPanel panel = new ClockRecevieCmdsPanel();
				PopupWindow window = new PopupWindow();
				window.addItem(panel);
				window.setTitle("服务器下发命令");
				window.setWidth100();
				window.setHeight100();
				window.centerInPage();
				window.show();
			}
		});
		Menu mainMenu = new Menu();
		
		MenuItem clockReboot = new MenuItem("设备重启");
		MenuItem checkClockInfo = new MenuItem("检查设备信息");
		MenuItem checkAndSendNewData = new MenuItem("检查并传送新数据");
		MenuItem checkDataUpdate = new MenuItem("传送设备上的考勤数据");
		MenuItem clearData = new MenuItem("清除设备上所有数据");
		MenuItem clearLog = new MenuItem("清除设备上的考勤记录");
		MenuItem clearPhoto = new MenuItem("清除设备上的照片");
		mainMenu.setItems(clockReboot,checkClockInfo,checkAndSendNewData,checkDataUpdate,clearData,clearLog,clearPhoto);
		
		IMenuButton manageAndMaintain = new IMenuButton("管理及维护",mainMenu);
		manageAndMaintain.setHeight(30);
		//管理及维护的下拉按钮点击事件*****************
		checkDataUpdate.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(MenuItemClickEvent event) {
				//获取选取的设备
				Record record = resultGrid.getSelectedRecord();
				if(BaseHelpUtils.isNullOrEmpty(record)){//说明未选择设备
					SC.say("提示","请选择一条记录");
					return;
				}
				String sn = BaseHelpUtils.getString(record.getAttribute("sn"));
				if(BaseHelpUtils.isNullOrEmpty(sn)){
					SC.say("提示","设备序列号不可为空");
					return;
				}
				Map<String,Object> param = new HashMap<>();
				//获取操作人
				int operateEmployeeId = ClientUtil.getEmployeeId();
				param.put("optType", "checkDataUpdate");
				param.put("sn",sn);
				param.put("operateEmployeeId",operateEmployeeId);
				DBDataSource.callOperation("EP_ClockMsgProcess", param,new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							SC.say("提示","操作成功");
							commonQuery();
						}
					}
				});
			}
		});
		
		clearData.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(MenuItemClickEvent event) {
				//获取选取的设备
				Record record = resultGrid.getSelectedRecord();
				if(BaseHelpUtils.isNullOrEmpty(record)){//说明未选择设备
					SC.say("提示","请选择一条记录");
					return;
				}
				String sn = BaseHelpUtils.getString(record.getAttribute("sn"));
				if(BaseHelpUtils.isNullOrEmpty(sn)){
					SC.say("提示","设备序列号不可为空");
					return;
				}
				Map<String,Object> param = new HashMap<>();
				int operateEmployeeId = ClientUtil.getEmployeeId();
				param.put("optType", "clearData");
				param.put("sn",sn);
				param.put("operateEmployeeId",operateEmployeeId);
				DBDataSource.callOperation("EP_ClockMsgProcess", param,new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							SC.say("提示","操作成功");
							commonQuery();
						}
					}
				});
			}
		});
		
		checkClockInfo.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(MenuItemClickEvent event) {
				//获取选取的设备
				Record record = resultGrid.getSelectedRecord();
				if(BaseHelpUtils.isNullOrEmpty(record)){//说明未选择设备
					SC.say("提示","请选择一条记录");
					return;
				}
				String sn = BaseHelpUtils.getString(record.getAttribute("sn"));
				if(BaseHelpUtils.isNullOrEmpty(sn)){
					SC.say("提示","设备序列号不可为空");
					return;
				}
				Map<String,Object> param = new HashMap<>();
				param.put("optType", "checkClockInfo");
				param.put("sn",sn);
				int operateEmployeeId = ClientUtil.getEmployeeId();
				param.put("operateEmployeeId",operateEmployeeId);
				DBDataSource.callOperation("EP_ClockMsgProcess", param,new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							SC.say("提示","操作成功");
							commonQuery();
						}
					}
				});
			}
		});
		
		clockReboot.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(MenuItemClickEvent event) {
				//获取选取的设备
				Record record = resultGrid.getSelectedRecord();
				if(BaseHelpUtils.isNullOrEmpty(record)){//说明未选择设备
					SC.say("提示","请选择一条记录");
					return;
				}
				String sn = BaseHelpUtils.getString(record.getAttribute("sn"));
				if(BaseHelpUtils.isNullOrEmpty(sn)){
					SC.say("提示","设备序列号不可为空");
					return;
				}
				Map<String,Object> param = new HashMap<>();
				param.put("optType", "clockReboot");
				param.put("sn",sn);
				int operateEmployeeId = ClientUtil.getEmployeeId();
				param.put("operateEmployeeId",operateEmployeeId);
				DBDataSource.callOperation("EP_ClockMsgProcess", param,new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							SC.say("提示","操作成功");
							commonQuery();
						}
					}
				});
			}
		});
		
		checkAndSendNewData.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(MenuItemClickEvent event) {
				//获取选取的设备
				Record record = resultGrid.getSelectedRecord();
				if(BaseHelpUtils.isNullOrEmpty(record)){//说明未选择设备
					SC.say("提示","请选择一条记录");
					return;
				}
				String sn = BaseHelpUtils.getString(record.getAttribute("sn"));
				if(BaseHelpUtils.isNullOrEmpty(sn)){
					SC.say("提示","设备序列号不可为空");
					return;
				}
				Map<String,Object> param = new HashMap<>();
				param.put("optType", "checkAndSendNewData");
				param.put("sn",sn);
				int operateEmployeeId = ClientUtil.getEmployeeId();
				param.put("operateEmployeeId",operateEmployeeId);
				DBDataSource.callOperation("EP_ClockMsgProcess", param,new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							SC.say("提示","操作成功");
							commonQuery();
						}
					}
				});
			}
		});
		
		clearLog.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(MenuItemClickEvent event) {
				//获取选取的设备
				Record record = resultGrid.getSelectedRecord();
				if(BaseHelpUtils.isNullOrEmpty(record)){//说明未选择设备
					SC.say("提示","请选择一条记录");
					return;
				}
				String sn = BaseHelpUtils.getString(record.getAttribute("sn"));
				if(BaseHelpUtils.isNullOrEmpty(sn)){
					SC.say("提示","设备序列号不可为空");
					return;
				}
				Map<String,Object> param = new HashMap<>();
				param.put("optType", "clearLog");
				param.put("sn",sn);
				int operateEmployeeId = ClientUtil.getEmployeeId();
				param.put("operateEmployeeId",operateEmployeeId);
				DBDataSource.callOperation("EP_ClockMsgProcess", param,new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							SC.say("提示","操作成功");
							commonQuery();
						}
					}
				});
			}
		});
		
		clearPhoto.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(MenuItemClickEvent event) {
				//获取选取的设备
				Record record = resultGrid.getSelectedRecord();
				if(BaseHelpUtils.isNullOrEmpty(record)){//说明未选择设备
					SC.say("提示","请选择一条记录");
					return;
				}
				String sn = BaseHelpUtils.getString(record.getAttribute("sn"));
				if(BaseHelpUtils.isNullOrEmpty(sn)){
					SC.say("提示","设备序列号不可为空");
					return;
				}
				Map<String,Object> param = new HashMap<>();
				param.put("optType", "clearPhoto");
				param.put("sn",sn);
				int operateEmployeeId = ClientUtil.getEmployeeId();
				param.put("operateEmployeeId",operateEmployeeId);
				DBDataSource.callOperation("EP_ClockMsgProcess", param,new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							SC.say("提示","操作成功");
							commonQuery();
						}
					}
				});
			}
		});
		
		IButton userManageButton = new IButton("用户管理");
		userManageButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SendEmployeePanel panel = new SendEmployeePanel();
				PopupWindow window = new PopupWindow();
				window.addItem(panel);
				panel.loadClock();
				panel.loadEmployee();
				panel.setParentWindow(window);
				window.setTitle("下发人员");
				window.setWidth100();
				window.setHeight100();
				window.centerInPage();
				window.show();
			}
		});
		leftButtonLayout.addMember(clockRecevieCmdButton);
		leftButtonLayout.addMember(userManageButton);
		leftButtonLayout.addMember(manageAndMaintain);
		leftButtonLayout.setAlign(Alignment.LEFT);
		contentLeftLayout.addMember(leftButtonLayout);
		
		
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Record record = resultGrid.getRecord(event.getRowNum());
				if(null != record){
					SC.debugger();
					Integer isEnable = record.getAttributeAsInt("isEnable");
					record.setAttribute("enabled", isEnable);
					Map<Object,Object> params = record.toMap();
					DBDataSource.callOperation("ST_Clock", "saveOrUpdate", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() < 0) {
								ClientUtil.displayErrorMessage(dsResponse);
							}else {
								commonQuery();
							}
						}
					});
				}
			}
		});
		
		leftGridLayout = new HLayout(10);
		leftGridLayout.setWidth100();
		leftGridLayout.setHeight("80%");
		
		leftGridLayout.addMember(resultGrid);
		contentLeftLayout.addMember(leftGridLayout);
		
		commonQuery();
		return allLayout;
	}
}

