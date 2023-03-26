package Shtakan;

import org.lwjgl.util.vector.Vector3f;

import modelakan.modelyPekhenraw;

public class Sht {
	
	private modelyPekhenraw da3ba;
	private Vector3f shwen;
	private float xulanawayX,xulanawayY,xulanawayZ;
	private float pewan;
	public Sht(modelyPekhenraw da3ba, Vector3f shwen, float xulanawayX, float xulanawayY, float xulanawayZ,
			float pewan) {
		
		this.da3ba = da3ba;
		this.shwen = shwen;
		this.xulanawayX = xulanawayX;
		this.xulanawayY = xulanawayY;
		this.xulanawayZ = xulanawayZ;
		this.pewan = pewan;
	}
	
	public void zyakrdnyShwen(float daltaX,float daltaY,float daltaZ) {   //wata increasePosition. dx Wata dalta X 
		this.shwen.x+=daltaX;
		this.shwen.y+=daltaY;
		this.shwen.z+=daltaZ;
		
	}
	public void zyakrdnySuranawa(float daltaX,float daltaY,float daltaZ) {
		this.xulanawayX+=daltaX; //la sarawa ba Private drwstman krdwn am xwlanawana 
		this.xulanawayY+=daltaY;
		this.xulanawayZ+=daltaZ;
	}
	
	public modelyPekhenraw getDa3ba() {
		return da3ba;
	}
	public void setDa3ba(modelyPekhenraw da3ba) {
		this.da3ba = da3ba;
	}
	public Vector3f getShwen() {
		return shwen;
	}
	public void setShwen(Vector3f shwen) {
		this.shwen = shwen;
	}
	public float getXulanawayX() {
		return xulanawayX;
	}
	public void setXulanawayX(float xulanawayX) {
		this.xulanawayX = xulanawayX;
	}
	public float getXulanawayY() {
		return xulanawayY;
	}
	public void setXulanawayY(float xulanawayY) {
		this.xulanawayY = xulanawayY;
	}
	public float getXulanawayZ() {
		return xulanawayZ;
	}
	public void setXulanawayZ(float xulanawayZ) {
		this.xulanawayZ = xulanawayZ;
	}
	public float getPewan() {
		return pewan;
	}
	public void setPewan(float pewan) {
		this.pewan = pewan;
	}

}
