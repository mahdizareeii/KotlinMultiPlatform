package viewmodel

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesRefined
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import state.BaseUiState

open class BaseViewModel<UiState, Events> : KMMViewModel() {

    protected val _events = MutableSharedFlow<Events>()
    val events = _events.asSharedFlow()

    protected val _uiState = MutableStateFlow<BaseUiState<UiState>>(
        viewModelScope,
        BaseUiState.InitialUiState<UiState>()
    )

    @NativeCoroutinesState
    val uiState = _uiState.asStateFlow()

}