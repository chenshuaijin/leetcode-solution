package sj.project.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

public class SudokuSolver {
	
	@Test
	public void test(){
		String[] strs = new String[]{"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		char[][] board = new char[9][9];
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				board[i][j] = strs[i].charAt(j);
			}
		}
		solveSudoku(board);
		System.out.println(Arrays.deepToString(board));
	}

	public void solveSudoku(char[][] board) {
		Deque<Integer> operationStack = new LinkedList();
		boolean[][] rowState = new boolean[9][9]; // [nums-1][rowIndex] true if exist
		boolean[][] columnState = new boolean[9][9];
		boolean[][] cubeState = new boolean[9][9];
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(board[i][j]=='.') continue;
				int num = board[i][j] - '0';
				rowState[num-1][i] = true;
				columnState[num-1][j] = true;
				cubeState[num-1][i/3*3+j/3] = true;
			}
		}
		int backState = -1;
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(board[i][j]!='.') continue;
				int num=0;
				if(backState!=-1) {
					num = backState +1;
					backState = -1;
				}
				boolean isSet = false;
				for(;num<9;num++){
					if(rowState[num][i] || columnState[num][j] || cubeState[num][i/3*3+j/3]) continue;
					board[i][j] = (char) ('1'+num);
					rowState[num][i] = true;
					columnState[num][j] = true;
					cubeState[num][i/3*3+j/3] = true;
					isSet = true;
					operationStack.push((i*9+j)*10+num);
					break;
				}
				if(!isSet){
					Integer operation = operationStack.pop();
					i = operation/10/9;
					j = operation/10%9;
					backState = operation%10;
					board[i][j] = '.';
//					System.out.println("i\t"+i+"\tj\t"+j+"\tnum\t"+num);
					rowState[backState][i] = false;
					columnState[backState][j] = false;
					cubeState[backState][i/3*3+j/3] = false;
					j--;
				}
			}
		}
	}

}
