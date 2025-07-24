package com.pomplatform.client.clocks.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.clocks.datasource.DSClockRecevieCmds;
import com.pomplatform.client.clocks.form.ClockRecevieCmdsSearchForm;
import com.pomplatform.client.clocks.form.ClockRecevieCmdsViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
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

public class ClockRecevieCmdsPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ClockRecevieCmdsPanel cm = new ClockRecevieCmdsPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ClockRecevieCmds";
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
		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] records = resultGrid.getSelectedRecords();
				if(null != records && records.length > 0){
					SC.ask("提示", "确认删除吗？", new BooleanCallback() {
						@Override
						public void execute(Boolean value) {
							if (value) {
								if (!resultGrid.anySelected()) {
									SC.say("Please select a data to remove.");
								}
								final ListGridRecord selected = resultGrid.getSelectedRecord();
								DBDataSource.callOperation("ST_ClockRecevieCmd", "delete", selected.toMap(), new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() < 0) {
											ClientUtil.displayErrorMessage(dsResponse);
										} else {
											int indexNum = resultGrid.getRowNum(selected);
											resultGrid.removeData(selected);
											resultGrid.selectSingleRecord(indexNum);
											commonQuery();
										}
									}
								});
							}
						}
					});
				}
			}
		});
		IButton removeAllButton = new IButton("一键清除");
		controlLayout.addMember(removeAllButton);
		removeAllButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] records = resultGrid.getRecords();
				if(null != records && records.length > 0){
					SC.ask("提示", "确认全部删除吗？", new BooleanCallback() {
						@Override
						public void execute(Boolean value) {
							if (value) {
								Map<String,Object> param = new HashMap<>();
								param.put("optType", "deleteAllCmd");
								DBDataSource.callOperation("EP_ClockMsgProcess",param, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() < 0) {
											ClientUtil.displayErrorMessage(dsResponse);
										} else {
											commonQuery();
										}
									}
								});
							}
						}
					});
				}
			}
		});
		
		IButton resendButton = new IButton("重新下发");
		controlLayout.addMember(resendButton);
		resendButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> param = new HashMap<>();
				ListGridRecord[] records = resultGrid.getSelectedRecords();
				if(null != records && records.length > 0){
					ListGridRecord selected = records[0];
					param.put("optType", "resendCmd");
					param.put("clockRecevieCmdId", selected.getAttribute("clockRecevieCmdId"));
					DBDataSource.callOperation("EP_ClockMsgProcess", param, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								commonQuery();
							}
						}
					});
				}
			}
		});
		
		IButton resendAllButton = new IButton("一键下发");
		controlLayout.addMember(resendAllButton);
		resendAllButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> param = new HashMap<>();
				ListGridRecord[] records = resultGrid.getRecords();
				if(null != records && records.length > 0){
					SC.ask("提示", "确认一键下发吗？", new BooleanCallback() {
						@Override
						public void execute(Boolean value) {
							if (value) {
								param.put("optType", "resendAllCmd");
								DBDataSource.callOperation("EP_ClockMsgProcess", param, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if(dsResponse.getStatus() >= 0){
											commonQuery();
											SC.say("一键下发成功");
										}else{
											SC.say(dsResponse.getErrors().get("errorMsg").toString());
										}
									}
								});
							}
						}
					});
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("服务器下发命令"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ClockRecevieCmdsViewer detailForm = new ClockRecevieCmdsViewer();
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
		resultGrid.setShowRowNumbers(true);
		criteria.put("addtionalCondition", "order by clock_recevie_cmd_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ClockRecevieCmdsSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSClockRecevieCmds.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}
	
	private int successSize;

	public int getSuccessSize() {
		return successSize;
	}

	public void setSuccessSize(int successSize) {
		this.successSize = successSize;
	}
	
}

