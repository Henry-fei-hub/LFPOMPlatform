package com.pomplatform.client.workflow.personnelbusiness.form;

import static com.delicacy.client.ui.GenericWizadWindow.BACKGROUND_COLOR;
import static com.delicacy.client.ui.GenericWizadWindow.BORDER_STYLE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractWizadPage;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class NewApplyForTransferWorkflow extends AbstractProcessPanel {

	@Override
	public void load() {
		if (getBusinessId() == null)
			return;
		Map params = new HashMap();
		params.put("personnelBusinessId", getBusinessId());
		DBDataSource.callOperation("NQ_Spersonnelbusinesppor", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					setData(dsResponse.getData()[0]);
					if (__pages == null)
						__pages = getPages();
					for (AbstractWizadPage wp : __pages) {
						wp.setRecord(getData());
						wp.startEdit();
					}
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
	public boolean checkData(Map data) {
		List<AbstractWizadPage> checkPages = __pages;
		boolean flag = true;
		for (AbstractWizadPage abstractWizadPage : checkPages) {
			if (!abstractWizadPage.checkData()) {
				flag = false;
//				SC.say("请您按系统提示填好信息。");
			}
		}
		return flag;
	}

	@Override
	public int getPageCount() {
		return 2;
	}

	@Override
	public List<AbstractWizadPage> getPages() {
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		res.add(new ApplyForTransferNewForm());
		WorkHandoverPanel panel = new WorkHandoverPanel(2);
		panel.setEmployeeId(ClientUtil.getEmployeeId());
		res.add(panel);
		return res;
	}

}
