package sj.project.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author sanjin
 *
 * 检查数独问题是否合法（而非是否可解）
 * 
 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		List<int[]>[] array = new List[9];
        //board 大小为 [9][9]
        for(int i=0;i<9;i++){
        	for(int j=0;j<9;j++){
        		if(board[i][j] == '.') continue;
        		int num = board[i][j] - '0';
        		if(array[num-1] == null) array[num-1] = new LinkedList<>();
        		array[num-1].add(new int[]{i,j,i/3*3+j/3});//第三个参数是所在子块，在九宫格的位置
        	}
        }
        for(int i=0;i<9;i++){
        	if(array[i]==null) continue;
        	int[] row = new int[9];
        	int[] column = new int[9];
        	int[] block = new int [9];
        	for(int[] item : array[i]){
        		if(row[item[0]]==1) {
        			return false;
        		} else {
        			row[item[0]]=1;
        		}
        		if(column[item[1]]==1) {
        			return false;
        		} else {
        			column[item[1]]=1;
        		}
        		if(block[item[2]]==1) {
        			return false;
        		} else {
        			block[item[2]]=1;
        		}
        	}
        }
        return true;	
    }
	
}
