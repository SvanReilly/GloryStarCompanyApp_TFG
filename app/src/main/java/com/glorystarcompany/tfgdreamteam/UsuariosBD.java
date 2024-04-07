package com.glorystarcompany.tfgdreamteam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;
import java.util.ArrayList;

public class UsuariosBD extends SQLiteOpenHelper{

    private ArrayList<Usuario> listaUsuario;
    private static final String DATABASE_NAME = "BDUsuariosGloryStarCompany.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Usuarios";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NAME = "Nombre";
    private static final String COLUMN_MAIL = "Correo";
    private static final String COLUMN_PASSWORD = "Contraseña";
    private static final String COLUMN_GLORY_COIN_AMOUNT = "GloryCoins";
    private static final String COLUMN_GAMES_WON = "Victorias";
    private static final String COLUMN_GAMES_LOST = "Derrotas";


    private SQLiteDatabase databaseSQL;
    private static final String SQLCREATE = "CREATE TABLE "
            + TABLE_NAME
            + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAME + " NAME,"
            + COLUMN_PASSWORD + " PASSWORD,"
            + COLUMN_MAIL + " MAIL, "
            + COLUMN_GAMES_WON + " WINS,"
            + COLUMN_GAMES_LOST + " DEFEATS,"
            + COLUMN_GLORY_COIN_AMOUNT + " GC_AMOUNT);";
    private String SQLDROP = "DROP TABLE IF EXISTS " + TABLE_NAME;


    public UsuariosBD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        listaUsuario = new ArrayList<>();
    }

    @Override
    public void onCreate(SQLiteDatabase databaseSQL) {
        databaseSQL.execSQL(SQLCREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase databaseSQL, int previousVersion, int newestVersion) {
        databaseSQL.execSQL(SQLDROP);
        onCreate(databaseSQL);
    }


    public ArrayList<Usuario> getUsuarios() {
        databaseSQL = this.getReadableDatabase();
        String[] SQL_COLUMNS = {COLUMN_ID, COLUMN_NAME, COLUMN_PASSWORD, COLUMN_MAIL, COLUMN_GAMES_WON, COLUMN_GAMES_LOST, COLUMN_GLORY_COIN_AMOUNT};
        Cursor c = databaseSQL.query(TABLE_NAME, SQL_COLUMNS, null, null,
                null, null, null);

        ArrayList<Usuario> listaUsuario = new ArrayList<>();

        if (c != null) {
            try {
                int nameIndex = c.getColumnIndex(COLUMN_NAME);
                int mailIndex = c.getColumnIndex(COLUMN_MAIL);
                int passIndex = c.getColumnIndex(COLUMN_PASSWORD);
                int winsIndex = c.getColumnIndex(COLUMN_GAMES_WON);
                int defeatIndex = c.getColumnIndex(COLUMN_GAMES_LOST);
                int gloryCoinAmountIndex = c.getColumnIndex(COLUMN_GLORY_COIN_AMOUNT);

                while (c.moveToNext()) {
                    String name = (nameIndex != -1) ? c.getString(nameIndex) :
                            "Nombre de usuario no identificado";
                    String mail = (mailIndex != -1) ? c.getString(mailIndex) :
                            "Correo no disponible";
                    String password = (passIndex != -1) ? c.getString(passIndex) :
                            "Contraseña inexistente";
                    int wins = (winsIndex != -1) ? c.getInt(winsIndex) :
                            0;
                    int defeats = (defeatIndex != -1) ? c.getInt(defeatIndex) :
                            0;
                    int gloryCoinAmount = (gloryCoinAmountIndex != -1) ? c.getInt(gloryCoinAmountIndex) :
                            0;

                    Usuario usuario = new Usuario(name, mail, password, wins, defeats, gloryCoinAmount);
                    listaUsuario.add(usuario);
                }
            } finally {
                c.close();
            }
        }
        closeBD();
        return listaUsuario;
    }

    //Se usa en el SecondActivity
    public void insertUsuario(Usuario usuario) {

        databaseSQL = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, usuario.getName());
        contentValues.put(COLUMN_PASSWORD, usuario.getPassword());
        contentValues.put(COLUMN_MAIL, usuario.getMail());
        contentValues.put(COLUMN_GAMES_WON, 0);
        contentValues.put(COLUMN_GAMES_LOST, 0);
        contentValues.put(COLUMN_GLORY_COIN_AMOUNT, 1);
        databaseSQL.insert(TABLE_NAME, null, contentValues);
        closeBD();

    }

    //Pendiente de Revisión//
    public void updateWinsUsuario(Usuario usuario) {

        listaUsuario = getUsuarios();
        for (int i = 0; i < listaUsuario.size(); i++) {

            if (listaUsuario.get(i).getName().contains(usuario.getName())) {

//                usuario = listaUsuario.get(i);

                // Incrementar las victorias y las monedas de gloria para el usuario ganador
                ContentValues contentValues = new ContentValues();
                contentValues.put(COLUMN_GAMES_WON, usuario.getWins() + 1); // Incrementa las victorias
                contentValues.put(COLUMN_GLORY_COIN_AMOUNT, usuario.getGcAmount() + 1); // Incrementa las monedas de gloria

                // Actualizar el registro del usuario ganador
                databaseSQL.update(TABLE_NAME, contentValues, COLUMN_NAME + "=?", new String[]{usuario.getName()});
            }
        }
        closeBD();
    }

    //Pendiente//
    public void updateDefeatsUsuario(Usuario usuario) {

        listaUsuario = getUsuarios();
        for (int i = 0; i < listaUsuario.size(); i++) {

        if (listaUsuario.get(i).getName().contains(usuario.getName())) {

//            usuario = listaUsuario.get(i);

            // Incrementar las derrotas
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_GAMES_WON, usuario.getDefeats() + 1); // Incrementa las victorias

            // Actualizar el registro del usuario perdedor
            databaseSQL.update(TABLE_NAME, contentValues, COLUMN_NAME + "=?", new String[]{usuario.getName()});
        }
        }
        closeBD();
    }


    //Implementar en un futuro, no es necesario para el TFG//
    public void removeOnlyOneUsuario(Usuario usuario) {

        databaseSQL = this.getWritableDatabase();
        databaseSQL = this.getWritableDatabase();
        String selection = COLUMN_MAIL + "=?";
        String[] selectionArgs = {usuario.getMail()};
        databaseSQL.delete(TABLE_NAME, selection, selectionArgs);
        closeBD();

    }

    public void dropWholeDB() {
        databaseSQL = this.getWritableDatabase();
        databaseSQL.delete(TABLE_NAME, null, null);
        closeBD();
    }

    public void closeBD() {
        if (databaseSQL != null) {
            databaseSQL.close();
        }
    }
}
