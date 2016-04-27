package com.nings.entity;

public class MCUtilitiesExpenseItem {
	private String utilitiesCode;

	private String utilitiesName;

	private String channelId;

	private String transCode;

	private String imagePath;

	private String sort;

	
	
	public MCUtilitiesExpenseItem() {
		super();
	}

	public String getUtilitiesCode() {
		return utilitiesCode;
	}

	public void setUtilitiesCode(String utilitiesCode) {
		this.utilitiesCode = utilitiesCode == null ? null : utilitiesCode.trim();
	}

	public String getUtilitiesName() {
		return utilitiesName;
	}

	public void setUtilitiesName(String utilitiesName) {
		this.utilitiesName = utilitiesName == null ? null : utilitiesName.trim();
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId == null ? null : channelId.trim();
	}

	public String getTransCode() {
		return transCode;
	}

	public void setTransCode(String transCode) {
		this.transCode = transCode == null ? null : transCode.trim();
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath == null ? null : imagePath.trim();
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort == null ? null : sort.trim();
	}

	@Override
	public String toString() {
		return "MCUtilitiesExpenseItem [utilitiesCode=" + utilitiesCode + ", utilitiesName=" + utilitiesName
				+ ", channelId=" + channelId + ", transCode=" + transCode + ", imagePath=" + imagePath + ", sort="
				+ sort + "]";
	}

}