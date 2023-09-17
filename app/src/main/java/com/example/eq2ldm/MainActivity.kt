package com.example.eq2ldm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var chat: ImageButton
    private lateinit var usuario:ImageButton
    private lateinit var roles: ImageButton
    private lateinit var idioma: ImageButton
    private lateinit var logout: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApp).setAppLanguage("es")

        chat = findViewById(R.id.chat_but)
        usuario = findViewById(R.id.usuario_but)
        roles = findViewById(R.id.admin_but)
        idioma = findViewById(R.id.idioma_but)
        logout = findViewById(R.id.logout_but)



        logout.setOnClickListener {
            showLogoutConfirmationDialog()
        }
        chat.setOnClickListener {
            showComingSoonDialog()
        }
        usuario.setOnClickListener {
            showComingSoonDialog()
        }
        roles.setOnClickListener {
            showComingSoonDialog()
        }
        idioma.setOnClickListener {
            gotoLang()
        }

    }

    fun gotoLang() {
        val intent = Intent(this, LanguageActivity::class.java)
        startActivity(intent)
    }

    private fun showComingSoonDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.error))
            .setMessage(getString(R.string.proximamente))
            .setPositiveButton(getString(R.string.ok)) { _, _ ->
            }
            .show()
    }
    private fun showLogoutConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.error))
        builder.setMessage(getString(R.string.segur))

        builder.setPositiveButton(getString(R.string.si)) { _, _ ->

            Firebase.auth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        builder.setNegativeButton(getString(R.string.no)) { _, _ ->

        }

        val dialog = builder.create()
        dialog.show()
    }
}
