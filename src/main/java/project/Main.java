package project;


import project.GUI.main_menu.menu;
import project.config.api.Api;

public class Main {
    /**
     *
     * @param args
     */
    public static <M> void main(String[] args, menu M) {
        Api.Api = new project.config.implementation.Api();

    }
}
