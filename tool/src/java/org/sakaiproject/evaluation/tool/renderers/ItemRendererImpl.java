/******************************************************************************
 * ItemRendererImpl.java - created by aaronz@vt.edu
 * 
 * Copyright (c) 2007 Virginia Polytechnic Institute and State University
 * Licensed under the Educational Community License version 1.0
 * 
 * A copy of the Educational Community License has been included in this 
 * distribution and is available at: http://www.opensource.org/licenses/ecl1.php
 * 
 * Contributors:
 * Aaron Zeckoski (aaronz@vt.edu) - primary
 * 
 *****************************************************************************/

package org.sakaiproject.evaluation.tool.renderers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.sakaiproject.evaluation.model.EvalTemplateItem;
import org.sakaiproject.evaluation.tool.utils.TemplateItemUtils;

import uk.org.ponder.rsf.components.UIContainer;
import uk.org.ponder.rsf.components.UIJointContainer;

/**
 * The main implementation for the ItemRenderer class which allows the presentation programmers
 * to simply inject and use a single class for all rendering of items
 * 
 * @author Aaron Zeckoski (aaronz@vt.edu)
 */
public class ItemRendererImpl implements ItemRenderer {

	private Map renderImpls = new HashMap();
	public void setRenderTypes(List types) {
		for (Iterator iter = types.iterator(); iter.hasNext();) {
			ItemRenderer ir = (ItemRenderer) iter.next();
			renderImpls.put(ir.getRenderType(), ir);
		}
	}

	public void init() {
		// just check that the renderImpls are inited
		if (renderImpls == null) {
			throw new IllegalStateException("The renderTypes must be set before this class can be used");
		}
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.evaluation.tool.renderers.ItemRenderer#renderItem(uk.org.ponder.rsf.components.UIContainer, java.lang.String, org.sakaiproject.evaluation.model.EvalTemplateItem, int, boolean)
	 */
	public UIJointContainer renderItem(UIContainer parent, String ID, String binding, EvalTemplateItem templateItem, int displayNumber, boolean disabled) {
		// figure out the type of item and then call the appropriate renderer
		String itemTypeConstant = TemplateItemUtils.getTemplateItemType(templateItem);
		ItemRenderer renderer = (ItemRenderer) renderImpls.get( itemTypeConstant );
		return renderer.renderItem(parent, ID, binding, templateItem, displayNumber, disabled);
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.evaluation.tool.renderers.ItemRenderer#getRenderType()
	 */
	public String getRenderType() {
		// this handles no specific type so return null
		return null;
	}

}
