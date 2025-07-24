package pomplatform.budgetmanagement.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseCapital;
import com.pomplatform.db.bean.BaseCapitalDistribution;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.CustomBaseCapitalDistribution;
import com.pomplatform.db.dao.BudgetAttachment;
import com.pomplatform.db.dao.Capital;
import com.pomplatform.db.dao.CapitalDistribution;
import com.pomplatform.db.dao.CapitalLog;
import com.pomplatform.db.dao.PaymentSequence;
import com.pomplatform.db.dao.Project;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.capitaldistribution.bean.BaseAutoFitInfo;
import pomplatform.capitaldistribution.bean.BaseGetProjectInfoAndLeftAmount;
import pomplatform.capitaldistribution.bean.BaseGetProjectSureAndLeftInteger;
import pomplatform.capitaldistribution.bean.BaseLeftCapitalAmount;
import pomplatform.capitaldistribution.bean.BaseSearchProjectCapitalDistribution;
import pomplatform.capitaldistribution.bean.BaseSumCapitalBorrowMoney;
import pomplatform.capitaldistribution.bean.BaseSumCapitalDistribution;
import pomplatform.capitaldistribution.bean.BaseSumDepartmentCapitalDistribution;
import pomplatform.capitaldistribution.bean.ConditionAutoFitInfo;
import pomplatform.capitaldistribution.bean.ConditionGetProjectInfoAndLeftAmount;
import pomplatform.capitaldistribution.bean.ConditionGetProjectSureAndLeftInteger;
import pomplatform.capitaldistribution.bean.ConditionLeftCapitalAmount;
import pomplatform.capitaldistribution.bean.ConditionSearchProjectCapitalDistribution;
import pomplatform.capitaldistribution.bean.ConditionSumCapitalBorrowMoney;
import pomplatform.capitaldistribution.bean.ConditionSumCapitalDistribution;
import pomplatform.capitaldistribution.bean.ConditionSumDepartmentCapitalDistribution;
import pomplatform.capitaldistribution.query.QueryAutoFitInfo;
import pomplatform.capitaldistribution.query.QueryGetProjectInfoAndLeftAmount;
import pomplatform.capitaldistribution.query.QueryGetProjectSureAndLeftInteger;
import pomplatform.capitaldistribution.query.QueryLeftCapitalAmount;
import pomplatform.capitaldistribution.query.QuerySearchProjectCapitalDistribution;
import pomplatform.capitaldistribution.query.QuerySumCapitalBorrowMoney;
import pomplatform.capitaldistribution.query.QuerySumCapitalDistribution;
import pomplatform.capitaldistribution.query.QuerySumDepartmentCapitalDistribution;
import pomplatform.common.utils.StaticUtils;
import pomplatform.filemanage.business.FileManageProcessor;

public class BudgetProcessor implements GenericProcessor {
	// 操作类型
	private static final String OPT_TYPE = "optType";

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		// 获取操作类型
		String optType = BaseHelpUtils.getStringValue(params, OPT_TYPE);
		switch (optType) {
		case "deleteBudgetAttachment":
			return deleteBudgetAttachment(params);
		default:
			return null;
		}
	}

	public String deleteBudgetAttachment(Map<String, Object> params) throws Exception {
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		int budgetAttachmentId = BaseHelpUtils.getIntValue(params.get("budgetAttachmentId"));
		BudgetAttachment baDao = new BudgetAttachment();
		baDao.setBudgetAttachmentId(budgetAttachmentId);
		if(!baDao.load()) {
			return bc.toJSON(-1, "预算附件不存在");
		}
		ThreadConnection.beginTransaction();
		//附件引用次数减一
		if(null != baDao.getFileId()) {
			FileManageProcessor.subtractTimesById(baDao.getFileId());
		}
		//删除该附件所关联的付款序列
		PaymentSequence psDao = new PaymentSequence();
		psDao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
		psDao.conditionalDelete();
		baDao.delete();
		ThreadConnection.commit();
		return bc.toJSON();
	}
}
