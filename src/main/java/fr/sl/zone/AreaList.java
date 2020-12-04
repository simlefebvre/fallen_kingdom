package fr.sl.zone;

import java.util.ArrayList;
import java.util.ListIterator;

public class AreaList {

	private ArrayList<Area> areas;
	
	public AreaList(ArrayList<Area> areas) {
		this.areas = areas;
	}
	
	public Area getArea(int index) {
		ListIterator<Area> li = areas.listIterator();
		boolean test = true;
	    //while (areas.hasNext() && test) {
	    //	Area a = li.next();
	    //	if(a.getindex() == index) {
	    //		return a;
	    //	}
	    //}
	        
	}
	
}
