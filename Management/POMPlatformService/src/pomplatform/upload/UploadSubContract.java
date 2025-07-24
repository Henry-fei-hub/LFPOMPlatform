package pomplatform.upload;

import com.pomplatform.db.bean.BaseDesignConsideration;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.DesignConsideration;
import com.pomplatform.db.dao.SubContract;
import com.pomplatform.db.dao.SystemDictionary;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericUploadProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class UploadSubContract implements GenericUploadProcessor {

    private static final Logger __logger = Logger.getLogger(UploadSubContract.class);
    private static List<BaseSystemDictionary> businessTypeList;
    private static List<BaseSystemDictionary> projectTypeList;

    @Override
    public String execute(String creteria, HttpServletRequest request, List<FileItem> items) throws Exception {
        if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
            JSON parser = new JSON(new StringReader(creteria));
            Map<String, Object> result = (Map<String, Object>) parser.parse(new BasicHandler());
            Integer contractId = BaseHelpUtils.getIntValue(result.get("contractId"));
            SystemDictionary sysDicDao = new SystemDictionary();
            sysDicDao.unsetSelectFlags();
            sysDicDao.setSelectDicTypeValue(true);
            sysDicDao.setSelectDicTypeValueId(true);
            sysDicDao.setConditionDicTypeId("=", 31);
            businessTypeList = sysDicDao.conditionalLoad();
            sysDicDao.setConditionDicTypeId("=", 32);
            projectTypeList = sysDicDao.conditionalLoad();
            for (FileItem fileItem : items) {
                File fullName = File.createTempFile("DelicacyUploadFiles", UUID.randomUUID().toString());
                fileItem.write(fullName);
                saveData(fullName, 1, contractId);
                fullName.delete();
            }
        }

        BaseCollection bc = new BaseCollection();
        return bc.toJSON(0, "^^^^^^^^^^^^^^^^^^" + creteria);
    }

    /**
     * 读取Excel的内容，第一维数组存储的是一行中格列的值，二维数组存储的是多少个行
     *
     * @param file 读取数据的源Excel
     * @param ignoreRows 读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
     * @param contractId 主合同ID
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void saveData(File file, int ignoreRows, Integer contractId)
            throws Exception {
        Contract contractDao = new Contract();
        contractDao.setContractId(contractId);
        contractDao.unsetSelectFlags();
        contractDao.setSelectContractName(true);
        contractDao.setSelectProjectCode(true);
        if (contractDao.load()) {
            Date date = new Date();
            List<DesignConsideration> list = new ArrayList<>();
            List<SubContract> subList = new ArrayList<>();
            int rowSize = 0;
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(
                    file));
            // 打开HSSFWorkbook
            POIFSFileSystem fs = new POIFSFileSystem(in);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFCell cell = null;
            ThreadConnection.beginTransaction();
            for (int sheetIndex = 0; sheetIndex < 1; sheetIndex++) {
                HSSFSheet st = wb.getSheetAt(sheetIndex);
                // 第一行为标题，不取
                for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {
                    HSSFRow row = st.getRow(rowIndex);
                    if (row == null) {
                        continue;
                    }
                    int tempRowSize = row.getLastCellNum() + 1;
                    if (tempRowSize > rowSize) {
                        rowSize = tempRowSize;
                    }
                    String[] values = new String[rowSize];
                    Arrays.fill(values, "");
                    cell = row.getCell(0);
                    if (BaseHelpUtils.isNullOrEmpty(cell)) {
                        break;
                    } else {
                        BaseDesignConsideration base = new BaseDesignConsideration();
                        for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
                            cell = row.getCell(columnIndex);
                            if (cell != null) {
                                switch (columnIndex) {
                                    case 0://主设计区域名称
                                        values[columnIndex] = cell.getStringCellValue();
                                        break;
                                    case 1://子设计区域名称
                                        values[columnIndex] = cell.getStringCellValue();
                                        break;
                                    case 2://业务类别
                                        values[columnIndex] = cell.getStringCellValue() + "~" + getBussinessCode(cell.getStringCellValue());
                                        break;
                                    case 3://项目类别
                                        values[columnIndex] = cell.getStringCellValue() + "~" + getProjectTypeCode(cell.getStringCellValue());
                                        break;
                                    case 4://精简装状态
                                        String str = cell.getStringCellValue();
                                        if (str.equals("简装")) {
                                            values[columnIndex] = "1";
                                        } else {
                                            values[columnIndex] = "0";
                                        }
                                        break;
                                    case 5://设计面积（㎡）
                                        values[columnIndex] = BaseHelpUtils.getString(cell.getNumericCellValue());
                                        break;
                                    case 6://设计单价（元/㎡）
                                        values[columnIndex] = BaseHelpUtils.getString(cell.getNumericCellValue());
                                        break;
                                    case 7://小计(元)
                                        values[columnIndex] = BaseHelpUtils.getString(cell.getNumericCellValue());
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        String[] businessTypeArr = values[2].split("~");
                        String[] projectTypeArr = values[3].split("~");
                        boolean alreadyHasSubContract = false;//根据业务类别和项目类别来判断，是否该子合同已经存在
                        int subContractId = 0;//子合同的ID
                        for (SubContract subObj : subList) {
                            if (subObj.getBusinessType().equals(BaseHelpUtils.getIntValue(businessTypeArr[1])) && subObj.getProjectType().equals(BaseHelpUtils.getIntValue(projectTypeArr[1]))) {
                                alreadyHasSubContract = true;
                                subContractId = subObj.getSubContractId();
                                break;
                            }
                        }
                        if (!alreadyHasSubContract) {//子合同尚未存在,则先创建子合同
                            SubContract sub = new SubContract();
                            sub.setProjectCode(contractDao.getProjectCode());
                            sub.setBusinessType(BaseHelpUtils.getIntValue(businessTypeArr[1]));
                            sub.setProjectType(BaseHelpUtils.getIntValue(projectTypeArr[1]));
                            sub.setParentId(contractId);
                            String name = "(" + businessTypeArr[0] + projectTypeArr[0] + ")" + contractDao.getContractName();
                            sub.setSubContractName(name);
                            sub.setCreateTime(date);
                            sub.setUpdateTime(date);
                            sub.save();
                            subContractId = sub.getSubContractId();
                            subList.add(sub);
                        }
                        //创建设计要素
                        DesignConsideration designConsiderationDao = new DesignConsideration();
                        designConsiderationDao.setSubContractId(subContractId);
                        designConsiderationDao.setMainDesignAreaName(values[0]);
//                        designConsiderationDao.setSubDesignAreaName(values[1]);
                        designConsiderationDao.setDecorationStatus(BaseHelpUtils.getIntValue(values[4]));
                        designConsiderationDao.setDesignArea(new BigDecimal(new DecimalFormat("0.00").format(BaseHelpUtils.getDoubleValue(values[5]))));
                        designConsiderationDao.setDesignUnitPrice(new BigDecimal(new DecimalFormat("0.00").format(BaseHelpUtils.getDoubleValue(values[6]))));
                        designConsiderationDao.setMoneySum(new BigDecimal(new DecimalFormat("0.00").format(BaseHelpUtils.getDoubleValue(values[7]))));
                        designConsiderationDao.save();
                        list.add(designConsiderationDao);
                    }
                }
            }
            //根据设计要素，汇总子合同的公区面积、后勤面积和小计
            for (SubContract subObj : subList) {
                int subId = subObj.getSubContractId();
                BigDecimal logisticsArea = new BigDecimal(0);
                BigDecimal commonArea = new BigDecimal(0);
                BigDecimal money = new BigDecimal(0);
                for (DesignConsideration conObj : list) {
                    if (conObj.getSubContractId().equals(subId)) {
                        if (conObj.getDecorationStatus().equals(0)) {//精装，属于公区面积
                            commonArea = commonArea.add(conObj.getDesignArea());
                        } else {//简装，属于后勤面积
                            logisticsArea = logisticsArea.add(conObj.getDesignArea());
                        }
                        money = money.add(conObj.getMoneySum());
                    }
                }
                subObj.setCommonArea(commonArea);
                subObj.setLogisticsArea(logisticsArea);
                subObj.setMoneySum(money);
                subObj.setCreateTime(date);
                subObj.setUpdateTime(date);
                subObj.update();
            }
            in.close();
            ThreadConnection.commit();
        }
    }

    private static String getBussinessCode(String content) {
        if (!BaseHelpUtils.isNullOrEmpty(content) && !BaseHelpUtils.isNullOrEmpty(businessTypeList)) {
            for (BaseSystemDictionary base : businessTypeList) {
                if (content.equals(BaseHelpUtils.getString(base.getDicTypeValue()))) {
                    System.out.println(String.format("%02d", base.getDicTypeValueId()));
                    return String.format("%02d", base.getDicTypeValueId());
                }
            }
        }
        return "00";
    }

    private static String getProjectTypeCode(String content) {
        if (!BaseHelpUtils.isNullOrEmpty(content) && !BaseHelpUtils.isNullOrEmpty(projectTypeList)) {
            for (BaseSystemDictionary base : projectTypeList) {
                if (content.equals(BaseHelpUtils.getString(base.getDicTypeValue()))) {
                    System.out.println(String.format("%02d", base.getDicTypeValueId()));
                    return String.format("%02d", base.getDicTypeValueId());
                }
            }
        }
        return "00";
    }
}
//    public static void main(String[] args) {
//        try {
//            SystemDictionary sysDicDao = new SystemDictionary();
//            sysDicDao.unsetSelectFlags();
//            sysDicDao.setSelectDicTypeValue(true);
//            sysDicDao.setSelectDicTypeValueId(true);
//            sysDicDao.setConditionDicTypeId("=", 31);
//            businessTypeList = sysDicDao.conditionalLoad();
//            sysDicDao.setConditionDicTypeId("=", 32);
//            projectTypeList = sysDicDao.conditionalLoad();
//            File file = new File("C:\\Users\\PEPE\\Desktop\\子合同导入模板.xls");
//            saveData(file, 1, 15);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
