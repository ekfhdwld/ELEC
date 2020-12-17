package color.model.vo;

import java.io.Serializable;

public class Color implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String colorCode;
	private String colorName;
	private String colorRGB;
	public Color() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Color(String colorCode, String colorName, String colorRGB) {
		super();
		this.colorCode = colorCode;
		this.colorName = colorName;
		this.colorRGB = colorRGB;
	}
	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getColorRGB() {
		return colorRGB;
	}
	public void setColorRGB(String colorRGB) {
		this.colorRGB = colorRGB;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Color [colorCode=" + colorCode + ", colorName=" + colorName + ", colorRGB=" + colorRGB + "]";
	}

	
}
