package viewmodel

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import state.BaseUiState
import util.WrappedSharedFlow
import util.WrappedStateFlow

open class BaseViewModel<UiState, Events> : KMMViewModel() {

    protected val _events = MutableSharedFlow<Events>()
    val events = _events.asSharedFlow()

    protected val _uiState = MutableStateFlow<BaseUiState<UiState>>(
        viewModelScope,
        BaseUiState.InitialUiState<UiState>()
    )

    //use this annotation to use in ios
    @NativeCoroutinesState
    val uiState = _uiState.asStateFlow()

    //https://github.com/adeo-opensource/kviewmodel--mpp/blob/22b994b532da76024ff9c20d0771a32a7c810afc/kviewmodel/src/commonMain/kotlin/com/adeo/kviewmodel/BaseSharedViewModel.kt
    //to use in ios
    //don't forget to use ObservingView
    public fun uiStates(): WrappedStateFlow<BaseUiState<UiState>> = WrappedStateFlow(_uiState.asStateFlow())

    //to use is ios
    public fun events(): WrappedSharedFlow<Events?> = WrappedSharedFlow(_events.asSharedFlow())

}