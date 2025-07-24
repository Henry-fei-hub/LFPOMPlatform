package com.pomplatform.client.salary.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.DownloadFileByUrl;
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
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.UploadSalaryOfBonus;
import com.pomplatform.client.salary.datasource.DSSalaryAnnualbonus;
import com.pomplatform.client.salary.form.SalaryAnnualbonusSearchForm;
import com.pomplatform.client.salary.form.SalaryAnnualbonusViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class SalaryAnnualbonusPanel extends AbstractSearchPanel
{
	private static boolean canCheck = false;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SalaryAnnualbonusPanel cm = new SalaryAnnualbonusPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SalaryAnnualbonus";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setCanEdit(true);
		resultGrid.setShowGridSummary(true);
		canCheck = false;
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

		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton downloadTemplate = new IButton("下载模板");
		controlLayout.addMember(downloadTemplate);
		downloadTemplate.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	DownloadFileByUrl.download("/files/annualBonus.xlsx");
            }
        });
		
		IButton importData = new IButton("导入");
		controlLayout.addMember(importData);
		importData.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						if(!canCheck){
		            		SC.say("提示", "您无权进行操作");
		            		return;
		            	}
						Map<String,Object> map = new HashMap<>();
						map.put("operateEmployeeId", ClientUtil.getEmployeeId());
						map.put("operateTime", new Date());
						UploadSalaryOfBonus uploadXls = new UploadSalaryOfBonus(map, DBDataSource.getServerURL("UP_OnUploadAnnualBonus"));
						uploadXls.addDataEditedHandler(new DataEditedHandler() {
							
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						uploadXls.show();
					}
				});
			}
		});
		
		IButton outportData = new IButton("导出");
		controlLayout.addMember(outportData);
		outportData.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						if(!canCheck){
							SC.say("提示", "您无权进行操作");
							return;
						}
						Map condition = generateCriteria();
						DBDataSource.downloadFile("DW_SalaryAnnualbonus", condition);
					}
				});
			}
		});
		
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map<String,Object> param = resultGrid.getSelectedRecord().toMap();
				param.put("optType", "onAnnualBonusEdit");
				DBDataSource.callOperation("EP_OnPaymentManageProcess", param, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							commonQuery();
						}
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("SalaryAnnualbonus"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				SalaryAnnualbonusViewer detailForm = new SalaryAnnualbonusViewer();
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
	public void commonQuery() {
		if(!canCheck){
			SC.askforValue("提示","您需输入正确的解锁密码方可查看数据",new ValueCallback() {
				@Override
				public void execute(String value) {
					if(BaseHelpUtils.isNullOrEmpty(value)){
						SC.say("提示","请输入正确的解锁密码");
					}else{
						Map<String,Object> params = new HashMap<>();
						params.put("password",BaseHelpUtils.getString(value));
						params.put("optType","onComparePassword");
						DBDataSource.callOperation("EP_OnPaymentManageProcess","find", params, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() < 0) {
									SC.say("提示","密码匹配错误");
								}else {
									canCheck = true;
									query();
								}
							}
						});
					}
				}
			});
			return;
		}else{
			query();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void query(){
		Map condition = generateCriteria();
        if (condition == null) {
            return;
        }
        if (searchForm != null) {
            searchButton.setIcon("loading38.gif");
        }
        DBDataSource ds = (DBDataSource) getDataSource();
        String operationName = ds.getActionMode() + ds.getActionName();
        final LoadingWindow loading = new LoadingWindow();
        DBDataSource.callOperation(operationName, "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
            	loading.destroy();
                if (searchForm != null) {
                    searchButton.setIcon("[SKIN]/actions/search.png");
                }
                if (dsResponse.getStatus() >= 0) {
                    resultGrid.setData(dsResponse.getData());
                    afterDataReceived(dsResponse.getData());
                    if (isNeedPagenation() && pager != null) {
                        if (currentPage == 1) {
                            totalPages = dsResponse.getAttributeAsInt("totalPages");
                            pager.getTotalPages().setContents(String.valueOf(totalPages));
                        }
                    }
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
                if (showPagination() && pager != null) {
                    pager.getCurrentPage().setContents(String.valueOf(currentPage));
                }
            }
        });
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by employee_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new SalaryAnnualbonusSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSalaryAnnualbonus.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}
	
	//如果为已发放，则不能编辑
	@Override
	public void afterDataReceived(Record[] data) {
		if(!BaseHelpUtils.isNullOrEmpty(data)){
			for(Record e : data){
				boolean isSended = e.getAttributeAsBoolean("isSended");
				if(isSended){
					e.setAttribute("enabled", false);
				}
			}
		}
	}

}

