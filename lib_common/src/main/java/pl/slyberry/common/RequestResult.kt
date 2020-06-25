package pl.slyberry.common

sealed class RequestResult<T> {

  companion object {
    fun <T> createLoading(): RequestResult<T> = LoadingResult<T>()
    fun <T> createSuccess(data: T): RequestResult<T> = SuccessResult(data)
    fun <T> createError(error: Throwable): RequestResult<T> = ErrorResult<T>(error)
  }
}

class LoadingResult<T>() : RequestResult<T>()
data class SuccessResult<T>(val data: T) : RequestResult<T>()
data class ErrorResult<T>(val error: Throwable) : RequestResult<T>()
