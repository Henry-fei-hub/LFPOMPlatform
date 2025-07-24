package pomplatform.contract.business;

import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.Project;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * 合同删除
 *
 * @author lxf
 */
public class ContractDelete implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        //删除合同表表数据，先删除关联项目的数据
        ThreadConnection.beginTransaction();
        BaseContract bean = new BaseContract();
        bean.setDataFromJSON(creteria);
        Contract dao = new Contract();
        //获取合同编号
        String contractCode = bean.getContractCode();
        //根据合同编号删除关联项目表中的数据
        Project projectDao = new Project();
        projectDao.setConditionContractCode("=", contractCode);
        projectDao.conditionalDelete();
        //根据ID删除
        dao.setDataFromBase(bean);
        dao.delete();
        ThreadConnection.commit();
        return bean.toOneLineJSON(0, null);
    }

}
