package pomplatform.upload;

import com.pomplatform.db.bean.BaseProjectCost;
import com.pomplatform.db.dao.ProjectCost;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericUploadProcessor;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author lxf
 */
public class UploadFileCommon implements GenericUploadProcessor {

    private static final Logger __logger = Logger.getLogger(UploadFileCommon.class);

    @Override
    public String execute(String creteria, HttpServletRequest request, List<FileItem> items) throws Exception {
        for (FileItem fileItem : items) {
        	File fullName = File.createTempFile("DelicacyUploadFiles",UUID.randomUUID().toString());
            fileItem.write(fullName);
            saveData(fullName,1);
            fullName.delete();
        }
        BaseCollection bc = new BaseCollection();
        return bc.toJSON(0, null);
    }

    /**
     * 读取Excel的内容，第一维数组存储的是一行中格列的值，二维数组存储的是多少个行
     *
     * @param file 读取数据的源Excel
     * @param ignoreRows 读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void saveData(File file, int ignoreRows)
            throws Exception{
        List<BaseProjectCost> list = new ArrayList<>();
        int rowSize = 0;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(
                file));
       // 打开HSSFWorkbook
        POIFSFileSystem fs = new POIFSFileSystem(in);
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFCell cell = null;
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
                }else{
                    BaseProjectCost base = new BaseProjectCost();
                    for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
                        cell = row.getCell(columnIndex);
                        if (cell != null) {
                            switch(columnIndex){
                                case 0:
                                    base.setProjectId(BaseHelpUtils.getIntValue(cell.getNumericCellValue()));
                                    break;
                                case 3:
                                    base.setEmployeeId(BaseHelpUtils.getIntValue(cell.getStringCellValue().split("~")[2]));
                                    break;
                                case 4:
                                    base.setCostType(BaseHelpUtils.getIntValue(BaseHelpUtils.getString(cell.getStringCellValue()).split("-")[1]));
                                    break;
                                case 5:
                                    BigDecimal cost = new BigDecimal(new DecimalFormat("0.00").format(cell.getNumericCellValue()));
                                    base.setAmount(cost);
                                    break;
                                case 6:
                                    String text = BaseHelpUtils.getString(cell.getStringCellValue());
                                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
                                    ParsePosition pos = new ParsePosition(0);  
                                    Date date = formatter.parse(text, pos);
                                    base.setCostDate(date);
                                    break;
                                default:
                            }
                        }
                    }
                    list.add(base);
                }
            }
        }
        in.close();
        ProjectCost dao = new ProjectCost();
        dao.save(list);
    }
}
