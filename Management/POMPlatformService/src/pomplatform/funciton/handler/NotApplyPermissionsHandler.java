package pomplatform.funciton.handler;

import org.apache.log4j.Logger;
import pomplatform.funciton.bean.BaseNotApplyPermissions;
import pomplatform.funciton.bean.ConditionNotApplyPermissions;
import pomplatform.funciton.query.QueryNotApplyPermissions;
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

public class NotApplyPermissionsHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(NotApplyPermissionsHandler.class);

	public static BaseCollection<BaseNotApplyPermissions> executeQueryNotApplyPermissions(ConditionNotApplyPermissions c, KeyValuePair[] replacements ) throws Exception {
		QueryNotApplyPermissions dao = new QueryNotApplyPermissions();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseNotApplyPermissions> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionNotApplyPermissions c = new ConditionNotApplyPermissions();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseNotApplyPermissions> result = executeQueryNotApplyPermissions(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseNotApplyPermissions> result;
		ConditionNotApplyPermissions c = new ConditionNotApplyPermissions();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryNotApplyPermissions dao = new QueryNotApplyPermissions();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseNotApplyPermissions.ALL_CAPTIONS);
			for(BaseNotApplyPermissions b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


