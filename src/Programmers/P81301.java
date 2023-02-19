package Programmers;

public class P81301 {
    public static void main(String[] args) {
        System.out.println(solution("2three45sixseven"));
    }

    static int solution(String s) {
        String result = "";
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if (48 <= c && c <= 57) {
                result += c;
                continue;
            }
            switch (c) {
                case 'z':
                    result += "0";
                    i += 3;
                    break;
                case 'o':
                    result += "1";
                    i += 2;
                    break;
                case 't':
                    switch (arr[i + 1]) {
                        case 'w' : {
                            result += "2";
                            i += 2;
                            break;
                        }
                        case 'h' : {
                            result += "3";
                            i += 4;
                            break;
                        }
                    }
                    break;
                case 'f':
                    switch (arr[i + 1]) {
                        case 'o' : {
                            result += "4";
                            i += 3;
                            break;
                        }
                        case 'i' : {
                            result += "5";
                            i += 3;
                            break;
                        }
                    }
                    break;
                case 's':
                    switch (arr[i + 1]) {
                        case 'i' : {
                            result += "6";
                            i += 2;
                            break;
                        }
                        case 'e' : {
                            result += "7";
                            i += 4;
                            break;
                        }
                    }
                    break;
                case 'e':
                    result += "8";
                    i += 4;
                    break;
                case 'n':
                    result += "9";
                    i += 3;
                    break;
            }
        }
        return Integer.parseInt(result);
    }
}
