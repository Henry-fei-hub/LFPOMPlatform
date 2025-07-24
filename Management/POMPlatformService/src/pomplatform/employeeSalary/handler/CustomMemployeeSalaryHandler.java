package pomplatform.employeeSalary.handler;

import com.pomplatform.db.dao.SystemConfig;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.common.GenericBase;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.json.ParseException;
import delicacy.servlet.DelicacyServlet;
import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import pomplatform.common.utils.StaticUtils;
import pomplatform.employeeSalary.bean.BaseMemployeeSalary;
import pomplatform.employeeSalary.bean.ConditionMemployeeSalary;
import static pomplatform.employeeSalary.handler.MemployeeSalaryHandler.executeQueryMemployeeSalary;
import pomplatform.employeeSalary.query.QueryMemployeeSalary;

public class CustomMemployeeSalaryHandler extends MemployeeSalaryHandler {

    private static final Logger __logger = Logger.getLogger(CustomMemployeeSalaryHandler.class);

    @Override
    public String find(String creteria) throws Exception {
        ConditionMemployeeSalary c = new ConditionMemployeeSalary();
        c.setDataFromJSON(creteria);
        BaseCollection<BaseMemployeeSalary> result = executeQueryMemployeeSalary(c, c.getKeyValues());
        result = getSalary(result, creteria);
        return result.toJSON(null);
    }

    @Override
    public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
        BaseCollection<BaseMemployeeSalary> result;
        ConditionMemployeeSalary c = new ConditionMemployeeSalary();
        c.setDataFromJSON(creteria);
        QueryMemployeeSalary dao = new QueryMemployeeSalary();
        dao.setCurrentPage(c.getCurrentPage());
        dao.setPageLines(c.getPageLines());
        result = dao.executeQuery(c.getKeyValues(), c);
        if (result.getTotalLines() > GenericBase.MAX_EXPORT_LINES) {
            throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
        }
        SystemConfig sysDao = new SystemConfig();
        sysDao.setConditionSystemConfigId("=", 2);
        DES des = new DES(sysDao.executeQueryOneRow().getImagePath());
        result = dao.executeQuery(c.getKeyValues(), c);
//        result = getSalary(result, creteria);
        try (PrintStream ps = new PrintStream(downFile, "GBK")) {
            ps.println(BaseMemployeeSalary.ALL_CAPTIONS);
            for (BaseMemployeeSalary b : result.getCollections()) {
            	b.setBasicSalary(des.DEC(b.getBasicSalary()));
                ps.println(b.toCSVString());
            }
        }
    }
    
    /**
     * 如果是解密搜索，则返回明码
     * @param result
     * @param creteria
     * @return
     * @throws ParseException
     * @throws SQLException
     * @throws UnsupportedEncodingException 
     */
    public BaseCollection<BaseMemployeeSalary> getSalary(BaseCollection<BaseMemployeeSalary> result,String creteria) throws ParseException, SQLException, UnsupportedEncodingException{
        Map<String, Object> resultMap = null;
        if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
            JSON parser = new JSON(new StringReader(creteria));
            resultMap = (Map<String, Object>) parser.parse(new BasicHandler());
        }
        if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(resultMap)) {
            //检索系统表中的秘钥
            SystemConfig sc = new SystemConfig();
            sc.setSystemConfigId(StaticUtils.SYSTEM_KEY);
            sc.load();
            String keyValue = sc.getImagePath() == null ? DelicacyServlet.PUBLIC_KEY : sc.getImagePath();
            //获取输入的秘钥
            String getkeyValue = BaseHelpUtils.getStringValue(resultMap, "keyValue");
            DES des = new DES(DelicacyServlet.PUBLIC_KEY);//先对输入的秘钥进行加密
            String finalKeyValue = des.ENC(getkeyValue);
            if (keyValue.equals(finalKeyValue)) {//如果输入的秘钥匹配，则进行转秘
                if (!BaseHelpUtils.isNullOrEmpty(result)) {
                    des = new DES(keyValue);
                    List<BaseMemployeeSalary> listbeans = result.getCollections();
                    for (BaseMemployeeSalary e : listbeans) {
                        e.setBasicSalary(des.DEC(e.getBasicSalary()));
                    }
                    result.setCollections(listbeans);
                }
            }
        }
        return result;
    }

}
