package pomplatform.specialDeduction.handler;

import org.apache.log4j.Logger;
import pomplatform.specialDeduction.bean.BaseSspecialdeductiontypessor;
import pomplatform.specialDeduction.bean.ConditionSspecialdeductiontypessor;
import pomplatform.specialDeduction.query.QuerySspecialdeductiontypessor;
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

public class SspecialdeductiontypessorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SspecialdeductiontypessorHandler.class);

	public static BaseCollection<BaseSspecialdeductiontypessor> executeQuerySspecialdeductiontypessor(ConditionSspecialdeductiontypessor c, KeyValuePair[] replacements ) throws Exception {
		QuerySspecialdeductiontypessor dao = new QuerySspecialdeductiontypessor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSspecialdeductiontypessor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSspecialdeductiontypessor c = new ConditionSspecialdeductiontypessor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSspecialdeductiontypessor> result = executeQuerySspecialdeductiontypessor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSspecialdeductiontypessor> result;
		ConditionSspecialdeductiontypessor c = new ConditionSspecialdeductiontypessor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySspecialdeductiontypessor dao = new QuerySspecialdeductiontypessor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSspecialdeductiontypessor.ALL_CAPTIONS);
			for(BaseSspecialdeductiontypessor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


