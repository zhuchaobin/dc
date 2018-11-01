package com.xai.tt.dc.client.enums;

public enum Enabled {
	 FALSE("离职",false),TRUE("在职",true);
	    
	    private String name;
	    private boolean index;
	    
	    private Enabled(String name,boolean index){
	    	this.name = name;
	    	this.index = index;
	    }
	    
	    public static String getName(boolean index){
	    	for (Enabled enabled : Enabled.values()) {  
	            if (enabled.getIndex() == index) {  
	                return enabled.name;  
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
