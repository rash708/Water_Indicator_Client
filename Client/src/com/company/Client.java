package com.company;
import java.io.*;
import java.net.Socket;
import java.util.Random;

public class Client {

    private static Socket clientSocket;
    private static BufferedReader in;       // Socket read stream
    private static BufferedWriter out;      // Socket write stream


    public static void init_client() {
        try {
            try {
                clientSocket = new Socket("localhost", 9001); // этой строкой мы запрашиваем

                // Read income connection
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // Write to income connection
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                // Message - water indications
                String message = make_water_message();

                // Send message to server
                out.write(message);
                out.newLine();
                out.flush();

                // Waiting server answer
                String serverAnswer = in.readLine();
                System.out.println(serverAnswer);
            } finally {
                // Closing socket
                System.out.println("Client was closed");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static int get_cold_water_indication() {
        final Random random = new Random();
        return random.nextInt(100000);
    }

    public static int get_hot_water_indication() {
        final Random random = new Random();
        return random.nextInt(20000);
    }

    public static String make_water_message() {
        return new String(
                String.valueOf(get_cold_water_indication())
                + " | "
                + String.valueOf(get_hot_water_indication())
        );
    }
}
