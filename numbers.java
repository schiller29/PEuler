import java.util.ArrayList;
public class Numbers{
  public static void main(String[] args) {
      int[] zero      =       {5,6,1,6,1,8,5,6,5,0,5,1,8,2,9,3};    //2 correct
      int[] one       =       {3,8,4,7,4,3,9,6,4,7,2,9,3,0,4,7};    //1 correct
      int[] two       =       {5,8,5,5,4,6,2,9,4,0,8,1,0,5,8,7};    //3 correct //no crossover
      int[] three     =       {9,7,4,2,8,5,5,5,0,7,0,6,8,3,5,3};    //3 correct
      int[] four      =       {4,2,9,6,8,4,9,6,4,3,6,0,7,5,4,3};    //3 correct
      int[] five      =       {3,1,7,4,2,4,8,4,3,9,4,6,5,8,5,8};    //1 correct
      int[] six       =       {4,5,1,3,5,5,9,0,9,4,1,4,6,1,1,7};    //2 correct
      int[] seven     =       {7,8,9,0,9,7,1,5,4,8,9,0,8,0,6,7};    //3 correct
      int[] eight     =       {8,1,5,7,3,5,6,3,4,4,1,1,8,4,8,3};    //1 correct
      int[] nine      =       {2,6,1,5,2,5,0,7,4,4,3,8,6,8,9,9};    //2 correct
      int[] ten       =       {8,6,9,0,0,9,5,8,5,1,5,2,6,2,5,4};    //3 correct //no crossover
      int[] eleven    =       {6,4,4,2,8,8,9,0,5,5,0,4,2,7,6,8};    //2 correct
      int[] twelve    =       {2,3,2,6,5,0,9,4,7,1,2,7,1,4,4,8};    //2 correct
      int[] thirteen  =       {5,2,5,1,5,8,3,3,7,9,6,4,4,3,2,2};    //2 correct
      int[] fourteen  =       {1,7,4,8,2,7,0,4,7,6,7,5,8,2,7,6};    //3 correct //no crossover
      int[] fifteen   =       {4,8,9,5,7,2,2,6,5,2,1,9,0,3,0,6};    //1 correct //no crossover
      int[] sixteen   =       {3,0,4,1,6,3,1,1,1,7,2,2,4,6,3,5};    //3 correct
      int[] seventeen =       {1,8,4,1,2,3,6,4,5,4,3,2,4,5,8,9};    //3 correct
      int[] eighteen  =       {2,6,5,9,8,6,2,6,3,7,3,1,6,8,6,7};    //2 correct
      int[] allWrong  =       {2,3,2,1,3,8,6,1,0,4,3,0,3,8,4,5};    //0 correct
      int[][] arrays = {zero, one, two, three, four, five, six, seven, eight, nine,
                        ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen, seventeen, eighteen};
      ArrayList<Integer> wrong = new ArrayList<Integer>();
      ArrayList<Integer> wrongIndexNums = new ArrayList<Integer>();
        for(int i =0; i < 19; i++){
          int count=0;
          for (int j =0; j < 16; j++){
            if  (arrays[i][j] == allWrong[j]){
              wrong.add(i);
              count++;
            }
          }
          wrongIndexNums.add(count);
        }

        System.out.println(noCrossover);
        System.out.println(wrongIndexNums);

  }

}
