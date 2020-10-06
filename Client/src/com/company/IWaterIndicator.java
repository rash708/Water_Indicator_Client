package com.company;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IWaterIndicator extends Remote {
    float getColdWaterIndication() throws RemoteException;
    float getHotWaterIndication() throws RemoteException;
    String getWaterIndications() throws RemoteException;
}
