package pomplatform.equipment.handler;

import com.pomplatform.db.bean.BaseEquipmentRecord;
import com.pomplatform.db.bean.BaseEquipmentType;
import com.pomplatform.db.dao.EquipmentRecord;
import com.pomplatform.db.dao.EquipmentType;
import com.pomplatform.db.handler.EquipmentTypeHandler;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.common.JsonParser;
import delicacy.connection.ThreadConnection;
import delicacy.servlet.HttpCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: xiaolong
 * @Date: 2020/7/10 11:46
 */
public class AddEquipmentProcess implements GenericProcessor {

    private Logger logger = LoggerFactory.getLogger(AddEquipmentProcess.class);
    @Override
    public String execute(String creteria, HttpServletRequest httpServletRequest) throws Exception {
        // 获取操作员,部门,角色等信息
        HttpCookie cookies = new HttpCookie(httpServletRequest);
        int operatorId = cookies.getOperatorId();
        if (operatorId == 0) {
            //如果cookie中没有取到，则从传过来的参数列表中获取
            Map<String, Object> param = (Map<String, Object>) JsonParser.parse(creteria);
            operatorId = BaseHelpUtils.getIntValue(param, "updatePerson");
        }
        int num;
        //保存物品
        Date updateTime = new Date();
        BaseEquipmentType bean = new BaseEquipmentType();
        //物品属性
        bean.setDataFromJSON(creteria);
        bean.setUpdatePerson(operatorId);
        bean.setUpdateTime(updateTime);
        Integer equipmentTypeId = bean.getEquipmentTypeId();
        EquipmentType dao = new EquipmentType();
        BaseEquipmentType bean1 = dao.executeQueryOneRow("name = '"+bean.getName()+"' and is_delete = false ");
        BaseEquipmentType bean2 = dao.executeQueryOneRow("equipment_type_id = "+equipmentTypeId);
//        logger.debug(bean1.toJSONString());
//        BaseEquipmentType bean2 = dao.executeQueryOneRow("equipment_type_id = "+equipmentTypeId);
        if(BaseHelpUtils.isNullOrEmpty(bean1)&&BaseHelpUtils.isNullOrEmpty(bean2)){
            //新增物品
            dao.clear();
            dao.setDataFromBase(bean);
            num = dao.save();
        }else if(!BaseHelpUtils.isNullOrEmpty(bean1)&&BaseHelpUtils.isNullOrEmpty(equipmentTypeId)&&bean1.getEnabled()){
                throw new Exception("请勿重复添加物品，可刷新后添加该物品库存！");
        } else{
            //更新库存
            dao.clear();
            bean2.setCount(bean2.getCount()+bean.getCount());
            dao.setDataFromBase(bean2);
            num = dao.update();
        }
        //新增物品操作记录
        EquipmentRecord recordDao = new EquipmentRecord();
        BaseEquipmentRecord baseEquipmentRecord = new BaseEquipmentRecord();
        //物品id
        baseEquipmentRecord.setEquipmentId(dao.getEquipmentTypeId());
        //操作类型(新增)
        baseEquipmentRecord.setOperationType((short)3);
        //当前操作人id
        baseEquipmentRecord.setOperationPerson(operatorId);
        baseEquipmentRecord.setOperationTime(updateTime);
        baseEquipmentRecord.setCount(bean.getCount());
        recordDao.clear();
        recordDao.setDataFromBase(baseEquipmentRecord);
        recordDao.save();
        return bean.toOneLineJSON(num, null);
    }
}
