package project;


import project.config.api.Api;

public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Api.Api = new project.config.implementation.Api();
    }
}
