package com.tudor.android.proxom;

public class ProxyThread extends Thread {
    static{
        System.loadLibrary("proxom");
    }

    private Thread runningThread = null;

    private String serverAddress = null;

    private native void runProxy(String ServerAddress);
    private native void stopProxy();


    public void startThread(String serverAddress){
        runningThread = new Thread(this);
        this.serverAddress = serverAddress;
        runningThread.start();
    }

    @Override
    public void run(){
        runProxy(serverAddress);
    }

    public void stopThread(){
        stopProxy();
    }

}
