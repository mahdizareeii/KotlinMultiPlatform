package state

sealed class BaseUiState<out UI_STATE> {
    data object EmptyUiState : BaseUiState<Nothing>()
    data object InitialUiState : BaseUiState<Nothing>()
    data class LoadingUiState(val isPartial: Boolean = false, val isFooter: Boolean = false) :
        BaseUiState<Nothing>()

    data class ErrorUiState(
        val throwable: Throwable,
        val onTryAgainClicked: () -> Unit = {},
    ) : BaseUiState<Nothing>()

    data class SuccessUiState<UI_STATE>(val state: UI_STATE) : BaseUiState<UI_STATE>()
}