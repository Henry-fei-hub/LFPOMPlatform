package com.pomplatform.client.cwd.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.cwd.datasource.DSWorkplacePublicIPManage;
import com.pomplatform.client.cwd.form.NewWorkplacePublicIPManageForm;
import com.pomplatform.client.cwd.form.UpdateWorkplacePublicIPManageForm;
import com.pomplatform.client.cwd.form.WorkplacePublicIPManageSearchForm;
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
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class WorkplacePublicIPManagePanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			WorkplacePublicIPManagePanel cm = new WorkplacePublicIPManagePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "WorkplacePublicIPManage";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
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

		IButton operation2Button = new IButton("新建");
		controlLayout.addMember(operation2Button);
		operation2Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
					@Override
					public void onSuccess() {
						NewWorkplacePublicIPManageForm detailForm = new NewWorkplacePublicIPManageForm();
						detailForm.setTitle("新建");
						Record record = new Record();
						record.setAttribute("companyWorkplaceId", companyWorkplaceId);
						record.setAttribute("workplaceName", workplaceName);
						detailForm.setRecord(record);
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
						detailForm.setWidth("40%");
						detailForm.setHeight("40%");
						detailForm.centerInPage();
						detailForm.show();
					}
				});
			}
		});
		
		IButton operation3Button = new IButton("修改");
		controlLayout.addMember(operation3Button);
		operation3Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据修改"); return;}
						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
						UpdateWorkplacePublicIPManageForm detailForm = new UpdateWorkplacePublicIPManageForm();
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
						detailForm.setWidth("40%");
						detailForm.setHeight("40%");
						detailForm.centerInPage();
						detailForm.show();
						setCurrentPage(detailForm.getCurrentPage());
					}
				});
			}
		});
		
		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("Please select a data to remove.");
						}
						SC.confirm("确定要删掉这条记录吗？", new BooleanCallback() {
							
							@Override
							public void execute(Boolean value) {
								if(value) {
									final ListGridRecord selected = resultGrid.getSelectedRecord();
									DBDataSource.callOperation("ST_CompanyWorkplacePublicIp", "delete", selected.toMap(), new DSCallback() {
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
			}
		});

	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if(null != companyWorkplaceId)
			criteria.put("companyWorkplaceId", companyWorkplaceId);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new WorkplacePublicIPManageSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSWorkplacePublicIPManage.getInstance();
	}

	private Integer companyWorkplaceId;
	private String workplaceName;

	public Integer getCompanyWorkplaceId() {
		return companyWorkplaceId;
	}

	public void setCompanyWorkplaceId(Integer companyWorkplaceId) {
		this.companyWorkplaceId = companyWorkplaceId;
	}

	public String getWorkplaceName() {
		return workplaceName;
	}

	public void setWorkplaceName(String workplaceName) {
		this.workplaceName = workplaceName;
	}
	
}

