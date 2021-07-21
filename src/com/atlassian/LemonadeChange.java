package com.atlassian;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {

        if (bills.length == 0) {
            return true;
        }

        if (bills[0] != 5) {
            return false;
        }


        int count_5 = 0, count_10 = 0;

        for (int bill :  bills) {

            if (bill == 5) {
                count_5++;
                continue;
            }

            else if (bill == 10) {
                count_10++;

                if (count_5 <= 0) {
                    return false;
                }
                count_5--;
            }

            else {


                if (count_5 > 0 && count_10 > 0) {
                    count_5--;
                    count_10--;
                }
                else if (count_5 >= 3) {
                    count_5 -= 3;
                }
                else {
                    return false;
                }

            }
        }

        return true;
    }
}
