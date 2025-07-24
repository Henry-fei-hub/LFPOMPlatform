package com.pomplatform.client.workflow.projectNormalReimbursement.form;

import static com.delicacy.client.ui.GenericWizadWindow.BACKGROUND_COLOR;
import static com.delicacy.client.ui.GenericWizadWindow.BORDER_STYLE;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.panel.ProcessBillListApplyPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class NewNormalReimbursementWithProjectWorkflow extends AbstractProcessPanel
{

	private static final Logger __logger = Logger.getLogger("");
	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("projectNormalReimbursementId", getBusinessId());
		DBDataSource.callOperation("NQ_NormalReimbursementWithProject", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					setData(dsResponse.getData()[0]);
					if(__pages == null) __pages = getPages();
					for(AbstractWizadPage wp : __pages) { wp.setRecord(getData()); wp.startEdit(); }
				}
			}
		});
	}

	@Override
	public void initComponents() {
        //设置页面属性
        setWidth100();
        setHeight100();

        __pages = getPages();
        for (AbstractWizadPage __page : __pages) {
            if (__page.getPageMode() != AbstractWizadPage.PAGE_MODE_ADD) {
                setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
            }
            __page.setBorder(BORDER_STYLE);
            __page.setPadding(5);
            __page.setBackgroundColor(BACKGROUND_COLOR);
        }
        VLayout mainLayout = new VLayout();
        mainLayout.setOverflow(Overflow.HIDDEN);
        mainLayout.setWidth100();
        mainLayout.setHeight100();
        switch (__pageMode) {
            case PAGE_DISPLAY_NAV:
                __pageNum = getPageCount();
                customLayout = new HLayout();
                customLayout.setWidth100();
                customLayout.setHeight100();
                customLayout.setPadding(5);
                customLayout.addMember(__pages.get(getCurrentPage()));
                mainLayout.addMember(customLayout);
                break;
            default:
                __pageNum = 1;
                HLayout hLayout = new HLayout();
                hLayout.setWidth100();
                hLayout.setHeight100();
                hLayout.setPadding(5);
                HLayout hLeft = new HLayout();
                hLeft.setWidth("30%");
                hLeft.setHeight100();
                hLeft.setPadding(5);
                HLayout hRight = new HLayout();
                hRight.setWidth("70%");
                hRight.setHeight100();
                hRight.setPadding(5);
                VLayout vRight = new VLayout();
                vRight.setWidth100();
                vRight.setHeight100();
                vRight.setPadding(5);
                int i = 0;
                for (AbstractWizadPage __page : __pages) {
                	if(i == 0){
                		hLeft.addMember(__page);
                	}else{
                		vRight.addMember(__page);
                	}
                	i++;
                }
                hRight.addMember(vRight);
                hLayout.addMember(hLeft);
                hLayout.addMember(hRight);
                mainLayout.addMember(hLayout);
                break;
        }
        addMember(mainLayout);
    }
	
	@Override
	public boolean checkData(Map data){
		boolean flag =  true;
		List<AbstractWizadPage> pageList = __pages;
		for (AbstractWizadPage abstractWizadPage : pageList) {
			if(!abstractWizadPage.checkData()){
				flag = false;
				break;
			}
		}
		return flag;
	}

	@Override
	public int getPageCount(){
		return 4;
	}

	@Override
	public List<AbstractWizadPage> getPages(){
		Record initData = getData();
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		final NormalReimbursementWithProjectNewForm main = new NormalReimbursementWithProjectNewForm();
        main.setProcessId(getProcessId());
		main.setInitData(initData);
        res.add(main);
		final ProjectNormalReimbursementDetailPanel detail = new ProjectNormalReimbursementDetailPanel();
        detail.setProcessId(getProcessId());
        detail.setInitData(initData);
        detail.setMainInfoPage(main);
        detail.setTitle("项目日常报销费用清单");
        res.add(detail);
        detail.getDataGrid().addEditCompleteHandler(new EditCompleteHandler() {
            @Override
			public void onEditComplete(EditCompleteEvent event) {
				FormItem item = main.findNamedItem("amount");
				if (null != item) {
					BigDecimal amount = BigDecimal.ZERO;
					ListGridRecord[] data = detail.getDataGrid().getRecords();
					if (data == null || data.length == 0) {
						item.setValue(amount);
						return;
					}
					for (ListGridRecord r : data) {
						if (null != r.getAttribute("amount")) {
							amount = amount.add(new BigDecimal(r.getAttribute("amount")));
						}
					}
					item.setValue(amount);
					item.fireEvent(new ChangedEvent(null));
				}
			}
        });

        Record bdrecord=getData();//预算传过来的record
        final NormalReimbursementLinkProjectPanel link = new NormalReimbursementLinkProjectPanel(true, null);
        link.setInitData(initData);
        if(!BaseHelpUtils.isNullOrEmpty(bdrecord)) {
             link.setBdrecord(bdrecord);
        }
        link.setProcessId(getProcessId());
		link.setMainInfoPage(main);
		//link.setBillInfoPage(pblPanel);
		link.setDetailInfoPage(detail);
		link.setTitle("费用分拆");
		res.add(link);
        
        
		final ProcessBillListApplyPanel pblPanel = new ProcessBillListApplyPanel(null);
		pblPanel.setMainInfoPage(main);
		pblPanel.setTitle("账单流水");
		pblPanel.setInitData(initData);
		if(!BaseHelpUtils.isNullOrEmpty(bdrecord)) {
		    bdrecord.setAttribute("processType", 2);
		    pblPanel.setBudgetRecord(bdrecord);
		}
		res.add(pblPanel);
		
		main.setDetailPanel(detail);
		main.setLinkProjectPanel(link);
		main.setPblPanel(pblPanel);
		return res;
	}


}

