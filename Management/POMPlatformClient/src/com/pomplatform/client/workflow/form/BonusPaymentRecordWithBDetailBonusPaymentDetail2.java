package com.pomplatform.client.workflow.form;

import java.math.BigDecimal;
import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.Criteria;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import java.util.logging.Logger;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.pomplatform.client.bonuspayment.datasource.DSBonusPaymentDetail;
import com.pomplatform.client.common.ClientStaticUtils;

public class BonusPaymentRecordWithBDetailBonusPaymentDetail2 extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private BonusPaymentRecordWithBUpdateForm bonusPaymentRecordWithBUpdateForm =null;
	private Date payDate = new Date();
	
	public BonusPaymentRecordWithBDetailBonusPaymentDetail2(){
		
		HLayout bonusPaymentDetails = new HLayout();
		bonusPaymentDetails.setWidth100();
		bonusPaymentDetails.setHeight100();
		int index = 0;
		ListGridField[] fields = new ListGridField[11];
		fields[index] = new ListGridField("bonusPaymentRecordId");
		fields[index].setHidden(true);
		index++;
		fields[index] = new ListGridField("bonusPaymentDetailId");
		fields[index].setHidden(true);
		index++;
		fields[index] = new ListGridField("employeeNo");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("employeeName");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("achieveIntegral");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("payPercent");
		fields[index].setCanEdit(true);
		fields[index].setShowGridSummary(false);
		index++;
		fields[index] = new ListGridField("payIntegral");
		fields[index].setCanEdit(true);
		index++;
		fields[index] = new ListGridField("leftIntegral");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("plateId");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("status");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("sendNumber");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(true);
		fields[index].addChangeHandler(new com.smartgwt.client.widgets.grid.events.ChangeHandler() {
			@Override
			public void onChange(com.smartgwt.client.widgets.grid.events.ChangeEvent event) {
				int sendNumber=BaseHelpUtils.getIntValue(event.getValue());
				if(sendNumber>3||sendNumber<=0) {
					SC.say("发放次数不能超过3次或小于等于0");
					event.cancel();
				}
			}
		});
		index++;
		fields[index] = new ListGridField("firstIntegral");
		fields[index].setCanEdit(true);
		fields[index].addChangeHandler(new com.smartgwt.client.widgets.grid.events.ChangeHandler() {
			@Override
			public void onChange(com.smartgwt.client.widgets.grid.events.ChangeEvent event) {
				BigDecimal firstIntegral=BaseHelpUtils.getBigDecimalValue(event.getValue());
				if(firstIntegral.compareTo(BigDecimal.ZERO)<0) {
					SC.say("发放积分不能小于0");
					event.cancel();
				}
			}
		});
		index++;
		fields[index] = new ListGridField("secondIntegral");
		fields[index].setCanEdit(true);
		fields[index].addChangeHandler(new com.smartgwt.client.widgets.grid.events.ChangeHandler() {
			@Override
			public void onChange(com.smartgwt.client.widgets.grid.events.ChangeEvent event) {
				BigDecimal secondIntegral=BaseHelpUtils.getBigDecimalValue(event.getValue());
				if(secondIntegral.compareTo(BigDecimal.ZERO)<0) {
					SC.say("发放积分不能小于0");
					event.cancel();
				}
			}
		});
		index++;
		fields[index] = new ListGridField("thirdIntegral");
		fields[index].setCanEdit(true);
		fields[index].addChangeHandler(new com.smartgwt.client.widgets.grid.events.ChangeHandler() {
			@Override
			public void onChange(com.smartgwt.client.widgets.grid.events.ChangeEvent event) {
				BigDecimal thirdIntegral=BaseHelpUtils.getBigDecimalValue(event.getValue());
				if(thirdIntegral.compareTo(BigDecimal.ZERO)<0) {
					SC.say("发放积分不能小于0");
					event.cancel();
				}
			}
		});
		grid.setFields(fields);
		grid.setDataSource(DSBonusPaymentDetail.getInstance());
		grid.setAutoFitFieldWidths(false);
		grid.setHeight100();
		grid.setWidth100();
		grid.setShowGridSummary(true);
		grid.setCanRemoveRecords(false);
//		grid.addDoubleClickHandler(new DoubleClickHandler() {
//			@Override
//			public void onDoubleClick(DoubleClickEvent event) {
//				GWT.runAsync(new RunAsyncCallback() {
//					@Override
//					public void onSuccess() {
//						SC.debugger();
//						ListGridRecord record = grid.getSelectedRecord();
//						if(record.getAttributeAsBoolean("canEdit")){
//							grid.startEditing(grid.getRowNum(record));
//						}else{
//							grid.cancelEditing();
//						}
//					}
//					
//					@Override
//					public void onFailure(Throwable reason) {
//						SC.say(ClientStaticUtils.WARNING);
//					}
//				});
//			}
//		});
		grid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Record record = grid.getRecord(event.getRowNum());
				int colNum = event.getColNum();
				String fileName = grid.getFieldName(colNum);
				SelectItem plateIdItem = bonusPaymentRecordWithBUpdateForm.getPlateIdItem();
				DateItem payDateItem = bonusPaymentRecordWithBUpdateForm.getPayDateItem();
				TextItem payIntegralItem = bonusPaymentRecordWithBUpdateForm.getPayIntegralItem();
				BigDecimal payIntegral = new BigDecimal(payIntegralItem.getValueAsString())
						.subtract(new BigDecimal(record.getAttribute("payIntegral")));
				BigDecimal achieveIntegral = new BigDecimal(record.getAttribute("achieveIntegral"));
				
				BigDecimal firstIntegral=BaseHelpUtils.getBigDecimalValue(record.getAttribute("firstIntegral"));//第一次发放积分
				BigDecimal secondIntegral=BaseHelpUtils.getBigDecimalValue(record.getAttribute("secondIntegral"));//第二次发放积分
				BigDecimal thirdIntegral=BaseHelpUtils.getBigDecimalValue(record.getAttribute("thirdIntegral"));//第三次发放积分
				
				
				if(fileName.equals("payPercent")){//修改比例，发放积分自动计算
					BigDecimal temp = new BigDecimal(
							ClientUtil.checkAndGetDoubleValue(record.getAttribute("payPercent")) / 100);
					//限制奖金发放比例最大只能为100%
					if (temp.compareTo(BigDecimal.ONE) > 0) {
						temp = BigDecimal.ONE;
						record.setAttribute("payPercent", 100);
					}
					temp = achieveIntegral.multiply(temp).divide(BigDecimal.ONE,2,BigDecimal.ROUND_DOWN);
					payIntegral = payIntegral.add(temp);
					payIntegralItem.setValue(payIntegral);
					record.setAttribute("payIntegral", temp);
					record.setAttribute("leftIntegral", achieveIntegral.subtract(temp));
					
					//发放次数
					int sendNumber=BaseHelpUtils.getIntValue(record.getAttribute("sendNumber"));
					if(sendNumber<=0) {
						SC.say("发放次数不能超过3次或小于等于0");
					}
					
					BigDecimal leftIntegral = BigDecimal.ZERO;
					BigDecimal value = BigDecimal.ZERO;
					switch (sendNumber) {
					case 1:
						record.setAttribute("firstIntegral", temp);
						record.setAttribute("secondIntegral", BigDecimal.ZERO);
						record.setAttribute("thirdIntegral", BigDecimal.ZERO);
						break;
					case 2:
						BigDecimal two = new BigDecimal("2");
						value=temp.divide(two,2,BigDecimal.ROUND_DOWN);
						leftIntegral = temp.subtract(value.multiply(two));
						record.setAttribute("firstIntegral", value);
						record.setAttribute("secondIntegral", value.add(leftIntegral));
						record.setAttribute("thirdIntegral", BigDecimal.ZERO);
						break;
					case 3:
						BigDecimal three = new BigDecimal("3");
						value=temp.divide(three,2,BigDecimal.ROUND_DOWN);
						leftIntegral = temp.subtract(value.multiply(three));
						record.setAttribute("firstIntegral", value);
						record.setAttribute("secondIntegral", value);
						record.setAttribute("thirdIntegral", value.add(leftIntegral));
						break;
					}
					
				}else if(fileName.equals("payIntegral")){//修改发放积分，相应比例自动计算
					BigDecimal newIntegral = BaseHelpUtils.format(BaseHelpUtils.getBigDecimalValue(record.getAttribute("payIntegral")), 2);
					if(newIntegral.compareTo(achieveIntegral) > 0){
						newIntegral = achieveIntegral;
						record.setAttribute("payIntegral", newIntegral);
					}
					Record[] records = grid.getRecords();
					BigDecimal totalIntegral = BigDecimal.ZERO;
					if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
						for(Record e : records){
							totalIntegral = totalIntegral.add(BaseHelpUtils.getBigDecimalValue(e.getAttribute("payIntegral")));
						}
					}
					payIntegralItem.setValue(totalIntegral);
					BigDecimal percent = newIntegral.multiply(BigDecimal.valueOf(100)).divide(achieveIntegral,2,BigDecimal.ROUND_HALF_UP);
					record.setAttribute("payPercent", percent);
					record.setAttribute("leftIntegral", achieveIntegral.subtract(newIntegral));
					
					//发放次数
					int sendNumber=BaseHelpUtils.getIntValue(record.getAttribute("sendNumber"));
					if(sendNumber<=0) {
						SC.say("发放次数不能超过3次或小于等于0");
					}
					
					BigDecimal leftIntegral = BigDecimal.ZERO;
					BigDecimal value = BigDecimal.ZERO;
					switch (sendNumber) {
					case 1:
						record.setAttribute("firstIntegral", newIntegral);
						record.setAttribute("secondIntegral", BigDecimal.ZERO);
						record.setAttribute("thirdIntegral", BigDecimal.ZERO);
						break;
					case 2:
						BigDecimal two = new BigDecimal("2");
						value=newIntegral.divide(two,2,BigDecimal.ROUND_DOWN);
						leftIntegral = newIntegral.subtract(value.multiply(two));
						record.setAttribute("firstIntegral", value);
						record.setAttribute("secondIntegral", value.add(leftIntegral));
						record.setAttribute("thirdIntegral", BigDecimal.ZERO);
						break;
					case 3:
						BigDecimal three = new BigDecimal("3");
						value=newIntegral.divide(three,2,BigDecimal.ROUND_DOWN);
						leftIntegral = newIntegral.subtract(value.multiply(three));
						record.setAttribute("firstIntegral", value);
						record.setAttribute("secondIntegral", value);
						record.setAttribute("thirdIntegral", value.add(leftIntegral));
						break;
					}
					
				}else if(fileName.equals("sendNumber")) {//发放次数
					int sendNumber=BaseHelpUtils.getIntValue(record.getAttribute("sendNumber"));
					BigDecimal payIntegrals=BaseHelpUtils.getBigDecimalValue(record.getAttribute("payIntegral"));//价值积分
					BigDecimal leftIntegral = BigDecimal.ZERO;
					BigDecimal value = BigDecimal.ZERO;
					switch (sendNumber) {
					case 1:
						record.setAttribute("firstIntegral", payIntegrals);
						record.setAttribute("secondIntegral", BigDecimal.ZERO);
						record.setAttribute("thirdIntegral", BigDecimal.ZERO);
						break;
					case 2:
						BigDecimal two = new BigDecimal("2");
						value=payIntegrals.divide(two,2,BigDecimal.ROUND_DOWN);
						leftIntegral = payIntegrals.subtract(value.multiply(two));
						record.setAttribute("firstIntegral", value);
						record.setAttribute("secondIntegral", value.add(leftIntegral));
						record.setAttribute("thirdIntegral", BigDecimal.ZERO);
						break;
					case 3:
						BigDecimal three = new BigDecimal("3");
						value=payIntegrals.divide(three,2,BigDecimal.ROUND_DOWN);
						leftIntegral = payIntegrals.subtract(value.multiply(three));
						record.setAttribute("firstIntegral", value);
						record.setAttribute("secondIntegral", value);
						record.setAttribute("thirdIntegral", value.add(leftIntegral));
						break;
					}
				}else if (fileName.equals("firstIntegral")||fileName.equals("secondIntegral")||fileName.equals("thirdIntegral")) {
					int number=0;
					if(firstIntegral.compareTo(BigDecimal.ZERO)>0&&secondIntegral.compareTo(BigDecimal.ZERO)<=0&&thirdIntegral.compareTo(BigDecimal.ZERO)<=0) {
						number=1;
					}else if(secondIntegral.compareTo(BigDecimal.ZERO)>0&&firstIntegral.compareTo(BigDecimal.ZERO)<=0&&thirdIntegral.compareTo(BigDecimal.ZERO)<=0) {
						number=1;
					}else if(thirdIntegral.compareTo(BigDecimal.ZERO)>0&&firstIntegral.compareTo(BigDecimal.ZERO)<=0&&secondIntegral.compareTo(BigDecimal.ZERO)<=0) {
						number=1;
					}else if(firstIntegral.compareTo(BigDecimal.ZERO)>0&&secondIntegral.compareTo(BigDecimal.ZERO)>0&&thirdIntegral.compareTo(BigDecimal.ZERO)<=0) {
						number=2;
					}else if(firstIntegral.compareTo(BigDecimal.ZERO)>0&&secondIntegral.compareTo(BigDecimal.ZERO)<=0&&thirdIntegral.compareTo(BigDecimal.ZERO)>0) {
						number=2;
					}else if(firstIntegral.compareTo(BigDecimal.ZERO)<=0&&secondIntegral.compareTo(BigDecimal.ZERO)>0&&thirdIntegral.compareTo(BigDecimal.ZERO)>0) {
						number=2;
					}else if(firstIntegral.compareTo(BigDecimal.ZERO)>0&&secondIntegral.compareTo(BigDecimal.ZERO)>0&&thirdIntegral.compareTo(BigDecimal.ZERO)>0) {
						number=3;
					}
					record.setAttribute("sendNumber", number);
				}
				RecordList list = grid.getDataAsRecordList();
				list.set(event.getRowNum(), record);
				grid.setData(list);
				grid.redraw();
			}
		});
		
		bonusPaymentDetails.addMember(grid);
		VLayout bonusPaymentDetailsControls = new VLayout();
		bonusPaymentDetailsControls.setHeight100();
		bonusPaymentDetailsControls.setWidth(60);
		bonusPaymentDetailsControls.setLayoutTopMargin(30);
		bonusPaymentDetailsControls.setLayoutLeftMargin(5);
		bonusPaymentDetailsControls.setLayoutRightMargin(5);
		bonusPaymentDetailsControls.setMembersMargin(10);
		bonusPaymentDetails.addMember(bonusPaymentDetailsControls);
		addMember(bonusPaymentDetails);
		
		
		IButton firstItem = new IButton("第一季度");
		firstItem.setWidth("*");
		IButton twoItem = new IButton("第二季度");
		twoItem.setWidth("*");
		IButton threeItem = new IButton("第三季度");
		threeItem.setWidth("*");
		IButton fourItem = new IButton("第四季度");
		fourItem.setWidth("*");
		firstItem.addClickHandler(new ClickHandler() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(ClickEvent event) {
				//加载第一季度的数据
				Date date = new Date();
				date.setMonth(2);
				setPayDate(date);
				load();
			}
		});
		
		twoItem.addClickHandler(new ClickHandler() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(ClickEvent event) {
				//加载第二季度的数据
				Date date = new Date();
				date.setMonth(5);
				setPayDate(date);
				load();
			}
		});
		
		threeItem.addClickHandler(new ClickHandler() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(ClickEvent event) {
				//加载第三季度的数据
				Date date = new Date();
				date.setMonth(8);
				setPayDate(date);
				load();
			}
		});
		
		fourItem.addClickHandler(new ClickHandler() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(ClickEvent event) {
				//加载第四季度的数据
				Date date = new Date();
				//如果当前月份为1月份，那么该第四季度是上一年的，年份改为上一年的年份
				if(date.getMonth() == 0){
					int currentYear = date.getYear();
					date.setYear(currentYear-1);
				}
				date.setMonth(11);
				setPayDate(date);
				load();
			}
		});
		
		
		
		IButton bonusPaymentDetailsNewButton = new IButton("新增");
		bonusPaymentDetailsNewButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.startEditingNew();
			}
		});
		IButton bonusPaymentDetailsRemoveAllButton = new IButton("删除所有");
		bonusPaymentDetailsRemoveAllButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
			}
		});
		
		IButton bonusPaymentDetailsRemoveButton = new IButton("删除");
		bonusPaymentDetailsRemoveButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				SC.debugger();
				ListGridRecord selectedRecord = grid.getSelectedRecord();
				if(BaseHelpUtils.isNullOrEmpty(selectedRecord)) {
					SC.say("提示","请选择一条数据");
					return;
				}
				int indexNum = grid.getRowNum(selectedRecord);
				grid.removeData(selectedRecord);
				grid.selectSingleRecord(indexNum);
				
				TextItem payIntegralItem = bonusPaymentRecordWithBUpdateForm.getPayIntegralItem();
				ListGridRecord[] records = grid.getRecords();
				if(BaseHelpUtils.isNullOrEmpty(records)||records.length<=0) {
					payIntegralItem.setValue(0);
				}else {
					BigDecimal sum =BigDecimal.ZERO;
					for(ListGridRecord r : records){
						sum = sum.add(new BigDecimal(r.getAttribute("payIntegral")));
					}
					payIntegralItem.setValue(sum);
				}
			}
		});
		
		
		IButton totalButton = new IButton("汇总");
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] recordList = grid.getRecords();
				int len = recordList.length;
				Record[] records = new Record[len + 1];
				if (len > 0) {
					double achieveIntegral = 0;
					double payIntegral = 0;
					double leftIntegral = 0;
					double firstIntegral = 0;
					double secondIntegral = 0;
					double thirdIntegral = 0;
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("employeeNo"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						achieveIntegral += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("achieveIntegral"));
						payIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("payIntegral"));
						leftIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("leftIntegral"));
						firstIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("firstIntegral"));
						secondIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("secondIntegral"));
						thirdIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("thirdIntegral"));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("employeeNo", "汇总");
					record.setAttribute("achieveIntegral", achieveIntegral);
					record.setAttribute("payIntegral", payIntegral);
					record.setAttribute("leftIntegral", leftIntegral);
					record.setAttribute("firstIntegral", firstIntegral);
					record.setAttribute("secondIntegral", secondIntegral);
					record.setAttribute("thirdIntegral", thirdIntegral);
					records[len] = record;
					grid.setData(records);
					grid.redraw();
					grid.setCanEdit(false);
				}
			}
		});
//		bonusPaymentDetailsControls.addMember(firstItem);
//		bonusPaymentDetailsControls.addMember(twoItem);
//		bonusPaymentDetailsControls.addMember(threeItem);
//		bonusPaymentDetailsControls.addMember(fourItem);
//		bonusPaymentDetailsControls.addMember(bonusPaymentDetailsNewButton);
		bonusPaymentDetailsControls.addMember(bonusPaymentDetailsRemoveButton);
//		bonusPaymentDetailsControls.addMember(totalButton);
	}

	@Override
	public void startEdit() {
		if(getPageMode() != PAGE_MODE_UPDATE) return;
		reloadDetailTableData();
	}

	public void reloadDetailTableData(){
		Map condition = new HashMap();
		condition.put("bonusPaymentRecordId", getRecord().getAttribute("bonusPaymentRecordId"));
		DBDataSource.callOperation("ST_BonusPaymentDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					if(__startLoadedDetail != null) __startLoadedDetail.execute(dsResponse, data, dsRequest);
					grid.setData(dsResponse.getData());
					if(__endLoadedDetail != null) __endLoadedDetail.execute(dsResponse, data, dsRequest);
				}
			}
		});
	}

	@Override
	public boolean checkData() {
		for(ListGridRecord r : grid.getRecords()) {
			__logger.info(MapUtils.convertRecordToMap(grid.getDataSource(), r).toString());
		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailBonusPaymentDetail");
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
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailBonusPaymentDetail");
		return param;
	}

	@Override
	public String getName() {
		return "";
	}

	public DSCallback getStartLoadedDetail() {
		return this.__startLoadedDetail;
	}

	public void setStartLoadedDetail( DSCallback value ) {
		this.__startLoadedDetail = value;
	}

	public DSCallback getEndLoadedDetail() {
		return this.__endLoadedDetail;
	}

	public void setEndLoadedDetail( DSCallback value ) {
		this.__endLoadedDetail = value;
	}

	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid( DelicacyListGrid value ) {
		this.grid = value;
	}

	public BonusPaymentRecordWithBUpdateForm getBonusPaymentRecordWithBUpdateForm() {
		return bonusPaymentRecordWithBUpdateForm;
	}

	public void setBonusPaymentRecordWithBUpdateForm(BonusPaymentRecordWithBUpdateForm bonusPaymentRecordWithBUpdateForm) {
		this.bonusPaymentRecordWithBUpdateForm = bonusPaymentRecordWithBUpdateForm;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	
	/**
	 * 加载页面时加载该方法
	 */
	public void load() {
		grid.setData(new Record[0]);
		SelectItem plateIdItem = bonusPaymentRecordWithBUpdateForm.getPlateIdItem();
		DateItem payDateItem = bonusPaymentRecordWithBUpdateForm.getPayDateItem();
		TextItem payIntegralItem = bonusPaymentRecordWithBUpdateForm.getPayIntegralItem();
		Integer plateId = BaseHelpUtils.getIntValue(plateIdItem.getValue());
		if (null == plateId || plateId == 0) {
			return;
		}
		if (null != payDate && null == payDateItem.getValue()) {
			payDateItem.setValue(payDate);
		}
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "prepareApplyInfo");
		params.put("plateId", plateId);
		params.put("payDate", payDate);
		DBDataSource.callOperation("EP_BonusPaymentProcessor", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					int length = records.length;
					if (length == 0) {
						payIntegralItem.setValue(0);
					} else {
						BigDecimal sum = BigDecimal.ZERO;
						BigDecimal sixPercent = BigDecimal.valueOf(0.6);
						for(Record r : records){
							//如果是商业事业部：1万以下的100%，1万（包括1万）以上的60%
							if(plateId == 1){
								//获取价值积分
								BigDecimal achieveIntegral = BaseHelpUtils.getBigDecimalValue(r.getAttribute("achieveIntegral"));
								if(achieveIntegral.compareTo(BigDecimal.valueOf(10000)) >= 0 && BaseHelpUtils.getIntValue(r.getAttribute("status")) == ClientStaticUtils.EMPLOYEE_NORMAL){
									BigDecimal payIntegral = BaseHelpUtils.format(achieveIntegral.multiply(sixPercent), 2);
									BigDecimal leftIntegral = achieveIntegral.subtract(payIntegral);
									r.setAttribute("payIntegral", payIntegral);
									r.setAttribute("payPercent", "60");
									r.setAttribute("leftIntegral", leftIntegral);
								}
							}
							sum = sum.add(new BigDecimal(r.getAttribute("payIntegral")));
							r.setAttribute("sendNumber", 1);
							r.setAttribute("firstIntegral", BaseHelpUtils.getBigDecimalValue(r.getAttribute("achieveIntegral")));
						}
						payIntegralItem.setValue(sum);
					}
					grid.setData(records);
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}

}

