package me.umbrella.gitrepos.domain.di

import me.umbrella.gitrepos.domain.ListUserRepositoriesUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {

    fun load() {
        loadKoinModules(useCaseModule())
    }

    // Toda vez que o sistema precisar de usecase ele reinstancia uma nova usecase com o factory
    private fun useCaseModule(): Module {
        return module {
            factory { ListUserRepositoriesUseCase(get()) }
        }
    }

}