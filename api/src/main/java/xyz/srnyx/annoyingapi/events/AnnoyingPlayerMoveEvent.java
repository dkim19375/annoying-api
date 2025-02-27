package xyz.srnyx.annoyingapi.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerMoveEvent;

import org.jetbrains.annotations.NotNull;


/**
 * A more advanced version of {@link PlayerMoveEvent}
 */
public class AnnoyingPlayerMoveEvent extends PlayerMoveEvent {
    /**
     * The {@link HandlerList} for this event.
     */
    @NotNull private static final HandlerList HANDLERS = new HandlerList();

    /**
     * The {@link MovementType type of movement} that the player has done
     */
    @NotNull private final MovementType movementType;

    /**
     * Constructs a new {@link AnnoyingPlayerMoveEvent}
     *
     * @param   player  {@link #getPlayer()}
     * @param   from    {@link #getFrom()}
     * @param   to      {@link #getTo()}
     */
    public AnnoyingPlayerMoveEvent(@NotNull Player player, @NotNull Location from, @NotNull Location to) {
        super(player, from, to);

        // movementType
        if (from.getYaw() == to.getYaw() && from.getPitch() == to.getPitch()) {
            movementType = MovementType.TRANSLATION;
            return;
        }
        if (from.getX() == to.getX() && from.getY() == to.getY() && from.getZ() == to.getZ()) {
            movementType = MovementType.ROTATION;
            return;
        }
        movementType = MovementType.BOTH;
    }

    /**
     * Constructs a new {@link AnnoyingPlayerMoveEvent} from a {@link PlayerMoveEvent}
     *
     * @param   event   the {@link PlayerMoveEvent} to construct from
     */
    public AnnoyingPlayerMoveEvent(@NotNull PlayerMoveEvent event) {
        this(event.getPlayer(), event.getFrom(), event.getTo());
    }

    /**
     * Returns the {@link HandlerList} for this event
     *
     * @return  {@link #HANDLERS}
     */
    @NotNull
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    /**
     * Returns the {@link HandlerList} for this event
     *
     * @return  {@link #HANDLERS}
     */
    @Override @NotNull
    public HandlerList getHandlers() {
        return getHandlerList();
    }

    /**
     * Returns the {@link MovementType type of movement} that the player has done
     *
     * @return  {@link #movementType}
     */
    @NotNull
    public MovementType getMovementType() {
        return movementType;
    }

    /**
     * The type of movement that the player has done
     */
    public enum MovementType {
        /**
         * The player has changed their position (X, Y, or Z)
         */
        TRANSLATION,
        /**
         * The player has changed their rotation (yaw or pitch)
         */
        ROTATION,
        /**
         * The player has changed both their position (X, Y, or Z) and their rotation (yaw or pitch)
         */
        BOTH
    }
}
