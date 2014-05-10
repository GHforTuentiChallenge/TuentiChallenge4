import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Challenge4 {

	public static void main(String[] args) {
		
		//Read the imput
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(reader);
		String start=sc.nextLine();
		String goal=sc.nextLine();
		ArrayList<String> states = new ArrayList<String>();
		while(sc.hasNext()){
			states.add(sc.nextLine());
		}
		
		
		ArrayList<String> solveWay=new ArrayList<String>();
		solveWay.add(start);
		
		solve(start, goal, states, solveWay);
			
	}

	//Recursive and backtracking algorithm
	private static void solve(String start, String goal,
			ArrayList<String> states, ArrayList<String> solveWay) {
		
		
		for (int i = 0; i < states.size(); i++) {
			String state= states.get(i);
			if(isDistanceOne(start, state)&&!isInSolveWay(state,solveWay)){
				if(state.equals(goal)){
					solveWay.add(state);
					printWay(solveWay);
				}else{
					solveWay.add(state);
					solve(state, goal, states, solveWay);
				}
				solveWay.remove(solveWay.size()-1);
			}
		}
		
	}

	private static boolean isInSolveWay(String state, ArrayList<String> solveWay) {
		for (int i = 0; i < solveWay.size(); i++) {
			if(solveWay.get(i).equals(state)){
				return true;
			}
		}
		return false;
	}

	private static void printWay(ArrayList<String> solveWay) {
		for (int i = 0; i < solveWay.size()-1; i++) {
			System.out.print(solveWay.get(i)+"->");
		}
		System.out.println(solveWay.get(solveWay.size()-1));
		
	}

	private static boolean isDistanceOne(String start, String state) {
		//We are sure that start and state has the same length
		int diferentChar=0;
		for (int i = 0; i < start.length(); i++) {
			if(start.charAt(i)!=state.charAt(i)){
				diferentChar++;
			}
		}

		if(diferentChar==1){
			return true;
		}
		return false;
	}

}
