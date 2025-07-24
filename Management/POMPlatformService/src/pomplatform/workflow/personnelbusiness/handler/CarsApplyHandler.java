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
import pomplatform.workflow.personnelbusiness.bean.BaseCarsApply;
import pomplatform.workflow.personnelbusiness.bean.BaseGoodsApply;
import pomplatform.workflow.personnelbusiness.bean.ConditionCarsApply;
import pomplatform.workflow.personnelbusiness.query.QueryCarsApply;

public class CarsApplyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CarsApplyHandler.class);

	public static BaseCollection<BaseCarsApply> executeQueryCarsApply(ConditionCarsApply c, KeyValuePair[] replacements ) throws Exception {
		QueryCarsApply dao = new QueryCarsApply();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCarsApply> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCarsApply c = new ConditionCarsApply();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCarsApply> result = executeQueryCarsApply(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCarsApply> result;
		ConditionCarsApply c = new ConditionCarsApply();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCarsApply dao = new QueryCarsApply();
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
			for(BaseCarsApply b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


