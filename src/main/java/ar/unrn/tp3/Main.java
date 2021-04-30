package ar.unrn.tp3;

import ar.unrn.tp3.bd.JDBCParticipante;
import ar.unrn.tp3.ui.UI;

import java.awt.*;

public class Main {

    public static void main(String [] args){

        EventQueue.invokeLater(() -> new UI(new JDBCParticipante()));

    }
}
