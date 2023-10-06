package utils;

import java.util.Scanner;

public class LispEvaluator
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an expression to be solved: ");
        String str = input.nextLine();
        System.out.println(str);

        if(checkBalance(str))
        {
            //Spaces in the string
            String newStr = str.replaceAll(" ", "");

            //Convert the string to char then store in an array
            char[] ch = convertToArray(newStr);

            //Create stack array
            StackInterface<Character> stackArr = new ArrayStack<>(ch.length);

            //push every element in char array to stack array
            for(int i = 0; i < ch.length - 1; i ++)
            {
                stackArr.push(ch[i]);
            }

            //Convert to postfix
        }

    }

    private static char[] convertToArray(String str)
    {
        char[] ch = new char[str.length()];
        for(int i = 0; i < str.length(); i ++)
        {
            ch[i] = str.charAt(i);
        }
        return ch;
    }

    public static boolean checkBalance(String expression)
    {
        StackInterface<Character> openDelimiterStack = new ArrayStack<>();
        int characterCount = expression.length();
        boolean isBalanced = true;
        int index = 0;
        char nextCharacter = ' ';
        while(isBalanced && (index < characterCount))
        {
            nextCharacter = expression.charAt(index);
            switch(nextCharacter)
            {
                case '(': case '[' : case '{':
                    openDelimiterStack.push(nextCharacter);
                    break;
                case ')' : case ']' : case '}' :
                    if(openDelimiterStack.isEmpty())
                    {
                        isBalanced = false;
                    }
                    else
                    {
                        char openDelimiter = openDelimiterStack.pop();
                        isBalanced = isPaired(openDelimiter, nextCharacter);
                    }
                    break;
                default: break;
            }
            index ++;
        }
        if(!openDelimiterStack.isEmpty())
        {
            isBalanced = false;
        }
        return isBalanced;
    }

    private static boolean isPaired(char open, char close)
    {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }

    private static String convertToPostfix(StackInterface<Character> infix)
    {
        StackInterface<Character> operatorStack = new ArrayStack<>();
        String postfix = "";
        while(!infix.isEmpty())
        {
            char nextCharacter = infix.pop();
            switch(nextCharacter)
            {
                case
            }
        }
    }
}
