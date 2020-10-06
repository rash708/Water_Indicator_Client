package com.company;
import java.io.*;
import java.net.Socket;
import java.util.Random;

public class Client {

    public static void init_client() {
        try {
            try {
                clientSocket = new Socket("localhost", 9001); // этой строкой мы запрашиваем

                // Read income connection
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // Write to income connection
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                String command = in.readLine();

                String water_indication = new String();
                if(command.equals(command_from_server[0])) {
                    water_indication = Float.toString(get_cold_water_indication());
                }

                else if(command.equals(command_from_server[1])) {
                    water_indication = Float.toString(get_hot_water_indication());
                }

                else if(command.equals(command_from_server[2])) {
                    water_indication = get_water_indications();
                }

                // Send message to server
                out.write(water_indication);
                out.newLine();
                out.flush();

            } finally {
                // Closing socket
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }


    public static float get_cold_water_indication() {
        final Random randomizer = new Random();
        int min = 0;
        int max = 100000;
        return min + randomizer.nextFloat() * (max - min);
    }

    public static float get_hot_water_indication() {
        final Random randomizer = new Random();
        int min = 0;
        int max = 20000;
        return min + randomizer.nextFloat() * (max - min);
    }

    public static String get_water_indications() {
        return new String(
                String.valueOf(get_cold_water_indication())
                + " | "
                + String.valueOf(get_hot_water_indication())
        );
    }

    // Members
    private static Socket clientSocket;
    private static BufferedReader in;       // Socket read stream
    private static BufferedWriter out;      // Socket write stream

    private static String[] command_from_server =
            {
                    "rcw", // Recieve cold water
                    "rhw", // Recieve hot water
                    "rwi"  // Recieve water indications
            };
}
