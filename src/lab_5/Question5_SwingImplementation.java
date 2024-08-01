package lab_5;
/*
 * WAP to implement a swing application to perform WHOIS Lookup. (whois.internic.net port 43)
 *
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class Question5_SwingImplementation extends JFrame {
    private final JPanel panel1;
    private final JButton submit;
    private final JTextField address;
    private final JTextArea textArea;

    public Question5_SwingImplementation() {
        setTitle("Swing WHOIS Lookup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        address = new JTextField();
        submit = new JButton("Submit");
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Adding the address field
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel1.add(address, gbc);

        // Adding the submit button
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel1.add(submit, gbc);

        // Adding the text area with scroll pane
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(scrollPane, gbc);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String domain = address.getText();
                performWhoisLookup(domain);
            }
        });

        add(panel1);
        setVisible(true);
    }

    private void performWhoisLookup(String domain) {
        textArea.setText("Performing WHOIS lookup for " + domain + "...\n");
        try (Socket socket = new Socket("whois.internic.net", 43);
             Writer writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"))) {

            writer.write(domain + "\r\n");
            writer.flush();

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }

            textArea.append(response.toString());
        } catch (Exception ex) {
            textArea.append("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {

        new Question5_SwingImplementation();
    }
}
