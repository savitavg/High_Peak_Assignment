import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class HighPeak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String split = null;
		try {
			FileReader fr=new FileReader("C:\\Users\\dell\\eclipse-workspace\\Practice\\src\\sampleinput.txt");
			BufferedReader bf = new BufferedReader(fr);
			FileWriter fw = new FileWriter("C:\\Users\\dell\\eclipse-workspace\\Practice\\src\\output.txt");
			
			String s = bf.readLine();
			ArrayList al = new ArrayList<Integer>();
			ArrayList al2 = new ArrayList<String>();
			while(s!=null) {
				al2.add(s);
				String[] split2 = s.split( " ");
					if(split2[split2.length-1].equals("" )||split2[split2.length-1].endsWith("Prices:")) {}
					else {
					al.add(Integer.parseInt(split2[split2.length-1]));}
					s = bf.readLine();
			}
            Collections.sort(al);
            Integer ar[] =new Integer[al.size()];
            al.toArray(ar);
            int k=ar[0];
            int start=0;
            int min=ar[ar.length-1];
            for (int i = 1; i <=ar.length-k; i++) {
				int diff=ar[i+k-1]-ar[i];
				if(min>diff) {
					min=diff;
					start=i;
				}
			}
            System.out.println(min);
            String ar2[] =new String[al2.size()];
            al2.toArray(ar2);
            int l=0;
            
            fw.write("The goodies selected for distribution are:");
            fw.write("\n");
            for (int i = start; i <=start+k-1; i++) {
            	int d=ar[i];
				for(int j=4;j<ar2.length;j++) {
					String[] split2 = ar2[j].split (" ");
					Integer stt=Integer.parseInt(split2[split2.length-1]);
					if(stt==d) {
						fw.write(ar2[j]);
						fw.write("\n");
					}
				}
			}
            fw.write(min+"");
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	

}
