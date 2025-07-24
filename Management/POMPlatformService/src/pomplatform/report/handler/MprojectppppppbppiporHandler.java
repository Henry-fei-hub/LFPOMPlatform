package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseMprojectppppppbppipor;
import pomplatform.report.bean.ConditionMprojectppppppbppipor;
import pomplatform.report.query.QueryMprojectppppppbppipor;
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

public class MprojectppppppbppiporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MprojectppppppbppiporHandler.class);

	public static BaseCollection<BaseMprojectppppppbppipor> executeQueryMprojectppppppbppipor(ConditionMprojectppppppbppipor c, KeyValuePair[] replacements ) throws Exception {
		QueryMprojectppppppbppipor dao = new QueryMprojectppppppbppipor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMprojectppppppbppipor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMprojectppppppbppipor c = new ConditionMprojectppppppbppipor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMprojectppppppbppipor> result = executeQueryMprojectppppppbppipor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMprojectppppppbppipor> result;
		ConditionMprojectppppppbppipor c = new ConditionMprojectppppppbppipor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMprojectppppppbppipor dao = new QueryMprojectppppppbppipor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMprojectppppppbppipor.CAPTIONS);
			for(BaseMprojectppppppbppipor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}
	
	public final static java.lang.String CAPTIONS = "项目编号,项目名称,业务部门,项目类别,项目类型,业务类别,定价类型,订单合同金额,常规定价,项目总积分,差额,进度(%),运营补贴汇总,公司补贴汇总,项目补贴(部门),项目补贴(公司)";


}


