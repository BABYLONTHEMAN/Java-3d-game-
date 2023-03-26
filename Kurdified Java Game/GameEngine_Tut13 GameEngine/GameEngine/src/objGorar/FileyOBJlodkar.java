package objGorar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class FileyOBJlodkar {

	private static final String Sarchawa_Daxa = "sarchawa/";

	public static zanyariModel OBJlodka (String nawiObjFailaka) {
		FileReader isr=null;
		File faileyOBJ = new File(Sarchawa_Daxa + nawiObjFailaka+".obj");
		
		try
		{
			isr = new FileReader(faileyOBJ);
		} catch (FileNotFoundException e) {
			System.err.println("Failaka nadozrayawa la sarchawada ; hich extentionek bakar mahena ");
		}
		BufferedReader xwenarawa = new BufferedReader(isr);
		String xat;
		List<Lwtka> lwtkakan = new ArrayList<Lwtka>();
		List<Vector2f> pekhatakan = new ArrayList<Vector2f>();
		List<Vector3f> normalakan = new ArrayList<Vector3f>();
		List<Integer> indisekan = new ArrayList<Integer>();
		try {
			while(true) {
				
				xat=xwenarawa.readLine();
				if(xat.startsWith("v ")) {
					String [] xatyEsta = xat.split(" ");
					Vector3f lwtka = new Vector3f((float) Float.valueOf(xatyEsta[1]),
							(float) Float.valueOf(xatyEsta[2]),(float) Float.valueOf(xatyEsta[3]));
							Lwtka lwtkyTaza = new Lwtka(lwtkakan.size(), lwtka);
							lwtkakan.add(lwtkyTaza);
				}
				else if (xat.startsWith("vt ")) {
					String [] xatyEsta= xat.split(" ");
					Vector2f pekhata=new Vector2f((float) Float.valueOf(xatyEsta[1]),(float) Float.valueOf(xatyEsta[2]));
					pekhatakan.add(pekhata);
					
				}
				else if(xat.startsWith("vn ")) {
					String [] xatyEsta=xat.split(" ");
					Vector3f normal = new Vector3f((float) Float.valueOf(xatyEsta[1]),
							(float) Float.valueOf(xatyEsta[2]),(float) Float.valueOf(xatyEsta[3]));
							normalakan.add(normal);
				}
				else if(xat.startsWith("f ")) {
					break;
				}
				
			}
			while(xat!=null&&xat.startsWith("f ")) {
				String [] xatyEsta=xat.split(" ");
				String [] lwtkay1=xatyEsta[1].split("/");
				String [] lwtkay2=xatyEsta[2].split("/");
				String [] lwtkay3=xatyEsta[3].split("/");
				processkrdnyLwtka(lwtkay1,lwtkakan,indisekan);
				processkrdnyLwtka(lwtkay2,lwtkakan,indisekan);
				processkrdnyLwtka(lwtkay3,lwtkakan,indisekan);
				xat=xwenarawa.readLine();
			}
			xwenarawa.close();
			
		} catch(IOException e) {
			System.err.println("halayak haya la xwendnaway failaka");
		}
		LabrdnyLwtkakanyKaPewistNia(lwtkakan);
		float[] RizbandyLwtkakan = new float[lwtkakan.size() *3];
		float[] RizbandyPekhatakan = new float [lwtkakan.size() *2];
		float[] RizbandyNormalakan = new float[lwtkakan.size() *3];
		float dwrtrin=gorinyzanyariboRizband(lwtkakan,pekhatakan,normalakan,
				RizbandyLwtkakan,RizbandyPekhatakan,RizbandyNormalakan);
		int[] RizbandyIndisekan = goriniListyIndisekanBoRizband(indisekan);
		zanyariModel zanyary = new zanyariModel(RizbandyLwtkakan, RizbandyPekhatakan, RizbandyNormalakan, RizbandyIndisekan, dwrtrin);
		return zanyary;
}
	private static void processkrdnyLwtka(String[] lwtka, List<Lwtka>lwtkakan,List<Integer> indisekan) {
		int nawarok =Integer.parseInt(lwtka[0])-1;
		Lwtka lwtkayEsta = lwtkakan.get(nawarok);
		int nawarokyPekhata = Integer.parseInt(lwtka[1]) -1;
		int nawarokyNormal = Integer.parseInt(lwtka[2]) -1;
		if(!lwtkayEsta.danRawa()) {
			lwtkayEsta.nawarokyPekhataDane(nawarokyPekhata);
			lwtkayEsta.NawarokyNormalDane(nawarokyNormal);
			indisekan.add(nawarok);
		} else {
			charasarylwtkakanbkaKaBahar7alatekProcessKrawn(lwtkayEsta,nawarokyPekhata,nawarokyNormal,indisekan,lwtkakan);
			}
		}
	private static int[] goriniListyIndisekanBoRizband (List<Integer> indisekan) {
		int[] RizbandyIndisekan = new int [indisekan.size()];
		for (int i=0;i<RizbandyIndisekan.length;i++) {
			RizbandyIndisekan[i] = indisekan.get(i);
		}
		return RizbandyIndisekan;
	}
	
	private static float gorinyzanyariboRizband(List<Lwtka> lwtkakan, List<Vector2f> pekhatakan,
			List<Vector3f> normalakan, float[] rizbandylwtkakan,float [] rizbandypekhatakan,
			float[] rizbandyNormalakan) {
		float dwrtrinNwqta = 0;
		for(int i=0;i<lwtkakan.size();i++) {
			Lwtka lwtkayEsta=lwtkakan.get(i);
			if(lwtkayEsta.drezhyWargra()>dwrtrinNwqta) {
				dwrtrinNwqta=lwtkayEsta.drezhyWargra();
			}
			Vector3f shwen =lwtkayEsta.shwenWargra();
			Vector2f pekhatayHawriz=pekhatakan.get(lwtkayEsta.nawarokyPekhataWargra());
			Vector3f TiriNormal = normalakan.get(lwtkayEsta.nawarokyNormalWargra());
			rizbandylwtkakan[i *3] = shwen.x;
			rizbandylwtkakan[i*3+1] = shwen.y;
			rizbandylwtkakan[i*3+2] = shwen.z;
			rizbandypekhatakan[i*2] = pekhatayHawriz.x;
			rizbandypekhatakan[i*2+1] = 1-pekhatayHawriz.y;
			rizbandyNormalakan[i*3] = TiriNormal.x;
			rizbandyNormalakan[i*3+1] =TiriNormal.y;
			rizbandyNormalakan[i*3+2]=TiriNormal.z;
		}
		return dwrtrinNwqta;
	}
	
	private static void charasarylwtkakanbkaKaBahar7alatekProcessKrawn(Lwtka lwtkayPeshw,int nawarokyPekhatayTaza,
			int nawarokiNormalyTaza, List<Integer> indisekan,List<Lwtka> lwtkakan) {
		if (lwtkayPeshw.HamanpekhatawNormalyHaya(nawarokyPekhatayTaza, nawarokiNormalyTaza)) {
			indisekan.add(lwtkayPeshw.nawarokWargra());
		} else {
			Lwtka lwtkayakytr = lwtkayPeshw.LwtkaDablkaWargra();
			if(lwtkayakytr!=null) {
				charasarylwtkakanbkaKaBahar7alatekProcessKrawn(lwtkayakytr, nawarokyPekhatayTaza,
						nawarokiNormalyTaza, indisekan, lwtkakan);
			} else {
				Lwtka lwtkaDablka = new Lwtka(lwtkakan.size(), lwtkayPeshw.shwenWargra());
				lwtkaDablka.nawarokyPekhataDane(nawarokyPekhatayTaza);
				lwtkaDablka.NawarokyNormalDane(nawarokiNormalyTaza);
				lwtkayPeshw.lwtkaDablkaDane(lwtkaDablka);
				lwtkakan.add(lwtkaDablka);
				indisekan.add(lwtkaDablka.nawarokWargra());
			}
		}
	}
	private static void LabrdnyLwtkakanyKaPewistNia (List<Lwtka> lwtkakan) {
		for(Lwtka lwtka:lwtkakan) {
			if(!lwtka.danRawa()) {
				lwtka.nawarokyPekhataDane(0);
				lwtka.NawarokyNormalDane(0);
			}
		}
		
	}
}