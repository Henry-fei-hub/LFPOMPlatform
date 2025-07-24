package com.pomplatform.client.payment.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.payment.datasource.DSFiveInsuranceOneGolds;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.DateUtil;
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

public class InsuranceSummaryPlateDesignPanel extends AbstractWizadPage {
    private final Logger logger = Logger.getLogger("");
  	
    //定义面板样式
    private final String layoutGroupStyle = "2px solid #555555;border-top-width:22px;border-radius:5px;";
    public final static String BORDER_STYLE = "2px solid #f2f2f2;border-radius:8px;";
    //定义主面板
    private VLayout mainLayout;
    //定义top层，搜索栏
    private HLayout topLayout;
    //内容展示grid
    private HLayout contentLayout;
    
    //公司数据汇总gird
    private DelicacyListGrid summaryGrid;
    
    private DynamicForm __infoForm; 
    private SelectItem plateItem;
    private SelectItem yearItem;
    private SelectItem startMonthItem;
    private SelectItem endMonthItem;
    private IButton searchIbutton;
    private IButton resetIbutton;
    
	public InsuranceSummaryPlateDesignPanel() {
    	mainLayout = new VLayout(10);
    	mainLayout.setBackgroundColor("#FFF");
    	mainLayout.setHeight100();
    	mainLayout.setWidth100();
    	mainLayout.setMembersMargin(0);
    	
    	topLayout = new HLayout(10);
    	topLayout.setWidth100();
    	topLayout.setHeight("10%");
    	topLayout.setBorder(BORDER_STYLE);
    	topLayout.setLayoutTopMargin(10);
    	topLayout.setBackgroundColor("#f2f2f2");
    	
    	plateItem = new SelectItem("plateId","业务部门");
    	plateItem.setWidth(280);
    	plateItem.setHeight(26);
    	plateItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
    	
    	Date currentDate = new Date();
    	yearItem = new SelectItem("year","年份");
    	yearItem.setWidth(280);
    	yearItem.setHeight(26);
    	yearItem.setDefaultValue(currentDate.getYear()+1900);
    	yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
    	
    	startMonthItem = new SelectItem("startMonth","开始月份");
    	startMonthItem.setWidth(280);
    	startMonthItem.setHeight(26);
    	startMonthItem.setDefaultValue(currentDate.getMonth()+1);
    	startMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
    	
    	endMonthItem = new SelectItem("endMonth","截止月份");
    	endMonthItem.setWidth(280);
    	endMonthItem.setHeight(26);
    	endMonthItem.setDefaultValue(currentDate.getMonth()+2);
    	endMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
    	
    	__infoForm = new DynamicForm();
    	__infoForm.setItems(plateItem,yearItem,startMonthItem,endMonthItem);
    	__infoForm.setNumCols(8);
    	__infoForm.setWidth("80%");
    	__infoForm.setHeight100();
    	ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
    	topLayout.addMember(__infoForm);
    	
    	searchIbutton = new IButton("搜索");
    	searchIbutton.setHeight(26);
    	HLayout vbtn=new HLayout(10);
    	vbtn.setLayoutTopMargin(20);
        vbtn.addMember(searchIbutton);
    	searchIbutton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				startEdit();
			}
		});
    	
    	resetIbutton = new IButton("重置");
    	resetIbutton.setHeight(26);
    	vbtn.addMember(resetIbutton);
    	topLayout.addMember(vbtn);
    	resetIbutton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				__infoForm.editNewRecord();
			}
		});
    	
    	contentLayout = new HLayout(10);
    	contentLayout.setWidth100();
    	contentLayout.setLayoutTopMargin(20);
    	contentLayout.setHeight("90%");
    	
    	summaryGrid = new DelicacyListGrid();
    	summaryGrid.setWidth100();
    	summaryGrid.setHeight100();
    	summaryGrid.setDataSource(DSFiveInsuranceOneGolds.getInstance());
    	summaryGrid.setCanEdit(false);
    	contentLayout.addMember(summaryGrid);
    	
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
    	mainLayout.addMember(topLayout);
    	mainLayout.addMember(contentLayout);
    	addMember(mainLayout);
    }

    @Override
    public void startEdit() {
    	Map<String,Object> param = new HashMap<>();
    	if(!BaseHelpUtils.isNullOrEmpty(plateItem.getValue())){
    		param.put("plateId", plateItem.getValue());
    	}
    	if(!BaseHelpUtils.isNullOrEmpty(yearItem.getValue())){
    		param.put("year", yearItem.getValue());
    	}
    	if(!BaseHelpUtils.isNullOrEmpty(startMonthItem.getValue())){
    		param.put("startMonth", startMonthItem.getValue());
    	}
    	if(!BaseHelpUtils.isNullOrEmpty(endMonthItem.getValue())){
    		param.put("endMonth", endMonthItem.getValue());
    	}
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
    
}
