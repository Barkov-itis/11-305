package ru.itis.crocodile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

public class Handler extends Thread {
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    private static final Set<PrintWriter> writers = new HashSet<>();
    private static final Set<String> playerNames = new HashSet<>();

    public Handler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            writers.add(writer);

            String playerName = "user" + new Random().nextInt(1000);
            while (playerNames.contains(playerName)) {
                playerName = "user" + new Random().nextInt(1000);
            }
            playerNames.add(playerName);

            broadcast(playerName + " joined the game", writer);

            while (true) {
                String message = reader.readLine();
                if (message == null) {
                    return;
                }
                System.out.println("Received: " + message);

                if (message.startsWith("DRAW:")) {
                    broadcast(message, writer);
                } else if (message.equals("CLEAR_CANVAS")) {
                    clearCanvasForAll();
                } else {
                    broadcast(message, null);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writers.remove(writer);
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void broadcast(String message, PrintWriter sender) {
        for (PrintWriter writer : writers) {
            if (writer != sender) {
                writer.println(message);
            }
        }
        // ?!
//        if (sender != null) {
//            sender.println(message);
//        }
    }

    private void clearCanvasForAll() {
        for (PrintWriter writer : writers) {
            writer.println("CLEAR_CANVAS");
        }
    }
}
