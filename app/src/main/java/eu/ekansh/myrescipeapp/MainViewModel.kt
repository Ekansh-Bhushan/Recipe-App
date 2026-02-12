package eu.ekansh.myrescipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _categoriesState = mutableStateOf(RescipeState())

    val categoriesState : State<RescipeState> = _categoriesState

    init {
        fetchCategory()
    }

    private fun fetchCategory() {
        viewModelScope.launch {
            try {
                val response = rescipeService.getCategory()
                _categoriesState.value = _categoriesState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            }catch (e : Exception){
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error = "Error fetching Categories : ${e.message}"
                )
            }
        }
    }

    data class RescipeState(
        val loading : Boolean = true,
        val list : List<Category> = emptyList(),
        val error : String? = null
    )
}