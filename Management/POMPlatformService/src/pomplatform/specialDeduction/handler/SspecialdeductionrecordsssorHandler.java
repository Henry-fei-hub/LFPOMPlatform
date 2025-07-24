package pomplatform.specialDeduction.handler;

import org.apache.log4j.Logger;
import pomplatform.specialDeduction.bean.BaseSspecialdeductionrecordsssor;
import pomplatform.specialDeduction.bean.ConditionSspecialdeductionrecordsssor;
import pomplatform.specialDeduction.query.QuerySspecialdeductionrecordsssor;
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

public class SspecialdeductionrecordsssorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SspecialdeductionrecordsssorHandler.class);

	public static BaseCollection<BaseSspecialdeductionrecordsssor> executeQuerySspecialdeductionrecordsssor(ConditionSspecialdeductionrecordsssor c, KeyValuePair[] replacements ) throws Exception {
		QuerySspecialdeductionrecordsssor dao = new QuerySspecialdeductionrecordsssor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSspecialdeductionrecordsssor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSspecialdeductionrecordsssor c = new ConditionSspecialdeductionrecordsssor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSspecialdeductionrecordsssor> result = executeQuerySspecialdeductionrecordsssor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSspecialdeductionrecordsssor> result;
		ConditionSspecialdeductionrecordsssor c = new ConditionSspecialdeductionrecordsssor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySspecialdeductionrecordsssor dao = new QuerySspecialdeductionrecordsssor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSspecialdeductionrecordsssor.ALL_CAPTIONS);
			for(BaseSspecialdeductionrecordsssor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


