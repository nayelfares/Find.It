package com.emarketing.findit.vm

import android.content.Context
import com.emarketing.findit.api.MainAPIManager
import com.emarketing.findit.data.Filters
import com.emarketing.findit.data.RegisterResponse
import com.emarketing.findit.data.RequestInterface
import com.emarketing.findit.data.SearchResult
import com.emarketing.findit.ui.SearchView
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SearchViewModel(val searchView: SearchView, val context: Context) {
    fun getFilters(){
        val apiManager= MainAPIManager().provideRetrofitInterface().create(RequestInterface::class.java)
        val filtersVar  = apiManager.getFilters()
        filtersVar.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Filters> {
                override fun onComplete() { }
                override fun onSubscribe(d: Disposable) { }
                override fun onNext(t: Filters) {
                        searchView.getFiltersOnSuccess(t)
                }
                override fun onError(e: Throwable) {
                    searchView.getFiltersOnFailer(e.message.toString())
                }
            })
    }

    fun search(cityId:Long,categoryId:Long,tagId:Long){
        val apiManager= MainAPIManager().provideRetrofitInterface().create(RequestInterface::class.java)
        val filtersVar  = apiManager.search(tagId,categoryId,cityId)
        filtersVar.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<SearchResult> {
                override fun onComplete() { }
                override fun onSubscribe(d: Disposable) { }
                override fun onNext(t: SearchResult) {
                    searchView.searchOnSuccess(t.data)
                }
                override fun onError(e: Throwable) {
                    searchView.searchOnFailer(e.message.toString())
                }
            })
    }
}