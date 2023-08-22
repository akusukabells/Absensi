package com.wendot.absensi.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.wendot.absensi.DashBoardActivity;
import com.wendot.absensi.LoginActivity;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int mode;

    private static final String pref_nip = "crudpref";
    private static final String is_login = "islogin";
    public static final String kunci_nip = "keynip";
    public static final String kunci_name = "keyname";
    public static final String kunci_role = "keyrole";

    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(pref_nip, mode);
        editor = pref.edit();
    }

    public void createSession(String NIP, String Name, String Role){
        editor.putBoolean(is_login, true);
        editor.putString(kunci_nip, NIP);
        editor.putString(kunci_name, Name);
        editor.putString(kunci_role, Role);
        editor.commit();
    }

    public boolean checkLogin(){
        if (!this.is_login()){
            Intent i = new Intent(context, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
            return true;
        }else {
            Intent i = new Intent(context, DashBoardActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
            return true;
        }
    }

    private boolean is_login() {
        return pref.getBoolean(is_login, false);
    }

    public void logout(){
        editor.clear();
        editor.commit();
        Intent i = new Intent(context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(pref_nip, pref.getString(pref_nip, null));
        user.put(kunci_nip, pref.getString(kunci_nip, null));
        user.put(kunci_name, pref.getString(kunci_name, null));
        user.put(kunci_role, pref.getString(kunci_role, null));
        return user;
    }
}
