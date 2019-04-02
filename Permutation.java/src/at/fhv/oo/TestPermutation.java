package at.fhv.oo;


public class TestPermutation {
    private int[] _src = {1,3,2,4,5};
    private int[] _dest = {1,2,3,4,5};
    private int _n = 5;


    public boolean isPermutationPossible(){

        boolean test = true;
        Stack s = new Stack(_n);

        int j = 0;

        //auf stack schreiben wenn dest und src nicht gleich
        for(int i=0; i < _dest.length;i++){
        	if(_dest[i] != _src[j]) {
                s.push(_src[j]);
            }else{
                j++;
            }
        }

        while(!s.isEmpty() && test == true){
            if(s.pop() != _src[j-1]){
                test = false;
            }
        }

        return test;

    }




}
