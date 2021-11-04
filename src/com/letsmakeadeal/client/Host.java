package com.letsmakeadeal.client;


public class Host {




    public void execute(){
        greetUser();
        startGame(); //initialize user with default reward

        displayStage(); //update of rewards done here
        makeAOffer();
        showResults();

        endGame();


    }
}
