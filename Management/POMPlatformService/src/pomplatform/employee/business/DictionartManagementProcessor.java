package pomplatform.employee.business;

import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.dao.SystemDictionary;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.employee.bean.BaseDictionartManagenment;
import pomplatform.employee.bean.ConditionDictionartManagenment;
import pomplatform.employee.query.QueryDictionartManagenment;

import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionartManagementProcessor implements GenericProcessor {

        private static final String OPT_TYPE = "optType";

        private static final String INIT_DATE = "initDate";

        @Override
        public String execute(String creteria, HttpServletRequest request) throws Exception {
            JSON parser = new JSON(new StringReader(creteria));
            Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
            String optType = BaseHelpUtils.getString(param.get("optType"));
            switch(optType){
                case INIT_DATE:
                    return initDate(param);
                default :
                    return null;
            }

        }

    /**
     * 查询原始数据并且封装成树形结构
     * @param param
     * @return
     */
    private String initDate(Map<String,Object> param) throws SQLException {
        ConditionDictionartManagenment conditionDictionartManagenment = new ConditionDictionartManagenment();
        QueryDictionartManagenment queryDictionartManagenment = new QueryDictionartManagenment();
        String dicTypeName = BaseHelpUtils.getString(param.get("dicTypeName"));
        if (!BaseHelpUtils.isNullOrEmpty(dicTypeName)){
            conditionDictionartManagenment.setDicTypeName(dicTypeName);
        }
        BaseCollection<BaseDictionartManagenment> collection = queryDictionartManagenment.executeQuery(null,conditionDictionartManagenment);//查询所有的以及菜单
        SystemDictionary systemDictionary = new SystemDictionary();
        ArrayList<BaseSystemDictionary> lists = new ArrayList<>();

        if (!BaseHelpUtils.isNullOrEmpty(collection)){
            List<BaseDictionartManagenment> baseDictionartManagenments = collection.getCollections();
            for (BaseDictionartManagenment baseDictionartManagenment : baseDictionartManagenments){//遍历所有的一级结构
                Integer dicTypeId = baseDictionartManagenment.getDicTypeId();
                if (!BaseHelpUtils.isNullOrEmpty(dicTypeId)){
                    int parentId = 10000000 + dicTypeId;
                    BaseSystemDictionary baseSystemDictionary1 = new BaseSystemDictionary();
                    baseSystemDictionary1.setDicTypeId(dicTypeId);
                    baseSystemDictionary1.setDictionaryId(parentId);
                    baseSystemDictionary1.setDicTypeName(baseDictionartManagenment.getDicTypeName());
                    baseSystemDictionary1.setParentId(0);
                    lists.add(baseSystemDictionary1);//将一级部门添加进list中
                    systemDictionary.clear();
                    systemDictionary.setConditionDicTypeId("=", dicTypeId);
                    List<BaseSystemDictionary> baseSystemDictionaries = systemDictionary.conditionalLoad();
                    for (BaseSystemDictionary baseSystemDictionary : baseSystemDictionaries){
                        baseSystemDictionary.setParentId(parentId);
                        lists.add(baseSystemDictionary);//将子集添加进list中
                    }
                }
            }
        }
        BaseCollection<BaseSystemDictionary> collection2 = new BaseCollection<>();
        collection2.setCollections(lists);
        String s = collection2.toJSON(null);
        return collection2.toJSON(null);
    }

    public static void main(String[] args) throws Exception {
        DictionartManagementProcessor dictionartManagementProcessor = new DictionartManagementProcessor();
        String creteria = "{\"optType\":\"initDate\"}";
        dictionartManagementProcessor.execute(creteria,null);
    }

}
