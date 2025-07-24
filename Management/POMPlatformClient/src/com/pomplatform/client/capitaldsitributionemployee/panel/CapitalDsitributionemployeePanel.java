package com.pomplatform.client.capitaldsitributionemployee.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.capitaldsitributionemployee.datasource.DSCapitalDsitributionemployee;
import com.pomplatform.client.capitaldsitributionemployee.form.CapitalDsitributionemployeeSearchForm;
import com.pomplatform.client.employeeaccountrecordeeppccmmpebor.panel.MemployeeaccountrecordeeppccmmpeborPanel;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class CapitalDsitributionemployeePanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private MemployeeaccountrecordeeppccmmpeborPanel cpPanel;
	
	private CapitalDsitributionemployeeSearchForm form;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			CapitalDsitributionemployeePanel cm = new CapitalDsitributionemployeePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "CapitalDsitributionemployee";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
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
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.setIcon("[SKIN]/actions/view.png");
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				getCpPanel().setEmployeeId(resultGrid.getSelectedRecord().getAttributeAsInt("employeeId"));
				if(null != form.getField("plateId").getValue()){
					getCpPanel().setPlateId(resultGrid.getSelectedRecord().getAttributeAsInt("plateId"));
				}
				getCpPanel().commonQuery();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by employee_id");
		if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.EMPLOYEE_JF_HK_VIEW_ALL_DATA)){
			
		} else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.EMPLOYEE_JF_HK_VIEW_PLATE_DATA)){
			criteria.put("plateId", ClientUtil.getPlateId());
		} else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.EMPLOYEE_JF_HK_VIEW_OWN_DATA)){
			criteria.put("employeeId", ClientUtil.getEmployeeId());
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		form = new CapitalDsitributionemployeeSearchForm();
		if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.EMPLOYEE_JF_HK_VIEW_ALL_DATA)){
			form.getField("plateId").setValue(ClientUtil.getPlateId());
		} else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.EMPLOYEE_JF_HK_VIEW_PLATE_DATA)){
			form.getField("plateId").setDisabled(true);
			form.getField("plateId").setValue(ClientUtil.getPlateId());
		} else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.EMPLOYEE_JF_HK_VIEW_OWN_DATA)){
			return null;
		}
		return form;
	}

	@Override
	public DataSource getDataSource() {
		return DSCapitalDsitributionemployee.getInstance();
	}

	public MemployeeaccountrecordeeppccmmpeborPanel getCpPanel() {
		return cpPanel;
	}

	public void setCpPanel(MemployeeaccountrecordeeppccmmpeborPanel cpPanel) {
		this.cpPanel = cpPanel;
	}

}
