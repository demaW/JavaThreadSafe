package com.epam.grow;


import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import java.util.ArrayList;


public class AppTest {
    static ArrayList<String> countries = new ArrayList<>();
    private static Object lock1 = new Object();

    private static final String UKRAINE_IP = "176.104.190.179";
    private static final String USA_IP = "216.58.214.238";

    @Test
    public void jerseyUATest() {
        System.out.println("In method 1");
     /*   Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            addToCollection(String.valueOf(random.nextInt()));

        }*/
        for (int i = 0; i < 100; i++) {
            String respString = ClientBuilder.newClient().target("http://api.konvert.me")
                    .path("ip-country/" + UKRAINE_IP).request().get(String.class);
            addToCollection(respString);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Exiting method 1");

    }

    @Test
    public void jerseyUSTest() {
        System.out.println("In method 2");
      /*  Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            addToCollection(String.valueOf(random.nextInt()));
        }*/

        for (int i = 0; i < 100; i++) {
            String respString = ClientBuilder.newClient().target("http://api.konvert.me")
                    .path("ip-country/" + USA_IP).request().get(String.class);
            addToCollection(respString);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Exiting method 2");

    }

    public void addToCollection(String entry) {
        synchronized (lock1) {
            countries.add(entry);
        }
    }


}
