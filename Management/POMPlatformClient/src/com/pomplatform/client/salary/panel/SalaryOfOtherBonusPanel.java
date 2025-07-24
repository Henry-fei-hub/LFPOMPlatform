package com.pomplatform.client.salary.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.DownloadFileByUrl;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.UploadSalaryOfBonus;
import com.pomplatform.client.salary.datasource.DSSalaryOfOtherBonus;
import com.pomplatform.client.salary.form.SalaryOfOtherBonusSearchForm;
import com.pomplatform.client.salary.form.SalaryOfOtherBonusViewer;
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

public class SalaryOfOtherBonusPanel extends AbstractSearchPanel
{

	private static boolean canCheck = false;
	private static final Logger __LOGGER = Logger.getLogger("");
	private UploadSalaryOfBonus uploadXls;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SalaryOfOtherBonusPanel cm = new SalaryOfOtherBonusPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SalaryOfOtherBonus";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowGridSummary(true);
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
		
		resultGrid.setCanEdit(true);
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Record record = resultGrid.getRecord(event.getRowNum());
				if(!BaseHelpUtils.isNullOrEmpty(record)){
					Map<String,Object> params = record.toMap();
					params.put("optType", "onSalaryOfBonusSave");
					params.put("flag", 3);
					DBDataSource.callOperation("EP_OnPaymentManageProcess", params, new DSCallback() {
						
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
		
		IButton downloadTemplate = new IButton("下载模板");
		controlLayout.addMember(downloadTemplate);
		downloadTemplate.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	DownloadFileByUrl.download("/files/otherBonus.xlsx");
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
						Map<String,Object> param = new HashMap<>();
						param.put("flag", 3);
						uploadXls = new UploadSalaryOfBonus(param, DBDataSource.getServerURL("UP_OnUploadBonusProcess"));
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
		
		IButton addButton = new IButton("新增");
		controlLayout.addMember(addButton);
		addButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				resultGrid.startEditingNew();
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
				detail.setTitle("SalaryOfOtherBonus"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				SalaryOfOtherBonusViewer detailForm = new SalaryOfOtherBonusViewer();
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
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by salary_of_bonus_id");
		criteria.put("addtionalCondition", "order by employee_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new SalaryOfOtherBonusSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSalaryOfOtherBonus.getInstance();
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public void afterDataReceived(Record[] data) {
		if(!BaseHelpUtils.isNullOrEmpty(data)){
			boolean isSended = false;
			for(Record e : data){
				isSended = e.getAttributeAsBoolean("isSended");
				if(isSended){
					e.setAttribute("enabled", false);
				}
			}
		}
	}
}

