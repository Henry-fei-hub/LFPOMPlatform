package com.pomplatform.client.employeemoneymanagespeemmepemmor.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.i18n.client.NumberFormat;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource.DSMemployeemoneymanagespeemmepemmor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class MemployeemoneymanagespeemmepemmorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	public static Integer employeeId;
	
	public static int showStatus = 1;
	
	private List<Map> keyValues = new ArrayList<>();

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			MemployeemoneymanagespeemmepemmorPanel cm = new MemployeemoneymanagespeemmepemmorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Memployeemoneymanagespeemmepemmor";
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
            		if(!BaseHelpUtils.isNullOrEmpty(record.getAttribute("equivalentNumber"))){
            			 return "color: #ABABAB;";
            		}
            		 if (record.getAttributeAsInt("mType") == 2 || record.getAttributeAsInt("mType") == 3) {  
            			 return "color: #5DD031;";
                     } else {  
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
		int index = 0;
		ListGridField [] fields = new ListGridField[7];
		fields[index] = new ListGridField("employeeId");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("money");
		fields[index].setShowGridSummary(true);
		index ++;
		fields[index] = new ListGridField("balance", "余额");
		fields[index].setFormat("#,###,###,###,###,##0.00");
		fields[index].setAlign(Alignment.RIGHT);
		fields[index].setShowGridSummary(true);
		fields[index].setCellFormatter(new CellFormatter() {
			
			@Override
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
//				int mType = record.getAttributeAsInt("mType");
				BigDecimal topBalance = BigDecimal.ZERO;
				BigDecimal balance = BigDecimal.ZERO;
				BigDecimal money = new BigDecimal(record.getAttribute("money"));
				Record tmpR = null;
				if(rowNum > 0){
					tmpR = resultGrid.getRecord(rowNum - 1);
					topBalance = new BigDecimal(tmpR.getAttribute("balance"));
					
				}
				balance = topBalance.add(money);
//				switch (mType) {
//				case 1://借款
//					balance = topBalance.subtract(money);
//					break;
//				case 2:
//				case 3:
//				case 4://还款
//					balance = topBalance.add(money);
//					break;
//				default:
//					break;
//				}
				NumberFormat nf = NumberFormat.getFormat("#,###,###,###,###,##0.00");
				record.setAttribute("balance", balance.toString());
				return nf.format(balance);
			}
		});
		index ++;
//		fields[index] = new ListGridField("returnMoney");
//		index ++;
		fields[index] = new ListGridField("mType");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("completeTime");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("equivalentNumber");
		fields[index].setShowGridSummary(false);
//		fields[index].setCellFormatter(new CellFormatter() {  
//
//			@Override
//			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
//				if (value == null) {
//					
//					record.setCanSelect(false);
//					return null;
//				};
//				return value.toString();  
//			}  
//        });  
		index ++;
		fields[index] = new ListGridField("businessName");
		fields[index].setShowGridSummary(false);
		// IButton refreshButton = new IButton("刷新");
		// controlLayout.addMember(refreshButton);
		// refreshButton.setIcon("[SKIN]/actions/refresh.png");
		// refreshButton.addClickHandler(new ClickHandler() {
		// @Override
		// public void onClick(ClickEvent event) {
		// commonQuery();
		// }
		// });
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		resultGrid.setFields(fields);
		resultGrid.setSelectionType(SelectionStyle.SIMPLE);
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton operation1Button = PermissionControl.createPermissionButton("查看详情", ERPPermissionStatic.CHECK_DETAIL);
		controlLayout.addMember(operation1Button);
		// operation1Button.setIcon("[SKIN]/actions/view.png");
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		
		IButton enBtn = PermissionControl.createPermissionButton("进行对冲", ERPPermissionStatic.EC_BIND);
		controlLayout.addMember(enBtn);
		enBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					SC.ask("确定进行对冲", new BooleanCallback() {
						
						@Override
						public void execute(Boolean value) {
							Record [] records = resultGrid.getSelectedRecords();
							for (int i = 0; i < records.length; i++) {
								if(!BaseHelpUtils.isNullOrEmpty(records[i].getAttribute("equivalentNumber"))){
									SC.say("请去除没有选择的对冲");
									return;
								}
							}
							Map params = new HashMap<>();
							params.put("opt_type", "doEquivalentNumber");
							params.put("list", records);
							DBDataSource.callOperation("EP_CustomCapitalEquivalentNumberProcess", params, new DSCallback() {
								
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									commonQuery();
								}
							});
							
						}
					});
				}else{
					SC.say("选择需要进行对冲的数据");
				}
				
			}
		});
		IButton unbindBtn = PermissionControl.createPermissionButton("取消对冲", ERPPermissionStatic.EC_UNBIND);
		controlLayout.addMember(unbindBtn);
		unbindBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected() && resultGrid.getSelectedRecords().length == 1){
					SC.ask("确定取消对冲", new BooleanCallback() {
						
						@Override
						public void execute(Boolean value) {
							Record record = resultGrid.getSelectedRecord();
							if(!BaseHelpUtils.isNullOrEmpty(record.getAttribute("equivalentNumber"))){
								Map params = new HashMap<>();
								params.put("opt_type", "undoEquivalentNumber");
								params.put("equivalentNumber", record.getAttribute("equivalentNumber"));
								DBDataSource.callOperation("EP_CustomCapitalEquivalentNumberProcess", params, new DSCallback() {
									
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										commonQuery();
									}
								});
							}
							
						}
					});
				}else{
					SC.say("请选择需要取消对冲的一条数据");
				}
				
			}
		});
		IButton hideBtn = PermissionControl.createPermissionButton("隐藏已冲销", ERPPermissionStatic.EC_HIDE_BIND);
		controlLayout.addMember(hideBtn);
		hideBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				keyValues = new ArrayList<>();
				commonQuery();
			}
		});
		IButton showStatusTwoBtn = PermissionControl.createPermissionButton("完成冲销显示", ERPPermissionStatic.EC_SHOW_BIND);
		controlLayout.addMember(showStatusTwoBtn);
		showStatusTwoBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				keyValues = new ArrayList<>();
				Map<String, String> kv = new HashMap<>();
				kv.put("key", "WHERE ep.equivalent_number ISNULL OR ep.equivalent_number = ''");
				kv.put("value", "");
				keyValues.add(kv);
				commonQuery();
				
			}
		});
		keyValues = new ArrayList<>();
		Map<String, String> kv = new HashMap<>();
		kv.put("key", "WHERE ep.equivalent_number ISNULL OR ep.equivalent_number = ''");
		kv.put("value", "");
		keyValues.add(kv);
//		commonQuery();
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
				Record __record = resultGrid.getSelectedRecord();
				ViewProcessWindow Reimbursement = new ViewProcessWindow();
				Reimbursement.setWidth("80%");
				Reimbursement.setHeight("80%");
				Reimbursement.setLayoutMode(0);
				Reimbursement.setInstanceData(__record);
				Reimbursement.initComponents();
				Reimbursement.setTitle(ClientUtil.getProcessTypeName(__record));
				Reimbursement.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by process_instance_id");
		criteria.put("employeeId", employeeId);
		criteria.put("processStatus", 3);
		criteria.put("keyValues", keyValues);
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		// return new MemployeemoneymanagespeemmepemmorSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSMemployeemoneymanagespeemmepemmor.getInstance();
	}

	public static Integer getEmployeeId() {
		return employeeId;
	}

	public static void setEmployeeId(Integer employeeId) {
		MemployeemoneymanagespeemmepemmorPanel.employeeId = employeeId;
	}

}
