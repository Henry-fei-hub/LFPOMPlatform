package com.pomplatform.client.projectteambuild.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.pomplatform.client.projectteambuild.datasource.DSSemployeeedror;
import com.pomplatform.client.projectteambuild.datasource.DSSprojectteambuild;
import com.pomplatform.client.projectteambuild.panel.ProjectEmployeePlanIntegralProgressPanel;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickHandler;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SprojectteambuildDetailProjectEmployee2 extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private  ListGrid  grid ;
	private final DelicacyListGrid SourceGrid = new DelicacyListGrid();
	private final IButton disagreeButton = new IButton("不同意"); 
	private final IButton agreeButton = new IButton("同意"); 
	private final IButton saveButton = new IButton("保存");
	private final IButton showButton = new IButton("预分配进度");
	private final IButton searchButton = new IButton("搜索");
	private final IButton resetButton = new IButton("重置");
	Map<String,Object> result = new HashMap<>();
	Map<String,Object> removeEmployeeGradeId = new HashMap<>();
	private final SemployeeedrorSearchForm __searchForm = new SemployeeedrorSearchForm();
	//定义阶段相关信息显示栏表单项
	private TextItem stageNameView = null;//阶段名称显示
	private TextItem stageIntegralView = null;//阶段积分显示
	private TextItem stageLeftIntegralView = null;//阶段剩余积分显示
	//定义map来存放每个阶段的对象值
	private Map<Integer,Record> stageMap = new HashMap<>();
	//定义该项目是否按标准匹配人员
	private boolean isNeed = false;
	//定义项目Id
	private int projectId = 0;
	//定义该项目匹配的高、中、低级设计师个数
	private int highDesigner = 0;
	private int middleDesigner = 0;
	private int initialDesigner = 0;
	//定义map来存放成员是否可删除
	private Map<Integer,Boolean> notCanDeleteMap = new HashMap<>();
	//定义当前操作阶段Id
	private int currentStageId = -1;
	
	List<Map<String,Object>> resultList =new ArrayList<>();
	
	public SprojectteambuildDetailProjectEmployee2() {
		HLayout projectEmployees = new HLayout();
		projectEmployees.setWidth("75%");
		projectEmployees.setHeight100();
		projectEmployees.setLayoutLeftMargin(5);
		addMember(projectEmployees);
		
		VLayout leftLayout = new VLayout(10);
		leftLayout.setAlign(Alignment.RIGHT);
		projectEmployees.addMember(leftLayout);
		
		DynamicForm viewForm = new DynamicForm();
		viewForm.setNumCols(6);
		viewForm.setHeight("5%");
		leftLayout.addMember(viewForm);
		
		stageNameView = new TextItem("stageNameView","阶段名称");
		stageNameView.setWidth("*");
		stageNameView.setDisabled(true);
		
		stageIntegralView = new TextItem("stageIntegralView","阶段积分");
		stageIntegralView.setWidth("*");
		stageIntegralView.setDisabled(true);
		
		stageLeftIntegralView = new TextItem("stageLeftIntegralView","阶段剩余积分");
		stageLeftIntegralView.setWidth("*");
		stageLeftIntegralView.setDisabled(true);
		viewForm.setFields(stageNameView,stageIntegralView,stageLeftIntegralView);
		
        grid = new ListGrid() {  
            @Override  
            protected Canvas createRecordComponent(final ListGridRecord record, Integer colNum) {  
                String fieldName = this.getFieldName(colNum);
                if (fieldName.contains("status_")) {  
                	Label wait = new Label("待确定");
                	wait.setBackgroundColor("gray");
                	Label agreed = new Label("已同意");
                	agreed.setBackgroundColor("green");
                	Label disagreed = new Label("已拒绝");
                	disagreed.setBackgroundColor("red");
                	SC.debugger();
                	int status = BaseHelpUtils.getIntValue(record.getAttribute(fieldName));
                   	String employeeId = BaseHelpUtils.getString(record.getAttribute("employeeId"));
                   	int projectId = BaseHelpUtils.getIntValue(record.getAttribute("projectId"));
                    HLayout recordCanvas = new HLayout();  
                    recordCanvas.setHeight(22);  
                    recordCanvas.setWidth100();  
    				recordCanvas.setMembersMargin(10);
    				recordCanvas.setAlign(Alignment.LEFT);
                	if(status==1&&employeeId.equals(ClientUtil.getUserId())) {
                        IButton agreeButton = new IButton("同意"); 
                        agreeButton.setWidth("50%");
    					agreeButton.setAlign(Alignment.CENTER);
    					recordCanvas.addMember(agreeButton); 
    					agreeButton.addClickHandler(new ClickHandler() {  
                            public void onClick(ClickEvent event) { 
								SC.ask("提示", "确认同意该预分配方案吗?", new BooleanCallback() {
									@Override
									public void execute(Boolean value) {
										if(value==true) {
											SC.debugger();
											String fieldName = getFieldName(colNum);
											int stageId = -1;
											if(fieldName.contains("_")){//如果包含下斜杠，则说明有接阶段的Id
												//截取阶段Id
												 stageId = BaseHelpUtils.getIntValue(fieldName.substring(fieldName.indexOf("_")+1));
											}
											Map<String,Object> param =new HashMap<>();
											param.put("employeeId", employeeId);//审批人
											param.put("projectId", projectId);
											param.put("stageId",stageId);
											param.put("status",2);
											param.put("optType","onSaveOrUpdateStageStatus");
											DBDataSource.callOperation("EP_OnProjectCommonProcess", param, new DSCallback() {
												@Override
												public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
													if (dsResponse.getStatus() >= 0) {
														startEdit();
														SC.say("保存成功");
													}else {
														ClientUtil.displayErrorMessage(dsResponse);
													}
												}
											});
											
										}
									}
								});
                            }  
                        });  
      
    					IButton disagreeButton = new IButton("不同意");  
    					disagreeButton.setWidth("50%");
    					disagreeButton.setAlign(Alignment.CENTER);  
    					recordCanvas.addMember(disagreeButton); 
    					disagreeButton.addClickHandler(new ClickHandler() {  
                            public void onClick(ClickEvent event) {  
								SC.ask("提示", "确认不同意该预分配方案吗?", new BooleanCallback() {
									@Override
									public void execute(Boolean value) {
										if(value==true) {
											String fieldName = getFieldName(colNum);
											int stageId = -1;
											if(fieldName.contains("_")){//如果包含下斜杠，则说明有接阶段的Id
												//截取阶段Id
												 stageId = BaseHelpUtils.getIntValue(fieldName.substring(fieldName.indexOf("_")+1));
											}
											Map<String,Object> param =new HashMap<>();
											param.put("employeeId", employeeId);//审批人
											param.put("projectId", projectId);
											param.put("stageId",stageId);
											param.put("status",3);
											param.put("optType","onSaveOrUpdateStageStatus");
											DBDataSource.callOperation("EP_OnProjectCommonProcess", param, new DSCallback() {
												@Override
												public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
													if (dsResponse.getStatus() >= 0) {
														startEdit();
														SC.say("保存成功");
													}else {
														ClientUtil.displayErrorMessage(dsResponse);
													}
												}
											});
											
										}
									}
								});
                            }  
                        });  
                	}else if(status==1&&!employeeId.equals(ClientUtil.getUserId())) {
                		recordCanvas.addMember(wait);
                	} if(status==2) {
    					recordCanvas.addMember(agreed);
                	}else if(status==3) {
                		recordCanvas.addMember(disagreed);
                	}
                	return recordCanvas;  
                } else  
                    return null;  
                }  
  
            };
//		grid = new DelicacyListGrid();
//		grid.setHeight("95%");
//		grid.setAutoFitFieldWidths(false);
//		grid.setHeaderHeight(60); 
//		grid.setShowRowNumbers(true);
//		grid.setShowGridSummary(true);
//		grid.setVirtualScrolling(false);          
//		grid.setShowRecordComponents(true);          
//		grid.setShowRecordComponentsByCell(true);  
//		grid.setCanRemoveRecords(false); 
        
        grid.setHeight("95%");
        grid.setHeaderHeight(60); 
        grid.setShowRowNumbers(true);
        grid.setShowRecordComponents(true); 
        grid.setShowRecordComponentsByCell(true);
        grid.setAutoFitFieldWidths(false);
        grid.redraw();
		
		grid.addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent event) {
				int colNum = event.getColNum();
				String fieldName = grid.getFieldName(colNum);
				if(fieldName.contains("_")){//如果包含下斜杠，则说明有接阶段的Id
					//截取阶段Id
					int stageId = BaseHelpUtils.getIntValue(fieldName.substring(fieldName.indexOf("_")+1));
					currentStageId = stageId;
					setViewValue();
				}
			}
		});
//		HLayout bottom = new HLayout();
//		bottom.setWidth100();
//		bottom.setHeight("5%");
//		bottom.setAlign(Alignment.RIGHT);
//		bottom.addMember(agreeButton);
//		bottom.addMember(disagreeButton);
//		agreeButton.addClickHandler(new ClickHandler() {  
//            public void onClick(ClickEvent event) { 
//				SC.ask("提示", "确认同意该预分配方案吗?", new BooleanCallback() {
//					@Override
//					public void execute(Boolean value) {
//						if(value==true) {
//							Map<String,Object> param =new HashMap<>();
//							param.put("employeeId", ClientUtil.getUserId());//被审批人
//							param.put("projectId", projectId);
//							param.put("status",2);
//							param.put("optType","onSaveOrUpdateStageStatus");
//							DBDataSource.callOperation("EP_OnProjectCommonProcess", param, new DSCallback() {
//								@Override
//								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//									if (dsResponse.getStatus() >= 0) {
//										startEdit();
//										SC.say("保存成功");
//									}else {
//										ClientUtil.displayErrorMessage(dsResponse);
//									}
//								}
//							});
//							
//						}
//					}
//				});
//            }  
//        });  
//		
//		
//		disagreeButton.addClickHandler(new ClickHandler() {  
//            public void onClick(ClickEvent event) { 
//				SC.ask("提示", "确认同意该预分配方案吗?", new BooleanCallback() {
//					@Override
//					public void execute(Boolean value) {
//						if(value==true) {
//							Map<String,Object> param =new HashMap<>();
//							param.put("employeeId", ClientUtil.getUserId());//被审批人
//							param.put("projectId", projectId);
//							param.put("status",3);
//							param.put("optType","onSaveOrUpdateStageStatus");
//							DBDataSource.callOperation("EP_OnProjectCommonProcess", param, new DSCallback() {
//								@Override
//								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//									if (dsResponse.getStatus() >= 0) {
//										startEdit();
//										SC.say("保存成功");
//									}else {
//										ClientUtil.displayErrorMessage(dsResponse);
//									}
//								}
//							});
//							
//						}
//					}
//				});
//            }  
//        }); 
		
		leftLayout.addMember(grid);
//		leftLayout.addMember(bottom);
		
	}
	
	/**
	 * 设置阶段信息
	 */
	private void setViewValue(){
		//获取当前阶段的数据集
		Record record = stageMap.get(currentStageId);
		//设置当前阶段的信息
		stageNameView.setValue(record.getAttribute("stageName"));
		//获取阶段积分
		BigDecimal stageIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("projectAmount"));
		stageIntegralView.setValue(stageIntegral);
		//获取阶段已分配积分
		BigDecimal stagePlanIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("stagePlanIntegral"));
		//设置阶段剩余积分=阶段积分-阶段已分配积分
		BigDecimal stageLeftIntegral = BaseHelpUtils.format(stageIntegral.subtract(stagePlanIntegral),2);
		stageLeftIntegralView.setValue(stageLeftIntegral);
	}
	

	
	@Override
	public void startEdit() {
		if (getPageMode() != PAGE_MODE_UPDATE) {
			return;
		}
		stageMap.clear();
		Record record = getRecord();
		projectId = BaseHelpUtils.getIntValue(record.getAttribute("projectId"));
		Map<String,Object> condition = new HashMap<>();
		int projectId = BaseHelpUtils.getIntValue(record.getAttribute("projectId"));
		condition.put("projectId",projectId);
		condition.put("employeeId", ClientUtil.getUserId());
		DBDataSource.callOperation("NQ_OnLoadProjectStageSettlement", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					if(!BaseHelpUtils.isNullOrEmpty(records)){
						int len = records.length;
						DataSource gridDataSource = new DataSource();
						DataSourceTextField projectIdField = new DataSourceTextField("projectId","项目Id");
						projectIdField.setHidden(true);
						gridDataSource.addField(projectIdField);
						
						DataSourceTextField employeeIdField = new DataSourceTextField("employeeId","项目成员Id");
						employeeIdField.setHidden(true);
						gridDataSource.addField(employeeIdField);
						
						DataSourceTextField employeeNoField = new DataSourceTextField("employeeNo","员工编号");
						gridDataSource.addField(employeeNoField);
						
						DataSourceTextField employeeNameField = new DataSourceTextField("employeeName","员工姓名");
						gridDataSource.addField(employeeNameField);
						
						DataSourceTextField gradeIdField = new DataSourceTextField("gradeId","职级");
						gradeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));
						gridDataSource.addField(gradeIdField);
						
						HeaderSpan[] headerSpanArr = new HeaderSpan[len+1];
						for(int i = 0;i<len;i++){
							Record record = records[i];
							int stageId = BaseHelpUtils.getIntValue(record.getAttribute("stageId"));
							String stageName = BaseHelpUtils.getString(record.getAttribute("stageName"));
							//获取阶段确认函数
							int attachmentNum = BaseHelpUtils.getIntValue(record.getAttribute("attachmentNum"));
							if(currentStageId == -1){
								if(attachmentNum == 0){//说明当前阶段没上传确认函，即还在结算中
									currentStageId = stageId;
								}
							}
							stageMap.put(stageId,records[i]);
							DataSourceFloatField planField = new DataSourceFloatField();
							planField.setName("planIntegral_"+stageId);
							planField.setTitle("预分配积分");
							planField.setLength(18);
							planField.setDecimalPad(2);
							planField.setFormat("#,###,###,###,##0.00");
							planField.setEmptyDisplayValue("0");
							gridDataSource.addField(planField);
							
							DataSourceFloatField lastPlanField = new DataSourceFloatField();
							lastPlanField.setName("lastPlanIntegral_"+stageId);
							lastPlanField.setTitle("变动前预分配积分");
							lastPlanField.setLength(18);
							lastPlanField.setDecimalPad(2);
							lastPlanField.setFormat("#,###,###,###,##0.00");
							lastPlanField.setEmptyDisplayValue("0");
							gridDataSource.addField(lastPlanField);
							
							DataSourceFloatField sureField = new DataSourceFloatField();
							sureField.setName("sureIntegral_"+stageId);
							sureField.setTitle("确认积分");
							sureField.setLength(18);
							sureField.setDecimalPad(2);
							sureField.setFormat("#,###,###,###,##0.00");
							sureField.setEmptyDisplayValue("0");
							gridDataSource.addField(sureField);
	
							DataSourceTextField buttonField = new DataSourceTextField();
							buttonField.setName("status_"+stageId);
							buttonField.setTitle("状态");
							gridDataSource.addField(buttonField);
							
							HeaderSpan headerSpan = new HeaderSpan(stageName, new String[] {"lastPlanIntegral_"+stageId,"planIntegral_"+stageId,"sureIntegral_"+stageId,"status_"+stageId});
							headerSpanArr[i] = headerSpan;
							
						}
						//添加合计
						DataSourceFloatField planTotalField = new DataSourceFloatField("planTotal","预分配积分");
						planTotalField.setLength(18);
						planTotalField.setDecimalPad(2);
						planTotalField.setFormat("#,###,###,###,##0.00");
						planTotalField.setEmptyDisplayValue("0");
						gridDataSource.addField(planTotalField);
						
						DataSourceFloatField sureTotalField = new DataSourceFloatField("sureTotal","确认积分");
						sureTotalField.setLength(18);
						sureTotalField.setDecimalPad(2);
						sureTotalField.setFormat("#,###,###,###,##0.00");
						sureTotalField.setEmptyDisplayValue("0");
						gridDataSource.addField(sureTotalField);
						HeaderSpan headerSpan = new HeaderSpan("合计", new String[] {"planTotal","sureTotal"});
						headerSpanArr[len] = headerSpan;
						
						grid.setHeaderSpans(headerSpanArr);
						grid.setDataSource(gridDataSource);
						//加载项目成员信息
						getEmpData(condition);
						//判断是否匹配标准人员数
						if(isNeed){
							//加载页面时根据项目的归属业务部门和项目等级去获取匹配的人员配置数据集
							loadTalentsMinimumArrangement();
						}
						//默认显示第一个阶段的信息
						setViewValue();
					}
				}
			}
		});
		
	}
	
	/**
	 * 加载页面时根据项目的归属业务部门和项目等级去获取匹配的人员配置数据集
	 */
	private void loadTalentsMinimumArrangement(){
		Map<String,Object> param = new HashMap<>();
		Record record = getRecord();
		if(record == null){
			return;
		}
		int plateId = BaseHelpUtils.getIntValue(record.getAttribute("plateId"));
		param.put("plateId", plateId);
		String str;
		if(plateId == 4){
			param.put("projectType", record.getAttribute("projectType"));
			param.put("maxAmount", record.getAttribute("moneySum"));
			param.put("minAmount", record.getAttribute("moneySum"));
			str = "NQ_Stracktalentsminimumarrangementmmpor";
		}
		else{
			param.put("projectLevel", record.getAttribute("projectLevel"));
			str = "ST_TalentsMinimumArrangement";
		}
		DBDataSource.callOperation(str, "find", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				searchButton.setIcon("[SKIN]/actions/search.png");
				if (dsResponse.getStatus() >= 0) {
					if(dsResponse.getData()[0] != null){
						//获取匹配的高级设计师数
						int highDesignerValue = BaseHelpUtils.getIntValue(dsResponse.getData()[0].getAttribute("highDesigner"));
						int middleDesignerValue = BaseHelpUtils.getIntValue(dsResponse.getData()[0].getAttribute("middleDesigner"));
						int initialDesignerValue = BaseHelpUtils.getIntValue(dsResponse.getData()[0].getAttribute("initialDesigner"));
						result.put("highDesigner",highDesignerValue);
						result.put("middleDesigner", middleDesignerValue);
						result.put("initialDesigner",initialDesignerValue);
					}
				}
			}
		});
		return;
	}

	//加载成员列表信息
	public void getEmpData(Map<String,Object> condition){
		DBDataSource.callOperation("NQ_OnLoadProjectEmpAndStage", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
						//定义map来存放每个成员的数据集
						Map<Integer,Record> map = new HashMap<>();
						for(Record e : records){
							int projectId = BaseHelpUtils.getIntValue(e.getAttribute("projectId"));
							//状态值
							int status = BaseHelpUtils.getIntValue(e.getAttribute("status"));
							//获取职员Id
							int employeeId = BaseHelpUtils.getIntValue(e.getAttribute("employeeId"));
							//获取阶段Id
							int stageId = BaseHelpUtils.getIntValue(e.getAttribute("stageId"));
							//获取该成员在阶段上的预分配积分
							BigDecimal planIntegral = BaseHelpUtils.getBigDecimalValue(e.getAttribute("planIntegral"));
							//获取该成员在阶段上已经确认的积分
							BigDecimal sureIntegral = BaseHelpUtils.getBigDecimalValue(e.getAttribute("sureIntegral"));
							//获取该成员在阶段上的上一次预分配积分
							BigDecimal lastPlanIntegral = BaseHelpUtils.getBigDecimalValue(e.getAttribute("alternateField1"));
							Record record = map.get(employeeId);
							if(BaseHelpUtils.isNullOrEmpty(record)){
								record = new Record();
								record.setAttribute("projectId", projectId);
								record.setAttribute("employeeId", employeeId);
								record.setAttribute("employeeNo",e.getAttribute("employeeNo"));
								record.setAttribute("employeeName",e.getAttribute("employeeName"));
								record.setAttribute("gradeId", e.getAttribute("gradeId"));
							}
							record.setAttribute("planIntegral_"+stageId,planIntegral);
							record.setAttribute("lastPlanIntegral_"+stageId,lastPlanIntegral);
							record.setAttribute("sureIntegral_"+stageId,sureIntegral);
							BigDecimal planTotal = BaseHelpUtils.getBigDecimalValue(record.getAttribute("planTotal"));
							record.setAttribute("planTotal",planTotal.add(planIntegral));
							BigDecimal sureTotal = BaseHelpUtils.getBigDecimalValue(record.getAttribute("sureTotal"));
							record.setAttribute("sureTotal",sureTotal.add(sureIntegral));
							if(status==1) {
								record.setAttribute("status_"+stageId,1);
							}else if(status==2) {
								record.setAttribute("status_"+stageId,2);
							}else if(status==3) {
								record.setAttribute("status_"+stageId,3);
							}
							map.put(employeeId,record);
							//如果确认积分不为0，说明已经有确认积分，则不可删除该成员
							if(sureIntegral.compareTo(BigDecimal.ZERO) != 0){
								notCanDeleteMap.put(employeeId,Boolean.FALSE);
							}
						}
						int size = map.size();
						if(size > 0){
							Record[] resultData = new Record[size];
							int i = 0;
							for(Integer empId : map.keySet()){
								resultData[i] = map.get(empId);
								int gradeId = BaseHelpUtils.getIntValue(resultData[i].getAttribute("gradeId"));
								setDesigner(gradeId);
								i++;
							}
							grid.setData(resultData);
						}
					}
					ListGridField field = grid.getField("employeeId");
					if (field != null) {
						field.setAutoFreeze(true);
					}
				}
			}
		});
	}
	
	
	/**
	 * 设置设计师个数
	 * @param gradeId
	 */
	private void setDesigner(int gradeId){
		if(isNeed){
			if(gradeId == 1 || gradeId == 2 || gradeId == 3){
				highDesigner++;
			}else if(gradeId == 4 || gradeId == 5 || gradeId == 6){
				middleDesigner++;
			}else if(gradeId == 7 || gradeId == 8 || gradeId == 9){
				initialDesigner++;
			}
		}
	}

	
	@Override
	public boolean checkData() {
		for (ListGridRecord r : grid.getRecords()) {
			__logger.info(MapUtils.convertRecordToMap(grid.getDataSource(), r).toString());
		}
		return true;
	}

	@Override
	public java.util.Map<String,Object> getValuesAsMap() {
		return null;
	}

	
	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSprojectteambuild.getInstance());
	}
	
}
