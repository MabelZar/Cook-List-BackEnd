package com.cooklist.bean.dto;

public class MeasurementUnitDto implements java.io.Serializable {

	private static final long serialVersionUID = -8803078084975696171L;
	private Integer id;
	private String name;
	private String symbol;
	private boolean isMeasurable;

	public MeasurementUnitDto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public boolean isIsMeasurable() {
		return this.isMeasurable;
	}

	public void setIsMeasurable(boolean isMeasurable) {
		this.isMeasurable = isMeasurable;
	}

}
