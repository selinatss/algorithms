public class CountingValleys {

    public static void main(String[] args){
        String path = "DDUUDDDU";
        countingValleys(path);
    }

    public static int countingValleys(String path) {
        char[] pathArray = path.toCharArray();

        int level = 0;
        int valleys = 0;

        for(int i=0; i < pathArray.length; i++){
            if(pathArray[i] == 'U'){
                level ++;
            }else if(pathArray[i] == 'D'){
                if(level == 0){
                    valleys ++;
                }
                level --;
            }
        }
       System.out.println(valleys);
        return valleys;
    }


}
