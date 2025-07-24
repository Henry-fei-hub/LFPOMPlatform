package pomplatform.tablemaintain.handler;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.tablemaintain.bean.BasegetAllTables;
import pomplatform.tablemaintain.bean.ConditiongetAllTables;
import pomplatform.tablemaintain.query.QuerygetAllTables;

import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TableMaintainProcess implements GenericProcessor {

    /**
     * 方法：获取所有的数据库表格
     */
    private final static String GET_ALL_TABLES = "getAllTables";

    @Override
    public String execute(String s, HttpServletRequest httpServletRequest) throws Exception {
        Map<String, Object> result = null;
        if (!BaseHelpUtils.isNullOrEmpty(s)) {
            @SuppressWarnings("rawtypes")
            JSON parser = new JSON(new StringReader(s));
            result = (Map<String, Object>) parser.parse(new BasicHandler());
        }
        String optType = BaseHelpUtils.getStringValue(result, "opt_type");
        if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)){
            switch (optType) {
                case GET_ALL_TABLES:
                    return getAllTables(result);
                default:
                    break;
            }
        }
        return null;

    }

    /**
     * @author liubin
     * @date 2020/1/2 12:05
     * @param
     * @return
     * @description : 获取所有的数据库的表格
     */
    private String getAllTables(Map<String, Object> result) throws SQLException {
        BaseCollection<GenericBase> bc = new BaseCollection<>();
        QuerygetAllTables querygetAllTables = new QuerygetAllTables();
        ConditiongetAllTables conditiongetAllTables = new ConditiongetAllTables();
        BaseCollection<BasegetAllTables> lists = querygetAllTables.executeQuery(null, conditiongetAllTables);
        if (!BaseHelpUtils.isNullOrEmpty(lists) && lists.getCollections().size() != 0) {
            List<BasegetAllTables> collections = lists.getCollections();
            for (BasegetAllTables basegetAllTables : collections) {

            }
        }
        return null;
    }
}
