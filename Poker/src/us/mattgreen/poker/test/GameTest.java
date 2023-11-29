package us.mattgreen.poker.test;

import org.junit.Before;
import org.junit.Test;
import us.mattgreen.poker.Card;
import us.mattgreen.poker.Game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static us.mattgreen.poker.Face.*;
import static us.mattgreen.poker.Suit.*;

public class GameTest {
    private Card[] twoOfAKindHand;
    private Card[] threeOfAKindHand;
    private Card[] fullHouseHand;
    private Card[] hand;;

    @Before
    public void setUp() {
        twoOfAKindHand = new Card[]{new Card(JACK, CLUBS, 11), new Card(FIVE, CLUBS, 5), new Card(JACK, SPADES, 11)};
        threeOfAKindHand = new Card[]{new Card(JACK, CLUBS, 11), new Card(JACK, SPADES, 11), new Card(JACK, HEARTS, 11)};
        fullHouseHand = new Card[]{new Card(JACK, CLUBS, 11), new Card(JACK, SPADES, 11), new Card(FIVE, HEARTS, 5),
                new Card(FIVE, DIAMONDS, 5), new Card(JACK, DIAMONDS, 11)};
        hand = new Card[]{new Card(JACK, CLUBS, 11), new Card(FIVE, CLUBS, 5), new Card(TEN, CLUBS, 10),
                new Card(ACE, CLUBS, 1), new Card(SEVEN, CLUBS, 7)};
    }

    @Test
    public void twoOfAKindTest() {
        assertTrue("Two of a kind should have matched", Game.twoOfAKind(twoOfAKindHand));
        assertFalse("Two of a kind should not be in a three of a kind hand", Game.twoOfAKind(threeOfAKindHand));
    }

    @Test
    public void threeOfAKindTest() {
        assertTrue("Three of a kind should have matched", Game.threeOfAKind(threeOfAKindHand));
        assertFalse("Three of a kind should not be in a two of a kind hand", Game.threeOfAKind(twoOfAKindHand));
    }


    @Test
    public void fullHouseTest() {
        assertTrue("Full house should have matched", Game.fullHouse(fullHouseHand));
        assertFalse("Full house should not be in a two of a kind hand", Game.fullHouse(twoOfAKindHand));
    }

    @Test
    public void flushTest() {
        assertTrue("Flush should be true", Game.flush(hand));
        assertFalse("Two of a kind should not be in a flush hand", Game.twoOfAKind(hand));
    }


    @Test
    public void royalFlushTest() {
        Card[] royalFlushHand = new Card[]{new Card(TEN, CLUBS, 10), new Card(JACK, CLUBS, 11),
                new Card(QUEEN, CLUBS, 12), new Card(KING, CLUBS, 13), new Card(ACE, CLUBS, 14)};
        assertTrue("Royal Flush should be true", Game.royalFlush(royalFlushHand));
        assertFalse("Two of a kind should not be in a royal flush hand", Game.twoOfAKind(royalFlushHand));
    }

}