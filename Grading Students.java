class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
    // Write your code here
        for(int i=0;i<grades.size();i++){
            if(grades.get(i)>=38){
                int lastNum=grades.get(i)%10;
                if(lastNum < 5){
                    int count=5 - lastNum;
                    int edit=grades.get(i) + count;
                    if(edit-grades.get(i) < 3){
                        grades.set(i,edit);
                    }
                }else if(lastNum < 10){
                    int count=10 - lastNum;
                    int edit=grades.get(i) + count;
                    if(edit-grades.get(i) < 3){
                        grades.set(i,edit);
                    }
                }
            }
        }
        return grades;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
