import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Problem1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("students"));
		HashMap<String, ArrayList<String>> stud=new HashMap<>();
		
		String line = br.readLine();
		//load the file of the students in a HasMap
		while(line!=null){
			String v = line.substring(0, line.indexOf(','));
			String k = line.substring(line.indexOf(',')+1);
			if(stud.containsKey(k)){
				ArrayList<String> inside=stud.get(k);
				inside.add(v);
				stud.put(k, inside);
			}else{
				ArrayList<String> inside = new ArrayList<String>();
				inside.add(v);
				stud.put(k, inside);
			}
			line=br.readLine();
		}
		br.close();
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(reader);
		int numberLines=sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < numberLines; i++) {
			String key=sc.nextLine();
			if(stud.containsKey(key)){
				System.out.print("Case #"+(i+1)+": ");
				ArrayList<String> inside=shortList(stud.get(key));
				for (int j = 0; j < inside.size()-1; j++) {
					System.out.print(inside.get(j)+",");
				}
				System.out.println(inside.get(inside.size()-1));
			}else{
				System.out.println("Case #"+(i+1)+": NONE");
			}
		}
		sc.close();
	}

	private static ArrayList<String> shortList(ArrayList<String> arrayList) {
		List<String> list=arrayList.subList(0, arrayList.size());
		Collections.sort(list);
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			result.add(list.get(i));
		}
		return result;
	}

}
