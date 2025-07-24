package com.pomplatform.client.attentionsupplierinfo.panel;

import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.AttentionWindow;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.attentionprojectquotetemplate.form.AttentionProjectQuoteTemplateViewer;
import com.pomplatform.client.attentionsupplierinfo.datasource.DSAttentionSupplierInfo;
import com.pomplatform.client.attentionsupplierinfo.form.AttentionSupplierInfoSearchForm;
import com.pomplatform.client.attentionsupplierinfo.form.AttentionSupplierInfoViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

public class AttentionSupplierInfoPanel extends AbstractSearchPanel
{

	private static final Logger __LOGGER = Logger.getLogger("");
	private static IButton agreeButton;
	private static IButton batchAgreeButton;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			AttentionSupplierInfoPanel cm = new AttentionSupplierInfoPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AttentionSupplierInfo";
		}

	}

	@Override
	public void init(){
		super.init();
		super.init();
		int index = 0;
		ListGridField[] fields = new ListGridField[14];
		fields[index] = new ListGridField("supplierId");
		fields[index].setHidden(true);
		index++;
		fields[index] = new ListGridField("supplierName");
		index++;
		fields[index] = new ListGridField("supplierContact");
		index++;
		fields[index] = new ListGridField("supplierPhone");
		index++;
		fields[index] = new ListGridField("supplierEmail");
		index++;
		fields[index] = new ListGridField("teamSize");
		index++;
		fields[index] = new ListGridField("areasExpertise");
		KeyValueManager.loadValueMap("system_dictionary_213", fields[index]);
		index++;
		fields[index] = new ListGridField("fileUrl","附件");
		fields[index].setCanEdit(false);
		fields[index].setLinkText("相关文件下载/预览");
		index++;
		fields[index] = new ListGridField("operateEmployeeId");
		KeyValueManager.loadValueMap("employees",fields[index]);
		index++;
		fields[index] = new ListGridField("operateTime");
		index++;
		fields[index] = new ListGridField("isUse");
		fields[index].setAlign(Alignment.CENTER);
		LinkedHashMap<Integer, String> linkMap=new LinkedHashMap<>();
		linkMap.put(0, "无效");
		linkMap.put(1, "有效");
		fields[index].setValueMap(linkMap);
		index++;
		fields[index] = new ListGridField("status");
		KeyValueManager.loadValueMap("system_dictionary_38",fields[index]);
		resultGrid.setAutoFitFieldWidths(true);
		resultGrid.setFields(fields);
		resultGrid.setDataSource(getDataSource());
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		agreeButton = new IButton("批阅");
		controlLayout.addMember(agreeButton);
		agreeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	if (!resultGrid.anySelected()) {
                    SC.say("please select a record to edit");
                    return;
                }
                ListGridRecord selected = resultGrid.getSelectedRecord();
                AttentionWindow Reimbursement = new AttentionWindow();
                Reimbursement.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        commonQuery();
                    }

                });
                Reimbursement.setLayoutMode(0);
                Reimbursement.setInstanceData(selected);
                Reimbursement.initComponents();
                if(processType == 42){
                	Reimbursement.setWidth("50%");
					Reimbursement.setHeight100();
                }
				Reimbursement.centerInPage();
                Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
                Reimbursement.show();
            }
        });
		
		batchAgreeButton = new IButton("批量已阅");
        controlLayout.addMember(batchAgreeButton);
        batchAgreeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	final ListGridRecord[] records = resultGrid.getSelection();
            	if(null != records && records.length > 0){
            		SC.confirm("您确定已经要进行批量操作吗？", new BooleanCallback() {
                        @Override
                        public void execute(Boolean value) {
                            if (value) {
                            	if(null != records){
                        			successSize = 0;
                        			for(ListGridRecord record: records){
                        				final int sizeRecord = records.length;
                        				Map params = record.toMap();
                        				params.put("approvalment", 0);
                        				DBDataSource.callOperation("EP_AttentionProcessor", params, new DSCallback() {
                        					@Override
                        					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        						if (dsResponse.getStatus() >= 0) {
                        							successSize++;
                        							if(sizeRecord == successSize){
                        								commonQuery();
                        							}
                        						}else{
                        							SC.say(dsResponse.getErrors().get("errorMsg").toString());
                        							return;
                        						}
                        					}
                        				});
                        			}
                        		}
                            }
                        }
                    });
            	}else{
                    SC.say("please select a record");
                    return;
                }
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				ListGridRecord selected = resultGrid.getSelectedRecord();
                ViewProcessWindow Reimbursement = new ViewProcessWindow();
                Reimbursement.setLayoutMode(0);
                Reimbursement.setInstanceData(selected);
                Reimbursement.initComponents();
	        	Reimbursement.setWidth("80%");
	            Reimbursement.setHeight("80%");
                Reimbursement.setTitle("供应商详情");
                Reimbursement.show();
                Reimbursement.centerInPage();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("processType", processType);
		criteria.put("status", status);
		return true;
	}


	private int successSize = 0;
	private int processType;
	private int status;
	
	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
	}

	public int getStatus() {
		return status;
	}
	@Override
	public SearchForm generateSearchForm() {
		return new AttentionSupplierInfoSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSAttentionSupplierInfo.getInstance();
	}

	public void setStatus(int status) {
		if(status == 2){//如果是已审核，则隐藏审批按钮
			agreeButton.hide();
			batchAgreeButton.hide();
		}else{
			resultGrid.setSelectionType(SelectionStyle.SIMPLE);  
			resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		}
		this.status = status;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 80;
	}
	
}

