package modelakan;

public class model {

	private int vaoID;
	private int vertexCount;
	public model(int vaoID,int vertexCount) {
		this.vaoID=vaoID;
		this.vertexCount=vertexCount;
	}

	public int IDVaoWargra() {
		return vaoID;
	}
	
	public int VertexakanWargra() {
		return vertexCount;
	}
	
	
}
