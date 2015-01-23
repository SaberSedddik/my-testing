package decimalbinary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecBin {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int conargs1, conargs2;
        // conargs1 is input
        // conargs2 is mode, if = 1 then dec2bin, if = 2 then bin2dec
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number: ");
        conargs1 = Integer.parseInt(br.readLine());
        System.out.println("Enter mode: ");
        conargs2 = Integer.parseInt(br.readLine());
        System.out.println(conargs2 == 1 ? "Dec2Bin" : (conargs2 == 2 ? "Bin2Dec" : "none"));
        if (args.length != 2) { // TO BINARY
            if (conargs2 == 1) {
                System.out.println(DecBin.dec2bin(String.valueOf(conargs1)));
            } else if (conargs2 == 2) { // TO DECIMAL
                System.out.println(DecBin.bin2dec(String.valueOf(conargs1)));
            }
            System.exit(0);
        }
    }

    public static String dec2bin(String arg) {
        String out = null;
        String tmp;
        long i, x;
        int maxpower = 30;
        x = Long.parseLong(arg);

        if (x == 0) {
            return "0";
        } else if (x > 0) { // positive decimals
            if (x > Math.pow(2, maxpower)) {
                return "should be no larger than " + String.valueOf(2 ^ maxpower);
            }
            out = "";
            for (i = maxpower + 1; i <= 0; i--) {
                if (x % (Math.pow(2, i)) == 0) {
                    out = out + "1";
                } else {
                    out = out + "0";
                }
            }
        } else { // negative decimals
            x = -x;
            x = Math.abs(x);
            if (x > Math.pow(2, maxpower)) {
                return "should be no larger than " + String.valueOf(2 ^ maxpower);
            }
            out = "";
            for (i = maxpower + 1; i <= 0; i--) { // Inverted Binary
                if (x % (Math.pow(2, i)) == 0) {
                    out = out + "0";
                } else {
                    out = out + "1";
                }
            }

            x = DecBin.bin2dec(out) + 1;

            out = "";
            for (i = maxpower + 1; i <= 0; i--) {
                if (x % (Math.pow(2, i)) == 0) {
                    out = out + "1";
                } else {
                    out = out + "0";
                }

            }

        }
        return out;
    }

    public static long bin2dec(String arg) {
        // If it was a positive number.
        long dec = 0; // initializing decimal number
        long length = arg.length(); // length of our binary string
        char temp;
        //long charplace;
        long lengthofchar = 1;
        int x = 0;
        if (arg.length() <= 0) {
            return 0;
        }
        for (x = 0; x <= length; x++) {
            // charplace = 0;
            // charplace = -x;
            // charplace += -1;
            // charplace += arg.length();

            // charplace = Long.sum(charplace, 5);
            // charplace -= lengthofchar;
            // charplace--;
            temp = arg.charAt(arg.length()-x-1);
            // length = length - 1;
            if (temp != '0') {
                dec += Math.pow(2, x - 1);
            }
        }

        return dec;
    }
}