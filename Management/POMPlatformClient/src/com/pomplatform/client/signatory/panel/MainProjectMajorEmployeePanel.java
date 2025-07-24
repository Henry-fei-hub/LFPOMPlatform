package com.pomplatform.client.signatory.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.pomplatform.client.signatory.datasource.DSMainProjectMajorEmployee;
import com.pomplatform.client.signatory.form.MainProjectMajorEmployeeViewer;
import com.smartgwt.client.data.Criteria;
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
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class MainProjectMajorEmployeePanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private int mainProjectId;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			MainProjectMajorEmployeePanel cm = new MainProjectMajorEmployeePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "MainProjectMajorEmployee";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
	}

	@Override
	public void initComponents() {
		
		ListGridField employeeNoField = new ListGridField("employeeNo");
		ListGridField employeeNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		
		resultGrid.setAutoFitFieldWidths(true);
		resultGrid.setCanEdit(true);
		ListGridField[] fields = new ListGridField[4];
		int index = 0;
		fields[index] = new ListGridField("specialtyId", "专业");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("relation", "角色");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("employeeId", "负责人");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("stampHolder", "签署人");
		fields[index].setWidth(300);
		fields[index].setCanEdit(true);
		
		ComboBoxItem employeeSelectItem = new ComboBoxItem("stampHolder", "签署人");
		employeeSelectItem.setChangeOnKeypress(false);
		employeeSelectItem.setRequired(true);
		employeeSelectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeSelectItem.setWidth("*");
		Criteria cd = new Criteria();
		cd.addCriteria("status", "0");
		
		employeeSelectItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		employeeSelectItem.setOptionCriteria(cd);
		employeeSelectItem.setValueField("employeeId");
		employeeSelectItem.setDisplayField("employeeName");
		employeeSelectItem.setPickListFields(employeeNoField, employeeNameField, departmentIdField);
		fields[index].setEditorProperties(employeeSelectItem);

		resultGrid.setFields(fields);
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();
				final int rowNumModified = event.getRowNum();
				DBDataSource.callOperation("ST_MainProjectMajorEmployee", "saveOrUpdate", params, new DSCallback() {
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
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		// resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
		// @Override
		// public void onDoubleClick(DoubleClickEvent event) {
		// showDetail();
		// }
		// });
		// IButton operation1Button = new IButton("查看详情");
		// controlLayout.addMember(operation1Button);
		// operation1Button.setIcon("[SKIN]/actions/view.png");
		// operation1Button.addClickHandler(new ClickHandler(){
		// @Override
		// public void onClick(ClickEvent event) {
		// showDetail();
		// }
		// });
		// IButton operation2Button = new IButton("修改");
		// controlLayout.addMember(operation2Button);
		// operation2Button.setIcon("[SKIN]/actions/edit.png");
		// operation2Button.addClickHandler(new ClickHandler(){
		// @Override
		// public void onClick(ClickEvent event) {
		// GWT.runAsync(new RunAsyncCallback() {
		// @Override
		// public void onFailure(Throwable reason) {
		// SC.say("failure to download code");
		// }
		// @Override
		// public void onSuccess() {
		// if(!resultGrid.anySelected()){ SC.say("请选择一条数据修改"); return;}
		// final ListGridRecord selected1 = resultGrid.getSelectedRecord();
		// UpdateMainProjectMajorEmployeeForm detailForm = new
		// UpdateMainProjectMajorEmployeeForm();
		// detailForm.setTitle("修改");
		// detailForm.addDataEditedHandler(new DataEditedHandler(){
		// @Override
		// public void onDataEdited(DataEditEvent event) {
		// DBDataSource.copyRecord(event.getData(), selected1);
		// }
		// });
		// detailForm.setSearchForm(searchForm);
		// detailForm.setRecord(selected1);
		// detailForm.setCurrentPage(getCurrentPage());
		// detailForm.initComponents();
		// detailForm.startEdit();
		// detailForm.setWidth100();
		// detailForm.setHeight100();
		// detailForm.centerInPage();
		// detailForm.show();
		// setCurrentPage(detailForm.getCurrentPage());
		// }
		// });
		// }
		// });
		// IButton operation3Button = new IButton("新建");
		// controlLayout.addMember(operation3Button);
		// operation3Button.setIcon("[SKIN]/actions/add.png");
		// operation3Button.addClickHandler(new ClickHandler(){
		// @Override
		// public void onClick(ClickEvent event) {
		// GWT.runAsync(new RunAsyncCallback() {
		// @Override
		// public void onFailure(Throwable reason) {
		// SC.say("failure to download");
		// }
		// @Override
		// public void onSuccess() {
		// NewMainProjectMajorEmployeeForm detailForm = new
		// NewMainProjectMajorEmployeeForm();
		// detailForm.setTitle("新建");
		// detailForm.addDataEditedHandler(new DataEditedHandler(){
		// @Override
		// public void onDataEdited(DataEditEvent event) {
		// RecordList list = resultGrid.getDataAsRecordList();
		// RecordList newList = new RecordList();
		// newList.addList(list.getRange(0, list.getLength()));
		// newList.add(event.getData());
		// resultGrid.setData(newList);
		// resultGrid.selectSingleRecord(newList.getLength()-1);
		// }
		// });
		// detailForm.setSearchForm(searchForm);
		// detailForm.initComponents();
		// detailForm.startEdit();
		// detailForm.setWidth100();
		// detailForm.setHeight100();
		// detailForm.centerInPage();
		// detailForm.show();
		// }
		// });
		// }
		// });
		// IButton removeButton = new IButton("删除");
		// controlLayout.addMember(removeButton);
		// removeButton.setIcon("[SKIN]/actions/remove.png");
		// removeButton.addClickHandler(new ClickHandler() {
		// @Override
		// public void onClick(ClickEvent event) {
		// if (!resultGrid.anySelected()) {
		// SC.say("Please select a data to remove.");
		// }
		// final ListGridRecord selected = resultGrid.getSelectedRecord();
		// DBDataSource.callOperation("ST_MainProjectMajorEmployee", "delete",
		// selected.toMap(), new DSCallback() {
		// @Override
		// public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest)
		// {
		// if (dsResponse.getStatus() < 0) {
		// ClientUtil.displayErrorMessage(dsResponse);
		// } else {
		// int indexNum = resultGrid.getRowNum(selected);
		// resultGrid.removeData(selected);
		// resultGrid.selectSingleRecord(indexNum);
		// }
		// }
		// });
		// }
		// });

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
				detail.setTitle("签署人指定");
				detail.setWidth100();
				detail.setHeight100();
				MainProjectMajorEmployeeViewer detailForm = new MainProjectMajorEmployeeViewer();
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
		criteria.put("addtionalCondition", "order by specialty_id, relation");
		criteria.put("mainProjectId", getMainProjectId());
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSMainProjectMajorEmployee.getInstance();
	}

	public int getMainProjectId() {
		return mainProjectId;
	}

	public void setMainProjectId(int mainProjectId) {
		this.mainProjectId = mainProjectId;
	}

}
