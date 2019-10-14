public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        String[] ss=s.split(":");
        int hour=Integer.parseInt(ss[0]);     //we need this to add to hours count
        
        StringBuilder str=new StringBuilder(s);     //to alter our original string
        if(s.contains("12") && s.contains("AM")){       //this case handles Mid-night 
            str.replace(0,2,"00");
            str.delete(8,10);
            return str.toString();
        }
        if(s.contains("12") && s.contains("PM") ){    //this one for Noon case
             str.delete(8,10);
             return str.toString();
        }else{
            if(s.contains("PM")){                    //we have to add 12 to get 24 hour format
                int i=12+hour;
                str.replace(0,2,String.valueOf(i));
                str.delete(8,10);
                return str.toString();
            }else{
                str.delete(8,10);                    //for rest delete only AM and PM
                return str.toString();
            }
        }

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
