package me.umbrella.gitrepos.domain

import me.umbrella.gitrepos.core.UseCase
import me.umbrella.gitrepos.data.model.Repo
import me.umbrella.gitrepos.data.repositories.RepoRepository
import kotlinx.coroutines.flow.Flow

class ListUserRepositoriesUseCase(private val repository: RepoRepository) : UseCase<String, List<Repo>>() {

    override suspend fun execute(param: String): Flow<List<Repo>> {
        return repository.listRepositories(param)
    }
}