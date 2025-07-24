package com.pomplatform.client.revenuevoucher.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.revenuevoucher.datasource.DSMprojectcrymor;
import com.pomplatform.client.revenuevoucher.form.MprojectcrymorViewer;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridContractValue;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditorExitEvent;
import com.smartgwt.client.widgets.grid.events.EditorExitHandler;

public class MprojectcrymorAreaPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			MprojectcrymorAreaPanel cm = new MprojectcrymorAreaPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mprojectcrymor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		// 项目信息字段
		ListGridField projectIdField = new ListGridField("contractId");
		ListGridField contractCodeField = new ListGridField("contractCode");
		ListGridField projectNameField = new ListGridField("contractName");
		
		int index = 0;
		ListGridField [] fields = new ListGridField[10];
		fields[index] = new ListGridField("contractCode");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("projectName");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("sheetAmount");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("departmentId");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("contractId");
		fields[index].setCanEdit(true);
		fields[index].setWidth(300);
		ComboBoxItem projectSelectItem = new ComboBoxItem("contractId");
		projectSelectItem.setPickListWidth(450);
		projectSelectItem.setOptionDataSource(DSSelectGridContractValue.getInstance());
		projectSelectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectSelectItem.setValueField(projectIdField.getName());
		projectSelectItem.setDisplayField(projectNameField.getName());
		projectSelectItem.setChangeOnKeypress(false);
		projectSelectItem.setPickListFields(projectIdField, projectNameField, contractCodeField);
		fields[index].setEditorProperties(projectSelectItem);
		fields[index].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				int contractId = null == event.getNewValue() ? 0 : (int) event.getNewValue();
				ListGridRecord record = event.getRecord();
				if(contractId > 0){
					Map<String, Object> params = new HashMap<>();
					params.put("contractId", contractId);
					params.put("projectId", record.getAttributeAsObject("projectId"));
					DBDataSource.callOperation("ST_Project", "update", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							commonQuery();
							
						}
					});
				}
			}
		});
		index++;
		fields[index] = new ListGridField("contractArea");
		fields[index].setCanEdit(true);
		fields[index].setWidth(300);
		fields[index].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				int contractArea = null == event.getNewValue() ? 0 : (int) event.getNewValue();
				ListGridRecord record = event.getRecord();
				if(contractArea > 0){
					Map<String, Object> params = new HashMap<>();
					params.put("contractId", record.getAttributeAsObject("contractId"));
					params.put("contractArea", contractArea);
					DBDataSource.callOperation("ST_Contract", "update", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							commonQuery();
							
						}
					});
				}
			}
		});
		
		resultGrid.setFields(fields);
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("Mprojectcrymor");
				detail.setWidth100();
				detail.setHeight100();
				MprojectcrymorViewer detailForm = new MprojectcrymorViewer();
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
		criteria.put("addtionalCondition", "order by project_id");
		criteria.put("year", getYear());
		criteria.put("month", getMonth());
		
		List<Map> keyvalues = new ArrayList<>();
		Map<String, String> kv = new HashMap<>();
		kv.put("key", "(pj.contract_id ISNULL OR pj.contract_id <= 0)");
		if(null != getIsAll() && getIsAll()){
			kv.put("value", "1 = 1");
		}else{
			kv.put("value", "(ct.contract_area is null or ct.contract_area <= 0 )");
		}
		
		keyvalues.add(kv);
		criteria.put("keyValues", keyvalues);
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
//		return new MprojectcrymorSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSMprojectcrymor.getInstance();
	}
	
	private PopupWindow pw;

	public PopupWindow getPw() {
		return pw;
	}

	public void setPw(PopupWindow pw) {
		this.pw = pw;
	}
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}
	
	private Integer year;
	private Integer month;
	private Boolean isAll;

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Boolean getIsAll() {
		return isAll;
	}

	public void setIsAll(Boolean isAll) {
		this.isAll = isAll;
	}
	
}
