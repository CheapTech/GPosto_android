package br.com.senacrs.gposto.GUI;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.bumptech.glide.request.RequestOptions;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.senacrs.gposto.Controller.UsuarioController;
import br.com.senacrs.gposto.GUI.Callback.UsuarioCallback;
import br.com.senacrs.gposto.LibClass.Usuario;
import br.com.senacrs.gposto.R;
import br.com.senacrs.gposto.Util.Toast;

import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements UsuarioCallback {

    private LoginButton loginButton;
    private Button btnLogin;
    private EditText txtLogin;
    private EditText txtSenha;
    private CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestWindowFeature(Window.FEATURE_NO_TITLE);


        //facebook login button
        loginButton = findViewById(R.id.login_button);
        //loginButton.setReadPermissions(Arrays.asList("email, public_profile"));

        //----------------------
        //login gposto
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!areEmptyFields()){
                    userLogin();
                }
            }
        });
        txtLogin = findViewById(R.id.txtLogin);
        txtSenha = findViewById(R.id.txtSenha);

        //----------------------
        //facebook callbackmanager
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                startActivity(new Intent(MainActivity.this, Destaques_Activity.class));
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
        //------------------------

    }

    //Facebook login
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    AccessTokenTracker tokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
            if (currentAccessToken == null) {

            } else {
                loaduserProfile(currentAccessToken);
                if(currentAccessToken !=null){
                    startActivity( new Intent(MainActivity.this, Destaques_Activity.class));
                }
            }
        }
    };

    //access token facebook
    private void loaduserProfile(AccessToken newAccessToken) {

        GraphRequest request = GraphRequest.newMeRequest(newAccessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    String first_name = object.getString("first_name");
                    String last_name = object.getString("last_name");
                    String email = object.getString("email");
                    String id = object.getString("id");

                    String image_url = "https://graph.facebook.com/" + id + "/picture?type=normal";

                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.dontAnimate();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "first_name,last_name,email,id");
        request.setParameters(parameters);
        request.executeAsync();
    }
    //-------------------------

    //Cadastro
    public void callCadastro(View v) {
        startActivity(new Intent(MainActivity.this, Cadastro_Activity.class));
    }

    //validador de campos vazios
    private boolean areEmptyFields() {
        boolean isEmpty = true;

        if (txtLogin.getText().toString().trim().isEmpty()) {
            txtLogin.setError("Required!");
        } else {
            if (txtSenha.getText().toString().trim().isEmpty()) {
                txtSenha.setError("Required!");
            } else {
                isEmpty = false;
            }
        }
        return isEmpty;
    }

    private void userLogin(){
        UsuarioController controller = new UsuarioController();
        try {

            controller.getUsuarioWeb(txtLogin.getText().toString(), txtSenha.getText().toString(), MainActivity.this);

        } catch (Exception e) {
            android.widget.Toast.makeText(MainActivity.this, e.getMessage(), android.widget.Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUsuarioSuccess(Usuario usuario) {
        //information.setText(usuario.getUser());
        Toast.longToast(MainActivity.this, usuario.getUser());
    }

    @Override
    public void onUsuarioFailure(String message) {
        Toast.longToast(this, message);
    }

}



