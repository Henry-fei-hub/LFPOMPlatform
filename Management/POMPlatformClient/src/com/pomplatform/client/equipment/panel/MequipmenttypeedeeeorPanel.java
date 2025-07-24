package com.pomplatform.client.equipment.panel;

import java.util.Date;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ui.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
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

import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.equipment.datasource.DSMequipmenttypeedeeeor;
import com.pomplatform.client.equipment.form.MequipmenttypeedeeeorSearchForm;
import com.pomplatform.client.equipment.form.MequipmenttypeedeeeorViewer;
import com.pomplatform.client.equipment.form.NewMequipmenttypeedeeeorForm;
import com.pomplatform.client.equipment.form.UpdateMequipmenttypeedeeeorForm;
import com.pomplatform.client.equipment.form.UpdateMequipmenttypeedeeeorForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class MequipmenttypeedeeeorPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			MequipmenttypeedeeeorPanel cm = new MequipmenttypeedeeeorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mequipmenttypeedeeeor";
		}

	}

	@Override
	public void init(){
		super.init();

		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {resultGrid.setShowRowNumbers(true);
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
		IButton addequipmentButton = new IButton("新增物品");
		controlLayout.addMember(addequipmentButton);
		addequipmentButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
					@Override
					public void onSuccess() {
						NewMequipmenttypeedeeeorForm detailForm = new NewMequipmenttypeedeeeorForm();
						detailForm.setTitle("新增物品");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.initComponents();
						detailForm.startEdit();
                        detailForm.setWidth("60%");
                        detailForm.setHeight("70%");
						detailForm.centerInPage();
						detailForm.show();
						setCurrentPage(detailForm.getCurrentPage());
					}
				});
				commonQuery();
			}
		});

		IButton modifyButton = new IButton("修改");
		controlLayout.addMember(modifyButton);
		modifyButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable throwable) {
						SC.say("failure to download code");
					}

					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条数据修改");
							return;
						}
						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
						selected1.setAttribute("optType", "modify");
						selected1.setAttribute("userId", ClientUtil.getUserId());
						UpdateMequipmenttypeedeeeorForm detailForm = new UpdateMequipmenttypeedeeeorForm();
						detailForm.setTitle("库存调整");
						detailForm.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								DBDataSource.copyRecord(event.getData(), selected1);
								commonQuery();
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(selected1);
						detailForm.setCurrentPage(getCurrentPage());
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setModifyMode();
						detailForm.setWidth("60%");
						detailForm.setHeight("70%");
						detailForm.centerInPage();
						detailForm.show();
						setCurrentPage(detailForm.getCurrentPage());

					}
				});
			}
		});


		IButton modifycountButton = new IButton("库存调整");
		controlLayout.addMember(modifycountButton);
		modifycountButton.addClickHandler(new ClickHandler(){
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
						selected1.setAttribute("optType","updateCount");
                        selected1.setAttribute("userId",ClientUtil.getUserId());
						UpdateMequipmenttypeedeeeorForm detailForm = new UpdateMequipmenttypeedeeeorForm();
						detailForm.setTitle("库存调整");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								DBDataSource.copyRecord(event.getData(), selected1);
								commonQuery();
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
		IButton updateenabledButton = new IButton("启用/禁用");
		controlLayout.addMember(updateenabledButton);
		updateenabledButton.addClickHandler(new ClickHandler(){
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
						String enabled = selected1.getAttribute("flag");
						if(enabled.equals("false")){
							SC.confirm("是否确认启用该物品？", new BooleanCallback() {
								@Override
								public void execute(Boolean aBoolean) {
									//启用功能。。。。。
									if(aBoolean){
										int equipmentTypeId = selected1.getAttributeAsInt("equipmentTypeId");
										Map<String,Object> param = new HashMap<>();
										param.put("equipmentTypeId",equipmentTypeId);
										param.put("enabled",true);
//									param.put("flag",1);
										DBDataSource.callOperation("ST_EquipmentType","update",  param, new DSCallback() {
											@Override
											public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
												selected1.setAttribute("flag",true);
												resultGrid.redraw();
											}
										});
									}
								}
							});
						}
						if(enabled.equals("true")){
							SC.confirm("是否确认禁用该物品？", new BooleanCallback() {
								@Override
								public void execute(Boolean aBoolean) {
									//禁用功能。。。。。
									if(aBoolean){
										int equipmentTypeId = selected1.getAttributeAsInt("equipmentTypeId");
										Map<String,Object> param = new HashMap<>(2);
										param.put("equipmentTypeId",equipmentTypeId);
//                                    param.put("optType","updateEnabled");
										param.put("enabled",false);
										DBDataSource.callOperation("ST_EquipmentType","update",  param, new DSCallback() {
											@Override
											public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
												selected1.setAttribute("flag",false);
												resultGrid.redraw();
//											commonQuery();
											}
										});
									}
								}
							});

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
					SC.say("Please select a data to remove.");
				}
				SC.confirm("是否确认删除该物品？", new BooleanCallback() {
					@Override
					public void execute(Boolean aBoolean) {
						if(aBoolean){
							final ListGridRecord selected = resultGrid.getSelectedRecord();
							int equipmentTypeId = selected.getAttributeAsInt("equipmentTypeId");
							Map<String,Object> param = new HashMap<>(3);
							param.put("equipmentTypeId",equipmentTypeId);
							param.put("optType","delete");
							param.put("isDelete",selected.getAttribute("isDelete"));
							DBDataSource.callOperation("EP_UpdateEquipmentProcess", param, new DSCallback() {
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

		IButton exportButton = new IButton("导出");
		controlLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				ClientUtil.departmentParameterProcess(condition);
				DBDataSource.downloadFile("DW_Mequipmenttypeedeeeor", condition);
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
				detail.setTitle("物品详情");
				detail.setWidth100(); 
				detail.setHeight100(); 
				MequipmenttypeedeeeorViewer detailForm = new MequipmenttypeedeeeorViewer();
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
	public Canvas generateHDataCanvas() {
		resultGrid = new DelicacyListGrid() {
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				if (!BaseHelpUtils.getBoolean(record.getAttribute("flag"))) {
					return "color: red;";
				}else {
					return super.getCellCSSText(record, rowNum, colNum);
				}
			}
		};
		resultGrid.setDataSource(getDataSource());
		resultGrid.setWidth100();
		resultGrid.setHeight100();
		resultGrid.setShowRowNumbers(true);
		return resultGrid;
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by equipment_type_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new MequipmenttypeedeeeorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMequipmenttypeedeeeor.getInstance();
	}


}

