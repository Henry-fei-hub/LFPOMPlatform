package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.Overflow;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeOnboardInformation;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeEducationInformation;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeFamilyInformation;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeRewardExperience;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeWorkExperience;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeTechnicalTitle;

public class EmployeeOnboardInformationViewer extends AbstractDetailViewer
{


	private final DelicacyListGrid employeeEducationInformationsGrid = new DelicacyListGrid();
	private final DelicacyListGrid employeeFamilyInformationsGrid = new DelicacyListGrid();
	private final DelicacyListGrid employeeRewardExperiencesGrid = new DelicacyListGrid();
	private final DelicacyListGrid employeeWorkExperiencesGrid = new DelicacyListGrid();
	private final DelicacyListGrid employeeTechnicalTitlesGrid = new DelicacyListGrid();
	private String processName;
	private static final Logger logger = Logger.getLogger("");
	private HLayout allLayout;
	private VLayout leftLayout;
	private VLayout rightLayout;
	private EmployeeOnboardViewDetail a;
	
	public EmployeeOnboardInformationViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
		allLayout = new HLayout(10);
		allLayout.setWidth100();
		allLayout.setHeight100();
		
		leftLayout = new VLayout(10);
		leftLayout.setWidth("50%");
		leftLayout.setHeight100();
		leftLayout.setOverflow(Overflow.AUTO);
		allLayout.addMember(leftLayout);
		
		rightLayout = new VLayout(10);
		rightLayout.setWidth("50%");
		rightLayout.setHeight100();
		allLayout.addMember(rightLayout);
		
		a = new EmployeeOnboardViewDetail(processName);
		leftLayout.addMember(a);
		
		rightLayout.addMember(employeeEducationInformationsGrid);
		rightLayout.addMember(employeeFamilyInformationsGrid);
		rightLayout.addMember(employeeRewardExperiencesGrid);
		rightLayout.addMember(employeeWorkExperiencesGrid);
		rightLayout.addMember(employeeTechnicalTitlesGrid);
		
		addMember(allLayout);
		
		employeeEducationInformationsGrid.setDataSource(DSEmployeeEducationInformation.getInstance());
		employeeEducationInformationsGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("职员学历信息表");
				detail.setWidth(700); detail.setHeight(500); 
				EmployeeEducationInformationViewer viewer = new EmployeeEducationInformationViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();detail.show();
			}
		});
		employeeFamilyInformationsGrid.setDataSource(DSEmployeeFamilyInformation.getInstance());
		employeeFamilyInformationsGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("职员家庭成员表");
				detail.setWidth(700); detail.setHeight(500); 
				EmployeeFamilyInformationViewer viewer = new EmployeeFamilyInformationViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();detail.show();
			}
		});
		employeeRewardExperiencesGrid.setDataSource(DSEmployeeRewardExperience.getInstance());
		employeeRewardExperiencesGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("职员奖惩经历表");
				detail.setWidth(700); detail.setHeight(500); 
				EmployeeRewardExperienceViewer viewer = new EmployeeRewardExperienceViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();detail.show();
			}
		});
		employeeWorkExperiencesGrid.setDataSource(DSEmployeeWorkExperience.getInstance());
		employeeWorkExperiencesGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("职员工作经历表");
				detail.setWidth(700); detail.setHeight(500); 
				EmployeeWorkExperienceViewer viewer = new EmployeeWorkExperienceViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();detail.show();
			}
		});
		employeeTechnicalTitlesGrid.setDataSource(DSEmployeeTechnicalTitle.getInstance());
		employeeTechnicalTitlesGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("职员技术职称表");
				detail.setWidth(700); detail.setHeight(500); 
				EmployeeTechnicalTitleViewer viewer = new EmployeeTechnicalTitleViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();detail.show();
			}
		});
	}

	@Override
	public void viewRecord(Record r) {
		super.viewRecord(r);
		a.setEmployeeId(r.getAttributeAsInt("employeeId"));
		a.loadData();
	}
	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "EmployeeOnboardInformation";
	}

	@Override
	public int getGroupCount() {
		if(!processName.isEmpty() && !processName.equals("部门助理")){
			return 4;
		}else{
			return 3;
		}
		
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<GroupColumn>();
		GroupColumn gc;
		gc = new GroupColumn();
		gc.setGroupName("basicInfo");
		gc.setGroupCaption("职员基本信息");
		gc.getColumnNames().add("employeeNo");
		gc.getColumnNames().add("employeeName");
		gc.getColumnNames().add("employeeNameEn");
		gc.getColumnNames().add("fileNumber");
		gc.getColumnNames().add("card");
		gc.getColumnNames().add("birth");
		gc.getColumnNames().add("age");
		gc.getColumnNames().add("gender");
		gc.getColumnNames().add("phone");
		gc.getColumnNames().add("mobile");
		gc.getColumnNames().add("email");
		gc.getColumnNames().add("homePhone");
		gc.getColumnNames().add("country");
		gc.getColumnNames().add("birthplace");
		gc.getColumnNames().add("accountLocation");
		gc.getColumnNames().add("householdRegistration");
		gc.getColumnNames().add("nationality");
		gc.getColumnNames().add("marriedStatus");
		gc.getColumnNames().add("health");
		gc.getColumnNames().add("politicalFace");
		gc.getColumnNames().add("education");
		gc.getColumnNames().add("degree");
		gc.getColumnNames().add("startWorkDate");
		gc.getColumnNames().add("languages");
		gc.getColumnNames().add("onboardDate");
		gc.getColumnNames().add("positiveDate");
		gc.getColumnNames().add("tryTime");
		gc.getColumnNames().add("foreman");
		gc.getColumnNames().add("workAddress");
		gc.getColumnNames().add("status");
		gc.getColumnNames().add("contractStartDate");
		gc.getColumnNames().add("contractEndDate");
		gc.getColumnNames().add("ownedCompany");
		gc.getColumnNames().add("departmentId");
		gc.getColumnNames().add("plateId");
		gc.getColumnNames().add("dutyId");
		gc.getColumnNames().add("gradeId");
		gc.getColumnNames().add("jobs");
		gc.getColumnNames().add("isCheck");
		gc.getColumnNames().add("socialComputerNumber");
		gc.getColumnNames().add("fundAccount");
		gc.getColumnNames().add("bankCardNum");
		gc.getColumnNames().add("employeeShift");
		gc.getColumnNames().add("selfIntroduction");
		gc.getColumnNames().add("personalBusinessRemark");
		gcs.add(gc);
		gc = new GroupColumn();
		gc.setGroupName("employeeAttachments");
		gc.setGroupCaption("职员相关附件");
		gc.getColumnNames().add("cardAttachment");
		gc.getColumnNames().add("educationProof");
		gc.getColumnNames().add("degreeProof");
		gc.getColumnNames().add("laborAttachments");
		gc.getColumnNames().add("technicalAttachment");
		gc.getColumnNames().add("bankCardAttachment");
		gcs.add(gc);
		gc = new GroupColumn();
		gc.setGroupName("contactInfo");
		gc.setGroupCaption("联系信息");
		gc.getColumnNames().add("emergencyContactPerson");
		gc.getColumnNames().add("emergencyContactPhone");
		gc.getColumnNames().add("cardAddress");
		gc.getColumnNames().add("nowAddress");
		gcs.add(gc);
		if(!processName.isEmpty() && !processName.equals("部门助理")){
			gc = new GroupColumn();
			gc.setGroupName("payInfo");
			gc.setGroupCaption("薪酬信息");
			gc.getColumnNames().add("tryTimePay");
			gc.getColumnNames().add("positivePay");
			gc.getColumnNames().add("annualPerformance");
			gc.getColumnNames().add("annualBonus");
			gcs.add(gc);
		}
		return gcs;
	}

	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map<String, String> params = new HashMap<String, String>();
		params.put("employeeId", getBusinessId());
		DBDataSource.callOperation("NQ_EmployeeOnboardInformation", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					for(DetailViewer v : detailViewers){
						v.setData(dsResponse.getData());
						if(dsResponse.getData().length == 0) continue;
						v.selectRecord(0);
						v.redraw();
					}
					setRecord(dsResponse.getData()[0]);
					viewDetailData();
				}
			}
		});
	}

	@Override
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
		setRecord(grid.getSelectedRecord());
		viewDetailData();
	}

	public void viewDetailData(){
		Record selected = getRecord();
		Object val;
		java.util.Map condition = null;
		condition = new java.util.HashMap();
		condition.put("employeeId", selected.getAttributeAsString("employeeId"));
		DBDataSource.callOperation("ST_EmployeeEducationInformation", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					employeeEducationInformationsGrid.setData(dsResponse.getData());
				}
			}
		});
		condition = new java.util.HashMap();
		condition.put("employeeId", selected.getAttributeAsString("employeeId"));
		DBDataSource.callOperation("ST_EmployeeFamilyInformation", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					employeeFamilyInformationsGrid.setData(dsResponse.getData());
				}
			}
		});
		condition = new java.util.HashMap();
		condition.put("employeeId", selected.getAttributeAsString("employeeId"));
		DBDataSource.callOperation("ST_EmployeeRewardExperience", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					employeeRewardExperiencesGrid.setData(dsResponse.getData());
				}
			}
		});
		condition = new java.util.HashMap();
		condition.put("employeeId", selected.getAttributeAsString("employeeId"));
		DBDataSource.callOperation("ST_EmployeeWorkExperience", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					employeeWorkExperiencesGrid.setData(dsResponse.getData());
				}
			}
		});
		condition = new java.util.HashMap();
		condition.put("employeeId", selected.getAttributeAsString("employeeId"));
		DBDataSource.callOperation("ST_EmployeeTechnicalTitle", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					employeeTechnicalTitlesGrid.setData(dsResponse.getData());
				}
			}
		});
		a.setEmployeeId(selected.getAttributeAsInt("employeeId"));
	}

	@Override
	public DataSource getMainDataSource() {
		return DSEmployeeOnboardInformation.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 5;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(employeeEducationInformationsGrid);
		res.add(employeeFamilyInformationsGrid);
		res.add(employeeRewardExperiencesGrid);
		res.add(employeeWorkExperiencesGrid);
		res.add(employeeTechnicalTitlesGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("学历信息");
		res.add("家庭成员");
		res.add("奖惩经历");
		res.add("工作经历");
		res.add("技术职称");
		return res;
	}


	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
	


}

