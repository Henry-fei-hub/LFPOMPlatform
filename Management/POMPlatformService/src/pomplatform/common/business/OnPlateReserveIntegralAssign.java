package pomplatform.common.business;

import com.pomplatform.db.bean.BasePlateIntegralAssignRecord;
import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.dao.PlateIntegralAssignRecord;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * 部门积分发放处理
 * @author lxf
 */
public class OnPlateReserveIntegralAssign implements GenericProcessor {
    private static final Logger __logger = Logger.getLogger("");
    private static final String ALL_ASSIGN_INTEGRAL = "allEmployeeAssign";
    private static final String ONE_ASSIGN_INTEGRAL = "oneEmployeeAssign";

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ThreadConnection.beginTransaction();
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        String opt_type = BaseHelpUtils.getStringValue(param,"opt_type");
        PlateIntegralAssignRecord dao = new PlateIntegralAssignRecord();
        BasePlateIntegralAssignRecord bean;
        if(ALL_ASSIGN_INTEGRAL.equals(opt_type)){
            //获取到职员发放的grid数据
            List<BaseProjectEmployee> resultList = GenericBase.__getList(param.get("employeeAssign"), BaseProjectEmployee.newInstance());
            if(!BaseHelpUtils.isNullOrEmpty(resultList) && !resultList.isEmpty()){
                List<BasePlateIntegralAssignRecord> listBean = new ArrayList<>();
                for(BaseProjectEmployee e : resultList){
                    bean = new BasePlateIntegralAssignRecord();
                    bean.setDataFromJSON(creteria);
                    bean.setEmployeeId(BaseHelpUtils.getIntValue(e.getEmployeeId()));
                    bean.setAssignIntegral(new BigDecimal(BaseHelpUtils.getDoubleValue(e.getRealIntegral())));
                    dao.setDataFromBase(bean);
                    listBean.add(bean);
                }
                dao.save(listBean);
            }
            
        }else if(ONE_ASSIGN_INTEGRAL.equals(opt_type)){
            bean = new BasePlateIntegralAssignRecord();
            bean.setDataFromJSON(creteria);
            dao.setDataFromBase(bean);
            dao.save();
        }
        ThreadConnection.commit();
        return dao.generateBase().toOneLineJSON(0,null);
    }

}
