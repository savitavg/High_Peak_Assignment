import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HighPeak {

    static int Diff(int array[], int N, int M)
    {
        int result = Integer.MAX_VALUE;
        Arrays.sort(array);
        for (int i=0; i<= N-M;i++)
            result = Math.min(result, array[i + M - 1] - array[i]);
        return result;
    }

    static int fe(int res,int array[], int N, int M)
    {
        int result = Integer.MAX_VALUE;
        for(int i=0; i<=N; i++)
        {
            result = Math.min(result, array[i + M - 1] - array[i]);
            if (res==result)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
    	try {
			FileReader fr=new FileReader("C:\\Users\\dell\\eclipse-workspace\\Practice\\src\\sampleinput.txt");
			BufferedReader bf = new BufferedReader(fr);
			String s = bf.readLine();
			int c=0;
			ArrayList al = new ArrayList();
			while(s!=null) {
				String[] split2 = s.split(":");
				al.add(split2[split2.length-1]);
				c++;
				s = bf.readLine();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        int array[]={7980,22349,999,2799,229900,11101,9999,2195,9800,4999};
        String items[]={ "MI Band: 999","Sandwich Toaster: 2195" ,"Cult Pass: 2799","Scale: 4999","Fitbit Plus: 7980","Microwave Oven: 9800"  ,"Alexa: 9999","Digital Camera: 11101", "IPods: 22349","Macbook Pro: 229900" };
        int N = array.length;
        System.out.println("Enter the number of employees");
        Scanner s = new Scanner(System.in);
        int M=s.nextInt();
        int result=Diff(array, N, M);
        System.out.println("Number of the employees:"+M);
        int startindex=fe(result,array,N,M);
        System.out.println("Here the goodies that are selected for distribution are:");
        
        for(int i=startindex;i<startindex+M;i++)
            System.out.println(items[i]);
        System.out.println("\n");
        System.out.println("And the difference between the chosen goodies with highest price and the lowest price is:"+result);
    }
}