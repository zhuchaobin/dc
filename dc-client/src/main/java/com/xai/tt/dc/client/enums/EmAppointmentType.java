package com.xai.tt.dc.client.enums;

public enum EmAppointmentType implements BaseEnum<Integer, String> {
	maintenance(1, "维修"),
	appointment(2, "保养"),
	;

	private Integer key;
	private String value;

	private EmAppointmentType(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

	public static String getByKey(Integer key){
		for (EmAppointmentType em : EmAppointmentType.values()){
			if(key.equals(em.getKey())){
				return em.getValue();
			}
		}
		return null;
	}
	
	@Override
	public Integer getKey() {
		return this.key;
	}

	@Override
	public String getValue() {
		return this.value;
	}

}
