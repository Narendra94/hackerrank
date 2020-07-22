/*
     HackerLand University has the following grading policy:
    Every student receives a  in the inclusive range from  to .
    Any  less than  is a failing grade.
    Sam is a professor at the university and likes to round each student's  according to these rules:

    If the difference between the  and the next multiple of  is less than , round  up to the next multiple of .
    If the value of  is less than , no rounding occurs as the result will still be a failing grade.
    For example,  will be rounded to  but  will not be rounded because the rounding would result in a number that is less than .

    Given the initial value of  for each of Sam's  students, write code to automate the rounding process.
     */

class Result {

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
