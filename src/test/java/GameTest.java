import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GameTest {

    private Deck deck;
    private Game game1;
    private Player player1;
    private Player player2;

    @Before
    public void before() {
        deck = new Deck();
        player1 = new Player("Andy", false);
        player2 = new Player("Steve", true);
        game1 = new Game();

    }

    @Test
    public void canDealCardToPlayer() {
        game1.dealCardToPlayer(deck, player1);
        assertEquals(1, player1.getHandCount());
    }
    @Test
    public void canDealTwoCardsToPlayer() {
        game1.dealCardToPlayer(deck, player1);
        game1.dealCardToPlayer(deck, player1);
        assertEquals(2, player1.getHandCount());
    }
    @Test
    public void canReceiveFourCardsFromDeck() {
        assertEquals(4, game1.receiveFourCardsFromDeck(deck).size());
    }

    @Test
    public void canDealTwoCardsToEachPlayer() {
        game1.giveTwoCardsToEachPlayer(deck, player1, player2);
        assertEquals(2, player1.getHandCount());
        assertEquals(2, player2.getHandCount());
    }

    @Test
    public void canGetWinnerAccurately() {
        Card card1 = new Card(SuitType.CLUBS, RankType.FIVE);
        Card card2 = new Card(SuitType.HEARTS, RankType.SIX);
        Card card3 = new Card(SuitType.DIAMONDS, RankType.NINE);
        Card card4 = new Card(SuitType.SPADES, RankType.TEN);
        player1.addCardToHand(card1);
        player1.addCardToHand(card2);
        player2.addCardToHand(card3);
        player2.addCardToHand(card4);
        assertEquals("player 2 wins", game1.winnerCheck(deck, player1, player2));
    }

    @Test
    public void canGetWinnerAfterTwist() {
        Card card1 = new Card(SuitType.CLUBS, RankType.FIVE);
        Card card2 = new Card(SuitType.HEARTS, RankType.SIX);
        Card card3 = new Card(SuitType.DIAMONDS, RankType.NINE);
        Card card4 = new Card(SuitType.SPADES, RankType.FIVE);
        Card card5 = new Card(SuitType.HEARTS, RankType.FIVE);
        player1.addCardToHand(card1);
        player1.addCardToHand(card2);
        player2.addCardToHand(card3);
        player2.addCardToHand(card4);
        player1.twist(card5);
        assertEquals("player 1 wins", game1.winnerCheck(deck, player1, player2));
    }


//    @Test
//    public void canGetValueOfPlayersHand {
//        assertEquals(15, player1.get);
//    }

}
