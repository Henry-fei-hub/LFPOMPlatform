package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BaseGetProcessComment;
import pomplatform.workflow.personnelbusiness.bean.ConditionGetProcessComment;
import pomplatform.workflow.personnelbusiness.query.QueryGetProcessComment;
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

public class GetProcessCommentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetProcessCommentHandler.class);

	public static BaseCollection<BaseGetProcessComment> executeQueryGetProcessComment(ConditionGetProcessComment c, KeyValuePair[] replacements ) throws Exception {
		QueryGetProcessComment dao = new QueryGetProcessComment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetProcessComment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetProcessComment c = new ConditionGetProcessComment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetProcessComment> result = executeQueryGetProcessComment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetProcessComment> result;
		ConditionGetProcessComment c = new ConditionGetProcessComment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetProcessComment dao = new QueryGetProcessComment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetProcessComment.ALL_CAPTIONS);
			for(BaseGetProcessComment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


