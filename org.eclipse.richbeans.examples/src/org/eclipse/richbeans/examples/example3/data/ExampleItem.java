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

package org.eclipse.richbeans.examples.example3.data;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ExampleItem {
	
	public enum ItemChoice {
		XY, POLAR;

		public static Map<String, ItemChoice> names() {
			final Map<String,ItemChoice> ret = new HashMap<String,ItemChoice>(2);
			ret.put("X-Y Graph", XY);
			ret.put("Polar",     POLAR);
			return ret;
		}
	}

	private String     itemName;
	private ItemChoice choice = ItemChoice.XY;
	private Double x,y;
	private double r,theta;
	
    public ExampleItem() {
    	this(null, 1,1);
    }
    
	public ExampleItem(String itemName, double i, double j) {
		this.itemName = itemName;
		x = i; y = j;
	}
	
	public ExampleItem(String itemName, double i, double j, ItemChoice choice) {
		this.itemName = itemName;
		this.choice = choice;
		if (choice == ItemChoice.POLAR) {
			r = i; theta = j;
		} else {
			x = i; y = j;
		}
	}

	public ItemChoice getChoice() {
		return choice;
	}

	public void setChoice(ItemChoice choice) {
		this.choice = choice;
	}
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String name) {
		this.itemName = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((choice == null) ? 0 : choice.hashCode());
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(r);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(theta);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExampleItem other = (ExampleItem) obj;
		if (choice != other.choice)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (Double.doubleToLongBits(r) != Double.doubleToLongBits(other.r))
			return false;
		if (Double.doubleToLongBits(theta) != Double
				.doubleToLongBits(other.theta))
			return false;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}

	/**
	 * @return the x
	 */
	public Double getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(Double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public Double getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(Double y) {
		this.y = y;
	}
	
	
	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

	@Override
	public String toString() {
		return "ExampleItem [itemName=" + itemName + ", choice=" + choice
				+ ", x=" + x + ", y=" + y + ", r=" + r + ", theta=" + theta
				+ "]";
	}
}	