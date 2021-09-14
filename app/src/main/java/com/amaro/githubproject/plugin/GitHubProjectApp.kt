package com.amaro.githubproject.plugin

import android.app.Application
import com.amaro.feature.list.plugin.di.domainModule
import com.amaro.feature.list.plugin.di.gatewayModule
import com.amaro.feature.list.plugin.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class GitHubProjectApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@GitHubProjectApp)
            androidFileProperties()
            modules(listOf(
                repositoryModule,
                domainModule,
                gatewayModule
            ))
        }
    }
}