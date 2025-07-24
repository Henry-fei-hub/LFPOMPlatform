package com.pomplatform.client.employeemoneymanagespeemmepemmor.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.i18n.client.NumberFormat;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource.DSMemployeemoneymanagespeemmepemmor;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PersonnalMoneyManagePanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private Integer employeeId;
	
	public static int showStatus = 1;
	
	private List<Map> keyValues = new ArrayList<>();

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			PersonnalMoneyManagePanel cm = new PersonnalMoneyManagePanel();
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
		__needControl = false;
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
				NumberFormat nf = NumberFormat.getFormat("#,###,###,###,###,##0.00");
				record.setAttribute("balance", balance.toString());
				return nf.format(balance);
			}
		});
		index ++;
		fields[index] = new ListGridField("mType");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("completeTime");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("equivalentNumber");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("businessName");
		fields[index].setShowGridSummary(false);
		resultGrid.setFields(fields);
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
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
				Record __record = resultGrid.getSelectedRecords()[0];
				if(null != __record){
					if(ClientUtil.checkAndGetIntValue(__record.getAttribute("processId")) > 0){
						ViewProcessWindow Reimbursement = new ViewProcessWindow();
						Reimbursement.setWidth("80%");
						Reimbursement.setHeight("80%");
						Reimbursement.setLayoutMode(0);
						Reimbursement.setInstanceData(__record);
						Reimbursement.initComponents();
						Reimbursement.setTitle(ClientUtil.getProcessTypeName(__record));
						Reimbursement.show();
					}
				}
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

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

}
