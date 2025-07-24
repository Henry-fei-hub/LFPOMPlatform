package pomplatform.IntegralReturnOfPlate.handler;

import org.apache.log4j.Logger;
import pomplatform.IntegralReturnOfPlate.bean.BaseIntegralReturnOfPlate;
import pomplatform.IntegralReturnOfPlate.bean.ConditionIntegralReturnOfPlate;
import pomplatform.IntegralReturnOfPlate.query.QueryIntegralReturnOfPlate;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class IntegralReturnOfPlateHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(IntegralReturnOfPlateHandler.class);

	public static BaseCollection<BaseIntegralReturnOfPlate> executeQueryIntegralReturnOfPlate(ConditionIntegralReturnOfPlate c, KeyValuePair[] replacements ) throws Exception {
		QueryIntegralReturnOfPlate dao = new QueryIntegralReturnOfPlate();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseIntegralReturnOfPlate> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionIntegralReturnOfPlate c = new ConditionIntegralReturnOfPlate();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseIntegralReturnOfPlate> result = executeQueryIntegralReturnOfPlate(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseIntegralReturnOfPlate> result;
		ConditionIntegralReturnOfPlate c = new ConditionIntegralReturnOfPlate();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryIntegralReturnOfPlate dao = new QueryIntegralReturnOfPlate();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseIntegralReturnOfPlate.ALL_CAPTIONS);
			for(BaseIntegralReturnOfPlate b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


