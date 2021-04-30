package ar.unrn.tp3.bd;

import ar.unrn.tp3.modelo.Participante;
import ar.unrn.tp3.modelo.ParticipanteRepositorio;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCParticipante implements ParticipanteRepositorio {
    @Override
    public void guardarParticipante(Participante participante) {
        JDBCConexion conexion = new JDBCConexion();

        try {

            PreparedStatement st =
                    conexion.crearConexionConBaseDeDatos().prepareStatement(
                            "Insert into participantes (nombre, telefono, region) values (?,?,?)");

            st.setString(1, participante.getNombre());
            st.setString(2, participante.getTelefono());
            st.setString(3, participante.getRegion());
            st.executeUpdate();
            st.close();

        } catch (SQLException e){
            throw new RuntimeException("No se pudo registrar el participante.", e);
        }
    }
}
