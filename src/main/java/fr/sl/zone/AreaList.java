package fr.sl.zone;

import java.util.ArrayList;
import java.util.ListIterator;

public class AreaList {

	private ArrayList<Area> areas;
	
	public AreaList(ArrayList<Area> areas) {
		this.areas = areas;
	}
	
	public AreaList() {
		areas = new ArrayList<Area>();
	}
	
	
	public void addArea(Area a) {
		areas.add(a);
	}
	
	public ArrayList<Area> getList() {
		return areas;
	}
	
	public Area getArea(String index) {
		ListIterator<Area> li = areas.listIterator();
		boolean test = true;
	    while (li.hasNext() && test) {
	    	Area a = li.next();
	    	if(("" + a.getIndex()).equalsIgnoreCase(index)) {
	    		return a;
	    	}
	    }
	    return null;
	}
	
}
