package ar.unrn.tp3.ui;

import ar.unrn.tp3.modelo.Participante;
import ar.unrn.tp3.modelo.ParticipanteRepositorio;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UI extends JFrame {


    private final JTextField nombre;
    private final JTextField telefono;
    private final JTextField region;
    private final ParticipanteRepositorio participanteRepositorio;


    public UI(ParticipanteRepositorio participanteRepositorio) {

        this.participanteRepositorio = participanteRepositorio;

        setTitle("Add Participant");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout());

        contentPane.add(new JLabel("Nombre: "));
        this.nombre = new JTextField(10);
        contentPane.add(nombre);

        contentPane.add(new JLabel("Telefono: "));
        this.telefono = new JTextField(10);
        contentPane.add(telefono);

        contentPane.add(new JLabel("Region: "));
        this.region = new JTextField(10);
        contentPane.add(region);


        this.nombre.setText("");
        this.telefono.setText("");
        this.region.setText("China");


        JButton botonCargar = new JButton("Cargar");
        botonCargar.addActionListener(e -> onBotonCargar());
        contentPane.add(botonCargar);

        setContentPane(contentPane);
        contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pack();
        setVisible(true);
    }

    private void onBotonCargar() {
        Participante participante = new Participante(
                nombre.getText(), telefono.getText(), region.getText());
        participanteRepositorio.guardarParticipante(participante);

    }
}
