package com.minwook.mypracticeapp.viewModel

import android.service.autofill.RegexValidator
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.minwook.mypracticeapp.api.Api
import com.minwook.mypracticeapp.base.BaseKotlinViewModel
import com.minwook.mypracticeapp.model.DataModel
import com.minwook.mypracticeapp.model.DataModelImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.regex.Pattern

class MainViewModel() : BaseKotlinViewModel() {

    private val model: DataModel = DataModelImpl()
    // view model 에서 사용 할 변수들 (mutable)
    private val _shortenUrl = MutableLiveData<String>()
    private val _error = MutableLiveData<String>()
    private val _clickButton = SingleLiveEvent<String>()
    // view model 밖에서 사용할 변수들 (immutable)
    val shortenUrl: LiveData<String> get() = _shortenUrl
    val error: LiveData<String> get() = _error
    val clickButton: LiveData<String> get() = _clickButton

    val showResult = MutableLiveData<Boolean>()

    fun getShortenUrl(url: String) {
        addDisposable(model.getData(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                showResult.value = true
                _shortenUrl.value = it.url
            }, {
                _error.value = it.message
            }
            )

        )
    }

    fun clickButton() {
        _clickButton.call()
    }
}