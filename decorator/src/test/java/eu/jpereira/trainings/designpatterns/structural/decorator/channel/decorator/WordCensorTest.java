package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;

public class WordCensorTest
{
@Test
    public void testCensorSingleWord() {
        SocialChannel channel = new MockSocialChannel();
        WordCensor censor = new WordCensor(channel);
        censor.addCensoredWord("badword");

        censor.deliverMessage("This is a badword!");
        assertEquals("This is a ****!", ((MockSocialChannel) channel).getLastMessage());
    }

    @Test
    public void testCensorMultipleWords() {
        SocialChannel channel = new MockSocialChannel();
        WordCensor censor = new WordCensor(channel);
        censor.addCensoredWord("bad");
        censor.addCensoredWord("ugly");

        censor.deliverMessage("This is a bad and ugly world!");
        assertEquals("This is a **** and **** world!", ((MockSocialChannel) channel).getLastMessage());
    }

    // Mock class for testing
    private class MockSocialChannel implements SocialChannel {
        private String lastMessage;

        @Override
        public void deliverMessage(String message) {
            this.lastMessage = message;
        }

        public String getLastMessage() {
            return lastMessage;
        }
    }
}