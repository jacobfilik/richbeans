/*-
 *******************************************************************************
 * Copyright (c) 2011, 2014 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthew Gerring - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.richbeans.api.widget;

/**
 * An interface to give access to field values.
 */
public interface IFieldProvider {

	/**
	 * Returns the widget used for this field
	 * @param fieldName
	 * @return IFieldWidget
	 */
	public IFieldWidget getField(final String fieldName) throws Exception;
	
	/**
	 * Returns the value of a field in this provider.
	 * @return value
	 */
	public Object getFieldValue(final String fieldName) throws Exception;
}
