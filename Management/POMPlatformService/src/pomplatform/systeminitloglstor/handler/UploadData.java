package pomplatform.systeminitloglstor.handler;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.pomplatform.db.bean.BaseCapital;
import com.pomplatform.db.bean.BaseReceiveUnitManage;
import com.pomplatform.db.bean.BaseReimbursementPackageSummary;
import com.pomplatform.db.dao.Capital;
import com.pomplatform.db.dao.ReceiveUnitManage;
import com.pomplatform.db.dao.ReimbursementPackageSummary;

import delicacy.common.BaseHelpUtils;

public class UploadData {
	private static void onUpload(File file) throws Exception {
		ReimbursementPackageSummary rpsDao = new ReimbursementPackageSummary();
		BaseReimbursementPackageSummary rpsBean = null;

		Capital cDao = new Capital();
		BaseCapital cBean = null;

		// 将指定路径的数据读取到workbook中
		Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
		// 获取workbook的sheet数
		int count = workbook.getNumberOfSheets();
		Date currentTime = new Date();
		for (int i = 1; i < count - 1; i++) {
			// 获取Sheet
			Sheet sheet = workbook.getSheetAt(i);
			// 初始化行数
			int countRow = 0;
			int countCol = 0;
			countRow = sheet.getLastRowNum();
			for (int j = 1; j <= countRow; j++) {

				Row row = sheet.getRow(j);
				if (BaseHelpUtils.isNullOrEmpty(row)) {
					break;
				}
				// 获取每一行的列数
				countCol = row.getLastCellNum();
				rpsBean = new BaseReimbursementPackageSummary();
				rpsBean.setPayFor(2);
				rpsBean.setOtherName(8);
				rpsBean.setIsCompleted(true);
				rpsBean.setCreateTime(currentTime);
				cBean = new BaseCapital();
				cBean.setSelfName(8);
				cBean.setCapitalType(2);

				if (i == 1) {
					rpsBean.setOtherBankName("汇丰银行香港分行-港元往来户-HK");
					rpsBean.setOtherBankAccount("848-427720-838-CR");
					cBean.setSelfBankName("汇丰银行香港分行-港元往来户-HK");
					cBean.setSelfBankAccount("848-427720-838-CR");
				}
				if (i == 2) {
					rpsBean.setOtherBankName("汇丰银行香港分行-港元储蓄户-HK");
					rpsBean.setOtherBankAccount("848-427720-838-SV");
					cBean.setSelfBankName("汇丰银行香港分行-港元储蓄户-HK");
					cBean.setSelfBankAccount("848-427720-838-SV");
				}
				if (i == 3) {
					rpsBean.setOtherBankName("汇丰银行香港分行-港元定期存款户-HK");
					rpsBean.setOtherBankAccount("848-427720-838-TD");
					cBean.setSelfBankName("汇丰银行香港分行-港元定期存款户-HK");
					cBean.setSelfBankAccount("848-427720-838-TD");
				}
				if (i == 4) {
					rpsBean.setOtherBankName("汇丰银行香港分行-港元储蓄户-SZ");
					rpsBean.setOtherBankAccount("848-431193-838-SV");
					cBean.setSelfBankName("汇丰银行香港分行-港元储蓄户-SZ");
					cBean.setSelfBankAccount("848-431193-838-SV");
				}

				for (int k = 0; k < countCol + 1; k++) {
					// 创建一个列单元对象
					Cell cell = row.getCell(k);
					if (!BaseHelpUtils.isNullOrEmpty(cell)) {
						switch (k) {
						case 0:
							Date date = cell.getDateCellValue();
							rpsBean.setUpdateTime(date);
							cBean.setHappenDate(date);
							break;
						case 2:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							cBean.setRemark(cell.getStringCellValue());
							break;
						case 3:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							rpsBean.setPayeeName(cell.getStringCellValue());
							Integer id=getReceiveUnitManageId(cell.getStringCellValue());
							if (!BaseHelpUtils.isNullOrEmpty(id)) {
								rpsBean.setEmployeeOrCompanyId(id);
							}
							cBean.setOtherName(cell.getStringCellValue());
							break;
						case 5:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							rpsBean.setAmount(BaseHelpUtils.getBigDecimalValue(cell.getStringCellValue()));
							rpsBean.setPaymentAmount(BaseHelpUtils.getBigDecimalValue(cell.getStringCellValue()));
							cBean.setLoanMoney(BaseHelpUtils.getBigDecimalValue(cell.getStringCellValue()));
							break;
						default:
							break;
						}

					}

				}
				rpsDao.setDataFromBase(rpsBean);
				rpsDao.save();
				cBean.setReimbursementPackageSummaryId(rpsDao.getReimbursementPackageSummaryId());
				cDao.setDataFromBase(cBean);
				cDao.save();
			}

		}

	}

	private static Integer getReceiveUnitManageId(String ReceiveUnit) {
		Integer receiveUnitManageId = null;
		try {
			ReceiveUnitManage dao=new ReceiveUnitManage();
			List<BaseReceiveUnitManage> list=dao.conditionalLoad();
			for (BaseReceiveUnitManage bean : list) {
				if (null != ReceiveUnit && ReceiveUnit.equals(bean.getReceiveUnit())) {
					receiveUnitManageId = bean.getReceiveUnitManageId();
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return receiveUnitManageId;

	}
	public static void main(String[] args) {
//		File file = new File("d:\\JATO流水.xls");
//		try {
//			onUpload(file);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
		Calendar cl = Calendar.getInstance();   
		cl.setTime(new Date()); 
		int week = cl.get(Calendar.WEEK_OF_YEAR);   
		cl.add(Calendar.DAY_OF_MONTH, -7);  
		int year = cl.get(Calendar.YEAR);  
		if(week<cl.get(Calendar.WEEK_OF_YEAR)){  
		    year+=1;  
		}  
	}

}
