package me.umbrella.gitrepos.data.repositories

import me.umbrella.gitrepos.data.model.Repo
import kotlinx.coroutines.flow.Flow

interface RepoRepository {
    suspend fun listRepositories(user: String): Flow<List<Repo>>
}