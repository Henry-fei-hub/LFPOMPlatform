package com.pomplatform.client.specialdeduction.datasource;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.pomplatform.client.specialdeduction.panel.SspecialdeductiontypessorPanel;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeEducationInformation;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SpecialDeductionInformation5 extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private int parentId;
	private int specialDeductionTypeId=5; //赡养老人
	private int year;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	public SpecialDeductionInformation5(){
		HLayout employeeEducationInformations = new HLayout();
		employeeEducationInformations.setWidth100();
		employeeEducationInformations.setHeight100();
		grid.setHeaderHeight(60); 
		grid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("赡养老人信息", new String[] {"specialDeductionDetailId","parentId","specialDeductionTypeId","year","singleChild",
				   "allocationWay","amount","name","otherDocumentType","otherIdentificationNumber",
				   "brithdate","nationalityRegion","relationship","fileId","fileUrl"})
	    });
		ListGridField[] fields = new ListGridField[18];
		int idx = 0;
		fields[idx] = new ListGridField("specialDeductionDetailId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId",shouldNotBeNull+"专项类型");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(specialDeductionTypeId);
		idx++;
		fields[idx] = new ListGridField("year",shouldNotBeNull+"扣除年度");
		fields[idx].setShowGridSummary(false);
		Date d = new Date();
		fields[idx].setDefaultValue(d.getYear()+1900);
		idx++;
		fields[idx] = new ListGridField("name",shouldNotBeNull+"被赡养人姓名");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("otherDocumentType",shouldNotBeNull+"身份证件类型");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("otherIdentificationNumber",shouldNotBeNull+"身份证件号码");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("brithdate",shouldNotBeNull+"出生日期");
		idx++;
		fields[idx] = new ListGridField("nationalityRegion",shouldNotBeNull+"国籍地区");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("singleChild",shouldNotBeNull+"是否独生子女");
		fields[idx].setShowGridSummary(false);
		fields[idx].addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(BaseHelpUtils.getIntValue(event.getValue())==0) {
					ListGridRecord selectedRecord = grid.getSelectedRecord();
					selectedRecord.setAttribute("amount", 2000);
				}
			}
		});
		idx++;
		fields[idx] = new ListGridField("allocationWay");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("amount",shouldNotBeNull+"本年度月扣除及金额");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("relationship",shouldNotBeNull+"与本人关系");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("fileId");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("fileUrl",shouldNotBeNull+"独生子证或有兄弟姐妹签名的分摊协议附件");
		fields[idx].setShowGridSummary(false);
		grid.setFields(fields);
		grid.setDataSource(DSSspecialdeductiondetailor.getInstance());
		grid.setAutoFitFieldWidths(true);
		employeeEducationInformations.addMember(grid);
		VLayout employeeEducationInformationsControls = new VLayout();
		employeeEducationInformationsControls.setHeight100();
		employeeEducationInformationsControls.setWidth(60);
		employeeEducationInformationsControls.setLayoutTopMargin(30);
		employeeEducationInformationsControls.setLayoutLeftMargin(5);
		employeeEducationInformationsControls.setLayoutRightMargin(5);
		employeeEducationInformationsControls.setMembersMargin(10);
		employeeEducationInformations.addMember(employeeEducationInformationsControls);
		addMember(employeeEducationInformations);
		IButton refearshButton = new IButton("刷新");
		refearshButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.redraw();
			}
		});
		IButton employeeEducationInformationsNewButton = new IButton("新增");
		employeeEducationInformationsNewButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				SC.say("赡养老人提示","1.独生子女：每年24,000元（每月2,000元）的标准定额扣除；" + 
						"2.非独生子女：与兄弟姐妹分摊每年24,000元（每月2,000元）的扣除额度"
						+ "3.该项不累计金额"
						+ "4.填写前请点击申请说明仔细阅读，不符合条件者请勿填写该项，以免影响个人纳税信用甚至违反税收法律");
				grid.startEditingNew();
			}
		});
		IButton employeeEducationInformationsRemoveButton = new IButton("删除所有");
		employeeEducationInformationsRemoveButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
			}
		});
		IButton upButton = new IButton("上传独生子证或有兄弟姐妹签名的分摊协议");
		upButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if(null==grid.getSelectedRecord()) {
					SC.say("提示","请选择一条数据");
				}else {
					new CommonUploadWindow("请上传独生子证或有兄弟姐妹签名的分摊协议", false, 50, 2, 1, new UploadCallBack() {
						
						@Override
						public void execute(Map<String, Record> data) {
							// 上传附件文件成功
							for(String key : data.keySet()) {
								String fileId = data.get(key).getAttribute("fileId");
								String fileUrl = data.get(key).getAttribute("fileUrl");
								ListGridRecord selectedRecord = grid.getSelectedRecord();
								selectedRecord.setAttribute("fileId", fileId);
								selectedRecord.setAttribute("fileUrl", fileUrl);
								grid.redraw();
							}
						}
					});
				}
			}
		});
		employeeEducationInformationsControls.addMember(refearshButton);
		employeeEducationInformationsControls.addMember(employeeEducationInformationsNewButton);
		employeeEducationInformationsControls.addMember(employeeEducationInformationsRemoveButton);
		employeeEducationInformationsControls.addMember(upButton);
		IButton remarkButton = new IButton("申请说明");
		remarkButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setWidth(700); 
				detail.setHeight(500); 
				SspecialdeductiontypessorPanel panel =new SspecialdeductiontypessorPanel();
				panel.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				panel.setSpecialDeductionTypeId(specialDeductionTypeId);
				panel.commonQuery();
				detail.setContent(panel);
				detail.centerInPage();
				detail.show();
			}
		});
		employeeEducationInformationsControls.addMember(remarkButton);
	}
	

	@Override
	public void startEdit() {
		if(getPageMode() != PAGE_MODE_UPDATE) {
			return;
		}else{
			reloadDetailTableData();
		}
	}

	public void reloadDetailTableData(){
		Map condition = new HashMap();
		condition.put("parentId", parentId);
		condition.put("specialDeductionTypeId", specialDeductionTypeId);	
		condition.put("year", year);
		DBDataSource.callOperation("ST_SpecialDeductionDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					grid.setData(dsResponse.getData());
				}
			}
		});
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean checkData() {
		int sum = 0;
		
		for(ListGridRecord r : grid.getRecords()) {
			if(null!=r.getAttribute("brithdate")) {
				SC.debugger();
				Date now =new Date();
				Date brithdate = r.getAttributeAsDate("brithdate");
				if(brithdate.after(now)){
					SC.say("出生日期必须小于当前日期");
					return false;
				}
				int yearBirth = brithdate.getYear()+1900;
				int monthBirth = brithdate.getMonth()+1;
				int dayOfMonthBirth = brithdate.getDate();
				
				int yearNow = now.getYear()+1900;
				int monthNow = now.getMonth()+1;
				int dayOfMonthNow= now.getDate();
				
				int age =0 ;
				age = yearNow - yearBirth;  
	            if (monthNow <= monthBirth) {  
	                if (monthNow == monthBirth) {  
	                    if (dayOfMonthNow < dayOfMonthBirth) age--;  
	                }else{  
	                    age--;  
	                }  
	            }  
				if(age<60) {
					SC.warn("提示","赡养60岁（含）以上父母以及其他法定赡养人的纳税人方可申请");
					return false;
				}
				
			}
			if(null==r.getAttribute("specialDeductionTypeId")) {
				SC.say("提示","子项类型不能为空");
				return false;
			}
			if(null==r.getAttribute("name")) {
				SC.say("提示","被赡养人姓名不能为空");
				return false;
			}
			if(null==r.getAttribute("year")) {
				SC.say("提示","扣除年度不能为空");
				return false;
			}
			if(null==r.getAttribute("otherDocumentType")) {
				SC.say("提示","身份证类型不能为空");
				return false;
			}
			if(null==r.getAttribute("otherIdentificationNumber")) {
				SC.say("提示","身份证件号码不能为空");
				return false;
			}
			if(null==r.getAttribute("brithdate")) {
				SC.say("提示","出生日期不能为空");
				return false;
			}
			if(null==r.getAttribute("nationalityRegion")) {
				SC.say("提示","国籍地区不能为空");
				return false;
			}
			if(null==r.getAttribute("singleChild")) {
				SC.say("提示","是否独生不能为空");
				return false;
			}
			if(null==r.getAttribute("relationship")) {
				SC.say("提示","与本人关系不能为空");
				return false;
			}
			/*if(BaseHelpUtils.getIntValue(r.getAttribute("singleChild"))==1) {
				if(null==r.getAttribute("allocationWay")) {
					SC.say("提示","分摊方式不能为空");
					return false;
				}
			}*/
			if(null==r.getAttribute("amount")) {
				SC.say("提示","本年度月扣除及金额不能为空");
				return false;
			}else {
				int amount = BaseHelpUtils.getIntValue(r.getAttribute("amount"));
				if(amount>2000) {
					SC.say("提示","赡养老人专项扣除累计金额不能超过2000元，请删除多余数据或者平均金额");
					return false;
				}
				sum+=amount;
			}
			if(null==r.getAttribute("fileUrl")||null==r.getAttribute("fileId")) {
				SC.say("提示","请上传附件");
				return false;
			}
			__logger.info(MapUtils.convertRecordToMap(grid.getDataSource(), r).toString());
		}
		
		if(sum>2000) {
			SC.say("提示","赡养老人专项扣除累计金额不能超过2000元，请删除多余数据或者平均金额");
			return false;
		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("SpecialDeductionInformation5");
		return res;
	}

	@Override
	public boolean isTheValuesEmpty() {
		ListGridRecord[] rows = grid.getRecords();
		return rows == null || rows.length == 0;
	}

	@Override
	public Map getValuesAsMap() {
		Map param = new HashMap();
		ListGridRecord[] rows = grid.getRecords();
		if(!BaseHelpUtils.isNullOrEmpty(rows) && rows.length > 0) {
			MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "specialDeductionInformation5");
		}
		return param;
	}

	@Override
	public String getName() {
		return "赡养老人信息";
	}

	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid( DelicacyListGrid value ) {
		this.grid = value;
	}


	public int getParentId() {
		return parentId;
	}


	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


	public int getSpecialDeductionTypeId() {
		return specialDeductionTypeId;
	}


	public void setSpecialDeductionTypeId(int specialDeductionTypeId) {
		this.specialDeductionTypeId = specialDeductionTypeId;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}

	

}

