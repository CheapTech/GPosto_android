package br.com.senacrs.gposto.GUI.Callback;

import java.util.List;

import br.com.senacrs.gposto.LibClass.Usuario;

public interface UsuarioCallback {
    void onUsuarioSuccess(Usuario usuario);
    void onUsuarioFailure(String message);
}
