package com.pomplatform.client.workflow.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractWizadPage;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class NewProjectNormalReimbursementOfWorkflowWorkflow extends AbstractProcessPanel
{
private static final Logger logger = Logger.getLogger("");

	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		DBDataSource.callOperation("NQ_ProjectNormalReimbursementOfWorkflow", "find", new DSCallback() {
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
	public boolean checkData(Map data){
		return true;
	}

	@Override
	public int getPageCount(){
		return 2;
	}

	@Override
	public List<AbstractWizadPage> getPages(){
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
        final ProjectNormalReimbursementOfWorkflowNewForm main = new ProjectNormalReimbursementOfWorkflowNewForm();
        main.setProcessId(getProcessId());
        res.add(main);
        final ProjectNormalReimbursementDetailProjectNormalReimbursementDetail detail = new ProjectNormalReimbursementDetailProjectNormalReimbursementDetail();
        detail.setProcessId(getProcessId());
        detail.setMainInfoPage(main);
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
        return res;
	}


}

