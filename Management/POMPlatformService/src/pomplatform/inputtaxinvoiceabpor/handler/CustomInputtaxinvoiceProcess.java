package pomplatform.inputtaxinvoiceabpor.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.bean.BaseInputTaxInvoice;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.InputTaxInvoice;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.common.GenericUploadProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.payment.bean.BaseOnSalaryPlateBonusByCompany;
import pomplatform.payment.bean.ConditionOnSalaryPlateBonusByCompany;
import pomplatform.payment.query.QueryOnSalaryPlateBonusByCompany;

public class CustomInputtaxinvoiceProcess implements GenericProcessor, GenericUploadProcessor{
	
	
	private final static String GET_DEPARTMENT_BONUS_MONEY = "getDepartmentBonusMoney";//获取奖金发放到部门的金额
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "opt_type");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
			case GET_DEPARTMENT_BONUS_MONEY:
				return getDepartmentBonusMoney(result);
			}
		}
		return null;
	}
	
	public static String getDepartmentBonusMoney(Map<String, Object> params) throws SQLException, ParseException{
		int status = 1;
		String errorMsg = null;
		BaseCollection<BaseOnSalaryPlateBonusByCompany> bc = new BaseCollection<>();
		QueryOnSalaryPlateBonusByCompany dao = new QueryOnSalaryPlateBonusByCompany();
		dao.setCurrentPage(0);
		dao.setPageLines(1);
		ConditionOnSalaryPlateBonusByCompany c = new ConditionOnSalaryPlateBonusByCompany();
		c.setDataFromMap(params);
 		BaseCollection<BaseOnSalaryPlateBonusByCompany> result = dao.executeQuery( c.getKeyValues(), c) ;
 		List<BaseOnSalaryPlateBonusByCompany> list = result.getCollections();
 		Department dDao = new Department();
 		for (BaseOnSalaryPlateBonusByCompany baseOnSalaryReportByPlate : list) {
 			dDao.clear();
 			Integer plateId = baseOnSalaryReportByPlate.getPlateId();
 			dDao.setConditionPlateId("=", plateId);
 			BaseDepartment bean = dDao.executeQueryOneRow(" order by " + BaseDepartment.CS_PARENT_ID);
 			if(null != bean){
 				baseOnSalaryReportByPlate.setPlateId(bean.getDepartmentId());
 			}
		}
		bc.setCollections(list);
		return bc.toJSON(status, errorMsg);
	}
	

	@Override
    public String execute(String creteria, HttpServletRequest request, List<FileItem> items) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        String errorMesg = "";
        BaseCollection bc = new BaseCollection();
        for (FileItem fileItem : items) {
            File fullName = File.createTempFile("DelicacyUploadFiles", UUID.randomUUID().toString());
            fileItem.write(fullName);
        	errorMesg = onUploadTax(fullName,param);
            fullName.delete();
        }
        if (BaseHelpUtils.isNullOrEmpty(errorMesg)) {
            return bc.toJSON(0, null);
        } else {
            return bc.toJSON(-1, errorMesg);
        }
    }


	/**
	 * 
     * @param file 读取数据的源Excel
     * @return
     * @throws Exception
     */
	private String onUploadTax(File file, Map<String,Object> param) throws Exception {
        int employeeId = BaseHelpUtils.getIntValue(param, "employeeId");
        InputTaxInvoice itiDao = new InputTaxInvoice();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        StringBuilder log = new StringBuilder("");
        for (int m = 0; m < count; m++) {
            
            Sheet sheet = workbook.getSheetAt(m);

            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            for (int i = 1; i < countRow + 1; i++) {
                // 创建一个行对象,并从第二行开始读取
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                BaseInputTaxInvoice bean = new BaseInputTaxInvoice();
                for (int j = 0; j < countCol+1; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                            case 0:
                                break;
                            case 1:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                                bean.setInvoiceCode(cell.getStringCellValue());
                            	break;
                            case 2:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                        		bean.setInvoiceNumber(cell.getStringCellValue());
                                break;
                            case 3:
                            	Date d = null ;
                            	if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
									if (DateUtil.isCellDateFormatted(cell)) {
										d = cell.getDateCellValue();
										
									}
								}else{
									String dStr = cell.getStringCellValue();
	                            	try {
										d = sdf.parse(dStr);
									} catch (Exception e) {
										try {
											d = sdf1.parse(dStr);
										} catch (Exception e2) {
											
										}
									}
								}
                            	bean.setInvoiceDate(d);
                                break;
                            case 4:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	bean.setSalesName(cell.getStringCellValue());
                            	break;
                            case 5:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	bean.setSalesCode(cell.getStringCellValue());
                            	break;
                            case 6:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	String val = cell.getStringCellValue();
                            	if(!BaseHelpUtils.isNullOrEmpty(val)){
                            		BigDecimal b = new BigDecimal(val);
                            		bean.setInvoiceAmount(b);
                            	}
                            	break;
                            case 7:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	String val1 = cell.getStringCellValue();
                            	if(!BaseHelpUtils.isNullOrEmpty(val1)){
                            		BigDecimal b1 = new BigDecimal(val1);
                            		bean.setTaxAmount(b1);
                            	}
                            default:
                                break;
                        }
                    }
                }
                bean.setOperator(employeeId);
				if(null != bean.getInvoiceAmount() && null != bean.getTaxAmount()){
					bean.setTaxRate(bean.getTaxAmount().divide(bean.getInvoiceAmount(), 2, RoundingMode.HALF_UP));
				}
				
				itiDao.clear();
				itiDao.setConditionInvoiceNumber("=", bean.getInvoiceNumber());
                BaseInputTaxInvoice esbean = itiDao.executeQueryOneRow();
                if (!BaseHelpUtils.isNullOrEmpty(esbean)) {
                	itiDao.setDataFromBase(esbean);
                	itiDao.clearModifiedFlags();
                	itiDao.setDataFromBase(bean);
                	itiDao.update();
                } else {
                	itiDao.clear();
                	itiDao.setDataFromBase(bean);
                	itiDao.save();
                }
            }
        }
        return null;
	}

	
}
