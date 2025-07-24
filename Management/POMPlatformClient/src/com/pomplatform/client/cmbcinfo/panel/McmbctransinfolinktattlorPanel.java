package com.pomplatform.client.cmbcinfo.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.cmbcinfo.datasource.DSMcmbctransinfolinktattlor;
import com.pomplatform.client.cmbcinfo.form.McmbctransinfolinktattlorSearchForm;
import com.pomplatform.client.cmbcinfo.form.McmbctransinfolinktattlorViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class McmbctransinfolinktattlorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private McapitalbccoccmsssoooblpommmmlorPanel capitalPanel;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			McmbctransinfolinktattlorPanel cm = new McmbctransinfolinktattlorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mcmbctransinfolinktattlor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}
	
	@Override
	public Canvas generateHDataCanvas() {
        resultGrid = new DelicacyListGrid() {  
            @Override  
            protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {  
            	if(null != record.getAttribute("linkNum") && record.getAttributeAsInt("linkNum") > 0){
            		 return "color: #ABABAB;";
            	}else {  
                    return super.getCellCSSText(record, rowNum, colNum);  
                }  
            }  
        };  
        resultGrid.setDataSource(getDataSource());
        resultGrid.setWidth100();
        resultGrid.setHeight100();
        return resultGrid;
    }

	@Override
	public void initComponents() {
		IButton operation1Button = new IButton("查看绑定");
		controlLayout.addMember(operation1Button);
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		
		IButton transToCapitalBtn = new IButton("生成流水");
		controlLayout.addMember(transToCapitalBtn);
		transToCapitalBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					Record [] records = resultGrid.getSelectedRecords();
					boolean flag = true;
					for (Record record : records) {
						if(null != record.getAttribute("linkNum") && record.getAttributeAsInt("linkNum") > 0){
							flag = false;
							break;
						}
					}
					if(flag){
						//弹出转成流水的面板
						PopupWindow pw = new PopupWindow();
						pw.setHeight100();
						pw.setWidth100();
						pw.setTitle("账单流水生成");
						TransinfoToCapitalPanel panel = new TransinfoToCapitalPanel(records);
						panel.setFatherWindow(pw);
						panel.addDataEditedHandler(new DataEditedHandler() {
							
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
								getCapitalPanel().commonQuery();
							}
						});
						pw.addItem(panel);
						pw.centerInPage();
						pw.show();
					}else{
						SC.say("选择的数据中包含了已经绑定了的数据，请重新选择！");
					}
				}else{
					SC.say("请选择需要生成流水的数据");
				}
				
			}
		});
		IButton autoBtn = new IButton("自动匹配");
		controlLayout.addMember(autoBtn);
		autoBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				SC.ask("确定自动匹配?", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(null != value && value){
							Map<String, Object> condition = generateCriteria();
							condition.put("employeeId", ClientUtil.getEmployeeId());
							condition.put("opt_type", "autoBindTransAndCapitals");
							condition.put("linkType", 1);
							condition.put("transType", 1);
							DBDataSource.callOperation("EP_BankCapitalCheckProcess", condition, new DSCallback() {
								
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() > 0){
										commonQuery();
										SC.say("自动匹配成功");
									}
									
								}
							});
						}
						
					}
				});
				
				
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
				
				ListGridRecord selectedRecord = resultGrid.getSelectedRecord();
				if(null != selectedRecord.getAttribute("linkNum") && selectedRecord.getAttributeAsInt("linkNum") > 0){
					PopupWindow pw = new PopupWindow();
					pw.setWidth("80%");
					pw.setHeight("80%");
					pw.setTitle("绑定详情");
					int businessId = selectedRecord.getAttributeAsInt("cmbcTransInfoId");
					ViewReceiveBindDetailPanel panel = new ViewReceiveBindDetailPanel(1);
					panel.loadData(businessId, 1, 1);
					panel.setFatherWindow(pw);
					panel.addDataEditedHandler(new DataEditedHandler() {
						
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
							getCapitalPanel().commonQuery();
							
						}
					});
					pw.addItem(panel);
					pw.centerInPage();
					pw.show();
				}else{
					GenericViewWindow detail = new GenericViewWindow();
					detail.setTitle("详情");
					detail.setWidth100();
					detail.setHeight100();
					McmbctransinfolinktattlorViewer detailForm = new McmbctransinfolinktattlorViewer();
					detailForm.setParentSearchForm(searchForm);
					detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
					detailForm.initComponents();
					detailForm.viewSelectedData(resultGrid);
					detail.setContent(detailForm);
					detail.centerInPage();
					detail.show();
				}
				
				

			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by cmbc_trans_info_id");
		criteria.put("addtionalCondition", "order by company_record_id");
		criteria.put("transType", 1);
		criteria.put("linkType", 1);
		if(null != criteria.get("isLink")){
			boolean isLink = (boolean)criteria.get("isLink");
			if(isLink){
				criteria.put("linkNum", 0);
			}else{
				List<Map<String, Object>> keyValues = new ArrayList<>();
				Map<String, Object> kv = new HashMap<>();
				kv.put("key", "link_num > ?");
				kv.put("value", "link_num > ? and link_num isnull");
				keyValues.add(kv);
				criteria.put("keyValues", keyValues);
			}
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new McmbctransinfolinktattlorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMcmbctransinfolinktattlor.getInstance();
	}

	public boolean checkSelectData(){
		return resultGrid.anySelected();
	}
	
	public String getSelectIds(){
		String ids = "";
		Record [] records = resultGrid.getSelectedRecords();
		for (int i = 0; i < records.length; i++) {
			if(i != 0){
				ids += ",";
			}
			ids += records[i].getAttribute("cmbcTransInfoId");
		}
		return ids;
	}

	public McapitalbccoccmsssoooblpommmmlorPanel getCapitalPanel() {
		return capitalPanel;
	}

	public void setCapitalPanel(McapitalbccoccmsssoooblpommmmlorPanel capitalPanel) {
		this.capitalPanel = capitalPanel;
	}
	
}
