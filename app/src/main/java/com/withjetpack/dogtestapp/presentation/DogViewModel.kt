package com.withjetpack.dogtestapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.withjetpack.dogtestapp.domain.Dog
import com.withjetpack.dogtestapp.domain.repository.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogViewModel @Inject constructor(private val dogRepository: DogRepository) : ViewModel() {

    private val _dogsState = MutableStateFlow<List<Dog>>(emptyList())
    val dogsState: StateFlow<List<Dog>> get() = _dogsState

    fun getDogs() {
        viewModelScope.launch {
            _dogsState.value = dogRepository.getDogs()
        }
    }
}
