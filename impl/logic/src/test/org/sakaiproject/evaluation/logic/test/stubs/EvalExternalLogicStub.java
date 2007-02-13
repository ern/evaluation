/******************************************************************************
 * EvalExternalLogicStub.java - created by aaronz@vt.edu on Dec 25, 2006
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

package org.sakaiproject.evaluation.logic.test.stubs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sakaiproject.evaluation.logic.EvalExternalLogic;
import org.sakaiproject.evaluation.logic.model.Context;
import org.sakaiproject.evaluation.model.constant.EvalConstants;
import org.sakaiproject.evaluation.test.EvalTestDataLoad;


/**
 * This is a stub class for testing purposes, it will allow us to test all the classes
 * that depend on it since it has way to many external dependencies to make it worth
 * it to mock them all up<br/>
 * <br/>
 * It is emulating the following system state:<br/>
 * 4 users: ADMIN_USER_ID (super admin), MAINT_USER_ID, USER_ID, STUDENT_USER_ID
 * 2 sites:<br/>
 * 1) CONTEXT1/SITE_ID (Site) -
 * USER_ID can take eval, MAINT_USER_ID can admin evals and be evaluated (cannot take)<br/>
 * 2) CONTEXT2/SITE2_ID (Group) -
 * USER_ID and STUDENT_USER_ID can take eval, MAINT_USER_ID can be evaluated but can not admin (cannot take)<br/>
 *
 * @author Aaron Zeckoski (aaronz@vt.edu)
 */
public class EvalExternalLogicStub implements EvalExternalLogic {

	/**
	 * Note: Admin has all perms in all sites
	 * 2 sites:<br/>
	 * 1) CONTEXT1/SITE_ID -
	 * USER_ID can take eval, MAINT_USER_ID can admin evals and be evaluated (cannot take)<br/>
	 * 2) CONTEXT2/SITE2_ID -
	 * USER_ID and STUDENT_USER_ID can take eval, MAINT_USER_ID can be evaluated but can not admin (cannot take)<br/>
	 */
	public int countContextsForUser(String userId, String permission) {
		if ( EvalTestDataLoad.ADMIN_USER_ID.equals(userId) ) {
			return 2;
		} else if ( EvalTestDataLoad.MAINT_USER_ID.equals(userId) ) {
			if ( EvalConstants.PERM_ASSIGN_EVALUATION.equals(permission) ) {
				return 1;
			} else if ( EvalConstants.PERM_BE_EVALUATED.equals(permission) ) {
				return 2;
			} else if ( EvalConstants.PERM_TAKE_EVALUATION.equals(permission) ) {
				return 0;				
			} else if ( EvalConstants.PERM_WRITE_TEMPLATE.equals(permission) ) {
				return 1;
			} else {
				return 0;				
			}
		} else if ( EvalTestDataLoad.USER_ID.equals(userId) ) {
			if ( EvalConstants.PERM_ASSIGN_EVALUATION.equals(permission) ) {
				return 0;
			} else if ( EvalConstants.PERM_BE_EVALUATED.equals(permission) ) {
				return 0;
			} else if ( EvalConstants.PERM_TAKE_EVALUATION.equals(permission) ) {
				return 2;
			} else if ( EvalConstants.PERM_WRITE_TEMPLATE.equals(permission) ) {
				return 0;
			} else {
				return 0;
			}
		} else if ( EvalTestDataLoad.STUDENT_USER_ID.equals(userId) ) {
			if ( EvalConstants.PERM_ASSIGN_EVALUATION.equals(permission) ) {
				return 0;
			} else if ( EvalConstants.PERM_BE_EVALUATED.equals(permission) ) {
				return 0;
			} else if ( EvalConstants.PERM_TAKE_EVALUATION.equals(permission) ) {
				return 1;
			} else if ( EvalConstants.PERM_WRITE_TEMPLATE.equals(permission) ) {
				return 0;
			} else {
				return 0;
			}
		} else {
			// do nothing
		}
		return 0;
	}

	/**
	 * Note: Admin has all perms in all sites
	 * 2 sites:<br/>
	 * 1) CONTEXT1/SITE_ID -
	 * USER_ID can take eval, MAINT_USER_ID can admin evals and be evaluated (cannot take)<br/>
	 * 2) CONTEXT2/SITE2_ID -
	 * USER_ID and STUDENT_USER_ID can take eval, MAINT_USER_ID can be evaluated but can not admin (cannot take)<br/>
	 */
	public List getContextsForUser(String userId, String permission) {
		List l = new ArrayList();
		if ( EvalTestDataLoad.ADMIN_USER_ID.equals(userId) ) {
			l.add( makeContextObject(EvalTestDataLoad.CONTEXT1) );
			l.add( makeContextObject(EvalTestDataLoad.CONTEXT2) );
		} else if ( EvalTestDataLoad.MAINT_USER_ID.equals(userId) ) {
			if ( EvalConstants.PERM_ASSIGN_EVALUATION.equals(permission) ) {
				l.add( makeContextObject(EvalTestDataLoad.CONTEXT1) );
			} else if ( EvalConstants.PERM_BE_EVALUATED.equals(permission) ) {
				l.add( makeContextObject(EvalTestDataLoad.CONTEXT1) );
				l.add( makeContextObject(EvalTestDataLoad.CONTEXT2) );
			} else if ( EvalConstants.PERM_TAKE_EVALUATION.equals(permission) ) {
				// nothing
			} else if ( EvalConstants.PERM_WRITE_TEMPLATE.equals(permission) ) {
				l.add( makeContextObject(EvalTestDataLoad.CONTEXT1) );
			} else {
				// nothing
			}
		} else if ( EvalTestDataLoad.USER_ID.equals(userId) ) {
			if ( EvalConstants.PERM_ASSIGN_EVALUATION.equals(permission) ) {
				// nothing
			} else if ( EvalConstants.PERM_BE_EVALUATED.equals(permission) ) {
				// nothing
			} else if ( EvalConstants.PERM_TAKE_EVALUATION.equals(permission) ) {
				l.add( makeContextObject(EvalTestDataLoad.CONTEXT1) );
				l.add( makeContextObject(EvalTestDataLoad.CONTEXT2) );
			} else if ( EvalConstants.PERM_WRITE_TEMPLATE.equals(permission) ) {
				// nothing
			} else {
				// nothing
			}
		} else if ( EvalTestDataLoad.STUDENT_USER_ID.equals(userId) ) {
			if ( EvalConstants.PERM_ASSIGN_EVALUATION.equals(permission) ) {
				// nothing
			} else if ( EvalConstants.PERM_BE_EVALUATED.equals(permission) ) {
				// nothing
			} else if ( EvalConstants.PERM_TAKE_EVALUATION.equals(permission) ) {
				l.add( makeContextObject(EvalTestDataLoad.CONTEXT2) );
			} else if ( EvalConstants.PERM_WRITE_TEMPLATE.equals(permission) ) {
				// nothing
			} else {
				// nothing
			}
		} else {
			// do nothing
		}
		return l;
	}

	/**
	 * Note: Admin has all perms in all sites
	 * 2 sites:<br/>
	 * 1) CONTEXT1/SITE_ID -
	 * USER_ID can take eval, MAINT_USER_ID can admin evals and be evaluated (cannot take)<br/>
	 * 2) CONTEXT2/SITE2_ID -
	 * USER_ID and STUDENT_USER_ID can take eval, MAINT_USER_ID can be evaluated but can not admin (cannot take)<br/>
	 */
	public Set getUserIdsForContext(String context, String permission) {
		Set s = new HashSet();
		// Maybe should add the admin user here? -AZ
		if ( EvalTestDataLoad.CONTEXT1.equals(context) ) {
			if ( EvalConstants.PERM_ASSIGN_EVALUATION.equals(permission) ) {
				s.add(EvalTestDataLoad.MAINT_USER_ID);
			} else if ( EvalConstants.PERM_BE_EVALUATED.equals(permission) ) {
				s.add(EvalTestDataLoad.MAINT_USER_ID);
			} else if ( EvalConstants.PERM_TAKE_EVALUATION.equals(permission) ) {
				s.add(EvalTestDataLoad.USER_ID);
			} else if ( EvalConstants.PERM_WRITE_TEMPLATE.equals(permission) ) {
				s.add(EvalTestDataLoad.MAINT_USER_ID);
			} else {
				// nothing
			}
		} else if ( EvalTestDataLoad.CONTEXT2.equals(context) ) {
			if ( EvalConstants.PERM_ASSIGN_EVALUATION.equals(permission) ) {
				// nothing
			} else if ( EvalConstants.PERM_BE_EVALUATED.equals(permission) ) {
				s.add(EvalTestDataLoad.MAINT_USER_ID);
			} else if ( EvalConstants.PERM_TAKE_EVALUATION.equals(permission) ) {
				s.add(EvalTestDataLoad.USER_ID);
				s.add(EvalTestDataLoad.STUDENT_USER_ID);
			} else if ( EvalConstants.PERM_WRITE_TEMPLATE.equals(permission) ) {
				// nothing
			} else {
				// nothing
			}
		} else {
			// do nothing
		}
		return s;
	}

	/**
	 * Note: Admin has all perms in all sites
	 * 2 sites:<br/>
	 * 1) CONTEXT1/SITE_ID -
	 * USER_ID can take eval, MAINT_USER_ID can admin evals and be evaluated (cannot take)<br/>
	 * 2) CONTEXT2/SITE2_ID -
	 * USER_ID and STUDENT_USER_ID can take eval, MAINT_USER_ID can be evaluated but can not admin (cannot take)<br/>
	 */
	public boolean isUserAllowedInContext(String userId, String permission, String context) {
		if ( EvalTestDataLoad.ADMIN_USER_ID.equals(userId) ) {
			return true;
		} else if ( EvalTestDataLoad.MAINT_USER_ID.equals(userId) ) {
			if ( EvalConstants.PERM_ASSIGN_EVALUATION.equals(permission) ) {
				if ( EvalTestDataLoad.CONTEXT1.equals(context) ) {
					return true;
				} else if ( EvalTestDataLoad.CONTEXT2.equals(context) ) {
					return false;					
				}
			} else if ( EvalConstants.PERM_BE_EVALUATED.equals(permission) ) {
				if ( EvalTestDataLoad.CONTEXT1.equals(context) ) {
					return true;
				} else if ( EvalTestDataLoad.CONTEXT2.equals(context) ) {
					return true;					
				}
			} else if ( EvalConstants.PERM_TAKE_EVALUATION.equals(permission) ) {
				if ( EvalTestDataLoad.CONTEXT1.equals(context) ) {
					return false;
				} else if ( EvalTestDataLoad.CONTEXT2.equals(context) ) {
					return false;					
				}
			} else if ( EvalConstants.PERM_WRITE_TEMPLATE.equals(permission) ) {
				if ( EvalTestDataLoad.CONTEXT1.equals(context) ) {
					return true;
				} else if ( EvalTestDataLoad.CONTEXT2.equals(context) ) {
					return false;					
				}
			}
		} else if ( EvalTestDataLoad.USER_ID.equals(userId) ) {
			if ( EvalConstants.PERM_ASSIGN_EVALUATION.equals(permission) ) {
				if ( EvalTestDataLoad.CONTEXT1.equals(context) ) {
					return false;
				} else if ( EvalTestDataLoad.CONTEXT2.equals(context) ) {
					return false;					
				}
			} else if ( EvalConstants.PERM_BE_EVALUATED.equals(permission) ) {
				if ( EvalTestDataLoad.CONTEXT1.equals(context) ) {
					return false;
				} else if ( EvalTestDataLoad.CONTEXT2.equals(context) ) {
					return false;					
				}
			} else if ( EvalConstants.PERM_TAKE_EVALUATION.equals(permission) ) {
				if ( EvalTestDataLoad.CONTEXT1.equals(context) ) {
					return true;
				} else if ( EvalTestDataLoad.CONTEXT2.equals(context) ) {
					return true;					
				}
			} else if ( EvalConstants.PERM_WRITE_TEMPLATE.equals(permission) ) {
				if ( EvalTestDataLoad.CONTEXT1.equals(context) ) {
					return false;
				} else if ( EvalTestDataLoad.CONTEXT2.equals(context) ) {
					return false;					
				}
			}
		} else if ( EvalTestDataLoad.STUDENT_USER_ID.equals(userId) ) {
			if ( EvalConstants.PERM_ASSIGN_EVALUATION.equals(permission) ) {
				if ( EvalTestDataLoad.CONTEXT1.equals(context) ) {
					return false;
				} else if ( EvalTestDataLoad.CONTEXT2.equals(context) ) {
					return false;					
				}
			} else if ( EvalConstants.PERM_BE_EVALUATED.equals(permission) ) {
				if ( EvalTestDataLoad.CONTEXT1.equals(context) ) {
					return false;
				} else if ( EvalTestDataLoad.CONTEXT2.equals(context) ) {
					return false;					
				}
			} else if ( EvalConstants.PERM_TAKE_EVALUATION.equals(permission) ) {
				if ( EvalTestDataLoad.CONTEXT1.equals(context) ) {
					return false;
				} else if ( EvalTestDataLoad.CONTEXT2.equals(context) ) {
					return true;					
				}
			} else if ( EvalConstants.PERM_WRITE_TEMPLATE.equals(permission) ) {
				if ( EvalTestDataLoad.CONTEXT1.equals(context) ) {
					return false;
				} else if ( EvalTestDataLoad.CONTEXT2.equals(context) ) {
					return false;					
				}
			}
		} else {
			// do nothing
		}
		return false;
	}

	/**
	 * Always assume the current context is CONTEXT1
	 */
	public String getCurrentContext() {
		return EvalTestDataLoad.CONTEXT1;
	}

	/**
	 * Always assume the current user is USER_ID
	 */
	public String getCurrentUserId() {
		return EvalTestDataLoad.USER_ID;
	}

	/**
	 * Return titles from the data load class
	 */
	public String getDisplayTitle(String context) {
		if ( EvalTestDataLoad.CONTEXT1.equals(context) ) {
			return EvalTestDataLoad.CONTEXT1_TITLE;
		} else if ( EvalTestDataLoad.CONTEXT2.equals(context) ) {
			return EvalTestDataLoad.CONTEXT2_TITLE;			
		}
		return "Unknown title";
	}

	/**
	 * Return names from the data load class
	 */
	public String getUserDisplayName(String userId) {
		if ( EvalTestDataLoad.ADMIN_USER_ID.equals(userId) ) {
			return EvalTestDataLoad.ADMIN_USER_DISPLAY;
		} else if ( EvalTestDataLoad.MAINT_USER_ID.equals(userId) ) {
			return EvalTestDataLoad.MAINT_USER_DISPLAY;			
		} else if ( EvalTestDataLoad.USER_ID.equals(userId) ) {
			return EvalTestDataLoad.USER_DISPLAY;			
		}
		return "Unknown name";
	}

	/**
	 * Return usernames from the data load class
	 */
	public String getUserUsername(String userId) {
		if ( EvalTestDataLoad.ADMIN_USER_ID.equals(userId) ) {
			return EvalTestDataLoad.ADMIN_USER_NAME;
		} else if ( EvalTestDataLoad.MAINT_USER_ID.equals(userId) ) {
			return EvalTestDataLoad.MAINT_USER_NAME;			
		} else if ( EvalTestDataLoad.USER_ID.equals(userId) ) {
			return EvalTestDataLoad.USER_NAME;			
		}
		return "Unknown username";
	}

	/**
	 * only true for ADMIN_USER_ID
	 */
	public boolean isUserAdmin(String userId) {
		if ( EvalTestDataLoad.ADMIN_USER_ID.equals(userId) ) {
			return true;
		}
		return false;
	}

	/**
	 * Return Context objects based on data from the data load class
	 * CONTEXT1 = Site, CONTEXT2 = Group
	 */
	public Context makeContextObject(String context) {
		Context c = new Context(context, null, EvalConstants.CONTEXT_TYPE_UNKNOWN);
		if ( EvalTestDataLoad.CONTEXT1.equals(context) ) {
			c.title = EvalTestDataLoad.CONTEXT1_TITLE;
			c.type = EvalConstants.CONTEXT_TYPE_SITE;
		} else if ( EvalTestDataLoad.CONTEXT2.equals(context) ) {
			c.title = EvalTestDataLoad.CONTEXT2_TITLE;			
			c.type = EvalConstants.CONTEXT_TYPE_GROUP;
		}
		return c;
	}

	/**
	 * check if the options entered were nulls
	 */
	public void sendEmails(String from, String[] to, String subject, String message) {
		if (from == null || to == null || subject == null || message == null) {
			throw new NullPointerException("All params are required (none can be null)");
		}
	}

}
