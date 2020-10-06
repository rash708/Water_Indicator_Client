package com.company;
import com.company.Client;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) throws InterruptedException, RemoteException, AlreadyBoundException {
        Client client_socket = new Client();
        client_socket.init_client();
    }
}
