package com.pomplatform.client.ja.ht.panel;

import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.ja.ht.datasource.DSOutDesignConsideration;
import com.pomplatform.client.ja.ht.form.OutDesignConsiderationViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class OutDesignConsiderationPanel extends AbstractSearchPanel
{

	private static Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OutDesignConsiderationPanel cm = new OutDesignConsiderationPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OutDesignConsideration";
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

		ListGridField[] fields = new ListGridField[22];
		int idx = 0;
		fields[idx] = new ListGridField("outDesignConsiderationId");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("infoCode");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("projectCode");
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
		idx ++;
		fields[idx] = new ListGridField("designUnitPrice");
		idx ++;
		fields[idx] = new ListGridField("moneySum");
		idx ++;
		fields[idx] = new ListGridField("subContractId");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("jobMix");
		idx ++;
		fields[idx] = new ListGridField("serviceArea");
		idx ++;
		fields[idx] = new ListGridField("withTheAmount");
		idx ++;
		fields[idx] = new ListGridField("onSiteTime");
		idx ++;
		fields[idx] = new ListGridField("onSitePrice");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("onSiteTotalMoney");
		idx ++;
		fields[idx] = new ListGridField("createTime");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("updateTime");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("orderNo");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("disableType");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("outQuotationId");
		fields[idx].setHidden(true);
		idx ++;
		resultGrid.setFields(fields);
//		resultGrid.setShowFilterEditor(true);
//		resultGrid.setFilterOnKeypress(true);
		IButton newButton = new IButton("新增订单项");
		controlLayout.addMember(newButton);
		newButton.setIcon("[SKIN]/actions/add.png");
		newButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				resultGrid.startEditingNew();
			}
		});

		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();
				
				__LOGGER.info(" OutDesignConsideration param="+params);
				final int rowNumModified = event.getRowNum();
				DBDataSource.callOperation("ST_OutDesignConsideration", "saveOrUpdate", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						}else {
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
				DBDataSource.callOperation("ST_OutDesignConsideration", "delete", selected.toMap(), new DSCallback() {
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

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSOutDesignConsideration.getInstance();
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("infoCode", infoCode);
		criteria.put("projectCode", projectCode);
		criteria.put("outQuotationId", outQuotationId);
		return true;
	}

	private String infoCode;
	private String projectCode;
	private int outQuotationId;

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

	public int getOutQuotationId() {
		return outQuotationId;
	}

	public void setOutQuotationId(int outQuotationId) {
		this.outQuotationId = outQuotationId;
	}

}

