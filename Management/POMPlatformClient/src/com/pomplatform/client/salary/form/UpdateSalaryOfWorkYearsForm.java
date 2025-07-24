package com.pomplatform.client.salary.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.pomplatform.client.dataverification.DataVerification;
import com.pomplatform.client.stage.form.SprojectporDetailProjectStage;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;

public class UpdateSalaryOfWorkYearsForm extends GenericWizadWindow {

	private static final Logger __logger = Logger.getLogger("");
	@Override
    public String getActionName() {
        // 需要根据实际业务修改
        return "EP_OnProjectWithStageCommon";
    }

    @Override
    public boolean checkData(Map data) {
        return true;
    }

    @Override
    public int getPageCount() {
        return 1;
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
        SSalaryOfWorkYearsUpdateForm sSalaryOfWorkYearsUpdateForm = new SSalaryOfWorkYearsUpdateForm();
        sSalaryOfWorkYearsUpdateForm.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
        res.add(sSalaryOfWorkYearsUpdateForm);
        return res;
    }
    
    @Override
    public Map getValues() {
    	Map<String,Object> values = new HashMap<>();
    	for (AbstractWizadPage p : __pages) {
    		values = p.getValuesAsMap();
    	}
    	values.put("optType", "updatesalaryofworkyears");
    	/*Map<String,Object> values = new HashMap<>();
    	values.put("year",2018);
    	values.put("month", 1);
    	values.put("employeeId", 1985);
    	values.put("workMoney", 200);*/
    	return values;
    }
    
    private int year;
    private int month;
    private int employeeId;
    private String workMoney;
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getWorkMoney() {
		return workMoney;
	}

	public void setWorkMoney(String workMoney) {
		this.workMoney = workMoney;
	}
    
    
    
    
    
    
    
}
