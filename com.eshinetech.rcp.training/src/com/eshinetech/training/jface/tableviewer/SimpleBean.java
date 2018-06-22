
package com.eshinetech.training.jface.tableviewer;

/**
 * @author WuChengRui
 * @date 2018-5-14  
 * @desc   
 */
public class SimpleBean {

	private String id ;
	private String airCode;
	private String airStart;
	private String airEnd;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getAirCode() {
		return airCode;
	}
	public void setAirCode(String airCode) {
		this.airCode = airCode;
	}
	public String getAirStart() {
		return airStart;
	}
	public void setAirStart(String airStart) {
		this.airStart = airStart;
	}
	public String getAirEnd() {
		return airEnd;
	}
	public void setAirEnd(String airEnd) {
		this.airEnd = airEnd;
	}
    @Override
    public String toString() {
        return "SimpleBean [id=" + id + ", airCode=" + airCode + ", airStart=" + airStart + ", airEnd=" + airEnd + "]";
    }
	
	
	
	
	
	
	
}
