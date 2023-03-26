package Shtakan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import modelakan.model;
import windowKrdnawa.Loadkrdn;

public class OBJlodkar {

	public static model lodyOBJmodel(String nawifail, Loadkrdn lodbka) {

		FileReader fr = null;
		
		try {
			fr= new FileReader(new File("sarchawa/"+nawifail+".obj"));
		} catch (FileNotFoundException e) {
		System.err.println("natwanra faily OBJ bxwenretawa");
			e.printStackTrace();
		}
		BufferedReader xwenarawa = new BufferedReader(fr);
		String xat;
		List<Vector3f> lwtkakan= new ArrayList<Vector3f>();
		List<Vector2f> pekhenrawakan = new ArrayList<Vector2f>();
		List<Vector3f> normalakan = new ArrayList<Vector3f>();
		List<Integer> indisekan = new ArrayList<Integer>();
		
		float[] LwtkayRizband = null;
		float[] normalyRizband =null;
		float[] pekhatayrizband=null;
		int[] indisiRizband=null;
		
		try {
			while(true) {
				xat=xwenarawa.readLine();
				String [] xatyEsta =xat.split(" ");
				if(xat.startsWith("v ")) {
					Vector3f lwtka= new Vector3f(Float.parseFloat(xatyEsta[1]),Float.parseFloat(xatyEsta[2]),
							Float.parseFloat(xatyEsta[3]));
					lwtkakan.add(lwtka);
				}
				else if(xat.startsWith("vn ")) {
					Vector3f normal= new Vector3f(Float.parseFloat(xatyEsta[1]),Float.parseFloat(xatyEsta[2]),
							Float.parseFloat(xatyEsta[3]));
					normalakan.add(normal);
				}
				else if(xat.startsWith("vt ")) {
					Vector2f pekhata= new Vector2f(Float.parseFloat(xatyEsta[1]),Float.parseFloat(xatyEsta[2]));
					pekhenrawakan.add(pekhata);
				}
				else if(xat.startsWith("f ")) {
					pekhatayrizband=new float [lwtkakan.size()*2];
					normalyRizband=new float [lwtkakan.size()*3];
					break;
				}
				
			}
			while(xat!=null) {
				if(!xat.startsWith("f ")) {
					
					xat=xwenarawa.readLine();
					continue;
				}
				String[] xatyEsta=xat.split(" ");
				String[] lwtkay1=xatyEsta[1].split("/");
				String[] lwtkay2=xatyEsta[2].split("/");
				String[] lwtkay3=xatyEsta[3].split("/");
				
				//Shweny Xata Sawzakaya
				processyLwtka(lwtkay1, indisekan, pekhenrawakan, normalakan, pekhatayrizband, normalyRizband);
				processyLwtka(lwtkay2, indisekan, pekhenrawakan, normalakan, pekhatayrizband, normalyRizband);
				processyLwtka(lwtkay3, indisekan, pekhenrawakan, normalakan, pekhatayrizband, normalyRizband);
				xat=xwenarawa.readLine();
				
				
				
				//Shweny Xata Sawzakabw ta era
			}
			xwenarawa.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		LwtkayRizband=new float[lwtkakan.size()*3];
		indisiRizband =new int[indisekan.size()];
		int LwtkayNishandar=0;
		for(Vector3f lwtka:lwtkakan) {
			
			LwtkayRizband[LwtkayNishandar++]=lwtka.x;
			LwtkayRizband[LwtkayNishandar++]=lwtka.y;
			LwtkayRizband[LwtkayNishandar++]=lwtka.z;
		}
		for (int i=0;i<indisekan.size();i++) {
			indisiRizband[i]=indisekan.get(i);
		}
		return lodbka.bikanawVAO(LwtkayRizband, pekhatayrizband, indisiRizband);
		
				}
	
	private static void processyLwtka(String[] zanyaryLwtka, List<Integer> indisekan,
			List<Vector2f>pekhenrawakan,List<Vector3f>normalakan,float[] pekhatayrizband,float[]normalyRizband) {
		int VertexyEstayNishanapekraw=Integer.parseInt(zanyaryLwtka[0]) -1;
		indisekan.add(VertexyEstayNishanapekraw);
		Vector2f PekhatayEsta=pekhenrawakan.get(Integer.parseInt(zanyaryLwtka[1])-1);
		pekhatayrizband[VertexyEstayNishanapekraw*2]=PekhatayEsta.x;
		pekhatayrizband[VertexyEstayNishanapekraw*2+1]=1-PekhatayEsta.y;
		Vector3f normalyEsta = normalakan.get(Integer.parseInt(zanyaryLwtka[2])-1);
		
		normalyRizband[VertexyEstayNishanapekraw*3]=normalyEsta.x;
		
		normalyRizband[VertexyEstayNishanapekraw*3+1] = normalyEsta.y;
		normalyRizband[VertexyEstayNishanapekraw*3+2]=normalyEsta.z;
	}
}
