package src.Data_Structure;

import java.io.*;
import java.util.*;

public class Baek9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            String line = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isValid = true; // Stack 내부의 요소 존재 여부 확인

            // '('이면 push하고, ')'이면 pop
            // ')'가 없으면 false로 변환
            for(char ch : line.toCharArray()){
                if (ch == '('){
                    stack.push(ch);
                } else if (ch == ')'){
                    if (stack.isEmpty()){
                        isValid = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!stack.isEmpty()){
                isValid = false;
            }

            System.out.println(isValid ? "YES" : "NO");
        }

    }
}
