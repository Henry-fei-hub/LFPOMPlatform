package pomplatform.SplateProjectOrDepartmentIntegralSumRecordpysor.handler;

import org.apache.log4j.Logger;
import pomplatform.SplateProjectOrDepartmentIntegralSumRecordpysor.bean.BaseSplateProjectOrDepartmentIntegralSumRecordpysor;
import pomplatform.SplateProjectOrDepartmentIntegralSumRecordpysor.bean.ConditionSplateProjectOrDepartmentIntegralSumRecordpysor;
import pomplatform.SplateProjectOrDepartmentIntegralSumRecordpysor.query.QuerySplateProjectOrDepartmentIntegralSumRecordpysor;
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

public class SplateProjectOrDepartmentIntegralSumRecordpysorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SplateProjectOrDepartmentIntegralSumRecordpysorHandler.class);

	public static BaseCollection<BaseSplateProjectOrDepartmentIntegralSumRecordpysor> executeQuerySplateProjectOrDepartmentIntegralSumRecordpysor(ConditionSplateProjectOrDepartmentIntegralSumRecordpysor c, KeyValuePair[] replacements ) throws Exception {
		QuerySplateProjectOrDepartmentIntegralSumRecordpysor dao = new QuerySplateProjectOrDepartmentIntegralSumRecordpysor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSplateProjectOrDepartmentIntegralSumRecordpysor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSplateProjectOrDepartmentIntegralSumRecordpysor c = new ConditionSplateProjectOrDepartmentIntegralSumRecordpysor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSplateProjectOrDepartmentIntegralSumRecordpysor> result = executeQuerySplateProjectOrDepartmentIntegralSumRecordpysor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSplateProjectOrDepartmentIntegralSumRecordpysor> result;
		ConditionSplateProjectOrDepartmentIntegralSumRecordpysor c = new ConditionSplateProjectOrDepartmentIntegralSumRecordpysor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySplateProjectOrDepartmentIntegralSumRecordpysor dao = new QuerySplateProjectOrDepartmentIntegralSumRecordpysor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSplateProjectOrDepartmentIntegralSumRecordpysor.ALL_CAPTIONS);
			for(BaseSplateProjectOrDepartmentIntegralSumRecordpysor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


