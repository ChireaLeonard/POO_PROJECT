package org.george;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interface extends JFrame {

    private ArrayList<Payment> listaPlati;
    private ArrayList<TRANSFER> listaTransferuri;

    private JTextField txtValoare;
    private JTextArea txtRezultate;

    public Interface(ArrayList<Payment> plati, ArrayList<TRANSFER> transferuri) {
        this.listaPlati = plati;
        this.listaTransferuri = transferuri;


        setTitle("Interface POO");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        setLayout(new BorderLayout());


        JPanel panelSus = new JPanel();
        panelSus.setLayout(new FlowLayout());

        panelSus.add(new JLabel("Numbers / length of ids"));
        txtValoare = new JTextField(10);
        panelSus.add(txtValoare);

        JButton btnFrauda = new JButton("Verifying id frauds (<5)");
        JButton btnSuma = new JButton("Filter after minimal sum of money ");

        panelSus.add(btnFrauda);
        panelSus.add(btnSuma);

        add(panelSus, BorderLayout.NORTH);


        txtRezultate = new JTextArea();
        txtRezultate.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtRezultate);
        add(scrollPane, BorderLayout.CENTER);


        btnFrauda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtRezultate.setText("");
                txtRezultate.append("Verifying Fraud attemps ");

                boolean gasit = false;
                for (Payment p : listaPlati) {
                    if (p.getIplata() != null && p.getIplata().length() < 5) {
                        txtRezultate.append("[SUSPECT] Payment: " + p.toString() + "\n");
                        gasit = true;
                    }
                }
                for (TRANSFER t : listaTransferuri) {
                    if (t.getIdT() != null && t.getIdT().length() < 5) {
                        txtRezultate.append("[SUSPECT] TRANSFER: " + t.toString() + "\n");
                        gasit = true;
                    }
                }
                if (!gasit) {
                    txtRezultate.append("No issues  detected, all good .\n");
                }
            }
        });


        btnSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double sumaMinima = Double.parseDouble(txtValoare.getText());
                    if (sumaMinima < 0) {
                        JOptionPane.showMessageDialog(null, "Sum cannot be negative !", "Eror", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    txtRezultate.setText("");
                    txtRezultate.append("=== Rezults filtred by sums that are higher then this  >= " + sumaMinima + " ===\n");

                    boolean gasit = false;
                    for (Payment p : listaPlati) {
                        if (p.getSuma1() >= sumaMinima) {
                            txtRezultate.append("Payments: " + p.toString() + "\n");
                            gasit = true;
                        }
                    }
                    for (TRANSFER t : listaTransferuri) {
                        if (t.getSuma2() >= sumaMinima) {
                            txtRezultate.append("TRANSFER: " + t.toString() + "\n");
                            gasit = true;
                        }
                    }
                    if (!gasit) {
                        txtRezultate.append("No sums found .\n");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number !", "Formating  error!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
