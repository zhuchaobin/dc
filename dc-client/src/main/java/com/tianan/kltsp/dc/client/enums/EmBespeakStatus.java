package com.tianan.kltsp.dc.client.enums;

public enum EmBespeakStatus implements BaseEnum<Integer, String> {
	applying(1, "申请中"),
	accept(2, "已受理"),
	cancel(3, "取消"),
	complete(4, "完成"),
	;

	private Integer key;
	private String value;

	private EmBespeakStatus(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

	public static String getByKey(Integer key){
		for (EmBespeakStatus em : EmBespeakStatus.values()){
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
