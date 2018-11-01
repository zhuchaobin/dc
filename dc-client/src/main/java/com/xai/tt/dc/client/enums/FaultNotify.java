package com.xai.tt.dc.client.enums;

public enum FaultNotify implements BaseEnum<Integer, String> {
	No(0, "不通知"),
	Yes(1, "通知"),
	;

	private Integer key;
	private String value;
	
	private FaultNotify(Integer key, String value) {
		this.key = key;
		this.value = value;
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
