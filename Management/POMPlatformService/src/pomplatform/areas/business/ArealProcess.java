package pomplatform.areas.business;

import com.pomplatform.db.bean.BaseArea;
import com.pomplatform.db.dao.Area;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ArealProcess implements GenericProcessor {

    /**
     * 保存区域
     */
    private final static String SAVE_AREAL = "saveAreal";

    @Override
    public String execute(String s, HttpServletRequest httpServletRequest) throws Exception {
        JSON parser = new JSON(new StringReader(s));
        Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        // 获取操作类型
        String optType = BaseHelpUtils.getStringValue(params, "optType");
        switch (optType) {
            case SAVE_AREAL:
                return saveAreal(params);
        }

        return null;
    }

    /**
     * @param null
     * @return
     * @author liubin
     * @creed: write code
     * @date 2020-04-16 17:38
     * @describe:  保存区域数据
     */
    private String saveAreal(Map<String, Object> params) throws SQLException {
        List<Map> list = (List) params.get("lists");
        BaseCollection<GenericBase> bc = new BaseCollection<>();
        BaseArea baseArea = new BaseArea();
        Area area = new Area();
        baseArea.setDataFromMap(params);
        //校验数据是否有重复的
        area.clear();
        area.setConditionAllName("=", baseArea.getAllName());
        if (area.isExist()) {
            return bc.toJSON(-1, "该区域已经存在不能添加");
        }
        baseArea.setParentId(0);

        area.setDataFromBase(baseArea);
        area.save();
        Integer areaId = area.getAreaId();
        List<BaseArea> childAreal = GenericBase.__getList(list, BaseArea::new);
        for (BaseArea baseChildAreal : childAreal) {
            //校验子区域是否有重复的数据
            baseChildAreal.setParentId(areaId);
            area.clear();
            area.setConditionParentId("=", baseChildAreal.getParentId());
            area.setConditionAllName("=", baseChildAreal.getAllName());
            //存在则更新
            if (area.isExist()) {
                BaseArea baseChildAreal1 = area.executeQueryOneRow();
                area.setDataFromBase(baseChildAreal1);
                area.update();
            }
            area.setDataFromBase(baseChildAreal);
            area.save();
        }

        return bc.toJSON(1, "保存成功");
    }
}
