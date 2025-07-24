package com.pomplatform.client.cmbcinfo.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 *
 * @author cl
 */
public class BankCapitalReceiveCheckPanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	
	public final static String BORDER_STYLE = "1px solid #ABABAB";
	public final static String BACKGROUND_COLOR = "azure";
	public final static String FORM_BORDER_STYLE = "1px solid #808080";
	
	McmbctransinfolinktattlorPanel traninfoPanel;
	
	McapitalbccoccmsssoooblpommmmlorPanel capitalPanel;

	@Override
	public Canvas getViewPanel() {
		//构建
		traninfoPanel = new McmbctransinfolinktattlorPanel();
		capitalPanel = new McapitalbccoccmsssoooblpommmmlorPanel();
		
		traninfoPanel.setCapitalPanel(capitalPanel);
		HLayout mainLayout = new HLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		VLayout leftLayout = new VLayout();
		leftLayout.setWidth("50%");
		leftLayout.setHeight100();
		
		VLayout middleLayout = new VLayout();
		middleLayout.setWidth(120);
		middleLayout.setHeight100();
		middleLayout.setMembersMargin(10);
		middleLayout.setAlign(VerticalAlignment.CENTER);
		middleLayout.setBackgroundColor(BACKGROUND_COLOR);
		middleLayout.setPadding(10);
		
		IButton linkBtn = new IButton(">> 绑定 <<");
		middleLayout.addMember(linkBtn);
		linkBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!traninfoPanel.checkSelectData()){
					SC.say("请选择左边需要关联的数据");
					return;
				}
				if(!capitalPanel.checkSelectData()){
					SC.say("请选择右边需要关联的数据");
					return;
				}
				
				Map<String, Object> params = new HashMap<>();
				params.put("employeeId", ClientUtil.getEmployeeId());
				params.put("transInfoIds", traninfoPanel.getSelectIds());
				params.put("capitalIds", capitalPanel.getSelectIds());
				params.put("opt_type", "receivebind");
				DBDataSource.callOperation("EP_BankCapitalCheckProcess", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() > 0){
							traninfoPanel.commonQuery();
							capitalPanel.commonQuery();
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
						
					}
				});
				
			}
		});
		
		
		VLayout rightLayout = new VLayout();
		rightLayout.setWidth("50%");
		rightLayout.setHeight100();
		
		
		middleLayout.addMember(linkBtn);
		leftLayout.addMember(traninfoPanel);
		rightLayout.addMember(capitalPanel);
		//面板添加
		mainLayout.addMember(leftLayout);
		mainLayout.addMember(middleLayout);
		mainLayout.addMember(rightLayout);
		return mainLayout;
	}
	

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			BankCapitalReceiveCheckPanel cm = new BankCapitalReceiveCheckPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "BankCapitalReceiveCheckPanel";
		}

	}

}
