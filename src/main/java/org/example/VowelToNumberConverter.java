package org.example;

public class VowelToNumberConverter {
    public static String replaceVowelsWithNumbers(String inputword) {
        StringBuilder convertedWord = new StringBuilder();
        for (char currentChar : inputword.toCharArray()) {
            char upperChar = Character.toUpperCase(currentChar);
            switch (upperChar) {
                case 'A':
                    convertedWord.append('1');
                    break;
                case 'E':
                    convertedWord.append('3');
                    break;
                case 'I':
                    convertedWord.append('5');
                    break;
                case 'O':
                    convertedWord.append('7');
                    break;
                case 'U':
                    convertedWord.append('9');
                    break;
                default:
                    convertedWord.append(currentChar);
                    break;
            }
        }
        return convertedWord.toString();
    }

    public static String convertVowelsToNumbers(String inputWord) {
        StringBuilder convertedWord = new StringBuilder();
        for(char currentChar : inputWord.toCharArray()){
            char upperChar = Character.toUpperCase(currentChar);
            switch (upperChar){
                case 'A':
                    convertedWord.append('1');
                    break;
                case 'E':
                    convertedWord.append('3');
                    break;
                case 'I':
                    convertedWord.append('5');
                    break;
                case 'O':
                    convertedWord.append('7');
                    break;
                case 'U':
                    convertedWord.append('9');
                    break;
                    default:
                    convertedWord.append(currentChar);
                    break;
            }
        }
        return convertedWord.toString();
    }

    public static void main(String[] args) {
        String inputWord = "Welcome";
        String outputWord = replaceVowelsWithNumbers(inputWord);
        System.out.println("Input : " + inputWord);
        System.out.println("Output : " + outputWord);
    }

}