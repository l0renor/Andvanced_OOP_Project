package ludo.configuration.four_players;

import bunny_hop.configuration.four_players.FourPlayerLayout;
import bunny_hop.logic.BunnyHopGameState;
import framework.configuration.GameMode;
import framework.data.Board;
import framework.logic.GameState;
import framework.logic.Player;
import framework.logic.Rule;
import ludo.logic.LudoGameState;
import ludo.logic.rule.ChoosePawnRule;
import ludo.logic.rule.RollDiceRule;

import java.util.ArrayList;

public class FourPlayerLudoGameMode implements GameMode {
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Rule> rules = new ArrayList<>();
    private Board board = new FourPlayerLudoLayout().createLayout();
    private GameState gameState = new LudoGameState();

    public FourPlayerLudoGameMode() {
        players.add(new Player("Green"));
        players.add(new Player("Red"));
        players.add(new Player("Blue"));
        players.add(new Player("Yellow"));
        rules.add(new RollDiceRule());
        rules.add(new ChoosePawnRule());

    }

    @Override
    public ArrayList<Player> getPlayers() {
        return players;
    }

    @Override
    public ArrayList<Rule> getRules() {
        return rules;
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public GameState getGameState() {
        return gameState;
    }

    @Override
    public String getName() {
        return "Ludo";
    }
}