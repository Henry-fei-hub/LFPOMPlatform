package pomplatform.cardManage.business;

import java.io.File;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.SocketTimeoutException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.conn.ConnectTimeoutException;
import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCardManage;
import com.pomplatform.db.bean.BaseCompanyRecord;
import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.bean.BaseEmployeeCostRecord;
import com.pomplatform.db.bean.BaseEmployeeDayCheck;
import com.pomplatform.db.bean.BaseEmployeeMonthCheck;
import com.pomplatform.db.bean.BaseEmployeePaymentDetail;
import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.bean.BaseEmployeeShiftManage;
import com.pomplatform.db.bean.BaseFiveInsuranceOneGold;
import com.pomplatform.db.bean.BaseLaborPaymentEmployee;
import com.pomplatform.db.bean.BasePlateDepartment;
import com.pomplatform.db.bean.BaseSalaryAnnualBonus;
import com.pomplatform.db.bean.BaseSalaryEmployeePerformance;
import com.pomplatform.db.bean.BaseSalaryOfBonus;
import com.pomplatform.db.bean.BaseSalaryOfWorkYear;
import com.pomplatform.db.bean.BaseSalaryTotal;
import com.pomplatform.db.bean.BaseSalaryTotalRecord;
import com.pomplatform.db.bean.BaseSpecialDeductionMonthDetail;
import com.pomplatform.db.dao.CardManage;
import com.pomplatform.db.dao.CompanyRecord;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.EmployeeCostRecord;
import com.pomplatform.db.dao.EmployeeDayCheck;
import com.pomplatform.db.dao.EmployeeMonthCheck;
import com.pomplatform.db.dao.EmployeePaymentDetail;
import com.pomplatform.db.dao.EmployeeRole;
import com.pomplatform.db.dao.EmployeeShiftManage;
import com.pomplatform.db.dao.FiveInsuranceOneGold;
import com.pomplatform.db.dao.HolidayManage;
import com.pomplatform.db.dao.LaborPaymentEmployee;
import com.pomplatform.db.dao.PlateDepartment;
import com.pomplatform.db.dao.SalaryAnnualBonus;
import com.pomplatform.db.dao.SalaryEmployeePerformance;
import com.pomplatform.db.dao.SalaryFillSendDeduct;
import com.pomplatform.db.dao.SalaryJobSubsidy;
import com.pomplatform.db.dao.SalaryLeaveSubsidy;
import com.pomplatform.db.dao.SalaryOfBonus;
import com.pomplatform.db.dao.SalaryOfWorkYear;
import com.pomplatform.db.dao.SalaryTotal;
import com.pomplatform.db.dao.SalaryTotalRecord;
import com.pomplatform.db.dao.SpecialDeduction;
import com.pomplatform.db.dao.SpecialDeductionMonthDetail;
import com.pomplatform.db.dao.SystemConfig;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.servlet.DelicacyServlet;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import message.common.ERPWeixinUtils;
import message.common.OnTelMobile;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.StaticUtils;
import pomplatform.payment.bean.BaseFiveinsuranceSummaryPlate;
import pomplatform.payment.bean.BaseLoadSalaryTotal;
import pomplatform.payment.bean.BaseLoadSalaryTotal3;
import pomplatform.payment.bean.BaseOnLoadEmpWordDayOfMonth;
import pomplatform.payment.bean.BaseOnLoadSalaryPaymentChange;
import pomplatform.payment.bean.BaseOnLoadSalaryTotalMonthData;
import pomplatform.payment.bean.BaseOnLoadShiftAndDayPayment;
import pomplatform.payment.bean.BaseOnLoadUnitFundAndInsurance;
import pomplatform.payment.bean.BaseOnOtherDeductionData;
import pomplatform.payment.bean.BaseOnReplacementTaxData;
import pomplatform.payment.bean.BaseOnSalaryReportByPlate;
import pomplatform.payment.bean.BaseOnSalaryTotalData;
import pomplatform.payment.bean.BaseQueryLoadSalaryTotal2;
import pomplatform.payment.bean.BaseSearchCostData;
import pomplatform.payment.bean.BaseSendIntegralOfEmpPaymentDetail;
import pomplatform.payment.bean.ConditionFiveinsuranceSummaryPlate;
import pomplatform.payment.bean.ConditionLoadSalaryTotal;
import pomplatform.payment.bean.ConditionLoadSalaryTotal3;
import pomplatform.payment.bean.ConditionOnLoadEmpWordDayOfMonth;
import pomplatform.payment.bean.ConditionOnLoadSalaryPaymentChange;
import pomplatform.payment.bean.ConditionOnLoadSalaryTotalMonthData;
import pomplatform.payment.bean.ConditionOnLoadShiftAndDayPayment;
import pomplatform.payment.bean.ConditionOnLoadUnitFundAndInsurance;
import pomplatform.payment.bean.ConditionOnOtherDeductionData;
import pomplatform.payment.bean.ConditionOnReplacementTaxData;
import pomplatform.payment.bean.ConditionOnSalaryReportByPlate;
import pomplatform.payment.bean.ConditionOnSalaryTotalData;
import pomplatform.payment.bean.ConditionQueryLoadSalaryTotal2;
import pomplatform.payment.bean.ConditionSearchCostData;
import pomplatform.payment.bean.ConditionSendIntegralOfEmpPaymentDetail;
import pomplatform.payment.handler.OnReplacementTaxDataHandler;
import pomplatform.payment.query.QueryFiveinsuranceSummaryPlate;
import pomplatform.payment.query.QueryLoadSalaryTotal;
import pomplatform.payment.query.QueryLoadSalaryTotal3;
import pomplatform.payment.query.QueryOnLoadEmpWordDayOfMonth;
import pomplatform.payment.query.QueryOnLoadSalaryPaymentChange;
import pomplatform.payment.query.QueryOnLoadSalaryTotalMonthData;
import pomplatform.payment.query.QueryOnLoadShiftAndDayPayment;
import pomplatform.payment.query.QueryOnLoadUnitFundAndInsurance;
import pomplatform.payment.query.QueryOnOtherDeductionData;
import pomplatform.payment.query.QueryOnReplacementTaxData;
import pomplatform.payment.query.QueryOnSalaryReportByPlate;
import pomplatform.payment.query.QueryOnSalaryTotalData;
import pomplatform.payment.query.QueryQueryLoadSalaryTotal2;
import pomplatform.payment.query.QuerySearchCostData;
import pomplatform.payment.query.QuerySendIntegralOfEmpPaymentDetail;
import pomplatform.shift.business.ThreadTaskTemplate;
import pomplatform.shift.business.ThreadTaskUtils;
import pomplatform.specialDeduction.bean.BaseMspecialdeductionrecordsor;
import pomplatform.specialDeduction.bean.BaseOnLoadSpecialDeductionYear;
import pomplatform.specialDeduction.bean.BaseSspecialdeductionmonthdetailedpor;
import pomplatform.specialDeduction.bean.ConditionMspecialdeductionrecordsor;
import pomplatform.specialDeduction.bean.ConditionOnLoadSpecialDeductionYear;
import pomplatform.specialDeduction.bean.ConditionSspecialdeductionmonthdetailedpor;
import pomplatform.specialDeduction.query.QueryMspecialdeductionrecordsor;
import pomplatform.specialDeduction.query.QueryOnLoadSpecialDeductionYear;
import pomplatform.specialDeduction.query.QuerySspecialdeductionmonthdetailedpor;

/**
 * 卡号管理相关
 * @author lxf
 */
public class OnEmployeeCardManageProcess implements GenericProcessor,GenericDownloadProcessor {
	private static final Logger __logger = Logger.getLogger("");
    //操作类型
    private static final String OPT_TYPE = "optType";
    //员工日薪重置
    private static final String UPDATE_EMPLOYEE_CARD_MANAGE = "updateEmployeeCardManage";
    
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
        switch (optType) {
		case UPDATE_EMPLOYEE_CARD_MANAGE:
			return updateEmployeeCardManage(param);
		default:
			break;
		}
        return null;
    }
    
	@SuppressWarnings("unused")
	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
        
	}
	
	private String updateEmployeeCardManage(Map<String, Object> param) throws SQLException {
		ThreadConnection.beginTransaction();
		
		CardManage dao =new CardManage();
		BaseCardManage base =new BaseCardManage();
		SalaryTotal stDao =new SalaryTotal();
		base.setDataFromMap(param);
		dao.setDataFromBase(base);
		int employeeId = BaseHelpUtils.getIntValue(dao.getObjectId());
		if(employeeId<=0) {
			throw new SQLException("操作失败:获取职员失败");
		}
		String bankAccount = dao.getBankAccount();
		if(null==bankAccount) {
			throw new SQLException("操作失败:获取银行卡号失败");
		}
		Calendar cal =Calendar.getInstance();
		cal.setTime(new Date());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		stDao.setConditionEmployeeId("=", employeeId);
		stDao.setConditionYear("=", year);
		stDao.setConditionMonth("=", month);
		stDao.setConditionIsSended("=", false);//只对当月未发放的工资进行更新
		List<BaseSalaryTotal> list = stDao.conditionalLoad();
		if(list.size()==1) {//只有一条数据
			BaseSalaryTotal baseSalary = list.get(0);
			baseSalary.setBankAccount(bankAccount);
			stDao.setDataFromBase(baseSalary);
			stDao.update();
		}
		dao.update();
		ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}
	
	
	

}