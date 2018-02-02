package com.lulz_bot.Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Receiver extends Thread {
    private Socket socket;
    private int userID;

    Receiver(Socket socket, int userID) {
        this.socket = socket;
        this.userID = userID;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line;
            while(true) {
                line = in.readLine(); // ожидаем пока клиент пришлет строку текста.
                if (line.equals("exit"))
                    break;
                System.out.println("The dumb client just sent me this line : " + line);
                System.out.println("I'm sending it back...");
                out.println(line); // отсылаем клиенту обратно ту самую строку текста.
                System.out.println("Waiting for the next line...");
                System.out.println();
            }
        } catch(Exception x) { x.printStackTrace(); }
    }
}