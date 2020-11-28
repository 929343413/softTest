package cn.lww.bean;

import org.apache.commons.imaging.ImageInfo.ColorType;

public class MyPicture {
	private int width;
	private int height;
	private ColorType color; 
	private String detail;
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public ColorType getColor() {
		return color;
	}
	public void setColor(ColorType color) {
		this.color = color;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}
