package com.michaelmccormick.myfirstkmmapp.android

import android.app.Application
import com.michaelmccormick.myfirstkmmapp.android.viewmodel.SearchViewModel
import com.michaelmccormick.myfirstkmmapp.repositories.GitHubRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                module {
                    single { GitHubRepository() }
                    viewModel { SearchViewModel(get()) }
                }
            )
        }
    }
}
