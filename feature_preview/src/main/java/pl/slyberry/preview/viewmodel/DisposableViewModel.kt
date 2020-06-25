package pl.slyberry.preview.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class DisposableViewModel : ViewModel() {

  private val compositeDisposable = CompositeDisposable()

  protected fun addDisposable(disposable: Disposable) {
    compositeDisposable.add(disposable)
  }

  override fun onCleared() {
    super.onCleared()
    compositeDisposable.clear()
  }
}
