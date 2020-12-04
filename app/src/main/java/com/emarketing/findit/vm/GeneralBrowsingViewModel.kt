package com.emarketing.findit.vm

import android.content.Context
import com.emarketing.findit.api.MainAPIManager
import com.emarketing.findit.data.CategoryResult
import com.emarketing.findit.data.RegisterResponse
import com.emarketing.findit.data.RequestInterface
import com.emarketing.findit.ui.GeneralBrowsingView
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class GeneralBrowsingViewModel(val generalBrowsingView: GeneralBrowsingView,val context: Context) {
    fun getCategories(){
        val apiManager= MainAPIManager().provideRetrofitInterface().create(RequestInterface::class.java)
        val registerVar  = apiManager.getCategories()
        registerVar.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<CategoryResult> {
                override fun onComplete() { }
                override fun onSubscribe(d: Disposable) { }
                override fun onNext(t: CategoryResult) {
                        generalBrowsingView.onSuccess(t.data)
                }
                override fun onError(e: Throwable) {
                    generalBrowsingView.onFailer(e.message.toString())
                }
            })
    }
}