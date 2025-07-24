package pomplatform.upload;

import com.pomplatform.db.bean.BaseCompanyRecord;
import com.pomplatform.db.bean.BaseFiveInsuranceOneGold;
import com.pomplatform.db.dao.CompanyRecord;
import com.pomplatform.db.dao.FiveInsuranceOneGold;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericUploadProcessor;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

/**
 * 上传五险一金数据
 *
 * @author
 */
public class


OnUploadEmpFiveInsuranceOneGold implements GenericUploadProcessor {

    private static final Logger __logger = Logger.getLogger(OnUploadEmpFiveInsuranceOneGold.class);

    @Override
    public String execute(String creteria, HttpServletRequest request, List<FileItem> items) throws Exception {
        String errorMesg = "";
        for (FileItem fileItem : items) {
            File fullName = File.createTempFile("DelicacyUploadFiles", UUID.randomUUID().toString());
            fileItem.write(fullName);
            errorMesg = saveData(fullName);
            fullName.delete();
        }
        BaseCollection bc = new BaseCollection();
        if (BaseHelpUtils.isNullOrEmpty(errorMesg)) {
            return bc.toJSON(0, null);
        } else {
            return bc.toJSON(-1, errorMesg);
        }
    }

    /**
     * @param file 读取数据的源Excel
     * @throws java.lang.Exception
     */
    public String saveData(File file) throws Exception {

        FiveInsuranceOneGold dao = new FiveInsuranceOneGold();

        BaseFiveInsuranceOneGold bean;
        //把人员的数据加载出来
        Employee eDao = new Employee();
        eDao.unsetSelectFlags();
        eDao.setSelectEmployeeId(true);
        eDao.setSelectEmployeeNo(true);
        eDao.setSelectEmployeeName(true);
        eDao.setSelectCompanyId(true);
        eDao.setSelectDepartmentId(true);
        eDao.setSelectPlateId(true);
        List<BaseEmployee> listBeans = eDao.conditionalLoad("order by " + BaseEmployee.CS_EMPLOYEE_NO + " asc");

        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        StringBuilder log = new StringBuilder("未导入员工信息提示<br/>");
        int allerror = 0;
        int allsuccess = 0;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);

            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            for (int i = 2; i < countRow + 1; i++) {
                // 创建一个行对象,并从第三行开始读取
                String name = null, no = null, year = null, month = null, companyId = null;
                BigDecimal
                        accumulationFundGolePaymentBase = BigDecimal.ZERO,
                        accumulationFundGoleCompanyPaymentRatio = BigDecimal.ZERO,
                        accumulationFundGoleIndividualPaymentRatio = BigDecimal.ZERO,
                        unitPensionPaymentBase = BigDecimal.ZERO,
                        unitPensionPaymentRatio = BigDecimal.ZERO,
                        unitMedicalInsurancePaymentBase = BigDecimal.ZERO,
                        unitMedicalInsurancePaymentRatio = BigDecimal.ZERO,
                        unitInjuryInsuranceBase = BigDecimal.ZERO,
                        unitInjuryInsuranceRatio = BigDecimal.ZERO,
                        unitUnemploymentInsurancePaymentBase = BigDecimal.ZERO,
                        unitUnemploymentInsurancePaymentRatio = BigDecimal.ZERO,
                        unitGiveBirthInsurancePaymentBase = BigDecimal.ZERO,
                        unitGiveBirthInsurancePaymentRatio = BigDecimal.ZERO,
                        personalPensionPaymentRatio = BigDecimal.ZERO,
                        personalMedicalInsurancePaymentRatio = BigDecimal.ZERO,
                        personalUnemploymentInsurancePaymentRatio = BigDecimal.ZERO,
                        unitTotalFund = BigDecimal.ZERO,
                        personalTotalFund = BigDecimal.ZERO,
                        unitPension = BigDecimal.ZERO,
                        unitMedicalInsurance = BigDecimal.ZERO;
                BigDecimal unitLargeMedicalInsurance = BigDecimal.ZERO,
                        unitInjuryInsurance = BigDecimal.ZERO,
                        unitUnemploymentInsurance = BigDecimal.ZERO;
                BigDecimal unitGiveBirthInsurance = BigDecimal.ZERO,
                        personalPension = BigDecimal.ZERO,
                        personalMedicalInsurance = BigDecimal.ZERO,
                        personalLargeMedicalInsurance = BigDecimal.ZERO;
                BigDecimal personalSeriousIllInsurance = BigDecimal.ZERO,
                        personalUnemploymentInsurance = BigDecimal.ZERO,
                        personalHeating = BigDecimal.ZERO;
                BigDecimal unitDisabilityInsurance = BigDecimal.ZERO;
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                dao.clear();
                bean = new BaseFiveInsuranceOneGold();
                for (int j = 0; j < countCol + 1; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        switch (j) {
                            case 1:
                                name = BaseHelpUtils.getString(cell.toString().trim());
                                break;
                            case 2:
                                no = BaseHelpUtils.getString(cell.toString().trim());
                                if (no.length() < 6) {
                                    no = String.format("%06d", BaseHelpUtils.getIntValue(no));
                                }
                                break;
                            case 3:
                                year = BaseHelpUtils.getString(cell.toString().trim());
                                break;
                            case 4:
                                month = BaseHelpUtils.getString(cell.toString().trim());
                                break;
                            case 5:
                                companyId = BaseHelpUtils.getString(cell.toString().trim());
                                bean.setCompanyId(findCompanyId(companyId));
                                break;
                            case 6:
                                accumulationFundGolePaymentBase = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setAccumulationFundGolePaymentBase(accumulationFundGolePaymentBase);
                                break;
                            case 7:
                                accumulationFundGoleCompanyPaymentRatio = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setAccumulationFundGoleCompanyPaymentRatio(accumulationFundGoleCompanyPaymentRatio);
                                break;
                            case 8:
                                accumulationFundGoleIndividualPaymentRatio = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setAccumulationFundGoleIndividualPaymentRatio(accumulationFundGoleIndividualPaymentRatio);
                                break;

                            case 9:
                                unitTotalFund = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setUnitTotalFund(unitTotalFund);
                                break;
                            case 10:
                                personalTotalFund = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setPersonalTotalFund(personalTotalFund);
                                break;

                            case 11:
                                unitPensionPaymentBase = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setUnitPensionPaymentBase(unitPensionPaymentBase);
                                break;

                            case 12:
                                unitPensionPaymentRatio = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setUnitPensionPaymentRatio(unitPensionPaymentRatio);
                                break;

                            case 13:
                                unitPension = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setUnitPension(unitPension);
                                break;
                            case 14:
                                unitMedicalInsurancePaymentBase = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setUnitMedicalInsurancePaymentBase(unitMedicalInsurancePaymentBase);
                                break;
                            case 15:
                                unitMedicalInsurancePaymentRatio = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setUnitMedicalInsurancePaymentRatio(unitMedicalInsurancePaymentRatio);
                                break;
                            case 16:
                                unitMedicalInsurance = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setUnitMedicalInsurance(unitMedicalInsurance);
                                break;
                            case 17:
                                unitLargeMedicalInsurance = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setUnitLargeMedicalInsurance(unitLargeMedicalInsurance);
                                break;
                            case 18:
                                unitInjuryInsuranceBase = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setUnitInjuryInsuranceBase(unitInjuryInsuranceBase);
                                break;
                            case 19:
                                unitInjuryInsuranceRatio = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setUnitInjuryInsuranceRatio(unitInjuryInsuranceRatio);
                                break;
                            case 20:
                                unitInjuryInsurance = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setUnitInjuryInsurance(unitInjuryInsurance);
                                break;
                            case 21:
                                unitUnemploymentInsurancePaymentBase = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setUnitUnemploymentInsurancePaymentBase(unitUnemploymentInsurancePaymentBase);
                                break;
                            case 22:
                                unitUnemploymentInsurancePaymentRatio = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setUnitUnemploymentInsurancePaymentRatio(unitUnemploymentInsurancePaymentRatio);
                                break;
                            case 23:
                                unitUnemploymentInsurance = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setUnitUnemploymentInsurance(unitUnemploymentInsurance);
                                break;
                            case 24:
                                unitGiveBirthInsurancePaymentBase = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setUnitGiveBirthInsurancePaymentBase(unitGiveBirthInsurancePaymentBase);
                                break;
                            case 25:
                                unitGiveBirthInsurancePaymentRatio = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setUnitGiveBirthInsurancePaymentRatio(unitGiveBirthInsurancePaymentRatio);
                                break;
                            case 26:
                                unitGiveBirthInsurance = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setUnitGiveBirthInsurance(unitGiveBirthInsurance);
                                break;
                            case 27:
                                unitDisabilityInsurance = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setUnitDisabilityInsurance(unitDisabilityInsurance);
                                break;
                            case 28:
                                personalPensionPaymentRatio = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setPersonalPensionPaymentRatio(personalPensionPaymentRatio);
                                break;

                            case 29:
                                personalPension = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setPersonalPension(personalPension);
                                break;
                            case 30:
                                personalMedicalInsurancePaymentRatio = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setPersonalMedicalInsurancePaymentRatio(personalMedicalInsurancePaymentRatio);
                                break;
                            case 31:
                                personalMedicalInsurance = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setPersonalMedicalInsurance(personalMedicalInsurance);
                                break;
                            case 32:
                                personalLargeMedicalInsurance = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setPersonalLargeMedicalInsurance(personalLargeMedicalInsurance);
                                break;
                            case 33:
                                personalSeriousIllInsurance = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setPersonalSeriousIllInsurance(personalSeriousIllInsurance);
                                break;
                            case 34:
                                personalUnemploymentInsurancePaymentRatio = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setPersonalUnemploymentInsurancePaymentRatio(personalUnemploymentInsurancePaymentRatio);
                                break;
                            case 35:
                                personalUnemploymentInsurance = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setPersonalUnemploymentInsurance(personalUnemploymentInsurance);
                                break;
                            case 36:
                                personalHeating = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                bean.setPersonalHeating(personalHeating);
                                break;
                            default:
                                break;
                        }
                    }
                }
                //设置录入日期
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.set(Calendar.YEAR, BaseHelpUtils.getIntValue(year));
                calendar.set(Calendar.MONTH, BaseHelpUtils.getIntValue(month) - 1);
                calendar.set(Calendar.DATE, 1);

                BaseEmployee be = findEmployee(name, no, listBeans, log);
                //这里可能会修改，try，catch可以捕获员工id为空的异常
                bean.setEmployeeId(be.getEmployeeId());
                bean.setEmployeeNo(be.getEmployeeNo());
                bean.setDepartmentId(be.getDepartmentId());
                bean.setPlateId(be.getPlateId());

                //获取日期
                Date recordDate = calendar.getTime();

                /**
                 * 将年，月，日，操作时间插入到数据库
                 */
                bean.setYear(BaseHelpUtils.getIntValue(year));
                bean.setMonth(BaseHelpUtils.getIntValue(month));
                bean.setOperateTime(recordDate);

                dao.setConditionEmployeeId("=", bean.getEmployeeId());
                dao.setConditionYear("=", BaseHelpUtils.getIntValue(year));
                dao.setConditionMonth("=", BaseHelpUtils.getIntValue(month));
                BaseFiveInsuranceOneGold esbean = dao.executeQueryOneRow();

                //查看是否已有该条记录，如果有取要计算的数据出来计算，没有用默认的0计算
                //先根据职员ID去检索数据，如果有则更新薪资，如果没有则插入
                if (esbean != null) {

                    if (unitTotalFund.compareTo(BigDecimal.ZERO) == 0) {
                        unitTotalFund = esbean.getUnitTotalFund();
                    }
                    if (personalTotalFund.compareTo(BigDecimal.ZERO) == 0) {
                        personalTotalFund = esbean.getPersonalTotalFund();
                    }

                    if (unitPension.compareTo(BigDecimal.ZERO) == 0) {
                        unitPension = esbean.getUnitPension();
                    }
                    if (unitMedicalInsurance.compareTo(BigDecimal.ZERO) == 0) {
                        unitMedicalInsurance = esbean.getUnitMedicalInsurance();
                    }
                    if (unitLargeMedicalInsurance.compareTo(BigDecimal.ZERO) == 0) {
                        unitLargeMedicalInsurance = esbean.getUnitLargeMedicalInsurance();
                    }
                    if (unitInjuryInsurance.compareTo(BigDecimal.ZERO) == 0) {
                        unitInjuryInsurance = esbean.getUnitInjuryInsurance();
                    }
                    if (unitUnemploymentInsurance.compareTo(BigDecimal.ZERO) == 0) {
                        unitUnemploymentInsurance = esbean.getUnitUnemploymentInsurance();
                    }
                    if (unitGiveBirthInsurance.compareTo(BigDecimal.ZERO) == 0) {
                        unitGiveBirthInsurance = esbean.getUnitGiveBirthInsurance();
                    }
                    if (unitDisabilityInsurance.compareTo(BigDecimal.ZERO) == 0) {
                        unitDisabilityInsurance = esbean.getUnitDisabilityInsurance();
                    }

                    if (personalPension.compareTo(BigDecimal.ZERO) == 0) {
                        personalPension = esbean.getPersonalPension();
                    }
                    if (personalMedicalInsurance.compareTo(BigDecimal.ZERO) == 0) {
                        personalMedicalInsurance = esbean.getPersonalMedicalInsurance();
                    }
                    if (personalLargeMedicalInsurance.compareTo(BigDecimal.ZERO) == 0) {
                        personalLargeMedicalInsurance = esbean.getPersonalLargeMedicalInsurance();
                    }
                    if (personalSeriousIllInsurance.compareTo(BigDecimal.ZERO) == 0) {
                        personalSeriousIllInsurance = esbean.getPersonalSeriousIllInsurance();
                    }
                    if (personalUnemploymentInsurance.compareTo(BigDecimal.ZERO) == 0) {
                        personalUnemploymentInsurance = esbean.getPersonalUnemploymentInsurance();
                    }
                    if (personalHeating.compareTo(BigDecimal.ZERO) == 0) {
                        personalHeating = esbean.getPersonalHeating();
                    }

                    //应缴公积金合计
                    BigDecimal totalFund = unitTotalFund.add(personalTotalFund);
                    bean.setTotalFund(totalFund);

                    //单位社保合计
                    BigDecimal unitTotalInsurance = unitPension.add(unitMedicalInsurance).add(unitLargeMedicalInsurance).add(unitInjuryInsurance).add(unitUnemploymentInsurance).add(unitGiveBirthInsurance).add(unitDisabilityInsurance);
                    bean.setUnitTotalInsurance(unitTotalInsurance);
                    //个人社保合计
                    BigDecimal personalTotalInsurance = personalPension.add(personalMedicalInsurance).add(personalLargeMedicalInsurance).add(personalSeriousIllInsurance).add(personalUnemploymentInsurance).add(personalHeating);
                    bean.setPersonalTotalInsurance(personalTotalInsurance);
                    //应缴社保合计
                    BigDecimal totalInsurance = unitTotalInsurance.add(personalTotalInsurance);
                    bean.setTotalInsurance(totalInsurance);
                    dao.setDataFromBase(esbean);
                    dao.clearModifiedFlags();
                    dao.setDataFromBase(bean);
                    dao.update();
                } else {
//                    bean.setEmployeeNo(be.getEmployeeNo());
//                    bean.setEmployeeName(be.getEmployeeName());
//                    bean.setCompanyId(be.getCompanyId());
//                    bean.setDepartmentId(be.getDepartmentId());
//                    bean.setPlateId(be.getPlateId());
                    //应缴公积金合计
                    BigDecimal totalFund = unitTotalFund.add(personalTotalFund);
                    bean.setTotalFund(totalFund);
                    //单位社保合计
                    BigDecimal unitTotalInsurance = unitPension.add(unitMedicalInsurance).add(unitLargeMedicalInsurance).add(unitInjuryInsurance).add(unitUnemploymentInsurance).add(unitGiveBirthInsurance).add(unitDisabilityInsurance);
                    bean.setUnitTotalInsurance(unitTotalInsurance);
                    //个人社保合计
                    BigDecimal personalTotalInsurance = personalPension.add(personalMedicalInsurance).add(personalLargeMedicalInsurance).add(personalSeriousIllInsurance).add(personalUnemploymentInsurance).add(personalHeating);
                    bean.setPersonalTotalInsurance(personalTotalInsurance);
                    //应缴社保合计
                    BigDecimal totalInsurance = unitTotalInsurance.add(personalTotalInsurance);
                    bean.setTotalInsurance(totalInsurance);
                    dao.clear();
                    dao.setDataFromBase(bean);
                    dao.save();
                }
            }
        }
        if (allerror > 0) {
            log.append("<br/>总共：").append(allerror).append("人没有导入").append("<br/>原因：根据员工编号/名称没有匹配到员工");
            System.out.print(log.toString());
            return log.toString();
        } else {
            return null;
        }
    }

    /**
     * 根据编号和名称去匹配人员
     *
     * @param name
     * @param no
     * @param bes
     * @param log
     * @return
     */
    public static BaseEmployee findEmployee(String name, String no, List<BaseEmployee> bes, StringBuilder log) {
        for (BaseEmployee be : bes) {
            if (!Objects.equals(name, be.getEmployeeName())) {
                continue;
            }
            if (!Objects.equals(no, be.getEmployeeNo())) {
                log.append(String.format("姓名:%1$s, EXCEL员工号:%2$s 数据库员工号: %3$s 不符<br/>", name, no, be.getEmployeeNo()));
                continue;
            }
            return be;
        }
        return null;
    }


    /**
     * 根据传过来的公司名称获取该公司的id
     *
     * @param companyName
     * @return
     */
    public static int findCompanyId(String companyName) throws SQLException {
        CompanyRecord dao = new CompanyRecord();
        dao.setConditionCompanyName("=", companyName);
        BaseCompanyRecord bean = dao.executeQueryOneRow();
        int companyId = bean.getCompanyRecordId();
        return companyId;
    }


    public static void main(String[] args) {
        try {
            OnUploadEmpFiveInsuranceOneGold a = new OnUploadEmpFiveInsuranceOneGold();
            a.saveData(new File("C:\\Users\\J&A\\Desktop\\empInsurance.xlsx"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
