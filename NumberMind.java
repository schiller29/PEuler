// 5616185650518293 ;2 correct
// 3847439647293047 ;1 correct
// 5855462940810587 ;3 correct
// 9742855507068353 ;3 correct
// 4296849643607543 ;3 correct
// 3174248439465858 ;1 correct
// 4513559094146117 ;2 correct
// 7890971548908067 ;3 correct
// 8157356344118483 ;1 correct
// 2615250744386899 ;2 correct
// 8690095851526254 ;3 correct
// 6375711915077050 ;1 correct
// 6913859173121360 ;1 correct
// 6442889055042768 ;2 correct
// 2321386104303845 ;0 correct
// 2326509471271448 ;2 correct
// 5251583379644322 ;2 correct
// 1748270476758276 ;3 correct
// 4895722652190306 ;1 correct
// 3041631117224635 ;3 correct
// 1841236454324589 ;3 correct
// 2659862637316867 ;2 correct
public class NumberMind{
static int[] allWrong = { 2 , 3 , 2 , 1 , 3 , 8 , 6 , 1 , 0 , 4 , 3 , 0 , 3 , 8 , 4 , 5 };
 public static void main(String[] args){
    int[][] wrong = new int [16][16];
    for (int i = 0; i < 16; i++){
      wrong[i][i] = allWrong[i];
    }
  }
}
