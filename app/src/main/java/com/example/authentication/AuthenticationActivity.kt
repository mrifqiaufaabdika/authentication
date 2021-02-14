package com.example.authentication

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI

class AuthenticationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_authentication)
    }

    private fun createSignInIntent() {
        /*
        choose authentication providers
         */
        val provider = arrayListOf(
            AuthUI.IdpConfig.GoogleBuilder().build(),
            AuthUI.IdpConfig.FacebookBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder().build()
        )

        /*
        create and launch sign-in intent
         */
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(provider)
                .build(),
            RC_SIGN_IN)
    }

    companion object{

        private const val RC_SIGN_IN = 123
    }
}