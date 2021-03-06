package ru.javarush.cryptoanalyzer.gamora.actions.basicactions.textVerification;

public class SpellingTextVerification implements TextVerification {
    @Override
    public boolean verify(String text) {
        System.out.println("spelling: ");
        System.out.println("wordsDoNotStartFromSignChars: " + wordsDoNotStartFromSignChars(text));
        System.out.println("noSignsAfterVowels: " + noSignsAfterVowels(text));
        System.out.println("noRulesOfLanguageViolated: " + noRulesOfLanguageViolated(text));
        System.out.println("noSignsBetweenLetters: " + noSignsBetweenLetters(text));
        return wordsDoNotStartFromSignChars(text) && noSignsAfterVowels(text) && noRulesOfLanguageViolated(text) && noSignsBetweenLetters(text);
    }

    /*
     * Words cannot start from characters "ь", "ъ" in Russian
     */
    private boolean wordsDoNotStartFromSignChars(String text) {
        String regEx = "\\b[ьъ]";
        return noMatch(text, regEx);
    }

    /*
     * Vowels cannot be followed by "ь", "ъ" in Russian
     */
    private boolean noSignsAfterVowels(String text) {
        String regEx = "[аеёийоуьыъэюя][ьъ]";
        return noMatch(text, regEx);
    }

    /*
     * Some basic rules of russian grammar
     */
    private boolean noRulesOfLanguageViolated(String text) {
        String regEx = "[жш][ыя]|[чщ][яю]";
        return noMatch(text, regEx);
    }

    /*
     * Some basic rules of russian grammar
     */
    private boolean noSignsBetweenLetters(String text) {
        String regEx = "[а-я][.,”:!?][а-я]";
        return noMatch(text, regEx);
    }
}
