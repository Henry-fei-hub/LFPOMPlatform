package com.pomplatform.client.specialdeduction.panel;

import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.specialdeduction.datasource.DSSspecialdeductionmonthdetailedpor;
import com.pomplatform.client.specialdeduction.form.SspecialdeductionmonthdetailedporSearchForm;
import com.pomplatform.client.specialdeduction.form.SspecialdeductionmonthdetailedporViewer;
import com.pomplatform.client.specialdeduction.form.NewSspecialdeductionmonthdetailedporForm;
import com.pomplatform.client.specialdeduction.form.UpdateSspecialdeductionmonthdetailedporForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class SspecialdeductionmonthdetailedporPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SspecialdeductionmonthdetailedporPanel cm = new SspecialdeductionmonthdetailedporPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Sspecialdeductionmonthdetailedpor";
		}

	}

	@Override
	public void init(){
		super.init();
		resultGrid.setShowGridSummary(true);
		resultGrid.setAutoFitFieldWidths(false);
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

		
		IButton monthButton = new IButton("计算月专项扣除");
        controlLayout.addMember(monthButton);
        monthButton.addClickHandler(new ClickHandler() {
            @SuppressWarnings("unchecked")
			@Override
            public void onClick(ClickEvent event) {
            	Map<String,Object> param = new HashMap<>();
            	Criteria record = searchForm.getValuesAsCriteria();
            	param.putAll(record.getValues());
            	param.putAll(searchForm.getValues());
            	param.put("employeeId", 0);
                param.put("optType", "onSpecialDeductionMonthTotalAccount");
                final LoadingWindow loading = new LoadingWindow();
                DBDataSource.callOperation("EP_OnPaymentManageProcess", param, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                    	loading.destroy();
                        if (dsResponse.getStatus() >= 0) {
                            SC.say("计算成功");
                            commonQuery();
                        } else {
                            SC.say((String) dsResponse.getErrors().get("errorMsg"));
                        }
                    }
                    
                });
            }
        });
        
        IButton monthButton2 = new IButton("计算个人月专项扣除");
        controlLayout.addMember(monthButton2);
        monthButton2.addClickHandler(new ClickHandler() {
        	@SuppressWarnings("unchecked")
        	@Override
        	public void onClick(ClickEvent event) {
        	Map<String,Object> param = new HashMap<>();
        	param.putAll(searchForm.getValues());
        	int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
        	if(employeeId<=0){
        		SC.say("提示","请选择人员");
        	}
            param.put("optType", "onSpecialDeductionMonthTotalAccount");
            final LoadingWindow loading = new LoadingWindow();
            DBDataSource.callOperation("EP_OnPaymentManageProcess", param, new DSCallback() {
                @Override
                public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                	loading.destroy();
                    if (dsResponse.getStatus() >= 0) {
                        SC.say("计算成功");
                        commonQuery();
                    } else {
                        SC.say((String) dsResponse.getErrors().get("errorMsg"));
                    }
                }
                
            });
        }
        });
        
        
		IButton operation2Button = new IButton("新建");
//		controlLayout.addMember(operation2Button);
		operation2Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
					@Override
					public void onSuccess() {
						NewSspecialdeductionmonthdetailedporForm detailForm = new NewSspecialdeductionmonthdetailedporForm();
						detailForm.setTitle("新建");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								RecordList list = resultGrid.getDataAsRecordList();
								RecordList newList = new RecordList();
								newList.addList(list.getRange(0, list.getLength()));
								newList.add(event.getData());
								resultGrid.setData(newList);
								resultGrid.selectSingleRecord(newList.getLength()-1);
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth100();
						detailForm.setHeight100();
						detailForm.centerInPage();
						detailForm.show();
					}
				});
			}
		});
		IButton operation3Button = new IButton("修改");
//		controlLayout.addMember(operation3Button);
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
						UpdateSspecialdeductionmonthdetailedporForm detailForm = new UpdateSspecialdeductionmonthdetailedporForm();
						detailForm.setTitle("修改");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								DBDataSource.copyRecord(event.getData(), selected1);
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(selected1);
						detailForm.setCurrentPage(getCurrentPage());
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth100();
						detailForm.setHeight100();
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
				DBDataSource.callOperation("ST_Sspecialdeductionmonthdetailedpor", "delete", selected.toMap(), new DSCallback() {
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
				detail.setTitle("Sspecialdeductionmonthdetailedpor"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				SspecialdeductionmonthdetailedporViewer detailForm = new SspecialdeductionmonthdetailedporViewer();
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
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new SspecialdeductionmonthdetailedporSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSspecialdeductionmonthdetailedpor.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}
}

