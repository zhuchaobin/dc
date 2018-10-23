package com.tianan.kltsp.dc.client.enums;

public enum EmBranchType implements BaseEnum<Integer, String> {
	dealer(1, "经销商"),
	facilitator(2, "服务商"),
	;

	private Integer key;
	private String value;

	private EmBranchType(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

	public static String getByKey(Integer key){
		for (EmBranchType em : EmBranchType.values()){
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
