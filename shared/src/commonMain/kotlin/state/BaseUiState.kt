package state

sealed class BaseUiState<out UI_STATE> {
    class EmptyUiState<UI_STATE> : BaseUiState<Nothing>()
    class InitialUiState<UI_STATE> : BaseUiState<Nothing>()
    data class LoadingUiState<UI_STATE>(
        val isPartial: Boolean = false,
        val isFooter: Boolean = false
    ) : BaseUiState<Nothing>()

    data class ErrorUiState<UI_STATE>(
        val throwable: Throwable,
        val onTryAgainClicked: () -> Unit = {},
    ) : BaseUiState<Nothing>()

    data class SuccessUiState<UI_STATE>(val state: UI_STATE) : BaseUiState<UI_STATE>()
}