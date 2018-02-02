package com.lulz_bot.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {
    private ArrayList<Socket> connectedUsers;
    private int port;

    Server() {
        this.connectedUsers = new ArrayList<>();
    }

    @Override
    public void run() {
        int connectedCount = 0;
        try {
            ServerSocket ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
            while (true) {
                Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
                connectedUsers.add(socket);
                connectedCount++;
                System.out.println("New client is connected. [" + connectedCount + "]");
                new Receiver(socket,connectedCount).start();
            }
        } catch(Exception x) { x.printStackTrace(); }
    }

    public static void main(String[] args) throws IOException {
        new Server().start();
    }
}
