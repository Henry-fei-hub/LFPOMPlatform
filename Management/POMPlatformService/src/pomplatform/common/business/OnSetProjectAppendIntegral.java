package pomplatform.common.business;

import com.pomplatform.db.bean.BaseProjectAppendIntegralRecord;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectAppendIntegralRecord;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 项目追加积分
 * @author lxf
 */
public class OnSetProjectAppendIntegral implements GenericProcessor{
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        Map<String, Object> result = null;
        if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
            JSON parser = new JSON(new StringReader(creteria));
            result = (Map<String, Object>) parser.parse(new BasicHandler());
        }
        if(!BaseHelpUtils.isNullOrEmpty(result)){
            boolean flag = BaseHelpUtils.getBoolean(result.get("flag"));
            int projectId = BaseHelpUtils.getIntValue(result,"projectId");
            double totalIntegral = BaseHelpUtils.getDoubleValue(result.get("totalIntegral"));
            double projectIntegral = BaseHelpUtils.getDoubleValue(result.get("projectIntegral"));
            double reserveIntegral = BaseHelpUtils.getDoubleValue(result.get("reserveIntegral"));
            double appendTotalIntegral = BaseHelpUtils.getDoubleValue(result.get("appendTotalIntegral"));
            int appendIntegral = BaseHelpUtils.getIntValue(result.get("appendIntegral"));
            double percentage = BaseHelpUtils.getDoubleValue(result.get("percentage"));
            String remark = BaseHelpUtils.getStringValue(result,"remark");
            ThreadConnection.beginTransaction();
            Project dao = new Project();
            dao.setProjectId(projectId);
            if(flag){//板块运营负责人的操作
                if(dao.load()){
                    //根据项目的追加积分和核算比例重新分配项目积分和预留积分
                    double reserveInte = Math.round(appendIntegral*percentage/100);//根据追加积分和核算比例计算出的预留积分
                    dao.setProjectIntegral(new BigDecimal(projectIntegral+(appendIntegral-reserveInte)));
                    dao.setReserveIntegral(new BigDecimal(reserveIntegral+reserveInte));
                    dao.setAppendIntegral(new BigDecimal(0));//清空当前的追加积分
                    dao.setRemark("");
                    dao.update();
                    //更新项目追加的项目积分的同时，需往项目追加积分记录表中添加一条记录
                    ProjectAppendIntegralRecord paDao = new ProjectAppendIntegralRecord();
                    BaseProjectAppendIntegralRecord paBase = new BaseProjectAppendIntegralRecord();
                    paBase.setProjectId(projectId);
                    paBase.setAppendIntegral(appendIntegral);
                    paBase.setPercentage(new BigDecimal(percentage));
                    paBase.setRemark(remark);
                    paBase.setAppendTime(new Date());
                    paDao.setDataFromBase(paBase);
                    paDao.save();
                }
            }else{//运营部门人的操作
                if(dao.load()){
                    //向当前项目设置项目追加积分并向该项目的项目总积分累加上追加的积分，同时项目追加总积分也得累加上追加的积分
                    dao.setAppendIntegral(new BigDecimal(appendIntegral));
                    dao.setAppendTotalIntegral(new BigDecimal(appendTotalIntegral+appendIntegral));
                    dao.setRemark(remark);
                    dao.setTotalIntegral(new BigDecimal(totalIntegral+appendIntegral));
                    dao.update();
                }
            }
            ThreadConnection.commit();
        }
        BaseCollection bc = new BaseCollection();
        return bc.toJSON(0, "");
    }
}
