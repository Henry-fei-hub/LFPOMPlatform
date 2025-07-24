package pomplatform.project.query;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import delicacy.common.BaseTreeNode;
import delicacy.common.GenericProcessor;
import com.pomplatform.db.bean.BaseProjectQuoteTemplate;
import com.pomplatform.db.dao.ProjectQuoteTemplate;
import com.pomplatform.db.handler.ProjectQuoteTemplateHandler;

public class GenerateProjectQuoteTemplateTree implements GenericProcessor
{


	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		ProjectQuoteTemplate dao = new ProjectQuoteTemplate();
		BaseProjectQuoteTemplate bean = new BaseProjectQuoteTemplate();
		bean.setDataFromJSON(creteria);
		ProjectQuoteTemplateHandler.setConditions(bean, dao);
		List<BaseProjectQuoteTemplate> project_quote_templates = dao.conditionalLoad();
		List<BaseTreeNode> roots = generateRoot(project_quote_templates, bean.getProjectQuoteTemplateId() == null ? 0 : bean.getProjectQuoteTemplateId());
		for(BaseTreeNode n : roots){
			generateNode(n, project_quote_templates);
		}
		return BaseTreeNode.toJSON(roots);
	}

	private List<BaseTreeNode> generateRoot(List<BaseProjectQuoteTemplate> project_quote_templates, Integer parentId){
		List<BaseTreeNode> roots = new ArrayList<>();
		for(BaseProjectQuoteTemplate bd : project_quote_templates){
			if(Objects.equals(bd.getParentId(), parentId)){
				BaseTreeNode n = new BaseTreeNode();
				n.setId(bd.getProjectQuoteTemplateId());
				n.setTitle(bd.getDesignContent());
				n.setAttr(bd);
				roots.add(n);
			}
		}
		return roots;
	}

	private void generateNode(BaseTreeNode parent, List<BaseProjectQuoteTemplate> project_quote_templates){
		List<BaseTreeNode> children = new ArrayList<>();
		for(BaseProjectQuoteTemplate bd : project_quote_templates){
			if(Objects.equals(bd.getParentId(), parent.getId())){
				BaseTreeNode n = new BaseTreeNode();
				n.setId(bd.getProjectQuoteTemplateId());
				n.setTitle(bd.getDesignContent());
				n.setAttr(bd);
				children.add(n);
			}
		}
		if(!children.isEmpty()){
			parent.setChildren(children);
			for(BaseTreeNode n : children){
				generateNode(n, project_quote_templates);
			}
		}
	}

}
