package com.pomplatform.client.report.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.BasicPermissionStatic;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.report.datasource.DSReportOfResignationApplyEmp;
import com.pomplatform.client.report.datasource.DSReportOfTransferEmp;
import com.pomplatform.client.report.datasource.DSReportPayChangeOnboardEmp;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ReportOfSalaryChangeNoticeForm extends AbstractWizadPage {
    private final Logger __logger = Logger.getLogger("");
    private final String layoutGroupStyle = "2px solid #555555;border-top-width:22px;border-radius:5px;";
	public final static String BORDER_STYLE = "2px solid #f2f2f2;border-radius:8px;";
    private DynamicForm searchForm;
    private DelicacyListGrid oneGrid;
    private DelicacyListGrid twoGrid;
    private DelicacyListGrid threeGrid;
    private DelicacyListGrid fourGrid;
    private DelicacyListGrid fiveGrid;
    
    private SelectItem plateIdItem;
    private SelectItem yearItem;
    private SelectItem monthItem;
    
    private final IButton searchButton;
    private final IButton refreshButton;
  
	private VLayout mainLayout;
	private HLayout searchLayout;
	private HLayout itemsLayout;
	private HLayout buttonLayout;
	private VLayout contentLayout;
	private HLayout oneLayout;
	private HLayout twoLayout;
	private HLayout threeLayout;
	private HLayout fourLayout;
	private HLayout fiveLayout;
	
	public ReportOfSalaryChangeNoticeForm() {
    	
		mainLayout = new VLayout(10);
		mainLayout.setWidth100();
		mainLayout.setHeight100();
    	
		searchLayout = new HLayout(10);
		searchLayout.setWidth100();
		searchLayout.setHeight("5%");
		searchLayout.setBackgroundColor("#e2e2e2");
		
		itemsLayout = new HLayout(10);
		itemsLayout.setWidth("80%");
		itemsLayout.setHeight100();
		
        plateIdItem = new SelectItem("plateId", "业务部门");
        plateIdItem.setWidth("*");
        plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
        //根据登录人的权限设置可查看的部门数据
  		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.SALARY_CHANGE_NOTICE_CHECK_ALLDATA)) {
  			plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
  		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.SALARY_CHANGE_NOTICE_CHECK_SELFDATA)){
  			String plateIds = PomPlatformClientUtil.getRolePlateId();
  			String[] arr = plateIds.split(",");
  			if(arr.length > 0){
  				plateIdItem.setDefaultValue(arr[0]);
  			}
  			RoleDefinition.setPlateItemValueMap(plateIdItem,plateIds);
  		}
        
        Date currentDate = new Date();
        yearItem = new SelectItem("year","年份");
        yearItem.setDefaultValue(currentDate.getYear()+1900);
        yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
        yearItem.setWidth("*");
        
        monthItem = new SelectItem("month","月份");
        monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
        monthItem.setDefaultValue(currentDate.getMonth()+1);
        monthItem.setWidth("*");
        
        searchForm = new DynamicForm();
        searchForm.setWidth100();
        searchForm.setHeight100();
        searchForm.setNumCols(6);
        searchForm.setMargin(10);
        searchForm.setItems(plateIdItem,yearItem,monthItem);
        itemsLayout.addMember(searchForm);
    	
        searchButton = new IButton("搜索");
        refreshButton = new IButton("重置");
        //搜索按钮
        searchButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				startEdit();
			}
		});
        
        //重置按钮
        refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				searchForm.editNewRecord();
			}
		});
        
        buttonLayout = new HLayout(10);
        buttonLayout.setWidth("20%");
        buttonLayout.setHeight100();
        buttonLayout.setLayoutTopMargin(10);
        buttonLayout.addMember(searchButton);
        buttonLayout.addMember(refreshButton);
        
        searchLayout.addMember(itemsLayout);
        searchLayout.addMember(buttonLayout);
        mainLayout.addMember(searchLayout);
        
        contentLayout = new VLayout(10);
        contentLayout.setWidth100();
        contentLayout.setHeight("95%");
        contentLayout.setMembersMargin(30);
        
        oneLayout = new HLayout(10);
        oneLayout.setMinHeight(300);
        oneLayout.setWidth100();
        oneLayout.setIsGroup(true);
        oneLayout.setGroupTitle("新入职员工");
        oneLayout.setGroupBorderCSS(layoutGroupStyle);
        oneLayout.setGroupLabelBackgroundColor("#555555");
        oneLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
		
		oneGrid = new DelicacyListGrid();
		oneGrid.setShowRowNumbers(true);
		oneGrid.setAutoFitFieldWidths(false);   
		oneGrid.setDataSource(DSReportPayChangeOnboardEmp.getInstance());
		oneLayout.addMember(oneGrid);
		contentLayout.addMember(oneLayout);
        
		twoLayout = new HLayout(10);
		twoLayout.setMinHeight(300);
		twoLayout.setWidth100();
		twoLayout.setIsGroup(true);
		twoLayout.setGroupTitle("转正员工");
		twoLayout.setGroupBorderCSS(layoutGroupStyle);
		twoLayout.setGroupLabelBackgroundColor("#555555");
		twoLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
		
		twoGrid = new DelicacyListGrid();
		twoGrid.setShowRowNumbers(true);
		twoGrid.setAutoFitFieldWidths(false);  
		
		int index = 0;
        ListGridField [] fields = new ListGridField[9];
		fields[index] = new ListGridField("employeeNo", "工号");
		index++;
		fields[index] = new ListGridField("employeeName", "姓名");
		index++;
		fields[index] = new ListGridField("gender", "性别");
		index++;
		fields[index] = new ListGridField("plateId", "业务部门");
		index++;
		fields[index] = new ListGridField("departmentId", "所属部门");
		index++;
		fields[index] = new ListGridField("onboardDate", "入职日期");
		index++;
		fields[index] = new ListGridField("positiveDate", "转正日期");
		index++;
		fields[index] = new ListGridField("tryTimePay", "试用工资");
		index++;
		fields[index] = new ListGridField("positivePay", "转正工资");
		twoGrid.setFields(fields);
//		twoGrid.setDataSource(DSReportPayChangeOnboardEmp.getInstance());
		twoLayout.addMember(twoGrid);
		contentLayout.addMember(twoLayout);
		
		threeLayout = new HLayout(10);
		threeLayout.setMinHeight(300);
		threeLayout.setWidth100();
		threeLayout.setIsGroup(true);
		threeLayout.setGroupTitle("调转部门");
		threeLayout.setGroupBorderCSS(layoutGroupStyle);
		threeLayout.setGroupLabelBackgroundColor("#555555");
		threeLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
		
		
		threeGrid = new DelicacyListGrid();
		threeGrid.setShowRowNumbers(true);
		threeGrid.setAutoFitFieldWidths(false);  
		threeGrid.setDataSource(DSReportOfTransferEmp.getInstance());
		threeGrid.setHeaderHeight(60);
		threeGrid.setHeaderSpans(new HeaderSpan[] {
				   new HeaderSpan("调出部门", new String[] {"oldPlateId","oldDepartmentId"}),
				   new HeaderSpan("调入部门", new String[] {"newPlateId","newDepartmentId"}),
			    });
		threeLayout.addMember(threeGrid);
		contentLayout.addMember(threeLayout);
		
		fourLayout = new HLayout(10);
		fourLayout.setMinHeight(300);
		fourLayout.setWidth100();
		fourLayout.setIsGroup(true);
		fourLayout.setGroupTitle("离职员工");
		fourLayout.setGroupBorderCSS(layoutGroupStyle);
		fourLayout.setGroupLabelBackgroundColor("#555555");
		fourLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
		
		
		fourGrid = new DelicacyListGrid();
		fourGrid.setShowRowNumbers(true);
		fourGrid.setDataSource(DSReportOfResignationApplyEmp.getInstance());
		fourLayout.addMember(fourGrid);
		contentLayout.addMember(fourLayout);
		
		fiveLayout = new HLayout(10);
		fiveLayout.setMinHeight(300);
		fiveLayout.setWidth100();
		fiveLayout.setIsGroup(true);
		fiveLayout.setGroupTitle("调薪员工");
		fiveLayout.setGroupBorderCSS(layoutGroupStyle);
		fiveLayout.setGroupLabelBackgroundColor("#555555");
		fiveLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
		
		
		fiveGrid = new DelicacyListGrid();
		fiveGrid.setShowRowNumbers(true);
		fiveGrid.setAutoFitFieldWidths(false);  
		int i = 0;
        ListGridField [] ifields = new ListGridField[10];
        ifields[i] = new ListGridField("employeeNo", "工号");
		i++;
		ifields[i] = new ListGridField("employeeName", "姓名");
		i++;
		ifields[i] = new ListGridField("gender", "性别");
		i++;
		ifields[i] = new ListGridField("plateId", "业务部门");
		i++;
		ifields[i] = new ListGridField("departmentId", "所属部门");
		i++;
		ifields[i] = new ListGridField("onboardDate", "入职日期");
		i++;
		ifields[i] = new ListGridField("positiveDate", "转正日期");
		i++;
		ifields[i] = new ListGridField("tryTimePay", "试用工资");
		i++;
		ifields[i] = new ListGridField("", "原薪资");
		i++;
		ifields[i] = new ListGridField("", "调整后薪资");
		i++;
		ifields[i] = new ListGridField("", "调整比例");
		fiveGrid.setFields(fields);
		fiveLayout.addMember(fiveGrid);
		contentLayout.addMember(fiveLayout);
		
		mainLayout.addMember(contentLayout);
    	addMember(mainLayout);
    	
    }
    
    @Override
    public void startEdit() {
    	Map<String,Object> map = new HashMap<>();
    	if(!BaseHelpUtils.isNullOrEmpty(plateIdItem.getValue())){
    		map.put("plateId", plateIdItem.getValue());
    	}
    	map.put("year", yearItem.getValue());
    	map.put("month", monthItem.getValue());
    	loadOneGridData(map);
    	loadThreeGridData(map);
    	loadFourGridData(map);
    }
    
    //加载新员工入职grid的数据
    public void loadOneGridData(Map<String,Object> map){
    	DBDataSource.callOperation("NQ_ReportPayChangeOnboardEmp", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					oneGrid.setData(dsResponse.getData());
				}
			}
		});
    }
    
    //加载调转部门员工grid的数据
    public void loadThreeGridData(Map<String,Object> map){
    	List<Map> keyvalues = new ArrayList<>();
        if(BaseHelpUtils.isNullOrEmpty(plateIdItem.getValue())){
	        Map<String, String> kv = new HashMap<>();
	        kv.put("key", "((SELECT plate_id FROM departments WHERE department_id = pb.department_id) = ? OR (SELECT plate_id FROM departments WHERE department_id = pb.parent_id) = ?)");
	        kv.put("value", "1=1");
	        keyvalues.add(kv);
        }
        map.put("keyValues", keyvalues);
    	DBDataSource.callOperation("NQ_ReportOfTransferEmp", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					threeGrid.setData(dsResponse.getData());
				}
			}
		});
    }
    
    //加载离职员工grid的数据
    public void loadFourGridData(Map<String,Object> map){
    	DBDataSource.callOperation("NQ_ReportOfResignationApplyEmp", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					fourGrid.setData(dsResponse.getData());
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

}
