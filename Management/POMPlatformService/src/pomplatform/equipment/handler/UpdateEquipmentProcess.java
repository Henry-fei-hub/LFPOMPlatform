package pomplatform.equipment.handler;

import com.pomplatform.db.bean.BaseEquipmentRecord;
import com.pomplatform.db.bean.BaseEquipmentType;
import com.pomplatform.db.dao.EquipmentRecord;
import com.pomplatform.db.dao.EquipmentType;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.common.JsonParser;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.servlet.HttpCookie;

import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

/**
 * @author: xiaolong
 * @Date: 2020/7/8 15:31
 */
public class UpdateEquipmentProcess implements GenericProcessor {

    private final static String UPDATECOUNT = "updateCount"; //调整库存
    private final static String UPDATEENABLED = "updateEnabled"; // 设置启用/禁用
    private final static String DELETE = "delete"; //逻辑删除
    private final static String ADD = "add"; //新增后的操作
    private final static String MODIFY = "modify";//修改

    @Override
    public String execute(String creteria, HttpServletRequest httpServletRequest) throws Exception {
        Map<String, Object> result = null;
        if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
            @SuppressWarnings("rawtypes")
            JSON parser = new JSON(new StringReader(creteria));
            result = (Map<String, Object>) parser.parse(new BasicHandler());
        }
        String optType = BaseHelpUtils.getStringValue(result, "optType");

        // 获取操作员,部门,角色等信息
        HttpCookie cookies = new HttpCookie(httpServletRequest);
        int operatorId = cookies.getOperatorId();
        if (operatorId == 0) {
            //如果cookie中没有取到，则从传过来的参数列表中获取
            Map<String, Object> param = (Map<String, Object>) JsonParser.parse(creteria);
            operatorId = BaseHelpUtils.getIntValue(param, "userId");
        }

        if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)){
            switch (optType){
                case UPDATECOUNT:
                    return updateCount(creteria,operatorId);
                case UPDATEENABLED :
                    return updateEnabled(creteria);
                case DELETE:
                    return delete(creteria);
                case ADD:
                    return afterAdd(creteria,operatorId);
                case MODIFY:
                    return modify(creteria, operatorId);
            }
        }

        return null;
    }

    /**
     * 调整库存
     * @param creteria
     * @param employeeId
     * @return
     * @throws Exception
     */
    private String updateCount(String creteria,Integer employeeId) throws Exception {
        BaseEquipmentType bean = new BaseEquipmentType();
        bean.setDataFromJSON(creteria);
        Date updateTime = new Date();
        EquipmentType dao = new EquipmentType();
        //得到要修改的库存 +-
        int count = bean.getCount();
        //得到数据库里面的数据
        bean = dao.executeQueryOneRow("equipment_type_id = "+bean.getEquipmentTypeId());
        if(bean.getCount()+count<0)
            return "{\"status\":\"-1\",\"errorMessage\":\"库存不足\"}";

        dao.clear();
        //更新库存
        bean.setCount(bean.getCount()+count);
        bean.setUpdatePerson(employeeId);
        if(BaseHelpUtils.isNullOrEmpty(bean.getUpdateTime())){
            bean.setUpdateTime(updateTime);
        }
        dao.setDataFromBase(bean);

        EquipmentRecord recordDao = new EquipmentRecord();
        BaseEquipmentRecord baseEquipmentRecord = new BaseEquipmentRecord();
        //物品id
        baseEquipmentRecord.setEquipmentId(bean.getEquipmentTypeId());

        //操作类型（库存调整）
        baseEquipmentRecord.setOperationType((short)4);
        //当前操作人id
        baseEquipmentRecord.setOperationPerson(employeeId);
        baseEquipmentRecord.setOperationTime(updateTime);
        baseEquipmentRecord.setCount(count);
        recordDao.clear();
        recordDao.setDataFromBase(baseEquipmentRecord);
        ThreadConnection.beginTransaction();
        dao.update();
        recordDao.save();
        ThreadConnection.commit();
        return "{\"status\":\"1\",\"errorMessage\":\"修改成功\"}";
    }

    /**
     * 修改名称或者价格
     * @param creteria
     * @param employeeId
     * @return
     * @throws Exception
     */
    private String modify(String creteria,Integer employeeId) throws Exception {
        BaseEquipmentType bean = new BaseEquipmentType();
        bean.setDataFromJSON(creteria);
        if(!BaseHelpUtils.isNullOrEmpty(bean.getName()) || !BaseHelpUtils.isNullOrEmpty(bean.getPrice())){
            EquipmentType dao = new EquipmentType();
            dao.setDataFromBase(bean);
            dao.update();
            return "{\"status\":\"1\",\"errorMessage\":\"修改成功\"}";
        }
        return "{\"status\":\"-1\",\"errorMessage\":\"操作失败\"}";
    }

    /**
     * 启用 禁用
     * @param creteria
     * @return
     * @throws Exception
     */
    private String updateEnabled(String creteria) throws Exception {
        BaseEquipmentType bean = new BaseEquipmentType();
        bean.setDataFromJSON(creteria);
        if(!BaseHelpUtils.isNullOrEmpty(bean.getEnabled())){
            EquipmentType dao = new EquipmentType();
            dao.setDataFromBase(bean);
            dao.update();
            return "{\"status\":\"1\",\"errorMessage\":\"修改成功\"}";
        }
        return "{\"status\":\"-1\",\"errorMessage\":\"操作失败\"}";
    }

    /**
     * 删除
     * @param creteria
     * @return
     * @throws Exception
     */
    private String delete(String creteria) throws Exception {
        BaseEquipmentType bean = new BaseEquipmentType();
        bean.setDataFromJSON(creteria);
        EquipmentRecord recordDao = new EquipmentRecord();
        int recordCount = recordDao.countRows("equipment_id = "+bean.getEquipmentTypeId()+" and  follow_status is not null  ");
        if(recordCount > 0){
            throw new Exception("该物品已被使用，不可删除！");
        }
        bean.setIsDelete(true);
        bean.setEnabled(false);
        EquipmentType dao = new EquipmentType();
        dao.setDataFromBase(bean);
        ThreadConnection.beginTransaction();
        dao.update();
        ThreadConnection.commit();
        return "{\"status\":\"-1\",\"errorMessage\":\"删除成功\"}";
    }

    /**
     * 新增
     * @param creteria
     * @param employeeId
     * @return
     * @throws Exception
     */
    private String afterAdd(String creteria,Integer employeeId) throws Exception {
        BaseEquipmentType bean = new BaseEquipmentType();
        bean.setDataFromJSON(creteria);
        EquipmentRecord recordDao = new EquipmentRecord();
        BaseEquipmentRecord baseEquipmentRecord = new BaseEquipmentRecord();
        //物品id
        baseEquipmentRecord.setEquipmentId(recordDao.getEquipmentId());

        //操作类型(新增)
        baseEquipmentRecord.setOperationType((short)3);
        //当前操作人id
        if(!BaseHelpUtils.isNullOrZero(employeeId))
            baseEquipmentRecord.setOperationPerson(employeeId);
        baseEquipmentRecord.setOperationTime(new Date());
        baseEquipmentRecord.setCount(bean.getCount());
        recordDao.clear();
        recordDao.setDataFromBase(baseEquipmentRecord);
        ThreadConnection.beginTransaction();
        recordDao.save();
        ThreadConnection.commit();
        return "";
    }
}
