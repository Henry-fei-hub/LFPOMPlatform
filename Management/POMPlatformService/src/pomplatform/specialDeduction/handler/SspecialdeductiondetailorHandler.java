package pomplatform.specialDeduction.handler;

import org.apache.log4j.Logger;
import pomplatform.specialDeduction.bean.BaseSspecialdeductiondetailor;
import pomplatform.specialDeduction.bean.ConditionSspecialdeductiondetailor;
import pomplatform.specialDeduction.query.QuerySspecialdeductiondetailor;
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

public class SspecialdeductiondetailorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SspecialdeductiondetailorHandler.class);

	public static BaseCollection<BaseSspecialdeductiondetailor> executeQuerySspecialdeductiondetailor(ConditionSspecialdeductiondetailor c, KeyValuePair[] replacements ) throws Exception {
		QuerySspecialdeductiondetailor dao = new QuerySspecialdeductiondetailor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSspecialdeductiondetailor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSspecialdeductiondetailor c = new ConditionSspecialdeductiondetailor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSspecialdeductiondetailor> result = executeQuerySspecialdeductiondetailor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSspecialdeductiondetailor> result;
		ConditionSspecialdeductiondetailor c = new ConditionSspecialdeductiondetailor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySspecialdeductiondetailor dao = new QuerySspecialdeductiondetailor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSspecialdeductiondetailor.ALL_CAPTIONS);
			for(BaseSspecialdeductiondetailor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


