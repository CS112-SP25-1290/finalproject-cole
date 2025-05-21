package edu.miracosta.cs112.finalproject.finalproject;

import edu.miracosta.cs112.finalproject.finalproject.controllers.AttackController;
import edu.miracosta.cs112.finalproject.finalproject.controllers.BattleController;
import edu.miracosta.cs112.finalproject.finalproject.controllers.PokemonController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

/**
 * Contains the core logic for the battle system.
 * <p>
 * This class manages the battle between the user and the bot, maintaining their respective
 * {@code Player} objects and providing methods for healing, attacking, updating visuals, and more.
 * </p>
 *
 * @author Cole Mengelberg
 * @version 1.0
 * @since 2025-05-16
 */
public class BattleManager {
    private static final BattleManager instance = new BattleManager();
    private Player userPlayer;
    private BotPlayer botPlayer;
    private Stage primaryStage;

    /**
     * Constructs a new {@code BattleManager} instance.
     */
    public BattleManager() {
    }

    /**
     * Returns single instance of {@code BattleManager}.
     * <p>
     * This method is used to access the instance of the {@code BattleManager} class.
     * </p>
     *
     * @return the singleton instance of {@code BattleManager}
     */
    public static BattleManager getInstance() {
        return instance;
    }

    /**
     * Initializes the {@code BattleManager} with the given user player, bot player, and primary stage.
     *
     * @param userPlayer  the player controlled by the user
     * @param botPlayer   the bot
     * @param stage       the primary stage where battle scenes will be displayed
     */
    public void init(Player userPlayer, BotPlayer botPlayer, Stage stage) {
        this.userPlayer = userPlayer;
        this.botPlayer = botPlayer;
        this.primaryStage = stage;
    }

    /**
     * Returns the user controlled player in the battle.
     *
     * @return the {@code Player} object representing the user
     */
    public Player getUserPlayer() {
        return this.userPlayer;
    }

    /**
     * Returns the bot controlled in the battle.
     *
     * @return the {@code Player} object representing the bot
     */
    public BotPlayer getBotPlayer() {
        return this.botPlayer;
    }

    /**
     * Returns the primary stage used for displaying battle scenes.
     *
     * @return the JavaFX {@code Stage} representing the main game window
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Executes an attack from the user's current Pokémon on the bot's current Pokémon.
     * <p>
     * Retrieves the selected {@code AttackMove} by index, performs the attack, and updates
     * the bot's HP bar. If the bot's Pokémon is defeated, it attempts to switch to another
     * one. If no Pokémon are left, the game ends.
     * </p>
     *
     * @param index the index of the move to be used from the user's Pokémon move set
     */
    public void playerAttack(int index) {
        Pokemon userPokemon = this.userPlayer.getCurrentPokemon();
        AttackMove move = userPokemon.getMoveSet()[index];
        Pokemon botPokemon = this.botPlayer.getCurrentPokemon();

        userPokemon.attack(move, botPokemon);
        try {
            this.updateBotHPBar();
        } catch (Exception e) {
            System.out.println();
        }
        if (!checkAlive(botPokemon)) {
            try {
                botPlayer.switchPokemon();
            } catch (OutOfPokemons oop) {
                System.out.println(oop.getMessage());
                System.exit(0);
            }
        } else {
            botTurn();
        }
    }

    /**
     * Heals the user's current Pokémon using the specified potion by index.
     * <p>
     * After healing, update the bot's HP bar, and then
     * initiates the bot's turn.
     * </p>
     *
     * @param index the index of the potion to use from the user's inventory
     */
    public void playerHeal(int index) {
        this.userPlayer.healPokemon(index);
        try {
            this.updateBotHPBar();
        } catch (Exception e) {
            System.out.println();
        }
        botTurn();
    }

    /**
     * Handles the bot player's turn during the battle. The bot will either:
     * <ul>
     *     <li>Heal its Pokémon if its health is below 20%,</li>
     *     <li>Attack the user’s Pokémon if its health is above 20%.</li>
     * </ul>
     * <p>
     * If the user’s Pokémon is knocked out after the bot’s attack, it will attempt to switch to another Pokémon.
     * If the user has no more Pokémon, an exception is thrown and the game ends.
     * </p>
     *
     * @throws OutOfPokemons if the user has no more Pokémon to switch to.
     */
    public void botTurn() {
        Pokemon userPokemon = this.userPlayer.getCurrentPokemon();
        Pokemon botPokemon = this.botPlayer.getCurrentPokemon();

        float percentHealth = (float)botPokemon.getHp() / botPokemon.getMaxHP();
        if(percentHealth < 0.2) {
            botPlayer.healPokemon();
            try {
                this.updateBotHPBar();
            } catch (Exception e) {
                System.out.println();
            }
        } else {
            botPlayer.commandAttack(userPokemon);
            try {

            if(!checkAlive(userPokemon)) {
                if(this.userPlayer.getPokemonCount() > 1) {
                    this.userPlayer.setPokemonCount(this.userPlayer.getPokemonCount() - 1);
                    try {
                        showPokemonSwitchScene();
                    } catch (Exception e) {
                        System.out.println();
                    }
                } else {
                    throw new OutOfPokemons("Player has no more Pokemons!");
                }
            }
            } catch (OutOfPokemons oop) {
                System.out.println(oop.getMessage());
                System.exit(0);
            }

        }
    }

    /**
     * Checks if a given Pokémon's HP is greater than 0.
     * <p>
     * This method returns {@code true} if the Pokémon's HP is greater than 0.
     * It returns {@code false} if the Pokémon's HP is 0 or less.
     * </p>
     *
     * @param pokemon The Pokémon whose status is being checked.
     * @return {@code true} if the Pokémon is alive (HP > 0), otherwise {@code false}.
     */
    public boolean checkAlive(Pokemon pokemon) {
        if(pokemon.getHp() > 0) {
            return true;
        } return false;
    }

    public void updateBotHPBar() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/battle-scene.fxml"));
        Parent root = loader.load();

        BattleController controller = loader.getController();
        controller.updateBotHPBar();
    }

    /**
     * Updates the bot player's health bar in the battle scene by loading the FXML view and invoking the controller's update method.
     *
     * @throws IOException If an error occurs while loading the FXML file or accessing the controller.
     */
    private void showPokemonSwitchScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/pokemon-scene.fxml"));
        Parent root = loader.load();

        PokemonController controller = loader.getController();
        controller.initPokemonScene();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * Returns a string representation of the current state of the BattleManager object.
    *
     * @return A string representation of the BattleManagers user player and bot player details.
     */
    @Override
    public String toString() {
        return "BattleManager: " +
                "userPlayer=" + userPlayer +
                ", botPlayer=" + botPlayer;
    }

    /**
     * Compares this BattleManager object to another object to check equality.
     *
     * @param obj The object to compare with this BattleManager instance.
     * @return {@code true} if the specified object is equal to this BattleManager, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        BattleManager other = (BattleManager) obj;

        return
                (userPlayer != null && userPlayer.equals(other.userPlayer)) &&
                (botPlayer != null && botPlayer.equals(other.botPlayer));
    }
}
