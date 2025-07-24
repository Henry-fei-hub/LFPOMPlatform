package com.pomplatform.client.stagemodel.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.stagemodel.datasource.DSContractStageAudit;
import com.pomplatform.client.stagemodel.form.ContractStageAuditSearchForm;
import com.pomplatform.client.stagemodel.form.ContractStageAuditViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class ContractStageAuditPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ContractStageAuditPanel cm = new ContractStageAuditPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ContractStageAudit";
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

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton auditButton = new IButton("审批");
		auditButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(auditButton);
		
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
				detail.setTitle("合同小节点审批"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ContractStageAuditViewer detailForm = new ContractStageAuditViewer();
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
		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("addtionalCondition", "order by contract_stage_model_id");
		List<Map<String,Object>> keyvalues = new ArrayList<>();
		if (!BaseHelpUtils.isNullOrEmpty(criteria.get("auditStatus"))) {
			String value = BaseHelpUtils.getString(criteria.get("auditStatus"));
			if(value.equals(ContractStageAuditSearchForm.STATUS_1)){
				Map<String, Object> kv = new HashMap<>();
				kv.put("key", "a.need_manager_audit = true and a.manager_id");
				kv.put("value", "a.manager_audit_date is null and a.need_manager_audit = true and a.manager_id");
				keyvalues.add(kv);
				Map<String, Object> kv2 = new HashMap<>();
				kv2.put("key", "a.need_design_director_audit = true and a.design_director_id");
				kv2.put("value", "a.design_director_audit_date is null and a.need_design_director_audit = true and a.design_director_id");
				keyvalues.add(kv2);
			}else if(value.equals(ContractStageAuditSearchForm.STATUS_2)){
				Map<String, Object> kv = new HashMap<>();
				kv.put("key", "a.need_manager_audit = true and a.manager_id");
				kv.put("value", "a.manager_audit_date is not null and a.need_manager_audit = true and a.manager_id");
				keyvalues.add(kv);
				Map<String, Object> kv2 = new HashMap<>();
				kv2.put("key", "a.need_design_director_audit = true and a.design_director_id");
				kv2.put("value", "a.design_director_audit_date is not null and a.need_design_director_audit = true and a.design_director_id");
				keyvalues.add(kv2);
			}
		}
        if(!BaseHelpUtils.isNullOrEmpty(keyvalues)){
        	criteria.put("keyValues", keyvalues);
        }
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ContractStageAuditSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSContractStageAudit.getInstance();
	}


}

