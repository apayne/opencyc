/* $Id$
 *
 * Copyright (c) 2004 - 2006 Cycorp, Inc.  All rights reserved.
 * This software is the proprietary information of Cycorp, Inc.
 * Use is subject to license terms.
 */

package org.opencyc.inference;

//// Internal Imports
import org.opencyc.cycobject.*;

//// External Imports

/**
 * <P>InferenceParameter is designed to...
 *
 * <P>Copyright (c) 2004 - 2006 Cycorp, Inc.  All rights reserved.
 * <BR>This software is the proprietary information of Cycorp, Inc.
 * <P>Use is subject to license terms.
 *
 * @author tbrussea
 * @date August 2, 2005, 10:25 AM
 * @version $Id$
 */
public interface InferenceParameter {
  CycFort getId();
  CycSymbol getKeyword();
  String getShortDescription();
  String getLongDescription();
  InferenceParameterValueDescription getAlternateValue();
  boolean isValidValue(Object potentialValue);
  boolean isBasicParameter();
  boolean isQueryStaticParameter();
  Object getDefaultValue();
}
