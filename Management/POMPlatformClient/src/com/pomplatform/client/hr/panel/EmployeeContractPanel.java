package com.pomplatform.client.hr.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.company.panel.CompanyLoanPanel;
import com.pomplatform.client.employeerescord.datasource.DSEmployee;
import com.pomplatform.client.hr.form.EmployeeContractSearchForm;
import com.pomplatform.client.project.datasource.DSTalentsMinimumArrangement;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class EmployeeContractPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			EmployeeContractPanel cm = new EmployeeContractPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "EmployeeContractPanel";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		resultGrid.setCanEdit(true);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		ListGridField[] fields = new ListGridField[7];
		int idx = 0;
		fields[idx] = new ListGridField("employeeId");
		fields[idx].setHidden(true);;
		idx ++;
		fields[idx] = new ListGridField("employeeNo");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("employeeName");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("departmentId","所属部门");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("plateId","业务部门");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("status");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("onboardDate");
		fields[idx].setCanEdit(false);
		resultGrid.setFields(fields);
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setFilterOnKeypress(true);

		IButton detailButton = new IButton("查看详情");
		controlLayout.addMember(detailButton);
		detailButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		commonQuery();
	}

	public void showDetail(){
		if (!resultGrid.anySelected()) {
            SC.say("请选择一条数据");
            return;
        }
		Map<String,Object> param = new HashMap<>();
		ListGridRecord record = resultGrid.getSelectedRecord();
		int employeeId = record.getAttributeAsInt("employeeId");
		param.put("employeeId", employeeId);
		param.put("employeeNo", record.getAttribute("employeeNo"));
		param.put("employeeName", record.getAttribute("employeeName"));
		param.put("departmentId", record.getAttribute("departmentId"));
		param.put("status", record.getAttribute("status"));
		param.put("onboardDate", record.getAttributeAsDate("onboardDate"));
		param.put("plateId", record.getAttribute("plateId"));
		final PopupWindow popupWindow = new PopupWindow("员工合同详情");
		popupWindow.setWidth("40%");
		popupWindow.setHeight("50%");
		popupWindow.centerInPage();
		EmployeeContractDetailPanel detail = new EmployeeContractDetailPanel();
		detail.initComponents(employeeId);
		detail.load(param);
		popupWindow.addItem(detail);
		popupWindow.addCloseClickHandler(new CloseClickHandler() {
			@Override
			public void onCloseClick(CloseClickEvent event) {
				popupWindow.destroy();
			}
		});
		detail.setParentWindow(popupWindow);
		popupWindow.centerInPage();
		popupWindow.show();
	}
	
	@Override
	public SearchForm generateSearchForm() {
		return new EmployeeContractSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSEmployee.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

}

