package pomplatform.project.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.pomplatform.db.bean.BaseAccountRecord;
import com.pomplatform.db.bean.BaseBonusPaymentDetail;
import com.pomplatform.db.bean.BaseCompanyIntegralRecord;
import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseEmployeeAccountRecord;
import com.pomplatform.db.bean.BaseEmployeeAchieveIntegralReturnRecord;
import com.pomplatform.db.bean.BaseEmployeeSalaryDetail;
import com.pomplatform.db.bean.BaseEmployeeSalaryReturnRecord;
import com.pomplatform.db.bean.BaseEmployeeViolationCharge;
import com.pomplatform.db.bean.BaseManageProjectEmployeeRecord;
import com.pomplatform.db.bean.BasePlateAccountRecord;
import com.pomplatform.db.bean.BasePlateCostRecord;
import com.pomplatform.db.bean.BasePlateIntegralAchieve;
import com.pomplatform.db.bean.BasePlateIntegralSend;
import com.pomplatform.db.bean.BasePlatePerformanceBonusDetail;
import com.pomplatform.db.bean.BasePlateProjectAccountRecord;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.bean.BasePlateReportRecord;
import com.pomplatform.db.bean.BasePlateSalaryAdvanceRecord;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectAdvanceRecord;
import com.pomplatform.db.bean.BaseProjectEmployeeAdvanceRecord;
import com.pomplatform.db.bean.BaseProjectSettlementDetail;
import com.pomplatform.db.bean.BaseSalaryJobSubsidy;
import com.pomplatform.db.bean.BaseSaleIntegralRecord;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.dao.AccountRecord;
import com.pomplatform.db.dao.BonusPaymentDetail;
import com.pomplatform.db.dao.CompanyIntegralRecord;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.EmployeeAccountRecord;
import com.pomplatform.db.dao.EmployeeAchieveIntegralReturnRecord;
import com.pomplatform.db.dao.EmployeeSalaryDetail;
import com.pomplatform.db.dao.EmployeeSalaryReturnRecord;
import com.pomplatform.db.dao.EmployeeViolationCharge;
import com.pomplatform.db.dao.ManageProject;
import com.pomplatform.db.dao.ManageProjectEmployeeRecord;
import com.pomplatform.db.dao.PlateAccountRecord;
import com.pomplatform.db.dao.PlateCostRecord;
import com.pomplatform.db.dao.PlateIntegralAchieve;
import com.pomplatform.db.dao.PlateIntegralDistribution;
import com.pomplatform.db.dao.PlateIntegralSend;
import com.pomplatform.db.dao.PlatePerformanceBonus;
import com.pomplatform.db.dao.PlatePerformanceBonusDetail;
import com.pomplatform.db.dao.PlateProjectAccountRecord;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.PlateReportRecord;
import com.pomplatform.db.dao.PlateSalaryAdvanceRecord;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectAdvanceRecord;
import com.pomplatform.db.dao.ProjectEmployeeAdvanceRecord;
import com.pomplatform.db.dao.ProjectSettlementDetail;
import com.pomplatform.db.dao.SalaryJobSubsidy;
import com.pomplatform.db.dao.SaleIntegralRecord;
import com.pomplatform.db.dao.SystemConfig;
import com.pomplatform.db.dao.SystemDictionary;

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
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.IntegralReturnOfPlate.bean.BaseIntegralReturnOfPlate;
import pomplatform.IntegralReturnOfPlate.bean.ConditionIntegralReturnOfPlate;
import pomplatform.IntegralReturnOfPlate.query.QueryIntegralReturnOfPlate;
import pomplatform.account.bean.BaseCustomEmployeeAccount;
import pomplatform.account.bean.BaseCustomPlateAccount;
import pomplatform.account.bean.BaseCustomProjectAccount;
import pomplatform.account.bean.BaseCustomSheetAccount;
import pomplatform.account.bean.BaseOnGetBenefitsOfEmployee;
import pomplatform.account.bean.BaseOnGetLeftIntegralOfEmployee;
import pomplatform.account.bean.BaseOnGetLeftIntegralOfPlate;
import pomplatform.account.bean.BaseOnLoadBenefitsData;
import pomplatform.account.bean.BaseOnLoadBusinessTypeDataOfAccount;
import pomplatform.account.bean.BaseOnLoadEmployeeAccountData;
import pomplatform.account.bean.BaseOnLoadIntegralAdvanceOfAccount;
import pomplatform.account.bean.BaseOnLoadIntegralReturnOfAccount;
import pomplatform.account.bean.BaseOnLoadMonthReportData;
import pomplatform.account.bean.BaseOnLoadMonthStatisticOfPlateAccount;
import pomplatform.account.bean.BaseonLoadAccountInfoOfPlateAccount;
import pomplatform.account.bean.ConditionOnGetBenefitsOfEmployee;
import pomplatform.account.bean.ConditionOnGetLeftIntegralOfEmployee;
import pomplatform.account.bean.ConditionOnGetLeftIntegralOfPlate;
import pomplatform.account.bean.ConditionOnLoadBenefitsData;
import pomplatform.account.bean.ConditionOnLoadBusinessTypeDataOfAccount;
import pomplatform.account.bean.ConditionOnLoadEmployeeAccountData;
import pomplatform.account.bean.ConditionOnLoadMonthReportData;
import pomplatform.account.bean.ConditionOnLoadMonthStatisticOfPlateAccount;
import pomplatform.account.bean.ConditiononLoadAccountInfoOfPlateAccount;
import pomplatform.account.query.QueryOnGetBenefitsOfEmployee;
import pomplatform.account.query.QueryOnGetLeftIntegralOfEmployee;
import pomplatform.account.query.QueryOnGetLeftIntegralOfPlate;
import pomplatform.account.query.QueryOnLoadBenefitsData;
import pomplatform.account.query.QueryOnLoadBusinessTypeDataOfAccount;
import pomplatform.account.query.QueryOnLoadEmployeeAccountData;
import pomplatform.account.query.QueryOnLoadMonthReportData;
import pomplatform.account.query.QueryOnLoadMonthStatisticOfPlateAccount;
import pomplatform.account.query.QueryonLoadAccountInfoOfPlateAccount;
import pomplatform.revenue.bean.BaseOnLoadSaleIntegralFromPlate;
import pomplatform.upload.OnUploadJobSubsidysData;

/**
 * 
 * @author lxf
 */
public class ProjectsDWProcess implements GenericProcessor,GenericDownloadProcessor {
    //操作类型
    private static final String OPT_TYPE = "optType";
    //导出条线管理数据
    private static final String ON_DW_BUSINESSLINE_EXPORT_DATA = "onDWBusinessLineExportData";
    //导入条线管理数据
    private static final String ON_UP_BUSINESSLINE_EXPORT_DATA = "onUPBusinessLineExportData";
    
	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
        if(ON_DW_BUSINESSLINE_EXPORT_DATA.equals(optType)){
        	onDWBusinessLineExportData(param,downFile);
        }if(ON_UP_BUSINESSLINE_EXPORT_DATA.equals(optType)){
        	onUPBusinessLineExportData(param,downFile);
        }
	}
	
	
    /**
     * 导出条线管理
     * @param param
     * @throws UnsupportedEncodingException 
     * @throws FileNotFoundException 
     * @throws SQLException 
     * @throws ParseException 
     */
    public static void onDWBusinessLineExportData(Map<String, Object> param, File downFile) throws FileNotFoundException, UnsupportedEncodingException, ParseException, SQLException{    	Project dao =new Project();		
    	String addtionalCondition = BaseHelpUtils.getStringValue(param, "addtionalCondition");
    	String contractCode = BaseHelpUtils.getStringValue(param, "contractCode");
    	String projectName = BaseHelpUtils.getStringValue(param, "projectName");
    	int projectFlag = BaseHelpUtils.getIntValue(param, "projectFlag");
    	int plateId = BaseHelpUtils.getIntValue(param, "plateId");
    	
    	if(!BaseHelpUtils.isNullOrEmpty(contractCode)) {
    		dao.setConditionContractCode("like", "%"+contractCode+"%");
    	}
    	if(!BaseHelpUtils.isNullOrEmpty(projectName)) {
    		dao.setConditionProjectName("like", "%"+projectName+"%");
    	}
    	if(plateId>0) {
    		dao.setConditionPlateId("=", plateId);
    	}
    	Integer[] args =new Integer[] {1,4};
    	dao.addCondition(BaseProject.CS_PROJECT_FLAG, "in", args);
        List<BaseProject> conditionalLoad = dao.conditionalLoad();
		if(!conditionalLoad.isEmpty() && conditionalLoad.size() > 0){
			try(PrintStream ps = new PrintStream(downFile, "GBK")){
				ps.println(BaseProject.CAPTIONS);
				for(BaseProject b : conditionalLoad){
					ps.println(b.toCSVStringBussinessLine());
				}
			}
		}
    }
    
    
    /**导入
     * @param file 读取数据的源Excel
     * @throws java.lang.Exception
     */
    public static String onUPBusinessLineExportData(Map<String, Object> param,File file) throws Exception {
        
    	SystemDictionary sd =new SystemDictionary();
    	//业务类别
    	sd.setConditionDicTypeId("=", 31);
    	sd.setConditionDicIsEnable("=", true);
    	List<BaseSystemDictionary> dic_31 = sd.conditionalLoad();
    	//业务条线
    	sd.clear();
    	sd.setConditionDicTypeId("=", 205);
    	sd.setConditionDicIsEnable("=", true);
    	List<BaseSystemDictionary> dic_205 = sd.conditionalLoad();
    	
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        int allerror = 0;
        int allsuccess = 0;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
//            for (int i = 1; i < 2; i++) {
            	for (int i = 1; i < countRow+1; i++) {
                // 创建一个行对象,并从第二行开始读取
                String contractCode = null,businessType = null ,businessLine = null;
                
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
//                countCol = row.getLastCellNum();
                countCol = 4;
                for (int j = 0; j < countCol+1; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                        	case 0:
                        		cell.setCellType(Cell.CELL_TYPE_STRING);
                        		contractCode = BaseHelpUtils.getString(cell.toString().trim());
                             	break;
                            case 3:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	businessType = BaseHelpUtils.getString(cell.toString().trim());
                                break;
                            case 4:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	businessLine = BaseHelpUtils.getString(cell.toString().trim());
                                break;
                            default:
                                break;
                        }
                    }
                }
                
                BaseProject base =new BaseProject();
                Project dao =new Project();
                if(!BaseHelpUtils.isNullOrEmpty(contractCode)) {
                	dao.setConditionContractCode("=", contractCode);
                	BaseProject executeQueryOneRow = dao.executeQueryOneRow();
                	if(!BaseHelpUtils.isNullOrEmpty(executeQueryOneRow)) {
                		Integer projectId = executeQueryOneRow.getProjectId();
                		base.setProjectId(projectId);
                		for (BaseSystemDictionary bsd : dic_31) {
                			if(bsd.getDicTypeValue().equals(businessType)) {
                				base.setBusinessType(bsd.getDicTypeValueId());
                			}
						}
                		
                		for (BaseSystemDictionary bsd : dic_205) {
                			if(bsd.getDicTypeValue().equals(businessLine)) {
                				base.setBusinessLine(bsd.getDicTypeValueId());
                			}
						}
                		dao.clear();
                		dao.setDataFromBase(base);
                		dao.update();
                	}
                }
            }
        }
		return null;
    }
    
    
	
	public static void main(String[] args) throws UnsupportedEncodingException, SQLException, FileNotFoundException, ParseException {
		/*Map param = new HashMap<>();
		param.put("contractCode2","-000");
		param.put("projectFlag",1);//只检索设计项目
		File file = new File("F:\\新建文件夹 (2)\\fwtfw3.csv");
		onDWBusinessLineExportData(param,file);*/
		
		try{
			ProjectsDWProcess a = new ProjectsDWProcess();
    		a.onUPBusinessLineExportData(null, new File("C:\\Users\\Administrator\\Desktop\\test.xlsx"));
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
	}


	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

	@Override
	public String execute(String arg0, HttpServletRequest arg1) throws Exception {
		return null;
	}
}
