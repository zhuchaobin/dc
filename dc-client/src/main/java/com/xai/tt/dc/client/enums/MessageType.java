package com.xai.tt.dc.client.enums;

public enum MessageType implements BaseEnum<Integer, String> {
	
	alarm(1, "告警消息"),
	fault(2, "故障消息"),
	bounds(3, "越界消息"),
	illegal(4, "违章消息"),
	other(5, "其他消息"),
	dynamic(6, "动态消息"),
	publish(7, "推广消息"),
	repair(8, "养修消息"),
	notify(9, "通知消息")
	;

	private Integer key;
	private String value;

	private MessageType(Integer key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public static MessageType getByKey(Integer key){
		for (MessageType em : MessageType.values()){
			if(key.equals(em.getKey())){
				return em;
			}
		}
		return MessageType.other;
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
