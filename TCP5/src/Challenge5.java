import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Challenge5 {

	static int generationInitialLoop;
	public static void main(String[] args) {

		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(reader);
		
		char[][] grid=new char[8][8];
		for (int i = 0; i < grid.length; i++) {
			String line=sc.nextLine();
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j]=line.charAt(j);
				
			}
		}
		sc.close();
		
		boolean end=false;
		ArrayList<char[][]> steps= new ArrayList<>();
		steps.add(grid);
		while(!end){
			char[][] newGrid=nextGrid(grid);
			if(isInSteps(newGrid, steps)){
				System.out.println(generationInitialLoop+" "+(steps.size()-generationInitialLoop));
				end=true;
			}else{
				steps.add(newGrid);
			}
			grid=newGrid;
		}

	}

	private static boolean isInSteps(char[][] newGrid, ArrayList<char[][]> steps) {
		for (int i = 0; i < steps.size(); i++) {
			if(isSimilar(newGrid, steps.get(i))){
				generationInitialLoop=i;
				return true;
			}
		}
		return false;
	}

	private static boolean isSimilar(char[][] newGrid, char[][] comparableGrid) {
		for (int i = 0; i < newGrid.length; i++) {
			for (int j = 0; j < newGrid[i].length; j++) {
				if(newGrid[i][j]!=comparableGrid[i][j]){
					return false;
				}
				
			}
		}
		return true;
	}

	private static char[][] nextGrid(char[][] grid) {
		char[][] newGrid=new char[8][8];
		for (int i = 0; i < newGrid.length; i++) {
			for (int j = 0; j < newGrid[i].length; j++) {
				if(cellLive(i, j, grid)){
					newGrid[i][j]='X';
				}else{
					newGrid[i][j]='-';
				}
			}
		}
		return newGrid;
	}

	private static boolean cellLive(int i, int j, char[][] grid) {
		int countLivesAround=0;
		try{
			if(grid[i-1][j-1]=='X') countLivesAround++;			
		}catch(Exception e){
			//don't increment countLivesAround because this cell is out the grid
		}
		
		try{
			if(grid[i-1][j]=='X') countLivesAround++;			
		}catch(Exception e){
		}
		
		try{
			if(grid[i-1][j+1]=='X') countLivesAround++;			
		}catch(Exception e){
		}
		
		try{
			if(grid[i][j-1]=='X') countLivesAround++;			
		}catch(Exception e){
		}
		
		try{
			if(grid[i][j+1]=='X') countLivesAround++;			
		}catch(Exception e){
		}
		
		try{
			if(grid[i+1][j-1]=='X') countLivesAround++;			
		}catch(Exception e){
		}
		
		try{
			if(grid[i+1][j]=='X') countLivesAround++;			
		}catch(Exception e){
		}
		
		try{
			if(grid[i+1][j+1]=='X') countLivesAround++;			
		}catch(Exception e){
		}
		
		if(grid[i][j]=='-' && countLivesAround==3){
			return true;
		}
		
		if(grid[i][j]=='X' && countLivesAround<2){
			return false;
		}
		
		if(grid[i][j]=='X' && countLivesAround>3){
			return false;
		}
		
		if(grid[i][j]=='X' && (countLivesAround==2 || countLivesAround==3)){
			return true;
		}
		
		return false;
	}

	private static void printGrid(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();

		}
		System.out.println();
		
	}

}
