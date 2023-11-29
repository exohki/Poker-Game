package us.mattgreen.poker;

import org.junit.internal.Checks;
import us.mattgreen.poker.Card;

import java.util.Arrays;
import java.util.Comparator;

public class Game {

    /**
     * Checks if the hand contains two cards of the same rank (Two of a Kind).
     *
     * @param hand An array of cards representing a poker hand.
     * @return True if there is a pair in the hand, false otherwise.
     */
    public static boolean twoOfAKind(Card[] hand) {
        Arrays.sort(hand, Comparator.comparing(Card::getFace));
        int numberOfMatches = 0;

        for (int i = 0; i < hand.length - 1; ++i) {
            if (hand[i].getFace().equals(hand[i + 1].getFace())) {
                numberOfMatches++;
            }
        }

        return numberOfMatches == 1; // Check if exactly one pair exists in the hand
    }

    /**
     * Checks if the hand contains three cards of the same rank (Three of a Kind).
     *
     * @param hand An array of cards representing a poker hand.
     * @return True if there is a three-of-a-kind in the hand, false otherwise.
     */
    public static boolean threeOfAKind(Card[] hand) {
        Arrays.sort(hand, Comparator.comparing(Card::getFace));
        for (int i = 0; i < hand.length - 2; ++i) {
            if (hand[i].getFace().equals(hand[i + 1].getFace())
                    && hand[i + 1].getFace().equals(hand[i + 2].getFace())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the hand contains a pair and three cards of another rank (Full House).
     *
     * @param hand An array of cards representing a poker hand.
     * @return True if there is a full house in the hand, false otherwise.
     */
    public static boolean fullHouse(Card[] hand) {
        Arrays.sort(hand, Comparator.comparing(Card::getFace));
        if ((hand[0].getFace().equals(hand[1].getFace()) && hand[1].getFace().equals(hand[2].getFace())
                && hand[3].getFace().equals(hand[4].getFace()))
                || (hand[0].getFace().equals(hand[1].getFace()) && hand[2].getFace().equals(hand[3].getFace())
                && hand[3].getFace().equals(hand[4].getFace()))) {
            return true;
        }
        return false;
    }

    /**
     * Checks if all cards in the hand belong to the same suit (Flush).
     *
     * @param hand An array of cards representing a poker hand.
     * @return True if there is a flush in the hand, false otherwise.
     */
    public static boolean flush(Card[] hand) {
        Arrays.sort(hand, Comparator.comparing(Card::getSuit));

        for (int i = 0; i < hand.length - 1; i++) {
            if (!hand[i].getSuit().equals(hand[i + 1].getSuit())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if the hand contains the cards TEN, JACK, QUEEN, KING, and ACE of the same suit (Royal Flush).
     *
     * @param hand An array of cards representing a poker hand.
     * @return True if there is a royal flush in the hand, false otherwise.
     */
    public static boolean royalFlush(Card[] hand) {
        Arrays.sort(hand, Comparator.comparing(Card::getFace));
        return hand[0].getFace().equals(Face.TEN) &&
                hand[1].getFace().equals(Face.JACK) &&
                hand[2].getFace().equals(Face.QUEEN) &&
                hand[3].getFace().equals(Face.KING) &&
                hand[4].getFace().equals(Face.ACE) && flush(hand);
    }
}