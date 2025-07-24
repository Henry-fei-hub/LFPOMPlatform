package pomplatform.minvocieapplydedaocor.handler;

import org.apache.log4j.Logger;
import pomplatform.minvocieapplydedaocor.bean.BaseMinvocieapplydedaocor;
import pomplatform.minvocieapplydedaocor.bean.ConditionMinvocieapplydedaocor;
import pomplatform.minvocieapplydedaocor.query.QueryMinvocieapplydedaocor;
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

public class MinvocieapplydedaocorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MinvocieapplydedaocorHandler.class);

	public static BaseCollection<BaseMinvocieapplydedaocor> executeQueryMinvocieapplydedaocor(ConditionMinvocieapplydedaocor c, KeyValuePair[] replacements ) throws Exception {
		QueryMinvocieapplydedaocor dao = new QueryMinvocieapplydedaocor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMinvocieapplydedaocor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMinvocieapplydedaocor c = new ConditionMinvocieapplydedaocor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMinvocieapplydedaocor> result = executeQueryMinvocieapplydedaocor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMinvocieapplydedaocor> result;
		ConditionMinvocieapplydedaocor c = new ConditionMinvocieapplydedaocor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMinvocieapplydedaocor dao = new QueryMinvocieapplydedaocor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMinvocieapplydedaocor.ALL_CAPTIONS);
			for(BaseMinvocieapplydedaocor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


