package pomplatform.receiveunit.handler;

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
import pomplatform.receiveunit.bean.BaseMreceiveunitmanagepsrbbor;
import pomplatform.receiveunit.bean.ConditionMreceiveunitmanagepsrbbor;
import pomplatform.receiveunit.query.QueryMreceiveunitmanagepsrbbor;

public class MreceiveunitmanagepsrbborHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MreceiveunitmanagepsrbborHandler.class);

	public static BaseCollection<BaseMreceiveunitmanagepsrbbor> executeQueryMreceiveunitmanagepsrbbor(ConditionMreceiveunitmanagepsrbbor c, KeyValuePair[] replacements ) throws Exception {
		QueryMreceiveunitmanagepsrbbor dao = new QueryMreceiveunitmanagepsrbbor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMreceiveunitmanagepsrbbor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMreceiveunitmanagepsrbbor c = new ConditionMreceiveunitmanagepsrbbor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMreceiveunitmanagepsrbbor> result = executeQueryMreceiveunitmanagepsrbbor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMreceiveunitmanagepsrbbor> result;
		ConditionMreceiveunitmanagepsrbbor c = new ConditionMreceiveunitmanagepsrbbor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMreceiveunitmanagepsrbbor dao = new QueryMreceiveunitmanagepsrbbor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMreceiveunitmanagepsrbbor.ALL_CAPTIONS);
			for(BaseMreceiveunitmanagepsrbbor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


