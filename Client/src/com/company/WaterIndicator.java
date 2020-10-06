package com.company;
import java.rmi.RemoteException;
import java.util.Random;

public class WaterIndicator implements IWaterIndicator {
    @Override
    public float getColdWaterIndication() throws RemoteException {
        final Random randomizer = new Random();
        int min = 0;
        int max = coldMaxRange;
        return min + randomizer.nextFloat() * (max - min);
    }

    @Override
    public float getHotWaterIndication() throws RemoteException {
        final Random randomizer = new Random();
        int min = 0;
        int max = hotMaxRange;
        return min + randomizer.nextFloat() * (max - min);
    }

    @Override
    public String getWaterIndications() throws RemoteException {
        return new String(
                String.valueOf(getColdWaterIndication())
                        + " | "
                        + String.valueOf(getHotWaterIndication())
        );
    }

    private final int hotMaxRange = 20000;
    private final int coldMaxRange = 100000;
}
