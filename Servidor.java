/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.servidor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Arrays;

public class Servidor extends JFrame {

    private JTextArea txtLog;
    private JTextField txtMensaje;
    private JButton btnEnviar;

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;

    public Servidor() {
        super("Servidor de Chat");

        setLayout(new BorderLayout());

        txtLog = new JTextArea();
        txtLog.setEditable(false);
        add(new JScrollPane(txtLog), BorderLayout.CENTER);

        JPanel panelAbajo = new JPanel(new BorderLayout());
        txtMensaje = new JTextField();
        btnEnviar = new JButton("Enviar");

        panelAbajo.add(txtMensaje, BorderLayout.CENTER);
        panelAbajo.add(btnEnviar, BorderLayout.EAST);
        add(panelAbajo, BorderLayout.SOUTH);

        btnEnviar.addActionListener(e -> enviarMensaje());

        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        iniciarServidor();
    }

    private void iniciarServidor() {
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(5000);
                txtLog.append("Servidor escuchando en puerto 5000...\n");

                clientSocket = serverSocket.accept();
                txtLog.append("Cliente conectado: " + clientSocket.getInetAddress() + "\n");

                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());

                while (true) {
                    byte[] buffer = new byte[1024];
                    int bytes = in.read(buffer);

                    if (bytes > 0) {
                        byte[] data = Arrays.copyOf(buffer, bytes);
                        String recibido = new String(data);
                        txtLog.append("Cliente: " + recibido + "\n");
                        txtLog.append("HEX: " + bytesToHex(data) + "\n\n");
                    }
                }

            } catch (Exception e) {
                txtLog.append("Error: " + e.getMessage() + "\n");
            }
        }).start();
    }

    private void enviarMensaje() {
        try {
            String msg = txtMensaje.getText();
            if (out != null) {
                out.write(msg.getBytes());
                txtLog.append("Servidor: " + msg + "\n");
                txtMensaje.setText("");
            }
        } catch (IOException e) {
            txtLog.append("Error al enviar: " + e.getMessage() + "\n");
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) sb.append(String.format("%02X ", b));
        return sb.toString();
    }

    public static void main(String[] args) {
        new Servidor();
    }
}
