package com.topcoder.srm;

/**
 *
 * You and your friend are waiting in a line. A description of the line is given in the String line.
 * The character 'S' represents yourself, the character 'F' represents your friend, and '.' indicates anyone else in the line.
 *
 * How far apart are you and your friend in this line?
 * Constraints
 * -	line will have between 2 and 50 characters, inclusive.
 * -	Each character of line will be '.', 'S', or 'F'.
 * -	'S' and 'F' will each appear exactly once in line.
 *
 * Examples
 * 0)
 *
 * "....SF..."
 * Returns: 1
 * You and your friend are adjacent in this line, thus you are one position away from each other.
 * 1)
 *
 * "S........F"
 * Returns: 9
 * You and your friend are at completely opposite ends of this line.
 * 2)
 *
 * "..F...S.."
 * Returns: 4
 * You and your friend may appear in either order.
 */
public class FriendFinder {
    public static void main(String[] args) {
        System.out.println(distance("S........................................F"));
    }

    public static int distance(String line) {
        char[] arr = line.toCharArray();
        int fPos = -1, sPos = -1;

        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 'S'){
                sPos = i;
            }

            if (arr[i] == 'F'){
                fPos = i;
            }
        }

        return Math.abs(fPos - sPos);
    }
}
