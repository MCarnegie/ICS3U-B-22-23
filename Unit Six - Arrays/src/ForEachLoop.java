public class ForEachLoop {
    public static void main(String[] args) {
        String[] words = {"Ega", "suge", "weech", "omcha", "excited", "sleep"};

        //for each loop - meant to iterate through the whole collection
        //cannot change the size of the collection - not a big deal for arrrays
        //no access to teh index
        //must iterate stating at index 0 to length-1

        for (String str : words) {
            System.out.println(str);
        }
    }
}
