package com.pomplatform.client.project.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.NewProcessWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.storage.client.Storage;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.projectStageStorage.datasource.DSSprojectstagestorageor;
import com.pomplatform.client.stage.datasource.DSSsystemdictionaryor;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class StageOfPlanningPanel extends HLayout implements HasHandlers {

	private Window parentWindow;
    //订单表查询(业务部门，项目类别，业务类别)plate_id,project_type,business_type
    private String plateId;
    private String projectType;
    private String businessType;
    private String projectName;
	private BigDecimal projectIntegral2;
	private int projectId;
	
    private  DelicacyListGrid grid = new DelicacyListGrid();
    private  DelicacyListGrid SourceGrid = new DelicacyListGrid();
    private  DynamicForm form;
    private  DynamicForm form2;
    private  DynamicForm form3;
    private int countPercent = 0;
    
    // 0:自定义   1:模板
    private int booleanGridStageStorageor ;
    private BigDecimal projectIntegral;
    private BigDecimal settlementIntegral;
    private int attachmentNum;
    private String oldValue = null;
    private TextItem projectIntegralLeftItem;
    private TextItem projectIntegralItem;
    private TextItem projectNameItem;
    private TextItem remarkItem;
    private SelectItem projectStageTemplateItem = null;
    private IButton okButton;
    private IButton closeButton;
    private Map<String,Object> contrastMap;



	public void initComponents(Map<String,Object> map) {

        VLayout SearchSourceLayout = new VLayout();
        SearchSourceLayout.setWidth("50%");
        SearchSourceLayout.setHeight100();
        SearchSourceLayout.setLayoutTopMargin(10);
        SearchSourceLayout.setLayoutRightMargin(5);
        SearchSourceLayout.setMembersMargin(10);
        SearchSourceLayout.setShowResizeBar(false);
        
        HLayout SourceLayout = new HLayout(5);
        SourceLayout.setWidth100();
        SourceLayout.setHeight100();
        SearchSourceLayout.addMember(SourceLayout);
        SourceGrid.setAutoFitFieldWidths(false);
        SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        SourceGrid.setDataSource(DSSsystemdictionaryor.getInstance());
        SourceLayout.addMember(SourceGrid);
        
        VLayout SourceControls = new VLayout();
        SourceControls.setHeight100();
        SourceControls.setWidth(60);
        SourceControls.setLayoutTopMargin(150);
        SourceControls.setLayoutLeftMargin(15);
        SourceControls.setLayoutRightMargin(5);
        SourceControls.setMembersMargin(10);
        SourceLayout.addMember(SourceControls);
		TransferImgButton AddToButton = new TransferImgButton(TransferImgButton.RIGHT);
        SourceControls.addMember(AddToButton);
        AddToButton.addClickHandler(new ClickHandler() {
        @Override
        public void onClick(ClickEvent event) {
            if (!SourceGrid.anySelected()) {
                return;
            }
            //项目积分为0的话，不能添加阶段
            if(BaseHelpUtils.getIntValue(map.get("projectIntegral")) == 0){
            	SC.say("提示","项目积分为0，无法添加阶段");
            	return;
            }
            //非自定义模板不能添加阶段BaseHelpUtils.getIntValue(projectStageTemplateItem.getValue())
            if(BaseHelpUtils.getIntValue(projectStageTemplateItem.getValue()) != 1){
            	SC.say("提示","非自定义模板，无法添加阶段");
            	return;
            }
            //自定义模板审批流程中不予添加阶段
            if(booleanGridStageStorageor==0){
            	SC.say("提示","自定义模板审批流程中，现不予添加阶段");
            	return;
            }
            addSelectedDataToTarget(SourceGrid, grid);
        }
        });
        SourceGrid.addDoubleClickHandler(new DoubleClickHandler() {
        @Override
        public void onDoubleClick(DoubleClickEvent event) {
            if (!SourceGrid.anySelected()) {
                return;
            }
            //项目积分为0的话，不能添加阶段
            if(BaseHelpUtils.getIntValue(map.get("projectIntegral")) == 0){
            	SC.say("提示","项目积分为0，无法添加阶段");
            	return;
            }
            //非自定义模板不能添加阶段BaseHelpUtils.getIntValue(projectStageTemplateItem.getValue())
            if(BaseHelpUtils.getIntValue(projectStageTemplateItem.getValue()) != 1){
            	SC.say("提示","非自定义模板，无法添加阶段");
            	return;
            }
            //自定义模板审批流程中不予添加阶段
            if(booleanGridStageStorageor==0){
            	SC.say("提示","自定义模板审批流程中，现不予添加阶段");
            	return;
            }
            addSelectedDataToTarget(SourceGrid, grid);
        }
        });
        addMember(SearchSourceLayout);
        
        VLayout rightLayout = new VLayout(10);
        rightLayout.setWidth("50%");
        rightLayout.setHeight100(); 
        
        HLayout infoLayout = new HLayout(10);
        infoLayout.setWidth("90%");
        infoLayout.setHeight("10%");
        infoLayout.setLayoutTopMargin(30);
        
        projectNameItem = new TextItem("projectName","订单名称");
        projectNameItem.setWidth("*");
        projectNameItem.setValue(map.get("projectName"));
        projectNameItem.setCanEdit(false);
        
        projectIntegralItem = new TextItem("projectIntegral","项目积分");
        projectIntegralItem.setWidth("*");
        projectIntegralItem.setValue(map.get("projectIntegral"));
        projectIntegralItem.setCanEdit(false);
        
        projectIntegralLeftItem = new TextItem("projectIntegralLeft","剩余积分");
        projectIntegralLeftItem.setWidth("*");
        projectIntegralLeftItem.setCanEdit(false);
        projectIntegral = BaseHelpUtils.getBigDecimalValue(projectIntegralItem.getValue());
        
        form = new DynamicForm();
        form.setNumCols(8);
        form.setWidth100();
        form.setHeight100();
        form.setItems(projectNameItem,projectIntegralItem,projectIntegralLeftItem);
        projectNameItem.setColSpan(3);
        infoLayout.addMember(form);
        rightLayout.addMember(infoLayout);
        
        //阶段模板
        HLayout infoLayout2 = new HLayout(10);
        infoLayout2.setWidth("90%");
        infoLayout2.setHeight("10%");
        infoLayout2.setLayoutTopMargin(30);
        projectStageTemplateItem = new SelectItem("projectTemplateId", "阶段模板");
        projectStageTemplateItem.setWidth("*");
        projectStageTemplateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
					
				if(booleanGridStageStorageor==1) {
					LinkedHashMap<String,Object> params = new LinkedHashMap<>();
					params.put("optType", "onGetStageOfPlanning");
					params.put("projectIntegral", BaseHelpUtils.getIntValue(projectIntegralItem.getValue()));
					params.put("projectTemplateId",BaseHelpUtils.getIntValue(projectStageTemplateItem.getValue()));
					DBDataSource.callOperation("EP_OnProjectCommonProcess", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								RecordList dataAsRecordList = dsResponse.getDataAsRecordList();
								grid.setData(dataAsRecordList);
								grid.redraw();
							} else {
								SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
							}
						}
					});
				}else {
					SC.say("该项目处于自定义模板审批流程，现不予修改");
				}
			}
		});
        
        form2 = new DynamicForm();
        form2.setNumCols(4);
        form2.setWidth100();
        form2.setHeight(20);
        form2.setItems(projectStageTemplateItem);
        rightLayout.addMember(form2);
        
        //remarkItem
        HLayout infoLayout3 = new HLayout(10);
        infoLayout3.setWidth("90%");
        infoLayout3.setHeight("10%");
        infoLayout3.setLayoutTopMargin(30);
        remarkItem = new TextItem("remark", "备注");
        remarkItem.setDefaultValue("自定义模板使用");
        remarkItem.setWidth(500);
        remarkItem.setHeight(200);
        form3 = new DynamicForm();
        form3.setWidth100();
        form3.setHeight(200);
        form3.setItems(remarkItem);
        rightLayout.addMember(form3);
        
        
        HLayout projectStages = new HLayout();
        projectStages.setWidth100();
        projectStages.setHeight("90%");
        projectStages.setLayoutLeftMargin(20);
        grid.setCanReorderRecords(true);
        grid.setAutoFitFieldWidths(false);
        grid.setShowGridSummary(true);
        grid.setShowRowNumbers(true);
        grid.setCanRemoveRecords(true);
        projectStages.addMember(grid);
        
        VLayout projectStagesControls = new VLayout();
        projectStagesControls.setHeight100();
        projectStagesControls.setWidth(60);
        projectStagesControls.setLayoutTopMargin(30);
        projectStagesControls.setLayoutLeftMargin(5);
        projectStagesControls.setLayoutRightMargin(5);
        projectStagesControls.setMembersMargin(10);
        projectStages.addMember(projectStagesControls);
        rightLayout.addMember(projectStages);
        
        HLayout btnLayout = new HLayout(10);
		btnLayout.setWidth100();
		btnLayout.setHeight("5%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);
        okButton =new IButton("提交");
        okButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(BaseHelpUtils.isNullOrEmpty(grid.getRecords())||grid.getRecords().length<=0){ SC.say("异常操作:阶段不能为空"); return;}
				//1:自定义流程
		        int projectStageTemplateId = BaseHelpUtils.getIntValue( projectStageTemplateItem.getValue());
				if(projectStageTemplateId==1) {
					LinkedHashMap<String,Object> params = new LinkedHashMap<>();
					Record record = new Record();
					ListGridRecord[] rows = grid.getRecords();
			        if(!BaseHelpUtils.isNullOrEmpty(rows)&&rows.length>0) {
//			        	for (ListGridRecord listGridRecord : rows) {
			        	for (int i = 0; i < rows.length; i++) {
			        		ListGridRecord listGridRecord = rows[i];
			        		record.setAttribute(i+"", listGridRecord.getAttribute("stageId")+","+listGridRecord.getAttribute("stageName")+","+listGridRecord.getAttribute("percent")+","+listGridRecord.getAttribute("projectAmount"));
						}
			        	record.setAttribute("remark", remarkItem.getValue());
			        	record.setAttribute("projectId", BaseHelpUtils.getIntValue(map.get("projectId")));
			        	record.setAttribute("number",rows.length);
			        	record.setAttribute("projectName",map.get("projectName"));
			        	record.setAttribute("projectIntegral",map.get("projectIntegral"));
			        	record.setAttribute("projectManageId",map.get("projectManageId"));
			        	record.setAttribute("contractCode",map.get("contractCode"));
			        }
					NewProcessWindow panel=new NewProcessWindow();
					panel.setTitle("自定义项目阶段模板审批");
//					panel.setProcessId(ClientUtil.checkAndGetIntValue(gerProcessId("Project_stages_process")));
					panel.setProcessId(185);
					panel.setData(record);
					panel.setLayoutMode(0);
					panel.initComponents();
					panel.setWidth("65%");
					panel.setHeight("65%");
					panel.centerInPage();
					panel.show();
					
				/*	else if(projectStageTemplateId==1){
			        	params.put("optType", "SaveApprovalProcess");
			        }*/
				}else {
					java.util.Map params = new java.util.HashMap();
			        ListGridRecord[] rows = grid.getRecords();
			        if(!BaseHelpUtils.isNullOrEmpty(rows)&&rows.length>0) {
			        	for (ListGridRecord listGridRecord : rows) {
			        		listGridRecord.setAttribute("remark", remarkItem.getValue());
						}
			        }
			        int projectId=BaseHelpUtils.getIntValue(map.get("projectId"));
			        MapUtils.convertRecordToMap(grid.getDataSource(), rows, params, "detailProjectStage");
			        params.put("remark",remarkItem.getValue());
			        params.put("projectId",projectId);
			        params.put("projectTemplate",projectStageTemplateId);
			        if(projectStageTemplateId>1) {
			        	params.put("optType", "UpdateProjectWithStage");
			        }else {
			        	params.put("optType", "NoChangProjectWithStage");
			        }
			        
					DBDataSource.callOperation("EP_OnProjectWithStageCommon", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								SC.say("提交成功");
							}else {
								SC.say(dsResponse.getErrors().get("errorMsg").toString());
							}
						}
					});
				}
				
			}
		});
        closeButton=new IButton("关闭");
        closeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (getParentWindow() == null) {
					return;
				}
				getParentWindow().destroy();
				DataEditEvent dee = new DataEditEvent();
				fireEvent(dee);
			}
		});
        btnLayout.addMember(okButton);
        btnLayout.addMember(closeButton);
        rightLayout.addMember(btnLayout);
        
        grid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
			@Override
			public void onRemoveRecordClick(RemoveRecordClickEvent event) {
				Record record = grid.getSelectedRecord();
				Record[] oldData = grid.getRecords();
				Map<String,Object> params = new HashMap<>();
				params.put("projectId", record.getAttribute("projectId"));
				params.put("stageId", record.getAttribute("stageId"));
				DBDataSource.callOperation("ST_ProjectSettlement","find", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							Record[] result = dsResponse.getData();
							if(!BaseHelpUtils.isNullOrEmpty(result) && result.length > 0){
								grid.setData(oldData);
								grid.redraw();
								SC.say("提示","该阶段已有确认积分，无法删除");
							}else{
								BigDecimal projectAmount = BaseHelpUtils.getBigDecimalValue(record.getAttribute("projectAmount"));
								BigDecimal projectIntegralLeft = BaseHelpUtils.getBigDecimalValue(projectIntegralLeftItem.getValue());
								projectIntegralLeftItem.setValue(projectAmount.add(projectIntegralLeft));
							}
						}
					}
				});
			}
		});
        
        grid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				ListGridRecord selected = grid.getSelectedRecord();
				ListGridRecord[] gridData = grid.getRecords();
				
				Map<String,Object> params = new HashMap<>();
				if(!BaseHelpUtils.isNullOrEmpty(selected)){
					params.put("projectId", selected.getAttribute("projectId"));
					params.put("stageId", selected.getAttribute("stageId"));
					DBDataSource.callOperation("NQ_OnLoadProjectStageSettlement", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								oldValue = "";
								Record record = dsResponse.getData()[0];
								if(!BaseHelpUtils.isNullOrEmpty(record)){
									attachmentNum = record.getAttributeAsInt("attachmentNum");
									if(!BaseHelpUtils.isNullOrEmpty(record.getAttribute("settlementIntegral"))){
										settlementIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("settlementIntegral"));
									}else{
										settlementIntegral = BigDecimal.ZERO;
									}
									if(attachmentNum > 0){
										SC.say("提示","该阶段已确认，不能再修改");
										return;
									}
								}
								countPercent = 0;
								for(ListGridRecord e : gridData){
									countPercent += BaseHelpUtils.getIntValue(e.getAttribute("percent"));
								}
								if(!BaseHelpUtils.isNullOrEmpty(selected.getAttribute("percent"))){
									countPercent = countPercent - BaseHelpUtils.getIntValue(selected.getAttribute("percent"));
								}
								if(!BaseHelpUtils.isNullOrEmpty(selected.getAttribute("percent"))){
									oldValue = BaseHelpUtils.getString(selected.getAttribute("percent"));
								}
								SC.askforValue("阶段占比:", new ValueCallback() {
									
									@Override
									public void execute(String value) {
										if(BaseHelpUtils.isNullOrEmpty(value)){
											value = oldValue;
										}else{
											if(BaseHelpUtils.getIntValue(value) < 0){
												SC.say("提示","该阶段占比不可为负数");
												value = oldValue;
											}else if(BaseHelpUtils.getIntValue(value) == 0){
												SC.say("提示","阶段占比不可等于0或不可输入小数点");
												value = oldValue;
											}
										}
										if(!BaseHelpUtils.isNullOrEmpty(settlementIntegral)){
											if(settlementIntegral.compareTo(BigDecimal.ZERO) > 0 && attachmentNum == 0 && BaseHelpUtils.getIntValue(value) < BaseHelpUtils.getIntValue(oldValue)){
												SC.say("提示","该阶段已在确认积分，阶段占比不可减少");
												return;
											}
										}
										int add = countPercent + BaseHelpUtils.getIntValue(value);
										if(add > 100){
											SC.say("提示","阶段总占比不能大于100%");
											return;
										}
										selected.setAttribute("percent", BaseHelpUtils.getIntValue(value));
										//阶段占比
										BigDecimal percent = BaseHelpUtils.getBigDecimalValue(value).divide(BigDecimal.valueOf(100));
										//阶段积分
										BigDecimal projectAmount = BaseHelpUtils.format(projectIntegral.multiply(percent), 2);
										selected.setAttribute("projectAmount", projectAmount);
										BigDecimal projectUsed = BigDecimal.ZERO;
										for(ListGridRecord e : gridData){
											//已分配积分
											projectUsed = projectUsed.add(BaseHelpUtils.getBigDecimalValue(e.getAttribute("projectAmount")));
										}
										//剩余积分
										BigDecimal leftIntegral = projectIntegral.subtract(projectUsed);
										//如果当前阶段总和为100,且剩余积分存在残余数据，则追加到当前阶段上
										if(add == 100 && leftIntegral.compareTo(BigDecimal.ZERO) != 0){
											projectAmount = projectAmount.add(leftIntegral);
											leftIntegral = BigDecimal.ZERO;
											selected.setAttribute("projectAmount", projectAmount);
										}
										grid.updateData(selected);
										//剩余积分
										projectIntegralLeftItem.setValue(leftIntegral);
									}
								});
							}
						}
					});
				}
			}
		});
        addMember(rightLayout);
        reloadProjectTemplate(map);
        booleanGridDateSource(map);
        reloadSource(SourceGrid, null);

	}



	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	private int contractId;
	private int stageId;

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public int getStageId() {
		return stageId;
	}

	public void setStageId(int stageId) {
		this.stageId = stageId;
	}
	
	
    public void startEdit(int projectId) {
        Map condition = new HashMap();
        //加载项目每个阶段已确认积分
        condition.clear(); 
        condition.put("projectId",projectId);
        DBDataSource.callOperation("NQ_OnLoadProjectStageSettlement", "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    grid.setData(dsResponse.getData());
                    //加载项目积分，剩余积分
                    Record[] records = dsResponse.getData();
                    BigDecimal projectUsed = BigDecimal.ZERO;
                    for(Record record : records){
                    	//已分配积分
						projectUsed = projectUsed.add(BaseHelpUtils.getBigDecimalValue(record.getAttribute("projectAmount")));
                    }
                    //剩余积分
                    projectIntegralLeftItem.setValue(projectIntegral.subtract(projectUsed));
                }
            }
        });
        
    }

	//获取流程ID
	public String gerProcessId(String workName) {
		String processId = "";
		Storage sta = Storage.getLocalStorageIfSupported();
							String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
		if(!PomPlatformClientUtil.isNullOrEmpty(str)){
			String[] arr = str.split(",");
			for(String tempStr : arr){
				String[] tempArr = tempStr.split(":");
				//获取父级ID
				if(tempArr[0].replaceAll("\"", "").equals(workName)){
					processId = tempArr[1];
				}
			}
		}
		return processId;
	}
	
	
    public void reloadSourceData() {
        Criteria condition = new Criteria();
        reloadSource(SourceGrid, condition);
    }

    private void reloadSource(final ListGrid source, Criteria condition) {
        if (condition == null) {
            condition = new Criteria();
        }
        FormItem item;
        Object val = null;
        DBDataSource.callOperation("NQ_Ssystemdictionaryor", "find", condition.getValues(), new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    source.setData(dsResponse.getData());
                }
            }
        });
    }
	
    //加载阶段模板
    private void reloadProjectTemplate(Map<String,Object> map) {
    	LinkedHashMap<String,Object> params = new LinkedHashMap<>();
		params.put("projectId",map.get("projectId"));
		params.put("plateId",map.get("plateId"));
		params.put("projectType",map.get("projectType"));
		params.put("optType", "onReloadProjectTemplate");
		DBDataSource.callOperation("EP_OnProjectCommonProcess", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] record = dsResponse.getData();
					Map<Integer,Object> valueMap = new HashMap<>();
					valueMap.put(1, "自定义模板");
					if(!BaseHelpUtils.isNullOrEmpty(record) && record.length > 0) {
						for (Record re : record) {
							String projectTemplateId = re.getAttribute("projectTemplateId");
							String projectTemplateName = re.getAttribute("projectTemplateName");
							valueMap.put(BaseHelpUtils.getIntValue(projectTemplateId), projectTemplateName);
						}
					}
					projectStageTemplateItem.setValueMap(valueMap);
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
				}
			}
		});
    	 
	}
	
    //判断该项目是否属于审批流程中，   booleanGridStageStorageor   是:0提示不允许修改并显示数据    否:1显示数据   
    private void booleanGridDateSource(Map<String,Object> map) {
    	LinkedHashMap<String,Object> params = new LinkedHashMap<>();
    	params.put("projectId",map.get("projectId"));
    	params.put("optType", "BooleanGridDateSource");
    	DBDataSource.callOperation("EP_OnProjectWithStageCommon", params, new DSCallback() {
    		@Override
    		public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
    			if (dsResponse.getStatus() >= 0) {
    				Record[] records = dsResponse.getData();
    				if(!BaseHelpUtils.isNullOrEmpty(records)&&records.length>0) {
    					grid.setDataSource(DSSprojectstagestorageor.getInstance());
    					grid.setData(dsResponse.getDataAsRecordList());
    					remarkItem.setValue(records[0].getAttribute("remark"));
    					booleanGridStageStorageor=0;
    				}else {
    			        grid.setDataSource(DSSprojectstagestorageor.getInstance());
    			        startEdit(BaseHelpUtils.getIntValue(map.get("projectId")));
    			        booleanGridStageStorageor=1;
    				}
    				
    				
    			} else {
    				SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
    			}
    		}
    	});
    	
    }
	
    private void addSelectedDataToTarget(ListGrid source, ListGrid target) {
        ListGridRecord[] selectedRecords = source.getSelectedRecords();
        RecordList originalList = target.getDataAsRecordList();
        FormItem item;
        int originalLength = originalList.getLength();
        RecordList newList = new RecordList();
        if (originalLength > 0) {
            newList.addList(originalList.getRange(0, originalLength));
        }
        for (ListGridRecord selectedRecord : selectedRecords) {
            Map searchMap = new HashMap();
            searchMap.put("projectId", selectedRecord.getAttribute("projectId"));
            searchMap.put("stageId", selectedRecord.getAttribute("dicTypeValueId"));
            searchMap.put("stageName", selectedRecord.getAttribute("dicTypeValue"));
            if (originalLength > 0) {
                int index = originalList.findIndex(searchMap);
                if (index != -1) {
                    continue;
                }
            }
            newList.add(new Record(searchMap));
        }
        target.setData(newList);
    }

	
	public String getPlateId() {
		return plateId;
	}

	public void setPlateId(String plateId) {
		this.plateId = plateId;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public BigDecimal getProjectIntegral2() {
		return projectIntegral2;
	}

	public void setProjectIntegral2(BigDecimal projectIntegral2) {
		this.projectIntegral2 = projectIntegral2;
	}
	


}
