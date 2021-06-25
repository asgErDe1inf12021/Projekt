package project;


import project.save.api.Api;

public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Api.Api = new project.save.implementation.Api();
    }
}
