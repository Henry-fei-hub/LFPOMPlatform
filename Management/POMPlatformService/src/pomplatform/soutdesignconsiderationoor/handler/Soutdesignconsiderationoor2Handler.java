package pomplatform.soutdesignconsiderationoor.handler;

import org.apache.log4j.Logger;
import pomplatform.soutdesignconsiderationoor.bean.BaseSoutdesignconsiderationoor2;
import pomplatform.soutdesignconsiderationoor.bean.ConditionSoutdesignconsiderationoor2;
import pomplatform.soutdesignconsiderationoor.query.QuerySoutdesignconsiderationoor2;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BaseMainProjectBusinessType;
import com.pomplatform.db.bean.BaseOutDesignConsideration;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.MainProjectBusinessType;
import com.pomplatform.db.dao.OutDesignConsideration;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;

public class Soutdesignconsiderationoor2Handler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(Soutdesignconsiderationoor2Handler.class);

	public static BaseCollection<BaseSoutdesignconsiderationoor2> executeQuerySoutdesignconsiderationoor2(ConditionSoutdesignconsiderationoor2 c, KeyValuePair[] replacements ) throws Exception {
		QuerySoutdesignconsiderationoor2 dao = new QuerySoutdesignconsiderationoor2();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSoutdesignconsiderationoor2> result = dao.execute( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			OutDesignConsideration daoOutDesignConsideration = new OutDesignConsideration();
			for(BaseSoutdesignconsiderationoor2 bean : result.getCollections()){
				daoOutDesignConsideration.setConditionOutQuotationId("=", bean.getOutQuotationId());
				bean.setDetailOutDesignConsideration(daoOutDesignConsideration.conditionalLoad(null));
			}
		}
		if(!BaseHelpUtils.isNullOrEmpty(result)&&result.getCollections().size()>0) {
			List<BaseSoutdesignconsiderationoor2> collections = result.getCollections();
			BaseSoutdesignconsiderationoor2 base = collections.get(0);
			//报价单产值数据
			BigDecimal  outAggregateAmount = BigDecimal.ZERO;
			MainProject mpDao = new MainProject();
			mpDao.setConditionProjectCode("=",base.getProjectCode());
			mpDao.setConditionInfoCode("=",  base.getInfoCode());
			BaseMainProject bean = mpDao.executeQueryOneRow();
			if(!BaseHelpUtils.isNullOrEmpty(bean)) {
				Integer mainProjectId = bean.getMainProjectId();	
				MainProjectBusinessType mDao = new MainProjectBusinessType();
				mDao.setConditionMainProjectId("=", mainProjectId);
				mDao.setConditionOutQuotationId("=", BaseHelpUtils.getIntValue(c.getOutQuotationId()));
				List<BaseMainProjectBusinessType> list = mDao.conditionalLoad();
				if(list.size()>0) {
					for (BaseMainProjectBusinessType baseMainProjectBusinessType : list) {
						outAggregateAmount = outAggregateAmount.add(BaseHelpUtils.getBigDecimalValue(baseMainProjectBusinessType.getOutputValue()));
					}
				}else {
					mDao.setConditionOutQuotationId("=", 0);
					List<BaseMainProjectBusinessType> list2 = mDao.conditionalLoad();
					if(list2.size()>0) {
						for (BaseMainProjectBusinessType baseMainProjectBusinessType : list2) {
							outAggregateAmount = outAggregateAmount.add(BaseHelpUtils.getBigDecimalValue(baseMainProjectBusinessType.getOutputValue()));
						}
					}
				}
			}
			base.setInteriorMoneySum(outAggregateAmount);
			collections.clear();
			collections.add(base);
			result.setCollections(collections);
		}
		
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSoutdesignconsiderationoor2 c = new ConditionSoutdesignconsiderationoor2();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSoutdesignconsiderationoor2> result = executeQuerySoutdesignconsiderationoor2(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSoutdesignconsiderationoor2> result;
		ConditionSoutdesignconsiderationoor2 c = new ConditionSoutdesignconsiderationoor2();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySoutdesignconsiderationoor2 dao = new QuerySoutdesignconsiderationoor2();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSoutdesignconsiderationoor2.ALL_CAPTIONS);
			for(BaseSoutdesignconsiderationoor2 b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


