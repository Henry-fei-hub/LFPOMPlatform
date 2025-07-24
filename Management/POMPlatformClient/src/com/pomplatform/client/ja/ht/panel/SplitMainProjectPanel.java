package com.pomplatform.client.ja.ht.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.util.ConfigUtil;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PaginationPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.ja.ht.datasource.DSMainProject;
import com.pomplatform.client.ja.ht.form.MainProjectSearchForm;
import com.pomplatform.client.ja.ht.form.MainProjectViewer;
import com.pomplatform.client.ja.ht.form.NewSformalcontractcccorForm;
import com.pomplatform.client.ja.ht.form.SformalcontractcccorNewForm;
import com.pomplatform.client.ja.ht.form.UpdateMainProjectForm;
import com.pomplatform.client.ja.ht.form.UpdateSformalcontractcccorForm;
import com.pomplatform.client.mainprojectinfo.panel.MmainprojectclientccmorPanel;
import com.pomplatform.client.newcontract.form.NewNewContractForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.web.bindery.autobean.vm.Configuration;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.security.auth.callback.ConfirmationCallback;

public class SplitMainProjectPanel extends AbstractSearchPanel
{

	private static Logger __LOGGER = Logger.getLogger("");
	
	private static String isBeforeAfter;
	
	private static ListGridField[] fields = new ListGridField[4];
	
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SplitMainProjectPanel cm = new SplitMainProjectPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "MainProject";
		}

	}

	@Override
	public void initComponents() {
		int idx = 0;
		fields[idx] = new ListGridField("infoCode");
		idx++;
		fields[idx] = new ListGridField("projectCode");
		idx++;
		fields[idx] = new ListGridField("projectName");
		idx++;
		fields[idx] = new ListGridField("businessType");
		idx++;
		fields[idx] = new ListGridField("projectBaseOn");
		idx++;
		fields[idx] = new ListGridField("hasOutQuotations");
		idx++;
		fields[idx] = new ListGridField("hasSplitPrice");
		resultGrid.setFields(fields);
		//标题从新写
        resultGrid.setHeaderHeight(60);  
		resultGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("立项信息", new String[] {"infoCode","projectCode","projectName","businessType","projectBaseOn","hasOutQuotations","hasSplitPrice"}),
	    });
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
				if(PermissionControl.getPermission(ERPPermissionStatic.CFJ_MANAGEMENT)){
					//先去判断是否有报价单，没有创建一个默认的
					ListGridRecord[] selected = resultGrid.getSelectedRecords();
	                final String infoCode = selected[0].getAttribute("infoCode");
	                final String projectCode = selected[0].getAttribute("projectCode");
	                boolean hasOutQuotations=selected[0].getAttributeAsBoolean("hasOutQuotations");
	                final String projectName=selected[0].getAttributeAsString("projectName");
	                if(hasOutQuotations){
	                	Map<String, Object> condition = new HashMap<>();
	    				condition.put("opt_type", "checkInternalAndExternal");
	    				condition.put("infoCode", infoCode);
	    				condition.put("quotationStatus", 1);
	    				
	    				DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", condition, new DSCallback() {
	    					@Override
	    					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
	    						if (dsResponse.getStatus() >= 0) {
	    							Map<String, Object> paramMap = new HashMap<String, Object>();
	    		    				paramMap.put("infoCode", infoCode);
	    		    				paramMap.put("allOrOne", false);
	    		    				PopupWindow pw = new PopupWindow("报价单拆分【"+projectName+"】");
	    		    				CustomAddQuotationMainPanel panel = new CustomAddQuotationMainPanel(infoCode,
	    		    						projectCode);
	    		    				pw.addItem(panel);
	    		    				pw.setWidth100();
	    		    				pw.setHeight100();
	    		    				pw.centerInPage();
	    		    				pw.show();
	    		    				pw.addCloseClickHandler(new CloseClickHandler() {
	    		    					@Override
	    		    					public void onCloseClick(CloseClickEvent event) {
	    		    						commonQuery();
	    		    					}
	    		    				});
	    						}else{
	    							ClientUtil.displayErrorMessage(dsResponse);
	    						}
	    					}
	    				});
	                }
				}
			}
		});
        
		IButton Button3 = PermissionControl.createPermissionButton("填写拆分价",
				ERPPermissionStatic.CFJ_ADD_BTN);
		controlLayout.addMember(Button3);
		Button3.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				//先去判断是否有报价单，没有创建一个默认的
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
                final String infoCode = selected[0].getAttribute("infoCode");
                final String projectCode = selected[0].getAttribute("projectCode");
                boolean hasOutQuotations=selected[0].getAttributeAsBoolean("hasOutQuotations");
                final String projectName=selected[0].getAttributeAsString("projectName");
                
                if(hasOutQuotations){
                	//去检验报价单的产值 和合同报价的总金额一致，只要有一个单子不一致则不能通过
                	
                	Map<String, Object> condition = new HashMap<>();
    				condition.put("opt_type", "checkInternalAndExternal");
    				condition.put("projectCode", projectCode);
//    				condition.put("infoCode", infoCode);
    				condition.put("quotationStatus", 1);
    				DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", condition, new DSCallback() {
    					@Override
    					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
    						if (dsResponse.getStatus() >= 0) {
    							Map<String, Object> paramMap = new HashMap<String, Object>();
    		    				paramMap.put("projectCode", projectCode);
//    		    				paramMap.put("infoCode", infoCode);
    		    				paramMap.put("allOrOne", false);
    		    				PopupWindow pw = new PopupWindow("报价单拆分【"+projectName+"】");
    		    				CustomAddQuotationMainPanel panel = new CustomAddQuotationMainPanel(infoCode,
    		    						projectCode);
    		    				pw.addItem(panel);
    		    				pw.setWidth100();
    		    				pw.setHeight100();
    		    				pw.centerInPage();
    		    				pw.show();
    		    				pw.addCloseClickHandler(new CloseClickHandler() {
    		    					@Override
    		    					public void onCloseClick(CloseClickEvent event) {
    		    						commonQuery();
    		    					}
    		    				});
    						}else{
    							ClientUtil.displayErrorMessage(dsResponse);
    						}
    					}
    				});
                }else{
                	SC.say("没有报价单，不能填写拆分价");
                }
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
				detail.setTitle("MainProject"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				MainProjectViewer detailForm = new MainProjectViewer();
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
		criteria.put("addtionalCondition", "order by main_project_id");
		criteria.put("is_before_after", isBeforeAfter);
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new MainProjectSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMainProject.getInstance();
	}
	@Override
    public int getSearchFormHeight() {
        return 60;
    }
}

