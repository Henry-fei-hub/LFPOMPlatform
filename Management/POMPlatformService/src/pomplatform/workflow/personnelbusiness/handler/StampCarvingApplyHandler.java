package pomplatform.workflow.personnelbusiness.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.workflow.personnelbusiness.bean.BaseStampCarvingApply;
import pomplatform.workflow.personnelbusiness.bean.BaseGoodsApply;
import pomplatform.workflow.personnelbusiness.bean.ConditionCarsApply;
import pomplatform.workflow.personnelbusiness.bean.ConditionStampCarvingApply;
import pomplatform.workflow.personnelbusiness.query.QueryStampCarvingApply;

public class StampCarvingApplyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(StampCarvingApplyHandler.class);

	public static BaseCollection<BaseStampCarvingApply> executeQueryStampCarvingApply(ConditionStampCarvingApply c, KeyValuePair[] replacements ) throws Exception {
		QueryStampCarvingApply dao = new QueryStampCarvingApply();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseStampCarvingApply> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionStampCarvingApply c = new ConditionStampCarvingApply();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseStampCarvingApply> result = executeQueryStampCarvingApply(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseStampCarvingApply> result;
		ConditionCarsApply c = new ConditionCarsApply();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryStampCarvingApply dao = new QueryStampCarvingApply();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGoodsApply.ALL_CAPTIONS);
			for(BaseStampCarvingApply b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


