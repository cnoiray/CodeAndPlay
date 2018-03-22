package fr.goat.service;

import java.util.ArrayList;
import java.util.List;

import fr.goat.bo.Board;
import fr.goat.bo.Items;
import fr.goat.bo.Player;
import fr.goat.bo.Position;
import fr.goat.bo.PositionPlayer;
import fr.goat.utils.MoveEnum;

public class GameMecanicsServices {

    public static List<MoveEnum> evaluateNextPosition(final Player pPlayerNous, final List<Items> listObstacle) {
        final List<MoveEnum> moveList = new ArrayList<>();
        for (final MoveEnum val : MoveEnum.values()) {
            moveList.add(val);
        }
        final PositionPlayer pos = pPlayerNous.getPosition();
        if (pos.getLane() == 0) {
            moveList.remove(MoveEnum.LEFT);
        }
        if (pos.getLane() == 4) {
            moveList.remove(MoveEnum.RIGHT);
        }
        for (final Items item : listObstacle) {
            final Position posObstacle = item.getPosition();

            if (item.getType().equals("O") || item.getType().equals("M")) {
                if (moveList.contains(MoveEnum.LEFT) && testPosition(posObstacle, new Position(pos.getLane() - 1, pos
                    .getRow() + 1))) {
                    moveList.remove(MoveEnum.LEFT);
                }
                if (testPosition(posObstacle, new Position(pos.getLane(), pos.getRow() + 1))) {
                    moveList.remove(MoveEnum.BRAKE);
                    moveList.remove(MoveEnum.FORWARD);
                    moveList.remove(MoveEnum.USE_BONUS);
                }
                if (moveList.contains(MoveEnum.FORWARD) && testPosition(posObstacle, new Position(pos.getLane(), pos
                    .getRow() + 2))) {
                    moveList.remove(MoveEnum.FORWARD);
                    moveList.remove(MoveEnum.USE_BONUS);
                }
                if (testPosition(posObstacle, new Position(pos.getLane() + 1, pos.getRow() + 1))) {
                    moveList.remove(MoveEnum.RIGHT);
                }
            }
        }

        if (moveList.contains(MoveEnum.FORWARD) && pPlayerNous.getInventory() != null && !pPlayerNous.getInventory()
            .isEmpty()) {
            moveList.add(0, MoveEnum.USE_BONUS);
        } else {
            moveList.remove(MoveEnum.USE_BONUS);
        }

        return moveList;
    }

    public static Board nextBoard(final Board board) {
        final List<Items> rockets = new ArrayList<>();
        for (final Items item : board.getItems()) {
            if (item.getType().equals("R")) {
                rockets.add(item);
            }
        }

        for (final Items currentRocket : rockets) {
            final Position position1 = new Position(currentRocket.getPosition().getLane() + 1, currentRocket
                .getPosition().getRow());
            final Position position2 = new Position(currentRocket.getPosition().getLane() + 2, currentRocket
                .getPosition().getRow());
            final Position position3 = new Position(currentRocket.getPosition().getLane() + 3, currentRocket
                .getPosition().getRow());
            final Position position4 = new Position(currentRocket.getPosition().getLane() + 4, currentRocket
                .getPosition().getRow());

            board.getItems().add(new Items(currentRocket.getType(), position1, currentRocket.getPlayer()));
            board.getItems().add(new Items(currentRocket.getType(), position2, currentRocket.getPlayer()));
            board.getItems().add(new Items(currentRocket.getType(), position3, currentRocket.getPlayer()));
            board.getItems().add(new Items(currentRocket.getType(), position4, currentRocket.getPlayer()));
        }

        return board;
    }

    private static boolean testPosition(final Position A, final Position B) {
        if (A.getLane() == B.getLane() && A.getRow() == B.getRow()) {
            return true;
        }
        return false;
    }

}