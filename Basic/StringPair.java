// String Pair
// Problem Description One person hands over the list of digits to Mr. String, But Mr. String understands only strings. Within strings also he understands only vowels. Mr. String needs your help to find the total number of pairs which add up to a certain digit D.The rules to calculate digit D are as follow :- Take all digits and convert them into their textual representation. Next, sum up the number of vowels i.e. {a, e, i, o, u} from all textual representation. This sum is digit D Now, once digit D is known find out all unordered pairs of numbers in input whose sum is equal to D. Refer example section for better understanding.

// Constraints 1 <= N <= 100 1 <= value of each element in second line of input <= 100 Number 100, if and when it appears in input should be converted to textual representation as hundred and not as one hundred. Hence number of vowels in number 100 should be 2 and not 4

// Input First line contains an integer N which represents number of elements to be processed as input Second line contains N numbers separated by space

// Output Lower case representation of textual representation of number of pairs in input that sum up to digit D Note: – (If the count exceeds 100 print "greater 100")

// Examples

// Input : 5
// 1 2 3 4 5
// Output : one

// Input : 3
// 7 4 2
// Output : zero

public class StringPair {

    public static void main(String args[]) {
        int n = 5;
        int arr1[] = { 1, 2, 3, 4, 5 };
        int arr2[] = { 7, 4, 2 };
        String map1[] = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty" };
        String map2[] = {"", "", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety", "hundred"};

        int pairCount = calculatePairs(n, arr1, map1, map2);

        if(pairCount > 100)
            System.out.println("greater 100");
        else if(pairCount == 100)
            System.out.println("hundred");
        else if(pairCount == 0) 
            System.out.println("zero");
        else if(pairCount >= 20) {
            String first = map2[pairCount/10];
            String sec = map1[pairCount - pairCount/10*10];
            System.out.println(first + sec);
        } else {
            System.out.println(map1[pairCount]);
        }
    }

    public static int calculatePairs(int n, int arr[], String map1[], String map2[]) {
        int vowelCount = 0;

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            
            if(curr >= 20) {
                String first = map2[curr/10];
                String sec = map1[curr - ((curr/10) * 10)];

                vowelCount += countVowels(first + sec);
            } else {
                vowelCount += countVowels(map1[curr]);
            }
        }

        int pairs = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == vowelCount)
                    pairs++;
            }
        }

        return pairs;
    }

    public static int countVowels(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
                    || s.charAt(i) == 'u')
                count++;
        }
        return count;
    }

}