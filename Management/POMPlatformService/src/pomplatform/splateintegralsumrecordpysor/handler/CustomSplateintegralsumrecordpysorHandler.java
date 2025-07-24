package pomplatform.splateintegralsumrecordpysor.handler;

import org.apache.log4j.Logger;
import pomplatform.splateintegralsumrecordpysor.bean.BaseSplateintegralsumrecordpysor;
import pomplatform.splateintegralsumrecordpysor.bean.ConditionSplateintegralsumrecordpysor;
import pomplatform.splateintegralsumrecordpysor.query.QuerySplateintegralsumrecordpysor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.json.ParseException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import pomplatform.common.utils.CommonHandel;

public class CustomSplateintegralsumrecordpysorHandler extends SplateintegralsumrecordpysorHandler {

    private static final Logger __logger = Logger.getLogger(CustomSplateintegralsumrecordpysorHandler.class);

    @Override
    public String find(String creteria) throws Exception {
        ConditionSplateintegralsumrecordpysor c = new ConditionSplateintegralsumrecordpysor();
        c.setDataFromJSON(creteria);
        BaseCollection<BaseSplateintegralsumrecordpysor> result = executeQuerySplateintegralsumrecordpysor(c, c.getKeyValues());
        setFinalAccReserveIntegral(result, creteria);
        return result.toJSON(null);
    }

    @Override
    public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
        BaseCollection<BaseSplateintegralsumrecordpysor> result;
        ConditionSplateintegralsumrecordpysor c = new ConditionSplateintegralsumrecordpysor();
        c.setDataFromJSON(creteria);
        QuerySplateintegralsumrecordpysor dao = new QuerySplateintegralsumrecordpysor();
        dao.setCurrentPage(1);
        dao.setPageLines(1);
        result = dao.executeQuery(c.getKeyValues(), c);
        if (result.getTotalLines() > GenericBase.MAX_EXPORT_LINES) {
            throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
        }
        dao.setCurrentPage(0);
        result = dao.executeQuery(c.getKeyValues(), c);
        setFinalAccReserveIntegral(result, creteria);
        try (PrintStream ps = new PrintStream(downFile, "GBK")) {
            ps.println(BaseSplateintegralsumrecordpysor.ALL_CAPTIONS);
            for (BaseSplateintegralsumrecordpysor b : result.getCollections()) {
                ps.println(b.toCSVString());
            }
        }
    }

    /**
     * 设置最终的价值积分
     *
     * @param result
     * @param creteria
     */
    public void setFinalAccReserveIntegral(BaseCollection<BaseSplateintegralsumrecordpysor> result, String creteria) throws ParseException, SQLException {
        if (!BaseHelpUtils.isNullOrEmpty(result)) {
            JSON parser = new JSON(new StringReader(creteria));
            Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
            int year = BaseHelpUtils.getIntValue(param.get("year"));
            int startMonth = BaseHelpUtils.getIntValue(param.get("startMonth"));
            int endMonth = BaseHelpUtils.getIntValue(param.get("endMonth"));
            //设置开始计算的日期格式
            StringBuilder startDate = new StringBuilder();
            StringBuilder endDate = new StringBuilder();
            if (year > 0) {
                if (startMonth > 0) {
                    startDate.append(year).append("-").append(startMonth).append("-01");
                }
                if (endMonth > 0) {
                    endMonth += 1;
                    endDate.append(year).append("-").append(endMonth).append("-01");
                }
            }
            List<BaseSplateintegralsumrecordpysor> list = result.getCollections();
            for (BaseSplateintegralsumrecordpysor e : list) {
                int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
                //获取价值积分
                double achiveIntegral = BaseHelpUtils.getDoubleValue(e.getAchieveIntegral());
                double accReserveIntegral = CommonHandel.getFinalAccReserveIntegral(plateId, achiveIntegral, startDate.toString(), endDate.toString());
                e.setAchieveIntegral(new BigDecimal(accReserveIntegral));
            }
            result.setCollections(list);
        }
    }

}
