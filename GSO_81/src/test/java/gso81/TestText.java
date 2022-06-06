package gso81;

import org.junit.Test;
public class TestText {

    @Test
    public void doTestCensured() {
        System.out.println(Censured.class.getName() + ":");
        String censuredWord = "idler";
        String text = "idlerIdleR IdLeRis A IdLeR";
        Censured censured = new Censured(censuredWord);
        System.out.println("censure: " + censured.censure(text));
    }

    @Test
    public  void doTestTextAutomaticalllyEditor() {
        System.out.println(TextAnalyzer.class.getName() + ":");
        String[] text = new String[]{" $ a 4t gd", "Was it a car or a cat I saw?", "Madam, I’m Adam",
                "apple", "4 bd", "", null, "Алла",
                "привет Привет ages 12 through 14 (6-8 Grades) and high school from ages 15 through 19 (9-12 Grades).", "Eve"};
        String palindrome = "Was it a car or a cat I saw?";
        TextAnalyzer textEditor = new TextAnalyzer();
        for (String message : text) {
            System.out.println("isPalindrome: " + message + " " + textEditor.isPalindrome(message));
            System.out.println("capitalize: " + textEditor.capitalize(message));
            System.out.println("alphabetize: " + textEditor.alphabetize(message));
        }
    }
}
