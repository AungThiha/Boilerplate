package thiha.aung.boilerplate.core.domain.entities

sealed class ErrorResponse(message: String?) : Throwable(message) {
    object NoInternetConnection : ErrorResponse("No internet connection")
}