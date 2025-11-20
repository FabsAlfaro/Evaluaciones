/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cliente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Arrays;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Cliente extends JFrame {

    private JTextArea txtLog;
    private JTextField txtMensaje;
    private JTextField txtIP;
    private JTextField txtPuerto;
    private JButton btnConectar;
    private JButton btnEnviar;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean conectado = false;

    public Cliente() {
        super("Cliente de Chat");

        setLayout(new BorderLayout());

        txtLog = new JTextArea();
        txtLog.setEditable(false);
        add(new JScrollPane(txtLog), BorderLayout.CENTER);

        // Panel superior (IP y puerto)
        JPanel panelArriba = new JPanel(new GridLayout(1, 5));
        panelArriba.add(new JLabel("IP:"));
        txtIP = new JTextField("127.0.0.1");
        panelArriba.add(txtIP);

        panelArriba.add(new JLabel("Puerto:"));
        txtPuerto = new JTextField("5000");
        panelArriba.add(txtPuerto);

        btnConectar = new JButton("Conectar");
        panelArriba.add(btnConectar);

        add(panelArriba, BorderLayout.NORTH);

        // Panel inferior (mensaje + enviar)
        JPanel panelAbajo = new JPanel(new BorderLayout());
        txtMensaje = new JTextField();
        btnEnviar = new JButton("Enviar");
        btnEnviar.setEnabled(false);

        panelAbajo.add(txtMensaje, BorderLayout.CENTER);
        panelAbajo.add(btnEnviar, BorderLayout.EAST);

        add(panelAbajo, BorderLayout.SOUTH);

        btnConectar.addActionListener(e -> conectar());
        btnEnviar.addActionListener(e -> enviarMensaje());

        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void conectar() {
        if (!conectado) {
            try {
                String ip = txtIP.getText();
                int puerto = Integer.parseInt(txtPuerto.getText());

                socket = new Socket(ip, puerto);
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                conectado = true;
                btnConectar.setText("Desconectar");
                btnEnviar.setEnabled(true);

                txtLog.append("Conectado al servidor\n");

                escuchar();

            } catch (Exception e) {
                txtLog.append("Error al conectar: " + e.getMessage() + "\n");
            }

        } else {
            desconectar();
        }
    }

    private void escuchar() {
        new Thread(() -> {
            try {
                while (true) {
                    byte[] buffer = new byte[1024];
                    int bytes = in.read(buffer);

                    if (bytes > 0) {
                        byte[] data = Arrays.copyOf(buffer, bytes);
                        String recibido = new String(data);
                        txtLog.append("Servidor: " + recibido + "\n");
                        txtLog.append("HEX: " + bytesToHex(data) + "\n\n");
                    }
                }
            } catch (Exception e) {
                txtLog.append("Desconectado del servidor\n");
            }
        }).start();
    }

    private void enviarMensaje() {
        try {
            if (conectado) {
                String msg = txtMensaje.getText();
                out.write(msg.getBytes());
                txtLog.append("Cliente: " + msg + "\n");
                txtMensaje.setText("");
            }
        } catch (IOException e) {
            txtLog.append("Error al enviar: " + e.getMessage() + "\n");
        }
    }

    private void desconectar() {
        try {
            conectado = false;
            btnConectar.setText("Conectar");
            btnEnviar.setEnabled(false);

            if (socket != null) socket.close();
            txtLog.append("Desconectado.\n");

        } catch (IOException e) {
            txtLog.append("Error al desconectar: " + e.getMessage() + "\n");
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) sb.append(String.format("%02X ", b));
        return sb.toString();
    }

    public static void main(String[] args) {
        new Cliente();
    }
}