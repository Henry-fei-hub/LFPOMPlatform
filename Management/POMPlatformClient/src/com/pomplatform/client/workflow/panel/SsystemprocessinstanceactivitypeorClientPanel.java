package com.pomplatform.client.workflow.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.management.panel.SsystemprocessinstanceactivitypeorPanel;
import com.delicacy.client.ui.ApprovalmentWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class SsystemprocessinstanceactivitypeorClientPanel extends SsystemprocessinstanceactivitypeorPanel{

	private static final Logger logger = Logger.getLogger("");
	
	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			SsystemprocessinstanceactivitypeorClientPanel cm = new SsystemprocessinstanceactivitypeorClientPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SsystemprocessinstanceactivitypeorClient";
		}

	}
	
	@Override
    public void init() {
        super.init();
        __controlPosition = LayoutConstant.RIGHT;
    }
	
	@Override
    public void initComponents() {
		
		resultGrid.setShowRowNumbers(true);
		resultGrid.setSelectionType(SelectionStyle.SIMPLE);  
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);  
        
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		
        IButton refreshButton = new IButton("刷新");
        controlLayout.addMember(refreshButton);
        refreshButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                commonQuery();
            }
        });

        IButton viewButton = new IButton("审批");
        viewButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	ListGridRecord[] records = resultGrid.getSelection();
            	if(null != records && records.length > 0){
            		ListGridRecord selected = records[0];
                    ApprovalmentWindow Reimbursement = new ApprovalmentWindow();
                    Reimbursement.addDataEditedHandler(new DataEditedHandler(){
                        @Override
                        public void onDataEdited(DataEditEvent event) {
                            commonQuery();
                        }
                    });
                    Reimbursement.setWidth("80%");
                    Reimbursement.setHeight("80%");
                    Reimbursement.setLayoutMode(0);
                    Reimbursement.setInstanceData(selected);
                    Reimbursement.initComponents();
                    Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
                    Reimbursement.show();
            	}else{
                    SC.say("please select a record to edit");
                    return;
                }
            }
        });
        controlLayout.addMember(viewButton);
        
        IButton agreeButton = new IButton("批量审批");
        agreeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	final ListGridRecord[] records = resultGrid.getSelection();
            	if(null != records && records.length > 0){
            		SC.confirm("您确定已经要进行批量操作吗？", new BooleanCallback() {
                        @Override
                        public void execute(Boolean value) {
                            if (value) {
                                submit(records, 0);
                            }
                        }
                    });
            	}else{
                    SC.say("please select a record");
                    return;
                }
            }
        });
        controlLayout.addMember(agreeButton);
        
        commonQuery();
    }
	
	private int successSize = 0;
	public void submit(ListGridRecord[] records, int approvalment) {
		if(null != records){
			successSize = 0;
			for(ListGridRecord record: records){
				final int recordSize = records.length;
				Map params = record.toMap();
				params.put("approvalment", approvalment);
				DBDataSource.callOperation("EP_WorkFlowActivityProcessor", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							successSize++;
							if(recordSize == successSize){
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
