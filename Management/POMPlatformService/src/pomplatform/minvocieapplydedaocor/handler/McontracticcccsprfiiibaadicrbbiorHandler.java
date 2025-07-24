package pomplatform.minvocieapplydedaocor.handler;

import org.apache.log4j.Logger;
import pomplatform.minvocieapplydedaocor.bean.BaseMcontracticcccsprfiiibaadicrbbior;
import pomplatform.minvocieapplydedaocor.bean.ConditionMcontracticcccsprfiiibaadicrbbior;
import pomplatform.minvocieapplydedaocor.query.QueryMcontracticcccsprfiiibaadicrbbior;
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

public class McontracticcccsprfiiibaadicrbbiorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(McontracticcccsprfiiibaadicrbbiorHandler.class);

	public static BaseCollection<BaseMcontracticcccsprfiiibaadicrbbior> executeQueryMcontracticcccsprfiiibaadicrbbior(ConditionMcontracticcccsprfiiibaadicrbbior c, KeyValuePair[] replacements ) throws Exception {
		QueryMcontracticcccsprfiiibaadicrbbior dao = new QueryMcontracticcccsprfiiibaadicrbbior();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMcontracticcccsprfiiibaadicrbbior> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMcontracticcccsprfiiibaadicrbbior c = new ConditionMcontracticcccsprfiiibaadicrbbior();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMcontracticcccsprfiiibaadicrbbior> result = executeQueryMcontracticcccsprfiiibaadicrbbior(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMcontracticcccsprfiiibaadicrbbior> result;
		ConditionMcontracticcccsprfiiibaadicrbbior c = new ConditionMcontracticcccsprfiiibaadicrbbior();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMcontracticcccsprfiiibaadicrbbior dao = new QueryMcontracticcccsprfiiibaadicrbbior();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMcontracticcccsprfiiibaadicrbbior.ALL_CAPTIONS);
			for(BaseMcontracticcccsprfiiibaadicrbbior b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


