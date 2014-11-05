/*-
 * Copyright (c) 2014 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.tree.impl;

import java.io.Serializable;

import org.eclipse.dawnsci.analysis.api.tree.Attribute;
import org.eclipse.dawnsci.analysis.api.tree.Tree;
import org.eclipse.dawnsci.analysis.dataset.impl.Dataset;
import org.eclipse.dawnsci.analysis.dataset.impl.DatasetFactory;
import org.eclipse.dawnsci.analysis.dataset.impl.DatasetUtils;
import org.eclipse.dawnsci.analysis.dataset.impl.StringDataset;

public class AttributeImpl implements Attribute, Serializable {
	protected static final long serialVersionUID = -5046142834233727039L;

	private TreeImpl tree;
	private String node;
	private String name;
	private String type;
	private Dataset value;

	/**
	 * Create an attribute with node, name, value and sign
	 * @param tree
	 * @param nodeName
	 * @param attrName
	 * @param attrValue (usually, this is a Java array)
	 * @param isUnsigned true if items are unsigned but held in signed primitives
	 */
	public AttributeImpl(final Tree tree, final String nodeName, final String attrName, final Object attrValue, final boolean isUnsigned) {
		this.tree = tree instanceof TreeImpl ? (TreeImpl) tree : new TreeImpl(tree);
		node = nodeName;
		name = attrName;
		value = DatasetFactory.createFromObject(attrValue, isUnsigned);
	}

	public AttributeImpl(final Attribute attr) {
		Tree t = attr.getTree();
		tree = t instanceof TreeImpl ? (TreeImpl) t : new TreeImpl(t);
		node = attr.getNodeName();
		name = attr.getName();
		value = DatasetUtils.convertToDataset(attr.getValue());
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getFullName() {
		return node + NodeImpl.ATTRIBUTE + name;
	}

	@Override
	public boolean isString() {
		return value != null && (value instanceof StringDataset);
	}

	@Override
	public String getTypeName() {
		return type;
	}

	@Override
	public void setTypeName(String name) {
		type = name;
	}

	@Override
	public int getRank() {
		return value.getRank();
	}

	@Override
	public int[] getShape() {
		return value.getShape();
	}

	@Override
	public int getSize() {
		return value.getSize();
	}

	@Override
	public String getFirstElement() {
		return value.getString(0);
	}

	@Override
	public String toString() {
		// Fix to showing values in Value view - you cannot see the attribute
		// values so there would be no point of the view otherwise!
		if (value.getSize()==1 && value.getRank()==1) {
			return "["+value.getString(0)+"]";
		}
		return value.toString();
	}

	@Override
	public Dataset getValue() {
		return value;
	}

	@Override
	public void setValue(Object obj) {
		setValue(obj, false);
	}

	@Override
	public void setValue(Object obj, boolean isUnsigned) {
		value = DatasetFactory.createFromObject(obj, isUnsigned);
	}

	@Override
	public String getNodeName() {
		return node;
	}

	@Override
	public Tree getTree() {
		return tree;
	}
}
