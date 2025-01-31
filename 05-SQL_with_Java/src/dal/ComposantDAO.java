package dal;

import bo.Composant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComposantDAO {

    public List<Composant> select() {

        List<Composant> composants = new ArrayList<>();

        try {

            Connection cnx = DriverManager.getConnection("jdbc:sqlserver://localhost;databasename=[DB];username=[USERNAME];password=[PASSWORD];trustservercertificate=true");

            if(! cnx.isClosed()){

                PreparedStatement ps = cnx.prepareStatement("SELECT * FROM composants");
                ResultSet rs = ps.executeQuery(); //pour executer un select

                while(rs.next()){
                    composants.add(convertResultSetToComposant(rs));
                }

            }

            cnx.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return composants;

    }

    public void insert(Composant composant) {
        try {

            Connection cnx = DriverManager.getConnection("jdbc:sqlserver://localhost;databasename=[DB];username=[USERNAME];password=[PASSWORD];trustservercertificate=true");

            if(! cnx.isClosed()){

                PreparedStatement ps = cnx.prepareStatement(
                        "INSERT INTO composants (nom, description)" +
                                "VALUES (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, composant.getNom());
                ps.setString(2, composant.getType());
                ps.setDate(3, Date.valueOf(composant.getDateSortie()));

                ps.executeUpdate(); //pour executer un insert, un update, ou un delete
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    composant.setId(rs.getInt(1));
                }

            }

            cnx.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Composant composant){

        try {

            Connection cnx = DriverManager.getConnection("jdbc:sqlserver://localhost;databasename=[DB];username=[USERNAME];password=[PASSWORD];trustservercertificate=true");

            if(! cnx.isClosed()){

                PreparedStatement ps = cnx.prepareStatement("UPDATE composants SET nom = ?, type = ?, date_sortie = ? WHERE id = ?");
                ps.setString(1, composant.getNom());
                ps.setString(2, composant.getType());
                ps.setDate(3, Date.valueOf(composant.getDateSortie()));
                ps.setInt(4, composant.getId());

                ps.executeUpdate(); //pour executer un insert, un update, ou un delete

            }

            cnx.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id){
        try {
            Connection cnx = DriverManager.getConnection("jdbc:sqlserver://localhost;databasename=[DB];username=[USERNAME];password=[PASSWORD];trustservercertificate=true");

            if (!cnx.isClosed()) {
                PreparedStatement ps = cnx.prepareStatement("DELETE FROM composants WHERE id=?");
                ps.setInt(1, id);
                ps.executeUpdate();
            }

            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean composantPresent(){
        List<Composant> composants = this.select();
        return !composants.isEmpty();
    }


    public Composant convertResultSetToComposant(ResultSet rs) throws SQLException{
        Composant composant = new Composant();

        composant.setId(rs.getInt("id"));
        composant.setNom(rs.getString("nom"));
        composant.setType(rs.getString("type"));
        if(rs.getDate("date_sortie") != null){
            composant.setDateSortie(rs.getDate("date_sortie").toLocalDate());
        }

        return composant;

    }


}
