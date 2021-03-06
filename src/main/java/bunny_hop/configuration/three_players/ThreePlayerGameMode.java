package bunny_hop.configuration.three_players;

import bunny_hop.accessories.Bunny;
import bunny_hop.logic.BunnyHopAccessoryType;
import bunny_hop.logic.BunnyHopGameState;
import bunny_hop.logic.BunnyHopPlayer;
import bunny_hop.logic.rule.CardMoveRule;
import bunny_hop.logic.rule.DrawCardRule;
import framework.configuration.GameMode;
import framework.data.Board;
import framework.data.accessories.Accessory;
import framework.logic.GameState;
import framework.logic.Player;
import framework.logic.Rule;

import java.util.ArrayList;

public class ThreePlayerGameMode implements GameMode {

    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Rule> rules = new ArrayList<>();
    private Board board = new ThreePlayerLayout().createLayout();
    private BunnyHopGameState gameState = new BunnyHopGameState();

    public ThreePlayerGameMode() {
        players.add(new BunnyHopPlayer("Pink"));
        players.add(new BunnyHopPlayer("Red"));
        players.add(new BunnyHopPlayer("Purple"));
        rules.add(new DrawCardRule());
        rules.add(new CardMoveRule());
        gameState.setActivePlayer(players.get(0));
        assignBunnyToPlayer(Bunny.BunnyColor.PINK, players.get(0));
        assignBunnyToPlayer(Bunny.BunnyColor.RED, players.get(1));
        assignBunnyToPlayer(Bunny.BunnyColor.PURPLE, players.get(2));
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
        return "Bunny Hop | 3 Players";
    }

    @Override
    public boolean isFinished() {
        boolean result = true;
        for (Player p : players) {
            result = result && p.isOut();
            if (!gameState.getLeaderboard().contains(p) && p.isOut()) {
                gameState.getLeaderboard().add(p);
            }
        }
        return result;
    }

    private void assignBunnyToPlayer(Bunny.BunnyColor bunnyColor, Player player) {
        for (Accessory accessory : board.getAccessories(2, BunnyHopAccessoryType.BUNNY)) {
            Bunny bunny = (Bunny) accessory;
            if (bunny.getBunnyColor() == bunnyColor) {
                bunny.setPlayer(player);
            }
        }
    }

}
