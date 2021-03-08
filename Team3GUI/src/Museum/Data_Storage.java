package Museum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;

public class Data_Storage {
	
	static String loadTxt() {
		String exp="";
		String bf="";
		FileReader fr=null;
		try {
			fr=new FileReader("test_explain.txt");
			BufferedReader br=new BufferedReader(fr);
			while((bf=br.readLine())!=null) {
				exp+=bf+"\n";
			}
			br.close();
			fr.close();
		}catch(Exception e) {}
		return exp;
	}

}
