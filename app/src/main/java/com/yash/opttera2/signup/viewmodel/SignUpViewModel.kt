package com.yash.opttera2.signup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yash.opttera2.signup.data.remote.PhoneNumberBody
import com.yash.opttera2.signup.data.remote.SignUpBody
import com.yash.opttera2.signup.data.remote.SignUpEmail
import com.yash.opttera2.signup.data.remote.brandresponse.Result
import com.yash.opttera2.signup.repository.SignUpRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val repository: SignUpRepository) : ViewModel() {

    private val _spinnerItem = MutableStateFlow<List<Result>>(emptyList())
    val spinnerItem: StateFlow<List<Result>> get() = _spinnerItem

    private val _spinnerBrand =
        MutableStateFlow<List<com.yash.opttera2.signup.data.remote.modelbrandresponse.Result>>(
            emptyList()
        )
    val spinnerBrand: StateFlow<List<com.yash.opttera2.signup.data.remote.modelbrandresponse.Result>> get() = _spinnerBrand

//    private val _searchQuery = MutableStateFlow("")
//    val searchQuery: StateFlow<String> = _searchQuery

    private val _responseSharedFlow = MutableSharedFlow<SignUpEvent>()
    val responseSharedFlow: SharedFlow<SignUpEvent> get() = _responseSharedFlow

    private val _responseSharedFlow1 = MutableSharedFlow<SignUpEmailEvent>()
    val responseSharedFlow1: SharedFlow<SignUpEmailEvent> get() = _responseSharedFlow1

    private val _responseSharedFlow2 = MutableSharedFlow<SignUpPhoneEvent>()
    val responseSharedFlow2: SharedFlow<SignUpPhoneEvent> get() = _responseSharedFlow2

    // StateFlow to track the loading state
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    // Pagination variables
    private var currentPage = 1
    private var pageSize = 10
    private var isLastPage = false

//     Fetch initial data when ViewModel is created
//    init {
//        fetchVehicleBrands("", currentPage, pageSize)
//
//    }


    fun signUP(body: SignUpBody) {
        viewModelScope.launch {
            repository.signUpApiServiceRepo(body)
                .onSuccess {
                    _responseSharedFlow.emit(SignUpEvent.Success(it.message))
                }
                .onFailure {
                    _responseSharedFlow.emit(SignUpEvent.ShowToast("Error"))
                }
        }
    }

    fun emailExist(body: SignUpEmail) {
        viewModelScope.launch {
            repository.signUpEmailExist(body)
                .onFailure {
                    _responseSharedFlow1.emit(SignUpEmailEvent.Failure("This email exist"))
                }
        }
    }

    fun phoneExist(body: PhoneNumberBody) {
        viewModelScope.launch {
            repository.signUpPhoneExist(body)
                .onFailure {
                    _responseSharedFlow2.emit(SignUpPhoneEvent.Failure("Phone Number already exists."))
                }
        }
    }

    fun fetchVehicleBrands(search: String, page: Int, pageSize: Int) {
        if (_loading.value || (isLastPage && page > currentPage)) return

        viewModelScope.launch {
            _loading.value = true
            repository.vehicleBrand(search, page, pageSize)
                .onSuccess { data ->
                    if (data != null) {
                        _spinnerItem.value = data.data.results
                        currentPage = page
                        isLastPage = false
                    }
                }
                .onFailure {
                    //       _responseSharedFlow.emit(SignUpEvent.ShowToast("Failed to load data"))
                }
                .also {
                    _loading.value = false
                }
        }
    }

    fun searchQuery(query: String) {
        viewModelScope.launch {
            fetchVehicleBrands(query, 1, 10)
        }
    }

    fun fetchVehicleModel(search: String, page: Int, pageSize: Int, brandName: String) {
        if (_loading.value || (isLastPage && page > currentPage)) return

        viewModelScope.launch {
            repository.modelBrand(brandName, search, page, pageSize)
                .onSuccess { data ->
                    if (data != null) {
                        _spinnerBrand.value = data.data.results
                        currentPage = page
                        isLastPage = false
                    }
                }
                .onFailure {
                    //       _responseSharedFlow.emit(SignUpEvent.ShowToast("Failed to load data"))
                }
                .also {
                    _loading.value = false
                }
        }
    }



    sealed class SignUpEvent {
        data class ShowToast(val message: String) : SignUpEvent()
        data class Success(val message: String) : SignUpEvent()
    }

    sealed class SignUpEmailEvent {
        data class Failure(val message: String) : SignUpEmailEvent()
        data class Success(val message: String) : SignUpEmailEvent()
    }


    sealed class SignUpPhoneEvent {
        data class Failure(val message: String) : SignUpPhoneEvent()
        data class Success(val message: String) : SignUpPhoneEvent()
    }

    sealed class VehicleBrandEvent {
        data class ShowToast(val message: String) : VehicleBrandEvent()
        data class Success(val message: String) : VehicleBrandEvent()
    }


}


