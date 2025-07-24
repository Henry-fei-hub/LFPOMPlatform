package pomplatform.groupOutdesignconsiderationior.handler;

import org.apache.log4j.Logger;
import pomplatform.groupOutdesignconsiderationior.bean.BaseGroupOutdesignconsiderationior;
import pomplatform.groupOutdesignconsiderationior.bean.ConditionGroupOutdesignconsiderationior;
import pomplatform.groupOutdesignconsiderationior.query.QueryGroupOutdesignconsiderationior;
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

public class GroupOutdesignconsiderationiorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GroupOutdesignconsiderationiorHandler.class);

	public static BaseCollection<BaseGroupOutdesignconsiderationior> executeQueryGroupOutdesignconsiderationior(ConditionGroupOutdesignconsiderationior c, KeyValuePair[] replacements ) throws Exception {
		QueryGroupOutdesignconsiderationior dao = new QueryGroupOutdesignconsiderationior();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGroupOutdesignconsiderationior> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGroupOutdesignconsiderationior c = new ConditionGroupOutdesignconsiderationior();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGroupOutdesignconsiderationior> result = executeQueryGroupOutdesignconsiderationior(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGroupOutdesignconsiderationior> result;
		ConditionGroupOutdesignconsiderationior c = new ConditionGroupOutdesignconsiderationior();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGroupOutdesignconsiderationior dao = new QueryGroupOutdesignconsiderationior();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGroupOutdesignconsiderationior.ALL_CAPTIONS);
			for(BaseGroupOutdesignconsiderationior b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


