package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import java.util.HashSet;
import java.util.Set;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;

public class WordCensor extends SocialChannelDecorator {

    private Set<String> censoredWords = new HashSet<>();

    public WordCensor(SocialChannel decoratedChannel) {
        // Ustaw dekorowany kanał
        this.setDecoratedSocialChannel(decoratedChannel);

        // Dodaj domyślne słowa do cenzury
        addDefaultCensoredWords();
    }

    private void addDefaultCensoredWords() {
        censoredWords.add("Bill"); // Dodaj słowo do cenzury
        // Możesz dodać więcej domyślnych słów, jeśli to konieczne
    }

    public void addCensoredWord(String word) {
        censoredWords.add(word);
    }

    @Override
    public void deliverMessage(String message) {
        // Zastąp zablokowane słowa
        for (String word : censoredWords) {
            message = message.replaceAll("(?i)" + word, "****");
        }
        // Przekaż wiadomość do dekorowanego kanału
        if (delegate != null) {
            delegate.deliverMessage(message);
        }
    }
}
