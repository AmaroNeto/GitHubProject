package com.amaro.feature.list.plugin

import android.content.Context
import com.amaro.libraries.networking.plugin.api.GitHubAPI
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.mockito.Mockito

class RepositoryTestRule : TestRule {

    val gitHubAPI: GitHubAPI = Mockito.mock(GitHubAPI::class.java)
    val context: Context = Mockito.mock(Context::class.java)

    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement() {
            override fun evaluate() {
                base?.evaluate()
            }
        }
    }
}