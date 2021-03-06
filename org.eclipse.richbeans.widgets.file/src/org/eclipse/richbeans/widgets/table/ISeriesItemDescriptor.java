/*
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.richbeans.widgets.table;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.fieldassist.IContentProposalProvider;

/**
 * An interface for providing fitting functions by providing the name and
 * the function itself when required
 *
 */
public interface ISeriesItemDescriptor extends IAdaptable {


	/**
	 * Instantiate the function/operation/operator (if it is null)
	 * and return it. Otherwise return the current version.
	 * 
	 * @return the function
	 * @throws InstantiationException
	 */
	Object getSeriesObject() throws Exception;

	/**
	 * Provides the function name
	 * @return String name
	 */
	String getName();

    /**
     * The label shown when choosing the item, might also include category
     * @return
     */
	String getLabel();

	/**
	 * Provides the description of the function
	 *
	 * @return String description of the function
	 */
	String getDescription();
	
	/**
	 * Determines whether this item can be used to filter
	 * options for later items in the series
	 * 
	 * @return filterable
	 */
	boolean isFilterable();

	/**
	 * Function Descriptors can choose to adapt to:
	 * <ul>
	 * <li> {@link IContentProposalProvider} - if the function descriptor is
	 * going to contribute to auto-completion suggestions.
	 * </ul>
	 *
	 * @param clazz
	 * @return
	 */
	@Override
	<T> T getAdapter(Class<T> clazz);
	
	public class Stub implements ISeriesItemDescriptor {

		@Override
		public Object getSeriesObject() throws InstantiationException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getAdapter(Class clazz) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getLabel() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isFilterable() {
			// TODO Auto-generated method stub
			return true;
		}
		
	}
	
	
	ISeriesItemDescriptor NEW = new Stub() {

		@Override
		public String getName() {
			return "New...";
		}

		@Override
		public String getDescription() {
			return "Add a choosable item to the list of items.";
		}		
	};
	
	ISeriesItemDescriptor INSERT = new Stub() {
		@Override
		public String getName() {
			return "Insert...";
		}

		@Override
		public String getDescription() {
			return "Insert a choosable item to the list of items.";
		}		
		
	};

}
