package viewmodel

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.flow.asStateFlow
import state.BaseUiState

open class BaseViewModel<UiState> : KMMViewModel() {
    protected val _uiState = MutableStateFlow<BaseUiState<UiState>>(
        viewModelScope,
        BaseUiState.InitialUiState<UiState>()
    )

    @NativeCoroutinesState
    val uiState = _uiState.asStateFlow()

}