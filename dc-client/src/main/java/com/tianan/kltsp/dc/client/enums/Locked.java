package com.tianan.kltsp.dc.client.enums;

public enum Locked {
    FALSE("未冻结",true),TRUE("已冻结",false);
    
    private String name;
    private boolean index;
    
    private Locked(String name,boolean index){
    	this.name = name;
    	this.index = index;
    }
    
    public static String getName(boolean index){
    	for (Locked locked : Locked.values()) {  
            if (locked.getIndex() == index) {  
                return locked.name;  
            }  
        }  
        return null;  
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIndex() {
		return index;
	}

	public void setIndex(boolean index) {
		this.index = index;
	}
    
}
