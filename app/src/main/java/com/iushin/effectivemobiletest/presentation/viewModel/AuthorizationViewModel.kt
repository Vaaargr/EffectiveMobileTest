package com.iushin.effectivemobiletest.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iushin.domain.api.interactors.AuthorizationInteractor
import com.iushin.domain.entity.SignInState
import com.iushin.domain.entity.SignUpState
import com.iushin.effectivemobiletest.presentation.state.AuthorizationUIState

class AuthorizationViewModel(private val authInteracor: AuthorizationInteractor) : ViewModel() {

    private val authUIStateLD =
        MutableLiveData<AuthorizationUIState>(AuthorizationUIState.ENTRANCE)

    private val signUpState = MutableLiveData<SignUpState>()

    private val signInState = MutableLiveData<SignInState>()

    fun observeAuthorizationUIState(): LiveData<AuthorizationUIState> = authUIStateLD

    fun observeSignUpState(): LiveData<SignUpState> = signUpState

    fun observeSignInState(): LiveData<SignInState> = signInState

    private fun setAuthorizationUIState(state: AuthorizationUIState) {
        authUIStateLD.value = state
    }

    private fun setSignUpState(state: SignUpState) {
        signUpState.value = state
    }

    private fun setSignInState(state: SignInState) {
        signInState.value = state
    }

    fun changeUIState() {
        when (authUIStateLD.value) {
            AuthorizationUIState.ENTRANCE -> setAuthorizationUIState(AuthorizationUIState.REGISTRATION)
            AuthorizationUIState.REGISTRATION -> setAuthorizationUIState(AuthorizationUIState.ENTRANCE)
            null -> setAuthorizationUIState(AuthorizationUIState.ENTRANCE)
        }
    }

    fun signUpButtonPressed(email: String, password: String) {
        authInteracor.createUser(email = email, password = password) { state ->
            setSignUpState(state)
        }
    }

    fun signInButtonPressed(email: String, password: String) {
        authInteracor.logIn(email = email, password = password) { state ->
            setSignInState(state)
        }
    }

    fun getUserEmail(): String?{
        return authInteracor.getCurrentUserMail()
    }
}