package edu.miracosta.cs112.finalproject.finalproject;

import edu.miracosta.cs112.finalproject.finalproject.Pokemons.*;
import edu.miracosta.cs112.finalproject.finalproject.controllers.BattleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("battle-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        BattleController controller = fxmlLoader.getController();
        Player userPlayer = new Player(new Pokemon[]{
                new Chimchar(),
                new Blastoise(),
                new Treecko(),
                new Floatzel(),
                new Hooh(),
                new Kyogre()},
                new Potion[] {
                        new GreatPotion(3, 3),
                        new MysteriousPotion(2, 2)},
                6);
        BotPlayer botPlayer = new BotPlayer(new Pokemon[]{
                new Kyogre(),
                new Blastoise(),
                new Treecko(),
                new Floatzel(),
                new Hooh(),
                new Chimchar()},
                new Potion[] {
                        new GreatPotion(3, 3),
                        new MysteriousPotion(2, 2)},
                6);
        BattleManager.getInstance().init(userPlayer, botPlayer, stage);
        controller.initBattleScene();

        System.out.println(userPlayer.getPotions()[0].getPotionsLeft());
        stage.setTitle("Pokemon Battle!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}