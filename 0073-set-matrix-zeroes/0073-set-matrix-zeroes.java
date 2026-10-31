class Solution {
    public void setZeroes(int[][] matrix) {
        int n= matrix.length;
        int m = matrix[0].length;
        boolean [] rows = new boolean[n];
        boolean [] cols = new boolean[m];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    rows[i]=true;
                    cols[j]=true;
                }
            }
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length;j++){
                if(rows[i]|| cols[j]){
                    matrix[i][j]=0;
                }
            }
        }
    } 
}