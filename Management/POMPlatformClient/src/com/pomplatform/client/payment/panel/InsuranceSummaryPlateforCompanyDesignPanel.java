package com.pomplatform.client.payment.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.Print;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.payment.datasource.DSFiveInsuranceOneGolds;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.DateUtil;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class InsuranceSummaryPlateforCompanyDesignPanel extends AbstractWizadPage {
    private final Logger logger = Logger.getLogger("");
  	
    //定义面板样式
    private final String layoutGroupStyle = "2px solid #555555;border-top-width:22px;border-radius:5px;";
    public final static String BORDER_STYLE = "2px solid #f2f2f2;border-radius:8px;";
    //定义主面板
    private HLayout mainLayout;
    private HLayout contentLayout;
    private HLayout buttonLayout;
    
    //公司数据汇总gird
    private DelicacyListGrid summaryGrid;
    
	public InsuranceSummaryPlateforCompanyDesignPanel() {
    	mainLayout = new HLayout(10);
    	mainLayout.setBackgroundColor("#f2f2f2");
    	mainLayout.setHeight100();
    	mainLayout.setWidth100();
    	mainLayout.setMembersMargin(0);
    	
    	contentLayout = new HLayout(10);
    	contentLayout.setWidth("95%");
    	contentLayout.setHeight100();
    	
    	summaryGrid = new DelicacyListGrid();
    	summaryGrid.setWidth100();
    	summaryGrid.setHeight100();
    	summaryGrid.setDataSource(DSFiveInsuranceOneGolds.getInstance());
    	summaryGrid.setCanEdit(false);
    	
    	summaryGrid.setHeaderHeight(60);
    	summaryGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("单位社会保险", new String[] {"unitPension","unitMedicalInsurance","unitLargeMedicalInsurance","unitInjuryInsurance","unitUnemploymentInsurance","unitGiveBirthInsurance"}),
		   new HeaderSpan("个人社会保险", new String[] {"personalPension","personalMedicalInsurance","personalLargeMedicalInsurance","personalSeriousIllInsurance","personalUnemploymentInsurance","personalHeating"})
	    });
    	int idx = 0;
    	ListGridField[] fields = new ListGridField[21];
    	fields[idx] = new ListGridField("plateId");
    	idx++;
    	fields[idx] = new ListGridField("year");
    	idx++;
    	fields[idx] = new ListGridField("month");
    	idx++;
    	fields[idx] = new ListGridField("totalFund");
    	idx++;
    	fields[idx] = new ListGridField("unitTotalFund");
    	idx++;
    	fields[idx] = new ListGridField("personalTotalFund");
    	idx++;
    	fields[idx] = new ListGridField("totalInsurance");
    	idx++;
    	fields[idx] = new ListGridField("unitTotalInsurance");
    	idx++;
    	fields[idx] = new ListGridField("personalTotalInsurance");
    	idx++;
    	fields[idx] = new ListGridField("unitPension");
    	idx++;
    	fields[idx] = new ListGridField("unitMedicalInsurance");
    	idx++;
    	fields[idx] = new ListGridField("unitLargeMedicalInsurance");
    	idx++;
    	fields[idx] = new ListGridField("unitInjuryInsurance");
    	idx++;
    	fields[idx] = new ListGridField("unitUnemploymentInsurance");
    	idx++;
    	fields[idx] = new ListGridField("unitGiveBirthInsurance");
    	idx++;
    	fields[idx] = new ListGridField("personalPension");
    	idx++;
    	fields[idx] = new ListGridField("personalMedicalInsurance");
    	idx++;
    	fields[idx] = new ListGridField("personalLargeMedicalInsurance");
    	idx++;
    	fields[idx] = new ListGridField("personalSeriousIllInsurance");
    	idx++;
    	fields[idx] = new ListGridField("personalUnemploymentInsurance");
    	idx++;
    	fields[idx] = new ListGridField("personalHeating");
    	summaryGrid.setFields(fields);
    	summaryGrid.setAutoFitFieldWidths(false);
    	summaryGrid.setShowGridSummary(true);
    	contentLayout.addMember(summaryGrid);
    	mainLayout.addMember(contentLayout);
    	
    	buttonLayout = new HLayout(10);
    	buttonLayout.setWidth("5%");
    	buttonLayout.setHeight100();
    	buttonLayout.setLayoutMargin(10);
    	buttonLayout.setLayoutTopMargin(20);
    	
    	IButton printButton = new IButton("打印");
    	buttonLayout.addMember(printButton);
		printButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> param = new HashMap<>(); 
				param.put("companyId",companyId);
				param.put("year",year);
				param.put("month",month);
				OnPrintFiveInsuranceOneGoldByPlatePanel printHtml = new OnPrintFiveInsuranceOneGoldByPlatePanel();
				//获取列表数据集
				Record[] records = summaryGrid.getRecords();
				if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
					printHtml.setRecords(records);
					printHtml.setPrintData(param);
					Print.it(printHtml.generatePrintHTML());
				}else{
					SC.say("提示","没有可打印的数据");
				}
			}
		});
		mainLayout.addMember(buttonLayout);
    	
    	addMember(mainLayout);
    }

    @Override
    public void startEdit() {
    }
    
    
    public void findPlateSum() {
    	Map<String,Object> param = new HashMap<>();
    	param.put("companyId", companyId);
    	param.put("year", year);
    	param.put("startMonth", month);
    	param.put("endMonth", month);
    	DBDataSource.callOperation("NQ_FiveinsuranceSummaryPlate", param, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					summaryGrid.setData(dsResponse.getData());
				}
			}
		});
    }
    
    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        Map values = __form.getValues();
        return values;
    }

    public String getActionName() {
        // 需要根据实际业务修改
        return "";
    }
    
    private int year;
    private int month;
    private int companyId;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
}
