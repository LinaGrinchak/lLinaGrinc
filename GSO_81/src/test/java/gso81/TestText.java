package gso81;

public class TestText {
    public static void main(String[] args) throws Exception {
        doTestCensured();
        doTestTextAutomaticalllyEditor();
    }

    private static void doTestCensured() {
        System.out.println(Censured.class.getName() + ":");
        String censuredWord = "idler";
        String text = "idlerIdleR IdLeRis A IdLeR";
        Censured censured = new Censured(censuredWord);
        System.out.println("censure: " + censured.censure(text));
    }

    private static void doTestTextAutomaticalllyEditor() {
        System.out.println(TextAutomaticallyEditor.class.getName() + ":");
        String[] text = new String[]{" $ a 4t gd", "Was it a car or a cat I saw?", "Madam, I’m Adam",
                "apple", "4 bd", "", null, "Алла",
                "привет Привет ages 12 through 14 (6-8 Grades) and high school from ages 15 through 19 (9-12 Grades).", "Eve"};
        TextAutomaticallyEditor textEditor = new TextAutomaticallyEditor();
        for (String message : text) {
            System.out.println("isPalindrome: " + message + " " + textEditor.isPalindrome(message));
            System.out.println("capitalize: " + textEditor.capitalize(message));
            System.out.println("alphabetize: " + textEditor.alphabetize(message));
        }
    }
}
