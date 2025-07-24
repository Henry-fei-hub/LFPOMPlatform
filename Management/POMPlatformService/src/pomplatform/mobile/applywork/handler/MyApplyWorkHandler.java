package pomplatform.mobile.applywork.handler;

import org.apache.log4j.Logger;
import pomplatform.mobile.applywork.bean.BaseMyApplyWork;
import pomplatform.mobile.applywork.bean.ConditionMyApplyWork;
import pomplatform.mobile.applywork.query.QueryMyApplyWork;
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

public class MyApplyWorkHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MyApplyWorkHandler.class);

	public static BaseCollection<BaseMyApplyWork> executeQueryMyApplyWork(ConditionMyApplyWork c, KeyValuePair[] replacements ) throws Exception {
		QueryMyApplyWork dao = new QueryMyApplyWork();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMyApplyWork> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMyApplyWork c = new ConditionMyApplyWork();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMyApplyWork> result = executeQueryMyApplyWork(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMyApplyWork> result;
		ConditionMyApplyWork c = new ConditionMyApplyWork();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMyApplyWork dao = new QueryMyApplyWork();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMyApplyWork.ALL_CAPTIONS);
			for(BaseMyApplyWork b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


