package com.pomplatform.client.manageprojectbyproject.form;

import java.util.ArrayList;
import java.util.List;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.designer.panel.DesignerProjectPanel;
import com.pomplatform.client.manageprojectbyproject.datasource.DSManageProjectByProject;
import com.pomplatform.client.manageprojectemployee.datasource.DSManageProjectEmployee;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ManageProjectByProjectViewer extends AbstractDetailViewer
{

	private final DelicacyListGrid projectEmployeesGrid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;


	public ManageProjectByProjectViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
		projectEmployeesGrid.setDataSource(DSManageProjectEmployee.getInstance());
		projectEmployeesGrid.setShowRowNumbers(true);
		projectEmployeesGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				ListGridRecord[] selected = projectEmployeesGrid.getSelectedRecords();
				String employeeId = selected[0].getAttribute("employeeId");
				String employeeName = KeyValueManager.getValueMap("employees").get(employeeId);
				PopupWindow pw = new PopupWindow();
				DesignerProjectPanel myselfProject = new DesignerProjectPanel();
				myselfProject.setEmployeeId(ClientUtil.checkAndGetIntValue(employeeId));
				pw.addItem(myselfProject.getViewPanel());
				pw.setTitle(employeeName + "的管理项目");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
				myselfProject.commonQuery();
			}
		});
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "管理项目详情";
	}

	@Override
	public int getGroupCount() {
		return 0;
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<GroupColumn>();
		return gcs;
	}

	@Override
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
		Record selected = grid.getSelectedRecord();
		Object val;
		java.util.Map condition = null;
		java.util.Map parentSearch = __parentSearchForm == null ? new java.util.HashMap()
				: __parentSearchForm.getValues();
		condition = new java.util.HashMap();
		String manageProjectId = selected.getAttributeAsString("manageProjectId");
		condition.put("manageProjectId", manageProjectId);
		DBDataSource.callOperation("NQ_ManageProjectEmployee", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					projectEmployeesGrid.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSManageProjectByProject.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(projectEmployeesGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("项目成员");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

