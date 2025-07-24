package pomplatform.specialDeduction.handler;

import org.apache.log4j.Logger;
import pomplatform.specialDeduction.bean.BaseMspecialdeductionrecordssyeseeshsppcor;
import pomplatform.specialDeduction.bean.ConditionMspecialdeductionrecordssyeseeshsppcor;
import pomplatform.specialDeduction.query.QueryMspecialdeductionrecordssyeseeshsppcor;
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

public class MspecialdeductionrecordssyeseeshsppcorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MspecialdeductionrecordssyeseeshsppcorHandler.class);

	public static BaseCollection<BaseMspecialdeductionrecordssyeseeshsppcor> executeQueryMspecialdeductionrecordssyeseeshsppcor(ConditionMspecialdeductionrecordssyeseeshsppcor c, KeyValuePair[] replacements ) throws Exception {
		QueryMspecialdeductionrecordssyeseeshsppcor dao = new QueryMspecialdeductionrecordssyeseeshsppcor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMspecialdeductionrecordssyeseeshsppcor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMspecialdeductionrecordssyeseeshsppcor c = new ConditionMspecialdeductionrecordssyeseeshsppcor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMspecialdeductionrecordssyeseeshsppcor> result = executeQueryMspecialdeductionrecordssyeseeshsppcor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMspecialdeductionrecordssyeseeshsppcor> result;
		ConditionMspecialdeductionrecordssyeseeshsppcor c = new ConditionMspecialdeductionrecordssyeseeshsppcor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMspecialdeductionrecordssyeseeshsppcor dao = new QueryMspecialdeductionrecordssyeseeshsppcor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMspecialdeductionrecordssyeseeshsppcor.ALL_CAPTIONS);
			for(BaseMspecialdeductionrecordssyeseeshsppcor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


