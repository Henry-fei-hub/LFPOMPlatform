package com.pomplatform.client.cmbcinfo.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.cmbcinfo.datasource.DSMcmbcaccoutinfoccacbscor;
import com.pomplatform.client.cmbcinfo.form.McmbcaccoutinfoccacbscorSearchForm;
import com.pomplatform.client.cmbcinfo.form.McmbcaccoutinfoccacbscorViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class McmbcaccoutinfoccacbscorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			McmbcaccoutinfoccacbscorPanel cm = new McmbcaccoutinfoccacbscorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mcmbcaccoutinfoccacbscor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
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
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.setIcon("[SKIN]/actions/view.png");
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		
		IButton syncDataBtn = new IButton("同步账户数据");
		controlLayout.addMember(syncDataBtn);
		syncDataBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				final LoadingWindow loading = new LoadingWindow();
				Map<String, Object> params = new HashMap<>();
				params.put("opt_type", "syncCmbcData");
				DBDataSource.callOperation("CmbcInfoProcessor", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						loading.destroy();
						if(dsResponse.getStatus() >= 0){
							commonQuery();
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
						
					}
				});
				
			}
		});

		IButton synctransDataBtn = new IButton("同步交易数据");
		controlLayout.addMember(synctransDataBtn);
		synctransDataBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						PopupWindow pw = new PopupWindow();
						
		                
		                pw.setTitle("同步交易数据(间隔时间越长,更新等待时间越长)");
		                pw.setWidth(270);
		                pw.setHeight(270);
		                pw.centerInPage();
		                
						if(resultGrid.anySelected()){
							SC.ask("确认同步选择账号的交易数据吗?", new BooleanCallback() {
								
								@Override
								public void execute(Boolean value) {
									if(null != value && value){
										Record [] records = resultGrid.getSelectedRecords();
										SyncCmbcDataPanel panel = new SyncCmbcDataPanel();
										panel.addDataEditedHandler(new DataEditedHandler() {
						                	@Override
						                	public void onDataEdited(DataEditEvent event) {
						                		SC.say("操作成功");
						                	}
						                });
										panel.setParentCanvas(pw);
						                panel.setFatherWindow(pw);
										panel.setSelectRecords(records);
										pw.addItem(panel);
										pw.show();
									}else{
										pw.destroy();
									}
									
								}
							});
							
						}else{
							SC.ask("请问是需要同步所有银行账号的交易数据吗?如果是想单独更新指定账号的交易流水，请选择需要更新的数据支持多选!", new BooleanCallback() {
								
								@Override
								public void execute(Boolean value) {
									if(null != value && value){
										SyncCmbcDataPanel panel = new SyncCmbcDataPanel();
										panel.addDataEditedHandler(new DataEditedHandler() {
						                	@Override
						                	public void onDataEdited(DataEditEvent event) {
						                		SC.say("操作成功");
						                	}
						                });
										panel.setParentCanvas(pw);
						                panel.setFatherWindow(pw);
										pw.addItem(panel);
										pw.show();
									}else{
										pw.destroy();
									}
								}
							});
						}
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
				
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
				detail.setTitle("账户");
				detail.setWidth100();
				detail.setHeight100();
				McmbcaccoutinfoccacbscorViewer detailForm = new McmbcaccoutinfoccacbscorViewer();
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
		criteria.put("addtionalCondition", "order by cmbc_accout_info_id");
		criteria.put("addtionalCondition", "order by company_record_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new McmbcaccoutinfoccacbscorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMcmbcaccoutinfoccacbscor.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

}
