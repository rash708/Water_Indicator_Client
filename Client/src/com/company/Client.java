package com.company;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Client {
    public static final String UNIQUE_BINDING_NAME = "client.waterIndicator";

    public static void init_client() throws RemoteException, AlreadyBoundException, InterruptedException {

        final WaterIndicator waterIndicator = new WaterIndicator();
        final Registry registry = LocateRegistry.createRegistry(9001);

        Remote stub = UnicastRemoteObject.exportObject(waterIndicator, 0);
        registry.bind(UNIQUE_BINDING_NAME, stub);

        Thread.sleep(Integer.MAX_VALUE);
    }
}
