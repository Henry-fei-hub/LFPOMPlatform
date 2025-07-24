package com.pomplatform.client.ja.ht.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.ChangeEvent;
import com.smartgwt.client.widgets.grid.events.ChangeHandler;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.EditorExitEvent;
import com.smartgwt.client.widgets.grid.events.EditorExitHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PaginationPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.ja.ht.datasource.DSDesignConsideration;
import com.pomplatform.client.ja.ht.form.DesignConsiderationViewer;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.Map;
import java.util.logging.Logger;

public class DesignConsiderationPanel extends AbstractSearchPanel {
	private static Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			DesignConsiderationPanel cm = new DesignConsiderationPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "DesignConsideration";
		}

	}

	@Override
	public void initComponents() {
		resultGrid.setCanEdit(true);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		ListGridField[] fields = new ListGridField[11];
		int idx = 0;
		fields[idx] = new ListGridField("infoCode");
		fields[idx].setDefaultValue(infoCode);
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("projectCode");
		fields[idx].setDefaultValue(projectCode);
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("businessType");
		SelectItem selectBusinessTypeItem = new SelectItem();
		selectBusinessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		fields[idx].setEditorProperties(selectBusinessTypeItem);

		idx++;
		fields[idx] = new ListGridField("projectType");
		SelectItem selectProjectTypeItem = new SelectItem();
		selectProjectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		fields[idx].setEditorProperties(selectProjectTypeItem);
		idx++;
		fields[idx] = new ListGridField("mainDesignAreaName");
		idx++;
		fields[idx] = new ListGridField("decorationStatus");
		SelectItem selectDecorationStatusItem = new SelectItem();
		selectDecorationStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_30"));
		fields[idx].setEditorProperties(selectDecorationStatusItem);
		idx++;
		fields[idx] = new ListGridField("designArea");
		fields[idx].addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				// TODO Auto-generated method stub
				int recordNum = event.getRowNum();
				ListGridRecord lr = resultGrid.getRecord(recordNum);
				Double tempPrice = 0.00;
				try {
					tempPrice = BaseHelpUtils.getDoubleValue(
							lr.getAttribute("designUnitPrice") == null ? 0 : lr.getAttribute("designUnitPrice"));
				} catch (Exception e) {
					tempPrice = 0.00;
					__LOGGER.info("add 单价=" + tempPrice);
				}
				Double tempArea = BaseHelpUtils.getDoubleValue(event.getValue());
				Double tempMoneySum = tempArea * tempPrice;
				lr.setAttribute("designArea", tempArea);
				lr.setAttribute("moneySum", BaseHelpUtils.getDoubleValue(tempMoneySum));// 小计
				
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();

//				__LOGGER.info("params=" + params);
				final int rowNumModified = event.getRowNum();
				DBDataSource.callOperation("ST_DesignConsideration", "saveOrUpdate", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							DBDataSource.copyRecord(dsResponse.getData()[0], resultGrid.getRecord(rowNumModified));
							resultGrid.redraw();
						}
					}
				});

				// __LOGGER.info("tempArea="+tempArea+"tempPrice="+tempPrice+"mymoneySum="+tempMoneySum);
			}
		});
		idx++;
		fields[idx] = new ListGridField("designUnitPrice");
		fields[idx].addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				// TODO Auto-generated method stub
				int recordNum = event.getRowNum();
				ListGridRecord lr = resultGrid.getRecord(recordNum);
				Double tempPrice = BaseHelpUtils.getDoubleValue(event.getValue());
				Double tempArea = 0.00;
				try {
					tempArea = BaseHelpUtils
							.getDoubleValue(lr.getAttribute("designArea") == null ? 0 : lr.getAttribute("designArea"));
				} catch (Exception e) {
					tempArea = 0.00;
					__LOGGER.info("add 设计面积=" + tempArea);
				}

				Double tempMoneySum = tempArea * tempPrice;

				lr.setAttribute("designUnitPrice", tempPrice);
				lr.setAttribute("moneySum", BaseHelpUtils.getDoubleValue(tempMoneySum));// 小计
				
				
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();

//				__LOGGER.info("params=" + params);
				final int rowNumModified = event.getRowNum();
				DBDataSource.callOperation("ST_DesignConsideration", "saveOrUpdate", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							DBDataSource.copyRecord(dsResponse.getData()[0], resultGrid.getRecord(rowNumModified));
							resultGrid.redraw();
						}
					}
				});

				// __LOGGER.info("tempPrice="+tempPrice+"tempArea="+tempArea+"mymoneySum="+tempMoneySum);
			}
		});
		idx++;
		fields[idx] = new ListGridField("moneySum");
		idx++;
		fields[idx] = new ListGridField("jobMix");
		idx++;
		fields[idx] = new ListGridField("serviceArea");
		idx++;
		fields[idx] = new ListGridField("withTheAmount");
		idx++;
		fields[idx] = new ListGridField("onSiteTime");
		idx++;
		fields[idx] = new ListGridField("onSiteTotalMoney");
		idx++;
		resultGrid.setFields(fields);
//		resultGrid.setShowFilterEditor(true);
		resultGrid.setFilterOnKeypress(true);
		IButton newButton = new IButton("新增报价单");
		controlLayout.addMember(newButton);
		newButton.setIcon("[SKIN]/actions/add.png");
		newButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {

				Map m = new HashMap<>();
				m.put("designArea", 0);
				m.put("designUnitPrice", 0);
				m.put("moneySum", 0);
				resultGrid.startEditingNew(m);

				// ListGridRecord record = new ListGridRecord();
				// record.setAttribute("infoCode", infoCode);
				// record.setAttribute("designArea", 0);
				// record.setAttribute("designUnitPrice", 0);
				// record.setAttribute("moneySum", 0);
				//
				// ListGridRecord[] rlist = resultGrid.getRecords();
				// int len = rlist.length;
				// ListGridRecord[] resultList = new ListGridRecord[len + 1];
				// int i = 0;
				// for (ListGridRecord e : rlist) {
				// resultList[i] = e;
				// i++;
				// }
				// resultList[len] = record;
				// resultGrid.setData(resultList);
				// resultGrid.redraw();

			}
		});
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();

//				__LOGGER.info("params=" + params);
				final int rowNumModified = event.getRowNum();
				DBDataSource.callOperation("ST_DesignConsideration", "saveOrUpdate", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							DBDataSource.copyRecord(dsResponse.getData()[0], resultGrid.getRecord(rowNumModified));
							resultGrid.redraw();
						}
					}
				});
			}
		});

		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.setIcon("[SKIN]/actions/remove.png");
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				DBDataSource.callOperation("ST_DesignConsideration", "delete", selected.toMap(), new DSCallback() {
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

	// getViewPanel 重写
	public Canvas getViewPanel() {
		VLayout layout = new VLayout();
		layout.setWidth100();
		layout.setHeight100();
		layout.setBackgroundColor("#e2e2e2");

		VLayout resultLayout = new VLayout();
		resultLayout.setWidth100();
		resultLayout.setHeight100();

		HLayout dataLayout = new HLayout();
		dataLayout.setHeight100();
		dataLayout.setWidth100();
		resultLayout.addMember(dataLayout);

		resultGrid = new DelicacyListGrid();
		resultGrid.setDataSource(getDataSource());

		VLayout centerLayout = new VLayout();
		centerLayout.addMember(resultGrid);
		dataLayout.addMember(resultGrid);
		dataLayout.addMember(centerLayout);
		if (showControlPanel()) {
			controlLayout = new VLayout();
			controlLayout.setHeight100();
			controlLayout.setLayoutTopMargin(30);
			controlLayout.setLayoutLeftMargin(5);
			controlLayout.setLayoutRightMargin(5);
			controlLayout.setMembersMargin(10);

			dataLayout.addMember(controlLayout);
		}
		
		
		ToolStrip toolStrip = new ToolStrip();
		toolStrip.addFill();
		IButton resertSureIntegral = new IButton("报价单提交");
		resertSureIntegral.setAutoFit(true);
		resertSureIntegral.setWidth(100);
		//toolStrip.addMember(resertSureIntegral);
		// 报价单提交 histroy
		resertSureIntegral.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				RecordList rl = resultGrid.getRecordList();
				if (rl.isEmpty()) {
					SC.say("没有报价单");
				} else {

					SC.confirm("提交前请确认无误", new BooleanCallback() {

						@Override
						public void execute(Boolean value) {
							if(value){
								__LOGGER.info("====报价单提交======");
								Map<String, String> m = new HashMap<>();
								m.put("infoCode", infoCode);
								DBDataSource.callOperation("EP_CustomSubmitQuotation", m, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() < 0) {
											ClientUtil.displayErrorMessage(dsResponse);
										} else {
											SC.say("提交完成");
										}
									}
								});
							}
						}
					});
				}

			}
		});
		
//		centerLayout.addMember(toolStrip);

		layout.addMember(resultLayout);

		initComponents();
		if (showControlPanel()) {
			setControlLayoutWidth();
		}
		return layout;
	}
	

	private void getFormItemArray() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSDesignConsideration.getInstance();
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("infoCode", infoCode);
		criteria.put("projectCode", projectCode);
		return true;
	}

	private String infoCode;
	private String projectCode;

	public String getInfoCode() {
		return infoCode;
	}

	public void setInfoCode(String infoCode) {
		this.infoCode = infoCode;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
}
