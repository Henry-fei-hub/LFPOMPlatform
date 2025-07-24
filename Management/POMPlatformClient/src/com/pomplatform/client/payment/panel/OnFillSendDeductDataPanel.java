package com.pomplatform.client.payment.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.DownloadFileByUrl;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.common.UploadFillSendDeductData;
import com.pomplatform.client.payment.datasource.DSOnFillSendDeductData;
import com.pomplatform.client.payment.form.OnFillSendDeductDataSearchForm;
import com.pomplatform.client.payment.form.OnFillSendDeductDataViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class OnFillSendDeductDataPanel extends AbstractSearchPanel
{
	private static boolean canCheck = false;
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnFillSendDeductDataPanel cm = new OnFillSendDeductDataPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnFillSendDeductData";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setShowRowNumbers(true);
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setCanEdit(true);
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
		
		IButton downloadTemplate = new IButton("下载模板");
		controlLayout.addMember(downloadTemplate);
		downloadTemplate.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	DownloadFileByUrl.download("/files/reissueBuckle.xlsx");
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
						UploadFillSendDeductData uploadXls = new UploadFillSendDeductData();
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
		addButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				resultGrid.startEditingNew();
			}
		});
		controlLayout.addMember(addButton);
		
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();
				//获取填平五险一金
				BigDecimal fillFiveInsuranceOneGolds = BaseHelpUtils.getBigDecimalValue(params.get("fillFiveInsuranceOneGolds"));
				//获取多扣个税
				BigDecimal moreDeductTax = BaseHelpUtils.getBigDecimalValue(params.get("moreDeductTax"));
				//获取填平个税
				BigDecimal fillTax = BaseHelpUtils.getBigDecimalValue(params.get("fillTax"));
				//设置合计
				BigDecimal totalAmount = fillFiveInsuranceOneGolds.add(moreDeductTax).add(fillTax);
				//获取日期
				Date recordDate = (Date)params.get("recordDate");
				DateTimeFormat yeardf = DateTimeFormat.getFormat("yyyy");
				DateTimeFormat monthdf = DateTimeFormat.getFormat("MM");
				int year = BaseHelpUtils.getIntValue(yeardf.format(recordDate));
				int month = BaseHelpUtils.getIntValue(monthdf.format(recordDate));
				params.put("recordDate",recordDate);
				params.put("year",year);
				params.put("month",month);
				params.put("totalAmount",totalAmount);
				params.put("operateEmployeeId",ClientUtil.getEmployeeId());
				params.put("operateTime",new Date());
				DBDataSource.callOperation("ST_SalaryFillSendDeduct","saveOrUpdate", params, new DSCallback() {
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
		});
		
		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条删除");
					return;
				}
				SC.ask("提示","您确认要删除吗?",new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						final ListGridRecord selected = resultGrid.getSelectedRecord();
						DBDataSource.callOperation("ST_SalaryFillSendDeduct", "delete", selected.toMap(), new DSCallback() {
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
				});
			}
		});
		
		commonQuery();
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
				detail.setTitle("补发补扣"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnFillSendDeductDataViewer detailForm = new OnFillSendDeductDataViewer();
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
	public void afterDataReceived(Record[] data) {
		if(!BaseHelpUtils.isNullOrEmpty(data) && data.length > 0){
			for(Record e : data){
				//获取是否发放
				boolean isSended = e.getAttributeAsBoolean("isSended");
				if(isSended){//如果已发放，则设置为不可用，即不可以进行修改
					e.setAttribute("enabled", false);
				}
			}
		}
	}
	
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new OnFillSendDeductDataSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnFillSendDeductData.getInstance();
	}


}

